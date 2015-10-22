package org.eclipse.xtext.generator.ecore.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.generator.ecore.services.EcoreFragmentTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEcoreFragmentTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'first'"
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


        public PsiInternalEcoreFragmentTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEcoreFragmentTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEcoreFragmentTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalEcoreFragmentTestLanguage.g"; }



    	protected EcoreFragmentTestLanguageGrammarAccess grammarAccess;

    	protected EcoreFragmentTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEcoreFragmentTestLanguageParser(PsiBuilder builder, TokenStream input, EcoreFragmentTestLanguageElementTypeProvider elementTypeProvider, EcoreFragmentTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Second";
    	}




    // $ANTLR start "entryRuleSecond"
    // PsiInternalEcoreFragmentTestLanguage.g:52:1: entryRuleSecond returns [Boolean current=false] : iv_ruleSecond= ruleSecond EOF ;
    public final Boolean entryRuleSecond() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSecond = null;


        try {
            // PsiInternalEcoreFragmentTestLanguage.g:52:48: (iv_ruleSecond= ruleSecond EOF )
            // PsiInternalEcoreFragmentTestLanguage.g:53:2: iv_ruleSecond= ruleSecond EOF
            {
             markComposite(elementTypeProvider.getSecondElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSecond=ruleSecond();

            state._fsp--;

             current =iv_ruleSecond; 
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
    // $ANTLR end "entryRuleSecond"


    // $ANTLR start "ruleSecond"
    // PsiInternalEcoreFragmentTestLanguage.g:59:1: ruleSecond returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) ) ;
    public final Boolean ruleSecond() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // PsiInternalEcoreFragmentTestLanguage.g:60:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) ) )
            // PsiInternalEcoreFragmentTestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) )
            {
            // PsiInternalEcoreFragmentTestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) ) )
            // PsiInternalEcoreFragmentTestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'first' ( (otherlv_2= RULE_ID ) )
            {
            // PsiInternalEcoreFragmentTestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalEcoreFragmentTestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalEcoreFragmentTestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            // PsiInternalEcoreFragmentTestLanguage.g:64:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSecond_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getSecond_FirstKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEcoreFragmentTestLanguage.g:86:3: ( (otherlv_2= RULE_ID ) )
            // PsiInternalEcoreFragmentTestLanguage.g:87:4: (otherlv_2= RULE_ID )
            {
            // PsiInternalEcoreFragmentTestLanguage.g:87:4: (otherlv_2= RULE_ID )
            // PsiInternalEcoreFragmentTestLanguage.g:88:5: otherlv_2= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getSecond_FirstFirstCrossReference_2_0ElementType());
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_2);
            				

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
    // $ANTLR end "ruleSecond"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    }


}