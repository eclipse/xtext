package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.reconstr.services.SerializationErrorTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSerializationErrorTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'tworequired'", "'twooptions'", "'one'", "'two'", "'{'", "'}'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalSerializationErrorTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSerializationErrorTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSerializationErrorTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSerializationErrorTestLanguage.g"; }



     	private SerializationErrorTestLanguageGrammarAccess grammarAccess;

        public InternalSerializationErrorTestLanguageParser(TokenStream input, SerializationErrorTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SerializationErrorTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSerializationErrorTestLanguage.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSerializationErrorTestLanguage.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalSerializationErrorTestLanguage.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalSerializationErrorTestLanguage.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_test_0_0 = null;

        EObject lv_test_1_0 = null;



        	enterRule();

        try {
            // InternalSerializationErrorTestLanguage.g:77:2: ( ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) )
            // InternalSerializationErrorTestLanguage.g:78:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
            {
            // InternalSerializationErrorTestLanguage.g:78:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=13 && LA1_0<=14)||LA1_0==17) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalSerializationErrorTestLanguage.g:79:3: ( (lv_test_0_0= ruleTest ) )
                    {
                    // InternalSerializationErrorTestLanguage.g:79:3: ( (lv_test_0_0= ruleTest ) )
                    // InternalSerializationErrorTestLanguage.g:80:4: (lv_test_0_0= ruleTest )
                    {
                    // InternalSerializationErrorTestLanguage.g:80:4: (lv_test_0_0= ruleTest )
                    // InternalSerializationErrorTestLanguage.g:81:5: lv_test_0_0= ruleTest
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getTestTestParserRuleCall_0_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_test_0_0=ruleTest();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"test",
                    						lv_test_0_0,
                    						"org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage.Test");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSerializationErrorTestLanguage.g:99:3: ( (lv_test_1_0= ruleParenthesis ) )
                    {
                    // InternalSerializationErrorTestLanguage.g:99:3: ( (lv_test_1_0= ruleParenthesis ) )
                    // InternalSerializationErrorTestLanguage.g:100:4: (lv_test_1_0= ruleParenthesis )
                    {
                    // InternalSerializationErrorTestLanguage.g:100:4: (lv_test_1_0= ruleParenthesis )
                    // InternalSerializationErrorTestLanguage.g:101:5: lv_test_1_0= ruleParenthesis
                    {

                    					newCompositeNode(grammarAccess.getModelAccess().getTestParenthesisParserRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_test_1_0=ruleParenthesis();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModelRule());
                    					}
                    					set(
                    						current,
                    						"test",
                    						lv_test_1_0,
                    						"org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage.Parenthesis");
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


    // $ANTLR start "entryRuleParenthesis"
    // InternalSerializationErrorTestLanguage.g:122:1: entryRuleParenthesis returns [EObject current=null] : iv_ruleParenthesis= ruleParenthesis EOF ;
    public final EObject entryRuleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesis = null;


        try {
            // InternalSerializationErrorTestLanguage.g:122:52: (iv_ruleParenthesis= ruleParenthesis EOF )
            // InternalSerializationErrorTestLanguage.g:123:2: iv_ruleParenthesis= ruleParenthesis EOF
            {
             newCompositeNode(grammarAccess.getParenthesisRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesis=ruleParenthesis();

            state._fsp--;

             current =iv_ruleParenthesis; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleParenthesis"


    // $ANTLR start "ruleParenthesis"
    // InternalSerializationErrorTestLanguage.g:129:1: ruleParenthesis returns [EObject current=null] : (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' ) ;
    public final EObject ruleParenthesis() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Test_1 = null;



        	enterRule();

        try {
            // InternalSerializationErrorTestLanguage.g:135:2: ( (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' ) )
            // InternalSerializationErrorTestLanguage.g:136:2: (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' )
            {
            // InternalSerializationErrorTestLanguage.g:136:2: (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' )
            // InternalSerializationErrorTestLanguage.g:137:3: otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParenthesisAccess().getLeftParenthesisKeyword_0());
            		

            			newCompositeNode(grammarAccess.getParenthesisAccess().getTestParserRuleCall_1());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            this_Test_1=ruleTest();

            state._fsp--;


            			current = this_Test_1;
            			afterParserOrEnumRuleCall();
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParenthesisAccess().getRightParenthesisKeyword_2());
            		

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
    // $ANTLR end "ruleParenthesis"


    // $ANTLR start "entryRuleTest"
    // InternalSerializationErrorTestLanguage.g:157:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalSerializationErrorTestLanguage.g:157:45: (iv_ruleTest= ruleTest EOF )
            // InternalSerializationErrorTestLanguage.g:158:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // InternalSerializationErrorTestLanguage.g:164:1: ruleTest returns [EObject current=null] : (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        EObject this_TwoRequired_0 = null;

        EObject this_TwoOptions_1 = null;

        EObject this_Indent_2 = null;



        	enterRule();

        try {
            // InternalSerializationErrorTestLanguage.g:170:2: ( (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) )
            // InternalSerializationErrorTestLanguage.g:171:2: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
            {
            // InternalSerializationErrorTestLanguage.g:171:2: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 17:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalSerializationErrorTestLanguage.g:172:3: this_TwoRequired_0= ruleTwoRequired
                    {

                    			newCompositeNode(grammarAccess.getTestAccess().getTwoRequiredParserRuleCall_0());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoRequired_0=ruleTwoRequired();

                    state._fsp--;


                    			current = this_TwoRequired_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSerializationErrorTestLanguage.g:181:3: this_TwoOptions_1= ruleTwoOptions
                    {

                    			newCompositeNode(grammarAccess.getTestAccess().getTwoOptionsParserRuleCall_1());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoOptions_1=ruleTwoOptions();

                    state._fsp--;


                    			current = this_TwoOptions_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSerializationErrorTestLanguage.g:190:3: this_Indent_2= ruleIndent
                    {

                    			newCompositeNode(grammarAccess.getTestAccess().getIndentParserRuleCall_2());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Indent_2=ruleIndent();

                    state._fsp--;


                    			current = this_Indent_2;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleTwoRequired"
    // InternalSerializationErrorTestLanguage.g:202:1: entryRuleTwoRequired returns [EObject current=null] : iv_ruleTwoRequired= ruleTwoRequired EOF ;
    public final EObject entryRuleTwoRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoRequired = null;


        try {
            // InternalSerializationErrorTestLanguage.g:202:52: (iv_ruleTwoRequired= ruleTwoRequired EOF )
            // InternalSerializationErrorTestLanguage.g:203:2: iv_ruleTwoRequired= ruleTwoRequired EOF
            {
             newCompositeNode(grammarAccess.getTwoRequiredRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoRequired=ruleTwoRequired();

            state._fsp--;

             current =iv_ruleTwoRequired; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoRequired"


    // $ANTLR start "ruleTwoRequired"
    // InternalSerializationErrorTestLanguage.g:209:1: ruleTwoRequired returns [EObject current=null] : (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTwoRequired() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_one_1_0=null;
        Token lv_two_2_0=null;


        	enterRule();

        try {
            // InternalSerializationErrorTestLanguage.g:215:2: ( (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) )
            // InternalSerializationErrorTestLanguage.g:216:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            {
            // InternalSerializationErrorTestLanguage.g:216:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            // InternalSerializationErrorTestLanguage.g:217:3: otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getTwoRequiredAccess().getTworequiredKeyword_0());
            		
            // InternalSerializationErrorTestLanguage.g:221:3: ( (lv_one_1_0= RULE_ID ) )
            // InternalSerializationErrorTestLanguage.g:222:4: (lv_one_1_0= RULE_ID )
            {
            // InternalSerializationErrorTestLanguage.g:222:4: (lv_one_1_0= RULE_ID )
            // InternalSerializationErrorTestLanguage.g:223:5: lv_one_1_0= RULE_ID
            {
            lv_one_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					newLeafNode(lv_one_1_0, grammarAccess.getTwoRequiredAccess().getOneIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTwoRequiredRule());
            					}
            					setWithLastConsumed(
            						current,
            						"one",
            						lv_one_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSerializationErrorTestLanguage.g:239:3: ( (lv_two_2_0= RULE_ID ) )
            // InternalSerializationErrorTestLanguage.g:240:4: (lv_two_2_0= RULE_ID )
            {
            // InternalSerializationErrorTestLanguage.g:240:4: (lv_two_2_0= RULE_ID )
            // InternalSerializationErrorTestLanguage.g:241:5: lv_two_2_0= RULE_ID
            {
            lv_two_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					newLeafNode(lv_two_2_0, grammarAccess.getTwoRequiredAccess().getTwoIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTwoRequiredRule());
            					}
            					setWithLastConsumed(
            						current,
            						"two",
            						lv_two_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


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
    // $ANTLR end "ruleTwoRequired"


    // $ANTLR start "entryRuleTwoOptions"
    // InternalSerializationErrorTestLanguage.g:261:1: entryRuleTwoOptions returns [EObject current=null] : iv_ruleTwoOptions= ruleTwoOptions EOF ;
    public final EObject entryRuleTwoOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoOptions = null;


        try {
            // InternalSerializationErrorTestLanguage.g:261:51: (iv_ruleTwoOptions= ruleTwoOptions EOF )
            // InternalSerializationErrorTestLanguage.g:262:2: iv_ruleTwoOptions= ruleTwoOptions EOF
            {
             newCompositeNode(grammarAccess.getTwoOptionsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoOptions=ruleTwoOptions();

            state._fsp--;

             current =iv_ruleTwoOptions; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleTwoOptions"


    // $ANTLR start "ruleTwoOptions"
    // InternalSerializationErrorTestLanguage.g:268:1: ruleTwoOptions returns [EObject current=null] : (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleTwoOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_one_2_0=null;
        Token otherlv_3=null;
        Token lv_two_4_0=null;


        	enterRule();

        try {
            // InternalSerializationErrorTestLanguage.g:274:2: ( (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) )
            // InternalSerializationErrorTestLanguage.g:275:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            {
            // InternalSerializationErrorTestLanguage.g:275:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            // InternalSerializationErrorTestLanguage.g:276:3: otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getTwoOptionsAccess().getTwooptionsKeyword_0());
            		
            // InternalSerializationErrorTestLanguage.g:280:3: ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalSerializationErrorTestLanguage.g:281:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    {
                    // InternalSerializationErrorTestLanguage.g:281:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    // InternalSerializationErrorTestLanguage.g:282:5: otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_1, grammarAccess.getTwoOptionsAccess().getOneKeyword_1_0_0());
                    				
                    // InternalSerializationErrorTestLanguage.g:286:5: ( (lv_one_2_0= RULE_ID ) )
                    // InternalSerializationErrorTestLanguage.g:287:6: (lv_one_2_0= RULE_ID )
                    {
                    // InternalSerializationErrorTestLanguage.g:287:6: (lv_one_2_0= RULE_ID )
                    // InternalSerializationErrorTestLanguage.g:288:7: lv_one_2_0= RULE_ID
                    {
                    lv_one_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(lv_one_2_0, grammarAccess.getTwoOptionsAccess().getOneIDTerminalRuleCall_1_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTwoOptionsRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"one",
                    								lv_one_2_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSerializationErrorTestLanguage.g:306:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    {
                    // InternalSerializationErrorTestLanguage.g:306:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    // InternalSerializationErrorTestLanguage.g:307:5: otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                    					newLeafNode(otherlv_3, grammarAccess.getTwoOptionsAccess().getTwoKeyword_1_1_0());
                    				
                    // InternalSerializationErrorTestLanguage.g:311:5: ( (lv_two_4_0= RULE_ID ) )
                    // InternalSerializationErrorTestLanguage.g:312:6: (lv_two_4_0= RULE_ID )
                    {
                    // InternalSerializationErrorTestLanguage.g:312:6: (lv_two_4_0= RULE_ID )
                    // InternalSerializationErrorTestLanguage.g:313:7: lv_two_4_0= RULE_ID
                    {
                    lv_two_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							newLeafNode(lv_two_4_0, grammarAccess.getTwoOptionsAccess().getTwoIDTerminalRuleCall_1_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTwoOptionsRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"two",
                    								lv_two_4_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }


                    }


                    }
                    break;

            }


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
    // $ANTLR end "ruleTwoOptions"


    // $ANTLR start "entryRuleIndent"
    // InternalSerializationErrorTestLanguage.g:335:1: entryRuleIndent returns [EObject current=null] : iv_ruleIndent= ruleIndent EOF ;
    public final EObject entryRuleIndent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndent = null;


        try {
            // InternalSerializationErrorTestLanguage.g:335:47: (iv_ruleIndent= ruleIndent EOF )
            // InternalSerializationErrorTestLanguage.g:336:2: iv_ruleIndent= ruleIndent EOF
            {
             newCompositeNode(grammarAccess.getIndentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIndent=ruleIndent();

            state._fsp--;

             current =iv_ruleIndent; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleIndent"


    // $ANTLR start "ruleIndent"
    // InternalSerializationErrorTestLanguage.g:342:1: ruleIndent returns [EObject current=null] : (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) ;
    public final EObject ruleIndent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_req_1_0 = null;

        EObject lv_opt_2_0 = null;

        EObject lv_indent_3_0 = null;



        	enterRule();

        try {
            // InternalSerializationErrorTestLanguage.g:348:2: ( (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) )
            // InternalSerializationErrorTestLanguage.g:349:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            {
            // InternalSerializationErrorTestLanguage.g:349:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            // InternalSerializationErrorTestLanguage.g:350:3: otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getIndentAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalSerializationErrorTestLanguage.g:354:3: ( (lv_req_1_0= ruleTwoRequired ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSerializationErrorTestLanguage.g:355:4: (lv_req_1_0= ruleTwoRequired )
                    {
                    // InternalSerializationErrorTestLanguage.g:355:4: (lv_req_1_0= ruleTwoRequired )
                    // InternalSerializationErrorTestLanguage.g:356:5: lv_req_1_0= ruleTwoRequired
                    {

                    					newCompositeNode(grammarAccess.getIndentAccess().getReqTwoRequiredParserRuleCall_1_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_req_1_0=ruleTwoRequired();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIndentRule());
                    					}
                    					set(
                    						current,
                    						"req",
                    						lv_req_1_0,
                    						"org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage.TwoRequired");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSerializationErrorTestLanguage.g:373:3: ( (lv_opt_2_0= ruleTwoOptions ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSerializationErrorTestLanguage.g:374:4: (lv_opt_2_0= ruleTwoOptions )
                    {
                    // InternalSerializationErrorTestLanguage.g:374:4: (lv_opt_2_0= ruleTwoOptions )
                    // InternalSerializationErrorTestLanguage.g:375:5: lv_opt_2_0= ruleTwoOptions
                    {

                    					newCompositeNode(grammarAccess.getIndentAccess().getOptTwoOptionsParserRuleCall_2_0());
                    				
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_opt_2_0=ruleTwoOptions();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIndentRule());
                    					}
                    					set(
                    						current,
                    						"opt",
                    						lv_opt_2_0,
                    						"org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage.TwoOptions");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSerializationErrorTestLanguage.g:392:3: ( (lv_indent_3_0= ruleIndent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSerializationErrorTestLanguage.g:393:4: (lv_indent_3_0= ruleIndent )
            	    {
            	    // InternalSerializationErrorTestLanguage.g:393:4: (lv_indent_3_0= ruleIndent )
            	    // InternalSerializationErrorTestLanguage.g:394:5: lv_indent_3_0= ruleIndent
            	    {

            	    					newCompositeNode(grammarAccess.getIndentAccess().getIndentIndentParserRuleCall_3_0());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_indent_3_0=ruleIndent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIndentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"indent",
            	    						lv_indent_3_0,
            	    						"org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguage.Indent");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getIndentAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleIndent"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000026000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000066000L});
    }


}