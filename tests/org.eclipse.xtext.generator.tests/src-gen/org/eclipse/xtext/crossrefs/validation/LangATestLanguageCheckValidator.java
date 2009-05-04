
package org.eclipse.xtext.crossrefs.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class LangATestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public LangATestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::crossrefs::validation::LangATestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::crossrefs::validation::LangATestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::crossrefs::validation::LangATestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
