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
    // PsiInternalDatatypeRulesTestLanguage.g:52:1: entryRuleCompositeModel returns [Boolean current=false] : iv_ruleCompositeModel= ruleCompositeModel EOF ;
    public final Boolean entryRuleCompositeModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCompositeModel = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:52:56: (iv_ruleCompositeModel= ruleCompositeModel EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:53:2: iv_ruleCompositeModel= ruleCompositeModel EOF
            {
             markComposite(elementTypeProvider.getCompositeModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCompositeModel=ruleCompositeModel();

            state._fsp--;

             current =iv_ruleCompositeModel; 
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
    // $ANTLR end "entryRuleCompositeModel"


    // $ANTLR start "ruleCompositeModel"
    // PsiInternalDatatypeRulesTestLanguage.g:59:1: ruleCompositeModel returns [Boolean current=false] : ( (lv_model_0_0= ruleModel ) )+ ;
    public final Boolean ruleCompositeModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_model_0_0 = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:60:1: ( ( (lv_model_0_0= ruleModel ) )+ )
            // PsiInternalDatatypeRulesTestLanguage.g:61:2: ( (lv_model_0_0= ruleModel ) )+
            {
            // PsiInternalDatatypeRulesTestLanguage.g:61:2: ( (lv_model_0_0= ruleModel ) )+
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
            	    // PsiInternalDatatypeRulesTestLanguage.g:62:3: (lv_model_0_0= ruleModel )
            	    {
            	    // PsiInternalDatatypeRulesTestLanguage.g:62:3: (lv_model_0_0= ruleModel )
            	    // PsiInternalDatatypeRulesTestLanguage.g:63:4: lv_model_0_0= ruleModel
            	    {

            	    				markComposite(elementTypeProvider.getCompositeModel_ModelModelParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_model_0_0=ruleModel();

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
        return current;
    }
    // $ANTLR end "ruleCompositeModel"


    // $ANTLR start "entryRuleModel"
    // PsiInternalDatatypeRulesTestLanguage.g:79:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:79:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:80:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalDatatypeRulesTestLanguage.g:86:1: ruleModel returns [Boolean current=false] : ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Boolean lv_id_0_0 = null;

        Boolean lv_value_2_0 = null;

        Boolean lv_vector_4_0 = null;

        Boolean lv_dots_6_0 = null;

        Boolean lv_double_8_0 = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:87:1: ( ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' ) )
            // PsiInternalDatatypeRulesTestLanguage.g:88:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:88:2: ( ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';' )
            // PsiInternalDatatypeRulesTestLanguage.g:89:3: ( (lv_id_0_0= ruleNestedModelId ) ) (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )? (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )? (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )? (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )? otherlv_9= ';'
            {
            // PsiInternalDatatypeRulesTestLanguage.g:89:3: ( (lv_id_0_0= ruleNestedModelId ) )
            // PsiInternalDatatypeRulesTestLanguage.g:90:4: (lv_id_0_0= ruleNestedModelId )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:90:4: (lv_id_0_0= ruleNestedModelId )
            // PsiInternalDatatypeRulesTestLanguage.g:91:5: lv_id_0_0= ruleNestedModelId
            {

            					markComposite(elementTypeProvider.getModel_IdNestedModelIdParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_4);
            lv_id_0_0=ruleNestedModelId();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalDatatypeRulesTestLanguage.g:104:3: (otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:105:4: otherlv_1= ':' ( (lv_value_2_0= ruleFraction ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_ColonKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:112:4: ( (lv_value_2_0= ruleFraction ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:113:5: (lv_value_2_0= ruleFraction )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:113:5: (lv_value_2_0= ruleFraction )
                    // PsiInternalDatatypeRulesTestLanguage.g:114:6: lv_value_2_0= ruleFraction
                    {

                    						markComposite(elementTypeProvider.getModel_ValueFractionParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_value_2_0=ruleFraction();

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

            // PsiInternalDatatypeRulesTestLanguage.g:128:3: (otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:129:4: otherlv_3= '#' ( (lv_vector_4_0= ruleVector ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_NumberSignKeyword_2_0ElementType());
                    			
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_7); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:136:4: ( (lv_vector_4_0= ruleVector ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:137:5: (lv_vector_4_0= ruleVector )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:137:5: (lv_vector_4_0= ruleVector )
                    // PsiInternalDatatypeRulesTestLanguage.g:138:6: lv_vector_4_0= ruleVector
                    {

                    						markComposite(elementTypeProvider.getModel_VectorVectorParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_8);
                    lv_vector_4_0=ruleVector();

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

            // PsiInternalDatatypeRulesTestLanguage.g:152:3: (otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:153:4: otherlv_5= '+' ( (lv_dots_6_0= ruleDots ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_PlusSignKeyword_3_0ElementType());
                    			
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_9); 

                    				doneLeaf(otherlv_5);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:160:4: ( (lv_dots_6_0= ruleDots ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:161:5: (lv_dots_6_0= ruleDots )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:161:5: (lv_dots_6_0= ruleDots )
                    // PsiInternalDatatypeRulesTestLanguage.g:162:6: lv_dots_6_0= ruleDots
                    {

                    						markComposite(elementTypeProvider.getModel_DotsDotsParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_10);
                    lv_dots_6_0=ruleDots();

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

            // PsiInternalDatatypeRulesTestLanguage.g:176:3: (otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:177:4: otherlv_7= '*' ( (lv_double_8_0= ruleDouble ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_AsteriskKeyword_4_0ElementType());
                    			
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_11); 

                    				doneLeaf(otherlv_7);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:184:4: ( (lv_double_8_0= ruleDouble ) )
                    // PsiInternalDatatypeRulesTestLanguage.g:185:5: (lv_double_8_0= ruleDouble )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:185:5: (lv_double_8_0= ruleDouble )
                    // PsiInternalDatatypeRulesTestLanguage.g:186:6: lv_double_8_0= ruleDouble
                    {

                    						markComposite(elementTypeProvider.getModel_DoubleDoubleParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_12);
                    lv_double_8_0=ruleDouble();

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelId"
    // PsiInternalDatatypeRulesTestLanguage.g:211:1: entryRuleModelId returns [Boolean current=false] : iv_ruleModelId= ruleModelId EOF ;
    public final Boolean entryRuleModelId() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModelId = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:211:49: (iv_ruleModelId= ruleModelId EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:212:2: iv_ruleModelId= ruleModelId EOF
            {
             markComposite(elementTypeProvider.getModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModelId=ruleModelId();

            state._fsp--;

             current =iv_ruleModelId; 
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
    // $ANTLR end "entryRuleModelId"


    // $ANTLR start "ruleModelId"
    // PsiInternalDatatypeRulesTestLanguage.g:218:1: ruleModelId returns [Boolean current=false] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final Boolean ruleModelId() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:219:1: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // PsiInternalDatatypeRulesTestLanguage.g:220:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:220:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // PsiInternalDatatypeRulesTestLanguage.g:221:3: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
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
        return current;
    }
    // $ANTLR end "ruleModelId"


    // $ANTLR start "entryRuleNestedModelId"
    // PsiInternalDatatypeRulesTestLanguage.g:246:1: entryRuleNestedModelId returns [Boolean current=false] : iv_ruleNestedModelId= ruleNestedModelId EOF ;
    public final Boolean entryRuleNestedModelId() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedModelId = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:246:55: (iv_ruleNestedModelId= ruleNestedModelId EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:247:2: iv_ruleNestedModelId= ruleNestedModelId EOF
            {
             markComposite(elementTypeProvider.getNestedModelIdElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedModelId=ruleNestedModelId();

            state._fsp--;

             current =iv_ruleNestedModelId; 
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
    // $ANTLR end "entryRuleNestedModelId"


    // $ANTLR start "ruleNestedModelId"
    // PsiInternalDatatypeRulesTestLanguage.g:253:1: ruleNestedModelId returns [Boolean current=false] : ( ruleModelId kw= '.' ruleModelId ) ;
    public final Boolean ruleNestedModelId() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:254:1: ( ( ruleModelId kw= '.' ruleModelId ) )
            // PsiInternalDatatypeRulesTestLanguage.g:255:2: ( ruleModelId kw= '.' ruleModelId )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:255:2: ( ruleModelId kw= '.' ruleModelId )
            // PsiInternalDatatypeRulesTestLanguage.g:256:3: ruleModelId kw= '.' ruleModelId
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
        return current;
    }
    // $ANTLR end "ruleNestedModelId"


    // $ANTLR start "entryRuleFraction"
    // PsiInternalDatatypeRulesTestLanguage.g:281:1: entryRuleFraction returns [Boolean current=false] : iv_ruleFraction= ruleFraction EOF ;
    public final Boolean entryRuleFraction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFraction = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:281:50: (iv_ruleFraction= ruleFraction EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:282:2: iv_ruleFraction= ruleFraction EOF
            {
             markComposite(elementTypeProvider.getFractionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFraction=ruleFraction();

            state._fsp--;

             current =iv_ruleFraction; 
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
    // $ANTLR end "entryRuleFraction"


    // $ANTLR start "ruleFraction"
    // PsiInternalDatatypeRulesTestLanguage.g:288:1: ruleFraction returns [Boolean current=false] : (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) ;
    public final Boolean ruleFraction() throws RecognitionException {
        Boolean current = false;

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:289:1: ( (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? ) )
            // PsiInternalDatatypeRulesTestLanguage.g:290:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:290:2: (this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )? )
            // PsiInternalDatatypeRulesTestLanguage.g:291:3: this_INT_0= RULE_INT (kw= '/' this_INT_2= RULE_INT )?
            {

            			markLeaf(elementTypeProvider.getFraction_INTTerminalRuleCall_0ElementType());
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_15); 

            			doneLeaf(this_INT_0);
            		
            // PsiInternalDatatypeRulesTestLanguage.g:298:3: (kw= '/' this_INT_2= RULE_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:299:4: kw= '/' this_INT_2= RULE_INT
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
        return current;
    }
    // $ANTLR end "ruleFraction"


    // $ANTLR start "entryRuleVector"
    // PsiInternalDatatypeRulesTestLanguage.g:318:1: entryRuleVector returns [Boolean current=false] : iv_ruleVector= ruleVector EOF ;
    public final Boolean entryRuleVector() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleVector = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:318:48: (iv_ruleVector= ruleVector EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:319:2: iv_ruleVector= ruleVector EOF
            {
             markComposite(elementTypeProvider.getVectorElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVector=ruleVector();

            state._fsp--;

             current =iv_ruleVector; 
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
    // $ANTLR end "entryRuleVector"


    // $ANTLR start "ruleVector"
    // PsiInternalDatatypeRulesTestLanguage.g:325:1: ruleVector returns [Boolean current=false] : (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) ;
    public final Boolean ruleVector() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:326:1: ( (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' ) )
            // PsiInternalDatatypeRulesTestLanguage.g:327:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:327:2: (kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')' )
            // PsiInternalDatatypeRulesTestLanguage.g:328:3: kw= '(' this_INT_1= RULE_INT this_INT_2= RULE_INT kw= ')'
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
        return current;
    }
    // $ANTLR end "ruleVector"


    // $ANTLR start "entryRuleDots"
    // PsiInternalDatatypeRulesTestLanguage.g:360:1: entryRuleDots returns [Boolean current=false] : iv_ruleDots= ruleDots EOF ;
    public final Boolean entryRuleDots() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDots = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:360:46: (iv_ruleDots= ruleDots EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:361:2: iv_ruleDots= ruleDots EOF
            {
             markComposite(elementTypeProvider.getDotsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDots=ruleDots();

            state._fsp--;

             current =iv_ruleDots; 
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
    // $ANTLR end "entryRuleDots"


    // $ANTLR start "ruleDots"
    // PsiInternalDatatypeRulesTestLanguage.g:367:1: ruleDots returns [Boolean current=false] : ( (kw= '.' kw= '.' ) | kw= '..' ) ;
    public final Boolean ruleDots() throws RecognitionException {
        Boolean current = false;

        Token kw=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:368:1: ( ( (kw= '.' kw= '.' ) | kw= '..' ) )
            // PsiInternalDatatypeRulesTestLanguage.g:369:2: ( (kw= '.' kw= '.' ) | kw= '..' )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:369:2: ( (kw= '.' kw= '.' ) | kw= '..' )
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
                    // PsiInternalDatatypeRulesTestLanguage.g:370:3: (kw= '.' kw= '.' )
                    {
                    // PsiInternalDatatypeRulesTestLanguage.g:370:3: (kw= '.' kw= '.' )
                    // PsiInternalDatatypeRulesTestLanguage.g:371:4: kw= '.' kw= '.'
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
                    // PsiInternalDatatypeRulesTestLanguage.g:387:3: kw= '..'
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
        return current;
    }
    // $ANTLR end "ruleDots"


    // $ANTLR start "entryRuleDouble"
    // PsiInternalDatatypeRulesTestLanguage.g:398:1: entryRuleDouble returns [Boolean current=false] : iv_ruleDouble= ruleDouble EOF ;
    public final Boolean entryRuleDouble() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDouble = null;


        try {
            // PsiInternalDatatypeRulesTestLanguage.g:398:48: (iv_ruleDouble= ruleDouble EOF )
            // PsiInternalDatatypeRulesTestLanguage.g:399:2: iv_ruleDouble= ruleDouble EOF
            {
             markComposite(elementTypeProvider.getDoubleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDouble=ruleDouble();

            state._fsp--;

             current =iv_ruleDouble; 
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
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // PsiInternalDatatypeRulesTestLanguage.g:405:1: ruleDouble returns [Boolean current=false] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) ;
    public final Boolean ruleDouble() throws RecognitionException {
        Boolean current = false;

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_6=null;

        try {
            // PsiInternalDatatypeRulesTestLanguage.g:406:1: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? ) )
            // PsiInternalDatatypeRulesTestLanguage.g:407:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            {
            // PsiInternalDatatypeRulesTestLanguage.g:407:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )? )
            // PsiInternalDatatypeRulesTestLanguage.g:408:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            {
            // PsiInternalDatatypeRulesTestLanguage.g:408:3: (kw= '-' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:409:4: kw= '-'
                    {

                    				markLeaf(elementTypeProvider.getDouble_HyphenMinusKeyword_0ElementType());
                    			
                    kw=(Token)match(input,21,FollowSets000.FOLLOW_17); 

                    				doneLeaf(kw);
                    			

                    }
                    break;

            }

            // PsiInternalDatatypeRulesTestLanguage.g:417:3: (this_INT_1= RULE_INT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:418:4: this_INT_1= RULE_INT
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
            		
            // PsiInternalDatatypeRulesTestLanguage.g:440:3: (kw= 'E' (kw= '-' )? this_INT_6= RULE_INT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalDatatypeRulesTestLanguage.g:441:4: kw= 'E' (kw= '-' )? this_INT_6= RULE_INT
                    {

                    				markLeaf(elementTypeProvider.getDouble_EKeyword_4_0ElementType());
                    			
                    kw=(Token)match(input,22,FollowSets000.FOLLOW_19); 

                    				doneLeaf(kw);
                    			
                    // PsiInternalDatatypeRulesTestLanguage.g:448:4: (kw= '-' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==21) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // PsiInternalDatatypeRulesTestLanguage.g:449:5: kw= '-'
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
        return current;
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