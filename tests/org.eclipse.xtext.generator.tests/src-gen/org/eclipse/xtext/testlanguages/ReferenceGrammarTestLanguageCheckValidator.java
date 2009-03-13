
package org.eclipse.xtext.testlanguages;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class ReferenceGrammarTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ReferenceGrammarTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::testlanguages::ReferenceGrammarTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage.eINSTANCE);
	    
		return result;
	}
	
}
