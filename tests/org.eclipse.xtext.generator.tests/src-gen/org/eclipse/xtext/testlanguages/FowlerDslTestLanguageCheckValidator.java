
package org.eclipse.xtext.testlanguages;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class FowlerDslTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public FowlerDslTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::testlanguages::FowlerDslTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.testlanguages.fowlerdsl.FowlerdslPackage.eINSTANCE);
	    
		return result;
	}
	
}
