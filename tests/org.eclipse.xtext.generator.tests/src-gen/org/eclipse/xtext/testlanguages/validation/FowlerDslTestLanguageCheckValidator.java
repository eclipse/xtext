
package org.eclipse.xtext.testlanguages.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class FowlerDslTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public FowlerDslTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::testlanguages::validation::FowlerDslTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::FowlerDslTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::FowlerDslTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.testlanguages.fowlerdsl.FowlerdslPackage.eINSTANCE);
		return result;
	}
	
}
