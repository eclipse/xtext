
package org.eclipse.xtext.example;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class FowlerDslCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public FowlerDslCheckValidator() {
		addCheckFile("org::eclipse::xtext::example::FowlerDslChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage.eINSTANCE);
	    
		return result;
	}
	
}
