package org.eclipse.xtext.generator.grammarAccess.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.generator.grammarAccess.services.GrammarAccessTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalGrammarAccessTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo'", "'bar'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalGrammarAccessTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalGrammarAccessTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalGrammarAccessTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalGrammarAccessTestLanguage.g"; }



    	protected GrammarAccessTestLanguageGrammarAccess grammarAccess;

    	protected GrammarAccessTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalGrammarAccessTestLanguageParser(PsiBuilder builder, TokenStream input, GrammarAccessTestLanguageElementTypeProvider elementTypeProvider, GrammarAccessTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Root";
    	}




    // $ANTLR start "entryRuleRoot"
    // PsiInternalGrammarAccessTestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // PsiInternalGrammarAccessTestLanguage.g:52:14: ( ruleRoot EOF )
            // PsiInternalGrammarAccessTestLanguage.g:53:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRoot();

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalGrammarAccessTestLanguage.g:58:1: ruleRoot : ( (lv_elements_0_0= ruleType ) )* ;
    public final void ruleRoot() throws RecognitionException {
        try {
            // PsiInternalGrammarAccessTestLanguage.g:58:9: ( ( (lv_elements_0_0= ruleType ) )* )
            // PsiInternalGrammarAccessTestLanguage.g:59:2: ( (lv_elements_0_0= ruleType ) )*
            {
            // PsiInternalGrammarAccessTestLanguage.g:59:2: ( (lv_elements_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalGrammarAccessTestLanguage.g:60:3: (lv_elements_0_0= ruleType )
            	    {
            	    // PsiInternalGrammarAccessTestLanguage.g:60:3: (lv_elements_0_0= ruleType )
            	    // PsiInternalGrammarAccessTestLanguage.g:61:4: lv_elements_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getRoot_ElementsTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleType();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleType"
    // PsiInternalGrammarAccessTestLanguage.g:73:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // PsiInternalGrammarAccessTestLanguage.g:73:14: ( ruleType EOF )
            // PsiInternalGrammarAccessTestLanguage.g:74:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleType();

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalGrammarAccessTestLanguage.g:79:1: ruleType : ( ruleAType | ruleAnotherType ) ;
    public final void ruleType() throws RecognitionException {
        try {
            // PsiInternalGrammarAccessTestLanguage.g:79:9: ( ( ruleAType | ruleAnotherType ) )
            // PsiInternalGrammarAccessTestLanguage.g:80:2: ( ruleAType | ruleAnotherType )
            {
            // PsiInternalGrammarAccessTestLanguage.g:80:2: ( ruleAType | ruleAnotherType )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalGrammarAccessTestLanguage.g:81:3: ruleAType
                    {

                    			markComposite(elementTypeProvider.getType_ATypeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAType();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalGrammarAccessTestLanguage.g:89:3: ruleAnotherType
                    {

                    			markComposite(elementTypeProvider.getType_AnotherTypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAnotherType();

                    state._fsp--;


                    			doneComposite();
                    		

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
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleAType"
    // PsiInternalGrammarAccessTestLanguage.g:100:1: entryRuleAType : ruleAType EOF ;
    public final void entryRuleAType() throws RecognitionException {
        try {
            // PsiInternalGrammarAccessTestLanguage.g:100:15: ( ruleAType EOF )
            // PsiInternalGrammarAccessTestLanguage.g:101:2: ruleAType EOF
            {
             markComposite(elementTypeProvider.getATypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAType();

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
    // $ANTLR end "entryRuleAType"


    // $ANTLR start "ruleAType"
    // PsiInternalGrammarAccessTestLanguage.g:106:1: ruleAType : (otherlv_0= 'foo' () ) ;
    public final void ruleAType() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalGrammarAccessTestLanguage.g:106:10: ( (otherlv_0= 'foo' () ) )
            // PsiInternalGrammarAccessTestLanguage.g:107:2: (otherlv_0= 'foo' () )
            {
            // PsiInternalGrammarAccessTestLanguage.g:107:2: (otherlv_0= 'foo' () )
            // PsiInternalGrammarAccessTestLanguage.g:108:3: otherlv_0= 'foo' ()
            {

            			markLeaf(elementTypeProvider.getAType_FooKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalGrammarAccessTestLanguage.g:115:3: ()
            // PsiInternalGrammarAccessTestLanguage.g:116:4: 
            {

            				precedeComposite(elementTypeProvider.getAType_ATypeAction_1ElementType());
            				doneComposite();
            			

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
    // $ANTLR end "ruleAType"


    // $ANTLR start "entryRuleAnotherType"
    // PsiInternalGrammarAccessTestLanguage.g:125:1: entryRuleAnotherType : ruleAnotherType EOF ;
    public final void entryRuleAnotherType() throws RecognitionException {
        try {
            // PsiInternalGrammarAccessTestLanguage.g:125:21: ( ruleAnotherType EOF )
            // PsiInternalGrammarAccessTestLanguage.g:126:2: ruleAnotherType EOF
            {
             markComposite(elementTypeProvider.getAnotherTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAnotherType();

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
    // $ANTLR end "entryRuleAnotherType"


    // $ANTLR start "ruleAnotherType"
    // PsiInternalGrammarAccessTestLanguage.g:131:1: ruleAnotherType : (otherlv_0= 'bar' () ) ;
    public final void ruleAnotherType() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalGrammarAccessTestLanguage.g:131:16: ( (otherlv_0= 'bar' () ) )
            // PsiInternalGrammarAccessTestLanguage.g:132:2: (otherlv_0= 'bar' () )
            {
            // PsiInternalGrammarAccessTestLanguage.g:132:2: (otherlv_0= 'bar' () )
            // PsiInternalGrammarAccessTestLanguage.g:133:3: otherlv_0= 'bar' ()
            {

            			markLeaf(elementTypeProvider.getAnotherType_BarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalGrammarAccessTestLanguage.g:140:3: ()
            // PsiInternalGrammarAccessTestLanguage.g:141:4: 
            {

            				precedeComposite(elementTypeProvider.getAnotherType_AnotherTypeAction_1ElementType());
            				doneComposite();
            			

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
    // $ANTLR end "ruleAnotherType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    }


}