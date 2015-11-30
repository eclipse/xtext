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
    // PsiInternalGrammarAccessTestLanguage.g:52:1: entryRuleRoot returns [Boolean current=false] : iv_ruleRoot= ruleRoot EOF ;
    public final Boolean entryRuleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRoot = null;


        try {
            // PsiInternalGrammarAccessTestLanguage.g:52:46: (iv_ruleRoot= ruleRoot EOF )
            // PsiInternalGrammarAccessTestLanguage.g:53:2: iv_ruleRoot= ruleRoot EOF
            {
             markComposite(elementTypeProvider.getRootElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // PsiInternalGrammarAccessTestLanguage.g:59:1: ruleRoot returns [Boolean current=false] : ( (lv_elements_0_0= ruleType ) )* ;
    public final Boolean ruleRoot() throws RecognitionException {
        Boolean current = false;

        Boolean lv_elements_0_0 = null;


        try {
            // PsiInternalGrammarAccessTestLanguage.g:60:1: ( ( (lv_elements_0_0= ruleType ) )* )
            // PsiInternalGrammarAccessTestLanguage.g:61:2: ( (lv_elements_0_0= ruleType ) )*
            {
            // PsiInternalGrammarAccessTestLanguage.g:61:2: ( (lv_elements_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalGrammarAccessTestLanguage.g:62:3: (lv_elements_0_0= ruleType )
            	    {
            	    // PsiInternalGrammarAccessTestLanguage.g:62:3: (lv_elements_0_0= ruleType )
            	    // PsiInternalGrammarAccessTestLanguage.g:63:4: lv_elements_0_0= ruleType
            	    {

            	    				markComposite(elementTypeProvider.getRoot_ElementsTypeParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_elements_0_0=ruleType();

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleType"
    // PsiInternalGrammarAccessTestLanguage.g:79:1: entryRuleType returns [Boolean current=false] : iv_ruleType= ruleType EOF ;
    public final Boolean entryRuleType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleType = null;


        try {
            // PsiInternalGrammarAccessTestLanguage.g:79:46: (iv_ruleType= ruleType EOF )
            // PsiInternalGrammarAccessTestLanguage.g:80:2: iv_ruleType= ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalGrammarAccessTestLanguage.g:86:1: ruleType returns [Boolean current=false] : (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType ) ;
    public final Boolean ruleType() throws RecognitionException {
        Boolean current = false;

        Boolean this_AType_0 = null;

        Boolean this_AnotherType_1 = null;


        try {
            // PsiInternalGrammarAccessTestLanguage.g:87:1: ( (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType ) )
            // PsiInternalGrammarAccessTestLanguage.g:88:2: (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType )
            {
            // PsiInternalGrammarAccessTestLanguage.g:88:2: (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType )
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
                    // PsiInternalGrammarAccessTestLanguage.g:89:3: this_AType_0= ruleAType
                    {

                    			markComposite(elementTypeProvider.getType_ATypeParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AType_0=ruleAType();

                    state._fsp--;


                    			current = this_AType_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalGrammarAccessTestLanguage.g:98:3: this_AnotherType_1= ruleAnotherType
                    {

                    			markComposite(elementTypeProvider.getType_AnotherTypeParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AnotherType_1=ruleAnotherType();

                    state._fsp--;


                    			current = this_AnotherType_1;
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleAType"
    // PsiInternalGrammarAccessTestLanguage.g:110:1: entryRuleAType returns [Boolean current=false] : iv_ruleAType= ruleAType EOF ;
    public final Boolean entryRuleAType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAType = null;


        try {
            // PsiInternalGrammarAccessTestLanguage.g:110:47: (iv_ruleAType= ruleAType EOF )
            // PsiInternalGrammarAccessTestLanguage.g:111:2: iv_ruleAType= ruleAType EOF
            {
             markComposite(elementTypeProvider.getATypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAType=ruleAType();

            state._fsp--;

             current =iv_ruleAType; 
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
    // $ANTLR end "entryRuleAType"


    // $ANTLR start "ruleAType"
    // PsiInternalGrammarAccessTestLanguage.g:117:1: ruleAType returns [Boolean current=false] : (otherlv_0= 'foo' () ) ;
    public final Boolean ruleAType() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalGrammarAccessTestLanguage.g:118:1: ( (otherlv_0= 'foo' () ) )
            // PsiInternalGrammarAccessTestLanguage.g:119:2: (otherlv_0= 'foo' () )
            {
            // PsiInternalGrammarAccessTestLanguage.g:119:2: (otherlv_0= 'foo' () )
            // PsiInternalGrammarAccessTestLanguage.g:120:3: otherlv_0= 'foo' ()
            {

            			markLeaf(elementTypeProvider.getAType_FooKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalGrammarAccessTestLanguage.g:127:3: ()
            // PsiInternalGrammarAccessTestLanguage.g:128:4: 
            {

            				precedeComposite(elementTypeProvider.getAType_ATypeAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
    // $ANTLR end "ruleAType"


    // $ANTLR start "entryRuleAnotherType"
    // PsiInternalGrammarAccessTestLanguage.g:138:1: entryRuleAnotherType returns [Boolean current=false] : iv_ruleAnotherType= ruleAnotherType EOF ;
    public final Boolean entryRuleAnotherType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAnotherType = null;


        try {
            // PsiInternalGrammarAccessTestLanguage.g:138:53: (iv_ruleAnotherType= ruleAnotherType EOF )
            // PsiInternalGrammarAccessTestLanguage.g:139:2: iv_ruleAnotherType= ruleAnotherType EOF
            {
             markComposite(elementTypeProvider.getAnotherTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnotherType=ruleAnotherType();

            state._fsp--;

             current =iv_ruleAnotherType; 
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
    // $ANTLR end "entryRuleAnotherType"


    // $ANTLR start "ruleAnotherType"
    // PsiInternalGrammarAccessTestLanguage.g:145:1: ruleAnotherType returns [Boolean current=false] : (otherlv_0= 'bar' () ) ;
    public final Boolean ruleAnotherType() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalGrammarAccessTestLanguage.g:146:1: ( (otherlv_0= 'bar' () ) )
            // PsiInternalGrammarAccessTestLanguage.g:147:2: (otherlv_0= 'bar' () )
            {
            // PsiInternalGrammarAccessTestLanguage.g:147:2: (otherlv_0= 'bar' () )
            // PsiInternalGrammarAccessTestLanguage.g:148:3: otherlv_0= 'bar' ()
            {

            			markLeaf(elementTypeProvider.getAnotherType_BarKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalGrammarAccessTestLanguage.g:155:3: ()
            // PsiInternalGrammarAccessTestLanguage.g:156:4: 
            {

            				precedeComposite(elementTypeProvider.getAnotherType_AnotherTypeAction_1ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

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
    // $ANTLR end "ruleAnotherType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    }


}