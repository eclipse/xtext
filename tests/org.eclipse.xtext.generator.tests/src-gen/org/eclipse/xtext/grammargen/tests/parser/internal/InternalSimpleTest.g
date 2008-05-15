
grammar InternalSimpleTest;

@lexer::header {
package org.eclipse.xtext.grammargen.tests.parser.internal;
}

@parser::header {
package org.eclipse.xtext.grammargen.tests.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;
}

@parser::members {

private IElementFactory factory;
public InternalSimpleTestParser(TokenStream input, IElementFactory factory) {
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
	ruleFoo {$current=$ruleFoo.current;} EOF {appendTrailingHiddenTokens(currentNode);};


ruleFoo returns [EObject current=null] : {EObject temp=null; currentNode=createCompositeNode(null, currentNode); }
	
(
	lv_name=
RULE_ID{createLeafNode(null, currentNode, 
"name");}
 {if ($current==null) {
	$current = factory.create("Foo");}
	factory.set($current, "name",lv_name);
	associateNodeWithAstElement(currentNode, $current);
	}
) { currentNode = currentNode.getParent()!=null?currentNode.getParent():currentNode; };



RULE_INT : ('0'..'9')+;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_ANY_OTHER : .;


