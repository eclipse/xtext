
package org.eclipse.xtext.generator;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class lowerCaseNamedTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public lowerCaseNamedTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::generator::lowerCaseNamedTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.generator.lowerCaseNamedTestLanguage.LowerCaseNamedTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
