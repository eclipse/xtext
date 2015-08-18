package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalTestLanguage.g"; }



    	protected TestLanguageGrammarAccess grammarAccess;

    	protected TestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalTestLanguageParser(PsiBuilder builder, TokenStream input, TestLanguageElementTypeProvider elementTypeProvider, TestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "EntryRule";
    	}




    // $ANTLR start "entryRuleEntryRule"
    // PsiInternalTestLanguage.g:52:1: entryRuleEntryRule : ruleEntryRule EOF ;
    public final void entryRuleEntryRule() throws RecognitionException {
        try {
            // PsiInternalTestLanguage.g:52:19: ( ruleEntryRule EOF )
            // PsiInternalTestLanguage.g:53:2: ruleEntryRule EOF
            {
             markComposite(elementTypeProvider.getEntryRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEntryRule();

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
    // $ANTLR end "entryRuleEntryRule"


    // $ANTLR start "ruleEntryRule"
    // PsiInternalTestLanguage.g:58:1: ruleEntryRule : ( (lv_multiFeature_0_0= ruleAbstractRule ) )* ;
    public final void ruleEntryRule() throws RecognitionException {
        try {
            // PsiInternalTestLanguage.g:58:14: ( ( (lv_multiFeature_0_0= ruleAbstractRule ) )* )
            // PsiInternalTestLanguage.g:59:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            {
            // PsiInternalTestLanguage.g:59:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalTestLanguage.g:60:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    {
            	    // PsiInternalTestLanguage.g:60:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    // PsiInternalTestLanguage.g:61:4: lv_multiFeature_0_0= ruleAbstractRule
            	    {

            	    				markComposite(elementTypeProvider.getEntryRule_MultiFeatureAbstractRuleParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleAbstractRule();

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
    // $ANTLR end "ruleEntryRule"


    // $ANTLR start "entryRuleAbstractRule"
    // PsiInternalTestLanguage.g:73:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // PsiInternalTestLanguage.g:73:22: ( ruleAbstractRule EOF )
            // PsiInternalTestLanguage.g:74:2: ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractRule();

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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // PsiInternalTestLanguage.g:79:1: ruleAbstractRule : ( ruleChoiceRule | ruleReducibleRule ) ;
    public final void ruleAbstractRule() throws RecognitionException {
        try {
            // PsiInternalTestLanguage.g:79:17: ( ( ruleChoiceRule | ruleReducibleRule ) )
            // PsiInternalTestLanguage.g:80:2: ( ruleChoiceRule | ruleReducibleRule )
            {
            // PsiInternalTestLanguage.g:80:2: ( ruleChoiceRule | ruleReducibleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalTestLanguage.g:81:3: ruleChoiceRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ChoiceRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleChoiceRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalTestLanguage.g:89:3: ruleReducibleRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ReducibleRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReducibleRule();

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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleChoiceRule"
    // PsiInternalTestLanguage.g:100:1: entryRuleChoiceRule : ruleChoiceRule EOF ;
    public final void entryRuleChoiceRule() throws RecognitionException {
        try {
            // PsiInternalTestLanguage.g:100:20: ( ruleChoiceRule EOF )
            // PsiInternalTestLanguage.g:101:2: ruleChoiceRule EOF
            {
             markComposite(elementTypeProvider.getChoiceRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChoiceRule();

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
    // $ANTLR end "entryRuleChoiceRule"


    // $ANTLR start "ruleChoiceRule"
    // PsiInternalTestLanguage.g:106:1: ruleChoiceRule : (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final void ruleChoiceRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_optionalKeyword_1_0=null;
        Token lv_name_2_0=null;

        try {
            // PsiInternalTestLanguage.g:106:15: ( (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // PsiInternalTestLanguage.g:107:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // PsiInternalTestLanguage.g:107:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // PsiInternalTestLanguage.g:108:3: otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getChoiceRule_ChoiceKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalTestLanguage.g:115:3: ( (lv_optionalKeyword_1_0= 'optional' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalTestLanguage.g:116:4: (lv_optionalKeyword_1_0= 'optional' )
                    {
                    // PsiInternalTestLanguage.g:116:4: (lv_optionalKeyword_1_0= 'optional' )
                    // PsiInternalTestLanguage.g:117:5: lv_optionalKeyword_1_0= 'optional'
                    {

                    					markLeaf(elementTypeProvider.getChoiceRule_OptionalKeywordOptionalKeyword_1_0ElementType());
                    				
                    lv_optionalKeyword_1_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					doneLeaf(lv_optionalKeyword_1_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalTestLanguage.g:126:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalTestLanguage.g:127:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalTestLanguage.g:127:4: (lv_name_2_0= RULE_ID )
            // PsiInternalTestLanguage.g:128:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getChoiceRule_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_2_0);
            				

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
    // $ANTLR end "ruleChoiceRule"


    // $ANTLR start "entryRuleReducibleRule"
    // PsiInternalTestLanguage.g:141:1: entryRuleReducibleRule : ruleReducibleRule EOF ;
    public final void entryRuleReducibleRule() throws RecognitionException {
        try {
            // PsiInternalTestLanguage.g:141:23: ( ruleReducibleRule EOF )
            // PsiInternalTestLanguage.g:142:2: ruleReducibleRule EOF
            {
             markComposite(elementTypeProvider.getReducibleRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReducibleRule();

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
    // $ANTLR end "entryRuleReducibleRule"


    // $ANTLR start "ruleReducibleRule"
    // PsiInternalTestLanguage.g:147:1: ruleReducibleRule : (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) ;
    public final void ruleReducibleRule() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalTestLanguage.g:147:18: ( (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) )
            // PsiInternalTestLanguage.g:148:2: (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            {
            // PsiInternalTestLanguage.g:148:2: (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            // PsiInternalTestLanguage.g:149:3: otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            {

            			markLeaf(elementTypeProvider.getReducibleRule_ReducibleKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getReducibleRule_TerminalRuleParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            ruleTerminalRule();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalTestLanguage.g:163:3: ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalTestLanguage.g:164:4: () ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    {
                    // PsiInternalTestLanguage.g:164:4: ()
                    // PsiInternalTestLanguage.g:165:5: 
                    {

                    					precedeComposite(elementTypeProvider.getReducibleRule_ReducibleCompositeActionFeatureAction_2_0ElementType());
                    					doneComposite();
                    				

                    }

                    // PsiInternalTestLanguage.g:170:4: ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    // PsiInternalTestLanguage.g:171:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    {
                    // PsiInternalTestLanguage.g:171:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    // PsiInternalTestLanguage.g:172:6: lv_actionFeature_3_0= ruleTerminalRule
                    {

                    						markComposite(elementTypeProvider.getReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRule();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleReducibleRule"


    // $ANTLR start "entryRuleTerminalRule"
    // PsiInternalTestLanguage.g:186:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // PsiInternalTestLanguage.g:186:22: ( ruleTerminalRule EOF )
            // PsiInternalTestLanguage.g:187:2: ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRule();

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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // PsiInternalTestLanguage.g:192:1: ruleTerminalRule : ( (lv_stringFeature_0_0= RULE_STRING ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {
        Token lv_stringFeature_0_0=null;

        try {
            // PsiInternalTestLanguage.g:192:17: ( ( (lv_stringFeature_0_0= RULE_STRING ) ) )
            // PsiInternalTestLanguage.g:193:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            {
            // PsiInternalTestLanguage.g:193:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            // PsiInternalTestLanguage.g:194:3: (lv_stringFeature_0_0= RULE_STRING )
            {
            // PsiInternalTestLanguage.g:194:3: (lv_stringFeature_0_0= RULE_STRING )
            // PsiInternalTestLanguage.g:195:4: lv_stringFeature_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getTerminalRule_StringFeatureSTRINGTerminalRuleCall_0ElementType());
            			
            lv_stringFeature_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_stringFeature_0_0);
            			

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
    // $ANTLR end "ruleTerminalRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000022L});
    }


}