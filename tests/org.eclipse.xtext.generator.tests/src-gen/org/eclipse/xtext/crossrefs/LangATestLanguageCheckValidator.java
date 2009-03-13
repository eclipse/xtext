
package org.eclipse.xtext.crossrefs;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class LangATestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public LangATestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::crossrefs::LangATestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
