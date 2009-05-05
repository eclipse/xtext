
package org.eclipse.xtext.grammarinheritance.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class BaseInheritanceTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public BaseInheritanceTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::BaseInheritanceTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::BaseInheritanceTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::BaseInheritanceTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.grammarinheritance.baseInheritanceTest.BaseInheritanceTestPackage.eINSTANCE);
		return result;
	}
	
}
