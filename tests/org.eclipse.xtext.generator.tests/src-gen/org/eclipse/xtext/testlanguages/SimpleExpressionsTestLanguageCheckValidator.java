
package org.eclipse.xtext.testlanguages;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class SimpleExpressionsTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public SimpleExpressionsTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::testlanguages::SimpleExpressionsTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage.eINSTANCE);
	    
		return result;
	}
	
}
