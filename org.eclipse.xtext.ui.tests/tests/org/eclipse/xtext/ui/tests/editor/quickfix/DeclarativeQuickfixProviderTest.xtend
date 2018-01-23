/** 
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.editor.quickfix

import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.quickfix.AbstractDeclarativeQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.ui.editor.quickfix.Fixes

/** 
 * @author Knut Wannheden - Initial contribution and API
 */
class DeclarativeQuickfixProviderTest extends Assert {

	static final String DUMMY_CODE = "DeclarativeQuickfixProviderTest.DummyCode"
	static final String DUMMY_CODE2 = "DeclarativeQuickfixProviderTest.DummyCode2"

	@Test def void testHasResolutions() throws Exception {
		var AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {

			@Fix(DUMMY_CODE) def void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		}
		assertFalse(provider.hasResolutionFor(DUMMY_CODE + 1))
		assertTrue(provider.hasResolutionFor(DUMMY_CODE))
	}

	@Test def void testHasResolutions2() throws Exception {
		var AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {

			@Fix(DUMMY_CODE) @Fix(DUMMY_CODE2) def void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		}
		assertFalse(provider.hasResolutionFor(DUMMY_CODE + 1))
		assertTrue(provider.hasResolutionFor(DUMMY_CODE))
		assertTrue(provider.hasResolutionFor(DUMMY_CODE2))
	}
	
	@Test def void testHasResolutions3() throws Exception {
		var AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {

			@Fixes(@Fix(DUMMY_CODE),@Fix(DUMMY_CODE2)) def void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		}
		assertFalse(provider.hasResolutionFor(DUMMY_CODE + 1))
		assertTrue(provider.hasResolutionFor(DUMMY_CODE))
		assertTrue(provider.hasResolutionFor(DUMMY_CODE2))
	}

	@Test def void testGetResolutions() throws Exception {
		var AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {

			@Fix(DUMMY_CODE) def void fixError1(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError1", "", "", IModification.NULL)
			}

			@Fix(DUMMY_CODE) def void fixError2(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError2", "", "", IModification.NULL)
			}
		}
		provider.issueResolutionAcceptorProvider = [new IssueResolutionAcceptor[null]]
		var resolutionsIterable = provider.getResolutions(createIssue(DUMMY_CODE + 1))
		assertNull(resolutionsIterable.head)
		var resolutions = provider.getResolutions(createIssue(DUMMY_CODE))
		assertEquals(2, resolutions.size)
		assertTrue(resolutions.exists[label == "fixError1"])
		assertTrue(resolutions.exists[label == "fixError2"])
	}

	@Test def void testGetResolutions2() throws Exception {
		var AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {

			@Fix(DUMMY_CODE) @Fix(DUMMY_CODE2) def void fixError1(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError1", "", "", IModification.NULL)
			}

			@Fix(DUMMY_CODE) def void fixError2(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError2", "", "", IModification.NULL)
			}
			
			@Fixes(@Fix(DUMMY_CODE), @Fix(DUMMY_CODE2)) def void fixError3(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError3", "", "", IModification.NULL)
			}
		}
		provider.issueResolutionAcceptorProvider = [new IssueResolutionAcceptor[null]]
		var resolutionsIterable = provider.getResolutions(createIssue(DUMMY_CODE + 1))
		assertNull(resolutionsIterable.head)
		var resolutions = provider.getResolutions(createIssue(DUMMY_CODE))
		assertEquals(3, resolutions.size)
		assertTrue(resolutions.exists[label == "fixError1"])
		assertTrue(resolutions.exists[label == "fixError2"])
		assertTrue(resolutions.exists[label == "fixError3"])
		var resolutions2 = provider.getResolutions(createIssue(DUMMY_CODE2))
		assertEquals(2, resolutions2.size)
		assertTrue(resolutions.exists[label == "fixError2"])
		assertTrue(resolutions.exists[label == "fixError3"])
	}

	def protected Issue createIssue(String code) {
		return new Issue.IssueImpl => [
			it.code = code
		]
	}
}
