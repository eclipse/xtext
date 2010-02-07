package org.eclipse.xtext.ui.tests.testlanguages.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.testlanguages.services.ContentAssistTestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g"; }



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
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Start";	
       	} 



    // $ANTLR start entryRuleStart
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:72:1: entryRuleStart returns [EObject current=null] : iv_ruleStart= ruleStart EOF ;
    public final EObject entryRuleStart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStart = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:73:2: (iv_ruleStart= ruleStart EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:74:2: iv_ruleStart= ruleStart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStartRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleStart_in_entryRuleStart75);
            iv_ruleStart=ruleStart();
            _fsp--;

             current =iv_ruleStart; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStart85); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:81:1: ruleStart returns [EObject current=null] : ( 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ 'end' ) ;
    public final EObject ruleStart() throws RecognitionException {
        EObject current = null;

        EObject lv_rules_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:87:6: ( ( 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:88:1: ( 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:88:1: ( 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:88:3: 'abstract rules' ( (lv_rules_1_0= ruleAbstractRule ) )+ 'end'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleStart120); 

                    createLeafNode(grammarAccess.getStartAccess().getAbstractRulesKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:92:1: ( (lv_rules_1_0= ruleAbstractRule ) )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:93:1: (lv_rules_1_0= ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:93:1: (lv_rules_1_0= ruleAbstractRule )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:94:3: lv_rules_1_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStartAccess().getRulesAbstractRuleParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleStart141);
            	    lv_rules_1_0=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStartRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"rules",
            	    	        		lv_rules_1_0, 
            	    	        		"AbstractRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleStart152); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:128:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:129:2: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:130:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule188);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule198); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:137:1: ruleAbstractRule returns [EObject current=null] : (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_FirstAbstractRuleChild_0 = null;

        EObject this_SecondAbstractRuleChild_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:143:6: ( (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:144:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:144:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==16) ) {
                    alt2=2;
                }
                else if ( (LA2_1==13) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("144:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("144:1: (this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild | this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:145:5: this_FirstAbstractRuleChild_0= ruleFirstAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getFirstAbstractRuleChildParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule245);
                    this_FirstAbstractRuleChild_0=ruleFirstAbstractRuleChild();
                    _fsp--;

                     
                            current = this_FirstAbstractRuleChild_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:155:5: this_SecondAbstractRuleChild_1= ruleSecondAbstractRuleChild
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractRuleAccess().getSecondAbstractRuleChildParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule272);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:171:1: entryRuleFirstAbstractRuleChild returns [EObject current=null] : iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF ;
    public final EObject entryRuleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:172:2: (iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:173:2: iv_ruleFirstAbstractRuleChild= ruleFirstAbstractRuleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFirstAbstractRuleChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild307);
            iv_ruleFirstAbstractRuleChild=ruleFirstAbstractRuleChild();
            _fsp--;

             current =iv_ruleFirstAbstractRuleChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild317); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:180:1: ruleFirstAbstractRuleChild returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ ')' ';' ) ;
    public final EObject ruleFirstAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_elements_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:186:6: ( ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ ')' ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:187:1: ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ ')' ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:187:1: ( ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ ')' ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:187:2: ( (lv_name_0_0= RULE_ID ) ) '(' ( (lv_elements_2_0= ruleAbstractRule ) )+ ')' ';'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:187:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:188:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:188:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:189:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild359); 

            			createLeafNode(grammarAccess.getFirstAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFirstAbstractRuleChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,13,FollowSets000.FOLLOW_13_in_ruleFirstAbstractRuleChild374); 

                    createLeafNode(grammarAccess.getFirstAbstractRuleChildAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:215:1: ( (lv_elements_2_0= ruleAbstractRule ) )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:216:1: (lv_elements_2_0= ruleAbstractRule )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:216:1: (lv_elements_2_0= ruleAbstractRule )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:217:3: lv_elements_2_0= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFirstAbstractRuleChildAccess().getElementsAbstractRuleParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild395);
            	    lv_elements_2_0=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFirstAbstractRuleChildRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_2_0, 
            	    	        		"AbstractRule", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleFirstAbstractRuleChild406); 

                    createLeafNode(grammarAccess.getFirstAbstractRuleChildAccess().getRightParenthesisKeyword_3(), null); 
                
            match(input,15,FollowSets000.FOLLOW_15_in_ruleFirstAbstractRuleChild416); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:255:1: entryRuleSecondAbstractRuleChild returns [EObject current=null] : iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF ;
    public final EObject entryRuleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondAbstractRuleChild = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:256:2: (iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:257:2: iv_ruleSecondAbstractRuleChild= ruleSecondAbstractRuleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondAbstractRuleChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild452);
            iv_ruleSecondAbstractRuleChild=ruleSecondAbstractRuleChild();
            _fsp--;

             current =iv_ruleSecondAbstractRuleChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild462); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:264:1: ruleSecondAbstractRuleChild returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) 'rule' ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) ';' ) ;
    public final EObject ruleSecondAbstractRuleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_rule_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:270:6: ( ( ( (lv_name_0_0= RULE_ID ) ) 'rule' ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:271:1: ( ( (lv_name_0_0= RULE_ID ) ) 'rule' ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:271:1: ( ( (lv_name_0_0= RULE_ID ) ) 'rule' ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:271:2: ( (lv_name_0_0= RULE_ID ) ) 'rule' ':' ( (lv_rule_3_0= ruleAbstractRuleCall ) ) ';'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:271:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:272:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:272:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:273:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild504); 

            			createLeafNode(grammarAccess.getSecondAbstractRuleChildAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSecondAbstractRuleChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleSecondAbstractRuleChild519); 

                    createLeafNode(grammarAccess.getSecondAbstractRuleChildAccess().getRuleKeyword_1(), null); 
                
            match(input,17,FollowSets000.FOLLOW_17_in_ruleSecondAbstractRuleChild529); 

                    createLeafNode(grammarAccess.getSecondAbstractRuleChildAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:303:1: ( (lv_rule_3_0= ruleAbstractRuleCall ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:304:1: (lv_rule_3_0= ruleAbstractRuleCall )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:304:1: (lv_rule_3_0= ruleAbstractRuleCall )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:305:3: lv_rule_3_0= ruleAbstractRuleCall
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSecondAbstractRuleChildAccess().getRuleAbstractRuleCallParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild550);
            lv_rule_3_0=ruleAbstractRuleCall();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSecondAbstractRuleChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"rule",
            	        		lv_rule_3_0, 
            	        		"AbstractRuleCall", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,15,FollowSets000.FOLLOW_15_in_ruleSecondAbstractRuleChild560); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:339:1: entryRuleAbstractRuleCall returns [EObject current=null] : iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF ;
    public final EObject entryRuleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleCall = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:340:2: (iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:341:2: iv_ruleAbstractRuleCall= ruleAbstractRuleCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRuleCallRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall596);
            iv_ruleAbstractRuleCall=ruleAbstractRuleCall();
            _fsp--;

             current =iv_ruleAbstractRuleCall; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRuleCall606); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:348:1: ruleAbstractRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleAbstractRuleCall() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 

            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:354:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:355:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:355:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:356:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:356:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/testlanguages/parser/antlr/internal/InternalContentAssistTestLanguage.g:357:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAbstractRuleCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAbstractRuleCall648); 

            		createLeafNode(grammarAccess.getAbstractRuleCallAccess().getRuleAbstractRuleCrossReference_0(), "rule"); 
            	

            }


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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleStart_in_entryRuleStart75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStart85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleStart120 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleStart141 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleStart152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule188 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_ruleAbstractRule245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_ruleAbstractRule272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstAbstractRuleChild_in_entryRuleFirstAbstractRuleChild307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstAbstractRuleChild317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFirstAbstractRuleChild359 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleFirstAbstractRuleChild374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleFirstAbstractRuleChild395 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleFirstAbstractRuleChild406 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleFirstAbstractRuleChild416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondAbstractRuleChild_in_entryRuleSecondAbstractRuleChild452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondAbstractRuleChild462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecondAbstractRuleChild504 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSecondAbstractRuleChild519 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSecondAbstractRuleChild529 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAbstractRuleCall_in_ruleSecondAbstractRuleChild550 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSecondAbstractRuleChild560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRuleCall_in_entryRuleAbstractRuleCall596 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleCall606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAbstractRuleCall648 = new BitSet(new long[]{0x0000000000000002L});
    }


}