
package org.eclipse.xtext.parser.keywords.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class KeywordsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public KeywordsTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parser::keywords::validation::KeywordsTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parser::keywords::validation::KeywordsTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parser::keywords::validation::KeywordsTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parser.keywords.keywordsTestLanguage.KeywordsTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
