package org.eclipse.xtext.ui.tests.validation;

import org.eclipse.xtext.ui.tests.foo.FooPackage;
import org.eclipse.xtext.ui.tests.foo.Stuff;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
 

public class TestLanguageJavaValidator extends AbstractTestLanguageJavaValidator {

	@Check(CheckType.EXPENSIVE)
	public void checkTypeNameStartsWithCapital(Stuff stuff) {
		if ("foo".equalsIgnoreCase(stuff.getName())) {
			error("Invalid Stuff name", FooPackage.STUFF__NAME);
		}
	}

}
