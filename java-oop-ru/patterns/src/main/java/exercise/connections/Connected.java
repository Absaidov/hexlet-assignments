package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection{
    private TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection){
        this.tcpConnection = tcpConnection;
    }
    @Override
    public String getCurrentState(){
        return "connected";
    }
    @Override
    public void connect() {
        System.out.println("Error! Connection already connected");
    }

    @Override
    public void disconnect() {
        TcpConnection conect = this.tcpConnection;
        conect.setConnection(new Disconnected(conect));
        System.out.println("disconnected");
    }

    @Override
    public void write(String string) {
        System.out.println(string + " was added.");
    }
}
// END
