package org.eclipse.xtext.xtext.ecoreInference.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.xtext.ecoreInference.services.MultiValueFeatureTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalMultiValueFeatureTestLanguageParser extends AbstractPsiAntlrParser {
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


        public PsiInternalMultiValueFeatureTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalMultiValueFeatureTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalMultiValueFeatureTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalMultiValueFeatureTestLanguage.g"; }



    	protected MultiValueFeatureTestLanguageGrammarAccess grammarAccess;

    	protected MultiValueFeatureTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalMultiValueFeatureTestLanguageParser(PsiBuilder builder, TokenStream input, MultiValueFeatureTestLanguageElementTypeProvider elementTypeProvider, MultiValueFeatureTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Start";
    	}




    // $ANTLR start "entryRuleStart"
    // PsiInternalMultiValueFeatureTestLanguage.g:52:1: entryRuleStart returns [Boolean current=false] : iv_ruleStart= ruleStart EOF ;
    public final Boolean entryRuleStart() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStart = null;


        try {
            // PsiInternalMultiValueFeatureTestLanguage.g:52:47: (iv_ruleStart= ruleStart EOF )
            // PsiInternalMultiValueFeatureTestLanguage.g:53:2: iv_ruleStart= ruleStart EOF
            {
             markComposite(elementTypeProvider.getStartElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStart=ruleStart();

            state._fsp--;

             current =iv_ruleStart; 
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
    // $ANTLR end "entryRuleStart"


    // $ANTLR start "ruleStart"
    // PsiInternalMultiValueFeatureTestLanguage.g:59:1: ruleStart returns [Boolean current=false] : ( (lv_featureA_0_0= RULE_ID ) )+ ;
    public final Boolean ruleStart() throws RecognitionException {
        Boolean current = false;

        Token lv_featureA_0_0=null;

        try {
            // PsiInternalMultiValueFeatureTestLanguage.g:60:1: ( ( (lv_featureA_0_0= RULE_ID ) )+ )
            // PsiInternalMultiValueFeatureTestLanguage.g:61:2: ( (lv_featureA_0_0= RULE_ID ) )+
            {
            // PsiInternalMultiValueFeatureTestLanguage.g:61:2: ( (lv_featureA_0_0= RULE_ID ) )+
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
            	    // PsiInternalMultiValueFeatureTestLanguage.g:62:3: (lv_featureA_0_0= RULE_ID )
            	    {
            	    // PsiInternalMultiValueFeatureTestLanguage.g:62:3: (lv_featureA_0_0= RULE_ID )
            	    // PsiInternalMultiValueFeatureTestLanguage.g:63:4: lv_featureA_0_0= RULE_ID
            	    {

            	    				markLeaf(elementTypeProvider.getStart_FeatureAIDTerminalRuleCall_0ElementType());
            	    			
            	    lv_featureA_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

            	    				doneLeaf(lv_featureA_0_0);
            	    			

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
    // $ANTLR end "ruleStart"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    }


}