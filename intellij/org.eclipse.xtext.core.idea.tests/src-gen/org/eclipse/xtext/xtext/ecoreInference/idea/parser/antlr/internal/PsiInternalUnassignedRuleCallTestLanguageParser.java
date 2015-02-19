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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:59:1: ruleModel : (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token this_INT_1=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:62:2: ( (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:63:2: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:63:2: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:64:3: otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel88); 

            			doneLeaf(otherlv_0, elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:71:3: (this_INT_1= RULE_INT )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:72:4: this_INT_1= RULE_INT
            	    {

            	    				markLeaf();
            	    			
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleModel108); 

            	    				doneLeaf(this_INT_1, elementTypeProvider.getModel_INTTerminalRuleCall_1ElementType());
            	    			

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:80:3: ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:81:4: (lv_modelFeatures_2_0= ruleModelFeatures )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:81:4: (lv_modelFeatures_2_0= ruleModelFeatures )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:82:5: lv_modelFeatures_2_0= ruleModelFeatures
            {

            					markComposite(elementTypeProvider.getModel_ModelFeaturesModelFeaturesParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleModelFeatures_in_ruleModel141);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:95:1: entryRuleModelFeatures : ruleModelFeatures EOF ;
    public final void entryRuleModelFeatures() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:95:23: ( ruleModelFeatures EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:96:2: ruleModelFeatures EOF
            {
             markComposite(elementTypeProvider.getModelFeaturesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures172);
            ruleModelFeatures();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelFeatures178); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:102:1: ruleModelFeatures : (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) ;
    public final void ruleModelFeatures() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:105:2: ( (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:106:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:106:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:107:3: otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModelFeatures206); 

            			doneLeaf(otherlv_0, elementTypeProvider.getModelFeatures_FeatureKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:114:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:115:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:115:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:116:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelFeatures233); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getModelFeatures_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getModelFeatures_DataTypeRuleParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeRule_in_ruleModelFeatures256);
            ruleDataTypeRule();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModelFeatures270); 

            			doneLeaf(otherlv_3, elementTypeProvider.getModelFeatures_SemicolonKeyword_3ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:143:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:143:22: ( ruleDataTypeRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:144:2: ruleDataTypeRule EOF
            {
             markComposite(elementTypeProvider.getDataTypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule290);
            ruleDataTypeRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeRule296); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:150:1: ruleDataTypeRule : (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) ;
    public final void ruleDataTypeRule() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:153:2: ( (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:154:2: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:154:2: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:155:3: this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )?
            {

            			markLeaf();
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDataTypeRule324); 

            			doneLeaf(this_INT_0, elementTypeProvider.getDataTypeRule_INTTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDataTypeRule338); 

            			doneLeaf(kw, elementTypeProvider.getDataTypeRule_KeywordKeyword_1ElementType());
            		

            			markLeaf();
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDataTypeRule352); 

            			doneLeaf(this_INT_2, elementTypeProvider.getDataTypeRule_INTTerminalRuleCall_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:176:3: (this_STRING_3= RULE_STRING )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:177:4: this_STRING_3= RULE_STRING
                    {

                    				markLeaf();
                    			
                    this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleDataTypeRule372); 

                    				doneLeaf(this_STRING_3, elementTypeProvider.getDataTypeRule_STRINGTerminalRuleCall_3ElementType());
                    			

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel88 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleModel108 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleModelFeatures_in_ruleModel141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelFeatures178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModelFeatures206 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelFeatures233 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDataTypeRule_in_ruleModelFeatures256 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModelFeatures270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule290 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeRule296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule324 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleDataTypeRule338 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule352 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleDataTypeRule372 = new BitSet(new long[]{0x0000000000000002L});
    }


}