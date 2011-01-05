package org.eclipse.xtext.testlanguages.backtracking.validation;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.testlanguages.backtracking.beeLangTestLanguage.BeeLangTestLanguagePackage;

import static java.util.Collections.*;
 

public class SimpleBeeLangTestLanguageJavaValidator extends AbstractSimpleBeeLangTestLanguageJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage) BeeLangTestLanguagePackage.eINSTANCE);
	}

}
