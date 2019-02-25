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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'string'", "'int'", "'boolean'", "'void'", "'package'", "'{'", "'}'", "'type'", "'extends'", "']'", "'op'", "'('", "')'", "','", "':'", "'.'", "'['"
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
    public static final int T__26=26;
    public static final int T__27=27;
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
    // InternalTestLanguage.g:66:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:70:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalTestLanguage.g:71:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalTestLanguage.g:71:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalTestLanguage.g:72:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalTestLanguage.g:73:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15||LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTestLanguage.g:73:4: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

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


    // $ANTLR start "entryRulePackageDeclaration"
    // InternalTestLanguage.g:82:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // InternalTestLanguage.g:83:1: ( rulePackageDeclaration EOF )
            // InternalTestLanguage.g:84:1: rulePackageDeclaration EOF
            {
             before(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            rulePackageDeclaration();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationRule()); 
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
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalTestLanguage.g:91:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:95:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // InternalTestLanguage.g:96:2: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // InternalTestLanguage.g:96:2: ( ( rule__PackageDeclaration__Group__0 ) )
            // InternalTestLanguage.g:97:3: ( rule__PackageDeclaration__Group__0 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            // InternalTestLanguage.g:98:3: ( rule__PackageDeclaration__Group__0 )
            // InternalTestLanguage.g:98:4: rule__PackageDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getGroup()); 

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
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalTestLanguage.g:107:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalTestLanguage.g:108:1: ( ruleAbstractElement EOF )
            // InternalTestLanguage.g:109:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalTestLanguage.g:116:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:120:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalTestLanguage.g:121:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalTestLanguage.g:121:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalTestLanguage.g:122:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalTestLanguage.g:123:3: ( rule__AbstractElement__Alternatives )
            // InternalTestLanguage.g:123:4: rule__AbstractElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleTypeDeclaration"
    // InternalTestLanguage.g:132:1: entryRuleTypeDeclaration : ruleTypeDeclaration EOF ;
    public final void entryRuleTypeDeclaration() throws RecognitionException {
        try {
            // InternalTestLanguage.g:133:1: ( ruleTypeDeclaration EOF )
            // InternalTestLanguage.g:134:1: ruleTypeDeclaration EOF
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
    // InternalTestLanguage.g:141:1: ruleTypeDeclaration : ( ( rule__TypeDeclaration__Group__0 ) ) ;
    public final void ruleTypeDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:145:2: ( ( ( rule__TypeDeclaration__Group__0 ) ) )
            // InternalTestLanguage.g:146:2: ( ( rule__TypeDeclaration__Group__0 ) )
            {
            // InternalTestLanguage.g:146:2: ( ( rule__TypeDeclaration__Group__0 ) )
            // InternalTestLanguage.g:147:3: ( rule__TypeDeclaration__Group__0 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getGroup()); 
            // InternalTestLanguage.g:148:3: ( rule__TypeDeclaration__Group__0 )
            // InternalTestLanguage.g:148:4: rule__TypeDeclaration__Group__0
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
    // InternalTestLanguage.g:157:1: entryRuleMember : ruleMember EOF ;
    public final void entryRuleMember() throws RecognitionException {
        try {
            // InternalTestLanguage.g:158:1: ( ruleMember EOF )
            // InternalTestLanguage.g:159:1: ruleMember EOF
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
    // InternalTestLanguage.g:166:1: ruleMember : ( ( rule__Member__Alternatives ) ) ;
    public final void ruleMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:170:2: ( ( ( rule__Member__Alternatives ) ) )
            // InternalTestLanguage.g:171:2: ( ( rule__Member__Alternatives ) )
            {
            // InternalTestLanguage.g:171:2: ( ( rule__Member__Alternatives ) )
            // InternalTestLanguage.g:172:3: ( rule__Member__Alternatives )
            {
             before(grammarAccess.getMemberAccess().getAlternatives()); 
            // InternalTestLanguage.g:173:3: ( rule__Member__Alternatives )
            // InternalTestLanguage.g:173:4: rule__Member__Alternatives
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
    // InternalTestLanguage.g:182:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // InternalTestLanguage.g:183:1: ( ruleProperty EOF )
            // InternalTestLanguage.g:184:1: ruleProperty EOF
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
    // InternalTestLanguage.g:191:1: ruleProperty : ( ( rule__Property__Group__0 ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:195:2: ( ( ( rule__Property__Group__0 ) ) )
            // InternalTestLanguage.g:196:2: ( ( rule__Property__Group__0 ) )
            {
            // InternalTestLanguage.g:196:2: ( ( rule__Property__Group__0 ) )
            // InternalTestLanguage.g:197:3: ( rule__Property__Group__0 )
            {
             before(grammarAccess.getPropertyAccess().getGroup()); 
            // InternalTestLanguage.g:198:3: ( rule__Property__Group__0 )
            // InternalTestLanguage.g:198:4: rule__Property__Group__0
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
    // InternalTestLanguage.g:207:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // InternalTestLanguage.g:208:1: ( ruleType EOF )
            // InternalTestLanguage.g:209:1: ruleType EOF
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
    // InternalTestLanguage.g:216:1: ruleType : ( ( rule__Type__Group__0 ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:220:2: ( ( ( rule__Type__Group__0 ) ) )
            // InternalTestLanguage.g:221:2: ( ( rule__Type__Group__0 ) )
            {
            // InternalTestLanguage.g:221:2: ( ( rule__Type__Group__0 ) )
            // InternalTestLanguage.g:222:3: ( rule__Type__Group__0 )
            {
             before(grammarAccess.getTypeAccess().getGroup()); 
            // InternalTestLanguage.g:223:3: ( rule__Type__Group__0 )
            // InternalTestLanguage.g:223:4: rule__Type__Group__0
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
    // InternalTestLanguage.g:232:1: entryRuleOperation : ruleOperation EOF ;
    public final void entryRuleOperation() throws RecognitionException {
        try {
            // InternalTestLanguage.g:233:1: ( ruleOperation EOF )
            // InternalTestLanguage.g:234:1: ruleOperation EOF
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
    // InternalTestLanguage.g:241:1: ruleOperation : ( ( rule__Operation__Group__0 ) ) ;
    public final void ruleOperation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:245:2: ( ( ( rule__Operation__Group__0 ) ) )
            // InternalTestLanguage.g:246:2: ( ( rule__Operation__Group__0 ) )
            {
            // InternalTestLanguage.g:246:2: ( ( rule__Operation__Group__0 ) )
            // InternalTestLanguage.g:247:3: ( rule__Operation__Group__0 )
            {
             before(grammarAccess.getOperationAccess().getGroup()); 
            // InternalTestLanguage.g:248:3: ( rule__Operation__Group__0 )
            // InternalTestLanguage.g:248:4: rule__Operation__Group__0
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
    // InternalTestLanguage.g:257:1: entryRuleOperationCall : ruleOperationCall EOF ;
    public final void entryRuleOperationCall() throws RecognitionException {
        try {
            // InternalTestLanguage.g:258:1: ( ruleOperationCall EOF )
            // InternalTestLanguage.g:259:1: ruleOperationCall EOF
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
    // InternalTestLanguage.g:266:1: ruleOperationCall : ( ( rule__OperationCall__Group__0 ) ) ;
    public final void ruleOperationCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:270:2: ( ( ( rule__OperationCall__Group__0 ) ) )
            // InternalTestLanguage.g:271:2: ( ( rule__OperationCall__Group__0 ) )
            {
            // InternalTestLanguage.g:271:2: ( ( rule__OperationCall__Group__0 ) )
            // InternalTestLanguage.g:272:3: ( rule__OperationCall__Group__0 )
            {
             before(grammarAccess.getOperationCallAccess().getGroup()); 
            // InternalTestLanguage.g:273:3: ( rule__OperationCall__Group__0 )
            // InternalTestLanguage.g:273:4: rule__OperationCall__Group__0
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
    // InternalTestLanguage.g:282:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalTestLanguage.g:283:1: ( ruleParameter EOF )
            // InternalTestLanguage.g:284:1: ruleParameter EOF
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
    // InternalTestLanguage.g:291:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:295:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalTestLanguage.g:296:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalTestLanguage.g:296:2: ( ( rule__Parameter__Group__0 ) )
            // InternalTestLanguage.g:297:3: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // InternalTestLanguage.g:298:3: ( rule__Parameter__Group__0 )
            // InternalTestLanguage.g:298:4: rule__Parameter__Group__0
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
    // InternalTestLanguage.g:307:1: entryRuleTypeReference : ruleTypeReference EOF ;
    public final void entryRuleTypeReference() throws RecognitionException {
        try {
            // InternalTestLanguage.g:308:1: ( ruleTypeReference EOF )
            // InternalTestLanguage.g:309:1: ruleTypeReference EOF
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
    // InternalTestLanguage.g:316:1: ruleTypeReference : ( ( rule__TypeReference__TypeRefAssignment ) ) ;
    public final void ruleTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:320:2: ( ( ( rule__TypeReference__TypeRefAssignment ) ) )
            // InternalTestLanguage.g:321:2: ( ( rule__TypeReference__TypeRefAssignment ) )
            {
            // InternalTestLanguage.g:321:2: ( ( rule__TypeReference__TypeRefAssignment ) )
            // InternalTestLanguage.g:322:3: ( rule__TypeReference__TypeRefAssignment )
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment()); 
            // InternalTestLanguage.g:323:3: ( rule__TypeReference__TypeRefAssignment )
            // InternalTestLanguage.g:323:4: rule__TypeReference__TypeRefAssignment
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
    // InternalTestLanguage.g:332:1: entryRulePrimitiveType : rulePrimitiveType EOF ;
    public final void entryRulePrimitiveType() throws RecognitionException {
        try {
            // InternalTestLanguage.g:333:1: ( rulePrimitiveType EOF )
            // InternalTestLanguage.g:334:1: rulePrimitiveType EOF
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
    // InternalTestLanguage.g:341:1: rulePrimitiveType : ( ( rule__PrimitiveType__NameAssignment ) ) ;
    public final void rulePrimitiveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:345:2: ( ( ( rule__PrimitiveType__NameAssignment ) ) )
            // InternalTestLanguage.g:346:2: ( ( rule__PrimitiveType__NameAssignment ) )
            {
            // InternalTestLanguage.g:346:2: ( ( rule__PrimitiveType__NameAssignment ) )
            // InternalTestLanguage.g:347:3: ( rule__PrimitiveType__NameAssignment )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAssignment()); 
            // InternalTestLanguage.g:348:3: ( rule__PrimitiveType__NameAssignment )
            // InternalTestLanguage.g:348:4: rule__PrimitiveType__NameAssignment
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


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTestLanguage.g:357:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalTestLanguage.g:358:1: ( ruleQualifiedName EOF )
            // InternalTestLanguage.g:359:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTestLanguage.g:366:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:370:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalTestLanguage.g:371:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalTestLanguage.g:371:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalTestLanguage.g:372:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalTestLanguage.g:373:3: ( rule__QualifiedName__Group__0 )
            // InternalTestLanguage.g:373:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // InternalTestLanguage.g:381:1: rule__AbstractElement__Alternatives : ( ( rulePackageDeclaration ) | ( ruleTypeDeclaration ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:385:1: ( ( rulePackageDeclaration ) | ( ruleTypeDeclaration ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTestLanguage.g:386:2: ( rulePackageDeclaration )
                    {
                    // InternalTestLanguage.g:386:2: ( rulePackageDeclaration )
                    // InternalTestLanguage.g:387:3: rulePackageDeclaration
                    {
                     before(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePackageDeclaration();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:392:2: ( ruleTypeDeclaration )
                    {
                    // InternalTestLanguage.g:392:2: ( ruleTypeDeclaration )
                    // InternalTestLanguage.g:393:3: ruleTypeDeclaration
                    {
                     before(grammarAccess.getAbstractElementAccess().getTypeDeclarationParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTypeDeclaration();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getTypeDeclarationParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__Member__Alternatives"
    // InternalTestLanguage.g:402:1: rule__Member__Alternatives : ( ( ruleProperty ) | ( ruleOperation ) );
    public final void rule__Member__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:406:1: ( ( ruleProperty ) | ( ruleOperation ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID||(LA3_0>=11 && LA3_0<=14)) ) {
                alt3=1;
            }
            else if ( (LA3_0==21) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTestLanguage.g:407:2: ( ruleProperty )
                    {
                    // InternalTestLanguage.g:407:2: ( ruleProperty )
                    // InternalTestLanguage.g:408:3: ruleProperty
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
                    // InternalTestLanguage.g:413:2: ( ruleOperation )
                    {
                    // InternalTestLanguage.g:413:2: ( ruleOperation )
                    // InternalTestLanguage.g:414:3: ruleOperation
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
    // InternalTestLanguage.g:423:1: rule__Type__Alternatives_0 : ( ( ruleTypeReference ) | ( rulePrimitiveType ) );
    public final void rule__Type__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:427:1: ( ( ruleTypeReference ) | ( rulePrimitiveType ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=11 && LA4_0<=14)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalTestLanguage.g:428:2: ( ruleTypeReference )
                    {
                    // InternalTestLanguage.g:428:2: ( ruleTypeReference )
                    // InternalTestLanguage.g:429:3: ruleTypeReference
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
                    // InternalTestLanguage.g:434:2: ( rulePrimitiveType )
                    {
                    // InternalTestLanguage.g:434:2: ( rulePrimitiveType )
                    // InternalTestLanguage.g:435:3: rulePrimitiveType
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
    // InternalTestLanguage.g:444:1: rule__PrimitiveType__NameAlternatives_0 : ( ( 'string' ) | ( 'int' ) | ( 'boolean' ) | ( 'void' ) );
    public final void rule__PrimitiveType__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:448:1: ( ( 'string' ) | ( 'int' ) | ( 'boolean' ) | ( 'void' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt5=1;
                }
                break;
            case 12:
                {
                alt5=2;
                }
                break;
            case 13:
                {
                alt5=3;
                }
                break;
            case 14:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalTestLanguage.g:449:2: ( 'string' )
                    {
                    // InternalTestLanguage.g:449:2: ( 'string' )
                    // InternalTestLanguage.g:450:3: 'string'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTestLanguage.g:455:2: ( 'int' )
                    {
                    // InternalTestLanguage.g:455:2: ( 'int' )
                    // InternalTestLanguage.g:456:3: 'int'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTestLanguage.g:461:2: ( 'boolean' )
                    {
                    // InternalTestLanguage.g:461:2: ( 'boolean' )
                    // InternalTestLanguage.g:462:3: 'boolean'
                    {
                     before(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTestLanguage.g:467:2: ( 'void' )
                    {
                    // InternalTestLanguage.g:467:2: ( 'void' )
                    // InternalTestLanguage.g:468:3: 'void'
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


    // $ANTLR start "rule__PackageDeclaration__Group__0"
    // InternalTestLanguage.g:477:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:481:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // InternalTestLanguage.g:482:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__1();

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
    // $ANTLR end "rule__PackageDeclaration__Group__0"


    // $ANTLR start "rule__PackageDeclaration__Group__0__Impl"
    // InternalTestLanguage.g:489:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:493:1: ( ( 'package' ) )
            // InternalTestLanguage.g:494:1: ( 'package' )
            {
            // InternalTestLanguage.g:494:1: ( 'package' )
            // InternalTestLanguage.g:495:2: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 

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
    // $ANTLR end "rule__PackageDeclaration__Group__0__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__1"
    // InternalTestLanguage.g:504:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:508:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // InternalTestLanguage.g:509:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__2();

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
    // $ANTLR end "rule__PackageDeclaration__Group__1"


    // $ANTLR start "rule__PackageDeclaration__Group__1__Impl"
    // InternalTestLanguage.g:516:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:520:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:521:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:521:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // InternalTestLanguage.g:522:2: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:523:2: ( rule__PackageDeclaration__NameAssignment_1 )
            // InternalTestLanguage.g:523:3: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__PackageDeclaration__Group__1__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__2"
    // InternalTestLanguage.g:531:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:535:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // InternalTestLanguage.g:536:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__PackageDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__3();

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
    // $ANTLR end "rule__PackageDeclaration__Group__2"


    // $ANTLR start "rule__PackageDeclaration__Group__2__Impl"
    // InternalTestLanguage.g:543:1: rule__PackageDeclaration__Group__2__Impl : ( '{' ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:547:1: ( ( '{' ) )
            // InternalTestLanguage.g:548:1: ( '{' )
            {
            // InternalTestLanguage.g:548:1: ( '{' )
            // InternalTestLanguage.g:549:2: '{'
            {
             before(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 

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
    // $ANTLR end "rule__PackageDeclaration__Group__2__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__3"
    // InternalTestLanguage.g:558:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4 ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:562:1: ( rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4 )
            // InternalTestLanguage.g:563:2: rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__PackageDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__4();

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
    // $ANTLR end "rule__PackageDeclaration__Group__3"


    // $ANTLR start "rule__PackageDeclaration__Group__3__Impl"
    // InternalTestLanguage.g:570:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:574:1: ( ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) )
            // InternalTestLanguage.g:575:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* )
            {
            // InternalTestLanguage.g:575:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* )
            // InternalTestLanguage.g:576:2: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3()); 
            // InternalTestLanguage.g:577:2: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15||LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalTestLanguage.g:577:3: rule__PackageDeclaration__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__PackageDeclaration__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3()); 

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
    // $ANTLR end "rule__PackageDeclaration__Group__3__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__4"
    // InternalTestLanguage.g:585:1: rule__PackageDeclaration__Group__4 : rule__PackageDeclaration__Group__4__Impl ;
    public final void rule__PackageDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:589:1: ( rule__PackageDeclaration__Group__4__Impl )
            // InternalTestLanguage.g:590:2: rule__PackageDeclaration__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__4__Impl();

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
    // $ANTLR end "rule__PackageDeclaration__Group__4"


    // $ANTLR start "rule__PackageDeclaration__Group__4__Impl"
    // InternalTestLanguage.g:596:1: rule__PackageDeclaration__Group__4__Impl : ( '}' ) ;
    public final void rule__PackageDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:600:1: ( ( '}' ) )
            // InternalTestLanguage.g:601:1: ( '}' )
            {
            // InternalTestLanguage.g:601:1: ( '}' )
            // InternalTestLanguage.g:602:2: '}'
            {
             before(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__PackageDeclaration__Group__4__Impl"


    // $ANTLR start "rule__TypeDeclaration__Group__0"
    // InternalTestLanguage.g:612:1: rule__TypeDeclaration__Group__0 : rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 ;
    public final void rule__TypeDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:616:1: ( rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1 )
            // InternalTestLanguage.g:617:2: rule__TypeDeclaration__Group__0__Impl rule__TypeDeclaration__Group__1
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
    // InternalTestLanguage.g:624:1: rule__TypeDeclaration__Group__0__Impl : ( 'type' ) ;
    public final void rule__TypeDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:628:1: ( ( 'type' ) )
            // InternalTestLanguage.g:629:1: ( 'type' )
            {
            // InternalTestLanguage.g:629:1: ( 'type' )
            // InternalTestLanguage.g:630:2: 'type'
            {
             before(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalTestLanguage.g:639:1: rule__TypeDeclaration__Group__1 : rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 ;
    public final void rule__TypeDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:643:1: ( rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2 )
            // InternalTestLanguage.g:644:2: rule__TypeDeclaration__Group__1__Impl rule__TypeDeclaration__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalTestLanguage.g:651:1: rule__TypeDeclaration__Group__1__Impl : ( ( rule__TypeDeclaration__NameAssignment_1 ) ) ;
    public final void rule__TypeDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:655:1: ( ( ( rule__TypeDeclaration__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:656:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:656:1: ( ( rule__TypeDeclaration__NameAssignment_1 ) )
            // InternalTestLanguage.g:657:2: ( rule__TypeDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:658:2: ( rule__TypeDeclaration__NameAssignment_1 )
            // InternalTestLanguage.g:658:3: rule__TypeDeclaration__NameAssignment_1
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
    // InternalTestLanguage.g:666:1: rule__TypeDeclaration__Group__2 : rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 ;
    public final void rule__TypeDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:670:1: ( rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3 )
            // InternalTestLanguage.g:671:2: rule__TypeDeclaration__Group__2__Impl rule__TypeDeclaration__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalTestLanguage.g:678:1: rule__TypeDeclaration__Group__2__Impl : ( ( rule__TypeDeclaration__Group_2__0 )? ) ;
    public final void rule__TypeDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:682:1: ( ( ( rule__TypeDeclaration__Group_2__0 )? ) )
            // InternalTestLanguage.g:683:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            {
            // InternalTestLanguage.g:683:1: ( ( rule__TypeDeclaration__Group_2__0 )? )
            // InternalTestLanguage.g:684:2: ( rule__TypeDeclaration__Group_2__0 )?
            {
             before(grammarAccess.getTypeDeclarationAccess().getGroup_2()); 
            // InternalTestLanguage.g:685:2: ( rule__TypeDeclaration__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalTestLanguage.g:685:3: rule__TypeDeclaration__Group_2__0
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
    // InternalTestLanguage.g:693:1: rule__TypeDeclaration__Group__3 : rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 ;
    public final void rule__TypeDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:697:1: ( rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4 )
            // InternalTestLanguage.g:698:2: rule__TypeDeclaration__Group__3__Impl rule__TypeDeclaration__Group__4
            {
            pushFollow(FOLLOW_8);
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
    // InternalTestLanguage.g:705:1: rule__TypeDeclaration__Group__3__Impl : ( '{' ) ;
    public final void rule__TypeDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:709:1: ( ( '{' ) )
            // InternalTestLanguage.g:710:1: ( '{' )
            {
            // InternalTestLanguage.g:710:1: ( '{' )
            // InternalTestLanguage.g:711:2: '{'
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
    // InternalTestLanguage.g:720:1: rule__TypeDeclaration__Group__4 : rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 ;
    public final void rule__TypeDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:724:1: ( rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5 )
            // InternalTestLanguage.g:725:2: rule__TypeDeclaration__Group__4__Impl rule__TypeDeclaration__Group__5
            {
            pushFollow(FOLLOW_8);
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
    // InternalTestLanguage.g:732:1: rule__TypeDeclaration__Group__4__Impl : ( ( rule__TypeDeclaration__MembersAssignment_4 )* ) ;
    public final void rule__TypeDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:736:1: ( ( ( rule__TypeDeclaration__MembersAssignment_4 )* ) )
            // InternalTestLanguage.g:737:1: ( ( rule__TypeDeclaration__MembersAssignment_4 )* )
            {
            // InternalTestLanguage.g:737:1: ( ( rule__TypeDeclaration__MembersAssignment_4 )* )
            // InternalTestLanguage.g:738:2: ( rule__TypeDeclaration__MembersAssignment_4 )*
            {
             before(grammarAccess.getTypeDeclarationAccess().getMembersAssignment_4()); 
            // InternalTestLanguage.g:739:2: ( rule__TypeDeclaration__MembersAssignment_4 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||(LA8_0>=11 && LA8_0<=14)||LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalTestLanguage.g:739:3: rule__TypeDeclaration__MembersAssignment_4
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TypeDeclaration__MembersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // InternalTestLanguage.g:747:1: rule__TypeDeclaration__Group__5 : rule__TypeDeclaration__Group__5__Impl ;
    public final void rule__TypeDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:751:1: ( rule__TypeDeclaration__Group__5__Impl )
            // InternalTestLanguage.g:752:2: rule__TypeDeclaration__Group__5__Impl
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
    // InternalTestLanguage.g:758:1: rule__TypeDeclaration__Group__5__Impl : ( '}' ) ;
    public final void rule__TypeDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:762:1: ( ( '}' ) )
            // InternalTestLanguage.g:763:1: ( '}' )
            {
            // InternalTestLanguage.g:763:1: ( '}' )
            // InternalTestLanguage.g:764:2: '}'
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
    // InternalTestLanguage.g:774:1: rule__TypeDeclaration__Group_2__0 : rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 ;
    public final void rule__TypeDeclaration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:778:1: ( rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1 )
            // InternalTestLanguage.g:779:2: rule__TypeDeclaration__Group_2__0__Impl rule__TypeDeclaration__Group_2__1
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
    // InternalTestLanguage.g:786:1: rule__TypeDeclaration__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__TypeDeclaration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:790:1: ( ( 'extends' ) )
            // InternalTestLanguage.g:791:1: ( 'extends' )
            {
            // InternalTestLanguage.g:791:1: ( 'extends' )
            // InternalTestLanguage.g:792:2: 'extends'
            {
             before(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalTestLanguage.g:801:1: rule__TypeDeclaration__Group_2__1 : rule__TypeDeclaration__Group_2__1__Impl ;
    public final void rule__TypeDeclaration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:805:1: ( rule__TypeDeclaration__Group_2__1__Impl )
            // InternalTestLanguage.g:806:2: rule__TypeDeclaration__Group_2__1__Impl
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
    // InternalTestLanguage.g:812:1: rule__TypeDeclaration__Group_2__1__Impl : ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) ;
    public final void rule__TypeDeclaration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:816:1: ( ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) ) )
            // InternalTestLanguage.g:817:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            {
            // InternalTestLanguage.g:817:1: ( ( rule__TypeDeclaration__SuperTypeAssignment_2_1 ) )
            // InternalTestLanguage.g:818:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); 
            // InternalTestLanguage.g:819:2: ( rule__TypeDeclaration__SuperTypeAssignment_2_1 )
            // InternalTestLanguage.g:819:3: rule__TypeDeclaration__SuperTypeAssignment_2_1
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
    // InternalTestLanguage.g:828:1: rule__Property__Group__0 : rule__Property__Group__0__Impl rule__Property__Group__1 ;
    public final void rule__Property__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:832:1: ( rule__Property__Group__0__Impl rule__Property__Group__1 )
            // InternalTestLanguage.g:833:2: rule__Property__Group__0__Impl rule__Property__Group__1
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
    // InternalTestLanguage.g:840:1: rule__Property__Group__0__Impl : ( ( rule__Property__TypeAssignment_0 ) ) ;
    public final void rule__Property__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:844:1: ( ( ( rule__Property__TypeAssignment_0 ) ) )
            // InternalTestLanguage.g:845:1: ( ( rule__Property__TypeAssignment_0 ) )
            {
            // InternalTestLanguage.g:845:1: ( ( rule__Property__TypeAssignment_0 ) )
            // InternalTestLanguage.g:846:2: ( rule__Property__TypeAssignment_0 )
            {
             before(grammarAccess.getPropertyAccess().getTypeAssignment_0()); 
            // InternalTestLanguage.g:847:2: ( rule__Property__TypeAssignment_0 )
            // InternalTestLanguage.g:847:3: rule__Property__TypeAssignment_0
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
    // InternalTestLanguage.g:855:1: rule__Property__Group__1 : rule__Property__Group__1__Impl ;
    public final void rule__Property__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:859:1: ( rule__Property__Group__1__Impl )
            // InternalTestLanguage.g:860:2: rule__Property__Group__1__Impl
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
    // InternalTestLanguage.g:866:1: rule__Property__Group__1__Impl : ( ( rule__Property__NameAssignment_1 ) ) ;
    public final void rule__Property__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:870:1: ( ( ( rule__Property__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:871:1: ( ( rule__Property__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:871:1: ( ( rule__Property__NameAssignment_1 ) )
            // InternalTestLanguage.g:872:2: ( rule__Property__NameAssignment_1 )
            {
             before(grammarAccess.getPropertyAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:873:2: ( rule__Property__NameAssignment_1 )
            // InternalTestLanguage.g:873:3: rule__Property__NameAssignment_1
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
    // InternalTestLanguage.g:882:1: rule__Type__Group__0 : rule__Type__Group__0__Impl rule__Type__Group__1 ;
    public final void rule__Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:886:1: ( rule__Type__Group__0__Impl rule__Type__Group__1 )
            // InternalTestLanguage.g:887:2: rule__Type__Group__0__Impl rule__Type__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalTestLanguage.g:894:1: rule__Type__Group__0__Impl : ( ( rule__Type__Alternatives_0 ) ) ;
    public final void rule__Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:898:1: ( ( ( rule__Type__Alternatives_0 ) ) )
            // InternalTestLanguage.g:899:1: ( ( rule__Type__Alternatives_0 ) )
            {
            // InternalTestLanguage.g:899:1: ( ( rule__Type__Alternatives_0 ) )
            // InternalTestLanguage.g:900:2: ( rule__Type__Alternatives_0 )
            {
             before(grammarAccess.getTypeAccess().getAlternatives_0()); 
            // InternalTestLanguage.g:901:2: ( rule__Type__Alternatives_0 )
            // InternalTestLanguage.g:901:3: rule__Type__Alternatives_0
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
    // InternalTestLanguage.g:909:1: rule__Type__Group__1 : rule__Type__Group__1__Impl ;
    public final void rule__Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:913:1: ( rule__Type__Group__1__Impl )
            // InternalTestLanguage.g:914:2: rule__Type__Group__1__Impl
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
    // InternalTestLanguage.g:920:1: rule__Type__Group__1__Impl : ( ( rule__Type__Group_1__0 )* ) ;
    public final void rule__Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:924:1: ( ( ( rule__Type__Group_1__0 )* ) )
            // InternalTestLanguage.g:925:1: ( ( rule__Type__Group_1__0 )* )
            {
            // InternalTestLanguage.g:925:1: ( ( rule__Type__Group_1__0 )* )
            // InternalTestLanguage.g:926:2: ( rule__Type__Group_1__0 )*
            {
             before(grammarAccess.getTypeAccess().getGroup_1()); 
            // InternalTestLanguage.g:927:2: ( rule__Type__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==27) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalTestLanguage.g:927:3: rule__Type__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Type__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalTestLanguage.g:936:1: rule__Type__Group_1__0 : rule__Type__Group_1__0__Impl rule__Type__Group_1__1 ;
    public final void rule__Type__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:940:1: ( rule__Type__Group_1__0__Impl rule__Type__Group_1__1 )
            // InternalTestLanguage.g:941:2: rule__Type__Group_1__0__Impl rule__Type__Group_1__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalTestLanguage.g:948:1: rule__Type__Group_1__0__Impl : ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) ) ;
    public final void rule__Type__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:952:1: ( ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) ) )
            // InternalTestLanguage.g:953:1: ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) )
            {
            // InternalTestLanguage.g:953:1: ( ( rule__Type__ArrayDiemensionsAssignment_1_0 ) )
            // InternalTestLanguage.g:954:2: ( rule__Type__ArrayDiemensionsAssignment_1_0 )
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0()); 
            // InternalTestLanguage.g:955:2: ( rule__Type__ArrayDiemensionsAssignment_1_0 )
            // InternalTestLanguage.g:955:3: rule__Type__ArrayDiemensionsAssignment_1_0
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
    // InternalTestLanguage.g:963:1: rule__Type__Group_1__1 : rule__Type__Group_1__1__Impl ;
    public final void rule__Type__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:967:1: ( rule__Type__Group_1__1__Impl )
            // InternalTestLanguage.g:968:2: rule__Type__Group_1__1__Impl
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
    // InternalTestLanguage.g:974:1: rule__Type__Group_1__1__Impl : ( ']' ) ;
    public final void rule__Type__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:978:1: ( ( ']' ) )
            // InternalTestLanguage.g:979:1: ( ']' )
            {
            // InternalTestLanguage.g:979:1: ( ']' )
            // InternalTestLanguage.g:980:2: ']'
            {
             before(grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1()); 
            match(input,20,FOLLOW_2); 
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
    // InternalTestLanguage.g:990:1: rule__Operation__Group__0 : rule__Operation__Group__0__Impl rule__Operation__Group__1 ;
    public final void rule__Operation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:994:1: ( rule__Operation__Group__0__Impl rule__Operation__Group__1 )
            // InternalTestLanguage.g:995:2: rule__Operation__Group__0__Impl rule__Operation__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalTestLanguage.g:1002:1: rule__Operation__Group__0__Impl : ( () ) ;
    public final void rule__Operation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1006:1: ( ( () ) )
            // InternalTestLanguage.g:1007:1: ( () )
            {
            // InternalTestLanguage.g:1007:1: ( () )
            // InternalTestLanguage.g:1008:2: ()
            {
             before(grammarAccess.getOperationAccess().getOperationAction_0()); 
            // InternalTestLanguage.g:1009:2: ()
            // InternalTestLanguage.g:1009:3: 
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
    // InternalTestLanguage.g:1017:1: rule__Operation__Group__1 : rule__Operation__Group__1__Impl rule__Operation__Group__2 ;
    public final void rule__Operation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1021:1: ( rule__Operation__Group__1__Impl rule__Operation__Group__2 )
            // InternalTestLanguage.g:1022:2: rule__Operation__Group__1__Impl rule__Operation__Group__2
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
    // InternalTestLanguage.g:1029:1: rule__Operation__Group__1__Impl : ( 'op' ) ;
    public final void rule__Operation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1033:1: ( ( 'op' ) )
            // InternalTestLanguage.g:1034:1: ( 'op' )
            {
            // InternalTestLanguage.g:1034:1: ( 'op' )
            // InternalTestLanguage.g:1035:2: 'op'
            {
             before(grammarAccess.getOperationAccess().getOpKeyword_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalTestLanguage.g:1044:1: rule__Operation__Group__2 : rule__Operation__Group__2__Impl rule__Operation__Group__3 ;
    public final void rule__Operation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1048:1: ( rule__Operation__Group__2__Impl rule__Operation__Group__3 )
            // InternalTestLanguage.g:1049:2: rule__Operation__Group__2__Impl rule__Operation__Group__3
            {
            pushFollow(FOLLOW_14);
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
    // InternalTestLanguage.g:1056:1: rule__Operation__Group__2__Impl : ( ( rule__Operation__NameAssignment_2 ) ) ;
    public final void rule__Operation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1060:1: ( ( ( rule__Operation__NameAssignment_2 ) ) )
            // InternalTestLanguage.g:1061:1: ( ( rule__Operation__NameAssignment_2 ) )
            {
            // InternalTestLanguage.g:1061:1: ( ( rule__Operation__NameAssignment_2 ) )
            // InternalTestLanguage.g:1062:2: ( rule__Operation__NameAssignment_2 )
            {
             before(grammarAccess.getOperationAccess().getNameAssignment_2()); 
            // InternalTestLanguage.g:1063:2: ( rule__Operation__NameAssignment_2 )
            // InternalTestLanguage.g:1063:3: rule__Operation__NameAssignment_2
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
    // InternalTestLanguage.g:1071:1: rule__Operation__Group__3 : rule__Operation__Group__3__Impl rule__Operation__Group__4 ;
    public final void rule__Operation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1075:1: ( rule__Operation__Group__3__Impl rule__Operation__Group__4 )
            // InternalTestLanguage.g:1076:2: rule__Operation__Group__3__Impl rule__Operation__Group__4
            {
            pushFollow(FOLLOW_15);
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
    // InternalTestLanguage.g:1083:1: rule__Operation__Group__3__Impl : ( '(' ) ;
    public final void rule__Operation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1087:1: ( ( '(' ) )
            // InternalTestLanguage.g:1088:1: ( '(' )
            {
            // InternalTestLanguage.g:1088:1: ( '(' )
            // InternalTestLanguage.g:1089:2: '('
            {
             before(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); 
            match(input,22,FOLLOW_2); 
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
    // InternalTestLanguage.g:1098:1: rule__Operation__Group__4 : rule__Operation__Group__4__Impl rule__Operation__Group__5 ;
    public final void rule__Operation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1102:1: ( rule__Operation__Group__4__Impl rule__Operation__Group__5 )
            // InternalTestLanguage.g:1103:2: rule__Operation__Group__4__Impl rule__Operation__Group__5
            {
            pushFollow(FOLLOW_15);
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
    // InternalTestLanguage.g:1110:1: rule__Operation__Group__4__Impl : ( ( rule__Operation__Group_4__0 )? ) ;
    public final void rule__Operation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1114:1: ( ( ( rule__Operation__Group_4__0 )? ) )
            // InternalTestLanguage.g:1115:1: ( ( rule__Operation__Group_4__0 )? )
            {
            // InternalTestLanguage.g:1115:1: ( ( rule__Operation__Group_4__0 )? )
            // InternalTestLanguage.g:1116:2: ( rule__Operation__Group_4__0 )?
            {
             before(grammarAccess.getOperationAccess().getGroup_4()); 
            // InternalTestLanguage.g:1117:2: ( rule__Operation__Group_4__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalTestLanguage.g:1117:3: rule__Operation__Group_4__0
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
    // InternalTestLanguage.g:1125:1: rule__Operation__Group__5 : rule__Operation__Group__5__Impl rule__Operation__Group__6 ;
    public final void rule__Operation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1129:1: ( rule__Operation__Group__5__Impl rule__Operation__Group__6 )
            // InternalTestLanguage.g:1130:2: rule__Operation__Group__5__Impl rule__Operation__Group__6
            {
            pushFollow(FOLLOW_16);
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
    // InternalTestLanguage.g:1137:1: rule__Operation__Group__5__Impl : ( ')' ) ;
    public final void rule__Operation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1141:1: ( ( ')' ) )
            // InternalTestLanguage.g:1142:1: ( ')' )
            {
            // InternalTestLanguage.g:1142:1: ( ')' )
            // InternalTestLanguage.g:1143:2: ')'
            {
             before(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); 
            match(input,23,FOLLOW_2); 
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
    // InternalTestLanguage.g:1152:1: rule__Operation__Group__6 : rule__Operation__Group__6__Impl rule__Operation__Group__7 ;
    public final void rule__Operation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1156:1: ( rule__Operation__Group__6__Impl rule__Operation__Group__7 )
            // InternalTestLanguage.g:1157:2: rule__Operation__Group__6__Impl rule__Operation__Group__7
            {
            pushFollow(FOLLOW_16);
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
    // InternalTestLanguage.g:1164:1: rule__Operation__Group__6__Impl : ( ( rule__Operation__Group_6__0 )? ) ;
    public final void rule__Operation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1168:1: ( ( ( rule__Operation__Group_6__0 )? ) )
            // InternalTestLanguage.g:1169:1: ( ( rule__Operation__Group_6__0 )? )
            {
            // InternalTestLanguage.g:1169:1: ( ( rule__Operation__Group_6__0 )? )
            // InternalTestLanguage.g:1170:2: ( rule__Operation__Group_6__0 )?
            {
             before(grammarAccess.getOperationAccess().getGroup_6()); 
            // InternalTestLanguage.g:1171:2: ( rule__Operation__Group_6__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTestLanguage.g:1171:3: rule__Operation__Group_6__0
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
    // InternalTestLanguage.g:1179:1: rule__Operation__Group__7 : rule__Operation__Group__7__Impl rule__Operation__Group__8 ;
    public final void rule__Operation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1183:1: ( rule__Operation__Group__7__Impl rule__Operation__Group__8 )
            // InternalTestLanguage.g:1184:2: rule__Operation__Group__7__Impl rule__Operation__Group__8
            {
            pushFollow(FOLLOW_17);
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
    // InternalTestLanguage.g:1191:1: rule__Operation__Group__7__Impl : ( '{' ) ;
    public final void rule__Operation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1195:1: ( ( '{' ) )
            // InternalTestLanguage.g:1196:1: ( '{' )
            {
            // InternalTestLanguage.g:1196:1: ( '{' )
            // InternalTestLanguage.g:1197:2: '{'
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
    // InternalTestLanguage.g:1206:1: rule__Operation__Group__8 : rule__Operation__Group__8__Impl rule__Operation__Group__9 ;
    public final void rule__Operation__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1210:1: ( rule__Operation__Group__8__Impl rule__Operation__Group__9 )
            // InternalTestLanguage.g:1211:2: rule__Operation__Group__8__Impl rule__Operation__Group__9
            {
            pushFollow(FOLLOW_17);
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
    // InternalTestLanguage.g:1218:1: rule__Operation__Group__8__Impl : ( ( rule__Operation__OperationCallAssignment_8 )? ) ;
    public final void rule__Operation__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1222:1: ( ( ( rule__Operation__OperationCallAssignment_8 )? ) )
            // InternalTestLanguage.g:1223:1: ( ( rule__Operation__OperationCallAssignment_8 )? )
            {
            // InternalTestLanguage.g:1223:1: ( ( rule__Operation__OperationCallAssignment_8 )? )
            // InternalTestLanguage.g:1224:2: ( rule__Operation__OperationCallAssignment_8 )?
            {
             before(grammarAccess.getOperationAccess().getOperationCallAssignment_8()); 
            // InternalTestLanguage.g:1225:2: ( rule__Operation__OperationCallAssignment_8 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalTestLanguage.g:1225:3: rule__Operation__OperationCallAssignment_8
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
    // InternalTestLanguage.g:1233:1: rule__Operation__Group__9 : rule__Operation__Group__9__Impl ;
    public final void rule__Operation__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1237:1: ( rule__Operation__Group__9__Impl )
            // InternalTestLanguage.g:1238:2: rule__Operation__Group__9__Impl
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
    // InternalTestLanguage.g:1244:1: rule__Operation__Group__9__Impl : ( '}' ) ;
    public final void rule__Operation__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1248:1: ( ( '}' ) )
            // InternalTestLanguage.g:1249:1: ( '}' )
            {
            // InternalTestLanguage.g:1249:1: ( '}' )
            // InternalTestLanguage.g:1250:2: '}'
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
    // InternalTestLanguage.g:1260:1: rule__Operation__Group_4__0 : rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1 ;
    public final void rule__Operation__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1264:1: ( rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1 )
            // InternalTestLanguage.g:1265:2: rule__Operation__Group_4__0__Impl rule__Operation__Group_4__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalTestLanguage.g:1272:1: rule__Operation__Group_4__0__Impl : ( ( rule__Operation__ParamsAssignment_4_0 ) ) ;
    public final void rule__Operation__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1276:1: ( ( ( rule__Operation__ParamsAssignment_4_0 ) ) )
            // InternalTestLanguage.g:1277:1: ( ( rule__Operation__ParamsAssignment_4_0 ) )
            {
            // InternalTestLanguage.g:1277:1: ( ( rule__Operation__ParamsAssignment_4_0 ) )
            // InternalTestLanguage.g:1278:2: ( rule__Operation__ParamsAssignment_4_0 )
            {
             before(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); 
            // InternalTestLanguage.g:1279:2: ( rule__Operation__ParamsAssignment_4_0 )
            // InternalTestLanguage.g:1279:3: rule__Operation__ParamsAssignment_4_0
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
    // InternalTestLanguage.g:1287:1: rule__Operation__Group_4__1 : rule__Operation__Group_4__1__Impl ;
    public final void rule__Operation__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1291:1: ( rule__Operation__Group_4__1__Impl )
            // InternalTestLanguage.g:1292:2: rule__Operation__Group_4__1__Impl
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
    // InternalTestLanguage.g:1298:1: rule__Operation__Group_4__1__Impl : ( ( rule__Operation__Group_4_1__0 )* ) ;
    public final void rule__Operation__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1302:1: ( ( ( rule__Operation__Group_4_1__0 )* ) )
            // InternalTestLanguage.g:1303:1: ( ( rule__Operation__Group_4_1__0 )* )
            {
            // InternalTestLanguage.g:1303:1: ( ( rule__Operation__Group_4_1__0 )* )
            // InternalTestLanguage.g:1304:2: ( rule__Operation__Group_4_1__0 )*
            {
             before(grammarAccess.getOperationAccess().getGroup_4_1()); 
            // InternalTestLanguage.g:1305:2: ( rule__Operation__Group_4_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==24) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalTestLanguage.g:1305:3: rule__Operation__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__Operation__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // InternalTestLanguage.g:1314:1: rule__Operation__Group_4_1__0 : rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1 ;
    public final void rule__Operation__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1318:1: ( rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1 )
            // InternalTestLanguage.g:1319:2: rule__Operation__Group_4_1__0__Impl rule__Operation__Group_4_1__1
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
    // InternalTestLanguage.g:1326:1: rule__Operation__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__Operation__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1330:1: ( ( ',' ) )
            // InternalTestLanguage.g:1331:1: ( ',' )
            {
            // InternalTestLanguage.g:1331:1: ( ',' )
            // InternalTestLanguage.g:1332:2: ','
            {
             before(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalTestLanguage.g:1341:1: rule__Operation__Group_4_1__1 : rule__Operation__Group_4_1__1__Impl ;
    public final void rule__Operation__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1345:1: ( rule__Operation__Group_4_1__1__Impl )
            // InternalTestLanguage.g:1346:2: rule__Operation__Group_4_1__1__Impl
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
    // InternalTestLanguage.g:1352:1: rule__Operation__Group_4_1__1__Impl : ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) ;
    public final void rule__Operation__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1356:1: ( ( ( rule__Operation__ParamsAssignment_4_1_1 ) ) )
            // InternalTestLanguage.g:1357:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            {
            // InternalTestLanguage.g:1357:1: ( ( rule__Operation__ParamsAssignment_4_1_1 ) )
            // InternalTestLanguage.g:1358:2: ( rule__Operation__ParamsAssignment_4_1_1 )
            {
             before(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); 
            // InternalTestLanguage.g:1359:2: ( rule__Operation__ParamsAssignment_4_1_1 )
            // InternalTestLanguage.g:1359:3: rule__Operation__ParamsAssignment_4_1_1
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
    // InternalTestLanguage.g:1368:1: rule__Operation__Group_6__0 : rule__Operation__Group_6__0__Impl rule__Operation__Group_6__1 ;
    public final void rule__Operation__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1372:1: ( rule__Operation__Group_6__0__Impl rule__Operation__Group_6__1 )
            // InternalTestLanguage.g:1373:2: rule__Operation__Group_6__0__Impl rule__Operation__Group_6__1
            {
            pushFollow(FOLLOW_20);
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
    // InternalTestLanguage.g:1380:1: rule__Operation__Group_6__0__Impl : ( ':' ) ;
    public final void rule__Operation__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1384:1: ( ( ':' ) )
            // InternalTestLanguage.g:1385:1: ( ':' )
            {
            // InternalTestLanguage.g:1385:1: ( ':' )
            // InternalTestLanguage.g:1386:2: ':'
            {
             before(grammarAccess.getOperationAccess().getColonKeyword_6_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalTestLanguage.g:1395:1: rule__Operation__Group_6__1 : rule__Operation__Group_6__1__Impl ;
    public final void rule__Operation__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1399:1: ( rule__Operation__Group_6__1__Impl )
            // InternalTestLanguage.g:1400:2: rule__Operation__Group_6__1__Impl
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
    // InternalTestLanguage.g:1406:1: rule__Operation__Group_6__1__Impl : ( ( rule__Operation__ReturnTypeAssignment_6_1 ) ) ;
    public final void rule__Operation__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1410:1: ( ( ( rule__Operation__ReturnTypeAssignment_6_1 ) ) )
            // InternalTestLanguage.g:1411:1: ( ( rule__Operation__ReturnTypeAssignment_6_1 ) )
            {
            // InternalTestLanguage.g:1411:1: ( ( rule__Operation__ReturnTypeAssignment_6_1 ) )
            // InternalTestLanguage.g:1412:2: ( rule__Operation__ReturnTypeAssignment_6_1 )
            {
             before(grammarAccess.getOperationAccess().getReturnTypeAssignment_6_1()); 
            // InternalTestLanguage.g:1413:2: ( rule__Operation__ReturnTypeAssignment_6_1 )
            // InternalTestLanguage.g:1413:3: rule__Operation__ReturnTypeAssignment_6_1
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
    // InternalTestLanguage.g:1422:1: rule__OperationCall__Group__0 : rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1 ;
    public final void rule__OperationCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1426:1: ( rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1 )
            // InternalTestLanguage.g:1427:2: rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalTestLanguage.g:1434:1: rule__OperationCall__Group__0__Impl : ( ( rule__OperationCall__OperationAssignment_0 ) ) ;
    public final void rule__OperationCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1438:1: ( ( ( rule__OperationCall__OperationAssignment_0 ) ) )
            // InternalTestLanguage.g:1439:1: ( ( rule__OperationCall__OperationAssignment_0 ) )
            {
            // InternalTestLanguage.g:1439:1: ( ( rule__OperationCall__OperationAssignment_0 ) )
            // InternalTestLanguage.g:1440:2: ( rule__OperationCall__OperationAssignment_0 )
            {
             before(grammarAccess.getOperationCallAccess().getOperationAssignment_0()); 
            // InternalTestLanguage.g:1441:2: ( rule__OperationCall__OperationAssignment_0 )
            // InternalTestLanguage.g:1441:3: rule__OperationCall__OperationAssignment_0
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
    // InternalTestLanguage.g:1449:1: rule__OperationCall__Group__1 : rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2 ;
    public final void rule__OperationCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1453:1: ( rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2 )
            // InternalTestLanguage.g:1454:2: rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalTestLanguage.g:1461:1: rule__OperationCall__Group__1__Impl : ( '(' ) ;
    public final void rule__OperationCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1465:1: ( ( '(' ) )
            // InternalTestLanguage.g:1466:1: ( '(' )
            {
            // InternalTestLanguage.g:1466:1: ( '(' )
            // InternalTestLanguage.g:1467:2: '('
            {
             before(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalTestLanguage.g:1476:1: rule__OperationCall__Group__2 : rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3 ;
    public final void rule__OperationCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1480:1: ( rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3 )
            // InternalTestLanguage.g:1481:2: rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3
            {
            pushFollow(FOLLOW_21);
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
    // InternalTestLanguage.g:1488:1: rule__OperationCall__Group__2__Impl : ( ( rule__OperationCall__Group_2__0 )? ) ;
    public final void rule__OperationCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1492:1: ( ( ( rule__OperationCall__Group_2__0 )? ) )
            // InternalTestLanguage.g:1493:1: ( ( rule__OperationCall__Group_2__0 )? )
            {
            // InternalTestLanguage.g:1493:1: ( ( rule__OperationCall__Group_2__0 )? )
            // InternalTestLanguage.g:1494:2: ( rule__OperationCall__Group_2__0 )?
            {
             before(grammarAccess.getOperationCallAccess().getGroup_2()); 
            // InternalTestLanguage.g:1495:2: ( rule__OperationCall__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_INT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTestLanguage.g:1495:3: rule__OperationCall__Group_2__0
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
    // InternalTestLanguage.g:1503:1: rule__OperationCall__Group__3 : rule__OperationCall__Group__3__Impl ;
    public final void rule__OperationCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1507:1: ( rule__OperationCall__Group__3__Impl )
            // InternalTestLanguage.g:1508:2: rule__OperationCall__Group__3__Impl
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
    // InternalTestLanguage.g:1514:1: rule__OperationCall__Group__3__Impl : ( ')' ) ;
    public final void rule__OperationCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1518:1: ( ( ')' ) )
            // InternalTestLanguage.g:1519:1: ( ')' )
            {
            // InternalTestLanguage.g:1519:1: ( ')' )
            // InternalTestLanguage.g:1520:2: ')'
            {
             before(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3()); 
            match(input,23,FOLLOW_2); 
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
    // InternalTestLanguage.g:1530:1: rule__OperationCall__Group_2__0 : rule__OperationCall__Group_2__0__Impl rule__OperationCall__Group_2__1 ;
    public final void rule__OperationCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1534:1: ( rule__OperationCall__Group_2__0__Impl rule__OperationCall__Group_2__1 )
            // InternalTestLanguage.g:1535:2: rule__OperationCall__Group_2__0__Impl rule__OperationCall__Group_2__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalTestLanguage.g:1542:1: rule__OperationCall__Group_2__0__Impl : ( ( rule__OperationCall__ParamsAssignment_2_0 ) ) ;
    public final void rule__OperationCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1546:1: ( ( ( rule__OperationCall__ParamsAssignment_2_0 ) ) )
            // InternalTestLanguage.g:1547:1: ( ( rule__OperationCall__ParamsAssignment_2_0 ) )
            {
            // InternalTestLanguage.g:1547:1: ( ( rule__OperationCall__ParamsAssignment_2_0 ) )
            // InternalTestLanguage.g:1548:2: ( rule__OperationCall__ParamsAssignment_2_0 )
            {
             before(grammarAccess.getOperationCallAccess().getParamsAssignment_2_0()); 
            // InternalTestLanguage.g:1549:2: ( rule__OperationCall__ParamsAssignment_2_0 )
            // InternalTestLanguage.g:1549:3: rule__OperationCall__ParamsAssignment_2_0
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
    // InternalTestLanguage.g:1557:1: rule__OperationCall__Group_2__1 : rule__OperationCall__Group_2__1__Impl ;
    public final void rule__OperationCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1561:1: ( rule__OperationCall__Group_2__1__Impl )
            // InternalTestLanguage.g:1562:2: rule__OperationCall__Group_2__1__Impl
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
    // InternalTestLanguage.g:1568:1: rule__OperationCall__Group_2__1__Impl : ( ( rule__OperationCall__Group_2_1__0 )* ) ;
    public final void rule__OperationCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1572:1: ( ( ( rule__OperationCall__Group_2_1__0 )* ) )
            // InternalTestLanguage.g:1573:1: ( ( rule__OperationCall__Group_2_1__0 )* )
            {
            // InternalTestLanguage.g:1573:1: ( ( rule__OperationCall__Group_2_1__0 )* )
            // InternalTestLanguage.g:1574:2: ( rule__OperationCall__Group_2_1__0 )*
            {
             before(grammarAccess.getOperationCallAccess().getGroup_2_1()); 
            // InternalTestLanguage.g:1575:2: ( rule__OperationCall__Group_2_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalTestLanguage.g:1575:3: rule__OperationCall__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__OperationCall__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalTestLanguage.g:1584:1: rule__OperationCall__Group_2_1__0 : rule__OperationCall__Group_2_1__0__Impl rule__OperationCall__Group_2_1__1 ;
    public final void rule__OperationCall__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1588:1: ( rule__OperationCall__Group_2_1__0__Impl rule__OperationCall__Group_2_1__1 )
            // InternalTestLanguage.g:1589:2: rule__OperationCall__Group_2_1__0__Impl rule__OperationCall__Group_2_1__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalTestLanguage.g:1596:1: rule__OperationCall__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__OperationCall__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1600:1: ( ( ',' ) )
            // InternalTestLanguage.g:1601:1: ( ',' )
            {
            // InternalTestLanguage.g:1601:1: ( ',' )
            // InternalTestLanguage.g:1602:2: ','
            {
             before(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0()); 
            match(input,24,FOLLOW_2); 
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
    // InternalTestLanguage.g:1611:1: rule__OperationCall__Group_2_1__1 : rule__OperationCall__Group_2_1__1__Impl ;
    public final void rule__OperationCall__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1615:1: ( rule__OperationCall__Group_2_1__1__Impl )
            // InternalTestLanguage.g:1616:2: rule__OperationCall__Group_2_1__1__Impl
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
    // InternalTestLanguage.g:1622:1: rule__OperationCall__Group_2_1__1__Impl : ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) ) ;
    public final void rule__OperationCall__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1626:1: ( ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) ) )
            // InternalTestLanguage.g:1627:1: ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) )
            {
            // InternalTestLanguage.g:1627:1: ( ( rule__OperationCall__ParamsAssignment_2_1_1 ) )
            // InternalTestLanguage.g:1628:2: ( rule__OperationCall__ParamsAssignment_2_1_1 )
            {
             before(grammarAccess.getOperationCallAccess().getParamsAssignment_2_1_1()); 
            // InternalTestLanguage.g:1629:2: ( rule__OperationCall__ParamsAssignment_2_1_1 )
            // InternalTestLanguage.g:1629:3: rule__OperationCall__ParamsAssignment_2_1_1
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
    // InternalTestLanguage.g:1638:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1642:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalTestLanguage.g:1643:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
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
    // InternalTestLanguage.g:1650:1: rule__Parameter__Group__0__Impl : ( () ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1654:1: ( ( () ) )
            // InternalTestLanguage.g:1655:1: ( () )
            {
            // InternalTestLanguage.g:1655:1: ( () )
            // InternalTestLanguage.g:1656:2: ()
            {
             before(grammarAccess.getParameterAccess().getParameterAction_0()); 
            // InternalTestLanguage.g:1657:2: ()
            // InternalTestLanguage.g:1657:3: 
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
    // InternalTestLanguage.g:1665:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1669:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalTestLanguage.g:1670:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_23);
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
    // InternalTestLanguage.g:1677:1: rule__Parameter__Group__1__Impl : ( ( rule__Parameter__NameAssignment_1 ) ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1681:1: ( ( ( rule__Parameter__NameAssignment_1 ) ) )
            // InternalTestLanguage.g:1682:1: ( ( rule__Parameter__NameAssignment_1 ) )
            {
            // InternalTestLanguage.g:1682:1: ( ( rule__Parameter__NameAssignment_1 ) )
            // InternalTestLanguage.g:1683:2: ( rule__Parameter__NameAssignment_1 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_1()); 
            // InternalTestLanguage.g:1684:2: ( rule__Parameter__NameAssignment_1 )
            // InternalTestLanguage.g:1684:3: rule__Parameter__NameAssignment_1
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
    // InternalTestLanguage.g:1692:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1696:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalTestLanguage.g:1697:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FOLLOW_20);
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
    // InternalTestLanguage.g:1704:1: rule__Parameter__Group__2__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1708:1: ( ( ':' ) )
            // InternalTestLanguage.g:1709:1: ( ':' )
            {
            // InternalTestLanguage.g:1709:1: ( ':' )
            // InternalTestLanguage.g:1710:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_2()); 
            match(input,25,FOLLOW_2); 
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
    // InternalTestLanguage.g:1719:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1723:1: ( rule__Parameter__Group__3__Impl )
            // InternalTestLanguage.g:1724:2: rule__Parameter__Group__3__Impl
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
    // InternalTestLanguage.g:1730:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__TypeAssignment_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1734:1: ( ( ( rule__Parameter__TypeAssignment_3 ) ) )
            // InternalTestLanguage.g:1735:1: ( ( rule__Parameter__TypeAssignment_3 ) )
            {
            // InternalTestLanguage.g:1735:1: ( ( rule__Parameter__TypeAssignment_3 ) )
            // InternalTestLanguage.g:1736:2: ( rule__Parameter__TypeAssignment_3 )
            {
             before(grammarAccess.getParameterAccess().getTypeAssignment_3()); 
            // InternalTestLanguage.g:1737:2: ( rule__Parameter__TypeAssignment_3 )
            // InternalTestLanguage.g:1737:3: rule__Parameter__TypeAssignment_3
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalTestLanguage.g:1746:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1750:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalTestLanguage.g:1751:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalTestLanguage.g:1758:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1762:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1763:1: ( RULE_ID )
            {
            // InternalTestLanguage.g:1763:1: ( RULE_ID )
            // InternalTestLanguage.g:1764:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalTestLanguage.g:1773:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1777:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalTestLanguage.g:1778:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalTestLanguage.g:1784:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1788:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalTestLanguage.g:1789:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalTestLanguage.g:1789:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalTestLanguage.g:1790:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalTestLanguage.g:1791:2: ( rule__QualifiedName__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalTestLanguage.g:1791:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

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
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalTestLanguage.g:1800:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1804:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalTestLanguage.g:1805:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalTestLanguage.g:1812:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1816:1: ( ( '.' ) )
            // InternalTestLanguage.g:1817:1: ( '.' )
            {
            // InternalTestLanguage.g:1817:1: ( '.' )
            // InternalTestLanguage.g:1818:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

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
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalTestLanguage.g:1827:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1831:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalTestLanguage.g:1832:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalTestLanguage.g:1838:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1842:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1843:1: ( RULE_ID )
            {
            // InternalTestLanguage.g:1843:1: ( RULE_ID )
            // InternalTestLanguage.g:1844:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

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
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalTestLanguage.g:1854:1: rule__Model__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1858:1: ( ( ruleAbstractElement ) )
            // InternalTestLanguage.g:1859:2: ( ruleAbstractElement )
            {
            // InternalTestLanguage.g:1859:2: ( ruleAbstractElement )
            // InternalTestLanguage.g:1860:3: ruleAbstractElement
            {
             before(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 

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
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__PackageDeclaration__NameAssignment_1"
    // InternalTestLanguage.g:1869:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1873:1: ( ( ruleQualifiedName ) )
            // InternalTestLanguage.g:1874:2: ( ruleQualifiedName )
            {
            // InternalTestLanguage.g:1874:2: ( ruleQualifiedName )
            // InternalTestLanguage.g:1875:3: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__PackageDeclaration__NameAssignment_1"


    // $ANTLR start "rule__PackageDeclaration__ElementsAssignment_3"
    // InternalTestLanguage.g:1884:1: rule__PackageDeclaration__ElementsAssignment_3 : ( ruleAbstractElement ) ;
    public final void rule__PackageDeclaration__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1888:1: ( ( ruleAbstractElement ) )
            // InternalTestLanguage.g:1889:2: ( ruleAbstractElement )
            {
            // InternalTestLanguage.g:1889:2: ( ruleAbstractElement )
            // InternalTestLanguage.g:1890:3: ruleAbstractElement
            {
             before(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__PackageDeclaration__ElementsAssignment_3"


    // $ANTLR start "rule__TypeDeclaration__NameAssignment_1"
    // InternalTestLanguage.g:1899:1: rule__TypeDeclaration__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__TypeDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1903:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1904:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:1904:2: ( RULE_ID )
            // InternalTestLanguage.g:1905:3: RULE_ID
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
    // InternalTestLanguage.g:1914:1: rule__TypeDeclaration__SuperTypeAssignment_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeDeclaration__SuperTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1918:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTestLanguage.g:1919:2: ( ( ruleQualifiedName ) )
            {
            // InternalTestLanguage.g:1919:2: ( ( ruleQualifiedName ) )
            // InternalTestLanguage.g:1920:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); 
            // InternalTestLanguage.g:1921:3: ( ruleQualifiedName )
            // InternalTestLanguage.g:1922:4: ruleQualifiedName
            {
             before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationQualifiedNameParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationQualifiedNameParserRuleCall_2_1_0_1()); 

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
    // InternalTestLanguage.g:1933:1: rule__TypeDeclaration__MembersAssignment_4 : ( ruleMember ) ;
    public final void rule__TypeDeclaration__MembersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1937:1: ( ( ruleMember ) )
            // InternalTestLanguage.g:1938:2: ( ruleMember )
            {
            // InternalTestLanguage.g:1938:2: ( ruleMember )
            // InternalTestLanguage.g:1939:3: ruleMember
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
    // InternalTestLanguage.g:1948:1: rule__Property__TypeAssignment_0 : ( ruleType ) ;
    public final void rule__Property__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1952:1: ( ( ruleType ) )
            // InternalTestLanguage.g:1953:2: ( ruleType )
            {
            // InternalTestLanguage.g:1953:2: ( ruleType )
            // InternalTestLanguage.g:1954:3: ruleType
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
    // InternalTestLanguage.g:1963:1: rule__Property__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Property__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1967:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:1968:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:1968:2: ( RULE_ID )
            // InternalTestLanguage.g:1969:3: RULE_ID
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
    // InternalTestLanguage.g:1978:1: rule__Type__ArrayDiemensionsAssignment_1_0 : ( ( '[' ) ) ;
    public final void rule__Type__ArrayDiemensionsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:1982:1: ( ( ( '[' ) ) )
            // InternalTestLanguage.g:1983:2: ( ( '[' ) )
            {
            // InternalTestLanguage.g:1983:2: ( ( '[' ) )
            // InternalTestLanguage.g:1984:3: ( '[' )
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 
            // InternalTestLanguage.g:1985:3: ( '[' )
            // InternalTestLanguage.g:1986:4: '['
            {
             before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalTestLanguage.g:1997:1: rule__Operation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Operation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2001:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:2002:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:2002:2: ( RULE_ID )
            // InternalTestLanguage.g:2003:3: RULE_ID
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
    // InternalTestLanguage.g:2012:1: rule__Operation__ParamsAssignment_4_0 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2016:1: ( ( ruleParameter ) )
            // InternalTestLanguage.g:2017:2: ( ruleParameter )
            {
            // InternalTestLanguage.g:2017:2: ( ruleParameter )
            // InternalTestLanguage.g:2018:3: ruleParameter
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
    // InternalTestLanguage.g:2027:1: rule__Operation__ParamsAssignment_4_1_1 : ( ruleParameter ) ;
    public final void rule__Operation__ParamsAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2031:1: ( ( ruleParameter ) )
            // InternalTestLanguage.g:2032:2: ( ruleParameter )
            {
            // InternalTestLanguage.g:2032:2: ( ruleParameter )
            // InternalTestLanguage.g:2033:3: ruleParameter
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
    // InternalTestLanguage.g:2042:1: rule__Operation__ReturnTypeAssignment_6_1 : ( ruleType ) ;
    public final void rule__Operation__ReturnTypeAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2046:1: ( ( ruleType ) )
            // InternalTestLanguage.g:2047:2: ( ruleType )
            {
            // InternalTestLanguage.g:2047:2: ( ruleType )
            // InternalTestLanguage.g:2048:3: ruleType
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
    // InternalTestLanguage.g:2057:1: rule__Operation__OperationCallAssignment_8 : ( ruleOperationCall ) ;
    public final void rule__Operation__OperationCallAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2061:1: ( ( ruleOperationCall ) )
            // InternalTestLanguage.g:2062:2: ( ruleOperationCall )
            {
            // InternalTestLanguage.g:2062:2: ( ruleOperationCall )
            // InternalTestLanguage.g:2063:3: ruleOperationCall
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
    // InternalTestLanguage.g:2072:1: rule__OperationCall__OperationAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__OperationCall__OperationAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2076:1: ( ( ( RULE_ID ) ) )
            // InternalTestLanguage.g:2077:2: ( ( RULE_ID ) )
            {
            // InternalTestLanguage.g:2077:2: ( ( RULE_ID ) )
            // InternalTestLanguage.g:2078:3: ( RULE_ID )
            {
             before(grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_0_0()); 
            // InternalTestLanguage.g:2079:3: ( RULE_ID )
            // InternalTestLanguage.g:2080:4: RULE_ID
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
    // InternalTestLanguage.g:2091:1: rule__OperationCall__ParamsAssignment_2_0 : ( RULE_INT ) ;
    public final void rule__OperationCall__ParamsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2095:1: ( ( RULE_INT ) )
            // InternalTestLanguage.g:2096:2: ( RULE_INT )
            {
            // InternalTestLanguage.g:2096:2: ( RULE_INT )
            // InternalTestLanguage.g:2097:3: RULE_INT
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
    // InternalTestLanguage.g:2106:1: rule__OperationCall__ParamsAssignment_2_1_1 : ( RULE_INT ) ;
    public final void rule__OperationCall__ParamsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2110:1: ( ( RULE_INT ) )
            // InternalTestLanguage.g:2111:2: ( RULE_INT )
            {
            // InternalTestLanguage.g:2111:2: ( RULE_INT )
            // InternalTestLanguage.g:2112:3: RULE_INT
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
    // InternalTestLanguage.g:2121:1: rule__Parameter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2125:1: ( ( RULE_ID ) )
            // InternalTestLanguage.g:2126:2: ( RULE_ID )
            {
            // InternalTestLanguage.g:2126:2: ( RULE_ID )
            // InternalTestLanguage.g:2127:3: RULE_ID
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
    // InternalTestLanguage.g:2136:1: rule__Parameter__TypeAssignment_3 : ( ruleType ) ;
    public final void rule__Parameter__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2140:1: ( ( ruleType ) )
            // InternalTestLanguage.g:2141:2: ( ruleType )
            {
            // InternalTestLanguage.g:2141:2: ( ruleType )
            // InternalTestLanguage.g:2142:3: ruleType
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
    // InternalTestLanguage.g:2151:1: rule__TypeReference__TypeRefAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__TypeReference__TypeRefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2155:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTestLanguage.g:2156:2: ( ( ruleQualifiedName ) )
            {
            // InternalTestLanguage.g:2156:2: ( ( ruleQualifiedName ) )
            // InternalTestLanguage.g:2157:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0()); 
            // InternalTestLanguage.g:2158:3: ( ruleQualifiedName )
            // InternalTestLanguage.g:2159:4: ruleQualifiedName
            {
             before(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationQualifiedNameParserRuleCall_0_1()); 

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
    // InternalTestLanguage.g:2170:1: rule__PrimitiveType__NameAssignment : ( ( rule__PrimitiveType__NameAlternatives_0 ) ) ;
    public final void rule__PrimitiveType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTestLanguage.g:2174:1: ( ( ( rule__PrimitiveType__NameAlternatives_0 ) ) )
            // InternalTestLanguage.g:2175:2: ( ( rule__PrimitiveType__NameAlternatives_0 ) )
            {
            // InternalTestLanguage.g:2175:2: ( ( rule__PrimitiveType__NameAlternatives_0 ) )
            // InternalTestLanguage.g:2176:3: ( rule__PrimitiveType__NameAlternatives_0 )
            {
             before(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0()); 
            // InternalTestLanguage.g:2177:3: ( rule__PrimitiveType__NameAlternatives_0 )
            // InternalTestLanguage.g:2177:4: rule__PrimitiveType__NameAlternatives_0
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000048002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000068000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000090000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000227810L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000207812L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000207810L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000007810L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000004000002L});

}