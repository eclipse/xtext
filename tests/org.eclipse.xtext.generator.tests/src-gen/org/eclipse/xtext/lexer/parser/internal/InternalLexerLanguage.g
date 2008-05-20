
grammar InternalLexerLanguage;

@lexer::header {
package org.eclipse.xtext.lexer.parser.internal;
}

@parser::header {
package org.eclipse.xtext.lexer.parser.internal; 

import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.lexer.parser.internal.LexerLanguageTokenTypeResolver;
}

@parser::members {

private IElementFactory factory;
public InternalLexerLanguageParser(TokenStream input, IElementFactory factory) {
    this(input);
    this.factory = factory;
}

public CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
    CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
    if (parentNode!=null) parentNode.getChildren().add(compositeNode);
    compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
    return compositeNode;
}

public Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
    Token token = input.LT(-1);
    Token tokenBefore = input.LT(-2);
    int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
    if (indexOfTokenBefore+1<token.getTokenIndex()) {
        for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
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
    return leafNode;
}

private void appendTrailingHiddenTokens(CompositeNode parentNode) {
    Token tokenBefore = input.LT(-1);
    int size = input.size();
    if (tokenBefore!=null && tokenBefore.getTokenIndex()<size) {
        for (int x = tokenBefore.getTokenIndex()+1; x<size;x++) {
            Token hidden = input.get(x);
            LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
            leafNode.setText(hidden.getText());
            leafNode.setHidden(true);
            setLexerRule(leafNode, hidden);
            parentNode.getChildren().add(leafNode);
        }
    }
}
    
public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
    if(node.getElement() != null && node.getElement() != astElement) {
        throw new ParseException(node, "Reassignment of astElement in parse tree node");
    }
    node.setElement(astElement);
    if(astElement instanceof EObject) {
        EObject eObject = (EObject) astElement;
        NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
        adapter.setParserNode(node); 
    }
}
    
protected void setLexerRule(LeafNode node, Token t) {
	LexerRule lexerRule = LexerLanguageTokenTypeResolver.getLexerRule(node, t.getType());
	if(lexerRule != null) {
		node.setGrammarElement(lexerRule);
	}
}

private CompositeNode currentNode;

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.lexer.LexerLanguageConstants.getLexerLanguageGrammar();



}

parse returns [EObject current] : 
    { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
    ruleModel 
    { $current=$ruleModel.current; } 
    EOF 
    { appendTrailingHiddenTokens(currentNode); };



// Rule Model
ruleModel returns [EObject current=null] 
    @init { EObject temp=null; }    :
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_children=ruleElement 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Model");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "children", lv_children);    }
)*;


// Rule Element
ruleElement returns [EObject current=null] 
    @init { EObject temp=null; }    :
((((
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Element");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
)(
    lv_f=RULE_EXPLICITTOKENTYPE
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"f"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Element");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "f", lv_f);    }
))(
    lv_g=RULE_IMPLICITTOKENTYPE
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"g"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Element");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "g", lv_g);    }
))(
    lv_h=RULE_STRING
    { 
    createLeafNode("//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"h"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Element");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "h", lv_h);    }
));



RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_IMPLICITTOKENTYPE :  ('C')+ ;

RULE_INT : ('0'..'9')+;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_STRING :  ('B')+ ;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_EXPLICITTOKENTYPE :  ('A')+ ;

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_ANY_OTHER : .;


