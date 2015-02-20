package org.eclipse.xtext.parsetree.formatter.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalElementMatcherTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'kw1'", "'.'", "'#2'", "'sub'", "'ass1'", "'ass2'", "'#3'", "'sub2'", "'sub3'", "'#4'", "'{'", "'}'", "';'", "'#5'", "'gr'", "'#6'", "'+'", "'*'", "'('", "','", "')'", "'=>'", "'#7'", "'kw3'", "'kw2'", "'#8'"
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
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalElementMatcherTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalElementMatcherTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalElementMatcherTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g"; }



    	protected ElementMatcherTestLanguageGrammarAccess grammarAccess;

    	protected ElementMatcherTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalElementMatcherTestLanguageParser(PsiBuilder builder, TokenStream input, ElementMatcherTestLanguageElementTypeProvider elementTypeProvider, ElementMatcherTestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:59:1: ruleModel : ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:59:10: ( ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:60:2: ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:60:2: ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 14:
                {
                alt1=2;
                }
                break;
            case 18:
                {
                alt1=3;
                }
                break;
            case 21:
                {
                alt1=4;
                }
                break;
            case 25:
                {
                alt1=5;
                }
                break;
            case 27:
                {
                alt1=6;
                }
                break;
            case 34:
                {
                alt1=7;
                }
                break;
            case 37:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:61:3: ruleSimple
                    {

                    			markComposite(elementTypeProvider.getModel_SimpleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleModel77);
                    ruleSimple();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:69:3: ruleRuleCalls
                    {

                    			markComposite(elementTypeProvider.getModel_RuleCallsParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_ruleModel97);
                    ruleRuleCalls();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:77:3: ruleOptionalCalls
                    {

                    			markComposite(elementTypeProvider.getModel_OptionalCallsParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_ruleModel117);
                    ruleOptionalCalls();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:85:3: ruleRecursion
                    {

                    			markComposite(elementTypeProvider.getModel_RecursionParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_ruleModel137);
                    ruleRecursion();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:93:3: ruleLoop
                    {

                    			markComposite(elementTypeProvider.getModel_LoopParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLoop_in_ruleModel157);
                    ruleLoop();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:101:3: ruleExpression
                    {

                    			markComposite(elementTypeProvider.getModel_ExpressionParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel177);
                    ruleExpression();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:109:3: ruleRuleCalls12
                    {

                    			markComposite(elementTypeProvider.getModel_RuleCalls12ParserRuleCall_6ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls12_in_ruleModel197);
                    ruleRuleCalls12();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:117:3: ruleNestedStart
                    {

                    			markComposite(elementTypeProvider.getModel_NestedStartParserRuleCall_7ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleNestedStart_in_ruleModel217);
                    ruleNestedStart();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSimple"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:128:1: entryRuleSimple : ruleSimple EOF ;
    public final void entryRuleSimple() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:128:16: ( ruleSimple EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:129:2: ruleSimple EOF
            {
             markComposite(elementTypeProvider.getSimpleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple237);
            ruleSimple();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple243); 

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
    // $ANTLR end "entryRuleSimple"


    // $ANTLR start "ruleSimple"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:135:1: ruleSimple : (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) ;
    public final void ruleSimple() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_optional_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:135:11: ( (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:136:2: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:136:2: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:137:3: otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSimple262); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSimple_NumberSignDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:144:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:145:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:145:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:146:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple289); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:155:3: (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:156:4: otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple320); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getSimple_Kw1Keyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:163:4: ( (lv_optional_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:164:5: (lv_optional_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:164:5: (lv_optional_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:165:6: lv_optional_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_optional_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple352); 

                    						doneLeaf(lv_optional_3_0, elementTypeProvider.getSimple_OptionalIDTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:175:3: ( (lv_datatype_4_0= ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:176:4: (lv_datatype_4_0= ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:176:4: (lv_datatype_4_0= ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:177:5: lv_datatype_4_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getSimple_DatatypeFQNParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSimple398);
            ruleFQN();

            state._fsp--;


            					doneComposite();
            				

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
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleFQN"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:190:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:190:13: ( ruleFQN EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:191:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN429);
            ruleFQN();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN435); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:197:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:197:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:198:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:198:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:199:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN454); 

            			doneLeaf(this_ID_0, elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:206:3: (kw= '.' this_ID_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:207:4: kw= '.' this_ID_2= RULE_ID
            {

            				markLeaf();
            			
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleFQN474); 

            				doneLeaf(kw, elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            			

            				markLeaf();
            			
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN491); 

            				doneLeaf(this_ID_2, elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            			

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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleRuleCalls"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:226:1: entryRuleRuleCalls : ruleRuleCalls EOF ;
    public final void entryRuleRuleCalls() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:226:19: ( ruleRuleCalls EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:227:2: ruleRuleCalls EOF
            {
             markComposite(elementTypeProvider.getRuleCallsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls516);
            ruleRuleCalls();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls522); 

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
    // $ANTLR end "entryRuleRuleCalls"


    // $ANTLR start "ruleRuleCalls"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:233:1: ruleRuleCalls : (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) ;
    public final void ruleRuleCalls() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:233:14: ( (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:234:2: (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:234:2: (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:235:3: otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleCalls541); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRuleCalls_NumberSignDigitTwoKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getRuleCalls_RuleCallsSubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls553);
            ruleRuleCallsSub();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:249:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:250:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:250:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:251:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCalls580); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getRuleCalls_NameIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:260:3: ( (lv_call1_3_0= ruleRuleCallsAss1 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:261:4: (lv_call1_3_0= ruleRuleCallsAss1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:261:4: (lv_call1_3_0= ruleRuleCallsAss1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:262:5: lv_call1_3_0= ruleRuleCallsAss1
                    {

                    					markComposite(elementTypeProvider.getRuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls618);
                    ruleRuleCallsAss1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:271:3: ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:272:4: (lv_call2_4_0= ruleRuleCallsAss2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:272:4: (lv_call2_4_0= ruleRuleCallsAss2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:273:5: lv_call2_4_0= ruleRuleCallsAss2
                    {

                    					markComposite(elementTypeProvider.getRuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls657);
                    ruleRuleCallsAss2();

                    state._fsp--;


                    					doneComposite();
                    				

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
    // $ANTLR end "ruleRuleCalls"


    // $ANTLR start "entryRuleRuleCallsSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:286:1: entryRuleRuleCallsSub : ruleRuleCallsSub EOF ;
    public final void entryRuleRuleCallsSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:286:22: ( ruleRuleCallsSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:287:2: ruleRuleCallsSub EOF
            {
             markComposite(elementTypeProvider.getRuleCallsSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub689);
            ruleRuleCallsSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsSub695); 

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
    // $ANTLR end "entryRuleRuleCallsSub"


    // $ANTLR start "ruleRuleCallsSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:293:1: ruleRuleCallsSub : ( (lv_sub_0_0= 'sub' ) ) ;
    public final void ruleRuleCallsSub() throws RecognitionException {
        Token lv_sub_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:293:17: ( ( (lv_sub_0_0= 'sub' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:294:2: ( (lv_sub_0_0= 'sub' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:294:2: ( (lv_sub_0_0= 'sub' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:295:3: (lv_sub_0_0= 'sub' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:295:3: (lv_sub_0_0= 'sub' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:296:4: lv_sub_0_0= 'sub'
            {

            				markLeaf();
            			
            lv_sub_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleCallsSub720); 

            				doneLeaf(lv_sub_0_0, elementTypeProvider.getRuleCallsSub_SubSubKeyword_0ElementType());
            			

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
    // $ANTLR end "ruleRuleCallsSub"


    // $ANTLR start "entryRuleRuleCallsAss1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:308:1: entryRuleRuleCallsAss1 : ruleRuleCallsAss1 EOF ;
    public final void entryRuleRuleCallsAss1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:308:23: ( ruleRuleCallsAss1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:309:2: ruleRuleCallsAss1 EOF
            {
             markComposite(elementTypeProvider.getRuleCallsAss1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1745);
            ruleRuleCallsAss1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss1751); 

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
    // $ANTLR end "entryRuleRuleCallsAss1"


    // $ANTLR start "ruleRuleCallsAss1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:315:1: ruleRuleCallsAss1 : (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleRuleCallsAss1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:315:18: ( (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:316:2: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:316:2: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:317:3: otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleCallsAss1770); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRuleCallsAss1_Ass1Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:324:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:325:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:325:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:326:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss1797); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getRuleCallsAss1_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleRuleCallsAss1"


    // $ANTLR start "entryRuleRuleCallsAss2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:339:1: entryRuleRuleCallsAss2 : ruleRuleCallsAss2 EOF ;
    public final void entryRuleRuleCallsAss2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:339:23: ( ruleRuleCallsAss2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:340:2: ruleRuleCallsAss2 EOF
            {
             markComposite(elementTypeProvider.getRuleCallsAss2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2828);
            ruleRuleCallsAss2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss2834); 

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
    // $ANTLR end "entryRuleRuleCallsAss2"


    // $ANTLR start "ruleRuleCallsAss2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:346:1: ruleRuleCallsAss2 : (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleRuleCallsAss2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:346:18: ( (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:347:2: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:347:2: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:348:3: otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallsAss2853); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRuleCallsAss2_Ass2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:355:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:356:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:356:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:357:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss2880); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getRuleCallsAss2_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleRuleCallsAss2"


    // $ANTLR start "entryRuleOptionalCalls"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:370:1: entryRuleOptionalCalls : ruleOptionalCalls EOF ;
    public final void entryRuleOptionalCalls() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:370:23: ( ruleOptionalCalls EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:371:2: ruleOptionalCalls EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls911);
            ruleOptionalCalls();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCalls917); 

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
    // $ANTLR end "entryRuleOptionalCalls"


    // $ANTLR start "ruleOptionalCalls"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:377:1: ruleOptionalCalls : (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final void ruleOptionalCalls() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:377:18: ( (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:378:2: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:378:2: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:379:3: otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOptionalCalls936); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalCalls_NumberSignDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:386:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:387:4: 
            {

            				precedeComposite(elementTypeProvider.getOptionalCalls_OptionalCallsAction_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:392:3: ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:393:4: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:393:4: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:394:5: lv_opt1_2_0= ruleOptionalCallsSub1
                    {

                    					markComposite(elementTypeProvider.getOptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls976);
                    ruleOptionalCallsSub1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:403:3: ( (lv_name_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:404:4: (lv_name_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:404:4: (lv_name_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:405:5: lv_name_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCalls1015); 

            					doneLeaf(lv_name_3_0, elementTypeProvider.getOptionalCalls_NameIDTerminalRuleCall_3_0ElementType());
            				

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
    // $ANTLR end "ruleOptionalCalls"


    // $ANTLR start "entryRuleOptionalCallsSub1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:418:1: entryRuleOptionalCallsSub1 : ruleOptionalCallsSub1 EOF ;
    public final void entryRuleOptionalCallsSub1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:418:27: ( ruleOptionalCallsSub1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:419:2: ruleOptionalCallsSub1 EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsSub1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11046);
            ruleOptionalCallsSub1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub11052); 

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
    // $ANTLR end "entryRuleOptionalCallsSub1"


    // $ANTLR start "ruleOptionalCallsSub1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:425:1: ruleOptionalCallsSub1 : ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) ;
    public final void ruleOptionalCallsSub1() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:425:22: ( ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:426:2: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:426:2: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:427:3: () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:427:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:428:4: 
            {

            				precedeComposite(elementTypeProvider.getOptionalCallsSub1_OptionalCallsSub1Action_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:433:3: ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:434:4: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:434:4: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:435:5: lv_opt2_1_0= ruleOptionalCallsSub2
                    {

                    					markComposite(elementTypeProvider.getOptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11097);
                    ruleOptionalCallsSub2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOptionalCallsSub11123); 

            			doneLeaf(otherlv_2, elementTypeProvider.getOptionalCallsSub1_SubKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:451:3: ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:452:4: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:452:4: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:453:5: lv_opt3_3_0= ruleOptionalCallsSub3
                    {

                    					markComposite(elementTypeProvider.getOptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11150);
                    ruleOptionalCallsSub3();

                    state._fsp--;


                    					doneComposite();
                    				

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
    // $ANTLR end "ruleOptionalCallsSub1"


    // $ANTLR start "entryRuleOptionalCallsSub2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:466:1: entryRuleOptionalCallsSub2 : ruleOptionalCallsSub2 EOF ;
    public final void entryRuleOptionalCallsSub2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:466:27: ( ruleOptionalCallsSub2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:467:2: ruleOptionalCallsSub2 EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsSub2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21182);
            ruleOptionalCallsSub2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub21188); 

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
    // $ANTLR end "entryRuleOptionalCallsSub2"


    // $ANTLR start "ruleOptionalCallsSub2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:473:1: ruleOptionalCallsSub2 : (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleOptionalCallsSub2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:473:22: ( (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:474:2: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:474:2: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:475:3: otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOptionalCallsSub21207); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalCallsSub2_Sub2Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:482:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:483:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:483:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:484:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub21234); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getOptionalCallsSub2_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleOptionalCallsSub2"


    // $ANTLR start "entryRuleOptionalCallsSub3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:497:1: entryRuleOptionalCallsSub3 : ruleOptionalCallsSub3 EOF ;
    public final void entryRuleOptionalCallsSub3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:497:27: ( ruleOptionalCallsSub3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:498:2: ruleOptionalCallsSub3 EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsSub3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31265);
            ruleOptionalCallsSub3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub31271); 

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
    // $ANTLR end "entryRuleOptionalCallsSub3"


    // $ANTLR start "ruleOptionalCallsSub3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:504:1: ruleOptionalCallsSub3 : (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleOptionalCallsSub3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:504:22: ( (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:505:2: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:505:2: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:506:3: otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOptionalCallsSub31290); 

            			doneLeaf(otherlv_0, elementTypeProvider.getOptionalCallsSub3_Sub3Keyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:513:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:514:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:514:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:515:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub31317); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getOptionalCallsSub3_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleOptionalCallsSub3"


    // $ANTLR start "entryRuleRecursion"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:528:1: entryRuleRecursion : ruleRecursion EOF ;
    public final void entryRuleRecursion() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:528:19: ( ruleRecursion EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:529:2: ruleRecursion EOF
            {
             markComposite(elementTypeProvider.getRecursionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_entryRuleRecursion1348);
            ruleRecursion();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursion1354); 

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
    // $ANTLR end "entryRuleRecursion"


    // $ANTLR start "ruleRecursion"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:535:1: ruleRecursion : (otherlv_0= '#4' ruleRecursionSub ) ;
    public final void ruleRecursion() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:535:14: ( (otherlv_0= '#4' ruleRecursionSub ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:536:2: (otherlv_0= '#4' ruleRecursionSub )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:536:2: (otherlv_0= '#4' ruleRecursionSub )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:537:3: otherlv_0= '#4' ruleRecursionSub
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRecursion1373); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRecursion_NumberSignDigitFourKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getRecursion_RecursionSubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursion1385);
            ruleRecursionSub();

            state._fsp--;


            			doneComposite();
            		

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
    // $ANTLR end "ruleRecursion"


    // $ANTLR start "entryRuleRecursionSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:555:1: entryRuleRecursionSub : ruleRecursionSub EOF ;
    public final void entryRuleRecursionSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:555:22: ( ruleRecursionSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:556:2: ruleRecursionSub EOF
            {
             markComposite(elementTypeProvider.getRecursionSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1405);
            ruleRecursionSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursionSub1411); 

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
    // $ANTLR end "entryRuleRecursionSub"


    // $ANTLR start "ruleRecursionSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:562:1: ruleRecursionSub : ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final void ruleRecursionSub() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_vals_3_0=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:562:17: ( ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:563:2: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:563:2: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:564:3: () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:564:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:565:4: 
            {

            				precedeComposite(elementTypeProvider.getRecursionSub_RecursionSubAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRecursionSub1443); 

            			doneLeaf(otherlv_1, elementTypeProvider.getRecursionSub_LeftCurlyBracketKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:577:3: ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }
                else if ( (LA8_0==RULE_ID) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:578:4: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:578:4: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:579:5: (lv_sub_2_0= ruleRecursionSub )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:579:5: (lv_sub_2_0= ruleRecursionSub )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:580:6: lv_sub_2_0= ruleRecursionSub
            	    {

            	    						markComposite(elementTypeProvider.getRecursionSub_SubRecursionSubParserRuleCall_2_0_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursionSub1478);
            	    ruleRecursionSub();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:590:4: ( (lv_vals_3_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:590:4: ( (lv_vals_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:591:5: (lv_vals_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:591:5: (lv_vals_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:592:6: lv_vals_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_vals_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecursionSub1532); 

            	    						doneLeaf(lv_vals_3_0, elementTypeProvider.getRecursionSub_ValsIDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRecursionSub1565); 

            			doneLeaf(otherlv_4, elementTypeProvider.getRecursionSub_RightCurlyBracketKeyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:609:3: ( (lv_semi_5_0= ';' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:610:4: (lv_semi_5_0= ';' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:610:4: (lv_semi_5_0= ';' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:611:5: lv_semi_5_0= ';'
                    {

                    					markLeaf();
                    				
                    lv_semi_5_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRecursionSub1592); 

                    					doneLeaf(lv_semi_5_0, elementTypeProvider.getRecursionSub_SemiSemicolonKeyword_4_0ElementType());
                    				

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
    // $ANTLR end "ruleRecursionSub"


    // $ANTLR start "entryRuleLoop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:624:1: entryRuleLoop : ruleLoop EOF ;
    public final void entryRuleLoop() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:624:14: ( ruleLoop EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:625:2: ruleLoop EOF
            {
             markComposite(elementTypeProvider.getLoopElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop_in_entryRuleLoop1624);
            ruleLoop();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop1630); 

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
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:631:1: ruleLoop : (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) ;
    public final void ruleLoop() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_names_1_0=null;
        Token otherlv_2=null;
        Token lv_gr_3_0=null;
        Token lv_ints_4_0=null;
        Token lv_strings_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:631:9: ( (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:632:2: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:632:2: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:633:3: otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop1649); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLoop_NumberSignDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:640:3: ( (lv_names_1_0= RULE_ID ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:641:4: (lv_names_1_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:641:4: (lv_names_1_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:642:5: lv_names_1_0= RULE_ID
            	    {

            	    					markLeaf();
            	    				
            	    lv_names_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1676); 

            	    					doneLeaf(lv_names_1_0, elementTypeProvider.getLoop_NamesIDTerminalRuleCall_1_0ElementType());
            	    				

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:651:3: (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:652:4: otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop1708); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getLoop_GrKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:659:4: ( (lv_gr_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:660:5: (lv_gr_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:660:5: (lv_gr_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:661:6: lv_gr_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_gr_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1740); 

            	    						doneLeaf(lv_gr_3_0, elementTypeProvider.getLoop_GrIDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:671:3: ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_INT) ) {
                    alt12=1;
                }
                else if ( (LA12_0==RULE_STRING) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:672:4: ( (lv_ints_4_0= RULE_INT ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:672:4: ( (lv_ints_4_0= RULE_INT ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:673:5: (lv_ints_4_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:673:5: (lv_ints_4_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:674:6: lv_ints_4_0= RULE_INT
            	    {

            	    						markLeaf();
            	    					
            	    lv_ints_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLoop1794); 

            	    						doneLeaf(lv_ints_4_0, elementTypeProvider.getLoop_IntsINTTerminalRuleCall_3_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:684:4: ( (lv_strings_5_0= RULE_STRING ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:684:4: ( (lv_strings_5_0= RULE_STRING ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:685:5: (lv_strings_5_0= RULE_STRING )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:685:5: (lv_strings_5_0= RULE_STRING )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:686:6: lv_strings_5_0= RULE_STRING
            	    {

            	    						markLeaf();
            	    					
            	    lv_strings_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLoop1848); 

            	    						doneLeaf(lv_strings_5_0, elementTypeProvider.getLoop_StringsSTRINGTerminalRuleCall_3_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleExpression"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:700:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:700:20: ( ruleExpression EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:701:2: ruleExpression EOF
            {
             markComposite(elementTypeProvider.getExpressionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression1887);
            ruleExpression();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression1893); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:707:1: ruleExpression : (otherlv_0= '#6' ruleAdd ) ;
    public final void ruleExpression() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:707:15: ( (otherlv_0= '#6' ruleAdd ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:708:2: (otherlv_0= '#6' ruleAdd )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:708:2: (otherlv_0= '#6' ruleAdd )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:709:3: otherlv_0= '#6' ruleAdd
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleExpression1912); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExpression_NumberSignDigitSixKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getExpression_AddParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_ruleExpression1924);
            ruleAdd();

            state._fsp--;


            			doneComposite();
            		

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAdd"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:727:1: entryRuleAdd : ruleAdd EOF ;
    public final void entryRuleAdd() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:727:13: ( ruleAdd EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:728:2: ruleAdd EOF
            {
             markComposite(elementTypeProvider.getAddElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_entryRuleAdd1944);
            ruleAdd();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdd1950); 

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
    // $ANTLR end "entryRuleAdd"


    // $ANTLR start "ruleAdd"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:734:1: ruleAdd : ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) ;
    public final void ruleAdd() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:734:8: ( ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:735:2: ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:735:2: ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:736:3: ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            {

            			markComposite(elementTypeProvider.getAdd_MultParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd1967);
            ruleMult();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:743:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:744:4: () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:744:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:745:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAdd_AddLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAdd2003); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getAdd_PlusSignKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:757:4: ( (lv_right_3_0= ruleMult ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:758:5: (lv_right_3_0= ruleMult )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:758:5: (lv_right_3_0= ruleMult )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:759:6: lv_right_3_0= ruleMult
            	    {

            	    						markComposite(elementTypeProvider.getAdd_RightMultParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd2035);
            	    ruleMult();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleAdd"


    // $ANTLR start "entryRuleMult"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:773:1: entryRuleMult : ruleMult EOF ;
    public final void entryRuleMult() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:773:14: ( ruleMult EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:774:2: ruleMult EOF
            {
             markComposite(elementTypeProvider.getMultElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_entryRuleMult2074);
            ruleMult();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMult2080); 

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
    // $ANTLR end "entryRuleMult"


    // $ANTLR start "ruleMult"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:780:1: ruleMult : ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) ;
    public final void ruleMult() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:780:9: ( ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:781:2: ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:781:2: ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:782:3: rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            {

            			markComposite(elementTypeProvider.getMult_PrimParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2097);
            rulePrim();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:789:3: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:790:4: () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:790:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:791:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMult_MultLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMult2133); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getMult_AsteriskKeyword_1_1ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:803:4: ( (lv_right_3_0= rulePrim ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:804:5: (lv_right_3_0= rulePrim )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:804:5: (lv_right_3_0= rulePrim )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:805:6: lv_right_3_0= rulePrim
            	    {

            	    						markComposite(elementTypeProvider.getMult_RightPrimParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2165);
            	    rulePrim();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


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
    // $ANTLR end "ruleMult"


    // $ANTLR start "entryRulePrim"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:819:1: entryRulePrim : rulePrim EOF ;
    public final void entryRulePrim() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:819:14: ( rulePrim EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:820:2: rulePrim EOF
            {
             markComposite(elementTypeProvider.getPrimElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_entryRulePrim2204);
            rulePrim();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim2210); 

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
    // $ANTLR end "entryRulePrim"


    // $ANTLR start "rulePrim"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:826:1: rulePrim : ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) ) ;
    public final void rulePrim() throws RecognitionException {
        Token lv_val_1_0=null;
        Token lv_func_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:826:9: ( ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:827:2: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:827:2: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
                {
                alt16=2;
                }
                break;
            case 33:
                {
                alt16=3;
                }
                break;
            case 30:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:828:3: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:828:3: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:829:4: () ( (lv_val_1_0= RULE_INT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:829:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:830:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim_ValueAction_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:835:4: ( (lv_val_1_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:836:5: (lv_val_1_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:836:5: (lv_val_1_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:837:6: lv_val_1_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePrim2266); 

                    						doneLeaf(lv_val_1_0, elementTypeProvider.getPrim_ValINTTerminalRuleCall_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:848:3: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:848:3: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:849:4: () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')'
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:849:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:850:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim_FunctionAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:855:4: ( (lv_func_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:856:5: (lv_func_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:856:5: (lv_func_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:857:6: lv_func_3_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_func_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim2343); 

                    						doneLeaf(lv_func_3_0, elementTypeProvider.getPrim_FuncIDTerminalRuleCall_1_1_0ElementType());
                    					

                    }


                    }


                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2373); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getPrim_LeftParenthesisKeyword_1_2ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:873:4: ( (lv_param_5_0= ruleAdd ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:874:5: (lv_param_5_0= ruleAdd )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:874:5: (lv_param_5_0= ruleAdd )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:875:6: lv_param_5_0= ruleAdd
                    {

                    						markComposite(elementTypeProvider.getPrim_ParamAddParserRuleCall_1_3_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2405);
                    ruleAdd();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:884:4: (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==31) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:885:5: otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_rulePrim2442); 

                    	    					doneLeaf(otherlv_6, elementTypeProvider.getPrim_CommaKeyword_1_4_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:892:5: ( (lv_param_7_0= ruleAdd ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:893:6: (lv_param_7_0= ruleAdd )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:893:6: (lv_param_7_0= ruleAdd )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:894:7: lv_param_7_0= ruleAdd
                    	    {

                    	    							markComposite(elementTypeProvider.getPrim_ParamAddParserRuleCall_1_4_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2479);
                    	    ruleAdd();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2518); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getPrim_RightParenthesisKeyword_1_5ElementType());
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:913:3: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:913:3: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:914:4: () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:914:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:915:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim_PointerAction_2_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,33,FollowSets000.FOLLOW_33_in_rulePrim2567); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getPrim_EqualsSignGreaterThanSignKeyword_2_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:927:4: ( (lv_target_11_0= rulePrim ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:928:5: (lv_target_11_0= rulePrim )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:928:5: (lv_target_11_0= rulePrim )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:929:6: lv_target_11_0= rulePrim
                    {

                    						markComposite(elementTypeProvider.getPrim_TargetPrimParserRuleCall_2_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_rulePrim_in_rulePrim2599);
                    rulePrim();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:940:3: (otherlv_12= '(' ruleAdd otherlv_14= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:940:3: (otherlv_12= '(' ruleAdd otherlv_14= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:941:4: otherlv_12= '(' ruleAdd otherlv_14= ')'
                    {

                    				markLeaf();
                    			
                    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2645); 

                    				doneLeaf(otherlv_12, elementTypeProvider.getPrim_LeftParenthesisKeyword_3_0ElementType());
                    			

                    				markComposite(elementTypeProvider.getPrim_AddParserRuleCall_3_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2660);
                    ruleAdd();

                    state._fsp--;


                    				doneComposite();
                    			

                    				markLeaf();
                    			
                    otherlv_14=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2677); 

                    				doneLeaf(otherlv_14, elementTypeProvider.getPrim_RightParenthesisKeyword_3_2ElementType());
                    			

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
    // $ANTLR end "rulePrim"


    // $ANTLR start "entryRuleRuleCalls12"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:967:1: entryRuleRuleCalls12 : ruleRuleCalls12 EOF ;
    public final void entryRuleRuleCalls12() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:967:21: ( ruleRuleCalls12 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:968:2: ruleRuleCalls12 EOF
            {
             markComposite(elementTypeProvider.getRuleCalls12ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls12_in_entryRuleRuleCalls122702);
            ruleRuleCalls12();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls122708); 

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
    // $ANTLR end "entryRuleRuleCalls12"


    // $ANTLR start "ruleRuleCalls12"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:974:1: ruleRuleCalls12 : (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) ;
    public final void ruleRuleCalls12() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:974:16: ( (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:975:2: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:975:2: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:976:3: otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRuleCalls122727); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRuleCalls12_NumberSignDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:983:3: ( (lv_constructor_1_0= ruleConstructor ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:984:4: (lv_constructor_1_0= ruleConstructor )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:984:4: (lv_constructor_1_0= ruleConstructor )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:985:5: lv_constructor_1_0= ruleConstructor
            {

            					markComposite(elementTypeProvider.getRuleCalls12_ConstructorConstructorParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleConstructor_in_ruleRuleCalls122754);
            ruleConstructor();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:994:3: ( (lv_fields_2_0= ruleField ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:995:4: (lv_fields_2_0= ruleField )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:995:4: (lv_fields_2_0= ruleField )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:996:5: lv_fields_2_0= ruleField
            {

            					markComposite(elementTypeProvider.getRuleCalls12_FieldsFieldParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleField_in_ruleRuleCalls122792);
            ruleField();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRuleCalls122817); 

            			doneLeaf(otherlv_3, elementTypeProvider.getRuleCalls12_Kw3Keyword_3ElementType());
            		

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
    // $ANTLR end "ruleRuleCalls12"


    // $ANTLR start "entryRuleConstructor"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1016:1: entryRuleConstructor : ruleConstructor EOF ;
    public final void entryRuleConstructor() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1016:21: ( ruleConstructor EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1017:2: ruleConstructor EOF
            {
             markComposite(elementTypeProvider.getConstructorElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstructor_in_entryRuleConstructor2837);
            ruleConstructor();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructor2843); 

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
    // $ANTLR end "entryRuleConstructor"


    // $ANTLR start "ruleConstructor"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1023:1: ruleConstructor : ( () ( (lv_kw1_1_0= 'kw1' ) )? ) ;
    public final void ruleConstructor() throws RecognitionException {
        Token lv_kw1_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1023:16: ( ( () ( (lv_kw1_1_0= 'kw1' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1024:2: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1024:2: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1025:3: () ( (lv_kw1_1_0= 'kw1' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1025:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1026:4: 
            {

            				precedeComposite(elementTypeProvider.getConstructor_ConstructorAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1031:3: ( (lv_kw1_1_0= 'kw1' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==12) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1032:4: (lv_kw1_1_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1032:4: (lv_kw1_1_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1033:5: lv_kw1_1_0= 'kw1'
                    {

                    					markLeaf();
                    				
                    lv_kw1_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConstructor2888); 

                    					doneLeaf(lv_kw1_1_0, elementTypeProvider.getConstructor_Kw1Kw1Keyword_1_0ElementType());
                    				

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
    // $ANTLR end "ruleConstructor"


    // $ANTLR start "entryRuleField"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1046:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1046:15: ( ruleField EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1047:2: ruleField EOF
            {
             markComposite(elementTypeProvider.getFieldElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleField_in_entryRuleField2920);
            ruleField();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleField2926); 

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
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1053:1: ruleField : (this_ID_0= RULE_ID ruleParameter ) ;
    public final void ruleField() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1053:10: ( (this_ID_0= RULE_ID ruleParameter ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1054:2: (this_ID_0= RULE_ID ruleParameter )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1054:2: (this_ID_0= RULE_ID ruleParameter )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1055:3: this_ID_0= RULE_ID ruleParameter
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleField2945); 

            			doneLeaf(this_ID_0, elementTypeProvider.getField_IDTerminalRuleCall_0ElementType());
            		

            			markComposite(elementTypeProvider.getField_ParameterParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleField2957);
            ruleParameter();

            state._fsp--;


            			doneComposite();
            		

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
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleParameter"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1073:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1073:19: ( ruleParameter EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1074:2: ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter2977);
            ruleParameter();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter2983); 

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1080:1: ruleParameter : ( () ( (lv_kw2_1_0= 'kw2' ) )? ) ;
    public final void ruleParameter() throws RecognitionException {
        Token lv_kw2_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1080:14: ( ( () ( (lv_kw2_1_0= 'kw2' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1081:2: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1081:2: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1082:3: () ( (lv_kw2_1_0= 'kw2' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1082:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1083:4: 
            {

            				precedeComposite(elementTypeProvider.getParameter_ParameterAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1088:3: ( (lv_kw2_1_0= 'kw2' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1089:4: (lv_kw2_1_0= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1089:4: (lv_kw2_1_0= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1090:5: lv_kw2_1_0= 'kw2'
                    {

                    					markLeaf();
                    				
                    lv_kw2_1_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleParameter3028); 

                    					doneLeaf(lv_kw2_1_0, elementTypeProvider.getParameter_Kw2Kw2Keyword_1_0ElementType());
                    				

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleNestedStart"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1103:1: entryRuleNestedStart : ruleNestedStart EOF ;
    public final void entryRuleNestedStart() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1103:21: ( ruleNestedStart EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1104:2: ruleNestedStart EOF
            {
             markComposite(elementTypeProvider.getNestedStartElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedStart_in_entryRuleNestedStart3060);
            ruleNestedStart();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedStart3066); 

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
    // $ANTLR end "entryRuleNestedStart"


    // $ANTLR start "ruleNestedStart"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1110:1: ruleNestedStart : ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleNestedStart() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1110:16: ( ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1111:2: ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1111:2: ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1112:3: ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) )
            {

            			markComposite(elementTypeProvider.getNestedStart_NestedStartSubParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleNestedStartSub_in_ruleNestedStart3083);
            ruleNestedStartSub();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1119:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1120:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1120:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1121:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedStart3110); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getNestedStart_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleNestedStart"


    // $ANTLR start "entryRuleNestedStartSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1134:1: entryRuleNestedStartSub : ruleNestedStartSub EOF ;
    public final void entryRuleNestedStartSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1134:24: ( ruleNestedStartSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1135:2: ruleNestedStartSub EOF
            {
             markComposite(elementTypeProvider.getNestedStartSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedStartSub_in_entryRuleNestedStartSub3141);
            ruleNestedStartSub();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedStartSub3147); 

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
    // $ANTLR end "entryRuleNestedStartSub"


    // $ANTLR start "ruleNestedStartSub"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1141:1: ruleNestedStartSub : (otherlv_0= '#8' () ) ;
    public final void ruleNestedStartSub() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1141:19: ( (otherlv_0= '#8' () ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1142:2: (otherlv_0= '#8' () )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1142:2: (otherlv_0= '#8' () )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1143:3: otherlv_0= '#8' ()
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNestedStartSub3166); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNestedStartSub_NumberSignDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1150:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1151:4: 
            {

            				precedeComposite(elementTypeProvider.getNestedStartSub_NestedStartSubAction_1ElementType());
            				doneComposite();
            			

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
    // $ANTLR end "ruleNestedStartSub"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleModel77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_ruleModel97 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_ruleModel117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_ruleModel137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_ruleModel157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleModel177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls12_in_ruleModel197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStart_in_ruleModel217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimple262 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple289 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleSimple320 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple352 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSimple398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN429 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN454 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleFQN474 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls516 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRuleCalls541 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls553 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCalls580 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls618 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub689 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsSub695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleCallsSub720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss1751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRuleCallsAss1770 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss1797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2828 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss2834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallsAss2853 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss2880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls911 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCalls917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleOptionalCalls936 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls976 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCalls1015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11046 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub11052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11097 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOptionalCallsSub11123 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub21188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleOptionalCallsSub21207 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub21234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31265 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub31271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOptionalCallsSub31290 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub31317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_entryRuleRecursion1348 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursion1354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleRecursion1373 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursion1385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1405 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursionSub1411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRecursionSub1443 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursionSub1478 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecursionSub1532 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_23_in_ruleRecursionSub1565 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleRecursionSub1592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop1624 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop1630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleLoop1649 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1676 = new BitSet(new long[]{0x0000000004000072L});
        public static final BitSet FOLLOW_26_in_ruleLoop1708 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1740 = new BitSet(new long[]{0x0000000004000062L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLoop1794 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLoop1848 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1887 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression1893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleExpression1912 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_ruleExpression1924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd1944 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdd1950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd1967 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleAdd2003 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd2035 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleMult_in_entryRuleMult2074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMult2080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2097 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleMult2133 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2165 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rulePrim_in_entryRulePrim2204 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim2210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePrim2266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim2343 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_rulePrim2373 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2405 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_rulePrim2442 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2479 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rulePrim2567 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_rulePrim2599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rulePrim2645 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2660 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls12_in_entryRuleRuleCalls122702 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls122708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleRuleCalls122727 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleConstructor_in_ruleRuleCalls122754 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleField_in_ruleRuleCalls122792 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleRuleCalls122817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructor_in_entryRuleConstructor2837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructor2843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleConstructor2888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleField_in_entryRuleField2920 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleField2926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleField2945 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleField2957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2977 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter2983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleParameter3028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStart_in_entryRuleNestedStart3060 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedStart3066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStartSub_in_ruleNestedStart3083 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedStart3110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStartSub_in_entryRuleNestedStartSub3141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedStartSub3147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleNestedStartSub3166 = new BitSet(new long[]{0x0000000000000002L});
    }


}