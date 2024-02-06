package org.eclipse.xtext.ui.tests.editor.bracketmatching.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.bracketmatching.services.BmTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalBmTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'('", "')'", "'begin'", "'end'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBmTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBmTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBmTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBmTestLanguage.g"; }


    	private BmTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(BmTestLanguageGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleFile"
    // InternalBmTestLanguage.g:58:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // InternalBmTestLanguage.g:59:1: ( ruleFile EOF )
            // InternalBmTestLanguage.g:60:1: ruleFile EOF
            {
             before(grammarAccess.getFileRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFile();

            state._fsp--;

             after(grammarAccess.getFileRule()); 
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
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // InternalBmTestLanguage.g:67:1: ruleFile : ( ( rule__File__ExpressionAssignment )* ) ;
    public final void ruleFile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:71:2: ( ( ( rule__File__ExpressionAssignment )* ) )
            // InternalBmTestLanguage.g:72:2: ( ( rule__File__ExpressionAssignment )* )
            {
            // InternalBmTestLanguage.g:72:2: ( ( rule__File__ExpressionAssignment )* )
            // InternalBmTestLanguage.g:73:3: ( rule__File__ExpressionAssignment )*
            {
             before(grammarAccess.getFileAccess().getExpressionAssignment()); 
            // InternalBmTestLanguage.g:74:3: ( rule__File__ExpressionAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||LA1_0==11||LA1_0==13||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBmTestLanguage.g:74:4: rule__File__ExpressionAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__File__ExpressionAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getFileAccess().getExpressionAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleExpression"
    // InternalBmTestLanguage.g:83:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalBmTestLanguage.g:84:1: ( ruleExpression EOF )
            // InternalBmTestLanguage.g:85:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalBmTestLanguage.g:92:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:96:2: ( ( ( rule__Expression__Alternatives ) ) )
            // InternalBmTestLanguage.g:97:2: ( ( rule__Expression__Alternatives ) )
            {
            // InternalBmTestLanguage.g:97:2: ( ( rule__Expression__Alternatives ) )
            // InternalBmTestLanguage.g:98:3: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // InternalBmTestLanguage.g:99:3: ( rule__Expression__Alternatives )
            // InternalBmTestLanguage.g:99:4: rule__Expression__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleSExpression"
    // InternalBmTestLanguage.g:108:1: entryRuleSExpression : ruleSExpression EOF ;
    public final void entryRuleSExpression() throws RecognitionException {
        try {
            // InternalBmTestLanguage.g:109:1: ( ruleSExpression EOF )
            // InternalBmTestLanguage.g:110:1: ruleSExpression EOF
            {
             before(grammarAccess.getSExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSExpression();

            state._fsp--;

             after(grammarAccess.getSExpressionRule()); 
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
    // $ANTLR end "entryRuleSExpression"


    // $ANTLR start "ruleSExpression"
    // InternalBmTestLanguage.g:117:1: ruleSExpression : ( ( rule__SExpression__Group__0 ) ) ;
    public final void ruleSExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:121:2: ( ( ( rule__SExpression__Group__0 ) ) )
            // InternalBmTestLanguage.g:122:2: ( ( rule__SExpression__Group__0 ) )
            {
            // InternalBmTestLanguage.g:122:2: ( ( rule__SExpression__Group__0 ) )
            // InternalBmTestLanguage.g:123:3: ( rule__SExpression__Group__0 )
            {
             before(grammarAccess.getSExpressionAccess().getGroup()); 
            // InternalBmTestLanguage.g:124:3: ( rule__SExpression__Group__0 )
            // InternalBmTestLanguage.g:124:4: rule__SExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSExpression"


    // $ANTLR start "entryRuleAtom"
    // InternalBmTestLanguage.g:133:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // InternalBmTestLanguage.g:134:1: ( ruleAtom EOF )
            // InternalBmTestLanguage.g:135:1: ruleAtom EOF
            {
             before(grammarAccess.getAtomRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAtom();

            state._fsp--;

             after(grammarAccess.getAtomRule()); 
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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // InternalBmTestLanguage.g:142:1: ruleAtom : ( ( rule__Atom__ValueAssignment ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:146:2: ( ( ( rule__Atom__ValueAssignment ) ) )
            // InternalBmTestLanguage.g:147:2: ( ( rule__Atom__ValueAssignment ) )
            {
            // InternalBmTestLanguage.g:147:2: ( ( rule__Atom__ValueAssignment ) )
            // InternalBmTestLanguage.g:148:3: ( rule__Atom__ValueAssignment )
            {
             before(grammarAccess.getAtomAccess().getValueAssignment()); 
            // InternalBmTestLanguage.g:149:3: ( rule__Atom__ValueAssignment )
            // InternalBmTestLanguage.g:149:4: rule__Atom__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Atom__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getAtomAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleVALUE"
    // InternalBmTestLanguage.g:158:1: entryRuleVALUE : ruleVALUE EOF ;
    public final void entryRuleVALUE() throws RecognitionException {
        try {
            // InternalBmTestLanguage.g:159:1: ( ruleVALUE EOF )
            // InternalBmTestLanguage.g:160:1: ruleVALUE EOF
            {
             before(grammarAccess.getVALUERule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleVALUE();

            state._fsp--;

             after(grammarAccess.getVALUERule()); 
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
    // $ANTLR end "entryRuleVALUE"


    // $ANTLR start "ruleVALUE"
    // InternalBmTestLanguage.g:167:1: ruleVALUE : ( ( rule__VALUE__Alternatives ) ) ;
    public final void ruleVALUE() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:171:2: ( ( ( rule__VALUE__Alternatives ) ) )
            // InternalBmTestLanguage.g:172:2: ( ( rule__VALUE__Alternatives ) )
            {
            // InternalBmTestLanguage.g:172:2: ( ( rule__VALUE__Alternatives ) )
            // InternalBmTestLanguage.g:173:3: ( rule__VALUE__Alternatives )
            {
             before(grammarAccess.getVALUEAccess().getAlternatives()); 
            // InternalBmTestLanguage.g:174:3: ( rule__VALUE__Alternatives )
            // InternalBmTestLanguage.g:174:4: rule__VALUE__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__VALUE__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVALUEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVALUE"


    // $ANTLR start "rule__Expression__Alternatives"
    // InternalBmTestLanguage.g:182:1: rule__Expression__Alternatives : ( ( ruleSExpression ) | ( ruleAtom ) | ( ( rule__Expression__Group_2__0 ) ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:186:1: ( ( ruleSExpression ) | ( ruleAtom ) | ( ( rule__Expression__Group_2__0 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
            case 15:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBmTestLanguage.g:187:2: ( ruleSExpression )
                    {
                    // InternalBmTestLanguage.g:187:2: ( ruleSExpression )
                    // InternalBmTestLanguage.g:188:3: ruleSExpression
                    {
                     before(grammarAccess.getExpressionAccess().getSExpressionParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleSExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getSExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBmTestLanguage.g:193:2: ( ruleAtom )
                    {
                    // InternalBmTestLanguage.g:193:2: ( ruleAtom )
                    // InternalBmTestLanguage.g:194:3: ruleAtom
                    {
                     before(grammarAccess.getExpressionAccess().getAtomParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAtom();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getAtomParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBmTestLanguage.g:199:2: ( ( rule__Expression__Group_2__0 ) )
                    {
                    // InternalBmTestLanguage.g:199:2: ( ( rule__Expression__Group_2__0 ) )
                    // InternalBmTestLanguage.g:200:3: ( rule__Expression__Group_2__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_2()); 
                    // InternalBmTestLanguage.g:201:3: ( rule__Expression__Group_2__0 )
                    // InternalBmTestLanguage.g:201:4: rule__Expression__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Expression__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExpressionAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Alternatives"


    // $ANTLR start "rule__SExpression__Alternatives_1"
    // InternalBmTestLanguage.g:209:1: rule__SExpression__Alternatives_1 : ( ( ( rule__SExpression__Group_1_0__0 ) ) | ( ( rule__SExpression__Group_1_1__0 ) ) );
    public final void rule__SExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:213:1: ( ( ( rule__SExpression__Group_1_0__0 ) ) | ( ( rule__SExpression__Group_1_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBmTestLanguage.g:214:2: ( ( rule__SExpression__Group_1_0__0 ) )
                    {
                    // InternalBmTestLanguage.g:214:2: ( ( rule__SExpression__Group_1_0__0 ) )
                    // InternalBmTestLanguage.g:215:3: ( rule__SExpression__Group_1_0__0 )
                    {
                     before(grammarAccess.getSExpressionAccess().getGroup_1_0()); 
                    // InternalBmTestLanguage.g:216:3: ( rule__SExpression__Group_1_0__0 )
                    // InternalBmTestLanguage.g:216:4: rule__SExpression__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__SExpression__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSExpressionAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBmTestLanguage.g:220:2: ( ( rule__SExpression__Group_1_1__0 ) )
                    {
                    // InternalBmTestLanguage.g:220:2: ( ( rule__SExpression__Group_1_1__0 ) )
                    // InternalBmTestLanguage.g:221:3: ( rule__SExpression__Group_1_1__0 )
                    {
                     before(grammarAccess.getSExpressionAccess().getGroup_1_1()); 
                    // InternalBmTestLanguage.g:222:3: ( rule__SExpression__Group_1_1__0 )
                    // InternalBmTestLanguage.g:222:4: rule__SExpression__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__SExpression__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSExpressionAccess().getGroup_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Alternatives_1"


    // $ANTLR start "rule__VALUE__Alternatives"
    // InternalBmTestLanguage.g:230:1: rule__VALUE__Alternatives : ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_STRING ) );
    public final void rule__VALUE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:234:1: ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_STRING ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt4=1;
                }
                break;
            case RULE_INT:
                {
                alt4=2;
                }
                break;
            case RULE_STRING:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalBmTestLanguage.g:235:2: ( RULE_ID )
                    {
                    // InternalBmTestLanguage.g:235:2: ( RULE_ID )
                    // InternalBmTestLanguage.g:236:3: RULE_ID
                    {
                     before(grammarAccess.getVALUEAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVALUEAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBmTestLanguage.g:241:2: ( RULE_INT )
                    {
                    // InternalBmTestLanguage.g:241:2: ( RULE_INT )
                    // InternalBmTestLanguage.g:242:3: RULE_INT
                    {
                     before(grammarAccess.getVALUEAccess().getINTTerminalRuleCall_1()); 
                    match(input,RULE_INT,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVALUEAccess().getINTTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBmTestLanguage.g:247:2: ( RULE_STRING )
                    {
                    // InternalBmTestLanguage.g:247:2: ( RULE_STRING )
                    // InternalBmTestLanguage.g:248:3: RULE_STRING
                    {
                     before(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VALUE__Alternatives"


    // $ANTLR start "rule__Expression__Group_2__0"
    // InternalBmTestLanguage.g:257:1: rule__Expression__Group_2__0 : rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1 ;
    public final void rule__Expression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:261:1: ( rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1 )
            // InternalBmTestLanguage.g:262:2: rule__Expression__Group_2__0__Impl rule__Expression__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Expression__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Expression__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__0"


    // $ANTLR start "rule__Expression__Group_2__0__Impl"
    // InternalBmTestLanguage.g:269:1: rule__Expression__Group_2__0__Impl : ( '[' ) ;
    public final void rule__Expression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:273:1: ( ( '[' ) )
            // InternalBmTestLanguage.g:274:1: ( '[' )
            {
            // InternalBmTestLanguage.g:274:1: ( '[' )
            // InternalBmTestLanguage.g:275:2: '['
            {
             before(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__0__Impl"


    // $ANTLR start "rule__Expression__Group_2__1"
    // InternalBmTestLanguage.g:284:1: rule__Expression__Group_2__1 : rule__Expression__Group_2__1__Impl rule__Expression__Group_2__2 ;
    public final void rule__Expression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:288:1: ( rule__Expression__Group_2__1__Impl rule__Expression__Group_2__2 )
            // InternalBmTestLanguage.g:289:2: rule__Expression__Group_2__1__Impl rule__Expression__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Expression__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Expression__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__1"


    // $ANTLR start "rule__Expression__Group_2__1__Impl"
    // InternalBmTestLanguage.g:296:1: rule__Expression__Group_2__1__Impl : ( ruleExpression ) ;
    public final void rule__Expression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:300:1: ( ( ruleExpression ) )
            // InternalBmTestLanguage.g:301:1: ( ruleExpression )
            {
            // InternalBmTestLanguage.g:301:1: ( ruleExpression )
            // InternalBmTestLanguage.g:302:2: ruleExpression
            {
             before(grammarAccess.getExpressionAccess().getExpressionParserRuleCall_2_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getExpressionParserRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__1__Impl"


    // $ANTLR start "rule__Expression__Group_2__2"
    // InternalBmTestLanguage.g:311:1: rule__Expression__Group_2__2 : rule__Expression__Group_2__2__Impl ;
    public final void rule__Expression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:315:1: ( rule__Expression__Group_2__2__Impl )
            // InternalBmTestLanguage.g:316:2: rule__Expression__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Expression__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__2"


    // $ANTLR start "rule__Expression__Group_2__2__Impl"
    // InternalBmTestLanguage.g:322:1: rule__Expression__Group_2__2__Impl : ( ']' ) ;
    public final void rule__Expression__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:326:1: ( ( ']' ) )
            // InternalBmTestLanguage.g:327:1: ( ']' )
            {
            // InternalBmTestLanguage.g:327:1: ( ']' )
            // InternalBmTestLanguage.g:328:2: ']'
            {
             before(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Group_2__2__Impl"


    // $ANTLR start "rule__SExpression__Group__0"
    // InternalBmTestLanguage.g:338:1: rule__SExpression__Group__0 : rule__SExpression__Group__0__Impl rule__SExpression__Group__1 ;
    public final void rule__SExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:342:1: ( rule__SExpression__Group__0__Impl rule__SExpression__Group__1 )
            // InternalBmTestLanguage.g:343:2: rule__SExpression__Group__0__Impl rule__SExpression__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__SExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group__0"


    // $ANTLR start "rule__SExpression__Group__0__Impl"
    // InternalBmTestLanguage.g:350:1: rule__SExpression__Group__0__Impl : ( () ) ;
    public final void rule__SExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:354:1: ( ( () ) )
            // InternalBmTestLanguage.g:355:1: ( () )
            {
            // InternalBmTestLanguage.g:355:1: ( () )
            // InternalBmTestLanguage.g:356:2: ()
            {
             before(grammarAccess.getSExpressionAccess().getSExpressionAction_0()); 
            // InternalBmTestLanguage.g:357:2: ()
            // InternalBmTestLanguage.g:357:3: 
            {
            }

             after(grammarAccess.getSExpressionAccess().getSExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group__0__Impl"


    // $ANTLR start "rule__SExpression__Group__1"
    // InternalBmTestLanguage.g:365:1: rule__SExpression__Group__1 : rule__SExpression__Group__1__Impl ;
    public final void rule__SExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:369:1: ( rule__SExpression__Group__1__Impl )
            // InternalBmTestLanguage.g:370:2: rule__SExpression__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group__1"


    // $ANTLR start "rule__SExpression__Group__1__Impl"
    // InternalBmTestLanguage.g:376:1: rule__SExpression__Group__1__Impl : ( ( rule__SExpression__Alternatives_1 ) ) ;
    public final void rule__SExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:380:1: ( ( ( rule__SExpression__Alternatives_1 ) ) )
            // InternalBmTestLanguage.g:381:1: ( ( rule__SExpression__Alternatives_1 ) )
            {
            // InternalBmTestLanguage.g:381:1: ( ( rule__SExpression__Alternatives_1 ) )
            // InternalBmTestLanguage.g:382:2: ( rule__SExpression__Alternatives_1 )
            {
             before(grammarAccess.getSExpressionAccess().getAlternatives_1()); 
            // InternalBmTestLanguage.g:383:2: ( rule__SExpression__Alternatives_1 )
            // InternalBmTestLanguage.g:383:3: rule__SExpression__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getSExpressionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group__1__Impl"


    // $ANTLR start "rule__SExpression__Group_1_0__0"
    // InternalBmTestLanguage.g:392:1: rule__SExpression__Group_1_0__0 : rule__SExpression__Group_1_0__0__Impl rule__SExpression__Group_1_0__1 ;
    public final void rule__SExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:396:1: ( rule__SExpression__Group_1_0__0__Impl rule__SExpression__Group_1_0__1 )
            // InternalBmTestLanguage.g:397:2: rule__SExpression__Group_1_0__0__Impl rule__SExpression__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__SExpression__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_0__0"


    // $ANTLR start "rule__SExpression__Group_1_0__0__Impl"
    // InternalBmTestLanguage.g:404:1: rule__SExpression__Group_1_0__0__Impl : ( '(' ) ;
    public final void rule__SExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:408:1: ( ( '(' ) )
            // InternalBmTestLanguage.g:409:1: ( '(' )
            {
            // InternalBmTestLanguage.g:409:1: ( '(' )
            // InternalBmTestLanguage.g:410:2: '('
            {
             before(grammarAccess.getSExpressionAccess().getLeftParenthesisKeyword_1_0_0()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSExpressionAccess().getLeftParenthesisKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__SExpression__Group_1_0__1"
    // InternalBmTestLanguage.g:419:1: rule__SExpression__Group_1_0__1 : rule__SExpression__Group_1_0__1__Impl rule__SExpression__Group_1_0__2 ;
    public final void rule__SExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:423:1: ( rule__SExpression__Group_1_0__1__Impl rule__SExpression__Group_1_0__2 )
            // InternalBmTestLanguage.g:424:2: rule__SExpression__Group_1_0__1__Impl rule__SExpression__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__SExpression__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_0__1"


    // $ANTLR start "rule__SExpression__Group_1_0__1__Impl"
    // InternalBmTestLanguage.g:431:1: rule__SExpression__Group_1_0__1__Impl : ( ( rule__SExpression__ElementAssignment_1_0_1 )* ) ;
    public final void rule__SExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:435:1: ( ( ( rule__SExpression__ElementAssignment_1_0_1 )* ) )
            // InternalBmTestLanguage.g:436:1: ( ( rule__SExpression__ElementAssignment_1_0_1 )* )
            {
            // InternalBmTestLanguage.g:436:1: ( ( rule__SExpression__ElementAssignment_1_0_1 )* )
            // InternalBmTestLanguage.g:437:2: ( rule__SExpression__ElementAssignment_1_0_1 )*
            {
             before(grammarAccess.getSExpressionAccess().getElementAssignment_1_0_1()); 
            // InternalBmTestLanguage.g:438:2: ( rule__SExpression__ElementAssignment_1_0_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_STRING)||LA5_0==11||LA5_0==13||LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalBmTestLanguage.g:438:3: rule__SExpression__ElementAssignment_1_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__SExpression__ElementAssignment_1_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSExpressionAccess().getElementAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_0__1__Impl"


    // $ANTLR start "rule__SExpression__Group_1_0__2"
    // InternalBmTestLanguage.g:446:1: rule__SExpression__Group_1_0__2 : rule__SExpression__Group_1_0__2__Impl ;
    public final void rule__SExpression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:450:1: ( rule__SExpression__Group_1_0__2__Impl )
            // InternalBmTestLanguage.g:451:2: rule__SExpression__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_0__2"


    // $ANTLR start "rule__SExpression__Group_1_0__2__Impl"
    // InternalBmTestLanguage.g:457:1: rule__SExpression__Group_1_0__2__Impl : ( ')' ) ;
    public final void rule__SExpression__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:461:1: ( ( ')' ) )
            // InternalBmTestLanguage.g:462:1: ( ')' )
            {
            // InternalBmTestLanguage.g:462:1: ( ')' )
            // InternalBmTestLanguage.g:463:2: ')'
            {
             before(grammarAccess.getSExpressionAccess().getRightParenthesisKeyword_1_0_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSExpressionAccess().getRightParenthesisKeyword_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_0__2__Impl"


    // $ANTLR start "rule__SExpression__Group_1_1__0"
    // InternalBmTestLanguage.g:473:1: rule__SExpression__Group_1_1__0 : rule__SExpression__Group_1_1__0__Impl rule__SExpression__Group_1_1__1 ;
    public final void rule__SExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:477:1: ( rule__SExpression__Group_1_1__0__Impl rule__SExpression__Group_1_1__1 )
            // InternalBmTestLanguage.g:478:2: rule__SExpression__Group_1_1__0__Impl rule__SExpression__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SExpression__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_1__0"


    // $ANTLR start "rule__SExpression__Group_1_1__0__Impl"
    // InternalBmTestLanguage.g:485:1: rule__SExpression__Group_1_1__0__Impl : ( 'begin' ) ;
    public final void rule__SExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:489:1: ( ( 'begin' ) )
            // InternalBmTestLanguage.g:490:1: ( 'begin' )
            {
            // InternalBmTestLanguage.g:490:1: ( 'begin' )
            // InternalBmTestLanguage.g:491:2: 'begin'
            {
             before(grammarAccess.getSExpressionAccess().getBeginKeyword_1_1_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSExpressionAccess().getBeginKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_1__0__Impl"


    // $ANTLR start "rule__SExpression__Group_1_1__1"
    // InternalBmTestLanguage.g:500:1: rule__SExpression__Group_1_1__1 : rule__SExpression__Group_1_1__1__Impl rule__SExpression__Group_1_1__2 ;
    public final void rule__SExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:504:1: ( rule__SExpression__Group_1_1__1__Impl rule__SExpression__Group_1_1__2 )
            // InternalBmTestLanguage.g:505:2: rule__SExpression__Group_1_1__1__Impl rule__SExpression__Group_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__SExpression__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_1__1"


    // $ANTLR start "rule__SExpression__Group_1_1__1__Impl"
    // InternalBmTestLanguage.g:512:1: rule__SExpression__Group_1_1__1__Impl : ( ( rule__SExpression__ElementAssignment_1_1_1 )* ) ;
    public final void rule__SExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:516:1: ( ( ( rule__SExpression__ElementAssignment_1_1_1 )* ) )
            // InternalBmTestLanguage.g:517:1: ( ( rule__SExpression__ElementAssignment_1_1_1 )* )
            {
            // InternalBmTestLanguage.g:517:1: ( ( rule__SExpression__ElementAssignment_1_1_1 )* )
            // InternalBmTestLanguage.g:518:2: ( rule__SExpression__ElementAssignment_1_1_1 )*
            {
             before(grammarAccess.getSExpressionAccess().getElementAssignment_1_1_1()); 
            // InternalBmTestLanguage.g:519:2: ( rule__SExpression__ElementAssignment_1_1_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==11||LA6_0==13||LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalBmTestLanguage.g:519:3: rule__SExpression__ElementAssignment_1_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__SExpression__ElementAssignment_1_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSExpressionAccess().getElementAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_1__1__Impl"


    // $ANTLR start "rule__SExpression__Group_1_1__2"
    // InternalBmTestLanguage.g:527:1: rule__SExpression__Group_1_1__2 : rule__SExpression__Group_1_1__2__Impl ;
    public final void rule__SExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:531:1: ( rule__SExpression__Group_1_1__2__Impl )
            // InternalBmTestLanguage.g:532:2: rule__SExpression__Group_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__SExpression__Group_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_1__2"


    // $ANTLR start "rule__SExpression__Group_1_1__2__Impl"
    // InternalBmTestLanguage.g:538:1: rule__SExpression__Group_1_1__2__Impl : ( 'end' ) ;
    public final void rule__SExpression__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:542:1: ( ( 'end' ) )
            // InternalBmTestLanguage.g:543:1: ( 'end' )
            {
            // InternalBmTestLanguage.g:543:1: ( 'end' )
            // InternalBmTestLanguage.g:544:2: 'end'
            {
             before(grammarAccess.getSExpressionAccess().getEndKeyword_1_1_2()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getSExpressionAccess().getEndKeyword_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__Group_1_1__2__Impl"


    // $ANTLR start "rule__File__ExpressionAssignment"
    // InternalBmTestLanguage.g:554:1: rule__File__ExpressionAssignment : ( ruleExpression ) ;
    public final void rule__File__ExpressionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:558:1: ( ( ruleExpression ) )
            // InternalBmTestLanguage.g:559:2: ( ruleExpression )
            {
            // InternalBmTestLanguage.g:559:2: ( ruleExpression )
            // InternalBmTestLanguage.g:560:3: ruleExpression
            {
             before(grammarAccess.getFileAccess().getExpressionExpressionParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFileAccess().getExpressionExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__File__ExpressionAssignment"


    // $ANTLR start "rule__SExpression__ElementAssignment_1_0_1"
    // InternalBmTestLanguage.g:569:1: rule__SExpression__ElementAssignment_1_0_1 : ( ruleExpression ) ;
    public final void rule__SExpression__ElementAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:573:1: ( ( ruleExpression ) )
            // InternalBmTestLanguage.g:574:2: ( ruleExpression )
            {
            // InternalBmTestLanguage.g:574:2: ( ruleExpression )
            // InternalBmTestLanguage.g:575:3: ruleExpression
            {
             before(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__ElementAssignment_1_0_1"


    // $ANTLR start "rule__SExpression__ElementAssignment_1_1_1"
    // InternalBmTestLanguage.g:584:1: rule__SExpression__ElementAssignment_1_1_1 : ( ruleExpression ) ;
    public final void rule__SExpression__ElementAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:588:1: ( ( ruleExpression ) )
            // InternalBmTestLanguage.g:589:2: ( ruleExpression )
            {
            // InternalBmTestLanguage.g:589:2: ( ruleExpression )
            // InternalBmTestLanguage.g:590:3: ruleExpression
            {
             before(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SExpression__ElementAssignment_1_1_1"


    // $ANTLR start "rule__Atom__ValueAssignment"
    // InternalBmTestLanguage.g:599:1: rule__Atom__ValueAssignment : ( ruleVALUE ) ;
    public final void rule__Atom__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBmTestLanguage.g:603:1: ( ( ruleVALUE ) )
            // InternalBmTestLanguage.g:604:2: ( ruleVALUE )
            {
            // InternalBmTestLanguage.g:604:2: ( ruleVALUE )
            // InternalBmTestLanguage.g:605:3: ruleVALUE
            {
             before(grammarAccess.getAtomAccess().getValueVALUEParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleVALUE();

            state._fsp--;

             after(grammarAccess.getAtomAccess().getValueVALUEParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Atom__ValueAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000A872L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000000A870L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000000A000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000001A870L});
    }


}