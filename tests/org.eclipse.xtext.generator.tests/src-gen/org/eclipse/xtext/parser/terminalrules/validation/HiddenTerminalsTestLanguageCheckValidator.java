
package org.eclipse.xtext.parser.terminalrules.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class HiddenTerminalsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public HiddenTerminalsTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::HiddenTerminalsTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::HiddenTerminalsTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::HiddenTerminalsTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
