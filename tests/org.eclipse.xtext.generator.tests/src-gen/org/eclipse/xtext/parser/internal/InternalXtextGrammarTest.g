
grammar InternalXtextGrammarTest;

@lexer::header {
package org.eclipse.xtext.parser.internal;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;

}

@parser::members {

private IElementFactory factory;
public InternalXtextGrammarTestParser(TokenStream input, IElementFactory factory) {
	this(input);
	this.factory = factory;
}

public CompositeNode createCompositeNode(EObject grammarElement, CompositeNode parentNode) {
	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
	compositeNode.setGrammarElement(grammarElement);
	return compositeNode;
}

public Object createLeafNode(EObject currentGrammarElement, CompositeNode parentNode, String feature) {
	Token token = input.LT(-1);
	Token tokenBefore = input.LT(-2);
	int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
	if (indexOfTokenBefore+1<token.getTokenIndex()) {
		for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
			Token hidden = input.get(x);
			LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
			leafNode.setText(hidden.getText());
			leafNode.setHidden(true);
			parentNode.getChildren().add(leafNode);
		}
	}
	LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
		leafNode.setText(token.getText());
	leafNode.setGrammarElement(currentGrammarElement);
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
			parentNode.getChildren().add(leafNode);
		}
	}
}
	
public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
	assert node.getElement() == null || node.getElement() == astElement;
	node.setElement(astElement);
	if(astElement instanceof EObject) {
		EObject eObject = (EObject) astElement;
		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
		adapter.setParserNode(node); 
	}
}
	
private CompositeNode currentNode;

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.XtextGrammarTestConstants.getXtextGrammarTestGrammar();
}

parse returns [EObject current] : {currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@a0dde2 (name: Grammar)
grammar.eResource().getEObject("//@parserRules.0"), currentNode);}
	ruleGrammar {$current=$ruleGrammar.current;} EOF {appendTrailingHiddenTokens(currentNode);};



// Rule Grammar
ruleGrammar returns [EObject current=null] : { EObject temp=null; }
(((
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@578c79 (cardinality: null) (name: AbstractMetamodelDeclaration)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode);} 
	lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration
 
{ if ($current==null) {
     $current = factory.create("Grammar");
  }
  factory.add($current, "metamodelDeclarations", lv_metamodelDeclarations);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
)*(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@67e563 (cardinality: null) (name: ParserRule)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode);} 
	lv_parserRules=ruleParserRule
 
{ if ($current==null) {
     $current = factory.create("Grammar");
  }
  factory.add($current, "parserRules", lv_parserRules);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
)*)(('lexing' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@1fff2b (cardinality: null) (value: 'lexing')
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }':' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@bfa97b (cardinality: null) (value: ':')
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@17fd27 (cardinality: null) (name: LexerRule)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);} 
	lv_lexerRules=ruleLexerRule
 
{ if ($current==null) {
     $current = factory.create("Grammar");
  }
  factory.add($current, "lexerRules", lv_lexerRules);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
)+)?) ;


// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] : { EObject temp=null; }
(this_LexerRule=ruleLexerRule{$current = $this_LexerRule.current;}
|this_ParserRule=ruleParserRule{$current = $this_ParserRule.current;}
) ;


// Rule AbstractMetamodelDeclaration
ruleAbstractMetamodelDeclaration returns [EObject current=null] : { EObject temp=null; }
(this_GeneratedMetamodel=ruleGeneratedMetamodel{$current = $this_GeneratedMetamodel.current;}
|this_ReferencedMetamodel=ruleReferencedMetamodel{$current = $this_ReferencedMetamodel.current;}
) ;


// Rule GeneratedMetamodel
ruleGeneratedMetamodel returns [EObject current=null] : { EObject temp=null; }
((('generate' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@e7aa15 (cardinality: null) (value: 'generate')
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }(
	
	lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@1b2759 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"name"); }
 
{ if ($current==null) {
     $current = factory.create("GeneratedMetamodel");
  }
  factory.set($current, "name", lv_name);
  
  associateNodeWithAstElement(currentNode, $current); }
))(
	
	lv_nsURI=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@a09c82 (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"nsURI"); }
 
{ if ($current==null) {
     $current = factory.create("GeneratedMetamodel");
  }
  factory.set($current, "nsURI", lv_nsURI);
  
  associateNodeWithAstElement(currentNode, $current); }
))('as' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@4eeb6 (cardinality: null) (value: 'as')
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
	
	lv_alias=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@4d3500 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); }
 
{ if ($current==null) {
     $current = factory.create("GeneratedMetamodel");
  }
  factory.set($current, "alias", lv_alias);
  
  associateNodeWithAstElement(currentNode, $current); }
))?) ;


