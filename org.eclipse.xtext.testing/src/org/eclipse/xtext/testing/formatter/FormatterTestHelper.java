/*******************************************************************************
 * Copyright (c) 2014, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.formatter;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegions;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.ExceptionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterTestHelper {

	@Inject(optional = true)
	private Provider<IFormatter2> formatter;

	@Inject
	private Provider<FormatterTestRequest> formatterRequestProvider;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionBuilderProvider;

	@Inject
	private ParseHelper<EObject> parseHelper;

	@Inject
	private Serializer serializer;

	protected void assertAllWhitespaceIsFormatted(ITextRegionAccess access, List<ITextReplacement> replacements) {
		List<ITextSegment> expected = Lists.newArrayList();
		IHiddenRegion current = access.regionForRootEObject().getPreviousHiddenRegion();
		while (current != null) {
			expected.addAll(current.getMergedSpaces());
			current = current.getNextHiddenRegion();
		}
		List<ITextSegment> missing = TextRegions.difference(expected, replacements);
		if (!missing.isEmpty()) {
			TextRegionsToString toString = new TextRegionsToString().setTextRegionAccess(access);
			for (ITextSegment region : missing)
				toString.add(region, region.getClass().getSimpleName());
			String msg = "The following regions are not formatted:\n" + toString;
			System.err.println(msg);
			Assert.fail(msg);
		}
	}

	public void assertFormatted(FormatterTestRequest req) {
		checkNotNull(req);
		checkNotNull(req.getToBeFormatted());

		FormatterRequest request = req.getRequest();
		checkArgument(request.getTextRegionAccess() == null);

		String document = req.getToBeFormatted().toString();
		XtextResource parsed = parse(document);
		if (req.isAllowSyntaxErrors()) {
			if (request.getExplicitExceptionHandler() == null) {
				request.setExceptionHandler(ExceptionAcceptor.IGNORING);
			}
		} else {
			assertNoSyntaxErrors(parsed);
			if (request.getExplicitExceptionHandler() == null) {
				request.setExceptionHandler(ExceptionAcceptor.THROWING);
			}
		}
		if (!req.isAllowUnformattedWhitespace()) {
			request.setAllowIdentityEdits(true);
		}
		request.setTextRegionAccess(createRegionAccess(parsed, req));
		if (request.getPreferences() == null)
			request.setPreferences(new MapBasedPreferenceValues(Maps.<String, String> newLinkedHashMap()));
		List<ITextReplacement> replacements = createFormatter(req).format(request);
		assertReplacementsAreInRegion(replacements, request.getRegions(), document);
		if (!req.isAllowUnformattedWhitespace()) {
			assertAllWhitespaceIsFormatted(request.getTextRegionAccess(), replacements);
		}
		String formatted = request.getTextRegionAccess().getRewriter().renderToString(replacements);

		Assert.assertEquals(req.getExpectationOrToBeFormatted().toString(), formatted);

		// TODO: assert formatting a second time only produces identity replacements
		// TODO: assert formatting with undefined whitespace only
	}

	public void assertFormatted(Procedure1<FormatterTestRequest> init) {
		FormatterTestRequest request = formatterRequestProvider.get();
		init.apply(request);
		assertFormatted(request);
	}

	protected void assertNoSyntaxErrors(XtextResource resource) {
		Iterable<INode> syntaxErrors = resource.getParseResult().getSyntaxErrors();
		if (!Iterables.isEmpty(syntaxErrors)) {
			StringBuilder builder = new StringBuilder();
			builder.append("This document can't be formatted because of syntax errors:\n");
			for (INode node : syntaxErrors) {
				SyntaxErrorMessage msg = node.getSyntaxErrorMessage();
				builder.append(String.format("Line %02d: %s\n", node.getTotalStartLine(), msg.getMessage()));
			}
			fail(builder, resource.getParseResult().getRootNode().getText());
		}
	}

	protected void assertReplacementsAreInRegion(List<ITextReplacement> rep, Collection<ITextRegion> regions,
			String doc) {
		Set<ITextReplacement> invalid = Sets.newHashSet();
		ALLOWED: for (ITextRegion allowed : regions)
			for (ITextReplacement r : rep) {
				if (allowed.contains(r))
					continue ALLOWED;
				invalid.add(r);
			}
		if (!invalid.isEmpty()) {
			String visualized = new TextRegionsToString().addAllReplacements(invalid).toString();
			fail("One or more TextReplacements are outside of the allowed region. Region: " + regions, visualized);
		}
	}

	protected IFormatter2 createFormatter(FormatterTestRequest request) {
		checkNotNull(formatter, "There is a Guice Binding missing for " + IFormatter2.class.getName());
		return formatter.get();
	}

	protected ITextRegionAccess createRegionAccess(XtextResource resource, FormatterTestRequest req) {
		boolean useSerializer = req.isUseSerializer() && !req.isAllowSyntaxErrors();
		if (req.isUseNodeModel() && useSerializer) {
			ITextRegionAccess nmRegions = createRegionAccessViaNodeModel(resource);
			ITextRegionAccess serRegions = createRegionAccessViaSerializer(resource);
			String nmString = toString(nmRegions);
			String serString = toString(serRegions);
			Assert.assertEquals(nmString, serString);
			return nmRegions;
		} else if (req.isUseNodeModel()) {
			ITextRegionAccess nmRegions = createRegionAccessViaNodeModel(resource);
			return nmRegions;
		} else if (useSerializer) {
			ITextRegionAccess serRegions = createRegionAccessViaSerializer(resource);
			return serRegions;
		} else
			throw new IllegalStateException("Can't format anything when using neither NodeModel nor Serializer.");
	}

	protected ITextRegionAccess createRegionAccessViaNodeModel(XtextResource resource) {
		ITextRegionAccess access = textRegionBuilderProvider.get().forNodeModel(resource).create();
		return access;
	}

	protected ITextRegionAccess createRegionAccessViaSerializer(XtextResource resource) {
		EObject root = resource.getContents().get(0);
		ITextRegionAccess regionAccess = serializer.serializeToRegions(root);
		return regionAccess;
	}

	protected void fail(CharSequence error, CharSequence document) {
		StringBuilder builder = new StringBuilder(Strings.trimTrailingLineBreak(error));
		if (document != null) {
			builder.append("\n----------------------------------------------------------\n");
			builder.append(Strings.trimTrailingLineBreak(document));
			builder.append("\n----------------------------------------------------------");
		}
		String msg = builder.toString();
		System.err.println(msg);
		Assert.fail(msg);
	}

	protected XtextResource parse(String document) {
		try {
			return (XtextResource) parseHelper.parse(document).eResource();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String toString(ITextRegionAccess nmRegions) {
		return new TextRegionAccessToString().withRegionAccess(nmRegions).hideColumnExplanation() + "\n";
	}
}
