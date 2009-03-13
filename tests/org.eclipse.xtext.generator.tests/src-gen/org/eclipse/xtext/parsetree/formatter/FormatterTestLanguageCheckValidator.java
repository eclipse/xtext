
package org.eclipse.xtext.parsetree.formatter;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class FormatterTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public FormatterTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::parsetree::formatter::FormatterTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
