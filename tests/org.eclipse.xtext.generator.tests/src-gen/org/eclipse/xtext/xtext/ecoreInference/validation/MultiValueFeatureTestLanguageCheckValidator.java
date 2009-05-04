
package org.eclipse.xtext.xtext.ecoreInference.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class MultiValueFeatureTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public MultiValueFeatureTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::validation::MultiValueFeatureTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::validation::MultiValueFeatureTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::xtext::ecoreInference::validation::MultiValueFeatureTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
