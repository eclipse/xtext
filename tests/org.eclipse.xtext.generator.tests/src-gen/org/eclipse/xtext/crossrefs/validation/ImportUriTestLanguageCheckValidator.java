
package org.eclipse.xtext.crossrefs.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class ImportUriTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ImportUriTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::crossrefs::validation::ImportUriTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::crossrefs::validation::ImportUriTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::crossrefs::validation::ImportUriTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.crossrefs.importedURI.ImportedURIPackage.eINSTANCE);
		return result;
	}
	
}
