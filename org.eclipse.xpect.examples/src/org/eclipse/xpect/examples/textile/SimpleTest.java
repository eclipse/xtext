package org.eclipse.xpect.examples.textile;

import org.eclipse.xpect.parameters.CommaSeparatedValuesExpectation;
import org.eclipse.xpect.parameters.ICommaSeparatedValuesExpectation;
import org.eclipse.xpect.parameters.IStringExpectation;
import org.eclipse.xpect.parameters.StringExpectation;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.runner.XpectTestFiles;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;

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

	@Xpect
	public void simpleCSV(
			@CommaSeparatedValuesExpectation ICommaSeparatedValuesExpectation expectation) {
		System.out.println("simpleString");
		expectation.assertEquals(Lists.newArrayList("aa", "bb", "cc"));
	}

}
