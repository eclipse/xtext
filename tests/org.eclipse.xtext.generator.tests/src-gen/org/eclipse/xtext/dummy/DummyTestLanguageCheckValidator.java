
package org.eclipse.xtext.dummy;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class DummyTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public DummyTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::dummy::DummyTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.dummy.dummyLang.DummyLangPackage.eINSTANCE);
	    
		return result;
	}
	
}
