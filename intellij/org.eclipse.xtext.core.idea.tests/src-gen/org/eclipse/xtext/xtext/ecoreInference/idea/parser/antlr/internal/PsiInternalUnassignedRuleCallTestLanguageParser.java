package org.eclipse.xtext.xtext.ecoreInference.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.xtext.ecoreInference.services.UnassignedRuleCallTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalUnassignedRuleCallTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "'feature'", "';'", "'keyword'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=4;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalUnassignedRuleCallTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalUnassignedRuleCallTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalUnassignedRuleCallTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalUnassignedRuleCallTestLanguage.g"; }



    	protected UnassignedRuleCallTestLanguageGrammarAccess grammarAccess;

    	protected UnassignedRuleCallTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalUnassignedRuleCallTestLanguageParser(PsiBuilder builder, TokenStream input, UnassignedRuleCallTestLanguageElementTypeProvider elementTypeProvider, UnassignedRuleCallTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalUnassignedRuleCallTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalUnassignedRuleCallTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalUnassignedRuleCallTestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalUnassignedRuleCallTestLanguage.g:58:1: ruleModel : (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token this_INT_1=null;

        try {
            // PsiInternalUnassignedRuleCallTestLanguage.g:58:10: ( (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) )
            // PsiInternalUnassignedRuleCallTestLanguage.g:59:2: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            {
            // PsiInternalUnassignedRuleCallTestLanguage.g:59:2: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            // PsiInternalUnassignedRuleCallTestLanguage.g:60:3: otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            {

            			markLeaf(elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedRuleCallTestLanguage.g:67:3: (this_INT_1= RULE_INT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_INT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalUnassignedRuleCallTestLanguage.g:68:4: this_INT_1= RULE_INT
            	    {

            	    				markLeaf(elementTypeProvider.getModel_INTTerminalRuleCall_1ElementType());
            	    			
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

            	    				doneLeaf(this_INT_1);
            	    			

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

            // PsiInternalUnassignedRuleCallTestLanguage.g:76:3: ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            // PsiInternalUnassignedRuleCallTestLanguage.g:77:4: (lv_modelFeatures_2_0= ruleModelFeatures )
            {
            // PsiInternalUnassignedRuleCallTestLanguage.g:77:4: (lv_modelFeatures_2_0= ruleModelFeatures )
            // PsiInternalUnassignedRuleCallTestLanguage.g:78:5: lv_modelFeatures_2_0= ruleModelFeatures
            {

            					markComposite(elementTypeProvider.getModel_ModelFeaturesModelFeaturesParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleModelFeatures();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModelFeatures"
    // PsiInternalUnassignedRuleCallTestLanguage.g:91:1: entryRuleModelFeatures : ruleModelFeatures EOF ;
    public final void entryRuleModelFeatures() throws RecognitionException {
        try {
            // PsiInternalUnassignedRuleCallTestLanguage.g:91:23: ( ruleModelFeatures EOF )
            // PsiInternalUnassignedRuleCallTestLanguage.g:92:2: ruleModelFeatures EOF
            {
             markComposite(elementTypeProvider.getModelFeaturesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModelFeatures();

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
    // $ANTLR end "entryRuleModelFeatures"


    // $ANTLR start "ruleModelFeatures"
    // PsiInternalUnassignedRuleCallTestLanguage.g:97:1: ruleModelFeatures : (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) ;
    public final void ruleModelFeatures() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalUnassignedRuleCallTestLanguage.g:97:18: ( (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) )
            // PsiInternalUnassignedRuleCallTestLanguage.g:98:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            {
            // PsiInternalUnassignedRuleCallTestLanguage.g:98:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            // PsiInternalUnassignedRuleCallTestLanguage.g:99:3: otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';'
            {

            			markLeaf(elementTypeProvider.getModelFeatures_FeatureKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalUnassignedRuleCallTestLanguage.g:106:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalUnassignedRuleCallTestLanguage.g:107:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalUnassignedRuleCallTestLanguage.g:107:4: (lv_name_1_0= RULE_ID )
            // PsiInternalUnassignedRuleCallTestLanguage.g:108:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModelFeatures_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markComposite(elementTypeProvider.getModelFeatures_DataTypeRuleParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_6);
            ruleDataTypeRule();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getModelFeatures_SemicolonKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleModelFeatures"


    // $ANTLR start "entryRuleDataTypeRule"
    // PsiInternalUnassignedRuleCallTestLanguage.g:135:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // PsiInternalUnassignedRuleCallTestLanguage.g:135:22: ( ruleDataTypeRule EOF )
            // PsiInternalUnassignedRuleCallTestLanguage.g:136:2: ruleDataTypeRule EOF
            {
             markComposite(elementTypeProvider.getDataTypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDataTypeRule();

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
    // $ANTLR end "entryRuleDataTypeRule"


    // $ANTLR start "ruleDataTypeRule"
    // PsiInternalUnassignedRuleCallTestLanguage.g:141:1: ruleDataTypeRule : (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) ;
    public final void ruleDataTypeRule() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;

        try {
            // PsiInternalUnassignedRuleCallTestLanguage.g:141:17: ( (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) )
            // PsiInternalUnassignedRuleCallTestLanguage.g:142:2: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            {
            // PsiInternalUnassignedRuleCallTestLanguage.g:142:2: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            // PsiInternalUnassignedRuleCallTestLanguage.g:143:3: this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )?
            {

            			markLeaf(elementTypeProvider.getDataTypeRule_INTTerminalRuleCall_0ElementType());
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_7); 

            			doneLeaf(this_INT_0);
            		

            			markLeaf(elementTypeProvider.getDataTypeRule_KeywordKeyword_1ElementType());
            		
            kw=(Token)match(input,14,FollowSets000.FOLLOW_3); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getDataTypeRule_INTTerminalRuleCall_2ElementType());
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            			doneLeaf(this_INT_2);
            		
            // PsiInternalUnassignedRuleCallTestLanguage.g:164:3: (this_STRING_3= RULE_STRING )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalUnassignedRuleCallTestLanguage.g:165:4: this_STRING_3= RULE_STRING
                    {

                    				markLeaf(elementTypeProvider.getDataTypeRule_STRINGTerminalRuleCall_3ElementType());
                    			
                    this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    				doneLeaf(this_STRING_3);
                    			

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
    // $ANTLR end "ruleDataTypeRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000042L});
    }


}