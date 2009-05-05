
package org.eclipse.xtext.example.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class EcoreDslCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public EcoreDslCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::example::validation::EcoreDslFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::example::validation::EcoreDslChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::example::validation::EcoreDslExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.example.ecoredsl.EcoredslPackage.eINSTANCE);
		return result;
	}
	
}
