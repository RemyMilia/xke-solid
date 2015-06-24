package fr.xebia.xke.solid.srp;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public class Connection {

    public final String connectionString;
    private boolean online;

    public Connection(String connectionString) {
        checkArgument(!isNullOrEmpty(connectionString));
        this.connectionString = connectionString;
    }

    public boolean isOnline() {
        return online;
    }

    public void connect() {
        online = true;
    }

    public void disconnect() {
        online = false;
    }
}
