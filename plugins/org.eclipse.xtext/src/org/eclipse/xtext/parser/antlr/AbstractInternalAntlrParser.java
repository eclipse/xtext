/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider.IParserErrorContext;
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider.IValueConverterErrorContext;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeAdapterFactory;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

/**
 * TODO Javadoc
 */
public abstract class AbstractInternalAntlrParser extends Parser {

	protected class ErrorContext {
		public EObject getCurrentContext() {
			if (currentNode != null)
				return NodeUtil.getNearestSemanticObject(currentNode);
			return null;
		}
		
		public AbstractNode getCurrentNode() {
			return currentNode;
		}	
	}
	
	protected class ParserErrorContext extends ErrorContext implements IParserErrorContext {

		private final RecognitionException recognitionException;

		protected ParserErrorContext(RecognitionException recognitionException) {
			this.recognitionException = recognitionException;
		}
		
		public String getDefaultMessage() {
			return superGetErrorMessage(getRecognitionException(), getTokenNames());
		}

		public RecognitionException getRecognitionException() {
			return recognitionException;
		}

		public String[] getTokenNames() {
			return readableTokenNames;
		}

	}
	
	protected class ValueConverterErrorContext extends ErrorContext implements IValueConverterErrorContext {

		private final ValueConverterException valueConverterException;

		protected ValueConverterErrorContext(ValueConverterException valueConverterException) {
			this.valueConverterException = valueConverterException;
		}

		public String getDefaultMessage() {
			return getValueConverterExceptionMessage(getValueConverterException());
		}

		public ValueConverterException getValueConverterException() {
			return valueConverterException;
		}

	}
	
	private final Logger logger = Logger.getLogger(AbstractInternalAntlrParser.class);
	
	protected CompositeNode currentNode;

	protected IAstFactory factory;
	
	protected int lastConsumedIndex = -1;

	protected AbstractNode lastConsumedNode;

	private final Map<String, AbstractRule> allRules;
	
	private ISyntaxErrorMessageProvider syntaxErrorProvider;
	
	private IUnorderedGroupHelper unorderedGroupHelper;
	
	private final ListMultimap<Token, CompositeNode> deferredLookaheadMap = Multimaps.newArrayListMultimap();
	private final Map<Token, LeafNode> token2NodeMap = new HashMap<Token, LeafNode>();

	protected AbstractInternalAntlrParser(TokenStream input) {
		super(input);
		allRules = new HashMap<String, AbstractRule>();
	}

	protected void registerRules(Grammar grammar) {
		for (AbstractRule rule: GrammarUtil.allRules(grammar)) {
			allRules.put(rule.getName(), rule);
		}
	}

	public TokenStream getInput() {
		return input;
	}

	protected CompositeNode getCurrentNode() {
		return currentNode;
	}

