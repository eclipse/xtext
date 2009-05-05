
package org.eclipse.xtext.generator.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class lowerCaseNamedTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public lowerCaseNamedTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::generator::validation::lowerCaseNamedTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::generator::validation::lowerCaseNamedTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::generator::validation::lowerCaseNamedTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.generator.lowerCaseNamedTestLanguage.LowerCaseNamedTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