// Rule ReferencedMetamodel
ruleReferencedMetamodel returns [EObject current=null] : { EObject temp=null; }
(('import' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@4fd0b4 (cardinality: null) (value: 'import')
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }(
	
	lv_uri=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@8dc539 (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"uri"); }
 
{ if ($current==null) {
     $current = factory.create("ReferencedMetamodel");
  }
  factory.set($current, "uri", lv_uri);
  
  associateNodeWithAstElement(currentNode, $current); }
))('as' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@cf00a1 (cardinality: null) (value: 'as')
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
	
	lv_alias=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@d32fef (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); }
 
{ if ($current==null) {
     $current = factory.create("ReferencedMetamodel");
  }
  factory.set($current, "alias", lv_alias);
  
  associateNodeWithAstElement(currentNode, $current); }
))?) ;


// Rule LexerRule
ruleLexerRule returns [EObject current=null] : { EObject temp=null; }
((((
	
	lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@5970bf (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); }
 
{ if ($current==null) {
     $current = factory.create("LexerRule");
  }
  factory.set($current, "name", lv_name);
  
  associateNodeWithAstElement(currentNode, $current); }
)('tokentype' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@6e4ecd (cardinality: null) (value: 'tokentype')
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
	
	lv_tokenType=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@30be8c (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"tokenType"); }
 
{ if ($current==null) {
     $current = factory.create("LexerRule");
  }
  factory.set($current, "tokenType", lv_tokenType);
  
  associateNodeWithAstElement(currentNode, $current); }
))?)':' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@67ca0f (cardinality: null) (value: ':')
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
	
	lv_body=RULE_LEXER_BODY{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@ea4043 (cardinality: null) (name: LEXER_BODY)
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.1/@terminal"), currentNode,"body"); }
 
{ if ($current==null) {
     $current = factory.create("LexerRule");
  }
  factory.set($current, "body", lv_body);
  
  associateNodeWithAstElement(currentNode, $current); }
)) ;


// Rule ParserRule
ruleParserRule returns [EObject current=null] : { EObject temp=null; }
(((((
	
	lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@438ef4 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); }
 
{ if ($current==null) {
     $current = factory.create("ParserRule");
  }
  factory.set($current, "name", lv_name);
  
  associateNodeWithAstElement(currentNode, $current); }
)('returns' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@ccc22d (cardinality: null) (value: 'returns')
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@eac619 (cardinality: null) (name: TypeRef)
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);} 
	lv_type=ruleTypeRef
 
{ if ($current==null) {
     $current = factory.create("ParserRule");
  }
  factory.set($current, "type", lv_type);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
))?)':' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@e852b9 (cardinality: null) (value: ':')
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@59448b (cardinality: null) (name: Alternatives)
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode);} 
	lv_alternatives=ruleAlternatives
 
{ if ($current==null) {
     $current = factory.create("ParserRule");
  }
  factory.set($current, "alternatives", lv_alternatives);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
))';' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@aa6838 (cardinality: null) (value: ';')
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.1"), currentNode,null); }) ;


// Rule TypeRef
ruleTypeRef returns [EObject current=null] : { EObject temp=null; }
(((
	
	lv_alias=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@fbdef7 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"alias"); }
 
{ if ($current==null) {
     $current = factory.create("TypeRef");
  }
  factory.set($current, "alias", lv_alias);
  
  associateNodeWithAstElement(currentNode, $current); }
)'::' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@e9981c (cardinality: null) (value: '::')
grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })?(
	
	lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@16ac04 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.1/@terminal"), currentNode,"name"); }
 
{ if ($current==null) {
     $current = factory.create("TypeRef");
  }
  factory.set($current, "name", lv_name);
  
  associateNodeWithAstElement(currentNode, $current); }
)) ;


// Rule Alternatives
ruleAlternatives returns [EObject current=null] : { EObject temp=null; }
(this_Group=ruleGroup{$current = $this_Group.current;}
(((
{ temp=factory.create("Alternatives");
  factory.add(temp, "groups",$current);
  $current = temp; 
  temp = null;
  associateNodeWithAstElement(currentNode, $current); }
)'|' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@3c4bca (cardinality: null) (value: '|')
grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@e92aef (cardinality: null) (name: Group)
grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);} 
	lv_groups=ruleGroup
 
{ if ($current==null) {
     $current = factory.create("AbstractElement");
  }
  factory.add($current, "groups", lv_groups);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
))*) ;


