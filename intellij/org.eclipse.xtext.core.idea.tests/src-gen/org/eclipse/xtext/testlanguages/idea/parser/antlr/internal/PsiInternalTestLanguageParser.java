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
    // PsiInternalTestLanguage.g:52:1: entryRuleEntryRule returns [Boolean current=false] : iv_ruleEntryRule= ruleEntryRule EOF ;
    public final Boolean entryRuleEntryRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntryRule = null;


        try {
            // PsiInternalTestLanguage.g:52:51: (iv_ruleEntryRule= ruleEntryRule EOF )
            // PsiInternalTestLanguage.g:53:2: iv_ruleEntryRule= ruleEntryRule EOF
            {
             markComposite(elementTypeProvider.getEntryRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEntryRule=ruleEntryRule();

            state._fsp--;

             current =iv_ruleEntryRule; 
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
    // $ANTLR end "entryRuleEntryRule"


    // $ANTLR start "ruleEntryRule"
    // PsiInternalTestLanguage.g:59:1: ruleEntryRule returns [Boolean current=false] : ( (lv_multiFeature_0_0= ruleAbstractRule ) )* ;
    public final Boolean ruleEntryRule() throws RecognitionException {
        Boolean current = false;

        Boolean lv_multiFeature_0_0 = null;


        try {
            // PsiInternalTestLanguage.g:60:1: ( ( (lv_multiFeature_0_0= ruleAbstractRule ) )* )
            // PsiInternalTestLanguage.g:61:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            {
            // PsiInternalTestLanguage.g:61:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalTestLanguage.g:62:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    {
            	    // PsiInternalTestLanguage.g:62:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    // PsiInternalTestLanguage.g:63:4: lv_multiFeature_0_0= ruleAbstractRule
            	    {

            	    				markComposite(elementTypeProvider.getEntryRule_MultiFeatureAbstractRuleParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_multiFeature_0_0=ruleAbstractRule();

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
    // $ANTLR end "ruleEntryRule"


    // $ANTLR start "entryRuleAbstractRule"
    // PsiInternalTestLanguage.g:79:1: entryRuleAbstractRule returns [Boolean current=false] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final Boolean entryRuleAbstractRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAbstractRule = null;


        try {
            // PsiInternalTestLanguage.g:79:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // PsiInternalTestLanguage.g:80:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAbstractRule=ruleAbstractRule();

            state._fsp--;

             current =iv_ruleAbstractRule; 
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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // PsiInternalTestLanguage.g:86:1: ruleAbstractRule returns [Boolean current=false] : (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) ;
    public final Boolean ruleAbstractRule() throws RecognitionException {
        Boolean current = false;

        Boolean this_ChoiceRule_0 = null;

        Boolean this_ReducibleRule_1 = null;


        try {
            // PsiInternalTestLanguage.g:87:1: ( (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule ) )
            // PsiInternalTestLanguage.g:88:2: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
            {
            // PsiInternalTestLanguage.g:88:2: (this_ChoiceRule_0= ruleChoiceRule | this_ReducibleRule_1= ruleReducibleRule )
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
                    // PsiInternalTestLanguage.g:89:3: this_ChoiceRule_0= ruleChoiceRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ChoiceRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ChoiceRule_0=ruleChoiceRule();

                    state._fsp--;


                    			current = this_ChoiceRule_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalTestLanguage.g:98:3: this_ReducibleRule_1= ruleReducibleRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ReducibleRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ReducibleRule_1=ruleReducibleRule();

                    state._fsp--;


                    			current = this_ReducibleRule_1;
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
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleChoiceRule"
    // PsiInternalTestLanguage.g:110:1: entryRuleChoiceRule returns [Boolean current=false] : iv_ruleChoiceRule= ruleChoiceRule EOF ;
    public final Boolean entryRuleChoiceRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChoiceRule = null;


        try {
            // PsiInternalTestLanguage.g:110:52: (iv_ruleChoiceRule= ruleChoiceRule EOF )
            // PsiInternalTestLanguage.g:111:2: iv_ruleChoiceRule= ruleChoiceRule EOF
            {
             markComposite(elementTypeProvider.getChoiceRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChoiceRule=ruleChoiceRule();

            state._fsp--;

             current =iv_ruleChoiceRule; 
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
    // $ANTLR end "entryRuleChoiceRule"


    // $ANTLR start "ruleChoiceRule"
    // PsiInternalTestLanguage.g:117:1: ruleChoiceRule returns [Boolean current=false] : (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleChoiceRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_optionalKeyword_1_0=null;
        Token lv_name_2_0=null;

        try {
            // PsiInternalTestLanguage.g:118:1: ( (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // PsiInternalTestLanguage.g:119:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // PsiInternalTestLanguage.g:119:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // PsiInternalTestLanguage.g:120:3: otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getChoiceRule_ChoiceKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalTestLanguage.g:127:3: ( (lv_optionalKeyword_1_0= 'optional' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalTestLanguage.g:128:4: (lv_optionalKeyword_1_0= 'optional' )
                    {
                    // PsiInternalTestLanguage.g:128:4: (lv_optionalKeyword_1_0= 'optional' )
                    // PsiInternalTestLanguage.g:129:5: lv_optionalKeyword_1_0= 'optional'
                    {

                    					markLeaf(elementTypeProvider.getChoiceRule_OptionalKeywordOptionalKeyword_1_0ElementType());
                    				
                    lv_optionalKeyword_1_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                    					doneLeaf(lv_optionalKeyword_1_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalTestLanguage.g:144:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalTestLanguage.g:145:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalTestLanguage.g:145:4: (lv_name_2_0= RULE_ID )
            // PsiInternalTestLanguage.g:146:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getChoiceRule_NameIDTerminalRuleCall_2_0ElementType());
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
        return current;
    }
    // $ANTLR end "ruleChoiceRule"


    // $ANTLR start "entryRuleReducibleRule"
    // PsiInternalTestLanguage.g:165:1: entryRuleReducibleRule returns [Boolean current=false] : iv_ruleReducibleRule= ruleReducibleRule EOF ;
    public final Boolean entryRuleReducibleRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleReducibleRule = null;


        try {
            // PsiInternalTestLanguage.g:165:55: (iv_ruleReducibleRule= ruleReducibleRule EOF )
            // PsiInternalTestLanguage.g:166:2: iv_ruleReducibleRule= ruleReducibleRule EOF
            {
             markComposite(elementTypeProvider.getReducibleRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleReducibleRule=ruleReducibleRule();

            state._fsp--;

             current =iv_ruleReducibleRule; 
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
    // $ANTLR end "entryRuleReducibleRule"


    // $ANTLR start "ruleReducibleRule"
    // PsiInternalTestLanguage.g:172:1: ruleReducibleRule returns [Boolean current=false] : (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) ;
    public final Boolean ruleReducibleRule() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_TerminalRule_1 = null;

        Boolean lv_actionFeature_3_0 = null;


        try {
            // PsiInternalTestLanguage.g:173:1: ( (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) )
            // PsiInternalTestLanguage.g:174:2: (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            {
            // PsiInternalTestLanguage.g:174:2: (otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            // PsiInternalTestLanguage.g:175:3: otherlv_0= 'reducible' this_TerminalRule_1= ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            {

            			markLeaf(elementTypeProvider.getReducibleRule_ReducibleKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getReducibleRule_TerminalRuleParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_TerminalRule_1=ruleTerminalRule();

            state._fsp--;


            			current = this_TerminalRule_1;
            			doneComposite();
            		
            // PsiInternalTestLanguage.g:190:3: ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalTestLanguage.g:191:4: () ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    {
                    // PsiInternalTestLanguage.g:191:4: ()
                    // PsiInternalTestLanguage.g:192:5: 
                    {

                    					precedeComposite(elementTypeProvider.getReducibleRule_ReducibleCompositeActionFeatureAction_2_0ElementType());
                    					doneComposite();
                    					associateWithSemanticElement();
                    				

                    }

                    // PsiInternalTestLanguage.g:198:4: ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    // PsiInternalTestLanguage.g:199:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    {
                    // PsiInternalTestLanguage.g:199:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    // PsiInternalTestLanguage.g:200:6: lv_actionFeature_3_0= ruleTerminalRule
                    {

                    						markComposite(elementTypeProvider.getReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_actionFeature_3_0=ruleTerminalRule();

                    state._fsp--;


                    						doneComposite();
                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleReducibleRule"


    // $ANTLR start "entryRuleTerminalRule"
    // PsiInternalTestLanguage.g:218:1: entryRuleTerminalRule returns [Boolean current=false] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final Boolean entryRuleTerminalRule() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerminalRule = null;


        try {
            // PsiInternalTestLanguage.g:218:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // PsiInternalTestLanguage.g:219:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerminalRule=ruleTerminalRule();

            state._fsp--;

             current =iv_ruleTerminalRule; 
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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // PsiInternalTestLanguage.g:225:1: ruleTerminalRule returns [Boolean current=false] : ( (lv_stringFeature_0_0= RULE_STRING ) ) ;
    public final Boolean ruleTerminalRule() throws RecognitionException {
        Boolean current = false;

        Token lv_stringFeature_0_0=null;

        try {
            // PsiInternalTestLanguage.g:226:1: ( ( (lv_stringFeature_0_0= RULE_STRING ) ) )
            // PsiInternalTestLanguage.g:227:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            {
            // PsiInternalTestLanguage.g:227:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            // PsiInternalTestLanguage.g:228:3: (lv_stringFeature_0_0= RULE_STRING )
            {
            // PsiInternalTestLanguage.g:228:3: (lv_stringFeature_0_0= RULE_STRING )
            // PsiInternalTestLanguage.g:229:4: lv_stringFeature_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getTerminalRule_StringFeatureSTRINGTerminalRuleCall_0ElementType());
            			
            lv_stringFeature_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

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
        return current;
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