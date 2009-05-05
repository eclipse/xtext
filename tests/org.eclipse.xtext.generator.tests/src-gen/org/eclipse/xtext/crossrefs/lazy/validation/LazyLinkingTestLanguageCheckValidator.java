
package org.eclipse.xtext.crossrefs.lazy.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class LazyLinkingTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public LazyLinkingTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::crossrefs::lazy::validation::LazyLinkingTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::crossrefs::lazy::validation::LazyLinkingTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::crossrefs::lazy::validation::LazyLinkingTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.crossrefs.lazy.lazyLinking.LazyLinkingPackage.eINSTANCE);
		return result;
	}
	
}
