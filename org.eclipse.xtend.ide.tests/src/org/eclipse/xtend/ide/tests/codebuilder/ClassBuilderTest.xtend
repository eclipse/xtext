/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.codebuilder

import com.google.inject.Inject
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory
import org.eclipse.xtext.common.types.JvmVisibility
import org.junit.Test

class ClassBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Test
	def testXtendClass() {
		(createClassBuilder(xtendClass) => [
			context = xtendClass
			className = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			class Bar {
			}''')
	}
	
	@Test
	def testJavaClass() {
		(createClassBuilder(javaClass) => [
			context = javaClass
			className = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			public class Bar {
			}''')
	}
}