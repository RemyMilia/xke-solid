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
        telemetryClient.disconnect();
        telemetryClient.connect(3);

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
