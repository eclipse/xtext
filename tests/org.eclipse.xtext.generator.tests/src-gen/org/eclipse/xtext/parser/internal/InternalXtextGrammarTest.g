
grammar InternalXtextGrammarTest;

@lexer::header {
package org.eclipse.xtext.parser.internal;
}

@parser::header {
package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
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
	
private CompositeNode currentNode;

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.XtextGrammarTestConstants.getXtextGrammarTestGrammar();
}

parse returns [EObject current] : {currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@91a191 (name: Grammar)
grammar.eResource().getEObject("//@parserRules.0"), currentNode);}
	ruleGrammar {$current=$ruleGrammar.current;} EOF {appendTrailingHiddenTokens(currentNode);};



// Rule Grammar
ruleGrammar returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(((
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@d3126 (cardinality: null) (name: AbstractMetamodelDeclaration)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode); } 
   lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("Grammar");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.add($current, "metamodelDeclarations", lv_metamodelDeclarations);
}
)*(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@b76edf (cardinality: null) (name: ParserRule)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode); } 
   lv_parserRules=ruleParserRule
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("Grammar");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.add($current, "parserRules", lv_parserRules);
}
)*)(('lexing' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@779845 (cardinality: null) (value: 'lexing')
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }':' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@ade920 (cardinality: null) (value: ':')
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@456977 (cardinality: null) (name: LexerRule)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); } 
   lv_lexerRules=ruleLexerRule
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("Grammar");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.add($current, "lexerRules", lv_lexerRules);
}
)+)?);


// Rule AbstractRule
ruleAbstractRule returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(this_LexerRule=ruleLexerRule{$current = $this_LexerRule.current;}
|this_ParserRule=ruleParserRule{$current = $this_ParserRule.current;}
);


// Rule AbstractMetamodelDeclaration
ruleAbstractMetamodelDeclaration returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(this_GeneratedMetamodel=ruleGeneratedMetamodel{$current = $this_GeneratedMetamodel.current;}
|this_ReferencedMetamodel=ruleReferencedMetamodel{$current = $this_ReferencedMetamodel.current;}
);


// Rule GeneratedMetamodel
ruleGeneratedMetamodel returns [EObject current=null] 
   @init { EObject temp=null; }
   :
((('generate' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@f9cff1 (cardinality: null) (value: 'generate')
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }(
   
   lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@b73feb (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("GeneratedMetamodel");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
))(
   
   lv_nsURI=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@6c8a0c (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"nsURI"); }
 
{     if ($current==null) {
      $current = factory.create("GeneratedMetamodel");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "nsURI", lv_nsURI);
}
))('as' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@7d2a06 (cardinality: null) (value: 'as')
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
   
   lv_alias=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@b76ce4 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); }
 
{     if ($current==null) {
      $current = factory.create("GeneratedMetamodel");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "alias", lv_alias);
}
))?);


// Rule ReferencedMetamodel
ruleReferencedMetamodel returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(('import' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@6faeb8 (cardinality: null) (value: 'import')
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }(
   
   lv_uri=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@e76514 (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"uri"); }
 
{     if ($current==null) {
      $current = factory.create("ReferencedMetamodel");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "uri", lv_uri);
}
))('as' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@ade71c (cardinality: null) (value: 'as')
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
   
   lv_alias=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@9847e5 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"alias"); }
 
{     if ($current==null) {
      $current = factory.create("ReferencedMetamodel");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "alias", lv_alias);
}
))?);


// Rule LexerRule
ruleLexerRule returns [EObject current=null] 
   @init { EObject temp=null; }
   :
((((
   
   lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@2dec81 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("LexerRule");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
)('tokentype' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@403263 (cardinality: null) (value: 'tokentype')
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
   
   lv_tokenType=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@4561a6 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode,"tokenType"); }
 
{     if ($current==null) {
      $current = factory.create("LexerRule");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "tokenType", lv_tokenType);
}
))?)':' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@df626 (cardinality: null) (value: ':')
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
   
   lv_body=RULE_LEXER_BODY{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@9a1621 (cardinality: null) (name: LEXER_BODY)
grammar.eResource().getEObject("//@parserRules.5/@alternatives/@abstractTokens.1/@terminal"), currentNode,"body"); }
 
{     if ($current==null) {
      $current = factory.create("LexerRule");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "body", lv_body);
}
));


// Rule ParserRule
ruleParserRule returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(((((
   
   lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@d587bf (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("ParserRule");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
)('returns' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@91d8be (cardinality: null) (value: 'returns')
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@3a3047 (cardinality: null) (name: TypeRef)
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); } 
   lv_type=ruleTypeRef
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("ParserRule");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "type", lv_type);
}
))?)':' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@37aefa (cardinality: null) (value: ':')
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@e3d345 (cardinality: null) (name: Alternatives)
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode); } 
   lv_alternatives=ruleAlternatives
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("ParserRule");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "alternatives", lv_alternatives);
}
))';' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@438186 (cardinality: null) (value: ';')
grammar.eResource().getEObject("//@parserRules.6/@alternatives/@abstractTokens.1"), currentNode,null); });


// Rule TypeRef
ruleTypeRef returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(((
   
   lv_alias=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@3c4bca (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"alias"); }
 
{     if ($current==null) {
      $current = factory.create("TypeRef");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "alias", lv_alias);
}
)'::' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@93decc (cardinality: null) (value: '::')
grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })?(
   
   lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@7ff81e (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.7/@alternatives/@abstractTokens.1/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("TypeRef");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
));


