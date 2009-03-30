
package org.eclipse.xtext.xtext.ecoreInference;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class MultiValueFeatureTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public MultiValueFeatureTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::MultiValueFeatureTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
