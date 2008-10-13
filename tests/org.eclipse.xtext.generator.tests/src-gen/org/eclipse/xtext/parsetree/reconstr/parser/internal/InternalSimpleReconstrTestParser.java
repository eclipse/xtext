// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g 2008-10-10 15:59:18

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

public class InternalSimpleReconstrTestParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'#'", "'='", "'type'", "'extends'", "'#2'", "'mykeyword1'", "'mykeyword2'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSimpleReconstrTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g"; }


     
        public InternalSimpleReconstrTestParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalSimpleReconstrTestParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Op";	
       	} 



    // $ANTLR start entryRuleOp
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:63:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:63:44: (iv_ruleOp= ruleOp EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:64:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:71:1: ruleOp returns [EObject current=null] : (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:73:33: ( (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:74:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:74:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:75:5: this_Term= ruleTerm ( () (lv_values= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleOp128);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:83:1: ( () (lv_values= ruleTerm ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11||(LA1_0>=15 && LA1_0<=16)||LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:83:2: () (lv_values= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:83:2: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:84:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            factory.add(temp, "values",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:95:2: (lv_values= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:98:6: lv_values= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp171);
            	    lv_values=ruleTerm();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Expression");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "values", lv_values,null);
            	    	         

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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:117:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:117:46: (iv_ruleTerm= ruleTerm EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:118:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm212);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm222); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:125:1: ruleTerm returns [EObject current=null] : ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_TwoNumbers = null;

        EObject this_ManyStrings = null;

        EObject this_Parens = null;

        EObject this_Type = null;

        EObject this_Ref2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:127:33: ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:1: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:1: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_INT)||LA6_0==11||(LA6_0>=15 && LA6_0<=16)) ) {
                alt6=1;
            }
            else if ( (LA6_0==18) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("128:1: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:2: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )
                    {
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:2: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_INT)||LA5_0==11||LA5_0==15) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==16) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("128:2: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:3: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )
                            {
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:3: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_INT)||LA4_0==15) ) {
                                alt4=1;
                            }
                            else if ( (LA4_0==11) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("128:3: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:4: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )
                                    {
                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:4: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )
                                    int alt3=2;
                                    int LA3_0 = input.LA(1);

                                    if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_INT)) ) {
                                        alt3=1;
                                    }
                                    else if ( (LA3_0==15) ) {
                                        alt3=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("128:4: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )", 3, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt3) {
                                        case 1 :
                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:5: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )
                                            {
                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:128:5: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )
                                            int alt2=2;
                                            int LA2_0 = input.LA(1);

                                            if ( (LA2_0==RULE_ID) ) {
                                                alt2=1;
                                            }
                                            else if ( (LA2_0==RULE_INT) ) {
                                                alt2=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("128:5: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )", 2, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt2) {
                                                case 1 :
                                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:129:5: this_Atom= ruleAtom
                                                    {
                                                     
                                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                                        
                                                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm273);
                                                    this_Atom=ruleAtom();
                                                    _fsp--;

                                                     
                                                            current = this_Atom; 
                                                            currentNode = currentNode.getParent();
                                                        

                                                    }
                                                    break;
                                                case 2 :
                                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:139:5: this_TwoNumbers= ruleTwoNumbers
                                                    {
                                                     
                                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                        
                                                    pushFollow(FOLLOW_ruleTwoNumbers_in_ruleTerm300);
                                                    this_TwoNumbers=ruleTwoNumbers();
                                                    _fsp--;

                                                     
                                                            current = this_TwoNumbers; 
                                                            currentNode = currentNode.getParent();
                                                        

                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:149:5: this_ManyStrings= ruleManyStrings
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleManyStrings_in_ruleTerm328);
                                            this_ManyStrings=ruleManyStrings();
                                            _fsp--;

                                             
                                                    current = this_ManyStrings; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:159:5: this_Parens= ruleParens
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParens_in_ruleTerm356);
                                    this_Parens=ruleParens();
                                    _fsp--;

                                     
                                            current = this_Parens; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:169:5: this_Type= ruleType
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleType_in_ruleTerm384);
                            this_Type=ruleType();
                            _fsp--;

                             
                                    current = this_Type; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:179:5: this_Ref2= ruleRef2
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleRef2_in_ruleTerm412);
                    this_Ref2=ruleRef2();
                    _fsp--;

                     
                            current = this_Ref2; 
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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:192:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:192:46: (iv_ruleAtom= ruleAtom EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:193:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom446);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom456); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:200:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:202:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:203:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:203:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:205:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom501); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.2/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:224:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:224:48: (iv_ruleParens= ruleParens EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:225:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens546);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens556); 

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
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:232:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em=null;
        EObject this_Op = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:234:33: ( ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:235:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:235:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:235:2: ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:235:2: ( ( '(' this_Op= ruleOp ) ')' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:235:3: ( '(' this_Op= ruleOp ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:235:3: ( '(' this_Op= ruleOp )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:235:4: '(' this_Op= ruleOp
            {
            match(input,11,FOLLOW_11_in_ruleParens592); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens614);
            this_Op=ruleOp();
            _fsp--;

             
                    current = this_Op; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,12,FOLLOW_12_in_ruleParens623); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:252:2: (lv_em= '!' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:254:6: lv_em= '!'
                    {
                    lv_em=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleParens645); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "em"); 
                        

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


    // $ANTLR start entryRuleTwoNumbers
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:273:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:273:52: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:274:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers693);
            iv_ruleTwoNumbers=ruleTwoNumbers();
            _fsp--;

             current =iv_ruleTwoNumbers; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoNumbers703); 

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
    // $ANTLR end entryRuleTwoNumbers


    // $ANTLR start ruleTwoNumbers
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:281:1: ruleTwoNumbers returns [EObject current=null] : ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1=null;
        Token lv_num2=null;
        Token lv_num3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:283:33: ( ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:284:1: ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:284:1: ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:284:2: ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )*
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:284:2: ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:284:3: (lv_num1= RULE_INT ) (lv_num2= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:284:3: (lv_num1= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:286:6: lv_num1= RULE_INT
            {
            lv_num1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers750); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "num1"); 
                

            	        if (current==null) {
            	            current = factory.create("TwoNumbers");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "num1", lv_num1,"INT");
            	         

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:300:2: (lv_num2= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:302:6: lv_num2= RULE_INT
            {
            lv_num2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers782); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "num2"); 
                

            	        if (current==null) {
            	            current = factory.create("TwoNumbers");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "num2", lv_num2,"INT");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:316:3: ( '#' (lv_num3= RULE_INT ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:316:4: '#' (lv_num3= RULE_INT )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTwoNumbers804); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:320:1: (lv_num3= RULE_INT )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:322:6: lv_num3= RULE_INT
            	    {
            	    lv_num3=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers825); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "num3"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("TwoNumbers");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "num3", lv_num3,"INT");
            	    	         

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end ruleTwoNumbers


    // $ANTLR start entryRuleManyStrings
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:341:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:341:53: (iv_ruleManyStrings= ruleManyStrings EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:342:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleManyStrings_in_entryRuleManyStrings873);
            iv_ruleManyStrings=ruleManyStrings();
            _fsp--;

             current =iv_ruleManyStrings; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleManyStrings883); 

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
    // $ANTLR end entryRuleManyStrings


    // $ANTLR start ruleManyStrings
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:349:1: ruleManyStrings returns [EObject current=null] : ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token lv_str1=null;
        Token lv_str2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:351:33: ( ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:352:1: ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:352:1: ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:352:2: ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:352:2: ( '=' (lv_str1= RULE_STRING )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:352:3: '=' (lv_str1= RULE_STRING )*
            {
            match(input,15,FOLLOW_15_in_ruleManyStrings918); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:356:1: (lv_str1= RULE_STRING )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_STRING) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==RULE_STRING) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:358:6: lv_str1= RULE_STRING
            	    {
            	    lv_str1=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings939); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "str1"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("ManyStrings");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "str1", lv_str1,"STRING");
            	    	         

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:372:4: (lv_str2= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:374:6: lv_str2= RULE_STRING
            {
            lv_str2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings973); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "str2"); 
                

            	        if (current==null) {
            	            current = factory.create("ManyStrings");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.add(current, "str2", lv_str2,"STRING");
            	         

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
    // $ANTLR end ruleManyStrings


    // $ANTLR start entryRuleType
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:393:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:393:46: (iv_ruleType= ruleType EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:394:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType1019);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1029); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:401:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:403:33: ( ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:404:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:404:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:404:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:404:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:404:3: ( 'type' (lv_name= RULE_ID ) ) 'extends'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:404:3: ( 'type' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:404:4: 'type' (lv_name= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleType1065); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:408:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:410:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1086); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            match(input,17,FOLLOW_17_in_ruleType1107); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:428:2: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:431:1: ( RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:431:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:432:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1128); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "extends"); 
                

            }


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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleRef2
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:442:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:442:46: (iv_ruleRef2= ruleRef2 EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:443:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRef2_in_entryRuleRef21167);
            iv_ruleRef2=ruleRef2();
            _fsp--;

             current =iv_ruleRef2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRef21177); 

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
    // $ANTLR end entryRuleRef2


    // $ANTLR start ruleRef2
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:450:1: ruleRef2 returns [EObject current=null] : ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token lv_ref2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:452:33: ( ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:453:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:453:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:453:2: '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            {
            match(input,18,FOLLOW_18_in_ruleRef21211); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:457:1: (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:459:6: lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:459:14: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING||LA11_0==19) ) {
                alt11=1;
            }
            else if ( (LA11_0==20) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("459:14: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:459:15: ( 'mykeyword1' | RULE_STRING )
                    {
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:459:15: ( 'mykeyword1' | RULE_STRING )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==19) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==RULE_STRING) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("459:15: ( 'mykeyword1' | RULE_STRING )", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:459:16: 'mykeyword1'
                            {
                            match(input,19,FOLLOW_19_in_ruleRef21234); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "ref2"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:464:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRef21249); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "ref2"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/internal/InternalSimpleReconstrTest.g:469:6: 'mykeyword2'
                    {
                    match(input,20,FOLLOW_20_in_ruleRef21264); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "ref2"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Ref2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "ref2", input.LT(-1),null);
            	         

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
    // $ANTLR end ruleRef2


 

    public static final BitSet FOLLOW_ruleOp_in_entryRuleOp71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOp81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp128 = new BitSet(new long[]{0x0000000000058832L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp171 = new BitSet(new long[]{0x0000000000058832L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_ruleTerm300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_ruleTerm328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleTerm384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_ruleTerm412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleParens592 = new BitSet(new long[]{0x0000000000058830L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens614 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParens623 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleParens645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoNumbers703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers750 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers782 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTwoNumbers804 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers825 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_entryRuleManyStrings873 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleManyStrings883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleManyStrings918 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings939 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleType1065 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1086 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleType1107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef21167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRef21177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRef21211 = new BitSet(new long[]{0x0000000000180040L});
    public static final BitSet FOLLOW_19_in_ruleRef21234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRef21249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleRef21264 = new BitSet(new long[]{0x0000000000000002L});

}