package org.xpect.xtext.lib.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
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
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;
import org.xpect.expectation.IStringDiffExpectation.IToken;
import org.xpect.text.StringEndsSimilarityFunction;
import org.xpect.text.WhitespaceTokenizer;
import org.xpect.util.IDifferencer.ISimilarityFunction;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
public class TokenSerializer {

	public static class Acceptor implements FormattingSequenceAcceptor.IAcceptor {

		private boolean excluding = false;

		private final List<Token> tokens = new TokenList();

		public void accept(EObject semanticElement, EObject grammarElement, String token, boolean hidden) {
			if (token.contains("XPECT")) {
				excluding = true;
				return;
			}
			if (hidden) {
				if (excluding)
					return;
			} else {
				excluding = false;
			}
			boolean ignored = hidden;
			for (int i = 0; hidden && i < token.length(); i++)
				if (!Character.isWhitespace(token.charAt(i)))
					ignored = false;
			Iterable<String> segments;
			if (grammarElement instanceof Keyword) {
				segments = Collections.singletonList(token);
			} else {
				segments = new WhitespaceTokenizer().apply(token);
			}
			tokens.add(new Token(semanticElement, segments, ignored, new StringEndsSimilarityFunction()));
		}
	}

	public static class Token implements IToken<Token> {
		private final boolean hidden;
		private final Object owner;
		private final Iterable<String> segments;
		private final ISimilarityFunction<String> similarityFunction;

		public Token(Object owner, Iterable<String> segments, boolean hidden, ISimilarityFunction<String> similarityFunction) {
			super();
			this.owner = owner;
			this.segments = segments;
			this.hidden = hidden;
			this.similarityFunction = similarityFunction;
		}

		public boolean isHidden(String segment) {
			return hidden;
		}

		public float similarity(String ownSegment, Token otherToken, String otherSegment) {
			if (owner != otherToken.owner)
				return ISimilarityFunction.UPPER_SIMILARITY_BOUND;
			return similarityFunction.similarity(ownSegment, otherSegment);
		}

		public Iterable<String> splitIntoSegments() {
			return segments;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("segments", Lists.newArrayList(segments)).add("hidden", hidden).add("owner", owner).toString();
		}

	}

	@SuppressWarnings("serial")
	public static class TokenList extends ArrayList<Token> {
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			for (Token t : this)
				for (String segment : t.splitIntoSegments())
					result.append(segment);
			return result.toString();
		}
	}

	@Inject
	protected IContextFinder contextFinder;

	@Inject
	protected IFormatter formatter;

	@Inject
	protected IGrammarAccess grammar;

	@Inject
	protected Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	protected Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	protected Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	protected IConcreteSyntaxValidator validator;

	protected EObject getContext(EObject semanticObject) {
		Iterator<EObject> contexts = contextFinder.findContextsByContentsAndContainer(semanticObject, null).iterator();
		if (!contexts.hasNext())
			throw new RuntimeException("No Context for " + EmfFormatter.objPath(semanticObject) + " could be found");
		return contexts.next();
	}

	public Iterable<ILeafNode> getParsedLeafNodes(XtextResource resource) {
		return resource.getParseResult().getRootNode().getLeafNodes();
	}

	public List<Token> serialize(EObject obj) {
		return serialize(obj, SaveOptions.defaultOptions());
	}

	protected void serialize(EObject semanticObject, EObject context, ISequenceAcceptor tokens, ISerializationDiagnostic.Acceptor errors) {
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

	public List<Token> serialize(EObject obj, SaveOptions options) {
		Acceptor tokenStream = new Acceptor();
		ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
		FormattingSequenceAcceptor formatterAcceptor = new FormattingSequenceAcceptor(obj, formatter, errors, !options.isFormatting(), tokenStream);
		// ITokenStream formatterTokenStream;
		// if (formatter instanceof IFormatterExtension)
		// formatterTokenStream = ((IFormatterExtension) formatter).createFormatterStream(obj, null, tokenStream, !options.isFormatting());
		// else
		// formatterTokenStream = formatter.createFormatterStream(null, tokenStream, !options.isFormatting());
		EObject context = getContext(obj);
		// ISequenceAcceptor acceptor = new TokenStreamSequenceAdapter(formatterTokenStream, errors);
		serialize(obj, context, formatterAcceptor, errors);
		formatterAcceptor.flush();
		return tokenStream.tokens;
	}

}
