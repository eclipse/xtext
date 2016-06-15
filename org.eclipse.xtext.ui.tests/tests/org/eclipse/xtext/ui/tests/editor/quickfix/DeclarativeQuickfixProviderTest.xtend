/** 
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
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

/** 
 * @author Knut Wannheden - Initial contribution and API
 */
class DeclarativeQuickfixProviderTest extends Assert {

	static final String DUMMY_CODE = "DeclarativeQuickfixProviderTest.DummyCode"

	@Test def void testHasResolutions() throws Exception {
		var AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {

			@Fix(DUMMY_CODE) def void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		}
		assertFalse(provider.hasResolutionFor(DUMMY_CODE + 1))
		assertTrue(provider.hasResolutionFor(DUMMY_CODE))
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

	def protected Issue createIssue(String code) {
		return new Issue.IssueImpl => [
			it.code = code
		]
	}
}
