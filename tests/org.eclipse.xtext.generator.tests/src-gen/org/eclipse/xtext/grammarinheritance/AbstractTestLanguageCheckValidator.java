
package org.eclipse.xtext.grammarinheritance;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class AbstractTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public AbstractTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::grammarinheritance::AbstractTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
		return result;
	}
	
}
