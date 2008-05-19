// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g 2008-05-19 20:58:04

package org.eclipse.xtext.parsetree.reconstr.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSimpleReconstrTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_ML_COMMENT", "RULE_STRING", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'('", "')'", "'!'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=6;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=8;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_LEXER_BODY=10;

        public InternalSimpleReconstrTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g"; }



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



    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:85:1: parse returns [EObject current] : ruleOp EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleOp1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:85:33: ( ruleOp EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:85:35: ruleOp EOF
            {
            currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@b903c1 (name: Op)
            grammar.eResource().getEObject("//@parserRules.0"), currentNode);
            pushFollow(FOLLOW_ruleOp_in_parse45);
            ruleOp1=ruleOp();
            _fsp--;

            current =ruleOp1;
            match(input,EOF,FOLLOW_EOF_in_parse49); 
            appendTrailingHiddenTokens(currentNode);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end parse


    // $ANTLR start ruleOp
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:92:1: ruleOp returns [EObject current=null] : (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:94:39: ( (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:95:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:95:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:95:2: this_Term= ruleTerm ( () (lv_values= ruleTerm ) )*
            {
            pushFollow(FOLLOW_ruleTerm_in_ruleOp85);
            this_Term=ruleTerm();
            _fsp--;

            current = this_Term;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:96:1: ( () (lv_values= ruleTerm ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:96:2: () (lv_values= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:96:2: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:97:1: 
            	    {
            	     temp=factory.create("Op");
            	      factory.add(temp, "values",current);
            	      current = temp; 
            	      temp = null;
            	      currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@1cea92 (cardinality: null) (operator: +=, feature: values)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode); 
            	      associateNodeWithAstElement(currentNode, current); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:104:2: (lv_values= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:105:4: lv_values= ruleTerm
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@640180 (cardinality: null) (name: Term)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp107);
            	    lv_values=ruleTerm();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("Expression");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "values", lv_values);


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             currentNode = entryNode; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOp


    // $ANTLR start ruleTerm
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:119:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:121:4: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:122:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:122:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("122:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:122:2: this_Atom= ruleAtom
                    {
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm145);
                    this_Atom=ruleAtom();
                    _fsp--;

                    current = this_Atom;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:123:2: this_Parens= ruleParens
                    {
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm151);
                    this_Parens=ruleParens();
                    _fsp--;

                    current = this_Parens;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTerm


    // $ANTLR start ruleAtom
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:130:4: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:131:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:131:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:133:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom191); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@6da05c (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.2/@alternatives/@terminal"), currentNode,"name"); 
                 if (current==null) {
                  current = factory.create("Atom");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "name", lv_name);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAtom


    // $ANTLR start ruleParens
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:146:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em=null;
        EObject this_Op = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:148:4: ( ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:2: ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:2: ( ( '(' this_Op= ruleOp ) ')' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:3: ( '(' this_Op= ruleOp ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:3: ( '(' this_Op= ruleOp )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:4: '(' this_Op= ruleOp
            {
            match(input,12,FOLLOW_12_in_ruleParens227); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@78e0e7 (cardinality: null) (value: '(')
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            pushFollow(FOLLOW_ruleOp_in_ruleParens232);
            this_Op=ruleOp();
            _fsp--;

            current = this_Op;

            }

            match(input,13,FOLLOW_13_in_ruleParens236); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@62dd8b (cardinality: null) (value: ')')
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:152:124: (lv_em= '!' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:154:4: lv_em= '!'
                    {
                    lv_em=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleParens251); 
                         if (current==null) {
                          current = factory.create("Expression");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "em", lv_em);
                    createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@824203 (cardinality: null) (value: '!')
                    grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@terminal"), currentNode,"em");

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParens


 

    public static final BitSet FOLLOW_ruleOp_in_parse45 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp85 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp107 = new BitSet(new long[]{0x0000000000001012L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleParens227 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens232 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleParens236 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleParens251 = new BitSet(new long[]{0x0000000000000002L});

}