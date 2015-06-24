package fr.xebia.xke.solid.srp;

/**
 * Exercise by Emily Bache (see <a href="https://github.com/emilybache/Racing-Car-Katas">this GitHub repository</a>).
 */
public class TelemetryDiagnosticControls {

    private final TelemetryClient telemetryClient;

    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect();
            retryLeft -= 1;
        }

        if (!telemetryClient.getOnlineStatus()) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }

    /*
     * Getters & setters.
     */

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

}
