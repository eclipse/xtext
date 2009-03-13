
package org.eclipse.xtext;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class XtextGrammarTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public XtextGrammarTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::XtextGrammarTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.xtextTest.XtextTestPackage.eINSTANCE);
	    
		return result;
	}
	
}
