/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@InjectWith(XbaseInjectorProvider.class)
@RunWith(XtextRunner.class)
public class OnTheFlyJavaCompiler2Test extends AbstractJvmModelTest {
	@Rule
	@Inject
	public TemporaryFolder temporaryFolder;

	@Inject
	private OnTheFlyJavaCompiler2 javaCompiler;

	@Test(expected = IllegalArgumentException.class)
	public void testDefaultJavaVersionWithJava7Feature() {
		assertJavaCompilation("java.util.List<String> list = new java.util.LinkedList<>();", null);
	}

	@Test
	public void testJavaVersion7() {
		assertJavaCompilation("java.util.List<String> list = new java.util.LinkedList<>();", JavaVersion.JAVA7);
	}

	@Test
	public void testJavaVersion8() {
		assertJavaCompilation("Runnable r = () -> {};", JavaVersion.JAVA8);
	}

	private Class<?> assertJavaCompilation(CharSequence input, JavaVersion javaVersion) {
			if (javaVersion != null) {
				this.javaCompiler.setJavaVersion(javaVersion);
			}
			StringBuilder builder = new StringBuilder();
			builder.append("package tests;\n");
			builder.append("public class Main {\n");
			builder.append("	public static void main(String args[]) {\n");
			builder.append("		" + input + "\n");
			builder.append("	}\n");
			builder.append("}");
			return javaCompiler.compileToClass("tests.Main", builder.toString());
	}
}
