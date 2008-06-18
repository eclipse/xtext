
/*
Generated with Xtext
*/
grammar InternalXtextGrammarTest;

options {
	superClass=AbstractAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.internal;
}

@lexer::members {

  public Token nextToken() {
        while (true) {
            this.token = null;
            this.channel = Token.DEFAULT_CHANNEL;
            this.tokenStartCharIndex = input.index();
            this.tokenStartCharPositionInLine = input.getCharPositionInLine();
            this.tokenStartLine = input.getLine();
            this.text = null;
            if ( input.LA(1)==CharStream.EOF ) {
                return Token.EOF_TOKEN;
            }
            try {
                mTokens();
                if ( this.token==null ) {
                    emit();
                }
                else if ( this.token==Token.SKIP_TOKEN ) {
                    continue;
                }
                return this.token;
            }
            catch (RecognitionException re) {
                reportError(re);
                if ( re instanceof NoViableAltException ) { recover(re); }
                                // create token that holds mismatched char
                Token t = new CommonToken(input, Token.INVALID_TOKEN_TYPE,
                                          Token.HIDDEN_CHANNEL,
                                          this.tokenStartCharIndex,
                                          getCharIndex()-1);
                t.setLine(this.tokenStartLine);
                t.setCharPositionInLine(this.tokenStartCharPositionInLine);
                emit(t);
                return this.token;
            }
        }
    }
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
}

@parser::members {
 
    public InternalXtextGrammarTestParser(TokenStream input, IElementFactory factory, Grammar g) {
        this(input);
        this.factory = factory;
		grammar = g;
    }
    
    protected InputStream getTokenFile() {
    	ClassLoader classLoader = InternalXtextGrammarTestParser.class.getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.tokens");
    }
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
        IParseError error = createParseError(re);
        reportError(error, re);
    } 
}

internalParse returns [EObject current=null] :
	 { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
	 iv_ruleGrammar=ruleGrammar 
	 { $current=$iv_ruleGrammar.current; } 
	 EOF 
;


// Rule Grammar
ruleGrammar returns [EObject current=null] 
    @init { EObject temp=null; }:
((((((((
    lv_abstract='abstract language' 
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "abstract", true,"abstract language");        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, currentNode,"abstract");    }
)
    |'language' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, currentNode,null); 
    }
)(
    lv_idElements=RULE_ID
    { 
    createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"idElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "idElements", lv_idElements,"ID");    }
))('.' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_idElements=RULE_ID
    { 
    createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"idElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "idElements", lv_idElements,"ID");    }
))*)(('extends' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_superGrammarIdElements=RULE_ID
    { 
    createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"superGrammarIdElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "superGrammarIdElements", lv_superGrammarIdElements,"ID");    }
))('.' 

    {
        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    lv_superGrammarIdElements=RULE_ID
    { 
    createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"superGrammarIdElements"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "superGrammarIdElements", lv_superGrammarIdElements,"ID");    }
))*)?)?(
    
    { 
        currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Grammar");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "metamodelDeclarations", lv_metamodelDeclarations,null);    }
)*)(
    
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
        factory.add($current, "parserRules", lv_parserRules,null);    }
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
        factory.add($current, "lexerRules", lv_lexerRules,null);    }
)+)?);





// Rule AbstractMetamodelDeclaration
ruleAbstractMetamodelDeclaration returns [EObject current=null] 
    @init { EObject temp=null; }:
(
    { 
        currentNode=createCompositeNode("//@parserRules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_GeneratedMetamodel=ruleGeneratedMetamodel
    { 
        $current = $this_GeneratedMetamodel.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("//@parserRules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ReferencedMetamodel=ruleReferencedMetamodel
    { 
        $current = $this_ReferencedMetamodel.current; 
        currentNode = currentNode.getParent();
    }
);



// Rule GeneratedMetamodel
ruleGeneratedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "name", lv_name,"ID");    }
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
        factory.set($current, "nsURI", lv_nsURI,"STRING");    }
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
        factory.set($current, "alias", lv_alias,"ID");    }
))?);



// Rule ReferencedMetamodel
ruleReferencedMetamodel returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "uri", lv_uri,"STRING");    }
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
        factory.set($current, "alias", lv_alias,"ID");    }
))?);



// Rule LexerRule
ruleLexerRule returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "name", lv_name,"ID");    }
)('returns' 

    {
        createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }
(
    
    { 
        currentNode=createCompositeNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_type=ruleTypeRef 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("LexerRule");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "type", lv_type,null);    }
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
        factory.set($current, "body", lv_body,"LEXER_BODY");    }
));



