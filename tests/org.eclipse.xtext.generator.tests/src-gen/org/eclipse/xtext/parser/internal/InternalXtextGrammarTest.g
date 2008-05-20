
grammar InternalXtextGrammarTest;

@lexer::header {
package org.eclipse.xtext.parser.internal;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.internal.XtextGrammarTestTokenTypeResolver;
}

@parser::members {

private IElementFactory factory;
public InternalXtextGrammarTestParser(TokenStream input, IElementFactory factory) {
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
	LexerRule lexerRule = XtextGrammarTestTokenTypeResolver.getLexerRule(node, t.getType());
	if(lexerRule != null) {
		node.setGrammarElement(lexerRule);
	}
}

private CompositeNode currentNode;

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.XtextGrammarTestConstants.getXtextGrammarTestGrammar();



}

parse returns [EObject current] : 
    { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
    ruleGrammar 
    { $current=$ruleGrammar.current; } 
    EOF 
    { appendTrailingHiddenTokens(currentNode); };



// Rule Grammar
ruleGrammar returns [EObject current=null] 
    @init { EObject temp=null; }    :
(((
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "metamodelDeclarations", lv_metamodelDeclarations);    }
)*(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_parserRules=ruleParserRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "parserRules", lv_parserRules);    }
)*)(('lexing' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
':' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_lexerRules=ruleLexerRule 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "lexerRules", lv_lexerRules);    }
)+)?);


// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] 
    @init { EObject temp=null; }    :
(this_LexerRule=ruleLexerRule
    { 
        $current = $this_LexerRule.current; 
    }

    |this_ParserRule=ruleParserRule
    { 
        $current = $this_ParserRule.current; 
    }
);


// Rule AbstractMetamodelDeclaration
ruleAbstractMetamodelDeclaration returns [EObject current=null] 
    @init { EObject temp=null; }    :
(this_GeneratedMetamodel=ruleGeneratedMetamodel
    { 
        $current = $this_GeneratedMetamodel.current; 
    }

    |this_ReferencedMetamodel=ruleReferencedMetamodel
    { 
        $current = $this_ReferencedMetamodel.current; 
    }
);


