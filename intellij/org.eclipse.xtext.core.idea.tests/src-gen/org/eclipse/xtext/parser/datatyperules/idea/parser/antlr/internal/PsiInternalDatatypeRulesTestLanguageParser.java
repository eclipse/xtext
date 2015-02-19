package org.eclipse.xtext.parser.datatyperules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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



    	protected DatatypeRulesTestLanguageGrammarAccess grammarAccess;

    	protected DatatypeRulesTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalDatatypeRulesTestLanguageParser(PsiBuilder builder, TokenStream input, DatatypeRulesTestLanguageElementTypeProvider elementTypeProvider, DatatypeRulesTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "CompositeModel";
    	}




    // $ANTLR start "entryRuleCompositeModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:52:1: entryRuleCompositeModel : ruleCompositeModel EOF ;
    public final void entryRuleCompositeModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:52:24: ( ruleCompositeModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:53:2: ruleCompositeModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:59:1: ruleCompositeModel : ( (lv_model_0_0= ruleModel ) )+ ;
    public final void ruleCompositeModel() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:62:2: ( ( (lv_model_0_0= ruleModel ) )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:63:2: ( (lv_model_0_0= ruleModel ) )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:63:2: ( (lv_model_0_0= ruleModel ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:64:3: (lv_model_0_0= ruleModel )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:64:3: (lv_model_0_0= ruleModel )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:65:4: lv_model_0_0= ruleModel
            	    {

            	    				markComposite(elementTypeProvider.getCompositeModel_ModelModelParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleModel_in_ruleCompositeModel94);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:77:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:77:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:78:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel120);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel126); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:84:1: ruleModel : ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:87:2: ( ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:88:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:88:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:89:3: ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:89:3: ( (lv_id_0_0= ruleNestedModelId ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:90:4: (lv_id_0_0= ruleNestedModelId )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:90:4: (lv_id_0_0= ruleNestedModelId )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:91:5: lv_id_0_0= ruleNestedModelId
            {

            					markComposite(elementTypeProvider.getModel_IdNestedModelIdParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleNestedModelId_in_ruleModel167);
            ruleNestedModelId();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:100:3: (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:101:4: otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) )
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel198); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getModel_ColonKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:108:4: ( (lv_value_2_0= ruleFraction ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:109:5: (lv_value_2_0= ruleFraction )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:109:5: (lv_value_2_0= ruleFraction )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:110:6: lv_value_2_0= ruleFraction
                    {

                    						markComposite(elementTypeProvider.getModel_ValueFractionParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleFraction_in_ruleModel230);
                    ruleFraction();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:120:3: (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:121:4: otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) )
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel269); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getModel_NumberSignKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:128:4: ( (lv_vector_4_0= ruleVector ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:129:5: (lv_vector_4_0= ruleVector )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:129:5: (lv_vector_4_0= ruleVector )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:130:6: lv_vector_4_0= ruleVector
                    {

                    						markComposite(elementTypeProvider.getModel_VectorVectorParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleVector_in_ruleModel301);
                    ruleVector();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:140:3: (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:141:4: otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) )
                    {

                    				markLeaf();
                    			
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel340); 

                    				doneLeaf(otherlv_5, elementTypeProvider.getModel_PlusSignKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:148:4: ( (lv_dots_6_0= ruleDots ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:149:5: (lv_dots_6_0= ruleDots )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:149:5: (lv_dots_6_0= ruleDots )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:150:6: lv_dots_6_0= ruleDots
                    {

                    						markComposite(elementTypeProvider.getModel_DotsDotsParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDots_in_ruleModel372);
                    ruleDots();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:160:3: (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:161:4: otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) )
                    {

                    				markLeaf();
                    			
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel411); 

                    				doneLeaf(otherlv_7, elementTypeProvider.getModel_AsteriskKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:168:4: ( (lv_double_8_0= ruleDouble ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:169:5: (lv_double_8_0= ruleDouble )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:169:5: (lv_double_8_0= ruleDouble )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:170:6: lv_double_8_0= ruleDouble
                    {

                    						markComposite(elementTypeProvider.getModel_DoubleDoubleParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDouble_in_ruleModel443);
                    ruleDouble();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel476); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:191:1: entryRuleModelId : ruleModelId EOF ;
    public final void entryRuleModelId() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:191:17: ( ruleModelId EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:192:2: ruleModelId EOF
            {
             markComposite(elementTypeProvider.getModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_entryRuleModelId496);
            ruleModelId();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelId502); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:198:1: ruleModelId : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final void ruleModelId() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:201:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:202:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:202:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:203:3: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelId530); 

            			doneLeaf(this_ID_0, elementTypeProvider.getModelId_IDTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModelId544); 

            			doneLeaf(kw, elementTypeProvider.getModelId_FullStopKeyword_1ElementType());
            		

            			markLeaf();
            		
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelId558); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:228:1: entryRuleNestedModelId : ruleNestedModelId EOF ;
    public final void entryRuleNestedModelId() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:228:23: ( ruleNestedModelId EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:229:2: ruleNestedModelId EOF
            {
             markComposite(elementTypeProvider.getNestedModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId578);
            ruleNestedModelId();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedModelId584); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:235:1: ruleNestedModelId : ( ruleModelId kw= '.' ruleModelId ) ;
    public final void ruleNestedModelId() throws RecognitionException {
        Token kw=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:238:2: ( ( ruleModelId kw= '.' ruleModelId ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:239:2: ( ruleModelId kw= '.' ruleModelId )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:239:2: ( ruleModelId kw= '.' ruleModelId )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:240:3: ruleModelId kw= '.' ruleModelId
            {

            			markComposite(elementTypeProvider.getNestedModelId_ModelIdParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_ruleNestedModelId610);
            ruleModelId();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNestedModelId624); 

            			doneLeaf(kw, elementTypeProvider.getNestedModelId_FullStopKeyword_1ElementType());
            		

            			markComposite(elementTypeProvider.getNestedModelId_ModelIdParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleModelId_in_ruleNestedModelId636);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:265:1: entryRuleFraction : ruleFraction EOF ;
    public final void entryRuleFraction() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:265:18: ( ruleFraction EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:266:2: ruleFraction EOF
            {
             markComposite(elementTypeProvider.getFractionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleFraction_in_entryRuleFraction656);
            ruleFraction();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFraction662); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:272:1: ruleFraction : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final void ruleFraction() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:275:2: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:276:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:276:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:277:3: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {

            			markLeaf();
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFraction690); 

            			doneLeaf(this_INT_0, elementTypeProvider.getFraction_INTTerminalRuleCall_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:284:3: (kw= '/' this_INT_2= RULE_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:285:4: kw= '/' this_INT_2= RULE_INT
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFraction710); 

                    				doneLeaf(kw, elementTypeProvider.getFraction_SolidusKeyword_1_0ElementType());
                    			

                    				markLeaf();
                    			
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleFraction727); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:304:1: entryRuleVector : ruleVector EOF ;
    public final void entryRuleVector() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:304:16: ( ruleVector EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:305:2: ruleVector EOF
            {
             markComposite(elementTypeProvider.getVectorElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleVector_in_entryRuleVector753);
            ruleVector();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVector759); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:311:1: ruleVector : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final void ruleVector() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:314:2: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:315:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:315:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:316:3: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
            {

            			markLeaf();
            		
            kw=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleVector787); 

            			doneLeaf(kw, elementTypeProvider.getVector_LeftParenthesisKeyword_0ElementType());
            		

            			markLeaf();
            		
            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVector801); 

            			doneLeaf(this_INT_1, elementTypeProvider.getVector_INTTerminalRuleCall_1ElementType());
            		

            			markLeaf();
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVector815); 

            			doneLeaf(this_INT_2, elementTypeProvider.getVector_INTTerminalRuleCall_2ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleVector829); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:348:1: entryRuleDots : ruleDots EOF ;
    public final void entryRuleDots() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:348:14: ( ruleDots EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:349:2: ruleDots EOF
            {
             markComposite(elementTypeProvider.getDotsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDots_in_entryRuleDots849);
            ruleDots();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDots855); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:355:1: ruleDots : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final void ruleDots() throws RecognitionException {
        Token kw=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:358:2: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:359:2: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:359:2: ( (kw= '.' kw= '.' ) | kw= '..' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:360:3: (kw= '.' kw= '.' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:360:3: (kw= '.' kw= '.' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:361:4: kw= '.' kw= '.'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDots889); 

                    				doneLeaf(kw, elementTypeProvider.getDots_FullStopKeyword_0_0ElementType());
                    			

                    				markLeaf();
                    			
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDots906); 

                    				doneLeaf(kw, elementTypeProvider.getDots_FullStopKeyword_0_1ElementType());
                    			

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:377:3: kw= '..'
                    {

                    			markLeaf();
                    		
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleDots933); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:388:1: entryRuleDouble : ruleDouble EOF ;
    public final void entryRuleDouble() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:388:16: ( ruleDouble EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:389:2: ruleDouble EOF
            {
             markComposite(elementTypeProvider.getDoubleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDouble_in_entryRuleDouble953);
            ruleDouble();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDouble959); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:395:1: ruleDouble : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) ;
    public final void ruleDouble() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_6=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:398:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:399:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:399:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:400:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:400:3: (kw= '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:401:4: kw= '-'
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDouble993); 

                    				doneLeaf(kw, elementTypeProvider.getDouble_HyphenMinusKeyword_0ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:409:3: (this_INT_1= RULE_INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:410:4: this_INT_1= RULE_INT
                    {

                    				markLeaf();
                    			
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1019); 

                    				doneLeaf(this_INT_1, elementTypeProvider.getDouble_INTTerminalRuleCall_1ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDouble1039); 

            			doneLeaf(kw, elementTypeProvider.getDouble_FullStopKeyword_2ElementType());
            		

            			markLeaf();
            		
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1053); 

            			doneLeaf(this_INT_3, elementTypeProvider.getDouble_INTTerminalRuleCall_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:432:3: (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:433:4: kw= 'E' (kw= '-' )? this_INT_6= RULE_INT
                    {

                    				markLeaf();
                    			
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleDouble1073); 

                    				doneLeaf(kw, elementTypeProvider.getDouble_EKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:440:4: (kw= '-' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/datatyperules/idea/parser/antlr/internal/PsiInternalDatatypeRulesTestLanguage.g:441:5: kw= '-'
                            {

                            					markLeaf();
                            				
                            kw=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDouble1097); 

                            					doneLeaf(kw, elementTypeProvider.getDouble_HyphenMinusKeyword_4_1ElementType());
                            				

                            }
                            break;

                    }


                    				markLeaf();
                    			
                    this_INT_6=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDouble1121); 

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
        public static final BitSet FOLLOW_ruleModel_in_ruleCompositeModel94 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedModelId_in_ruleModel167 = new BitSet(new long[]{0x000000000000F800L});
        public static final BitSet FOLLOW_11_in_ruleModel198 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleFraction_in_ruleModel230 = new BitSet(new long[]{0x000000000000F000L});
        public static final BitSet FOLLOW_12_in_ruleModel269 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleVector_in_ruleModel301 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_13_in_ruleModel340 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_ruleDots_in_ruleModel372 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleModel411 = new BitSet(new long[]{0x0000000000210020L});
        public static final BitSet FOLLOW_ruleDouble_in_ruleModel443 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModel476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelId_in_entryRuleModelId496 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelId502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelId530 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleModelId544 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelId558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedModelId_in_entryRuleNestedModelId578 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedModelId584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId610 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleNestedModelId624 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleModelId_in_ruleNestedModelId636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFraction_in_entryRuleFraction656 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFraction662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFraction690 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleFraction710 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleFraction727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVector_in_entryRuleVector753 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVector759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleVector787 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVector801 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVector815 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleVector829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDots_in_entryRuleDots849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDots855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleDots889 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDots906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleDots933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDouble_in_entryRuleDouble953 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDouble959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleDouble993 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1019 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDouble1039 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1053 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleDouble1073 = new BitSet(new long[]{0x0000000000200020L});
        public static final BitSet FOLLOW_21_in_ruleDouble1097 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDouble1121 = new BitSet(new long[]{0x0000000000000002L});
    }


}