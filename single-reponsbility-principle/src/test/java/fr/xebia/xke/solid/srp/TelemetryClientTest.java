package fr.xebia.xke.solid.srp;

import org.junit.Test;
import org.mockito.Mockito;

import static com.googlecode.catchexception.apis.BDDCatchException.*;
import static fr.xebia.xke.solid.srp.DataChannel.DIAGNOSTIC_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TelemetryClientTest {

    private final Connection connection = mock(Connection.class);
    private final DataChannel dataChannel = new DataChannel();
    private final TelemetryClient telemetryClient = new TelemetryClient(connection, dataChannel);

    @Test
    public void should_throw_exception_when_unable_to_connect() {

        // Arrange
        Mockito.when(connection.isOnline()).thenReturn(false, false, false);

        // Act
        when(() -> telemetryClient.connect(3));

        // Assert
        verify(connection, times(3)).connect();
        then(caughtException())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unable to connect.");
    }

    @Test
    public void should_receive_random_response_when_sending_an_unexpected_request() {

        // Arrange
        telemetryClient.send("whatUWant");

        // Act
        final String response = telemetryClient.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .doesNotContain("LAST");
    }

    private void should_throw_an_illegal_argument_exception_when_sending_an_invalid_message(String invalidMessage) {

        // Act
        when(() -> telemetryClient.send(invalidMessage));

        // Assert
        then(caughtException()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_throw_an_illegal_argument_exception_when_sending_no_message() {
        should_throw_an_illegal_argument_exception_when_sending_an_invalid_message(null);
    }

    @Test
    public void should_throw_an_illegal_argument_exception_when_sending_an_empty_message() {
        should_throw_an_illegal_argument_exception_when_sending_an_invalid_message("");
    }

    @Test
    public void should_receive_diagnostic_response_when_sending_diagnostic_request() {

        // Arrange
        telemetryClient.send(DIAGNOSTIC_MESSAGE);

        // Act
        final String response = telemetryClient.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .startsWith("LAST");
    }

    @Test
    public void should_receive_random_response_when_no_request_has_been_sent() {

        // Act
        final String response = telemetryClient.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .doesNotContain("LAST");
    }

    @Test
    public void should_receive_random_response_when_receiving_a_same_response_twice() {

        // Arrange
        telemetryClient.send(DIAGNOSTIC_MESSAGE);
        telemetryClient.receive();

        // Act
        final String response = telemetryClient.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .doesNotContain("LAST");
    }

}