// Rule GeneratedMetamodel
ruleGeneratedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; }    :
((('generate' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("GeneratedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
))(
    lv_nsURI=RULE_STRING
    { 
    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"nsURI"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("GeneratedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "nsURI", lv_nsURI);    }
))('as' 

    {
        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_alias=RULE_ID
    { 
    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"alias"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("GeneratedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "alias", lv_alias);    }
))?);


// Rule ReferencedMetamodel
ruleReferencedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; }    :
(('import' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_uri=RULE_STRING
    { 
    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"uri"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ReferencedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "uri", lv_uri);    }
))('as' 

    {
        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_alias=RULE_ID
    { 
    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"alias"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ReferencedMetamodel");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "alias", lv_alias);    }
))?);


// Rule LexerRule
ruleLexerRule returns [EObject current=null] 
    @init { EObject temp=null; }    :
((((
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("LexerRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
)('tokentype' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_tokenType=RULE_ID
    { 
    createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"tokenType"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("LexerRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "tokenType", lv_tokenType);    }
))?)':' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_body=RULE_LEXER_BODY
    { 
    createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"body"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("LexerRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "body", lv_body);    }
));


// Rule ParserRule
ruleParserRule returns [EObject current=null] 
    @init { EObject temp=null; }    :
(((((
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("ParserRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
)('returns' 

    {
        createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_type=ruleTypeRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("ParserRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "type", lv_type);    }
))?)':' 

    {
        createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_alternatives=ruleAlternatives 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("ParserRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "alternatives", lv_alternatives);    }
))';' 

    {
        createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);


// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
    @init { EObject temp=null; }    :
(((
    lv_alias=RULE_ID
    { 
    createLeafNode("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"alias"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("TypeRef");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "alias", lv_alias);    }
)'::' 

    {
        createLeafNode("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)?(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("TypeRef");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
));


// Rule Alternatives
ruleAlternatives returns [EObject current=null] 
    @init { EObject temp=null; CompositeNode entryNode = currentNode; }    @after { currentNode = entryNode; }:
(this_Group=ruleGroup
    { 
        $current = $this_Group.current; 
    }
(((
    { 
        temp=factory.create("Alternatives");
        factory.add(temp, "groups",$current);
        $current = temp; 
        temp = null;
        currentNode=createCompositeNode("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode); 
        associateNodeWithAstElement(currentNode, $current); 
    }
)'|' 

    {
        createLeafNode("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_groups=ruleGroup 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("AbstractElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "groups", lv_groups);    }
))*);


// Rule Group
ruleGroup returns [EObject current=null] 
    @init { EObject temp=null; CompositeNode entryNode = currentNode; }    @after { currentNode = entryNode; }:
(this_AbstractToken=ruleAbstractToken
    { 
        $current = $this_AbstractToken.current; 
    }
((
    { 
        temp=factory.create("Group");
        factory.add(temp, "abstractTokens",$current);
        $current = temp; 
        temp = null;
        currentNode=createCompositeNode("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode); 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_abstractTokens=ruleAbstractToken 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("AbstractElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "abstractTokens", lv_abstractTokens);    }
))*);


// Rule AbstractToken
ruleAbstractToken returns [EObject current=null] 
    @init { EObject temp=null; }    :
(((this_Assignment=ruleAssignment
    { 
        $current = $this_Assignment.current; 
    }

    |this_Action=ruleAction
    { 
        $current = $this_Action.current; 
    }
)
    |this_AbstractTerminal=ruleAbstractTerminal
    { 
        $current = $this_AbstractTerminal.current; 
    }
)(
    lv_cardinality=(('?' 

    |'*' 
)
    |'+' 
) 
    {
        if ($current==null) {
            $current = factory.create("AbstractElement");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "cardinality", lv_cardinality);        createLeafNode("//@parserRules.10/@alternatives/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"cardinality");    }
)?);


// Rule Assignment
ruleAssignment returns [EObject current=null] 
    @init { EObject temp=null; }    :
(((
    lv_feature=RULE_ID
    { 
    createLeafNode("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"feature"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Assignment");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "feature", lv_feature);    }
)(
    lv_operator=(('+=' 

    |'=' 
)
    |'?=' 
) 
    {
        if ($current==null) {
            $current = factory.create("Assignment");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "operator", lv_operator);        createLeafNode("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    }
))(
    
    { 
        currentNode=createCompositeNode("//@parserRules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_terminal=ruleAbstractTerminal 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Assignment");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "terminal", lv_terminal);    }
));


// Rule Action
ruleAction returns [EObject current=null] 
    @init { EObject temp=null; }    :
(((('{' 

    {
        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
('current' 

    {
        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
'=' 

    {
        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)?)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_typeName=ruleTypeRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Action");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "typeName", lv_typeName);    }
))((('.' 

    {
        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_feature=RULE_ID
    { 
    createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"feature"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Action");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "feature", lv_feature);    }
))(
    lv_operator=('=' 

    |'+=' 
) 
    {
        if ($current==null) {
            $current = factory.create("Action");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "operator", lv_operator);        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    }
))'current' 

    {
        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
)?)'}' 

    {
        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);


// Rule AbstractTerminal
ruleAbstractTerminal returns [EObject current=null] 
    @init { EObject temp=null; }    :
((this_Keyword=ruleKeyword
    { 
        $current = $this_Keyword.current; 
    }

    |this_RuleCall=ruleRuleCall
    { 
        $current = $this_RuleCall.current; 
    }
)
    |this_ParenthesizedElement=ruleParenthesizedElement
    { 
        $current = $this_ParenthesizedElement.current; 
    }
);


// Rule ParenthesizedElement
ruleParenthesizedElement returns [EObject current=null] 
    @init { EObject temp=null; }    :
(('(' 

    {
        createLeafNode("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
this_Alternatives=ruleAlternatives
    { 
        $current = $this_Alternatives.current; 
    }
)')' 

    {
        createLeafNode("//@parserRules.14/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);


// Rule Keyword
ruleKeyword returns [EObject current=null] 
    @init { EObject temp=null; }    :
(
    lv_value=RULE_STRING
    { 
    createLeafNode("//@parserRules.15/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"value"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Keyword");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "value", lv_value);    }
);


// Rule RuleCall
ruleRuleCall returns [EObject current=null] 
    @init { EObject temp=null; }    :
(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.16/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("RuleCall");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
);



RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


