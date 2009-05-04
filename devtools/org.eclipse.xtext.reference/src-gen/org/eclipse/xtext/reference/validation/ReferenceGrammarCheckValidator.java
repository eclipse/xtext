
package org.eclipse.xtext.reference.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class ReferenceGrammarCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ReferenceGrammarCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::reference::validation::ReferenceGrammarFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::reference::validation::ReferenceGrammarChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::reference::validation::ReferenceGrammarExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.reference.referenceGrammar.ReferenceGrammarPackage.eINSTANCE);
		return result;
	}
	
}
