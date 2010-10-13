package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistContextTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistContextTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'A1'", "'A2'", "'B1'", "'B2'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalContentAssistContextTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistContextTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistContextTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g"; }



     	private ContentAssistContextTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistContextTestLanguageParser(TokenStream input, IAstFactory factory, ContentAssistContextTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "FirstLevel";	
       	}
       	
       	@Override
       	protected ContentAssistContextTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFirstLevel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:71:1: entryRuleFirstLevel returns [EObject current=null] : iv_ruleFirstLevel= ruleFirstLevel EOF ;
    public final EObject entryRuleFirstLevel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstLevel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:72:2: (iv_ruleFirstLevel= ruleFirstLevel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:73:2: iv_ruleFirstLevel= ruleFirstLevel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFirstLevelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel75);
            iv_ruleFirstLevel=ruleFirstLevel();

            state._fsp--;

             current =iv_ruleFirstLevel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstLevel85); 

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
    // $ANTLR end "entryRuleFirstLevel"


    // $ANTLR start "ruleFirstLevel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:80:1: ruleFirstLevel returns [EObject current=null] : ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* ) ;
    public final EObject ruleFirstLevel() throws RecognitionException {
        EObject current = null;

        EObject lv_secondLevelA_0_0 = null;

        EObject lv_secondLevelB_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:85:6: ( ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:1: ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:1: ( ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:2: ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )* ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:86:2: ( (lv_secondLevelA_0_0= ruleSecondLevelA ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:87:1: (lv_secondLevelA_0_0= ruleSecondLevelA )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:87:1: (lv_secondLevelA_0_0= ruleSecondLevelA )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:88:3: lv_secondLevelA_0_0= ruleSecondLevelA
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFirstLevelAccess().getSecondLevelASecondLevelAParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSecondLevelA_in_ruleFirstLevel131);
            	    lv_secondLevelA_0_0=ruleSecondLevelA();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFirstLevelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"secondLevelA",
            	    	        		lv_secondLevelA_0_0, 
            	    	        		"SecondLevelA", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:110:3: ( (lv_secondLevelB_1_0= ruleSecondLevelB ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:111:1: (lv_secondLevelB_1_0= ruleSecondLevelB )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:111:1: (lv_secondLevelB_1_0= ruleSecondLevelB )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:112:3: lv_secondLevelB_1_0= ruleSecondLevelB
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFirstLevelAccess().getSecondLevelBSecondLevelBParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSecondLevelB_in_ruleFirstLevel153);
            	    lv_secondLevelB_1_0=ruleSecondLevelB();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFirstLevelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"secondLevelB",
            	    	        		lv_secondLevelB_1_0, 
            	    	        		"SecondLevelB", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // $ANTLR end "ruleFirstLevel"


    // $ANTLR start "entryRuleSecondLevelA"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:142:1: entryRuleSecondLevelA returns [EObject current=null] : iv_ruleSecondLevelA= ruleSecondLevelA EOF ;
    public final EObject entryRuleSecondLevelA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondLevelA = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:143:2: (iv_ruleSecondLevelA= ruleSecondLevelA EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:144:2: iv_ruleSecondLevelA= ruleSecondLevelA EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondLevelARule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA190);
            iv_ruleSecondLevelA=ruleSecondLevelA();

            state._fsp--;

             current =iv_ruleSecondLevelA; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondLevelA200); 

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
    // $ANTLR end "entryRuleSecondLevelA"


    // $ANTLR start "ruleSecondLevelA"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:151:1: ruleSecondLevelA returns [EObject current=null] : ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ ) ;
    public final EObject ruleSecondLevelA() throws RecognitionException {
        EObject current = null;

        EObject lv_thirdLevelA1_0_0 = null;

        EObject lv_thirdLevelA2_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:156:6: ( ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:157:1: ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:157:1: ( ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:157:2: ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+ ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:157:2: ( (lv_thirdLevelA1_0_0= ruleThirdLevelA1 ) )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:158:1: (lv_thirdLevelA1_0_0= ruleThirdLevelA1 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:158:1: (lv_thirdLevelA1_0_0= ruleThirdLevelA1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:159:3: lv_thirdLevelA1_0_0= ruleThirdLevelA1
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelAAccess().getThirdLevelA1ThirdLevelA1ParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA1_in_ruleSecondLevelA246);
            	    lv_thirdLevelA1_0_0=ruleThirdLevelA1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelARule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"thirdLevelA1",
            	    	        		lv_thirdLevelA1_0_0, 
            	    	        		"ThirdLevelA1", 
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:181:3: ( (lv_thirdLevelA2_1_0= ruleThirdLevelA2 ) )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:182:1: (lv_thirdLevelA2_1_0= ruleThirdLevelA2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:182:1: (lv_thirdLevelA2_1_0= ruleThirdLevelA2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:183:3: lv_thirdLevelA2_1_0= ruleThirdLevelA2
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelAAccess().getThirdLevelA2ThirdLevelA2ParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA2_in_ruleSecondLevelA268);
            	    lv_thirdLevelA2_1_0=ruleThirdLevelA2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelARule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"thirdLevelA2",
            	    	        		lv_thirdLevelA2_1_0, 
            	    	        		"ThirdLevelA2", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // $ANTLR end "ruleSecondLevelA"


    // $ANTLR start "entryRuleSecondLevelB"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:213:1: entryRuleSecondLevelB returns [EObject current=null] : iv_ruleSecondLevelB= ruleSecondLevelB EOF ;
    public final EObject entryRuleSecondLevelB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondLevelB = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:214:2: (iv_ruleSecondLevelB= ruleSecondLevelB EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:215:2: iv_ruleSecondLevelB= ruleSecondLevelB EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondLevelBRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB305);
            iv_ruleSecondLevelB=ruleSecondLevelB();

            state._fsp--;

             current =iv_ruleSecondLevelB; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondLevelB315); 

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
    // $ANTLR end "entryRuleSecondLevelB"


    // $ANTLR start "ruleSecondLevelB"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:222:1: ruleSecondLevelB returns [EObject current=null] : ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ ) ;
    public final EObject ruleSecondLevelB() throws RecognitionException {
        EObject current = null;

        EObject lv_thirdLevelB1_0_0 = null;

        EObject lv_thirdLevelB2_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:227:6: ( ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:228:1: ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:228:1: ( ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+ )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:228:2: ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+ ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:228:2: ( (lv_thirdLevelB1_0_0= ruleThirdLevelB1 ) )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:229:1: (lv_thirdLevelB1_0_0= ruleThirdLevelB1 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:229:1: (lv_thirdLevelB1_0_0= ruleThirdLevelB1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:230:3: lv_thirdLevelB1_0_0= ruleThirdLevelB1
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelBAccess().getThirdLevelB1ThirdLevelB1ParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB1_in_ruleSecondLevelB361);
            	    lv_thirdLevelB1_0_0=ruleThirdLevelB1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelBRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"thirdLevelB1",
            	    	        		lv_thirdLevelB1_0_0, 
            	    	        		"ThirdLevelB1", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:252:3: ( (lv_thirdLevelB2_1_0= ruleThirdLevelB2 ) )+
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
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:253:1: (lv_thirdLevelB2_1_0= ruleThirdLevelB2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:253:1: (lv_thirdLevelB2_1_0= ruleThirdLevelB2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:254:3: lv_thirdLevelB2_1_0= ruleThirdLevelB2
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSecondLevelBAccess().getThirdLevelB2ThirdLevelB2ParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB2_in_ruleSecondLevelB383);
            	    lv_thirdLevelB2_1_0=ruleThirdLevelB2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSecondLevelBRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"thirdLevelB2",
            	    	        		lv_thirdLevelB2_1_0, 
            	    	        		"ThirdLevelB2", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


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
    // $ANTLR end "ruleSecondLevelB"


    // $ANTLR start "entryRuleThirdLevelA1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:284:1: entryRuleThirdLevelA1 returns [EObject current=null] : iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF ;
    public final EObject entryRuleThirdLevelA1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelA1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:285:2: (iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:286:2: iv_ruleThirdLevelA1= ruleThirdLevelA1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelA1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1420);
            iv_ruleThirdLevelA1=ruleThirdLevelA1();

            state._fsp--;

             current =iv_ruleThirdLevelA1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelA1430); 

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
    // $ANTLR end "entryRuleThirdLevelA1"


    // $ANTLR start "ruleThirdLevelA1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:293:1: ruleThirdLevelA1 returns [EObject current=null] : (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelA1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:298:6: ( (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:299:1: (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:299:1: (otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:299:3: otherlv_0= 'A1' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleThirdLevelA1467); 

                	createLeafNode(otherlv_0, grammarAccess.getThirdLevelA1Access().getA1Keyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:303:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:304:5: 
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:314:2: ( (lv_name_2_0= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:315:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:315:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:316:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleThirdLevelA1493); 

                    			createLeafNode(lv_name_2_0, grammarAccess.getThirdLevelA1Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelA1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end "ruleThirdLevelA1"


    // $ANTLR start "entryRuleThirdLevelA2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:346:1: entryRuleThirdLevelA2 returns [EObject current=null] : iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF ;
    public final EObject entryRuleThirdLevelA2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelA2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:347:2: (iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:348:2: iv_ruleThirdLevelA2= ruleThirdLevelA2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelA2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2535);
            iv_ruleThirdLevelA2=ruleThirdLevelA2();

            state._fsp--;

             current =iv_ruleThirdLevelA2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelA2545); 

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
    // $ANTLR end "entryRuleThirdLevelA2"


    // $ANTLR start "ruleThirdLevelA2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:355:1: ruleThirdLevelA2 returns [EObject current=null] : (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelA2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:360:6: ( (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:361:1: (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:361:1: (otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:361:3: otherlv_0= 'A2' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleThirdLevelA2582); 

                	createLeafNode(otherlv_0, grammarAccess.getThirdLevelA2Access().getA2Keyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:365:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:366:5: 
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:376:2: ( (lv_name_2_0= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:377:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:377:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:378:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleThirdLevelA2608); 

                    			createLeafNode(lv_name_2_0, grammarAccess.getThirdLevelA2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelA2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end "ruleThirdLevelA2"


    // $ANTLR start "entryRuleThirdLevelB1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:408:1: entryRuleThirdLevelB1 returns [EObject current=null] : iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF ;
    public final EObject entryRuleThirdLevelB1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelB1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:409:2: (iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:410:2: iv_ruleThirdLevelB1= ruleThirdLevelB1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelB1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1650);
            iv_ruleThirdLevelB1=ruleThirdLevelB1();

            state._fsp--;

             current =iv_ruleThirdLevelB1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelB1660); 

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
    // $ANTLR end "entryRuleThirdLevelB1"


    // $ANTLR start "ruleThirdLevelB1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:417:1: ruleThirdLevelB1 returns [EObject current=null] : (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelB1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:422:6: ( (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:423:1: (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:423:1: (otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:423:3: otherlv_0= 'B1' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleThirdLevelB1697); 

                	createLeafNode(otherlv_0, grammarAccess.getThirdLevelB1Access().getB1Keyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:427:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:428:5: 
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:438:2: ( (lv_name_2_0= RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:439:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:439:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:440:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleThirdLevelB1723); 

                    			createLeafNode(lv_name_2_0, grammarAccess.getThirdLevelB1Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelB1Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end "ruleThirdLevelB1"


    // $ANTLR start "entryRuleThirdLevelB2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:470:1: entryRuleThirdLevelB2 returns [EObject current=null] : iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF ;
    public final EObject entryRuleThirdLevelB2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdLevelB2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:471:2: (iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:472:2: iv_ruleThirdLevelB2= ruleThirdLevelB2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getThirdLevelB2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2765);
            iv_ruleThirdLevelB2=ruleThirdLevelB2();

            state._fsp--;

             current =iv_ruleThirdLevelB2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdLevelB2775); 

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
    // $ANTLR end "entryRuleThirdLevelB2"


    // $ANTLR start "ruleThirdLevelB2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:479:1: ruleThirdLevelB2 returns [EObject current=null] : (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? ) ;
    public final EObject ruleThirdLevelB2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:484:6: ( (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:485:1: (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:485:1: (otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:485:3: otherlv_0= 'B2' () ( (lv_name_2_0= RULE_ID ) )?
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleThirdLevelB2812); 

                	createLeafNode(otherlv_0, grammarAccess.getThirdLevelB2Access().getB2Keyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:489:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:490:5: 
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:500:2: ( (lv_name_2_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:501:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:501:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalContentAssistContextTestLanguage.g:502:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleThirdLevelB2838); 

                    			createLeafNode(lv_name_2_0, grammarAccess.getThirdLevelB2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getThirdLevelB2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // $ANTLR end "ruleThirdLevelB2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFirstLevel_in_entryRuleFirstLevel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstLevel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondLevelA_in_ruleFirstLevel131 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_ruleSecondLevelB_in_ruleFirstLevel153 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleSecondLevelA_in_entryRuleSecondLevelA190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelA200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA1_in_ruleSecondLevelA246 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_ruleThirdLevelA2_in_ruleSecondLevelA268 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleSecondLevelB_in_entryRuleSecondLevelB305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondLevelB315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB1_in_ruleSecondLevelB361 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_ruleThirdLevelB2_in_ruleSecondLevelB383 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleThirdLevelA1_in_entryRuleThirdLevelA1420 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA1430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleThirdLevelA1467 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelA1493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelA2_in_entryRuleThirdLevelA2535 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelA2545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleThirdLevelA2582 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelA2608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB1_in_entryRuleThirdLevelB1650 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB1660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleThirdLevelB1697 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelB1723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdLevelB2_in_entryRuleThirdLevelB2765 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdLevelB2775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleThirdLevelB2812 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleThirdLevelB2838 = new BitSet(new long[]{0x0000000000000002L});
    }


}