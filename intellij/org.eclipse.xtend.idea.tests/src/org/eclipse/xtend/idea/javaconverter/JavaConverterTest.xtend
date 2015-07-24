/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.javaconverter

import com.google.inject.Inject
import org.eclipse.xtend.core.javaconverter.JavaConverter
import org.eclipse.xtend.idea.LightXtendTest
import org.junit.Ignore
import org.junit.Test

/**
 * @author dhuebner - Initial contribution and API
 */
class JavaConverterTest extends LightXtendTest {
	@Inject JavaConverter converter

	@Test
	@Ignore("Fails on server for unknown reasons")
	def void testSimpleCase() {
		val javaCalzz = myFixture.addFileToProject('javaconverter/JavaConverterTest.java', '''
			package javaconverter;
			
			public class JavaConverterTest {
			
				public void doStuff() {
				}
			
			}
		''')
		val result = converter.toXtend(javaCalzz.virtualFile.nameWithoutExtension, javaCalzz.text)
		assertNotNull(result)
		assertTrue(result.problems.empty)
	}
}