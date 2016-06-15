/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.contentassist

import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLangUiInjectorProvider

/**
 * Test the content assist to make sure we inherit the default XbaseProposalProvider
 * implementation.
 * 
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=471434
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ContentAssistFragmentTestLangUiInjectorProvider))
class Bug471434Test extends AbstractContentAssistTest {

	@Test def void testVariableRightWithPrefix() throws Exception {
		newBuilder.append('''
			{
				val first = 0
				val second = f''')
			.assertProposal('first')
			.withDisplayString('first')
	}

	@Test def void testVariableRight() throws Exception {
		newBuilder.append('''
			{
				val first = 0
				val second = ''')
			.assertProposal('first')
			.withDisplayString('first')
	}
	
}
