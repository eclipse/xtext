
package org.eclipse.xtext.example.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class DomainmodelCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public DomainmodelCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::example::validation::DomainmodelFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::example::validation::DomainmodelChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::example::validation::DomainmodelExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.example.domainmodel.DomainmodelPackage.eINSTANCE);
		return result;
	}
	
}
