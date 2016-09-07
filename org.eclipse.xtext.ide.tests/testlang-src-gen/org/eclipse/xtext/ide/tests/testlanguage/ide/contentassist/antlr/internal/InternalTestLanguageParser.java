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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'string'", "'int'", "'boolean'", "'void'", "'type'", "'{'", "'}'", "'extends'", "']'", "'op'", "'('", "')'", "','", "':'", "'['"
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
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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

                if ( (LA1_0==15) ) {
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


    // $ANTLR start "entryRuleMember"
    // InternalTestLanguage.g:107:1: entryRuleMember : ruleMember EOF ;
    public final void entryRuleMember() throws RecognitionException {
        try {
            // InternalTestLanguage.g:108:1: ( ruleMember EOF )
            // InternalTestLanguage.g:109:1: ruleMember EOF
            {
             before(grammarAccess.getMemberRule()); 
            pushFollow(FOLLOW_1);
            ruleMember();

            state._fsp--;

             after(grammarAccess.getMemberRule()); 
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
    // $ANTLR end "entryRuleMember"


    // $ANTLR start "ruleMember"
    // InternalTestLanguage.g:116:1: ruleMember : ( ( rule__Member__Alternatives ) ) ;
    public final void ruleMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:120:2: ( ( ( rule__Member__Alternatives ) ) )
            // InternalTestLanguage.g:121:2: ( ( rule__Member__Alternatives ) )
            {
            // InternalTestLanguage.g:121:2: ( ( rule__Member__Alternatives ) )
            // InternalTestLanguage.g:122:3: ( rule__Member__Alternatives )
            {
             before(grammarAccess.getMemberAccess().getAlternatives()); 
            // InternalTestLanguage.g:123:3: ( rule__Member__Alternatives )
            // InternalTestLanguage.g:123:4: rule__Member__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Member__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMemberAccess().getAlternatives()); 

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
    // $ANTLR end "ruleMember"


    // $ANTLR start "entryRuleProperty"
    // InternalTestLanguage.g:132:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // InternalTestLanguage.g:133:1: ( ruleProperty EOF )
            // InternalTestLanguage.g:134:1: ruleProperty EOF
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
    // InternalTestLanguage.g:141:1: ruleProperty : ( ( rule__Property__Group__0 ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:145:2: ( ( ( rule__Property__Group__0 ) ) )
            // InternalTestLanguage.g:146:2: ( ( rule__Property__Group__0 ) )
            {
            // InternalTestLanguage.g:146:2: ( ( rule__Property__Group__0 ) )
            // InternalTestLanguage.g:147:3: ( rule__Property__Group__0 )
            {
             before(grammarAccess.getPropertyAccess().getGroup()); 
            // InternalTestLanguage.g:148:3: ( rule__Property__Group__0 )
            // InternalTestLanguage.g:148:4: rule__Property__Group__0
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
    // InternalTestLanguage.g:157:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalTestLanguage.g:158:1: ( ruleType EOF )
            // InternalTestLanguage.g:159:1: ruleType EOF
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
    // InternalTestLanguage.g:166:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:170:2: ( ( ( rule__Type__Group__0 ) ) )
            // InternalTestLanguage.g:171:2: ( ( rule__Type__Group__0 ) )
            {
            // InternalTestLanguage.g:171:2: ( ( rule__Type__Group__0 ) )
            // InternalTestLanguage.g:172:3: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // InternalTestLanguage.g:173:3: ( rule__Type__Group__0 )
            // InternalTestLanguage.g:173:4: rule__Type__Group__0
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


    // $ANTLR start "entryRuleOperation"
    // InternalTestLanguage.g:182:1: entryRuleOperation : ruleOperation EOF ;
    public final void entryRuleOperation() throws RecognitionException {
        try {
            // InternalTestLanguage.g:183:1: ( ruleOperation EOF )
            // InternalTestLanguage.g:184:1: ruleOperation EOF
            {
             before(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            ruleOperation();

            state._fsp--;

             after(grammarAccess.getOperationRule()); 
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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalTestLanguage.g:191:1: ruleOperation : ( ( rule__Operation__Group__0 ) ) ;
    public final void ruleOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:195:2: ( ( ( rule__Operation__Group__0 ) ) )
            // InternalTestLanguage.g:196:2: ( ( rule__Operation__Group__0 ) )
            {
            // InternalTestLanguage.g:196:2: ( ( rule__Operation__Group__0 ) )
            // InternalTestLanguage.g:197:3: ( rule__Operation__Group__0 )
            {
             before(grammarAccess.getOperationAccess().getGroup()); 
            // InternalTestLanguage.g:198:3: ( rule__Operation__Group__0 )
            // InternalTestLanguage.g:198:4: rule__Operation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Operation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperationAccess().getGroup()); 

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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleOperationCall"
    // InternalTestLanguage.g:207:1: entryRuleOperationCall : ruleOperationCall EOF ;
    public final void entryRuleOperationCall() throws RecognitionException {
        try {
            // InternalTestLanguage.g:208:1: ( ruleOperationCall EOF )
            // InternalTestLanguage.g:209:1: ruleOperationCall EOF
            {
             before(grammarAccess.getOperationCallRule()); 
            pushFollow(FOLLOW_1);
            ruleOperationCall();

            state._fsp--;

             after(grammarAccess.getOperationCallRule()); 
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
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // InternalTestLanguage.g:216:1: ruleOperationCall : ( ( rule__OperationCall__Group__0 ) ) ;
    public final void ruleOperationCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:220:2: ( ( ( rule__OperationCall__Group__0 ) ) )
            // InternalTestLanguage.g:221:2: ( ( rule__OperationCall__Group__0 ) )
            {
            // InternalTestLanguage.g:221:2: ( ( rule__OperationCall__Group__0 ) )
            // InternalTestLanguage.g:222:3: ( rule__OperationCall__Group__0 )
            {
             before(grammarAccess.getOperationCallAccess().getGroup()); 
            // InternalTestLanguage.g:223:3: ( rule__OperationCall__Group__0 )
            // InternalTestLanguage.g:223:4: rule__OperationCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getGroup()); 

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
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleParameter"
    // InternalTestLanguage.g:232:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalTestLanguage.g:233:1: ( ruleParameter EOF )
            // InternalTestLanguage.g:234:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalTestLanguage.g:241:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:245:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalTestLanguage.g:246:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalTestLanguage.g:246:2: ( ( rule__Parameter__Group__0 ) )
            // InternalTestLanguage.g:247:3: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // InternalTestLanguage.g:248:3: ( rule__Parameter__Group__0 )
            // InternalTestLanguage.g:248:4: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getGroup()); 

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeReference"
    // InternalTestLanguage.g:257:1: entryRuleTypeReference : ruleTypeReference EOF ;
    public final void entryRuleTypeReference() throws RecognitionException {
        try {
            // InternalTestLanguage.g:258:1: ( ruleTypeReference EOF )
            // InternalTestLanguage.g:259:1: ruleTypeReference EOF
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
    // InternalTestLanguage.g:266:1: ruleTypeReference : ( ( rule__TypeReference__TypeRefAssignment ) ) ;
    public final void ruleTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:270:2: ( ( ( rule__TypeReference__TypeRefAssignment ) ) )
            // InternalTestLanguage.g:271:2: ( ( rule__TypeReference__TypeRefAssignment ) )
            {
            // InternalTestLanguage.g:271:2: ( ( rule__TypeReference__TypeRefAssignment ) )
            // InternalTestLanguage.g:272:3: ( rule__TypeReference__TypeRefAssignment )
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment()); 
            // InternalTestLanguage.g:273:3: ( rule__TypeReference__TypeRefAssignment )
            // InternalTestLanguage.g:273:4: rule__TypeReference__TypeRefAssignment
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
    // InternalTestLanguage.g:282:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalTestLanguage.g:283:1: ( rulePrimitiveType EOF )
            // InternalTestLanguage.g:284:1: rulePrimitiveType EOF
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
    // InternalTestLanguage.g:291:1: rulePrimitiveType : ( ( rule__PrimitiveType__NameAssignment ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:295:2: ( ( ( rule__PrimitiveType__NameAssignment ) ) )
            // InternalTestLanguage.g:296:2: ( ( rule__PrimitiveType__NameAssignment ) )
            {
            // InternalTestLanguage.g:296:2: ( ( rule__PrimitiveType__NameAssignment ) )
            // InternalTestLanguage.g:297:3: ( rule__PrimitiveType__NameAssignment )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAssignment()); 
            // InternalTestLanguage.g:298:3: ( rule__PrimitiveType__NameAssignment )
            // InternalTestLanguage.g:298:4: rule__PrimitiveType__NameAssignment
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


    // $ANTLR start "rule__Member__Alternatives"
    // InternalTestLanguage.g:306:1: rule__Member__Alternatives : ( ( ruleProperty ) | ( ruleOperation ) );
    public final void rule__Member__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:310:1: ( ( ruleProperty ) | ( ruleOperation ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||(LA2_0>=11 && LA2_0<=14)) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:311:2: ( ruleProperty )
                    {
                    // InternalTestLanguage.g:311:2: ( ruleProperty )
                    // InternalTestLanguage.g:312:3: ruleProperty
                    {
                     before(grammarAccess.getMemberAccess().getPropertyParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleProperty();

                    state._fsp--;

                     after(grammarAccess.getMemberAccess().getPropertyParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:317:2: ( ruleOperation )
                    {
                    // InternalTestLanguage.g:317:2: ( ruleOperation )
                    // InternalTestLanguage.g:318:3: ruleOperation
                    {
                     before(grammarAccess.getMemberAccess().getOperationParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOperation();

                    state._fsp--;

                     after(grammarAccess.getMemberAccess().getOperationParserRuleCall_1()); 

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
    // $ANTLR end "rule__Member__Alternatives"


    // $ANTLR start "rule__Type__Alternatives_0"
    // InternalTestLanguage.g:327:1: rule__Type__Alternatives_0 : ( ( ruleTypeReference ) | ( rulePrimitiveType ) );
    public final void rule__Type__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:331:1: ( ( ruleTypeReference ) | ( rulePrimitiveType ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=11 && LA3_0<=14)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTestLanguage.g:332:2: ( ruleTypeReference )
                    {
                    // InternalTestLanguage.g:332:2: ( ruleTypeReference )
                    // InternalTestLanguage.g:333:3: ruleTypeReference
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
                    // InternalTestLanguage.g:338:2: ( rulePrimitiveType )
                    {
                    // InternalTestLanguage.g:338:2: ( rulePrimitiveType )
                    // InternalTestLanguage.g:339:3: rulePrimitiveType
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
    // InternalTestLanguage.g:348:1: rule__PrimitiveType__NameAlternatives_0 : ( ( 'string' ) | ( 'int' ) | ( 'boolean' ) | ( 'void' ) );
    public final void rule__PrimitiveType__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:352:1: ( ( 'string' ) | ( 'int' ) | ( 'boolean' ) | ( 'void' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            case 14:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalTestLanguage.g:353:2: ( 'string' )
                    {
                    // InternalTestLanguage.g:353:2: ( 'string' )
                    // InternalTestLanguage.g:354:3: 'string'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:359:2: ( 'int' )
                    {
                    // InternalTestLanguage.g:359:2: ( 'int' )
                    // InternalTestLanguage.g:360:3: 'int'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTestLanguage.g:365:2: ( 'boolean' )
                    {
                    // InternalTestLanguage.g:365:2: ( 'boolean' )
                    // InternalTestLanguage.g:366:3: 'boolean'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTestLanguage.g:371:2: ( 'void' )
                    {
                    // InternalTestLanguage.g:371:2: ( 'void' )
                    // InternalTestLanguage.g:372:3: 'void'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameVoidKeyword_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameVoidKeyword_0_3()); 

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
    // InternalTestLanguage.g:381:1: rule__TypeDeclaration__Group__0 : rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 ;
    public final void rule__TypeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:385:1: ( rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 )
            // InternalTestLanguage.g:386:2: rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1
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
    // InternalTestLanguage.g:393:1: rule__TypeDeclaration__Group__0__Impl : ( 'type' ) ;
    public final void rule__TypeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:397:1: ( ( 'type' ) )
            // InternalTestLanguage.g:398:1: ( 'type' )
            {
            // InternalTestLanguage.g:398:1: ( 'type' )
            // InternalTestLanguage.g:399:2: 'type'
            {
             before(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalTestLanguage.g:408:1: rule__TypeDeclaration__Group__1 : rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 ;
    public final void rule__TypeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:412:1: ( rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 )
            // InternalTestLanguage.g:413:2: rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2
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
    // InternalTestLanguage.g:420:1: rule__TypeDeclaration__Group__1__Impl : ( ( rule__TypeDeclaration__NameAssignment_1 ) ) ;
    public final void rule__TypeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:424:1: ( ( ( rule__TypeDeclaration__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:425:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:425:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            // InternalTestLanguage.g:426:2: ( rule__TypeDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:427:2: ( rule__TypeDeclaration__NameAssignment_1 )
            // InternalTestLanguage.g:427:3: rule__TypeDeclaration__NameAssignment_1
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
    // InternalTestLanguage.g:435:1: rule__TypeDeclaration__Group__2 : rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 ;
    public final void rule__TypeDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:439:1: ( rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 )
            // InternalTestLanguage.g:440:2: rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3
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
    // InternalTestLanguage.g:447:1: rule__TypeDeclaration__Group__2__Impl : ( ( rule__TypeDeclaration__Group_2__0 )? ) ;
    public final void rule__TypeDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:451:1: ( ( ( rule__TypeDeclaration__Group_2__0 )? ) )
            // InternalTestLanguage.g:452:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            {
            // InternalTestLanguage.g:452:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            // InternalTestLanguage.g:453:2: ( rule__TypeDeclaration__Group_2__0 )?
            {
             before(grammarAccess.getTypeDeclarationAccess().getGroup_2()); 
            // InternalTestLanguage.g:454:2: ( rule__TypeDeclaration__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTestLanguage.g:454:3: rule__TypeDeclaration__Group_2__0
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
    // InternalTestLanguage.g:462:1: rule__TypeDeclaration__Group__3 : rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 ;
    public final void rule__TypeDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:466:1: ( rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 )
            // InternalTestLanguage.g:467:2: rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4
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
    // InternalTestLanguage.g:474:1: rule__TypeDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__TypeDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:478:1: ( ( '{' ) )
            // InternalTestLanguage.g:479:1: ( '{' )
            {
            // InternalTestLanguage.g:479:1: ( '{' )
            // InternalTestLanguage.g:480:2: '{'
            {
             before(grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,16,FOLLOW_2); 
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
    // InternalTestLanguage.g:489:1: rule__TypeDeclaration__Group__4 : rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 ;
    public final void rule__TypeDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:493:1: ( rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 )
            // InternalTestLanguage.g:494:2: rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5
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
    // InternalTestLanguage.g:501:1: rule__TypeDeclaration__Group__4__Impl : ( ( rule__TypeDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__TypeDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:505:1: ( ( ( rule__TypeDeclaration__MembersAssignment_4 )* ) )
            // InternalTestLanguage.g:506:1: ( ( rule__TypeDeclaration__MembersAssignment_4 )* )
            {
            // InternalTestLanguage.g:506:1: ( ( rule__TypeDeclaration__MembersAssignment_4 )* )
            // InternalTestLanguage.g:507:2: ( rule__TypeDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getTypeDeclarationAccess().getMembersAssignment_4()); 
            // InternalTestLanguage.g:508:2: ( rule__TypeDeclaration__MembersAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=11 && LA6_0<=14)||LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalTestLanguage.g:508:3: rule__TypeDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__TypeDeclaration__MembersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getTypeDeclarationAccess().getMembersAssignment_4()); 

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
    // InternalTestLanguage.g:516:1: rule__TypeDeclaration__Group__5 : rule__TypeDeclaration__Group__5__Impl ;
    public final void rule__TypeDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:520:1: ( rule__TypeDeclaration__Group__5__Impl )
            // InternalTestLanguage.g:521:2: rule__TypeDeclaration__Group__5__Impl
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
    // InternalTestLanguage.g:527:1: rule__TypeDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__TypeDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:531:1: ( ( '}' ) )
            // InternalTestLanguage.g:532:1: ( '}' )
            {
            // InternalTestLanguage.g:532:1: ( '}' )
            // InternalTestLanguage.g:533:2: '}'
            {
             before(grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,17,FOLLOW_2); 
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
    // InternalTestLanguage.g:543:1: rule__TypeDeclaration__Group_2__0 : rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 ;
    public final void rule__TypeDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:547:1: ( rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 )
            // InternalTestLanguage.g:548:2: rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1
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
    // InternalTestLanguage.g:555:1: rule__TypeDeclaration__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:559:1: ( ( 'extends' ) )
            // InternalTestLanguage.g:560:1: ( 'extends' )
            {
            // InternalTestLanguage.g:560:1: ( 'extends' )
            // InternalTestLanguage.g:561:2: 'extends'
            {
             before(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalTestLanguage.g:570:1: rule__TypeDeclaration__Group_2__1 : rule__TypeDeclaration__Group_2__1__Impl ;
    public final void rule__TypeDeclaration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:574:1: ( rule__TypeDeclaration__Group_2__1__Impl )
            // InternalTestLanguage.g:575:2: rule__TypeDeclaration__Group_2__1__Impl
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
    // InternalTestLanguage.g:581:1: rule__TypeDeclaration__Group_2__1__Impl : ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) ;
    public final void rule__TypeDeclaration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:585:1: ( ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) )
            // InternalTestLanguage.g:586:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            {
            // InternalTestLanguage.g:586:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            // InternalTestLanguage.g:587:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); 
            // InternalTestLanguage.g:588:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            // InternalTestLanguage.g:588:3: rule__TypeDeclaration__SuperTypeAssignment_2_1
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
    // InternalTestLanguage.g:597:1: rule__Property__Group__0 : rule__Property__Group__0__Impl rule__Property__Group__1 ;
    public final void rule__Property__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:601:1: ( rule__Property__Group__0__Impl rule__Property__Group__1 )
            // InternalTestLanguage.g:602:2: rule__Property__Group__0__Impl rule__Property__Group__1
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
    // InternalTestLanguage.g:609:1: rule__Property__Group__0__Impl : ( ( rule__Property__TypeAssignment_0 ) ) ;
    public final void rule__Property__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:613:1: ( ( ( rule__Property__TypeAssignment_0 ) ) )
            // InternalTestLanguage.g:614:1: ( ( rule__Property__TypeAssignment_0 ) )
            {
            // InternalTestLanguage.g:614:1: ( ( rule__Property__TypeAssignment_0 ) )
            // InternalTestLanguage.g:615:2: ( rule__Property__TypeAssignment_0 )
            {
             before(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 
            // InternalTestLanguage.g:616:2: ( rule__Property__TypeAssignment_0 )
            // InternalTestLanguage.g:616:3: rule__Property__TypeAssignment_0
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
    // InternalTestLanguage.g:624:1: rule__Property__Group__1 : rule__Property__Group__1__Impl ;
    public final void rule__Property__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:628:1: ( rule__Property__Group__1__Impl )
            // InternalTestLanguage.g:629:2: rule__Property__Group__1__Impl
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
    // InternalTestLanguage.g:635:1: rule__Property__Group__1__Impl : ( ( rule__Property__NameAssignment_1 ) ) ;
    public final void rule__Property__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:639:1: ( ( ( rule__Property__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:640:1: ( ( rule__Property__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:640:1: ( ( rule__Property__NameAssignment_1 ) )
            // InternalTestLanguage.g:641:2: ( rule__Property__NameAssignment_1 )
            {
             before(grammarAccess.getPropertyAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:642:2: ( rule__Property__NameAssignment_1 )
            // InternalTestLanguage.g:642:3: rule__Property__NameAssignment_1
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
    // InternalTestLanguage.g:651:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:655:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // InternalTestLanguage.g:656:2: rule__Type__Group__0__Impl rule__Type__Group__1
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
    // InternalTestLanguage.g:663:1: rule__Type__Group__0__Impl : ( ( rule__Type__Alternatives_0 ) ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:667:1: ( ( ( rule__Type__Alternatives_0 ) ) )
            // InternalTestLanguage.g:668:1: ( ( rule__Type__Alternatives_0 ) )
            {
            // InternalTestLanguage.g:668:1: ( ( rule__Type__Alternatives_0 ) )
            // InternalTestLanguage.g:669:2: ( rule__Type__Alternatives_0 )
            {
             before(grammarAccess.getTypeAccess().getAlternatives_0()); 
            // InternalTestLanguage.g:670:2: ( rule__Type__Alternatives_0 )
            // InternalTestLanguage.g:670:3: rule__Type__Alternatives_0
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
    // InternalTestLanguage.g:678:1: rule__Type__Group__1 : rule__Type__Group__1__Impl ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:682:1: ( rule__Type__Group__1__Impl )
            // InternalTestLanguage.g:683:2: rule__Type__Group__1__Impl
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
    // InternalTestLanguage.g:689:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )* ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:693:1: ( ( ( rule__Type__Group_1__0 )* ) )
            // InternalTestLanguage.g:694:1: ( ( rule__Type__Group_1__0 )* )
            {
            // InternalTestLanguage.g:694:1: ( ( rule__Type__Group_1__0 )* )
            // InternalTestLanguage.g:695:2: ( rule__Type__Group_1__0 )*
            {
             before(grammarAccess.getTypeAccess().getGroup_1()); 
            // InternalTestLanguage.g:696:2: ( rule__Type__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==25) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalTestLanguage.g:696:3: rule__Type__Group_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Type__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalTestLanguage.g:705:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:709:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // InternalTestLanguage.g:710:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
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
    // InternalTestLanguage.g:717:1: rule__Type__Group_1__0__Impl : ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:721:1: ( ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) ) )
            // InternalTestLanguage.g:722:1: ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) )
            {
            // InternalTestLanguage.g:722:1: ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) )
            // InternalTestLanguage.g:723:2: ( rule__Type__ArrayDiemensionsAssignment_1_0 )
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0()); 
            // InternalTestLanguage.g:724:2: ( rule__Type__ArrayDiemensionsAssignment_1_0 )
            // InternalTestLanguage.g:724:3: rule__Type__ArrayDiemensionsAssignment_1_0
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
    // InternalTestLanguage.g:732:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:736:1: ( rule__Type__Group_1__1__Impl )
            // InternalTestLanguage.g:737:2: rule__Type__Group_1__1__Impl
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
    // InternalTestLanguage.g:743:1: rule__Type__Group_1__1__Impl : ( ']' ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:747:1: ( ( ']' ) )
            // InternalTestLanguage.g:748:1: ( ']' )
            {
            // InternalTestLanguage.g:748:1: ( ']' )
            // InternalTestLanguage.g:749:2: ']'
            {
             before(grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1()); 
            match(input,19,FOLLOW_2); 
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


    // $ANTLR start "rule__Operation__Group__0"
    // InternalTestLanguage.g:759:1: rule__Operation__Group__0 : rule__Operation__Group__0__Impl rule__Operation__Group__1 ;
    public final void rule__Operation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:763:1: ( rule__Operation__Group__0__Impl rule__Operation__Group__1 )
            // InternalTestLanguage.g:764:2: rule__Operation__Group__0__Impl rule__Operation__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__Operation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__1();

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
    // $ANTLR end "rule__Operation__Group__0"


    // $ANTLR start "rule__Operation__Group__0__Impl"
    // InternalTestLanguage.g:771:1: rule__Operation__Group__0__Impl : ( () ) ;
    public final void rule__Operation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:775:1: ( ( () ) )
            // InternalTestLanguage.g:776:1: ( () )
            {
            // InternalTestLanguage.g:776:1: ( () )
            // InternalTestLanguage.g:777:2: ()
            {
             before(grammarAccess.getOperationAccess().getOperationAction_0()); 
            // InternalTestLanguage.g:778:2: ()
            // InternalTestLanguage.g:778:3: 
            {
            }

             after(grammarAccess.getOperationAccess().getOperationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operation__Group__0__Impl"


    // $ANTLR start "rule__Operation__Group__1"
    // InternalTestLanguage.g:786:1: rule__Operation__Group__1 : rule__Operation__Group__1__Impl rule__Operation__Group__2 ;
    public final void rule__Operation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:790:1: ( rule__Operation__Group__1__Impl rule__Operation__Group__2 )
            // InternalTestLanguage.g:791:2: rule__Operation__Group__1__Impl rule__Operation__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Operation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__2();

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
    // $ANTLR end "rule__Operation__Group__1"


    // $ANTLR start "rule__Operation__Group__1__Impl"
    // InternalTestLanguage.g:798:1: rule__Operation__Group__1__Impl : ( 'op' ) ;
    public final void rule__Operation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:802:1: ( ( 'op' ) )
            // InternalTestLanguage.g:803:1: ( 'op' )
            {
            // InternalTestLanguage.g:803:1: ( 'op' )
            // InternalTestLanguage.g:804:2: 'op'
            {
             before(grammarAccess.getOperationAccess().getOpKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getOpKeyword_1()); 

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
    // $ANTLR end "rule__Operation__Group__1__Impl"


    // $ANTLR start "rule__Operation__Group__2"
    // InternalTestLanguage.g:813:1: rule__Operation__Group__2 : rule__Operation__Group__2__Impl rule__Operation__Group__3 ;
    public final void rule__Operation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:817:1: ( rule__Operation__Group__2__Impl rule__Operation__Group__3 )
            // InternalTestLanguage.g:818:2: rule__Operation__Group__2__Impl rule__Operation__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__Operation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__3();

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
    // $ANTLR end "rule__Operation__Group__2"


    // $ANTLR start "rule__Operation__Group__2__Impl"
    // InternalTestLanguage.g:825:1: rule__Operation__Group__2__Impl : ( ( rule__Operation__NameAssignment_2 ) ) ;
    public final void rule__Operation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:829:1: ( ( ( rule__Operation__NameAssignment_2 ) ) )
            // InternalTestLanguage.g:830:1: ( ( rule__Operation__NameAssignment_2 ) )
            {
            // InternalTestLanguage.g:830:1: ( ( rule__Operation__NameAssignment_2 ) )
            // InternalTestLanguage.g:831:2: ( rule__Operation__NameAssignment_2 )
            {
             before(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            // InternalTestLanguage.g:832:2: ( rule__Operation__NameAssignment_2 )
            // InternalTestLanguage.g:832:3: rule__Operation__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Operation__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOperationAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Operation__Group__2__Impl"


    // $ANTLR start "rule__Operation__Group__3"
    // InternalTestLanguage.g:840:1: rule__Operation__Group__3 : rule__Operation__Group__3__Impl rule__Operation__Group__4 ;
    public final void rule__Operation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:844:1: ( rule__Operation__Group__3__Impl rule__Operation__Group__4 )
            // InternalTestLanguage.g:845:2: rule__Operation__Group__3__Impl rule__Operation__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__Operation__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__4();

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
    // $ANTLR end "rule__Operation__Group__3"


    // $ANTLR start "rule__Operation__Group__3__Impl"
    // InternalTestLanguage.g:852:1: rule__Operation__Group__3__Impl : ( '(' ) ;
    public final void rule__Operation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:856:1: ( ( '(' ) )
            // InternalTestLanguage.g:857:1: ( '(' )
            {
            // InternalTestLanguage.g:857:1: ( '(' )
            // InternalTestLanguage.g:858:2: '('
            {
             before(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__Operation__Group__3__Impl"


    // $ANTLR start "rule__Operation__Group__4"
    // InternalTestLanguage.g:867:1: rule__Operation__Group__4 : rule__Operation__Group__4__Impl rule__Operation__Group__5 ;
    public final void rule__Operation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:871:1: ( rule__Operation__Group__4__Impl rule__Operation__Group__5 )
            // InternalTestLanguage.g:872:2: rule__Operation__Group__4__Impl rule__Operation__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__Operation__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__5();

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
    // $ANTLR end "rule__Operation__Group__4"


    // $ANTLR start "rule__Operation__Group__4__Impl"
    // InternalTestLanguage.g:879:1: rule__Operation__Group__4__Impl : ( ( rule__Operation__Group_4__0 )? ) ;
    public final void rule__Operation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:883:1: ( ( ( rule__Operation__Group_4__0 )? ) )
            // InternalTestLanguage.g:884:1: ( ( rule__Operation__Group_4__0 )? )
            {
            // InternalTestLanguage.g:884:1: ( ( rule__Operation__Group_4__0 )? )
            // InternalTestLanguage.g:885:2: ( rule__Operation__Group_4__0 )?
            {
             before(grammarAccess.getOperationAccess().getGroup_4()); 
            // InternalTestLanguage.g:886:2: ( rule__Operation__Group_4__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalTestLanguage.g:886:3: rule__Operation__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operation__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationAccess().getGroup_4()); 

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
    // $ANTLR end "rule__Operation__Group__4__Impl"


    // $ANTLR start "rule__Operation__Group__5"
    // InternalTestLanguage.g:894:1: rule__Operation__Group__5 : rule__Operation__Group__5__Impl rule__Operation__Group__6 ;
    public final void rule__Operation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:898:1: ( rule__Operation__Group__5__Impl rule__Operation__Group__6 )
            // InternalTestLanguage.g:899:2: rule__Operation__Group__5__Impl rule__Operation__Group__6
            {
            pushFollow(FOLLOW_14);
            rule__Operation__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__6();

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
    // $ANTLR end "rule__Operation__Group__5"


    // $ANTLR start "rule__Operation__Group__5__Impl"
    // InternalTestLanguage.g:906:1: rule__Operation__Group__5__Impl : ( ')' ) ;
    public final void rule__Operation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:910:1: ( ( ')' ) )
            // InternalTestLanguage.g:911:1: ( ')' )
            {
            // InternalTestLanguage.g:911:1: ( ')' )
            // InternalTestLanguage.g:912:2: ')'
            {
             before(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); 

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
    // $ANTLR end "rule__Operation__Group__5__Impl"


    // $ANTLR start "rule__Operation__Group__6"
    // InternalTestLanguage.g:921:1: rule__Operation__Group__6 : rule__Operation__Group__6__Impl rule__Operation__Group__7 ;
    public final void rule__Operation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:925:1: ( rule__Operation__Group__6__Impl rule__Operation__Group__7 )
            // InternalTestLanguage.g:926:2: rule__Operation__Group__6__Impl rule__Operation__Group__7
            {
            pushFollow(FOLLOW_14);
            rule__Operation__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__7();

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
    // $ANTLR end "rule__Operation__Group__6"


    // $ANTLR start "rule__Operation__Group__6__Impl"
    // InternalTestLanguage.g:933:1: rule__Operation__Group__6__Impl : ( ( rule__Operation__Group_6__0 )? ) ;
    public final void rule__Operation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:937:1: ( ( ( rule__Operation__Group_6__0 )? ) )
            // InternalTestLanguage.g:938:1: ( ( rule__Operation__Group_6__0 )? )
            {
            // InternalTestLanguage.g:938:1: ( ( rule__Operation__Group_6__0 )? )
            // InternalTestLanguage.g:939:2: ( rule__Operation__Group_6__0 )?
            {
             before(grammarAccess.getOperationAccess().getGroup_6()); 
            // InternalTestLanguage.g:940:2: ( rule__Operation__Group_6__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTestLanguage.g:940:3: rule__Operation__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operation__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationAccess().getGroup_6()); 

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
    // $ANTLR end "rule__Operation__Group__6__Impl"


    // $ANTLR start "rule__Operation__Group__7"
    // InternalTestLanguage.g:948:1: rule__Operation__Group__7 : rule__Operation__Group__7__Impl rule__Operation__Group__8 ;
    public final void rule__Operation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:952:1: ( rule__Operation__Group__7__Impl rule__Operation__Group__8 )
            // InternalTestLanguage.g:953:2: rule__Operation__Group__7__Impl rule__Operation__Group__8
            {
            pushFollow(FOLLOW_15);
            rule__Operation__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__8();

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
    // $ANTLR end "rule__Operation__Group__7"


    // $ANTLR start "rule__Operation__Group__7__Impl"
    // InternalTestLanguage.g:960:1: rule__Operation__Group__7__Impl : ( '{' ) ;
    public final void rule__Operation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:964:1: ( ( '{' ) )
            // InternalTestLanguage.g:965:1: ( '{' )
            {
            // InternalTestLanguage.g:965:1: ( '{' )
            // InternalTestLanguage.g:966:2: '{'
            {
             before(grammarAccess.getOperationAccess().getLeftCurlyBracketKeyword_7()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getLeftCurlyBracketKeyword_7()); 

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
    // $ANTLR end "rule__Operation__Group__7__Impl"


    // $ANTLR start "rule__Operation__Group__8"
    // InternalTestLanguage.g:975:1: rule__Operation__Group__8 : rule__Operation__Group__8__Impl rule__Operation__Group__9 ;
    public final void rule__Operation__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:979:1: ( rule__Operation__Group__8__Impl rule__Operation__Group__9 )
            // InternalTestLanguage.g:980:2: rule__Operation__Group__8__Impl rule__Operation__Group__9
            {
            pushFollow(FOLLOW_15);
            rule__Operation__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group__9();

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
    // $ANTLR end "rule__Operation__Group__8"


    // $ANTLR start "rule__Operation__Group__8__Impl"
    // InternalTestLanguage.g:987:1: rule__Operation__Group__8__Impl : ( ( rule__Operation__OperationCallAssignment_8 )? ) ;
    public final void rule__Operation__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:991:1: ( ( ( rule__Operation__OperationCallAssignment_8 )? ) )
            // InternalTestLanguage.g:992:1: ( ( rule__Operation__OperationCallAssignment_8 )? )
            {
            // InternalTestLanguage.g:992:1: ( ( rule__Operation__OperationCallAssignment_8 )? )
            // InternalTestLanguage.g:993:2: ( rule__Operation__OperationCallAssignment_8 )?
            {
             before(grammarAccess.getOperationAccess().getOperationCallAssignment_8()); 
            // InternalTestLanguage.g:994:2: ( rule__Operation__OperationCallAssignment_8 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTestLanguage.g:994:3: rule__Operation__OperationCallAssignment_8
                    {
                    pushFollow(FOLLOW_2);
                    rule__Operation__OperationCallAssignment_8();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationAccess().getOperationCallAssignment_8()); 

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
    // $ANTLR end "rule__Operation__Group__8__Impl"


    // $ANTLR start "rule__Operation__Group__9"
    // InternalTestLanguage.g:1002:1: rule__Operation__Group__9 : rule__Operation__Group__9__Impl ;
    public final void rule__Operation__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1006:1: ( rule__Operation__Group__9__Impl )
            // InternalTestLanguage.g:1007:2: rule__Operation__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operation__Group__9__Impl();

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
    // $ANTLR end "rule__Operation__Group__9"


    // $ANTLR start "rule__Operation__Group__9__Impl"
    // InternalTestLanguage.g:1013:1: rule__Operation__Group__9__Impl : ( '}' ) ;
    public final void rule__Operation__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1017:1: ( ( '}' ) )
            // InternalTestLanguage.g:1018:1: ( '}' )
            {
            // InternalTestLanguage.g:1018:1: ( '}' )
            // InternalTestLanguage.g:1019:2: '}'
            {
             before(grammarAccess.getOperationAccess().getRightCurlyBracketKeyword_9()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getRightCurlyBracketKeyword_9()); 

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
    // $ANTLR end "rule__Operation__Group__9__Impl"


    // $ANTLR start "rule__Operation__Group_4__0"
    // InternalTestLanguage.g:1029:1: rule__Operation__Group_4__0 : rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1 ;
    public final void rule__Operation__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1033:1: ( rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1 )
            // InternalTestLanguage.g:1034:2: rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1
            {
            pushFollow(FOLLOW_16);
            rule__Operation__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group_4__1();

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
    // $ANTLR end "rule__Operation__Group_4__0"


    // $ANTLR start "rule__Operation__Group_4__0__Impl"
    // InternalTestLanguage.g:1041:1: rule__Operation__Group_4__0__Impl : ( ( rule__Operation__ParamsAssignment_4_0 ) ) ;
    public final void rule__Operation__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1045:1: ( ( ( rule__Operation__ParamsAssignment_4_0 ) ) )
            // InternalTestLanguage.g:1046:1: ( ( rule__Operation__ParamsAssignment_4_0 ) )
            {
            // InternalTestLanguage.g:1046:1: ( ( rule__Operation__ParamsAssignment_4_0 ) )
            // InternalTestLanguage.g:1047:2: ( rule__Operation__ParamsAssignment_4_0 )
            {
             before(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); 
            // InternalTestLanguage.g:1048:2: ( rule__Operation__ParamsAssignment_4_0 )
            // InternalTestLanguage.g:1048:3: rule__Operation__ParamsAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__Operation__ParamsAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); 

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
    // $ANTLR end "rule__Operation__Group_4__0__Impl"


    // $ANTLR start "rule__Operation__Group_4__1"
    // InternalTestLanguage.g:1056:1: rule__Operation__Group_4__1 : rule__Operation__Group_4__1__Impl ;
    public final void rule__Operation__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1060:1: ( rule__Operation__Group_4__1__Impl )
            // InternalTestLanguage.g:1061:2: rule__Operation__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operation__Group_4__1__Impl();

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
    // $ANTLR end "rule__Operation__Group_4__1"


    // $ANTLR start "rule__Operation__Group_4__1__Impl"
    // InternalTestLanguage.g:1067:1: rule__Operation__Group_4__1__Impl : ( ( rule__Operation__Group_4_1__0 )* ) ;
    public final void rule__Operation__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1071:1: ( ( ( rule__Operation__Group_4_1__0 )* ) )
            // InternalTestLanguage.g:1072:1: ( ( rule__Operation__Group_4_1__0 )* )
            {
            // InternalTestLanguage.g:1072:1: ( ( rule__Operation__Group_4_1__0 )* )
            // InternalTestLanguage.g:1073:2: ( rule__Operation__Group_4_1__0 )*
            {
             before(grammarAccess.getOperationAccess().getGroup_4_1()); 
            // InternalTestLanguage.g:1074:2: ( rule__Operation__Group_4_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalTestLanguage.g:1074:3: rule__Operation__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Operation__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getOperationAccess().getGroup_4_1()); 

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
    // $ANTLR end "rule__Operation__Group_4__1__Impl"


    // $ANTLR start "rule__Operation__Group_4_1__0"
    // InternalTestLanguage.g:1083:1: rule__Operation__Group_4_1__0 : rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1 ;
    public final void rule__Operation__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1087:1: ( rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1 )
            // InternalTestLanguage.g:1088:2: rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Operation__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group_4_1__1();

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
    // $ANTLR end "rule__Operation__Group_4_1__0"


    // $ANTLR start "rule__Operation__Group_4_1__0__Impl"
    // InternalTestLanguage.g:1095:1: rule__Operation__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__Operation__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1099:1: ( ( ',' ) )
            // InternalTestLanguage.g:1100:1: ( ',' )
            {
            // InternalTestLanguage.g:1100:1: ( ',' )
            // InternalTestLanguage.g:1101:2: ','
            {
             before(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); 

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
    // $ANTLR end "rule__Operation__Group_4_1__0__Impl"


    // $ANTLR start "rule__Operation__Group_4_1__1"
    // InternalTestLanguage.g:1110:1: rule__Operation__Group_4_1__1 : rule__Operation__Group_4_1__1__Impl ;
    public final void rule__Operation__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1114:1: ( rule__Operation__Group_4_1__1__Impl )
            // InternalTestLanguage.g:1115:2: rule__Operation__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operation__Group_4_1__1__Impl();

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
    // $ANTLR end "rule__Operation__Group_4_1__1"


    // $ANTLR start "rule__Operation__Group_4_1__1__Impl"
    // InternalTestLanguage.g:1121:1: rule__Operation__Group_4_1__1__Impl : ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) ;
    public final void rule__Operation__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1125:1: ( ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) )
            // InternalTestLanguage.g:1126:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            {
            // InternalTestLanguage.g:1126:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            // InternalTestLanguage.g:1127:2: ( rule__Operation__ParamsAssignment_4_1_1 )
            {
             before(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); 
            // InternalTestLanguage.g:1128:2: ( rule__Operation__ParamsAssignment_4_1_1 )
            // InternalTestLanguage.g:1128:3: rule__Operation__ParamsAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Operation__ParamsAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); 

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
    // $ANTLR end "rule__Operation__Group_4_1__1__Impl"


    // $ANTLR start "rule__Operation__Group_6__0"
    // InternalTestLanguage.g:1137:1: rule__Operation__Group_6__0 : rule__Operation__Group_6__0__Impl rule__Operation__Group_6__1 ;
    public final void rule__Operation__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1141:1: ( rule__Operation__Group_6__0__Impl rule__Operation__Group_6__1 )
            // InternalTestLanguage.g:1142:2: rule__Operation__Group_6__0__Impl rule__Operation__Group_6__1
            {
            pushFollow(FOLLOW_18);
            rule__Operation__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Operation__Group_6__1();

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
    // $ANTLR end "rule__Operation__Group_6__0"


    // $ANTLR start "rule__Operation__Group_6__0__Impl"
    // InternalTestLanguage.g:1149:1: rule__Operation__Group_6__0__Impl : ( ':' ) ;
    public final void rule__Operation__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1153:1: ( ( ':' ) )
            // InternalTestLanguage.g:1154:1: ( ':' )
            {
            // InternalTestLanguage.g:1154:1: ( ':' )
            // InternalTestLanguage.g:1155:2: ':'
            {
             before(grammarAccess.getOperationAccess().getColonKeyword_6_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getColonKeyword_6_0()); 

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
    // $ANTLR end "rule__Operation__Group_6__0__Impl"


    // $ANTLR start "rule__Operation__Group_6__1"
    // InternalTestLanguage.g:1164:1: rule__Operation__Group_6__1 : rule__Operation__Group_6__1__Impl ;
    public final void rule__Operation__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1168:1: ( rule__Operation__Group_6__1__Impl )
            // InternalTestLanguage.g:1169:2: rule__Operation__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Operation__Group_6__1__Impl();

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
    // $ANTLR end "rule__Operation__Group_6__1"


    // $ANTLR start "rule__Operation__Group_6__1__Impl"
    // InternalTestLanguage.g:1175:1: rule__Operation__Group_6__1__Impl : ( ( rule__Operation__ReturnTypeAssignment_6_1 ) ) ;
    public final void rule__Operation__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1179:1: ( ( ( rule__Operation__ReturnTypeAssignment_6_1 ) ) )
            // InternalTestLanguage.g:1180:1: ( ( rule__Operation__ReturnTypeAssignment_6_1 ) )
            {
            // InternalTestLanguage.g:1180:1: ( ( rule__Operation__ReturnTypeAssignment_6_1 ) )
            // InternalTestLanguage.g:1181:2: ( rule__Operation__ReturnTypeAssignment_6_1 )
            {
             before(grammarAccess.getOperationAccess().getReturnTypeAssignment_6_1()); 
            // InternalTestLanguage.g:1182:2: ( rule__Operation__ReturnTypeAssignment_6_1 )
            // InternalTestLanguage.g:1182:3: rule__Operation__ReturnTypeAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Operation__ReturnTypeAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getOperationAccess().getReturnTypeAssignment_6_1()); 

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
    // $ANTLR end "rule__Operation__Group_6__1__Impl"


    // $ANTLR start "rule__OperationCall__Group__0"
    // InternalTestLanguage.g:1191:1: rule__OperationCall__Group__0 : rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1 ;
    public final void rule__OperationCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1195:1: ( rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1 )
            // InternalTestLanguage.g:1196:2: rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__OperationCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__1();

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
    // $ANTLR end "rule__OperationCall__Group__0"


    // $ANTLR start "rule__OperationCall__Group__0__Impl"
    // InternalTestLanguage.g:1203:1: rule__OperationCall__Group__0__Impl : ( ( rule__OperationCall__OperationAssignment_0 ) ) ;
    public final void rule__OperationCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1207:1: ( ( ( rule__OperationCall__OperationAssignment_0 ) ) )
            // InternalTestLanguage.g:1208:1: ( ( rule__OperationCall__OperationAssignment_0 ) )
            {
            // InternalTestLanguage.g:1208:1: ( ( rule__OperationCall__OperationAssignment_0 ) )
            // InternalTestLanguage.g:1209:2: ( rule__OperationCall__OperationAssignment_0 )
            {
             before(grammarAccess.getOperationCallAccess().getOperationAssignment_0()); 
            // InternalTestLanguage.g:1210:2: ( rule__OperationCall__OperationAssignment_0 )
            // InternalTestLanguage.g:1210:3: rule__OperationCall__OperationAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__OperationAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getOperationAssignment_0()); 

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
    // $ANTLR end "rule__OperationCall__Group__0__Impl"


    // $ANTLR start "rule__OperationCall__Group__1"
    // InternalTestLanguage.g:1218:1: rule__OperationCall__Group__1 : rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2 ;
    public final void rule__OperationCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1222:1: ( rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2 )
            // InternalTestLanguage.g:1223:2: rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__OperationCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__2();

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
    // $ANTLR end "rule__OperationCall__Group__1"


    // $ANTLR start "rule__OperationCall__Group__1__Impl"
    // InternalTestLanguage.g:1230:1: rule__OperationCall__Group__1__Impl : ( '(' ) ;
    public final void rule__OperationCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1234:1: ( ( '(' ) )
            // InternalTestLanguage.g:1235:1: ( '(' )
            {
            // InternalTestLanguage.g:1235:1: ( '(' )
            // InternalTestLanguage.g:1236:2: '('
            {
             before(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1()); 

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
    // $ANTLR end "rule__OperationCall__Group__1__Impl"


    // $ANTLR start "rule__OperationCall__Group__2"
    // InternalTestLanguage.g:1245:1: rule__OperationCall__Group__2 : rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3 ;
    public final void rule__OperationCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1249:1: ( rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3 )
            // InternalTestLanguage.g:1250:2: rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__OperationCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__3();

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
    // $ANTLR end "rule__OperationCall__Group__2"


    // $ANTLR start "rule__OperationCall__Group__2__Impl"
    // InternalTestLanguage.g:1257:1: rule__OperationCall__Group__2__Impl : ( ( rule__OperationCall__Group_2__0 )? ) ;
    public final void rule__OperationCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1261:1: ( ( ( rule__OperationCall__Group_2__0 )? ) )
            // InternalTestLanguage.g:1262:1: ( ( rule__OperationCall__Group_2__0 )? )
            {
            // InternalTestLanguage.g:1262:1: ( ( rule__OperationCall__Group_2__0 )? )
            // InternalTestLanguage.g:1263:2: ( rule__OperationCall__Group_2__0 )?
            {
             before(grammarAccess.getOperationCallAccess().getGroup_2()); 
            // InternalTestLanguage.g:1264:2: ( rule__OperationCall__Group_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTestLanguage.g:1264:3: rule__OperationCall__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OperationCall__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationCallAccess().getGroup_2()); 

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
    // $ANTLR end "rule__OperationCall__Group__2__Impl"


    // $ANTLR start "rule__OperationCall__Group__3"
    // InternalTestLanguage.g:1272:1: rule__OperationCall__Group__3 : rule__OperationCall__Group__3__Impl ;
    public final void rule__OperationCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1276:1: ( rule__OperationCall__Group__3__Impl )
            // InternalTestLanguage.g:1277:2: rule__OperationCall__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__3__Impl();

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
    // $ANTLR end "rule__OperationCall__Group__3"


    // $ANTLR start "rule__OperationCall__Group__3__Impl"
    // InternalTestLanguage.g:1283:1: rule__OperationCall__Group__3__Impl : ( ')' ) ;
    public final void rule__OperationCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1287:1: ( ( ')' ) )
            // InternalTestLanguage.g:1288:1: ( ')' )
            {
            // InternalTestLanguage.g:1288:1: ( ')' )
            // InternalTestLanguage.g:1289:2: ')'
            {
             before(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__OperationCall__Group__3__Impl"


    // $ANTLR start "rule__OperationCall__Group_2__0"
    // InternalTestLanguage.g:1299:1: rule__OperationCall__Group_2__0 : rule__OperationCall__Group_2__0__Impl rule__OperationCall__Group_2__1 ;
    public final void rule__OperationCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1303:1: ( rule__OperationCall__Group_2__0__Impl rule__OperationCall__Group_2__1 )
            // InternalTestLanguage.g:1304:2: rule__OperationCall__Group_2__0__Impl rule__OperationCall__Group_2__1
            {
            pushFollow(FOLLOW_16);
            rule__OperationCall__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_2__1();

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
    // $ANTLR end "rule__OperationCall__Group_2__0"


    // $ANTLR start "rule__OperationCall__Group_2__0__Impl"
    // InternalTestLanguage.g:1311:1: rule__OperationCall__Group_2__0__Impl : ( ( rule__OperationCall__ParamsAssignment_2_0 ) ) ;
    public final void rule__OperationCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1315:1: ( ( ( rule__OperationCall__ParamsAssignment_2_0 ) ) )
            // InternalTestLanguage.g:1316:1: ( ( rule__OperationCall__ParamsAssignment_2_0 ) )
            {
            // InternalTestLanguage.g:1316:1: ( ( rule__OperationCall__ParamsAssignment_2_0 ) )
            // InternalTestLanguage.g:1317:2: ( rule__OperationCall__ParamsAssignment_2_0 )
            {
             before(grammarAccess.getOperationCallAccess().getParamsAssignment_2_0()); 
            // InternalTestLanguage.g:1318:2: ( rule__OperationCall__ParamsAssignment_2_0 )
            // InternalTestLanguage.g:1318:3: rule__OperationCall__ParamsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__ParamsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getParamsAssignment_2_0()); 

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
    // $ANTLR end "rule__OperationCall__Group_2__0__Impl"


    // $ANTLR start "rule__OperationCall__Group_2__1"
    // InternalTestLanguage.g:1326:1: rule__OperationCall__Group_2__1 : rule__OperationCall__Group_2__1__Impl ;
    public final void rule__OperationCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1330:1: ( rule__OperationCall__Group_2__1__Impl )
            // InternalTestLanguage.g:1331:2: rule__OperationCall__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_2__1__Impl();

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
    // $ANTLR end "rule__OperationCall__Group_2__1"


    // $ANTLR start "rule__OperationCall__Group_2__1__Impl"
    // InternalTestLanguage.g:1337:1: rule__OperationCall__Group_2__1__Impl : ( ( rule__OperationCall__Group_2_1__0 )* ) ;
    public final void rule__OperationCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1341:1: ( ( ( rule__OperationCall__Group_2_1__0 )* ) )
            // InternalTestLanguage.g:1342:1: ( ( rule__OperationCall__Group_2_1__0 )* )
            {
            // InternalTestLanguage.g:1342:1: ( ( rule__OperationCall__Group_2_1__0 )* )
            // InternalTestLanguage.g:1343:2: ( rule__OperationCall__Group_2_1__0 )*
            {
             before(grammarAccess.getOperationCallAccess().getGroup_2_1()); 
            // InternalTestLanguage.g:1344:2: ( rule__OperationCall__Group_2_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==23) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalTestLanguage.g:1344:3: rule__OperationCall__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__OperationCall__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getOperationCallAccess().getGroup_2_1()); 

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
    // $ANTLR end "rule__OperationCall__Group_2__1__Impl"


    // $ANTLR start "rule__OperationCall__Group_2_1__0"
    // InternalTestLanguage.g:1353:1: rule__OperationCall__Group_2_1__0 : rule__OperationCall__Group_2_1__0__Impl rule__OperationCall__Group_2_1__1 ;
    public final void rule__OperationCall__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1357:1: ( rule__OperationCall__Group_2_1__0__Impl rule__OperationCall__Group_2_1__1 )
            // InternalTestLanguage.g:1358:2: rule__OperationCall__Group_2_1__0__Impl rule__OperationCall__Group_2_1__1
            {
            pushFollow(FOLLOW_20);
            rule__OperationCall__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_2_1__1();

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
    // $ANTLR end "rule__OperationCall__Group_2_1__0"


    // $ANTLR start "rule__OperationCall__Group_2_1__0__Impl"
    // InternalTestLanguage.g:1365:1: rule__OperationCall__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__OperationCall__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1369:1: ( ( ',' ) )
            // InternalTestLanguage.g:1370:1: ( ',' )
            {
            // InternalTestLanguage.g:1370:1: ( ',' )
            // InternalTestLanguage.g:1371:2: ','
            {
             before(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0()); 

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
    // $ANTLR end "rule__OperationCall__Group_2_1__0__Impl"


    // $ANTLR start "rule__OperationCall__Group_2_1__1"
    // InternalTestLanguage.g:1380:1: rule__OperationCall__Group_2_1__1 : rule__OperationCall__Group_2_1__1__Impl ;
    public final void rule__OperationCall__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1384:1: ( rule__OperationCall__Group_2_1__1__Impl )
            // InternalTestLanguage.g:1385:2: rule__OperationCall__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__OperationCall__Group_2_1__1"


    // $ANTLR start "rule__OperationCall__Group_2_1__1__Impl"
    // InternalTestLanguage.g:1391:1: rule__OperationCall__Group_2_1__1__Impl : ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) ) ;
    public final void rule__OperationCall__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1395:1: ( ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) ) )
            // InternalTestLanguage.g:1396:1: ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) )
            {
            // InternalTestLanguage.g:1396:1: ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) )
            // InternalTestLanguage.g:1397:2: ( rule__OperationCall__ParamsAssignment_2_1_1 )
            {
             before(grammarAccess.getOperationCallAccess().getParamsAssignment_2_1_1()); 
            // InternalTestLanguage.g:1398:2: ( rule__OperationCall__ParamsAssignment_2_1_1 )
            // InternalTestLanguage.g:1398:3: rule__OperationCall__ParamsAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__ParamsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getParamsAssignment_2_1_1()); 

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
    // $ANTLR end "rule__OperationCall__Group_2_1__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // InternalTestLanguage.g:1407:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1411:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalTestLanguage.g:1412:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__1();

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
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // InternalTestLanguage.g:1419:1: rule__Parameter__Group__0__Impl : ( () ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1423:1: ( ( () ) )
            // InternalTestLanguage.g:1424:1: ( () )
            {
            // InternalTestLanguage.g:1424:1: ( () )
            // InternalTestLanguage.g:1425:2: ()
            {
             before(grammarAccess.getParameterAccess().getParameterAction_0()); 
            // InternalTestLanguage.g:1426:2: ()
            // InternalTestLanguage.g:1426:3: 
            {
            }

             after(grammarAccess.getParameterAccess().getParameterAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // InternalTestLanguage.g:1434:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1438:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalTestLanguage.g:1439:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__2();

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
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // InternalTestLanguage.g:1446:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__NameAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1450:1: ( ( ( rule__Parameter__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:1451:1: ( ( rule__Parameter__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:1451:1: ( ( rule__Parameter__NameAssignment_1 ) )
            // InternalTestLanguage.g:1452:2: ( rule__Parameter__NameAssignment_1 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:1453:2: ( rule__Parameter__NameAssignment_1 )
            // InternalTestLanguage.g:1453:3: rule__Parameter__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__2"
    // InternalTestLanguage.g:1461:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1465:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalTestLanguage.g:1466:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Parameter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__3();

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
    // $ANTLR end "rule__Parameter__Group__2"


    // $ANTLR start "rule__Parameter__Group__2__Impl"
    // InternalTestLanguage.g:1473:1: rule__Parameter__Group__2__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1477:1: ( ( ':' ) )
            // InternalTestLanguage.g:1478:1: ( ':' )
            {
            // InternalTestLanguage.g:1478:1: ( ':' )
            // InternalTestLanguage.g:1479:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__Parameter__Group__2__Impl"


    // $ANTLR start "rule__Parameter__Group__3"
    // InternalTestLanguage.g:1488:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1492:1: ( rule__Parameter__Group__3__Impl )
            // InternalTestLanguage.g:1493:2: rule__Parameter__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__3__Impl();

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
    // $ANTLR end "rule__Parameter__Group__3"


    // $ANTLR start "rule__Parameter__Group__3__Impl"
    // InternalTestLanguage.g:1499:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__TypeAssignment_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1503:1: ( ( ( rule__Parameter__TypeAssignment_3 ) ) )
            // InternalTestLanguage.g:1504:1: ( ( rule__Parameter__TypeAssignment_3 ) )
            {
            // InternalTestLanguage.g:1504:1: ( ( rule__Parameter__TypeAssignment_3 ) )
            // InternalTestLanguage.g:1505:2: ( rule__Parameter__TypeAssignment_3 )
            {
             before(grammarAccess.getParameterAccess().getTypeAssignment_3()); 
            // InternalTestLanguage.g:1506:2: ( rule__Parameter__TypeAssignment_3 )
            // InternalTestLanguage.g:1506:3: rule__Parameter__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getTypeAssignment_3()); 

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
    // $ANTLR end "rule__Parameter__Group__3__Impl"


    // $ANTLR start "rule__Model__TypesAssignment"
    // InternalTestLanguage.g:1515:1: rule__Model__TypesAssignment : ( ruleTypeDeclaration ) ;
    public final void rule__Model__TypesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1519:1: ( ( ruleTypeDeclaration ) )
            // InternalTestLanguage.g:1520:2: ( ruleTypeDeclaration )
            {
            // InternalTestLanguage.g:1520:2: ( ruleTypeDeclaration )
            // InternalTestLanguage.g:1521:3: ruleTypeDeclaration
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
    // InternalTestLanguage.g:1530:1: rule__TypeDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TypeDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1534:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1535:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:1535:2: ( RULE_ID )
            // InternalTestLanguage.g:1536:3: RULE_ID
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
    // InternalTestLanguage.g:1545:1: rule__TypeDeclaration__SuperTypeAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeDeclaration__SuperTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1549:1: ( ( ( RULE_ID ) ) )
            // InternalTestLanguage.g:1550:2: ( ( RULE_ID ) )
            {
            // InternalTestLanguage.g:1550:2: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1551:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); 
            // InternalTestLanguage.g:1552:3: ( RULE_ID )
            // InternalTestLanguage.g:1553:4: RULE_ID
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


    // $ANTLR start "rule__TypeDeclaration__MembersAssignment_4"
    // InternalTestLanguage.g:1564:1: rule__TypeDeclaration__MembersAssignment_4 : ( ruleMember ) ;
    public final void rule__TypeDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1568:1: ( ( ruleMember ) )
            // InternalTestLanguage.g:1569:2: ( ruleMember )
            {
            // InternalTestLanguage.g:1569:2: ( ruleMember )
            // InternalTestLanguage.g:1570:3: ruleMember
            {
             before(grammarAccess.getTypeDeclarationAccess().getMembersMemberParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleMember();

            state._fsp--;

             after(grammarAccess.getTypeDeclarationAccess().getMembersMemberParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__TypeDeclaration__MembersAssignment_4"


    // $ANTLR start "rule__Property__TypeAssignment_0"
    // InternalTestLanguage.g:1579:1: rule__Property__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Property__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1583:1: ( ( ruleType ) )
            // InternalTestLanguage.g:1584:2: ( ruleType )
            {
            // InternalTestLanguage.g:1584:2: ( ruleType )
            // InternalTestLanguage.g:1585:3: ruleType
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
    // InternalTestLanguage.g:1594:1: rule__Property__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Property__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1598:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1599:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:1599:2: ( RULE_ID )
            // InternalTestLanguage.g:1600:3: RULE_ID
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
    // InternalTestLanguage.g:1609:1: rule__Type__ArrayDiemensionsAssignment_1_0 : ( ( '[' ) ) ;
    public final void rule__Type__ArrayDiemensionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1613:1: ( ( ( '[' ) ) )
            // InternalTestLanguage.g:1614:2: ( ( '[' ) )
            {
            // InternalTestLanguage.g:1614:2: ( ( '[' ) )
            // InternalTestLanguage.g:1615:3: ( '[' )
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 
            // InternalTestLanguage.g:1616:3: ( '[' )
            // InternalTestLanguage.g:1617:4: '['
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 
            match(input,25,FOLLOW_2); 
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


    // $ANTLR start "rule__Operation__NameAssignment_2"
    // InternalTestLanguage.g:1628:1: rule__Operation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1632:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1633:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:1633:2: ( RULE_ID )
            // InternalTestLanguage.g:1634:3: RULE_ID
            {
             before(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Operation__NameAssignment_2"


    // $ANTLR start "rule__Operation__ParamsAssignment_4_0"
    // InternalTestLanguage.g:1643:1: rule__Operation__ParamsAssignment_4_0 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1647:1: ( ( ruleParameter ) )
            // InternalTestLanguage.g:1648:2: ( ruleParameter )
            {
            // InternalTestLanguage.g:1648:2: ( ruleParameter )
            // InternalTestLanguage.g:1649:3: ruleParameter
            {
             before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0()); 

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
    // $ANTLR end "rule__Operation__ParamsAssignment_4_0"


    // $ANTLR start "rule__Operation__ParamsAssignment_4_1_1"
    // InternalTestLanguage.g:1658:1: rule__Operation__ParamsAssignment_4_1_1 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1662:1: ( ( ruleParameter ) )
            // InternalTestLanguage.g:1663:2: ( ruleParameter )
            {
            // InternalTestLanguage.g:1663:2: ( ruleParameter )
            // InternalTestLanguage.g:1664:3: ruleParameter
            {
             before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0()); 

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
    // $ANTLR end "rule__Operation__ParamsAssignment_4_1_1"


    // $ANTLR start "rule__Operation__ReturnTypeAssignment_6_1"
    // InternalTestLanguage.g:1673:1: rule__Operation__ReturnTypeAssignment_6_1 : ( ruleType ) ;
    public final void rule__Operation__ReturnTypeAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1677:1: ( ( ruleType ) )
            // InternalTestLanguage.g:1678:2: ( ruleType )
            {
            // InternalTestLanguage.g:1678:2: ( ruleType )
            // InternalTestLanguage.g:1679:3: ruleType
            {
             before(grammarAccess.getOperationAccess().getReturnTypeTypeParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getOperationAccess().getReturnTypeTypeParserRuleCall_6_1_0()); 

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
    // $ANTLR end "rule__Operation__ReturnTypeAssignment_6_1"


    // $ANTLR start "rule__Operation__OperationCallAssignment_8"
    // InternalTestLanguage.g:1688:1: rule__Operation__OperationCallAssignment_8 : ( ruleOperationCall ) ;
    public final void rule__Operation__OperationCallAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1692:1: ( ( ruleOperationCall ) )
            // InternalTestLanguage.g:1693:2: ( ruleOperationCall )
            {
            // InternalTestLanguage.g:1693:2: ( ruleOperationCall )
            // InternalTestLanguage.g:1694:3: ruleOperationCall
            {
             before(grammarAccess.getOperationAccess().getOperationCallOperationCallParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationCall();

            state._fsp--;

             after(grammarAccess.getOperationAccess().getOperationCallOperationCallParserRuleCall_8_0()); 

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
    // $ANTLR end "rule__Operation__OperationCallAssignment_8"


    // $ANTLR start "rule__OperationCall__OperationAssignment_0"
    // InternalTestLanguage.g:1703:1: rule__OperationCall__OperationAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__OperationCall__OperationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1707:1: ( ( ( RULE_ID ) ) )
            // InternalTestLanguage.g:1708:2: ( ( RULE_ID ) )
            {
            // InternalTestLanguage.g:1708:2: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1709:3: ( RULE_ID )
            {
             before(grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_0_0()); 
            // InternalTestLanguage.g:1710:3: ( RULE_ID )
            // InternalTestLanguage.g:1711:4: RULE_ID
            {
             before(grammarAccess.getOperationCallAccess().getOperationOperationIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getOperationOperationIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_0_0()); 

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
    // $ANTLR end "rule__OperationCall__OperationAssignment_0"


    // $ANTLR start "rule__OperationCall__ParamsAssignment_2_0"
    // InternalTestLanguage.g:1722:1: rule__OperationCall__ParamsAssignment_2_0 : ( RULE_INT ) ;
    public final void rule__OperationCall__ParamsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1726:1: ( ( RULE_INT ) )
            // InternalTestLanguage.g:1727:2: ( RULE_INT )
            {
            // InternalTestLanguage.g:1727:2: ( RULE_INT )
            // InternalTestLanguage.g:1728:3: RULE_INT
            {
             before(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__OperationCall__ParamsAssignment_2_0"


    // $ANTLR start "rule__OperationCall__ParamsAssignment_2_1_1"
    // InternalTestLanguage.g:1737:1: rule__OperationCall__ParamsAssignment_2_1_1 : ( RULE_INT ) ;
    public final void rule__OperationCall__ParamsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1741:1: ( ( RULE_INT ) )
            // InternalTestLanguage.g:1742:2: ( RULE_INT )
            {
            // InternalTestLanguage.g:1742:2: ( RULE_INT )
            // InternalTestLanguage.g:1743:3: RULE_INT
            {
             before(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_1_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_1_1_0()); 

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
    // $ANTLR end "rule__OperationCall__ParamsAssignment_2_1_1"


    // $ANTLR start "rule__Parameter__NameAssignment_1"
    // InternalTestLanguage.g:1752:1: rule__Parameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1756:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1757:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:1757:2: ( RULE_ID )
            // InternalTestLanguage.g:1758:3: RULE_ID
            {
             before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__Parameter__NameAssignment_1"


    // $ANTLR start "rule__Parameter__TypeAssignment_3"
    // InternalTestLanguage.g:1767:1: rule__Parameter__TypeAssignment_3 : ( ruleType ) ;
    public final void rule__Parameter__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1771:1: ( ( ruleType ) )
            // InternalTestLanguage.g:1772:2: ( ruleType )
            {
            // InternalTestLanguage.g:1772:2: ( ruleType )
            // InternalTestLanguage.g:1773:3: ruleType
            {
             before(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleType();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Parameter__TypeAssignment_3"


    // $ANTLR start "rule__TypeReference__TypeRefAssignment"
    // InternalTestLanguage.g:1782:1: rule__TypeReference__TypeRefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__TypeReference__TypeRefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1786:1: ( ( ( RULE_ID ) ) )
            // InternalTestLanguage.g:1787:2: ( ( RULE_ID ) )
            {
            // InternalTestLanguage.g:1787:2: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1788:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0()); 
            // InternalTestLanguage.g:1789:3: ( RULE_ID )
            // InternalTestLanguage.g:1790:4: RULE_ID
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
    // InternalTestLanguage.g:1801:1: rule__PrimitiveType__NameAssignment : ( ( rule__PrimitiveType__NameAlternatives_0 ) ) ;
    public final void rule__PrimitiveType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1805:1: ( ( ( rule__PrimitiveType__NameAlternatives_0 ) ) )
            // InternalTestLanguage.g:1806:2: ( ( rule__PrimitiveType__NameAlternatives_0 ) )
            {
            // InternalTestLanguage.g:1806:2: ( ( rule__PrimitiveType__NameAlternatives_0 ) )
            // InternalTestLanguage.g:1807:3: ( rule__PrimitiveType__NameAlternatives_0 )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0()); 
            // InternalTestLanguage.g:1808:3: ( rule__PrimitiveType__NameAlternatives_0 )
            // InternalTestLanguage.g:1808:4: rule__PrimitiveType__NameAlternatives_0
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000127810L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000107812L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000107810L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000007810L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});

}