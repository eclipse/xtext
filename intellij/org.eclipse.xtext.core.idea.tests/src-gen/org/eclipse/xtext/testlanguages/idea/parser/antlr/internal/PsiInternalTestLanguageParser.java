package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:50:1: entryRuleEntryRule : ruleEntryRule EOF ;
    public final void entryRuleEntryRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:50:19: ( ruleEntryRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:51:2: ruleEntryRule EOF
            {
             markComposite(elementTypeProvider.getEntryRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEntryRule_in_entryRuleEntryRule54);
            ruleEntryRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntryRule60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:59:1: ruleEntryRule : ( (lv_multiFeature_0_0= ruleAbstractRule ) )* ;
    public final void ruleEntryRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:59:14: ( ( (lv_multiFeature_0_0= ruleAbstractRule ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:60:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:60:2: ( (lv_multiFeature_0_0= ruleAbstractRule ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:61:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:61:3: (lv_multiFeature_0_0= ruleAbstractRule )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:62:4: lv_multiFeature_0_0= ruleAbstractRule
            	    {

            	    				markComposite(elementTypeProvider.getEntryRule_MultiFeatureAbstractRuleParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_ruleEntryRule89);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:74:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:74:22: ( ruleAbstractRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:75:2: ruleAbstractRule EOF
            {
             markComposite(elementTypeProvider.getAbstractRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule115);
            ruleAbstractRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractRule121); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:83:1: ruleAbstractRule : ( ruleChoiceRule | ruleReducibleRule ) ;
    public final void ruleAbstractRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:83:17: ( ( ruleChoiceRule | ruleReducibleRule ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:84:2: ( ruleChoiceRule | ruleReducibleRule )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:84:2: ( ruleChoiceRule | ruleReducibleRule )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:85:3: ruleChoiceRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ChoiceRuleParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleChoiceRule_in_ruleAbstractRule142);
                    ruleChoiceRule();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:93:3: ruleReducibleRule
                    {

                    			markComposite(elementTypeProvider.getAbstractRule_ReducibleRuleParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleReducibleRule_in_ruleAbstractRule162);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:104:1: entryRuleChoiceRule : ruleChoiceRule EOF ;
    public final void entryRuleChoiceRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:104:20: ( ruleChoiceRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:105:2: ruleChoiceRule EOF
            {
             markComposite(elementTypeProvider.getChoiceRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule182);
            ruleChoiceRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChoiceRule188); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:113:1: ruleChoiceRule : (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final void ruleChoiceRule() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_optionalKeyword_1_0=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:113:15: ( (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:114:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:114:2: (otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:115:3: otherlv_0= 'choice' ( (lv_optionalKeyword_1_0= 'optional' ) )? ( (lv_name_2_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleChoiceRule211); 

            			doneLeaf(otherlv_0, elementTypeProvider.getChoiceRule_ChoiceKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:122:3: ( (lv_optionalKeyword_1_0= 'optional' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:123:4: (lv_optionalKeyword_1_0= 'optional' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:123:4: (lv_optionalKeyword_1_0= 'optional' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:124:5: lv_optionalKeyword_1_0= 'optional'
                    {

                    					markLeaf();
                    				
                    lv_optionalKeyword_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleChoiceRule238); 

                    					doneLeaf(lv_optionalKeyword_1_0, elementTypeProvider.getChoiceRule_OptionalKeywordOptionalKeyword_1_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:133:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:134:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:134:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:135:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChoiceRule277); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getChoiceRule_NameIDTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:148:1: entryRuleReducibleRule : ruleReducibleRule EOF ;
    public final void entryRuleReducibleRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:148:23: ( ruleReducibleRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:149:2: ruleReducibleRule EOF
            {
             markComposite(elementTypeProvider.getReducibleRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule308);
            ruleReducibleRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReducibleRule314); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:157:1: ruleReducibleRule : (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) ;
    public final void ruleReducibleRule() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:157:18: ( (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:158:2: (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:158:2: (otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:159:3: otherlv_0= 'reducible' ruleTerminalRule ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleReducibleRule337); 

            			doneLeaf(otherlv_0, elementTypeProvider.getReducibleRule_ReducibleKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getReducibleRule_TerminalRuleParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleReducibleRule349);
            ruleTerminalRule();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:173:3: ( () ( (lv_actionFeature_3_0= ruleTerminalRule ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:174:4: () ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:174:4: ()
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:175:5: 
                    {

                    					precedeComposite(elementTypeProvider.getReducibleRule_ReducibleCompositeActionFeatureAction_2_0ElementType());
                    					doneComposite();
                    				

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:180:4: ( (lv_actionFeature_3_0= ruleTerminalRule ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:181:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:181:5: (lv_actionFeature_3_0= ruleTerminalRule )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:182:6: lv_actionFeature_3_0= ruleTerminalRule
                    {

                    						markComposite(elementTypeProvider.getReducibleRule_ActionFeatureTerminalRuleParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_ruleReducibleRule400);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:196:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:196:22: ( ruleTerminalRule EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:197:2: ruleTerminalRule EOF
            {
             markComposite(elementTypeProvider.getTerminalRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule439);
            ruleTerminalRule();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerminalRule445); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:205:1: ruleTerminalRule : ( (lv_stringFeature_0_0= RULE_STRING ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {
        Token lv_stringFeature_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:205:17: ( ( (lv_stringFeature_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:206:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:206:2: ( (lv_stringFeature_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:207:3: (lv_stringFeature_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:207:3: (lv_stringFeature_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalTestLanguage.g:208:4: lv_stringFeature_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_stringFeature_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTerminalRule474); 

            				doneLeaf(lv_stringFeature_0_0, elementTypeProvider.getTerminalRule_StringFeatureSTRINGTerminalRuleCall_0ElementType());
            			

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
        public static final BitSet FOLLOW_ruleEntryRule_in_entryRuleEntryRule54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntryRule60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_ruleEntryRule89 = new BitSet(new long[]{0x0000000000002802L});
        public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule115 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChoiceRule_in_ruleAbstractRule142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReducibleRule_in_ruleAbstractRule162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChoiceRule_in_entryRuleChoiceRule182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChoiceRule188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleChoiceRule211 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleChoiceRule238 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReducibleRule_in_entryRuleReducibleRule308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReducibleRule314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleReducibleRule337 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule349 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule439 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule474 = new BitSet(new long[]{0x0000000000000002L});
    }


}