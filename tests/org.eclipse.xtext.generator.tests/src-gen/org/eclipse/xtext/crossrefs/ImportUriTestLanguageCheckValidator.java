
package org.eclipse.xtext.crossrefs;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class ImportUriTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public ImportUriTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::crossrefs::ImportUriTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.crossrefs.importedURI.ImportedURIPackage.eINSTANCE);
	    
		return result;
	}
	
}
