
package org.eclipse.xtext.enumrules;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class EnumRulesTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public EnumRulesTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::enumrules::EnumRulesTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
