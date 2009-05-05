
package org.eclipse.xtext.dummy.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class DummyTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public DummyTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::dummy::validation::DummyTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::dummy::validation::DummyTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::dummy::validation::DummyTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.dummy.dummyLang.DummyLangPackage.eINSTANCE);
		return result;
	}
	
}