// Rule ParserRule
ruleParserRule returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "name", lv_name,"ID");    }
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
        factory.set($current, "type", lv_type,null);    }
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
        factory.set($current, "alternatives", lv_alternatives,null);    }
))';' 

    {
        createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);



// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "alias", lv_alias,"ID");    }
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
        factory.set($current, "name", lv_name,"ID");    }
));



// Rule Alternatives
ruleAlternatives returns [EObject current=null] 
    @init { EObject temp=null; }:
(
    { 
        currentNode=createCompositeNode("//@parserRules.8/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Group=ruleGroup
    { 
        $current = $this_Group.current; 
        currentNode = currentNode.getParent();
    }
(((
    { 
        temp=factory.create("Alternatives");
        factory.add(temp, "groups",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    currentNode = newNode; 
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
        factory.add($current, "groups", lv_groups,null);    }
))*);



// Rule Group
ruleGroup returns [EObject current=null] 
    @init { EObject temp=null; }:
(
    { 
        currentNode=createCompositeNode("//@parserRules.9/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractToken=ruleAbstractToken
    { 
        $current = $this_AbstractToken.current; 
        currentNode = currentNode.getParent();
    }
((
    { 
        temp=factory.create("Group");
        factory.add(temp, "abstractTokens",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
    newNode.getChildren().add(currentNode);
    currentNode = newNode; 
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
        factory.add($current, "abstractTokens", lv_abstractTokens,null);    }
))*);



// Rule AbstractToken
ruleAbstractToken returns [EObject current=null] 
    @init { EObject temp=null; }:
(((
    { 
        currentNode=createCompositeNode("//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Assignment=ruleAssignment
    { 
        $current = $this_Assignment.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Action=ruleAction
    { 
        $current = $this_Action.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("//@parserRules.10/@alternatives/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_AbstractTerminal=ruleAbstractTerminal
    { 
        $current = $this_AbstractTerminal.current; 
        currentNode = currentNode.getParent();
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
        factory.set($current, "cardinality", lv_cardinality,null);        createLeafNode("//@parserRules.10/@alternatives/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"cardinality");    }
)?);



// Rule Assignment
ruleAssignment returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "feature", lv_feature,"ID");    }
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
        factory.set($current, "operator", lv_operator,null);        createLeafNode("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    }
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
        factory.set($current, "terminal", lv_terminal,null);    }
));



// Rule Action
ruleAction returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "typeName", lv_typeName,null);    }
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
        factory.set($current, "feature", lv_feature,"ID");    }
))(
    lv_operator=('=' 

    |'+=' 
) 
    {
        if ($current==null) {
            $current = factory.create("Action");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "operator", lv_operator,null);        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    }
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
    @init { EObject temp=null; }:
((
    { 
        currentNode=createCompositeNode("//@parserRules.13/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
    }
    this_Keyword=ruleKeyword
    { 
        $current = $this_Keyword.current; 
        currentNode = currentNode.getParent();
    }

    |
    { 
        currentNode=createCompositeNode("//@parserRules.13/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_RuleCall=ruleRuleCall
    { 
        $current = $this_RuleCall.current; 
        currentNode = currentNode.getParent();
    }
)
    |
    { 
        currentNode=createCompositeNode("//@parserRules.13/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
    }
    this_ParenthesizedElement=ruleParenthesizedElement
    { 
        $current = $this_ParenthesizedElement.current; 
        currentNode = currentNode.getParent();
    }
);



// Rule ParenthesizedElement
ruleParenthesizedElement returns [EObject current=null] 
    @init { EObject temp=null; }:
(('(' 

    {
        createLeafNode("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
    }

    { 
        currentNode=createCompositeNode("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
    }
    this_Alternatives=ruleAlternatives
    { 
        $current = $this_Alternatives.current; 
        currentNode = currentNode.getParent();
    }
)')' 

    {
        createLeafNode("//@parserRules.14/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
    }
);



// Rule Keyword
ruleKeyword returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "value", lv_value,"STRING");    }
);



// Rule RuleCall
ruleRuleCall returns [EObject current=null] 
    @init { EObject temp=null; }:
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
        factory.set($current, "name", lv_name,"ID");    }
);




RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ( ~('\n'|'\r'))* ((options{greedy=true;}:'\r\n' | '\r' | '\n' ))? {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' '.'* '#>';

RULE_ANY_OTHER : .;


