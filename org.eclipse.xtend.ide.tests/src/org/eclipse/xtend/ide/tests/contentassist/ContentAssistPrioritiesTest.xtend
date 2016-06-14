/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test
import org.eclipse.jface.text.contentassist.ICompletionProposal

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ContentAssistPrioritiesTest extends AbstractXtendContentAssistBugTest {
	
	@Test def void testPriorities() {
		val String text = '''
			public class Example {
				String aField;
				String zField;
				static String aStaticField;
				static String zStaticField;
			
				def void aMethod(String aParam,String zParam) {
					val aVar = 'fdfg';
					val zVar = 'fdfg';
					//CURSOR
				}
				def void zMethod() {
				}
				
				def static void aStaticMethod() {
				}
				def static void zStaticMethod() {
				}
			}
		'''
		val idx = text.indexOf("//CURSOR")-1
		val proposals = newBuilder.append(text).insert("",idx).computeCompletionProposals.iterator
		proposals.next.assertContains("aParam")
		proposals.next.assertContains("aVar")
		proposals.next.assertContains("zParam")
		proposals.next.assertContains("zVar")
		proposals.next.assertContains("aField")
		proposals.next.assertContains("aStaticField")
		proposals.next.assertContains("zField")
		proposals.next.assertContains("zStaticField")
		proposals.next.assertContains("aMethod")
		proposals.next.assertContains("aStaticMethod")
	}
	
	def void assertContains(ICompletionProposal proposal, String text) {
		assertTrue(text + ' in ' + proposal.displayString, proposal.displayString.contains(text))
	}
	
}