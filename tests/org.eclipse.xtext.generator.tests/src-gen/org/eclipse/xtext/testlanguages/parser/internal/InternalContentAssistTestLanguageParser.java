// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g 2009-01-06 10:50:14

package org.eclipse.xtext.testlanguages.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.DatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalContentAssistTestLanguageParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract rules'", "'end'", "'('", "')'", "';'", "'rule'", "':'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalContentAssistTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g"; }


     
        public InternalContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalContentAssistTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Start";	
       	} 



    // $ANTLR start entryRuleStart
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:66:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:66:47: (iv_ruleStart= ruleStart EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:67:2: iv_ruleStart= ruleStart EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleStart_in_entryRuleStart71);
            iv_ruleStart=ruleStart();
            _fsp--;

             current =iv_ruleStart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStart81); 

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
    // $ANTLR end entryRuleStart


    // $ANTLR start ruleStart
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:74:1: ruleStart returns [EObject current=null] : ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        EObject lv_rules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:76:33: ( ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:77:1: ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:77:1: ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:77:2: ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:77:2: ( 'abstract rules' (lv_rules= ruleAbstractRule )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:77:3: 'abstract rules' (lv_rules= ruleAbstractRule )+
            {
            match(input,11,FOLLOW_11_in_ruleStart116); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:81:1: (lv_rules= ruleAbstractRule )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:84:6: lv_rules= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleStart150);
            	    lv_rules=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Start");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "rules", lv_rules, "AbstractRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            match(input,12,FOLLOW_12_in_ruleStart165); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleStart


    // $ANTLR start entryRuleAbstractRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:113:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:113:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:114:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule198);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule208); 

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:121:1: ruleAbstractRule returns [EObject current=null] : (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_FirstAbstractRuleChild = null;

        EObject this_SecondAbstractRuleChild = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:123:33: ( (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:124:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:124:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==13) ) {
                    alt2=1;
                }
                else if ( (LA2_1==16) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("124:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("124:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:125:5: this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule255);
                    this_FirstAbstractRuleChild=ruleFirstAbstractRuleChild();
                    _fsp--;

                     
                            current = this_FirstAbstractRuleChild; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:135:5: this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule282);
                    this_SecondAbstractRuleChild=ruleSecondAbstractRuleChild();
                    _fsp--;

                     
                            current = this_SecondAbstractRuleChild; 
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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleFirstAbstractRuleChild
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:150:1: entryRuleFirstAbstractRuleChild returns [EObject current=null] : iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF ;
    public final EObject entryRuleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstAbstractRuleChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:150:64: (iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:151:2: iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild314);
            iv_ruleFirstAbstractRuleChild=ruleFirstAbstractRuleChild();
            _fsp--;

             current =iv_ruleFirstAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild324); 

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
    // $ANTLR end entryRuleFirstAbstractRuleChild


    // $ANTLR start ruleFirstAbstractRuleChild
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:158:1: ruleFirstAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' ) ;
    public final EObject ruleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:160:33: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:1: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:1: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:2: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:2: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:3: ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:3: ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:4: ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:4: ( (lv_name= RULE_ID ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:5: (lv_name= RULE_ID ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:161:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:163:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild373); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("FirstAbstractRuleChild");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,13,FOLLOW_13_in_ruleFirstAbstractRuleChild393); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:185:2: (lv_elements= ruleAbstractRule )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:188:6: lv_elements= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild428);
            	    lv_elements=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("FirstAbstractRuleChild");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "elements", lv_elements, "AbstractRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleFirstAbstractRuleChild443); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,15,FOLLOW_15_in_ruleFirstAbstractRuleChild453); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleFirstAbstractRuleChild


    // $ANTLR start entryRuleSecondAbstractRuleChild
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:221:1: entryRuleSecondAbstractRuleChild returns [EObject current=null] : iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF ;
    public final EObject entryRuleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondAbstractRuleChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:221:65: (iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:222:2: iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild486);
            iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild();
            _fsp--;

             current =iv_ruleSecondAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild496); 

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
    // $ANTLR end entryRuleSecondAbstractRuleChild


    // $ANTLR start ruleSecondAbstractRuleChild
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:229:1: ruleSecondAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' ) ;
    public final EObject ruleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_rule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:231:33: ( ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:1: ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:1: ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:2: ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:2: ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:3: ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:3: ( ( (lv_name= RULE_ID ) 'rule' ) ':' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:4: ( (lv_name= RULE_ID ) 'rule' ) ':'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:4: ( (lv_name= RULE_ID ) 'rule' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:5: (lv_name= RULE_ID ) 'rule'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:232:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:234:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild545); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("SecondAbstractRuleChild");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleSecondAbstractRuleChild565); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,17,FOLLOW_17_in_ruleSecondAbstractRuleChild575); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:260:2: (lv_rule= ruleAbstractRuleCall )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:263:6: lv_rule= ruleAbstractRuleCall
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild610);
            lv_rule=ruleAbstractRuleCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("SecondAbstractRuleChild");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "rule", lv_rule, "AbstractRuleCall", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleSecondAbstractRuleChild624); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleSecondAbstractRuleChild


    // $ANTLR start entryRuleAbstractRuleCall
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:292:1: entryRuleAbstractRuleCall returns [EObject current=null] : iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF ;
    public final EObject entryRuleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleCall = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:292:58: (iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:293:2: iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall657);
            iv_ruleAbstractRuleCall=ruleAbstractRuleCall();
            _fsp--;

             current =iv_ruleAbstractRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleCall667); 

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
    // $ANTLR end entryRuleAbstractRuleCall


    // $ANTLR start ruleAbstractRuleCall
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:300:1: ruleAbstractRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:302:33: ( ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:303:1: ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:303:1: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:306:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("AbstractRuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:312:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:313:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRuleCall715); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4/@alternatives/@terminal" /* xtext::CrossReference */, "rule"); 
                

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
    // $ANTLR end ruleAbstractRuleCall


 

    public static final BitSet FOLLOW_ruleStart_in_entryRuleStart71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStart81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStart116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleStart150 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStart165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild373 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFirstAbstractRuleChild393 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild428 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleFirstAbstractRuleChild443 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFirstAbstractRuleChild453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild545 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSecondAbstractRuleChild565 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSecondAbstractRuleChild575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild610 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSecondAbstractRuleChild624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRuleCall715 = new BitSet(new long[]{0x0000000000000002L});

}