package io.github.yagosiguinolfi.cepjavaapi.exception;

public class DuplicateEnderecoException extends Exception {
	
	public DuplicateEnderecoException(){
		super();
	}
	
	public DuplicateEnderecoException(String msg){
		super(msg);
	}
	
	public DuplicateEnderecoException(String msg, Throwable cause){
		super(msg, cause);
	}

}
