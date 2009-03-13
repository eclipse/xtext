
package org.eclipse.xtext.reference;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class ReferenceGrammarCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ReferenceGrammarCheckValidator() {
		addCheckFile("org::eclipse::xtext::reference::ReferenceGrammarChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.reference.referenceGrammar.ReferenceGrammarPackage.eINSTANCE);
	    
		return result;
	}
	
}
