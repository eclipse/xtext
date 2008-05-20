
grammar InternalSimpleReconstrTest;

@lexer::header {
package org.eclipse.xtext.parsetree.reconstr.parser.internal;
}

@parser::header {
package org.eclipse.xtext.parsetree.reconstr.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;

}

@parser::members {

private IElementFactory factory;
public InternalSimpleReconstrTestParser(TokenStream input, IElementFactory factory) {
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

private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestConstants.getSimpleReconstrTestGrammar();
}

parse returns [EObject current] : {currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@3692c8 (name: Op)
grammar.eResource().getEObject("//@parserRules.0"), currentNode);}
	ruleOp {$current=$ruleOp.current;} EOF {appendTrailingHiddenTokens(currentNode);};



// Rule Op
ruleOp returns [EObject current=null] 
   @init { EObject temp=null; CompositeNode entryNode = currentNode; }
   @after { currentNode = entryNode; }:
(this_Term=ruleTerm{$current = $this_Term.current;}
((
{ temp=factory.create("Op");
  factory.add(temp, "values",$current);
  $current = temp; 
  temp = null;
  currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@b35a10 (cardinality: null) (operator: +=, feature: values)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode); 
  associateNodeWithAstElement(currentNode, $current); }
)(
   { currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@5fbed4 (cardinality: null) (name: Term)
grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); } 
   lv_values=ruleTerm
 
{  currentNode = currentNode.getParent();   if ($current==null) {
      $current = factory.create("Expression");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.add($current, "values", lv_values);
}
))*);


// Rule Term
ruleTerm returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(this_Atom=ruleAtom{$current = $this_Atom.current;}
|this_Parens=ruleParens{$current = $this_Parens.current;}
);


// Rule Atom
ruleAtom returns [EObject current=null] 
   @init { EObject temp=null; }
   :
(
   
   lv_name=RULE_ID{ createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@fab5ad (cardinality: null) (name: ID)
grammar.eResource().getEObject("//@parserRules.2/@alternatives/@terminal"), currentNode,"name"); }
 
{     if ($current==null) {
      $current = factory.create("Atom");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "name", lv_name);
}
);


// Rule Parens
ruleParens returns [EObject current=null] 
   @init { EObject temp=null; }
   :
((('(' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@395ead (cardinality: null) (value: '(')
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); }this_Op=ruleOp{$current = $this_Op.current;}
)')' { createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@a12a0e (cardinality: null) (value: ')')
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); })(
   
   lv_em='!'  
{     if ($current==null) {
      $current = factory.create("Expression");
      associateNodeWithAstElement(currentNode, $current);
   }
   factory.set($current, "em", lv_em);
createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@885c6b (cardinality: null) (value: '!')
grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal"), currentNode,"em");}
)?);



RULE_INT : ('0'..'9')+;

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' |
	'\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


