package org.eclipse.xtext.grammarinheritance.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalAbstractTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_REAL", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=7;
    public static final int T__12=12;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=5;
    public static final int RULE_REAL=6;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

    // delegates
    // delegators


        public PsiInternalAbstractTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalAbstractTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalAbstractTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalAbstractTestLanguage.g"; }



    	protected AbstractTestLanguageGrammarAccess grammarAccess;

    	protected AbstractTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalAbstractTestLanguageParser(PsiBuilder builder, TokenStream input, AbstractTestLanguageElementTypeProvider elementTypeProvider, AbstractTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "InheritedParserRule";
    	}




    // $ANTLR start "entryRuleInheritedParserRule"
    // PsiInternalAbstractTestLanguage.g:52:1: entryRuleInheritedParserRule : ruleInheritedParserRule EOF ;
    public final void entryRuleInheritedParserRule() throws RecognitionException {
        try {
            // PsiInternalAbstractTestLanguage.g:52:29: ( ruleInheritedParserRule EOF )
            // PsiInternalAbstractTestLanguage.g:53:2: ruleInheritedParserRule EOF
            {
             markComposite(elementTypeProvider.getInheritedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInheritedParserRule();

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
    // $ANTLR end "entryRuleInheritedParserRule"


    // $ANTLR start "ruleInheritedParserRule"
    // PsiInternalAbstractTestLanguage.g:58:1: ruleInheritedParserRule : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleInheritedParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalAbstractTestLanguage.g:58:24: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalAbstractTestLanguage.g:59:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalAbstractTestLanguage.g:59:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalAbstractTestLanguage.g:60:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getInheritedParserRule_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAbstractTestLanguage.g:67:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalAbstractTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalAbstractTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            // PsiInternalAbstractTestLanguage.g:69:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleInheritedParserRule"


    // $ANTLR start "entryRuleOverridableParserRule"
    // PsiInternalAbstractTestLanguage.g:82:1: entryRuleOverridableParserRule : ruleOverridableParserRule EOF ;
    public final void entryRuleOverridableParserRule() throws RecognitionException {
        try {
            // PsiInternalAbstractTestLanguage.g:82:31: ( ruleOverridableParserRule EOF )
            // PsiInternalAbstractTestLanguage.g:83:2: ruleOverridableParserRule EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOverridableParserRule();

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
    // $ANTLR end "entryRuleOverridableParserRule"


    // $ANTLR start "ruleOverridableParserRule"
    // PsiInternalAbstractTestLanguage.g:88:1: ruleOverridableParserRule : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleOverridableParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalAbstractTestLanguage.g:88:26: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalAbstractTestLanguage.g:89:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalAbstractTestLanguage.g:89:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalAbstractTestLanguage.g:90:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getOverridableParserRule_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAbstractTestLanguage.g:97:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalAbstractTestLanguage.g:98:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalAbstractTestLanguage.g:98:4: (lv_name_1_0= RULE_ID )
            // PsiInternalAbstractTestLanguage.g:99:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleOverridableParserRule"


    // $ANTLR start "entryRuleExtendableParserRule"
    // PsiInternalAbstractTestLanguage.g:112:1: entryRuleExtendableParserRule : ruleExtendableParserRule EOF ;
    public final void entryRuleExtendableParserRule() throws RecognitionException {
        try {
            // PsiInternalAbstractTestLanguage.g:112:30: ( ruleExtendableParserRule EOF )
            // PsiInternalAbstractTestLanguage.g:113:2: ruleExtendableParserRule EOF
            {
             markComposite(elementTypeProvider.getExtendableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExtendableParserRule();

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
    // $ANTLR end "entryRuleExtendableParserRule"


    // $ANTLR start "ruleExtendableParserRule"
    // PsiInternalAbstractTestLanguage.g:118:1: ruleExtendableParserRule : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleExtendableParserRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalAbstractTestLanguage.g:118:25: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalAbstractTestLanguage.g:119:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalAbstractTestLanguage.g:119:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalAbstractTestLanguage.g:120:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getExtendableParserRule_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAbstractTestLanguage.g:127:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalAbstractTestLanguage.g:128:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalAbstractTestLanguage.g:128:4: (lv_name_1_0= RULE_ID )
            // PsiInternalAbstractTestLanguage.g:129:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getExtendableParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleExtendableParserRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}