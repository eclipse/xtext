
package org.eclipse.xtext.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class XtextGrammarTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public XtextGrammarTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::validation::XtextGrammarTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::validation::XtextGrammarTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::validation::XtextGrammarTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.xtextTest.XtextTestPackage.eINSTANCE);
		return result;
	}
	
}