// Rule Alternatives
ruleAlternatives returns [EObject current=null] 
   @init { EObject temp=null; CompositeNode entryNode = currentNode; }
   @after { currentNode = entryNode; }:
(this_Group=ruleGroup{$current = $this_Group.current;}
(((
{ temp=factory.create("Alternatives");
  factory.add(temp, "groups",$current);
  $current = temp; 
  temp = null;
  currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@da7c9a (cardinality: null) (operator: +=, feature: groups)
grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0"), currentNode); 
  associateNodeWithAstElement(currentNode, $current); }
)'|' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@b45709 (cardinality: null) (value: '|')
grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@93ccd5 (cardinality: null) (name: Group)
grammar.eResource().getEObject("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); } 
   lv_groups=ruleGroup
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("AbstractElement");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.add($current, "groups", lv_groups);
}
))*);


// Rule Group
ruleGroup returns [EObject current=null] 
   @init { EObject temp=null; CompositeNode entryNode = currentNode; }
   @after { currentNode = entryNode; }:
(this_AbstractToken=ruleAbstractToken{$current = $this_AbstractToken.current;}
((
{ temp=factory.create("Group");
  factory.add(temp, "abstractTokens",$current);
  $current = temp; 
  temp = null;
  currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@7aaee9 (cardinality: null) (operator: +=, feature: abstractTokens)
grammar.eResource().getEObject("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode); 
  associateNodeWithAstElement(currentNode, $current); }
)(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@58b2a9 (cardinality: null) (name: AbstractToken)
grammar.eResource().getEObject("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); } 
   lv_abstractTokens=ruleAbstractToken
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("AbstractElement");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.add($current, "abstractTokens", lv_abstractTokens);
}
))*);


// Rule AbstractToken
ruleAbstractToken returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(((this_Assignment=ruleAssignment{$current = $this_Assignment.current;}
|this_Action=ruleAction{$current = $this_Action.current;}
)|this_AbstractTerminal=ruleAbstractTerminal{$current = $this_AbstractTerminal.current;}
)(
   
   lv_cardinality=(('?' |'*' )|'+' ) 
{     if ($current==null) {
      $current = factory.create("AbstractElement");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "cardinality", lv_cardinality);
createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@80a576 (cardinality: null)
grammar.eResource().getEObject("//@parserRules.10/@alternatives/@abstractTokens.1/@terminal"), currentNode,"cardinality");}
)?);


// Rule Assignment
ruleAssignment returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(((
   
   lv_feature=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@febe2b (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal"), currentNode,"feature"); }
 
{     if ($current==null) {
      $current = factory.create("Assignment");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "feature", lv_feature);
}
)(
   
   lv_operator=(('+=' |'=' )|'?=' ) 
{     if ($current==null) {
      $current = factory.create("Assignment");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "operator", lv_operator);
createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@e28e2 (cardinality: null)
grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");}
))(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@9f99ae (cardinality: null) (name: AbstractTerminal)
grammar.eResource().getEObject("//@parserRules.11/@alternatives/@abstractTokens.1/@terminal"), currentNode); } 
   lv_terminal=ruleAbstractTerminal
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("Assignment");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "terminal", lv_terminal);
}
));


// Rule Action
ruleAction returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(((('{' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@f1740f (cardinality: null) (value: '{')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }('current' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@651733 (cardinality: null) (value: 'current')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0"), currentNode,null); }'=' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@d65595 (cardinality: null) (value: '=')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); })?)(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@7baf7d (cardinality: null) (name: TypeRef)
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode); } 
   lv_typeName=ruleTypeRef
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("Action");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "typeName", lv_typeName);
}
))((('.' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@f0c01 (cardinality: null) (value: '.')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }(
   
   lv_feature=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@4e9726 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"feature"); }
 
{     if ($current==null) {
      $current = factory.create("Action");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "feature", lv_feature);
}
))(
   
   lv_operator=('=' |'+=' ) 
{     if ($current==null) {
      $current = factory.create("Action");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "operator", lv_operator);
createLeafNode(// org.eclipse.xtext.impl.AlternativesImpl@44e406 (cardinality: null)
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"operator");}
))'current' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@f0e973 (cardinality: null) (value: 'current')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1"), currentNode,null); })?)'}' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@6ea1eb (cardinality: null) (value: '}')
grammar.eResource().getEObject("//@parserRules.12/@alternatives/@abstractTokens.1"), currentNode,null); });


// Rule AbstractTerminal
ruleAbstractTerminal returns [EObject current=null] 
   @init { EObject temp=null; }
   :
((this_Keyword=ruleKeyword{$current = $this_Keyword.current;}
|this_RuleCall=ruleRuleCall{$current = $this_RuleCall.current;}
)|this_ParenthesizedElement=ruleParenthesizedElement{$current = $this_ParenthesizedElement.current;}
);


// Rule ParenthesizedElement
ruleParenthesizedElement returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(('(' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a5598d (cardinality: null) (value: '(')
grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }this_Alternatives=ruleAlternatives{$current = $this_Alternatives.current;}
)')' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@5f80d4 (cardinality: null) (value: ')')
grammar.eResource().getEObject("//@parserRules.14/@alternatives/@abstractTokens.1"), currentNode,null); });


// Rule Keyword
ruleKeyword returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(
   
   lv_value=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@ee808a (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.15/@alternatives/@terminal"), currentNode,"value"); }
 
{     if ($current==null) {
      $current = factory.create("Keyword");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "value", lv_value);
}
);


// Rule RuleCall
ruleRuleCall returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(
   
   lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@21e98d (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.16/@alternatives/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("RuleCall");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
);



RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_INT : ('0'..'9')+;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


