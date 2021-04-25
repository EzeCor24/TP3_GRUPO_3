package exception;

import java.io.IOException;

public class DniInvalido extends IOException{

	public DniInvalido() {}

	@Override
	public String getMessage() {
		return "Error: el DNI no puede contener letras";
	}
	
	

}
