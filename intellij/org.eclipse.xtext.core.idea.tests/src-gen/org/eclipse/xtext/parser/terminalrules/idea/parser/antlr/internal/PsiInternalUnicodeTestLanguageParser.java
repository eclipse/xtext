package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:51:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:59:1: ruleModel : ( (lv_strings_0_0= ruleAbstractString ) )* ;
    public final void ruleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:59:10: ( ( (lv_strings_0_0= ruleAbstractString ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:60:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:60:2: ( (lv_strings_0_0= ruleAbstractString ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_GERMAN_STRING && LA1_0<=RULE_STRING)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:61:3: (lv_strings_0_0= ruleAbstractString )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:61:3: (lv_strings_0_0= ruleAbstractString )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:62:4: lv_strings_0_0= ruleAbstractString
            	    {

            	    				markComposite(elementTypeProvider.getModel_StringsAbstractStringParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractString_in_ruleModel89);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:74:1: entryRuleAbstractString : ruleAbstractString EOF ;
    public final void entryRuleAbstractString() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:74:24: ( ruleAbstractString EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:75:2: ruleAbstractString EOF
            {
             markComposite(elementTypeProvider.getAbstractStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractString_in_entryRuleAbstractString115);
            ruleAbstractString();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractString121); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:83:1: ruleAbstractString : ( ruleGString | ruleQuotedString ) ;
    public final void ruleAbstractString() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:83:19: ( ( ruleGString | ruleQuotedString ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:84:2: ( ruleGString | ruleQuotedString )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:84:2: ( ruleGString | ruleQuotedString )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:85:3: ruleGString
                    {

                    			markComposite(elementTypeProvider.getAbstractString_GStringParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleGString_in_ruleAbstractString142);
                    ruleGString();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:93:3: ruleQuotedString
                    {

                    			markComposite(elementTypeProvider.getAbstractString_QuotedStringParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleQuotedString_in_ruleAbstractString162);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:104:1: entryRuleGString : ruleGString EOF ;
    public final void entryRuleGString() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:104:17: ( ruleGString EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:105:2: ruleGString EOF
            {
             markComposite(elementTypeProvider.getGStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleGString_in_entryRuleGString182);
            ruleGString();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGString188); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:113:1: ruleGString : ( (lv_name_0_0= RULE_GERMAN_STRING ) ) ;
    public final void ruleGString() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:113:12: ( ( (lv_name_0_0= RULE_GERMAN_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:114:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:114:2: ( (lv_name_0_0= RULE_GERMAN_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:115:3: (lv_name_0_0= RULE_GERMAN_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:115:3: (lv_name_0_0= RULE_GERMAN_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:116:4: lv_name_0_0= RULE_GERMAN_STRING
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_GERMAN_STRING,FollowSets000.FOLLOW_RULE_GERMAN_STRING_in_ruleGString217); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getGString_NameGERMAN_STRINGTerminalRuleCall_0ElementType());
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:128:1: entryRuleQuotedString : ruleQuotedString EOF ;
    public final void entryRuleQuotedString() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:128:22: ( ruleQuotedString EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:129:2: ruleQuotedString EOF
            {
             markComposite(elementTypeProvider.getQuotedStringElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleQuotedString_in_entryRuleQuotedString242);
            ruleQuotedString();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQuotedString248); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:137:1: ruleQuotedString : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final void ruleQuotedString() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:137:17: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:138:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:138:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:139:3: (lv_name_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:139:3: (lv_name_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/terminalrules/idea/parser/antlr/internal/PsiInternalUnicodeTestLanguage.g:140:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleQuotedString277); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getQuotedString_NameSTRINGTerminalRuleCall_0ElementType());
            			

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractString_in_ruleModel89 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleAbstractString_in_entryRuleAbstractString115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractString121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGString_in_ruleAbstractString142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuotedString_in_ruleAbstractString162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGString_in_entryRuleGString182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGString188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_GERMAN_STRING_in_ruleGString217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQuotedString_in_entryRuleQuotedString242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQuotedString248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleQuotedString277 = new BitSet(new long[]{0x0000000000000002L});
    }


}