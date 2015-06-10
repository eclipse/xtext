/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations

/**
 * @author kosyakov - Initial contribution and API
 */
class PsiJvmModelAssociationsTests extends LightXtendTest {

	@Inject
	extension IPsiJvmModelAssociations

	def void testAssociations() {
		configureByText('''
			package foo
			
			class Foo {
				String name
				def getName() {
					name
				}
				def void setName(String name) {
					this.name = name
				}
				class Bar {
				}
			}
		''')
		val jvmClass = xtextFile.resource.contents.filter(JvmDeclaredType).head
		val sourceElement = jvmClass.primarySourceElement
		assertNotNull(sourceElement.toString, sourceElement)
	}

}