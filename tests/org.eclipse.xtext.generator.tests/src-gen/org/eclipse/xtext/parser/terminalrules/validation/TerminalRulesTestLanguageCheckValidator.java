
package org.eclipse.xtext.parser.terminalrules.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class TerminalRulesTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TerminalRulesTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::TerminalRulesTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::TerminalRulesTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::TerminalRulesTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.TerminalRulesTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
