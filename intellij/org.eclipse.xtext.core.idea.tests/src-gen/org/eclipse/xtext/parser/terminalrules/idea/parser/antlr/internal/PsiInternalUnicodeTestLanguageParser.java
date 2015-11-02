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
    // PsiInternalUnicodeTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalUnicodeTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalUnicodeTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalUnicodeTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (lv_strings_0_0= ruleAbstractString ) )* ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_strings_0_0 = null;


        try {
            // PsiInternalUnicodeTestLanguage.g:60:1: ( ( (lv_strings_0_0= ruleAbstractString ) )* )
            // PsiInternalUnicodeTestLanguage.g:61:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            {
            // PsiInternalUnicodeTestLanguage.g:61:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_GERMAN_STRING && LA1_0<=RULE_STRING)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalUnicodeTestLanguage.g:62:3: (lv_strings_0_0= ruleAbstractString )
            	    {
            	    // PsiInternalUnicodeTestLanguage.g:62:3: (lv_strings_0_0= ruleAbstractString )
            	    // PsiInternalUnicodeTestLanguage.g:63:4: lv_strings_0_0= ruleAbstractString
            	    {

            	    				markComposite(elementTypeProvider.getModel_StringsAbstractStringParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_strings_0_0=ruleAbstractString();

            	    state._fsp--;


            	    				doneComposite();
            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractString"
    // PsiInternalUnicodeTestLanguage.g:79:1: entryRuleAbstractString returns [Boolean current=false] : iv_ruleAbstractString= ruleAbstractString EOF ;
    public final Boolean entryRuleAbstractString() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractString = null;


        try {
            // PsiInternalUnicodeTestLanguage.g:79:56: (iv_ruleAbstractString= ruleAbstractString EOF )
            // PsiInternalUnicodeTestLanguage.g:80:2: iv_ruleAbstractString= ruleAbstractString EOF
            {
             markComposite(elementTypeProvider.getAbstractStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractString=ruleAbstractString();

            state._fsp--;

             current =iv_ruleAbstractString; 
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
    // $ANTLR end "entryRuleAbstractString"


    // $ANTLR start "ruleAbstractString"
    // PsiInternalUnicodeTestLanguage.g:86:1: ruleAbstractString returns [Boolean current=false] : (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString ) ;
    public final Boolean ruleAbstractString() throws RecognitionException {
        Boolean current = false;

        Boolean this_GString_0 = null;

        Boolean this_QuotedString_1 = null;


        try {
            // PsiInternalUnicodeTestLanguage.g:87:1: ( (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString ) )
            // PsiInternalUnicodeTestLanguage.g:88:2: (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString )
            {
            // PsiInternalUnicodeTestLanguage.g:88:2: (this_GString_0= ruleGString | this_QuotedString_1= ruleQuotedString )
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
                    // PsiInternalUnicodeTestLanguage.g:89:3: this_GString_0= ruleGString
                    {

                    			markComposite(elementTypeProvider.getAbstractString_GStringParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_GString_0=ruleGString();

                    state._fsp--;


                    			current = this_GString_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalUnicodeTestLanguage.g:98:3: this_QuotedString_1= ruleQuotedString
                    {

                    			markComposite(elementTypeProvider.getAbstractString_QuotedStringParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_QuotedString_1=ruleQuotedString();

                    state._fsp--;


                    			current = this_QuotedString_1;
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
        return current;
    }
    // $ANTLR end "ruleAbstractString"


    // $ANTLR start "entryRuleGString"
    // PsiInternalUnicodeTestLanguage.g:110:1: entryRuleGString returns [Boolean current=false] : iv_ruleGString= ruleGString EOF ;
    public final Boolean entryRuleGString() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGString = null;


        try {
            // PsiInternalUnicodeTestLanguage.g:110:49: (iv_ruleGString= ruleGString EOF )
            // PsiInternalUnicodeTestLanguage.g:111:2: iv_ruleGString= ruleGString EOF
            {
             markComposite(elementTypeProvider.getGStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleGString=ruleGString();

            state._fsp--;

             current =iv_ruleGString; 
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
    // $ANTLR end "entryRuleGString"


    // $ANTLR start "ruleGString"
    // PsiInternalUnicodeTestLanguage.g:117:1: ruleGString returns [Boolean current=false] : ( (lv_name_0_0= RULE_GERMAN_STRING ) ) ;
    public final Boolean ruleGString() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalUnicodeTestLanguage.g:118:1: ( ( (lv_name_0_0= RULE_GERMAN_STRING ) ) )
            // PsiInternalUnicodeTestLanguage.g:119:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            {
            // PsiInternalUnicodeTestLanguage.g:119:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            // PsiInternalUnicodeTestLanguage.g:120:3: (lv_name_0_0= RULE_GERMAN_STRING )
            {
            // PsiInternalUnicodeTestLanguage.g:120:3: (lv_name_0_0= RULE_GERMAN_STRING )
            // PsiInternalUnicodeTestLanguage.g:121:4: lv_name_0_0= RULE_GERMAN_STRING
            {

            				markLeaf(elementTypeProvider.getGString_NameGERMAN_STRINGTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_GERMAN_STRING,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleGString"


    // $ANTLR start "entryRuleQuotedString"
    // PsiInternalUnicodeTestLanguage.g:139:1: entryRuleQuotedString returns [Boolean current=false] : iv_ruleQuotedString= ruleQuotedString EOF ;
    public final Boolean entryRuleQuotedString() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleQuotedString = null;


        try {
            // PsiInternalUnicodeTestLanguage.g:139:54: (iv_ruleQuotedString= ruleQuotedString EOF )
            // PsiInternalUnicodeTestLanguage.g:140:2: iv_ruleQuotedString= ruleQuotedString EOF
            {
             markComposite(elementTypeProvider.getQuotedStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleQuotedString=ruleQuotedString();

            state._fsp--;

             current =iv_ruleQuotedString; 
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
    // $ANTLR end "entryRuleQuotedString"


    // $ANTLR start "ruleQuotedString"
    // PsiInternalUnicodeTestLanguage.g:146:1: ruleQuotedString returns [Boolean current=false] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final Boolean ruleQuotedString() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalUnicodeTestLanguage.g:147:1: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // PsiInternalUnicodeTestLanguage.g:148:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // PsiInternalUnicodeTestLanguage.g:148:2: ( (lv_name_0_0= RULE_STRING ) )
            // PsiInternalUnicodeTestLanguage.g:149:3: (lv_name_0_0= RULE_STRING )
            {
            // PsiInternalUnicodeTestLanguage.g:149:3: (lv_name_0_0= RULE_STRING )
            // PsiInternalUnicodeTestLanguage.g:150:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getQuotedString_NameSTRINGTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "ruleQuotedString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L});
    }


}