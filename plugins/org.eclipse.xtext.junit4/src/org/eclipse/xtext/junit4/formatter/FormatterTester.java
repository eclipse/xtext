/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.formatter;

import static com.google.common.base.Preconditions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormatter;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.impl.FormatterRequest;
import org.eclipse.xtext.formatting2.impl.RegionsToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.impl.NodeModelTokenAccess;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.junit.Assert;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterTester {

	@Inject
	private Provider<IFormatter> formatter;

	@Inject
	private Provider<NodeModelTokenAccess.Builder> nodeModelTokenAccessBuilderProvider;

	@Inject
	private ParseHelper<EObject> parseHelper;

	protected void assertAllWhitespaceIsFormatted(ITextRegionAccess expectation, List<ITextReplacement> actual) {
		// TODO implement
	}

	// TODO: factor out
	protected String apply(CharSequence input, Iterable<ITextReplacement> replacements) {
		ArrayList<ITextReplacement> list = Lists.newArrayList(replacements);
		Collections.sort(list);
		int lastOffset = 0;
		StringBuilder result = new StringBuilder();
		for (ITextReplacement r : list) {
			result.append(input.subSequence(lastOffset, r.getOffset()));
			result.append(r.getReplacementText());
			lastOffset = r.getOffset() + r.getLength();
		}
		result.append(input.subSequence(lastOffset, input.length()));
		return result.toString();
	}

	public void assertFormatted(FormatterTestRequest req) {
		checkNotNull(req);
		checkNotNull(req.getToBeFormatted());
		checkArgument(req.getExpectationOnInitialFormat() != null || req.getExpectationOnReformat() != null);

		String document = req.getToBeFormattedDocument();
		XtextResource parsed = parse(document);
		assertNoSyntaxErrors(parsed);
		NodeModelTokenAccess tokenAccess = nodeModelTokenAccessBuilderProvider.get().withResource(parsed).create();
		ITextRegion betweenPreAndPostfix = req.getRegionBetweenPreAndPostfix();
		FormatterRequest request = new FormatterRequest();
		request.setAllowIdentityEdits(true);
		request.addRegion(betweenPreAndPostfix);
		request.setTokens(tokenAccess);
		request.setPreferenceValues(req.getPreferenceValues());
		List<ITextReplacement> format = formatter.get().format(request);
		assertReplacementsAreInRegion(format, betweenPreAndPostfix, document);
		assertAllWhitespaceIsFormatted(tokenAccess, format);
		String applied = apply(document, format);
		String formatted = applied.substring(req.getPrefixLenght(), applied.length() - req.getPostfixLenght());
		Assert.assertEquals(req.getExpectationOnReformat().toString(), formatted);

		// TODO: assert formatting a second time only produces identity replacements
		// TODO: assert formatting with serializer
		// TODO: assert formatting with undefined whitespace only
	}

	public void assertFormatted(Procedures.Procedure1<FormatterTestRequest> init) {
		FormatterTestRequest request = new FormatterTestRequest();
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

	protected void assertReplacementsAreInRegion(List<ITextReplacement> rep, ITextRegion region, String document) {
		int offset = region.getOffset();
		int end = offset + region.getLength();
		Set<ITextReplacement> invalid = Sets.newHashSet();
		for (ITextReplacement r : rep)
			if (r.getOffset() < offset)
				invalid.add(r);
			else if (r.getEndOffset() > end)
				invalid.add(r);
		if (!invalid.isEmpty()) {
			String visualized = new RegionsToString<ITextReplacement>().apply(invalid);
			fail("One or more TextReplacements are outside of the allowed region. Region: " + region, visualized);
		}
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
}
