package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.ArrayList;
import java.util.List;


// BEGIN
public class TcpConnection implements Connection {

    private String ip;
    private int port;

    private Connection state;

    List<String> buffer = new ArrayList<>();

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.state = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.state.getCurrentState();
    }
    @Override
    public void connect() {
        state.connect();
    }
    @Override
    public void disconnect() {
        state.disconnect();
    }
    public void setState(Connection stateObject) {
        this.state = stateObject;
    }

    @Override
    public void write(String data) {
        state.write(data);
    }
    public void addToBuffer(String data){
        buffer.add(data);
    }
}
// END