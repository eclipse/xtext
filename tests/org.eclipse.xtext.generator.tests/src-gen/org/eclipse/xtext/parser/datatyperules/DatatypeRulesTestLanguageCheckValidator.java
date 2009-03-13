
package org.eclipse.xtext.parser.datatyperules;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class DatatypeRulesTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public DatatypeRulesTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parser::datatyperules::DatatypeRulesTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
