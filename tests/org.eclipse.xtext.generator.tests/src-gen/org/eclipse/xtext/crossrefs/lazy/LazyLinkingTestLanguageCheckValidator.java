
package org.eclipse.xtext.crossrefs.lazy;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class LazyLinkingTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public LazyLinkingTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::crossrefs::lazy::LazyLinkingTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.crossrefs.lazy.lazyLinking.LazyLinkingPackage.eINSTANCE);
	    
		return result;
	}
	
}
