// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g 2008-05-20 08:04:40

package org.eclipse.xtext.parsetree.reconstr.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalComplexReconstrTestParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_WS", "RULE_LEXER_BODY", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_ANY_OTHER", "'+'", "'-'", "'('", "')'", "'!'"
    };
    public static final int RULE_ML_COMMENT=10;
    public static final int RULE_ID=4;
    public static final int RULE_WS=6;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=8;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_LEXER_BODY=7;

        public InternalComplexReconstrTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g"; }



    private IElementFactory factory;
    public InternalComplexReconstrTestParser(TokenStream input, IElementFactory factory) {
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

    private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestConstants.getComplexReconstrTestGrammar();



    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:85:1: parse returns [EObject current] : ruleOp EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleOp1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:85:33: ( ruleOp EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:85:35: ruleOp EOF
            {
            currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@e2dd88 (name: Op)
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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:92:1: ruleOp returns [EObject current=null] : (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term = null;

        EObject lv_addOperands = null;

        EObject lv_minusOperands = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:94:39: ( (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:95:1: (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:95:1: (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:95:2: this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )*
            {
            pushFollow(FOLLOW_ruleTerm_in_ruleOp85);
            this_Term=ruleTerm();
            _fsp--;

            current = this_Term;
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:96:1: ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }
                else if ( (LA1_0==13) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:96:2: ( ( () '+' ) (lv_addOperands= ruleTerm ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:96:2: ( ( () '+' ) (lv_addOperands= ruleTerm ) )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:96:3: ( () '+' ) (lv_addOperands= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:96:3: ( () '+' )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:96:4: () '+'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:96:4: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:97:1: 
            	    {
            	     temp=factory.create("Add");
            	      factory.add(temp, "addOperands",current);
            	      current = temp; 
            	      temp = null;
            	      currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@60adf5 (cardinality: null) (operator: +=, feature: addOperands)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0"), currentNode); 
            	      associateNodeWithAstElement(currentNode, current); 

            	    }

            	    match(input,12,FOLLOW_12_in_ruleOp96); 
            	     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@9ed1e4 (cardinality: null) (value: '+')
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:105:152: (lv_addOperands= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:106:4: lv_addOperands= ruleTerm
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@f9ca83 (cardinality: null) (name: Term)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp113);
            	    lv_addOperands=ruleTerm();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("Expression");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "addOperands", lv_addOperands);


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:4: ( ( () '-' ) (lv_minusOperands= ruleTerm ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:4: ( ( () '-' ) (lv_minusOperands= ruleTerm ) )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:5: ( () '-' ) (lv_minusOperands= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:5: ( () '-' )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:6: () '-'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:6: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:117:1: 
            	    {
            	     temp=factory.create("Minus");
            	      factory.add(temp, "minusOperands",current);
            	      current = temp; 
            	      temp = null;
            	      currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@354e4e (cardinality: null) (operator: +=, feature: minusOperands)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0"), currentNode); 
            	      associateNodeWithAstElement(currentNode, current); 

            	    }

            	    match(input,13,FOLLOW_13_in_ruleOp129); 
            	     createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@4912e5 (cardinality: null) (value: '-')
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:125:152: (lv_minusOperands= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:126:4: lv_minusOperands= ruleTerm
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@1e5dc5 (cardinality: null) (name: Term)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp146);
            	    lv_minusOperands=ruleTerm();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("Expression");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "minusOperands", lv_minusOperands);


            	    }


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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:140:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:142:4: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:143:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:143:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("143:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:143:2: this_Atom= ruleAtom
                    {
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm185);
                    this_Atom=ruleAtom();
                    _fsp--;

                    current = this_Atom;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:144:2: this_Parens= ruleParens
                    {
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm191);
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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:149:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:151:4: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:152:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:152:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:154:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom231); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@513710 (cardinality: null) (name: ID)
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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:167:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em=null;
        EObject this_Op = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:169:4: ( ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:170:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:170:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:170:2: ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:170:2: ( ( '(' this_Op= ruleOp ) ')' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:170:3: ( '(' this_Op= ruleOp ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:170:3: ( '(' this_Op= ruleOp )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:170:4: '(' this_Op= ruleOp
            {
            match(input,14,FOLLOW_14_in_ruleParens267); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@354c20 (cardinality: null) (value: '(')
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            pushFollow(FOLLOW_ruleOp_in_ruleParens272);
            this_Op=ruleOp();
            _fsp--;

            current = this_Op;

            }

            match(input,15,FOLLOW_15_in_ruleParens276); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@3f8386 (cardinality: null) (value: ')')
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1"), currentNode,null); 

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:173:124: (lv_em= '!' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:175:4: lv_em= '!'
                    {
                    lv_em=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleParens291); 
                         if (current==null) {
                          current = factory.create("Expression");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "em", lv_em);
                    createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@8f3f1d (cardinality: null) (value: '!')
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
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp85 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleOp96 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp113 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_13_in_ruleOp129 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp146 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleParens267 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens272 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParens276 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleParens291 = new BitSet(new long[]{0x0000000000000002L});

}