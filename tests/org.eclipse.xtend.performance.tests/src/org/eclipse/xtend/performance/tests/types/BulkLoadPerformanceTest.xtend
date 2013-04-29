/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.performance.tests.types

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.performance.tests.PerformanceTestProjectSetup
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*
import java.util.List
import java.util.Collection
import java.util.Set
import com.google.common.collect.Multimaps
import com.google.common.collect.Iterators
import com.google.common.collect.Lists
import java.util.Collections
import com.google.common.collect.Collections2
import javax.swing.JButton
import javax.swing.JTextField
import org.junit.Ignore

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BulkLoadPerformanceTest extends AbstractXtendUITestCase {

	@Rule public static val rule = new StopwatchRule(true)

	@Inject protected extension ReflectExtensions

	@BeforeClass
	def static void createTestProject() {
		PerformanceTestProjectSetup::setUp(false)
		waitForAutoBuild();
	}

	@AfterClass
	def static void deleteTestProject() {
		PerformanceTestProjectSetup::tearDown
	}
	
	def protected getTypesToLoad() {
		val List<Class<?>> result = newArrayList
		result += new ImplicitlyImportedTypes().invoke('getExtensionClasses') as List<Class<?>>
		return result
	}

	@Test
	def void testSequentialLoad() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoad300Times() throws Exception {
		for (i : 1 .. 300) {
			testSequentialLoad
		}
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoad300TimesAgain() throws Exception {
		testSequentialLoad300Times
	}

	@Test
	def void testBulkLoad() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new OldJdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(typesToLoad.map[name])
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoad300Times() throws Exception {
		for (i : 1 .. 300) {
			testBulkLoad
		}
	}
	
	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoad300TimesAgain() throws Exception {
		testBulkLoad300Times
	}
	
	@Test
	def void testSequentialLoadNewImpl() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val extension typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typesToLoad.map[name].forEach [
			assertNotNull(findTypeByName)
		]
	}

	@Test
	def void testSequentialLoadNewImpl300Times() throws Exception {
		for (i : 1 .. 300) {
			testSequentialLoadNewImpl
		}
	}

	@Test
	def void testSequentialLoadNewImpl300TimesAgain() throws Exception {
		testSequentialLoadNewImpl300Times
	}

	@Test
	def void testBulkLoadNewImpl() throws Exception {
		val resourceSet = new ResourceSetImpl();
		val typeProvider = new JdtTypeProvider(PerformanceTestProjectSetup::testProject, resourceSet);
		typeProvider.findTypesByName(typesToLoad.map[name])
	}

	@Test
	def void testBulkLoadNewImpl300Times() throws Exception {
		for (i : 1 .. 300) {
			testBulkLoadNewImpl
		}
	}

	@Test
	def void testBulkLoadNewImpl300TimesAgain() throws Exception {
		testBulkLoadNewImpl300Times
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoad300TimesOnceMore() throws Exception {
		testSequentialLoad300Times
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoad300TimesOnceMore() throws Exception {
		testBulkLoad300Times
	}
	
	@Test
	def void testSequentialLoadNewImpl300TimesOnceMore() throws Exception {
		testSequentialLoadNewImpl300Times
	}

	@Test
	def void testBulkLoadNewImpl300TimesOnceMore() throws Exception {
		testBulkLoadNewImpl300Times
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testSequentialLoadAgain() throws Exception {
		testSequentialLoad
	}

	@Ignore("Implementation is obsolete but kept here as a reference")
	@Test
	def void testBulkLoadAgain() throws Exception {
		testBulkLoad
	}
	
	@Test
	def void testSequentialLoadNewImplAgain() throws Exception {
		testSequentialLoad
	}

	@Test
	def void testBulkLoadNewImplAgain() throws Exception {
		testBulkLoad
	}
	
	@Test
	def void testDummy() throws Exception {
		assertTrue(true)
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class BulkLoadPerformanceTestWithMoreTypes extends BulkLoadPerformanceTest {
	
	override protected getTypesToLoad()
		{
		val List<Class<?>> result = newArrayList
		result += new ImplicitlyImportedTypes().invoke('getExtensionClasses') as List<Class<?>>
		result += #[
			typeof(List),
			typeof(Collection),
			typeof(Set),
			typeof(StringBuilder),
			typeof(StringBuffer),
			typeof(CharSequence),
			typeof(String),
			typeof(Class),
			typeof(Multimaps),
			typeof(Iterators),
			typeof(Lists),
			typeof(Collections),
			typeof(Collections2),
			typeof(JButton),
			typeof(JTextField)
		]
		return result
	}
	
}

