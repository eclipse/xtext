
package org.eclipse.xtext.testlanguages.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class OptionalEmptyTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public OptionalEmptyTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::testlanguages::validation::OptionalEmptyTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::OptionalEmptyTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::OptionalEmptyTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.testlanguages.optionalEmpty.OptionalEmptyPackage.eINSTANCE);
		return result;
	}
	
}
