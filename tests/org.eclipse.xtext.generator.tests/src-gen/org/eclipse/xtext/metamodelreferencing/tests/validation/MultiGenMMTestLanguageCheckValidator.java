
package org.eclipse.xtext.metamodelreferencing.tests.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class MultiGenMMTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public MultiGenMMTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::validation::MultiGenMMTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::validation::MultiGenMMTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::validation::MultiGenMMTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.metamodelreferencing.tests.simpleTest.SimpleTestPackage.eINSTANCE);
	    result.add(org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestPackage.eINSTANCE);
		return result;
	}
	
}
