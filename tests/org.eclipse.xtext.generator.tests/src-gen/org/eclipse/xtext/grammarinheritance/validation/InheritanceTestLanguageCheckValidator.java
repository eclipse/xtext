
package org.eclipse.xtext.grammarinheritance.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class InheritanceTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public InheritanceTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::InheritanceTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::InheritanceTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::InheritanceTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.grammarinheritance.inheritanceTest.InheritanceTestPackage.eINSTANCE);
		return result;
	}
	
}
