package org.eclipse.xtext.ui.common.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.common.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalContentAssistContextTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A1'", "'A2'", "'B1'", "'B2'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalContentAssistContextTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g"; }


     
     	private ContentAssistContextTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistContextTestLanguageParser(TokenStream input, IAstFactory factory, ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "FirstLevel";	
       	} 



    // $ANTLR start entryRuleFirstLevel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:72:1: entryRuleFirstLevel returns [EObject current=null] : iv_ruleFirstLevel= ruleFirstLevel EOF ;
    public final EObject entryRuleFirstLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstLevel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:72:52: (iv_ruleFirstLevel= ruleFirstLevel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:73:2: iv_ruleFirstLevel= ruleFirstLevel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFirstLevelRule(), currentNode); 
            pushFollow(FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel73);
            iv_ruleFirstLevel=ruleFirstLevel();
            _fsp--;

             current =iv_ruleFirstLevel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstLevel83); 

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
    // $ANTLR end entryRuleFirstLevel


    // $ANTLR start ruleFirstLevel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:80:1: ruleFirstLevel returns [EObject current=null] : ( (lv_secondLevelA_0= ruleSecondLevelA )* (lv_secondLevelB_1= ruleSecondLevelB )* ) ;
    public final EObject ruleFirstLevel() throws RecognitionException {
        EObject current = null;

        EObject lv_secondLevelA_0 = null;

        EObject lv_secondLevelB_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:85:6: ( ( (lv_secondLevelA_0= ruleSecondLevelA )* (lv_secondLevelB_1= ruleSecondLevelB )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:1: ( (lv_secondLevelA_0= ruleSecondLevelA )* (lv_secondLevelB_1= ruleSecondLevelB )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:1: ( (lv_secondLevelA_0= ruleSecondLevelA )* (lv_secondLevelB_1= ruleSecondLevelB )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:2: (lv_secondLevelA_0= ruleSecondLevelA )* (lv_secondLevelB_1= ruleSecondLevelB )*
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:2: (lv_secondLevelA_0= ruleSecondLevelA )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:89:6: lv_secondLevelA_0= ruleSecondLevelA
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSecondLevelA_in_ruleFirstLevel142);
            	    lv_secondLevelA_0=ruleSecondLevelA();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFirstLevelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "secondLevelA", lv_secondLevelA_0, "SecondLevelA", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:107:3: (lv_secondLevelB_1= ruleSecondLevelB )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:110:6: lv_secondLevelB_1= ruleSecondLevelB
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSecondLevelB_in_ruleFirstLevel181);
            	    lv_secondLevelB_1=ruleSecondLevelB();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFirstLevelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "secondLevelB", lv_secondLevelB_1, "SecondLevelB", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end ruleFirstLevel


    // $ANTLR start entryRuleSecondLevelA
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:135:1: entryRuleSecondLevelA returns [EObject current=null] : iv_ruleSecondLevelA= ruleSecondLevelA EOF ;
    public final EObject entryRuleSecondLevelA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondLevelA = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:135:54: (iv_ruleSecondLevelA= ruleSecondLevelA EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:136:2: iv_ruleSecondLevelA= ruleSecondLevelA EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondLevelARule(), currentNode); 
            pushFollow(FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA219);
            iv_ruleSecondLevelA=ruleSecondLevelA();
            _fsp--;

             current =iv_ruleSecondLevelA; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondLevelA229); 

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
    // $ANTLR end entryRuleSecondLevelA


    // $ANTLR start ruleSecondLevelA
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:143:1: ruleSecondLevelA returns [EObject current=null] : ( (lv_thirdLevelA1_0= ruleThirdLevelA1 )+ (lv_thirdLevelA2_1= ruleThirdLevelA2 )+ ) ;
    public final EObject ruleSecondLevelA() throws RecognitionException {
        EObject current = null;

        EObject lv_thirdLevelA1_0 = null;

        EObject lv_thirdLevelA2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:148:6: ( ( (lv_thirdLevelA1_0= ruleThirdLevelA1 )+ (lv_thirdLevelA2_1= ruleThirdLevelA2 )+ ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:149:1: ( (lv_thirdLevelA1_0= ruleThirdLevelA1 )+ (lv_thirdLevelA2_1= ruleThirdLevelA2 )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:149:1: ( (lv_thirdLevelA1_0= ruleThirdLevelA1 )+ (lv_thirdLevelA2_1= ruleThirdLevelA2 )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:149:2: (lv_thirdLevelA1_0= ruleThirdLevelA1 )+ (lv_thirdLevelA2_1= ruleThirdLevelA2 )+
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:149:2: (lv_thirdLevelA1_0= ruleThirdLevelA1 )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:152:6: lv_thirdLevelA1_0= ruleThirdLevelA1
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleThirdLevelA1_in_ruleSecondLevelA288);
            	    lv_thirdLevelA1_0=ruleThirdLevelA1();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelARule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "thirdLevelA1", lv_thirdLevelA1_0, "ThirdLevelA1", currentNode);
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

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:170:3: (lv_thirdLevelA2_1= ruleThirdLevelA2 )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:173:6: lv_thirdLevelA2_1= ruleThirdLevelA2
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleThirdLevelA2_in_ruleSecondLevelA327);
            	    lv_thirdLevelA2_1=ruleThirdLevelA2();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelARule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "thirdLevelA2", lv_thirdLevelA2_1, "ThirdLevelA2", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


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
    // $ANTLR end ruleSecondLevelA


    // $ANTLR start entryRuleSecondLevelB
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:198:1: entryRuleSecondLevelB returns [EObject current=null] : iv_ruleSecondLevelB= ruleSecondLevelB EOF ;
    public final EObject entryRuleSecondLevelB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondLevelB = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:198:54: (iv_ruleSecondLevelB= ruleSecondLevelB EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:199:2: iv_ruleSecondLevelB= ruleSecondLevelB EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondLevelBRule(), currentNode); 
            pushFollow(FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB365);
            iv_ruleSecondLevelB=ruleSecondLevelB();
            _fsp--;

             current =iv_ruleSecondLevelB; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondLevelB375); 

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
    // $ANTLR end entryRuleSecondLevelB


    // $ANTLR start ruleSecondLevelB
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:206:1: ruleSecondLevelB returns [EObject current=null] : ( (lv_thirdLevelB1_0= ruleThirdLevelB1 )+ (lv_thirdLevelB2_1= ruleThirdLevelB2 )+ ) ;
    public final EObject ruleSecondLevelB() throws RecognitionException {
        EObject current = null;

        EObject lv_thirdLevelB1_0 = null;

        EObject lv_thirdLevelB2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:211:6: ( ( (lv_thirdLevelB1_0= ruleThirdLevelB1 )+ (lv_thirdLevelB2_1= ruleThirdLevelB2 )+ ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:212:1: ( (lv_thirdLevelB1_0= ruleThirdLevelB1 )+ (lv_thirdLevelB2_1= ruleThirdLevelB2 )+ )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:212:1: ( (lv_thirdLevelB1_0= ruleThirdLevelB1 )+ (lv_thirdLevelB2_1= ruleThirdLevelB2 )+ )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:212:2: (lv_thirdLevelB1_0= ruleThirdLevelB1 )+ (lv_thirdLevelB2_1= ruleThirdLevelB2 )+
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:212:2: (lv_thirdLevelB1_0= ruleThirdLevelB1 )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:215:6: lv_thirdLevelB1_0= ruleThirdLevelB1
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleThirdLevelB1_in_ruleSecondLevelB434);
            	    lv_thirdLevelB1_0=ruleThirdLevelB1();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelBRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "thirdLevelB1", lv_thirdLevelB1_0, "ThirdLevelB1", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:233:3: (lv_thirdLevelB2_1= ruleThirdLevelB2 )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:236:6: lv_thirdLevelB2_1= ruleThirdLevelB2
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleThirdLevelB2_in_ruleSecondLevelB473);
            	    lv_thirdLevelB2_1=ruleThirdLevelB2();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelBRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "thirdLevelB2", lv_thirdLevelB2_1, "ThirdLevelB2", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


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
    // $ANTLR end ruleSecondLevelB


    // $ANTLR start entryRuleThirdLevelA1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:261:1: entryRuleThirdLevelA1 returns [EObject current=null] : iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF ;
    public final EObject entryRuleThirdLevelA1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelA1 = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:261:54: (iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:262:2: iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelA1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1511);
            iv_ruleThirdLevelA1=ruleThirdLevelA1();
            _fsp--;

             current =iv_ruleThirdLevelA1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelA1521); 

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
    // $ANTLR end entryRuleThirdLevelA1


    // $ANTLR start ruleThirdLevelA1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:269:1: ruleThirdLevelA1 returns [EObject current=null] : ( 'A1' () (lv_name_2= RULE_ID )? ) ;
    public final EObject ruleThirdLevelA1() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:274:6: ( ( 'A1' () (lv_name_2= RULE_ID )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:275:1: ( 'A1' () (lv_name_2= RULE_ID )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:275:1: ( 'A1' () (lv_name_2= RULE_ID )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:275:2: 'A1' () (lv_name_2= RULE_ID )?
            {
            match(input,11,FOLLOW_11_in_ruleThirdLevelA1555); 

                    createLeafNode(grammarAccess.getThirdLevelA1Access().getA1Keyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:279:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:280:5: 
            {
             
                    temp=factory.create(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getThirdLevelA1Access().getThirdLevelA1Action_1(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:290:2: (lv_name_2= RULE_ID )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:292:6: lv_name_2= RULE_ID
                    {
                    lv_name_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleThirdLevelA1586); 

                    		createLeafNode(grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelA1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

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
    // $ANTLR end ruleThirdLevelA1


    // $ANTLR start entryRuleThirdLevelA2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:317:1: entryRuleThirdLevelA2 returns [EObject current=null] : iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF ;
    public final EObject entryRuleThirdLevelA2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelA2 = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:317:54: (iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:318:2: iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelA2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2628);
            iv_ruleThirdLevelA2=ruleThirdLevelA2();
            _fsp--;

             current =iv_ruleThirdLevelA2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelA2638); 

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
    // $ANTLR end entryRuleThirdLevelA2


    // $ANTLR start ruleThirdLevelA2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:325:1: ruleThirdLevelA2 returns [EObject current=null] : ( 'A2' () (lv_name_2= RULE_ID )? ) ;
    public final EObject ruleThirdLevelA2() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:330:6: ( ( 'A2' () (lv_name_2= RULE_ID )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:331:1: ( 'A2' () (lv_name_2= RULE_ID )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:331:1: ( 'A2' () (lv_name_2= RULE_ID )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:331:2: 'A2' () (lv_name_2= RULE_ID )?
            {
            match(input,12,FOLLOW_12_in_ruleThirdLevelA2672); 

                    createLeafNode(grammarAccess.getThirdLevelA2Access().getA2Keyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:335:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:336:5: 
            {
             
                    temp=factory.create(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getThirdLevelA2Access().getThirdLevelA2Action_1(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:346:2: (lv_name_2= RULE_ID )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:348:6: lv_name_2= RULE_ID
                    {
                    lv_name_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleThirdLevelA2703); 

                    		createLeafNode(grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelA2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

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
    // $ANTLR end ruleThirdLevelA2


    // $ANTLR start entryRuleThirdLevelB1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:373:1: entryRuleThirdLevelB1 returns [EObject current=null] : iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF ;
    public final EObject entryRuleThirdLevelB1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelB1 = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:373:54: (iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:374:2: iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelB1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1745);
            iv_ruleThirdLevelB1=ruleThirdLevelB1();
            _fsp--;

             current =iv_ruleThirdLevelB1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelB1755); 

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
    // $ANTLR end entryRuleThirdLevelB1


    // $ANTLR start ruleThirdLevelB1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:381:1: ruleThirdLevelB1 returns [EObject current=null] : ( 'B1' () (lv_name_2= RULE_ID )? ) ;
    public final EObject ruleThirdLevelB1() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:386:6: ( ( 'B1' () (lv_name_2= RULE_ID )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:387:1: ( 'B1' () (lv_name_2= RULE_ID )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:387:1: ( 'B1' () (lv_name_2= RULE_ID )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:387:2: 'B1' () (lv_name_2= RULE_ID )?
            {
            match(input,13,FOLLOW_13_in_ruleThirdLevelB1789); 

                    createLeafNode(grammarAccess.getThirdLevelB1Access().getB1Keyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:391:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:392:5: 
            {
             
                    temp=factory.create(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getThirdLevelB1Access().getThirdLevelB1Action_1(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:402:2: (lv_name_2= RULE_ID )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:404:6: lv_name_2= RULE_ID
                    {
                    lv_name_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleThirdLevelB1820); 

                    		createLeafNode(grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelB1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

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
    // $ANTLR end ruleThirdLevelB1


    // $ANTLR start entryRuleThirdLevelB2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:429:1: entryRuleThirdLevelB2 returns [EObject current=null] : iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF ;
    public final EObject entryRuleThirdLevelB2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelB2 = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:429:54: (iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:430:2: iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelB2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2862);
            iv_ruleThirdLevelB2=ruleThirdLevelB2();
            _fsp--;

             current =iv_ruleThirdLevelB2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThirdLevelB2872); 

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
    // $ANTLR end entryRuleThirdLevelB2


    // $ANTLR start ruleThirdLevelB2
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:437:1: ruleThirdLevelB2 returns [EObject current=null] : ( 'B2' () (lv_name_2= RULE_ID )? ) ;
    public final EObject ruleThirdLevelB2() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:442:6: ( ( 'B2' () (lv_name_2= RULE_ID )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:443:1: ( 'B2' () (lv_name_2= RULE_ID )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:443:1: ( 'B2' () (lv_name_2= RULE_ID )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:443:2: 'B2' () (lv_name_2= RULE_ID )?
            {
            match(input,14,FOLLOW_14_in_ruleThirdLevelB2906); 

                    createLeafNode(grammarAccess.getThirdLevelB2Access().getB2Keyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:447:1: ()
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:448:5: 
            {
             
                    temp=factory.create(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getThirdLevelB2Access().getThirdLevelB2Action_1(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:458:2: (lv_name_2= RULE_ID )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:460:6: lv_name_2= RULE_ID
                    {
                    lv_name_2=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleThirdLevelB2937); 

                    		createLeafNode(grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelB2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

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
    // $ANTLR end ruleThirdLevelB2


 

    public static final BitSet FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstLevel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondLevelA_in_ruleFirstLevel142 = new BitSet(new long[]{0x0000000000002802L});
    public static final BitSet FOLLOW_ruleSecondLevelB_in_ruleFirstLevel181 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelA229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA1_in_ruleSecondLevelA288 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleThirdLevelA2_in_ruleSecondLevelA327 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelB375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB1_in_ruleSecondLevelB434 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_ruleThirdLevelB2_in_ruleSecondLevelB473 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleThirdLevelA1555 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelA1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleThirdLevelA2672 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelA2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleThirdLevelB1789 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelB1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleThirdLevelB2906 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelB2937 = new BitSet(new long[]{0x0000000000000002L});

}