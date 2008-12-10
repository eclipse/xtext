// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g 2008-12-10 12:15:47

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:62:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:62:47: (iv_ruleStart= ruleStart EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:63:2: iv_ruleStart= ruleStart EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleStart_in_entryRuleStart70);
            iv_ruleStart=ruleStart();
            _fsp--;

             current =iv_ruleStart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStart80); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:70:1: ruleStart returns [EObject current=null] : ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        EObject lv_rules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:72:33: ( ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:73:1: ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:73:1: ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:73:2: ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:73:2: ( 'abstract rules' (lv_rules= ruleAbstractRule )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:73:3: 'abstract rules' (lv_rules= ruleAbstractRule )+
            {
            match(input,11,FOLLOW_11_in_ruleStart115); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:77:1: (lv_rules= ruleAbstractRule )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:80:6: lv_rules= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleStart149);
            	    lv_rules=ruleAbstractRule();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Start");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "rules", lv_rules,null);
            	    	         

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

            match(input,12,FOLLOW_12_in_ruleStart164); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:103:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:103:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:104:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule199);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule209); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:111:1: ruleAbstractRule returns [EObject current=null] : (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_FirstAbstractRuleChild = null;

        EObject this_SecondAbstractRuleChild = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:113:33: ( (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:114:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:114:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )
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
                        new NoViableAltException("114:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("114:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:115:5: this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule256);
                    this_FirstAbstractRuleChild=ruleFirstAbstractRuleChild();
                    _fsp--;

                     
                            current = this_FirstAbstractRuleChild; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:125:5: this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule283);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:138:1: entryRuleFirstAbstractRuleChild returns [EObject current=null] : iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF ;
    public final EObject entryRuleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstAbstractRuleChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:138:64: (iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:139:2: iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild317);
            iv_ruleFirstAbstractRuleChild=ruleFirstAbstractRuleChild();
            _fsp--;

             current =iv_ruleFirstAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild327); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:146:1: ruleFirstAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' ) ;
    public final EObject ruleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:148:33: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:1: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:1: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:2: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:2: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:3: ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:3: ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:4: ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:4: ( (lv_name= RULE_ID ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:5: (lv_name= RULE_ID ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:149:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:151:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild376); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("FirstAbstractRuleChild");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }

            match(input,13,FOLLOW_13_in_ruleFirstAbstractRuleChild396); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:169:2: (lv_elements= ruleAbstractRule )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:172:6: lv_elements= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild431);
            	    lv_elements=ruleAbstractRule();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("FirstAbstractRuleChild");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "elements", lv_elements,null);
            	    	         

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

            match(input,14,FOLLOW_14_in_ruleFirstAbstractRuleChild446); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,15,FOLLOW_15_in_ruleFirstAbstractRuleChild456); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:199:1: entryRuleSecondAbstractRuleChild returns [EObject current=null] : iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF ;
    public final EObject entryRuleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondAbstractRuleChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:199:65: (iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:200:2: iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild491);
            iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild();
            _fsp--;

             current =iv_ruleSecondAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild501); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:207:1: ruleSecondAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' ) ;
    public final EObject ruleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_rule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:209:33: ( ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:1: ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:1: ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:2: ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:2: ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:3: ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:3: ( ( (lv_name= RULE_ID ) 'rule' ) ':' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:4: ( (lv_name= RULE_ID ) 'rule' ) ':'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:4: ( (lv_name= RULE_ID ) 'rule' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:5: (lv_name= RULE_ID ) 'rule'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:210:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:212:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild550); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("SecondAbstractRuleChild");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }

            match(input,16,FOLLOW_16_in_ruleSecondAbstractRuleChild570); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,17,FOLLOW_17_in_ruleSecondAbstractRuleChild580); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:234:2: (lv_rule= ruleAbstractRuleCall )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:237:6: lv_rule= ruleAbstractRuleCall
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild615);
            lv_rule=ruleAbstractRuleCall();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("SecondAbstractRuleChild");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "rule", lv_rule,null);
            	         

            }


            }

            match(input,15,FOLLOW_15_in_ruleSecondAbstractRuleChild629); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:260:1: entryRuleAbstractRuleCall returns [EObject current=null] : iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF ;
    public final EObject entryRuleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleCall = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:260:58: (iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:261:2: iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall664);
            iv_ruleAbstractRuleCall=ruleAbstractRuleCall();
            _fsp--;

             current =iv_ruleAbstractRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleCall674); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:268:1: ruleAbstractRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:270:33: ( ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:271:1: ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:271:1: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:274:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("AbstractRuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:280:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalContentAssistTestLanguage.g:281:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRuleCall722); 
             
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


 

    public static final BitSet FOLLOW_ruleStart_in_entryRuleStart70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStart80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStart115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleStart149 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStart164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild376 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFirstAbstractRuleChild396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild431 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleFirstAbstractRuleChild446 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFirstAbstractRuleChild456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild491 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild550 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSecondAbstractRuleChild570 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSecondAbstractRuleChild580 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild615 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSecondAbstractRuleChild629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRuleCall722 = new BitSet(new long[]{0x0000000000000002L});

}