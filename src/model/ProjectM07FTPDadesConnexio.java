package model;

public class ProjectM07FTPDadesConnexio {

	public String connectionName;
	public String host;
	public Integer port;
	public String user;
	public String password;

	public ProjectM07FTPDadesConnexio() {

	}

	public ProjectM07FTPDadesConnexio(String connectionName, String host, Integer port, String user, String password) {
		this.connectionName = connectionName;
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
