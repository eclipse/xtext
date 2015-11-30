package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalActionTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalActionTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalActionTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalActionTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalActionTestLanguage.g"; }



    	protected ActionTestLanguageGrammarAccess grammarAccess;

    	protected ActionTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalActionTestLanguageParser(PsiBuilder builder, TokenStream input, ActionTestLanguageElementTypeProvider elementTypeProvider, ActionTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalActionTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalActionTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalActionTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalActionTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean this_Child_0 = null;

        Boolean lv_right_2_0 = null;


        try {
            // PsiInternalActionTestLanguage.g:60:1: ( (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? ) )
            // PsiInternalActionTestLanguage.g:61:2: (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? )
            {
            // PsiInternalActionTestLanguage.g:61:2: (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? )
            // PsiInternalActionTestLanguage.g:62:3: this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )?
            {

            			markComposite(elementTypeProvider.getModel_ChildParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Child_0=ruleChild();

            state._fsp--;


            			current = this_Child_0;
            			doneComposite();
            		
            // PsiInternalActionTestLanguage.g:70:3: ( () ( (lv_right_2_0= ruleChild ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalActionTestLanguage.g:71:4: () ( (lv_right_2_0= ruleChild ) )
                    {
                    // PsiInternalActionTestLanguage.g:71:4: ()
                    // PsiInternalActionTestLanguage.g:72:5: 
                    {

                    					precedeComposite(elementTypeProvider.getModel_ParentLeftAction_1_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalActionTestLanguage.g:78:4: ( (lv_right_2_0= ruleChild ) )
                    // PsiInternalActionTestLanguage.g:79:5: (lv_right_2_0= ruleChild )
                    {
                    // PsiInternalActionTestLanguage.g:79:5: (lv_right_2_0= ruleChild )
                    // PsiInternalActionTestLanguage.g:80:6: lv_right_2_0= ruleChild
                    {

                    						markComposite(elementTypeProvider.getModel_RightChildParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_2_0=ruleChild();

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


    // $ANTLR start "entryRuleChild"
    // PsiInternalActionTestLanguage.g:98:1: entryRuleChild returns [Boolean current=false] : iv_ruleChild= ruleChild EOF ;
    public final Boolean entryRuleChild() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChild = null;


        try {
            // PsiInternalActionTestLanguage.g:98:47: (iv_ruleChild= ruleChild EOF )
            // PsiInternalActionTestLanguage.g:99:2: iv_ruleChild= ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChild=ruleChild();

            state._fsp--;

             current =iv_ruleChild; 
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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // PsiInternalActionTestLanguage.g:105:1: ruleChild returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleChild() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalActionTestLanguage.g:106:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalActionTestLanguage.g:107:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalActionTestLanguage.g:107:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalActionTestLanguage.g:108:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalActionTestLanguage.g:108:3: (lv_name_0_0= RULE_ID )
            // PsiInternalActionTestLanguage.g:109:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getChild_NameIDTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				doneLeaf(lv_name_0_0);
            			

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
    // $ANTLR end "ruleChild"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    }


}