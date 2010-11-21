package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
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
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalSerializationErrorTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSerializationErrorTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSerializationErrorTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g"; }



     	private SerializationErrorTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSerializationErrorTestLanguageParser(TokenStream input, IAstFactory factory, SerializationErrorTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:72:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:79:1: ruleModel returns [EObject current=null] : ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_test_0_0 = null;

        EObject lv_test_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:82:28: ( ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:83:1: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:83:1: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:83:2: ( (lv_test_0_0= ruleTest ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:83:2: ( (lv_test_0_0= ruleTest ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:84:1: (lv_test_0_0= ruleTest )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:84:1: (lv_test_0_0= ruleTest )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:85:3: lv_test_0_0= ruleTest
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getTestTestParserRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleModel131);
                    lv_test_0_0=ruleTest();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"test",
                            		lv_test_0_0, 
                            		"Test");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:102:6: ( (lv_test_1_0= ruleParenthesis ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:102:6: ( (lv_test_1_0= ruleParenthesis ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:103:1: (lv_test_1_0= ruleParenthesis )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:103:1: (lv_test_1_0= ruleParenthesis )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:104:3: lv_test_1_0= ruleParenthesis
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getTestParenthesisParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_ruleModel158);
                    lv_test_1_0=ruleParenthesis();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"test",
                            		lv_test_1_0, 
                            		"Parenthesis");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:128:1: entryRuleParenthesis returns [EObject current=null] : iv_ruleParenthesis= ruleParenthesis EOF ;
    public final EObject entryRuleParenthesis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesis = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:129:2: (iv_ruleParenthesis= ruleParenthesis EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:130:2: iv_ruleParenthesis= ruleParenthesis EOF
            {
             newCompositeNode(grammarAccess.getParenthesisRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_entryRuleParenthesis194);
            iv_ruleParenthesis=ruleParenthesis();

            state._fsp--;

             current =iv_ruleParenthesis; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesis204); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:137:1: ruleParenthesis returns [EObject current=null] : (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' ) ;
    public final EObject ruleParenthesis() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Test_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:140:28: ( (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:141:1: (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:141:1: (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:141:3: otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleParenthesis241); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesisAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesisAccess().getTestParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleParenthesis263);
            this_Test_1=ruleTest();

            state._fsp--;

             
                    current = this_Test_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleParenthesis274); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:166:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:167:2: (iv_ruleTest= ruleTest EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:168:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_entryRuleTest310);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTest320); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:175:1: ruleTest returns [EObject current=null] : (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        EObject this_TwoRequired_0 = null;

        EObject this_TwoOptions_1 = null;

        EObject this_Indent_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:178:28: ( (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:179:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:179:1: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:180:5: this_TwoRequired_0= ruleTwoRequired
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getTwoRequiredParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_ruleTest367);
                    this_TwoRequired_0=ruleTwoRequired();

                    state._fsp--;

                     
                            current = this_TwoRequired_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:190:5: this_TwoOptions_1= ruleTwoOptions
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getTwoOptionsParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_ruleTest394);
                    this_TwoOptions_1=ruleTwoOptions();

                    state._fsp--;

                     
                            current = this_TwoOptions_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:200:5: this_Indent_2= ruleIndent
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getIndentParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIndent_in_ruleTest421);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:216:1: entryRuleTwoRequired returns [EObject current=null] : iv_ruleTwoRequired= ruleTwoRequired EOF ;
    public final EObject entryRuleTwoRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoRequired = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:217:2: (iv_ruleTwoRequired= ruleTwoRequired EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:218:2: iv_ruleTwoRequired= ruleTwoRequired EOF
            {
             newCompositeNode(grammarAccess.getTwoRequiredRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired456);
            iv_ruleTwoRequired=ruleTwoRequired();

            state._fsp--;

             current =iv_ruleTwoRequired; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoRequired466); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:225:1: ruleTwoRequired returns [EObject current=null] : (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTwoRequired() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_one_1_0=null;
        Token lv_two_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:228:28: ( (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:229:1: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:229:1: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:229:3: otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTwoRequired503); 

                	newLeafNode(otherlv_0, grammarAccess.getTwoRequiredAccess().getTworequiredKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:233:1: ( (lv_one_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:234:1: (lv_one_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:234:1: (lv_one_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:235:3: lv_one_1_0= RULE_ID
            {
            lv_one_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoRequired520); 

            			newLeafNode(lv_one_1_0, grammarAccess.getTwoRequiredAccess().getOneIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTwoRequiredRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"one",
                    		lv_one_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:251:2: ( (lv_two_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:252:1: (lv_two_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:252:1: (lv_two_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:253:3: lv_two_2_0= RULE_ID
            {
            lv_two_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoRequired542); 

            			newLeafNode(lv_two_2_0, grammarAccess.getTwoRequiredAccess().getTwoIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTwoRequiredRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"two",
                    		lv_two_2_0, 
                    		"ID");
            	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:277:1: entryRuleTwoOptions returns [EObject current=null] : iv_ruleTwoOptions= ruleTwoOptions EOF ;
    public final EObject entryRuleTwoOptions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoOptions = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:278:2: (iv_ruleTwoOptions= ruleTwoOptions EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:279:2: iv_ruleTwoOptions= ruleTwoOptions EOF
            {
             newCompositeNode(grammarAccess.getTwoOptionsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions583);
            iv_ruleTwoOptions=ruleTwoOptions();

            state._fsp--;

             current =iv_ruleTwoOptions; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoOptions593); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:286:1: ruleTwoOptions returns [EObject current=null] : (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleTwoOptions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_one_2_0=null;
        Token otherlv_3=null;
        Token lv_two_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:289:28: ( (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:290:1: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:290:1: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:290:3: otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTwoOptions630); 

                	newLeafNode(otherlv_0, grammarAccess.getTwoOptionsAccess().getTwooptionsKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:294:1: ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:294:2: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:294:2: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:294:4: otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTwoOptions644); 

                        	newLeafNode(otherlv_1, grammarAccess.getTwoOptionsAccess().getOneKeyword_1_0_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:298:1: ( (lv_one_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:299:1: (lv_one_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:299:1: (lv_one_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:300:3: lv_one_2_0= RULE_ID
                    {
                    lv_one_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoOptions661); 

                    			newLeafNode(lv_one_2_0, grammarAccess.getTwoOptionsAccess().getOneIDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTwoOptionsRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"one",
                            		lv_one_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:317:6: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:317:6: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:317:8: otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTwoOptions686); 

                        	newLeafNode(otherlv_3, grammarAccess.getTwoOptionsAccess().getTwoKeyword_1_1_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:321:1: ( (lv_two_4_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:322:1: (lv_two_4_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:322:1: (lv_two_4_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:323:3: lv_two_4_0= RULE_ID
                    {
                    lv_two_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoOptions703); 

                    			newLeafNode(lv_two_4_0, grammarAccess.getTwoOptionsAccess().getTwoIDTerminalRuleCall_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTwoOptionsRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"two",
                            		lv_two_4_0, 
                            		"ID");
                    	    

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:347:1: entryRuleIndent returns [EObject current=null] : iv_ruleIndent= ruleIndent EOF ;
    public final EObject entryRuleIndent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndent = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:348:2: (iv_ruleIndent= ruleIndent EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:349:2: iv_ruleIndent= ruleIndent EOF
            {
             newCompositeNode(grammarAccess.getIndentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndent_in_entryRuleIndent746);
            iv_ruleIndent=ruleIndent();

            state._fsp--;

             current =iv_ruleIndent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIndent756); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:356:1: ruleIndent returns [EObject current=null] : (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) ;
    public final EObject ruleIndent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_req_1_0 = null;

        EObject lv_opt_2_0 = null;

        EObject lv_indent_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:359:28: ( (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:360:1: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:360:1: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:360:3: otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleIndent793); 

                	newLeafNode(otherlv_0, grammarAccess.getIndentAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:364:1: ( (lv_req_1_0= ruleTwoRequired ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:365:1: (lv_req_1_0= ruleTwoRequired )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:365:1: (lv_req_1_0= ruleTwoRequired )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:366:3: lv_req_1_0= ruleTwoRequired
                    {
                     
                    	        newCompositeNode(grammarAccess.getIndentAccess().getReqTwoRequiredParserRuleCall_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_ruleIndent814);
                    lv_req_1_0=ruleTwoRequired();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIndentRule());
                    	        }
                           		set(
                           			current, 
                           			"req",
                            		lv_req_1_0, 
                            		"TwoRequired");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:382:3: ( (lv_opt_2_0= ruleTwoOptions ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:383:1: (lv_opt_2_0= ruleTwoOptions )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:383:1: (lv_opt_2_0= ruleTwoOptions )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:384:3: lv_opt_2_0= ruleTwoOptions
                    {
                     
                    	        newCompositeNode(grammarAccess.getIndentAccess().getOptTwoOptionsParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_ruleIndent836);
                    lv_opt_2_0=ruleTwoOptions();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIndentRule());
                    	        }
                           		set(
                           			current, 
                           			"opt",
                            		lv_opt_2_0, 
                            		"TwoOptions");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:400:3: ( (lv_indent_3_0= ruleIndent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:401:1: (lv_indent_3_0= ruleIndent )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:401:1: (lv_indent_3_0= ruleIndent )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationErrorTestLanguage.g:402:3: lv_indent_3_0= ruleIndent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getIndentAccess().getIndentIndentParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleIndent_in_ruleIndent858);
            	    lv_indent_3_0=ruleIndent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getIndentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"indent",
            	            		lv_indent_3_0, 
            	            		"Indent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleIndent871); 

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_entryRuleParenthesis194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesis204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParenthesis241 = new BitSet(new long[]{0x0000000000026000L});
        public static final BitSet FOLLOW_ruleTest_in_ruleParenthesis263 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleParenthesis274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_entryRuleTest310 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTest320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_ruleTest367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_ruleTest394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndent_in_ruleTest421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired456 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoRequired466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleTwoRequired503 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired520 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions583 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoOptions593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleTwoOptions630 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_15_in_ruleTwoOptions644 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleTwoOptions686 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndent_in_entryRuleIndent746 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIndent756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleIndent793 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_ruleIndent814 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_ruleIndent836 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_ruleIndent_in_ruleIndent858 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_18_in_ruleIndent871 = new BitSet(new long[]{0x0000000000000002L});
    }


}