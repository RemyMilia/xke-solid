package fr.xebia.xke.solid.srp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.googlecode.catchexception.apis.BDDCatchException.*;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static fr.xebia.xke.solid.srp.TelemetryClient.DIAGNOSTIC_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest {

    private final TelemetryClient telemetryClientMock = mock(TelemetryClient.class);
    private TelemetryDiagnosticControls controls;

    @Before
    public void setUp() {
        controls = new TelemetryDiagnosticControls(telemetryClientMock);
    }

    @Test
    public void should_throw_an_exception_when_unable_to_connect() throws Exception {

        // Arrange
        Mockito.when(telemetryClientMock.getOnlineStatus()).thenReturn(false);

        // Act
        when(controls::checkTransmission);

        // Assert
        then(caughtException())
                .isInstanceOf(Exception.class)
                .hasMessage("Unable to connect.");

        verify(telemetryClientMock, times(5)).getOnlineStatus();
        verify(telemetryClientMock).disconnect();
    }

    @Test
    public void should_receive_diagnostic_response_when_sending_diagnostic_request() throws Exception {

        // Arrange
        final String aResponse = "aResponse";

        Mockito.when(telemetryClientMock.getOnlineStatus()).thenReturn(false, true, true);
        Mockito.when(telemetryClientMock.receive()).thenReturn(aResponse);

        // Act
        controls.checkTransmission();

        // Assert
        verify(telemetryClientMock, times(3)).getOnlineStatus();
        verify(telemetryClientMock).send(DIAGNOSTIC_MESSAGE);
        verify(telemetryClientMock).disconnect();

        assertThat(controls.getDiagnosticInfo()).isEqualTo(aResponse);
    }

}