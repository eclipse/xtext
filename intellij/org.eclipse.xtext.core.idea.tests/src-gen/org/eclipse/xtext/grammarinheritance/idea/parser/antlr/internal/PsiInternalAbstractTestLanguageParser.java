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
    // PsiInternalAbstractTestLanguage.g:52:1: entryRuleInheritedParserRule returns [Boolean current=false] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final Boolean entryRuleInheritedParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleInheritedParserRule = null;


        try {
            // PsiInternalAbstractTestLanguage.g:52:61: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // PsiInternalAbstractTestLanguage.g:53:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             markComposite(elementTypeProvider.getInheritedParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();

            state._fsp--;

             current =iv_ruleInheritedParserRule; 
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
    // $ANTLR end "entryRuleInheritedParserRule"


    // $ANTLR start "ruleInheritedParserRule"
    // PsiInternalAbstractTestLanguage.g:59:1: ruleInheritedParserRule returns [Boolean current=false] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleInheritedParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalAbstractTestLanguage.g:60:1: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalAbstractTestLanguage.g:61:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalAbstractTestLanguage.g:61:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalAbstractTestLanguage.g:62:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getInheritedParserRule_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAbstractTestLanguage.g:69:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalAbstractTestLanguage.g:70:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalAbstractTestLanguage.g:70:4: (lv_name_1_0= RULE_ID )
            // PsiInternalAbstractTestLanguage.g:71:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleInheritedParserRule"


    // $ANTLR start "entryRuleOverridableParserRule"
    // PsiInternalAbstractTestLanguage.g:90:1: entryRuleOverridableParserRule returns [Boolean current=false] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final Boolean entryRuleOverridableParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOverridableParserRule = null;


        try {
            // PsiInternalAbstractTestLanguage.g:90:63: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // PsiInternalAbstractTestLanguage.g:91:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             markComposite(elementTypeProvider.getOverridableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();

            state._fsp--;

             current =iv_ruleOverridableParserRule; 
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
    // $ANTLR end "entryRuleOverridableParserRule"


    // $ANTLR start "ruleOverridableParserRule"
    // PsiInternalAbstractTestLanguage.g:97:1: ruleOverridableParserRule returns [Boolean current=false] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleOverridableParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalAbstractTestLanguage.g:98:1: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalAbstractTestLanguage.g:99:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalAbstractTestLanguage.g:99:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalAbstractTestLanguage.g:100:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getOverridableParserRule_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAbstractTestLanguage.g:107:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalAbstractTestLanguage.g:108:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalAbstractTestLanguage.g:108:4: (lv_name_1_0= RULE_ID )
            // PsiInternalAbstractTestLanguage.g:109:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleOverridableParserRule"


    // $ANTLR start "entryRuleExtendableParserRule"
    // PsiInternalAbstractTestLanguage.g:128:1: entryRuleExtendableParserRule returns [Boolean current=false] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final Boolean entryRuleExtendableParserRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExtendableParserRule = null;


        try {
            // PsiInternalAbstractTestLanguage.g:128:62: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // PsiInternalAbstractTestLanguage.g:129:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             markComposite(elementTypeProvider.getExtendableParserRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();

            state._fsp--;

             current =iv_ruleExtendableParserRule; 
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
    // $ANTLR end "entryRuleExtendableParserRule"


    // $ANTLR start "ruleExtendableParserRule"
    // PsiInternalAbstractTestLanguage.g:135:1: ruleExtendableParserRule returns [Boolean current=false] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleExtendableParserRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalAbstractTestLanguage.g:136:1: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalAbstractTestLanguage.g:137:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalAbstractTestLanguage.g:137:2: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalAbstractTestLanguage.g:138:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getExtendableParserRule_ElementKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalAbstractTestLanguage.g:145:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalAbstractTestLanguage.g:146:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalAbstractTestLanguage.g:146:4: (lv_name_1_0= RULE_ID )
            // PsiInternalAbstractTestLanguage.g:147:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getExtendableParserRule_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleExtendableParserRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    }


}