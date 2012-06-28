package org.eclipse.xpect.examples.textile;

import org.eclipse.xpect.lib.XpectTestFiles;
import org.eclipse.xpect.lib.Xpect;
import org.eclipse.xpect.lib.XpectRunner;
import org.eclipse.xpect.lib.parameters.IStringExpectation;
import org.eclipse.xpect.lib.parameters.StringExpectation;
import org.junit.runner.RunWith;

@RunWith(XpectRunner.class)
@XpectTestFiles(fileExtensions = "textile")
public class SimpleTest {

	@Xpect
	public void simple() {
		System.out.println("Hello World");
	}

	@Xpect
	public void simpleString(@StringExpectation IStringExpectation expectation) {
		System.out.println("simpleString");
		expectation.assertEquals("Foo Bar");
	}

}
