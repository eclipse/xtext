
package org.eclipse.xtext.testlanguages.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class SimpleExpressionsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public SimpleExpressionsTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::testlanguages::validation::SimpleExpressionsTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::SimpleExpressionsTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::SimpleExpressionsTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage.eINSTANCE);
		return result;
	}
	
}
