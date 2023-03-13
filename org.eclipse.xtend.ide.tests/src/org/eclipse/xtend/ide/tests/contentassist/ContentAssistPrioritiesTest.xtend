/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.eclipse.core.runtime.preferences.InstanceScope
import org.eclipse.jdt.ui.JavaUI
import org.eclipse.jdt.ui.PreferenceConstants
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ContentAssistPrioritiesTest extends AbstractXtendContentAssistBugTest {
	
	@Test def void testPriorities() {
		// Switch of static favorites since they would appear here, too.
		val defaultprefs = PreferenceConstants.getPreference(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, null);
		val jdtPreference = InstanceScope.INSTANCE.getNode(JavaUI.ID_PLUGIN)
		try {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS,"")
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
		
		} finally {
			jdtPreference.put(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS, defaultprefs)
		}
	}
	
	def void assertContains(ICompletionProposal proposal, String text) {
		assertTrue(text + ' in ' + proposal.displayString, proposal.displayString.contains(text))
	}
	
}