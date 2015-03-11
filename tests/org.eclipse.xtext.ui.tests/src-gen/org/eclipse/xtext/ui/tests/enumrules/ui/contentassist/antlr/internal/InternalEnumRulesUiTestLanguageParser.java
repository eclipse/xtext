package org.eclipse.xtext.ui.tests.enumrules.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.enumrules.services.EnumRulesUiTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEnumRulesUiTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SameName'", "'overridden'", "'DifferentLiteral'", "'existing'", "'generated'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalEnumRulesUiTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEnumRulesUiTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEnumRulesUiTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g"; }


     
     	private EnumRulesUiTestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EnumRulesUiTestLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:61:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:69:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:73:2: ( ( ( rule__Model__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:74:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:75:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:76:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:76:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel94);
            rule__Model__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "ruleExistingEnum"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:89:1: ruleExistingEnum : ( ( rule__ExistingEnum__Alternatives ) ) ;
    public final void ruleExistingEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:93:1: ( ( ( rule__ExistingEnum__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:94:1: ( ( rule__ExistingEnum__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:94:1: ( ( rule__ExistingEnum__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:95:1: ( rule__ExistingEnum__Alternatives )
            {
             before(grammarAccess.getExistingEnumAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:96:1: ( rule__ExistingEnum__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:96:2: rule__ExistingEnum__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ExistingEnum__Alternatives_in_ruleExistingEnum131);
            rule__ExistingEnum__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleExistingEnum"


    // $ANTLR start "ruleGeneratedEnum"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:108:1: ruleGeneratedEnum : ( ( rule__GeneratedEnum__Alternatives ) ) ;
    public final void ruleGeneratedEnum() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:112:1: ( ( ( rule__GeneratedEnum__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:113:1: ( ( rule__GeneratedEnum__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:113:1: ( ( rule__GeneratedEnum__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:114:1: ( rule__GeneratedEnum__Alternatives )
            {
             before(grammarAccess.getGeneratedEnumAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:115:1: ( rule__GeneratedEnum__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:115:2: rule__GeneratedEnum__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__GeneratedEnum__Alternatives_in_ruleGeneratedEnum167);
            rule__GeneratedEnum__Alternatives();

            state._fsp--;


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
    // $ANTLR end "ruleGeneratedEnum"


    // $ANTLR start "rule__Model__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:126:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:130:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
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
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:131:1: ( ( rule__Model__Group_0__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:131:1: ( ( rule__Model__Group_0__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:132:1: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:133:1: ( rule__Model__Group_0__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:133:2: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0_in_rule__Model__Alternatives202);
                    rule__Model__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:137:6: ( ( rule__Model__Group_1__0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:137:6: ( ( rule__Model__Group_1__0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:138:1: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:139:1: ( rule__Model__Group_1__0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:139:2: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0_in_rule__Model__Alternatives220);
                    rule__Model__Group_1__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Model__Alternatives"


    // $ANTLR start "rule__ExistingEnum__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:148:1: rule__ExistingEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__ExistingEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:152:1: ( ( ( 'SameName' ) ) | ( ( 'overridden' ) ) | ( ( 'DifferentLiteral' ) ) )
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
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:153:1: ( ( 'SameName' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:153:1: ( ( 'SameName' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:154:1: ( 'SameName' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:155:1: ( 'SameName' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:155:3: 'SameName'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__ExistingEnum__Alternatives254); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:160:6: ( ( 'overridden' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:160:6: ( ( 'overridden' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:161:1: ( 'overridden' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:162:1: ( 'overridden' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:162:3: 'overridden'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__ExistingEnum__Alternatives275); 

                    }

                     after(grammarAccess.getExistingEnumAccess().getOverriddenLiteralEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:167:6: ( ( 'DifferentLiteral' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:167:6: ( ( 'DifferentLiteral' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:168:1: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getExistingEnumAccess().getDifferentNameEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:169:1: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:169:3: 'DifferentLiteral'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__ExistingEnum__Alternatives296); 

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
    // $ANTLR end "rule__ExistingEnum__Alternatives"


    // $ANTLR start "rule__GeneratedEnum__Alternatives"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:179:1: rule__GeneratedEnum__Alternatives : ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) );
    public final void rule__GeneratedEnum__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:183:1: ( ( ( 'SameName' ) ) | ( ( 'DifferentLiteral' ) ) )
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
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:184:1: ( ( 'SameName' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:184:1: ( ( 'SameName' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:185:1: ( 'SameName' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:186:1: ( 'SameName' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:186:3: 'SameName'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__GeneratedEnum__Alternatives332); 

                    }

                     after(grammarAccess.getGeneratedEnumAccess().getSameNameEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:191:6: ( ( 'DifferentLiteral' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:191:6: ( ( 'DifferentLiteral' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:192:1: ( 'DifferentLiteral' )
                    {
                     before(grammarAccess.getGeneratedEnumAccess().getDifferentNameEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:193:1: ( 'DifferentLiteral' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:193:3: 'DifferentLiteral'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__GeneratedEnum__Alternatives353); 

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
    // $ANTLR end "rule__GeneratedEnum__Alternatives"


    // $ANTLR start "rule__Model__Group_0__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:205:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:209:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:210:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__0386);
            rule__Model__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0389);
            rule__Model__Group_0__1();

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
    // $ANTLR end "rule__Model__Group_0__0"


    // $ANTLR start "rule__Model__Group_0__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:217:1: rule__Model__Group_0__0__Impl : ( 'existing' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:221:1: ( ( 'existing' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:222:1: ( 'existing' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:222:1: ( 'existing' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:223:1: 'existing'
            {
             before(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Model__Group_0__0__Impl417); 
             after(grammarAccess.getModelAccess().getExistingKeyword_0_0()); 

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
    // $ANTLR end "rule__Model__Group_0__0__Impl"


    // $ANTLR start "rule__Model__Group_0__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:236:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl rule__Model__Group_0__2 ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:240:1: ( rule__Model__Group_0__1__Impl rule__Model__Group_0__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:241:2: rule__Model__Group_0__1__Impl rule__Model__Group_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__1448);
            rule__Model__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__2_in_rule__Model__Group_0__1451);
            rule__Model__Group_0__2();

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
    // $ANTLR end "rule__Model__Group_0__1"


    // $ANTLR start "rule__Model__Group_0__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:248:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__ExistingAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:252:1: ( ( ( rule__Model__ExistingAssignment_0_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:253:1: ( ( rule__Model__ExistingAssignment_0_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:253:1: ( ( rule__Model__ExistingAssignment_0_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:254:1: ( rule__Model__ExistingAssignment_0_1 )
            {
             before(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:255:1: ( rule__Model__ExistingAssignment_0_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:255:2: rule__Model__ExistingAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__ExistingAssignment_0_1_in_rule__Model__Group_0__1__Impl478);
            rule__Model__ExistingAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getExistingAssignment_0_1()); 

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
    // $ANTLR end "rule__Model__Group_0__1__Impl"


    // $ANTLR start "rule__Model__Group_0__2"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:265:1: rule__Model__Group_0__2 : rule__Model__Group_0__2__Impl ;
    public final void rule__Model__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:269:1: ( rule__Model__Group_0__2__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:270:2: rule__Model__Group_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0__2__Impl_in_rule__Model__Group_0__2508);
            rule__Model__Group_0__2__Impl();

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
    // $ANTLR end "rule__Model__Group_0__2"


    // $ANTLR start "rule__Model__Group_0__2__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:276:1: rule__Model__Group_0__2__Impl : ( ( rule__Model__Group_0_2__0 )? ) ;
    public final void rule__Model__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:280:1: ( ( ( rule__Model__Group_0_2__0 )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:281:1: ( ( rule__Model__Group_0_2__0 )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:281:1: ( ( rule__Model__Group_0_2__0 )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:282:1: ( rule__Model__Group_0_2__0 )?
            {
             before(grammarAccess.getModelAccess().getGroup_0_2()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:283:1: ( rule__Model__Group_0_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:283:2: rule__Model__Group_0_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0_2__0_in_rule__Model__Group_0__2__Impl535);
                    rule__Model__Group_0_2__0();

                    state._fsp--;


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
    // $ANTLR end "rule__Model__Group_0__2__Impl"


    // $ANTLR start "rule__Model__Group_0_2__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:299:1: rule__Model__Group_0_2__0 : rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1 ;
    public final void rule__Model__Group_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:303:1: ( rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:304:2: rule__Model__Group_0_2__0__Impl rule__Model__Group_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0_2__0__Impl_in_rule__Model__Group_0_2__0572);
            rule__Model__Group_0_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0_2__1_in_rule__Model__Group_0_2__0575);
            rule__Model__Group_0_2__1();

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
    // $ANTLR end "rule__Model__Group_0_2__0"


    // $ANTLR start "rule__Model__Group_0_2__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:311:1: rule__Model__Group_0_2__0__Impl : ( 'generated' ) ;
    public final void rule__Model__Group_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:315:1: ( ( 'generated' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:316:1: ( 'generated' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:316:1: ( 'generated' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:317:1: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_0_2__0__Impl603); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_0_2_0()); 

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
    // $ANTLR end "rule__Model__Group_0_2__0__Impl"


    // $ANTLR start "rule__Model__Group_0_2__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:330:1: rule__Model__Group_0_2__1 : rule__Model__Group_0_2__1__Impl ;
    public final void rule__Model__Group_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:334:1: ( rule__Model__Group_0_2__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:335:2: rule__Model__Group_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_0_2__1__Impl_in_rule__Model__Group_0_2__1634);
            rule__Model__Group_0_2__1__Impl();

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
    // $ANTLR end "rule__Model__Group_0_2__1"


    // $ANTLR start "rule__Model__Group_0_2__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:341:1: rule__Model__Group_0_2__1__Impl : ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) ;
    public final void rule__Model__Group_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:345:1: ( ( ( rule__Model__GeneratedAssignment_0_2_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:346:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:346:1: ( ( rule__Model__GeneratedAssignment_0_2_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:347:1: ( rule__Model__GeneratedAssignment_0_2_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_0_2_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:348:1: ( rule__Model__GeneratedAssignment_0_2_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:348:2: rule__Model__GeneratedAssignment_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__GeneratedAssignment_0_2_1_in_rule__Model__Group_0_2__1__Impl661);
            rule__Model__GeneratedAssignment_0_2_1();

            state._fsp--;


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
    // $ANTLR end "rule__Model__Group_0_2__1__Impl"


    // $ANTLR start "rule__Model__Group_1__0"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:362:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:366:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:367:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0695);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0698);
            rule__Model__Group_1__1();

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
    // $ANTLR end "rule__Model__Group_1__0"


    // $ANTLR start "rule__Model__Group_1__0__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:374:1: rule__Model__Group_1__0__Impl : ( 'generated' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:378:1: ( ( 'generated' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:379:1: ( 'generated' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:379:1: ( 'generated' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:380:1: 'generated'
            {
             before(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Model__Group_1__0__Impl726); 
             after(grammarAccess.getModelAccess().getGeneratedKeyword_1_0()); 

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
    // $ANTLR end "rule__Model__Group_1__0__Impl"


    // $ANTLR start "rule__Model__Group_1__1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:393:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:397:1: ( rule__Model__Group_1__1__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:398:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__1757);
            rule__Model__Group_1__1__Impl();

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
    // $ANTLR end "rule__Model__Group_1__1"


    // $ANTLR start "rule__Model__Group_1__1__Impl"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:404:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__GeneratedAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:408:1: ( ( ( rule__Model__GeneratedAssignment_1_1 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:409:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:409:1: ( ( rule__Model__GeneratedAssignment_1_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:410:1: ( rule__Model__GeneratedAssignment_1_1 )
            {
             before(grammarAccess.getModelAccess().getGeneratedAssignment_1_1()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:411:1: ( rule__Model__GeneratedAssignment_1_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:411:2: rule__Model__GeneratedAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__GeneratedAssignment_1_1_in_rule__Model__Group_1__1__Impl784);
            rule__Model__GeneratedAssignment_1_1();

            state._fsp--;


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
    // $ANTLR end "rule__Model__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ExistingAssignment_0_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:426:1: rule__Model__ExistingAssignment_0_1 : ( ruleExistingEnum ) ;
    public final void rule__Model__ExistingAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:430:1: ( ( ruleExistingEnum ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:431:1: ( ruleExistingEnum )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:431:1: ( ruleExistingEnum )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:432:1: ruleExistingEnum
            {
             before(grammarAccess.getModelAccess().getExistingExistingEnumEnumRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleExistingEnum_in_rule__Model__ExistingAssignment_0_1823);
            ruleExistingEnum();

            state._fsp--;

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
    // $ANTLR end "rule__Model__ExistingAssignment_0_1"


    // $ANTLR start "rule__Model__GeneratedAssignment_0_2_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:441:1: rule__Model__GeneratedAssignment_0_2_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:445:1: ( ( ruleGeneratedEnum ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:446:1: ( ruleGeneratedEnum )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:446:1: ( ruleGeneratedEnum )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:447:1: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_0_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_0_2_1854);
            ruleGeneratedEnum();

            state._fsp--;

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
    // $ANTLR end "rule__Model__GeneratedAssignment_0_2_1"


    // $ANTLR start "rule__Model__GeneratedAssignment_1_1"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:456:1: rule__Model__GeneratedAssignment_1_1 : ( ruleGeneratedEnum ) ;
    public final void rule__Model__GeneratedAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:460:1: ( ( ruleGeneratedEnum ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:461:1: ( ruleGeneratedEnum )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:461:1: ( ruleGeneratedEnum )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/enumrules/ui/contentassist/antlr/internal/InternalEnumRulesUiTestLanguage.g:462:1: ruleGeneratedEnum
            {
             before(grammarAccess.getModelAccess().getGeneratedGeneratedEnumEnumRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_1_1885);
            ruleGeneratedEnum();

            state._fsp--;

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
    // $ANTLR end "rule__Model__GeneratedAssignment_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
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
        public static final BitSet FOLLOW_rule__Model__Group_0__0__Impl_in_rule__Model__Group_0__0386 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1_in_rule__Model__Group_0__0389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Model__Group_0__0__Impl417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__1__Impl_in_rule__Model__Group_0__1448 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Model__Group_0__2_in_rule__Model__Group_0__1451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__ExistingAssignment_0_1_in_rule__Model__Group_0__1__Impl478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0__2__Impl_in_rule__Model__Group_0__2508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0_2__0_in_rule__Model__Group_0__2__Impl535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0_2__0__Impl_in_rule__Model__Group_0_2__0572 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_rule__Model__Group_0_2__1_in_rule__Model__Group_0_2__0575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_0_2__0__Impl603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_0_2__1__Impl_in_rule__Model__Group_0_2__1634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__GeneratedAssignment_0_2_1_in_rule__Model__Group_0_2__1__Impl661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__0__Impl_in_rule__Model__Group_1__0695 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1_in_rule__Model__Group_1__0698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Model__Group_1__0__Impl726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Group_1__1__Impl_in_rule__Model__Group_1__1757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__GeneratedAssignment_1_1_in_rule__Model__Group_1__1__Impl784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExistingEnum_in_rule__Model__ExistingAssignment_0_1823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_0_2_1854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGeneratedEnum_in_rule__Model__GeneratedAssignment_1_1885 = new BitSet(new long[]{0x0000000000000002L});
    }


}