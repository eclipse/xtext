/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.text.TypedRegion;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class TaskHighlightingTest extends AbstractXtextTests implements IHighlightedPositionAcceptor {
	@Inject
	private DefaultSemanticHighlightingCalculator highlighter;

	private Set<TypedRegion> expectedRegions = new HashSet<>();

	@Before
	public void setup() throws Exception {
		with(NoJdtTestLanguageStandaloneSetup.class);
		injectMembers(this);
		expectedRegions.clear();
	}

	@Test
	public void test() throws Exception {
		// @formatter:off
		String model = 
				"//TODO foo\n" +
				"/*\n" +
				" * FIXME bar\n" +
				" * Fixme no match\n" +
				" * FOO also no match\n" +
				" */\n"+
				"Hello notATODO!\n";
		// @formatter:on
		XtextResource resource = getResourceFromString(model);
		expect(2, 4, DefaultHighlightingConfiguration.TASK_ID);
		expect(17, 5, DefaultHighlightingConfiguration.TASK_ID);
		getHighlighter().provideHighlightingFor(resource, this, CancelIndicator.NullImpl);
	}

	protected DefaultSemanticHighlightingCalculator getHighlighter() {
		return highlighter;
	}

	protected boolean expect(int offset, int length, String type) {
		return expectedRegions.add(new TypedRegion(offset, length, type));
	}

	@Override
	public void addPosition(int offset, int length, String... id) {
		Assert.assertEquals(1, id.length);
		TypedRegion region = new TypedRegion(offset, length, id[0]);
		Assert.assertFalse(region.toString(), expectedRegions.isEmpty());
		Assert.assertTrue("expected: " + expectedRegions.toString() + " but was: " + region, expectedRegions.remove(region));
	}
}
