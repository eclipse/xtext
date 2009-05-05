
package org.eclipse.xtext.parsetree.transientvalues.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class TransientValuesTestCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TransientValuesTestCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parsetree::transientvalues::validation::TransientValuesTestFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parsetree::transientvalues::validation::TransientValuesTestChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parsetree::transientvalues::validation::TransientValuesTestExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage.eINSTANCE);
		return result;
	}
	
}
