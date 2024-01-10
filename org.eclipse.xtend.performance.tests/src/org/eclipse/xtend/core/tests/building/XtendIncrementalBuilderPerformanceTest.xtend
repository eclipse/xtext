/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.building

import com.google.common.base.Stopwatch
import com.google.inject.Inject
import java.util.concurrent.TimeUnit
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.java.JavaSourceLanguageSetup
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Performance test for a code base mixed between Xtend and Java sources
 */
@InjectWith(InjectorProviderWithJavaSourceLang)
@RunWith(XtextRunner)
class XtendIncrementalBuilderPerformanceTest extends AbstractIncrementalBuilderTest {
	
	static class InjectorProviderWithJavaSourceLang extends RuntimeInjectorProvider {
		
		override protected internalCreateInjector() {
			new JavaSourceLanguageSetup().createInjectorAndDoEMFRegistration();
			return super.internalCreateInjector();
		}
			
	}
	
	@Inject IResourceServiceProvider.Registry registry
	
	override protected getLanguages() {
		return registry
	}
	
	def void doTestPerformance(int max) {
		val buildRequest = newBuildRequest [
			dirtyFiles = (1..max).map[toFile(max)].toList
		]
		val sw = Stopwatch.createStarted
		build(buildRequest)
		println('''«max» file took «sw.elapsed(TimeUnit.MILLISECONDS)» ms''')
	}
	
	def URI toFile(int number, int max) {
		return "demo/Demo"+number+(if (number % 2 === 0) ".xtend" else ".java") - '''
			package demo;
			public class Demo«number» {
				«IF (number % 2 === 0)»
					private String x
«««						= String.valueOf(new Object().toString().chars().boxed().map[toString].collect(java.util.stream.Collectors.joining("")))
					;
				«ELSE»
					private String x
«««					 	= String.valueOf(new Object().toString().chars().boxed().map(Object::toString).collect(java.util.stream.Collectors.joining("")))
					;
				«ENDIF»
				«IF number > 1»
					private Demo«number-1» demoA;
				«ENDIF»
				«IF number > 2»
					private Demo«number-2» demoB;
				«ENDIF»
				«IF number < max-1»
					private Demo«number+1» demoC;
				«ENDIF»
			}
		'''
	}
	
	@Test
	def void testPerf00100() {
		doTestPerformance(100)
	}
	
	@Test(timeout=30000)
	def void testPerf00200() {
		doTestPerformance(200)
	}
	
	@Test(timeout=30000)
	def void testPerf00400() {
		doTestPerformance(400)
	}
	
	@Test(timeout=30000)
	def void testPerf00800() {
		doTestPerformance(800)
	}
	
	@Test(timeout=30000)
	def void testPerf01600() {
		doTestPerformance(1600)
	}
	
	@Test(timeout=30000)
	def void testPerf03200() {
		doTestPerformance(3200)
	}
	
	@Test(timeout=30000)
	def void testPerf06400() {
		doTestPerformance(6400)
	}
	
	@Test(timeout=60000)
	def void testPerf12800() {
		doTestPerformance(12800)
	}
	
	@Test(timeout=120000)
	def void testPerf25600() {
		doTestPerformance(25600)
	}
	
	@Test(timeout=240000)
	def void testPerf51200() {
		doTestPerformance(51200)
	}
	
}