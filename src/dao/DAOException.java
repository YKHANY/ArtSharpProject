package dao;

public class DAOException extends Exception{

	private static final long serialVersionUID = -3631850514610635327L;
	private String message;
	
	public DAOException(){
		
	}
	public DAOException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return message;
	}
}
