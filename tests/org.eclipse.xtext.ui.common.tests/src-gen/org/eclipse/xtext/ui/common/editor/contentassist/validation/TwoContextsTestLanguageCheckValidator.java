
package org.eclipse.xtext.ui.common.editor.contentassist.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class TwoContextsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TwoContextsTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::ui::common::editor::contentassist::validation::TwoContextsTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::ui::common::editor::contentassist::validation::TwoContextsTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::ui::common::editor::contentassist::validation::TwoContextsTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.ui.common.editor.contentassist.twoContexts.TwoContextsPackage.eINSTANCE);
		return result;
	}
	
}
