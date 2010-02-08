package org.eclipse.xtext.ui.tests.editor.contentassist.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.LookAheadContentAssistTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalLookAheadContentAssistTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'['", "']'", "'<'", "'>'", "'{'", "'}'", "'='"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalLookAheadContentAssistTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g"; }


     
     	private LookAheadContentAssistTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(LookAheadContentAssistTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel68); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:76:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:76:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel94);
            rule__Model__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:88:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:89:1: ( ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:90:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute121);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute128); 

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:97:1: ruleAttribute : ( ( rule__Attribute__ValueAssignment ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:101:2: ( ( ( rule__Attribute__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:102:1: ( ( rule__Attribute__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:102:1: ( ( rule__Attribute__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:103:1: ( rule__Attribute__ValueAssignment )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:104:1: ( rule__Attribute__ValueAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:104:2: rule__Attribute__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__ValueAssignment_in_ruleAttribute154);
            rule__Attribute__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getAttributeAccess().getValueAssignment()); 

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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRulePair
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:116:1: entryRulePair : rulePair EOF ;
    public final void entryRulePair() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:117:1: ( rulePair EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:118:1: rulePair EOF
            {
             before(grammarAccess.getPairRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePair_in_entryRulePair181);
            rulePair();
            _fsp--;

             after(grammarAccess.getPairRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePair188); 

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
    // $ANTLR end entryRulePair


    // $ANTLR start rulePair
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:125:1: rulePair : ( ( rule__Pair__Group__0 ) ) ;
    public final void rulePair() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:129:2: ( ( ( rule__Pair__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:130:1: ( ( rule__Pair__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:130:1: ( ( rule__Pair__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:131:1: ( rule__Pair__Group__0 )
            {
             before(grammarAccess.getPairAccess().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:132:1: ( rule__Pair__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:132:2: rule__Pair__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Pair__Group__0_in_rulePair214);
            rule__Pair__Group__0();
            _fsp--;


            }

             after(grammarAccess.getPairAccess().getGroup()); 

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
    // $ANTLR end rulePair


    // $ANTLR start rule__Model__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:144:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:148:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("144:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:149:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:149:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:150:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:151:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:151:2: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives250);
                    rule__Model__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:155:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:155:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:156:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:157:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:157:2: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives268);
                    rule__Model__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:161:6: ( ( rule__Model__Group_2__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:161:6: ( ( rule__Model__Group_2__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:162:1: ( rule__Model__Group_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:163:1: ( rule__Model__Group_2__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:163:2: rule__Model__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives286);
                    rule__Model__Group_2__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:167:6: ( ( rule__Model__Group_3__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:167:6: ( ( rule__Model__Group_3__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:168:1: ( rule__Model__Group_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_3()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:169:1: ( rule__Model__Group_3__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:169:2: rule__Model__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives304);
                    rule__Model__Group_3__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_3()); 

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
    // $ANTLR end rule__Model__Alternatives


    // $ANTLR start rule__Model__Group_0__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:180:1: rule__Model__Group_0__0 : ( '(' ) rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:184:1: ( ( '(' ) rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:185:1: ( '(' ) rule__Model__Group_0__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:185:1: ( '(' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:186:1: '('
            {
             before(grammarAccess.getModelAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Model__Group_0__0340); 
             after(grammarAccess.getModelAccess().getLeftParenthesisKeyword_0_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0350);
            rule__Model__Group_0__1();
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
    // $ANTLR end rule__Model__Group_0__0


    // $ANTLR start rule__Model__Group_0__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:200:1: rule__Model__Group_0__1 : ( ( rule__Model__AttributeAssignment_0_1 )* ) rule__Model__Group_0__2 ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:204:1: ( ( ( rule__Model__AttributeAssignment_0_1 )* ) rule__Model__Group_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:205:1: ( ( rule__Model__AttributeAssignment_0_1 )* ) rule__Model__Group_0__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:205:1: ( ( rule__Model__AttributeAssignment_0_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:206:1: ( rule__Model__AttributeAssignment_0_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:207:1: ( rule__Model__AttributeAssignment_0_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==RULE_ID||LA2_1==12) ) {
                        alt2=1;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:207:2: rule__Model__AttributeAssignment_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_0_1_in_rule__Model__Group_0__1378);
            	    rule__Model__AttributeAssignment_0_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_0_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__2_in_rule__Model__Group_0__1388);
            rule__Model__Group_0__2();
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
    // $ANTLR end rule__Model__Group_0__1


    // $ANTLR start rule__Model__Group_0__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:218:1: rule__Model__Group_0__2 : ( ( rule__Model__AttributeAssignment_0_2 )* ) rule__Model__Group_0__3 ;
    public final void rule__Model__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:222:1: ( ( ( rule__Model__AttributeAssignment_0_2 )* ) rule__Model__Group_0__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:223:1: ( ( rule__Model__AttributeAssignment_0_2 )* ) rule__Model__Group_0__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:223:1: ( ( rule__Model__AttributeAssignment_0_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:224:1: ( rule__Model__AttributeAssignment_0_2 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_0_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:225:1: ( rule__Model__AttributeAssignment_0_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:225:2: rule__Model__AttributeAssignment_0_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_0_2_in_rule__Model__Group_0__2416);
            	    rule__Model__AttributeAssignment_0_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_0_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__3_in_rule__Model__Group_0__2426);
            rule__Model__Group_0__3();
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
    // $ANTLR end rule__Model__Group_0__2


    // $ANTLR start rule__Model__Group_0__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:236:1: rule__Model__Group_0__3 : ( ')' ) ;
    public final void rule__Model__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:240:1: ( ( ')' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:241:1: ( ')' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:241:1: ( ')' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:242:1: ')'
            {
             before(grammarAccess.getModelAccess().getRightParenthesisKeyword_0_3()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Model__Group_0__3455); 
             after(grammarAccess.getModelAccess().getRightParenthesisKeyword_0_3()); 

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
    // $ANTLR end rule__Model__Group_0__3


    // $ANTLR start rule__Model__Group_1__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:263:1: rule__Model__Group_1__0 : ( '[' ) rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:267:1: ( ( '[' ) rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:268:1: ( '[' ) rule__Model__Group_1__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:268:1: ( '[' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:269:1: '['
            {
             before(grammarAccess.getModelAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Model__Group_1__0499); 
             after(grammarAccess.getModelAccess().getLeftSquareBracketKeyword_1_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0509);
            rule__Model__Group_1__1();
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
    // $ANTLR end rule__Model__Group_1__0


    // $ANTLR start rule__Model__Group_1__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:283:1: rule__Model__Group_1__1 : ( ( ( rule__Model__AttributeAssignment_1_1 ) ) ( ( rule__Model__AttributeAssignment_1_1 )* ) ) rule__Model__Group_1__2 ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:287:1: ( ( ( ( rule__Model__AttributeAssignment_1_1 ) ) ( ( rule__Model__AttributeAssignment_1_1 )* ) ) rule__Model__Group_1__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:288:1: ( ( ( rule__Model__AttributeAssignment_1_1 ) ) ( ( rule__Model__AttributeAssignment_1_1 )* ) ) rule__Model__Group_1__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:288:1: ( ( ( rule__Model__AttributeAssignment_1_1 ) ) ( ( rule__Model__AttributeAssignment_1_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:289:1: ( ( rule__Model__AttributeAssignment_1_1 ) ) ( ( rule__Model__AttributeAssignment_1_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:289:1: ( ( rule__Model__AttributeAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:290:1: ( rule__Model__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:291:1: ( rule__Model__AttributeAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:291:2: rule__Model__AttributeAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_1_1_in_rule__Model__Group_1__1539);
            rule__Model__AttributeAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAttributeAssignment_1_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:294:1: ( ( rule__Model__AttributeAssignment_1_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:295:1: ( rule__Model__AttributeAssignment_1_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:296:1: ( rule__Model__AttributeAssignment_1_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==RULE_ID||LA4_1==14) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:296:2: rule__Model__AttributeAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_1_1_in_rule__Model__Group_1__1551);
            	    rule__Model__AttributeAssignment_1_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_1_1()); 

            }


            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__2_in_rule__Model__Group_1__1563);
            rule__Model__Group_1__2();
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
    // $ANTLR end rule__Model__Group_1__1


    // $ANTLR start rule__Model__Group_1__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:308:1: rule__Model__Group_1__2 : ( ( rule__Model__AttributeAssignment_1_2 )* ) rule__Model__Group_1__3 ;
    public final void rule__Model__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:312:1: ( ( ( rule__Model__AttributeAssignment_1_2 )* ) rule__Model__Group_1__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:313:1: ( ( rule__Model__AttributeAssignment_1_2 )* ) rule__Model__Group_1__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:313:1: ( ( rule__Model__AttributeAssignment_1_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:314:1: ( rule__Model__AttributeAssignment_1_2 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_1_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:315:1: ( rule__Model__AttributeAssignment_1_2 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:315:2: rule__Model__AttributeAssignment_1_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_1_2_in_rule__Model__Group_1__2591);
            	    rule__Model__AttributeAssignment_1_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_1_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__3_in_rule__Model__Group_1__2601);
            rule__Model__Group_1__3();
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
    // $ANTLR end rule__Model__Group_1__2


    // $ANTLR start rule__Model__Group_1__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:326:1: rule__Model__Group_1__3 : ( ']' ) ;
    public final void rule__Model__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:330:1: ( ( ']' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:331:1: ( ']' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:331:1: ( ']' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:332:1: ']'
            {
             before(grammarAccess.getModelAccess().getRightSquareBracketKeyword_1_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_1__3630); 
             after(grammarAccess.getModelAccess().getRightSquareBracketKeyword_1_3()); 

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
    // $ANTLR end rule__Model__Group_1__3


    // $ANTLR start rule__Model__Group_2__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:353:1: rule__Model__Group_2__0 : ( '<' ) rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:357:1: ( ( '<' ) rule__Model__Group_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:358:1: ( '<' ) rule__Model__Group_2__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:358:1: ( '<' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:359:1: '<'
            {
             before(grammarAccess.getModelAccess().getLessThanSignKeyword_2_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_2__0674); 
             after(grammarAccess.getModelAccess().getLessThanSignKeyword_2_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__0684);
            rule__Model__Group_2__1();
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
    // $ANTLR end rule__Model__Group_2__0


    // $ANTLR start rule__Model__Group_2__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:373:1: rule__Model__Group_2__1 : ( ( rule__Model__AttributeAssignment_2_1 )* ) rule__Model__Group_2__2 ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:377:1: ( ( ( rule__Model__AttributeAssignment_2_1 )* ) rule__Model__Group_2__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:378:1: ( ( rule__Model__AttributeAssignment_2_1 )* ) rule__Model__Group_2__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:378:1: ( ( rule__Model__AttributeAssignment_2_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:379:1: ( rule__Model__AttributeAssignment_2_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:380:1: ( rule__Model__AttributeAssignment_2_1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_ID) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:380:2: rule__Model__AttributeAssignment_2_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_2_1_in_rule__Model__Group_2__1712);
            	    rule__Model__AttributeAssignment_2_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_2_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__2_in_rule__Model__Group_2__1722);
            rule__Model__Group_2__2();
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
    // $ANTLR end rule__Model__Group_2__1


    // $ANTLR start rule__Model__Group_2__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:391:1: rule__Model__Group_2__2 : ( ( ( rule__Model__AttributeAssignment_2_2 ) ) ( ( rule__Model__AttributeAssignment_2_2 )* ) ) rule__Model__Group_2__3 ;
    public final void rule__Model__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:395:1: ( ( ( ( rule__Model__AttributeAssignment_2_2 ) ) ( ( rule__Model__AttributeAssignment_2_2 )* ) ) rule__Model__Group_2__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:396:1: ( ( ( rule__Model__AttributeAssignment_2_2 ) ) ( ( rule__Model__AttributeAssignment_2_2 )* ) ) rule__Model__Group_2__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:396:1: ( ( ( rule__Model__AttributeAssignment_2_2 ) ) ( ( rule__Model__AttributeAssignment_2_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:397:1: ( ( rule__Model__AttributeAssignment_2_2 ) ) ( ( rule__Model__AttributeAssignment_2_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:397:1: ( ( rule__Model__AttributeAssignment_2_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:398:1: ( rule__Model__AttributeAssignment_2_2 )
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_2_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:399:1: ( rule__Model__AttributeAssignment_2_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:399:2: rule__Model__AttributeAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_2_2_in_rule__Model__Group_2__2752);
            rule__Model__AttributeAssignment_2_2();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAttributeAssignment_2_2()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:402:1: ( ( rule__Model__AttributeAssignment_2_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:403:1: ( rule__Model__AttributeAssignment_2_2 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_2_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:404:1: ( rule__Model__AttributeAssignment_2_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:404:2: rule__Model__AttributeAssignment_2_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_2_2_in_rule__Model__Group_2__2764);
            	    rule__Model__AttributeAssignment_2_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_2_2()); 

            }


            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_2__3_in_rule__Model__Group_2__2776);
            rule__Model__Group_2__3();
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
    // $ANTLR end rule__Model__Group_2__2


    // $ANTLR start rule__Model__Group_2__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:416:1: rule__Model__Group_2__3 : ( '>' ) ;
    public final void rule__Model__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:420:1: ( ( '>' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:421:1: ( '>' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:421:1: ( '>' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:422:1: '>'
            {
             before(grammarAccess.getModelAccess().getGreaterThanSignKeyword_2_3()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Model__Group_2__3805); 
             after(grammarAccess.getModelAccess().getGreaterThanSignKeyword_2_3()); 

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
    // $ANTLR end rule__Model__Group_2__3


    // $ANTLR start rule__Model__Group_3__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:443:1: rule__Model__Group_3__0 : ( '{' ) rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:447:1: ( ( '{' ) rule__Model__Group_3__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:448:1: ( '{' ) rule__Model__Group_3__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:448:1: ( '{' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:449:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Model__Group_3__0849); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__0859);
            rule__Model__Group_3__1();
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
    // $ANTLR end rule__Model__Group_3__0


    // $ANTLR start rule__Model__Group_3__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:463:1: rule__Model__Group_3__1 : ( ( ( rule__Model__AttributeAssignment_3_1 ) ) ( ( rule__Model__AttributeAssignment_3_1 )* ) ) rule__Model__Group_3__2 ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:467:1: ( ( ( ( rule__Model__AttributeAssignment_3_1 ) ) ( ( rule__Model__AttributeAssignment_3_1 )* ) ) rule__Model__Group_3__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:468:1: ( ( ( rule__Model__AttributeAssignment_3_1 ) ) ( ( rule__Model__AttributeAssignment_3_1 )* ) ) rule__Model__Group_3__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:468:1: ( ( ( rule__Model__AttributeAssignment_3_1 ) ) ( ( rule__Model__AttributeAssignment_3_1 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:469:1: ( ( rule__Model__AttributeAssignment_3_1 ) ) ( ( rule__Model__AttributeAssignment_3_1 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:469:1: ( ( rule__Model__AttributeAssignment_3_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:470:1: ( rule__Model__AttributeAssignment_3_1 )
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:471:1: ( rule__Model__AttributeAssignment_3_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:471:2: rule__Model__AttributeAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_3_1_in_rule__Model__Group_3__1889);
            rule__Model__AttributeAssignment_3_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAttributeAssignment_3_1()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:474:1: ( ( rule__Model__AttributeAssignment_3_1 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:475:1: ( rule__Model__AttributeAssignment_3_1 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_3_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:476:1: ( rule__Model__AttributeAssignment_3_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==RULE_ID) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:476:2: rule__Model__AttributeAssignment_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_3_1_in_rule__Model__Group_3__1901);
            	    rule__Model__AttributeAssignment_3_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_3_1()); 

            }


            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__2_in_rule__Model__Group_3__1913);
            rule__Model__Group_3__2();
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
    // $ANTLR end rule__Model__Group_3__1


    // $ANTLR start rule__Model__Group_3__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:488:1: rule__Model__Group_3__2 : ( ( ( rule__Model__AttributeAssignment_3_2 ) ) ( ( rule__Model__AttributeAssignment_3_2 )* ) ) rule__Model__Group_3__3 ;
    public final void rule__Model__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:492:1: ( ( ( ( rule__Model__AttributeAssignment_3_2 ) ) ( ( rule__Model__AttributeAssignment_3_2 )* ) ) rule__Model__Group_3__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:493:1: ( ( ( rule__Model__AttributeAssignment_3_2 ) ) ( ( rule__Model__AttributeAssignment_3_2 )* ) ) rule__Model__Group_3__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:493:1: ( ( ( rule__Model__AttributeAssignment_3_2 ) ) ( ( rule__Model__AttributeAssignment_3_2 )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:494:1: ( ( rule__Model__AttributeAssignment_3_2 ) ) ( ( rule__Model__AttributeAssignment_3_2 )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:494:1: ( ( rule__Model__AttributeAssignment_3_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:495:1: ( rule__Model__AttributeAssignment_3_2 )
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_3_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:496:1: ( rule__Model__AttributeAssignment_3_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:496:2: rule__Model__AttributeAssignment_3_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_3_2_in_rule__Model__Group_3__2943);
            rule__Model__AttributeAssignment_3_2();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAttributeAssignment_3_2()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:499:1: ( ( rule__Model__AttributeAssignment_3_2 )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:500:1: ( rule__Model__AttributeAssignment_3_2 )*
            {
             before(grammarAccess.getModelAccess().getAttributeAssignment_3_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:501:1: ( rule__Model__AttributeAssignment_3_2 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:501:2: rule__Model__AttributeAssignment_3_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__AttributeAssignment_3_2_in_rule__Model__Group_3__2955);
            	    rule__Model__AttributeAssignment_3_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAttributeAssignment_3_2()); 

            }


            }

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_3__3_in_rule__Model__Group_3__2967);
            rule__Model__Group_3__3();
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
    // $ANTLR end rule__Model__Group_3__2


    // $ANTLR start rule__Model__Group_3__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:513:1: rule__Model__Group_3__3 : ( '}' ) ;
    public final void rule__Model__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:517:1: ( ( '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:518:1: ( '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:518:1: ( '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:519:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_3()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Model__Group_3__3996); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_3_3()); 

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
    // $ANTLR end rule__Model__Group_3__3


    // $ANTLR start rule__Pair__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:540:1: rule__Pair__Group__0 : ( ( rule__Pair__NameAssignment_0 ) ) rule__Pair__Group__1 ;
    public final void rule__Pair__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:544:1: ( ( ( rule__Pair__NameAssignment_0 ) ) rule__Pair__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:545:1: ( ( rule__Pair__NameAssignment_0 ) ) rule__Pair__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:545:1: ( ( rule__Pair__NameAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:546:1: ( rule__Pair__NameAssignment_0 )
            {
             before(grammarAccess.getPairAccess().getNameAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:547:1: ( rule__Pair__NameAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:547:2: rule__Pair__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Pair__NameAssignment_0_in_rule__Pair__Group__01039);
            rule__Pair__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getPairAccess().getNameAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Pair__Group__1_in_rule__Pair__Group__01048);
            rule__Pair__Group__1();
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
    // $ANTLR end rule__Pair__Group__0


    // $ANTLR start rule__Pair__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:558:1: rule__Pair__Group__1 : ( '=' ) rule__Pair__Group__2 ;
    public final void rule__Pair__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:562:1: ( ( '=' ) rule__Pair__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:563:1: ( '=' ) rule__Pair__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:563:1: ( '=' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:564:1: '='
            {
             before(grammarAccess.getPairAccess().getEqualsSignKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Pair__Group__11077); 
             after(grammarAccess.getPairAccess().getEqualsSignKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Pair__Group__2_in_rule__Pair__Group__11087);
            rule__Pair__Group__2();
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
    // $ANTLR end rule__Pair__Group__1


    // $ANTLR start rule__Pair__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:578:1: rule__Pair__Group__2 : ( ( rule__Pair__ValueAssignment_2 ) ) ;
    public final void rule__Pair__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:582:1: ( ( ( rule__Pair__ValueAssignment_2 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:583:1: ( ( rule__Pair__ValueAssignment_2 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:583:1: ( ( rule__Pair__ValueAssignment_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:584:1: ( rule__Pair__ValueAssignment_2 )
            {
             before(grammarAccess.getPairAccess().getValueAssignment_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:585:1: ( rule__Pair__ValueAssignment_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:585:2: rule__Pair__ValueAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Pair__ValueAssignment_2_in_rule__Pair__Group__21115);
            rule__Pair__ValueAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getPairAccess().getValueAssignment_2()); 

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
    // $ANTLR end rule__Pair__Group__2


    // $ANTLR start rule__Model__AttributeAssignment_0_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:602:1: rule__Model__AttributeAssignment_0_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:606:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:607:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:607:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:608:1: ruleAttribute
            {
             before(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_0_11156);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_0_1_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_0_1


    // $ANTLR start rule__Model__AttributeAssignment_0_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:617:1: rule__Model__AttributeAssignment_0_2 : ( rulePair ) ;
    public final void rule__Model__AttributeAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:621:1: ( ( rulePair ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:622:1: ( rulePair )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:622:1: ( rulePair )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:623:1: rulePair
            {
             before(grammarAccess.getModelAccess().getAttributePairParserRuleCall_0_2_0()); 
            pushFollow(FollowSets000.FOLLOW_rulePair_in_rule__Model__AttributeAssignment_0_21187);
            rulePair();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributePairParserRuleCall_0_2_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_0_2


    // $ANTLR start rule__Model__AttributeAssignment_1_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:632:1: rule__Model__AttributeAssignment_1_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:636:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:637:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:637:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:638:1: ruleAttribute
            {
             before(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_1_11218);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_1_1_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_1_1


    // $ANTLR start rule__Model__AttributeAssignment_1_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:647:1: rule__Model__AttributeAssignment_1_2 : ( rulePair ) ;
    public final void rule__Model__AttributeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:651:1: ( ( rulePair ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:652:1: ( rulePair )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:652:1: ( rulePair )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:653:1: rulePair
            {
             before(grammarAccess.getModelAccess().getAttributePairParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_rulePair_in_rule__Model__AttributeAssignment_1_21249);
            rulePair();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributePairParserRuleCall_1_2_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_1_2


    // $ANTLR start rule__Model__AttributeAssignment_2_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:662:1: rule__Model__AttributeAssignment_2_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:666:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:667:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:667:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:668:1: ruleAttribute
            {
             before(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_2_11280);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_2_1_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_2_1


    // $ANTLR start rule__Model__AttributeAssignment_2_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:677:1: rule__Model__AttributeAssignment_2_2 : ( rulePair ) ;
    public final void rule__Model__AttributeAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:681:1: ( ( rulePair ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:682:1: ( rulePair )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:682:1: ( rulePair )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:683:1: rulePair
            {
             before(grammarAccess.getModelAccess().getAttributePairParserRuleCall_2_2_0()); 
            pushFollow(FollowSets000.FOLLOW_rulePair_in_rule__Model__AttributeAssignment_2_21311);
            rulePair();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributePairParserRuleCall_2_2_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_2_2


    // $ANTLR start rule__Model__AttributeAssignment_3_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:692:1: rule__Model__AttributeAssignment_3_1 : ( ruleAttribute ) ;
    public final void rule__Model__AttributeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:696:1: ( ( ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:697:1: ( ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:697:1: ( ruleAttribute )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:698:1: ruleAttribute
            {
             before(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_3_11342);
            ruleAttribute();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributeAttributeParserRuleCall_3_1_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_3_1


    // $ANTLR start rule__Model__AttributeAssignment_3_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:707:1: rule__Model__AttributeAssignment_3_2 : ( rulePair ) ;
    public final void rule__Model__AttributeAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:711:1: ( ( rulePair ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:712:1: ( rulePair )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:712:1: ( rulePair )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:713:1: rulePair
            {
             before(grammarAccess.getModelAccess().getAttributePairParserRuleCall_3_2_0()); 
            pushFollow(FollowSets000.FOLLOW_rulePair_in_rule__Model__AttributeAssignment_3_21373);
            rulePair();
            _fsp--;

             after(grammarAccess.getModelAccess().getAttributePairParserRuleCall_3_2_0()); 

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
    // $ANTLR end rule__Model__AttributeAssignment_3_2


    // $ANTLR start rule__Attribute__ValueAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:722:1: rule__Attribute__ValueAssignment : ( RULE_ID ) ;
    public final void rule__Attribute__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:726:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:727:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:727:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:728:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getValueIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__ValueAssignment1404); 
             after(grammarAccess.getAttributeAccess().getValueIDTerminalRuleCall_0()); 

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
    // $ANTLR end rule__Attribute__ValueAssignment


    // $ANTLR start rule__Pair__NameAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:737:1: rule__Pair__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Pair__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:741:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:742:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:742:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:743:1: RULE_ID
            {
             before(grammarAccess.getPairAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Pair__NameAssignment_01435); 
             after(grammarAccess.getPairAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__Pair__NameAssignment_0


    // $ANTLR start rule__Pair__ValueAssignment_2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:752:1: rule__Pair__ValueAssignment_2 : ( RULE_ID ) ;
    public final void rule__Pair__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:756:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:757:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:757:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/contentassist/antlr/internal/InternalLookAheadContentAssistTestLanguage.g:758:1: RULE_ID
            {
             before(grammarAccess.getPairAccess().getValueIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Pair__ValueAssignment_21466); 
             after(grammarAccess.getPairAccess().getValueIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end rule__Pair__ValueAssignment_2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__ValueAssignment_in_ruleAttribute154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePair_in_entryRulePair181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePair188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Pair__Group__0_in_rulePair214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_2__0_in_rule__Model__Alternatives286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_3__0_in_rule__Model__Alternatives304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Model__Group_0__0340 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_0_1_in_rule__Model__Group_0__1378 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Model__Group_0__2_in_rule__Model__Group_0__1388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_0_2_in_rule__Model__Group_0__2416 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_rule__Model__Group_0__3_in_rule__Model__Group_0__2426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Model__Group_0__3455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Model__Group_1__0499 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_1_1_in_rule__Model__Group_1__1539 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_1_1_in_rule__Model__Group_1__1551 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Model__Group_1__2_in_rule__Model__Group_1__1563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_1_2_in_rule__Model__Group_1__2591 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_rule__Model__Group_1__3_in_rule__Model__Group_1__2601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group_1__3630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_2__0674 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_2__1_in_rule__Model__Group_2__0684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_2_1_in_rule__Model__Group_2__1712 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_2__2_in_rule__Model__Group_2__1722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_2_2_in_rule__Model__Group_2__2752 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_2_2_in_rule__Model__Group_2__2764 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_rule__Model__Group_2__3_in_rule__Model__Group_2__2776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Model__Group_2__3805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Model__Group_3__0849 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_3__1_in_rule__Model__Group_3__0859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_3_1_in_rule__Model__Group_3__1889 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_3_1_in_rule__Model__Group_3__1901 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Model__Group_3__2_in_rule__Model__Group_3__1913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_3_2_in_rule__Model__Group_3__2943 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_rule__Model__AttributeAssignment_3_2_in_rule__Model__Group_3__2955 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_rule__Model__Group_3__3_in_rule__Model__Group_3__2967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Model__Group_3__3996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Pair__NameAssignment_0_in_rule__Pair__Group__01039 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Pair__Group__1_in_rule__Pair__Group__01048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Pair__Group__11077 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Pair__Group__2_in_rule__Pair__Group__11087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Pair__ValueAssignment_2_in_rule__Pair__Group__21115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_0_11156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePair_in_rule__Model__AttributeAssignment_0_21187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_1_11218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePair_in_rule__Model__AttributeAssignment_1_21249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_2_11280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePair_in_rule__Model__AttributeAssignment_2_21311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Model__AttributeAssignment_3_11342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePair_in_rule__Model__AttributeAssignment_3_21373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__ValueAssignment1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Pair__NameAssignment_01435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Pair__ValueAssignment_21466 = new BitSet(new long[]{0x0000000000000002L});
    }


}