// Rule Group
ruleGroup returns [EObject current=null] : { EObject temp=null; }
(this_AbstractToken=ruleAbstractToken{$current = $this_AbstractToken.current;}
((
{ temp=factory.create("Group");
  factory.add(temp, "abstractTokens",$current);
  $current = temp; 
  temp = null;
  associateNodeWithAstElement(currentNode, $current); }
)(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@d2b042 (cardinality: null) (name: AbstractToken)
grammar.eResource().getEObject("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode);} 
	lv_abstractTokens=ruleAbstractToken
 
{ if ($current==null) {
     $current = factory.create("AbstractElement");
  }
  factory.add($current, "abstractTokens", lv_abstractTokens);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
))*) ;


// Rule AbstractToken
ruleAbstractToken returns [EObject current=null] : { EObject temp=null; }
(((this_Assignment=ruleAssignment{$current = $this_Assignment.current;}
|this_Action=ruleAction{$current = $this_Action.current;}
)|this_AbstractTerminal=ruleAbstractTerminal{$current = $this_AbstractTerminal.current;}
)(
	
	lv_cardinality=(('?' |'*' )|'+' ) 
{ if ($current==null) {
     $current = factory.create("AbstractElement");
  }
  factory.set($current, "cardinality", lv_cardinality);
createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@367e26 (cardinality: null)
grammar.eResource().getEObject("//@parserRules.10/@alternatives/@abstractTokens.1/@terminal"), currentNode,"cardinality");  
  associateNodeWithAstElement(currentNode, $current); }
)?) ;


// Rule Assignment
ruleAssignment returns [EObject current=null] : { EObject temp=null; }
(((
	
	lv_feature=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@90e25 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"feature"); }
 
{ if ($current==null) {
     $current = factory.create("Assignment");
  }
  factory.set($current, "feature", lv_feature);
  
  associateNodeWithAstElement(currentNode, $current); }
)(
	
	lv_operator=(('+=' |'=' )|'?=' ) 
{ if ($current==null) {
     $current = factory.create("Assignment");
  }
  factory.set($current, "operator", lv_operator);
createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@f3f6ff (cardinality: null)
grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");  
  associateNodeWithAstElement(currentNode, $current); }
))(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@f51055 (cardinality: null) (name: AbstractTerminal)
grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.1/@terminal"), currentNode);} 
	lv_terminal=ruleAbstractTerminal
 
{ if ($current==null) {
     $current = factory.create("Assignment");
  }
  factory.set($current, "terminal", lv_terminal);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
)) ;


// Rule Action
ruleAction returns [EObject current=null] : { EObject temp=null; }
(((('{' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@79a09c (cardinality: null) (value: '{')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }('current' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a6164e (cardinality: null) (value: 'current')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }'=' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@870711 (cardinality: null) (value: '=')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); })?)(
	{ currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@a57e86 (cardinality: null) (name: TypeRef)
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode);} 
	lv_typeName=ruleTypeRef
 
{ if ($current==null) {
     $current = factory.create("Action");
  }
  factory.set($current, "typeName", lv_typeName);
  currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode;
  associateNodeWithAstElement(currentNode, $current); }
))((('.' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@d8a522 (cardinality: null) (value: '.')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }(
	
	lv_feature=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@b891ad (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"feature"); }
 
{ if ($current==null) {
     $current = factory.create("Action");
  }
  factory.set($current, "feature", lv_feature);
  
  associateNodeWithAstElement(currentNode, $current); }
))(
	
	lv_operator=('=' |'+=' ) 
{ if ($current==null) {
     $current = factory.create("Action");
  }
  factory.set($current, "operator", lv_operator);
createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@e45af3 (cardinality: null)
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");  
  associateNodeWithAstElement(currentNode, $current); }
))'current' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@dac0d9 (cardinality: null) (value: 'current')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); })?)'}' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@53235f (cardinality: null) (value: '}')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.1"), currentNode,null); }) ;


// Rule AbstractTerminal
ruleAbstractTerminal returns [EObject current=null] : { EObject temp=null; }
((this_Keyword=ruleKeyword{$current = $this_Keyword.current;}
|this_RuleCall=ruleRuleCall{$current = $this_RuleCall.current;}
)|this_ParenthesizedElement=ruleParenthesizedElement{$current = $this_ParenthesizedElement.current;}
) ;


// Rule ParenthesizedElement
ruleParenthesizedElement returns [EObject current=null] : { EObject temp=null; }
(('(' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@ee8c9b (cardinality: null) (value: '(')
grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }this_Alternatives=ruleAlternatives{$current = $this_Alternatives.current;}
)')' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@f64d29 (cardinality: null) (value: ')')
grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.1"), currentNode,null); }) ;


// Rule Keyword
ruleKeyword returns [EObject current=null] : { EObject temp=null; }
(
	
	lv_value=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@6cc7c7 (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.15/@alternatives/@terminal"), currentNode,"value"); }
 
{ if ($current==null) {
     $current = factory.create("Keyword");
  }
  factory.set($current, "value", lv_value);
  
  associateNodeWithAstElement(currentNode, $current); }
) ;


// Rule RuleCall
ruleRuleCall returns [EObject current=null] : { EObject temp=null; }
(
	
	lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@50b410 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.16/@alternatives/@terminal"), currentNode,"name"); }
 
{ if ($current==null) {
     $current = factory.create("RuleCall");
  }
  factory.set($current, "name", lv_name);
  
  associateNodeWithAstElement(currentNode, $current); }
) ;



RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_ANY_OTHER : .;


