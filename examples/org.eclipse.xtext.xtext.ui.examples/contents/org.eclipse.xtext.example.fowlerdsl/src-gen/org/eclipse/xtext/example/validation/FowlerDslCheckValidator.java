
package org.eclipse.xtext.example.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class FowlerDslCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public FowlerDslCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::example::validation::FowlerDslFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::example::validation::FowlerDslChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::example::validation::FowlerDslExpensiveChecks", CheckType.EXPENSIVE);
	}
	
@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.example.fowlerdsl.FowlerdslPackage.eINSTANCE);
		return result;
	}
	
}
