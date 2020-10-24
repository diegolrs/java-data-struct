
public class EmptyException extends Exception {
	private String message;
	
	public EmptyException(String message){
		this.message = message;	
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
