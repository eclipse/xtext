
package org.eclipse.xtext.xtext.ecoreInference.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class UnassignedRuleCallTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public UnassignedRuleCallTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::validation::UnassignedRuleCallTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::validation::UnassignedRuleCallTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::validation::UnassignedRuleCallTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.UnassignedRuleCallTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
