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
    public String getGrammarFileName() { return "PsiInternalDatatypeRulesTestLanguage.g"; }



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
    // PsiInternalDatatypeRulesTestLanguage.g:52:1: entryRuleCompositeModel : ruleCompositeModel EOF ;
    public final void entryRuleCompositeModel() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:52:24: ( ruleCompositeModel EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:53:2: ruleCompositeModel EOF
            {
             markComposite(elementTypeProvider.getCompositeModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCompositeModel();

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
    // $ANTLR end "entryRuleCompositeModel"


    // $ANTLR start "ruleCompositeModel"
    // PsiInternalDatatypeRulesTestLanguage.g:58:1: ruleCompositeModel : ( (lv_model_0_0= ruleModel ) )+ ;
    public final void ruleCompositeModel() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:58:19: ( ( (lv_model_0_0= ruleModel ) )+ )
            // PsiInternalDatatypeRulesTestLanguage.g:59:2: ( (lv_model_0_0= ruleModel ) )+
            {
            // PsiInternalDatatypeRulesTestLanguage.g:59:2: ( (lv_model_0_0= ruleModel ) )+
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
            	    // PsiInternalDatatypeRulesTestLanguage.g:60:3: (lv_model_0_0= ruleModel )
            	    {
            	    // PsiInternalDatatypeRulesTestLanguage.g:60:3: (lv_model_0_0= ruleModel )
            	    // PsiInternalDatatypeRulesTestLanguage.g:61:4: lv_model_0_0= ruleModel
            	    {

            	    				markComposite(elementTypeProvider.getCompositeModel_ModelModelParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
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
    // PsiInternalDatatypeRulesTestLanguage.g:73:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:73:15: ( ruleModel EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:74:2: ruleModel EOF
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
    // PsiInternalDatatypeRulesTestLanguage.g:79:1: ruleModel : ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:79:10: ( ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) )
            // PsiInternalDatatypeRulesTestLanguage.g:80:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:80:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            // PsiInternalDatatypeRulesTestLanguage.g:81:3: ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';'
            {
            // PsiInternalDatatypeRulesTestLanguage.g:81:3: ( (lv_id_0_0= ruleNestedModelId ) )
            // PsiInternalDatatypeRulesTestLanguage.g:82:4: (lv_id_0_0= ruleNestedModelId )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:82:4: (lv_id_0_0= ruleNestedModelId )
            // PsiInternalDatatypeRulesTestLanguage.g:83:5: lv_id_0_0= ruleNestedModelId
            {

            					markComposite(elementTypeProvider.getModel_IdNestedModelIdParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            ruleNestedModelId();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalDatatypeRulesTestLanguage.g:92:3: (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:93:4: otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_ColonKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:100:4: ( (lv_value_2_0= ruleFraction ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:101:5: (lv_value_2_0= ruleFraction )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:101:5: (lv_value_2_0= ruleFraction )
                    // PsiInternalDatatypeRulesTestLanguage.g:102:6: lv_value_2_0= ruleFraction
                    {

                    						markComposite(elementTypeProvider.getModel_ValueFractionParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_6);
                    ruleFraction();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalDatatypeRulesTestLanguage.g:112:3: (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:113:4: otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignKeyword_2_0ElementType());
                    			
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:120:4: ( (lv_vector_4_0= ruleVector ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:121:5: (lv_vector_4_0= ruleVector )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:121:5: (lv_vector_4_0= ruleVector )
                    // PsiInternalDatatypeRulesTestLanguage.g:122:6: lv_vector_4_0= ruleVector
                    {

                    						markComposite(elementTypeProvider.getModel_VectorVectorParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_8);
                    ruleVector();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalDatatypeRulesTestLanguage.g:132:3: (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:133:4: otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_PlusSignKeyword_3_0ElementType());
                    			
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_9); 

                    				doneLeaf(otherlv_5);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:140:4: ( (lv_dots_6_0= ruleDots ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:141:5: (lv_dots_6_0= ruleDots )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:141:5: (lv_dots_6_0= ruleDots )
                    // PsiInternalDatatypeRulesTestLanguage.g:142:6: lv_dots_6_0= ruleDots
                    {

                    						markComposite(elementTypeProvider.getModel_DotsDotsParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    ruleDots();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalDatatypeRulesTestLanguage.g:152:3: (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:153:4: otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_AsteriskKeyword_4_0ElementType());
                    			
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_7);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:160:4: ( (lv_double_8_0= ruleDouble ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:161:5: (lv_double_8_0= ruleDouble )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:161:5: (lv_double_8_0= ruleDouble )
                    // PsiInternalDatatypeRulesTestLanguage.g:162:6: lv_double_8_0= ruleDouble
                    {

                    						markComposite(elementTypeProvider.getModel_DoubleDoubleParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_12);
                    ruleDouble();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getModel_SemicolonKeyword_5ElementType());
            		
            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_9);
            		

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
    // PsiInternalDatatypeRulesTestLanguage.g:183:1: entryRuleModelId : ruleModelId EOF ;
    public final void entryRuleModelId() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:183:17: ( ruleModelId EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:184:2: ruleModelId EOF
            {
             markComposite(elementTypeProvider.getModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModelId();

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
    // $ANTLR end "entryRuleModelId"


    // $ANTLR start "ruleModelId"
    // PsiInternalDatatypeRulesTestLanguage.g:189:1: ruleModelId : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final void ruleModelId() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:189:12: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // PsiInternalDatatypeRulesTestLanguage.g:190:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:190:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // PsiInternalDatatypeRulesTestLanguage.g:191:3: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {

            			markLeaf(elementTypeProvider.getModelId_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            			doneLeaf(this_ID_0);
            		

            			markLeaf(elementTypeProvider.getModelId_FullStopKeyword_1ElementType());
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_14); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getModelId_IDTerminalRuleCall_2ElementType());
            		
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			doneLeaf(this_ID_2);
            		

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
    // PsiInternalDatatypeRulesTestLanguage.g:216:1: entryRuleNestedModelId : ruleNestedModelId EOF ;
    public final void entryRuleNestedModelId() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:216:23: ( ruleNestedModelId EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:217:2: ruleNestedModelId EOF
            {
             markComposite(elementTypeProvider.getNestedModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNestedModelId();

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
    // $ANTLR end "entryRuleNestedModelId"


    // $ANTLR start "ruleNestedModelId"
    // PsiInternalDatatypeRulesTestLanguage.g:222:1: ruleNestedModelId : ( ruleModelId kw= '.' ruleModelId ) ;
    public final void ruleNestedModelId() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:222:18: ( ( ruleModelId kw= '.' ruleModelId ) )
            // PsiInternalDatatypeRulesTestLanguage.g:223:2: ( ruleModelId kw= '.' ruleModelId )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:223:2: ( ruleModelId kw= '.' ruleModelId )
            // PsiInternalDatatypeRulesTestLanguage.g:224:3: ruleModelId kw= '.' ruleModelId
            {

            			markComposite(elementTypeProvider.getNestedModelId_ModelIdParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_13);
            ruleModelId();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getNestedModelId_FullStopKeyword_1ElementType());
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_14); 

            			doneLeaf(kw);
            		

            			markComposite(elementTypeProvider.getNestedModelId_ModelIdParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalDatatypeRulesTestLanguage.g:249:1: entryRuleFraction : ruleFraction EOF ;
    public final void entryRuleFraction() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:249:18: ( ruleFraction EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:250:2: ruleFraction EOF
            {
             markComposite(elementTypeProvider.getFractionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFraction();

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
    // $ANTLR end "entryRuleFraction"


    // $ANTLR start "ruleFraction"
    // PsiInternalDatatypeRulesTestLanguage.g:255:1: ruleFraction : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final void ruleFraction() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:255:13: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // PsiInternalDatatypeRulesTestLanguage.g:256:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:256:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // PsiInternalDatatypeRulesTestLanguage.g:257:3: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {

            			markLeaf(elementTypeProvider.getFraction_INTTerminalRuleCall_0ElementType());
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_15); 

            			doneLeaf(this_INT_0);
            		
            // PsiInternalDatatypeRulesTestLanguage.g:264:3: (kw= '/' this_INT_2= RULE_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:265:4: kw= '/' this_INT_2= RULE_INT
                    {

                    				markLeaf(elementTypeProvider.getFraction_SolidusKeyword_1_0ElementType());
                    			
                    kw=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				doneLeaf(kw);
                    			

                    				markLeaf(elementTypeProvider.getFraction_INTTerminalRuleCall_1_1ElementType());
                    			
                    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    				doneLeaf(this_INT_2);
                    			

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
    // PsiInternalDatatypeRulesTestLanguage.g:284:1: entryRuleVector : ruleVector EOF ;
    public final void entryRuleVector() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:284:16: ( ruleVector EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:285:2: ruleVector EOF
            {
             markComposite(elementTypeProvider.getVectorElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleVector();

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
    // $ANTLR end "entryRuleVector"


    // $ANTLR start "ruleVector"
    // PsiInternalDatatypeRulesTestLanguage.g:290:1: ruleVector : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final void ruleVector() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:290:11: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // PsiInternalDatatypeRulesTestLanguage.g:291:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:291:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // PsiInternalDatatypeRulesTestLanguage.g:292:3: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
            {

            			markLeaf(elementTypeProvider.getVector_LeftParenthesisKeyword_0ElementType());
            		
            kw=(Token)match(input,18,FollowSets000.FOLLOW_5); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getVector_INTTerminalRuleCall_1ElementType());
            		
            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_5); 

            			doneLeaf(this_INT_1);
            		

            			markLeaf(elementTypeProvider.getVector_INTTerminalRuleCall_2ElementType());
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_16); 

            			doneLeaf(this_INT_2);
            		

            			markLeaf(elementTypeProvider.getVector_RightParenthesisKeyword_3ElementType());
            		
            kw=(Token)match(input,19,FollowSets000.FOLLOW_2); 

            			doneLeaf(kw);
            		

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
    // PsiInternalDatatypeRulesTestLanguage.g:324:1: entryRuleDots : ruleDots EOF ;
    public final void entryRuleDots() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:324:14: ( ruleDots EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:325:2: ruleDots EOF
            {
             markComposite(elementTypeProvider.getDotsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDots();

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
    // $ANTLR end "entryRuleDots"


    // $ANTLR start "ruleDots"
    // PsiInternalDatatypeRulesTestLanguage.g:330:1: ruleDots : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final void ruleDots() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:330:9: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // PsiInternalDatatypeRulesTestLanguage.g:331:2: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:331:2: ( (kw= '.' kw= '.' ) | kw= '..' )
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
                    // PsiInternalDatatypeRulesTestLanguage.g:332:3: (kw= '.' kw= '.' )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:332:3: (kw= '.' kw= '.' )
                    // PsiInternalDatatypeRulesTestLanguage.g:333:4: kw= '.' kw= '.'
                    {

                    				markLeaf(elementTypeProvider.getDots_FullStopKeyword_0_0ElementType());
                    			
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_13); 

                    				doneLeaf(kw);
                    			

                    				markLeaf(elementTypeProvider.getDots_FullStopKeyword_0_1ElementType());
                    			
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                    				doneLeaf(kw);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalDatatypeRulesTestLanguage.g:349:3: kw= '..'
                    {

                    			markLeaf(elementTypeProvider.getDots_FullStopFullStopKeyword_1ElementType());
                    		
                    kw=(Token)match(input,20,FollowSets000.FOLLOW_2); 

                    			doneLeaf(kw);
                    		

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
    // PsiInternalDatatypeRulesTestLanguage.g:360:1: entryRuleDouble : ruleDouble EOF ;
    public final void entryRuleDouble() throws RecognitionException {
        try {
            // PsiInternalDatatypeRulesTestLanguage.g:360:16: ( ruleDouble EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:361:2: ruleDouble EOF
            {
             markComposite(elementTypeProvider.getDoubleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDouble();

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
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // PsiInternalDatatypeRulesTestLanguage.g:366:1: ruleDouble : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) ;
    public final void ruleDouble() throws RecognitionException {
        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_6=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:366:11: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) )
            // PsiInternalDatatypeRulesTestLanguage.g:367:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:367:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            // PsiInternalDatatypeRulesTestLanguage.g:368:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            {
            // PsiInternalDatatypeRulesTestLanguage.g:368:3: (kw= '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:369:4: kw= '-'
                    {

                    				markLeaf(elementTypeProvider.getDouble_HyphenMinusKeyword_0ElementType());
                    			
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_17); 

                    				doneLeaf(kw);
                    			

                    }
                    break;

            }

            // PsiInternalDatatypeRulesTestLanguage.g:377:3: (this_INT_1= RULE_INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:378:4: this_INT_1= RULE_INT
                    {

                    				markLeaf(elementTypeProvider.getDouble_INTTerminalRuleCall_1ElementType());
                    			
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_13); 

                    				doneLeaf(this_INT_1);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getDouble_FullStopKeyword_2ElementType());
            		
            kw=(Token)match(input,16,FollowSets000.FOLLOW_5); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getDouble_INTTerminalRuleCall_3ElementType());
            		
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_18); 

            			doneLeaf(this_INT_3);
            		
            // PsiInternalDatatypeRulesTestLanguage.g:400:3: (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:401:4: kw= 'E' (kw= '-' )? this_INT_6= RULE_INT
                    {

                    				markLeaf(elementTypeProvider.getDouble_EKeyword_4_0ElementType());
                    			
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_19); 

                    				doneLeaf(kw);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:408:4: (kw= '-' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // PsiInternalDatatypeRulesTestLanguage.g:409:5: kw= '-'
                            {

                            					markLeaf(elementTypeProvider.getDouble_HyphenMinusKeyword_4_1ElementType());
                            				
                            kw=(Token)match(input,21,FollowSets000.FOLLOW_5); 

                            					doneLeaf(kw);
                            				

                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getDouble_INTTerminalRuleCall_4_2ElementType());
                    			
                    this_INT_6=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    				doneLeaf(this_INT_6);
                    			

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000F800L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000F000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000E000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000110000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000210020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200020L});
    }


}