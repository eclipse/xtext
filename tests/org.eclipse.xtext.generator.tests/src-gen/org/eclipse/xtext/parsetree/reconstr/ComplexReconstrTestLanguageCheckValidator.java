
package org.eclipse.xtext.parsetree.reconstr;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class ComplexReconstrTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ComplexReconstrTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::ComplexReconstrTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage.eINSTANCE);
	    
		return result;
	}
	
}
