/*******************************************************************************
 * Copyright (c) 2011, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import static com.google.common.base.Preconditions.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.IFormatterExtension;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.parsetree.reconstr.impl.WriterTokenStream;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.TokenStreamSequenceAdapter;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;

import com.google.common.base.CharMatcher;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Serializer implements ISerializer {

	@Override
	public String serialize(EObject obj) {
		checkNotNull(obj, "obj must not be null.");
		return serialize(obj, SaveOptions.defaultOptions());
	}

	@Inject(optional = true)
	protected IFormatter formatter;

	@Inject(optional = true)
	private Provider<IFormatter2> formatter2Provider;

	@Inject
	private Provider<FormatterRequest> formatterRequestProvider;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionBuilderProvider;

	@Inject
	protected Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	protected Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	protected Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	protected IGrammarAccess grammar;

	@Inject
	protected IContextFinder contextFinder;

	@Inject
	protected IConcreteSyntaxValidator validator;

	/**
	 * @deprecated use {@link #serialize(ISerializationContext, EObject, ISequenceAcceptor, ISerializationDiagnostic.Acceptor)}
	 */
	@Deprecated
	protected void serialize(EObject semanticObject, EObject context, ISequenceAcceptor tokens,
			ISerializationDiagnostic.Acceptor errors) {
		ISemanticSequencer semantic = semanticSequencerProvider.get();
		ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
		IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
		semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
		syntactic.init(context, semanticObject, (ISyntacticSequenceAcceptor) hidden, errors);
		hidden.init(context, semanticObject, tokens, errors);
		if (tokens instanceof TokenStreamSequenceAdapter)
			((TokenStreamSequenceAdapter) tokens).init(context);
		semantic.createSequence(context, semanticObject);
	}

	protected void serialize(ISerializationContext context, EObject semanticObject, ISequenceAcceptor tokens,
			ISerializationDiagnostic.Acceptor errors) {
		ISemanticSequencer semantic = semanticSequencerProvider.get();
		ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
		IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
		semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
		syntactic.init(context, semanticObject, (ISyntacticSequenceAcceptor) hidden, errors);
		hidden.init(context, semanticObject, tokens, errors);
		if (tokens instanceof TokenStreamSequenceAdapter)
			((TokenStreamSequenceAdapter) tokens).init(context);
		semantic.createSequence(context, semanticObject);
	}

	protected void serialize(EObject obj, ITokenStream tokenStream, SaveOptions options) throws IOException {
		ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
		ITokenStream formatterTokenStream;
		if (formatter instanceof IFormatterExtension)
			formatterTokenStream = ((IFormatterExtension) formatter).createFormatterStream(obj, null, tokenStream,
					!options.isFormatting());
		else
			formatterTokenStream = formatter.createFormatterStream(null, tokenStream, !options.isFormatting());
		ISerializationContext context = getIContext(obj);
		ISequenceAcceptor acceptor = new TokenStreamSequenceAdapter(formatterTokenStream, grammar.getGrammar(), errors);
		serialize(context, obj, acceptor, errors);
		formatterTokenStream.flush();
	}

	public ITextRegionAccess serializeToRegions(EObject obj) {
		checkNotNull(obj, "obj must not be null.");
		ISerializationContext context = getIContext(obj);
		TextRegionAccessBuilder builder = textRegionBuilderProvider.get();
		ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
		serialize(context, obj, builder.forSequence(context, obj), errors);
		ITextRegionAccess regionAccess = builder.create();
		return regionAccess;
	}

	protected void serialize(EObject obj, Appendable appendable, SaveOptions options) throws IOException {
		ITextRegionAccess regionAccess = serializeToRegions(obj);
		FormatterRequest request = formatterRequestProvider.get();
		request.setFormatUndefinedHiddenRegionsOnly(!options.isFormatting());
		request.setTextRegionAccess(regionAccess);
		IFormatter2 formatter2 = formatter2Provider.get();
		List<ITextReplacement> replacements = formatter2.format(request);
		regionAccess.getRewriter().renderToAppendable(replacements, appendable);
	}

	/**
	 * @deprecated use {@link #getIContext(EObject)}
	 */
	@Deprecated
	protected EObject getContext(EObject semanticObject) {
		Iterator<EObject> contexts = contextFinder.findContextsByContentsAndContainer(semanticObject, null).iterator();
		if (!contexts.hasNext())
			throw new RuntimeException("No Context for " + EmfFormatter.objPath(semanticObject) + " could be found");
		return contexts.next();
	}

	protected ISerializationContext getIContext(EObject semanticObject) {
		Iterator<ISerializationContext> contexts = contextFinder.findByContentsAndContainer(semanticObject, null).iterator();
		if (!contexts.hasNext())
			throw new RuntimeException("No Context for " + EmfFormatter.objPath(semanticObject) + " could be found");
		return contexts.next();
	}

	@Override
	public String serialize(EObject obj, SaveOptions options) {
		checkNotNull(obj, "obj must not be null.");
		checkNotNull(options, "options must not be null.");
		try {
			if (formatter2Provider != null) {
				StringBuilder builder = new StringBuilder();
				serialize(obj, builder, options);
				return builder.toString();
			} else {
				TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
				serialize(obj, tokenStringBuffer, options);
				return tokenStringBuffer.toString();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void serialize(EObject obj, Writer writer, SaveOptions options) throws IOException {
		checkNotNull(obj, "obj must not be null.");
		checkNotNull(writer, "writer must not be null.");
		checkNotNull(options, "options must not be null.");
		if (formatter2Provider != null) {
			serialize(obj, (Appendable) writer, options);
			writer.flush();
		} else {
			serialize(obj, new WriterTokenStream(writer), options);
		}
	}

	@Override
	public ReplaceRegion serializeReplacement(EObject obj, SaveOptions options) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		if (node == null) {
			throw new IllegalStateException("Cannot replace an obj that has no associated node");
		}
		String text = serialize(obj, options);
		int replaceRegionLength = calculateReplaceRegionLength(node, text);
		return new ReplaceRegion(node.getTotalOffset(), replaceRegionLength, text);
	}

	/**
	 * @since 2.22
	 */
	protected int calculateReplaceRegionLength(ICompositeNode node, String text) {
		int oldTextLength = node.getTotalLength();
		int newTextLength = text.length();

		if (newTextLength > oldTextLength) {
			String remainingText = text.substring(oldTextLength);
			if (isWhitespace(remainingText) && hiddenNodeFollows(node)) {
				return newTextLength;
			}
		}
		return oldTextLength;
	}

	/**
	 * @since 2.22
	 */
	protected boolean hiddenNodeFollows(ICompositeNode node) {
		INode followingNode = getFollowingNode(node);
		if (followingNode instanceof ILeafNode) {
			return ((ILeafNode)followingNode).isHidden();
		}
		return false;
	}
	
	/**
	 * Returns the node that follows the <i>node</i>, independently, if they have the same parent.
	 * @since 2.22
	 */
	protected INode getFollowingNode(ICompositeNode node) {
		if (node != null) {
			if (node.hasNextSibling()) {
				INode nextSibling = node.getNextSibling();
				Iterator<ILeafNode> nextSiblingLeafNodes = nextSibling.getLeafNodes().iterator();
				if (nextSiblingLeafNodes.hasNext()) {
					return nextSiblingLeafNodes.next();
				} else {
					return getFollowingNode(node.getParent());
				}	
			}
		}
		return null;
	}

	/**
	 * @since 2.22
	 */
	protected boolean isWhitespace(String text) {
		return CharMatcher.whitespace().matchesAllOf(text);
	}
}
