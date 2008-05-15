
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

public CompositeNode createCompositeNode(EObject currentGrammarElement,
		CompositeNode parentNode) {
	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
	compositeNode.setGrammarElement(currentGrammarElement);
	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
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
	
public void associateNodeWithAstElement(AbstractNode node, EObject astElement) {
	node.setElement(astElement);
	if(astElement instanceof EObject) {
		EObject eObject = (EObject) astElement;
		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
		adapter.setParserNode(node); 
	}
}
	
private CompositeNode currentNode;

}

parse returns [EObject current] :
	ruleGrammar {$current=$ruleGrammar.current;} EOF {appendTrailingHiddenTokens(currentNode);};


ruleGrammar returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_metamodelDeclarations=
ruleAbstractMetamodelDeclaration
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "metamodelDeclarations",lv_metamodelDeclarations);
	associateNodeWithAstElement(currentNode, $current);
	}
)*
(
	lv_parserRules=
ruleParserRule
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "parserRules",lv_parserRules);
	associateNodeWithAstElement(currentNode, $current);
	}
)*)
(
(
'lexing' {createLeafNode(null, currentNode, 
null);}
':' {createLeafNode(null, currentNode, 
null);})
(
	lv_lexerRules=
ruleLexerRule
 {if ($current==null) {
	$current = factory.create("Grammar");}
	factory.add($current, "lexerRules",lv_lexerRules);
	associateNodeWithAstElement(currentNode, $current);
	}
)+)?) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleAbstractRule returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_LexerRule=ruleLexerRule{$current = $this_LexerRule.current;}
|
this_ParserRule=ruleParserRule{$current = $this_ParserRule.current;}
) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleAbstractMetamodelDeclaration returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_GeneratedMetamodel=ruleGeneratedMetamodel{$current = $this_GeneratedMetamodel.current;}
|
this_ReferencedMetamodel=ruleReferencedMetamodel{$current = $this_ReferencedMetamodel.current;}
) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleGeneratedMetamodel returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
'generate' {createLeafNode(null, currentNode, 
null);}
(
	lv_name=
RULE_ID{createLeafNode(null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);
	}
))
(
	lv_nsURI=
RULE_STRING{createLeafNode(null, currentNode, 
"nsURI");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "nsURI",lv_nsURI);
	associateNodeWithAstElement(currentNode, $current);
	}
))
(
'as' {createLeafNode(null, currentNode, 
null);}
(
	lv_alias=
RULE_ID{createLeafNode(null, currentNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("GeneratedMetamodel");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentNode, $current);
	}
))?) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleReferencedMetamodel returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
'import' {createLeafNode(null, currentNode, 
null);}
(
	lv_uri=
RULE_STRING{createLeafNode(null, currentNode, 
"uri");}
 {if ($current==null) {
	$current = factory.create("ReferencedMetamodel");}
	factory.set($current, "uri",lv_uri);
	associateNodeWithAstElement(currentNode, $current);
	}
))
(
'as' {createLeafNode(null, currentNode, 
null);}
(
	lv_alias=
RULE_ID{createLeafNode(null, currentNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("ReferencedMetamodel");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentNode, $current);
	}
))?) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleLexerRule returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_name=
RULE_ID{createLeafNode(null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("LexerRule");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);
	}
)
':' {createLeafNode(null, currentNode, 
null);})
(
	lv_body=
RULE_LEXER_BODY{createLeafNode(null, currentNode, 
"body");}
 {if ($current==null) {
	$current = factory.create("LexerRule");}
	factory.set($current, "body",lv_body);
	associateNodeWithAstElement(currentNode, $current);
	}
)) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleParserRule returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
(
(
	lv_name=
RULE_ID{createLeafNode(null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);
	}
)
(
'returns' {createLeafNode(null, currentNode, 
null);}
(
	lv_type=
ruleTypeRef
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "type",lv_type);
	associateNodeWithAstElement(currentNode, $current);
	}
))?)
':' {createLeafNode(null, currentNode, 
null);})
(
	lv_alternatives=
ruleAlternatives
 {if ($current==null) {
	$current = factory.create("ParserRule");}
	factory.set($current, "alternatives",lv_alternatives);
	associateNodeWithAstElement(currentNode, $current);
	}
))
';' {createLeafNode(null, currentNode, 
null);}) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleTypeRef returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_alias=
RULE_ID{createLeafNode(null, currentNode, 
"alias");}
 {if ($current==null) {
	$current = factory.create("TypeRef");}
	factory.set($current, "alias",lv_alias);
	associateNodeWithAstElement(currentNode, $current);
	}
)
'::' {createLeafNode(null, currentNode, 
null);})?
(
	lv_name=
RULE_ID{createLeafNode(null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("TypeRef");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);
	}
)) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleAlternatives returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_Group=ruleGroup{$current = $this_Group.current;}

