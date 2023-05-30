package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection{
    private TcpConnection connection;

    public Connected(TcpConnection tcpConnection){
        this.connection = tcpConnection;
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
        TcpConnection conect = this.connection;
        conect.setState(new Disconnected(conect));
        System.out.println("disconnected");
    }

    @Override
    public void write(String string) {
        connection.addToBuffer(string);
    }
}
// END
