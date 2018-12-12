package mx.edu.uacm.objsperdidos.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidarDatosUsuario implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {		
		return Usuario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Usuario usuario = (Usuario) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "field.nombre.required", 
				"El nombre es obligatorio");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "field.correo.required", 
				"El correo es obligatorio");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contrasena", "field.contrasena.required", 
				"La contrasena es obligatoria");
		
		
	}

}
