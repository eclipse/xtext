
package org.eclipse.xtext.parsetree.reconstr.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class SerializationBug269362TestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public SerializationBug269362TestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::SerializationBug269362TestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::SerializationBug269362TestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::parsetree::reconstr::validation::SerializationBug269362TestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
