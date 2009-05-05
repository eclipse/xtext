
package org.eclipse.xtext.testlanguages.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class ContentAssistTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ContentAssistTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::testlanguages::validation::ContentAssistTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::ContentAssistTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::ContentAssistTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
