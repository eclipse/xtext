
package org.eclipse.xtext.metamodelreferencing.tests;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class MultiGenMMTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public MultiGenMMTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::MultiGenMMTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.metamodelreferencing.tests.simpleTest.SimpleTestPackage.eINSTANCE);
	    
	    result.add(org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestPackage.eINSTANCE);
	    
		return result;
	}
	
}
