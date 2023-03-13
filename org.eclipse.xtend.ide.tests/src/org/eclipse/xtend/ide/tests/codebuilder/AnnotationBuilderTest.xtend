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

class AnnotationBuilderTest extends AbstractBuilderTest {
	
	@Inject extension CodeBuilderFactory 
	
	@Test
	def testXtendAnnotation() {
		(createAnnotationBuilder(xtendClass) => [
			context = xtendClass
			annotationName = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			annotation Bar {
			}''')
	}
	
	@Test
	def testJavaAnnotation() {
		(createAnnotationBuilder(javaClass) => [
			context = javaClass
			annotationName = 'Bar'
			visibility = JvmVisibility::PUBLIC
		]).assertBuilds('''
			public @interface Bar {
			}''')
	}
}