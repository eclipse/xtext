
package org.eclipse.xtext.testlanguages;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class PartialParserTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public PartialParserTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::testlanguages::PartialParserTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
