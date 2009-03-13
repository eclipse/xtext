
package org.eclipse.xtext.parser.keywords;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class KeywordsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public KeywordsTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parser::keywords::KeywordsTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parser.keywords.keywordsTestLanguage.KeywordsTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
