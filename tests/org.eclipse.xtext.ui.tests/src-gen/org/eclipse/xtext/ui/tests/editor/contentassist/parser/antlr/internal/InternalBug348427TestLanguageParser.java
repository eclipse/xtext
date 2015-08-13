package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug348427TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug348427TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1.1'", "'next'", "'1.2'", "'1.3'", "'1.4'", "':'", "'bool'", "'keyword'", "'child1'", "'end'", "'child2'", "'child3'", "'2.1'", "'2.2'", "'2.3'", "'2.4'", "'2.5'", "'2.6'", "'2.7'", "'2.8'", "'a'", "'b'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBug348427TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug348427TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug348427TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g"; }



     	private Bug348427TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug348427TestLanguageParser(TokenStream input, Bug348427TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug348427TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( ( (lv_element1_0_0= ruleScenario1_1 ) ) | ( (lv_element1_1_0= ruleScenario1_2 ) ) | ( (lv_element1_2_0= ruleScenario1_3 ) ) | ( (lv_element1_3_0= ruleScenario1_4 ) ) | ( (lv_element2_4_0= ruleScenario2_1 ) ) | ( (lv_element2_5_0= ruleScenario2_2 ) ) | ( (lv_element2_6_0= ruleScenario2_3 ) ) | ( (lv_element2_7_0= ruleScenario2_4 ) ) | ( (lv_element2_8_0= ruleScenario2_5 ) ) | ( (lv_element2_9_0= ruleScenario2_6 ) ) | ( (lv_element2_10_0= ruleScenario2_7 ) ) | ( (lv_element2_11_0= ruleScenario2_8 ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_element1_0_0 = null;

        EObject lv_element1_1_0 = null;

        EObject lv_element1_2_0 = null;

        EObject lv_element1_3_0 = null;

        EObject lv_element2_4_0 = null;

        EObject lv_element2_5_0 = null;

        EObject lv_element2_6_0 = null;

        EObject lv_element2_7_0 = null;

        EObject lv_element2_8_0 = null;

        EObject lv_element2_9_0 = null;

        EObject lv_element2_10_0 = null;

        EObject lv_element2_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:80:28: ( ( ( (lv_element1_0_0= ruleScenario1_1 ) ) | ( (lv_element1_1_0= ruleScenario1_2 ) ) | ( (lv_element1_2_0= ruleScenario1_3 ) ) | ( (lv_element1_3_0= ruleScenario1_4 ) ) | ( (lv_element2_4_0= ruleScenario2_1 ) ) | ( (lv_element2_5_0= ruleScenario2_2 ) ) | ( (lv_element2_6_0= ruleScenario2_3 ) ) | ( (lv_element2_7_0= ruleScenario2_4 ) ) | ( (lv_element2_8_0= ruleScenario2_5 ) ) | ( (lv_element2_9_0= ruleScenario2_6 ) ) | ( (lv_element2_10_0= ruleScenario2_7 ) ) | ( (lv_element2_11_0= ruleScenario2_8 ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:81:1: ( ( (lv_element1_0_0= ruleScenario1_1 ) ) | ( (lv_element1_1_0= ruleScenario1_2 ) ) | ( (lv_element1_2_0= ruleScenario1_3 ) ) | ( (lv_element1_3_0= ruleScenario1_4 ) ) | ( (lv_element2_4_0= ruleScenario2_1 ) ) | ( (lv_element2_5_0= ruleScenario2_2 ) ) | ( (lv_element2_6_0= ruleScenario2_3 ) ) | ( (lv_element2_7_0= ruleScenario2_4 ) ) | ( (lv_element2_8_0= ruleScenario2_5 ) ) | ( (lv_element2_9_0= ruleScenario2_6 ) ) | ( (lv_element2_10_0= ruleScenario2_7 ) ) | ( (lv_element2_11_0= ruleScenario2_8 ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:81:1: ( ( (lv_element1_0_0= ruleScenario1_1 ) ) | ( (lv_element1_1_0= ruleScenario1_2 ) ) | ( (lv_element1_2_0= ruleScenario1_3 ) ) | ( (lv_element1_3_0= ruleScenario1_4 ) ) | ( (lv_element2_4_0= ruleScenario2_1 ) ) | ( (lv_element2_5_0= ruleScenario2_2 ) ) | ( (lv_element2_6_0= ruleScenario2_3 ) ) | ( (lv_element2_7_0= ruleScenario2_4 ) ) | ( (lv_element2_8_0= ruleScenario2_5 ) ) | ( (lv_element2_9_0= ruleScenario2_6 ) ) | ( (lv_element2_10_0= ruleScenario2_7 ) ) | ( (lv_element2_11_0= ruleScenario2_8 ) ) )
            int alt1=12;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 14:
                {
                alt1=3;
                }
                break;
            case 15:
                {
                alt1=4;
                }
                break;
            case 23:
                {
                alt1=5;
                }
                break;
            case 24:
                {
                alt1=6;
                }
                break;
            case 25:
                {
                alt1=7;
                }
                break;
            case 26:
                {
                alt1=8;
                }
                break;
            case 27:
                {
                alt1=9;
                }
                break;
            case 28:
                {
                alt1=10;
                }
                break;
            case 29:
                {
                alt1=11;
                }
                break;
            case 30:
                {
                alt1=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:81:2: ( (lv_element1_0_0= ruleScenario1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:81:2: ( (lv_element1_0_0= ruleScenario1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:82:1: (lv_element1_0_0= ruleScenario1_1 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:82:1: (lv_element1_0_0= ruleScenario1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:83:3: lv_element1_0_0= ruleScenario1_1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement1Scenario1_1ParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_1_in_ruleModel131);
                    lv_element1_0_0=ruleScenario1_1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element1",
                            		lv_element1_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario1_1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:100:6: ( (lv_element1_1_0= ruleScenario1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:100:6: ( (lv_element1_1_0= ruleScenario1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:101:1: (lv_element1_1_0= ruleScenario1_2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:101:1: (lv_element1_1_0= ruleScenario1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:102:3: lv_element1_1_0= ruleScenario1_2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement1Scenario1_2ParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_2_in_ruleModel158);
                    lv_element1_1_0=ruleScenario1_2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element1",
                            		lv_element1_1_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario1_2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:119:6: ( (lv_element1_2_0= ruleScenario1_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:119:6: ( (lv_element1_2_0= ruleScenario1_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:120:1: (lv_element1_2_0= ruleScenario1_3 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:120:1: (lv_element1_2_0= ruleScenario1_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:121:3: lv_element1_2_0= ruleScenario1_3
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement1Scenario1_3ParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_3_in_ruleModel185);
                    lv_element1_2_0=ruleScenario1_3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element1",
                            		lv_element1_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario1_3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:138:6: ( (lv_element1_3_0= ruleScenario1_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:138:6: ( (lv_element1_3_0= ruleScenario1_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:139:1: (lv_element1_3_0= ruleScenario1_4 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:139:1: (lv_element1_3_0= ruleScenario1_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:140:3: lv_element1_3_0= ruleScenario1_4
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement1Scenario1_4ParserRuleCall_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario1_4_in_ruleModel212);
                    lv_element1_3_0=ruleScenario1_4();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element1",
                            		lv_element1_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario1_4");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:157:6: ( (lv_element2_4_0= ruleScenario2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:157:6: ( (lv_element2_4_0= ruleScenario2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:158:1: (lv_element2_4_0= ruleScenario2_1 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:158:1: (lv_element2_4_0= ruleScenario2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:159:3: lv_element2_4_0= ruleScenario2_1
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_1ParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_1_in_ruleModel239);
                    lv_element2_4_0=ruleScenario2_1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_4_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:176:6: ( (lv_element2_5_0= ruleScenario2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:176:6: ( (lv_element2_5_0= ruleScenario2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:177:1: (lv_element2_5_0= ruleScenario2_2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:177:1: (lv_element2_5_0= ruleScenario2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:178:3: lv_element2_5_0= ruleScenario2_2
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_2ParserRuleCall_5_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_2_in_ruleModel266);
                    lv_element2_5_0=ruleScenario2_2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_5_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:195:6: ( (lv_element2_6_0= ruleScenario2_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:195:6: ( (lv_element2_6_0= ruleScenario2_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:196:1: (lv_element2_6_0= ruleScenario2_3 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:196:1: (lv_element2_6_0= ruleScenario2_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:197:3: lv_element2_6_0= ruleScenario2_3
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_3ParserRuleCall_6_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_3_in_ruleModel293);
                    lv_element2_6_0=ruleScenario2_3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_6_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:214:6: ( (lv_element2_7_0= ruleScenario2_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:214:6: ( (lv_element2_7_0= ruleScenario2_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:215:1: (lv_element2_7_0= ruleScenario2_4 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:215:1: (lv_element2_7_0= ruleScenario2_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:216:3: lv_element2_7_0= ruleScenario2_4
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_4ParserRuleCall_7_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_4_in_ruleModel320);
                    lv_element2_7_0=ruleScenario2_4();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_7_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_4");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:233:6: ( (lv_element2_8_0= ruleScenario2_5 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:233:6: ( (lv_element2_8_0= ruleScenario2_5 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:234:1: (lv_element2_8_0= ruleScenario2_5 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:234:1: (lv_element2_8_0= ruleScenario2_5 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:235:3: lv_element2_8_0= ruleScenario2_5
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_5ParserRuleCall_8_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_5_in_ruleModel347);
                    lv_element2_8_0=ruleScenario2_5();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_8_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_5");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:252:6: ( (lv_element2_9_0= ruleScenario2_6 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:252:6: ( (lv_element2_9_0= ruleScenario2_6 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:253:1: (lv_element2_9_0= ruleScenario2_6 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:253:1: (lv_element2_9_0= ruleScenario2_6 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:254:3: lv_element2_9_0= ruleScenario2_6
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_6ParserRuleCall_9_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_6_in_ruleModel374);
                    lv_element2_9_0=ruleScenario2_6();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_9_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_6");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:271:6: ( (lv_element2_10_0= ruleScenario2_7 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:271:6: ( (lv_element2_10_0= ruleScenario2_7 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:272:1: (lv_element2_10_0= ruleScenario2_7 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:272:1: (lv_element2_10_0= ruleScenario2_7 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:273:3: lv_element2_10_0= ruleScenario2_7
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_7ParserRuleCall_10_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_7_in_ruleModel401);
                    lv_element2_10_0=ruleScenario2_7();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_10_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_7");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:290:6: ( (lv_element2_11_0= ruleScenario2_8 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:290:6: ( (lv_element2_11_0= ruleScenario2_8 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:291:1: (lv_element2_11_0= ruleScenario2_8 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:291:1: (lv_element2_11_0= ruleScenario2_8 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:292:3: lv_element2_11_0= ruleScenario2_8
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getElement2Scenario2_8ParserRuleCall_11_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleScenario2_8_in_ruleModel428);
                    lv_element2_11_0=ruleScenario2_8();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"element2",
                            		lv_element2_11_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Scenario2_8");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleScenario1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:316:1: entryRuleScenario1_1 returns [EObject current=null] : iv_ruleScenario1_1= ruleScenario1_1 EOF ;
    public final EObject entryRuleScenario1_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:317:2: (iv_ruleScenario1_1= ruleScenario1_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:318:2: iv_ruleScenario1_1= ruleScenario1_1 EOF
            {
             newCompositeNode(grammarAccess.getScenario1_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_1_in_entryRuleScenario1_1464);
            iv_ruleScenario1_1=ruleScenario1_1();

            state._fsp--;

             current =iv_ruleScenario1_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_1474); 

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
    // $ANTLR end "entryRuleScenario1_1"


    // $ANTLR start "ruleScenario1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:325:1: ruleScenario1_1 returns [EObject current=null] : (otherlv_0= '1.1' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) ) otherlv_4= 'next' ) ;
    public final EObject ruleScenario1_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_child_1_0 = null;

        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:328:28: ( (otherlv_0= '1.1' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) ) otherlv_4= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:329:1: (otherlv_0= '1.1' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) ) otherlv_4= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:329:1: (otherlv_0= '1.1' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) ) otherlv_4= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:329:3: otherlv_0= '1.1' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) ) otherlv_4= 'next'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleScenario1_1511); 

                	newLeafNode(otherlv_0, grammarAccess.getScenario1_1Access().getDigitOneFullStopDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:333:1: ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )
            int alt2=3;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:333:2: ( (lv_child_1_0= ruleChild1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:333:2: ( (lv_child_1_0= ruleChild1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:334:1: (lv_child_1_0= ruleChild1_1 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:334:1: (lv_child_1_0= ruleChild1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:335:3: lv_child_1_0= ruleChild1_1
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario1_1Access().getChildChild1_1ParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_ruleScenario1_1533);
                    lv_child_1_0=ruleChild1_1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario1_1Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_1_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:352:6: ( (lv_child_2_0= ruleChild1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:352:6: ( (lv_child_2_0= ruleChild1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:353:1: (lv_child_2_0= ruleChild1_2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:353:1: (lv_child_2_0= ruleChild1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:354:3: lv_child_2_0= ruleChild1_2
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario1_1Access().getChildChild1_2ParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_ruleScenario1_1560);
                    lv_child_2_0=ruleChild1_2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario1_1Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:371:6: ( (lv_child_3_0= ruleChild1_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:371:6: ( (lv_child_3_0= ruleChild1_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:372:1: (lv_child_3_0= ruleChild1_3 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:372:1: (lv_child_3_0= ruleChild1_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:373:3: lv_child_3_0= ruleChild1_3
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario1_1Access().getChildChild1_3ParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_ruleScenario1_1587);
                    lv_child_3_0=ruleChild1_3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario1_1Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario1_1600); 

                	newLeafNode(otherlv_4, grammarAccess.getScenario1_1Access().getNextKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario1_1"


    // $ANTLR start "entryRuleScenario1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:401:1: entryRuleScenario1_2 returns [EObject current=null] : iv_ruleScenario1_2= ruleScenario1_2 EOF ;
    public final EObject entryRuleScenario1_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:402:2: (iv_ruleScenario1_2= ruleScenario1_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:403:2: iv_ruleScenario1_2= ruleScenario1_2 EOF
            {
             newCompositeNode(grammarAccess.getScenario1_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_2_in_entryRuleScenario1_2636);
            iv_ruleScenario1_2=ruleScenario1_2();

            state._fsp--;

             current =iv_ruleScenario1_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_2646); 

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
    // $ANTLR end "entryRuleScenario1_2"


    // $ANTLR start "ruleScenario1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:410:1: ruleScenario1_2 returns [EObject current=null] : (otherlv_0= '1.2' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )+ otherlv_4= 'next' ) ;
    public final EObject ruleScenario1_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_child_1_0 = null;

        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:413:28: ( (otherlv_0= '1.2' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )+ otherlv_4= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:414:1: (otherlv_0= '1.2' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )+ otherlv_4= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:414:1: (otherlv_0= '1.2' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )+ otherlv_4= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:414:3: otherlv_0= '1.2' ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )+ otherlv_4= 'next'
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleScenario1_2683); 

                	newLeafNode(otherlv_0, grammarAccess.getScenario1_2Access().getDigitOneFullStopDigitTwoKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:418:1: ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=4;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:418:2: ( (lv_child_1_0= ruleChild1_1 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:418:2: ( (lv_child_1_0= ruleChild1_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:419:1: (lv_child_1_0= ruleChild1_1 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:419:1: (lv_child_1_0= ruleChild1_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:420:3: lv_child_1_0= ruleChild1_1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario1_2Access().getChildChild1_1ParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_ruleScenario1_2705);
            	    lv_child_1_0=ruleChild1_1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario1_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_1_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_1");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:437:6: ( (lv_child_2_0= ruleChild1_2 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:437:6: ( (lv_child_2_0= ruleChild1_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:438:1: (lv_child_2_0= ruleChild1_2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:438:1: (lv_child_2_0= ruleChild1_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:439:3: lv_child_2_0= ruleChild1_2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario1_2Access().getChildChild1_2ParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_ruleScenario1_2732);
            	    lv_child_2_0=ruleChild1_2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario1_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_2_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:456:6: ( (lv_child_3_0= ruleChild1_3 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:456:6: ( (lv_child_3_0= ruleChild1_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:457:1: (lv_child_3_0= ruleChild1_3 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:457:1: (lv_child_3_0= ruleChild1_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:458:3: lv_child_3_0= ruleChild1_3
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario1_2Access().getChildChild1_3ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_ruleScenario1_2759);
            	    lv_child_3_0=ruleChild1_3();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario1_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_3");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario1_2773); 

                	newLeafNode(otherlv_4, grammarAccess.getScenario1_2Access().getNextKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario1_2"


    // $ANTLR start "entryRuleScenario1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:486:1: entryRuleScenario1_3 returns [EObject current=null] : iv_ruleScenario1_3= ruleScenario1_3 EOF ;
    public final EObject entryRuleScenario1_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:487:2: (iv_ruleScenario1_3= ruleScenario1_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:488:2: iv_ruleScenario1_3= ruleScenario1_3 EOF
            {
             newCompositeNode(grammarAccess.getScenario1_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_3_in_entryRuleScenario1_3809);
            iv_ruleScenario1_3=ruleScenario1_3();

            state._fsp--;

             current =iv_ruleScenario1_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_3819); 

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
    // $ANTLR end "entryRuleScenario1_3"


    // $ANTLR start "ruleScenario1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:495:1: ruleScenario1_3 returns [EObject current=null] : ( () otherlv_1= '1.3' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )* otherlv_5= 'next' ) ;
    public final EObject ruleScenario1_3() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;

        EObject lv_child_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:498:28: ( ( () otherlv_1= '1.3' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )* otherlv_5= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:499:1: ( () otherlv_1= '1.3' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )* otherlv_5= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:499:1: ( () otherlv_1= '1.3' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )* otherlv_5= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:499:2: () otherlv_1= '1.3' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )* otherlv_5= 'next'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:499:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:500:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getScenario1_3Access().getScenario1Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleScenario1_3865); 

                	newLeafNode(otherlv_1, grammarAccess.getScenario1_3Access().getDigitOneFullStopDigitThreeKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:509:1: ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )*
            loop4:
            do {
                int alt4=4;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:509:2: ( (lv_child_2_0= ruleChild1_1 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:509:2: ( (lv_child_2_0= ruleChild1_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:510:1: (lv_child_2_0= ruleChild1_1 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:510:1: (lv_child_2_0= ruleChild1_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:511:3: lv_child_2_0= ruleChild1_1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario1_3Access().getChildChild1_1ParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_ruleScenario1_3887);
            	    lv_child_2_0=ruleChild1_1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario1_3Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_2_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_1");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:528:6: ( (lv_child_3_0= ruleChild1_2 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:528:6: ( (lv_child_3_0= ruleChild1_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:529:1: (lv_child_3_0= ruleChild1_2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:529:1: (lv_child_3_0= ruleChild1_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:530:3: lv_child_3_0= ruleChild1_2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario1_3Access().getChildChild1_2ParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_ruleScenario1_3914);
            	    lv_child_3_0=ruleChild1_2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario1_3Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:547:6: ( (lv_child_4_0= ruleChild1_3 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:547:6: ( (lv_child_4_0= ruleChild1_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:548:1: (lv_child_4_0= ruleChild1_3 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:548:1: (lv_child_4_0= ruleChild1_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:549:3: lv_child_4_0= ruleChild1_3
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario1_3Access().getChildChild1_3ParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_ruleScenario1_3941);
            	    lv_child_4_0=ruleChild1_3();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario1_3Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_4_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_3");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario1_3955); 

                	newLeafNode(otherlv_5, grammarAccess.getScenario1_3Access().getNextKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario1_3"


    // $ANTLR start "entryRuleScenario1_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:577:1: entryRuleScenario1_4 returns [EObject current=null] : iv_ruleScenario1_4= ruleScenario1_4 EOF ;
    public final EObject entryRuleScenario1_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario1_4 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:578:2: (iv_ruleScenario1_4= ruleScenario1_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:579:2: iv_ruleScenario1_4= ruleScenario1_4 EOF
            {
             newCompositeNode(grammarAccess.getScenario1_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario1_4_in_entryRuleScenario1_4991);
            iv_ruleScenario1_4=ruleScenario1_4();

            state._fsp--;

             current =iv_ruleScenario1_4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario1_41001); 

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
    // $ANTLR end "entryRuleScenario1_4"


    // $ANTLR start "ruleScenario1_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:586:1: ruleScenario1_4 returns [EObject current=null] : ( () otherlv_1= '1.4' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )? otherlv_5= 'next' ) ;
    public final EObject ruleScenario1_4() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;

        EObject lv_child_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:589:28: ( ( () otherlv_1= '1.4' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )? otherlv_5= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:590:1: ( () otherlv_1= '1.4' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )? otherlv_5= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:590:1: ( () otherlv_1= '1.4' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )? otherlv_5= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:590:2: () otherlv_1= '1.4' ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )? otherlv_5= 'next'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:590:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:591:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getScenario1_4Access().getScenario1Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleScenario1_41047); 

                	newLeafNode(otherlv_1, grammarAccess.getScenario1_4Access().getDigitOneFullStopDigitFourKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:600:1: ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )?
            int alt5=4;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:600:2: ( (lv_child_2_0= ruleChild1_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:600:2: ( (lv_child_2_0= ruleChild1_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:601:1: (lv_child_2_0= ruleChild1_1 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:601:1: (lv_child_2_0= ruleChild1_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:602:3: lv_child_2_0= ruleChild1_1
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario1_4Access().getChildChild1_1ParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_ruleScenario1_41069);
                    lv_child_2_0=ruleChild1_1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario1_4Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:619:6: ( (lv_child_3_0= ruleChild1_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:619:6: ( (lv_child_3_0= ruleChild1_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:620:1: (lv_child_3_0= ruleChild1_2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:620:1: (lv_child_3_0= ruleChild1_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:621:3: lv_child_3_0= ruleChild1_2
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario1_4Access().getChildChild1_2ParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_ruleScenario1_41096);
                    lv_child_3_0=ruleChild1_2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario1_4Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:638:6: ( (lv_child_4_0= ruleChild1_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:638:6: ( (lv_child_4_0= ruleChild1_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:639:1: (lv_child_4_0= ruleChild1_3 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:639:1: (lv_child_4_0= ruleChild1_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:640:3: lv_child_4_0= ruleChild1_3
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario1_4Access().getChildChild1_3ParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_ruleScenario1_41123);
                    lv_child_4_0=ruleChild1_3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario1_4Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_4_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child1_3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario1_41137); 

                	newLeafNode(otherlv_5, grammarAccess.getScenario1_4Access().getNextKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario1_4"


    // $ANTLR start "entryRuleChild1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:668:1: entryRuleChild1_1 returns [EObject current=null] : iv_ruleChild1_1= ruleChild1_1 EOF ;
    public final EObject entryRuleChild1_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:669:2: (iv_ruleChild1_1= ruleChild1_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:670:2: iv_ruleChild1_1= ruleChild1_1 EOF
            {
             newCompositeNode(grammarAccess.getChild1_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_1_in_entryRuleChild1_11173);
            iv_ruleChild1_1=ruleChild1_1();

            state._fsp--;

             current =iv_ruleChild1_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1_11183); 

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
    // $ANTLR end "entryRuleChild1_1"


    // $ANTLR start "ruleChild1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:677:1: ruleChild1_1 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child1' otherlv_6= 'end' ) ;
    public final EObject ruleChild1_1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Enumerator lv_enumType_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:680:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child1' otherlv_6= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:681:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child1' otherlv_6= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:681:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child1' otherlv_6= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:681:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child1' otherlv_6= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:681:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:682:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:682:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:683:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild1_11225); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild1_1Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild1_1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild1_11242); 

                	newLeafNode(otherlv_1, grammarAccess.getChild1_1Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:703:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:703:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:703:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:704:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:704:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:705:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild1_11261); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild1_1Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild1_1Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild1_11286); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild1_1Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:722:3: ( (lv_enumType_4_0= ruleEnumType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:723:1: (lv_enumType_4_0= ruleEnumType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:723:1: (lv_enumType_4_0= ruleEnumType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:724:3: lv_enumType_4_0= ruleEnumType
            {
             
            	        newCompositeNode(grammarAccess.getChild1_1Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumType_in_ruleChild1_11309);
            lv_enumType_4_0=ruleEnumType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getChild1_1Rule());
            	        }
                   		set(
                   			current, 
                   			"enumType",
                    		lv_enumType_4_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.EnumType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleChild1_11321); 

                	newLeafNode(otherlv_5, grammarAccess.getChild1_1Access().getChild1Keyword_4());
                
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild1_11333); 

                	newLeafNode(otherlv_6, grammarAccess.getChild1_1Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild1_1"


    // $ANTLR start "entryRuleChild1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:756:1: entryRuleChild1_2 returns [EObject current=null] : iv_ruleChild1_2= ruleChild1_2 EOF ;
    public final EObject entryRuleChild1_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:757:2: (iv_ruleChild1_2= ruleChild1_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:758:2: iv_ruleChild1_2= ruleChild1_2 EOF
            {
             newCompositeNode(grammarAccess.getChild1_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_2_in_entryRuleChild1_21369);
            iv_ruleChild1_2=ruleChild1_2();

            state._fsp--;

             current =iv_ruleChild1_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1_21379); 

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
    // $ANTLR end "entryRuleChild1_2"


    // $ANTLR start "ruleChild1_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:765:1: ruleChild1_2 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child2' otherlv_6= 'end' ) ;
    public final EObject ruleChild1_2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Enumerator lv_enumType_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:768:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child2' otherlv_6= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:769:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child2' otherlv_6= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:769:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child2' otherlv_6= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:769:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child2' otherlv_6= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:769:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:770:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:770:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:771:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild1_21421); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild1_2Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild1_2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild1_21438); 

                	newLeafNode(otherlv_1, grammarAccess.getChild1_2Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:791:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:791:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:791:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:792:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:792:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:793:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild1_21457); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild1_2Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild1_2Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild1_21482); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild1_2Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:810:3: ( (lv_enumType_4_0= ruleEnumType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:811:1: (lv_enumType_4_0= ruleEnumType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:811:1: (lv_enumType_4_0= ruleEnumType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:812:3: lv_enumType_4_0= ruleEnumType
            {
             
            	        newCompositeNode(grammarAccess.getChild1_2Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumType_in_ruleChild1_21505);
            lv_enumType_4_0=ruleEnumType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getChild1_2Rule());
            	        }
                   		set(
                   			current, 
                   			"enumType",
                    		lv_enumType_4_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.EnumType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleChild1_21517); 

                	newLeafNode(otherlv_5, grammarAccess.getChild1_2Access().getChild2Keyword_4());
                
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild1_21529); 

                	newLeafNode(otherlv_6, grammarAccess.getChild1_2Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild1_2"


    // $ANTLR start "entryRuleChild1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:844:1: entryRuleChild1_3 returns [EObject current=null] : iv_ruleChild1_3= ruleChild1_3 EOF ;
    public final EObject entryRuleChild1_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:845:2: (iv_ruleChild1_3= ruleChild1_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:846:2: iv_ruleChild1_3= ruleChild1_3 EOF
            {
             newCompositeNode(grammarAccess.getChild1_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_3_in_entryRuleChild1_31565);
            iv_ruleChild1_3=ruleChild1_3();

            state._fsp--;

             current =iv_ruleChild1_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1_31575); 

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
    // $ANTLR end "entryRuleChild1_3"


    // $ANTLR start "ruleChild1_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:853:1: ruleChild1_3 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child3' otherlv_6= 'end' ) ;
    public final EObject ruleChild1_3() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Enumerator lv_enumType_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:856:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child3' otherlv_6= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:857:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child3' otherlv_6= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:857:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child3' otherlv_6= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:857:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( (lv_enumType_4_0= ruleEnumType ) ) otherlv_5= 'child3' otherlv_6= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:857:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:858:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:858:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:859:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild1_31617); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild1_3Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild1_3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild1_31634); 

                	newLeafNode(otherlv_1, grammarAccess.getChild1_3Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:879:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:879:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:879:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:880:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:880:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:881:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild1_31653); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild1_3Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild1_3Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild1_31678); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild1_3Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:898:3: ( (lv_enumType_4_0= ruleEnumType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:899:1: (lv_enumType_4_0= ruleEnumType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:899:1: (lv_enumType_4_0= ruleEnumType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:900:3: lv_enumType_4_0= ruleEnumType
            {
             
            	        newCompositeNode(grammarAccess.getChild1_3Access().getEnumTypeEnumTypeEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumType_in_ruleChild1_31701);
            lv_enumType_4_0=ruleEnumType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getChild1_3Rule());
            	        }
                   		set(
                   			current, 
                   			"enumType",
                    		lv_enumType_4_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.EnumType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleChild1_31713); 

                	newLeafNode(otherlv_5, grammarAccess.getChild1_3Access().getChild3Keyword_4());
                
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild1_31725); 

                	newLeafNode(otherlv_6, grammarAccess.getChild1_3Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild1_3"


    // $ANTLR start "entryRuleScenario2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:932:1: entryRuleScenario2_1 returns [EObject current=null] : iv_ruleScenario2_1= ruleScenario2_1 EOF ;
    public final EObject entryRuleScenario2_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:933:2: (iv_ruleScenario2_1= ruleScenario2_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:934:2: iv_ruleScenario2_1= ruleScenario2_1 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_1_in_entryRuleScenario2_11761);
            iv_ruleScenario2_1=ruleScenario2_1();

            state._fsp--;

             current =iv_ruleScenario2_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_11771); 

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
    // $ANTLR end "entryRuleScenario2_1"


    // $ANTLR start "ruleScenario2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:941:1: ruleScenario2_1 returns [EObject current=null] : (otherlv_0= '2.1' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) ) otherlv_4= 'next' ) ;
    public final EObject ruleScenario2_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_child_1_0 = null;

        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:944:28: ( (otherlv_0= '2.1' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) ) otherlv_4= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:945:1: (otherlv_0= '2.1' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) ) otherlv_4= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:945:1: (otherlv_0= '2.1' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) ) otherlv_4= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:945:3: otherlv_0= '2.1' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) ) otherlv_4= 'next'
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleScenario2_11808); 

                	newLeafNode(otherlv_0, grammarAccess.getScenario2_1Access().getDigitTwoFullStopDigitOneKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:949:1: ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )
            int alt9=3;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:949:2: ( (lv_child_1_0= ruleChild2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:949:2: ( (lv_child_1_0= ruleChild2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:950:1: (lv_child_1_0= ruleChild2_1 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:950:1: (lv_child_1_0= ruleChild2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:951:3: lv_child_1_0= ruleChild2_1
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_1Access().getChildChild2_1ParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_ruleScenario2_11830);
                    lv_child_1_0=ruleChild2_1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_1Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_1_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:968:6: ( (lv_child_2_0= ruleChild2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:968:6: ( (lv_child_2_0= ruleChild2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:969:1: (lv_child_2_0= ruleChild2_2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:969:1: (lv_child_2_0= ruleChild2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:970:3: lv_child_2_0= ruleChild2_2
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_1Access().getChildChild2_2ParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_ruleScenario2_11857);
                    lv_child_2_0=ruleChild2_2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_1Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:987:6: ( (lv_child_3_0= ruleChild2_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:987:6: ( (lv_child_3_0= ruleChild2_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:988:1: (lv_child_3_0= ruleChild2_3 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:988:1: (lv_child_3_0= ruleChild2_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:989:3: lv_child_3_0= ruleChild2_3
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_1Access().getChildChild2_3ParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_ruleScenario2_11884);
                    lv_child_3_0=ruleChild2_3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_1Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_11897); 

                	newLeafNode(otherlv_4, grammarAccess.getScenario2_1Access().getNextKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_1"


    // $ANTLR start "entryRuleScenario2_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1017:1: entryRuleScenario2_2 returns [EObject current=null] : iv_ruleScenario2_2= ruleScenario2_2 EOF ;
    public final EObject entryRuleScenario2_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1018:2: (iv_ruleScenario2_2= ruleScenario2_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1019:2: iv_ruleScenario2_2= ruleScenario2_2 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_2_in_entryRuleScenario2_21933);
            iv_ruleScenario2_2=ruleScenario2_2();

            state._fsp--;

             current =iv_ruleScenario2_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_21943); 

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
    // $ANTLR end "entryRuleScenario2_2"


    // $ANTLR start "ruleScenario2_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1026:1: ruleScenario2_2 returns [EObject current=null] : (otherlv_0= '2.2' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )+ otherlv_4= 'next' ) ;
    public final EObject ruleScenario2_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_child_1_0 = null;

        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1029:28: ( (otherlv_0= '2.2' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )+ otherlv_4= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1030:1: (otherlv_0= '2.2' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )+ otherlv_4= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1030:1: (otherlv_0= '2.2' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )+ otherlv_4= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1030:3: otherlv_0= '2.2' ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )+ otherlv_4= 'next'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleScenario2_21980); 

                	newLeafNode(otherlv_0, grammarAccess.getScenario2_2Access().getDigitTwoFullStopDigitTwoKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1034:1: ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=4;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1034:2: ( (lv_child_1_0= ruleChild2_1 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1034:2: ( (lv_child_1_0= ruleChild2_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1035:1: (lv_child_1_0= ruleChild2_1 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1035:1: (lv_child_1_0= ruleChild2_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1036:3: lv_child_1_0= ruleChild2_1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_2Access().getChildChild2_1ParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_ruleScenario2_22002);
            	    lv_child_1_0=ruleChild2_1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_1_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_1");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1053:6: ( (lv_child_2_0= ruleChild2_2 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1053:6: ( (lv_child_2_0= ruleChild2_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1054:1: (lv_child_2_0= ruleChild2_2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1054:1: (lv_child_2_0= ruleChild2_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1055:3: lv_child_2_0= ruleChild2_2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_2Access().getChildChild2_2ParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_ruleScenario2_22029);
            	    lv_child_2_0=ruleChild2_2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_2_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1072:6: ( (lv_child_3_0= ruleChild2_3 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1072:6: ( (lv_child_3_0= ruleChild2_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1073:1: (lv_child_3_0= ruleChild2_3 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1073:1: (lv_child_3_0= ruleChild2_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1074:3: lv_child_3_0= ruleChild2_3
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_2Access().getChildChild2_3ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_ruleScenario2_22056);
            	    lv_child_3_0=ruleChild2_3();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_2Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_3");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_22070); 

                	newLeafNode(otherlv_4, grammarAccess.getScenario2_2Access().getNextKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_2"


    // $ANTLR start "entryRuleScenario2_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1102:1: entryRuleScenario2_3 returns [EObject current=null] : iv_ruleScenario2_3= ruleScenario2_3 EOF ;
    public final EObject entryRuleScenario2_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1103:2: (iv_ruleScenario2_3= ruleScenario2_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1104:2: iv_ruleScenario2_3= ruleScenario2_3 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_3_in_entryRuleScenario2_32106);
            iv_ruleScenario2_3=ruleScenario2_3();

            state._fsp--;

             current =iv_ruleScenario2_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_32116); 

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
    // $ANTLR end "entryRuleScenario2_3"


    // $ANTLR start "ruleScenario2_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1111:1: ruleScenario2_3 returns [EObject current=null] : (otherlv_0= '2.3' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) ) otherlv_4= 'next' ) ;
    public final EObject ruleScenario2_3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_child_1_0 = null;

        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1114:28: ( (otherlv_0= '2.3' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) ) otherlv_4= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1115:1: (otherlv_0= '2.3' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) ) otherlv_4= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1115:1: (otherlv_0= '2.3' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) ) otherlv_4= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1115:3: otherlv_0= '2.3' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) ) otherlv_4= 'next'
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleScenario2_32153); 

                	newLeafNode(otherlv_0, grammarAccess.getScenario2_3Access().getDigitTwoFullStopDigitThreeKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1119:1: ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )
            int alt11=3;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1119:2: ( (lv_child_1_0= ruleChild2_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1119:2: ( (lv_child_1_0= ruleChild2_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1120:1: (lv_child_1_0= ruleChild2_4 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1120:1: (lv_child_1_0= ruleChild2_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1121:3: lv_child_1_0= ruleChild2_4
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_3Access().getChildChild2_4ParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_ruleScenario2_32175);
                    lv_child_1_0=ruleChild2_4();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_3Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_1_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_4");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1138:6: ( (lv_child_2_0= ruleChild2_5 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1138:6: ( (lv_child_2_0= ruleChild2_5 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1139:1: (lv_child_2_0= ruleChild2_5 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1139:1: (lv_child_2_0= ruleChild2_5 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1140:3: lv_child_2_0= ruleChild2_5
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_3Access().getChildChild2_5ParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_ruleScenario2_32202);
                    lv_child_2_0=ruleChild2_5();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_3Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_5");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1157:6: ( (lv_child_3_0= ruleChild2_6 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1157:6: ( (lv_child_3_0= ruleChild2_6 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1158:1: (lv_child_3_0= ruleChild2_6 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1158:1: (lv_child_3_0= ruleChild2_6 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1159:3: lv_child_3_0= ruleChild2_6
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_3Access().getChildChild2_6ParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_ruleScenario2_32229);
                    lv_child_3_0=ruleChild2_6();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_3Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_6");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_32242); 

                	newLeafNode(otherlv_4, grammarAccess.getScenario2_3Access().getNextKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_3"


    // $ANTLR start "entryRuleScenario2_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1187:1: entryRuleScenario2_4 returns [EObject current=null] : iv_ruleScenario2_4= ruleScenario2_4 EOF ;
    public final EObject entryRuleScenario2_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_4 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1188:2: (iv_ruleScenario2_4= ruleScenario2_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1189:2: iv_ruleScenario2_4= ruleScenario2_4 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_4_in_entryRuleScenario2_42278);
            iv_ruleScenario2_4=ruleScenario2_4();

            state._fsp--;

             current =iv_ruleScenario2_4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_42288); 

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
    // $ANTLR end "entryRuleScenario2_4"


    // $ANTLR start "ruleScenario2_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1196:1: ruleScenario2_4 returns [EObject current=null] : (otherlv_0= '2.4' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )+ otherlv_4= 'next' ) ;
    public final EObject ruleScenario2_4() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_child_1_0 = null;

        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1199:28: ( (otherlv_0= '2.4' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )+ otherlv_4= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1200:1: (otherlv_0= '2.4' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )+ otherlv_4= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1200:1: (otherlv_0= '2.4' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )+ otherlv_4= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1200:3: otherlv_0= '2.4' ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )+ otherlv_4= 'next'
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleScenario2_42325); 

                	newLeafNode(otherlv_0, grammarAccess.getScenario2_4Access().getDigitTwoFullStopDigitFourKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1204:1: ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=4;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1204:2: ( (lv_child_1_0= ruleChild2_4 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1204:2: ( (lv_child_1_0= ruleChild2_4 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1205:1: (lv_child_1_0= ruleChild2_4 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1205:1: (lv_child_1_0= ruleChild2_4 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1206:3: lv_child_1_0= ruleChild2_4
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_4Access().getChildChild2_4ParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_ruleScenario2_42347);
            	    lv_child_1_0=ruleChild2_4();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_4Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_1_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_4");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1223:6: ( (lv_child_2_0= ruleChild2_5 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1223:6: ( (lv_child_2_0= ruleChild2_5 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1224:1: (lv_child_2_0= ruleChild2_5 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1224:1: (lv_child_2_0= ruleChild2_5 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1225:3: lv_child_2_0= ruleChild2_5
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_4Access().getChildChild2_5ParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_ruleScenario2_42374);
            	    lv_child_2_0=ruleChild2_5();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_4Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_2_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_5");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1242:6: ( (lv_child_3_0= ruleChild2_6 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1242:6: ( (lv_child_3_0= ruleChild2_6 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1243:1: (lv_child_3_0= ruleChild2_6 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1243:1: (lv_child_3_0= ruleChild2_6 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1244:3: lv_child_3_0= ruleChild2_6
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_4Access().getChildChild2_6ParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_ruleScenario2_42401);
            	    lv_child_3_0=ruleChild2_6();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_4Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_6");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_42415); 

                	newLeafNode(otherlv_4, grammarAccess.getScenario2_4Access().getNextKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_4"


    // $ANTLR start "entryRuleScenario2_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1272:1: entryRuleScenario2_5 returns [EObject current=null] : iv_ruleScenario2_5= ruleScenario2_5 EOF ;
    public final EObject entryRuleScenario2_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_5 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1273:2: (iv_ruleScenario2_5= ruleScenario2_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1274:2: iv_ruleScenario2_5= ruleScenario2_5 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_5_in_entryRuleScenario2_52451);
            iv_ruleScenario2_5=ruleScenario2_5();

            state._fsp--;

             current =iv_ruleScenario2_5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_52461); 

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
    // $ANTLR end "entryRuleScenario2_5"


    // $ANTLR start "ruleScenario2_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1281:1: ruleScenario2_5 returns [EObject current=null] : ( () otherlv_1= '2.5' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )? otherlv_5= 'next' ) ;
    public final EObject ruleScenario2_5() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;

        EObject lv_child_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1284:28: ( ( () otherlv_1= '2.5' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )? otherlv_5= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1285:1: ( () otherlv_1= '2.5' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )? otherlv_5= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1285:1: ( () otherlv_1= '2.5' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )? otherlv_5= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1285:2: () otherlv_1= '2.5' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )? otherlv_5= 'next'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1285:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1286:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getScenario2_5Access().getScenario2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleScenario2_52507); 

                	newLeafNode(otherlv_1, grammarAccess.getScenario2_5Access().getDigitTwoFullStopDigitFiveKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1295:1: ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )?
            int alt13=4;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1295:2: ( (lv_child_2_0= ruleChild2_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1295:2: ( (lv_child_2_0= ruleChild2_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1296:1: (lv_child_2_0= ruleChild2_1 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1296:1: (lv_child_2_0= ruleChild2_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1297:3: lv_child_2_0= ruleChild2_1
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_5Access().getChildChild2_1ParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_ruleScenario2_52529);
                    lv_child_2_0=ruleChild2_1();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_5Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_1");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1314:6: ( (lv_child_3_0= ruleChild2_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1314:6: ( (lv_child_3_0= ruleChild2_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1315:1: (lv_child_3_0= ruleChild2_2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1315:1: (lv_child_3_0= ruleChild2_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1316:3: lv_child_3_0= ruleChild2_2
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_5Access().getChildChild2_2ParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_ruleScenario2_52556);
                    lv_child_3_0=ruleChild2_2();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_5Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_2");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1333:6: ( (lv_child_4_0= ruleChild2_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1333:6: ( (lv_child_4_0= ruleChild2_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1334:1: (lv_child_4_0= ruleChild2_3 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1334:1: (lv_child_4_0= ruleChild2_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1335:3: lv_child_4_0= ruleChild2_3
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_5Access().getChildChild2_3ParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_ruleScenario2_52583);
                    lv_child_4_0=ruleChild2_3();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_5Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_4_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_3");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_52597); 

                	newLeafNode(otherlv_5, grammarAccess.getScenario2_5Access().getNextKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_5"


    // $ANTLR start "entryRuleScenario2_6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1363:1: entryRuleScenario2_6 returns [EObject current=null] : iv_ruleScenario2_6= ruleScenario2_6 EOF ;
    public final EObject entryRuleScenario2_6() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_6 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1364:2: (iv_ruleScenario2_6= ruleScenario2_6 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1365:2: iv_ruleScenario2_6= ruleScenario2_6 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_6Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_6_in_entryRuleScenario2_62633);
            iv_ruleScenario2_6=ruleScenario2_6();

            state._fsp--;

             current =iv_ruleScenario2_6; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_62643); 

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
    // $ANTLR end "entryRuleScenario2_6"


    // $ANTLR start "ruleScenario2_6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1372:1: ruleScenario2_6 returns [EObject current=null] : ( () otherlv_1= '2.6' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )* otherlv_5= 'next' ) ;
    public final EObject ruleScenario2_6() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;

        EObject lv_child_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1375:28: ( ( () otherlv_1= '2.6' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )* otherlv_5= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1376:1: ( () otherlv_1= '2.6' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )* otherlv_5= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1376:1: ( () otherlv_1= '2.6' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )* otherlv_5= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1376:2: () otherlv_1= '2.6' ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )* otherlv_5= 'next'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1376:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1377:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getScenario2_6Access().getScenario2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleScenario2_62689); 

                	newLeafNode(otherlv_1, grammarAccess.getScenario2_6Access().getDigitTwoFullStopDigitSixKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1386:1: ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )*
            loop14:
            do {
                int alt14=4;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1386:2: ( (lv_child_2_0= ruleChild2_1 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1386:2: ( (lv_child_2_0= ruleChild2_1 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1387:1: (lv_child_2_0= ruleChild2_1 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1387:1: (lv_child_2_0= ruleChild2_1 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1388:3: lv_child_2_0= ruleChild2_1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_6Access().getChildChild2_1ParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_ruleScenario2_62711);
            	    lv_child_2_0=ruleChild2_1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_6Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_2_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_1");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1405:6: ( (lv_child_3_0= ruleChild2_2 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1405:6: ( (lv_child_3_0= ruleChild2_2 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1406:1: (lv_child_3_0= ruleChild2_2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1406:1: (lv_child_3_0= ruleChild2_2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1407:3: lv_child_3_0= ruleChild2_2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_6Access().getChildChild2_2ParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_ruleScenario2_62738);
            	    lv_child_3_0=ruleChild2_2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_6Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1424:6: ( (lv_child_4_0= ruleChild2_3 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1424:6: ( (lv_child_4_0= ruleChild2_3 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1425:1: (lv_child_4_0= ruleChild2_3 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1425:1: (lv_child_4_0= ruleChild2_3 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1426:3: lv_child_4_0= ruleChild2_3
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_6Access().getChildChild2_3ParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_ruleScenario2_62765);
            	    lv_child_4_0=ruleChild2_3();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_6Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_4_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_3");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_62779); 

                	newLeafNode(otherlv_5, grammarAccess.getScenario2_6Access().getNextKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_6"


    // $ANTLR start "entryRuleScenario2_7"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1454:1: entryRuleScenario2_7 returns [EObject current=null] : iv_ruleScenario2_7= ruleScenario2_7 EOF ;
    public final EObject entryRuleScenario2_7() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_7 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1455:2: (iv_ruleScenario2_7= ruleScenario2_7 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1456:2: iv_ruleScenario2_7= ruleScenario2_7 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_7Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_7_in_entryRuleScenario2_72815);
            iv_ruleScenario2_7=ruleScenario2_7();

            state._fsp--;

             current =iv_ruleScenario2_7; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_72825); 

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
    // $ANTLR end "entryRuleScenario2_7"


    // $ANTLR start "ruleScenario2_7"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1463:1: ruleScenario2_7 returns [EObject current=null] : ( () otherlv_1= '2.7' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )? otherlv_5= 'next' ) ;
    public final EObject ruleScenario2_7() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;

        EObject lv_child_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1466:28: ( ( () otherlv_1= '2.7' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )? otherlv_5= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1467:1: ( () otherlv_1= '2.7' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )? otherlv_5= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1467:1: ( () otherlv_1= '2.7' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )? otherlv_5= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1467:2: () otherlv_1= '2.7' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )? otherlv_5= 'next'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1467:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1468:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getScenario2_7Access().getScenario2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleScenario2_72871); 

                	newLeafNode(otherlv_1, grammarAccess.getScenario2_7Access().getDigitTwoFullStopDigitSevenKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1477:1: ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )?
            int alt15=4;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1477:2: ( (lv_child_2_0= ruleChild2_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1477:2: ( (lv_child_2_0= ruleChild2_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1478:1: (lv_child_2_0= ruleChild2_4 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1478:1: (lv_child_2_0= ruleChild2_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1479:3: lv_child_2_0= ruleChild2_4
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_7Access().getChildChild2_4ParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_ruleScenario2_72893);
                    lv_child_2_0=ruleChild2_4();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_7Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_2_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_4");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1496:6: ( (lv_child_3_0= ruleChild2_5 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1496:6: ( (lv_child_3_0= ruleChild2_5 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1497:1: (lv_child_3_0= ruleChild2_5 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1497:1: (lv_child_3_0= ruleChild2_5 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1498:3: lv_child_3_0= ruleChild2_5
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_7Access().getChildChild2_5ParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_ruleScenario2_72920);
                    lv_child_3_0=ruleChild2_5();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_7Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_5");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1515:6: ( (lv_child_4_0= ruleChild2_6 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1515:6: ( (lv_child_4_0= ruleChild2_6 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1516:1: (lv_child_4_0= ruleChild2_6 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1516:1: (lv_child_4_0= ruleChild2_6 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1517:3: lv_child_4_0= ruleChild2_6
                    {
                     
                    	        newCompositeNode(grammarAccess.getScenario2_7Access().getChildChild2_6ParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_ruleScenario2_72947);
                    lv_child_4_0=ruleChild2_6();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getScenario2_7Rule());
                    	        }
                           		add(
                           			current, 
                           			"child",
                            		lv_child_4_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_6");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_72961); 

                	newLeafNode(otherlv_5, grammarAccess.getScenario2_7Access().getNextKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_7"


    // $ANTLR start "entryRuleScenario2_8"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1545:1: entryRuleScenario2_8 returns [EObject current=null] : iv_ruleScenario2_8= ruleScenario2_8 EOF ;
    public final EObject entryRuleScenario2_8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenario2_8 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1546:2: (iv_ruleScenario2_8= ruleScenario2_8 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1547:2: iv_ruleScenario2_8= ruleScenario2_8 EOF
            {
             newCompositeNode(grammarAccess.getScenario2_8Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleScenario2_8_in_entryRuleScenario2_82997);
            iv_ruleScenario2_8=ruleScenario2_8();

            state._fsp--;

             current =iv_ruleScenario2_8; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleScenario2_83007); 

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
    // $ANTLR end "entryRuleScenario2_8"


    // $ANTLR start "ruleScenario2_8"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1554:1: ruleScenario2_8 returns [EObject current=null] : ( () otherlv_1= '2.8' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )* otherlv_5= 'next' ) ;
    public final EObject ruleScenario2_8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_child_2_0 = null;

        EObject lv_child_3_0 = null;

        EObject lv_child_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1557:28: ( ( () otherlv_1= '2.8' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )* otherlv_5= 'next' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1558:1: ( () otherlv_1= '2.8' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )* otherlv_5= 'next' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1558:1: ( () otherlv_1= '2.8' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )* otherlv_5= 'next' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1558:2: () otherlv_1= '2.8' ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )* otherlv_5= 'next'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1558:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1559:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getScenario2_8Access().getScenario2Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleScenario2_83053); 

                	newLeafNode(otherlv_1, grammarAccess.getScenario2_8Access().getDigitTwoFullStopDigitEightKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1568:1: ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )*
            loop16:
            do {
                int alt16=4;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1568:2: ( (lv_child_2_0= ruleChild2_4 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1568:2: ( (lv_child_2_0= ruleChild2_4 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1569:1: (lv_child_2_0= ruleChild2_4 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1569:1: (lv_child_2_0= ruleChild2_4 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1570:3: lv_child_2_0= ruleChild2_4
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_8Access().getChildChild2_4ParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_ruleScenario2_83075);
            	    lv_child_2_0=ruleChild2_4();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_8Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_2_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_4");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1587:6: ( (lv_child_3_0= ruleChild2_5 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1587:6: ( (lv_child_3_0= ruleChild2_5 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1588:1: (lv_child_3_0= ruleChild2_5 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1588:1: (lv_child_3_0= ruleChild2_5 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1589:3: lv_child_3_0= ruleChild2_5
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_8Access().getChildChild2_5ParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_ruleScenario2_83102);
            	    lv_child_3_0=ruleChild2_5();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_8Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_3_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_5");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1606:6: ( (lv_child_4_0= ruleChild2_6 ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1606:6: ( (lv_child_4_0= ruleChild2_6 ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1607:1: (lv_child_4_0= ruleChild2_6 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1607:1: (lv_child_4_0= ruleChild2_6 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1608:3: lv_child_4_0= ruleChild2_6
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getScenario2_8Access().getChildChild2_6ParserRuleCall_2_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_ruleScenario2_83129);
            	    lv_child_4_0=ruleChild2_6();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getScenario2_8Rule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"child",
            	            		lv_child_4_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug348427TestLanguage.Child2_6");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleScenario2_83143); 

                	newLeafNode(otherlv_5, grammarAccess.getScenario2_8Access().getNextKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenario2_8"


    // $ANTLR start "entryRuleChild2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1636:1: entryRuleChild2_1 returns [EObject current=null] : iv_ruleChild2_1= ruleChild2_1 EOF ;
    public final EObject entryRuleChild2_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2_1 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1637:2: (iv_ruleChild2_1= ruleChild2_1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1638:2: iv_ruleChild2_1= ruleChild2_1 EOF
            {
             newCompositeNode(grammarAccess.getChild2_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_1_in_entryRuleChild2_13179);
            iv_ruleChild2_1=ruleChild2_1();

            state._fsp--;

             current =iv_ruleChild2_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_13189); 

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
    // $ANTLR end "entryRuleChild2_1"


    // $ANTLR start "ruleChild2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1645:1: ruleChild2_1 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child1' otherlv_6= 'end' ) ;
    public final EObject ruleChild2_1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token lv_string_4_1=null;
        Token lv_string_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1648:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child1' otherlv_6= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1649:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child1' otherlv_6= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1649:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child1' otherlv_6= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1649:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child1' otherlv_6= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1649:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1650:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1650:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1651:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild2_13231); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild2_1Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild2_1Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild2_13248); 

                	newLeafNode(otherlv_1, grammarAccess.getChild2_1Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1671:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1671:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1671:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1672:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1672:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1673:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild2_13267); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild2_1Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_1Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild2_13292); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild2_1Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1690:3: ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1691:1: ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1691:1: ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1692:1: (lv_string_4_1= 'a' | lv_string_4_2= 'b' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1692:1: (lv_string_4_1= 'a' | lv_string_4_2= 'b' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            else if ( (LA18_0==32) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1693:3: lv_string_4_1= 'a'
                    {
                    lv_string_4_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleChild2_13314); 

                            newLeafNode(lv_string_4_1, grammarAccess.getChild2_1Access().getStringAKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_1Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1705:8: lv_string_4_2= 'b'
                    {
                    lv_string_4_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleChild2_13343); 

                            newLeafNode(lv_string_4_2, grammarAccess.getChild2_1Access().getStringBKeyword_3_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_1Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleChild2_13371); 

                	newLeafNode(otherlv_5, grammarAccess.getChild2_1Access().getChild1Keyword_4());
                
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild2_13383); 

                	newLeafNode(otherlv_6, grammarAccess.getChild2_1Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild2_1"


    // $ANTLR start "entryRuleChild2_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1736:1: entryRuleChild2_2 returns [EObject current=null] : iv_ruleChild2_2= ruleChild2_2 EOF ;
    public final EObject entryRuleChild2_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2_2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1737:2: (iv_ruleChild2_2= ruleChild2_2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1738:2: iv_ruleChild2_2= ruleChild2_2 EOF
            {
             newCompositeNode(grammarAccess.getChild2_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_2_in_entryRuleChild2_23419);
            iv_ruleChild2_2=ruleChild2_2();

            state._fsp--;

             current =iv_ruleChild2_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_23429); 

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
    // $ANTLR end "entryRuleChild2_2"


    // $ANTLR start "ruleChild2_2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1745:1: ruleChild2_2 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child2' otherlv_6= 'end' ) ;
    public final EObject ruleChild2_2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token lv_string_4_1=null;
        Token lv_string_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1748:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child2' otherlv_6= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1749:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child2' otherlv_6= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1749:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child2' otherlv_6= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1749:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child2' otherlv_6= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1749:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1750:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1750:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1751:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild2_23471); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild2_2Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild2_2Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild2_23488); 

                	newLeafNode(otherlv_1, grammarAccess.getChild2_2Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1771:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1771:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1771:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1772:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1772:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1773:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild2_23507); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild2_2Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_2Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild2_23532); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild2_2Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1790:3: ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1791:1: ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1791:1: ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1792:1: (lv_string_4_1= 'a' | lv_string_4_2= 'b' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1792:1: (lv_string_4_1= 'a' | lv_string_4_2= 'b' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==31) ) {
                alt20=1;
            }
            else if ( (LA20_0==32) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1793:3: lv_string_4_1= 'a'
                    {
                    lv_string_4_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleChild2_23554); 

                            newLeafNode(lv_string_4_1, grammarAccess.getChild2_2Access().getStringAKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_2Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1805:8: lv_string_4_2= 'b'
                    {
                    lv_string_4_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleChild2_23583); 

                            newLeafNode(lv_string_4_2, grammarAccess.getChild2_2Access().getStringBKeyword_3_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_2Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleChild2_23611); 

                	newLeafNode(otherlv_5, grammarAccess.getChild2_2Access().getChild2Keyword_4());
                
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild2_23623); 

                	newLeafNode(otherlv_6, grammarAccess.getChild2_2Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild2_2"


    // $ANTLR start "entryRuleChild2_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1836:1: entryRuleChild2_3 returns [EObject current=null] : iv_ruleChild2_3= ruleChild2_3 EOF ;
    public final EObject entryRuleChild2_3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2_3 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1837:2: (iv_ruleChild2_3= ruleChild2_3 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1838:2: iv_ruleChild2_3= ruleChild2_3 EOF
            {
             newCompositeNode(grammarAccess.getChild2_3Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_3_in_entryRuleChild2_33659);
            iv_ruleChild2_3=ruleChild2_3();

            state._fsp--;

             current =iv_ruleChild2_3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_33669); 

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
    // $ANTLR end "entryRuleChild2_3"


    // $ANTLR start "ruleChild2_3"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1845:1: ruleChild2_3 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child3' otherlv_6= 'end' ) ;
    public final EObject ruleChild2_3() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token lv_string_4_1=null;
        Token lv_string_4_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1848:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child3' otherlv_6= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1849:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child3' otherlv_6= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1849:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child3' otherlv_6= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1849:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) ) otherlv_5= 'child3' otherlv_6= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1849:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1850:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1850:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1851:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild2_33711); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild2_3Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild2_3Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild2_33728); 

                	newLeafNode(otherlv_1, grammarAccess.getChild2_3Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1871:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1871:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1871:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1872:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1872:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1873:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild2_33747); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild2_3Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_3Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild2_33772); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild2_3Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1890:3: ( ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1891:1: ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1891:1: ( (lv_string_4_1= 'a' | lv_string_4_2= 'b' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1892:1: (lv_string_4_1= 'a' | lv_string_4_2= 'b' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1892:1: (lv_string_4_1= 'a' | lv_string_4_2= 'b' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==31) ) {
                alt22=1;
            }
            else if ( (LA22_0==32) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1893:3: lv_string_4_1= 'a'
                    {
                    lv_string_4_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleChild2_33794); 

                            newLeafNode(lv_string_4_1, grammarAccess.getChild2_3Access().getStringAKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_3Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1905:8: lv_string_4_2= 'b'
                    {
                    lv_string_4_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleChild2_33823); 

                            newLeafNode(lv_string_4_2, grammarAccess.getChild2_3Access().getStringBKeyword_3_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_3Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleChild2_33851); 

                	newLeafNode(otherlv_5, grammarAccess.getChild2_3Access().getChild3Keyword_4());
                
            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild2_33863); 

                	newLeafNode(otherlv_6, grammarAccess.getChild2_3Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild2_3"


    // $ANTLR start "entryRuleChild2_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1936:1: entryRuleChild2_4 returns [EObject current=null] : iv_ruleChild2_4= ruleChild2_4 EOF ;
    public final EObject entryRuleChild2_4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2_4 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1937:2: (iv_ruleChild2_4= ruleChild2_4 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1938:2: iv_ruleChild2_4= ruleChild2_4 EOF
            {
             newCompositeNode(grammarAccess.getChild2_4Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_4_in_entryRuleChild2_43899);
            iv_ruleChild2_4=ruleChild2_4();

            state._fsp--;

             current =iv_ruleChild2_4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_43909); 

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
    // $ANTLR end "entryRuleChild2_4"


    // $ANTLR start "ruleChild2_4"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1945:1: ruleChild2_4 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child1' otherlv_7= 'end' ) ;
    public final EObject ruleChild2_4() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token lv_string_4_0=null;
        Token lv_string_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1948:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child1' otherlv_7= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1949:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child1' otherlv_7= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1949:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child1' otherlv_7= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1949:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child1' otherlv_7= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1949:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1950:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1950:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1951:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild2_43951); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild2_4Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild2_4Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild2_43968); 

                	newLeafNode(otherlv_1, grammarAccess.getChild2_4Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1971:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1971:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1971:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1972:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1972:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1973:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild2_43987); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild2_4Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_4Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild2_44012); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild2_4Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1990:3: ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            else if ( (LA24_0==32) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1990:4: ( (lv_string_4_0= 'a' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1990:4: ( (lv_string_4_0= 'a' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1991:1: (lv_string_4_0= 'a' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1991:1: (lv_string_4_0= 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:1992:3: lv_string_4_0= 'a'
                    {
                    lv_string_4_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleChild2_44033); 

                            newLeafNode(lv_string_4_0, grammarAccess.getChild2_4Access().getStringAKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_4Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_0, "a");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2006:6: ( (lv_string_5_0= 'b' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2006:6: ( (lv_string_5_0= 'b' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2007:1: (lv_string_5_0= 'b' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2007:1: (lv_string_5_0= 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2008:3: lv_string_5_0= 'b'
                    {
                    lv_string_5_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleChild2_44070); 

                            newLeafNode(lv_string_5_0, grammarAccess.getChild2_4Access().getStringBKeyword_3_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_4Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_5_0, "b");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleChild2_44096); 

                	newLeafNode(otherlv_6, grammarAccess.getChild2_4Access().getChild1Keyword_4());
                
            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild2_44108); 

                	newLeafNode(otherlv_7, grammarAccess.getChild2_4Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild2_4"


    // $ANTLR start "entryRuleChild2_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2037:1: entryRuleChild2_5 returns [EObject current=null] : iv_ruleChild2_5= ruleChild2_5 EOF ;
    public final EObject entryRuleChild2_5() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2_5 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2038:2: (iv_ruleChild2_5= ruleChild2_5 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2039:2: iv_ruleChild2_5= ruleChild2_5 EOF
            {
             newCompositeNode(grammarAccess.getChild2_5Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_5_in_entryRuleChild2_54144);
            iv_ruleChild2_5=ruleChild2_5();

            state._fsp--;

             current =iv_ruleChild2_5; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_54154); 

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
    // $ANTLR end "entryRuleChild2_5"


    // $ANTLR start "ruleChild2_5"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2046:1: ruleChild2_5 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child2' otherlv_7= 'end' ) ;
    public final EObject ruleChild2_5() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token lv_string_4_0=null;
        Token lv_string_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2049:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child2' otherlv_7= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2050:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child2' otherlv_7= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2050:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child2' otherlv_7= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2050:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child2' otherlv_7= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2050:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2051:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2051:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2052:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild2_54196); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild2_5Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild2_5Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild2_54213); 

                	newLeafNode(otherlv_1, grammarAccess.getChild2_5Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2072:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==17) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2072:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2072:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2073:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2073:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2074:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild2_54232); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild2_5Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_5Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild2_54257); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild2_5Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2091:3: ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==31) ) {
                alt26=1;
            }
            else if ( (LA26_0==32) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2091:4: ( (lv_string_4_0= 'a' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2091:4: ( (lv_string_4_0= 'a' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2092:1: (lv_string_4_0= 'a' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2092:1: (lv_string_4_0= 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2093:3: lv_string_4_0= 'a'
                    {
                    lv_string_4_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleChild2_54278); 

                            newLeafNode(lv_string_4_0, grammarAccess.getChild2_5Access().getStringAKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_5Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_0, "a");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2107:6: ( (lv_string_5_0= 'b' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2107:6: ( (lv_string_5_0= 'b' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2108:1: (lv_string_5_0= 'b' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2108:1: (lv_string_5_0= 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2109:3: lv_string_5_0= 'b'
                    {
                    lv_string_5_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleChild2_54315); 

                            newLeafNode(lv_string_5_0, grammarAccess.getChild2_5Access().getStringBKeyword_3_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_5Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_5_0, "b");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleChild2_54341); 

                	newLeafNode(otherlv_6, grammarAccess.getChild2_5Access().getChild2Keyword_4());
                
            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild2_54353); 

                	newLeafNode(otherlv_7, grammarAccess.getChild2_5Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild2_5"


    // $ANTLR start "entryRuleChild2_6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2138:1: entryRuleChild2_6 returns [EObject current=null] : iv_ruleChild2_6= ruleChild2_6 EOF ;
    public final EObject entryRuleChild2_6() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2_6 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2139:2: (iv_ruleChild2_6= ruleChild2_6 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2140:2: iv_ruleChild2_6= ruleChild2_6 EOF
            {
             newCompositeNode(grammarAccess.getChild2_6Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_6_in_entryRuleChild2_64389);
            iv_ruleChild2_6=ruleChild2_6();

            state._fsp--;

             current =iv_ruleChild2_6; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild2_64399); 

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
    // $ANTLR end "entryRuleChild2_6"


    // $ANTLR start "ruleChild2_6"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2147:1: ruleChild2_6 returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child3' otherlv_7= 'end' ) ;
    public final EObject ruleChild2_6() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_bool_2_0=null;
        Token otherlv_3=null;
        Token lv_string_4_0=null;
        Token lv_string_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2150:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child3' otherlv_7= 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2151:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child3' otherlv_7= 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2151:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child3' otherlv_7= 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2151:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )? ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) ) otherlv_6= 'child3' otherlv_7= 'end'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2151:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2152:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2152:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2153:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild2_64441); 

            			newLeafNode(lv_name_0_0, grammarAccess.getChild2_6Access().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getChild2_6Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChild2_64458); 

                	newLeafNode(otherlv_1, grammarAccess.getChild2_6Access().getColonKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2173:1: ( ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2173:2: ( (lv_bool_2_0= 'bool' ) ) otherlv_3= 'keyword'
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2173:2: ( (lv_bool_2_0= 'bool' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2174:1: (lv_bool_2_0= 'bool' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2174:1: (lv_bool_2_0= 'bool' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2175:3: lv_bool_2_0= 'bool'
                    {
                    lv_bool_2_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild2_64477); 

                            newLeafNode(lv_bool_2_0, grammarAccess.getChild2_6Access().getBoolBoolKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_6Rule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "bool");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild2_64502); 

                        	newLeafNode(otherlv_3, grammarAccess.getChild2_6Access().getKeywordKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2192:3: ( ( (lv_string_4_0= 'a' ) ) | ( (lv_string_5_0= 'b' ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==31) ) {
                alt28=1;
            }
            else if ( (LA28_0==32) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2192:4: ( (lv_string_4_0= 'a' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2192:4: ( (lv_string_4_0= 'a' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2193:1: (lv_string_4_0= 'a' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2193:1: (lv_string_4_0= 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2194:3: lv_string_4_0= 'a'
                    {
                    lv_string_4_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleChild2_64523); 

                            newLeafNode(lv_string_4_0, grammarAccess.getChild2_6Access().getStringAKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_6Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_4_0, "a");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2208:6: ( (lv_string_5_0= 'b' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2208:6: ( (lv_string_5_0= 'b' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2209:1: (lv_string_5_0= 'b' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2209:1: (lv_string_5_0= 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2210:3: lv_string_5_0= 'b'
                    {
                    lv_string_5_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleChild2_64560); 

                            newLeafNode(lv_string_5_0, grammarAccess.getChild2_6Access().getStringBKeyword_3_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getChild2_6Rule());
                    	        }
                           		setWithLastConsumed(current, "string", lv_string_5_0, "b");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleChild2_64586); 

                	newLeafNode(otherlv_6, grammarAccess.getChild2_6Access().getChild3Keyword_4());
                
            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild2_64598); 

                	newLeafNode(otherlv_7, grammarAccess.getChild2_6Access().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChild2_6"


    // $ANTLR start "ruleEnumType"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2239:1: ruleEnumType returns [Enumerator current=null] : ( (enumLiteral_0= 'a' ) | (enumLiteral_1= 'b' ) ) ;
    public final Enumerator ruleEnumType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2241:28: ( ( (enumLiteral_0= 'a' ) | (enumLiteral_1= 'b' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2242:1: ( (enumLiteral_0= 'a' ) | (enumLiteral_1= 'b' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2242:1: ( (enumLiteral_0= 'a' ) | (enumLiteral_1= 'b' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==31) ) {
                alt29=1;
            }
            else if ( (LA29_0==32) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2242:2: (enumLiteral_0= 'a' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2242:2: (enumLiteral_0= 'a' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2242:4: enumLiteral_0= 'a'
                    {
                    enumLiteral_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleEnumType4648); 

                            current = grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEnumTypeAccess().getAEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2248:6: (enumLiteral_1= 'b' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2248:6: (enumLiteral_1= 'b' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug348427TestLanguage.g:2248:8: enumLiteral_1= 'b'
                    {
                    enumLiteral_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEnumType4665); 

                            current = grammarAccess.getEnumTypeAccess().getBEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEnumTypeAccess().getBEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumType"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA2_eotS =
        "\12\uffff";
    static final String DFA2_eofS =
        "\12\uffff";
    static final String DFA2_minS =
        "\1\4\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA2_maxS =
        "\1\4\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA2_acceptS =
        "\7\uffff\1\3\1\1\1\2";
    static final String DFA2_specialS =
        "\12\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\15\uffff\1\4\1\5",
            "\1\6",
            "\1\10\1\uffff\1\11\1\7",
            "\1\10\1\uffff\1\11\1\7",
            "\1\4\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "333:1: ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )";
        }
    }
    static final String DFA3_eotS =
        "\13\uffff";
    static final String DFA3_eofS =
        "\13\uffff";
    static final String DFA3_minS =
        "\1\4\1\uffff\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA3_maxS =
        "\1\14\1\uffff\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\4\6\uffff\1\3\1\2\1\1";
    static final String DFA3_specialS =
        "\13\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\7\uffff\1\1",
            "",
            "\1\3",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\12\1\uffff\1\11\1\10",
            "\1\12\1\uffff\1\11\1\10",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()+ loopback of 418:1: ( ( (lv_child_1_0= ruleChild1_1 ) ) | ( (lv_child_2_0= ruleChild1_2 ) ) | ( (lv_child_3_0= ruleChild1_3 ) ) )+";
        }
    }
    static final String DFA4_eotS =
        "\13\uffff";
    static final String DFA4_eofS =
        "\13\uffff";
    static final String DFA4_minS =
        "\1\4\1\uffff\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA4_maxS =
        "\1\14\1\uffff\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\4\6\uffff\1\3\1\2\1\1";
    static final String DFA4_specialS =
        "\13\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\7\uffff\1\1",
            "",
            "\1\3",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\12\1\uffff\1\11\1\10",
            "\1\12\1\uffff\1\11\1\10",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()* loopback of 509:1: ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )*";
        }
    }
    static final String DFA5_eotS =
        "\13\uffff";
    static final String DFA5_eofS =
        "\13\uffff";
    static final String DFA5_minS =
        "\1\4\1\20\1\uffff\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA5_maxS =
        "\1\14\1\20\1\uffff\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\4\5\uffff\1\1\1\3\1\2";
    static final String DFA5_specialS =
        "\13\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\3",
            "",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\10\1\uffff\1\12\1\11",
            "\1\10\1\uffff\1\12\1\11",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "600:1: ( ( (lv_child_2_0= ruleChild1_1 ) ) | ( (lv_child_3_0= ruleChild1_2 ) ) | ( (lv_child_4_0= ruleChild1_3 ) ) )?";
        }
    }
    static final String DFA9_eotS =
        "\12\uffff";
    static final String DFA9_eofS =
        "\12\uffff";
    static final String DFA9_minS =
        "\1\4\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA9_maxS =
        "\1\4\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA9_acceptS =
        "\7\uffff\1\1\1\3\1\2";
    static final String DFA9_specialS =
        "\12\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\15\uffff\1\4\1\5",
            "\1\6",
            "\1\7\1\uffff\1\11\1\10",
            "\1\7\1\uffff\1\11\1\10",
            "\1\4\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "949:1: ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )";
        }
    }
    static final String DFA10_eotS =
        "\13\uffff";
    static final String DFA10_eofS =
        "\13\uffff";
    static final String DFA10_minS =
        "\1\4\1\uffff\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA10_maxS =
        "\1\14\1\uffff\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\4\6\uffff\1\3\1\2\1\1";
    static final String DFA10_specialS =
        "\13\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\7\uffff\1\1",
            "",
            "\1\3",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\12\1\uffff\1\11\1\10",
            "\1\12\1\uffff\1\11\1\10",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1034:1: ( ( (lv_child_1_0= ruleChild2_1 ) ) | ( (lv_child_2_0= ruleChild2_2 ) ) | ( (lv_child_3_0= ruleChild2_3 ) ) )+";
        }
    }
    static final String DFA11_eotS =
        "\12\uffff";
    static final String DFA11_eofS =
        "\12\uffff";
    static final String DFA11_minS =
        "\1\4\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA11_maxS =
        "\1\4\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA11_acceptS =
        "\7\uffff\1\3\1\1\1\2";
    static final String DFA11_specialS =
        "\12\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\15\uffff\1\4\1\5",
            "\1\6",
            "\1\10\1\uffff\1\11\1\7",
            "\1\10\1\uffff\1\11\1\7",
            "\1\4\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1119:1: ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )";
        }
    }
    static final String DFA12_eotS =
        "\13\uffff";
    static final String DFA12_eofS =
        "\13\uffff";
    static final String DFA12_minS =
        "\1\4\1\uffff\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA12_maxS =
        "\1\14\1\uffff\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\4\6\uffff\1\3\1\2\1\1";
    static final String DFA12_specialS =
        "\13\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\7\uffff\1\1",
            "",
            "\1\3",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\12\1\uffff\1\11\1\10",
            "\1\12\1\uffff\1\11\1\10",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1204:1: ( ( (lv_child_1_0= ruleChild2_4 ) ) | ( (lv_child_2_0= ruleChild2_5 ) ) | ( (lv_child_3_0= ruleChild2_6 ) ) )+";
        }
    }
    static final String DFA13_eotS =
        "\13\uffff";
    static final String DFA13_eofS =
        "\13\uffff";
    static final String DFA13_minS =
        "\1\4\1\20\1\uffff\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA13_maxS =
        "\1\14\1\20\1\uffff\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\4\5\uffff\1\2\1\3\1\1";
    static final String DFA13_specialS =
        "\13\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\3",
            "",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\12\1\uffff\1\10\1\11",
            "\1\12\1\uffff\1\10\1\11",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1295:1: ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )?";
        }
    }
    static final String DFA14_eotS =
        "\13\uffff";
    static final String DFA14_eofS =
        "\13\uffff";
    static final String DFA14_minS =
        "\1\4\1\uffff\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA14_maxS =
        "\1\14\1\uffff\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\4\6\uffff\1\3\1\1\1\2";
    static final String DFA14_specialS =
        "\13\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\2\7\uffff\1\1",
            "",
            "\1\3",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\11\1\uffff\1\12\1\10",
            "\1\11\1\uffff\1\12\1\10",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "()* loopback of 1386:1: ( ( (lv_child_2_0= ruleChild2_1 ) ) | ( (lv_child_3_0= ruleChild2_2 ) ) | ( (lv_child_4_0= ruleChild2_3 ) ) )*";
        }
    }
    static final String DFA15_eotS =
        "\13\uffff";
    static final String DFA15_eofS =
        "\13\uffff";
    static final String DFA15_minS =
        "\1\4\1\20\1\uffff\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA15_maxS =
        "\1\14\1\20\1\uffff\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA15_acceptS =
        "\2\uffff\1\4\5\uffff\1\1\1\3\1\2";
    static final String DFA15_specialS =
        "\13\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\3",
            "",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\10\1\uffff\1\12\1\11",
            "\1\10\1\uffff\1\12\1\11",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1477:1: ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )?";
        }
    }
    static final String DFA16_eotS =
        "\13\uffff";
    static final String DFA16_eofS =
        "\13\uffff";
    static final String DFA16_minS =
        "\1\4\1\uffff\1\20\1\21\1\22\2\23\1\37\3\uffff";
    static final String DFA16_maxS =
        "\1\14\1\uffff\1\20\1\40\1\22\2\26\1\40\3\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\4\6\uffff\1\3\1\2\1\1";
    static final String DFA16_specialS =
        "\13\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\2\7\uffff\1\1",
            "",
            "\1\3",
            "\1\4\15\uffff\1\5\1\6",
            "\1\7",
            "\1\12\1\uffff\1\11\1\10",
            "\1\12\1\uffff\1\11\1\10",
            "\1\5\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()* loopback of 1568:1: ( ( (lv_child_2_0= ruleChild2_4 ) ) | ( (lv_child_3_0= ruleChild2_5 ) ) | ( (lv_child_4_0= ruleChild2_6 ) ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_1_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_2_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_3_in_ruleModel185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_4_in_ruleModel212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_1_in_ruleModel239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_2_in_ruleModel266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_3_in_ruleModel293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_4_in_ruleModel320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_5_in_ruleModel347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_6_in_ruleModel374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_7_in_ruleModel401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_8_in_ruleModel428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_1_in_entryRuleScenario1_1464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleScenario1_1511 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleChild1_1_in_ruleScenario1_1533 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild1_2_in_ruleScenario1_1560 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild1_3_in_ruleScenario1_1587 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleScenario1_1600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_2_in_entryRuleScenario1_2636 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_2646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleScenario1_2683 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleChild1_1_in_ruleScenario1_2705 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild1_2_in_ruleScenario1_2732 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild1_3_in_ruleScenario1_2759 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleScenario1_2773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_3_in_entryRuleScenario1_3809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_3819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleScenario1_3865 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild1_1_in_ruleScenario1_3887 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild1_2_in_ruleScenario1_3914 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild1_3_in_ruleScenario1_3941 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleScenario1_3955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario1_4_in_entryRuleScenario1_4991 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario1_41001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleScenario1_41047 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild1_1_in_ruleScenario1_41069 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild1_2_in_ruleScenario1_41096 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild1_3_in_ruleScenario1_41123 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleScenario1_41137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_1_in_entryRuleChild1_11173 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1_11183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild1_11225 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild1_11242 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild1_11261 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild1_11286 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_ruleEnumType_in_ruleChild1_11309 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleChild1_11321 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild1_11333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_2_in_entryRuleChild1_21369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1_21379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild1_21421 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild1_21438 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild1_21457 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild1_21482 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_ruleEnumType_in_ruleChild1_21505 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleChild1_21517 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild1_21529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_3_in_entryRuleChild1_31565 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1_31575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild1_31617 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild1_31634 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild1_31653 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild1_31678 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_ruleEnumType_in_ruleChild1_31701 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleChild1_31713 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild1_31725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_1_in_entryRuleScenario2_11761 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_11771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleScenario2_11808 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleChild2_1_in_ruleScenario2_11830 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_2_in_ruleScenario2_11857 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_3_in_ruleScenario2_11884 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_11897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_2_in_entryRuleScenario2_21933 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_21943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleScenario2_21980 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleChild2_1_in_ruleScenario2_22002 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_2_in_ruleScenario2_22029 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_3_in_ruleScenario2_22056 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_22070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_3_in_entryRuleScenario2_32106 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_32116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleScenario2_32153 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleChild2_4_in_ruleScenario2_32175 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_5_in_ruleScenario2_32202 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_6_in_ruleScenario2_32229 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_32242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_4_in_entryRuleScenario2_42278 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_42288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleScenario2_42325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleChild2_4_in_ruleScenario2_42347 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_5_in_ruleScenario2_42374 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_6_in_ruleScenario2_42401 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_42415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_5_in_entryRuleScenario2_52451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_52461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleScenario2_52507 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_1_in_ruleScenario2_52529 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_2_in_ruleScenario2_52556 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_3_in_ruleScenario2_52583 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_52597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_6_in_entryRuleScenario2_62633 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_62643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleScenario2_62689 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_1_in_ruleScenario2_62711 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_2_in_ruleScenario2_62738 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_3_in_ruleScenario2_62765 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_62779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_7_in_entryRuleScenario2_72815 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_72825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleScenario2_72871 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_4_in_ruleScenario2_72893 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_5_in_ruleScenario2_72920 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleChild2_6_in_ruleScenario2_72947 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_72961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleScenario2_8_in_entryRuleScenario2_82997 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleScenario2_83007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleScenario2_83053 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_4_in_ruleScenario2_83075 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_5_in_ruleScenario2_83102 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleChild2_6_in_ruleScenario2_83129 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleScenario2_83143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_1_in_entryRuleChild2_13179 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_13189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild2_13231 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild2_13248 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild2_13267 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild2_13292 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleChild2_13314 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_32_in_ruleChild2_13343 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleChild2_13371 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild2_13383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_2_in_entryRuleChild2_23419 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_23429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild2_23471 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild2_23488 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild2_23507 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild2_23532 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleChild2_23554 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_32_in_ruleChild2_23583 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleChild2_23611 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild2_23623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_3_in_entryRuleChild2_33659 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_33669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild2_33711 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild2_33728 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild2_33747 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild2_33772 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleChild2_33794 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_32_in_ruleChild2_33823 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleChild2_33851 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild2_33863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_4_in_entryRuleChild2_43899 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_43909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild2_43951 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild2_43968 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild2_43987 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild2_44012 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleChild2_44033 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_32_in_ruleChild2_44070 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleChild2_44096 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild2_44108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_5_in_entryRuleChild2_54144 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_54154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild2_54196 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild2_54213 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild2_54232 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild2_54257 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleChild2_54278 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_32_in_ruleChild2_54315 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleChild2_54341 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild2_54353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_6_in_entryRuleChild2_64389 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild2_64399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild2_64441 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleChild2_64458 = new BitSet(new long[]{0x0000000180020000L});
        public static final BitSet FOLLOW_17_in_ruleChild2_64477 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild2_64502 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_ruleChild2_64523 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_32_in_ruleChild2_64560 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleChild2_64586 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild2_64598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleEnumType4648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEnumType4665 = new BitSet(new long[]{0x0000000000000002L});
    }


}