
package org.eclipse.xtext.example;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class DomainmodelCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public DomainmodelCheckValidator() {
		addCheckFile("org::eclipse::xtext::example::DomainmodelChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.example.domainmodel.DomainmodelPackage.eINSTANCE);
	    
		return result;
	}
	
}
