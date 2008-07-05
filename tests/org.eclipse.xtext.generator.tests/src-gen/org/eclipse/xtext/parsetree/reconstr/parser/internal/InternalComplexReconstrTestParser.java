// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g 2008-07-05 20:00:20

package org.eclipse.xtext.parsetree.reconstr.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalComplexReconstrTestParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'+'", "'-'", "'('", "')'", "'!'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalComplexReconstrTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g"; }


     
        public InternalComplexReconstrTestParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalComplexReconstrTestParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Op";	
       	} 



    // $ANTLR start entryRuleOp
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:63:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:63:44: (iv_ruleOp= ruleOp EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:64:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOp_in_entryRuleOp71);
            iv_ruleOp=ruleOp();
            _fsp--;

             current =iv_ruleOp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOp81); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOp


    // $ANTLR start ruleOp
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:71:1: ruleOp returns [EObject current=null] : (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term = null;

        EObject lv_addOperands = null;

        EObject lv_minusOperands = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:73:33: ( (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:74:1: (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:74:1: (this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:75:5: this_Term= ruleTerm ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleOp128);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:83:1: ( ( ( () '+' ) (lv_addOperands= ruleTerm ) ) | ( ( () '-' ) (lv_minusOperands= ruleTerm ) ) )*
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
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:83:2: ( ( () '+' ) (lv_addOperands= ruleTerm ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:83:2: ( ( () '+' ) (lv_addOperands= ruleTerm ) )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:83:3: ( () '+' ) (lv_addOperands= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:83:3: ( () '+' )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:83:4: () '+'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:83:4: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:84:5: 
            	    {
            	     
            	            temp=factory.create("Add");
            	            factory.add(temp, "addOperands",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,12,FOLLOW_12_in_ruleOp148); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:99:2: (lv_addOperands= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:101:5: lv_addOperands= ruleTerm
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp177);
            	    lv_addOperands=ruleTerm();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "addOperands", lv_addOperands,null);
            	            
            	             

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:6: ( ( () '-' ) (lv_minusOperands= ruleTerm ) )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:6: ( ( () '-' ) (lv_minusOperands= ruleTerm ) )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:7: ( () '-' ) (lv_minusOperands= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:7: ( () '-' )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:8: () '-'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:116:8: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:117:5: 
            	    {
            	     
            	            temp=factory.create("Minus");
            	            factory.add(temp, "minusOperands",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,13,FOLLOW_13_in_ruleOp205); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:132:2: (lv_minusOperands= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:134:5: lv_minusOperands= ruleTerm
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@groups.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp234);
            	    lv_minusOperands=ruleTerm();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Expression");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "minusOperands", lv_minusOperands,null);
            	            
            	             

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

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOp


    // $ANTLR start entryRuleTerm
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:153:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:153:46: (iv_ruleTerm= ruleTerm EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:154:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm273);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm283); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTerm


    // $ANTLR start ruleTerm
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:161:1: ruleTerm returns [EObject current=null] : (this_Atom= ruleAtom | this_Parens= ruleParens ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_Parens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:163:33: ( (this_Atom= ruleAtom | this_Parens= ruleParens ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:164:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:164:1: (this_Atom= ruleAtom | this_Parens= ruleParens )
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
                    new NoViableAltException("164:1: (this_Atom= ruleAtom | this_Parens= ruleParens )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:165:5: this_Atom= ruleAtom
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm330);
                    this_Atom=ruleAtom();
                    _fsp--;

                     
                            current = this_Atom; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:175:5: this_Parens= ruleParens
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleParens_in_ruleTerm357);
                    this_Parens=ruleParens();
                    _fsp--;

                     
                            current = this_Parens; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTerm


    // $ANTLR start entryRuleAtom
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:188:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:188:46: (iv_ruleAtom= ruleAtom EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:189:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom391);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom401); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:196:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:198:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:199:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:199:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:200:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom442); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.2/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

                    if (current==null) {
                        current = factory.create("Atom");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "name", lv_name,"ID");
                    
                     

            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleParens
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:219:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:219:48: (iv_ruleParens= ruleParens EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:220:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens484);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens494); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParens


    // $ANTLR start ruleParens
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:227:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em=null;
        EObject this_Op = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:229:33: ( ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:230:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:230:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:230:2: ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:230:2: ( ( '(' this_Op= ruleOp ) ')' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:230:3: ( '(' this_Op= ruleOp ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:230:3: ( '(' this_Op= ruleOp )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:230:4: '(' this_Op= ruleOp
            {
            match(input,14,FOLLOW_14_in_ruleParens530); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens552);
            this_Op=ruleOp();
            _fsp--;

             
                    current = this_Op; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,15,FOLLOW_15_in_ruleParens561); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:247:2: (lv_em= '!' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalComplexReconstrTest.g:248:5: lv_em= '!'
                    {
                    lv_em=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleParens579); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "em"); 
                        

                            if (current==null) {
                                current = factory.create("Expression");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            
                            factory.set(current, "em", input.LT(-1),"!");
                            
                             

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParens


 

    public static final BitSet FOLLOW_ruleOp_in_entryRuleOp71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOp81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp128 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleOp148 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp177 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_13_in_ruleOp205 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp234 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleParens530 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens552 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleParens561 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleParens579 = new BitSet(new long[]{0x0000000000000002L});

}