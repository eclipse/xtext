
package org.eclipse.xtext.example;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class EcoreDslCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public EcoreDslCheckValidator() {
		addCheckFile("org::eclipse::xtext::example::EcoreDslChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.example.ecoredsl.EcoredslPackage.eINSTANCE);
	    
		return result;
	}
	
}
