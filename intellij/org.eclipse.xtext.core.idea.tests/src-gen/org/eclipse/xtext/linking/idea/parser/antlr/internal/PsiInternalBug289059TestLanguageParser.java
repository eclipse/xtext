package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.services.Bug289059TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug289059TestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'enabled'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalBug289059TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug289059TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug289059TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug289059TestLanguage.g"; }



    	protected Bug289059TestLanguageGrammarAccess grammarAccess;

    	protected Bug289059TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBug289059TestLanguageParser(PsiBuilder builder, TokenStream input, Bug289059TestLanguageElementTypeProvider elementTypeProvider, Bug289059TestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalBug289059TestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBug289059TestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalBug289059TestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalBug289059TestLanguage.g:58:1: ruleModel : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? ) ;
    public final void ruleModel() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug289059TestLanguage.g:58:10: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? ) )
            // PsiInternalBug289059TestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? )
            {
            // PsiInternalBug289059TestLanguage.g:59:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? )
            // PsiInternalBug289059TestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )?
            {
            // PsiInternalBug289059TestLanguage.g:60:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug289059TestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug289059TestLanguage.g:61:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug289059TestLanguage.g:62:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalBug289059TestLanguage.g:71:3: ( (lv_enabled_1_0= ruleUnassignedAction ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalBug289059TestLanguage.g:72:4: (lv_enabled_1_0= ruleUnassignedAction )
                    {
                    // PsiInternalBug289059TestLanguage.g:72:4: (lv_enabled_1_0= ruleUnassignedAction )
                    // PsiInternalBug289059TestLanguage.g:73:5: lv_enabled_1_0= ruleUnassignedAction
                    {

                    					markComposite(elementTypeProvider.getModel_EnabledUnassignedActionParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_4);
                    ruleUnassignedAction();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // PsiInternalBug289059TestLanguage.g:82:3: ( (otherlv_2= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug289059TestLanguage.g:83:4: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalBug289059TestLanguage.g:83:4: (otherlv_2= RULE_ID )
                    // PsiInternalBug289059TestLanguage.g:84:5: otherlv_2= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getModel_ReferenceModelCrossReference_2_0ElementType());
                    				
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    					doneLeaf(otherlv_2);
                    				

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnassignedAction"
    // PsiInternalBug289059TestLanguage.g:97:1: entryRuleUnassignedAction : ruleUnassignedAction EOF ;
    public final void entryRuleUnassignedAction() throws RecognitionException {
        try {
            // PsiInternalBug289059TestLanguage.g:97:26: ( ruleUnassignedAction EOF )
            // PsiInternalBug289059TestLanguage.g:98:2: ruleUnassignedAction EOF
            {
             markComposite(elementTypeProvider.getUnassignedActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnassignedAction();

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
    // $ANTLR end "entryRuleUnassignedAction"


    // $ANTLR start "ruleUnassignedAction"
    // PsiInternalBug289059TestLanguage.g:103:1: ruleUnassignedAction : ( () otherlv_1= 'enabled' ) ;
    public final void ruleUnassignedAction() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalBug289059TestLanguage.g:103:21: ( ( () otherlv_1= 'enabled' ) )
            // PsiInternalBug289059TestLanguage.g:104:2: ( () otherlv_1= 'enabled' )
            {
            // PsiInternalBug289059TestLanguage.g:104:2: ( () otherlv_1= 'enabled' )
            // PsiInternalBug289059TestLanguage.g:105:3: () otherlv_1= 'enabled'
            {
            // PsiInternalBug289059TestLanguage.g:105:3: ()
            // PsiInternalBug289059TestLanguage.g:106:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction_UnassignedActionAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getUnassignedAction_EnabledKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_1);
            		

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
    // $ANTLR end "ruleUnassignedAction"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
    }


}