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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g"; }


     
     	private ContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistTestLanguageParser(TokenStream input, IAstFactory factory, ContentAssistTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:72:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:72:47: (iv_ruleStart= ruleStart EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:73:2: iv_ruleStart= ruleStart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStartRule(), currentNode); 
            pushFollow(FOLLOW_ruleStart_in_entryRuleStart73);
            iv_ruleStart=ruleStart();
            _fsp--;

             current =iv_ruleStart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStart83); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:80:1: ruleStart returns [EObject current=null] : ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ 'end' ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:85:6: ( ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ 'end' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:1: ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ 'end' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:1: ( 'abstract rules' (lv_rules_1= ruleAbstractRule )+ 'end' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:86:2: 'abstract rules' (lv_rules_1= ruleAbstractRule )+ 'end'
            {
            match(input,11,FOLLOW_11_in_ruleStart117); 

                    createLeafNode(grammarAccess.getStartAccess().getAbstractRulesKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:90:1: (lv_rules_1= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:93:6: lv_rules_1= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleStart151);
            	    lv_rules_1=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStartRule().getType().getClassifier());
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

            match(input,12,FOLLOW_12_in_ruleStart165); 

                    createLeafNode(grammarAccess.getStartAccess().getEndKeyword_2(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:122:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:122:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:123:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:130:1: ruleAbstractRule returns [EObject current=null] : (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_FirstAbstractRuleChild_0 = null;

        EObject this_SecondAbstractRuleChild_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:135:6: ( (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:136:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:136:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:137:5: this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule255);
                    this_FirstAbstractRuleChild_0=ruleFirstAbstractRuleChild();
                    _fsp--;

                     
                            current = this_FirstAbstractRuleChild_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:147:5: this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule282);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:162:1: entryRuleFirstAbstractRuleChild returns [EObject current=null] : iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF ;
    public final EObject entryRuleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:162:64: (iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:163:2: iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFirstAbstractRuleChildRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:170:1: ruleFirstAbstractRuleChild returns [EObject current=null] : ( (lv_name_0= RULE_ID ) '(' (lv_elements_2= ruleAbstractRule )+ ')' ';' ) ;
    public final EObject ruleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_elements_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:175:6: ( ( (lv_name_0= RULE_ID ) '(' (lv_elements_2= ruleAbstractRule )+ ')' ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:176:1: ( (lv_name_0= RULE_ID ) '(' (lv_elements_2= ruleAbstractRule )+ ')' ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:176:1: ( (lv_name_0= RULE_ID ) '(' (lv_elements_2= ruleAbstractRule )+ ')' ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:176:2: (lv_name_0= RULE_ID ) '(' (lv_elements_2= ruleAbstractRule )+ ')' ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:176:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:178:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild371); 

            		createLeafNode(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFirstAbstractRuleChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,13,FOLLOW_13_in_ruleFirstAbstractRuleChild388); 

                    createLeafNode(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:200:1: (lv_elements_2= ruleAbstractRule )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:203:6: lv_elements_2= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild422);
            	    lv_elements_2=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFirstAbstractRuleChildRule().getType().getClassifier());
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

            match(input,14,FOLLOW_14_in_ruleFirstAbstractRuleChild436); 

                    createLeafNode(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3(), null); 
                
            match(input,15,FOLLOW_15_in_ruleFirstAbstractRuleChild445); 

                    createLeafNode(grammarAccess.getFirstAbstractRuleChildAccess().getSemicolonKeyword_4(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:236:1: entryRuleSecondAbstractRuleChild returns [EObject current=null] : iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF ;
    public final EObject entryRuleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:236:65: (iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:237:2: iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondAbstractRuleChildRule(), currentNode); 
            pushFollow(FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild478);
            iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild();
            _fsp--;

             current =iv_ruleSecondAbstractRuleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild488); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:244:1: ruleSecondAbstractRuleChild returns [EObject current=null] : ( (lv_name_0= RULE_ID ) 'rule' ':' (lv_rule_3= ruleAbstractRuleCall ) ';' ) ;
    public final EObject ruleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_rule_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:249:6: ( ( (lv_name_0= RULE_ID ) 'rule' ':' (lv_rule_3= ruleAbstractRuleCall ) ';' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:250:1: ( (lv_name_0= RULE_ID ) 'rule' ':' (lv_rule_3= ruleAbstractRuleCall ) ';' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:250:1: ( (lv_name_0= RULE_ID ) 'rule' ':' (lv_rule_3= ruleAbstractRuleCall ) ';' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:250:2: (lv_name_0= RULE_ID ) 'rule' ':' (lv_rule_3= ruleAbstractRuleCall ) ';'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:250:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:252:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild535); 

            		createLeafNode(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSecondAbstractRuleChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleSecondAbstractRuleChild552); 

                    createLeafNode(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1(), null); 
                
            match(input,17,FOLLOW_17_in_ruleSecondAbstractRuleChild561); 

                    createLeafNode(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:278:1: (lv_rule_3= ruleAbstractRuleCall )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:281:6: lv_rule_3= ruleAbstractRuleCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild595);
            lv_rule_3=ruleAbstractRuleCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSecondAbstractRuleChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "rule", lv_rule_3, "AbstractRuleCall", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,15,FOLLOW_15_in_ruleSecondAbstractRuleChild608); 

                    createLeafNode(grammarAccess.getSecondAbstractRuleChildAccess().getSemicolonKeyword_4(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:310:1: entryRuleAbstractRuleCall returns [EObject current=null] : iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF ;
    public final EObject entryRuleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleCall = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:310:58: (iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:311:2: iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall641);
            iv_ruleAbstractRuleCall=ruleAbstractRuleCall();
            _fsp--;

             current =iv_ruleAbstractRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleCall651); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:318:1: ruleAbstractRuleCall returns [EObject current=null] : ( RULE_ID ) ;
    public final EObject ruleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:323:6: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:324:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:324:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:327:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAbstractRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbstractRuleCall697); 

            		createLeafNode(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0(), "rule"); 
            	
             lastConsumedDatatypeToken = null; 

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


 

    public static final BitSet FOLLOW_ruleStart_in_entryRuleStart73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStart83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStart117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleStart151 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStart165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild371 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFirstAbstractRuleChild388 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild422 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleFirstAbstractRuleChild436 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFirstAbstractRuleChild445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild535 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSecondAbstractRuleChild552 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSecondAbstractRuleChild561 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild595 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSecondAbstractRuleChild608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRuleCall697 = new BitSet(new long[]{0x0000000000000002L});

}