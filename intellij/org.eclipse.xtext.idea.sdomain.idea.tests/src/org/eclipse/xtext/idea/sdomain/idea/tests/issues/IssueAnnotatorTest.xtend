/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.tests.issues

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType
import org.eclipse.xtext.idea.tests.LightToolingTest

class IssueAnnotatorTest extends LightToolingTest {
	
	new() {
		super(SDomainFileType.INSTANCE)
	}
	
	def void testErrorsAndWarnings() {
		configureByText('''
			entity <warning descr="Name should start with a capital">foo</warning> {
				<error descr="Couldn't resolve reference to Type 'Bar'.">Bar</error> bar
			}
		''')
		checkHighlighting
	}
	
	def void testNoDuplicateSyntaxErrors() {
		configureByText('''
			<error descr="missing EOF at '{'">{</error>}''')
		checkHighlighting
	}
	
}