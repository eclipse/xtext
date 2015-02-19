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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:52:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:52:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:53:2: ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot54);
            ruleRoot();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:59:1: ruleRoot : ( (lv_elements_0_0= ruleType ) )* ;
    public final void ruleRoot() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:62:2: ( ( (lv_elements_0_0= ruleType ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:63:2: ( (lv_elements_0_0= ruleType ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:63:2: ( (lv_elements_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:64:3: (lv_elements_0_0= ruleType )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:64:3: (lv_elements_0_0= ruleType )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:65:4: lv_elements_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getRoot_ElementsTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleRoot94);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:77:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:77:14: ( ruleType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:78:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType120);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType126); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:84:1: ruleType : ( ruleAType | ruleAnotherType ) ;
    public final void ruleType() throws RecognitionException {


        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:87:2: ( ( ruleAType | ruleAnotherType ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:88:2: ( ruleAType | ruleAnotherType )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:88:2: ( ruleAType | ruleAnotherType )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:89:3: ruleAType
                    {

                    			markComposite(elementTypeProvider.getType_ATypeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAType_in_ruleType152);
                    ruleAType();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:97:3: ruleAnotherType
                    {

                    			markComposite(elementTypeProvider.getType_AnotherTypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAnotherType_in_ruleType172);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:108:1: entryRuleAType : ruleAType EOF ;
    public final void entryRuleAType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:108:15: ( ruleAType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:109:2: ruleAType EOF
            {
             markComposite(elementTypeProvider.getATypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAType_in_entryRuleAType192);
            ruleAType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAType198); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:115:1: ruleAType : (otherlv_0= 'foo' () ) ;
    public final void ruleAType() throws RecognitionException {
        Token otherlv_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:118:2: ( (otherlv_0= 'foo' () ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:119:2: (otherlv_0= 'foo' () )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:119:2: (otherlv_0= 'foo' () )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:120:3: otherlv_0= 'foo' ()
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleAType226); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAType_FooKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:127:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:128:4: 
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:137:1: entryRuleAnotherType : ruleAnotherType EOF ;
    public final void entryRuleAnotherType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:137:21: ( ruleAnotherType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:138:2: ruleAnotherType EOF
            {
             markComposite(elementTypeProvider.getAnotherTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnotherType_in_entryRuleAnotherType259);
            ruleAnotherType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnotherType265); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:144:1: ruleAnotherType : (otherlv_0= 'bar' () ) ;
    public final void ruleAnotherType() throws RecognitionException {
        Token otherlv_0=null;



        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:147:2: ( (otherlv_0= 'bar' () ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:148:2: (otherlv_0= 'bar' () )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:148:2: (otherlv_0= 'bar' () )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:149:3: otherlv_0= 'bar' ()
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAnotherType293); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAnotherType_BarKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:156:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:157:4: 
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
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleRoot94 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAType_in_ruleType152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherType_in_ruleType172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAType_in_entryRuleAType192 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAType198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleAType226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherType_in_entryRuleAnotherType259 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnotherType265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleAnotherType293 = new BitSet(new long[]{0x0000000000000002L});
    }


}