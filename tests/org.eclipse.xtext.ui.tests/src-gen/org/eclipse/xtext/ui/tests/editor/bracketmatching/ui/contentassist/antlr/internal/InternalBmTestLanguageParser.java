package org.eclipse.xtext.ui.tests.editor.bracketmatching.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.bracketmatching.services.BmTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBmTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'('", "')'", "'begin'", "'end'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBmTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g"; }


     
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




    // $ANTLR start entryRuleFile
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:60:1: entryRuleFile : ruleFile EOF ;
    public final void entryRuleFile() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:61:1: ( ruleFile EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:62:1: ruleFile EOF
            {
             before(grammarAccess.getFileRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFile_in_entryRuleFile61);
            ruleFile();
            _fsp--;

             after(grammarAccess.getFileRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFile68); 

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
    // $ANTLR end entryRuleFile


    // $ANTLR start ruleFile
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:69:1: ruleFile : ( ( rule__File__ExpressionAssignment )* ) ;
    public final void ruleFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:73:2: ( ( ( rule__File__ExpressionAssignment )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:74:1: ( ( rule__File__ExpressionAssignment )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:74:1: ( ( rule__File__ExpressionAssignment )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:75:1: ( rule__File__ExpressionAssignment )*
            {
             before(grammarAccess.getFileAccess().getExpressionAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:76:1: ( rule__File__ExpressionAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||LA1_0==11||LA1_0==13||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:76:2: rule__File__ExpressionAssignment
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__File__ExpressionAssignment_in_ruleFile94);
            	    rule__File__ExpressionAssignment();
            	    _fsp--;


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
    // $ANTLR end ruleFile


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:88:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:89:1: ( ruleExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:90:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression122);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression129); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:97:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:101:2: ( ( ( rule__Expression__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:102:1: ( ( rule__Expression__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:102:1: ( ( rule__Expression__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:103:1: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:104:1: ( rule__Expression__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:104:2: rule__Expression__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Expression__Alternatives_in_ruleExpression155);
            rule__Expression__Alternatives();
            _fsp--;


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
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleSExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:116:1: entryRuleSExpression : ruleSExpression EOF ;
    public final void entryRuleSExpression() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:117:1: ( ruleSExpression EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:118:1: ruleSExpression EOF
            {
             before(grammarAccess.getSExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSExpression_in_entryRuleSExpression182);
            ruleSExpression();
            _fsp--;

             after(grammarAccess.getSExpressionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSExpression189); 

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
    // $ANTLR end entryRuleSExpression


    // $ANTLR start ruleSExpression
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:125:1: ruleSExpression : ( ( rule__SExpression__Group__0 ) ) ;
    public final void ruleSExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:129:2: ( ( ( rule__SExpression__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:130:1: ( ( rule__SExpression__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:130:1: ( ( rule__SExpression__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:131:1: ( rule__SExpression__Group__0 )
            {
             before(grammarAccess.getSExpressionAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:132:1: ( rule__SExpression__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:132:2: rule__SExpression__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group__0_in_ruleSExpression215);
            rule__SExpression__Group__0();
            _fsp--;


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
    // $ANTLR end ruleSExpression


    // $ANTLR start entryRuleAtom
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:144:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:145:1: ( ruleAtom EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:146:1: ruleAtom EOF
            {
             before(grammarAccess.getAtomRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom242);
            ruleAtom();
            _fsp--;

             after(grammarAccess.getAtomRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom249); 

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
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:153:1: ruleAtom : ( ( rule__Atom__ValueAssignment ) ) ;
    public final void ruleAtom() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:157:2: ( ( ( rule__Atom__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:158:1: ( ( rule__Atom__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:158:1: ( ( rule__Atom__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:159:1: ( rule__Atom__ValueAssignment )
            {
             before(grammarAccess.getAtomAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:160:1: ( rule__Atom__ValueAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:160:2: rule__Atom__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Atom__ValueAssignment_in_ruleAtom275);
            rule__Atom__ValueAssignment();
            _fsp--;


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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleVALUE
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:172:1: entryRuleVALUE : ruleVALUE EOF ;
    public final void entryRuleVALUE() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:173:1: ( ruleVALUE EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:174:1: ruleVALUE EOF
            {
             before(grammarAccess.getVALUERule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVALUE_in_entryRuleVALUE302);
            ruleVALUE();
            _fsp--;

             after(grammarAccess.getVALUERule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVALUE309); 

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
    // $ANTLR end entryRuleVALUE


    // $ANTLR start ruleVALUE
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:181:1: ruleVALUE : ( ( rule__VALUE__Alternatives ) ) ;
    public final void ruleVALUE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:185:2: ( ( ( rule__VALUE__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:186:1: ( ( rule__VALUE__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:186:1: ( ( rule__VALUE__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:187:1: ( rule__VALUE__Alternatives )
            {
             before(grammarAccess.getVALUEAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:188:1: ( rule__VALUE__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:188:2: rule__VALUE__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__VALUE__Alternatives_in_ruleVALUE335);
            rule__VALUE__Alternatives();
            _fsp--;


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
    // $ANTLR end ruleVALUE


    // $ANTLR start rule__Expression__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:200:1: rule__Expression__Alternatives : ( ( ruleSExpression ) | ( ruleAtom ) | ( ( rule__Expression__Group_2__0 ) ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:204:1: ( ( ruleSExpression ) | ( ruleAtom ) | ( ( rule__Expression__Group_2__0 ) ) )
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
                    new NoViableAltException("200:1: rule__Expression__Alternatives : ( ( ruleSExpression ) | ( ruleAtom ) | ( ( rule__Expression__Group_2__0 ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:205:1: ( ruleSExpression )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:205:1: ( ruleSExpression )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:206:1: ruleSExpression
                    {
                     before(grammarAccess.getExpressionAccess().getSExpressionParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleSExpression_in_rule__Expression__Alternatives371);
                    ruleSExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getSExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:211:6: ( ruleAtom )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:211:6: ( ruleAtom )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:212:1: ruleAtom
                    {
                     before(grammarAccess.getExpressionAccess().getAtomParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_rule__Expression__Alternatives388);
                    ruleAtom();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getAtomParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:217:6: ( ( rule__Expression__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:217:6: ( ( rule__Expression__Group_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:218:1: ( rule__Expression__Group_2__0 )
                    {
                     before(grammarAccess.getExpressionAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:219:1: ( rule__Expression__Group_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:219:2: rule__Expression__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Expression__Group_2__0_in_rule__Expression__Alternatives405);
                    rule__Expression__Group_2__0();
                    _fsp--;


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
    // $ANTLR end rule__Expression__Alternatives


    // $ANTLR start rule__SExpression__Alternatives_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:228:1: rule__SExpression__Alternatives_1 : ( ( ( rule__SExpression__Group_1_0__0 ) ) | ( ( rule__SExpression__Group_1_1__0 ) ) );
    public final void rule__SExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:232:1: ( ( ( rule__SExpression__Group_1_0__0 ) ) | ( ( rule__SExpression__Group_1_1__0 ) ) )
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
                    new NoViableAltException("228:1: rule__SExpression__Alternatives_1 : ( ( ( rule__SExpression__Group_1_0__0 ) ) | ( ( rule__SExpression__Group_1_1__0 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:233:1: ( ( rule__SExpression__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:233:1: ( ( rule__SExpression__Group_1_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:234:1: ( rule__SExpression__Group_1_0__0 )
                    {
                     before(grammarAccess.getSExpressionAccess().getGroup_1_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:235:1: ( rule__SExpression__Group_1_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:235:2: rule__SExpression__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group_1_0__0_in_rule__SExpression__Alternatives_1438);
                    rule__SExpression__Group_1_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getSExpressionAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:239:6: ( ( rule__SExpression__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:239:6: ( ( rule__SExpression__Group_1_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:240:1: ( rule__SExpression__Group_1_1__0 )
                    {
                     before(grammarAccess.getSExpressionAccess().getGroup_1_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:241:1: ( rule__SExpression__Group_1_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:241:2: rule__SExpression__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group_1_1__0_in_rule__SExpression__Alternatives_1456);
                    rule__SExpression__Group_1_1__0();
                    _fsp--;


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
    // $ANTLR end rule__SExpression__Alternatives_1


    // $ANTLR start rule__VALUE__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:250:1: rule__VALUE__Alternatives : ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_STRING ) );
    public final void rule__VALUE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:254:1: ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_STRING ) )
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
                    new NoViableAltException("250:1: rule__VALUE__Alternatives : ( ( RULE_ID ) | ( RULE_INT ) | ( RULE_STRING ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:255:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:255:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:256:1: RULE_ID
                    {
                     before(grammarAccess.getVALUEAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__VALUE__Alternatives489); 
                     after(grammarAccess.getVALUEAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:261:6: ( RULE_INT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:261:6: ( RULE_INT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:262:1: RULE_INT
                    {
                     before(grammarAccess.getVALUEAccess().getINTTerminalRuleCall_1()); 
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__VALUE__Alternatives506); 
                     after(grammarAccess.getVALUEAccess().getINTTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:267:6: ( RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:267:6: ( RULE_STRING )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:268:1: RULE_STRING
                    {
                     before(grammarAccess.getVALUEAccess().getSTRINGTerminalRuleCall_2()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives523); 
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
    // $ANTLR end rule__VALUE__Alternatives


    // $ANTLR start rule__Expression__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:280:1: rule__Expression__Group_2__0 : ( '[' ) rule__Expression__Group_2__1 ;
    public final void rule__Expression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:284:1: ( ( '[' ) rule__Expression__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:285:1: ( '[' ) rule__Expression__Group_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:285:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:286:1: '['
            {
             before(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Expression__Group_2__0558); 
             after(grammarAccess.getExpressionAccess().getLeftSquareBracketKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Expression__Group_2__1_in_rule__Expression__Group_2__0568);
            rule__Expression__Group_2__1();
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
    // $ANTLR end rule__Expression__Group_2__0


    // $ANTLR start rule__Expression__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:300:1: rule__Expression__Group_2__1 : ( ruleExpression ) rule__Expression__Group_2__2 ;
    public final void rule__Expression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:304:1: ( ( ruleExpression ) rule__Expression__Group_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:305:1: ( ruleExpression ) rule__Expression__Group_2__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:305:1: ( ruleExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:306:1: ruleExpression
            {
             before(grammarAccess.getExpressionAccess().getExpressionParserRuleCall_2_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__Expression__Group_2__1596);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionAccess().getExpressionParserRuleCall_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Expression__Group_2__2_in_rule__Expression__Group_2__1604);
            rule__Expression__Group_2__2();
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
    // $ANTLR end rule__Expression__Group_2__1


    // $ANTLR start rule__Expression__Group_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:318:1: rule__Expression__Group_2__2 : ( ']' ) ;
    public final void rule__Expression__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:322:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:323:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:323:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:324:1: ']'
            {
             before(grammarAccess.getExpressionAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Expression__Group_2__2633); 
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
    // $ANTLR end rule__Expression__Group_2__2


    // $ANTLR start rule__SExpression__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:343:1: rule__SExpression__Group__0 : ( () ) rule__SExpression__Group__1 ;
    public final void rule__SExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:347:1: ( ( () ) rule__SExpression__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:348:1: ( () ) rule__SExpression__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:348:1: ( () )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:349:1: ()
            {
             before(grammarAccess.getSExpressionAccess().getSExpressionAction_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:350:1: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:352:1: 
            {
            }

             after(grammarAccess.getSExpressionAccess().getSExpressionAction_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group__1_in_rule__SExpression__Group__0684);
            rule__SExpression__Group__1();
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
    // $ANTLR end rule__SExpression__Group__0


    // $ANTLR start rule__SExpression__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:363:1: rule__SExpression__Group__1 : ( ( rule__SExpression__Alternatives_1 ) ) ;
    public final void rule__SExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:367:1: ( ( ( rule__SExpression__Alternatives_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:368:1: ( ( rule__SExpression__Alternatives_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:368:1: ( ( rule__SExpression__Alternatives_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:369:1: ( rule__SExpression__Alternatives_1 )
            {
             before(grammarAccess.getSExpressionAccess().getAlternatives_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:370:1: ( rule__SExpression__Alternatives_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:370:2: rule__SExpression__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__SExpression__Alternatives_1_in_rule__SExpression__Group__1712);
            rule__SExpression__Alternatives_1();
            _fsp--;


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
    // $ANTLR end rule__SExpression__Group__1


    // $ANTLR start rule__SExpression__Group_1_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:384:1: rule__SExpression__Group_1_0__0 : ( '(' ) rule__SExpression__Group_1_0__1 ;
    public final void rule__SExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:388:1: ( ( '(' ) rule__SExpression__Group_1_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:389:1: ( '(' ) rule__SExpression__Group_1_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:389:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:390:1: '('
            {
             before(grammarAccess.getSExpressionAccess().getLeftParenthesisKeyword_1_0_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__SExpression__Group_1_0__0751); 
             after(grammarAccess.getSExpressionAccess().getLeftParenthesisKeyword_1_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group_1_0__1_in_rule__SExpression__Group_1_0__0761);
            rule__SExpression__Group_1_0__1();
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
    // $ANTLR end rule__SExpression__Group_1_0__0


    // $ANTLR start rule__SExpression__Group_1_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:404:1: rule__SExpression__Group_1_0__1 : ( ( rule__SExpression__ElementAssignment_1_0_1 )* ) rule__SExpression__Group_1_0__2 ;
    public final void rule__SExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:408:1: ( ( ( rule__SExpression__ElementAssignment_1_0_1 )* ) rule__SExpression__Group_1_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:409:1: ( ( rule__SExpression__ElementAssignment_1_0_1 )* ) rule__SExpression__Group_1_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:409:1: ( ( rule__SExpression__ElementAssignment_1_0_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:410:1: ( rule__SExpression__ElementAssignment_1_0_1 )*
            {
             before(grammarAccess.getSExpressionAccess().getElementAssignment_1_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:411:1: ( rule__SExpression__ElementAssignment_1_0_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_STRING)||LA5_0==11||LA5_0==13||LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:411:2: rule__SExpression__ElementAssignment_1_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SExpression__ElementAssignment_1_0_1_in_rule__SExpression__Group_1_0__1789);
            	    rule__SExpression__ElementAssignment_1_0_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getSExpressionAccess().getElementAssignment_1_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group_1_0__2_in_rule__SExpression__Group_1_0__1799);
            rule__SExpression__Group_1_0__2();
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
    // $ANTLR end rule__SExpression__Group_1_0__1


    // $ANTLR start rule__SExpression__Group_1_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:422:1: rule__SExpression__Group_1_0__2 : ( ')' ) ;
    public final void rule__SExpression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:426:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:427:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:427:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:428:1: ')'
            {
             before(grammarAccess.getSExpressionAccess().getRightParenthesisKeyword_1_0_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__SExpression__Group_1_0__2828); 
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
    // $ANTLR end rule__SExpression__Group_1_0__2


    // $ANTLR start rule__SExpression__Group_1_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:447:1: rule__SExpression__Group_1_1__0 : ( 'begin' ) rule__SExpression__Group_1_1__1 ;
    public final void rule__SExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:451:1: ( ( 'begin' ) rule__SExpression__Group_1_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:452:1: ( 'begin' ) rule__SExpression__Group_1_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:452:1: ( 'begin' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:453:1: 'begin'
            {
             before(grammarAccess.getSExpressionAccess().getBeginKeyword_1_1_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__SExpression__Group_1_1__0870); 
             after(grammarAccess.getSExpressionAccess().getBeginKeyword_1_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group_1_1__1_in_rule__SExpression__Group_1_1__0880);
            rule__SExpression__Group_1_1__1();
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
    // $ANTLR end rule__SExpression__Group_1_1__0


    // $ANTLR start rule__SExpression__Group_1_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:467:1: rule__SExpression__Group_1_1__1 : ( ( rule__SExpression__ElementAssignment_1_1_1 )* ) rule__SExpression__Group_1_1__2 ;
    public final void rule__SExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:471:1: ( ( ( rule__SExpression__ElementAssignment_1_1_1 )* ) rule__SExpression__Group_1_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:472:1: ( ( rule__SExpression__ElementAssignment_1_1_1 )* ) rule__SExpression__Group_1_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:472:1: ( ( rule__SExpression__ElementAssignment_1_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:473:1: ( rule__SExpression__ElementAssignment_1_1_1 )*
            {
             before(grammarAccess.getSExpressionAccess().getElementAssignment_1_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:474:1: ( rule__SExpression__ElementAssignment_1_1_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==11||LA6_0==13||LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:474:2: rule__SExpression__ElementAssignment_1_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__SExpression__ElementAssignment_1_1_1_in_rule__SExpression__Group_1_1__1908);
            	    rule__SExpression__ElementAssignment_1_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getSExpressionAccess().getElementAssignment_1_1_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__SExpression__Group_1_1__2_in_rule__SExpression__Group_1_1__1918);
            rule__SExpression__Group_1_1__2();
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
    // $ANTLR end rule__SExpression__Group_1_1__1


    // $ANTLR start rule__SExpression__Group_1_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:485:1: rule__SExpression__Group_1_1__2 : ( 'end' ) ;
    public final void rule__SExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:489:1: ( ( 'end' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:490:1: ( 'end' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:490:1: ( 'end' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:491:1: 'end'
            {
             before(grammarAccess.getSExpressionAccess().getEndKeyword_1_1_2()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__SExpression__Group_1_1__2947); 
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
    // $ANTLR end rule__SExpression__Group_1_1__2


    // $ANTLR start rule__File__ExpressionAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:511:1: rule__File__ExpressionAssignment : ( ruleExpression ) ;
    public final void rule__File__ExpressionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:515:1: ( ( ruleExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:516:1: ( ruleExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:516:1: ( ruleExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:517:1: ruleExpression
            {
             before(grammarAccess.getFileAccess().getExpressionExpressionParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__File__ExpressionAssignment989);
            ruleExpression();
            _fsp--;

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
    // $ANTLR end rule__File__ExpressionAssignment


    // $ANTLR start rule__SExpression__ElementAssignment_1_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:526:1: rule__SExpression__ElementAssignment_1_0_1 : ( ruleExpression ) ;
    public final void rule__SExpression__ElementAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:530:1: ( ( ruleExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:531:1: ( ruleExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:531:1: ( ruleExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:532:1: ruleExpression
            {
             before(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__SExpression__ElementAssignment_1_0_11020);
            ruleExpression();
            _fsp--;

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
    // $ANTLR end rule__SExpression__ElementAssignment_1_0_1


    // $ANTLR start rule__SExpression__ElementAssignment_1_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:541:1: rule__SExpression__ElementAssignment_1_1_1 : ( ruleExpression ) ;
    public final void rule__SExpression__ElementAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:545:1: ( ( ruleExpression ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:546:1: ( ruleExpression )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:546:1: ( ruleExpression )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:547:1: ruleExpression
            {
             before(grammarAccess.getSExpressionAccess().getElementExpressionParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_rule__SExpression__ElementAssignment_1_1_11051);
            ruleExpression();
            _fsp--;

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
    // $ANTLR end rule__SExpression__ElementAssignment_1_1_1


    // $ANTLR start rule__Atom__ValueAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:556:1: rule__Atom__ValueAssignment : ( ruleVALUE ) ;
    public final void rule__Atom__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:560:1: ( ( ruleVALUE ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:561:1: ( ruleVALUE )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:561:1: ( ruleVALUE )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/bracketmatching/ui/contentassist/antlr/internal/InternalBmTestLanguage.g:562:1: ruleVALUE
            {
             before(grammarAccess.getAtomAccess().getValueVALUEParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleVALUE_in_rule__Atom__ValueAssignment1082);
            ruleVALUE();
            _fsp--;

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
    // $ANTLR end rule__Atom__ValueAssignment


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFile_in_entryRuleFile61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFile68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__File__ExpressionAssignment_in_ruleFile94 = new BitSet(new long[]{0x000000000000A872L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression122 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Expression__Alternatives_in_ruleExpression155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSExpression_in_entryRuleSExpression182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSExpression189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SExpression__Group__0_in_ruleSExpression215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom242 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Atom__ValueAssignment_in_ruleAtom275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVALUE_in_entryRuleVALUE302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVALUE309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VALUE__Alternatives_in_ruleVALUE335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSExpression_in_rule__Expression__Alternatives371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_rule__Expression__Alternatives388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Expression__Group_2__0_in_rule__Expression__Alternatives405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SExpression__Group_1_0__0_in_rule__SExpression__Alternatives_1438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SExpression__Group_1_1__0_in_rule__SExpression__Alternatives_1456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__VALUE__Alternatives489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__VALUE__Alternatives506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__VALUE__Alternatives523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Expression__Group_2__0558 = new BitSet(new long[]{0x000000000000A870L});
        public static final BitSet FOLLOW_rule__Expression__Group_2__1_in_rule__Expression__Group_2__0568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__Expression__Group_2__1596 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Expression__Group_2__2_in_rule__Expression__Group_2__1604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Expression__Group_2__2633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SExpression__Group__1_in_rule__SExpression__Group__0684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SExpression__Alternatives_1_in_rule__SExpression__Group__1712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__SExpression__Group_1_0__0751 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_rule__SExpression__Group_1_0__1_in_rule__SExpression__Group_1_0__0761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SExpression__ElementAssignment_1_0_1_in_rule__SExpression__Group_1_0__1789 = new BitSet(new long[]{0x000000000000E870L});
        public static final BitSet FOLLOW_rule__SExpression__Group_1_0__2_in_rule__SExpression__Group_1_0__1799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__SExpression__Group_1_0__2828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__SExpression__Group_1_1__0870 = new BitSet(new long[]{0x000000000001A870L});
        public static final BitSet FOLLOW_rule__SExpression__Group_1_1__1_in_rule__SExpression__Group_1_1__0880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__SExpression__ElementAssignment_1_1_1_in_rule__SExpression__Group_1_1__1908 = new BitSet(new long[]{0x000000000001A870L});
        public static final BitSet FOLLOW_rule__SExpression__Group_1_1__2_in_rule__SExpression__Group_1_1__1918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__SExpression__Group_1_1__2947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__File__ExpressionAssignment989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__SExpression__ElementAssignment_1_0_11020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_rule__SExpression__ElementAssignment_1_1_11051 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVALUE_in_rule__Atom__ValueAssignment1082 = new BitSet(new long[]{0x0000000000000002L});
    }


}