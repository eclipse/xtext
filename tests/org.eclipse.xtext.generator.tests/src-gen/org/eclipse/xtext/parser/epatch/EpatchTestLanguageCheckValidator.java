
package org.eclipse.xtext.parser.epatch;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class EpatchTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public EpatchTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parser::epatch::EpatchTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
