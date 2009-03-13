
package org.eclipse.xtext.metamodelreferencing.tests;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validator.CheckType;

public class MetamodelRefTestLanguageCheckValidator extends org.eclipse.xtext.check.AbstractCheckValidator {

	public MetamodelRefTestLanguageCheckValidator() {
		addCheckFile("org::eclipse::xtext::metamodelreferencing::tests::MetamodelRefTestLanguageChecks", CheckType.FAST);
	}
	
	@Override
	protected List<? extends EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    
	    result.add(org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage.eINSTANCE);
	    
		return result;
	}
	
}
