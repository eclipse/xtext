
package org.eclipse.xtext.parsetree.reconstr;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class SerializationBug269362TestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public SerializationBug269362TestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::SerializationBug269362TestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
