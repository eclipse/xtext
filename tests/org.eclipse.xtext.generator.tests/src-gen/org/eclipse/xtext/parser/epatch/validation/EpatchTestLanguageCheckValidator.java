
package org.eclipse.xtext.parser.epatch.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class EpatchTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public EpatchTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parser::epatch::validation::EpatchTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parser::epatch::validation::EpatchTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parser::epatch::validation::EpatchTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
