package org.eclipse.xpect.xtext.lib.tests;

import org.junit.runner.RunWith;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectSuiteClasses;

@XpectSuiteClasses({ JvmModelInferrerTest.class, //
		LinkingTest.class,//
		ResourceDescriptionTest.class, //
		ScopingTest.class, //
		ValidationTest.class, //
})
@RunWith(XpectRunner.class)
public class XtextTests {

}
