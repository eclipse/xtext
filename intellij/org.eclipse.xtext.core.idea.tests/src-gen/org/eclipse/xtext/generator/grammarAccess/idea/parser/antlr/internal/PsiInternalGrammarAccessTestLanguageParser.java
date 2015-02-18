package org.eclipse.xtext.generator.grammarAccess.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:50:1: entryRuleRoot : ruleRoot EOF ;
    public final void entryRuleRoot() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:50:14: ( ruleRoot EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:51:2: ruleRoot EOF
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:59:9: ( ( (lv_elements_0_0= ruleType ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:60:2: ( (lv_elements_0_0= ruleType ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:60:2: ( (lv_elements_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:61:3: (lv_elements_0_0= ruleType )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:61:3: (lv_elements_0_0= ruleType )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:62:4: lv_elements_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getRoot_ElementsTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleRoot89);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:74:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:74:14: ( ruleType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:75:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType115);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType121); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:83:1: ruleType : ( ruleAType | ruleAnotherType ) ;
    public final void ruleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:83:9: ( ( ruleAType | ruleAnotherType ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:84:2: ( ruleAType | ruleAnotherType )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:84:2: ( ruleAType | ruleAnotherType )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:85:3: ruleAType
                    {

                    			markComposite(elementTypeProvider.getType_ATypeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAType_in_ruleType142);
                    ruleAType();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:93:3: ruleAnotherType
                    {

                    			markComposite(elementTypeProvider.getType_AnotherTypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAnotherType_in_ruleType162);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:104:1: entryRuleAType : ruleAType EOF ;
    public final void entryRuleAType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:104:15: ( ruleAType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:105:2: ruleAType EOF
            {
             markComposite(elementTypeProvider.getATypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAType_in_entryRuleAType182);
            ruleAType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAType188); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:113:1: ruleAType : (otherlv_0= 'foo' () ) ;
    public final void ruleAType() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:113:10: ( (otherlv_0= 'foo' () ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:114:2: (otherlv_0= 'foo' () )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:114:2: (otherlv_0= 'foo' () )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:115:3: otherlv_0= 'foo' ()
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleAType211); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAType_FooKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:122:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:123:4: 
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:132:1: entryRuleAnotherType : ruleAnotherType EOF ;
    public final void entryRuleAnotherType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:132:21: ( ruleAnotherType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:133:2: ruleAnotherType EOF
            {
             markComposite(elementTypeProvider.getAnotherTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAnotherType_in_entryRuleAnotherType244);
            ruleAnotherType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnotherType250); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:141:1: ruleAnotherType : (otherlv_0= 'bar' () ) ;
    public final void ruleAnotherType() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:141:16: ( (otherlv_0= 'bar' () ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:142:2: (otherlv_0= 'bar' () )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:142:2: (otherlv_0= 'bar' () )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:143:3: otherlv_0= 'bar' ()
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAnotherType273); 

            			doneLeaf(otherlv_0, elementTypeProvider.getAnotherType_BarKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:150:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/idea/parser/antlr/internal/PsiInternalGrammarAccessTestLanguage.g:151:4: 
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
        public static final BitSet FOLLOW_ruleType_in_ruleRoot89 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAType_in_ruleType142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherType_in_ruleType162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAType_in_entryRuleAType182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAType188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleAType211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherType_in_entryRuleAnotherType244 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnotherType250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleAnotherType273 = new BitSet(new long[]{0x0000000000000002L});
    }


}