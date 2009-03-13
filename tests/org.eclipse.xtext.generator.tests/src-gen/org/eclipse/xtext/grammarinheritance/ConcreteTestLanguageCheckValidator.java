
package org.eclipse.xtext.grammarinheritance;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class ConcreteTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ConcreteTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::grammarinheritance::ConcreteTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.grammarinheritance.foo.FooPackage.eINSTANCE);
	    
		return result;
	}
	
}
