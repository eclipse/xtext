
grammar InternalMetamodelRefTest;

@lexer::header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.metamodelreferencing.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;

}

@parser::members {

private IElementFactory factory;
public InternalMetamodelRefTestParser(TokenStream input, IElementFactory factory) {
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

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestConstants.getMetamodelRefTestGrammar();
}

parse returns [EObject current] : {currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@c8607d (name: Foo)
grammar.eResource().getEObject("//@parserRules.0"), currentNode);}
	ruleFoo {$current=$ruleFoo.current;} EOF {appendTrailingHiddenTokens(currentNode);};



// Rule Foo
ruleFoo returns [EObject current=null] 
   @init { EObject temp=null; }
   :
((
   
   lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@f20761 (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.0/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("Foo");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
)(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@a4b6a (cardinality: null) (name: NameRef)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@terminal"), currentNode); } 
   lv_nameRefs=ruleNameRef
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("Foo");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.add($current, "nameRefs", lv_nameRefs);
}
)*);


// Rule NameRef
ruleNameRef returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(
   
   lv_name=RULE_STRING{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@c06cac (cardinality: null) (name: STRING)
grammar.eResource().getEObject("//@parserRules.1/@alternatives/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("xtext::RuleCall");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
);



RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_ANY_OTHER : .;


