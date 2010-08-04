package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug286935TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug286935TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'NORMAL'", "'cond'", "'reference'", "'textual'", "'state'", "'init'", "'final'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug286935TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g"; }


     
     	private Bug286935TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug286935TestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleState
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:61:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:62:1: ( ruleState EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:63:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleState_in_entryRuleState61);
            ruleState();
            _fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleState68); 

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
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:70:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:74:2: ( ( ( rule__State__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:75:1: ( ( rule__State__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:75:1: ( ( rule__State__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:76:1: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:77:1: ( rule__State__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:77:2: rule__State__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group__0_in_ruleState94);
            rule__State__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

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
    // $ANTLR end ruleState


    // $ANTLR start ruleStateType
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:90:1: ruleStateType : ( ( rule__StateType__Alternatives ) ) ;
    public final void ruleStateType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:94:1: ( ( ( rule__StateType__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:95:1: ( ( rule__StateType__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:95:1: ( ( rule__StateType__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:96:1: ( rule__StateType__Alternatives )
            {
             before(grammarAccess.getStateTypeAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:97:1: ( rule__StateType__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:97:2: rule__StateType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__StateType__Alternatives_in_ruleStateType131);
            rule__StateType__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getStateTypeAccess().getAlternatives()); 

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
    // $ANTLR end ruleStateType


    // $ANTLR start rule__State__Alternatives_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:108:1: rule__State__Alternatives_0 : ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) );
    public final void rule__State__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:112:1: ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 16:
                {
                switch ( input.LA(2) ) {
                case 11:
                    {
                    int LA1_4 = input.LA(3);

                    if ( (LA1_4==17) ) {
                        alt1=5;
                    }
                    else if ( (LA1_4==EOF||(LA1_4>=RULE_ID && LA1_4<=RULE_STRING)||LA1_4==15) ) {
                        alt1=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("108:1: rule__State__Alternatives_0 : ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) );", 1, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 12:
                    {
                    int LA1_5 = input.LA(3);

                    if ( (LA1_5==EOF||(LA1_5>=RULE_ID && LA1_5<=RULE_STRING)||LA1_5==15) ) {
                        alt1=4;
                    }
                    else if ( (LA1_5==17) ) {
                        alt1=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("108:1: rule__State__Alternatives_0 : ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) );", 1, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                case 13:
                    {
                    int LA1_6 = input.LA(3);

                    if ( (LA1_6==EOF||(LA1_6>=RULE_ID && LA1_6<=RULE_STRING)||LA1_6==15) ) {
                        alt1=4;
                    }
                    else if ( (LA1_6==17) ) {
                        alt1=5;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("108:1: rule__State__Alternatives_0 : ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) );", 1, 6, input);

                        throw nvae;
                    }
                    }
                    break;
                case 14:
                    {
                    int LA1_7 = input.LA(3);

                    if ( (LA1_7==17) ) {
                        alt1=5;
                    }
                    else if ( (LA1_7==EOF||(LA1_7>=RULE_ID && LA1_7<=RULE_STRING)||LA1_7==15) ) {
                        alt1=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("108:1: rule__State__Alternatives_0 : ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) );", 1, 7, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case RULE_ID:
                case RULE_STRING:
                case 15:
                    {
                    alt1=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("108:1: rule__State__Alternatives_0 : ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) );", 1, 1, input);

                    throw nvae;
                }

                }
                break;
            case 17:
                {
                alt1=2;
                }
                break;
            case 11:
            case 12:
            case 13:
            case 14:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("108:1: rule__State__Alternatives_0 : ( ( ( rule__State__IsInitialAssignment_0_0 ) ) | ( ( rule__State__IsFinalAssignment_0_1 ) ) | ( ( rule__State__StateKindAssignment_0_2 ) ) | ( ( rule__State__Group_0_3__0 ) ) | ( ( rule__State__Group_0_4__0 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:113:1: ( ( rule__State__IsInitialAssignment_0_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:113:1: ( ( rule__State__IsInitialAssignment_0_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:114:1: ( rule__State__IsInitialAssignment_0_0 )
                    {
                     before(grammarAccess.getStateAccess().getIsInitialAssignment_0_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:115:1: ( rule__State__IsInitialAssignment_0_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:115:2: rule__State__IsInitialAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__IsInitialAssignment_0_0_in_rule__State__Alternatives_0166);
                    rule__State__IsInitialAssignment_0_0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateAccess().getIsInitialAssignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:119:6: ( ( rule__State__IsFinalAssignment_0_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:119:6: ( ( rule__State__IsFinalAssignment_0_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:120:1: ( rule__State__IsFinalAssignment_0_1 )
                    {
                     before(grammarAccess.getStateAccess().getIsFinalAssignment_0_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:121:1: ( rule__State__IsFinalAssignment_0_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:121:2: rule__State__IsFinalAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__IsFinalAssignment_0_1_in_rule__State__Alternatives_0184);
                    rule__State__IsFinalAssignment_0_1();
                    _fsp--;


                    }

                     after(grammarAccess.getStateAccess().getIsFinalAssignment_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:125:6: ( ( rule__State__StateKindAssignment_0_2 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:125:6: ( ( rule__State__StateKindAssignment_0_2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:126:1: ( rule__State__StateKindAssignment_0_2 )
                    {
                     before(grammarAccess.getStateAccess().getStateKindAssignment_0_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:127:1: ( rule__State__StateKindAssignment_0_2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:127:2: rule__State__StateKindAssignment_0_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__StateKindAssignment_0_2_in_rule__State__Alternatives_0202);
                    rule__State__StateKindAssignment_0_2();
                    _fsp--;


                    }

                     after(grammarAccess.getStateAccess().getStateKindAssignment_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:131:6: ( ( rule__State__Group_0_3__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:131:6: ( ( rule__State__Group_0_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:132:1: ( rule__State__Group_0_3__0 )
                    {
                     before(grammarAccess.getStateAccess().getGroup_0_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:133:1: ( rule__State__Group_0_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:133:2: rule__State__Group_0_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_3__0_in_rule__State__Alternatives_0220);
                    rule__State__Group_0_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateAccess().getGroup_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:137:6: ( ( rule__State__Group_0_4__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:137:6: ( ( rule__State__Group_0_4__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:138:1: ( rule__State__Group_0_4__0 )
                    {
                     before(grammarAccess.getStateAccess().getGroup_0_4()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:139:1: ( rule__State__Group_0_4__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:139:2: rule__State__Group_0_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_4__0_in_rule__State__Alternatives_0238);
                    rule__State__Group_0_4__0();
                    _fsp--;


                    }

                     after(grammarAccess.getStateAccess().getGroup_0_4()); 

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
    // $ANTLR end rule__State__Alternatives_0


    // $ANTLR start rule__StateType__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:148:1: rule__StateType__Alternatives : ( ( ( 'NORMAL' ) ) | ( ( 'cond' ) ) | ( ( 'reference' ) ) | ( ( 'textual' ) ) );
    public final void rule__StateType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:152:1: ( ( ( 'NORMAL' ) ) | ( ( 'cond' ) ) | ( ( 'reference' ) ) | ( ( 'textual' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("148:1: rule__StateType__Alternatives : ( ( ( 'NORMAL' ) ) | ( ( 'cond' ) ) | ( ( 'reference' ) ) | ( ( 'textual' ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:153:1: ( ( 'NORMAL' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:153:1: ( ( 'NORMAL' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:154:1: ( 'NORMAL' )
                    {
                     before(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:155:1: ( 'NORMAL' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:155:3: 'NORMAL'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__StateType__Alternatives272); 

                    }

                     after(grammarAccess.getStateTypeAccess().getNORMALEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:160:6: ( ( 'cond' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:160:6: ( ( 'cond' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:161:1: ( 'cond' )
                    {
                     before(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:162:1: ( 'cond' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:162:3: 'cond'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__StateType__Alternatives293); 

                    }

                     after(grammarAccess.getStateTypeAccess().getPSEUDOEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:167:6: ( ( 'reference' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:167:6: ( ( 'reference' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:168:1: ( 'reference' )
                    {
                     before(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:169:1: ( 'reference' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:169:3: 'reference'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__StateType__Alternatives314); 

                    }

                     after(grammarAccess.getStateTypeAccess().getREFERENCEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:174:6: ( ( 'textual' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:174:6: ( ( 'textual' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:175:1: ( 'textual' )
                    {
                     before(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:176:1: ( 'textual' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:176:3: 'textual'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__StateType__Alternatives335); 

                    }

                     after(grammarAccess.getStateTypeAccess().getTEXTUALEnumLiteralDeclaration_3()); 

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
    // $ANTLR end rule__StateType__Alternatives


    // $ANTLR start rule__State__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:188:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:192:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:193:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__0368);
            rule__State__Group__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__State__Group__1_in_rule__State__Group__0371);
            rule__State__Group__1();
            _fsp--;


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
    // $ANTLR end rule__State__Group__0


    // $ANTLR start rule__State__Group__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:200:1: rule__State__Group__0__Impl : ( ( rule__State__Alternatives_0 )? ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:204:1: ( ( ( rule__State__Alternatives_0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:205:1: ( ( rule__State__Alternatives_0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:205:1: ( ( rule__State__Alternatives_0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:206:1: ( rule__State__Alternatives_0 )?
            {
             before(grammarAccess.getStateAccess().getAlternatives_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:207:1: ( rule__State__Alternatives_0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=11 && LA3_0<=14)||(LA3_0>=16 && LA3_0<=17)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:207:2: rule__State__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__Alternatives_0_in_rule__State__Group__0__Impl398);
                    rule__State__Alternatives_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getAlternatives_0()); 

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
    // $ANTLR end rule__State__Group__0__Impl


    // $ANTLR start rule__State__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:217:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:221:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:222:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__1429);
            rule__State__Group__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__State__Group__2_in_rule__State__Group__1432);
            rule__State__Group__2();
            _fsp--;


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
    // $ANTLR end rule__State__Group__1


    // $ANTLR start rule__State__Group__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:229:1: rule__State__Group__1__Impl : ( ( 'state' )? ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:233:1: ( ( ( 'state' )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:234:1: ( ( 'state' )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:234:1: ( ( 'state' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:235:1: ( 'state' )?
            {
             before(grammarAccess.getStateAccess().getStateKeyword_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:236:1: ( 'state' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:237:2: 'state'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__State__Group__1__Impl461); 

                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getStateKeyword_1()); 

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
    // $ANTLR end rule__State__Group__1__Impl


    // $ANTLR start rule__State__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:248:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:252:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:253:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__2494);
            rule__State__Group__2__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__State__Group__3_in_rule__State__Group__2497);
            rule__State__Group__3();
            _fsp--;


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
    // $ANTLR end rule__State__Group__2


    // $ANTLR start rule__State__Group__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:260:1: rule__State__Group__2__Impl : ( ( rule__State__StateNameAssignment_2 )? ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:264:1: ( ( ( rule__State__StateNameAssignment_2 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:265:1: ( ( rule__State__StateNameAssignment_2 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:265:1: ( ( rule__State__StateNameAssignment_2 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:266:1: ( rule__State__StateNameAssignment_2 )?
            {
             before(grammarAccess.getStateAccess().getStateNameAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:267:1: ( rule__State__StateNameAssignment_2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:267:2: rule__State__StateNameAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__StateNameAssignment_2_in_rule__State__Group__2__Impl524);
                    rule__State__StateNameAssignment_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getStateNameAssignment_2()); 

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
    // $ANTLR end rule__State__Group__2__Impl


    // $ANTLR start rule__State__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:277:1: rule__State__Group__3 : rule__State__Group__3__Impl ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:281:1: ( rule__State__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:282:2: rule__State__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__3555);
            rule__State__Group__3__Impl();
            _fsp--;


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
    // $ANTLR end rule__State__Group__3


    // $ANTLR start rule__State__Group__3__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:288:1: rule__State__Group__3__Impl : ( ( rule__State__LabelAssignment_3 )? ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:292:1: ( ( ( rule__State__LabelAssignment_3 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:293:1: ( ( rule__State__LabelAssignment_3 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:293:1: ( ( rule__State__LabelAssignment_3 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:294:1: ( rule__State__LabelAssignment_3 )?
            {
             before(grammarAccess.getStateAccess().getLabelAssignment_3()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:295:1: ( rule__State__LabelAssignment_3 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:295:2: rule__State__LabelAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__State__LabelAssignment_3_in_rule__State__Group__3__Impl582);
                    rule__State__LabelAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getLabelAssignment_3()); 

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
    // $ANTLR end rule__State__Group__3__Impl


    // $ANTLR start rule__State__Group_0_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:313:1: rule__State__Group_0_3__0 : rule__State__Group_0_3__0__Impl rule__State__Group_0_3__1 ;
    public final void rule__State__Group_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:317:1: ( rule__State__Group_0_3__0__Impl rule__State__Group_0_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:318:2: rule__State__Group_0_3__0__Impl rule__State__Group_0_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_3__0__Impl_in_rule__State__Group_0_3__0621);
            rule__State__Group_0_3__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_3__1_in_rule__State__Group_0_3__0624);
            rule__State__Group_0_3__1();
            _fsp--;


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
    // $ANTLR end rule__State__Group_0_3__0


    // $ANTLR start rule__State__Group_0_3__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:325:1: rule__State__Group_0_3__0__Impl : ( ( rule__State__IsInitialAssignment_0_3_0 ) ) ;
    public final void rule__State__Group_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:329:1: ( ( ( rule__State__IsInitialAssignment_0_3_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:330:1: ( ( rule__State__IsInitialAssignment_0_3_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:330:1: ( ( rule__State__IsInitialAssignment_0_3_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:331:1: ( rule__State__IsInitialAssignment_0_3_0 )
            {
             before(grammarAccess.getStateAccess().getIsInitialAssignment_0_3_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:332:1: ( rule__State__IsInitialAssignment_0_3_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:332:2: rule__State__IsInitialAssignment_0_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__IsInitialAssignment_0_3_0_in_rule__State__Group_0_3__0__Impl651);
            rule__State__IsInitialAssignment_0_3_0();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getIsInitialAssignment_0_3_0()); 

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
    // $ANTLR end rule__State__Group_0_3__0__Impl


    // $ANTLR start rule__State__Group_0_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:342:1: rule__State__Group_0_3__1 : rule__State__Group_0_3__1__Impl ;
    public final void rule__State__Group_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:346:1: ( rule__State__Group_0_3__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:347:2: rule__State__Group_0_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_3__1__Impl_in_rule__State__Group_0_3__1681);
            rule__State__Group_0_3__1__Impl();
            _fsp--;


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
    // $ANTLR end rule__State__Group_0_3__1


    // $ANTLR start rule__State__Group_0_3__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:353:1: rule__State__Group_0_3__1__Impl : ( ( rule__State__StateKindAssignment_0_3_1 ) ) ;
    public final void rule__State__Group_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:357:1: ( ( ( rule__State__StateKindAssignment_0_3_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:358:1: ( ( rule__State__StateKindAssignment_0_3_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:358:1: ( ( rule__State__StateKindAssignment_0_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:359:1: ( rule__State__StateKindAssignment_0_3_1 )
            {
             before(grammarAccess.getStateAccess().getStateKindAssignment_0_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:360:1: ( rule__State__StateKindAssignment_0_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:360:2: rule__State__StateKindAssignment_0_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__StateKindAssignment_0_3_1_in_rule__State__Group_0_3__1__Impl708);
            rule__State__StateKindAssignment_0_3_1();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getStateKindAssignment_0_3_1()); 

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
    // $ANTLR end rule__State__Group_0_3__1__Impl


    // $ANTLR start rule__State__Group_0_4__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:374:1: rule__State__Group_0_4__0 : rule__State__Group_0_4__0__Impl rule__State__Group_0_4__1 ;
    public final void rule__State__Group_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:378:1: ( rule__State__Group_0_4__0__Impl rule__State__Group_0_4__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:379:2: rule__State__Group_0_4__0__Impl rule__State__Group_0_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_4__0__Impl_in_rule__State__Group_0_4__0742);
            rule__State__Group_0_4__0__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_4__1_in_rule__State__Group_0_4__0745);
            rule__State__Group_0_4__1();
            _fsp--;


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
    // $ANTLR end rule__State__Group_0_4__0


    // $ANTLR start rule__State__Group_0_4__0__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:386:1: rule__State__Group_0_4__0__Impl : ( ( rule__State__IsInitialAssignment_0_4_0 ) ) ;
    public final void rule__State__Group_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:390:1: ( ( ( rule__State__IsInitialAssignment_0_4_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:391:1: ( ( rule__State__IsInitialAssignment_0_4_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:391:1: ( ( rule__State__IsInitialAssignment_0_4_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:392:1: ( rule__State__IsInitialAssignment_0_4_0 )
            {
             before(grammarAccess.getStateAccess().getIsInitialAssignment_0_4_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:393:1: ( rule__State__IsInitialAssignment_0_4_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:393:2: rule__State__IsInitialAssignment_0_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__IsInitialAssignment_0_4_0_in_rule__State__Group_0_4__0__Impl772);
            rule__State__IsInitialAssignment_0_4_0();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getIsInitialAssignment_0_4_0()); 

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
    // $ANTLR end rule__State__Group_0_4__0__Impl


    // $ANTLR start rule__State__Group_0_4__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:403:1: rule__State__Group_0_4__1 : rule__State__Group_0_4__1__Impl rule__State__Group_0_4__2 ;
    public final void rule__State__Group_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:407:1: ( rule__State__Group_0_4__1__Impl rule__State__Group_0_4__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:408:2: rule__State__Group_0_4__1__Impl rule__State__Group_0_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_4__1__Impl_in_rule__State__Group_0_4__1802);
            rule__State__Group_0_4__1__Impl();
            _fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_4__2_in_rule__State__Group_0_4__1805);
            rule__State__Group_0_4__2();
            _fsp--;


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
    // $ANTLR end rule__State__Group_0_4__1


    // $ANTLR start rule__State__Group_0_4__1__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:415:1: rule__State__Group_0_4__1__Impl : ( ( rule__State__StateKindAssignment_0_4_1 ) ) ;
    public final void rule__State__Group_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:419:1: ( ( ( rule__State__StateKindAssignment_0_4_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:420:1: ( ( rule__State__StateKindAssignment_0_4_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:420:1: ( ( rule__State__StateKindAssignment_0_4_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:421:1: ( rule__State__StateKindAssignment_0_4_1 )
            {
             before(grammarAccess.getStateAccess().getStateKindAssignment_0_4_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:422:1: ( rule__State__StateKindAssignment_0_4_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:422:2: rule__State__StateKindAssignment_0_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__StateKindAssignment_0_4_1_in_rule__State__Group_0_4__1__Impl832);
            rule__State__StateKindAssignment_0_4_1();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getStateKindAssignment_0_4_1()); 

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
    // $ANTLR end rule__State__Group_0_4__1__Impl


    // $ANTLR start rule__State__Group_0_4__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:432:1: rule__State__Group_0_4__2 : rule__State__Group_0_4__2__Impl ;
    public final void rule__State__Group_0_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:436:1: ( rule__State__Group_0_4__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:437:2: rule__State__Group_0_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__Group_0_4__2__Impl_in_rule__State__Group_0_4__2862);
            rule__State__Group_0_4__2__Impl();
            _fsp--;


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
    // $ANTLR end rule__State__Group_0_4__2


    // $ANTLR start rule__State__Group_0_4__2__Impl
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:443:1: rule__State__Group_0_4__2__Impl : ( ( rule__State__IsFinalAssignment_0_4_2 ) ) ;
    public final void rule__State__Group_0_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:447:1: ( ( ( rule__State__IsFinalAssignment_0_4_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:448:1: ( ( rule__State__IsFinalAssignment_0_4_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:448:1: ( ( rule__State__IsFinalAssignment_0_4_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:449:1: ( rule__State__IsFinalAssignment_0_4_2 )
            {
             before(grammarAccess.getStateAccess().getIsFinalAssignment_0_4_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:450:1: ( rule__State__IsFinalAssignment_0_4_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:450:2: rule__State__IsFinalAssignment_0_4_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__State__IsFinalAssignment_0_4_2_in_rule__State__Group_0_4__2__Impl889);
            rule__State__IsFinalAssignment_0_4_2();
            _fsp--;


            }

             after(grammarAccess.getStateAccess().getIsFinalAssignment_0_4_2()); 

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
    // $ANTLR end rule__State__Group_0_4__2__Impl


    // $ANTLR start rule__State__IsInitialAssignment_0_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:467:1: rule__State__IsInitialAssignment_0_0 : ( ( 'init' ) ) ;
    public final void rule__State__IsInitialAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:471:1: ( ( ( 'init' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:472:1: ( ( 'init' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:472:1: ( ( 'init' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:473:1: ( 'init' )
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:474:1: ( 'init' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:475:1: 'init'
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__State__IsInitialAssignment_0_0935); 
             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); 

            }

             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_0_0()); 

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
    // $ANTLR end rule__State__IsInitialAssignment_0_0


    // $ANTLR start rule__State__IsFinalAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:490:1: rule__State__IsFinalAssignment_0_1 : ( ( 'final' ) ) ;
    public final void rule__State__IsFinalAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:494:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:495:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:495:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:496:1: ( 'final' )
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:497:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:498:1: 'final'
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__State__IsFinalAssignment_0_1979); 
             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_0()); 

            }

             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_1_0()); 

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
    // $ANTLR end rule__State__IsFinalAssignment_0_1


    // $ANTLR start rule__State__StateKindAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:513:1: rule__State__StateKindAssignment_0_2 : ( ruleStateType ) ;
    public final void rule__State__StateKindAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:517:1: ( ( ruleStateType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:518:1: ( ruleStateType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:518:1: ( ruleStateType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:519:1: ruleStateType
            {
             before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleStateType_in_rule__State__StateKindAssignment_0_21018);
            ruleStateType();
            _fsp--;

             after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_2_0()); 

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
    // $ANTLR end rule__State__StateKindAssignment_0_2


    // $ANTLR start rule__State__IsInitialAssignment_0_3_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:528:1: rule__State__IsInitialAssignment_0_3_0 : ( ( 'init' ) ) ;
    public final void rule__State__IsInitialAssignment_0_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:532:1: ( ( ( 'init' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:533:1: ( ( 'init' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:533:1: ( ( 'init' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:534:1: ( 'init' )
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_3_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:535:1: ( 'init' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:536:1: 'init'
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_3_0_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__State__IsInitialAssignment_0_3_01054); 
             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_3_0_0()); 

            }

             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_3_0_0()); 

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
    // $ANTLR end rule__State__IsInitialAssignment_0_3_0


    // $ANTLR start rule__State__StateKindAssignment_0_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:551:1: rule__State__StateKindAssignment_0_3_1 : ( ruleStateType ) ;
    public final void rule__State__StateKindAssignment_0_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:555:1: ( ( ruleStateType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:556:1: ( ruleStateType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:556:1: ( ruleStateType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:557:1: ruleStateType
            {
             before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleStateType_in_rule__State__StateKindAssignment_0_3_11093);
            ruleStateType();
            _fsp--;

             after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_3_1_0()); 

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
    // $ANTLR end rule__State__StateKindAssignment_0_3_1


    // $ANTLR start rule__State__IsInitialAssignment_0_4_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:566:1: rule__State__IsInitialAssignment_0_4_0 : ( ( 'init' ) ) ;
    public final void rule__State__IsInitialAssignment_0_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:570:1: ( ( ( 'init' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:571:1: ( ( 'init' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:571:1: ( ( 'init' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:572:1: ( 'init' )
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_0_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:573:1: ( 'init' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:574:1: 'init'
            {
             before(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_0_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__State__IsInitialAssignment_0_4_01129); 
             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_0_0()); 

            }

             after(grammarAccess.getStateAccess().getIsInitialInitKeyword_0_4_0_0()); 

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
    // $ANTLR end rule__State__IsInitialAssignment_0_4_0


    // $ANTLR start rule__State__StateKindAssignment_0_4_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:589:1: rule__State__StateKindAssignment_0_4_1 : ( ruleStateType ) ;
    public final void rule__State__StateKindAssignment_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:593:1: ( ( ruleStateType ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:594:1: ( ruleStateType )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:594:1: ( ruleStateType )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:595:1: ruleStateType
            {
             before(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleStateType_in_rule__State__StateKindAssignment_0_4_11168);
            ruleStateType();
            _fsp--;

             after(grammarAccess.getStateAccess().getStateKindStateTypeEnumRuleCall_0_4_1_0()); 

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
    // $ANTLR end rule__State__StateKindAssignment_0_4_1


    // $ANTLR start rule__State__IsFinalAssignment_0_4_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:604:1: rule__State__IsFinalAssignment_0_4_2 : ( ( 'final' ) ) ;
    public final void rule__State__IsFinalAssignment_0_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:608:1: ( ( ( 'final' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:609:1: ( ( 'final' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:609:1: ( ( 'final' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:610:1: ( 'final' )
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_4_2_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:611:1: ( 'final' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:612:1: 'final'
            {
             before(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_4_2_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__State__IsFinalAssignment_0_4_21204); 
             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_4_2_0()); 

            }

             after(grammarAccess.getStateAccess().getIsFinalFinalKeyword_0_4_2_0()); 

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
    // $ANTLR end rule__State__IsFinalAssignment_0_4_2


    // $ANTLR start rule__State__StateNameAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:627:1: rule__State__StateNameAssignment_2 : ( RULE_ID ) ;
    public final void rule__State__StateNameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:631:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:632:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:632:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:633:1: RULE_ID
            {
             before(grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__State__StateNameAssignment_21243); 
             after(grammarAccess.getStateAccess().getStateNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__State__StateNameAssignment_2


    // $ANTLR start rule__State__LabelAssignment_3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:642:1: rule__State__LabelAssignment_3 : ( RULE_STRING ) ;
    public final void rule__State__LabelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:646:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:647:1: ( RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:647:1: ( RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug286935TestLanguage.g:648:1: RULE_STRING
            {
             before(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__State__LabelAssignment_31274); 
             after(grammarAccess.getStateAccess().getLabelSTRINGTerminalRuleCall_3_0()); 

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
    // $ANTLR end rule__State__LabelAssignment_3


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleState_in_entryRuleState61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleState68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group__0_in_ruleState94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__StateType__Alternatives_in_ruleStateType131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__IsInitialAssignment_0_0_in_rule__State__Alternatives_0166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__IsFinalAssignment_0_1_in_rule__State__Alternatives_0184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__StateKindAssignment_0_2_in_rule__State__Alternatives_0202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_0_3__0_in_rule__State__Alternatives_0220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_0_4__0_in_rule__State__Alternatives_0238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__StateType__Alternatives272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__StateType__Alternatives293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__StateType__Alternatives314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__StateType__Alternatives335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group__0__Impl_in_rule__State__Group__0368 = new BitSet(new long[]{0x0000000000008032L});
        public static final BitSet FOLLOW_rule__State__Group__1_in_rule__State__Group__0371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Alternatives_0_in_rule__State__Group__0__Impl398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group__1__Impl_in_rule__State__Group__1429 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_rule__State__Group__2_in_rule__State__Group__1432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__State__Group__1__Impl461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group__2__Impl_in_rule__State__Group__2494 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_rule__State__Group__3_in_rule__State__Group__2497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__StateNameAssignment_2_in_rule__State__Group__2__Impl524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group__3__Impl_in_rule__State__Group__3555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__LabelAssignment_3_in_rule__State__Group__3__Impl582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_0_3__0__Impl_in_rule__State__Group_0_3__0621 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_rule__State__Group_0_3__1_in_rule__State__Group_0_3__0624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__IsInitialAssignment_0_3_0_in_rule__State__Group_0_3__0__Impl651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_0_3__1__Impl_in_rule__State__Group_0_3__1681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__StateKindAssignment_0_3_1_in_rule__State__Group_0_3__1__Impl708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_0_4__0__Impl_in_rule__State__Group_0_4__0742 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_rule__State__Group_0_4__1_in_rule__State__Group_0_4__0745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__IsInitialAssignment_0_4_0_in_rule__State__Group_0_4__0__Impl772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_0_4__1__Impl_in_rule__State__Group_0_4__1802 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__State__Group_0_4__2_in_rule__State__Group_0_4__1805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__StateKindAssignment_0_4_1_in_rule__State__Group_0_4__1__Impl832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__Group_0_4__2__Impl_in_rule__State__Group_0_4__2862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__State__IsFinalAssignment_0_4_2_in_rule__State__Group_0_4__2__Impl889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__State__IsInitialAssignment_0_0935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__State__IsFinalAssignment_0_1979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStateType_in_rule__State__StateKindAssignment_0_21018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__State__IsInitialAssignment_0_3_01054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStateType_in_rule__State__StateKindAssignment_0_3_11093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__State__IsInitialAssignment_0_4_01129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStateType_in_rule__State__StateKindAssignment_0_4_11168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__State__IsFinalAssignment_0_4_21204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__State__StateNameAssignment_21243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__State__LabelAssignment_31274 = new BitSet(new long[]{0x0000000000000002L});
    }


}