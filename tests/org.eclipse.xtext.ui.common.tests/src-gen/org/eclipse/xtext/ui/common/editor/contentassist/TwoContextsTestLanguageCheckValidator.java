
package org.eclipse.xtext.ui.common.editor.contentassist;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class TwoContextsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TwoContextsTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::ui::common::editor::contentassist::TwoContextsTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.ui.common.editor.contentassist.twoContexts.TwoContextsPackage.eINSTANCE);
	    
		return result;
	}
	
}
