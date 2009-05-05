
package org.eclipse.xtext.parsetree.reconstr.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class SimpleReconstrTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public SimpleReconstrTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::SimpleReconstrTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::SimpleReconstrTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::SimpleReconstrTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage.eINSTANCE);
		return result;
	}
	
}
