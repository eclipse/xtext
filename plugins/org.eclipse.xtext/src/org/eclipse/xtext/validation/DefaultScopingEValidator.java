package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;

public class DefaultScopingEValidator implements EValidator {
	
	

	public boolean validate(EObject object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		return false;
	}

	public boolean validate(EClass class1, EObject object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validate(EDataType dataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO Auto-generated method stub
		return false;
	}

}
