
package org.eclipse.xtext.resource.metamodel;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class MultiValueFeatureTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public MultiValueFeatureTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::resource::metamodel::MultiValueFeatureTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage.eINSTANCE);
	    
		return result;
	}
	
}
