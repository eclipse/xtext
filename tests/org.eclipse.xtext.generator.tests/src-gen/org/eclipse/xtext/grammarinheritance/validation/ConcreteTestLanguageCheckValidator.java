
package org.eclipse.xtext.grammarinheritance.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class ConcreteTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ConcreteTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::ConcreteTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::ConcreteTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::ConcreteTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.grammarinheritance.foo.FooPackage.eINSTANCE);
		return result;
	}
	
}
