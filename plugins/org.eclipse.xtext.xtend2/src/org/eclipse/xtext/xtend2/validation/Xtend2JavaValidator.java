package org.eclipse.xtext.xtend2.validation;

import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
 

public class Xtend2JavaValidator extends AbstractXtend2JavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.GREETING__NAME);
//		}
//	}
	
	@Override
	protected List<EPackage> getEPackages() {
		return singletonList((EPackage)Xtend2Package.eINSTANCE);
	}

}
