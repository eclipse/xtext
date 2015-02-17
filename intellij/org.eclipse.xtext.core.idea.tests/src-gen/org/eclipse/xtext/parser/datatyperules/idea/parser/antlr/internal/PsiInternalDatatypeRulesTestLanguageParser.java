package org.eclipse.xtext.parser.datatyperules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalDatatypeRulesTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "':'", "'#'", "'+'", "'*'", "';'", "'.'", "'/'", "'('", "')'", "'..'", "'-'", "'E'"
    };
    public static final int RULE_ID=4;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
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


        public PsiInternalDatatypeRulesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalDatatypeRulesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalDatatypeRulesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g"; }



    private DatatypeRulesTestLanguageGrammarAccess grammarAccess;

    private DatatypeRulesTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalDatatypeRulesTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, DatatypeRulesTestLanguageElementTypeProvider elementTypeProvider, DatatypeRulesTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "CompositeModel";
    }




    // $ANTLR start "entryRuleCompositeModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:49:1: entryRuleCompositeModel : ruleCompositeModel EOF ;
    public final void entryRuleCompositeModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:49:24: ( ruleCompositeModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:50:2: ruleCompositeModel EOF
            {
             markComposite(elementTypeProvider.getCompositeModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel54);
            ruleCompositeModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeModel60); 

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
    // $ANTLR end "entryRuleCompositeModel"


    // $ANTLR start "ruleCompositeModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:58:1: ruleCompositeModel : ( (lv_model_0_0= ruleModel ) )+ ;
    public final void ruleCompositeModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:58:19: ( ( (lv_model_0_0= ruleModel ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:59:2: ( (lv_model_0_0= ruleModel ) )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:59:2: ( (lv_model_0_0= ruleModel ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:60:3: (lv_model_0_0= ruleModel )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:60:3: (lv_model_0_0= ruleModel )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:61:4: lv_model_0_0= ruleModel
            	    {

            	    				markComposite(elementTypeProvider.getCompositeModel_ModelModelParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleCompositeModel89);
            	    ruleModel();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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
    // $ANTLR end "ruleCompositeModel"


    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:73:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:73:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:74:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel115);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel121); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:82:1: ruleModel : ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:82:10: ( ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:83:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:83:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:84:3: ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:84:3: ( (lv_id_0_0= ruleNestedModelId ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:85:4: (lv_id_0_0= ruleNestedModelId )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:85:4: (lv_id_0_0= ruleNestedModelId )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:86:5: lv_id_0_0= ruleNestedModelId
            {

            					markComposite(elementTypeProvider.getModel_IdNestedModelIdParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNestedModelId_in_ruleModel157);
            ruleNestedModelId();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:95:3: (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:96:4: otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) )
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel188); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getModel_ColonKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:103:4: ( (lv_value_2_0= ruleFraction ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:104:5: (lv_value_2_0= ruleFraction )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:104:5: (lv_value_2_0= ruleFraction )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:105:6: lv_value_2_0= ruleFraction
                    {

                    						markComposite(elementTypeProvider.getModel_ValueFractionParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleFraction_in_ruleModel220);
                    ruleFraction();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:115:3: (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:116:4: otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) )
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel259); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getModel_NumberSignKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:123:4: ( (lv_vector_4_0= ruleVector ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:124:5: (lv_vector_4_0= ruleVector )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:124:5: (lv_vector_4_0= ruleVector )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:125:6: lv_vector_4_0= ruleVector
                    {

                    						markComposite(elementTypeProvider.getModel_VectorVectorParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleVector_in_ruleModel291);
                    ruleVector();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:135:3: (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:136:4: otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) )
                    {

                    				markLeaf();
                    			
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel330); 

                    				doneLeaf(otherlv_5, elementTypeProvider.getModel_PlusSignKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:143:4: ( (lv_dots_6_0= ruleDots ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:144:5: (lv_dots_6_0= ruleDots )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:144:5: (lv_dots_6_0= ruleDots )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:145:6: lv_dots_6_0= ruleDots
                    {

                    						markComposite(elementTypeProvider.getModel_DotsDotsParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDots_in_ruleModel362);
                    ruleDots();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:155:3: (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:156:4: otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) )
                    {

                    				markLeaf();
                    			
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel401); 

                    				doneLeaf(otherlv_7, elementTypeProvider.getModel_AsteriskKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:163:4: ( (lv_double_8_0= ruleDouble ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:164:5: (lv_double_8_0= ruleDouble )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:164:5: (lv_double_8_0= ruleDouble )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:165:6: lv_double_8_0= ruleDouble
                    {

                    						markComposite(elementTypeProvider.getModel_DoubleDoubleParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDouble_in_ruleModel433);
                    ruleDouble();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel466); 

            			doneLeaf(otherlv_9, elementTypeProvider.getModel_SemicolonKeyword_5ElementType());
            		

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


    // $ANTLR start "entryRuleModelId"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:186:1: entryRuleModelId : ruleModelId EOF ;
    public final void entryRuleModelId() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:186:17: ( ruleModelId EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:187:2: ruleModelId EOF
            {
             markComposite(elementTypeProvider.getModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_entryRuleModelId486);
            ruleModelId();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelId492); 

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
    // $ANTLR end "entryRuleModelId"


    // $ANTLR start "ruleModelId"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:195:1: ruleModelId : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final void ruleModelId() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:195:12: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:196:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:196:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:197:3: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelId515); 

            			doneLeaf(this_ID_0, elementTypeProvider.getModelId_IDTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModelId529); 

            			doneLeaf(kw, elementTypeProvider.getModelId_FullStopKeyword_1ElementType());
            		

            			markLeaf();
            		
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelId543); 

            			doneLeaf(this_ID_2, elementTypeProvider.getModelId_IDTerminalRuleCall_2ElementType());
            		

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
    // $ANTLR end "ruleModelId"


    // $ANTLR start "entryRuleNestedModelId"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:222:1: entryRuleNestedModelId : ruleNestedModelId EOF ;
    public final void entryRuleNestedModelId() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:222:23: ( ruleNestedModelId EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:223:2: ruleNestedModelId EOF
            {
             markComposite(elementTypeProvider.getNestedModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId563);
            ruleNestedModelId();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedModelId569); 

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
    // $ANTLR end "entryRuleNestedModelId"


    // $ANTLR start "ruleNestedModelId"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:231:1: ruleNestedModelId : ( ruleModelId kw= '.' ruleModelId ) ;
    public final void ruleNestedModelId() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:231:18: ( ( ruleModelId kw= '.' ruleModelId ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:232:2: ( ruleModelId kw= '.' ruleModelId )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:232:2: ( ruleModelId kw= '.' ruleModelId )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:233:3: ruleModelId kw= '.' ruleModelId
            {

            			markComposite(elementTypeProvider.getNestedModelId_ModelIdParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_ruleNestedModelId590);
            ruleModelId();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNestedModelId604); 

            			doneLeaf(kw, elementTypeProvider.getNestedModelId_FullStopKeyword_1ElementType());
            		

            			markComposite(elementTypeProvider.getNestedModelId_ModelIdParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_ruleNestedModelId616);
            ruleModelId();

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
    // $ANTLR end "ruleNestedModelId"


    // $ANTLR start "entryRuleFraction"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:258:1: entryRuleFraction : ruleFraction EOF ;
    public final void entryRuleFraction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:258:18: ( ruleFraction EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:259:2: ruleFraction EOF
            {
             markComposite(elementTypeProvider.getFractionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFraction_in_entryRuleFraction636);
            ruleFraction();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFraction642); 

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
    // $ANTLR end "entryRuleFraction"


    // $ANTLR start "ruleFraction"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:267:1: ruleFraction : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final void ruleFraction() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:267:13: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:268:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:268:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:269:3: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {

            			markLeaf();
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFraction665); 

            			doneLeaf(this_INT_0, elementTypeProvider.getFraction_INTTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:276:3: (kw= '/' this_INT_2= RULE_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:277:4: kw= '/' this_INT_2= RULE_INT
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFraction685); 

                    				doneLeaf(kw, elementTypeProvider.getFraction_SolidusKeyword_1_0ElementType());
                    			

                    				markLeaf();
                    			
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFraction702); 

                    				doneLeaf(this_INT_2, elementTypeProvider.getFraction_INTTerminalRuleCall_1_1ElementType());
                    			

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
    // $ANTLR end "ruleFraction"


    // $ANTLR start "entryRuleVector"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:296:1: entryRuleVector : ruleVector EOF ;
    public final void entryRuleVector() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:296:16: ( ruleVector EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:297:2: ruleVector EOF
            {
             markComposite(elementTypeProvider.getVectorElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleVector_in_entryRuleVector728);
            ruleVector();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVector734); 

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
    // $ANTLR end "entryRuleVector"


    // $ANTLR start "ruleVector"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:305:1: ruleVector : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final void ruleVector() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:305:11: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:306:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:306:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:307:3: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
            {

            			markLeaf();
            		
            kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleVector757); 

            			doneLeaf(kw, elementTypeProvider.getVector_LeftParenthesisKeyword_0ElementType());
            		

            			markLeaf();
            		
            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVector771); 

            			doneLeaf(this_INT_1, elementTypeProvider.getVector_INTTerminalRuleCall_1ElementType());
            		

            			markLeaf();
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVector785); 

            			doneLeaf(this_INT_2, elementTypeProvider.getVector_INTTerminalRuleCall_2ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleVector799); 

            			doneLeaf(kw, elementTypeProvider.getVector_RightParenthesisKeyword_3ElementType());
            		

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
    // $ANTLR end "ruleVector"


    // $ANTLR start "entryRuleDots"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:339:1: entryRuleDots : ruleDots EOF ;
    public final void entryRuleDots() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:339:14: ( ruleDots EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:340:2: ruleDots EOF
            {
             markComposite(elementTypeProvider.getDotsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDots_in_entryRuleDots819);
            ruleDots();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDots825); 

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
    // $ANTLR end "entryRuleDots"


    // $ANTLR start "ruleDots"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:348:1: ruleDots : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final void ruleDots() throws RecognitionException {
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:348:9: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:349:2: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:349:2: ( (kw= '.' kw= '.' ) | kw= '..' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:350:3: (kw= '.' kw= '.' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:350:3: (kw= '.' kw= '.' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:351:4: kw= '.' kw= '.'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDots854); 

                    				doneLeaf(kw, elementTypeProvider.getDots_FullStopKeyword_0_0ElementType());
                    			

                    				markLeaf();
                    			
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDots871); 

                    				doneLeaf(kw, elementTypeProvider.getDots_FullStopKeyword_0_1ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:367:3: kw= '..'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleDots898); 

                    			doneLeaf(kw, elementTypeProvider.getDots_FullStopFullStopKeyword_1ElementType());
                    		

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
    // $ANTLR end "ruleDots"


    // $ANTLR start "entryRuleDouble"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:378:1: entryRuleDouble : ruleDouble EOF ;
    public final void entryRuleDouble() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:378:16: ( ruleDouble EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:379:2: ruleDouble EOF
            {
             markComposite(elementTypeProvider.getDoubleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDouble_in_entryRuleDouble918);
            ruleDouble();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDouble924); 

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
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:387:1: ruleDouble : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) ;
    public final void ruleDouble() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:387:11: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:388:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:388:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:389:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:389:3: (kw= '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:390:4: kw= '-'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDouble953); 

                    				doneLeaf(kw, elementTypeProvider.getDouble_HyphenMinusKeyword_0ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:398:3: (this_INT_1= RULE_INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:399:4: this_INT_1= RULE_INT
                    {

                    				markLeaf();
                    			
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble979); 

                    				doneLeaf(this_INT_1, elementTypeProvider.getDouble_INTTerminalRuleCall_1ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDouble999); 

            			doneLeaf(kw, elementTypeProvider.getDouble_FullStopKeyword_2ElementType());
            		

            			markLeaf();
            		
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1013); 

            			doneLeaf(this_INT_3, elementTypeProvider.getDouble_INTTerminalRuleCall_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:421:3: (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:422:4: kw= 'E' (kw= '-' )? this_INT_6= RULE_INT
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleDouble1033); 

                    				doneLeaf(kw, elementTypeProvider.getDouble_EKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:429:4: (kw= '-' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:430:5: kw= '-'
                            {

                            					markLeaf();
                            				
                            kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDouble1057); 

                            					doneLeaf(kw, elementTypeProvider.getDouble_HyphenMinusKeyword_4_1ElementType());
                            				

                            }
                            break;

                    }


                    				markLeaf();
                    			
                    this_INT_6=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1081); 

                    				doneLeaf(this_INT_6, elementTypeProvider.getDouble_INTTerminalRuleCall_4_2ElementType());
                    			

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
    // $ANTLR end "ruleDouble"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleCompositeModel_in_entryRuleCompositeModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel89 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel157 = new BitSet(new long[]{0x000000000000F800L});
        public static final BitSet FOLLOW_11_in_ruleModel188 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleFraction_in_ruleModel220 = new BitSet(new long[]{0x000000000000F000L});
        public static final BitSet FOLLOW_12_in_ruleModel259 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleVector_in_ruleModel291 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_13_in_ruleModel330 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_ruleDots_in_ruleModel362 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleModel401 = new BitSet(new long[]{0x0000000000210020L});
        public static final BitSet FOLLOW_ruleDouble_in_ruleModel433 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModel466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId486 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelId492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelId515 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleModelId529 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelId543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId563 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId590 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleNestedModelId604 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction636 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFraction642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFraction665 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleFraction685 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFraction702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVector_in_entryRuleVector728 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVector734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleVector757 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVector771 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVector785 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleVector799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDots_in_entryRuleDots819 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDots825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDots854 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDots871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleDots898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble918 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDouble924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleDouble953 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble979 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDouble999 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1013 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleDouble1033 = new BitSet(new long[]{0x0000000000200020L});
        public static final BitSet FOLLOW_21_in_ruleDouble1057 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1081 = new BitSet(new long[]{0x0000000000000002L});
    }


}