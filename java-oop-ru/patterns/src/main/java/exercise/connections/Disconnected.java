package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection{
    private TcpConnection tcpConnection;
    public Disconnected(TcpConnection tcpConnection){
        this.tcpConnection = tcpConnection;
    }
    @Override
    public String getCurrentState() {
        return "disconnected";
    }
    @Override
    public void connect() {
        TcpConnection conect = this.tcpConnection;
        conect.setConnection(new Connected(conect));
        System.out.println("connected");
    }
    @Override
    public void disconnect() {
        System.out.println("Error! Connection already disconected.");
    }

    @Override
    public void write(String string) {
        System.out.println("Error " + string);
    }
}
// END