	protected void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
		if (astElement == null)
			throw new NullPointerException("passed astElement was null");
		if (node == null)
			throw new NullPointerException("passed node was null");
		if (node.getElement() != null && node.getElement() != astElement) {
			throw new ParseException("Reassignment of astElement in parse tree node");
		}
		if (node.getElement() != astElement) {
			node.setElement(astElement);
			NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(astElement, AbstractNode.class);
			adapter.setParserNode(node);
		}
	}

	protected Object createLeafNode(EObject grammarElement, String feature) {
		Token token = input.LT(-1);
		if (token != null && token.getTokenIndex() > lastConsumedIndex) {
			int indexOfTokenBefore = lastConsumedIndex;
			if (indexOfTokenBefore + 1 < token.getTokenIndex()) {
				for (int x = indexOfTokenBefore + 1; x < token.getTokenIndex(); x++) {
					Token hidden = input.get(x);
					LeafNode leafNode = createLeafNode(hidden, hidden.getChannel() == HIDDEN);
					setLexerRule(leafNode, hidden);
				}
			}
			LeafNode leafNode = createLeafNode(token, false);
			leafNode.setGrammarElement(grammarElement);
			leafNode.setFeature(feature);
			lastConsumedIndex = token.getTokenIndex();
			lastConsumedNode = leafNode;
			tokenConsumed(token, leafNode);
			return leafNode;
		}
		return null;
	}

	private Map<Integer, String> antlrTypeToLexerName = null;
	
	private String[] readableTokenNames = null;

	public void setTokenTypeMap(Map<Integer, String> tokenTypeMap) {
		antlrTypeToLexerName = new HashMap<Integer, String>();
		for(Entry<Integer, String> mapEntry: tokenTypeMap.entrySet()) {
			String value = mapEntry.getValue();
			if(TokenTool.isLexerRule(value)) {
				antlrTypeToLexerName.put(mapEntry.getKey(), TokenTool.getLexerRuleName(value));
			}
		}
		String[] tokenNames = getTokenNames();
		readableTokenNames = new String[tokenNames.length];
		for(int i = 0; i < tokenNames.length; i++) {
			if (tokenTypeMap.containsKey(i)) {
				readableTokenNames[i] = tokenTypeMap.get(i);
			} else {
				readableTokenNames[i] = tokenNames[i];
			}
		}
	}
	
	protected void setLexerRule(LeafNode leafNode, Token hidden) {
		String ruleName = antlrTypeToLexerName.get(hidden.getType());
		AbstractRule rule = allRules.get(ruleName);
		if (rule != null)
			leafNode.setGrammarElement(rule);
	}
	
	public void setSyntaxErrorProvider(ISyntaxErrorMessageProvider syntaxErrorProvider) {
		this.syntaxErrorProvider = syntaxErrorProvider;
	}
	
	public ISyntaxErrorMessageProvider getSyntaxErrorProvider() {
		return syntaxErrorProvider;
	}

	protected void set(EObject _this, String feature, Object value, String lexerRule, AbstractNode node) throws ValueConverterException {
		factory.set(_this, feature, value, lexerRule, node);
	}

	protected void add(EObject _this, String feature, Object value, String lexerRule, AbstractNode node) throws ValueConverterException {
		factory.add(_this, feature, value, lexerRule, node);
	}
	
	protected CompositeNode createCompositeNode(EObject grammarElement, CompositeNode parentNode) {
		CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
		if (parentNode != null)
			parentNode.getChildren().add(compositeNode);
		compositeNode.setGrammarElement(grammarElement);
		return compositeNode;
	}

	private void appendError(AbstractNode node) {
		if (currentError != null) {
			SyntaxError error = ParsetreeFactory.eINSTANCE.createSyntaxError();
			error.setMessage(currentError.getMessage());
			error.setIssueCode(currentError.getIssueCode());
			node.setSyntaxError(error);
			currentError = null;
		}
	}

	private LeafNode createLeafNode(Token token, boolean isHidden) {
		LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
		leafNode.setText(token.getText());
		leafNode.setHidden(isHidden);
		if (isSemanticChannel(token))
			appendError(leafNode);
		if (token.getType() == Token.INVALID_TOKEN_TYPE) {
			SyntaxError error = ParsetreeFactory.eINSTANCE.createSyntaxError();
			String lexerErrorMessage = ((XtextTokenStream) input).getLexerErrorMessage(token);
			error.setMessage(lexerErrorMessage);
			leafNode.setSyntaxError(error);
		}
		currentNode.getChildren().add(leafNode);
		return leafNode;
	}

	protected void appendAllTokens() {
		for (int x = lastConsumedIndex + 1; input.size() > x; input.consume(), x++) {
			Token hidden = input.get(x);
			LeafNode leafNode = createLeafNode(hidden, hidden.getChannel() == HIDDEN);
			setLexerRule(leafNode, hidden);
		}
		if (currentError != null) {
			EList<LeafNode> leafNodes = currentNode.getLeafNodes();
			if (leafNodes.isEmpty()) {
				appendError(currentNode);
			} else {
				appendError(leafNodes.get(leafNodes.size() - 1));
			}
		}
	}

	private boolean isSemanticChannel(Token hidden) {
		return hidden.getChannel() != HIDDEN;
	}

	protected List<LeafNode> appendSkippedTokens() {
		List<LeafNode> skipped = new ArrayList<LeafNode>();
		Token currentToken = input.LT(-1);
		int currentTokenIndex = (currentToken == null) ? -1 : currentToken.getTokenIndex();
		Token tokenBefore = (lastConsumedIndex == -1) ? null : input.get(lastConsumedIndex);
		int indexOfTokenBefore = tokenBefore != null ? tokenBefore.getTokenIndex() : -1;
		if (indexOfTokenBefore + 1 < currentTokenIndex) {
			for (int x = indexOfTokenBefore + 1; x < currentTokenIndex; x++) {
				Token hidden = input.get(x);
				LeafNode leafNode = createLeafNode(hidden, hidden.getChannel() == HIDDEN);
				setLexerRule(leafNode, hidden);
				skipped.add(leafNode);
			}
		}
		if (lastConsumedIndex < currentTokenIndex && currentToken != null) {
			LeafNode leafNode = createLeafNode(currentToken, currentToken.getChannel() == HIDDEN);
			setLexerRule(leafNode, currentToken);
			skipped.add(leafNode);
			lastConsumedIndex = currentToken.getTokenIndex();
		}
		return skipped;
	}

	protected void appendTrailingHiddenTokens() {
		Token tokenBefore = input.LT(-1);
		int size = input.size();
		if (tokenBefore != null && tokenBefore.getTokenIndex() < size) {
			for (int x = tokenBefore.getTokenIndex() + 1; x < size; x++) {
				Token hidden = input.get(x);
				LeafNode leafNode = createLeafNode(hidden, hidden.getChannel() == HIDDEN);
				setLexerRule(leafNode, hidden);
				lastConsumedIndex = hidden.getTokenIndex();
			}
		}
	}
	
	private SyntaxErrorMessage currentError = null;

	@Override
	public void recover(IntStream input, RecognitionException re) {
		if (currentError == null)
			currentError = getSyntaxErrorMessage(re, getTokenNames());
		super.recover(input, re);
	}
	
	protected String getValueConverterExceptionMessage(ValueConverterException vce) {
		Exception cause = (Exception) vce.getCause();
		String result = cause != null ? cause.getMessage() : vce.getMessage();
		if (result == null)
			result = vce.getMessage();
		if (result == null)
			result = cause != null ? cause.getClass().getSimpleName() : vce.getClass().getSimpleName();
		return result;
	}
	
	protected void handleValueConverterException(ValueConverterException vce) {
		Exception cause = (Exception) vce.getCause();
		if (vce != cause) {
			IValueConverterErrorContext errorContext = createValueConverterErrorContext(vce);
			currentError = syntaxErrorProvider.getSyntaxErrorMessage(errorContext);
			if (vce.getNode() == null) {
				final List<AbstractNode> children = currentNode.getChildren();
				if (children.isEmpty()) {
					appendError(currentNode);
				} else {
					appendError(children.get(children.size() - 1));
				}
			} else {
				appendError(vce.getNode());
			}
		} else {
			throw new RuntimeException(vce);
		}
	}

	protected IValueConverterErrorContext createValueConverterErrorContext(ValueConverterException vce) {
		return new ValueConverterErrorContext(vce);
	}

	@Override
	public void recoverFromMismatchedToken(IntStream in, RecognitionException re, int ttype, BitSet follow)
			throws RecognitionException {
		if (currentError == null)
			currentError = getSyntaxErrorMessage(re, getTokenNames());
		// inlined super call because we want to get rid of the System.err.println(..)
		// System.err.println("BR.recoverFromMismatchedToken");
		// if next token is what we are looking for then "delete" this token
		if ( input.LA(2)==ttype ) {
			reportError(re);
			/*
			System.err.println("recoverFromMismatchedToken deleting "+input.LT(1)+
							   " since "+input.LT(2)+" is what we want");
			*/
			beginResync();
			input.consume(); // simply delete extra token
			endResync();
			input.consume(); // move past ttype token as if all were ok
			return;
		}
		if ( !recoverFromMismatchedElement(input, re,follow) ) {
			throw re;
		}
	}
	
	@Override
	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
		throw new UnsupportedOperationException("getErrorMessage");
	}
	
	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
		throw new UnsupportedOperationException("displayRecognitionError");
	}
	
	@Override
	public void reportError(RecognitionException e) {
		if (errorRecovery) {
			return;
		}
		errorRecovery = true;
	}
	
	public SyntaxErrorMessage getSyntaxErrorMessage(RecognitionException e, String[] tokenNames) {
		IParserErrorContext parseErrorContext = createErrorContext(e);
		return syntaxErrorProvider.getSyntaxErrorMessage(parseErrorContext);
	}
	
	protected String superGetErrorMessage(RecognitionException e, String[] tokenNames) {
		return super.getErrorMessage(e, tokenNames);
	}
	
	protected IParserErrorContext createErrorContext(RecognitionException e) {
		return new ParserErrorContext(e);
	}

	public final IParseResult parse() throws RecognitionException {
		return parse(getFirstRuleName());
	}

	public final IParseResult parse(String entryRuleName) throws RecognitionException {
		IParseResult result = null;
		EObject current = null;
		try {
			String antlrEntryRuleName = normalizeEntryRuleName(entryRuleName);
			try {
				Method method = this.getClass().getMethod(antlrEntryRuleName);
				Object parseResult = method.invoke(this);
				if (parseResult instanceof EObject)
					current = (EObject) parseResult;
			} catch (InvocationTargetException ite) {
				Throwable targetException = ite.getTargetException();
				if (targetException instanceof RecognitionException) {
					throw (RecognitionException) targetException;
				}
				if (targetException instanceof Exception) {
					throw new WrappedException((Exception) targetException);
				}
				throw new RuntimeException(targetException);
			} catch (Exception e) {
				throw new WrappedException(e);
			}
			appendSkippedTokens();
			appendTrailingHiddenTokens();
		} finally {
			try {
				appendAllTokens();
			} finally {
				result = new ParseResult(current, currentNode);
			}
		}
		return result;
	}

	private String normalizeEntryRuleName(String entryRuleName) {
		String antlrEntryRuleName;
		if (!entryRuleName.startsWith("entryRule")) {
			if (!entryRuleName.startsWith("rule")) {
				antlrEntryRuleName = "entryRule" + entryRuleName;
			} else {
				antlrEntryRuleName = "entry" + Strings.toFirstUpper(entryRuleName);
			}
		} else {
			antlrEntryRuleName = entryRuleName;
		}
		return antlrEntryRuleName;
	}

	private void tokenConsumed(Token token, LeafNode leafNode) {
		List<CompositeNode> nodesDecidingOnToken = deferredLookaheadMap.get(token);
		for (CompositeNode nodeDecidingOnToken : nodesDecidingOnToken) {
			nodeDecidingOnToken.getLookaheadLeafNodes().add(leafNode);
		}
		deferredLookaheadMap.removeAll(token);
		token2NodeMap.put(token, leafNode);
	}

	/**
	 * The current lookahead is the number of tokens that have been matched by
	 * the parent rule to decide that the current rule has to be called.
	 *
	 * @return the currentLookahead
	 */
	protected void setCurrentLookahead() {
		XtextTokenStream xtextTokenStream = (XtextTokenStream) input;
		List<Token> lookaheadTokens = xtextTokenStream.getLookaheadTokens();
		for (Token lookaheadToken : lookaheadTokens) {
			LeafNode leafNode = token2NodeMap.get(lookaheadToken);
			if (leafNode == null) {
				deferredLookaheadMap.put(lookaheadToken, currentNode);
			} else {
				currentNode.getLookaheadLeafNodes().add(leafNode);
			}
		}
	}

	/**
	 * Sets the current lookahead to zero. See
	 * {@link AbstractInternalAntlrParser#setCurrentLookahead()}
	 */
	protected void resetLookahead() {
		XtextTokenStream xtextTokenStream = (XtextTokenStream) input;
		xtextTokenStream.resetLookahead();
		token2NodeMap.clear();
	}

	protected void moveLookaheadInfo(CompositeNode source, CompositeNode target) {
		EList<LeafNode> sourceLookaheadLeafNodes = source.getLookaheadLeafNodes();
		target.getLookaheadLeafNodes().addAll(sourceLookaheadLeafNodes);
		sourceLookaheadLeafNodes.clear();

		for (Token deferredLookaheadToken : deferredLookaheadMap.keySet()) {
			List<CompositeNode> nodesDecidingOnToken = deferredLookaheadMap.get(deferredLookaheadToken);
			while (nodesDecidingOnToken.indexOf(source) != -1) {
				nodesDecidingOnToken.set(nodesDecidingOnToken.indexOf(source), target);
			}
		}
	}

	/**
	 * Match is called to consume unambiguous tokens. It calls input.LA() and
	 * therefore increases the currentLookahead. We need to compensate. See
	 * {@link AbstractInternalAntlrParser#setCurrentLookahead()}
	 *
	 * @see org.antlr.runtime.BaseRecognizer#match(org.antlr.runtime.IntStream,
	 *      int, org.antlr.runtime.BitSet)
	 */
	@Override
	public void match(IntStream input, int ttype, BitSet follow) throws RecognitionException {
		XtextTokenStream xtextTokenStream = (XtextTokenStream) input;
		int numLookaheadBeforeMatch = xtextTokenStream.getLookaheadTokens().size();
		super.match(input, ttype, follow);
		if (xtextTokenStream.getLookaheadTokens().size() > numLookaheadBeforeMatch) {
			xtextTokenStream.removeLastLookaheadToken();
		}
	}
	
	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
		if (logger.isTraceEnabled())
			logger.trace(msg);
	}

	protected abstract InputStream getTokenFile();

	/**
	 * @return
	 */
	protected abstract String getFirstRuleName();

	public void setUnorderedGroupHelper(IUnorderedGroupHelper unorderedGroupHelper) {
		this.unorderedGroupHelper = unorderedGroupHelper;
	}

	public IUnorderedGroupHelper getUnorderedGroupHelper() {
		return unorderedGroupHelper;
	}

}
