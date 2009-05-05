
package org.eclipse.xtext.grammarinheritance.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class AbstractTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public AbstractTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::AbstractTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::AbstractTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::grammarinheritance::validation::AbstractTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
		return result;
	}
	
}
