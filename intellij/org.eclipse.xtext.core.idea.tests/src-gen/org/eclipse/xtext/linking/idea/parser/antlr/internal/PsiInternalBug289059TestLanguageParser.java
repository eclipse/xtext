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
    // PsiInternalBug289059TestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug289059TestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug289059TestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBug289059TestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Boolean lv_enabled_1_0 = null;


        try {
            // PsiInternalBug289059TestLanguage.g:60:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? ) )
            // PsiInternalBug289059TestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? )
            {
            // PsiInternalBug289059TestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )? )
            // PsiInternalBug289059TestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_enabled_1_0= ruleUnassignedAction ) )? ( (otherlv_2= RULE_ID ) )?
            {
            // PsiInternalBug289059TestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug289059TestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug289059TestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            // PsiInternalBug289059TestLanguage.g:64:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getModel_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalBug289059TestLanguage.g:79:3: ( (lv_enabled_1_0= ruleUnassignedAction ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalBug289059TestLanguage.g:80:4: (lv_enabled_1_0= ruleUnassignedAction )
                    {
                    // PsiInternalBug289059TestLanguage.g:80:4: (lv_enabled_1_0= ruleUnassignedAction )
                    // PsiInternalBug289059TestLanguage.g:81:5: lv_enabled_1_0= ruleUnassignedAction
                    {

                    					markComposite(elementTypeProvider.getModel_EnabledUnassignedActionParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_enabled_1_0=ruleUnassignedAction();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalBug289059TestLanguage.g:94:3: ( (otherlv_2= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalBug289059TestLanguage.g:95:4: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalBug289059TestLanguage.g:95:4: (otherlv_2= RULE_ID )
                    // PsiInternalBug289059TestLanguage.g:96:5: otherlv_2= RULE_ID
                    {

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnassignedAction"
    // PsiInternalBug289059TestLanguage.g:115:1: entryRuleUnassignedAction returns [Boolean current=false] : iv_ruleUnassignedAction= ruleUnassignedAction EOF ;
    public final Boolean entryRuleUnassignedAction() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleUnassignedAction = null;


        try {
            // PsiInternalBug289059TestLanguage.g:115:58: (iv_ruleUnassignedAction= ruleUnassignedAction EOF )
            // PsiInternalBug289059TestLanguage.g:116:2: iv_ruleUnassignedAction= ruleUnassignedAction EOF
            {
             markComposite(elementTypeProvider.getUnassignedActionElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnassignedAction=ruleUnassignedAction();

            state._fsp--;

             current =iv_ruleUnassignedAction; 
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
    // $ANTLR end "entryRuleUnassignedAction"


    // $ANTLR start "ruleUnassignedAction"
    // PsiInternalBug289059TestLanguage.g:122:1: ruleUnassignedAction returns [Boolean current=false] : ( () otherlv_1= 'enabled' ) ;
    public final Boolean ruleUnassignedAction() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;

        try {
            // PsiInternalBug289059TestLanguage.g:123:1: ( ( () otherlv_1= 'enabled' ) )
            // PsiInternalBug289059TestLanguage.g:124:2: ( () otherlv_1= 'enabled' )
            {
            // PsiInternalBug289059TestLanguage.g:124:2: ( () otherlv_1= 'enabled' )
            // PsiInternalBug289059TestLanguage.g:125:3: () otherlv_1= 'enabled'
            {
            // PsiInternalBug289059TestLanguage.g:125:3: ()
            // PsiInternalBug289059TestLanguage.g:126:4: 
            {

            				precedeComposite(elementTypeProvider.getUnassignedAction_UnassignedActionAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
        return current;
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