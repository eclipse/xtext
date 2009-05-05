
package org.eclipse.xtext.valueconverter.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class Bug250313CheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public Bug250313CheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::valueconverter::validation::Bug250313FastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::valueconverter::validation::Bug250313Checks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::valueconverter::validation::Bug250313ExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.valueconverter.bug250313.Bug250313Package.eINSTANCE);
		return result;
	}
	
}
