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

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel57); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:58:1: ruleModel : ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:58:10: ( ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:59:2: ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:59:2: ( ruleSimple | ruleRuleCalls | ruleOptionalCalls | ruleRecursion | ruleLoop | ruleExpression | ruleRuleCalls12 | ruleNestedStart )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:60:3: ruleSimple
                    {

                    			markComposite(elementTypeProvider.getModel_SimpleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSimple_in_ruleModel74);
                    ruleSimple();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:68:3: ruleRuleCalls
                    {

                    			markComposite(elementTypeProvider.getModel_RuleCallsParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_ruleModel94);
                    ruleRuleCalls();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:76:3: ruleOptionalCalls
                    {

                    			markComposite(elementTypeProvider.getModel_OptionalCallsParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_ruleModel114);
                    ruleOptionalCalls();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:84:3: ruleRecursion
                    {

                    			markComposite(elementTypeProvider.getModel_RecursionParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_ruleModel134);
                    ruleRecursion();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:92:3: ruleLoop
                    {

                    			markComposite(elementTypeProvider.getModel_LoopParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLoop_in_ruleModel154);
                    ruleLoop();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:100:3: ruleExpression
                    {

                    			markComposite(elementTypeProvider.getModel_ExpressionParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleModel174);
                    ruleExpression();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:108:3: ruleRuleCalls12
                    {

                    			markComposite(elementTypeProvider.getModel_RuleCalls12ParserRuleCall_6ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCalls12_in_ruleModel194);
                    ruleRuleCalls12();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:116:3: ruleNestedStart
                    {

                    			markComposite(elementTypeProvider.getModel_NestedStartParserRuleCall_7ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleNestedStart_in_ruleModel214);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:127:1: entryRuleSimple : ruleSimple EOF ;
    public final void entryRuleSimple() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:127:16: ( ruleSimple EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:128:2: ruleSimple EOF
            {
             markComposite(elementTypeProvider.getSimpleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSimple_in_entryRuleSimple234);
            ruleSimple();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimple237); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:133:1: ruleSimple : (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) ;
    public final void ruleSimple() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_optional_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:133:11: ( (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:134:2: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:134:2: (otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:135:3: otherlv_0= '#1' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )? ( (lv_datatype_4_0= ruleFQN ) )
            {

            			markLeaf(elementTypeProvider.getSimple_NumberSignDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSimple256); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:142:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:143:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:143:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:144:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSimple_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple283); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:153:3: (otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:154:4: otherlv_2= 'kw1' ( (lv_optional_3_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getSimple_Kw1Keyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimple314); 

                    				doneLeaf(otherlv_2);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:161:4: ( (lv_optional_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:162:5: (lv_optional_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:162:5: (lv_optional_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:163:6: lv_optional_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSimple_OptionalIDTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_optional_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimple346); 

                    						doneLeaf(lv_optional_3_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:173:3: ( (lv_datatype_4_0= ruleFQN ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:174:4: (lv_datatype_4_0= ruleFQN )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:174:4: (lv_datatype_4_0= ruleFQN )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:175:5: lv_datatype_4_0= ruleFQN
            {

            					markComposite(elementTypeProvider.getSimple_DatatypeFQNParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleSimple392);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:188:1: entryRuleFQN : ruleFQN EOF ;
    public final void entryRuleFQN() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:188:13: ( ruleFQN EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:189:2: ruleFQN EOF
            {
             markComposite(elementTypeProvider.getFQNElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN423);
            ruleFQN();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN426); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:194:1: ruleFQN : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) ;
    public final void ruleFQN() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:194:8: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:195:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:195:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:196:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )
            {

            			markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN445); 

            			doneLeaf(this_ID_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:203:3: (kw= '.' this_ID_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:204:4: kw= '.' this_ID_2= RULE_ID
            {

            				markLeaf(elementTypeProvider.getFQN_FullStopKeyword_1_0ElementType());
            			
            kw=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleFQN465); 

            				doneLeaf(kw);
            			

            				markLeaf(elementTypeProvider.getFQN_IDTerminalRuleCall_1_1ElementType());
            			
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN482); 

            				doneLeaf(this_ID_2);
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:223:1: entryRuleRuleCalls : ruleRuleCalls EOF ;
    public final void entryRuleRuleCalls() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:223:19: ( ruleRuleCalls EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:224:2: ruleRuleCalls EOF
            {
             markComposite(elementTypeProvider.getRuleCallsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls507);
            ruleRuleCalls();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls510); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:229:1: ruleRuleCalls : (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) ;
    public final void ruleRuleCalls() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:229:14: ( (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:230:2: (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:230:2: (otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:231:3: otherlv_0= '#2' ruleRuleCallsSub ( (lv_name_2_0= RULE_ID ) ) ( (lv_call1_3_0= ruleRuleCallsAss1 ) )? ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            {

            			markLeaf(elementTypeProvider.getRuleCalls_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRuleCalls529); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getRuleCalls_RuleCallsSubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls541);
            ruleRuleCallsSub();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:245:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:246:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:246:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:247:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRuleCalls_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCalls568); 

            					doneLeaf(lv_name_2_0);
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:256:3: ( (lv_call1_3_0= ruleRuleCallsAss1 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:257:4: (lv_call1_3_0= ruleRuleCallsAss1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:257:4: (lv_call1_3_0= ruleRuleCallsAss1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:258:5: lv_call1_3_0= ruleRuleCallsAss1
                    {

                    					markComposite(elementTypeProvider.getRuleCalls_Call1RuleCallsAss1ParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls606);
                    ruleRuleCallsAss1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:267:3: ( (lv_call2_4_0= ruleRuleCallsAss2 ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:268:4: (lv_call2_4_0= ruleRuleCallsAss2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:268:4: (lv_call2_4_0= ruleRuleCallsAss2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:269:5: lv_call2_4_0= ruleRuleCallsAss2
                    {

                    					markComposite(elementTypeProvider.getRuleCalls_Call2RuleCallsAss2ParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls645);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:282:1: entryRuleRuleCallsSub : ruleRuleCallsSub EOF ;
    public final void entryRuleRuleCallsSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:282:22: ( ruleRuleCallsSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:283:2: ruleRuleCallsSub EOF
            {
             markComposite(elementTypeProvider.getRuleCallsSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub677);
            ruleRuleCallsSub();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsSub680); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:288:1: ruleRuleCallsSub : ( (lv_sub_0_0= 'sub' ) ) ;
    public final void ruleRuleCallsSub() throws RecognitionException {
        Token lv_sub_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:288:17: ( ( (lv_sub_0_0= 'sub' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:289:2: ( (lv_sub_0_0= 'sub' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:289:2: ( (lv_sub_0_0= 'sub' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:290:3: (lv_sub_0_0= 'sub' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:290:3: (lv_sub_0_0= 'sub' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:291:4: lv_sub_0_0= 'sub'
            {

            				markLeaf(elementTypeProvider.getRuleCallsSub_SubSubKeyword_0ElementType());
            			
            lv_sub_0_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRuleCallsSub705); 

            				doneLeaf(lv_sub_0_0);
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:303:1: entryRuleRuleCallsAss1 : ruleRuleCallsAss1 EOF ;
    public final void entryRuleRuleCallsAss1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:303:23: ( ruleRuleCallsAss1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:304:2: ruleRuleCallsAss1 EOF
            {
             markComposite(elementTypeProvider.getRuleCallsAss1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1730);
            ruleRuleCallsAss1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss1733); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:309:1: ruleRuleCallsAss1 : (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleRuleCallsAss1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:309:18: ( (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:310:2: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:310:2: (otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:311:3: otherlv_0= 'ass1' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getRuleCallsAss1_Ass1Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRuleCallsAss1752); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:318:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:319:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:319:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:320:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRuleCallsAss1_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss1779); 

            					doneLeaf(lv_name_1_0);
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:333:1: entryRuleRuleCallsAss2 : ruleRuleCallsAss2 EOF ;
    public final void entryRuleRuleCallsAss2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:333:23: ( ruleRuleCallsAss2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:334:2: ruleRuleCallsAss2 EOF
            {
             markComposite(elementTypeProvider.getRuleCallsAss2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2810);
            ruleRuleCallsAss2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCallsAss2813); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:339:1: ruleRuleCallsAss2 : (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleRuleCallsAss2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:339:18: ( (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:340:2: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:340:2: (otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:341:3: otherlv_0= 'ass2' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getRuleCallsAss2_Ass2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleRuleCallsAss2832); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:348:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:349:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:349:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:350:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRuleCallsAss2_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRuleCallsAss2859); 

            					doneLeaf(lv_name_1_0);
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:363:1: entryRuleOptionalCalls : ruleOptionalCalls EOF ;
    public final void entryRuleOptionalCalls() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:363:23: ( ruleOptionalCalls EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:364:2: ruleOptionalCalls EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls890);
            ruleOptionalCalls();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCalls893); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:369:1: ruleOptionalCalls : (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final void ruleOptionalCalls() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:369:18: ( (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:370:2: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:370:2: (otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:371:3: otherlv_0= '#3' () ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )? ( (lv_name_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getOptionalCalls_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOptionalCalls912); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:378:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:379:4: 
            {

            				precedeComposite(elementTypeProvider.getOptionalCalls_OptionalCallsAction_1ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:384:3: ( (lv_opt1_2_0= ruleOptionalCallsSub1 ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:385:4: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:385:4: (lv_opt1_2_0= ruleOptionalCallsSub1 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:386:5: lv_opt1_2_0= ruleOptionalCallsSub1
                    {

                    					markComposite(elementTypeProvider.getOptionalCalls_Opt1OptionalCallsSub1ParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls952);
                    ruleOptionalCallsSub1();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:395:3: ( (lv_name_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:396:4: (lv_name_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:396:4: (lv_name_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:397:5: lv_name_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getOptionalCalls_NameIDTerminalRuleCall_3_0ElementType());
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCalls991); 

            					doneLeaf(lv_name_3_0);
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:410:1: entryRuleOptionalCallsSub1 : ruleOptionalCallsSub1 EOF ;
    public final void entryRuleOptionalCallsSub1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:410:27: ( ruleOptionalCallsSub1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:411:2: ruleOptionalCallsSub1 EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsSub1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11022);
            ruleOptionalCallsSub1();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub11025); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:416:1: ruleOptionalCallsSub1 : ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) ;
    public final void ruleOptionalCallsSub1() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:416:22: ( ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:417:2: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:417:2: ( () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:418:3: () ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )? otherlv_2= 'sub' ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:418:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:419:4: 
            {

            				precedeComposite(elementTypeProvider.getOptionalCallsSub1_OptionalCallsSub1Action_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:424:3: ( (lv_opt2_1_0= ruleOptionalCallsSub2 ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:425:4: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:425:4: (lv_opt2_1_0= ruleOptionalCallsSub2 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:426:5: lv_opt2_1_0= ruleOptionalCallsSub2
                    {

                    					markComposite(elementTypeProvider.getOptionalCallsSub1_Opt2OptionalCallsSub2ParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11070);
                    ruleOptionalCallsSub2();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getOptionalCallsSub1_SubKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOptionalCallsSub11096); 

            			doneLeaf(otherlv_2);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:442:3: ( (lv_opt3_3_0= ruleOptionalCallsSub3 ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:443:4: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:443:4: (lv_opt3_3_0= ruleOptionalCallsSub3 )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:444:5: lv_opt3_3_0= ruleOptionalCallsSub3
                    {

                    					markComposite(elementTypeProvider.getOptionalCallsSub1_Opt3OptionalCallsSub3ParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11123);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:457:1: entryRuleOptionalCallsSub2 : ruleOptionalCallsSub2 EOF ;
    public final void entryRuleOptionalCallsSub2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:457:27: ( ruleOptionalCallsSub2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:458:2: ruleOptionalCallsSub2 EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsSub2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21155);
            ruleOptionalCallsSub2();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub21158); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:463:1: ruleOptionalCallsSub2 : (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleOptionalCallsSub2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:463:22: ( (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:464:2: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:464:2: (otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:465:3: otherlv_0= 'sub2' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getOptionalCallsSub2_Sub2Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOptionalCallsSub21177); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:472:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:473:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:473:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:474:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getOptionalCallsSub2_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub21204); 

            					doneLeaf(lv_name_1_0);
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:487:1: entryRuleOptionalCallsSub3 : ruleOptionalCallsSub3 EOF ;
    public final void entryRuleOptionalCallsSub3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:487:27: ( ruleOptionalCallsSub3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:488:2: ruleOptionalCallsSub3 EOF
            {
             markComposite(elementTypeProvider.getOptionalCallsSub3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31235);
            ruleOptionalCallsSub3();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalCallsSub31238); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:493:1: ruleOptionalCallsSub3 : (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleOptionalCallsSub3() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:493:22: ( (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:494:2: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:494:2: (otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:495:3: otherlv_0= 'sub3' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getOptionalCallsSub3_Sub3Keyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOptionalCallsSub31257); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:502:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:503:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:503:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:504:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getOptionalCallsSub3_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalCallsSub31284); 

            					doneLeaf(lv_name_1_0);
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:517:1: entryRuleRecursion : ruleRecursion EOF ;
    public final void entryRuleRecursion() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:517:19: ( ruleRecursion EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:518:2: ruleRecursion EOF
            {
             markComposite(elementTypeProvider.getRecursionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursion_in_entryRuleRecursion1315);
            ruleRecursion();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursion1318); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:523:1: ruleRecursion : (otherlv_0= '#4' ruleRecursionSub ) ;
    public final void ruleRecursion() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:523:14: ( (otherlv_0= '#4' ruleRecursionSub ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:524:2: (otherlv_0= '#4' ruleRecursionSub )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:524:2: (otherlv_0= '#4' ruleRecursionSub )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:525:3: otherlv_0= '#4' ruleRecursionSub
            {

            			markLeaf(elementTypeProvider.getRecursion_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRecursion1337); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getRecursion_RecursionSubParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursion1349);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:543:1: entryRuleRecursionSub : ruleRecursionSub EOF ;
    public final void entryRuleRecursionSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:543:22: ( ruleRecursionSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:544:2: ruleRecursionSub EOF
            {
             markComposite(elementTypeProvider.getRecursionSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1369);
            ruleRecursionSub();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecursionSub1372); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:549:1: ruleRecursionSub : ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) ;
    public final void ruleRecursionSub() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_vals_3_0=null;
        Token otherlv_4=null;
        Token lv_semi_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:549:17: ( ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:550:2: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:550:2: ( () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:551:3: () otherlv_1= '{' ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )* otherlv_4= '}' ( (lv_semi_5_0= ';' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:551:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:552:4: 
            {

            				precedeComposite(elementTypeProvider.getRecursionSub_RecursionSubAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getRecursionSub_LeftCurlyBracketKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRecursionSub1404); 

            			doneLeaf(otherlv_1);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:564:3: ( ( (lv_sub_2_0= ruleRecursionSub ) ) | ( (lv_vals_3_0= RULE_ID ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:565:4: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:565:4: ( (lv_sub_2_0= ruleRecursionSub ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:566:5: (lv_sub_2_0= ruleRecursionSub )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:566:5: (lv_sub_2_0= ruleRecursionSub )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:567:6: lv_sub_2_0= ruleRecursionSub
            	    {

            	    						markComposite(elementTypeProvider.getRecursionSub_SubRecursionSubParserRuleCall_2_0_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleRecursionSub_in_ruleRecursionSub1439);
            	    ruleRecursionSub();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:577:4: ( (lv_vals_3_0= RULE_ID ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:577:4: ( (lv_vals_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:578:5: (lv_vals_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:578:5: (lv_vals_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:579:6: lv_vals_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getRecursionSub_ValsIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_vals_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecursionSub1493); 

            	    						doneLeaf(lv_vals_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getRecursionSub_RightCurlyBracketKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRecursionSub1526); 

            			doneLeaf(otherlv_4);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:596:3: ( (lv_semi_5_0= ';' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:597:4: (lv_semi_5_0= ';' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:597:4: (lv_semi_5_0= ';' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:598:5: lv_semi_5_0= ';'
                    {

                    					markLeaf(elementTypeProvider.getRecursionSub_SemiSemicolonKeyword_4_0ElementType());
                    				
                    lv_semi_5_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRecursionSub1553); 

                    					doneLeaf(lv_semi_5_0);
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:611:1: entryRuleLoop : ruleLoop EOF ;
    public final void entryRuleLoop() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:611:14: ( ruleLoop EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:612:2: ruleLoop EOF
            {
             markComposite(elementTypeProvider.getLoopElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop_in_entryRuleLoop1585);
            ruleLoop();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop1588); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:617:1: ruleLoop : (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) ;
    public final void ruleLoop() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_names_1_0=null;
        Token otherlv_2=null;
        Token lv_gr_3_0=null;
        Token lv_ints_4_0=null;
        Token lv_strings_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:617:9: ( (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:618:2: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:618:2: (otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:619:3: otherlv_0= '#5' ( (lv_names_1_0= RULE_ID ) )+ (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )* ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
            {

            			markLeaf(elementTypeProvider.getLoop_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLoop1607); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:626:3: ( (lv_names_1_0= RULE_ID ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:627:4: (lv_names_1_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:627:4: (lv_names_1_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:628:5: lv_names_1_0= RULE_ID
            	    {

            	    					markLeaf(elementTypeProvider.getLoop_NamesIDTerminalRuleCall_1_0ElementType());
            	    				
            	    lv_names_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1634); 

            	    					doneLeaf(lv_names_1_0);
            	    				

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:637:3: (otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:638:4: otherlv_2= 'gr' ( (lv_gr_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getLoop_GrKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleLoop1666); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:645:4: ( (lv_gr_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:646:5: (lv_gr_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:646:5: (lv_gr_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:647:6: lv_gr_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getLoop_GrIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_gr_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop1698); 

            	    						doneLeaf(lv_gr_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:657:3: ( ( (lv_ints_4_0= RULE_INT ) ) | ( (lv_strings_5_0= RULE_STRING ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:658:4: ( (lv_ints_4_0= RULE_INT ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:658:4: ( (lv_ints_4_0= RULE_INT ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:659:5: (lv_ints_4_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:659:5: (lv_ints_4_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:660:6: lv_ints_4_0= RULE_INT
            	    {

            	    						markLeaf(elementTypeProvider.getLoop_IntsINTTerminalRuleCall_3_0_0ElementType());
            	    					
            	    lv_ints_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLoop1752); 

            	    						doneLeaf(lv_ints_4_0);
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:670:4: ( (lv_strings_5_0= RULE_STRING ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:670:4: ( (lv_strings_5_0= RULE_STRING ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:671:5: (lv_strings_5_0= RULE_STRING )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:671:5: (lv_strings_5_0= RULE_STRING )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:672:6: lv_strings_5_0= RULE_STRING
            	    {

            	    						markLeaf(elementTypeProvider.getLoop_StringsSTRINGTerminalRuleCall_3_1_0ElementType());
            	    					
            	    lv_strings_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLoop1806); 

            	    						doneLeaf(lv_strings_5_0);
            	    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:686:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:686:20: ( ruleExpression EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:687:2: ruleExpression EOF
            {
             markComposite(elementTypeProvider.getExpressionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression1845);
            ruleExpression();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression1848); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:692:1: ruleExpression : (otherlv_0= '#6' ruleAdd ) ;
    public final void ruleExpression() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:692:15: ( (otherlv_0= '#6' ruleAdd ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:693:2: (otherlv_0= '#6' ruleAdd )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:693:2: (otherlv_0= '#6' ruleAdd )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:694:3: otherlv_0= '#6' ruleAdd
            {

            			markLeaf(elementTypeProvider.getExpression_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleExpression1867); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getExpression_AddParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_ruleExpression1879);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:712:1: entryRuleAdd : ruleAdd EOF ;
    public final void entryRuleAdd() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:712:13: ( ruleAdd EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:713:2: ruleAdd EOF
            {
             markComposite(elementTypeProvider.getAddElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAdd_in_entryRuleAdd1899);
            ruleAdd();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdd1902); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:718:1: ruleAdd : ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) ;
    public final void ruleAdd() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:718:8: ( ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:719:2: ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:719:2: ( ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:720:3: ruleMult ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            {

            			markComposite(elementTypeProvider.getAdd_MultParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd1919);
            ruleMult();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:727:3: ( () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==28) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:728:4: () otherlv_2= '+' ( (lv_right_3_0= ruleMult ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:728:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:729:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getAdd_AddLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getAdd_PlusSignKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleAdd1955); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:741:4: ( (lv_right_3_0= ruleMult ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:742:5: (lv_right_3_0= ruleMult )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:742:5: (lv_right_3_0= ruleMult )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:743:6: lv_right_3_0= ruleMult
            	    {

            	    						markComposite(elementTypeProvider.getAdd_RightMultParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleMult_in_ruleAdd1987);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:757:1: entryRuleMult : ruleMult EOF ;
    public final void entryRuleMult() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:757:14: ( ruleMult EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:758:2: ruleMult EOF
            {
             markComposite(elementTypeProvider.getMultElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMult_in_entryRuleMult2026);
            ruleMult();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMult2029); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:763:1: ruleMult : ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) ;
    public final void ruleMult() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:763:9: ( ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:764:2: ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:764:2: ( rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:765:3: rulePrim ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            {

            			markComposite(elementTypeProvider.getMult_PrimParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2046);
            rulePrim();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:772:3: ( () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:773:4: () otherlv_2= '*' ( (lv_right_3_0= rulePrim ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:773:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:774:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getMult_MultLeftAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }


            	    				markLeaf(elementTypeProvider.getMult_AsteriskKeyword_1_1ElementType());
            	    			
            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMult2082); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:786:4: ( (lv_right_3_0= rulePrim ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:787:5: (lv_right_3_0= rulePrim )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:787:5: (lv_right_3_0= rulePrim )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:788:6: lv_right_3_0= rulePrim
            	    {

            	    						markComposite(elementTypeProvider.getMult_RightPrimParserRuleCall_1_2_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_rulePrim_in_ruleMult2114);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:802:1: entryRulePrim : rulePrim EOF ;
    public final void entryRulePrim() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:802:14: ( rulePrim EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:803:2: rulePrim EOF
            {
             markComposite(elementTypeProvider.getPrimElementType()); 
            pushFollow(FollowSets000.FOLLOW_rulePrim_in_entryRulePrim2153);
            rulePrim();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrim2156); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:808:1: rulePrim : ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:808:9: ( ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:809:2: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:809:2: ( ( () ( (lv_val_1_0= RULE_INT ) ) ) | ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' ) | ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) ) | (otherlv_12= '(' ruleAdd otherlv_14= ')' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:810:3: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:810:3: ( () ( (lv_val_1_0= RULE_INT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:811:4: () ( (lv_val_1_0= RULE_INT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:811:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:812:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim_ValueAction_0_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:817:4: ( (lv_val_1_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:818:5: (lv_val_1_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:818:5: (lv_val_1_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:819:6: lv_val_1_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getPrim_ValINTTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_val_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePrim2212); 

                    						doneLeaf(lv_val_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:830:3: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:830:3: ( () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:831:4: () ( (lv_func_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_param_5_0= ruleAdd ) ) (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )* otherlv_8= ')'
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:831:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:832:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim_FunctionAction_1_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:837:4: ( (lv_func_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:838:5: (lv_func_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:838:5: (lv_func_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:839:6: lv_func_3_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getPrim_FuncIDTerminalRuleCall_1_1_0ElementType());
                    					
                    lv_func_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePrim2289); 

                    						doneLeaf(lv_func_3_0);
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getPrim_LeftParenthesisKeyword_1_2ElementType());
                    			
                    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2319); 

                    				doneLeaf(otherlv_4);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:855:4: ( (lv_param_5_0= ruleAdd ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:856:5: (lv_param_5_0= ruleAdd )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:856:5: (lv_param_5_0= ruleAdd )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:857:6: lv_param_5_0= ruleAdd
                    {

                    						markComposite(elementTypeProvider.getPrim_ParamAddParserRuleCall_1_3_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2351);
                    ruleAdd();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:866:4: (otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==31) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:867:5: otherlv_6= ',' ( (lv_param_7_0= ruleAdd ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getPrim_CommaKeyword_1_4_0ElementType());
                    	    				
                    	    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_rulePrim2388); 

                    	    					doneLeaf(otherlv_6);
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:874:5: ( (lv_param_7_0= ruleAdd ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:875:6: (lv_param_7_0= ruleAdd )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:875:6: (lv_param_7_0= ruleAdd )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:876:7: lv_param_7_0= ruleAdd
                    	    {

                    	    							markComposite(elementTypeProvider.getPrim_ParamAddParserRuleCall_1_4_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2425);
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


                    				markLeaf(elementTypeProvider.getPrim_RightParenthesisKeyword_1_5ElementType());
                    			
                    otherlv_8=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2464); 

                    				doneLeaf(otherlv_8);
                    			

                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:895:3: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:895:3: ( () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:896:4: () otherlv_10= '=>' ( (lv_target_11_0= rulePrim ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:896:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:897:5: 
                    {

                    					precedeComposite(elementTypeProvider.getPrim_PointerAction_2_0ElementType());
                    					doneComposite();
                    				

                    }


                    				markLeaf(elementTypeProvider.getPrim_EqualsSignGreaterThanSignKeyword_2_1ElementType());
                    			
                    otherlv_10=(Token)match(input,33,FollowSets000.FOLLOW_33_in_rulePrim2513); 

                    				doneLeaf(otherlv_10);
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:909:4: ( (lv_target_11_0= rulePrim ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:910:5: (lv_target_11_0= rulePrim )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:910:5: (lv_target_11_0= rulePrim )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:911:6: lv_target_11_0= rulePrim
                    {

                    						markComposite(elementTypeProvider.getPrim_TargetPrimParserRuleCall_2_2_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_rulePrim_in_rulePrim2545);
                    rulePrim();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:922:3: (otherlv_12= '(' ruleAdd otherlv_14= ')' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:922:3: (otherlv_12= '(' ruleAdd otherlv_14= ')' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:923:4: otherlv_12= '(' ruleAdd otherlv_14= ')'
                    {

                    				markLeaf(elementTypeProvider.getPrim_LeftParenthesisKeyword_3_0ElementType());
                    			
                    otherlv_12=(Token)match(input,30,FollowSets000.FOLLOW_30_in_rulePrim2591); 

                    				doneLeaf(otherlv_12);
                    			

                    				markComposite(elementTypeProvider.getPrim_AddParserRuleCall_3_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleAdd_in_rulePrim2606);
                    ruleAdd();

                    state._fsp--;


                    				doneComposite();
                    			

                    				markLeaf(elementTypeProvider.getPrim_RightParenthesisKeyword_3_2ElementType());
                    			
                    otherlv_14=(Token)match(input,32,FollowSets000.FOLLOW_32_in_rulePrim2623); 

                    				doneLeaf(otherlv_14);
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:949:1: entryRuleRuleCalls12 : ruleRuleCalls12 EOF ;
    public final void entryRuleRuleCalls12() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:949:21: ( ruleRuleCalls12 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:950:2: ruleRuleCalls12 EOF
            {
             markComposite(elementTypeProvider.getRuleCalls12ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRuleCalls12_in_entryRuleRuleCalls122648);
            ruleRuleCalls12();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRuleCalls122651); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:955:1: ruleRuleCalls12 : (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) ;
    public final void ruleRuleCalls12() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:955:16: ( (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:956:2: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:956:2: (otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:957:3: otherlv_0= '#7' ( (lv_constructor_1_0= ruleConstructor ) ) ( (lv_fields_2_0= ruleField ) ) otherlv_3= 'kw3'
            {

            			markLeaf(elementTypeProvider.getRuleCalls12_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRuleCalls122670); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:964:3: ( (lv_constructor_1_0= ruleConstructor ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:965:4: (lv_constructor_1_0= ruleConstructor )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:965:4: (lv_constructor_1_0= ruleConstructor )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:966:5: lv_constructor_1_0= ruleConstructor
            {

            					markComposite(elementTypeProvider.getRuleCalls12_ConstructorConstructorParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleConstructor_in_ruleRuleCalls122697);
            ruleConstructor();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:975:3: ( (lv_fields_2_0= ruleField ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:976:4: (lv_fields_2_0= ruleField )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:976:4: (lv_fields_2_0= ruleField )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:977:5: lv_fields_2_0= ruleField
            {

            					markComposite(elementTypeProvider.getRuleCalls12_FieldsFieldParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleField_in_ruleRuleCalls122735);
            ruleField();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getRuleCalls12_Kw3Keyword_3ElementType());
            		
            otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRuleCalls122760); 

            			doneLeaf(otherlv_3);
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:997:1: entryRuleConstructor : ruleConstructor EOF ;
    public final void entryRuleConstructor() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:997:21: ( ruleConstructor EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:998:2: ruleConstructor EOF
            {
             markComposite(elementTypeProvider.getConstructorElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstructor_in_entryRuleConstructor2780);
            ruleConstructor();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstructor2783); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1003:1: ruleConstructor : ( () ( (lv_kw1_1_0= 'kw1' ) )? ) ;
    public final void ruleConstructor() throws RecognitionException {
        Token lv_kw1_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1003:16: ( ( () ( (lv_kw1_1_0= 'kw1' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1004:2: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1004:2: ( () ( (lv_kw1_1_0= 'kw1' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1005:3: () ( (lv_kw1_1_0= 'kw1' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1005:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1006:4: 
            {

            				precedeComposite(elementTypeProvider.getConstructor_ConstructorAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1011:3: ( (lv_kw1_1_0= 'kw1' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==12) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1012:4: (lv_kw1_1_0= 'kw1' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1012:4: (lv_kw1_1_0= 'kw1' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1013:5: lv_kw1_1_0= 'kw1'
                    {

                    					markLeaf(elementTypeProvider.getConstructor_Kw1Kw1Keyword_1_0ElementType());
                    				
                    lv_kw1_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConstructor2828); 

                    					doneLeaf(lv_kw1_1_0);
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1026:1: entryRuleField : ruleField EOF ;
    public final void entryRuleField() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1026:15: ( ruleField EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1027:2: ruleField EOF
            {
             markComposite(elementTypeProvider.getFieldElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleField_in_entryRuleField2860);
            ruleField();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleField2863); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1032:1: ruleField : (this_ID_0= RULE_ID ruleParameter ) ;
    public final void ruleField() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1032:10: ( (this_ID_0= RULE_ID ruleParameter ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1033:2: (this_ID_0= RULE_ID ruleParameter )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1033:2: (this_ID_0= RULE_ID ruleParameter )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1034:3: this_ID_0= RULE_ID ruleParameter
            {

            			markLeaf(elementTypeProvider.getField_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleField2882); 

            			doneLeaf(this_ID_0);
            		

            			markComposite(elementTypeProvider.getField_ParameterParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleField2894);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1052:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1052:19: ( ruleParameter EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1053:2: ruleParameter EOF
            {
             markComposite(elementTypeProvider.getParameterElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter2914);
            ruleParameter();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter2917); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1058:1: ruleParameter : ( () ( (lv_kw2_1_0= 'kw2' ) )? ) ;
    public final void ruleParameter() throws RecognitionException {
        Token lv_kw2_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1058:14: ( ( () ( (lv_kw2_1_0= 'kw2' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1059:2: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1059:2: ( () ( (lv_kw2_1_0= 'kw2' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1060:3: () ( (lv_kw2_1_0= 'kw2' ) )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1060:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1061:4: 
            {

            				precedeComposite(elementTypeProvider.getParameter_ParameterAction_0ElementType());
            				doneComposite();
            			

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1066:3: ( (lv_kw2_1_0= 'kw2' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1067:4: (lv_kw2_1_0= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1067:4: (lv_kw2_1_0= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1068:5: lv_kw2_1_0= 'kw2'
                    {

                    					markLeaf(elementTypeProvider.getParameter_Kw2Kw2Keyword_1_0ElementType());
                    				
                    lv_kw2_1_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleParameter2962); 

                    					doneLeaf(lv_kw2_1_0);
                    				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1081:1: entryRuleNestedStart : ruleNestedStart EOF ;
    public final void entryRuleNestedStart() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1081:21: ( ruleNestedStart EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1082:2: ruleNestedStart EOF
            {
             markComposite(elementTypeProvider.getNestedStartElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedStart_in_entryRuleNestedStart2994);
            ruleNestedStart();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedStart2997); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1087:1: ruleNestedStart : ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleNestedStart() throws RecognitionException {
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1087:16: ( ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1088:2: ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1088:2: ( ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1089:3: ruleNestedStartSub ( (lv_name_1_0= RULE_ID ) )
            {

            			markComposite(elementTypeProvider.getNestedStart_NestedStartSubParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleNestedStartSub_in_ruleNestedStart3014);
            ruleNestedStartSub();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1096:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1097:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1097:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1098:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNestedStart_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedStart3041); 

            					doneLeaf(lv_name_1_0);
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1111:1: entryRuleNestedStartSub : ruleNestedStartSub EOF ;
    public final void entryRuleNestedStartSub() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1111:24: ( ruleNestedStartSub EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1112:2: ruleNestedStartSub EOF
            {
             markComposite(elementTypeProvider.getNestedStartSubElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedStartSub_in_entryRuleNestedStartSub3072);
            ruleNestedStartSub();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedStartSub3075); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1117:1: ruleNestedStartSub : (otherlv_0= '#8' () ) ;
    public final void ruleNestedStartSub() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1117:19: ( (otherlv_0= '#8' () ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1118:2: (otherlv_0= '#8' () )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1118:2: (otherlv_0= '#8' () )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1119:3: otherlv_0= '#8' ()
            {

            			markLeaf(elementTypeProvider.getNestedStartSub_NumberSignDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNestedStartSub3094); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1126:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/formatter/idea/parser/antlr/internal/PsiInternalElementMatcherTestLanguage.g:1127:4: 
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
        public static final BitSet FOLLOW_EOF_in_entryRuleModel57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_ruleModel74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_ruleModel114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_ruleModel134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_ruleModel154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleModel174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls12_in_ruleModel194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStart_in_ruleModel214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimple_in_entryRuleSimple234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimple237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSimple256 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple283 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleSimple314 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimple346 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleSimple392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN445 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleFQN465 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls_in_entryRuleRuleCalls507 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleRuleCalls529 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_ruleRuleCalls541 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCalls568 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_ruleRuleCalls606 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_ruleRuleCalls645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsSub_in_entryRuleRuleCallsSub677 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsSub680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleRuleCallsSub705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss1_in_entryRuleRuleCallsAss1730 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss1733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleRuleCallsAss1752 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss1779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCallsAss2_in_entryRuleRuleCallsAss2810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCallsAss2813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleRuleCallsAss2832 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCallsAss2859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCalls_in_entryRuleOptionalCalls890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCalls893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleOptionalCalls912 = new BitSet(new long[]{0x0000000000088010L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_ruleOptionalCalls952 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCalls991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub1_in_entryRuleOptionalCallsSub11022 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub11025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_ruleOptionalCallsSub11070 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOptionalCallsSub11096 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_ruleOptionalCallsSub11123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub2_in_entryRuleOptionalCallsSub21155 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub21158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleOptionalCallsSub21177 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub21204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOptionalCallsSub3_in_entryRuleOptionalCallsSub31235 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalCallsSub31238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleOptionalCallsSub31257 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalCallsSub31284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursion_in_entryRuleRecursion1315 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursion1318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleRecursion1337 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursion1349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_entryRuleRecursionSub1369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecursionSub1372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRecursionSub1404 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_ruleRecursionSub_in_ruleRecursionSub1439 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecursionSub1493 = new BitSet(new long[]{0x0000000000C00010L});
        public static final BitSet FOLLOW_23_in_ruleRecursionSub1526 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleRecursionSub1553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop1585 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop1588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleLoop1607 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1634 = new BitSet(new long[]{0x0000000004000072L});
        public static final BitSet FOLLOW_26_in_ruleLoop1666 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop1698 = new BitSet(new long[]{0x0000000004000062L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLoop1752 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLoop1806 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1845 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression1848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleExpression1867 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_ruleExpression1879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd1899 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdd1902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd1919 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleAdd1955 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleMult_in_ruleAdd1987 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_ruleMult_in_entryRuleMult2026 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMult2029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2046 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleMult2082 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_ruleMult2114 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rulePrim_in_entryRulePrim2153 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrim2156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePrim2212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePrim2289 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_rulePrim2319 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2351 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_31_in_rulePrim2388 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2425 = new BitSet(new long[]{0x0000000180000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rulePrim2513 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_rulePrim_in_rulePrim2545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rulePrim2591 = new BitSet(new long[]{0x0000000240000030L});
        public static final BitSet FOLLOW_ruleAdd_in_rulePrim2606 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_rulePrim2623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRuleCalls12_in_entryRuleRuleCalls122648 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRuleCalls122651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleRuleCalls122670 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleConstructor_in_ruleRuleCalls122697 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleField_in_ruleRuleCalls122735 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleRuleCalls122760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstructor_in_entryRuleConstructor2780 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstructor2783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleConstructor2828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleField_in_entryRuleField2860 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleField2863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleField2882 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleField2894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2914 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter2917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleParameter2962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStart_in_entryRuleNestedStart2994 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedStart2997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStartSub_in_ruleNestedStart3014 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedStart3041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedStartSub_in_entryRuleNestedStartSub3072 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedStartSub3075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleNestedStartSub3094 = new BitSet(new long[]{0x0000000000000002L});
    }


}