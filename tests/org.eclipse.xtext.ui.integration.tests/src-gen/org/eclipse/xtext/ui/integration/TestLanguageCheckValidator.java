
package org.eclipse.xtext.ui.integration;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class TestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::ui::integration::TestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.ui.integration.foo.FooPackage.eINSTANCE);
	    
		return result;
	}
	
}
