/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.formatting;

import java.util.List;

import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextSegment;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Service class for text formatting.
 */
@Singleton
public class FormattingService {
	@Inject(optional = true)
	private INodeModelFormatter formatter1;

	@Inject(optional = true)
	private Provider<IFormatter2> formatter2Provider;

	@Inject
	private Provider<FormatterRequest> formatterRequestProvider;

	@Inject
	private TextRegionAccessBuilder regionBuilder;

	/**
	 * Format the given document. This operation modifies the document content and
	 * returns the
	 */
	public FormattingResult format(XtextWebDocumentAccess document, ITextRegion selection,
			ITypedPreferenceValues preferences) throws InvalidRequestException {
		Wrapper<String> textWrapper = new Wrapper<String>();
		Wrapper<TextRegion> regionWrapper = new Wrapper<TextRegion>();
		CancelableUnitOfWork<FormattingResult, IXtextWebDocument> work = new CancelableUnitOfWork<FormattingResult, IXtextWebDocument>() {
			@Override
			public FormattingResult exec(IXtextWebDocument doc, CancelIndicator cancelIndicator)
					throws Exception {
				if (formatter2Provider != null) {
					textWrapper.set(format2(doc.getResource(), selection, preferences));
					if (selection != null) {
						regionWrapper.set(new TextRegion(selection.getOffset(), selection.getLength()));
					}
				} else {
					if (formatter1 != null) {
						INodeModelFormatter.IFormattedRegion formattedRegion = format1(doc.getResource(), selection);
						textWrapper.set(formattedRegion.getFormattedText());
						regionWrapper.set(new TextRegion(formattedRegion.getOffset(), formattedRegion.getLength()));
					} else {
						throw new IllegalStateException("No formatter is available in the language configuration.");
					}
				}
				doc.setDirty(true);
				doc.createNewStateId();
				return new FormattingResult(doc.getStateId(), textWrapper.get(), regionWrapper.get());
			}
		};
		CancelableUnitOfWork<Object, IXtextWebDocument> asynchronousWork = new CancelableUnitOfWork<Object, IXtextWebDocument>() {
			@Override
			public Object exec(IXtextWebDocument it, CancelIndicator cancelIndicator) throws Exception {
				if (regionWrapper.isEmpty()) {
					it.setText(textWrapper.get());
				} else {
					it.updateText(textWrapper.get(), regionWrapper.get().getOffset(), regionWrapper.get().getLength());
				}
				return null;
			}
		};
		return document.modify(work, asynchronousWork);
	}

	protected INodeModelFormatter.IFormattedRegion format1(XtextResource resource, ITextRegion selection) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null) {
			return null;
		}
		ICompositeNode rootNode = parseResult.getRootNode();
		ITextRegion region = selection;
		if (region == null) {
			region = new TextRegion(rootNode.getOffset(), rootNode.getLength());
		}
		return formatter1.format(rootNode, region.getOffset(), region.getLength());
	}

	protected String format2(XtextResource resource, ITextRegion selection, ITypedPreferenceValues preferences) {
		FormatterRequest request = formatterRequestProvider.get();
		request.setAllowIdentityEdits(false);
		request.setFormatUndefinedHiddenRegionsOnly(false);
		if (selection != null) {
			request.setRegions(Lists.newArrayList(selection));
		}
		if (preferences != null) {
			request.setPreferences(preferences);
		}
		ITextRegionAccess regionAccess = regionBuilder.forNodeModel(resource).create();
		request.setTextRegionAccess(regionAccess);
		IFormatter2 formatter2 = formatter2Provider.get();
		List<ITextReplacement> replacements = formatter2.format(request);
		if (selection != null) {
			return regionAccess.getRewriter().renderToString(
					new TextSegment(regionAccess, selection.getOffset(), selection.getLength()), replacements);
		} else {
			return regionAccess.getRewriter().renderToString(replacements);
		}
	}
}
