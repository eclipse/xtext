
package org.eclipse.xtext.parser.terminalrules;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class TerminalRulesTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TerminalRulesTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parser::terminalrules::TerminalRulesTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.TerminalRulesTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
