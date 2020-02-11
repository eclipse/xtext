/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(XbaseInjectorProvider)
@RunWith(XtextRunner)
/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
class OnTheFlyJavaCompiler2Test extends AbstractJvmModelTest {
	
	@Rule
	@Inject public TemporaryFolder temporaryFolder
	@Inject OnTheFlyJavaCompiler2 javaCompiler

	@Test(expected=IllegalArgumentException)
	def void testDefaultJavaVersionWithJava7Feature() {
		assertJavaCompilation(
			'''
			java.util.List<String> list = new java.util.LinkedList<>();
			''',
			null
		)
	}

	@Test def void testJavaVersion7() {
		assertJavaCompilation(
			'''
			java.util.List<String> list = new java.util.LinkedList<>();
			''',
			JavaVersion.JAVA7
		)
	}

	@Test def void testJavaVersion8() {
		assertJavaCompilation(
			'''
			Runnable r = () -> {};
			''',
			JavaVersion.JAVA8
		)
	}

	def private assertJavaCompilation(CharSequence input, JavaVersion javaVersion) {
		if (javaVersion !== null)
			javaCompiler.javaVersion = javaVersion
		javaCompiler.compileToClass("tests.Main",
			'''
			package tests;
			
			public class Main {
				public static void main(String args[]) {
					«input»
				}
			}
			'''
		)
	}

}

