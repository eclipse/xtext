package org.xpect.xtext.lib.util;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.IFormatterExtension;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
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
import org.xpect.expectation.IStringDiffExpectation.ITokenAdapter;
import org.xpect.text.GenericTokenizer;
import org.xpect.text.StringEndsSimilarityFunction;
import org.xpect.util.IDifferencer.ISimilarityFunction;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction")
public class TokenSerializer {

	public static class Acceptor implements ITokenStream {

		private final List<Token> tokens = Lists.newArrayList();

		public void flush() throws IOException {
		}

		public void writeHidden(EObject grammarElement, String value) throws IOException {
			add(grammarElement, value);
		}

		private void add(EObject grammarElement, String value) {
			if (!value.contains("XPECT")) {
				boolean hidden = true;
				for (int i = 0; hidden && i < value.length(); i++)
					if (!Character.isWhitespace(value.charAt(i)))
						hidden = false;
				tokens.add(new Token(null, grammarElement, value, hidden));
			}
		}

		public void writeSemantic(EObject grammarElement, String value) throws IOException {
			add(grammarElement, value);
		}
	}

	public static class TokenAdapter implements ITokenAdapter<Token> {
		private final ISimilarityFunction<String> similarityFunction;
		private final Function<String, ? extends Iterable<String>> tokenizer;

		public TokenAdapter() {
			this(new GenericTokenizer(), new StringEndsSimilarityFunction());
		}

		public TokenAdapter(Function<String, ? extends Iterable<String>> tokenizer, ISimilarityFunction<String> similarityFunction) {
			super();
			this.tokenizer = tokenizer;
			this.similarityFunction = similarityFunction;
		}

		public boolean isHidden(Token token, String segment) {
			return token.isHidden();
		}

		public float similarity(Token token1, String segment1, Token token2, String segment2) {
			if (token1.getSemanticElement() != token2.getSemanticElement())
				return ISimilarityFunction.UPPER_SIMILARITY_BOUND;
			return similarityFunction.similarity(segment1, segment2);
		}

		public Iterable<String> splitIntoSegments(Token token) {
			if (token.getGrammarElement() instanceof RuleCall)
				tokenizer.apply(token.getText());
			return Collections.singleton(token.getText());
		}
	}

	public static class Token {
		private final EObject grammarElement;
		private final boolean hidden;
		private final EObject semanticElement;
		private final String text;

		public Token(EObject semanticElement, EObject grammarElement, String text, boolean hidden) {
			super();
			this.semanticElement = semanticElement;
			this.grammarElement = grammarElement;
			this.text = text;
			this.hidden = hidden;
		}

		public EObject getGrammarElement() {
			return grammarElement;
		}

		public EObject getSemanticElement() {
			return semanticElement;
		}

		public String getText() {
			return text;
		}

		public boolean isHidden() {
			return hidden;
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

	public List<Token> serialize(EObject obj) {
		return serialize(obj, SaveOptions.defaultOptions());
	}

	public List<Token> serialize(EObject obj, SaveOptions options) {
		try {
			Acceptor tokenStream = new Acceptor();
			ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
			ITokenStream formatterTokenStream;
			if (formatter instanceof IFormatterExtension)
				formatterTokenStream = ((IFormatterExtension) formatter).createFormatterStream(obj, null, tokenStream, !options.isFormatting());
			else
				formatterTokenStream = formatter.createFormatterStream(null, tokenStream, !options.isFormatting());
			EObject context = getContext(obj);
			ISequenceAcceptor acceptor = new TokenStreamSequenceAdapter(formatterTokenStream, errors);
			serialize(obj, context, acceptor, errors);
			formatterTokenStream.flush();
			return tokenStream.tokens;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
