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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g"; }


     
     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, ContentAssistTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Start";	
       	} 



    // $ANTLR start entryRuleStart
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:70:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:70:47: (iv_ruleStart= ruleStart EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:71:2: iv_ruleStart= ruleStart EOF
            {
             currentNode = createCompositeNode(grammarAccess.prStart().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:78:1: ruleStart returns [EObject current=null] : ( ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ ) 'end' ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:83:6: ( ( ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ ) 'end' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:84:1: ( ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ ) 'end' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:84:1: ( ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ ) 'end' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:84:2: ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ ) 'end'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:84:2: ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:84:3: 'abstract rules' (lv_rules_1= ruleAbstractRule )+
            {
            match(input,11,FOLLOW_11_in_ruleStart117); 

                    createLeafNode(grammarAccess.prStart().ele00KeywordAbstractRules(), null); 
                
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:88:1: (lv_rules_1= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:91:6: lv_rules_1= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStart().ele010ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleStart151);
            	    lv_rules_1=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prStart().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "rules", lv_rules_1, "AbstractRule", currentNode);
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

                    createLeafNode(grammarAccess.prStart().ele1KeywordEnd(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:122:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:122:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:123:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRule().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:130:1: ruleAbstractRule returns [EObject current=null] : (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_FirstAbstractRuleChild_0 = null;

        EObject this_SecondAbstractRuleChild_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:135:6: ( (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:136:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:136:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
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
                        new NoViableAltException("136:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("136:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:137:5: this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele0ParserRuleCallFirstAbstractRuleChild(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule258);
                    this_FirstAbstractRuleChild_0=ruleFirstAbstractRuleChild();
                    _fsp--;

                     
                            current = this_FirstAbstractRuleChild_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:147:5: this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractRule().ele1ParserRuleCallSecondAbstractRuleChild(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule285);
                    this_SecondAbstractRuleChild_1=ruleSecondAbstractRuleChild();
                    _fsp--;

                     
                            current = this_SecondAbstractRuleChild_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:164:1: entryRuleFirstAbstractRuleChild returns [EObject current=null] : iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF ;
    public final EObject entryRuleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:164:64: (iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:165:2: iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFirstAbstractRuleChild().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:172:1: ruleFirstAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ ) ')' ) ';' ) ;
    public final EObject ruleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_elements_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:177:6: ( ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ ) ')' ) ';' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:1: ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ ) ')' ) ';' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:1: ( ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ ) ')' ) ';' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:2: ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ ) ')' ) ';'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:2: ( ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ ) ')' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:3: ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ ) ')'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:3: ( ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:4: ( (lv_name_0= RULE_ID ) '(' ) (lv_elements_2= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:4: ( (lv_name_0= RULE_ID ) '(' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:5: (lv_name_0= RULE_ID ) '('
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:5: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:180:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild378); 

            		createLeafNode(grammarAccess.prFirstAbstractRuleChild().ele00000ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prFirstAbstractRuleChild().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,13,FOLLOW_13_in_ruleFirstAbstractRuleChild394); 

                    createLeafNode(grammarAccess.prFirstAbstractRuleChild().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:201:2: (lv_elements_2= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:204:6: lv_elements_2= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prFirstAbstractRuleChild().ele0010ParserRuleCallAbstractRule(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild429);
            	    lv_elements_2=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prFirstAbstractRuleChild().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "elements", lv_elements_2, "AbstractRule", currentNode);
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

            match(input,14,FOLLOW_14_in_ruleFirstAbstractRuleChild444); 

                    createLeafNode(grammarAccess.prFirstAbstractRuleChild().ele01KeywordRightParenthesis(), null); 
                

            }

            match(input,15,FOLLOW_15_in_ruleFirstAbstractRuleChild454); 

                    createLeafNode(grammarAccess.prFirstAbstractRuleChild().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:1: entryRuleSecondAbstractRuleChild returns [EObject current=null] : iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF ;
    public final EObject entryRuleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:239:65: (iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:240:2: iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSecondAbstractRuleChild().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild489);
            iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild();
            _fsp--;

             current =iv_ruleSecondAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild499); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:247:1: ruleSecondAbstractRuleChild returns [EObject current=null] : ( ( ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' ) (lv_rule_3= ruleAbstractRuleCall ) ) ';' ) ;
    public final EObject ruleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_rule_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:252:6: ( ( ( ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' ) (lv_rule_3= ruleAbstractRuleCall ) ) ';' ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:1: ( ( ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' ) (lv_rule_3= ruleAbstractRuleCall ) ) ';' )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:1: ( ( ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' ) (lv_rule_3= ruleAbstractRuleCall ) ) ';' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:2: ( ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' ) (lv_rule_3= ruleAbstractRuleCall ) ) ';'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:2: ( ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' ) (lv_rule_3= ruleAbstractRuleCall ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:3: ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' ) (lv_rule_3= ruleAbstractRuleCall )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:3: ( ( (lv_name_0= RULE_ID ) 'rule' ) ':' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:4: ( (lv_name_0= RULE_ID ) 'rule' ) ':'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:4: ( (lv_name_0= RULE_ID ) 'rule' )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:5: (lv_name_0= RULE_ID ) 'rule'
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:253:5: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:255:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild548); 

            		createLeafNode(grammarAccess.prSecondAbstractRuleChild().ele00000ParserRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSecondAbstractRuleChild().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleSecondAbstractRuleChild564); 

                    createLeafNode(grammarAccess.prSecondAbstractRuleChild().ele0001KeywordRule(), null); 
                

            }

            match(input,17,FOLLOW_17_in_ruleSecondAbstractRuleChild574); 

                    createLeafNode(grammarAccess.prSecondAbstractRuleChild().ele001KeywordColon(), null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:280:2: (lv_rule_3= ruleAbstractRuleCall )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:283:6: lv_rule_3= ruleAbstractRuleCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prSecondAbstractRuleChild().ele010ParserRuleCallAbstractRuleCall(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild609);
            lv_rule_3=ruleAbstractRuleCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSecondAbstractRuleChild().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "rule", lv_rule_3, "AbstractRuleCall", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,15,FOLLOW_15_in_ruleSecondAbstractRuleChild623); 

                    createLeafNode(grammarAccess.prSecondAbstractRuleChild().ele1KeywordSemicolon(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:314:1: entryRuleAbstractRuleCall returns [EObject current=null] : iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF ;
    public final EObject entryRuleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleCall = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:314:58: (iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:315:2: iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractRuleCall().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall658);
            iv_ruleAbstractRuleCall=ruleAbstractRuleCall();
            _fsp--;

             current =iv_ruleAbstractRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleCall668); 

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
    // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:322:1: ruleAbstractRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:327:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:328:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:328:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:331:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prAbstractRuleCall().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRuleCall714); 

            		createLeafNode(grammarAccess.prAbstractRuleCall().ele0CrossReferenceEStringAbstractRule(), "rule"); 
            	

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    public static final BitSet FOLLOW_13_in_ruleFirstAbstractRuleChild394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild429 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleFirstAbstractRuleChild444 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFirstAbstractRuleChild454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild548 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSecondAbstractRuleChild564 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSecondAbstractRuleChild574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild609 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSecondAbstractRuleChild623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall658 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRuleCall714 = new BitSet(new long[]{0x0000000000000002L});

}