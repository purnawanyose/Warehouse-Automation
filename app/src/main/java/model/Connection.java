package model;

/**
 * Created by muham on 1/31/2018.
 */

public class Connection {
    private String connectionName;
    private String serverIp;
    private String Id;


    public Connection(){

    }

    public Connection (String Id, String connectionName, String serverIp){
        this.Id = Id;
        this.connectionName = connectionName;
        this.serverIp = serverIp;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
