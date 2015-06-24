package fr.xebia.xke.solid.srp;

import org.junit.Test;

import static com.googlecode.catchexception.apis.BDDCatchException.*;
import static fr.xebia.xke.solid.srp.DataChannel.DIAGNOSTIC_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class DataChannelTest {

    private final DataChannel dataChannel = new DataChannel();

    @Test
    public void should_receive_random_response_when_sending_an_unexpected_request() {

        // Arrange
        dataChannel.send("whatUWant");

        // Act
        final String response = dataChannel.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .doesNotContain("LAST");
    }

    private void should_throw_an_illegal_argument_exception_when_sending_an_invalid_message(String invalidMessage) {

        // Act
        when(() -> dataChannel.send(invalidMessage));

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
        dataChannel.send(DIAGNOSTIC_MESSAGE);

        // Act
        final String response = dataChannel.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .startsWith("LAST");
    }

    @Test
    public void should_receive_random_response_when_no_request_has_been_sent() {

        // Act
        final String response = dataChannel.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .doesNotContain("LAST");
    }

    @Test
    public void should_receive_random_response_when_receiving_a_same_response_twice() {

        // Arrange
        dataChannel.send(DIAGNOSTIC_MESSAGE);
        dataChannel.receive();

        // Act
        final String response = dataChannel.receive();

        // Assert
        assertThat(response)
                .isNotNull()
                .doesNotContain("LAST");
    }
}