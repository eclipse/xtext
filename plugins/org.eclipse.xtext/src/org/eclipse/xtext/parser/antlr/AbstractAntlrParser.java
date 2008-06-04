package org.eclipse.xtext.parser.antlr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.impl.ParseError;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeAdapterFactory;
import org.eclipse.xtext.parsetree.ParsetreeFactory;

public abstract class AbstractAntlrParser extends Parser {

    protected CompositeNode currentNode;

    protected org.eclipse.xtext.Grammar grammar;

    protected IElementFactory factory;

    protected List<IParseError> parseErrors;

    protected int lastConsumedIndex = -1;

    protected AbstractAntlrParser(TokenStream input) {
        super(input);
    }

    public TokenStream getInput() {
        return input;
    }

    protected CompositeNode getCurrentNode() {
        return currentNode;
    }

    protected void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
        if (node.getElement() != null && node.getElement() != astElement) {
            throw new ParseException(new ParseError(node, "Reassignment of astElement in parse tree node", null));
        }
        node.setElement(astElement);
        if (astElement instanceof EObject) {
            EObject eObject = (EObject) astElement;
            NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
            adapter.setParserNode(node);
        }
    }

    protected Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
        Token token = input.LT(-1);
        if (token.getTokenIndex() > lastConsumedIndex) {
            int indexOfTokenBefore = lastConsumedIndex;
            if (indexOfTokenBefore + 1 < token.getTokenIndex()) {
                for (int x = indexOfTokenBefore + 1; x < token.getTokenIndex(); x++) {
                    Token hidden = input.get(x);
                    LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                    leafNode.setText(hidden.getText());
                    leafNode.setHidden(true);
                    setLexerRule(leafNode, hidden);
                    parentNode.getChildren().add(leafNode);
                }
            }
            LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
            leafNode.setText(token.getText());
            leafNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
            leafNode.setFeature(feature);
            parentNode.getChildren().add(leafNode);
            lastConsumedIndex = token.getTokenIndex();
            return leafNode;
        }
        return null;
    }

    private Map<Integer, String> antlrTypeToLexerName = null;

    public Map<Integer, String> getTokenTypeMap() {
        if (antlrTypeToLexerName == null) {
            try {
                antlrTypeToLexerName = new HashMap<Integer, String>();
                InputStream stream = getClass().getClassLoader().getResourceAsStream(getClass().getName().replace('.', '/') + ".tokens");
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                String line = br.readLine();
                Pattern pattern = Pattern.compile("(.*)=(\\d+)");
                while (line != null) {
                    Matcher m = pattern.matcher(line);
                    if (!m.matches()) {
                        throw new IllegalStateException("Couldn't match line : '" + line + "'");
                    }

                    String tokenTypeId = m.group(2);
                    String token = m.group(1);
                    String prefix = "RULE_";
                    if (token.startsWith(prefix))
                        antlrTypeToLexerName.put(Integer.parseInt(tokenTypeId), token.substring(prefix.length()));
                    line = br.readLine();
                }
                stream.close();
            } catch (IOException e) {
                throw new WrappedException(e);
            }
        }
        return antlrTypeToLexerName;
    }

    protected void setLexerRule(LeafNode leafNode, Token hidden) {
        String ruleName = getTokenTypeMap().get(hidden.getType());
        AbstractRule rule = GrammarUtil.findRuleForName(grammar, ruleName);
        if (!(rule instanceof LexerRule))
            throw new IllegalStateException();
        leafNode.setGrammarElement(rule);
    }

    protected CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
        CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
        if (parentNode != null)
            parentNode.getChildren().add(compositeNode);
        compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
        return compositeNode;
    }

    protected void appendAllTokens() {
        for (int x = lastConsumedIndex + 1; input.size() > x; input.consume(), x++) {
            Token hidden = input.get(x);
            LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
            leafNode.setText(hidden.getText());
            leafNode.setHidden(true);
            setLexerRule(leafNode, hidden);
            currentNode.getChildren().add(leafNode);
        }
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
                LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                leafNode.setText(hidden.getText());
                leafNode.setHidden(true);
                setLexerRule(leafNode, hidden);
                currentNode.getChildren().add(leafNode);
                skipped.add(leafNode);
            }
        }
        if (lastConsumedIndex < currentTokenIndex) {
            LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
            leafNode.setText(currentToken.getText());
            leafNode.setHidden(true);
            setLexerRule(leafNode, currentToken);
            currentNode.getChildren().add(leafNode);
            skipped.add(leafNode);
            lastConsumedIndex = currentToken.getTokenIndex();
        }
        return skipped;
    }

    protected void appendTrailingHiddenTokens(CompositeNode parentNode) {
        Token tokenBefore = input.LT(-1);
        int size = input.size();
        if (tokenBefore != null && tokenBefore.getTokenIndex() < size) {
            for (int x = tokenBefore.getTokenIndex() + 1; x < size; x++) {
                Token hidden = input.get(x);
                LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
                leafNode.setText(hidden.getText());
                leafNode.setHidden(true);
                setLexerRule(leafNode, hidden);
                parentNode.getChildren().add(leafNode);
                lastConsumedIndex = hidden.getTokenIndex();
            }
        }
    }

    protected IParseError createParseError(RecognitionException re) {
        LeafNode ln = null;
        if (currentNode != null) {
            CompositeNode root = (CompositeNode) EcoreUtil.getRootContainer(currentNode);
            List<LeafNode> list = root.getLeafNodes();
            if (list.size() > lastErrorIndex)
                ln = list.get(lastErrorIndex);
        }
        IParseError error = null;
        if (ln == null) {
            CommonToken lt = (CommonToken) input.LT(input.index());
            error = new ParseError(lt.getLine(), lt.getStartIndex(), lt.getText() != null ? lt.getText().length() : 0, lt.getText(),
                    getErrorMessage(re, getTokenNames()), re);
        } else {
            error = new ParseError(ln, getErrorMessage(re, getTokenNames()), re);
        }
        parseErrors.add(error);
        return error;
    }

    protected void reportError(IParseError error, RecognitionException re) {
        reportError(re);
    }

    public final IParseResult parse() throws RecognitionException {
        IParseResult result = null;
        parseErrors = new ArrayList<IParseError>();
        EObject current = null;
        try {
            current = internalParse();
            appendTrailingHiddenTokens(currentNode);
        } finally {
            appendAllTokens();
            result = new ParseResult(current, currentNode, parseErrors);
        }
        return result;
    }

    public abstract EObject internalParse() throws RecognitionException;

}