(
(
(
	{temp=factory.create("Alternatives");
	 factory.add(temp, "groups",$current);
	 $current = temp; 
	 temp = null;
	 associateNodeWithAstElement(currentNode, $current);}
)
'|' {createLeafNode(null, currentNode, 
null);})
(
	lv_groups=
ruleGroup
 {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.add($current, "groups",lv_groups);
	associateNodeWithAstElement(currentNode, $current);
	}
))*) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleGroup returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
this_AbstractToken=ruleAbstractToken{$current = $this_AbstractToken.current;}

(
(
	{temp=factory.create("Group");
	 factory.add(temp, "abstractTokens",$current);
	 $current = temp; 
	 temp = null;
	 associateNodeWithAstElement(currentNode, $current);}
)
(
	lv_abstractTokens=
ruleAbstractToken
 {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.add($current, "abstractTokens",lv_abstractTokens);
	associateNodeWithAstElement(currentNode, $current);
	}
))*) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleAbstractToken returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
this_Assignment=ruleAssignment{$current = $this_Assignment.current;}
|
this_Action=ruleAction{$current = $this_Action.current;}
)|
this_AbstractTerminal=ruleAbstractTerminal{$current = $this_AbstractTerminal.current;}
)
(
	lv_cardinality=
(
(
'?' |
'*' )|
'+' ) {if ($current==null) {
	$current = factory.create("AbstractElement");}
	factory.set($current, "cardinality",lv_cardinality);
	associateNodeWithAstElement(currentNode, $current);
createLeafNode(null, currentNode, 
"cardinality");}
)?) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleAssignment returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
	lv_feature=
RULE_ID{createLeafNode(null, currentNode, 
"feature");}
 {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "feature",lv_feature);
	associateNodeWithAstElement(currentNode, $current);
	}
)
(
	lv_operator=
(
(
'+=' |
'=' )|
'?=' ) {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "operator",lv_operator);
	associateNodeWithAstElement(currentNode, $current);
createLeafNode(null, currentNode, 
"operator");}
))
(
	lv_terminal=
ruleAbstractTerminal
 {if ($current==null) {
	$current = factory.create("Assignment");}
	factory.set($current, "terminal",lv_terminal);
	associateNodeWithAstElement(currentNode, $current);
	}
)) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleAction returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
(
(
'{' {createLeafNode(null, currentNode, 
null);}
(
'current' {createLeafNode(null, currentNode, 
null);}
'=' {createLeafNode(null, currentNode, 
null);})?)
(
	lv_typeName=
ruleTypeRef
 {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "typeName",lv_typeName);
	associateNodeWithAstElement(currentNode, $current);
	}
))
(
(
(
'.' {createLeafNode(null, currentNode, 
null);}
(
	lv_feature=
RULE_ID{createLeafNode(null, currentNode, 
"feature");}
 {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "feature",lv_feature);
	associateNodeWithAstElement(currentNode, $current);
	}
))
(
	lv_operator=
(
'=' |
'+=' ) {if ($current==null) {
	$current = factory.create("Action");}
	factory.set($current, "operator",lv_operator);
	associateNodeWithAstElement(currentNode, $current);
createLeafNode(null, currentNode, 
"operator");}
))
'current' {createLeafNode(null, currentNode, 
null);})?)
'}' {createLeafNode(null, currentNode, 
null);}) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleAbstractTerminal returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
this_Keyword=ruleKeyword{$current = $this_Keyword.current;}
|
this_RuleCall=ruleRuleCall{$current = $this_RuleCall.current;}
)|
this_ParenthesizedElement=ruleParenthesizedElement{$current = $this_ParenthesizedElement.current;}
) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleParenthesizedElement returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
(
'(' {createLeafNode(null, currentNode, 
null);}
this_Alternatives=ruleAlternatives{$current = $this_Alternatives.current;}
)
')' {createLeafNode(null, currentNode, 
null);}) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleKeyword returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
	lv_value=
RULE_STRING{createLeafNode(null, currentNode, 
"value");}
 {if ($current==null) {
	$current = factory.create("Keyword");}
	factory.set($current, "value",lv_value);
	associateNodeWithAstElement(currentNode, $current);
	}
) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };

ruleRuleCall returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
	lv_name=
RULE_ID{createLeafNode(null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("RuleCall");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);
	}
) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };



RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


