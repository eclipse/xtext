package org.eclipse.xtext.lexer.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.lexer.services.IgnoreCaseLexerTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalIgnoreCaseLexerTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_SL_COMMENT", "'case'", "'foo'", "'CaSe'"
    };
    public static final int RULE_WS=4;
    public static final int RULE_SL_COMMENT=5;
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int T__6=6;

    // delegates
    // delegators


        public PsiInternalIgnoreCaseLexerTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalIgnoreCaseLexerTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalIgnoreCaseLexerTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalIgnoreCaseLexerTestLanguage.g"; }



    	protected IgnoreCaseLexerTestLanguageGrammarAccess grammarAccess;

    	protected IgnoreCaseLexerTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalIgnoreCaseLexerTestLanguageParser(PsiBuilder builder, TokenStream input, IgnoreCaseLexerTestLanguageElementTypeProvider elementTypeProvider, IgnoreCaseLexerTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalIgnoreCaseLexerTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalIgnoreCaseLexerTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalIgnoreCaseLexerTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : (otherlv_0= 'case' (otherlv_1= 'foo' )? ( (lv_value_2_0= 'CaSe' ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

        try {
            // PsiInternalIgnoreCaseLexerTestLanguage.g:60:1: ( (otherlv_0= 'case' (otherlv_1= 'foo' )? ( (lv_value_2_0= 'CaSe' ) ) ) )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:61:2: (otherlv_0= 'case' (otherlv_1= 'foo' )? ( (lv_value_2_0= 'CaSe' ) ) )
            {
            // PsiInternalIgnoreCaseLexerTestLanguage.g:61:2: (otherlv_0= 'case' (otherlv_1= 'foo' )? ( (lv_value_2_0= 'CaSe' ) ) )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:62:3: otherlv_0= 'case' (otherlv_1= 'foo' )? ( (lv_value_2_0= 'CaSe' ) )
            {

            			markLeaf(elementTypeProvider.getModel_CaseKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,6,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalIgnoreCaseLexerTestLanguage.g:69:3: (otherlv_1= 'foo' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==7) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PsiInternalIgnoreCaseLexerTestLanguage.g:70:4: otherlv_1= 'foo'
                    {

                    				markLeaf(elementTypeProvider.getModel_FooKeyword_1ElementType());
                    			
                    otherlv_1=(Token)match(input,7,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;

            }

            // PsiInternalIgnoreCaseLexerTestLanguage.g:78:3: ( (lv_value_2_0= 'CaSe' ) )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:79:4: (lv_value_2_0= 'CaSe' )
            {
            // PsiInternalIgnoreCaseLexerTestLanguage.g:79:4: (lv_value_2_0= 'CaSe' )
            // PsiInternalIgnoreCaseLexerTestLanguage.g:80:5: lv_value_2_0= 'CaSe'
            {

            					markLeaf(elementTypeProvider.getModel_ValueCaSeKeyword_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,8,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_value_2_0);
            				

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000180L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000100L});
    }


}