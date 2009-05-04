
package org.eclipse.xtext.enumrules.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class EnumRulesTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public EnumRulesTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::enumrules::validation::EnumRulesTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::enumrules::validation::EnumRulesTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::enumrules::validation::EnumRulesTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
