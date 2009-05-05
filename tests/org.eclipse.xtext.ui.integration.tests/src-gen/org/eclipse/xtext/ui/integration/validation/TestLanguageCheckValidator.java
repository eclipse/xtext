
package org.eclipse.xtext.ui.integration.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class TestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::ui::integration::validation::TestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::ui::integration::validation::TestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::ui::integration::validation::TestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.ui.integration.foo.FooPackage.eINSTANCE);
		return result;
	}
	
}
