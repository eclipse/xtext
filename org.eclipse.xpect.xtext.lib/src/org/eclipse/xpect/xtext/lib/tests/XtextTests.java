package org.eclipse.xpect.xtext.lib.tests;

import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.runner.XpectSuiteClasses;
import org.junit.runner.RunWith;

@XpectSuiteClasses({ JvmModelInferrerTest.class, //
		LinkingTest.class,//
		ResourceDescriptionTest.class, //
		ScopingTest.class, //
		ValidationTest.class, //
})
@RunWith(XpectRunner.class)
public class XtextTests {

}
