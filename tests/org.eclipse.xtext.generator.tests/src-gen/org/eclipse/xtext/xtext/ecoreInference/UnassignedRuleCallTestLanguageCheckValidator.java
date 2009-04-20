
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class UnassignedRuleCallTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public UnassignedRuleCallTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::UnassignedRuleCallTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.UnassignedRuleCallTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
