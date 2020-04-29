/**
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.quickfix;

import java.util.List;

import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.quickfix.AbstractDeclarativeQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.Fixes;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DeclarativeQuickfixProviderTest extends Assert {
	private static final String DUMMY_CODE = "DeclarativeQuickfixProviderTest.DummyCode";

	private static final String DUMMY_CODE2 = "DeclarativeQuickfixProviderTest.DummyCode2";

	@Test
	public void testHasResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
			public void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		};
		assertFalse(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE + 1));
		assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE));
	}

	@Test
	public void testHasResolutions2() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2)
			public void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		};
		assertFalse(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE + 1));
		assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE));
		assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE2));
	}

	@Test
	public void testHasResolutions3() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fixes({ @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE), @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2) })
			public void signature(Issue i, IssueResolutionAcceptor acceptor) {
			}
		};
		assertFalse(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE + 1));
		assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE));
		assertTrue(provider.hasResolutionFor(DeclarativeQuickfixProviderTest.DUMMY_CODE2));
	}

	@Test
	public void testGetResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
			public void fixError1(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError1", "", "", IModification.NULL);
			}

			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
			public void fixError2(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError2", "", "", IModification.NULL);
			}
		};
		provider.setIssueResolutionAcceptorProvider(() -> new IssueResolutionAcceptor(it -> null));
		List<IssueResolution> resolutionsIterable = provider.getResolutions(createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE + 1));
		assertNull(Iterables.getFirst(resolutionsIterable, null));
		List<IssueResolution> resolutions = provider.getResolutions(createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE));
		assertEquals(2, resolutions.size());
		assertTrue(resolutions.stream().anyMatch(it -> "fixError1".equals(it.getLabel())));
		assertTrue(resolutions.stream().anyMatch(it -> "fixError2".equals(it.getLabel())));
	}

	@Test
	public void testGetResolutions2() throws Exception {

		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2)
			public void fixError1(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError1", "", "", IModification.NULL);
			}

			@Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE)
			public void fixError2(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError2", "", "", IModification.NULL);
			}

			@Fixes({ @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE), @Fix(DeclarativeQuickfixProviderTest.DUMMY_CODE2) })
			public void fixError3(Issue i, IssueResolutionAcceptor acceptor) {
				acceptor.accept(i, "fixError3", "", "", IModification.NULL);
			}
		};
		provider.setIssueResolutionAcceptorProvider(() -> {
			return new IssueResolutionAcceptor(it -> null);
		});
		List<IssueResolution> resolutionsIterable = provider.getResolutions(createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE + 1));
		assertNull(Iterables.getFirst(resolutionsIterable, null));
		List<IssueResolution> resolutions = provider.getResolutions(createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE));
		assertEquals(3, resolutions.size());
		assertTrue(resolutions.stream().anyMatch(it -> "fixError1".equals(it.getLabel())));
		assertTrue(resolutions.stream().anyMatch(it -> "fixError2".equals(it.getLabel())));
		assertTrue(resolutions.stream().anyMatch(it -> "fixError3".equals(it.getLabel())));
		List<IssueResolution> resolutions2 = provider.getResolutions(createIssue(DeclarativeQuickfixProviderTest.DUMMY_CODE2));
		assertEquals(2, resolutions2.size());
		assertTrue(resolutions.stream().anyMatch(it -> "fixError2".equals(it.getLabel())));
		assertTrue(resolutions.stream().anyMatch(it -> "fixError3".equals(it.getLabel())));
	}

	protected Issue createIssue(String code) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setCode(code);
		return issue;
	}
}
