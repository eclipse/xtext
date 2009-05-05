
package org.eclipse.xtext.parser.terminalrules.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class XtextTerminalsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public XtextTerminalsTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::XtextTerminalsTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::XtextTerminalsTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parser::terminalrules::validation::XtextTerminalsTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
