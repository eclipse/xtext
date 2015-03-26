/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.formatter;

import static com.google.common.base.Preconditions.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.ITextReplacement;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.TextReplacements;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.SerializerBasedRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.SerializerBasedRegionAccess.Builder;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.ExceptionThrowingAcceptor;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.util.ExceptionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterTester {

	@Inject
	private IContextFinder contextFinder;

	@Inject(optional = true)
	private Provider<IFormatter2> formatter;

	@Inject
	private Provider<FormatterTestRequest> formatterRequestProvider;

	@Inject
	private Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	private Provider<NodeModelBasedRegionAccess.Builder> nodeModelBasedRegionAccessBuilderProvider;

	@Inject
	private ParseHelper<EObject> parseHelper;

	@Inject
	private Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	private Provider<SerializerBasedRegionAccess.Builder> serializerBasedRegionAccessBuilderProvider;

	@Inject
	private Provider<ISyntacticSequencer> syntacticSequencerProvider;

	protected void assertAllHiddenRegionsAre(ITextRegionAccess expectation, List<ITextReplacement> actual) {
		// TODO implement
	}

	protected ITextRegionAccess createRegionAccess(XtextResource resource, FormatterTestRequest req) {
		boolean useSerializer = req.isUseSerializer() && !req.isAllowSyntaxErrors();
		if (req.isUseNodeModel() && useSerializer) {
			ITextRegionAccess nmRegions = createRegionAccessViaNodeModel(resource);
			ITextRegionAccess serRegions = createRegionAccessViaSerializer(resource);
			Assert.assertEquals(toString(nmRegions), toString(serRegions));
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

	protected String toString(ITextRegionAccess nmRegions) {
		return new TextRegionAccessToString().withOrigin((ITextSegment) nmRegions).hideColumnExplanation() + "\n";
	}

	public void assertFormatted(FormatterTestRequest req) {
		checkNotNull(req);
		checkNotNull(req.getToBeFormatted());

		FormatterRequest request = req.getRequest();
		checkArgument(request.getTextRegionAccess() == null);

		String document = req.getToBeFormatted().toString();
		XtextResource parsed = parse(document);
		if (req.isAllowSyntaxErrors()) {
			request.setExceptionHandler(ExceptionAcceptor.IGNORING);
		} else {
			assertNoSyntaxErrors(parsed);
			request.setExceptionHandler(ExceptionAcceptor.THROWING);
		}
		request.setTextRegionAccess(createRegionAccess(parsed, req));
		if (request.getPreferences() == null)
			request.setPreferences(new MapBasedPreferenceValues(Maps.<String, String> newLinkedHashMap()));
		List<ITextReplacement> format = createFormatter(req).format(request);
		assertReplacementsAreInRegion(format, request.getRegions(), document);
		assertAllHiddenRegionsAre(request.getTextRegionAccess(), format);
		String applied = TextReplacements.apply(document, format);
		Assert.assertEquals(req.getExpectationOrToBeFormatted().toString(), applied);

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

	protected void assertReplacementsAreInRegion(List<ITextReplacement> rep, Collection<ITextRegion> regions, String doc) {
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
		return formatter.get();
	}

	protected ITextRegionAccess createRegionAccessViaNodeModel(XtextResource resource) {
		ITextRegionAccess access = nodeModelBasedRegionAccessBuilderProvider.get().withResource(resource).create();
		return access;
	}

	protected ITextRegionAccess createRegionAccessViaSerializer(XtextResource resource) {
		EObject root = resource.getContents().get(0);
		Builder builder = serializerBasedRegionAccessBuilderProvider.get().withRoot(root);
		ExceptionThrowingAcceptor errors = new ExceptionThrowingAcceptor();
		EObject context = contextFinder.findContextsByContentsAndContainer(root, null).iterator().next();
		ISemanticSequencer semantic = semanticSequencerProvider.get();
		ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
		IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
		semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
		syntactic.init(context, root, (ISyntacticSequenceAcceptor) hidden, errors);
		hidden.init(context, root, builder, errors);
		semantic.createSequence(context, root);
		ITextRegionAccess access = builder.getRegionAccess();
		return access;
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
