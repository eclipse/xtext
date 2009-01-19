// $ANTLR 3.0.1 ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g 2009-01-19 15:14:57

package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalContentAssistTestLanguageParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g"; }


     
        public InternalContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalContentAssistTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Start";	
       	} 



    // $ANTLR start entryRuleStart
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:67:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:67:47: (iv_ruleStart= ruleStart EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:68:2: iv_ruleStart= ruleStart EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleStart_in_entryRuleStart72);
            iv_ruleStart=ruleStart();
            _fsp--;

             current =iv_ruleStart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStart82); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:75:1: ruleStart returns [EObject current=null] : ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        EObject lv_rules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:77:33: ( ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:78:1: ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:78:1: ( ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:78:2: ( 'abstract rules' (lv_rules= ruleAbstractRule )+ ) 'end'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:78:2: ( 'abstract rules' (lv_rules= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:78:3: 'abstract rules' (lv_rules= ruleAbstractRule )+
            {
            match(input,11,FOLLOW_11_in_ruleStart117); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:82:1: (lv_rules= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:85:6: lv_rules= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleStart151);
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

            match(input,12,FOLLOW_12_in_ruleStart166); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:116:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:116:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:117:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule201);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule211); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:124:1: ruleAbstractRule returns [EObject current=null] : (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_FirstAbstractRuleChild = null;

        EObject this_SecondAbstractRuleChild = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:126:33: ( (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:127:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:127:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )
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
                        new NoViableAltException("127:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("127:1: (this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:128:5: this_FirstAbstractRuleChild= ruleFirstAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule258);
                    this_FirstAbstractRuleChild=ruleFirstAbstractRuleChild();
                    _fsp--;

                     
                            current = this_FirstAbstractRuleChild; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:138:5: this_SecondAbstractRuleChild= ruleSecondAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule285);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:155:1: entryRuleFirstAbstractRuleChild returns [EObject current=null] : iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF ;
    public final EObject entryRuleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:155:64: (iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:156:2: iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild319);
            iv_ruleFirstAbstractRuleChild=ruleFirstAbstractRuleChild();
            _fsp--;

             current =iv_ruleFirstAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild329); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:1: ruleFirstAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' ) ;
    public final EObject ruleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_elements = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:165:33: ( ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:1: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:1: ( ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:2: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:2: ( ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:3: ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ ) ')'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:3: ( ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:4: ( (lv_name= RULE_ID ) '(' ) (lv_elements= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:4: ( (lv_name= RULE_ID ) '(' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:5: (lv_name= RULE_ID ) '('
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:166:5: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:168:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild378); 
             
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

            match(input,13,FOLLOW_13_in_ruleFirstAbstractRuleChild398); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:190:2: (lv_elements= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:193:6: lv_elements= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild433);
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

            match(input,14,FOLLOW_14_in_ruleFirstAbstractRuleChild448); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,15,FOLLOW_15_in_ruleFirstAbstractRuleChild458); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:228:1: entryRuleSecondAbstractRuleChild returns [EObject current=null] : iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF ;
    public final EObject entryRuleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:228:65: (iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:229:2: iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild493);
            iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild();
            _fsp--;

             current =iv_ruleSecondAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild503); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:236:1: ruleSecondAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' ) ;
    public final EObject ruleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_rule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:238:33: ( ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:1: ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:1: ( ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:2: ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:2: ( ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:3: ( ( (lv_name= RULE_ID ) 'rule' ) ':' ) (lv_rule= ruleAbstractRuleCall )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:3: ( ( (lv_name= RULE_ID ) 'rule' ) ':' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:4: ( (lv_name= RULE_ID ) 'rule' ) ':'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:4: ( (lv_name= RULE_ID ) 'rule' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:5: (lv_name= RULE_ID ) 'rule'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:5: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:241:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild552); 
             
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

            match(input,16,FOLLOW_16_in_ruleSecondAbstractRuleChild572); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,17,FOLLOW_17_in_ruleSecondAbstractRuleChild582); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:267:2: (lv_rule= ruleAbstractRuleCall )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:270:6: lv_rule= ruleAbstractRuleCall
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild617);
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

            match(input,15,FOLLOW_15_in_ruleSecondAbstractRuleChild631); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:301:1: entryRuleAbstractRuleCall returns [EObject current=null] : iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF ;
    public final EObject entryRuleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:301:58: (iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:302:2: iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall666);
            iv_ruleAbstractRuleCall=ruleAbstractRuleCall();
            _fsp--;

             current =iv_ruleAbstractRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleCall676); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:309:1: ruleAbstractRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:311:33: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:312:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:312:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:315:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("AbstractRuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:321:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:322:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRuleCall724); 
             
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


 

    public static final BitSet FOLLOW_ruleStart_in_entryRuleStart72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStart82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStart117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleStart151 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStart166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild378 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFirstAbstractRuleChild398 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild433 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleFirstAbstractRuleChild448 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFirstAbstractRuleChild458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild493 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild552 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSecondAbstractRuleChild572 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSecondAbstractRuleChild582 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild617 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSecondAbstractRuleChild631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRuleCall724 = new BitSet(new long[]{0x0000000000000002L});

}