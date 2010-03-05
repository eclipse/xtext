/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.AbstractDeclarativeQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.inject.Provider;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DeclarativeQuickfixProviderTest extends TestCase {

	private static final String DUMMY_CODE = "DeclarativeQuickfixProviderTest.DummyCode";

	public void testHasResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(DUMMY_CODE)
			@SuppressWarnings("unused")
			public void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		};
		
		assertFalse(provider.hasResolutionFor(DUMMY_CODE+1));
		assertTrue(provider.hasResolutionFor(DUMMY_CODE));
	}

	public void testGetResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(DUMMY_CODE)
			@SuppressWarnings("unused")
			public void fixError1(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError1", "", "", null);
			}

			@Fix(DUMMY_CODE)
			@SuppressWarnings("unused")
			public void fixError2(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError2", "", "", null);
			}

		};
		provider.setIssueResolutionAcceptorProvider(new Provider<IssueResolutionAcceptor>() {
			public IssueResolutionAcceptor get() {
				return new IssueResolutionAcceptor(new IModificationContext.Factory() {
					public IModificationContext createModificationContext(Issue issue) {
						return null;
					}
				});
			}
		});
		Iterable<IssueResolution> resolutionsIterable = provider.getResolutions(
				createIssue(DUMMY_CODE+1));
		assertFalse(resolutionsIterable.iterator().hasNext());

		List<IssueResolution> resolutions = Lists.newArrayList(provider.getResolutions(
				createIssue(DUMMY_CODE)));
		assertTrue(!resolutions.isEmpty());

		assertEquals(2, resolutions.size());
		assertEquals("fixError1", resolutions.get(0).getLabel());
		assertEquals("fixError2", resolutions.get(1).getLabel());
	}

	protected Issue createIssue(String code) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setCode(code);
		return issue;
	}
}
