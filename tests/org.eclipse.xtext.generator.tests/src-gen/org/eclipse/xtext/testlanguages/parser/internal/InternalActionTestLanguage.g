
grammar InternalActionTestLanguage;

@lexer::header {
package org.eclipse.xtext.testlanguages.parser.internal;
}

@parser::header {
package org.eclipse.xtext.testlanguages.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.parser.internal.ActionTestLanguageTokenTypeResolver;
}

@parser::members {

	private IElementFactory factory;
	public InternalActionTestLanguageParser(TokenStream input, IElementFactory factory) {
	    this(input);
	    this.factory = factory;
	}
	
	protected void reportError(RecognitionException re, LeafNode ln) {
        	reportError(re);
    	}
    		
    		private int lastConsumedIndex = -1;
    	
    	 	private void appendAllTokens() {
        		for (int x = lastConsumedIndex+1; input.size()>x;input.consume(),x++) {
    		        Token hidden = input.get(x);
    		        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    		        leafNode.setText(hidden.getText());
    		        leafNode.setHidden(true);
    		        setLexerRule(leafNode, hidden);
    		        currentNode.getChildren().add(leafNode);
    		    }
        	}

         	public List<LeafNode> appendSkippedTokens() {
        		List<LeafNode> skipped = new ArrayList<LeafNode>();
        		Token token = input.LT(-1);
        		Token tokenBefore = input.get(lastConsumedIndex);
        		int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
        		if (indexOfTokenBefore+1<token.getTokenIndex()) {
        		    for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
        		        Token hidden = input.get(x);
        		        LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
        		        leafNode.setText(hidden.getText());
        		        leafNode.setHidden(true);
        		        setLexerRule(leafNode, hidden);
        		        currentNode.getChildren().add(leafNode);
        		        skipped.add(leafNode);
        		    }
        		}
        		LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
		        leafNode.setText(token.getText());
		        leafNode.setHidden(true);
		        setLexerRule(leafNode, token);
		        currentNode.getChildren().add(leafNode);
		        skipped.add(leafNode);
        		lastConsumedIndex = token.getTokenIndex();
        		return skipped;
        	}
        	
            public CompositeNode createCompositeNode(String grammarElementID, CompositeNode parentNode) {
                CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
                if (parentNode!=null) parentNode.getChildren().add(compositeNode);
                compositeNode.setGrammarElement(grammar.eResource().getEObject(grammarElementID));
                return compositeNode;
            }
            

            public Object createLeafNode(String grammarElementID, CompositeNode parentNode, String feature) {
                Token token = input.LT(-1);
                int indexOfTokenBefore = lastConsumedIndex;
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
                lastConsumedIndex = token.getTokenIndex();
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
                        lastConsumedIndex = hidden.getTokenIndex();
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
		LexerRule lexerRule = ActionTestLanguageTokenTypeResolver.getLexerRule(node, t.getType());
		if(lexerRule != null) {
			node.setGrammarElement(lexerRule);
		}
	}
	
	private CompositeNode currentNode;
	public CompositeNode getCurrentNode() {
		return currentNode;
	}
	
	private org.eclipse.xtext.Grammar grammar = LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/ActionTestLanguage").getGrammar();;

}

@rulecatch { 
	catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
        LeafNode ln = null;
        if (currentNode!=null) {
	        CompositeNode root = (CompositeNode) EcoreUtil.getRootContainer(currentNode);
	        List<LeafNode> list = root.getLeafNodes();
	        if (list.size()>lastErrorIndex)
	        	ln = list.get(lastErrorIndex);
        }
		reportError(re, ln);
	} 
}

parse returns [EObject current] : 
    { currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); }
    ruleModel 
    { $current=$ruleModel.current; } 
    EOF 
    { appendTrailingHiddenTokens(currentNode); };
    finally { appendAllTokens(); } 



// Rule Model
ruleModel returns [EObject current=null] 
    @init { EObject temp=null; }:
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
    @init { EObject temp=null; }:
(this_Item=ruleItem
    { 
        $current = $this_Item.current; 
    }
((
    { 
        temp=factory.create("Item");
        factory.add(temp, "items",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
	newNode.getChildren().add(currentNode);
	currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    
    { 
        currentNode=createCompositeNode("//@parserRules.1/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
    }
    lv_items=ruleItem 
    {
        currentNode = currentNode.getParent();
        if ($current==null) {
            $current = factory.create("Type");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.add($current, "items", lv_items);    }
)));


// Rule Item
ruleItem returns [EObject current=null] 
    @init { EObject temp=null; }:
((
    { 
        temp=factory.create("Thing");
        factory.set(temp, "content",$current);
        $current = temp; 
        temp = null;
        CompositeNode newNode = createCompositeNode("//@parserRules.2/@alternatives/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
	newNode.getChildren().add(currentNode);
	currentNode = newNode; 
        associateNodeWithAstElement(currentNode, $current); 
    }
)(
    lv_name=RULE_ID
    { 
    createLeafNode("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
    }
 
    {
        if ($current==null) {
            $current = factory.create("Type");
            associateNodeWithAstElement(currentNode, $current);
        }
        factory.set($current, "name", lv_name);    }
));



RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

RULE_STRING : '"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"' | '\'' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'\'') )* '\'';

RULE_ID : ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_WS : (' '|'\t'|'\r'|'\n')+ {$channel=HIDDEN;};

RULE_INT : ('0'..'9')+;

RULE_LEXER_BODY : '<#' ( options {greedy=false;} : . )* '#>';

RULE_SL_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};

RULE_ANY_OTHER : .;


