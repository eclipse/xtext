package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:51:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:59:1: ruleModel : ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:59:10: ( ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:60:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:60:2: ( ( (lv_test_0_0= ruleTest ) ) | ( (lv_test_1_0= ruleParenthesis ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:61:3: ( (lv_test_0_0= ruleTest ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:61:3: ( (lv_test_0_0= ruleTest ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:62:4: (lv_test_0_0= ruleTest )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:62:4: (lv_test_0_0= ruleTest )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:63:5: lv_test_0_0= ruleTest
                    {

                    					markComposite(elementTypeProvider.getModel_TestTestParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleModel96);
                    ruleTest();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:73:3: ( (lv_test_1_0= ruleParenthesis ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:73:3: ( (lv_test_1_0= ruleParenthesis ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:74:4: (lv_test_1_0= ruleParenthesis )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:74:4: (lv_test_1_0= ruleParenthesis )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:75:5: lv_test_1_0= ruleParenthesis
                    {

                    					markComposite(elementTypeProvider.getModel_TestParenthesisParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_ruleModel142);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:88:1: entryRuleParenthesis : ruleParenthesis EOF ;
    public final void entryRuleParenthesis() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:88:21: ( ruleParenthesis EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:89:2: ruleParenthesis EOF
            {
             markComposite(elementTypeProvider.getParenthesisElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParenthesis_in_entryRuleParenthesis173);
            ruleParenthesis();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParenthesis179); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:97:1: ruleParenthesis : (otherlv_0= '(' ruleTest otherlv_2= ')' ) ;
    public final void ruleParenthesis() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:97:16: ( (otherlv_0= '(' ruleTest otherlv_2= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:98:2: (otherlv_0= '(' ruleTest otherlv_2= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:98:2: (otherlv_0= '(' ruleTest otherlv_2= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:99:3: otherlv_0= '(' ruleTest otherlv_2= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleParenthesis202); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParenthesis_LeftParenthesisKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getParenthesis_TestParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_ruleParenthesis214);
            ruleTest();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleParenthesis228); 

            			doneLeaf(otherlv_2, elementTypeProvider.getParenthesis_RightParenthesisKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:124:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:124:14: ( ruleTest EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:125:2: ruleTest EOF
            {
             markComposite(elementTypeProvider.getTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_entryRuleTest248);
            ruleTest();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTest254); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:133:1: ruleTest : ( ruleTwoRequired | ruleTwoOptions | ruleIndent ) ;
    public final void ruleTest() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:133:9: ( ( ruleTwoRequired | ruleTwoOptions | ruleIndent ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:134:2: ( ruleTwoRequired | ruleTwoOptions | ruleIndent )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:134:2: ( ruleTwoRequired | ruleTwoOptions | ruleIndent )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:135:3: ruleTwoRequired
                    {

                    			markComposite(elementTypeProvider.getTest_TwoRequiredParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_ruleTest275);
                    ruleTwoRequired();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:143:3: ruleTwoOptions
                    {

                    			markComposite(elementTypeProvider.getTest_TwoOptionsParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_ruleTest295);
                    ruleTwoOptions();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:151:3: ruleIndent
                    {

                    			markComposite(elementTypeProvider.getTest_IndentParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleIndent_in_ruleTest315);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:162:1: entryRuleTwoRequired : ruleTwoRequired EOF ;
    public final void entryRuleTwoRequired() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:162:21: ( ruleTwoRequired EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:163:2: ruleTwoRequired EOF
            {
             markComposite(elementTypeProvider.getTwoRequiredElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired335);
            ruleTwoRequired();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoRequired341); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:171:1: ruleTwoRequired : (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) ;
    public final void ruleTwoRequired() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_one_1_0=null;
        Token lv_two_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:171:16: ( (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:172:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:172:2: (otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:173:3: otherlv_0= 'tworequired' ( (lv_one_1_0= RULE_ID ) ) ( (lv_two_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTwoRequired364); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTwoRequired_TworequiredKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:180:3: ( (lv_one_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:181:4: (lv_one_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:181:4: (lv_one_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:182:5: lv_one_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_one_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoRequired391); 

            					doneLeaf(lv_one_1_0, elementTypeProvider.getTwoRequired_OneIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:191:3: ( (lv_two_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:192:4: (lv_two_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:192:4: (lv_two_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:193:5: lv_two_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_two_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoRequired429); 

            					doneLeaf(lv_two_2_0, elementTypeProvider.getTwoRequired_TwoIDTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:206:1: entryRuleTwoOptions : ruleTwoOptions EOF ;
    public final void entryRuleTwoOptions() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:206:20: ( ruleTwoOptions EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:207:2: ruleTwoOptions EOF
            {
             markComposite(elementTypeProvider.getTwoOptionsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions460);
            ruleTwoOptions();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoOptions466); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:215:1: ruleTwoOptions : (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) ;
    public final void ruleTwoOptions() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_one_2_0=null;
        Token otherlv_3=null;
        Token lv_two_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:215:15: ( (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:216:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:216:2: (otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:217:3: otherlv_0= 'twooptions' ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTwoOptions489); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTwoOptions_TwooptionsKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:224:3: ( (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) ) | (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:225:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:225:4: (otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:226:5: otherlv_1= 'one' ( (lv_one_2_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTwoOptions516); 

                    					doneLeaf(otherlv_1, elementTypeProvider.getTwoOptions_OneKeyword_1_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:233:5: ( (lv_one_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:234:6: (lv_one_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:234:6: (lv_one_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:235:7: lv_one_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_one_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoOptions553); 

                    							doneLeaf(lv_one_2_0, elementTypeProvider.getTwoOptions_OneIDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:246:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:246:4: (otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:247:5: otherlv_3= 'two' ( (lv_two_4_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTwoOptions607); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getTwoOptions_TwoKeyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:254:5: ( (lv_two_4_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:255:6: (lv_two_4_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:255:6: (lv_two_4_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:256:7: lv_two_4_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_two_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTwoOptions644); 

                    							doneLeaf(lv_two_4_0, elementTypeProvider.getTwoOptions_TwoIDTerminalRuleCall_1_1_1_0ElementType());
                    						

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:271:1: entryRuleIndent : ruleIndent EOF ;
    public final void entryRuleIndent() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:271:16: ( ruleIndent EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:272:2: ruleIndent EOF
            {
             markComposite(elementTypeProvider.getIndentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndent_in_entryRuleIndent690);
            ruleIndent();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIndent696); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:280:1: ruleIndent : (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) ;
    public final void ruleIndent() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:280:11: ( (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:281:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:281:2: (otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:282:3: otherlv_0= '{' ( (lv_req_1_0= ruleTwoRequired ) )? ( (lv_opt_2_0= ruleTwoOptions ) )? ( (lv_indent_3_0= ruleIndent ) )* otherlv_4= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleIndent719); 

            			doneLeaf(otherlv_0, elementTypeProvider.getIndent_LeftCurlyBracketKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:289:3: ( (lv_req_1_0= ruleTwoRequired ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:290:4: (lv_req_1_0= ruleTwoRequired )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:290:4: (lv_req_1_0= ruleTwoRequired )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:291:5: lv_req_1_0= ruleTwoRequired
                    {

                    					markComposite(elementTypeProvider.getIndent_ReqTwoRequiredParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleTwoRequired_in_ruleIndent746);
                    ruleTwoRequired();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:300:3: ( (lv_opt_2_0= ruleTwoOptions ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:301:4: (lv_opt_2_0= ruleTwoOptions )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:301:4: (lv_opt_2_0= ruleTwoOptions )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:302:5: lv_opt_2_0= ruleTwoOptions
                    {

                    					markComposite(elementTypeProvider.getIndent_OptTwoOptionsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleTwoOptions_in_ruleIndent785);
                    ruleTwoOptions();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:311:3: ( (lv_indent_3_0= ruleIndent ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:312:4: (lv_indent_3_0= ruleIndent )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:312:4: (lv_indent_3_0= ruleIndent )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSerializationErrorTestLanguage.g:313:5: lv_indent_3_0= ruleIndent
            	    {

            	    					markComposite(elementTypeProvider.getIndent_IndentIndentParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleIndent_in_ruleIndent824);
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


            			markLeaf();
            		
            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleIndent850); 

            			doneLeaf(otherlv_4, elementTypeProvider.getIndent_RightCurlyBracketKeyword_4ElementType());
            		

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_ruleModel96 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParenthesis_in_entryRuleParenthesis173 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParenthesis179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParenthesis202 = new BitSet(new long[]{0x0000000000026000L});
        public static final BitSet FOLLOW_ruleTest_in_ruleParenthesis214 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleParenthesis228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_entryRuleTest248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTest254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_ruleTest275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_ruleTest295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndent_in_ruleTest315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_entryRuleTwoRequired335 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoRequired341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleTwoRequired364 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired391 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoRequired429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_entryRuleTwoOptions460 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoOptions466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleTwoOptions489 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_15_in_ruleTwoOptions516 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleTwoOptions607 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTwoOptions644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndent_in_entryRuleIndent690 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIndent696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleIndent719 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_ruleTwoRequired_in_ruleIndent746 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_ruleTwoOptions_in_ruleIndent785 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_ruleIndent_in_ruleIndent824 = new BitSet(new long[]{0x0000000000066000L});
        public static final BitSet FOLLOW_18_in_ruleIndent850 = new BitSet(new long[]{0x0000000000000002L});
    }


}