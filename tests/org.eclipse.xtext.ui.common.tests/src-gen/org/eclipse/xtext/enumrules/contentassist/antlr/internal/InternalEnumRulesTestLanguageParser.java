package org.eclipse.xtext.enumrules.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.enumrules.services.EnumRulesTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEnumRulesTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SameName'", "'overridden'", "'DifferentLiteral'", "'existing'", "'generated'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEnumRulesTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g"; }


     
     	private EnumRulesTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EnumRulesTestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:55:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:55:16: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:56:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:63:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:67:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:68:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:68:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:69:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:70:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:70:2: rule__Model__Alternatives
            {
            pushFollow(FOLLOW_rule__Model__Alternatives_in_ruleModel94);
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


    // $ANTLR start ruleExistingEnum
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:83:1: ruleExistingEnum : ( ( rule__ExistingEnum__Alternatives ) ) ;
    public final void ruleExistingEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:87:1: ( ( ( rule__ExistingEnum__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:88:1: ( ( rule__ExistingEnum__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:88:1: ( ( rule__ExistingEnum__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:89:1: ( rule__ExistingEnum__Alternatives )
            {
             before(grammarAccess.getExistingEnumAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:90:1: ( rule__ExistingEnum__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:90:2: rule__ExistingEnum__Alternatives
            {
            pushFollow(FOLLOW_rule__ExistingEnum__Alternatives_in_ruleExistingEnum131);
            rule__ExistingEnum__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getExistingEnumAccess().getAlternatives()); 

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
    // $ANTLR end ruleExistingEnum


    // $ANTLR start ruleGeneratedEnum
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:102:1: ruleGeneratedEnum : ( ( rule__GeneratedEnum__Alternatives ) ) ;
    public final void ruleGeneratedEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:106:1: ( ( ( rule__GeneratedEnum__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:107:1: ( ( rule__GeneratedEnum__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:107:1: ( ( rule__GeneratedEnum__Alternatives ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:108:1: ( rule__GeneratedEnum__Alternatives )
            {
             before(grammarAccess.getGeneratedEnumAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:109:1: ( rule__GeneratedEnum__Alternatives )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:109:2: rule__GeneratedEnum__Alternatives
            {
            pushFollow(FOLLOW_rule__GeneratedEnum__Alternatives_in_ruleGeneratedEnum167);
            rule__GeneratedEnum__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getGeneratedEnumAccess().getAlternatives()); 

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
    // $ANTLR end ruleGeneratedEnum


    // $ANTLR start rule__Model__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:120:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:124:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("120:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:125:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:125:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:126:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:127:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:127:2: rule__Model__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives202);
                    rule__Model__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:131:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:131:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:132:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:133:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:133:2: rule__Model__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives220);
                    rule__Model__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

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


    // $ANTLR start rule__ExistingEnum__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:142:1: rule__ExistingEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__ExistingEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:146:1: ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) )
            int alt2=3;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("142:1: rule__ExistingEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:147:1: ( ( 'SameName' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:147:1: ( ( 'SameName' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:148:1: ( 'SameName' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:149:1: ( 'SameName' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:149:3: 'SameName'
                    {
                    match(input,11,FOLLOW_11_in_rule__ExistingEnum__Alternatives254); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:154:6: ( ( 'overridden' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:154:6: ( ( 'overridden' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:155:1: ( 'overridden' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:156:1: ( 'overridden' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:156:3: 'overridden'
                    {
                    match(input,12,FOLLOW_12_in_rule__ExistingEnum__Alternatives275); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:161:6: ( ( 'DifferentLiteral' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:161:6: ( ( 'DifferentLiteral' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:162:1: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:163:1: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:163:3: 'DifferentLiteral'
                    {
                    match(input,13,FOLLOW_13_in_rule__ExistingEnum__Alternatives296); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2()); 

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
    // $ANTLR end rule__ExistingEnum__Alternatives


    // $ANTLR start rule__GeneratedEnum__Alternatives
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:173:1: rule__GeneratedEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__GeneratedEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:177:1: ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("173:1: rule__GeneratedEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:178:1: ( ( 'SameName' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:178:1: ( ( 'SameName' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:179:1: ( 'SameName' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:180:1: ( 'SameName' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:180:3: 'SameName'
                    {
                    match(input,11,FOLLOW_11_in_rule__GeneratedEnum__Alternatives332); 

                    }

                     after(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:185:6: ( ( 'DifferentLiteral' ) )
                    {
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:185:6: ( ( 'DifferentLiteral' ) )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:186:1: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:187:1: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:187:3: 'DifferentLiteral'
                    {
                    match(input,13,FOLLOW_13_in_rule__GeneratedEnum__Alternatives353); 

                    }

                     after(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1()); 

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
    // $ANTLR end rule__GeneratedEnum__Alternatives


    // $ANTLR start rule__Model__Group_0__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:199:1: rule__Model__Group_0__0 : ( 'existing' ) rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:203:1: ( ( 'existing' ) rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:204:1: ( 'existing' ) rule__Model__Group_0__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:204:1: ( 'existing' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:205:1: 'existing'
            {
             before(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 
            match(input,14,FOLLOW_14_in_rule__Model__Group_0__0391); 
             after(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0401);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:219:1: rule__Model__Group_0__1 : ( ( rule__Model__ExistingAssignment_0_1 ) ) rule__Model__Group_0__2 ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:223:1: ( ( ( rule__Model__ExistingAssignment_0_1 ) ) rule__Model__Group_0__2 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:224:1: ( ( rule__Model__ExistingAssignment_0_1 ) ) rule__Model__Group_0__2
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:224:1: ( ( rule__Model__ExistingAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:225:1: ( rule__Model__ExistingAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:226:1: ( rule__Model__ExistingAssignment_0_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:226:2: rule__Model__ExistingAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Model__ExistingAssignment_0_1_in_rule__Model__Group_0__1429);
            rule__Model__ExistingAssignment_0_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 

            }

            pushFollow(FOLLOW_rule__Model__Group_0__2_in_rule__Model__Group_0__1438);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:237:1: rule__Model__Group_0__2 : ( ( rule__Model__Group_0_2__0 )? ) ;
    public final void rule__Model__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:241:1: ( ( ( rule__Model__Group_0_2__0 )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:242:1: ( ( rule__Model__Group_0_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:242:1: ( ( rule__Model__Group_0_2__0 )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:243:1: ( rule__Model__Group_0_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_0_2()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:244:1: ( rule__Model__Group_0_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:244:2: rule__Model__Group_0_2__0
                    {
                    pushFollow(FOLLOW_rule__Model__Group_0_2__0_in_rule__Model__Group_0__2466);
                    rule__Model__Group_0_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getGroup_0_2()); 

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
    // $ANTLR end rule__Model__Group_0__2


    // $ANTLR start rule__Model__Group_0_2__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:260:1: rule__Model__Group_0_2__0 : ( 'generated' ) rule__Model__Group_0_2__1 ;
    public final void rule__Model__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:264:1: ( ( 'generated' ) rule__Model__Group_0_2__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:265:1: ( 'generated' ) rule__Model__Group_0_2__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:265:1: ( 'generated' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:266:1: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 
            match(input,15,FOLLOW_15_in_rule__Model__Group_0_2__0508); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group_0_2__1_in_rule__Model__Group_0_2__0518);
            rule__Model__Group_0_2__1();
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
    // $ANTLR end rule__Model__Group_0_2__0


    // $ANTLR start rule__Model__Group_0_2__1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:280:1: rule__Model__Group_0_2__1 : ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) ;
    public final void rule__Model__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:284:1: ( ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:285:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:285:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:286:1: ( rule__Model__GeneratedAssignment_0_2_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:287:1: ( rule__Model__GeneratedAssignment_0_2_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:287:2: rule__Model__GeneratedAssignment_0_2_1
            {
            pushFollow(FOLLOW_rule__Model__GeneratedAssignment_0_2_1_in_rule__Model__Group_0_2__1546);
            rule__Model__GeneratedAssignment_0_2_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1()); 

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
    // $ANTLR end rule__Model__Group_0_2__1


    // $ANTLR start rule__Model__Group_1__0
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:301:1: rule__Model__Group_1__0 : ( 'generated' ) rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:305:1: ( ( 'generated' ) rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:306:1: ( 'generated' ) rule__Model__Group_1__1
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:306:1: ( 'generated' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:307:1: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 
            match(input,15,FOLLOW_15_in_rule__Model__Group_1__0585); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0595);
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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:321:1: rule__Model__Group_1__1 : ( ( rule__Model__GeneratedAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:325:1: ( ( ( rule__Model__GeneratedAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:326:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:326:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:327:1: ( rule__Model__GeneratedAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:328:1: ( rule__Model__GeneratedAssignment_1_1 )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:328:2: rule__Model__GeneratedAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Model__GeneratedAssignment_1_1_in_rule__Model__Group_1__1623);
            rule__Model__GeneratedAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGeneratedAssignment_1_1()); 

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
    // $ANTLR end rule__Model__Group_1__1


    // $ANTLR start rule__Model__ExistingAssignment_0_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:342:1: rule__Model__ExistingAssignment_0_1 : ( ruleExistingEnum ) ;
    public final void rule__Model__ExistingAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:346:1: ( ( ruleExistingEnum ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:347:1: ( ruleExistingEnum )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:347:1: ( ruleExistingEnum )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:348:1: ruleExistingEnum
            {
             before(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleExistingEnum_in_rule__Model__ExistingAssignment_0_1661);
            ruleExistingEnum();
            _fsp--;

             after(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0()); 

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
    // $ANTLR end rule__Model__ExistingAssignment_0_1


    // $ANTLR start rule__Model__GeneratedAssignment_0_2_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:357:1: rule__Model__GeneratedAssignment_0_2_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:361:1: ( ( ruleGeneratedEnum ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:362:1: ( ruleGeneratedEnum )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:362:1: ( ruleGeneratedEnum )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:363:1: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0()); 
            pushFollow(FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_0_2_1692);
            ruleGeneratedEnum();
            _fsp--;

             after(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0()); 

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
    // $ANTLR end rule__Model__GeneratedAssignment_0_2_1


    // $ANTLR start rule__Model__GeneratedAssignment_1_1
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:372:1: rule__Model__GeneratedAssignment_1_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:376:1: ( ( ruleGeneratedEnum ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:377:1: ( ruleGeneratedEnum )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:377:1: ( ruleGeneratedEnum )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/enumrules/contentassist/antlr/internal/InternalEnumRulesTestLanguage.g:378:1: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_1_1723);
            ruleGeneratedEnum();
            _fsp--;

             after(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0()); 

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
    // $ANTLR end rule__Model__GeneratedAssignment_1_1


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExistingEnum__Alternatives_in_ruleExistingEnum131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GeneratedEnum__Alternatives_in_ruleGeneratedEnum167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ExistingEnum__Alternatives254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__ExistingEnum__Alternatives275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ExistingEnum__Alternatives296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__GeneratedEnum__Alternatives332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__GeneratedEnum__Alternatives353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Model__Group_0__0391 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ExistingAssignment_0_1_in_rule__Model__Group_0__1429 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__Model__Group_0__2_in_rule__Model__Group_0__1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group_0_2__0_in_rule__Model__Group_0__2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Model__Group_0_2__0508 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_rule__Model__Group_0_2__1_in_rule__Model__Group_0_2__0518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__GeneratedAssignment_0_2_1_in_rule__Model__Group_0_2__1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Model__Group_1__0585 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__GeneratedAssignment_1_1_in_rule__Model__Group_1__1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExistingEnum_in_rule__Model__ExistingAssignment_0_1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_0_2_1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_1_1723 = new BitSet(new long[]{0x0000000000000002L});

}