package fr.xebia.xke.solid.srp;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Exercise by Emily Bache (see <a href="https://github.com/emilybache/Racing-Car-Katas">this GitHub repository</a>).
 */
public class TelemetryClient {

    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private final Connection connection;
    private final DataChannel dataChannel;

    public TelemetryClient(Connection connection, DataChannel dataChannel) {
        this.connection = checkNotNull(connection);
        this.dataChannel = checkNotNull(dataChannel);
    }

    public void connect(int retry) {
        while (!connection.isOnline() && retry > 0) {
            connection.connect();
            retry --;
        }

        if (!connection.isOnline()) {
            throw new IllegalArgumentException("Unable to connect.");
        }
    }

    public void disconnect() {
        connection.disconnect();
    }

    public void send(String message) {
        dataChannel.send(message);
    }

    public String receive() {
        return dataChannel.receive();
    }

}
