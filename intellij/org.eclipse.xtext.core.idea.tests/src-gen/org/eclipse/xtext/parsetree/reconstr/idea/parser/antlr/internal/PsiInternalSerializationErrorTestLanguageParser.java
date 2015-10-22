package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.reconstr.services.SerializationErrorTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSerializationErrorTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'tworequired'", "'twooptions'", "'one'", "'two'", "'{'", "'}'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalSerializationErrorTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSerializationErrorTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSerializationErrorTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSerializationErrorTestLanguage.g"; }



    	protected SerializationErrorTestLanguageGrammarAccess grammarAccess;

    	protected SerializationErrorTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSerializationErrorTestLanguageParser(PsiBuilder builder, TokenStream input, SerializationErrorTestLanguageElementTypeProvider elementTypeProvider, SerializationErrorTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalSerializationErrorTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalSerializationErrorTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalSerializationErrorTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_test_0_0 = null;

        Boolean lv_test_1_0 = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:60:1: ( ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:61:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
            {
            // PsiInternalSerializationErrorTestLanguage.g:61:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
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
                    // PsiInternalSerializationErrorTestLanguage.g:62:3: ( (lv_test_0_0= ruleTest ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:62:3: ( (lv_test_0_0= ruleTest ) )
                    // PsiInternalSerializationErrorTestLanguage.g:63:4: (lv_test_0_0= ruleTest )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:63:4: (lv_test_0_0= ruleTest )
                    // PsiInternalSerializationErrorTestLanguage.g:64:5: lv_test_0_0= ruleTest
                    {

                    					markComposite(elementTypeProvider.getModel_TestTestParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_test_0_0=ruleTest();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSerializationErrorTestLanguage.g:78:3: ( (lv_test_1_0= ruleParenthesis ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:78:3: ( (lv_test_1_0= ruleParenthesis ) )
                    // PsiInternalSerializationErrorTestLanguage.g:79:4: (lv_test_1_0= ruleParenthesis )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:79:4: (lv_test_1_0= ruleParenthesis )
                    // PsiInternalSerializationErrorTestLanguage.g:80:5: lv_test_1_0= ruleParenthesis
                    {

                    					markComposite(elementTypeProvider.getModel_TestParenthesisParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_test_1_0=ruleParenthesis();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleParenthesis"
    // PsiInternalSerializationErrorTestLanguage.g:97:1: entryRuleParenthesis returns [Boolean current=false] : iv_ruleParenthesis= ruleParenthesis EOF ;
    public final Boolean entryRuleParenthesis() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParenthesis = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:97:53: (iv_ruleParenthesis= ruleParenthesis EOF )
            // PsiInternalSerializationErrorTestLanguage.g:98:2: iv_ruleParenthesis= ruleParenthesis EOF
            {
             markComposite(elementTypeProvider.getParenthesisElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParenthesis=ruleParenthesis();

            state._fsp--;

             current =iv_ruleParenthesis; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesis"


    // $ANTLR start "ruleParenthesis"
    // PsiInternalSerializationErrorTestLanguage.g:104:1: ruleParenthesis returns [Boolean current=false] : (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' ) ;
    public final Boolean ruleParenthesis() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Test_1 = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:105:1: ( (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' ) )
            // PsiInternalSerializationErrorTestLanguage.g:106:2: (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' )
            {
            // PsiInternalSerializationErrorTestLanguage.g:106:2: (otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')' )
            // PsiInternalSerializationErrorTestLanguage.g:107:3: otherlv_0= '(' this_Test_1= ruleTest otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesis_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesis_TestParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            this_Test_1=ruleTest();

            state._fsp--;


            			current = this_Test_1;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParenthesis_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesis"


    // $ANTLR start "entryRuleTest"
    // PsiInternalSerializationErrorTestLanguage.g:133:1: entryRuleTest returns [Boolean current=false] : iv_ruleTest= ruleTest EOF ;
    public final Boolean entryRuleTest() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTest = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:133:46: (iv_ruleTest= ruleTest EOF )
            // PsiInternalSerializationErrorTestLanguage.g:134:2: iv_ruleTest= ruleTest EOF
            {
             markComposite(elementTypeProvider.getTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // PsiInternalSerializationErrorTestLanguage.g:140:1: ruleTest returns [Boolean current=false] : (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) ;
    public final Boolean ruleTest() throws RecognitionException {
        Boolean current = false;

        Boolean this_TwoRequired_0 = null;

        Boolean this_TwoOptions_1 = null;

        Boolean this_Indent_2 = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:141:1: ( (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent ) )
            // PsiInternalSerializationErrorTestLanguage.g:142:2: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
            {
            // PsiInternalSerializationErrorTestLanguage.g:142:2: (this_TwoRequired_0= ruleTwoRequired | this_TwoOptions_1= ruleTwoOptions | this_Indent_2= ruleIndent )
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
                    // PsiInternalSerializationErrorTestLanguage.g:143:3: this_TwoRequired_0= ruleTwoRequired
                    {

                    			markComposite(elementTypeProvider.getTest_TwoRequiredParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoRequired_0=ruleTwoRequired();

                    state._fsp--;


                    			current = this_TwoRequired_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSerializationErrorTestLanguage.g:152:3: this_TwoOptions_1= ruleTwoOptions
                    {

                    			markComposite(elementTypeProvider.getTest_TwoOptionsParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoOptions_1=ruleTwoOptions();

                    state._fsp--;


                    			current = this_TwoOptions_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalSerializationErrorTestLanguage.g:161:3: this_Indent_2= ruleIndent
                    {

                    			markComposite(elementTypeProvider.getTest_IndentParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Indent_2=ruleIndent();

                    state._fsp--;


                    			current = this_Indent_2;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleTwoRequired"
    // PsiInternalSerializationErrorTestLanguage.g:173:1: entryRuleTwoRequired returns [Boolean current=false] : iv_ruleTwoRequired= ruleTwoRequired EOF ;
    public final Boolean entryRuleTwoRequired() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTwoRequired = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:173:53: (iv_ruleTwoRequired= ruleTwoRequired EOF )
            // PsiInternalSerializationErrorTestLanguage.g:174:2: iv_ruleTwoRequired= ruleTwoRequired EOF
            {
             markComposite(elementTypeProvider.getTwoRequiredElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoRequired=ruleTwoRequired();

            state._fsp--;

             current =iv_ruleTwoRequired; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTwoRequired"


    // $ANTLR start "ruleTwoRequired"
    // PsiInternalSerializationErrorTestLanguage.g:180:1: ruleTwoRequired returns [Boolean current=false] : (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleTwoRequired() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_one_1_0=null;
        Token lv_two_2_0=null;

        try {
            // PsiInternalSerializationErrorTestLanguage.g:181:1: ( (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:182:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            {
            // PsiInternalSerializationErrorTestLanguage.g:182:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:183:3: otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getTwoRequired_TworequiredKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSerializationErrorTestLanguage.g:190:3: ( (lv_one_1_0= RULE_ID ) )
            // PsiInternalSerializationErrorTestLanguage.g:191:4: (lv_one_1_0= RULE_ID )
            {
            // PsiInternalSerializationErrorTestLanguage.g:191:4: (lv_one_1_0= RULE_ID )
            // PsiInternalSerializationErrorTestLanguage.g:192:5: lv_one_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoRequired_OneIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_one_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_one_1_0);
            				

            }


            }

            // PsiInternalSerializationErrorTestLanguage.g:207:3: ( (lv_two_2_0= RULE_ID ) )
            // PsiInternalSerializationErrorTestLanguage.g:208:4: (lv_two_2_0= RULE_ID )
            {
            // PsiInternalSerializationErrorTestLanguage.g:208:4: (lv_two_2_0= RULE_ID )
            // PsiInternalSerializationErrorTestLanguage.g:209:5: lv_two_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoRequired_TwoIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_two_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_two_2_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTwoRequired"


    // $ANTLR start "entryRuleTwoOptions"
    // PsiInternalSerializationErrorTestLanguage.g:228:1: entryRuleTwoOptions returns [Boolean current=false] : iv_ruleTwoOptions= ruleTwoOptions EOF ;
    public final Boolean entryRuleTwoOptions() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTwoOptions = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:228:52: (iv_ruleTwoOptions= ruleTwoOptions EOF )
            // PsiInternalSerializationErrorTestLanguage.g:229:2: iv_ruleTwoOptions= ruleTwoOptions EOF
            {
             markComposite(elementTypeProvider.getTwoOptionsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoOptions=ruleTwoOptions();

            state._fsp--;

             current =iv_ruleTwoOptions; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTwoOptions"


    // $ANTLR start "ruleTwoOptions"
    // PsiInternalSerializationErrorTestLanguage.g:235:1: ruleTwoOptions returns [Boolean current=false] : (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) ;
    public final Boolean ruleTwoOptions() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_one_2_0=null;
        Token otherlv_3=null;
        Token lv_two_4_0=null;

        try {
            // PsiInternalSerializationErrorTestLanguage.g:236:1: ( (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:237:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalSerializationErrorTestLanguage.g:237:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:238:3: otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getTwoOptions_TwooptionsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSerializationErrorTestLanguage.g:245:3: ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
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
                    // PsiInternalSerializationErrorTestLanguage.g:246:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:246:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    // PsiInternalSerializationErrorTestLanguage.g:247:5: otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getTwoOptions_OneKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSerializationErrorTestLanguage.g:254:5: ( (lv_one_2_0= RULE_ID ) )
                    // PsiInternalSerializationErrorTestLanguage.g:255:6: (lv_one_2_0= RULE_ID )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:255:6: (lv_one_2_0= RULE_ID )
                    // PsiInternalSerializationErrorTestLanguage.g:256:7: lv_one_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoOptions_OneIDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_one_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_one_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSerializationErrorTestLanguage.g:273:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:273:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    // PsiInternalSerializationErrorTestLanguage.g:274:5: otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getTwoOptions_TwoKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSerializationErrorTestLanguage.g:281:5: ( (lv_two_4_0= RULE_ID ) )
                    // PsiInternalSerializationErrorTestLanguage.g:282:6: (lv_two_4_0= RULE_ID )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:282:6: (lv_two_4_0= RULE_ID )
                    // PsiInternalSerializationErrorTestLanguage.g:283:7: lv_two_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoOptions_TwoIDTerminalRuleCall_1_1_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_two_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_two_4_0);
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTwoOptions"


    // $ANTLR start "entryRuleIndent"
    // PsiInternalSerializationErrorTestLanguage.g:304:1: entryRuleIndent returns [Boolean current=false] : iv_ruleIndent= ruleIndent EOF ;
    public final Boolean entryRuleIndent() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIndent = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:304:48: (iv_ruleIndent= ruleIndent EOF )
            // PsiInternalSerializationErrorTestLanguage.g:305:2: iv_ruleIndent= ruleIndent EOF
            {
             markComposite(elementTypeProvider.getIndentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIndent=ruleIndent();

            state._fsp--;

             current =iv_ruleIndent; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndent"


    // $ANTLR start "ruleIndent"
    // PsiInternalSerializationErrorTestLanguage.g:311:1: ruleIndent returns [Boolean current=false] : (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) ;
    public final Boolean ruleIndent() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Boolean lv_req_1_0 = null;

        Boolean lv_opt_2_0 = null;

        Boolean lv_indent_3_0 = null;


        try {
            // PsiInternalSerializationErrorTestLanguage.g:312:1: ( (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) )
            // PsiInternalSerializationErrorTestLanguage.g:313:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            {
            // PsiInternalSerializationErrorTestLanguage.g:313:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            // PsiInternalSerializationErrorTestLanguage.g:314:3: otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}'
            {

            			markLeaf(elementTypeProvider.getIndent_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSerializationErrorTestLanguage.g:321:3: ( (lv_req_1_0= ruleTwoRequired ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalSerializationErrorTestLanguage.g:322:4: (lv_req_1_0= ruleTwoRequired )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:322:4: (lv_req_1_0= ruleTwoRequired )
                    // PsiInternalSerializationErrorTestLanguage.g:323:5: lv_req_1_0= ruleTwoRequired
                    {

                    					markComposite(elementTypeProvider.getIndent_ReqTwoRequiredParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_req_1_0=ruleTwoRequired();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalSerializationErrorTestLanguage.g:336:3: ( (lv_opt_2_0= ruleTwoOptions ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalSerializationErrorTestLanguage.g:337:4: (lv_opt_2_0= ruleTwoOptions )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:337:4: (lv_opt_2_0= ruleTwoOptions )
                    // PsiInternalSerializationErrorTestLanguage.g:338:5: lv_opt_2_0= ruleTwoOptions
                    {

                    					markComposite(elementTypeProvider.getIndent_OptTwoOptionsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_opt_2_0=ruleTwoOptions();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalSerializationErrorTestLanguage.g:351:3: ( (lv_indent_3_0= ruleIndent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalSerializationErrorTestLanguage.g:352:4: (lv_indent_3_0= ruleIndent )
            	    {
            	    // PsiInternalSerializationErrorTestLanguage.g:352:4: (lv_indent_3_0= ruleIndent )
            	    // PsiInternalSerializationErrorTestLanguage.g:353:5: lv_indent_3_0= ruleIndent
            	    {

            	    					markComposite(elementTypeProvider.getIndent_IndentIndentParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_indent_3_0=ruleIndent();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getIndent_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
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