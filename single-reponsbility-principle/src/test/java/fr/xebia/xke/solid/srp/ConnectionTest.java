package fr.xebia.xke.solid.srp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionTest {

    @Test
    public void should_be_offline_when_no_connection_attempted() {

        // Arrange
        final Connection connection = new Connection("whatUWant");

        // Act
        final boolean isOnline = connection.isOnline();

        // Assert
        assertThat(isOnline).isFalse();
    }

    @Test
    public void should_be_online_when_connection_succeeded() {

        // Arrange
        final Connection connection = new Connection("whatUWant");

        // Act
        connection.connect();

        // Assert
        assertThat(connection.isOnline()).isTrue();
    }

    @Test
    public void should_be_offline_when_disconnection_succeeded() {

        // Arrange
        final Connection connection = new Connection("whatUWant");
        connection.connect();

        // Act
        connection.disconnect();

        // Assert
        assertThat(connection.isOnline()).isFalse();
    }
}