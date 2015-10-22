package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalOptionalEmptyTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'hallo'"
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


        public PsiInternalOptionalEmptyTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalOptionalEmptyTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalOptionalEmptyTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalOptionalEmptyTestLanguage.g"; }



    	protected OptionalEmptyTestLanguageGrammarAccess grammarAccess;

    	protected OptionalEmptyTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalOptionalEmptyTestLanguageParser(PsiBuilder builder, TokenStream input, OptionalEmptyTestLanguageElementTypeProvider elementTypeProvider, OptionalEmptyTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalOptionalEmptyTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalOptionalEmptyTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalOptionalEmptyTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalOptionalEmptyTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_child_0_0= ruleGreeting ) )? ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_child_0_0 = null;


        try {
            // PsiInternalOptionalEmptyTestLanguage.g:60:1: ( ( (lv_child_0_0= ruleGreeting ) )? )
            // PsiInternalOptionalEmptyTestLanguage.g:61:2: ( (lv_child_0_0= ruleGreeting ) )?
            {
            // PsiInternalOptionalEmptyTestLanguage.g:61:2: ( (lv_child_0_0= ruleGreeting ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalOptionalEmptyTestLanguage.g:62:3: (lv_child_0_0= ruleGreeting )
                    {
                    // PsiInternalOptionalEmptyTestLanguage.g:62:3: (lv_child_0_0= ruleGreeting )
                    // PsiInternalOptionalEmptyTestLanguage.g:63:4: lv_child_0_0= ruleGreeting
                    {

                    				markComposite(elementTypeProvider.getModel_ChildGreetingParserRuleCall_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_child_0_0=ruleGreeting();

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


    // $ANTLR start "entryRuleGreeting"
    // PsiInternalOptionalEmptyTestLanguage.g:79:1: entryRuleGreeting returns [Boolean current=false] : iv_ruleGreeting= ruleGreeting EOF ;
    public final Boolean entryRuleGreeting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGreeting = null;


        try {
            // PsiInternalOptionalEmptyTestLanguage.g:79:50: (iv_ruleGreeting= ruleGreeting EOF )
            // PsiInternalOptionalEmptyTestLanguage.g:80:2: iv_ruleGreeting= ruleGreeting EOF
            {
             markComposite(elementTypeProvider.getGreetingElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGreeting=ruleGreeting();

            state._fsp--;

             current =iv_ruleGreeting; 
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
    // $ANTLR end "entryRuleGreeting"


    // $ANTLR start "ruleGreeting"
    // PsiInternalOptionalEmptyTestLanguage.g:86:1: ruleGreeting returns [Boolean current=false] : (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleGreeting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalOptionalEmptyTestLanguage.g:87:1: ( (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalOptionalEmptyTestLanguage.g:88:2: (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalOptionalEmptyTestLanguage.g:88:2: (otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalOptionalEmptyTestLanguage.g:89:3: otherlv_0= 'hallo' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getGreeting_HalloKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalOptionalEmptyTestLanguage.g:96:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalOptionalEmptyTestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalOptionalEmptyTestLanguage.g:97:4: (lv_name_1_0= RULE_ID )
            // PsiInternalOptionalEmptyTestLanguage.g:98:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getGreeting_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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
        return current;
    }
    // $ANTLR end "ruleGreeting"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}