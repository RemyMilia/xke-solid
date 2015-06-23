package fr.xebia.xke.solid.srp;

import org.junit.Test;

import static com.googlecode.catchexception.apis.BDDCatchException.*;
import static fr.xebia.xke.solid.srp.TelemetryClient.DIAGNOSTIC_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class TelemetryClientTest {

    private final TelemetryClient telemetryClient = new TelemetryClient();

    @Test
    public void should_throw_an_illegal_argument_exception_when_connecting_with_no_string() {
        should_throw_an_illegal_argument_exception_when_connecting_with_an_invalid_string(null);
    }

    @Test
    public void should_throw_an_illegal_argument_exception_when_connecting_with_empty_string() {
        should_throw_an_illegal_argument_exception_when_connecting_with_an_invalid_string("");
    }

    @Test
    public void should_be_online_when_connection_is_established() {

        // Act
        telemetryClient.connect("aConnectionString");

        // Assert
        assertThat(telemetryClient.getOnlineStatus()).isTrue();
    }

    @Test
    public void should_be_offline_when_no_connection_has_been_performed() {
        assertThat(telemetryClient.getOnlineStatus()).isFalse();
    }

    @Test
    public void should_be_offline_when_connection_is_terminated() {

        // Arrange
        telemetryClient.connect("aConnectionString");

        // Act
        telemetryClient.disconnect();

        // Assert
        assertThat(telemetryClient.getOnlineStatus()).isFalse();
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

    private void should_throw_an_illegal_argument_exception_when_connecting_with_an_invalid_string(String invalidConnectionString) {

        // Act
        when(() -> telemetryClient.connect(invalidConnectionString));

        // Assert
        then(caughtException()).isInstanceOf(IllegalArgumentException.class);
    }

}