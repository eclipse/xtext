
package org.eclipse.xtext.testlanguages.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class LexerTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public LexerTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::testlanguages::validation::LexerTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::LexerTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::testlanguages::validation::LexerTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.testlanguages.lexerLang.LexerLangPackage.eINSTANCE);
		return result;
	}
	
}
