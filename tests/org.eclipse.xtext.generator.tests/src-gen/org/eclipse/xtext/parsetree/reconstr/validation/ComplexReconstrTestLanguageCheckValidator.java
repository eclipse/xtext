
package org.eclipse.xtext.parsetree.reconstr.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class ComplexReconstrTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ComplexReconstrTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::ComplexReconstrTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::ComplexReconstrTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::ComplexReconstrTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage.eINSTANCE);
		return result;
	}
	
}
