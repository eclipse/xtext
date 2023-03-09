/*******************************************************************************
 * Copyright (c) 2021 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.editor.folding;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.folding.FoldingRange;
import org.eclipse.xtext.ide.editor.folding.IFoldingRangeProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.Assert;

import com.google.inject.Inject;

/**
 * @author Mark Sujew - Initial contribution and API
 */
public abstract class AbstractFoldingRangeProviderTest<T extends EObject> {

	@Inject
	private IFoldingRangeProvider foldingRangeProvider;
	@Inject
	private ParseHelper<T> parseHelper;

	protected void assertFoldingRanges(CharSequence content, FoldingRange... expectedRanges) {
		XtextResource resource;
		try {
			resource = (XtextResource) parseHelper.parse(content).eResource();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		List<FoldingRange> foldingRanges = foldingRangeProvider.getFoldingRanges(resource, CancelIndicator.NullImpl)
				.stream().collect(Collectors.toList());

		Assert.assertEquals(expectedRanges.length, foldingRanges.size());
		
		for (int i = 0; i < foldingRanges.size(); i++) {
			FoldingRange range = foldingRanges.get(i);
			FoldingRange expected = expectedRanges[i];
			Assert.assertEquals(expected.getOffset(), range.getOffset());
			Assert.assertEquals(expected.getLength(), range.getLength());
			Assert.assertEquals(expected.getKind(), range.getKind());
		}
	}
}
