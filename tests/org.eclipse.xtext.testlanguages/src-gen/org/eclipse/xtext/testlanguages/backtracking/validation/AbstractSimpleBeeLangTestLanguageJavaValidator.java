package org.eclipse.xtext.testlanguages.backtracking.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.testlanguages.backtracking.validation.BeeLangTestLanguageJavaValidator;

public class AbstractSimpleBeeLangTestLanguageJavaValidator extends BeeLangTestLanguageJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/2010/tmf/xtext/beeLangTestLanguage"));
		return result;
	}

}
