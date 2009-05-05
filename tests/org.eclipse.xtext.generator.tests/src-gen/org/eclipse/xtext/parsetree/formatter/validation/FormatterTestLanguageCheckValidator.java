
package org.eclipse.xtext.parsetree.formatter.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class FormatterTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public FormatterTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parsetree::formatter::validation::FormatterTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parsetree::formatter::validation::FormatterTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parsetree::formatter::validation::FormatterTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage.eINSTANCE);
		return result;
	}
	
}
