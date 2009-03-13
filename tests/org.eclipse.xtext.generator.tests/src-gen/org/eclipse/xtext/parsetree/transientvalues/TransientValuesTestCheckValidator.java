
package org.eclipse.xtext.parsetree.transientvalues;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class TransientValuesTestCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TransientValuesTestCheckValidator() {
		addCheckFile("org::eclipse::xtext::parsetree::transientvalues::TransientValuesTestChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage.eINSTANCE);
	    
		return result;
	}
	
}
