/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegmentDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccessDiff;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionRewriter;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
 */
public class RegionDiffFormatter {

	public final static class NullFormatter extends AbstractFormatter2 {
		@Override
		public void format(Object obj, IFormattableDocument document) {
		}
	}

	@Inject(optional = true)
	private Provider<IFormatter2> formatter;

	@Inject
	private Provider<FormatterRequest> formatterRequest;

	@Inject
	private Provider<NullFormatter> nullFormatter;

	protected Collection<ITextRegion> collectRegionsToFormat(ITextRegionAccessDiff regions) {
		List<ITextRegion> result = Lists.newArrayList();
		for (ITextSegmentDiff diff : regions.getRegionDifferences()) {
			int offset = diff.getModifiedFirstRegion().getOffset();
			int length = diff.getModifiedLastRegion().getEndOffset() - offset;
			ITextSegment region = regions.regionForOffset(offset, length);
			result.add(region);
		}
		return result;
	}

	protected FormatterRequest createFormatterRequest(ITextRegionAccess rewritten) {
		FormatterRequest request = formatterRequest.get();
		request.setTextRegionAccess(rewritten);
		return request;
	}

	protected FormatterRequest createFormatterRequest(ITextRegionAccessDiff rewritten) {
		FormatterRequest request = formatterRequest.get();
		request.setTextRegionAccess(rewritten);
		request.setRegions(collectRegionsToFormat(rewritten));
		return request;
	}

	public List<ITextReplacement> format(ITextRegionAccess regions) {
		IFormatter2 fmt = getFormatter();
		if (regions instanceof ITextRegionAccessDiff) {
			ITextRegionAccessDiff diff = (ITextRegionAccessDiff) regions;
			FormatterRequest request = createFormatterRequest(diff);
			List<ITextReplacement> replacements = fmt.format(request);
			List<ITextReplacement> merged = mergeReplacements(diff, replacements);
			return merged;
		} else {
			FormatterRequest request = createFormatterRequest(regions);
			List<ITextReplacement> replacements = fmt.format(request);
			return replacements;
		}
	}

	protected IFormatter2 getFormatter() {
		if (formatter != null) {
			return formatter.get();
		}
		return nullFormatter.get();
	}

	protected List<ITextReplacement> mergeReplacements(ITextRegionAccessDiff regions, List<ITextReplacement> rep) {
		ITextRegionRewriter rewriter = regions.getOriginalTextRegionAccess().getRewriter();
		List<ITextReplacement> result = Lists.newArrayList();
		for (ITextSegmentDiff r : regions.getRegionDifferences()) {
			ITextSegment original = r.getOriginalRegion();
			ITextSegment modified = r.getModifiedRegion();
			List<ITextReplacement> local = Lists.newArrayList();
			for (ITextReplacement re : rep) {
				if (modified.contains(re)) {
					local.add(re);
				}
			}
			String text;
			if (local.isEmpty()) {
				text = modified.getText();
			} else {
				text = regions.getRewriter().renderToString(modified, local);
			}
			ITextReplacement replacement = rewriter.createReplacement(original.getOffset(), original.getLength(), text);
			result.add(replacement);
		}
		return result;
	}

}
