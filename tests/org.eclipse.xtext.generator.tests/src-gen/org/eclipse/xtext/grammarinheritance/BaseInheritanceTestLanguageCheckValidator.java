
package org.eclipse.xtext.grammarinheritance;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class BaseInheritanceTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public BaseInheritanceTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::grammarinheritance::BaseInheritanceTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.grammarinheritance.baseInheritanceTest.BaseInheritanceTestPackage.eINSTANCE);
	    
		return result;
	}
	
}
