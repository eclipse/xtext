
package org.eclipse.xtext.parser.datatyperules.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class DatatypeRulesTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public DatatypeRulesTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parser::datatyperules::validation::DatatypeRulesTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parser::datatyperules::validation::DatatypeRulesTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parser::datatyperules::validation::DatatypeRulesTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
