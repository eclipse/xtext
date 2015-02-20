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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:59:10: ( (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:60:2: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:60:2: (otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:61:3: otherlv_0= 'model' (this_INT_1= RULE_INT )+ ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel79); 

            			doneLeaf(otherlv_0, elementTypeProvider.getModel_ModelKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:68:3: (this_INT_1= RULE_INT )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:69:4: this_INT_1= RULE_INT
            	    {

            	    				markLeaf();
            	    			
            	    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleModel99); 

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:77:3: ( (lv_modelFeatures_2_0= ruleModelFeatures ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:78:4: (lv_modelFeatures_2_0= ruleModelFeatures )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:78:4: (lv_modelFeatures_2_0= ruleModelFeatures )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:79:5: lv_modelFeatures_2_0= ruleModelFeatures
            {

            					markComposite(elementTypeProvider.getModel_ModelFeaturesModelFeaturesParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleModelFeatures_in_ruleModel132);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:92:1: entryRuleModelFeatures : ruleModelFeatures EOF ;
    public final void entryRuleModelFeatures() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:92:23: ( ruleModelFeatures EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:93:2: ruleModelFeatures EOF
            {
             markComposite(elementTypeProvider.getModelFeaturesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures163);
            ruleModelFeatures();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelFeatures169); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:99:1: ruleModelFeatures : (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) ;
    public final void ruleModelFeatures() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:99:18: ( (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:100:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:100:2: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:101:3: otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) ruleDataTypeRule otherlv_3= ';'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModelFeatures188); 

            			doneLeaf(otherlv_0, elementTypeProvider.getModelFeatures_FeatureKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:108:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:109:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:109:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:110:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelFeatures215); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getModelFeatures_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markComposite(elementTypeProvider.getModelFeatures_DataTypeRuleParserRuleCall_2ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeRule_in_ruleModelFeatures238);
            ruleDataTypeRule();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModelFeatures252); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:137:1: entryRuleDataTypeRule : ruleDataTypeRule EOF ;
    public final void entryRuleDataTypeRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:137:22: ( ruleDataTypeRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:138:2: ruleDataTypeRule EOF
            {
             markComposite(elementTypeProvider.getDataTypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule272);
            ruleDataTypeRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDataTypeRule278); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:144:1: ruleDataTypeRule : (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) ;
    public final void ruleDataTypeRule() throws RecognitionException {
        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_STRING_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:144:17: ( (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:145:2: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:145:2: (this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:146:3: this_INT_0= RULE_INT kw= 'keyword' this_INT_2= RULE_INT (this_STRING_3= RULE_STRING )?
            {

            			markLeaf();
            		
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDataTypeRule297); 

            			doneLeaf(this_INT_0, elementTypeProvider.getDataTypeRule_INTTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDataTypeRule311); 

            			doneLeaf(kw, elementTypeProvider.getDataTypeRule_KeywordKeyword_1ElementType());
            		

            			markLeaf();
            		
            this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleDataTypeRule325); 

            			doneLeaf(this_INT_2, elementTypeProvider.getDataTypeRule_INTTerminalRuleCall_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:167:3: (this_STRING_3= RULE_STRING )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/xtext/ecoreInference/idea/parser/antlr/internal/PsiInternalUnassignedRuleCallTestLanguage.g:168:4: this_STRING_3= RULE_STRING
                    {

                    				markLeaf();
                    			
                    this_STRING_3=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleDataTypeRule345); 

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
        public static final BitSet FOLLOW_11_in_ruleModel79 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleModel99 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleModelFeatures_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelFeatures_in_entryRuleModelFeatures163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelFeatures169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModelFeatures188 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelFeatures215 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleDataTypeRule_in_ruleModelFeatures238 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModelFeatures252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDataTypeRule_in_entryRuleDataTypeRule272 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeRule278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule297 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleDataTypeRule311 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleDataTypeRule325 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleDataTypeRule345 = new BitSet(new long[]{0x0000000000000002L});
    }


}