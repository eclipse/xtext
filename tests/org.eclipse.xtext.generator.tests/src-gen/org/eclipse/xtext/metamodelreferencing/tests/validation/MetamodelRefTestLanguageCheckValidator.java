
package org.eclipse.xtext.metamodelreferencing.tests.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.CheckType;

public class MetamodelRefTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public MetamodelRefTestLanguageCheckValidator() {
		configure();
	}
	
	protected void configure() {
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::validation::MetamodelRefTestLanguageFastChecks", CheckType.FAST);
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::validation::MetamodelRefTestLanguageChecks", CheckType.NORMAL);
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::validation::MetamodelRefTestLanguageExpensiveChecks", CheckType.EXPENSIVE);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage.eINSTANCE);
		return result;
	}
	
}
