/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class Java21RecordCompilerTest extends AbstractJvmModelTest {
	@Rule
	@Inject
	public TemporaryFolder temporaryFolder;

	@Inject
	private CompilationTestHelper compilationTestHelper;

	/**
	 * Since there's no record in the JDK and adding a Java source with a record in this
	 * project would require Java 21 compilation level, I'm using a known record from
	 * draw2d, which is in our target platform.
	 */
	@Test public void testUseJavaRecord() throws Exception {
		Assume.assumeTrue("Active only on Java 21 and later", JavaRuntimeVersion.isJava21OrLater());
		String source =
				"{\n"
				+ "  var interval = new org.eclipse.draw2d.geometry.Interval(0, 10);\n"
				+ "  var int begin = interval.begin\n"
				+ "  var end = interval.end()\n"
				+ "  interval.toString"
				+ "}";
		compilationTestHelper.compile(source, it -> {
			String expectation =
					"import org.eclipse.draw2d.geometry.Interval;\n"
					+ "\n"
					+ "@SuppressWarnings(\"all\")\n"
					+ "public class Test {\n"
					+ "  public String doStuff(final String s) {\n"
					+ "    String _xblockexpression = null;\n"
					+ "    {\n"
					+ "      Interval interval = new Interval(0, 10);\n"
					+ "      int begin = interval.begin();\n"
					+ "      int end = interval.end();\n"
					+ "      _xblockexpression = interval.toString();\n"
					+ "    }\n"
					+ "    return _xblockexpression;\n"
					+ "  }\n"
					+ "}\n"
					+ "";
			it.assertNoErrors();
			assertEquals(expectation, Strings.toUnixLineSeparator(it.getSingleGeneratedCode()));
			it.getCompiledClass(); // check that the generated Java code compiles
		});
	}
}
