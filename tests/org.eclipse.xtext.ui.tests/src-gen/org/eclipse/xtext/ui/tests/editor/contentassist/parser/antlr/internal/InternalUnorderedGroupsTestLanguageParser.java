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
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.UnorderedGroupsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalUnorderedGroupsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'3'", "'4'", "'5'", "'bug304681'", "'public'", "'private'", "'protected'", "'static'", "'synchronized'", "'abstract'", "'final'", "'class'", "'{'", "'}'", "'before'", "'after'", "'short'", "';'", "'long'", "'uid'", "'flag'", "'attr'", "'ref'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=5;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__33=33;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int T__31=31;
    public static final int RULE_INT=6;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__32=32;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__34=34;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalUnorderedGroupsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUnorderedGroupsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUnorderedGroupsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private UnorderedGroupsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalUnorderedGroupsTestLanguageParser(TokenStream input, IAstFactory factory, UnorderedGroupsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected UnorderedGroupsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:79:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:80:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); if (state.failed) return current;

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:87:1: ruleModel returns [EObject current=null] : ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_first_1_0 = null;

        EObject lv_second_3_0 = null;

        EObject lv_thrird_5_0 = null;

        EObject lv_forth_7_0 = null;

        EObject lv_fifth_9_0 = null;

        EObject lv_model_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:92:6: ( ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:1: ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:1: ( (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) ) | (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) ) | (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) ) | (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) ) | (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) ) | (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
                }
                break;
            case 16:
                {
                alt1=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:2: (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:2: (otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:93:4: otherlv_0= '1' ( (lv_first_1_0= ruleSimpleModel ) )
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:97:1: ( (lv_first_1_0= ruleSimpleModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:98:1: (lv_first_1_0= ruleSimpleModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:98:1: (lv_first_1_0= ruleSimpleModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:99:3: lv_first_1_0= ruleSimpleModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getFirstSimpleModelParserRuleCall_0_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_ruleModel150);
                    lv_first_1_0=ruleSimpleModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"first",
                      	        		lv_first_1_0, 
                      	        		"SimpleModel", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:122:6: (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:122:6: (otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:122:8: otherlv_2= '2' ( (lv_second_3_0= ruleMandatoryModel ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel170); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_2, grammarAccess.getModelAccess().getDigitTwoKeyword_1_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:126:1: ( (lv_second_3_0= ruleMandatoryModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:127:1: (lv_second_3_0= ruleMandatoryModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:127:1: (lv_second_3_0= ruleMandatoryModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:128:3: lv_second_3_0= ruleMandatoryModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getSecondMandatoryModelParserRuleCall_1_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_ruleModel191);
                    lv_second_3_0=ruleMandatoryModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"second",
                      	        		lv_second_3_0, 
                      	        		"MandatoryModel", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:151:6: (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:151:6: (otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:151:8: otherlv_4= '3' ( (lv_thrird_5_0= ruleLoopedModel ) )
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel211); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_4, grammarAccess.getModelAccess().getDigitThreeKeyword_2_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:155:1: ( (lv_thrird_5_0= ruleLoopedModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:156:1: (lv_thrird_5_0= ruleLoopedModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:156:1: (lv_thrird_5_0= ruleLoopedModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:157:3: lv_thrird_5_0= ruleLoopedModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getThrirdLoopedModelParserRuleCall_2_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_ruleModel232);
                    lv_thrird_5_0=ruleLoopedModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"thrird",
                      	        		lv_thrird_5_0, 
                      	        		"LoopedModel", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:180:6: (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:180:6: (otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:180:8: otherlv_6= '4' ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel252); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_6, grammarAccess.getModelAccess().getDigitFourKeyword_3_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:184:1: ( (lv_forth_7_0= ruleGroupLoopedModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:185:1: (lv_forth_7_0= ruleGroupLoopedModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:185:1: (lv_forth_7_0= ruleGroupLoopedModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:186:3: lv_forth_7_0= ruleGroupLoopedModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getForthGroupLoopedModelParserRuleCall_3_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_ruleModel273);
                    lv_forth_7_0=ruleGroupLoopedModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"forth",
                      	        		lv_forth_7_0, 
                      	        		"GroupLoopedModel", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:209:6: (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:209:6: (otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:209:8: otherlv_8= '5' ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel293); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_8, grammarAccess.getModelAccess().getDigitFiveKeyword_4_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:213:1: ( (lv_fifth_9_0= ruleLoopedAlternativeModel ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:214:1: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:214:1: (lv_fifth_9_0= ruleLoopedAlternativeModel )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:215:3: lv_fifth_9_0= ruleLoopedAlternativeModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getFifthLoopedAlternativeModelParserRuleCall_4_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_ruleModel314);
                    lv_fifth_9_0=ruleLoopedAlternativeModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"fifth",
                      	        		lv_fifth_9_0, 
                      	        		"LoopedAlternativeModel", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:238:6: (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:238:6: (otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:238:8: otherlv_10= 'bug304681' ( (lv_model_11_0= ruleBug304681Model ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel334); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	createLeafNode(otherlv_10, grammarAccess.getModelAccess().getBug304681Keyword_5_0(), null);
                          
                    }
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:242:1: ( (lv_model_11_0= ruleBug304681Model ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:243:1: (lv_model_11_0= ruleBug304681Model )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:243:1: (lv_model_11_0= ruleBug304681Model )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:244:3: lv_model_11_0= ruleBug304681Model
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getModelBug304681ModelParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_ruleModel355);
                    lv_model_11_0=ruleBug304681Model();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"model",
                      	        		lv_model_11_0, 
                      	        		"Bug304681Model", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSimpleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:274:1: entryRuleSimpleModel returns [EObject current=null] : iv_ruleSimpleModel= ruleSimpleModel EOF ;
    public final EObject entryRuleSimpleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleModel = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:280:2: (iv_ruleSimpleModel= ruleSimpleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:281:2: iv_ruleSimpleModel= ruleSimpleModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel398);
            iv_ruleSimpleModel=ruleSimpleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleModel408); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleModel"


    // $ANTLR start "ruleSimpleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:291:1: ruleSimpleModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleSimpleModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getSimpleModelAccess().getUnorderedGroup_0()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:299:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:300:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:302:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:302:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:303:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:306:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:307:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:307:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( LA4_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt4=1;
                }
                else if ( LA4_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt4=1;
                }
                else if ( LA4_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt4=1;
                }
                else if ( LA4_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt4=2;
                }
                else if ( LA4_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt4=3;
                }
                else if ( LA4_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt4=4;
                }
                else if ( LA4_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:309:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:309:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:310:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:310:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:311:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:314:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:316:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:316:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:317:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleModel499); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_1_1, grammarAccess.getSimpleModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:335:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleModel528); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_1_2, grammarAccess.getSimpleModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:353:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleModel557); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_1_3, grammarAccess.getSimpleModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:381:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:381:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:382:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:382:108: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:383:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:386:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:387:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:387:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:388:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSimpleModel641); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_static_2_0, grammarAccess.getSimpleModelAccess().getStaticStaticKeyword_0_1_0(), "static");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "static", true, "static", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:414:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:414:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:415:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:415:108: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:416:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:419:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:420:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:420:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:421:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSimpleModel722); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_synchronized_3_0, grammarAccess.getSimpleModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "synchronized", true, "synchronized", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleSimpleModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:449:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:452:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==22) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==23) ) {
            	        alt3=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:452:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:452:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:453:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:453:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:454:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSimpleModel804); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_abstract_4_0, grammarAccess.getSimpleModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "abstract", true, "abstract", lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:474:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:474:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:475:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:475:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:476:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSimpleModel841); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_final_5_0, grammarAccess.getSimpleModelAccess().getFinalFinalKeyword_0_3_1_0(), "final");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "final", true, "final", lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0());

            }

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSimpleModel906); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_6, grammarAccess.getSimpleModelAccess().getClassKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:513:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:514:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:514:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:515:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleModel923); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_7_0, grammarAccess.getSimpleModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSimpleModelRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_7_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleSimpleModel940); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_8, grammarAccess.getSimpleModelAccess().getLeftCurlyBracketKeyword_3(), null);
                  
            }
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleSimpleModel952); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_9, grammarAccess.getSimpleModelAccess().getRightCurlyBracketKeyword_4(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleSimpleModel"


    // $ANTLR start "entryRuleMandatoryModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:556:1: entryRuleMandatoryModel returns [EObject current=null] : iv_ruleMandatoryModel= ruleMandatoryModel EOF ;
    public final EObject entryRuleMandatoryModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatoryModel = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:562:2: (iv_ruleMandatoryModel= ruleMandatoryModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:563:2: iv_ruleMandatoryModel= ruleMandatoryModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMandatoryModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel998);
            iv_ruleMandatoryModel=ruleMandatoryModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMandatoryModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMandatoryModel1008); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleMandatoryModel"


    // $ANTLR start "ruleMandatoryModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:573:1: ruleMandatoryModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleMandatoryModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:581:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:582:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:582:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:582:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:582:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:584:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:584:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:585:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            {
            getUnorderedGroupHelper().enter(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:588:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:589:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:589:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                int LA7_0 = input.LA(1);

                if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt7=3;
                }
                else if ( LA7_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt7=4;
                }
                else if ( LA7_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt7=4;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:591:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:591:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:592:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:592:111: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:593:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:596:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:597:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:597:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:598:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:598:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    int alt5=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:599:3: lv_visibility_1_1= 'public'
            	            {
            	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMandatoryModel1099); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_1_1, grammarAccess.getMandatoryModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:617:8: lv_visibility_1_2= 'private'
            	            {
            	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMandatoryModel1128); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_1_2, grammarAccess.getMandatoryModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:8: lv_visibility_1_3= 'protected'
            	            {
            	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMandatoryModel1157); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_1_3, grammarAccess.getMandatoryModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:663:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:663:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:111: ( ( (lv_static_2_0= 'static' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:665:6: ( (lv_static_2_0= 'static' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:668:6: ( (lv_static_2_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:1: (lv_static_2_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:1: (lv_static_2_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:670:3: lv_static_2_0= 'static'
            	    {
            	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMandatoryModel1241); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_static_2_0, grammarAccess.getMandatoryModelAccess().getStaticStaticKeyword_0_1_0(), "static");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "static", true, "static", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:111: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:701:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:702:1: (lv_synchronized_3_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:702:1: (lv_synchronized_3_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:703:3: lv_synchronized_3_0= 'synchronized'
            	    {
            	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMandatoryModel1322); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_synchronized_3_0, grammarAccess.getMandatoryModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "synchronized", true, "synchronized", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:729:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:729:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:730:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:730:111: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:731:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==22) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==23) ) {
            	        alt6=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:7: ( (lv_abstract_4_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: (lv_abstract_4_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: (lv_abstract_4_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:3: lv_abstract_4_0= 'abstract'
            	            {
            	            lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMandatoryModel1404); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_abstract_4_0, grammarAccess.getMandatoryModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "abstract", true, "abstract", lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:756:6: ( (lv_final_5_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:756:6: ( (lv_final_5_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:1: (lv_final_5_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:1: (lv_final_5_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:758:3: lv_final_5_0= 'final'
            	            {
            	            lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMandatoryModel1441); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_final_5_0, grammarAccess.getMandatoryModelAccess().getFinalFinalKeyword_0_3_1_0(), "final");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		set(current, "final", true, "final", lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0()) ) {
                if (state.backtracking>0) {state.failed=true; return current;}
                throw new FailedPredicateException(input, "ruleMandatoryModel", "getUnorderedGroupHelper().canLeave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0())");
            }

            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0());

            }

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMandatoryModel1512); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_6, grammarAccess.getMandatoryModelAccess().getClassKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:796:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:797:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:797:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:798:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMandatoryModel1529); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_7_0, grammarAccess.getMandatoryModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getMandatoryModelRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_7_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleMandatoryModel1546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_8, grammarAccess.getMandatoryModelAccess().getLeftCurlyBracketKeyword_3(), null);
                  
            }
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleMandatoryModel1558); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_9, grammarAccess.getMandatoryModelAccess().getRightCurlyBracketKeyword_4(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleMandatoryModel"


    // $ANTLR start "entryRuleLoopedModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:839:1: entryRuleLoopedModel returns [EObject current=null] : iv_ruleLoopedModel= ruleLoopedModel EOF ;
    public final EObject entryRuleLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedModel = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:845:2: (iv_ruleLoopedModel= ruleLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:846:2: iv_ruleLoopedModel= ruleLoopedModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLoopedModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1604);
            iv_ruleLoopedModel=ruleLoopedModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopedModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedModel1614); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLoopedModel"


    // $ANTLR start "ruleLoopedModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:856:1: ruleLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleLoopedModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getLoopedModelAccess().getUnorderedGroup_0()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:864:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:865:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:865:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:865:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) ) otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:865:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:867:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:867:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:868:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:871:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:872:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:872:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=5;
                int LA13_0 = input.LA(1);

                if ( LA13_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt13=1;
                }
                else if ( LA13_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt13=1;
                }
                else if ( LA13_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
                    alt13=1;
                }
                else if ( LA13_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
                    alt13=2;
                }
                else if ( LA13_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
                    alt13=3;
                }
                else if ( LA13_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt13=4;
                }
                else if ( LA13_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
                    alt13=4;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:875:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:875:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:876:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:879:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        switch ( input.LA(1) ) {
            	        case 17:
            	            {
            	            int LA9_2 = input.LA(2);

            	            if ( (synpred22_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 18:
            	            {
            	            int LA9_3 = input.LA(2);

            	            if ( (synpred22_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;
            	        case 19:
            	            {
            	            int LA9_4 = input.LA(2);

            	            if ( (synpred22_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt9=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:881:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:881:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt8=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 17:
            	    	        {
            	    	        alt8=1;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt8=2;
            	    	        }
            	    	        break;
            	    	    case 19:
            	    	        {
            	    	        alt8=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 8, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt8) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:882:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLoopedModel1705); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_visibility_1_1, grammarAccess.getLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:900:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLoopedModel1734); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_visibility_1_2, grammarAccess.getLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }
            	    	            break;
            	    	        case 3 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:918:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleLoopedModel1763); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_visibility_1_3, grammarAccess.getLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:946:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:946:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:947:5: {...}? => ( ( (lv_static_2_0= 'static' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:947:108: ( ( (lv_static_2_0= 'static' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:948:6: ( (lv_static_2_0= 'static' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:951:6: ( (lv_static_2_0= 'static' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==20) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( (synpred24_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:952:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:952:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:953:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleLoopedModel1848); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	              createLeafNode(lv_static_2_0, grammarAccess.getLoopedModelAccess().getStaticStaticKeyword_0_1_0(), "static");
            	    	          
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	      	        
            	    	      	        try {
            	    	      	       		add(current, "static", lv_static_2_0, "static", lastConsumedNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:979:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:979:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:980:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:980:108: ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:981:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:984:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==21) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( (synpred26_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:985:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:985:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:986:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleLoopedModel1930); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	              createLeafNode(lv_synchronized_3_0, grammarAccess.getLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized");
            	    	          
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	      	        
            	    	      	        try {
            	    	      	       		add(current, "synchronized", lv_synchronized_3_0, "synchronized", lastConsumedNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1012:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1012:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1013:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1013:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1014:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=3;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==22) ) {
            	            int LA12_2 = input.LA(2);

            	            if ( (synpred28_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt12=1;
            	            }


            	        }
            	        else if ( (LA12_0==23) ) {
            	            int LA12_3 = input.LA(2);

            	            if ( (synpred29_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt12=2;
            	            }


            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: (lv_abstract_4_0= 'abstract' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: (lv_abstract_4_0= 'abstract' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:3: lv_abstract_4_0= 'abstract'
            	    	    {
            	    	    lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleLoopedModel2013); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	              createLeafNode(lv_abstract_4_0, grammarAccess.getLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract");
            	    	          
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	      	        
            	    	      	        try {
            	    	      	       		add(current, "abstract", lv_abstract_4_0, "abstract", lastConsumedNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	    
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1039:6: ( (lv_final_5_0= 'final' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1039:6: ( (lv_final_5_0= 'final' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1040:1: (lv_final_5_0= 'final' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1040:1: (lv_final_5_0= 'final' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1041:3: lv_final_5_0= 'final'
            	    	    {
            	    	    lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleLoopedModel2050); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	              createLeafNode(lv_final_5_0, grammarAccess.getLoopedModelAccess().getFinalFinalKeyword_0_3_1_0(), "final");
            	    	          
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	      	        
            	    	      	        try {
            	    	      	       		add(current, "final", lv_final_5_0, "final", lastConsumedNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	    
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0());

            }

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleLoopedModel2116); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_6, grammarAccess.getLoopedModelAccess().getClassKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1078:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1079:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1079:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1080:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopedModel2133); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_7_0, grammarAccess.getLoopedModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLoopedModelRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_7_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoopedModel2150); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_8, grammarAccess.getLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null);
                  
            }
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoopedModel2162); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_9, grammarAccess.getLoopedModelAccess().getRightCurlyBracketKeyword_4(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLoopedModel"


    // $ANTLR start "entryRuleGroupLoopedModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1121:1: entryRuleGroupLoopedModel returns [EObject current=null] : iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF ;
    public final EObject entryRuleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupLoopedModel = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1127:2: (iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1128:2: iv_ruleGroupLoopedModel= ruleGroupLoopedModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getGroupLoopedModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel2208);
            iv_ruleGroupLoopedModel=ruleGroupLoopedModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupLoopedModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGroupLoopedModel2218); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleGroupLoopedModel"


    // $ANTLR start "ruleGroupLoopedModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1138:1: ruleGroupLoopedModel returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) ;
    public final EObject ruleGroupLoopedModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;
        Token lv_static_2_0=null;
        Token lv_synchronized_3_0=null;
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1146:6: ( ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1147:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1147:1: ( ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1147:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )* otherlv_6= 'class' ( (lv_name_7_0= RULE_ID ) ) otherlv_8= '{' otherlv_9= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1147:2: ( ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=17 && LA17_0<=23)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1149:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1149:1: ( ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1150:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    {
            	    getUnorderedGroupHelper().enter(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1153:2: ( ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?)
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1154:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+ {...}?
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1154:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=5;
            	        alt16 = dfa16.predict(input);
            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1156:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1156:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1157:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1157:113: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1158:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    {
            	    	    getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1161:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1162:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1162:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1163:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1163:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
            	    	    int alt14=3;
            	    	    switch ( input.LA(1) ) {
            	    	    case 17:
            	    	        {
            	    	        alt14=1;
            	    	        }
            	    	        break;
            	    	    case 18:
            	    	        {
            	    	        alt14=2;
            	    	        }
            	    	        break;
            	    	    case 19:
            	    	        {
            	    	        alt14=3;
            	    	        }
            	    	        break;
            	    	    default:
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 14, 0, input);

            	    	        throw nvae;
            	    	    }

            	    	    switch (alt14) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1164:3: lv_visibility_1_1= 'public'
            	    	            {
            	    	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGroupLoopedModel2309); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_visibility_1_1, grammarAccess.getGroupLoopedModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "visibility", lv_visibility_1_1, null, lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1182:8: lv_visibility_1_2= 'private'
            	    	            {
            	    	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGroupLoopedModel2338); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_visibility_1_2, grammarAccess.getGroupLoopedModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "visibility", lv_visibility_1_2, null, lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }
            	    	            break;
            	    	        case 3 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1200:8: lv_visibility_1_3= 'protected'
            	    	            {
            	    	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleGroupLoopedModel2367); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_visibility_1_3, grammarAccess.getGroupLoopedModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "visibility", lv_visibility_1_3, null, lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }

            	    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:113: ( ( (lv_static_2_0= 'static' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1230:6: ( (lv_static_2_0= 'static' ) )
            	    	    {
            	    	    getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:6: ( (lv_static_2_0= 'static' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:1: (lv_static_2_0= 'static' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:1: (lv_static_2_0= 'static' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1235:3: lv_static_2_0= 'static'
            	    	    {
            	    	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleGroupLoopedModel2451); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	              createLeafNode(lv_static_2_0, grammarAccess.getGroupLoopedModelAccess().getStaticStaticKeyword_0_1_0(), "static");
            	    	          
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	      	        
            	    	      	        try {
            	    	      	       		add(current, "static", lv_static_2_0, "static", lastConsumedNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	    
            	    	    }

            	    	    }


            	    	    }

            	    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1261:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1261:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1262:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1262:113: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1263:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    {
            	    	    getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1266:6: ( (lv_synchronized_3_0= 'synchronized' ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1267:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1267:1: (lv_synchronized_3_0= 'synchronized' )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1268:3: lv_synchronized_3_0= 'synchronized'
            	    	    {
            	    	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleGroupLoopedModel2532); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	              createLeafNode(lv_synchronized_3_0, grammarAccess.getGroupLoopedModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized");
            	    	          
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode, current);
            	    	      	        }
            	    	      	        
            	    	      	        try {
            	    	      	       		add(current, "synchronized", lv_synchronized_3_0, "synchronized", lastConsumedNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	    
            	    	    }

            	    	    }


            	    	    }

            	    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1294:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1294:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1295:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
            	    	    }
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1295:113: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1296:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    {
            	    	    getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1299:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
            	    	    int alt15=2;
            	    	    int LA15_0 = input.LA(1);

            	    	    if ( (LA15_0==22) ) {
            	    	        alt15=1;
            	    	    }
            	    	    else if ( (LA15_0==23) ) {
            	    	        alt15=2;
            	    	    }
            	    	    else {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 15, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt15) {
            	    	        case 1 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1299:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1299:7: ( (lv_abstract_4_0= 'abstract' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1300:1: (lv_abstract_4_0= 'abstract' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1300:1: (lv_abstract_4_0= 'abstract' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1301:3: lv_abstract_4_0= 'abstract'
            	    	            {
            	    	            lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleGroupLoopedModel2614); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_abstract_4_0, grammarAccess.getGroupLoopedModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "abstract", lv_abstract_4_0, "abstract", lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }


            	    	            }


            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1321:6: ( (lv_final_5_0= 'final' ) )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1321:6: ( (lv_final_5_0= 'final' ) )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1322:1: (lv_final_5_0= 'final' )
            	    	            {
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1322:1: (lv_final_5_0= 'final' )
            	    	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1323:3: lv_final_5_0= 'final'
            	    	            {
            	    	            lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleGroupLoopedModel2651); if (state.failed) return current;
            	    	            if ( state.backtracking==0 ) {

            	    	                      createLeafNode(lv_final_5_0, grammarAccess.getGroupLoopedModelAccess().getFinalFinalKeyword_0_3_1_0(), "final");
            	    	                  
            	    	            }
            	    	            if ( state.backtracking==0 ) {

            	    	              	        if (current==null) {
            	    	              	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
            	    	              	            associateNodeWithAstElement(currentNode, current);
            	    	              	        }
            	    	              	        
            	    	              	        try {
            	    	              	       		add(current, "final", lv_final_5_0, "final", lastConsumedNode);
            	    	              	        } catch (ValueConverterException vce) {
            	    	              				handleValueConverterException(vce);
            	    	              	        }
            	    	              	    
            	    	            }

            	    	            }


            	    	            }


            	    	            }
            	    	            break;

            	    	    }

            	    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt16 >= 1 ) break loop16;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(16, input);
            	                throw eee;
            	        }
            	        cnt16++;
            	    } while (true);

            	    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleGroupLoopedModel", "getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0())");
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().leave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_6=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleGroupLoopedModel2723); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_6, grammarAccess.getGroupLoopedModelAccess().getClassKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1361:1: ( (lv_name_7_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1362:1: (lv_name_7_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1362:1: (lv_name_7_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1363:3: lv_name_7_0= RULE_ID
            {
            lv_name_7_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleGroupLoopedModel2740); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_7_0, grammarAccess.getGroupLoopedModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getGroupLoopedModelRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_7_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleGroupLoopedModel2757); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_8, grammarAccess.getGroupLoopedModelAccess().getLeftCurlyBracketKeyword_3(), null);
                  
            }
            otherlv_9=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleGroupLoopedModel2769); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_9, grammarAccess.getGroupLoopedModelAccess().getRightCurlyBracketKeyword_4(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleGroupLoopedModel"


    // $ANTLR start "entryRuleLoopedAlternativeModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1404:1: entryRuleLoopedAlternativeModel returns [EObject current=null] : iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF ;
    public final EObject entryRuleLoopedAlternativeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopedAlternativeModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1405:2: (iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1406:2: iv_ruleLoopedAlternativeModel= ruleLoopedAlternativeModel EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLoopedAlternativeModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel2809);
            iv_ruleLoopedAlternativeModel=ruleLoopedAlternativeModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopedAlternativeModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopedAlternativeModel2819); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLoopedAlternativeModel"


    // $ANTLR start "ruleLoopedAlternativeModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1413:1: ruleLoopedAlternativeModel returns [EObject current=null] : ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' ) ;
    public final EObject ruleLoopedAlternativeModel() throws RecognitionException {
        EObject current = null;

        Token lv_visibility_0_1=null;
        Token lv_visibility_0_2=null;
        Token lv_visibility_0_3=null;
        Token lv_static_1_0=null;
        Token lv_synchronized_2_0=null;
        Token lv_abstract_3_0=null;
        Token lv_final_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1418:6: ( ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:1: ( ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:2: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )* otherlv_7= 'class' ( (lv_name_8_0= RULE_ID ) ) otherlv_9= '{' otherlv_10= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:2: ( ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) ) | ( (lv_static_1_0= 'static' ) ) | ( (lv_synchronized_2_0= 'synchronized' ) ) | ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) ) | (otherlv_5= 'before' (otherlv_6= 'after' )* ) )*
            loop21:
            do {
                int alt21=6;
                switch ( input.LA(1) ) {
                case 17:
                case 18:
                case 19:
                    {
                    alt21=1;
                    }
                    break;
                case 20:
                    {
                    alt21=2;
                    }
                    break;
                case 21:
                    {
                    alt21=3;
                    }
                    break;
                case 22:
                case 23:
                    {
                    alt21=4;
                    }
                    break;
                case 27:
                    {
                    alt21=5;
                    }
                    break;

                }

                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:3: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1419:3: ( ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1420:1: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1420:1: ( (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1421:1: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1421:1: (lv_visibility_0_1= 'public' | lv_visibility_0_2= 'private' | lv_visibility_0_3= 'protected' )
            	    int alt18=3;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt18=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt18=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt18=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt18) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1422:3: lv_visibility_0_1= 'public'
            	            {
            	            lv_visibility_0_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLoopedAlternativeModel2865); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_0_1, grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPublicKeyword_0_0_0_0(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		add(current, "visibility", lv_visibility_0_1, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1440:8: lv_visibility_0_2= 'private'
            	            {
            	            lv_visibility_0_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLoopedAlternativeModel2894); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_0_2, grammarAccess.getLoopedAlternativeModelAccess().getVisibilityPrivateKeyword_0_0_0_1(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		add(current, "visibility", lv_visibility_0_2, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1458:8: lv_visibility_0_3= 'protected'
            	            {
            	            lv_visibility_0_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleLoopedAlternativeModel2923); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_visibility_0_3, grammarAccess.getLoopedAlternativeModelAccess().getVisibilityProtectedKeyword_0_0_0_2(), "visibility");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		add(current, "visibility", lv_visibility_0_3, null, lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1480:6: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1480:6: ( (lv_static_1_0= 'static' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1481:1: (lv_static_1_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1481:1: (lv_static_1_0= 'static' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1482:3: lv_static_1_0= 'static'
            	    {
            	    lv_static_1_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleLoopedAlternativeModel2963); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_static_1_0, grammarAccess.getLoopedAlternativeModelAccess().getStaticStaticKeyword_0_1_0(), "static");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "static", lv_static_1_0, "static", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1502:6: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1502:6: ( (lv_synchronized_2_0= 'synchronized' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1503:1: (lv_synchronized_2_0= 'synchronized' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1503:1: (lv_synchronized_2_0= 'synchronized' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1504:3: lv_synchronized_2_0= 'synchronized'
            	    {
            	    lv_synchronized_2_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleLoopedAlternativeModel3000); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_synchronized_2_0, grammarAccess.getLoopedAlternativeModelAccess().getSynchronizedSynchronizedKeyword_0_2_0(), "synchronized");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		add(current, "synchronized", lv_synchronized_2_0, "synchronized", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1524:6: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1524:6: ( ( (lv_abstract_3_0= 'abstract' ) ) | ( (lv_final_4_0= 'final' ) ) )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==22) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==23) ) {
            	        alt19=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1524:7: ( (lv_abstract_3_0= 'abstract' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1524:7: ( (lv_abstract_3_0= 'abstract' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1525:1: (lv_abstract_3_0= 'abstract' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1525:1: (lv_abstract_3_0= 'abstract' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1526:3: lv_abstract_3_0= 'abstract'
            	            {
            	            lv_abstract_3_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleLoopedAlternativeModel3038); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_abstract_3_0, grammarAccess.getLoopedAlternativeModelAccess().getAbstractAbstractKeyword_0_3_0_0(), "abstract");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		add(current, "abstract", lv_abstract_3_0, "abstract", lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1546:6: ( (lv_final_4_0= 'final' ) )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1546:6: ( (lv_final_4_0= 'final' ) )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1547:1: (lv_final_4_0= 'final' )
            	            {
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1547:1: (lv_final_4_0= 'final' )
            	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1548:3: lv_final_4_0= 'final'
            	            {
            	            lv_final_4_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleLoopedAlternativeModel3075); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      createLeafNode(lv_final_4_0, grammarAccess.getLoopedAlternativeModelAccess().getFinalFinalKeyword_0_3_1_0(), "final");
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
            	              	            associateNodeWithAstElement(currentNode, current);
            	              	        }
            	              	        
            	              	        try {
            	              	       		add(current, "final", lv_final_4_0, "final", lastConsumedNode);
            	              	        } catch (ValueConverterException vce) {
            	              				handleValueConverterException(vce);
            	              	        }
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1568:6: (otherlv_5= 'before' (otherlv_6= 'after' )* )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1568:6: (otherlv_5= 'before' (otherlv_6= 'after' )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1568:8: otherlv_5= 'before' (otherlv_6= 'after' )*
            	    {
            	    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleLoopedAlternativeModel3108); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_5, grammarAccess.getLoopedAlternativeModelAccess().getBeforeKeyword_0_4_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1572:1: (otherlv_6= 'after' )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==28) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1572:3: otherlv_6= 'after'
            	    	    {
            	    	    otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleLoopedAlternativeModel3121); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	          	createLeafNode(otherlv_6, grammarAccess.getLoopedAlternativeModelAccess().getAfterKeyword_0_4_1(), null);
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleLoopedAlternativeModel3138); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_7, grammarAccess.getLoopedAlternativeModelAccess().getClassKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1580:1: ( (lv_name_8_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1581:1: (lv_name_8_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1581:1: (lv_name_8_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1582:3: lv_name_8_0= RULE_ID
            {
            lv_name_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopedAlternativeModel3155); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_8_0, grammarAccess.getLoopedAlternativeModelAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLoopedAlternativeModelRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_8_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_9=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoopedAlternativeModel3172); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_9, grammarAccess.getLoopedAlternativeModelAccess().getLeftCurlyBracketKeyword_3(), null);
                  
            }
            otherlv_10=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoopedAlternativeModel3184); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_10, grammarAccess.getLoopedAlternativeModelAccess().getRightCurlyBracketKeyword_4(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end "ruleLoopedAlternativeModel"


    // $ANTLR start "entryRuleBug304681Model"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1620:1: entryRuleBug304681Model returns [EObject current=null] : iv_ruleBug304681Model= ruleBug304681Model EOF ;
    public final EObject entryRuleBug304681Model() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Model = null;


         
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2()
        		);
        	
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1626:2: (iv_ruleBug304681Model= ruleBug304681Model EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1627:2: iv_ruleBug304681Model= ruleBug304681Model EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBug304681ModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model3226);
            iv_ruleBug304681Model=ruleBug304681Model();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBug304681Model; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Model3236); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleBug304681Model"


    // $ANTLR start "ruleBug304681Model"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1637:1: ruleBug304681Model returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) otherlv_15= '}' ) ;
    public final EObject ruleBug304681Model() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_shortDescription_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_longDescription_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_uid_10_0=null;
        Token otherlv_11=null;
        Token lv_flag_12_0=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_features_14_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        			grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2()
        		);
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1645:6: ( ( () otherlv_1= '{' ( ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) otherlv_15= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1646:1: ( () otherlv_1= '{' ( ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) otherlv_15= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1646:1: ( () otherlv_1= '{' ( ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) otherlv_15= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1646:2: () otherlv_1= '{' ( ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) ) ) otherlv_15= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1646:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1647:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getBug304681ModelAccess().getBug304681ModelAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            otherlv_1=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBug304681Model3289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_1, grammarAccess.getBug304681ModelAccess().getLeftCurlyBracketKeyword_1(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1664:1: ( ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1666:1: ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1666:1: ( ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1667:2: ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1670:2: ( ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1671:3: ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1671:3: ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) | ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) | ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) | ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) | ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )*
            loop23:
            do {
                int alt23=6;
                int LA23_0 = input.LA(1);

                if ( LA23_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
                    alt23=1;
                }
                else if ( LA23_0 ==31 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
                    alt23=2;
                }
                else if ( LA23_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
                    alt23=3;
                }
                else if ( LA23_0 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
                    alt23=4;
                }
                else if ( LA23_0 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                    alt23=5;
                }
                else if ( LA23_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
                    alt23=5;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1673:4: ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1673:4: ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:5: {...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:111: ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1675:6: (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1678:6: (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1678:8: otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';'
            	    {
            	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleBug304681Model3344); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_3, grammarAccess.getBug304681ModelAccess().getShortKeyword_2_0_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1682:1: ( (lv_shortDescription_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:1: (lv_shortDescription_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:1: (lv_shortDescription_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1684:3: lv_shortDescription_4_0= RULE_STRING
            	    {
            	    lv_shortDescription_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model3361); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_shortDescription_4_0, grammarAccess.getBug304681ModelAccess().getShortDescriptionSTRINGTerminalRuleCall_2_0_1_0(), "shortDescription"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"shortDescription",
            	      	        		lv_shortDescription_4_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3378); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_5, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_0_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1717:4: ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1717:4: ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1718:5: {...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1718:111: ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1719:6: (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1722:6: (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1722:8: otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
            	    {
            	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleBug304681Model3442); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_6, grammarAccess.getBug304681ModelAccess().getLongKeyword_2_1_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1726:1: ( (lv_longDescription_7_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1727:1: (lv_longDescription_7_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1727:1: (lv_longDescription_7_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1728:3: lv_longDescription_7_0= RULE_STRING
            	    {
            	    lv_longDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model3459); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_longDescription_7_0, grammarAccess.getBug304681ModelAccess().getLongDescriptionSTRINGTerminalRuleCall_2_1_1_0(), "longDescription"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"longDescription",
            	      	        		lv_longDescription_7_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3476); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_8, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_1_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:4: ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:4: ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1762:5: {...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1762:111: ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1763:6: (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1766:6: (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1766:8: otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';'
            	    {
            	    otherlv_9=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleBug304681Model3540); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_9, grammarAccess.getBug304681ModelAccess().getUidKeyword_2_2_0(), null);
            	          
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1770:1: ( (lv_uid_10_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1771:1: (lv_uid_10_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1771:1: (lv_uid_10_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1772:3: lv_uid_10_0= RULE_STRING
            	    {
            	    lv_uid_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug304681Model3557); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			createLeafNode(lv_uid_10_0, grammarAccess.getBug304681ModelAccess().getUidSTRINGTerminalRuleCall_2_2_1_0(), "uid"); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        try {
            	      	       		set(
            	      	       			current, 
            	      	       			"uid",
            	      	        		lv_uid_10_0, 
            	      	        		"STRING", 
            	      	        		lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_11=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3574); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_11, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_2_2(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1805:4: ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1805:4: ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1806:5: {...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1806:111: ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1807:6: ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1810:6: ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1810:7: ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1810:7: ( (lv_flag_12_0= 'flag' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1811:1: (lv_flag_12_0= 'flag' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1811:1: (lv_flag_12_0= 'flag' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1812:3: lv_flag_12_0= 'flag'
            	    {
            	    lv_flag_12_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleBug304681Model3644); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              createLeafNode(lv_flag_12_0, grammarAccess.getBug304681ModelAccess().getFlagFlagKeyword_2_3_0_0(), "flag");
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode, current);
            	      	        }
            	      	        
            	      	        try {
            	      	       		set(current, "flag", true, "flag", lastConsumedNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Model3669); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	createLeafNode(otherlv_13, grammarAccess.getBug304681ModelAccess().getSemicolonKeyword_2_3_1(), null);
            	          
            	    }

            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:4: ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:4: ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1843:5: {...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleBug304681Model", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1843:111: ( ( (lv_features_14_0= ruleBug304681Feature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1844:6: ( (lv_features_14_0= ruleBug304681Feature ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4);
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1847:6: ( (lv_features_14_0= ruleBug304681Feature ) )+
            	    int cnt22=0;
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==34) ) {
            	            int LA22_2 = input.LA(2);

            	            if ( (synpred52_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt22=1;
            	            }


            	        }
            	        else if ( (LA22_0==35) ) {
            	            int LA22_3 = input.LA(2);

            	            if ( (synpred52_InternalUnorderedGroupsTestLanguage()) ) {
            	                alt22=1;
            	            }


            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: (lv_features_14_0= ruleBug304681Feature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: (lv_features_14_0= ruleBug304681Feature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1849:3: lv_features_14_0= ruleBug304681Feature
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        currentNode=createCompositeNode(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0(), currentNode); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_ruleBug304681Model3741);
            	    	    lv_features_14_0=ruleBug304681Feature();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      	        if (current==null) {
            	    	      	            current = factory.create(grammarAccess.getBug304681ModelRule().getType().getClassifier());
            	    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	      	        }
            	    	      	        try {
            	    	      	       		add(
            	    	      	       			current, 
            	    	      	       			"features",
            	    	      	        		lv_features_14_0, 
            	    	      	        		"Bug304681Feature", 
            	    	      	        		currentNode);
            	    	      	        } catch (ValueConverterException vce) {
            	    	      				handleValueConverterException(vce);
            	    	      	        }
            	    	      	        currentNode = currentNode.getParent();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt22 >= 1 ) break loop22;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(22, input);
            	                throw eee;
            	        }
            	        cnt22++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2());

            }

            otherlv_15=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBug304681Model3793); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_15, grammarAccess.getBug304681ModelAccess().getRightCurlyBracketKeyword_3(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleBug304681Model"


    // $ANTLR start "entryRuleBug304681Feature"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1900:1: entryRuleBug304681Feature returns [EObject current=null] : iv_ruleBug304681Feature= ruleBug304681Feature EOF ;
    public final EObject entryRuleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Feature = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1901:2: (iv_ruleBug304681Feature= ruleBug304681Feature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1902:2: iv_ruleBug304681Feature= ruleBug304681Feature EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBug304681FeatureRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature3833);
            iv_ruleBug304681Feature=ruleBug304681Feature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBug304681Feature; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Feature3843); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBug304681Feature"


    // $ANTLR start "ruleBug304681Feature"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1909:1: ruleBug304681Feature returns [EObject current=null] : (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) ;
    public final EObject ruleBug304681Feature() throws RecognitionException {
        EObject current = null;

        EObject this_Bug304681Attribute_0 = null;

        EObject this_Bug304681Reference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1914:6: ( (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1915:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1915:1: (this_Bug304681Attribute_0= ruleBug304681Attribute | this_Bug304681Reference_1= ruleBug304681Reference )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            else if ( (LA24_0==35) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1916:2: this_Bug304681Attribute_0= ruleBug304681Attribute
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681AttributeParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_ruleBug304681Feature3893);
                    this_Bug304681Attribute_0=ruleBug304681Attribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Bug304681Attribute_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1929:2: this_Bug304681Reference_1= ruleBug304681Reference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBug304681FeatureAccess().getBug304681ReferenceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_ruleBug304681Feature3923);
                    this_Bug304681Reference_1=ruleBug304681Reference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Bug304681Reference_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end "ruleBug304681Feature"


    // $ANTLR start "entryRuleBug304681Attribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1948:1: entryRuleBug304681Attribute returns [EObject current=null] : iv_ruleBug304681Attribute= ruleBug304681Attribute EOF ;
    public final EObject entryRuleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Attribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1949:2: (iv_ruleBug304681Attribute= ruleBug304681Attribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1950:2: iv_ruleBug304681Attribute= ruleBug304681Attribute EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBug304681AttributeRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute3958);
            iv_ruleBug304681Attribute=ruleBug304681Attribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBug304681Attribute; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Attribute3968); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBug304681Attribute"


    // $ANTLR start "ruleBug304681Attribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1957:1: ruleBug304681Attribute returns [EObject current=null] : (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBug304681Attribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1962:6: ( (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1963:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1963:1: (otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1963:3: otherlv_0= 'attr' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleBug304681Attribute4005); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getBug304681AttributeAccess().getAttrKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1967:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1968:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1968:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1969:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug304681Attribute4022); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_1_0, grammarAccess.getBug304681AttributeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getBug304681AttributeRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Attribute4039); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getBug304681AttributeAccess().getSemicolonKeyword_2(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end "ruleBug304681Attribute"


    // $ANTLR start "entryRuleBug304681Reference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2003:1: entryRuleBug304681Reference returns [EObject current=null] : iv_ruleBug304681Reference= ruleBug304681Reference EOF ;
    public final EObject entryRuleBug304681Reference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug304681Reference = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2004:2: (iv_ruleBug304681Reference= ruleBug304681Reference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2005:2: iv_ruleBug304681Reference= ruleBug304681Reference EOF
            {
            if ( state.backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBug304681ReferenceRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference4075);
            iv_ruleBug304681Reference=ruleBug304681Reference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBug304681Reference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug304681Reference4085); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBug304681Reference"


    // $ANTLR start "ruleBug304681Reference"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2012:1: ruleBug304681Reference returns [EObject current=null] : (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBug304681Reference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2017:6: ( (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2018:1: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2018:1: (otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2018:3: otherlv_0= 'ref' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleBug304681Reference4122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_0, grammarAccess.getBug304681ReferenceAccess().getRefKeyword_0(), null);
                  
            }
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2022:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2023:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2023:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:2024:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug304681Reference4139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			createLeafNode(lv_name_1_0, grammarAccess.getBug304681ReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getBug304681ReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug304681Reference4156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	createLeafNode(otherlv_2, grammarAccess.getBug304681ReferenceAccess().getSemicolonKeyword_2(), null);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end "ruleBug304681Reference"

    // $ANTLR start synpred8_InternalUnorderedGroupsTestLanguage
    public final void synpred8_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:309:4: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:309:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:309:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:310:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred8_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:310:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:311:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:314:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:315:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:316:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:316:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        int alt25=3;
        switch ( input.LA(1) ) {
        case 17:
            {
            alt25=1;
            }
            break;
        case 18:
            {
            alt25=2;
            }
            break;
        case 19:
            {
            alt25=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 25, 0, input);

            throw nvae;
        }

        switch (alt25) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:317:3: lv_visibility_1_1= 'public'
                {
                lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_synpred8_InternalUnorderedGroupsTestLanguage499); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:335:8: lv_visibility_1_2= 'private'
                {
                lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_synpred8_InternalUnorderedGroupsTestLanguage528); if (state.failed) return ;

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:353:8: lv_visibility_1_3= 'protected'
                {
                lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_synpred8_InternalUnorderedGroupsTestLanguage557); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred9_InternalUnorderedGroupsTestLanguage
    public final void synpred9_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_static_2_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:381:4: ( ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:381:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:381:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:382:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:382:108: ( ( (lv_static_2_0= 'static' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:383:6: ( (lv_static_2_0= 'static' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:386:6: ( (lv_static_2_0= 'static' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:387:1: (lv_static_2_0= 'static' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:387:1: (lv_static_2_0= 'static' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:388:3: lv_static_2_0= 'static'
        {
        lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred9_InternalUnorderedGroupsTestLanguage641); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred10_InternalUnorderedGroupsTestLanguage
    public final void synpred10_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_synchronized_3_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:414:4: ( ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:414:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:414:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:415:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:415:108: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:416:6: ( (lv_synchronized_3_0= 'synchronized' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:419:6: ( (lv_synchronized_3_0= 'synchronized' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:420:1: (lv_synchronized_3_0= 'synchronized' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:420:1: (lv_synchronized_3_0= 'synchronized' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:421:3: lv_synchronized_3_0= 'synchronized'
        {
        lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred10_InternalUnorderedGroupsTestLanguage722); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred12_InternalUnorderedGroupsTestLanguage
    public final void synpred12_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:4: ( ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:447:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:448:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:449:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getSimpleModelAccess().getUnorderedGroup_0(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:452:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
        int alt26=2;
        int LA26_0 = input.LA(1);

        if ( (LA26_0==22) ) {
            alt26=1;
        }
        else if ( (LA26_0==23) ) {
            alt26=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 26, 0, input);

            throw nvae;
        }
        switch (alt26) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:452:7: ( (lv_abstract_4_0= 'abstract' ) )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:452:7: ( (lv_abstract_4_0= 'abstract' ) )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:453:1: (lv_abstract_4_0= 'abstract' )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:453:1: (lv_abstract_4_0= 'abstract' )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:454:3: lv_abstract_4_0= 'abstract'
                {
                lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred12_InternalUnorderedGroupsTestLanguage804); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:474:6: ( (lv_final_5_0= 'final' ) )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:474:6: ( (lv_final_5_0= 'final' ) )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:475:1: (lv_final_5_0= 'final' )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:475:1: (lv_final_5_0= 'final' )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:476:3: lv_final_5_0= 'final'
                {
                lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred12_InternalUnorderedGroupsTestLanguage841); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred12_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred15_InternalUnorderedGroupsTestLanguage
    public final void synpred15_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:591:4: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:591:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:591:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:592:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:592:111: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:593:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:596:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:597:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:597:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:598:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:598:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        int alt27=3;
        switch ( input.LA(1) ) {
        case 17:
            {
            alt27=1;
            }
            break;
        case 18:
            {
            alt27=2;
            }
            break;
        case 19:
            {
            alt27=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 27, 0, input);

            throw nvae;
        }

        switch (alt27) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:599:3: lv_visibility_1_1= 'public'
                {
                lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_synpred15_InternalUnorderedGroupsTestLanguage1099); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:617:8: lv_visibility_1_2= 'private'
                {
                lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_synpred15_InternalUnorderedGroupsTestLanguage1128); if (state.failed) return ;

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:635:8: lv_visibility_1_3= 'protected'
                {
                lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_synpred15_InternalUnorderedGroupsTestLanguage1157); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred15_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred16_InternalUnorderedGroupsTestLanguage
    public final void synpred16_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_static_2_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:663:4: ( ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:663:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:663:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:664:111: ( ( (lv_static_2_0= 'static' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:665:6: ( (lv_static_2_0= 'static' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:668:6: ( (lv_static_2_0= 'static' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:1: (lv_static_2_0= 'static' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:669:1: (lv_static_2_0= 'static' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:670:3: lv_static_2_0= 'static'
        {
        lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred16_InternalUnorderedGroupsTestLanguage1241); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred16_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred17_InternalUnorderedGroupsTestLanguage
    public final void synpred17_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_synchronized_3_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:4: ( ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:696:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:697:111: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:698:6: ( (lv_synchronized_3_0= 'synchronized' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:701:6: ( (lv_synchronized_3_0= 'synchronized' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:702:1: (lv_synchronized_3_0= 'synchronized' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:702:1: (lv_synchronized_3_0= 'synchronized' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:703:3: lv_synchronized_3_0= 'synchronized'
        {
        lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred17_InternalUnorderedGroupsTestLanguage1322); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred17_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred19_InternalUnorderedGroupsTestLanguage
    public final void synpred19_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:729:4: ( ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:729:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:729:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:730:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred19_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:730:111: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:731:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getMandatoryModelAccess().getUnorderedGroup_0(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
        int alt28=2;
        int LA28_0 = input.LA(1);

        if ( (LA28_0==22) ) {
            alt28=1;
        }
        else if ( (LA28_0==23) ) {
            alt28=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 28, 0, input);

            throw nvae;
        }
        switch (alt28) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:7: ( (lv_abstract_4_0= 'abstract' ) )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:734:7: ( (lv_abstract_4_0= 'abstract' ) )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: (lv_abstract_4_0= 'abstract' )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:735:1: (lv_abstract_4_0= 'abstract' )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:736:3: lv_abstract_4_0= 'abstract'
                {
                lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred19_InternalUnorderedGroupsTestLanguage1404); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:756:6: ( (lv_final_5_0= 'final' ) )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:756:6: ( (lv_final_5_0= 'final' ) )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:1: (lv_final_5_0= 'final' )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:757:1: (lv_final_5_0= 'final' )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:758:3: lv_final_5_0= 'final'
                {
                lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred19_InternalUnorderedGroupsTestLanguage1441); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred19_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred22_InternalUnorderedGroupsTestLanguage
    public final void synpred22_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:881:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:881:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        int alt29=3;
        switch ( input.LA(1) ) {
        case 17:
            {
            alt29=1;
            }
            break;
        case 18:
            {
            alt29=2;
            }
            break;
        case 19:
            {
            alt29=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 29, 0, input);

            throw nvae;
        }

        switch (alt29) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:882:3: lv_visibility_1_1= 'public'
                {
                lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_synpred22_InternalUnorderedGroupsTestLanguage1705); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:900:8: lv_visibility_1_2= 'private'
                {
                lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_synpred22_InternalUnorderedGroupsTestLanguage1734); if (state.failed) return ;

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:918:8: lv_visibility_1_3= 'protected'
                {
                lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_synpred22_InternalUnorderedGroupsTestLanguage1763); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred22_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred23_InternalUnorderedGroupsTestLanguage
    public final void synpred23_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:4: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:874:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:875:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred23_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:875:108: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:876:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:879:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )+
        int cnt31=0;
        loop31:
        do {
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=17 && LA31_0<=19)) ) {
                alt31=1;
            }


            switch (alt31) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:880:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:881:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:881:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        	    int alt30=3;
        	    switch ( input.LA(1) ) {
        	    case 17:
        	        {
        	        alt30=1;
        	        }
        	        break;
        	    case 18:
        	        {
        	        alt30=2;
        	        }
        	        break;
        	    case 19:
        	        {
        	        alt30=3;
        	        }
        	        break;
        	    default:
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        NoViableAltException nvae =
        	            new NoViableAltException("", 30, 0, input);

        	        throw nvae;
        	    }

        	    switch (alt30) {
        	        case 1 :
        	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:882:3: lv_visibility_1_1= 'public'
        	            {
        	            lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_synpred23_InternalUnorderedGroupsTestLanguage1705); if (state.failed) return ;

        	            }
        	            break;
        	        case 2 :
        	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:900:8: lv_visibility_1_2= 'private'
        	            {
        	            lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_synpred23_InternalUnorderedGroupsTestLanguage1734); if (state.failed) return ;

        	            }
        	            break;
        	        case 3 :
        	            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:918:8: lv_visibility_1_3= 'protected'
        	            {
        	            lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_synpred23_InternalUnorderedGroupsTestLanguage1763); if (state.failed) return ;

        	            }
        	            break;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt31 >= 1 ) break loop31;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(31, input);
                    throw eee;
            }
            cnt31++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred23_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred24_InternalUnorderedGroupsTestLanguage
    public final void synpred24_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_static_2_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:952:1: ( (lv_static_2_0= 'static' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:952:1: (lv_static_2_0= 'static' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:952:1: (lv_static_2_0= 'static' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:953:3: lv_static_2_0= 'static'
        {
        lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred24_InternalUnorderedGroupsTestLanguage1848); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred25_InternalUnorderedGroupsTestLanguage
    public final void synpred25_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_static_2_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:946:4: ( ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:946:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:946:4: ({...}? => ( ( (lv_static_2_0= 'static' ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:947:5: {...}? => ( ( (lv_static_2_0= 'static' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred25_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:947:108: ( ( (lv_static_2_0= 'static' ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:948:6: ( (lv_static_2_0= 'static' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:951:6: ( (lv_static_2_0= 'static' ) )+
        int cnt32=0;
        loop32:
        do {
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==20) ) {
                alt32=1;
            }


            switch (alt32) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:952:1: (lv_static_2_0= 'static' )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:952:1: (lv_static_2_0= 'static' )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:953:3: lv_static_2_0= 'static'
        	    {
        	    lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred25_InternalUnorderedGroupsTestLanguage1848); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt32 >= 1 ) break loop32;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(32, input);
                    throw eee;
            }
            cnt32++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred26_InternalUnorderedGroupsTestLanguage
    public final void synpred26_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_synchronized_3_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:985:1: ( (lv_synchronized_3_0= 'synchronized' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:985:1: (lv_synchronized_3_0= 'synchronized' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:985:1: (lv_synchronized_3_0= 'synchronized' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:986:3: lv_synchronized_3_0= 'synchronized'
        {
        lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred26_InternalUnorderedGroupsTestLanguage1930); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred26_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred27_InternalUnorderedGroupsTestLanguage
    public final void synpred27_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_synchronized_3_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:979:4: ( ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:979:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:979:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:980:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:980:108: ( ( (lv_synchronized_3_0= 'synchronized' ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:981:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:984:6: ( (lv_synchronized_3_0= 'synchronized' ) )+
        int cnt33=0;
        loop33:
        do {
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==21) ) {
                alt33=1;
            }


            switch (alt33) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:985:1: (lv_synchronized_3_0= 'synchronized' )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:985:1: (lv_synchronized_3_0= 'synchronized' )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:986:3: lv_synchronized_3_0= 'synchronized'
        	    {
        	    lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred27_InternalUnorderedGroupsTestLanguage1930); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt33 >= 1 ) break loop33;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(33, input);
                    throw eee;
            }
            cnt33++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred28_InternalUnorderedGroupsTestLanguage
    public final void synpred28_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_abstract_4_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:7: ( ( (lv_abstract_4_0= 'abstract' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:7: ( (lv_abstract_4_0= 'abstract' ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:7: ( (lv_abstract_4_0= 'abstract' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: (lv_abstract_4_0= 'abstract' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: (lv_abstract_4_0= 'abstract' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:3: lv_abstract_4_0= 'abstract'
        {
        lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred28_InternalUnorderedGroupsTestLanguage2013); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred28_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred29_InternalUnorderedGroupsTestLanguage
    public final void synpred29_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_final_5_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1039:6: ( ( (lv_final_5_0= 'final' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1039:6: ( (lv_final_5_0= 'final' ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1039:6: ( (lv_final_5_0= 'final' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1040:1: (lv_final_5_0= 'final' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1040:1: (lv_final_5_0= 'final' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1041:3: lv_final_5_0= 'final'
        {
        lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred29_InternalUnorderedGroupsTestLanguage2050); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred29_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred30_InternalUnorderedGroupsTestLanguage
    public final void synpred30_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1012:4: ( ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1012:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1012:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1013:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1013:108: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1014:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getLoopedModelAccess().getUnorderedGroup_0(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )+
        int cnt34=0;
        loop34:
        do {
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==22) ) {
                alt34=1;
            }
            else if ( (LA34_0==23) ) {
                alt34=2;
            }


            switch (alt34) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:7: ( (lv_abstract_4_0= 'abstract' ) )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1017:7: ( (lv_abstract_4_0= 'abstract' ) )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: (lv_abstract_4_0= 'abstract' )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1018:1: (lv_abstract_4_0= 'abstract' )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1019:3: lv_abstract_4_0= 'abstract'
        	    {
        	    lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred30_InternalUnorderedGroupsTestLanguage2013); if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;
        	case 2 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1039:6: ( (lv_final_5_0= 'final' ) )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1039:6: ( (lv_final_5_0= 'final' ) )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1040:1: (lv_final_5_0= 'final' )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1040:1: (lv_final_5_0= 'final' )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1041:3: lv_final_5_0= 'final'
        	    {
        	    lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred30_InternalUnorderedGroupsTestLanguage2050); if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt34 >= 1 ) break loop34;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(34, input);
                    throw eee;
            }
            cnt34++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred30_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred33_InternalUnorderedGroupsTestLanguage
    public final void synpred33_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_visibility_1_1=null;
        Token lv_visibility_1_2=null;
        Token lv_visibility_1_3=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1156:4: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1156:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1156:4: ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1157:5: {...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1157:113: ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1158:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1161:6: ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1162:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1162:1: ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1163:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1163:1: (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' )
        int alt35=3;
        switch ( input.LA(1) ) {
        case 17:
            {
            alt35=1;
            }
            break;
        case 18:
            {
            alt35=2;
            }
            break;
        case 19:
            {
            alt35=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 35, 0, input);

            throw nvae;
        }

        switch (alt35) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1164:3: lv_visibility_1_1= 'public'
                {
                lv_visibility_1_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_synpred33_InternalUnorderedGroupsTestLanguage2309); if (state.failed) return ;

                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1182:8: lv_visibility_1_2= 'private'
                {
                lv_visibility_1_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_synpred33_InternalUnorderedGroupsTestLanguage2338); if (state.failed) return ;

                }
                break;
            case 3 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1200:8: lv_visibility_1_3= 'protected'
                {
                lv_visibility_1_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_synpred33_InternalUnorderedGroupsTestLanguage2367); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred33_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred34_InternalUnorderedGroupsTestLanguage
    public final void synpred34_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_static_2_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:4: ( ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1228:4: ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:5: {...}? => ( ( (lv_static_2_0= 'static' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1229:113: ( ( (lv_static_2_0= 'static' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1230:6: ( (lv_static_2_0= 'static' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1233:6: ( (lv_static_2_0= 'static' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:1: (lv_static_2_0= 'static' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1234:1: (lv_static_2_0= 'static' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1235:3: lv_static_2_0= 'static'
        {
        lv_static_2_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_synpred34_InternalUnorderedGroupsTestLanguage2451); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred34_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred35_InternalUnorderedGroupsTestLanguage
    public final void synpred35_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_synchronized_3_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1261:4: ( ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1261:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1261:4: ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1262:5: {...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1262:113: ( ( (lv_synchronized_3_0= 'synchronized' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1263:6: ( (lv_synchronized_3_0= 'synchronized' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1266:6: ( (lv_synchronized_3_0= 'synchronized' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1267:1: (lv_synchronized_3_0= 'synchronized' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1267:1: (lv_synchronized_3_0= 'synchronized' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1268:3: lv_synchronized_3_0= 'synchronized'
        {
        lv_synchronized_3_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_synpred35_InternalUnorderedGroupsTestLanguage2532); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred35_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred37_InternalUnorderedGroupsTestLanguage
    public final void synpred37_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_abstract_4_0=null;
        Token lv_final_5_0=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1294:4: ( ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1294:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1294:4: ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1295:5: {...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred37_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1295:113: ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1296:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1299:6: ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) )
        int alt36=2;
        int LA36_0 = input.LA(1);

        if ( (LA36_0==22) ) {
            alt36=1;
        }
        else if ( (LA36_0==23) ) {
            alt36=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 36, 0, input);

            throw nvae;
        }
        switch (alt36) {
            case 1 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1299:7: ( (lv_abstract_4_0= 'abstract' ) )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1299:7: ( (lv_abstract_4_0= 'abstract' ) )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1300:1: (lv_abstract_4_0= 'abstract' )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1300:1: (lv_abstract_4_0= 'abstract' )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1301:3: lv_abstract_4_0= 'abstract'
                {
                lv_abstract_4_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_synpred37_InternalUnorderedGroupsTestLanguage2614); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1321:6: ( (lv_final_5_0= 'final' ) )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1321:6: ( (lv_final_5_0= 'final' ) )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1322:1: (lv_final_5_0= 'final' )
                {
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1322:1: (lv_final_5_0= 'final' )
                // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1323:3: lv_final_5_0= 'final'
                {
                lv_final_5_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_synpred37_InternalUnorderedGroupsTestLanguage2651); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred37_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred48_InternalUnorderedGroupsTestLanguage
    public final void synpred48_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token lv_shortDescription_4_0=null;
        Token otherlv_5=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1673:4: ( ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1673:4: ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1673:4: ({...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:5: {...}? => ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred48_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1674:111: ( (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1675:6: (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 0);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1678:6: (otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1678:8: otherlv_3= 'short' ( (lv_shortDescription_4_0= RULE_STRING ) ) otherlv_5= ';'
        {
        otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_synpred48_InternalUnorderedGroupsTestLanguage3344); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1682:1: ( (lv_shortDescription_4_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:1: (lv_shortDescription_4_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1683:1: (lv_shortDescription_4_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1684:3: lv_shortDescription_4_0= RULE_STRING
        {
        lv_shortDescription_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred48_InternalUnorderedGroupsTestLanguage3361); if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_synpred48_InternalUnorderedGroupsTestLanguage3378); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred48_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred49_InternalUnorderedGroupsTestLanguage
    public final void synpred49_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_longDescription_7_0=null;
        Token otherlv_8=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1717:4: ( ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1717:4: ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1717:4: ({...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1718:5: {...}? => ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred49_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1718:111: ( (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1719:6: (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 1);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1722:6: (otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1722:8: otherlv_6= 'long' ( (lv_longDescription_7_0= RULE_STRING ) ) otherlv_8= ';'
        {
        otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_synpred49_InternalUnorderedGroupsTestLanguage3442); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1726:1: ( (lv_longDescription_7_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1727:1: (lv_longDescription_7_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1727:1: (lv_longDescription_7_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1728:3: lv_longDescription_7_0= RULE_STRING
        {
        lv_longDescription_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred49_InternalUnorderedGroupsTestLanguage3459); if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_synpred49_InternalUnorderedGroupsTestLanguage3476); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred49_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred50_InternalUnorderedGroupsTestLanguage
    public final void synpred50_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token lv_uid_10_0=null;
        Token otherlv_11=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:4: ( ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:4: ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1761:4: ({...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1762:5: {...}? => ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred50_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1762:111: ( (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1763:6: (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 2);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1766:6: (otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1766:8: otherlv_9= 'uid' ( (lv_uid_10_0= RULE_STRING ) ) otherlv_11= ';'
        {
        otherlv_9=(Token)match(input,32,FollowSets000.FOLLOW_32_in_synpred50_InternalUnorderedGroupsTestLanguage3540); if (state.failed) return ;
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1770:1: ( (lv_uid_10_0= RULE_STRING ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1771:1: (lv_uid_10_0= RULE_STRING )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1771:1: (lv_uid_10_0= RULE_STRING )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1772:3: lv_uid_10_0= RULE_STRING
        {
        lv_uid_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred50_InternalUnorderedGroupsTestLanguage3557); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,30,FollowSets000.FOLLOW_30_in_synpred50_InternalUnorderedGroupsTestLanguage3574); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred50_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred51_InternalUnorderedGroupsTestLanguage
    public final void synpred51_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        Token lv_flag_12_0=null;
        Token otherlv_13=null;

        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1805:4: ( ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1805:4: ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1805:4: ({...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1806:5: {...}? => ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred51_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1806:111: ( ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1807:6: ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 3);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1810:6: ( ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1810:7: ( (lv_flag_12_0= 'flag' ) ) otherlv_13= ';'
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1810:7: ( (lv_flag_12_0= 'flag' ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1811:1: (lv_flag_12_0= 'flag' )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1811:1: (lv_flag_12_0= 'flag' )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1812:3: lv_flag_12_0= 'flag'
        {
        lv_flag_12_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_synpred51_InternalUnorderedGroupsTestLanguage3644); if (state.failed) return ;

        }


        }

        otherlv_13=(Token)match(input,30,FollowSets000.FOLLOW_30_in_synpred51_InternalUnorderedGroupsTestLanguage3669); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred51_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred52_InternalUnorderedGroupsTestLanguage
    public final void synpred52_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_14_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: ( (lv_features_14_0= ruleBug304681Feature ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: (lv_features_14_0= ruleBug304681Feature )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: (lv_features_14_0= ruleBug304681Feature )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1849:3: lv_features_14_0= ruleBug304681Feature
        {
        if ( state.backtracking==0 ) {
           
          	        currentNode=createCompositeNode(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0(), currentNode); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_synpred52_InternalUnorderedGroupsTestLanguage3741);
        lv_features_14_0=ruleBug304681Feature();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred52_InternalUnorderedGroupsTestLanguage

    // $ANTLR start synpred53_InternalUnorderedGroupsTestLanguage
    public final void synpred53_InternalUnorderedGroupsTestLanguage_fragment() throws RecognitionException {   
        EObject lv_features_14_0 = null;


        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:4: ( ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:4: ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) )
        {
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1842:4: ({...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ ) )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1843:5: {...}? => ( ( (lv_features_14_0= ruleBug304681Feature ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred53_InternalUnorderedGroupsTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4)");
        }
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1843:111: ( ( (lv_features_14_0= ruleBug304681Feature ) )+ )
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1844:6: ( (lv_features_14_0= ruleBug304681Feature ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getBug304681ModelAccess().getUnorderedGroup_2(), 4);
        // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1847:6: ( (lv_features_14_0= ruleBug304681Feature ) )+
        int cnt43=0;
        loop43:
        do {
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=34 && LA43_0<=35)) ) {
                alt43=1;
            }


            switch (alt43) {
        	case 1 :
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: (lv_features_14_0= ruleBug304681Feature )
        	    {
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1848:1: (lv_features_14_0= ruleBug304681Feature )
        	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalUnorderedGroupsTestLanguage.g:1849:3: lv_features_14_0= ruleBug304681Feature
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        currentNode=createCompositeNode(grammarAccess.getBug304681ModelAccess().getFeaturesBug304681FeatureParserRuleCall_2_4_0(), currentNode); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleBug304681Feature_in_synpred53_InternalUnorderedGroupsTestLanguage3741);
        	    lv_features_14_0=ruleBug304681Feature();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt43 >= 1 ) break loop43;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(43, input);
                    throw eee;
            }
            cnt43++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred53_InternalUnorderedGroupsTestLanguage

    // Delegated rules

    public final boolean synpred12_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalUnorderedGroupsTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalUnorderedGroupsTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\15\uffff";
    static final String DFA16_minS =
        "\1\21\1\uffff\7\0\4\uffff";
    static final String DFA16_maxS =
        "\1\30\1\uffff\7\0\4\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\5\7\uffff\1\1\1\2\1\3\1\4";
    static final String DFA16_specialS =
        "\2\uffff\1\0\1\3\1\4\1\5\1\6\1\2\1\1\4\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
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
            return "()+ loopback of 1154:3: ( ({...}? => ( ( ( (lv_visibility_1_1= 'public' | lv_visibility_1_2= 'private' | lv_visibility_1_3= 'protected' ) ) ) ) ) | ({...}? => ( ( (lv_static_2_0= 'static' ) ) ) ) | ({...}? => ( ( (lv_synchronized_3_0= 'synchronized' ) ) ) ) | ({...}? => ( ( ( (lv_abstract_4_0= 'abstract' ) ) | ( (lv_final_5_0= 'final' ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred33_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_8 = input.LA(1);

                         
                        int index16_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred37_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 12;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index16_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_7 = input.LA(1);

                         
                        int index16_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred37_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 3) ) {s = 12;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index16_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_3 = input.LA(1);

                         
                        int index16_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred33_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index16_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_4 = input.LA(1);

                         
                        int index16_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred33_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 0) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index16_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_5 = input.LA(1);

                         
                        int index16_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred34_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 1) ) {s = 10;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index16_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA16_6 = input.LA(1);

                         
                        int index16_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( synpred35_InternalUnorderedGroupsTestLanguage() && getUnorderedGroupHelper().canSelect(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0(), 2) ) {s = 11;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getGroupLoopedModelAccess().getUnorderedGroup_0()) ) {s = 1;}

                         
                        input.seek(index16_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel129 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_ruleModel150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel170 = new BitSet(new long[]{0x0000000000FE0000L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_ruleModel191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel211 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_ruleModel232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel252 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_ruleModel273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel293 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_ruleModel314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel334 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_ruleModel355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleModel_in_entryRuleSimpleModel398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleModel408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSimpleModel499 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleSimpleModel528 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleSimpleModel557 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleSimpleModel641 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleSimpleModel722 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleSimpleModel804 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleSimpleModel841 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleSimpleModel906 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleModel923 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleSimpleModel940 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleSimpleModel952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMandatoryModel_in_entryRuleMandatoryModel998 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryModel1008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMandatoryModel1099 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleMandatoryModel1128 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleMandatoryModel1157 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleMandatoryModel1241 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleMandatoryModel1322 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleMandatoryModel1404 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleMandatoryModel1441 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleMandatoryModel1512 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMandatoryModel1529 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleMandatoryModel1546 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleMandatoryModel1558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedModel_in_entryRuleLoopedModel1604 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedModel1614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLoopedModel1705 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleLoopedModel1734 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleLoopedModel1763 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleLoopedModel1848 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleLoopedModel1930 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleLoopedModel2013 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleLoopedModel2050 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleLoopedModel2116 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopedModel2133 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLoopedModel2150 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLoopedModel2162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGroupLoopedModel_in_entryRuleGroupLoopedModel2208 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGroupLoopedModel2218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleGroupLoopedModel2309 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_18_in_ruleGroupLoopedModel2338 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_19_in_ruleGroupLoopedModel2367 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_20_in_ruleGroupLoopedModel2451 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_21_in_ruleGroupLoopedModel2532 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_22_in_ruleGroupLoopedModel2614 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_23_in_ruleGroupLoopedModel2651 = new BitSet(new long[]{0x0000000001FE0000L});
        public static final BitSet FOLLOW_24_in_ruleGroupLoopedModel2723 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleGroupLoopedModel2740 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleGroupLoopedModel2757 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleGroupLoopedModel2769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopedAlternativeModel_in_entryRuleLoopedAlternativeModel2809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopedAlternativeModel2819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLoopedAlternativeModel2865 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_18_in_ruleLoopedAlternativeModel2894 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_19_in_ruleLoopedAlternativeModel2923 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_20_in_ruleLoopedAlternativeModel2963 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_21_in_ruleLoopedAlternativeModel3000 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_22_in_ruleLoopedAlternativeModel3038 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_23_in_ruleLoopedAlternativeModel3075 = new BitSet(new long[]{0x0000000009FE0000L});
        public static final BitSet FOLLOW_27_in_ruleLoopedAlternativeModel3108 = new BitSet(new long[]{0x0000000019FE0000L});
        public static final BitSet FOLLOW_28_in_ruleLoopedAlternativeModel3121 = new BitSet(new long[]{0x0000000019FE0000L});
        public static final BitSet FOLLOW_24_in_ruleLoopedAlternativeModel3138 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopedAlternativeModel3155 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLoopedAlternativeModel3172 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleLoopedAlternativeModel3184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Model_in_entryRuleBug304681Model3226 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Model3236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleBug304681Model3289 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_29_in_ruleBug304681Model3344 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model3361 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3378 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_31_in_ruleBug304681Model3442 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model3459 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3476 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_32_in_ruleBug304681Model3540 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug304681Model3557 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3574 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_33_in_ruleBug304681Model3644 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Model3669 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_ruleBug304681Model3741 = new BitSet(new long[]{0x0000000FA4000000L});
        public static final BitSet FOLLOW_26_in_ruleBug304681Model3793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_entryRuleBug304681Feature3833 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Feature3843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_ruleBug304681Feature3893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_ruleBug304681Feature3923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Attribute_in_entryRuleBug304681Attribute3958 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Attribute3968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleBug304681Attribute4005 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug304681Attribute4022 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Attribute4039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Reference_in_entryRuleBug304681Reference4075 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug304681Reference4085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleBug304681Reference4122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug304681Reference4139 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleBug304681Reference4156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_synpred8_InternalUnorderedGroupsTestLanguage499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_synpred8_InternalUnorderedGroupsTestLanguage528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_synpred8_InternalUnorderedGroupsTestLanguage557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred9_InternalUnorderedGroupsTestLanguage641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred10_InternalUnorderedGroupsTestLanguage722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred12_InternalUnorderedGroupsTestLanguage804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred12_InternalUnorderedGroupsTestLanguage841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_synpred15_InternalUnorderedGroupsTestLanguage1099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_synpred15_InternalUnorderedGroupsTestLanguage1128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_synpred15_InternalUnorderedGroupsTestLanguage1157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred16_InternalUnorderedGroupsTestLanguage1241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred17_InternalUnorderedGroupsTestLanguage1322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred19_InternalUnorderedGroupsTestLanguage1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred19_InternalUnorderedGroupsTestLanguage1441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_synpred22_InternalUnorderedGroupsTestLanguage1705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_synpred22_InternalUnorderedGroupsTestLanguage1734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_synpred22_InternalUnorderedGroupsTestLanguage1763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_synpred23_InternalUnorderedGroupsTestLanguage1705 = new BitSet(new long[]{0x00000000000E0002L});
        public static final BitSet FOLLOW_18_in_synpred23_InternalUnorderedGroupsTestLanguage1734 = new BitSet(new long[]{0x00000000000E0002L});
        public static final BitSet FOLLOW_19_in_synpred23_InternalUnorderedGroupsTestLanguage1763 = new BitSet(new long[]{0x00000000000E0002L});
        public static final BitSet FOLLOW_20_in_synpred24_InternalUnorderedGroupsTestLanguage1848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred25_InternalUnorderedGroupsTestLanguage1848 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_21_in_synpred26_InternalUnorderedGroupsTestLanguage1930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred27_InternalUnorderedGroupsTestLanguage1930 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_22_in_synpred28_InternalUnorderedGroupsTestLanguage2013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred29_InternalUnorderedGroupsTestLanguage2050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred30_InternalUnorderedGroupsTestLanguage2013 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_23_in_synpred30_InternalUnorderedGroupsTestLanguage2050 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_17_in_synpred33_InternalUnorderedGroupsTestLanguage2309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_synpred33_InternalUnorderedGroupsTestLanguage2338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_synpred33_InternalUnorderedGroupsTestLanguage2367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_synpred34_InternalUnorderedGroupsTestLanguage2451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_synpred35_InternalUnorderedGroupsTestLanguage2532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_synpred37_InternalUnorderedGroupsTestLanguage2614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_synpred37_InternalUnorderedGroupsTestLanguage2651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_synpred48_InternalUnorderedGroupsTestLanguage3344 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred48_InternalUnorderedGroupsTestLanguage3361 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_synpred48_InternalUnorderedGroupsTestLanguage3378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_synpred49_InternalUnorderedGroupsTestLanguage3442 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred49_InternalUnorderedGroupsTestLanguage3459 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_synpred49_InternalUnorderedGroupsTestLanguage3476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_synpred50_InternalUnorderedGroupsTestLanguage3540 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred50_InternalUnorderedGroupsTestLanguage3557 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_synpred50_InternalUnorderedGroupsTestLanguage3574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_synpred51_InternalUnorderedGroupsTestLanguage3644 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_synpred51_InternalUnorderedGroupsTestLanguage3669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_synpred52_InternalUnorderedGroupsTestLanguage3741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug304681Feature_in_synpred53_InternalUnorderedGroupsTestLanguage3741 = new BitSet(new long[]{0x0000000FA0000002L});
    }


}