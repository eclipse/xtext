
grammar InternalTestLanguage;

@lexer::header {
package org.eclipse.xtext.testlanguages.parser.internal;
}

@parser::header {
package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.internal.TestLanguageTokenTypeResolver;
}

@parser::members {

private IElementFactory factory;
public InternalTestLanguageParser(TokenStream input, IElementFactory factory) {
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
	LexerRule lexerRule = TestLanguageTokenTypeResolver.getLexerRule(node, t.getType());
	if(lexerRule != null) {
		node.setGrammarElement(lexerRule);
	}
}

private CompositeNode currentNode;

private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/TestLanguage").getGrammar();;

}

parse returns [EObject current] : 
    { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
    ruleEntryRule 
    { $current=$ruleEntryRule.current; } 
    EOF 
    { appendTrailingHiddenTokens(currentNode); };



// Rule EntryRule
ruleEntryRule returns [EObject current=null] 
    @init { EObject temp=null; }    :
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_multiFeature=ruleAbstractRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Model");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "multiFeature", lv_multiFeature);    }
)*;


// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] 
    @init { EObject temp=null; }    :
(this_ChoiceRule=ruleChoiceRule
    { 
        $current = $this_ChoiceRule.current; 
    }

    |this_ReducibleRule=ruleReducibleRule
    { 
        $current = $this_ReducibleRule.current; 
    }
);


// Rule ChoiceRule
ruleChoiceRule returns [EObject current=null] 
    @init { EObject temp=null; }    :
(('choice' 

    {
        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_optionalKeyword='optional' 
 
    {
        if ($current==null) {
            $current = factory.create("ChoiceElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "optionalKeyword", true);        createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, currentNode,"optionalKeyword");    }
)?)(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ChoiceElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
));


// Rule ReducibleRule
ruleReducibleRule returns [EObject current=null] 
    @init { EObject temp=null; CompositeNode entryNode = currentNode; }    @after { currentNode = entryNode; }:
(('reducible' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
this_TerminalRule=ruleTerminalRule
    { 
        $current = $this_TerminalRule.current; 
    }
)((
    { 
        temp=factory.create("ReducibleComposite");
        factory.add(temp, "actionFeature",$current);
        $current = temp; 
        temp = null;
        currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode); 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_actionFeature=ruleTerminalRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("ReducibleElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "actionFeature", lv_actionFeature);    }
))?);


// Rule TerminalRule
ruleTerminalRule returns [EObject current=null] 
    @init { EObject temp=null; }    :
(
    lv_stringFeature=RULE_STRING
    { 
    createLeafNode("//@parserRules.4/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"stringFeature"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("TerminalElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "stringFeature", lv_stringFeature);    }
);



RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_INT : ('0'..'9')+;

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


