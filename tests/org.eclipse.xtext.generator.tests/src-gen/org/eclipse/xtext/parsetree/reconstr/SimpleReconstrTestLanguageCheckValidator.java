
package org.eclipse.xtext.parsetree.reconstr;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class SimpleReconstrTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public SimpleReconstrTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::SimpleReconstrTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage.eINSTANCE);
	    
		return result;
	}
	
}
