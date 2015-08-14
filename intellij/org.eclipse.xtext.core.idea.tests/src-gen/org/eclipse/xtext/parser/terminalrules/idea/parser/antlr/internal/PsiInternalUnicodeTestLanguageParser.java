package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.UnicodeTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalUnicodeTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_GERMAN_STRING", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_INT=7;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_GERMAN_STRING=4;
    public static final int RULE_ML_COMMENT=8;

    // delegates
    // delegators


        public PsiInternalUnicodeTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalUnicodeTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalUnicodeTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalUnicodeTestLanguage.g"; }



    	protected UnicodeTestLanguageGrammarAccess grammarAccess;

    	protected UnicodeTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalUnicodeTestLanguageParser(PsiBuilder builder, TokenStream input, UnicodeTestLanguageElementTypeProvider elementTypeProvider, UnicodeTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalUnicodeTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalUnicodeTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalUnicodeTestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalUnicodeTestLanguage.g:58:1: ruleModel : ( (lv_strings_0_0= ruleAbstractString ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalUnicodeTestLanguage.g:58:10: ( ( (lv_strings_0_0= ruleAbstractString ) )* )
            // PsiInternalUnicodeTestLanguage.g:59:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            {
            // PsiInternalUnicodeTestLanguage.g:59:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_GERMAN_STRING && LA1_0<=RULE_STRING)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalUnicodeTestLanguage.g:60:3: (lv_strings_0_0= ruleAbstractString )
            	    {
            	    // PsiInternalUnicodeTestLanguage.g:60:3: (lv_strings_0_0= ruleAbstractString )
            	    // PsiInternalUnicodeTestLanguage.g:61:4: lv_strings_0_0= ruleAbstractString
            	    {

            	    				markComposite(elementTypeProvider.getModel_StringsAbstractStringParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleAbstractString();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractString"
    // PsiInternalUnicodeTestLanguage.g:73:1: entryRuleAbstractString : ruleAbstractString EOF ;
    public final void entryRuleAbstractString() throws RecognitionException {
        try {
            // PsiInternalUnicodeTestLanguage.g:73:24: ( ruleAbstractString EOF )
            // PsiInternalUnicodeTestLanguage.g:74:2: ruleAbstractString EOF
            {
             markComposite(elementTypeProvider.getAbstractStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractString();

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
    // $ANTLR end "entryRuleAbstractString"


    // $ANTLR start "ruleAbstractString"
    // PsiInternalUnicodeTestLanguage.g:79:1: ruleAbstractString : ( ruleGString | ruleQuotedString ) ;
    public final void ruleAbstractString() throws RecognitionException {
        try {
            // PsiInternalUnicodeTestLanguage.g:79:19: ( ( ruleGString | ruleQuotedString ) )
            // PsiInternalUnicodeTestLanguage.g:80:2: ( ruleGString | ruleQuotedString )
            {
            // PsiInternalUnicodeTestLanguage.g:80:2: ( ruleGString | ruleQuotedString )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_GERMAN_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_STRING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalUnicodeTestLanguage.g:81:3: ruleGString
                    {

                    			markComposite(elementTypeProvider.getAbstractString_GStringParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleGString();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalUnicodeTestLanguage.g:89:3: ruleQuotedString
                    {

                    			markComposite(elementTypeProvider.getAbstractString_QuotedStringParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleQuotedString();

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
    // $ANTLR end "ruleAbstractString"


    // $ANTLR start "entryRuleGString"
    // PsiInternalUnicodeTestLanguage.g:100:1: entryRuleGString : ruleGString EOF ;
    public final void entryRuleGString() throws RecognitionException {
        try {
            // PsiInternalUnicodeTestLanguage.g:100:17: ( ruleGString EOF )
            // PsiInternalUnicodeTestLanguage.g:101:2: ruleGString EOF
            {
             markComposite(elementTypeProvider.getGStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGString();

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
    // $ANTLR end "entryRuleGString"


    // $ANTLR start "ruleGString"
    // PsiInternalUnicodeTestLanguage.g:106:1: ruleGString : ( (lv_name_0_0= RULE_GERMAN_STRING ) ) ;
    public final void ruleGString() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalUnicodeTestLanguage.g:106:12: ( ( (lv_name_0_0= RULE_GERMAN_STRING ) ) )
            // PsiInternalUnicodeTestLanguage.g:107:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            {
            // PsiInternalUnicodeTestLanguage.g:107:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            // PsiInternalUnicodeTestLanguage.g:108:3: (lv_name_0_0= RULE_GERMAN_STRING )
            {
            // PsiInternalUnicodeTestLanguage.g:108:3: (lv_name_0_0= RULE_GERMAN_STRING )
            // PsiInternalUnicodeTestLanguage.g:109:4: lv_name_0_0= RULE_GERMAN_STRING
            {

            				markLeaf(elementTypeProvider.getGString_NameGERMAN_STRINGTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_GERMAN_STRING,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleGString"


    // $ANTLR start "entryRuleQuotedString"
    // PsiInternalUnicodeTestLanguage.g:121:1: entryRuleQuotedString : ruleQuotedString EOF ;
    public final void entryRuleQuotedString() throws RecognitionException {
        try {
            // PsiInternalUnicodeTestLanguage.g:121:22: ( ruleQuotedString EOF )
            // PsiInternalUnicodeTestLanguage.g:122:2: ruleQuotedString EOF
            {
             markComposite(elementTypeProvider.getQuotedStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleQuotedString();

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
    // $ANTLR end "entryRuleQuotedString"


    // $ANTLR start "ruleQuotedString"
    // PsiInternalUnicodeTestLanguage.g:127:1: ruleQuotedString : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final void ruleQuotedString() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalUnicodeTestLanguage.g:127:17: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // PsiInternalUnicodeTestLanguage.g:128:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // PsiInternalUnicodeTestLanguage.g:128:2: ( (lv_name_0_0= RULE_STRING ) )
            // PsiInternalUnicodeTestLanguage.g:129:3: (lv_name_0_0= RULE_STRING )
            {
            // PsiInternalUnicodeTestLanguage.g:129:3: (lv_name_0_0= RULE_STRING )
            // PsiInternalUnicodeTestLanguage.g:130:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getQuotedString_NameSTRINGTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleQuotedString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L});
    }


}