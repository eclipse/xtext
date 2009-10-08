
package org.eclipse.xtext.xtend.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class TreeTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public TreeTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::xtend::validation::TreeTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::xtend::validation::TreeTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::xtend::validation::TreeTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.xtend.treeXtendTestLanguage.TreeXtendTestLanguagePackage.eINSTANCE);
		return result;
	}
	
}
