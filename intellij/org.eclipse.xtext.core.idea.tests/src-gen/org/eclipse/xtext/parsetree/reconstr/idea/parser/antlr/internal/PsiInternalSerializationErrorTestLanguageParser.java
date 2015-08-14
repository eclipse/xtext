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
    // PsiInternalSerializationErrorTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalSerializationErrorTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalSerializationErrorTestLanguage.g:58:1: ruleModel : ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:58:10: ( ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:59:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
            {
            // PsiInternalSerializationErrorTestLanguage.g:59:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
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
                    // PsiInternalSerializationErrorTestLanguage.g:60:3: ( (lv_test_0_0= ruleTest ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:60:3: ( (lv_test_0_0= ruleTest ) )
                    // PsiInternalSerializationErrorTestLanguage.g:61:4: (lv_test_0_0= ruleTest )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:61:4: (lv_test_0_0= ruleTest )
                    // PsiInternalSerializationErrorTestLanguage.g:62:5: lv_test_0_0= ruleTest
                    {

                    					markComposite(elementTypeProvider.getModel_TestTestParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTest();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSerializationErrorTestLanguage.g:72:3: ( (lv_test_1_0= ruleParenthesis ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:72:3: ( (lv_test_1_0= ruleParenthesis ) )
                    // PsiInternalSerializationErrorTestLanguage.g:73:4: (lv_test_1_0= ruleParenthesis )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:73:4: (lv_test_1_0= ruleParenthesis )
                    // PsiInternalSerializationErrorTestLanguage.g:74:5: lv_test_1_0= ruleParenthesis
                    {

                    					markComposite(elementTypeProvider.getModel_TestParenthesisParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesis();

                    state._fsp--;


                    					doneComposite();
                    				

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
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleParenthesis"
    // PsiInternalSerializationErrorTestLanguage.g:87:1: entryRuleParenthesis : ruleParenthesis EOF ;
    public final void entryRuleParenthesis() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:87:21: ( ruleParenthesis EOF )
            // PsiInternalSerializationErrorTestLanguage.g:88:2: ruleParenthesis EOF
            {
             markComposite(elementTypeProvider.getParenthesisElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesis();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParenthesis"


    // $ANTLR start "ruleParenthesis"
    // PsiInternalSerializationErrorTestLanguage.g:93:1: ruleParenthesis : (otherlv_0= '(' ruleTest otherlv_2= ')' ) ;
    public final void ruleParenthesis() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalSerializationErrorTestLanguage.g:93:16: ( (otherlv_0= '(' ruleTest otherlv_2= ')' ) )
            // PsiInternalSerializationErrorTestLanguage.g:94:2: (otherlv_0= '(' ruleTest otherlv_2= ')' )
            {
            // PsiInternalSerializationErrorTestLanguage.g:94:2: (otherlv_0= '(' ruleTest otherlv_2= ')' )
            // PsiInternalSerializationErrorTestLanguage.g:95:3: otherlv_0= '(' ruleTest otherlv_2= ')'
            {

            			markLeaf(elementTypeProvider.getParenthesis_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParenthesis_TestParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_4);
            ruleTest();

            state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleParenthesis"


    // $ANTLR start "entryRuleTest"
    // PsiInternalSerializationErrorTestLanguage.g:120:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:120:14: ( ruleTest EOF )
            // PsiInternalSerializationErrorTestLanguage.g:121:2: ruleTest EOF
            {
             markComposite(elementTypeProvider.getTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTest();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // PsiInternalSerializationErrorTestLanguage.g:126:1: ruleTest : ( ruleTwoRequired | ruleTwoOptions | ruleIndent ) ;
    public final void ruleTest() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:126:9: ( ( ruleTwoRequired | ruleTwoOptions | ruleIndent ) )
            // PsiInternalSerializationErrorTestLanguage.g:127:2: ( ruleTwoRequired | ruleTwoOptions | ruleIndent )
            {
            // PsiInternalSerializationErrorTestLanguage.g:127:2: ( ruleTwoRequired | ruleTwoOptions | ruleIndent )
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
                    // PsiInternalSerializationErrorTestLanguage.g:128:3: ruleTwoRequired
                    {

                    			markComposite(elementTypeProvider.getTest_TwoRequiredParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTwoRequired();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSerializationErrorTestLanguage.g:136:3: ruleTwoOptions
                    {

                    			markComposite(elementTypeProvider.getTest_TwoOptionsParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTwoOptions();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalSerializationErrorTestLanguage.g:144:3: ruleIndent
                    {

                    			markComposite(elementTypeProvider.getTest_IndentParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIndent();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleTwoRequired"
    // PsiInternalSerializationErrorTestLanguage.g:155:1: entryRuleTwoRequired : ruleTwoRequired EOF ;
    public final void entryRuleTwoRequired() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:155:21: ( ruleTwoRequired EOF )
            // PsiInternalSerializationErrorTestLanguage.g:156:2: ruleTwoRequired EOF
            {
             markComposite(elementTypeProvider.getTwoRequiredElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTwoRequired();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTwoRequired"


    // $ANTLR start "ruleTwoRequired"
    // PsiInternalSerializationErrorTestLanguage.g:161:1: ruleTwoRequired : (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) ;
    public final void ruleTwoRequired() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_one_1_0=null;
        Token lv_two_2_0=null;

        try {
            // PsiInternalSerializationErrorTestLanguage.g:161:16: ( (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:162:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            {
            // PsiInternalSerializationErrorTestLanguage.g:162:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:163:3: otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getTwoRequired_TworequiredKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSerializationErrorTestLanguage.g:170:3: ( (lv_one_1_0= RULE_ID ) )
            // PsiInternalSerializationErrorTestLanguage.g:171:4: (lv_one_1_0= RULE_ID )
            {
            // PsiInternalSerializationErrorTestLanguage.g:171:4: (lv_one_1_0= RULE_ID )
            // PsiInternalSerializationErrorTestLanguage.g:172:5: lv_one_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoRequired_OneIDTerminalRuleCall_1_0ElementType());
            				
            lv_one_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_one_1_0);
            				

            }


            }

            // PsiInternalSerializationErrorTestLanguage.g:181:3: ( (lv_two_2_0= RULE_ID ) )
            // PsiInternalSerializationErrorTestLanguage.g:182:4: (lv_two_2_0= RULE_ID )
            {
            // PsiInternalSerializationErrorTestLanguage.g:182:4: (lv_two_2_0= RULE_ID )
            // PsiInternalSerializationErrorTestLanguage.g:183:5: lv_two_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTwoRequired_TwoIDTerminalRuleCall_2_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleTwoRequired"


    // $ANTLR start "entryRuleTwoOptions"
    // PsiInternalSerializationErrorTestLanguage.g:196:1: entryRuleTwoOptions : ruleTwoOptions EOF ;
    public final void entryRuleTwoOptions() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:196:20: ( ruleTwoOptions EOF )
            // PsiInternalSerializationErrorTestLanguage.g:197:2: ruleTwoOptions EOF
            {
             markComposite(elementTypeProvider.getTwoOptionsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTwoOptions();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTwoOptions"


    // $ANTLR start "ruleTwoOptions"
    // PsiInternalSerializationErrorTestLanguage.g:202:1: ruleTwoOptions : (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) ;
    public final void ruleTwoOptions() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_one_2_0=null;
        Token otherlv_3=null;
        Token lv_two_4_0=null;

        try {
            // PsiInternalSerializationErrorTestLanguage.g:202:15: ( (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:203:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            {
            // PsiInternalSerializationErrorTestLanguage.g:203:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            // PsiInternalSerializationErrorTestLanguage.g:204:3: otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
            {

            			markLeaf(elementTypeProvider.getTwoOptions_TwooptionsKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSerializationErrorTestLanguage.g:211:3: ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
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
                    // PsiInternalSerializationErrorTestLanguage.g:212:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:212:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    // PsiInternalSerializationErrorTestLanguage.g:213:5: otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getTwoOptions_OneKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSerializationErrorTestLanguage.g:220:5: ( (lv_one_2_0= RULE_ID ) )
                    // PsiInternalSerializationErrorTestLanguage.g:221:6: (lv_one_2_0= RULE_ID )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:221:6: (lv_one_2_0= RULE_ID )
                    // PsiInternalSerializationErrorTestLanguage.g:222:7: lv_one_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoOptions_OneIDTerminalRuleCall_1_0_1_0ElementType());
                    						
                    lv_one_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_one_2_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSerializationErrorTestLanguage.g:233:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:233:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    // PsiInternalSerializationErrorTestLanguage.g:234:5: otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getTwoOptions_TwoKeyword_1_1_0ElementType());
                    				
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalSerializationErrorTestLanguage.g:241:5: ( (lv_two_4_0= RULE_ID ) )
                    // PsiInternalSerializationErrorTestLanguage.g:242:6: (lv_two_4_0= RULE_ID )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:242:6: (lv_two_4_0= RULE_ID )
                    // PsiInternalSerializationErrorTestLanguage.g:243:7: lv_two_4_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getTwoOptions_TwoIDTerminalRuleCall_1_1_1_0ElementType());
                    						
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
        return ;
    }
    // $ANTLR end "ruleTwoOptions"


    // $ANTLR start "entryRuleIndent"
    // PsiInternalSerializationErrorTestLanguage.g:258:1: entryRuleIndent : ruleIndent EOF ;
    public final void entryRuleIndent() throws RecognitionException {
        try {
            // PsiInternalSerializationErrorTestLanguage.g:258:16: ( ruleIndent EOF )
            // PsiInternalSerializationErrorTestLanguage.g:259:2: ruleIndent EOF
            {
             markComposite(elementTypeProvider.getIndentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIndent();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIndent"


    // $ANTLR start "ruleIndent"
    // PsiInternalSerializationErrorTestLanguage.g:264:1: ruleIndent : (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) ;
    public final void ruleIndent() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_4=null;

        try {
            // PsiInternalSerializationErrorTestLanguage.g:264:11: ( (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) )
            // PsiInternalSerializationErrorTestLanguage.g:265:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            {
            // PsiInternalSerializationErrorTestLanguage.g:265:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            // PsiInternalSerializationErrorTestLanguage.g:266:3: otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}'
            {

            			markLeaf(elementTypeProvider.getIndent_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSerializationErrorTestLanguage.g:273:3: ( (lv_req_1_0= ruleTwoRequired ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalSerializationErrorTestLanguage.g:274:4: (lv_req_1_0= ruleTwoRequired )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:274:4: (lv_req_1_0= ruleTwoRequired )
                    // PsiInternalSerializationErrorTestLanguage.g:275:5: lv_req_1_0= ruleTwoRequired
                    {

                    					markComposite(elementTypeProvider.getIndent_ReqTwoRequiredParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleTwoRequired();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // PsiInternalSerializationErrorTestLanguage.g:284:3: ( (lv_opt_2_0= ruleTwoOptions ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalSerializationErrorTestLanguage.g:285:4: (lv_opt_2_0= ruleTwoOptions )
                    {
                    // PsiInternalSerializationErrorTestLanguage.g:285:4: (lv_opt_2_0= ruleTwoOptions )
                    // PsiInternalSerializationErrorTestLanguage.g:286:5: lv_opt_2_0= ruleTwoOptions
                    {

                    					markComposite(elementTypeProvider.getIndent_OptTwoOptionsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleTwoOptions();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // PsiInternalSerializationErrorTestLanguage.g:295:3: ( (lv_indent_3_0= ruleIndent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalSerializationErrorTestLanguage.g:296:4: (lv_indent_3_0= ruleIndent )
            	    {
            	    // PsiInternalSerializationErrorTestLanguage.g:296:4: (lv_indent_3_0= ruleIndent )
            	    // PsiInternalSerializationErrorTestLanguage.g:297:5: lv_indent_3_0= ruleIndent
            	    {

            	    					markComposite(elementTypeProvider.getIndent_IndentIndentParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleIndent();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
        return ;
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