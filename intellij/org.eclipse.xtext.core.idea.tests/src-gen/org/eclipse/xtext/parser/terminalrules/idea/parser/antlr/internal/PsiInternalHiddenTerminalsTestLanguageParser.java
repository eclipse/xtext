package org.eclipse.xtext.parser.terminalrules.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalHiddenTerminalsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'without'", "'hiddens'", "';'", "'with'", "'overriding'", "'('", "')'", "'call'", "'inheriting'", "'datatype'", "'rule'", "'hiding'"
    };
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=7;
    public static final int T__10=10;
    public static final int RULE_WS=4;
    public static final int RULE_SL_COMMENT=6;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int RULE_ML_COMMENT=5;

    // delegates
    // delegators


        public PsiInternalHiddenTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalHiddenTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalHiddenTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalHiddenTerminalsTestLanguage.g"; }



    	protected HiddenTerminalsTestLanguageGrammarAccess grammarAccess;

    	protected HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalHiddenTerminalsTestLanguageParser(PsiBuilder builder, TokenStream input, HiddenTerminalsTestLanguageElementTypeProvider elementTypeProvider, HiddenTerminalsTestLanguageGrammarAccess grammarAccess) {
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
    // PsiInternalHiddenTerminalsTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:53:2: ruleModel EOF
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
    // PsiInternalHiddenTerminalsTestLanguage.g:58:1: ruleModel : ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:58:10: ( ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:59:2: ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:59:2: ( ruleWithoutHiddens | ruleWithHiddens | ruleOverridingHiddens | ruleInheritingHiddens | ruleDatatypeHiddens )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 8:
                {
                alt1=1;
                }
                break;
            case 11:
                {
                alt1=2;
                }
                break;
            case 12:
                {
                alt1=3;
                }
                break;
            case 16:
                {
                alt1=4;
                }
                break;
            case 17:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:60:3: ruleWithoutHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_WithoutHiddensParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWithoutHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:68:3: ruleWithHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_WithHiddensParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWithHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:76:3: ruleOverridingHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_OverridingHiddensParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleOverridingHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:84:3: ruleInheritingHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_InheritingHiddensParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleInheritingHiddens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:92:3: ruleDatatypeHiddens
                    {

                    			markComposite(elementTypeProvider.getModel_DatatypeHiddensParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatypeHiddens();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleWithoutHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:103:1: entryRuleWithoutHiddens : ruleWithoutHiddens EOF ;
    public final void entryRuleWithoutHiddens() throws RecognitionException {
        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:103:24: ( ruleWithoutHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:104:2: ruleWithoutHiddens EOF
            {
             markComposite(elementTypeProvider.getWithoutHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWithoutHiddens();

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
    // $ANTLR end "entryRuleWithoutHiddens"


    // $ANTLR start "ruleWithoutHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:109:1: ruleWithoutHiddens : (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) ;
    public final void ruleWithoutHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token otherlv_2=null;
        Token lv_spaces_3_0=null;
        Token lv_valid_4_0=null;

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:109:19: ( (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:110:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:110:2: (otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:111:3: otherlv_0= 'without' ( (lv_spaces_1_0= RULE_WS ) ) otherlv_2= 'hiddens' ( (lv_spaces_3_0= RULE_WS ) )? ( (lv_valid_4_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getWithoutHiddens_WithoutKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:118:3: ( (lv_spaces_1_0= RULE_WS ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:119:4: (lv_spaces_1_0= RULE_WS )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:119:4: (lv_spaces_1_0= RULE_WS )
            // PsiInternalHiddenTerminalsTestLanguage.g:120:5: lv_spaces_1_0= RULE_WS
            {

            					markLeaf(elementTypeProvider.getWithoutHiddens_SpacesWSTerminalRuleCall_1_0ElementType());
            				
            lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_spaces_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getWithoutHiddens_HiddensKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:136:3: ( (lv_spaces_3_0= RULE_WS ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_WS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:137:4: (lv_spaces_3_0= RULE_WS )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:137:4: (lv_spaces_3_0= RULE_WS )
                    // PsiInternalHiddenTerminalsTestLanguage.g:138:5: lv_spaces_3_0= RULE_WS
                    {

                    					markLeaf(elementTypeProvider.getWithoutHiddens_SpacesWSTerminalRuleCall_3_0ElementType());
                    				
                    lv_spaces_3_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_6); 

                    					doneLeaf(lv_spaces_3_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalHiddenTerminalsTestLanguage.g:147:3: ( (lv_valid_4_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:148:4: (lv_valid_4_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:148:4: (lv_valid_4_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:149:5: lv_valid_4_0= ';'
            {

            					markLeaf(elementTypeProvider.getWithoutHiddens_ValidSemicolonKeyword_4_0ElementType());
            				
            lv_valid_4_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_4_0);
            				

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
    // $ANTLR end "ruleWithoutHiddens"


    // $ANTLR start "entryRuleWithHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:162:1: entryRuleWithHiddens : ruleWithHiddens EOF ;
    public final void entryRuleWithHiddens() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:164:2: ( ruleWithHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:165:2: ruleWithHiddens EOF
            {
             markComposite(elementTypeProvider.getWithHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWithHiddens();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleWithHiddens"


    // $ANTLR start "ruleWithHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:173:1: ruleWithHiddens : (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) ;
    public final void ruleWithHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_valid_2_0=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:175:2: ( (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:176:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:176:2: (otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:177:3: otherlv_0= 'with' otherlv_1= 'hiddens' ( (lv_valid_2_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getWithHiddens_WithKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getWithHiddens_HiddensKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:191:3: ( (lv_valid_2_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:192:4: (lv_valid_2_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:192:4: (lv_valid_2_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:193:5: lv_valid_2_0= ';'
            {

            					markLeaf(elementTypeProvider.getWithHiddens_ValidSemicolonKeyword_2_0ElementType());
            				
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_2_0);
            				

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

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleWithHiddens"


    // $ANTLR start "entryRuleOverridingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:209:1: entryRuleOverridingHiddens : ruleOverridingHiddens EOF ;
    public final void entryRuleOverridingHiddens() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:211:2: ( ruleOverridingHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:212:2: ruleOverridingHiddens EOF
            {
             markComposite(elementTypeProvider.getOverridingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOverridingHiddens();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleOverridingHiddens"


    // $ANTLR start "ruleOverridingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:220:1: ruleOverridingHiddens : (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) ;
    public final void ruleOverridingHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_valid_5_0=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:222:2: ( (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:223:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:223:2: (otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:224:3: otherlv_0= 'overriding' otherlv_1= 'hiddens' otherlv_2= '(' ( (lv_called_3_0= ruleOverridingHiddensCall ) ) otherlv_4= ')' ( (lv_valid_5_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getOverridingHiddens_OverridingKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getOverridingHiddens_HiddensKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getOverridingHiddens_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_8); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:245:3: ( (lv_called_3_0= ruleOverridingHiddensCall ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:246:4: (lv_called_3_0= ruleOverridingHiddensCall )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:246:4: (lv_called_3_0= ruleOverridingHiddensCall )
            // PsiInternalHiddenTerminalsTestLanguage.g:247:5: lv_called_3_0= ruleOverridingHiddensCall
            {

            					markComposite(elementTypeProvider.getOverridingHiddens_CalledOverridingHiddensCallParserRuleCall_3_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_9);
            ruleOverridingHiddensCall();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getOverridingHiddens_RightParenthesisKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:263:3: ( (lv_valid_5_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:264:4: (lv_valid_5_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:264:4: (lv_valid_5_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:265:5: lv_valid_5_0= ';'
            {

            					markLeaf(elementTypeProvider.getOverridingHiddens_ValidSemicolonKeyword_5_0ElementType());
            				
            lv_valid_5_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_5_0);
            				

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

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleOverridingHiddens"


    // $ANTLR start "entryRuleOverridingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:281:1: entryRuleOverridingHiddensCall : ruleOverridingHiddensCall EOF ;
    public final void entryRuleOverridingHiddensCall() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:283:2: ( ruleOverridingHiddensCall EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:284:2: ruleOverridingHiddensCall EOF
            {
             markComposite(elementTypeProvider.getOverridingHiddensCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleOverridingHiddensCall();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleOverridingHiddensCall"


    // $ANTLR start "ruleOverridingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:292:1: ruleOverridingHiddensCall : (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) ;
    public final void ruleOverridingHiddensCall() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_spaces_1_0=null;
        Token lv_valid_2_0=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:294:2: ( (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:295:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:295:2: (otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:296:3: otherlv_0= 'call' ( (lv_spaces_1_0= RULE_WS ) )? ( (lv_valid_2_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getOverridingHiddensCall_CallKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:303:3: ( (lv_spaces_1_0= RULE_WS ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:304:4: (lv_spaces_1_0= RULE_WS )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:304:4: (lv_spaces_1_0= RULE_WS )
                    // PsiInternalHiddenTerminalsTestLanguage.g:305:5: lv_spaces_1_0= RULE_WS
                    {

                    					markLeaf(elementTypeProvider.getOverridingHiddensCall_SpacesWSTerminalRuleCall_1_0ElementType());
                    				
                    lv_spaces_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_6); 

                    					doneLeaf(lv_spaces_1_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalHiddenTerminalsTestLanguage.g:314:3: ( (lv_valid_2_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:315:4: (lv_valid_2_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:315:4: (lv_valid_2_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:316:5: lv_valid_2_0= ';'
            {

            					markLeaf(elementTypeProvider.getOverridingHiddensCall_ValidSemicolonKeyword_2_0ElementType());
            				
            lv_valid_2_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_2_0);
            				

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

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleOverridingHiddensCall"


    // $ANTLR start "entryRuleInheritingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:332:1: entryRuleInheritingHiddens : ruleInheritingHiddens EOF ;
    public final void entryRuleInheritingHiddens() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:334:2: ( ruleInheritingHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:335:2: ruleInheritingHiddens EOF
            {
             markComposite(elementTypeProvider.getInheritingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInheritingHiddens();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleInheritingHiddens"


    // $ANTLR start "ruleInheritingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:343:1: ruleInheritingHiddens : (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) ;
    public final void ruleInheritingHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_valid_6_0=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:345:2: ( (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:346:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:346:2: (otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:347:3: otherlv_0= 'inheriting' otherlv_1= 'hiddens' otherlv_2= '(' ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) ) otherlv_5= ')' ( (lv_valid_6_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getInheritingHiddens_InheritingKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getInheritingHiddens_HiddensKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,9,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getInheritingHiddens_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:368:3: ( ( (lv_called_3_0= ruleInheritingHiddensCall ) ) | ( (lv_hidingCalled_4_0= ruleHidingHiddens ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==19) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:369:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:369:4: ( (lv_called_3_0= ruleInheritingHiddensCall ) )
                    // PsiInternalHiddenTerminalsTestLanguage.g:370:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:370:5: (lv_called_3_0= ruleInheritingHiddensCall )
                    // PsiInternalHiddenTerminalsTestLanguage.g:371:6: lv_called_3_0= ruleInheritingHiddensCall
                    {

                    						markComposite(elementTypeProvider.getInheritingHiddens_CalledInheritingHiddensCallParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    ruleInheritingHiddensCall();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalHiddenTerminalsTestLanguage.g:381:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:381:4: ( (lv_hidingCalled_4_0= ruleHidingHiddens ) )
                    // PsiInternalHiddenTerminalsTestLanguage.g:382:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    {
                    // PsiInternalHiddenTerminalsTestLanguage.g:382:5: (lv_hidingCalled_4_0= ruleHidingHiddens )
                    // PsiInternalHiddenTerminalsTestLanguage.g:383:6: lv_hidingCalled_4_0= ruleHidingHiddens
                    {

                    						markComposite(elementTypeProvider.getInheritingHiddens_HidingCalledHidingHiddensParserRuleCall_3_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_9);
                    ruleHidingHiddens();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getInheritingHiddens_RightParenthesisKeyword_4ElementType());
            		
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_5);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:400:3: ( (lv_valid_6_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:401:4: (lv_valid_6_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:401:4: (lv_valid_6_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:402:5: lv_valid_6_0= ';'
            {

            					markLeaf(elementTypeProvider.getInheritingHiddens_ValidSemicolonKeyword_5_0ElementType());
            				
            lv_valid_6_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_6_0);
            				

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

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleInheritingHiddens"


    // $ANTLR start "entryRuleDatatypeHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:418:1: entryRuleDatatypeHiddens : ruleDatatypeHiddens EOF ;
    public final void entryRuleDatatypeHiddens() throws RecognitionException {
        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:418:25: ( ruleDatatypeHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:419:2: ruleDatatypeHiddens EOF
            {
             markComposite(elementTypeProvider.getDatatypeHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatypeHiddens();

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
    // $ANTLR end "entryRuleDatatypeHiddens"


    // $ANTLR start "ruleDatatypeHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:424:1: ruleDatatypeHiddens : (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) ;
    public final void ruleDatatypeHiddens() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:424:20: ( (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:425:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:425:2: (otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:426:3: otherlv_0= 'datatype' ( (lv_valid_1_0= ruleDatatypeRule ) )
            {

            			markLeaf(elementTypeProvider.getDatatypeHiddens_DatatypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:433:3: ( (lv_valid_1_0= ruleDatatypeRule ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:434:4: (lv_valid_1_0= ruleDatatypeRule )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:434:4: (lv_valid_1_0= ruleDatatypeRule )
            // PsiInternalHiddenTerminalsTestLanguage.g:435:5: lv_valid_1_0= ruleDatatypeRule
            {

            					markComposite(elementTypeProvider.getDatatypeHiddens_ValidDatatypeRuleParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleDatatypeRule();

            state._fsp--;


            					doneComposite();
            				

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
    // $ANTLR end "ruleDatatypeHiddens"


    // $ANTLR start "entryRuleDatatypeRule"
    // PsiInternalHiddenTerminalsTestLanguage.g:448:1: entryRuleDatatypeRule : ruleDatatypeRule EOF ;
    public final void entryRuleDatatypeRule() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:450:2: ( ruleDatatypeRule EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:451:2: ruleDatatypeRule EOF
            {
             markComposite(elementTypeProvider.getDatatypeRuleElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatypeRule();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleDatatypeRule"


    // $ANTLR start "ruleDatatypeRule"
    // PsiInternalHiddenTerminalsTestLanguage.g:459:1: ruleDatatypeRule : (kw= 'rule' kw= ';' ) ;
    public final void ruleDatatypeRule() throws RecognitionException {
        Token kw=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:461:2: ( (kw= 'rule' kw= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:462:2: (kw= 'rule' kw= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:462:2: (kw= 'rule' kw= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:463:3: kw= 'rule' kw= ';'
            {

            			markLeaf(elementTypeProvider.getDatatypeRule_RuleKeyword_0ElementType());
            		
            kw=(Token)match(input,18,FollowSets000.FOLLOW_6); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getDatatypeRule_SemicolonKeyword_1ElementType());
            		
            kw=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            			doneLeaf(kw);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleDatatypeRule"


    // $ANTLR start "entryRuleHidingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:484:1: entryRuleHidingHiddens : ruleHidingHiddens EOF ;
    public final void entryRuleHidingHiddens() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:486:2: ( ruleHidingHiddens EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:487:2: ruleHidingHiddens EOF
            {
             markComposite(elementTypeProvider.getHidingHiddensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleHidingHiddens();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleHidingHiddens"


    // $ANTLR start "ruleHidingHiddens"
    // PsiInternalHiddenTerminalsTestLanguage.g:495:1: ruleHidingHiddens : (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) ;
    public final void ruleHidingHiddens() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_space_1_0=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:497:2: ( (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:498:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:498:2: (otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:499:3: otherlv_0= 'hiding' ( (lv_space_1_0= RULE_WS ) ) ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            {

            			markLeaf(elementTypeProvider.getHidingHiddens_HidingKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:506:3: ( (lv_space_1_0= RULE_WS ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:507:4: (lv_space_1_0= RULE_WS )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:507:4: (lv_space_1_0= RULE_WS )
            // PsiInternalHiddenTerminalsTestLanguage.g:508:5: lv_space_1_0= RULE_WS
            {

            					markLeaf(elementTypeProvider.getHidingHiddens_SpaceWSTerminalRuleCall_1_0ElementType());
            				
            lv_space_1_0=(Token)match(input,RULE_WS,FollowSets000.FOLLOW_8); 

            					doneLeaf(lv_space_1_0);
            				

            }


            }

            // PsiInternalHiddenTerminalsTestLanguage.g:517:3: ( (lv_called_2_0= ruleInheritingHiddensCall ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:518:4: (lv_called_2_0= ruleInheritingHiddensCall )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:518:4: (lv_called_2_0= ruleInheritingHiddensCall )
            // PsiInternalHiddenTerminalsTestLanguage.g:519:5: lv_called_2_0= ruleInheritingHiddensCall
            {

            					markComposite(elementTypeProvider.getHidingHiddens_CalledInheritingHiddensCallParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            ruleInheritingHiddensCall();

            state._fsp--;


            					doneComposite();
            				

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

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleHidingHiddens"


    // $ANTLR start "entryRuleInheritingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:535:1: entryRuleInheritingHiddensCall : ruleInheritingHiddensCall EOF ;
    public final void entryRuleInheritingHiddensCall() throws RecognitionException {
        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:535:31: ( ruleInheritingHiddensCall EOF )
            // PsiInternalHiddenTerminalsTestLanguage.g:536:2: ruleInheritingHiddensCall EOF
            {
             markComposite(elementTypeProvider.getInheritingHiddensCallElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInheritingHiddensCall();

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
    // $ANTLR end "entryRuleInheritingHiddensCall"


    // $ANTLR start "ruleInheritingHiddensCall"
    // PsiInternalHiddenTerminalsTestLanguage.g:541:1: ruleInheritingHiddensCall : (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) ;
    public final void ruleInheritingHiddensCall() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_valid_1_0=null;

        try {
            // PsiInternalHiddenTerminalsTestLanguage.g:541:26: ( (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:542:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:542:2: (otherlv_0= 'call' ( (lv_valid_1_0= ';' ) ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:543:3: otherlv_0= 'call' ( (lv_valid_1_0= ';' ) )
            {

            			markLeaf(elementTypeProvider.getInheritingHiddensCall_CallKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalHiddenTerminalsTestLanguage.g:550:3: ( (lv_valid_1_0= ';' ) )
            // PsiInternalHiddenTerminalsTestLanguage.g:551:4: (lv_valid_1_0= ';' )
            {
            // PsiInternalHiddenTerminalsTestLanguage.g:551:4: (lv_valid_1_0= ';' )
            // PsiInternalHiddenTerminalsTestLanguage.g:552:5: lv_valid_1_0= ';'
            {

            					markLeaf(elementTypeProvider.getInheritingHiddensCall_ValidSemicolonKeyword_1_0ElementType());
            				
            lv_valid_1_0=(Token)match(input,10,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_valid_1_0);
            				

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
    // $ANTLR end "ruleInheritingHiddensCall"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000410L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000400L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000088000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    }


}