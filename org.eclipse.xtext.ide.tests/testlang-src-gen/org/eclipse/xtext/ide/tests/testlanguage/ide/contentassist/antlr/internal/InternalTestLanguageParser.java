package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'string'", "'int'", "'boolean'", "'type'", "'{'", "'}'", "'extends'", "']'", "'['"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTestLanguage.g"; }


    	private TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
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
    // InternalTestLanguage.g:57:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalTestLanguage.g:58:1: ( ruleModel EOF )
            // InternalTestLanguage.g:59:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalTestLanguage.g:66:1: ruleModel : ( ( rule__Model__TypesAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:70:2: ( ( ( rule__Model__TypesAssignment )* ) )
            // InternalTestLanguage.g:71:2: ( ( rule__Model__TypesAssignment )* )
            {
            // InternalTestLanguage.g:71:2: ( ( rule__Model__TypesAssignment )* )
            // InternalTestLanguage.g:72:3: ( rule__Model__TypesAssignment )*
            {
             before(grammarAccess.getModelAccess().getTypesAssignment()); 
            // InternalTestLanguage.g:73:3: ( rule__Model__TypesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:73:4: rule__Model__TypesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__TypesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getTypesAssignment()); 

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


    // $ANTLR start "entryRuleTypeDeclaration"
    // InternalTestLanguage.g:82:1: entryRuleTypeDeclaration : ruleTypeDeclaration EOF ;
    public final void entryRuleTypeDeclaration() throws RecognitionException {
        try {
            // InternalTestLanguage.g:83:1: ( ruleTypeDeclaration EOF )
            // InternalTestLanguage.g:84:1: ruleTypeDeclaration EOF
            {
             before(grammarAccess.getTypeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeDeclaration();

            state._fsp--;

             after(grammarAccess.getTypeDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeDeclaration"


    // $ANTLR start "ruleTypeDeclaration"
    // InternalTestLanguage.g:91:1: ruleTypeDeclaration : ( ( rule__TypeDeclaration__Group__0 ) ) ;
    public final void ruleTypeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:95:2: ( ( ( rule__TypeDeclaration__Group__0 ) ) )
            // InternalTestLanguage.g:96:2: ( ( rule__TypeDeclaration__Group__0 ) )
            {
            // InternalTestLanguage.g:96:2: ( ( rule__TypeDeclaration__Group__0 ) )
            // InternalTestLanguage.g:97:3: ( rule__TypeDeclaration__Group__0 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getGroup()); 
            // InternalTestLanguage.g:98:3: ( rule__TypeDeclaration__Group__0 )
            // InternalTestLanguage.g:98:4: rule__TypeDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclarationAccess().getGroup()); 

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
    // $ANTLR end "ruleTypeDeclaration"


    // $ANTLR start "entryRuleProperty"
    // InternalTestLanguage.g:107:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // InternalTestLanguage.g:108:1: ( ruleProperty EOF )
            // InternalTestLanguage.g:109:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalTestLanguage.g:116:1: ruleProperty : ( ( rule__Property__Group__0 ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:120:2: ( ( ( rule__Property__Group__0 ) ) )
            // InternalTestLanguage.g:121:2: ( ( rule__Property__Group__0 ) )
            {
            // InternalTestLanguage.g:121:2: ( ( rule__Property__Group__0 ) )
            // InternalTestLanguage.g:122:3: ( rule__Property__Group__0 )
            {
             before(grammarAccess.getPropertyAccess().getGroup()); 
            // InternalTestLanguage.g:123:3: ( rule__Property__Group__0 )
            // InternalTestLanguage.g:123:4: rule__Property__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Property__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getGroup()); 

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleType"
    // InternalTestLanguage.g:132:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalTestLanguage.g:133:1: ( ruleType EOF )
            // InternalTestLanguage.g:134:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleType();

            state._fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalTestLanguage.g:141:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:145:2: ( ( ( rule__Type__Group__0 ) ) )
            // InternalTestLanguage.g:146:2: ( ( rule__Type__Group__0 ) )
            {
            // InternalTestLanguage.g:146:2: ( ( rule__Type__Group__0 ) )
            // InternalTestLanguage.g:147:3: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // InternalTestLanguage.g:148:3: ( rule__Type__Group__0 )
            // InternalTestLanguage.g:148:4: rule__Type__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Type__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getGroup()); 

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeReference"
    // InternalTestLanguage.g:157:1: entryRuleTypeReference : ruleTypeReference EOF ;
    public final void entryRuleTypeReference() throws RecognitionException {
        try {
            // InternalTestLanguage.g:158:1: ( ruleTypeReference EOF )
            // InternalTestLanguage.g:159:1: ruleTypeReference EOF
            {
             before(grammarAccess.getTypeReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeReference();

            state._fsp--;

             after(grammarAccess.getTypeReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeReference"


    // $ANTLR start "ruleTypeReference"
    // InternalTestLanguage.g:166:1: ruleTypeReference : ( ( rule__TypeReference__TypeRefAssignment ) ) ;
    public final void ruleTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:170:2: ( ( ( rule__TypeReference__TypeRefAssignment ) ) )
            // InternalTestLanguage.g:171:2: ( ( rule__TypeReference__TypeRefAssignment ) )
            {
            // InternalTestLanguage.g:171:2: ( ( rule__TypeReference__TypeRefAssignment ) )
            // InternalTestLanguage.g:172:3: ( rule__TypeReference__TypeRefAssignment )
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment()); 
            // InternalTestLanguage.g:173:3: ( rule__TypeReference__TypeRefAssignment )
            // InternalTestLanguage.g:173:4: rule__TypeReference__TypeRefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__TypeReference__TypeRefAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment()); 

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
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRulePrimitiveType"
    // InternalTestLanguage.g:182:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalTestLanguage.g:183:1: ( rulePrimitiveType EOF )
            // InternalTestLanguage.g:184:1: rulePrimitiveType EOF
            {
             before(grammarAccess.getPrimitiveTypeRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveType();

            state._fsp--;

             after(grammarAccess.getPrimitiveTypeRule()); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimitiveType"


    // $ANTLR start "rulePrimitiveType"
    // InternalTestLanguage.g:191:1: rulePrimitiveType : ( ( rule__PrimitiveType__NameAssignment ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:195:2: ( ( ( rule__PrimitiveType__NameAssignment ) ) )
            // InternalTestLanguage.g:196:2: ( ( rule__PrimitiveType__NameAssignment ) )
            {
            // InternalTestLanguage.g:196:2: ( ( rule__PrimitiveType__NameAssignment ) )
            // InternalTestLanguage.g:197:3: ( rule__PrimitiveType__NameAssignment )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAssignment()); 
            // InternalTestLanguage.g:198:3: ( rule__PrimitiveType__NameAssignment )
            // InternalTestLanguage.g:198:4: rule__PrimitiveType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveTypeAccess().getNameAssignment()); 

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
    // $ANTLR end "rulePrimitiveType"


    // $ANTLR start "rule__Type__Alternatives_0"
    // InternalTestLanguage.g:206:1: rule__Type__Alternatives_0 : ( ( ruleTypeReference ) | ( rulePrimitiveType ) );
    public final void rule__Type__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:210:1: ( ( ruleTypeReference ) | ( rulePrimitiveType ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=11 && LA2_0<=13)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:211:2: ( ruleTypeReference )
                    {
                    // InternalTestLanguage.g:211:2: ( ruleTypeReference )
                    // InternalTestLanguage.g:212:3: ruleTypeReference
                    {
                     before(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTypeReference();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:217:2: ( rulePrimitiveType )
                    {
                    // InternalTestLanguage.g:217:2: ( rulePrimitiveType )
                    // InternalTestLanguage.g:218:3: rulePrimitiveType
                    {
                     before(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    rulePrimitiveType();

                    state._fsp--;

                     after(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__Type__Alternatives_0"


    // $ANTLR start "rule__PrimitiveType__NameAlternatives_0"
    // InternalTestLanguage.g:227:1: rule__PrimitiveType__NameAlternatives_0 : ( ( 'string' ) | ( 'int' ) | ( 'boolean' ) );
    public final void rule__PrimitiveType__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:231:1: ( ( 'string' ) | ( 'int' ) | ( 'boolean' ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalTestLanguage.g:232:2: ( 'string' )
                    {
                    // InternalTestLanguage.g:232:2: ( 'string' )
                    // InternalTestLanguage.g:233:3: 'string'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:238:2: ( 'int' )
                    {
                    // InternalTestLanguage.g:238:2: ( 'int' )
                    // InternalTestLanguage.g:239:3: 'int'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTestLanguage.g:244:2: ( 'boolean' )
                    {
                    // InternalTestLanguage.g:244:2: ( 'boolean' )
                    // InternalTestLanguage.g:245:3: 'boolean'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); 

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
    // $ANTLR end "rule__PrimitiveType__NameAlternatives_0"


    // $ANTLR start "rule__TypeDeclaration__Group__0"
    // InternalTestLanguage.g:254:1: rule__TypeDeclaration__Group__0 : rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 ;
    public final void rule__TypeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:258:1: ( rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 )
            // InternalTestLanguage.g:259:2: rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__TypeDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__1();

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
    // $ANTLR end "rule__TypeDeclaration__Group__0"


    // $ANTLR start "rule__TypeDeclaration__Group__0__Impl"
    // InternalTestLanguage.g:266:1: rule__TypeDeclaration__Group__0__Impl : ( 'type' ) ;
    public final void rule__TypeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:270:1: ( ( 'type' ) )
            // InternalTestLanguage.g:271:1: ( 'type' )
            {
            // InternalTestLanguage.g:271:1: ( 'type' )
            // InternalTestLanguage.g:272:2: 'type'
            {
             before(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group__0__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__1"
    // InternalTestLanguage.g:281:1: rule__TypeDeclaration__Group__1 : rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 ;
    public final void rule__TypeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:285:1: ( rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 )
            // InternalTestLanguage.g:286:2: rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__TypeDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__2();

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
    // $ANTLR end "rule__TypeDeclaration__Group__1"


    // $ANTLR start "rule__TypeDeclaration__Group__1__Impl"
    // InternalTestLanguage.g:293:1: rule__TypeDeclaration__Group__1__Impl : ( ( rule__TypeDeclaration__NameAssignment_1 ) ) ;
    public final void rule__TypeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:297:1: ( ( ( rule__TypeDeclaration__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:298:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:298:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            // InternalTestLanguage.g:299:2: ( rule__TypeDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:300:2: ( rule__TypeDeclaration__NameAssignment_1 )
            // InternalTestLanguage.g:300:3: rule__TypeDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group__1__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__2"
    // InternalTestLanguage.g:308:1: rule__TypeDeclaration__Group__2 : rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 ;
    public final void rule__TypeDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:312:1: ( rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 )
            // InternalTestLanguage.g:313:2: rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__TypeDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__3();

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
    // $ANTLR end "rule__TypeDeclaration__Group__2"


    // $ANTLR start "rule__TypeDeclaration__Group__2__Impl"
    // InternalTestLanguage.g:320:1: rule__TypeDeclaration__Group__2__Impl : ( ( rule__TypeDeclaration__Group_2__0 )? ) ;
    public final void rule__TypeDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:324:1: ( ( ( rule__TypeDeclaration__Group_2__0 )? ) )
            // InternalTestLanguage.g:325:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            {
            // InternalTestLanguage.g:325:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            // InternalTestLanguage.g:326:2: ( rule__TypeDeclaration__Group_2__0 )?
            {
             before(grammarAccess.getTypeDeclarationAccess().getGroup_2()); 
            // InternalTestLanguage.g:327:2: ( rule__TypeDeclaration__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalTestLanguage.g:327:3: rule__TypeDeclaration__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeDeclaration__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeDeclarationAccess().getGroup_2()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group__2__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__3"
    // InternalTestLanguage.g:335:1: rule__TypeDeclaration__Group__3 : rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 ;
    public final void rule__TypeDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:339:1: ( rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 )
            // InternalTestLanguage.g:340:2: rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__TypeDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__4();

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
    // $ANTLR end "rule__TypeDeclaration__Group__3"


    // $ANTLR start "rule__TypeDeclaration__Group__3__Impl"
    // InternalTestLanguage.g:347:1: rule__TypeDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__TypeDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:351:1: ( ( '{' ) )
            // InternalTestLanguage.g:352:1: ( '{' )
            {
            // InternalTestLanguage.g:352:1: ( '{' )
            // InternalTestLanguage.g:353:2: '{'
            {
             before(grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group__3__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__4"
    // InternalTestLanguage.g:362:1: rule__TypeDeclaration__Group__4 : rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 ;
    public final void rule__TypeDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:366:1: ( rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 )
            // InternalTestLanguage.g:367:2: rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__TypeDeclaration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__5();

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
    // $ANTLR end "rule__TypeDeclaration__Group__4"


    // $ANTLR start "rule__TypeDeclaration__Group__4__Impl"
    // InternalTestLanguage.g:374:1: rule__TypeDeclaration__Group__4__Impl : ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* ) ;
    public final void rule__TypeDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:378:1: ( ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* ) )
            // InternalTestLanguage.g:379:1: ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* )
            {
            // InternalTestLanguage.g:379:1: ( ( rule__TypeDeclaration__PropertiesAssignment_4 )* )
            // InternalTestLanguage.g:380:2: ( rule__TypeDeclaration__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getTypeDeclarationAccess().getPropertiesAssignment_4()); 
            // InternalTestLanguage.g:381:2: ( rule__TypeDeclaration__PropertiesAssignment_4 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||(LA5_0>=11 && LA5_0<=13)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalTestLanguage.g:381:3: rule__TypeDeclaration__PropertiesAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__TypeDeclaration__PropertiesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getTypeDeclarationAccess().getPropertiesAssignment_4()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group__4__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__5"
    // InternalTestLanguage.g:389:1: rule__TypeDeclaration__Group__5 : rule__TypeDeclaration__Group__5__Impl ;
    public final void rule__TypeDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:393:1: ( rule__TypeDeclaration__Group__5__Impl )
            // InternalTestLanguage.g:394:2: rule__TypeDeclaration__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group__5__Impl();

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
    // $ANTLR end "rule__TypeDeclaration__Group__5"


    // $ANTLR start "rule__TypeDeclaration__Group__5__Impl"
    // InternalTestLanguage.g:400:1: rule__TypeDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__TypeDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:404:1: ( ( '}' ) )
            // InternalTestLanguage.g:405:1: ( '}' )
            {
            // InternalTestLanguage.g:405:1: ( '}' )
            // InternalTestLanguage.g:406:2: '}'
            {
             before(grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group__5__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group_2__0"
    // InternalTestLanguage.g:416:1: rule__TypeDeclaration__Group_2__0 : rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 ;
    public final void rule__TypeDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:420:1: ( rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 )
            // InternalTestLanguage.g:421:2: rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__TypeDeclaration__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group_2__1();

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
    // $ANTLR end "rule__TypeDeclaration__Group_2__0"


    // $ANTLR start "rule__TypeDeclaration__Group_2__0__Impl"
    // InternalTestLanguage.g:428:1: rule__TypeDeclaration__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:432:1: ( ( 'extends' ) )
            // InternalTestLanguage.g:433:1: ( 'extends' )
            {
            // InternalTestLanguage.g:433:1: ( 'extends' )
            // InternalTestLanguage.g:434:2: 'extends'
            {
             before(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group_2__0__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group_2__1"
    // InternalTestLanguage.g:443:1: rule__TypeDeclaration__Group_2__1 : rule__TypeDeclaration__Group_2__1__Impl ;
    public final void rule__TypeDeclaration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:447:1: ( rule__TypeDeclaration__Group_2__1__Impl )
            // InternalTestLanguage.g:448:2: rule__TypeDeclaration__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__Group_2__1__Impl();

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
    // $ANTLR end "rule__TypeDeclaration__Group_2__1"


    // $ANTLR start "rule__TypeDeclaration__Group_2__1__Impl"
    // InternalTestLanguage.g:454:1: rule__TypeDeclaration__Group_2__1__Impl : ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) ;
    public final void rule__TypeDeclaration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:458:1: ( ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) )
            // InternalTestLanguage.g:459:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            {
            // InternalTestLanguage.g:459:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            // InternalTestLanguage.g:460:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); 
            // InternalTestLanguage.g:461:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            // InternalTestLanguage.g:461:3: rule__TypeDeclaration__SuperTypeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeDeclaration__SuperTypeAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); 

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
    // $ANTLR end "rule__TypeDeclaration__Group_2__1__Impl"


    // $ANTLR start "rule__Property__Group__0"
    // InternalTestLanguage.g:470:1: rule__Property__Group__0 : rule__Property__Group__0__Impl rule__Property__Group__1 ;
    public final void rule__Property__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:474:1: ( rule__Property__Group__0__Impl rule__Property__Group__1 )
            // InternalTestLanguage.g:475:2: rule__Property__Group__0__Impl rule__Property__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Property__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Property__Group__1();

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
    // $ANTLR end "rule__Property__Group__0"


    // $ANTLR start "rule__Property__Group__0__Impl"
    // InternalTestLanguage.g:482:1: rule__Property__Group__0__Impl : ( ( rule__Property__TypeAssignment_0 ) ) ;
    public final void rule__Property__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:486:1: ( ( ( rule__Property__TypeAssignment_0 ) ) )
            // InternalTestLanguage.g:487:1: ( ( rule__Property__TypeAssignment_0 ) )
            {
            // InternalTestLanguage.g:487:1: ( ( rule__Property__TypeAssignment_0 ) )
            // InternalTestLanguage.g:488:2: ( rule__Property__TypeAssignment_0 )
            {
             before(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 
            // InternalTestLanguage.g:489:2: ( rule__Property__TypeAssignment_0 )
            // InternalTestLanguage.g:489:3: rule__Property__TypeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Property__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 

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
    // $ANTLR end "rule__Property__Group__0__Impl"


    // $ANTLR start "rule__Property__Group__1"
    // InternalTestLanguage.g:497:1: rule__Property__Group__1 : rule__Property__Group__1__Impl ;
    public final void rule__Property__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:501:1: ( rule__Property__Group__1__Impl )
            // InternalTestLanguage.g:502:2: rule__Property__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Property__Group__1__Impl();

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
    // $ANTLR end "rule__Property__Group__1"


    // $ANTLR start "rule__Property__Group__1__Impl"
    // InternalTestLanguage.g:508:1: rule__Property__Group__1__Impl : ( ( rule__Property__NameAssignment_1 ) ) ;
    public final void rule__Property__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:512:1: ( ( ( rule__Property__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:513:1: ( ( rule__Property__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:513:1: ( ( rule__Property__NameAssignment_1 ) )
            // InternalTestLanguage.g:514:2: ( rule__Property__NameAssignment_1 )
            {
             before(grammarAccess.getPropertyAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:515:2: ( rule__Property__NameAssignment_1 )
            // InternalTestLanguage.g:515:3: rule__Property__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Property__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Property__Group__1__Impl"


    // $ANTLR start "rule__Type__Group__0"
    // InternalTestLanguage.g:524:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:528:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // InternalTestLanguage.g:529:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Type__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Type__Group__1();

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
    // $ANTLR end "rule__Type__Group__0"


    // $ANTLR start "rule__Type__Group__0__Impl"
    // InternalTestLanguage.g:536:1: rule__Type__Group__0__Impl : ( ( rule__Type__Alternatives_0 ) ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:540:1: ( ( ( rule__Type__Alternatives_0 ) ) )
            // InternalTestLanguage.g:541:1: ( ( rule__Type__Alternatives_0 ) )
            {
            // InternalTestLanguage.g:541:1: ( ( rule__Type__Alternatives_0 ) )
            // InternalTestLanguage.g:542:2: ( rule__Type__Alternatives_0 )
            {
             before(grammarAccess.getTypeAccess().getAlternatives_0()); 
            // InternalTestLanguage.g:543:2: ( rule__Type__Alternatives_0 )
            // InternalTestLanguage.g:543:3: rule__Type__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Type__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives_0()); 

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
    // $ANTLR end "rule__Type__Group__0__Impl"


    // $ANTLR start "rule__Type__Group__1"
    // InternalTestLanguage.g:551:1: rule__Type__Group__1 : rule__Type__Group__1__Impl ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:555:1: ( rule__Type__Group__1__Impl )
            // InternalTestLanguage.g:556:2: rule__Type__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Type__Group__1__Impl();

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
    // $ANTLR end "rule__Type__Group__1"


    // $ANTLR start "rule__Type__Group__1__Impl"
    // InternalTestLanguage.g:562:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )* ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:566:1: ( ( ( rule__Type__Group_1__0 )* ) )
            // InternalTestLanguage.g:567:1: ( ( rule__Type__Group_1__0 )* )
            {
            // InternalTestLanguage.g:567:1: ( ( rule__Type__Group_1__0 )* )
            // InternalTestLanguage.g:568:2: ( rule__Type__Group_1__0 )*
            {
             before(grammarAccess.getTypeAccess().getGroup_1()); 
            // InternalTestLanguage.g:569:2: ( rule__Type__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalTestLanguage.g:569:3: rule__Type__Group_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Type__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getTypeAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Type__Group__1__Impl"


    // $ANTLR start "rule__Type__Group_1__0"
    // InternalTestLanguage.g:578:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:582:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // InternalTestLanguage.g:583:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__Type__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Type__Group_1__1();

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
    // $ANTLR end "rule__Type__Group_1__0"


    // $ANTLR start "rule__Type__Group_1__0__Impl"
    // InternalTestLanguage.g:590:1: rule__Type__Group_1__0__Impl : ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:594:1: ( ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) ) )
            // InternalTestLanguage.g:595:1: ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) )
            {
            // InternalTestLanguage.g:595:1: ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) )
            // InternalTestLanguage.g:596:2: ( rule__Type__ArrayDiemensionsAssignment_1_0 )
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0()); 
            // InternalTestLanguage.g:597:2: ( rule__Type__ArrayDiemensionsAssignment_1_0 )
            // InternalTestLanguage.g:597:3: rule__Type__ArrayDiemensionsAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Type__ArrayDiemensionsAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0()); 

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
    // $ANTLR end "rule__Type__Group_1__0__Impl"


    // $ANTLR start "rule__Type__Group_1__1"
    // InternalTestLanguage.g:605:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:609:1: ( rule__Type__Group_1__1__Impl )
            // InternalTestLanguage.g:610:2: rule__Type__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Type__Group_1__1__Impl();

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
    // $ANTLR end "rule__Type__Group_1__1"


    // $ANTLR start "rule__Type__Group_1__1__Impl"
    // InternalTestLanguage.g:616:1: rule__Type__Group_1__1__Impl : ( ']' ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:620:1: ( ( ']' ) )
            // InternalTestLanguage.g:621:1: ( ']' )
            {
            // InternalTestLanguage.g:621:1: ( ']' )
            // InternalTestLanguage.g:622:2: ']'
            {
             before(grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1()); 

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
    // $ANTLR end "rule__Type__Group_1__1__Impl"


    // $ANTLR start "rule__Model__TypesAssignment"
    // InternalTestLanguage.g:632:1: rule__Model__TypesAssignment : ( ruleTypeDeclaration ) ;
    public final void rule__Model__TypesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:636:1: ( ( ruleTypeDeclaration ) )
            // InternalTestLanguage.g:637:2: ( ruleTypeDeclaration )
            {
            // InternalTestLanguage.g:637:2: ( ruleTypeDeclaration )
            // InternalTestLanguage.g:638:3: ruleTypeDeclaration
            {
             before(grammarAccess.getModelAccess().getTypesTypeDeclarationParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeDeclaration();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTypesTypeDeclarationParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__TypesAssignment"


    // $ANTLR start "rule__TypeDeclaration__NameAssignment_1"
    // InternalTestLanguage.g:647:1: rule__TypeDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TypeDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:651:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:652:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:652:2: ( RULE_ID )
            // InternalTestLanguage.g:653:3: RULE_ID
            {
             before(grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__TypeDeclaration__NameAssignment_1"


    // $ANTLR start "rule__TypeDeclaration__SuperTypeAssignment_2_1"
    // InternalTestLanguage.g:662:1: rule__TypeDeclaration__SuperTypeAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeDeclaration__SuperTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:666:1: ( ( ( RULE_ID ) ) )
            // InternalTestLanguage.g:667:2: ( ( RULE_ID ) )
            {
            // InternalTestLanguage.g:667:2: ( ( RULE_ID ) )
            // InternalTestLanguage.g:668:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); 
            // InternalTestLanguage.g:669:3: ( RULE_ID )
            // InternalTestLanguage.g:670:4: RULE_ID
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); 

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
    // $ANTLR end "rule__TypeDeclaration__SuperTypeAssignment_2_1"


    // $ANTLR start "rule__TypeDeclaration__PropertiesAssignment_4"
    // InternalTestLanguage.g:681:1: rule__TypeDeclaration__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__TypeDeclaration__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:685:1: ( ( ruleProperty ) )
            // InternalTestLanguage.g:686:2: ( ruleProperty )
            {
            // InternalTestLanguage.g:686:2: ( ruleProperty )
            // InternalTestLanguage.g:687:3: ruleProperty
            {
             before(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleProperty();

            state._fsp--;

             after(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__TypeDeclaration__PropertiesAssignment_4"


    // $ANTLR start "rule__Property__TypeAssignment_0"
    // InternalTestLanguage.g:696:1: rule__Property__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Property__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:700:1: ( ( ruleType ) )
            // InternalTestLanguage.g:701:2: ( ruleType )
            {
            // InternalTestLanguage.g:701:2: ( ruleType )
            // InternalTestLanguage.g:702:3: ruleType
            {
             before(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Property__TypeAssignment_0"


    // $ANTLR start "rule__Property__NameAssignment_1"
    // InternalTestLanguage.g:711:1: rule__Property__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Property__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:715:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:716:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:716:2: ( RULE_ID )
            // InternalTestLanguage.g:717:3: RULE_ID
            {
             before(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Property__NameAssignment_1"


    // $ANTLR start "rule__Type__ArrayDiemensionsAssignment_1_0"
    // InternalTestLanguage.g:726:1: rule__Type__ArrayDiemensionsAssignment_1_0 : ( ( '[' ) ) ;
    public final void rule__Type__ArrayDiemensionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:730:1: ( ( ( '[' ) ) )
            // InternalTestLanguage.g:731:2: ( ( '[' ) )
            {
            // InternalTestLanguage.g:731:2: ( ( '[' ) )
            // InternalTestLanguage.g:732:3: ( '[' )
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 
            // InternalTestLanguage.g:733:3: ( '[' )
            // InternalTestLanguage.g:734:4: '['
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 

            }

             after(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 

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
    // $ANTLR end "rule__Type__ArrayDiemensionsAssignment_1_0"


    // $ANTLR start "rule__TypeReference__TypeRefAssignment"
    // InternalTestLanguage.g:745:1: rule__TypeReference__TypeRefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__TypeReference__TypeRefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:749:1: ( ( ( RULE_ID ) ) )
            // InternalTestLanguage.g:750:2: ( ( RULE_ID ) )
            {
            // InternalTestLanguage.g:750:2: ( ( RULE_ID ) )
            // InternalTestLanguage.g:751:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0()); 
            // InternalTestLanguage.g:752:3: ( RULE_ID )
            // InternalTestLanguage.g:753:4: RULE_ID
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0()); 

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
    // $ANTLR end "rule__TypeReference__TypeRefAssignment"


    // $ANTLR start "rule__PrimitiveType__NameAssignment"
    // InternalTestLanguage.g:764:1: rule__PrimitiveType__NameAssignment : ( ( rule__PrimitiveType__NameAlternatives_0 ) ) ;
    public final void rule__PrimitiveType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:768:1: ( ( ( rule__PrimitiveType__NameAlternatives_0 ) ) )
            // InternalTestLanguage.g:769:2: ( ( rule__PrimitiveType__NameAlternatives_0 ) )
            {
            // InternalTestLanguage.g:769:2: ( ( rule__PrimitiveType__NameAlternatives_0 ) )
            // InternalTestLanguage.g:770:3: ( rule__PrimitiveType__NameAlternatives_0 )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0()); 
            // InternalTestLanguage.g:771:3: ( rule__PrimitiveType__NameAlternatives_0 )
            // InternalTestLanguage.g:771:4: rule__PrimitiveType__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveType__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0()); 

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
    // $ANTLR end "rule__PrimitiveType__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000013810L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000003812L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});

}