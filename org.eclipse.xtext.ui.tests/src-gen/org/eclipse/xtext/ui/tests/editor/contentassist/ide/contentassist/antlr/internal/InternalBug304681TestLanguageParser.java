package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug304681TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBug304681TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'1'", "'2'", "'package'", "'object'", "'{'", "'}'", "'extends'", "'shortDescription'", "'longDescription'", "'serialUID'", "'before'", "'after'", "'optionalLoop'", "'mandatoryLoop'", "'Attribute'", "'Reference'", "'constraint'", "'parameters'", "'message'", "'enabled'", "'abstract'", "'cloneable'", "'*'", "'required'", "'technical'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalBug304681TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug304681TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug304681TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug304681TestLanguage.g"; }


    	private Bug304681TestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(Bug304681TestLanguageGrammarAccess grammarAccess) {
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
    // InternalBug304681TestLanguage.g:54:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:55:1: ( ruleModel EOF )
            // InternalBug304681TestLanguage.g:56:1: ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // InternalBug304681TestLanguage.g:63:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:67:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalBug304681TestLanguage.g:68:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalBug304681TestLanguage.g:68:2: ( ( rule__Model__Alternatives ) )
            // InternalBug304681TestLanguage.g:69:3: ( rule__Model__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getAlternatives()); 
            }
            // InternalBug304681TestLanguage.g:70:3: ( rule__Model__Alternatives )
            // InternalBug304681TestLanguage.g:70:4: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRulePackageDefinition"
    // InternalBug304681TestLanguage.g:79:1: entryRulePackageDefinition : rulePackageDefinition EOF ;
    public final void entryRulePackageDefinition() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:80:1: ( rulePackageDefinition EOF )
            // InternalBug304681TestLanguage.g:81:1: rulePackageDefinition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePackageDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePackageDefinition"


    // $ANTLR start "rulePackageDefinition"
    // InternalBug304681TestLanguage.g:88:1: rulePackageDefinition : ( ( rule__PackageDefinition__Group__0 ) ) ;
    public final void rulePackageDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:92:2: ( ( ( rule__PackageDefinition__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:93:2: ( ( rule__PackageDefinition__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:93:2: ( ( rule__PackageDefinition__Group__0 ) )
            // InternalBug304681TestLanguage.g:94:3: ( rule__PackageDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:95:3: ( rule__PackageDefinition__Group__0 )
            // InternalBug304681TestLanguage.g:95:4: rule__PackageDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDefinition"


    // $ANTLR start "entryRuleObject"
    // InternalBug304681TestLanguage.g:104:1: entryRuleObject : ruleObject EOF ;
    public final void entryRuleObject() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:105:1: ( ruleObject EOF )
            // InternalBug304681TestLanguage.g:106:1: ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalBug304681TestLanguage.g:113:1: ruleObject : ( ( rule__Object__Group__0 ) ) ;
    public final void ruleObject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:117:2: ( ( ( rule__Object__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:118:2: ( ( rule__Object__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:118:2: ( ( rule__Object__Group__0 ) )
            // InternalBug304681TestLanguage.g:119:3: ( rule__Object__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:120:3: ( rule__Object__Group__0 )
            // InternalBug304681TestLanguage.g:120:4: rule__Object__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleFeature"
    // InternalBug304681TestLanguage.g:129:1: entryRuleFeature : ruleFeature EOF ;
    public final void entryRuleFeature() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:130:1: ( ruleFeature EOF )
            // InternalBug304681TestLanguage.g:131:1: ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalBug304681TestLanguage.g:138:1: ruleFeature : ( ( rule__Feature__Alternatives ) ) ;
    public final void ruleFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:142:2: ( ( ( rule__Feature__Alternatives ) ) )
            // InternalBug304681TestLanguage.g:143:2: ( ( rule__Feature__Alternatives ) )
            {
            // InternalBug304681TestLanguage.g:143:2: ( ( rule__Feature__Alternatives ) )
            // InternalBug304681TestLanguage.g:144:3: ( rule__Feature__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeatureAccess().getAlternatives()); 
            }
            // InternalBug304681TestLanguage.g:145:3: ( rule__Feature__Alternatives )
            // InternalBug304681TestLanguage.g:145:4: rule__Feature__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Feature__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeatureAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug304681TestLanguage.g:154:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:155:1: ( ruleAttribute EOF )
            // InternalBug304681TestLanguage.g:156:1: ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttribute();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBug304681TestLanguage.g:163:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:167:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:168:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:168:2: ( ( rule__Attribute__Group__0 ) )
            // InternalBug304681TestLanguage.g:169:3: ( rule__Attribute__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:170:3: ( rule__Attribute__Group__0 )
            // InternalBug304681TestLanguage.g:170:4: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleReference"
    // InternalBug304681TestLanguage.g:179:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:180:1: ( ruleReference EOF )
            // InternalBug304681TestLanguage.g:181:1: ruleReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalBug304681TestLanguage.g:188:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:192:2: ( ( ( rule__Reference__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:193:2: ( ( rule__Reference__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:193:2: ( ( rule__Reference__Group__0 ) )
            // InternalBug304681TestLanguage.g:194:3: ( rule__Reference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:195:3: ( rule__Reference__Group__0 )
            // InternalBug304681TestLanguage.g:195:4: rule__Reference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRulePackageDefinition2"
    // InternalBug304681TestLanguage.g:204:1: entryRulePackageDefinition2 : rulePackageDefinition2 EOF ;
    public final void entryRulePackageDefinition2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:205:1: ( rulePackageDefinition2 EOF )
            // InternalBug304681TestLanguage.g:206:1: rulePackageDefinition2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            rulePackageDefinition2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRulePackageDefinition2"


    // $ANTLR start "rulePackageDefinition2"
    // InternalBug304681TestLanguage.g:213:1: rulePackageDefinition2 : ( ( rule__PackageDefinition2__Group__0 ) ) ;
    public final void rulePackageDefinition2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:217:2: ( ( ( rule__PackageDefinition2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:218:2: ( ( rule__PackageDefinition2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:218:2: ( ( rule__PackageDefinition2__Group__0 ) )
            // InternalBug304681TestLanguage.g:219:3: ( rule__PackageDefinition2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:220:3: ( rule__PackageDefinition2__Group__0 )
            // InternalBug304681TestLanguage.g:220:4: rule__PackageDefinition2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDefinition2"


    // $ANTLR start "entryRuleObject2"
    // InternalBug304681TestLanguage.g:229:1: entryRuleObject2 : ruleObject2 EOF ;
    public final void entryRuleObject2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:230:1: ( ruleObject2 EOF )
            // InternalBug304681TestLanguage.g:231:1: ruleObject2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObject2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleObject2"


    // $ANTLR start "ruleObject2"
    // InternalBug304681TestLanguage.g:238:1: ruleObject2 : ( ( rule__Object2__Group__0 ) ) ;
    public final void ruleObject2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:242:2: ( ( ( rule__Object2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:243:2: ( ( rule__Object2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:243:2: ( ( rule__Object2__Group__0 ) )
            // InternalBug304681TestLanguage.g:244:3: ( rule__Object2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:245:3: ( rule__Object2__Group__0 )
            // InternalBug304681TestLanguage.g:245:4: rule__Object2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObject2"


    // $ANTLR start "entryRuleFeature2"
    // InternalBug304681TestLanguage.g:254:1: entryRuleFeature2 : ruleFeature2 EOF ;
    public final void entryRuleFeature2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:255:1: ( ruleFeature2 EOF )
            // InternalBug304681TestLanguage.g:256:1: ruleFeature2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeature2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleFeature2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeature2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleFeature2"


    // $ANTLR start "ruleFeature2"
    // InternalBug304681TestLanguage.g:263:1: ruleFeature2 : ( ( rule__Feature2__Alternatives ) ) ;
    public final void ruleFeature2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:267:2: ( ( ( rule__Feature2__Alternatives ) ) )
            // InternalBug304681TestLanguage.g:268:2: ( ( rule__Feature2__Alternatives ) )
            {
            // InternalBug304681TestLanguage.g:268:2: ( ( rule__Feature2__Alternatives ) )
            // InternalBug304681TestLanguage.g:269:3: ( rule__Feature2__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getFeature2Access().getAlternatives()); 
            }
            // InternalBug304681TestLanguage.g:270:3: ( rule__Feature2__Alternatives )
            // InternalBug304681TestLanguage.g:270:4: rule__Feature2__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Feature2__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getFeature2Access().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFeature2"


    // $ANTLR start "entryRuleAttribute2"
    // InternalBug304681TestLanguage.g:279:1: entryRuleAttribute2 : ruleAttribute2 EOF ;
    public final void entryRuleAttribute2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:280:1: ( ruleAttribute2 EOF )
            // InternalBug304681TestLanguage.g:281:1: ruleAttribute2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAttribute2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleAttribute2"


    // $ANTLR start "ruleAttribute2"
    // InternalBug304681TestLanguage.g:288:1: ruleAttribute2 : ( ( rule__Attribute2__Group__0 ) ) ;
    public final void ruleAttribute2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:292:2: ( ( ( rule__Attribute2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:293:2: ( ( rule__Attribute2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:293:2: ( ( rule__Attribute2__Group__0 ) )
            // InternalBug304681TestLanguage.g:294:3: ( rule__Attribute2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:295:3: ( rule__Attribute2__Group__0 )
            // InternalBug304681TestLanguage.g:295:4: rule__Attribute2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute2"


    // $ANTLR start "entryRuleReference2"
    // InternalBug304681TestLanguage.g:304:1: entryRuleReference2 : ruleReference2 EOF ;
    public final void entryRuleReference2() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:305:1: ( ruleReference2 EOF )
            // InternalBug304681TestLanguage.g:306:1: ruleReference2 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Rule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReference2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Rule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleReference2"


    // $ANTLR start "ruleReference2"
    // InternalBug304681TestLanguage.g:313:1: ruleReference2 : ( ( rule__Reference2__Group__0 ) ) ;
    public final void ruleReference2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:317:2: ( ( ( rule__Reference2__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:318:2: ( ( rule__Reference2__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:318:2: ( ( rule__Reference2__Group__0 ) )
            // InternalBug304681TestLanguage.g:319:3: ( rule__Reference2__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:320:3: ( rule__Reference2__Group__0 )
            // InternalBug304681TestLanguage.g:320:4: rule__Reference2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference2"


    // $ANTLR start "entryRuleConstraintDefinition"
    // InternalBug304681TestLanguage.g:329:1: entryRuleConstraintDefinition : ruleConstraintDefinition EOF ;
    public final void entryRuleConstraintDefinition() throws RecognitionException {
        try {
            // InternalBug304681TestLanguage.g:330:1: ( ruleConstraintDefinition EOF )
            // InternalBug304681TestLanguage.g:331:1: ruleConstraintDefinition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConstraintDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return ;

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
    // $ANTLR end "entryRuleConstraintDefinition"


    // $ANTLR start "ruleConstraintDefinition"
    // InternalBug304681TestLanguage.g:338:1: ruleConstraintDefinition : ( ( rule__ConstraintDefinition__Group__0 ) ) ;
    public final void ruleConstraintDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:342:2: ( ( ( rule__ConstraintDefinition__Group__0 ) ) )
            // InternalBug304681TestLanguage.g:343:2: ( ( rule__ConstraintDefinition__Group__0 ) )
            {
            // InternalBug304681TestLanguage.g:343:2: ( ( rule__ConstraintDefinition__Group__0 ) )
            // InternalBug304681TestLanguage.g:344:3: ( rule__ConstraintDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getGroup()); 
            }
            // InternalBug304681TestLanguage.g:345:3: ( rule__ConstraintDefinition__Group__0 )
            // InternalBug304681TestLanguage.g:345:4: rule__ConstraintDefinition__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintDefinition"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalBug304681TestLanguage.g:353:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:357:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBug304681TestLanguage.g:358:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:358:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalBug304681TestLanguage.g:359:3: ( rule__Model__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_0()); 
                    }
                    // InternalBug304681TestLanguage.g:360:3: ( rule__Model__Group_0__0 )
                    // InternalBug304681TestLanguage.g:360:4: rule__Model__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:364:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:364:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalBug304681TestLanguage.g:365:3: ( rule__Model__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModelAccess().getGroup_1()); 
                    }
                    // InternalBug304681TestLanguage.g:366:3: ( rule__Model__Group_1__0 )
                    // InternalBug304681TestLanguage.g:366:4: rule__Model__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModelAccess().getGroup_1()); 
                    }

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


    // $ANTLR start "rule__Object__Alternatives_0"
    // InternalBug304681TestLanguage.g:374:1: rule__Object__Alternatives_0 : ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) );
    public final void rule__Object__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:378:1: ( ( ( rule__Object__EnabledAssignment_0_0 ) ) | ( ( rule__Object__AbstractAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==31) ) {
                alt2=1;
            }
            else if ( (LA2_0==32) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug304681TestLanguage.g:379:2: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    {
                    // InternalBug304681TestLanguage.g:379:2: ( ( rule__Object__EnabledAssignment_0_0 ) )
                    // InternalBug304681TestLanguage.g:380:3: ( rule__Object__EnabledAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 
                    }
                    // InternalBug304681TestLanguage.g:381:3: ( rule__Object__EnabledAssignment_0_0 )
                    // InternalBug304681TestLanguage.g:381:4: rule__Object__EnabledAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__EnabledAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getEnabledAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:385:2: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    {
                    // InternalBug304681TestLanguage.g:385:2: ( ( rule__Object__AbstractAssignment_0_1 ) )
                    // InternalBug304681TestLanguage.g:386:3: ( rule__Object__AbstractAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getAbstractAssignment_0_1()); 
                    }
                    // InternalBug304681TestLanguage.g:387:3: ( rule__Object__AbstractAssignment_0_1 )
                    // InternalBug304681TestLanguage.g:387:4: rule__Object__AbstractAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__AbstractAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getAbstractAssignment_0_1()); 
                    }

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
    // $ANTLR end "rule__Object__Alternatives_0"


    // $ANTLR start "rule__Feature__Alternatives"
    // InternalBug304681TestLanguage.g:395:1: rule__Feature__Alternatives : ( ( ruleAttribute ) | ( ruleReference ) );
    public final void rule__Feature__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:399:1: ( ( ruleAttribute ) | ( ruleReference ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==26) ) {
                alt3=1;
            }
            else if ( (LA3_0==27) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug304681TestLanguage.g:400:2: ( ruleAttribute )
                    {
                    // InternalBug304681TestLanguage.g:400:2: ( ruleAttribute )
                    // InternalBug304681TestLanguage.g:401:3: ruleAttribute
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAttribute();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:406:2: ( ruleReference )
                    {
                    // InternalBug304681TestLanguage.g:406:2: ( ruleReference )
                    // InternalBug304681TestLanguage.g:407:3: ruleReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__Feature__Alternatives"


    // $ANTLR start "rule__Reference__Alternatives_4"
    // InternalBug304681TestLanguage.g:416:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:420:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ';' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug304681TestLanguage.g:421:2: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:421:2: ( ( rule__Reference__Group_4_0__0 ) )
                    // InternalBug304681TestLanguage.g:422:3: ( rule__Reference__Group_4_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    }
                    // InternalBug304681TestLanguage.g:423:3: ( rule__Reference__Group_4_0__0 )
                    // InternalBug304681TestLanguage.g:423:4: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__Group_4_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:427:2: ( ';' )
                    {
                    // InternalBug304681TestLanguage.g:427:2: ( ';' )
                    // InternalBug304681TestLanguage.g:428:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1()); 
                    }

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
    // $ANTLR end "rule__Reference__Alternatives_4"


    // $ANTLR start "rule__Object2__Alternatives_0"
    // InternalBug304681TestLanguage.g:437:1: rule__Object2__Alternatives_0 : ( ( ( rule__Object2__EnabledAssignment_0_0 ) ) | ( ( rule__Object2__AbstractAssignment_0_1 ) ) );
    public final void rule__Object2__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:441:1: ( ( ( rule__Object2__EnabledAssignment_0_0 ) ) | ( ( rule__Object2__AbstractAssignment_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==31) ) {
                alt5=1;
            }
            else if ( (LA5_0==32) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug304681TestLanguage.g:442:2: ( ( rule__Object2__EnabledAssignment_0_0 ) )
                    {
                    // InternalBug304681TestLanguage.g:442:2: ( ( rule__Object2__EnabledAssignment_0_0 ) )
                    // InternalBug304681TestLanguage.g:443:3: ( rule__Object2__EnabledAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getEnabledAssignment_0_0()); 
                    }
                    // InternalBug304681TestLanguage.g:444:3: ( rule__Object2__EnabledAssignment_0_0 )
                    // InternalBug304681TestLanguage.g:444:4: rule__Object2__EnabledAssignment_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__EnabledAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getEnabledAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:448:2: ( ( rule__Object2__AbstractAssignment_0_1 ) )
                    {
                    // InternalBug304681TestLanguage.g:448:2: ( ( rule__Object2__AbstractAssignment_0_1 ) )
                    // InternalBug304681TestLanguage.g:449:3: ( rule__Object2__AbstractAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getAbstractAssignment_0_1()); 
                    }
                    // InternalBug304681TestLanguage.g:450:3: ( rule__Object2__AbstractAssignment_0_1 )
                    // InternalBug304681TestLanguage.g:450:4: rule__Object2__AbstractAssignment_0_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__AbstractAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getAbstractAssignment_0_1()); 
                    }

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
    // $ANTLR end "rule__Object2__Alternatives_0"


    // $ANTLR start "rule__Feature2__Alternatives"
    // InternalBug304681TestLanguage.g:458:1: rule__Feature2__Alternatives : ( ( ruleAttribute2 ) | ( ruleReference2 ) );
    public final void rule__Feature2__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:462:1: ( ( ruleAttribute2 ) | ( ruleReference2 ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            else if ( (LA6_0==27) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug304681TestLanguage.g:463:2: ( ruleAttribute2 )
                    {
                    // InternalBug304681TestLanguage.g:463:2: ( ruleAttribute2 )
                    // InternalBug304681TestLanguage.g:464:3: ruleAttribute2
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAttribute2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:469:2: ( ruleReference2 )
                    {
                    // InternalBug304681TestLanguage.g:469:2: ( ruleReference2 )
                    // InternalBug304681TestLanguage.g:470:3: ruleReference2
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReference2();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__Feature2__Alternatives"


    // $ANTLR start "rule__Attribute2__Alternatives_3"
    // InternalBug304681TestLanguage.g:479:1: rule__Attribute2__Alternatives_3 : ( ( ( rule__Attribute2__Group_3_0__0 ) ) | ( ';' ) );
    public final void rule__Attribute2__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:483:1: ( ( ( rule__Attribute2__Group_3_0__0 ) ) | ( ';' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==11) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug304681TestLanguage.g:484:2: ( ( rule__Attribute2__Group_3_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:484:2: ( ( rule__Attribute2__Group_3_0__0 ) )
                    // InternalBug304681TestLanguage.g:485:3: ( rule__Attribute2__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0()); 
                    }
                    // InternalBug304681TestLanguage.g:486:3: ( rule__Attribute2__Group_3_0__0 )
                    // InternalBug304681TestLanguage.g:486:4: rule__Attribute2__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:490:2: ( ';' )
                    {
                    // InternalBug304681TestLanguage.g:490:2: ( ';' )
                    // InternalBug304681TestLanguage.g:491:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1()); 
                    }

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
    // $ANTLR end "rule__Attribute2__Alternatives_3"


    // $ANTLR start "rule__Reference2__Alternatives_4"
    // InternalBug304681TestLanguage.g:500:1: rule__Reference2__Alternatives_4 : ( ( ( rule__Reference2__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Reference2__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:504:1: ( ( ( rule__Reference2__Group_4_0__0 ) ) | ( ';' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( (LA8_0==11) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug304681TestLanguage.g:505:2: ( ( rule__Reference2__Group_4_0__0 ) )
                    {
                    // InternalBug304681TestLanguage.g:505:2: ( ( rule__Reference2__Group_4_0__0 ) )
                    // InternalBug304681TestLanguage.g:506:3: ( rule__Reference2__Group_4_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getGroup_4_0()); 
                    }
                    // InternalBug304681TestLanguage.g:507:3: ( rule__Reference2__Group_4_0__0 )
                    // InternalBug304681TestLanguage.g:507:4: rule__Reference2__Group_4_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__Group_4_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getGroup_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:511:2: ( ';' )
                    {
                    // InternalBug304681TestLanguage.g:511:2: ( ';' )
                    // InternalBug304681TestLanguage.g:512:3: ';'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getSemicolonKeyword_4_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getSemicolonKeyword_4_1()); 
                    }

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
    // $ANTLR end "rule__Reference2__Alternatives_4"


    // $ANTLR start "rule__Model__Group_0__0"
    // InternalBug304681TestLanguage.g:521:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:525:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalBug304681TestLanguage.g:526:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalBug304681TestLanguage.g:533:1: rule__Model__Group_0__0__Impl : ( '1' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:537:1: ( ( '1' ) )
            // InternalBug304681TestLanguage.g:538:1: ( '1' )
            {
            // InternalBug304681TestLanguage.g:538:1: ( '1' )
            // InternalBug304681TestLanguage.g:539:2: '1'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            }
            match(input,12,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitOneKeyword_0_0()); 
            }

            }


            }

        }
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
    // InternalBug304681TestLanguage.g:548:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:552:1: ( rule__Model__Group_0__1__Impl )
            // InternalBug304681TestLanguage.g:553:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalBug304681TestLanguage.g:559:1: rule__Model__Group_0__1__Impl : ( ( rule__Model__DefinitionAssignment_0_1 ) ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:563:1: ( ( ( rule__Model__DefinitionAssignment_0_1 ) ) )
            // InternalBug304681TestLanguage.g:564:1: ( ( rule__Model__DefinitionAssignment_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:564:1: ( ( rule__Model__DefinitionAssignment_0_1 ) )
            // InternalBug304681TestLanguage.g:565:2: ( rule__Model__DefinitionAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionAssignment_0_1()); 
            }
            // InternalBug304681TestLanguage.g:566:2: ( rule__Model__DefinitionAssignment_0_1 )
            // InternalBug304681TestLanguage.g:566:3: rule__Model__DefinitionAssignment_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__DefinitionAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionAssignment_0_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Model__Group_1__0"
    // InternalBug304681TestLanguage.g:575:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:579:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalBug304681TestLanguage.g:580:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalBug304681TestLanguage.g:587:1: rule__Model__Group_1__0__Impl : ( '2' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:591:1: ( ( '2' ) )
            // InternalBug304681TestLanguage.g:592:1: ( '2' )
            {
            // InternalBug304681TestLanguage.g:592:1: ( '2' )
            // InternalBug304681TestLanguage.g:593:2: '2'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0()); 
            }

            }


            }

        }
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
    // InternalBug304681TestLanguage.g:602:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:606:1: ( rule__Model__Group_1__1__Impl )
            // InternalBug304681TestLanguage.g:607:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // InternalBug304681TestLanguage.g:613:1: rule__Model__Group_1__1__Impl : ( ( rule__Model__DefinitionAssignment_1_1 ) ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:617:1: ( ( ( rule__Model__DefinitionAssignment_1_1 ) ) )
            // InternalBug304681TestLanguage.g:618:1: ( ( rule__Model__DefinitionAssignment_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:618:1: ( ( rule__Model__DefinitionAssignment_1_1 ) )
            // InternalBug304681TestLanguage.g:619:2: ( rule__Model__DefinitionAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionAssignment_1_1()); 
            }
            // InternalBug304681TestLanguage.g:620:2: ( rule__Model__DefinitionAssignment_1_1 )
            // InternalBug304681TestLanguage.g:620:3: rule__Model__DefinitionAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__DefinitionAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionAssignment_1_1()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__PackageDefinition__Group__0"
    // InternalBug304681TestLanguage.g:629:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:633:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // InternalBug304681TestLanguage.g:634:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__0"


    // $ANTLR start "rule__PackageDefinition__Group__0__Impl"
    // InternalBug304681TestLanguage.g:641:1: rule__PackageDefinition__Group__0__Impl : ( () ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:645:1: ( ( () ) )
            // InternalBug304681TestLanguage.g:646:1: ( () )
            {
            // InternalBug304681TestLanguage.g:646:1: ( () )
            // InternalBug304681TestLanguage.g:647:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 
            }
            // InternalBug304681TestLanguage.g:648:2: ()
            // InternalBug304681TestLanguage.g:648:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__0__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__1"
    // InternalBug304681TestLanguage.g:656:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:660:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // InternalBug304681TestLanguage.g:661:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__1"


    // $ANTLR start "rule__PackageDefinition__Group__1__Impl"
    // InternalBug304681TestLanguage.g:668:1: rule__PackageDefinition__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:672:1: ( ( 'package' ) )
            // InternalBug304681TestLanguage.g:673:1: ( 'package' )
            {
            // InternalBug304681TestLanguage.g:673:1: ( 'package' )
            // InternalBug304681TestLanguage.g:674:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 
            }
            match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__1__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__2"
    // InternalBug304681TestLanguage.g:683:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:687:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // InternalBug304681TestLanguage.g:688:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__2"


    // $ANTLR start "rule__PackageDefinition__Group__2__Impl"
    // InternalBug304681TestLanguage.g:695:1: rule__PackageDefinition__Group__2__Impl : ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:699:1: ( ( ( rule__PackageDefinition__NamespaceAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:700:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:700:1: ( ( rule__PackageDefinition__NamespaceAssignment_2 ) )
            // InternalBug304681TestLanguage.g:701:2: ( rule__PackageDefinition__NamespaceAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:702:2: ( rule__PackageDefinition__NamespaceAssignment_2 )
            // InternalBug304681TestLanguage.g:702:3: rule__PackageDefinition__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__NamespaceAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getNamespaceAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__2__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__3"
    // InternalBug304681TestLanguage.g:710:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:714:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // InternalBug304681TestLanguage.g:715:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__3"


    // $ANTLR start "rule__PackageDefinition__Group__3__Impl"
    // InternalBug304681TestLanguage.g:722:1: rule__PackageDefinition__Group__3__Impl : ( ';' ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:726:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:727:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:727:1: ( ';' )
            // InternalBug304681TestLanguage.g:728:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__3__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__4"
    // InternalBug304681TestLanguage.g:737:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:741:1: ( rule__PackageDefinition__Group__4__Impl )
            // InternalBug304681TestLanguage.g:742:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__4"


    // $ANTLR start "rule__PackageDefinition__Group__4__Impl"
    // InternalBug304681TestLanguage.g:748:1: rule__PackageDefinition__Group__4__Impl : ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:752:1: ( ( ( rule__PackageDefinition__ContentsAssignment_4 )* ) )
            // InternalBug304681TestLanguage.g:753:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            {
            // InternalBug304681TestLanguage.g:753:1: ( ( rule__PackageDefinition__ContentsAssignment_4 )* )
            // InternalBug304681TestLanguage.g:754:2: ( rule__PackageDefinition__ContentsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4()); 
            }
            // InternalBug304681TestLanguage.g:755:2: ( rule__PackageDefinition__ContentsAssignment_4 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15||(LA9_0>=31 && LA9_0<=32)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:755:3: rule__PackageDefinition__ContentsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__PackageDefinition__ContentsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getContentsAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__4__Impl"


    // $ANTLR start "rule__Object__Group__0"
    // InternalBug304681TestLanguage.g:764:1: rule__Object__Group__0 : rule__Object__Group__0__Impl rule__Object__Group__1 ;
    public final void rule__Object__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:768:1: ( rule__Object__Group__0__Impl rule__Object__Group__1 )
            // InternalBug304681TestLanguage.g:769:2: rule__Object__Group__0__Impl rule__Object__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Object__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__0"


    // $ANTLR start "rule__Object__Group__0__Impl"
    // InternalBug304681TestLanguage.g:776:1: rule__Object__Group__0__Impl : ( ( rule__Object__Alternatives_0 )? ) ;
    public final void rule__Object__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:780:1: ( ( ( rule__Object__Alternatives_0 )? ) )
            // InternalBug304681TestLanguage.g:781:1: ( ( rule__Object__Alternatives_0 )? )
            {
            // InternalBug304681TestLanguage.g:781:1: ( ( rule__Object__Alternatives_0 )? )
            // InternalBug304681TestLanguage.g:782:2: ( rule__Object__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAlternatives_0()); 
            }
            // InternalBug304681TestLanguage.g:783:2: ( rule__Object__Alternatives_0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=31 && LA10_0<=32)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBug304681TestLanguage.g:783:3: rule__Object__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__0__Impl"


    // $ANTLR start "rule__Object__Group__1"
    // InternalBug304681TestLanguage.g:791:1: rule__Object__Group__1 : rule__Object__Group__1__Impl rule__Object__Group__2 ;
    public final void rule__Object__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:795:1: ( rule__Object__Group__1__Impl rule__Object__Group__2 )
            // InternalBug304681TestLanguage.g:796:2: rule__Object__Group__1__Impl rule__Object__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__1"


    // $ANTLR start "rule__Object__Group__1__Impl"
    // InternalBug304681TestLanguage.g:803:1: rule__Object__Group__1__Impl : ( 'object' ) ;
    public final void rule__Object__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:807:1: ( ( 'object' ) )
            // InternalBug304681TestLanguage.g:808:1: ( 'object' )
            {
            // InternalBug304681TestLanguage.g:808:1: ( 'object' )
            // InternalBug304681TestLanguage.g:809:2: 'object'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getObjectKeyword_1()); 
            }
            match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getObjectKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__1__Impl"


    // $ANTLR start "rule__Object__Group__2"
    // InternalBug304681TestLanguage.g:818:1: rule__Object__Group__2 : rule__Object__Group__2__Impl rule__Object__Group__3 ;
    public final void rule__Object__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:822:1: ( rule__Object__Group__2__Impl rule__Object__Group__3 )
            // InternalBug304681TestLanguage.g:823:2: rule__Object__Group__2__Impl rule__Object__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__2"


    // $ANTLR start "rule__Object__Group__2__Impl"
    // InternalBug304681TestLanguage.g:830:1: rule__Object__Group__2__Impl : ( ( rule__Object__NameAssignment_2 ) ) ;
    public final void rule__Object__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:834:1: ( ( ( rule__Object__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:835:1: ( ( rule__Object__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:835:1: ( ( rule__Object__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:836:2: ( rule__Object__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:837:2: ( rule__Object__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:837:3: rule__Object__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__2__Impl"


    // $ANTLR start "rule__Object__Group__3"
    // InternalBug304681TestLanguage.g:845:1: rule__Object__Group__3 : rule__Object__Group__3__Impl rule__Object__Group__4 ;
    public final void rule__Object__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:849:1: ( rule__Object__Group__3__Impl rule__Object__Group__4 )
            // InternalBug304681TestLanguage.g:850:2: rule__Object__Group__3__Impl rule__Object__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__3"


    // $ANTLR start "rule__Object__Group__3__Impl"
    // InternalBug304681TestLanguage.g:857:1: rule__Object__Group__3__Impl : ( ( rule__Object__Group_3__0 )? ) ;
    public final void rule__Object__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:861:1: ( ( ( rule__Object__Group_3__0 )? ) )
            // InternalBug304681TestLanguage.g:862:1: ( ( rule__Object__Group_3__0 )? )
            {
            // InternalBug304681TestLanguage.g:862:1: ( ( rule__Object__Group_3__0 )? )
            // InternalBug304681TestLanguage.g:863:2: ( rule__Object__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getGroup_3()); 
            }
            // InternalBug304681TestLanguage.g:864:2: ( rule__Object__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBug304681TestLanguage.g:864:3: rule__Object__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__3__Impl"


    // $ANTLR start "rule__Object__Group__4"
    // InternalBug304681TestLanguage.g:872:1: rule__Object__Group__4 : rule__Object__Group__4__Impl rule__Object__Group__5 ;
    public final void rule__Object__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:876:1: ( rule__Object__Group__4__Impl rule__Object__Group__5 )
            // InternalBug304681TestLanguage.g:877:2: rule__Object__Group__4__Impl rule__Object__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__Object__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__4"


    // $ANTLR start "rule__Object__Group__4__Impl"
    // InternalBug304681TestLanguage.g:884:1: rule__Object__Group__4__Impl : ( '{' ) ;
    public final void rule__Object__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:888:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:889:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:889:1: ( '{' )
            // InternalBug304681TestLanguage.g:890:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__4__Impl"


    // $ANTLR start "rule__Object__Group__5"
    // InternalBug304681TestLanguage.g:899:1: rule__Object__Group__5 : rule__Object__Group__5__Impl rule__Object__Group__6 ;
    public final void rule__Object__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:903:1: ( rule__Object__Group__5__Impl rule__Object__Group__6 )
            // InternalBug304681TestLanguage.g:904:2: rule__Object__Group__5__Impl rule__Object__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Object__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__5"


    // $ANTLR start "rule__Object__Group__5__Impl"
    // InternalBug304681TestLanguage.g:911:1: rule__Object__Group__5__Impl : ( ( rule__Object__UnorderedGroup_5 ) ) ;
    public final void rule__Object__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:915:1: ( ( ( rule__Object__UnorderedGroup_5 ) ) )
            // InternalBug304681TestLanguage.g:916:1: ( ( rule__Object__UnorderedGroup_5 ) )
            {
            // InternalBug304681TestLanguage.g:916:1: ( ( rule__Object__UnorderedGroup_5 ) )
            // InternalBug304681TestLanguage.g:917:2: ( rule__Object__UnorderedGroup_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 
            }
            // InternalBug304681TestLanguage.g:918:2: ( rule__Object__UnorderedGroup_5 )
            // InternalBug304681TestLanguage.g:918:3: rule__Object__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__UnorderedGroup_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getUnorderedGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__5__Impl"


    // $ANTLR start "rule__Object__Group__6"
    // InternalBug304681TestLanguage.g:926:1: rule__Object__Group__6 : rule__Object__Group__6__Impl ;
    public final void rule__Object__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:930:1: ( rule__Object__Group__6__Impl )
            // InternalBug304681TestLanguage.g:931:2: rule__Object__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__6"


    // $ANTLR start "rule__Object__Group__6__Impl"
    // InternalBug304681TestLanguage.g:937:1: rule__Object__Group__6__Impl : ( '}' ) ;
    public final void rule__Object__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:941:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:942:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:942:1: ( '}' )
            // InternalBug304681TestLanguage.g:943:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group__6__Impl"


    // $ANTLR start "rule__Object__Group_3__0"
    // InternalBug304681TestLanguage.g:953:1: rule__Object__Group_3__0 : rule__Object__Group_3__0__Impl rule__Object__Group_3__1 ;
    public final void rule__Object__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:957:1: ( rule__Object__Group_3__0__Impl rule__Object__Group_3__1 )
            // InternalBug304681TestLanguage.g:958:2: rule__Object__Group_3__0__Impl rule__Object__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_3__0"


    // $ANTLR start "rule__Object__Group_3__0__Impl"
    // InternalBug304681TestLanguage.g:965:1: rule__Object__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__Object__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:969:1: ( ( 'extends' ) )
            // InternalBug304681TestLanguage.g:970:1: ( 'extends' )
            {
            // InternalBug304681TestLanguage.g:970:1: ( 'extends' )
            // InternalBug304681TestLanguage.g:971:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getExtendsKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_3__0__Impl"


    // $ANTLR start "rule__Object__Group_3__1"
    // InternalBug304681TestLanguage.g:980:1: rule__Object__Group_3__1 : rule__Object__Group_3__1__Impl ;
    public final void rule__Object__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:984:1: ( rule__Object__Group_3__1__Impl )
            // InternalBug304681TestLanguage.g:985:2: rule__Object__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_3__1"


    // $ANTLR start "rule__Object__Group_3__1__Impl"
    // InternalBug304681TestLanguage.g:991:1: rule__Object__Group_3__1__Impl : ( ( rule__Object__ParentAssignment_3_1 ) ) ;
    public final void rule__Object__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:995:1: ( ( ( rule__Object__ParentAssignment_3_1 ) ) )
            // InternalBug304681TestLanguage.g:996:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            {
            // InternalBug304681TestLanguage.g:996:1: ( ( rule__Object__ParentAssignment_3_1 ) )
            // InternalBug304681TestLanguage.g:997:2: ( rule__Object__ParentAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getParentAssignment_3_1()); 
            }
            // InternalBug304681TestLanguage.g:998:2: ( rule__Object__ParentAssignment_3_1 )
            // InternalBug304681TestLanguage.g:998:3: rule__Object__ParentAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__ParentAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getParentAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_3__1__Impl"


    // $ANTLR start "rule__Object__Group_5_0__0"
    // InternalBug304681TestLanguage.g:1007:1: rule__Object__Group_5_0__0 : rule__Object__Group_5_0__0__Impl rule__Object__Group_5_0__1 ;
    public final void rule__Object__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1011:1: ( rule__Object__Group_5_0__0__Impl rule__Object__Group_5_0__1 )
            // InternalBug304681TestLanguage.g:1012:2: rule__Object__Group_5_0__0__Impl rule__Object__Group_5_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object__Group_5_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__0"


    // $ANTLR start "rule__Object__Group_5_0__0__Impl"
    // InternalBug304681TestLanguage.g:1019:1: rule__Object__Group_5_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Object__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1023:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:1024:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:1024:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:1025:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__0__Impl"


    // $ANTLR start "rule__Object__Group_5_0__1"
    // InternalBug304681TestLanguage.g:1034:1: rule__Object__Group_5_0__1 : rule__Object__Group_5_0__1__Impl rule__Object__Group_5_0__2 ;
    public final void rule__Object__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1038:1: ( rule__Object__Group_5_0__1__Impl rule__Object__Group_5_0__2 )
            // InternalBug304681TestLanguage.g:1039:2: rule__Object__Group_5_0__1__Impl rule__Object__Group_5_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__1"


    // $ANTLR start "rule__Object__Group_5_0__1__Impl"
    // InternalBug304681TestLanguage.g:1046:1: rule__Object__Group_5_0__1__Impl : ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) ;
    public final void rule__Object__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1050:1: ( ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) ) )
            // InternalBug304681TestLanguage.g:1051:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:1051:1: ( ( rule__Object__ShortDescriptionAssignment_5_0_1 ) )
            // InternalBug304681TestLanguage.g:1052:2: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 
            }
            // InternalBug304681TestLanguage.g:1053:2: ( rule__Object__ShortDescriptionAssignment_5_0_1 )
            // InternalBug304681TestLanguage.g:1053:3: rule__Object__ShortDescriptionAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__ShortDescriptionAssignment_5_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getShortDescriptionAssignment_5_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__1__Impl"


    // $ANTLR start "rule__Object__Group_5_0__2"
    // InternalBug304681TestLanguage.g:1061:1: rule__Object__Group_5_0__2 : rule__Object__Group_5_0__2__Impl ;
    public final void rule__Object__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1065:1: ( rule__Object__Group_5_0__2__Impl )
            // InternalBug304681TestLanguage.g:1066:2: rule__Object__Group_5_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__2"


    // $ANTLR start "rule__Object__Group_5_0__2__Impl"
    // InternalBug304681TestLanguage.g:1072:1: rule__Object__Group_5_0__2__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1076:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1077:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1077:1: ( ';' )
            // InternalBug304681TestLanguage.g:1078:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_0__2__Impl"


    // $ANTLR start "rule__Object__Group_5_1__0"
    // InternalBug304681TestLanguage.g:1088:1: rule__Object__Group_5_1__0 : rule__Object__Group_5_1__0__Impl rule__Object__Group_5_1__1 ;
    public final void rule__Object__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1092:1: ( rule__Object__Group_5_1__0__Impl rule__Object__Group_5_1__1 )
            // InternalBug304681TestLanguage.g:1093:2: rule__Object__Group_5_1__0__Impl rule__Object__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object__Group_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__0"


    // $ANTLR start "rule__Object__Group_5_1__0__Impl"
    // InternalBug304681TestLanguage.g:1100:1: rule__Object__Group_5_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Object__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1104:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:1105:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:1105:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:1106:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__0__Impl"


    // $ANTLR start "rule__Object__Group_5_1__1"
    // InternalBug304681TestLanguage.g:1115:1: rule__Object__Group_5_1__1 : rule__Object__Group_5_1__1__Impl rule__Object__Group_5_1__2 ;
    public final void rule__Object__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1119:1: ( rule__Object__Group_5_1__1__Impl rule__Object__Group_5_1__2 )
            // InternalBug304681TestLanguage.g:1120:2: rule__Object__Group_5_1__1__Impl rule__Object__Group_5_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__1"


    // $ANTLR start "rule__Object__Group_5_1__1__Impl"
    // InternalBug304681TestLanguage.g:1127:1: rule__Object__Group_5_1__1__Impl : ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) ;
    public final void rule__Object__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1131:1: ( ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) ) )
            // InternalBug304681TestLanguage.g:1132:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:1132:1: ( ( rule__Object__LongDescriptionAssignment_5_1_1 ) )
            // InternalBug304681TestLanguage.g:1133:2: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 
            }
            // InternalBug304681TestLanguage.g:1134:2: ( rule__Object__LongDescriptionAssignment_5_1_1 )
            // InternalBug304681TestLanguage.g:1134:3: rule__Object__LongDescriptionAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__LongDescriptionAssignment_5_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLongDescriptionAssignment_5_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__1__Impl"


    // $ANTLR start "rule__Object__Group_5_1__2"
    // InternalBug304681TestLanguage.g:1142:1: rule__Object__Group_5_1__2 : rule__Object__Group_5_1__2__Impl ;
    public final void rule__Object__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1146:1: ( rule__Object__Group_5_1__2__Impl )
            // InternalBug304681TestLanguage.g:1147:2: rule__Object__Group_5_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__2"


    // $ANTLR start "rule__Object__Group_5_1__2__Impl"
    // InternalBug304681TestLanguage.g:1153:1: rule__Object__Group_5_1__2__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1157:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1158:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1158:1: ( ';' )
            // InternalBug304681TestLanguage.g:1159:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_1__2__Impl"


    // $ANTLR start "rule__Object__Group_5_2__0"
    // InternalBug304681TestLanguage.g:1169:1: rule__Object__Group_5_2__0 : rule__Object__Group_5_2__0__Impl rule__Object__Group_5_2__1 ;
    public final void rule__Object__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1173:1: ( rule__Object__Group_5_2__0__Impl rule__Object__Group_5_2__1 )
            // InternalBug304681TestLanguage.g:1174:2: rule__Object__Group_5_2__0__Impl rule__Object__Group_5_2__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Object__Group_5_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__0"


    // $ANTLR start "rule__Object__Group_5_2__0__Impl"
    // InternalBug304681TestLanguage.g:1181:1: rule__Object__Group_5_2__0__Impl : ( 'serialUID' ) ;
    public final void rule__Object__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1185:1: ( ( 'serialUID' ) )
            // InternalBug304681TestLanguage.g:1186:1: ( 'serialUID' )
            {
            // InternalBug304681TestLanguage.g:1186:1: ( 'serialUID' )
            // InternalBug304681TestLanguage.g:1187:2: 'serialUID'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__0__Impl"


    // $ANTLR start "rule__Object__Group_5_2__1"
    // InternalBug304681TestLanguage.g:1196:1: rule__Object__Group_5_2__1 : rule__Object__Group_5_2__1__Impl rule__Object__Group_5_2__2 ;
    public final void rule__Object__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1200:1: ( rule__Object__Group_5_2__1__Impl rule__Object__Group_5_2__2 )
            // InternalBug304681TestLanguage.g:1201:2: rule__Object__Group_5_2__1__Impl rule__Object__Group_5_2__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__1"


    // $ANTLR start "rule__Object__Group_5_2__1__Impl"
    // InternalBug304681TestLanguage.g:1208:1: rule__Object__Group_5_2__1__Impl : ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) ;
    public final void rule__Object__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1212:1: ( ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) ) )
            // InternalBug304681TestLanguage.g:1213:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) )
            {
            // InternalBug304681TestLanguage.g:1213:1: ( ( rule__Object__SerialVersionUIDAssignment_5_2_1 ) )
            // InternalBug304681TestLanguage.g:1214:2: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 
            }
            // InternalBug304681TestLanguage.g:1215:2: ( rule__Object__SerialVersionUIDAssignment_5_2_1 )
            // InternalBug304681TestLanguage.g:1215:3: rule__Object__SerialVersionUIDAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__SerialVersionUIDAssignment_5_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSerialVersionUIDAssignment_5_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__1__Impl"


    // $ANTLR start "rule__Object__Group_5_2__2"
    // InternalBug304681TestLanguage.g:1223:1: rule__Object__Group_5_2__2 : rule__Object__Group_5_2__2__Impl ;
    public final void rule__Object__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1227:1: ( rule__Object__Group_5_2__2__Impl )
            // InternalBug304681TestLanguage.g:1228:2: rule__Object__Group_5_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__2"


    // $ANTLR start "rule__Object__Group_5_2__2__Impl"
    // InternalBug304681TestLanguage.g:1234:1: rule__Object__Group_5_2__2__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1238:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1239:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1239:1: ( ';' )
            // InternalBug304681TestLanguage.g:1240:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_2__2__Impl"


    // $ANTLR start "rule__Object__Group_5_3__0"
    // InternalBug304681TestLanguage.g:1250:1: rule__Object__Group_5_3__0 : rule__Object__Group_5_3__0__Impl rule__Object__Group_5_3__1 ;
    public final void rule__Object__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1254:1: ( rule__Object__Group_5_3__0__Impl rule__Object__Group_5_3__1 )
            // InternalBug304681TestLanguage.g:1255:2: rule__Object__Group_5_3__0__Impl rule__Object__Group_5_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object__Group_5_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_3__0"


    // $ANTLR start "rule__Object__Group_5_3__0__Impl"
    // InternalBug304681TestLanguage.g:1262:1: rule__Object__Group_5_3__0__Impl : ( ( rule__Object__CloneableAssignment_5_3_0 ) ) ;
    public final void rule__Object__Group_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1266:1: ( ( ( rule__Object__CloneableAssignment_5_3_0 ) ) )
            // InternalBug304681TestLanguage.g:1267:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) )
            {
            // InternalBug304681TestLanguage.g:1267:1: ( ( rule__Object__CloneableAssignment_5_3_0 ) )
            // InternalBug304681TestLanguage.g:1268:2: ( rule__Object__CloneableAssignment_5_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 
            }
            // InternalBug304681TestLanguage.g:1269:2: ( rule__Object__CloneableAssignment_5_3_0 )
            // InternalBug304681TestLanguage.g:1269:3: rule__Object__CloneableAssignment_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__CloneableAssignment_5_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getCloneableAssignment_5_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_3__0__Impl"


    // $ANTLR start "rule__Object__Group_5_3__1"
    // InternalBug304681TestLanguage.g:1277:1: rule__Object__Group_5_3__1 : rule__Object__Group_5_3__1__Impl ;
    public final void rule__Object__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1281:1: ( rule__Object__Group_5_3__1__Impl )
            // InternalBug304681TestLanguage.g:1282:2: rule__Object__Group_5_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_3__1"


    // $ANTLR start "rule__Object__Group_5_3__1__Impl"
    // InternalBug304681TestLanguage.g:1288:1: rule__Object__Group_5_3__1__Impl : ( ';' ) ;
    public final void rule__Object__Group_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1292:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1293:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1293:1: ( ';' )
            // InternalBug304681TestLanguage.g:1294:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_3__1__Impl"


    // $ANTLR start "rule__Object__Group_5_5__0"
    // InternalBug304681TestLanguage.g:1304:1: rule__Object__Group_5_5__0 : rule__Object__Group_5_5__0__Impl rule__Object__Group_5_5__1 ;
    public final void rule__Object__Group_5_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1308:1: ( rule__Object__Group_5_5__0__Impl rule__Object__Group_5_5__1 )
            // InternalBug304681TestLanguage.g:1309:2: rule__Object__Group_5_5__0__Impl rule__Object__Group_5_5__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Object__Group_5_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__0"


    // $ANTLR start "rule__Object__Group_5_5__0__Impl"
    // InternalBug304681TestLanguage.g:1316:1: rule__Object__Group_5_5__0__Impl : ( 'before' ) ;
    public final void rule__Object__Group_5_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1320:1: ( ( 'before' ) )
            // InternalBug304681TestLanguage.g:1321:1: ( 'before' )
            {
            // InternalBug304681TestLanguage.g:1321:1: ( 'before' )
            // InternalBug304681TestLanguage.g:1322:2: 'before'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 
            }
            match(input,22,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__0__Impl"


    // $ANTLR start "rule__Object__Group_5_5__1"
    // InternalBug304681TestLanguage.g:1331:1: rule__Object__Group_5_5__1 : rule__Object__Group_5_5__1__Impl rule__Object__Group_5_5__2 ;
    public final void rule__Object__Group_5_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1335:1: ( rule__Object__Group_5_5__1__Impl rule__Object__Group_5_5__2 )
            // InternalBug304681TestLanguage.g:1336:2: rule__Object__Group_5_5__1__Impl rule__Object__Group_5_5__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__Object__Group_5_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_5__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__1"


    // $ANTLR start "rule__Object__Group_5_5__1__Impl"
    // InternalBug304681TestLanguage.g:1343:1: rule__Object__Group_5_5__1__Impl : ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) ;
    public final void rule__Object__Group_5_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1347:1: ( ( ( rule__Object__FeaturesAssignment_5_5_1 )* ) )
            // InternalBug304681TestLanguage.g:1348:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* )
            {
            // InternalBug304681TestLanguage.g:1348:1: ( ( rule__Object__FeaturesAssignment_5_5_1 )* )
            // InternalBug304681TestLanguage.g:1349:2: ( rule__Object__FeaturesAssignment_5_5_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 
            }
            // InternalBug304681TestLanguage.g:1350:2: ( rule__Object__FeaturesAssignment_5_5_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=26 && LA12_0<=27)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:1350:3: rule__Object__FeaturesAssignment_5_5_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__Object__FeaturesAssignment_5_5_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__1__Impl"


    // $ANTLR start "rule__Object__Group_5_5__2"
    // InternalBug304681TestLanguage.g:1358:1: rule__Object__Group_5_5__2 : rule__Object__Group_5_5__2__Impl ;
    public final void rule__Object__Group_5_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1362:1: ( rule__Object__Group_5_5__2__Impl )
            // InternalBug304681TestLanguage.g:1363:2: rule__Object__Group_5_5__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_5__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__2"


    // $ANTLR start "rule__Object__Group_5_5__2__Impl"
    // InternalBug304681TestLanguage.g:1369:1: rule__Object__Group_5_5__2__Impl : ( 'after' ) ;
    public final void rule__Object__Group_5_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1373:1: ( ( 'after' ) )
            // InternalBug304681TestLanguage.g:1374:1: ( 'after' )
            {
            // InternalBug304681TestLanguage.g:1374:1: ( 'after' )
            // InternalBug304681TestLanguage.g:1375:2: 'after'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2()); 
            }
            match(input,23,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_5__2__Impl"


    // $ANTLR start "rule__Object__Group_5_6__0"
    // InternalBug304681TestLanguage.g:1385:1: rule__Object__Group_5_6__0 : rule__Object__Group_5_6__0__Impl rule__Object__Group_5_6__1 ;
    public final void rule__Object__Group_5_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1389:1: ( rule__Object__Group_5_6__0__Impl rule__Object__Group_5_6__1 )
            // InternalBug304681TestLanguage.g:1390:2: rule__Object__Group_5_6__0__Impl rule__Object__Group_5_6__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Object__Group_5_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_6__0"


    // $ANTLR start "rule__Object__Group_5_6__0__Impl"
    // InternalBug304681TestLanguage.g:1397:1: rule__Object__Group_5_6__0__Impl : ( 'optionalLoop' ) ;
    public final void rule__Object__Group_5_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1401:1: ( ( 'optionalLoop' ) )
            // InternalBug304681TestLanguage.g:1402:1: ( 'optionalLoop' )
            {
            // InternalBug304681TestLanguage.g:1402:1: ( 'optionalLoop' )
            // InternalBug304681TestLanguage.g:1403:2: 'optionalLoop'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 
            }
            match(input,24,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_6__0__Impl"


    // $ANTLR start "rule__Object__Group_5_6__1"
    // InternalBug304681TestLanguage.g:1412:1: rule__Object__Group_5_6__1 : rule__Object__Group_5_6__1__Impl ;
    public final void rule__Object__Group_5_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1416:1: ( rule__Object__Group_5_6__1__Impl )
            // InternalBug304681TestLanguage.g:1417:2: rule__Object__Group_5_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_6__1"


    // $ANTLR start "rule__Object__Group_5_6__1__Impl"
    // InternalBug304681TestLanguage.g:1423:1: rule__Object__Group_5_6__1__Impl : ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) ;
    public final void rule__Object__Group_5_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1427:1: ( ( ( rule__Object__FeaturesAssignment_5_6_1 )* ) )
            // InternalBug304681TestLanguage.g:1428:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            {
            // InternalBug304681TestLanguage.g:1428:1: ( ( rule__Object__FeaturesAssignment_5_6_1 )* )
            // InternalBug304681TestLanguage.g:1429:2: ( rule__Object__FeaturesAssignment_5_6_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1()); 
            }
            // InternalBug304681TestLanguage.g:1430:2: ( rule__Object__FeaturesAssignment_5_6_1 )*
            loop13:
            do {
                int alt13=2;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:1430:3: rule__Object__FeaturesAssignment_5_6_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__Object__FeaturesAssignment_5_6_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_6__1__Impl"


    // $ANTLR start "rule__Object__Group_5_7__0"
    // InternalBug304681TestLanguage.g:1439:1: rule__Object__Group_5_7__0 : rule__Object__Group_5_7__0__Impl rule__Object__Group_5_7__1 ;
    public final void rule__Object__Group_5_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1443:1: ( rule__Object__Group_5_7__0__Impl rule__Object__Group_5_7__1 )
            // InternalBug304681TestLanguage.g:1444:2: rule__Object__Group_5_7__0__Impl rule__Object__Group_5_7__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__Object__Group_5_7__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_7__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_7__0"


    // $ANTLR start "rule__Object__Group_5_7__0__Impl"
    // InternalBug304681TestLanguage.g:1451:1: rule__Object__Group_5_7__0__Impl : ( 'mandatoryLoop' ) ;
    public final void rule__Object__Group_5_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1455:1: ( ( 'mandatoryLoop' ) )
            // InternalBug304681TestLanguage.g:1456:1: ( 'mandatoryLoop' )
            {
            // InternalBug304681TestLanguage.g:1456:1: ( 'mandatoryLoop' )
            // InternalBug304681TestLanguage.g:1457:2: 'mandatoryLoop'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 
            }
            match(input,25,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_7__0__Impl"


    // $ANTLR start "rule__Object__Group_5_7__1"
    // InternalBug304681TestLanguage.g:1466:1: rule__Object__Group_5_7__1 : rule__Object__Group_5_7__1__Impl ;
    public final void rule__Object__Group_5_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1470:1: ( rule__Object__Group_5_7__1__Impl )
            // InternalBug304681TestLanguage.g:1471:2: rule__Object__Group_5_7__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__Group_5_7__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_7__1"


    // $ANTLR start "rule__Object__Group_5_7__1__Impl"
    // InternalBug304681TestLanguage.g:1477:1: rule__Object__Group_5_7__1__Impl : ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) ;
    public final void rule__Object__Group_5_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1481:1: ( ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) ) )
            // InternalBug304681TestLanguage.g:1482:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            {
            // InternalBug304681TestLanguage.g:1482:1: ( ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* ) )
            // InternalBug304681TestLanguage.g:1483:2: ( ( rule__Object__FeaturesAssignment_5_7_1 ) ) ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            {
            // InternalBug304681TestLanguage.g:1483:2: ( ( rule__Object__FeaturesAssignment_5_7_1 ) )
            // InternalBug304681TestLanguage.g:1484:3: ( rule__Object__FeaturesAssignment_5_7_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            }
            // InternalBug304681TestLanguage.g:1485:3: ( rule__Object__FeaturesAssignment_5_7_1 )
            // InternalBug304681TestLanguage.g:1485:4: rule__Object__FeaturesAssignment_5_7_1
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__Object__FeaturesAssignment_5_7_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            }

            }

            // InternalBug304681TestLanguage.g:1488:2: ( ( rule__Object__FeaturesAssignment_5_7_1 )* )
            // InternalBug304681TestLanguage.g:1489:3: ( rule__Object__FeaturesAssignment_5_7_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
            }
            // InternalBug304681TestLanguage.g:1490:3: ( rule__Object__FeaturesAssignment_5_7_1 )*
            loop14:
            do {
                int alt14=2;
                alt14 = dfa14.predict(input);
                switch (alt14) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:1490:4: rule__Object__FeaturesAssignment_5_7_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_14);
            	    rule__Object__FeaturesAssignment_5_7_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_7_1()); 
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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__Group_5_7__1__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalBug304681TestLanguage.g:1500:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1504:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalBug304681TestLanguage.g:1505:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalBug304681TestLanguage.g:1512:1: rule__Attribute__Group__0__Impl : ( 'Attribute' ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1516:1: ( ( 'Attribute' ) )
            // InternalBug304681TestLanguage.g:1517:1: ( 'Attribute' )
            {
            // InternalBug304681TestLanguage.g:1517:1: ( 'Attribute' )
            // InternalBug304681TestLanguage.g:1518:2: 'Attribute'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getAttributeKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalBug304681TestLanguage.g:1527:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1531:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalBug304681TestLanguage.g:1532:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalBug304681TestLanguage.g:1539:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__TypeAssignment_1 ) ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1543:1: ( ( ( rule__Attribute__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:1544:1: ( ( rule__Attribute__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:1544:1: ( ( rule__Attribute__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:1545:2: ( rule__Attribute__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:1546:2: ( rule__Attribute__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:1546:3: rule__Attribute__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalBug304681TestLanguage.g:1554:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl rule__Attribute__Group__3 ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1558:1: ( rule__Attribute__Group__2__Impl rule__Attribute__Group__3 )
            // InternalBug304681TestLanguage.g:1559:2: rule__Attribute__Group__2__Impl rule__Attribute__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalBug304681TestLanguage.g:1566:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__NameAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1570:1: ( ( ( rule__Attribute__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:1571:1: ( ( rule__Attribute__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:1571:1: ( ( rule__Attribute__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:1572:2: ( rule__Attribute__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:1573:2: ( rule__Attribute__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:1573:3: rule__Attribute__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Attribute__Group__3"
    // InternalBug304681TestLanguage.g:1581:1: rule__Attribute__Group__3 : rule__Attribute__Group__3__Impl ;
    public final void rule__Attribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1585:1: ( rule__Attribute__Group__3__Impl )
            // InternalBug304681TestLanguage.g:1586:2: rule__Attribute__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3"


    // $ANTLR start "rule__Attribute__Group__3__Impl"
    // InternalBug304681TestLanguage.g:1592:1: rule__Attribute__Group__3__Impl : ( ';' ) ;
    public final void rule__Attribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1596:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1597:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1597:1: ( ';' )
            // InternalBug304681TestLanguage.g:1598:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getSemicolonKeyword_3()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__0"
    // InternalBug304681TestLanguage.g:1608:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1612:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // InternalBug304681TestLanguage.g:1613:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // InternalBug304681TestLanguage.g:1620:1: rule__Reference__Group__0__Impl : ( 'Reference' ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1624:1: ( ( 'Reference' ) )
            // InternalBug304681TestLanguage.g:1625:1: ( 'Reference' )
            {
            // InternalBug304681TestLanguage.g:1625:1: ( 'Reference' )
            // InternalBug304681TestLanguage.g:1626:2: 'Reference'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // InternalBug304681TestLanguage.g:1635:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1639:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // InternalBug304681TestLanguage.g:1640:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // InternalBug304681TestLanguage.g:1647:1: rule__Reference__Group__1__Impl : ( ( rule__Reference__TypeAssignment_1 ) ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1651:1: ( ( ( rule__Reference__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:1652:1: ( ( rule__Reference__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:1652:1: ( ( rule__Reference__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:1653:2: ( rule__Reference__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:1654:2: ( rule__Reference__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:1654:3: rule__Reference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__2"
    // InternalBug304681TestLanguage.g:1662:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1666:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // InternalBug304681TestLanguage.g:1667:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2"


    // $ANTLR start "rule__Reference__Group__2__Impl"
    // InternalBug304681TestLanguage.g:1674:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__ManyAssignment_2 )? ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1678:1: ( ( ( rule__Reference__ManyAssignment_2 )? ) )
            // InternalBug304681TestLanguage.g:1679:1: ( ( rule__Reference__ManyAssignment_2 )? )
            {
            // InternalBug304681TestLanguage.g:1679:1: ( ( rule__Reference__ManyAssignment_2 )? )
            // InternalBug304681TestLanguage.g:1680:2: ( rule__Reference__ManyAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getManyAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:1681:2: ( rule__Reference__ManyAssignment_2 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBug304681TestLanguage.g:1681:3: rule__Reference__ManyAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__ManyAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getManyAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__3"
    // InternalBug304681TestLanguage.g:1689:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1693:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // InternalBug304681TestLanguage.g:1694:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Reference__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3"


    // $ANTLR start "rule__Reference__Group__3__Impl"
    // InternalBug304681TestLanguage.g:1701:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__NameAssignment_3 ) ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1705:1: ( ( ( rule__Reference__NameAssignment_3 ) ) )
            // InternalBug304681TestLanguage.g:1706:1: ( ( rule__Reference__NameAssignment_3 ) )
            {
            // InternalBug304681TestLanguage.g:1706:1: ( ( rule__Reference__NameAssignment_3 ) )
            // InternalBug304681TestLanguage.g:1707:2: ( rule__Reference__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
            }
            // InternalBug304681TestLanguage.g:1708:2: ( rule__Reference__NameAssignment_3 )
            // InternalBug304681TestLanguage.g:1708:3: rule__Reference__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__4"
    // InternalBug304681TestLanguage.g:1716:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1720:1: ( rule__Reference__Group__4__Impl )
            // InternalBug304681TestLanguage.g:1721:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4"


    // $ANTLR start "rule__Reference__Group__4__Impl"
    // InternalBug304681TestLanguage.g:1727:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1731:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // InternalBug304681TestLanguage.g:1732:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // InternalBug304681TestLanguage.g:1732:1: ( ( rule__Reference__Alternatives_4 ) )
            // InternalBug304681TestLanguage.g:1733:2: ( rule__Reference__Alternatives_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            }
            // InternalBug304681TestLanguage.g:1734:2: ( rule__Reference__Alternatives_4 )
            // InternalBug304681TestLanguage.g:1734:3: rule__Reference__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Alternatives_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__0"
    // InternalBug304681TestLanguage.g:1743:1: rule__Reference__Group_4_0__0 : rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1747:1: ( rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 )
            // InternalBug304681TestLanguage.g:1748:2: rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__Reference__Group_4_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__0"


    // $ANTLR start "rule__Reference__Group_4_0__0__Impl"
    // InternalBug304681TestLanguage.g:1755:1: rule__Reference__Group_4_0__0__Impl : ( '{' ) ;
    public final void rule__Reference__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1759:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:1760:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:1760:1: ( '{' )
            // InternalBug304681TestLanguage.g:1761:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__1"
    // InternalBug304681TestLanguage.g:1770:1: rule__Reference__Group_4_0__1 : rule__Reference__Group_4_0__1__Impl rule__Reference__Group_4_0__2 ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1774:1: ( rule__Reference__Group_4_0__1__Impl rule__Reference__Group_4_0__2 )
            // InternalBug304681TestLanguage.g:1775:2: rule__Reference__Group_4_0__1__Impl rule__Reference__Group_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Reference__Group_4_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__1"


    // $ANTLR start "rule__Reference__Group_4_0__1__Impl"
    // InternalBug304681TestLanguage.g:1782:1: rule__Reference__Group_4_0__1__Impl : ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) ;
    public final void rule__Reference__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1786:1: ( ( ( rule__Reference__UnorderedGroup_4_0_1 ) ) )
            // InternalBug304681TestLanguage.g:1787:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:1787:1: ( ( rule__Reference__UnorderedGroup_4_0_1 ) )
            // InternalBug304681TestLanguage.g:1788:2: ( rule__Reference__UnorderedGroup_4_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 
            }
            // InternalBug304681TestLanguage.g:1789:2: ( rule__Reference__UnorderedGroup_4_0_1 )
            // InternalBug304681TestLanguage.g:1789:3: rule__Reference__UnorderedGroup_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__UnorderedGroup_4_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__2"
    // InternalBug304681TestLanguage.g:1797:1: rule__Reference__Group_4_0__2 : rule__Reference__Group_4_0__2__Impl ;
    public final void rule__Reference__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1801:1: ( rule__Reference__Group_4_0__2__Impl )
            // InternalBug304681TestLanguage.g:1802:2: rule__Reference__Group_4_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__2"


    // $ANTLR start "rule__Reference__Group_4_0__2__Impl"
    // InternalBug304681TestLanguage.g:1808:1: rule__Reference__Group_4_0__2__Impl : ( '}' ) ;
    public final void rule__Reference__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1812:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:1813:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:1813:1: ( '}' )
            // InternalBug304681TestLanguage.g:1814:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__2__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__0"
    // InternalBug304681TestLanguage.g:1824:1: rule__Reference__Group_4_0_1_0__0 : rule__Reference__Group_4_0_1_0__0__Impl rule__Reference__Group_4_0_1_0__1 ;
    public final void rule__Reference__Group_4_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1828:1: ( rule__Reference__Group_4_0_1_0__0__Impl rule__Reference__Group_4_0_1_0__1 )
            // InternalBug304681TestLanguage.g:1829:2: rule__Reference__Group_4_0_1_0__0__Impl rule__Reference__Group_4_0_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference__Group_4_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__0"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__0__Impl"
    // InternalBug304681TestLanguage.g:1836:1: rule__Reference__Group_4_0_1_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Reference__Group_4_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1840:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:1841:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:1841:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:1842:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__1"
    // InternalBug304681TestLanguage.g:1851:1: rule__Reference__Group_4_0_1_0__1 : rule__Reference__Group_4_0_1_0__1__Impl rule__Reference__Group_4_0_1_0__2 ;
    public final void rule__Reference__Group_4_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1855:1: ( rule__Reference__Group_4_0_1_0__1__Impl rule__Reference__Group_4_0_1_0__2 )
            // InternalBug304681TestLanguage.g:1856:2: rule__Reference__Group_4_0_1_0__1__Impl rule__Reference__Group_4_0_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference__Group_4_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__1"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__1__Impl"
    // InternalBug304681TestLanguage.g:1863:1: rule__Reference__Group_4_0_1_0__1__Impl : ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) ;
    public final void rule__Reference__Group_4_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1867:1: ( ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) ) )
            // InternalBug304681TestLanguage.g:1868:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:1868:1: ( ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 ) )
            // InternalBug304681TestLanguage.g:1869:2: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 
            }
            // InternalBug304681TestLanguage.g:1870:2: ( rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 )
            // InternalBug304681TestLanguage.g:1870:3: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__ShortDescriptionAssignment_4_0_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getShortDescriptionAssignment_4_0_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__2"
    // InternalBug304681TestLanguage.g:1878:1: rule__Reference__Group_4_0_1_0__2 : rule__Reference__Group_4_0_1_0__2__Impl ;
    public final void rule__Reference__Group_4_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1882:1: ( rule__Reference__Group_4_0_1_0__2__Impl )
            // InternalBug304681TestLanguage.g:1883:2: rule__Reference__Group_4_0_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__2"


    // $ANTLR start "rule__Reference__Group_4_0_1_0__2__Impl"
    // InternalBug304681TestLanguage.g:1889:1: rule__Reference__Group_4_0_1_0__2__Impl : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1893:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1894:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1894:1: ( ';' )
            // InternalBug304681TestLanguage.g:1895:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_0__2__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__0"
    // InternalBug304681TestLanguage.g:1905:1: rule__Reference__Group_4_0_1_1__0 : rule__Reference__Group_4_0_1_1__0__Impl rule__Reference__Group_4_0_1_1__1 ;
    public final void rule__Reference__Group_4_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1909:1: ( rule__Reference__Group_4_0_1_1__0__Impl rule__Reference__Group_4_0_1_1__1 )
            // InternalBug304681TestLanguage.g:1910:2: rule__Reference__Group_4_0_1_1__0__Impl rule__Reference__Group_4_0_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference__Group_4_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__0"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__0__Impl"
    // InternalBug304681TestLanguage.g:1917:1: rule__Reference__Group_4_0_1_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Reference__Group_4_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1921:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:1922:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:1922:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:1923:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__1"
    // InternalBug304681TestLanguage.g:1932:1: rule__Reference__Group_4_0_1_1__1 : rule__Reference__Group_4_0_1_1__1__Impl rule__Reference__Group_4_0_1_1__2 ;
    public final void rule__Reference__Group_4_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1936:1: ( rule__Reference__Group_4_0_1_1__1__Impl rule__Reference__Group_4_0_1_1__2 )
            // InternalBug304681TestLanguage.g:1937:2: rule__Reference__Group_4_0_1_1__1__Impl rule__Reference__Group_4_0_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference__Group_4_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__1"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__1__Impl"
    // InternalBug304681TestLanguage.g:1944:1: rule__Reference__Group_4_0_1_1__1__Impl : ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) ;
    public final void rule__Reference__Group_4_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1948:1: ( ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) ) )
            // InternalBug304681TestLanguage.g:1949:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:1949:1: ( ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 ) )
            // InternalBug304681TestLanguage.g:1950:2: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 
            }
            // InternalBug304681TestLanguage.g:1951:2: ( rule__Reference__LongDescriptionAssignment_4_0_1_1_1 )
            // InternalBug304681TestLanguage.g:1951:3: rule__Reference__LongDescriptionAssignment_4_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__LongDescriptionAssignment_4_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLongDescriptionAssignment_4_0_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__2"
    // InternalBug304681TestLanguage.g:1959:1: rule__Reference__Group_4_0_1_1__2 : rule__Reference__Group_4_0_1_1__2__Impl ;
    public final void rule__Reference__Group_4_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1963:1: ( rule__Reference__Group_4_0_1_1__2__Impl )
            // InternalBug304681TestLanguage.g:1964:2: rule__Reference__Group_4_0_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__Group_4_0_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__2"


    // $ANTLR start "rule__Reference__Group_4_0_1_1__2__Impl"
    // InternalBug304681TestLanguage.g:1970:1: rule__Reference__Group_4_0_1_1__2__Impl : ( ';' ) ;
    public final void rule__Reference__Group_4_0_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1974:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:1975:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:1975:1: ( ';' )
            // InternalBug304681TestLanguage.g:1976:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0_1_1__2__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__0"
    // InternalBug304681TestLanguage.g:1986:1: rule__PackageDefinition2__Group__0 : rule__PackageDefinition2__Group__0__Impl rule__PackageDefinition2__Group__1 ;
    public final void rule__PackageDefinition2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:1990:1: ( rule__PackageDefinition2__Group__0__Impl rule__PackageDefinition2__Group__1 )
            // InternalBug304681TestLanguage.g:1991:2: rule__PackageDefinition2__Group__0__Impl rule__PackageDefinition2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__PackageDefinition2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__0"


    // $ANTLR start "rule__PackageDefinition2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:1998:1: rule__PackageDefinition2__Group__0__Impl : ( () ) ;
    public final void rule__PackageDefinition2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2002:1: ( ( () ) )
            // InternalBug304681TestLanguage.g:2003:1: ( () )
            {
            // InternalBug304681TestLanguage.g:2003:1: ( () )
            // InternalBug304681TestLanguage.g:2004:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0()); 
            }
            // InternalBug304681TestLanguage.g:2005:2: ()
            // InternalBug304681TestLanguage.g:2005:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__0__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__1"
    // InternalBug304681TestLanguage.g:2013:1: rule__PackageDefinition2__Group__1 : rule__PackageDefinition2__Group__1__Impl rule__PackageDefinition2__Group__2 ;
    public final void rule__PackageDefinition2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2017:1: ( rule__PackageDefinition2__Group__1__Impl rule__PackageDefinition2__Group__2 )
            // InternalBug304681TestLanguage.g:2018:2: rule__PackageDefinition2__Group__1__Impl rule__PackageDefinition2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__PackageDefinition2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__1"


    // $ANTLR start "rule__PackageDefinition2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:2025:1: rule__PackageDefinition2__Group__1__Impl : ( 'package' ) ;
    public final void rule__PackageDefinition2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2029:1: ( ( 'package' ) )
            // InternalBug304681TestLanguage.g:2030:1: ( 'package' )
            {
            // InternalBug304681TestLanguage.g:2030:1: ( 'package' )
            // InternalBug304681TestLanguage.g:2031:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getPackageKeyword_1()); 
            }
            match(input,14,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getPackageKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__1__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__2"
    // InternalBug304681TestLanguage.g:2040:1: rule__PackageDefinition2__Group__2 : rule__PackageDefinition2__Group__2__Impl rule__PackageDefinition2__Group__3 ;
    public final void rule__PackageDefinition2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2044:1: ( rule__PackageDefinition2__Group__2__Impl rule__PackageDefinition2__Group__3 )
            // InternalBug304681TestLanguage.g:2045:2: rule__PackageDefinition2__Group__2__Impl rule__PackageDefinition2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__PackageDefinition2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__2"


    // $ANTLR start "rule__PackageDefinition2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:2052:1: rule__PackageDefinition2__Group__2__Impl : ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) ) ;
    public final void rule__PackageDefinition2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2056:1: ( ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:2057:1: ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:2057:1: ( ( rule__PackageDefinition2__NamespaceAssignment_2 ) )
            // InternalBug304681TestLanguage.g:2058:2: ( rule__PackageDefinition2__NamespaceAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getNamespaceAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:2059:2: ( rule__PackageDefinition2__NamespaceAssignment_2 )
            // InternalBug304681TestLanguage.g:2059:3: rule__PackageDefinition2__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__NamespaceAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getNamespaceAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__2__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__3"
    // InternalBug304681TestLanguage.g:2067:1: rule__PackageDefinition2__Group__3 : rule__PackageDefinition2__Group__3__Impl rule__PackageDefinition2__Group__4 ;
    public final void rule__PackageDefinition2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2071:1: ( rule__PackageDefinition2__Group__3__Impl rule__PackageDefinition2__Group__4 )
            // InternalBug304681TestLanguage.g:2072:2: rule__PackageDefinition2__Group__3__Impl rule__PackageDefinition2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__PackageDefinition2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__3"


    // $ANTLR start "rule__PackageDefinition2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:2079:1: rule__PackageDefinition2__Group__3__Impl : ( ';' ) ;
    public final void rule__PackageDefinition2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2083:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2084:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2084:1: ( ';' )
            // InternalBug304681TestLanguage.g:2085:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__3__Impl"


    // $ANTLR start "rule__PackageDefinition2__Group__4"
    // InternalBug304681TestLanguage.g:2094:1: rule__PackageDefinition2__Group__4 : rule__PackageDefinition2__Group__4__Impl ;
    public final void rule__PackageDefinition2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2098:1: ( rule__PackageDefinition2__Group__4__Impl )
            // InternalBug304681TestLanguage.g:2099:2: rule__PackageDefinition2__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PackageDefinition2__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__4"


    // $ANTLR start "rule__PackageDefinition2__Group__4__Impl"
    // InternalBug304681TestLanguage.g:2105:1: rule__PackageDefinition2__Group__4__Impl : ( ( rule__PackageDefinition2__ContentsAssignment_4 )* ) ;
    public final void rule__PackageDefinition2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2109:1: ( ( ( rule__PackageDefinition2__ContentsAssignment_4 )* ) )
            // InternalBug304681TestLanguage.g:2110:1: ( ( rule__PackageDefinition2__ContentsAssignment_4 )* )
            {
            // InternalBug304681TestLanguage.g:2110:1: ( ( rule__PackageDefinition2__ContentsAssignment_4 )* )
            // InternalBug304681TestLanguage.g:2111:2: ( rule__PackageDefinition2__ContentsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getContentsAssignment_4()); 
            }
            // InternalBug304681TestLanguage.g:2112:2: ( rule__PackageDefinition2__ContentsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15||(LA16_0>=31 && LA16_0<=32)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:2112:3: rule__PackageDefinition2__ContentsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    rule__PackageDefinition2__ContentsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getContentsAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__Group__4__Impl"


    // $ANTLR start "rule__Object2__Group__0"
    // InternalBug304681TestLanguage.g:2121:1: rule__Object2__Group__0 : rule__Object2__Group__0__Impl rule__Object2__Group__1 ;
    public final void rule__Object2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2125:1: ( rule__Object2__Group__0__Impl rule__Object2__Group__1 )
            // InternalBug304681TestLanguage.g:2126:2: rule__Object2__Group__0__Impl rule__Object2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Object2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__0"


    // $ANTLR start "rule__Object2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:2133:1: rule__Object2__Group__0__Impl : ( ( rule__Object2__Alternatives_0 )? ) ;
    public final void rule__Object2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2137:1: ( ( ( rule__Object2__Alternatives_0 )? ) )
            // InternalBug304681TestLanguage.g:2138:1: ( ( rule__Object2__Alternatives_0 )? )
            {
            // InternalBug304681TestLanguage.g:2138:1: ( ( rule__Object2__Alternatives_0 )? )
            // InternalBug304681TestLanguage.g:2139:2: ( rule__Object2__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getAlternatives_0()); 
            }
            // InternalBug304681TestLanguage.g:2140:2: ( rule__Object2__Alternatives_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=31 && LA17_0<=32)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalBug304681TestLanguage.g:2140:3: rule__Object2__Alternatives_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getAlternatives_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__0__Impl"


    // $ANTLR start "rule__Object2__Group__1"
    // InternalBug304681TestLanguage.g:2148:1: rule__Object2__Group__1 : rule__Object2__Group__1__Impl rule__Object2__Group__2 ;
    public final void rule__Object2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2152:1: ( rule__Object2__Group__1__Impl rule__Object2__Group__2 )
            // InternalBug304681TestLanguage.g:2153:2: rule__Object2__Group__1__Impl rule__Object2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__1"


    // $ANTLR start "rule__Object2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:2160:1: rule__Object2__Group__1__Impl : ( 'object' ) ;
    public final void rule__Object2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2164:1: ( ( 'object' ) )
            // InternalBug304681TestLanguage.g:2165:1: ( 'object' )
            {
            // InternalBug304681TestLanguage.g:2165:1: ( 'object' )
            // InternalBug304681TestLanguage.g:2166:2: 'object'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getObjectKeyword_1()); 
            }
            match(input,15,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getObjectKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__1__Impl"


    // $ANTLR start "rule__Object2__Group__2"
    // InternalBug304681TestLanguage.g:2175:1: rule__Object2__Group__2 : rule__Object2__Group__2__Impl rule__Object2__Group__3 ;
    public final void rule__Object2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2179:1: ( rule__Object2__Group__2__Impl rule__Object2__Group__3 )
            // InternalBug304681TestLanguage.g:2180:2: rule__Object2__Group__2__Impl rule__Object2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__2"


    // $ANTLR start "rule__Object2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:2187:1: rule__Object2__Group__2__Impl : ( ( rule__Object2__NameAssignment_2 ) ) ;
    public final void rule__Object2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2191:1: ( ( ( rule__Object2__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:2192:1: ( ( rule__Object2__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:2192:1: ( ( rule__Object2__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:2193:2: ( rule__Object2__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:2194:2: ( rule__Object2__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:2194:3: rule__Object2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__2__Impl"


    // $ANTLR start "rule__Object2__Group__3"
    // InternalBug304681TestLanguage.g:2202:1: rule__Object2__Group__3 : rule__Object2__Group__3__Impl rule__Object2__Group__4 ;
    public final void rule__Object2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2206:1: ( rule__Object2__Group__3__Impl rule__Object2__Group__4 )
            // InternalBug304681TestLanguage.g:2207:2: rule__Object2__Group__3__Impl rule__Object2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__Object2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__3"


    // $ANTLR start "rule__Object2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:2214:1: rule__Object2__Group__3__Impl : ( ( rule__Object2__Group_3__0 )? ) ;
    public final void rule__Object2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2218:1: ( ( ( rule__Object2__Group_3__0 )? ) )
            // InternalBug304681TestLanguage.g:2219:1: ( ( rule__Object2__Group_3__0 )? )
            {
            // InternalBug304681TestLanguage.g:2219:1: ( ( rule__Object2__Group_3__0 )? )
            // InternalBug304681TestLanguage.g:2220:2: ( rule__Object2__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getGroup_3()); 
            }
            // InternalBug304681TestLanguage.g:2221:2: ( rule__Object2__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBug304681TestLanguage.g:2221:3: rule__Object2__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__3__Impl"


    // $ANTLR start "rule__Object2__Group__4"
    // InternalBug304681TestLanguage.g:2229:1: rule__Object2__Group__4 : rule__Object2__Group__4__Impl rule__Object2__Group__5 ;
    public final void rule__Object2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2233:1: ( rule__Object2__Group__4__Impl rule__Object2__Group__5 )
            // InternalBug304681TestLanguage.g:2234:2: rule__Object2__Group__4__Impl rule__Object2__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__Object2__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__4"


    // $ANTLR start "rule__Object2__Group__4__Impl"
    // InternalBug304681TestLanguage.g:2241:1: rule__Object2__Group__4__Impl : ( '{' ) ;
    public final void rule__Object2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2245:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:2246:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:2246:1: ( '{' )
            // InternalBug304681TestLanguage.g:2247:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__4__Impl"


    // $ANTLR start "rule__Object2__Group__5"
    // InternalBug304681TestLanguage.g:2256:1: rule__Object2__Group__5 : rule__Object2__Group__5__Impl rule__Object2__Group__6 ;
    public final void rule__Object2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2260:1: ( rule__Object2__Group__5__Impl rule__Object2__Group__6 )
            // InternalBug304681TestLanguage.g:2261:2: rule__Object2__Group__5__Impl rule__Object2__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Object2__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__5"


    // $ANTLR start "rule__Object2__Group__5__Impl"
    // InternalBug304681TestLanguage.g:2268:1: rule__Object2__Group__5__Impl : ( ( rule__Object2__UnorderedGroup_5 ) ) ;
    public final void rule__Object2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2272:1: ( ( ( rule__Object2__UnorderedGroup_5 ) ) )
            // InternalBug304681TestLanguage.g:2273:1: ( ( rule__Object2__UnorderedGroup_5 ) )
            {
            // InternalBug304681TestLanguage.g:2273:1: ( ( rule__Object2__UnorderedGroup_5 ) )
            // InternalBug304681TestLanguage.g:2274:2: ( rule__Object2__UnorderedGroup_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getUnorderedGroup_5()); 
            }
            // InternalBug304681TestLanguage.g:2275:2: ( rule__Object2__UnorderedGroup_5 )
            // InternalBug304681TestLanguage.g:2275:3: rule__Object2__UnorderedGroup_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__UnorderedGroup_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getUnorderedGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__5__Impl"


    // $ANTLR start "rule__Object2__Group__6"
    // InternalBug304681TestLanguage.g:2283:1: rule__Object2__Group__6 : rule__Object2__Group__6__Impl ;
    public final void rule__Object2__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2287:1: ( rule__Object2__Group__6__Impl )
            // InternalBug304681TestLanguage.g:2288:2: rule__Object2__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__6"


    // $ANTLR start "rule__Object2__Group__6__Impl"
    // InternalBug304681TestLanguage.g:2294:1: rule__Object2__Group__6__Impl : ( '}' ) ;
    public final void rule__Object2__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2298:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:2299:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:2299:1: ( '}' )
            // InternalBug304681TestLanguage.g:2300:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group__6__Impl"


    // $ANTLR start "rule__Object2__Group_3__0"
    // InternalBug304681TestLanguage.g:2310:1: rule__Object2__Group_3__0 : rule__Object2__Group_3__0__Impl rule__Object2__Group_3__1 ;
    public final void rule__Object2__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2314:1: ( rule__Object2__Group_3__0__Impl rule__Object2__Group_3__1 )
            // InternalBug304681TestLanguage.g:2315:2: rule__Object2__Group_3__0__Impl rule__Object2__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Object2__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_3__0"


    // $ANTLR start "rule__Object2__Group_3__0__Impl"
    // InternalBug304681TestLanguage.g:2322:1: rule__Object2__Group_3__0__Impl : ( 'extends' ) ;
    public final void rule__Object2__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2326:1: ( ( 'extends' ) )
            // InternalBug304681TestLanguage.g:2327:1: ( 'extends' )
            {
            // InternalBug304681TestLanguage.g:2327:1: ( 'extends' )
            // InternalBug304681TestLanguage.g:2328:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getExtendsKeyword_3_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getExtendsKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_3__0__Impl"


    // $ANTLR start "rule__Object2__Group_3__1"
    // InternalBug304681TestLanguage.g:2337:1: rule__Object2__Group_3__1 : rule__Object2__Group_3__1__Impl ;
    public final void rule__Object2__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2341:1: ( rule__Object2__Group_3__1__Impl )
            // InternalBug304681TestLanguage.g:2342:2: rule__Object2__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_3__1"


    // $ANTLR start "rule__Object2__Group_3__1__Impl"
    // InternalBug304681TestLanguage.g:2348:1: rule__Object2__Group_3__1__Impl : ( ( rule__Object2__ParentAssignment_3_1 ) ) ;
    public final void rule__Object2__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2352:1: ( ( ( rule__Object2__ParentAssignment_3_1 ) ) )
            // InternalBug304681TestLanguage.g:2353:1: ( ( rule__Object2__ParentAssignment_3_1 ) )
            {
            // InternalBug304681TestLanguage.g:2353:1: ( ( rule__Object2__ParentAssignment_3_1 ) )
            // InternalBug304681TestLanguage.g:2354:2: ( rule__Object2__ParentAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getParentAssignment_3_1()); 
            }
            // InternalBug304681TestLanguage.g:2355:2: ( rule__Object2__ParentAssignment_3_1 )
            // InternalBug304681TestLanguage.g:2355:3: rule__Object2__ParentAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__ParentAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getParentAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_3__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_0__0"
    // InternalBug304681TestLanguage.g:2364:1: rule__Object2__Group_5_0__0 : rule__Object2__Group_5_0__0__Impl rule__Object2__Group_5_0__1 ;
    public final void rule__Object2__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2368:1: ( rule__Object2__Group_5_0__0__Impl rule__Object2__Group_5_0__1 )
            // InternalBug304681TestLanguage.g:2369:2: rule__Object2__Group_5_0__0__Impl rule__Object2__Group_5_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object2__Group_5_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__0"


    // $ANTLR start "rule__Object2__Group_5_0__0__Impl"
    // InternalBug304681TestLanguage.g:2376:1: rule__Object2__Group_5_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Object2__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2380:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:2381:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:2381:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:2382:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_0__1"
    // InternalBug304681TestLanguage.g:2391:1: rule__Object2__Group_5_0__1 : rule__Object2__Group_5_0__1__Impl rule__Object2__Group_5_0__2 ;
    public final void rule__Object2__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2395:1: ( rule__Object2__Group_5_0__1__Impl rule__Object2__Group_5_0__2 )
            // InternalBug304681TestLanguage.g:2396:2: rule__Object2__Group_5_0__1__Impl rule__Object2__Group_5_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__1"


    // $ANTLR start "rule__Object2__Group_5_0__1__Impl"
    // InternalBug304681TestLanguage.g:2403:1: rule__Object2__Group_5_0__1__Impl : ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) ) ;
    public final void rule__Object2__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2407:1: ( ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) ) )
            // InternalBug304681TestLanguage.g:2408:1: ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:2408:1: ( ( rule__Object2__ShortDescriptionAssignment_5_0_1 ) )
            // InternalBug304681TestLanguage.g:2409:2: ( rule__Object2__ShortDescriptionAssignment_5_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getShortDescriptionAssignment_5_0_1()); 
            }
            // InternalBug304681TestLanguage.g:2410:2: ( rule__Object2__ShortDescriptionAssignment_5_0_1 )
            // InternalBug304681TestLanguage.g:2410:3: rule__Object2__ShortDescriptionAssignment_5_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__ShortDescriptionAssignment_5_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getShortDescriptionAssignment_5_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_0__2"
    // InternalBug304681TestLanguage.g:2418:1: rule__Object2__Group_5_0__2 : rule__Object2__Group_5_0__2__Impl ;
    public final void rule__Object2__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2422:1: ( rule__Object2__Group_5_0__2__Impl )
            // InternalBug304681TestLanguage.g:2423:2: rule__Object2__Group_5_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__2"


    // $ANTLR start "rule__Object2__Group_5_0__2__Impl"
    // InternalBug304681TestLanguage.g:2429:1: rule__Object2__Group_5_0__2__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2433:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2434:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2434:1: ( ';' )
            // InternalBug304681TestLanguage.g:2435:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_0__2__Impl"


    // $ANTLR start "rule__Object2__Group_5_1__0"
    // InternalBug304681TestLanguage.g:2445:1: rule__Object2__Group_5_1__0 : rule__Object2__Group_5_1__0__Impl rule__Object2__Group_5_1__1 ;
    public final void rule__Object2__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2449:1: ( rule__Object2__Group_5_1__0__Impl rule__Object2__Group_5_1__1 )
            // InternalBug304681TestLanguage.g:2450:2: rule__Object2__Group_5_1__0__Impl rule__Object2__Group_5_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Object2__Group_5_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__0"


    // $ANTLR start "rule__Object2__Group_5_1__0__Impl"
    // InternalBug304681TestLanguage.g:2457:1: rule__Object2__Group_5_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Object2__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2461:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:2462:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:2462:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:2463:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_1__1"
    // InternalBug304681TestLanguage.g:2472:1: rule__Object2__Group_5_1__1 : rule__Object2__Group_5_1__1__Impl rule__Object2__Group_5_1__2 ;
    public final void rule__Object2__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2476:1: ( rule__Object2__Group_5_1__1__Impl rule__Object2__Group_5_1__2 )
            // InternalBug304681TestLanguage.g:2477:2: rule__Object2__Group_5_1__1__Impl rule__Object2__Group_5_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__1"


    // $ANTLR start "rule__Object2__Group_5_1__1__Impl"
    // InternalBug304681TestLanguage.g:2484:1: rule__Object2__Group_5_1__1__Impl : ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) ) ;
    public final void rule__Object2__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2488:1: ( ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) ) )
            // InternalBug304681TestLanguage.g:2489:1: ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:2489:1: ( ( rule__Object2__LongDescriptionAssignment_5_1_1 ) )
            // InternalBug304681TestLanguage.g:2490:2: ( rule__Object2__LongDescriptionAssignment_5_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLongDescriptionAssignment_5_1_1()); 
            }
            // InternalBug304681TestLanguage.g:2491:2: ( rule__Object2__LongDescriptionAssignment_5_1_1 )
            // InternalBug304681TestLanguage.g:2491:3: rule__Object2__LongDescriptionAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__LongDescriptionAssignment_5_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLongDescriptionAssignment_5_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_1__2"
    // InternalBug304681TestLanguage.g:2499:1: rule__Object2__Group_5_1__2 : rule__Object2__Group_5_1__2__Impl ;
    public final void rule__Object2__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2503:1: ( rule__Object2__Group_5_1__2__Impl )
            // InternalBug304681TestLanguage.g:2504:2: rule__Object2__Group_5_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__2"


    // $ANTLR start "rule__Object2__Group_5_1__2__Impl"
    // InternalBug304681TestLanguage.g:2510:1: rule__Object2__Group_5_1__2__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2514:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2515:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2515:1: ( ';' )
            // InternalBug304681TestLanguage.g:2516:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_1__2__Impl"


    // $ANTLR start "rule__Object2__Group_5_2__0"
    // InternalBug304681TestLanguage.g:2526:1: rule__Object2__Group_5_2__0 : rule__Object2__Group_5_2__0__Impl rule__Object2__Group_5_2__1 ;
    public final void rule__Object2__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2530:1: ( rule__Object2__Group_5_2__0__Impl rule__Object2__Group_5_2__1 )
            // InternalBug304681TestLanguage.g:2531:2: rule__Object2__Group_5_2__0__Impl rule__Object2__Group_5_2__1
            {
            pushFollow(FollowSets000.FOLLOW_12);
            rule__Object2__Group_5_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__0"


    // $ANTLR start "rule__Object2__Group_5_2__0__Impl"
    // InternalBug304681TestLanguage.g:2538:1: rule__Object2__Group_5_2__0__Impl : ( 'serialUID' ) ;
    public final void rule__Object2__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2542:1: ( ( 'serialUID' ) )
            // InternalBug304681TestLanguage.g:2543:1: ( 'serialUID' )
            {
            // InternalBug304681TestLanguage.g:2543:1: ( 'serialUID' )
            // InternalBug304681TestLanguage.g:2544:2: 'serialUID'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_2__1"
    // InternalBug304681TestLanguage.g:2553:1: rule__Object2__Group_5_2__1 : rule__Object2__Group_5_2__1__Impl rule__Object2__Group_5_2__2 ;
    public final void rule__Object2__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2557:1: ( rule__Object2__Group_5_2__1__Impl rule__Object2__Group_5_2__2 )
            // InternalBug304681TestLanguage.g:2558:2: rule__Object2__Group_5_2__1__Impl rule__Object2__Group_5_2__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__1"


    // $ANTLR start "rule__Object2__Group_5_2__1__Impl"
    // InternalBug304681TestLanguage.g:2565:1: rule__Object2__Group_5_2__1__Impl : ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) ) ;
    public final void rule__Object2__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2569:1: ( ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) ) )
            // InternalBug304681TestLanguage.g:2570:1: ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) )
            {
            // InternalBug304681TestLanguage.g:2570:1: ( ( rule__Object2__SerialVersionUIDAssignment_5_2_1 ) )
            // InternalBug304681TestLanguage.g:2571:2: ( rule__Object2__SerialVersionUIDAssignment_5_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSerialVersionUIDAssignment_5_2_1()); 
            }
            // InternalBug304681TestLanguage.g:2572:2: ( rule__Object2__SerialVersionUIDAssignment_5_2_1 )
            // InternalBug304681TestLanguage.g:2572:3: rule__Object2__SerialVersionUIDAssignment_5_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__SerialVersionUIDAssignment_5_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSerialVersionUIDAssignment_5_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__1__Impl"


    // $ANTLR start "rule__Object2__Group_5_2__2"
    // InternalBug304681TestLanguage.g:2580:1: rule__Object2__Group_5_2__2 : rule__Object2__Group_5_2__2__Impl ;
    public final void rule__Object2__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2584:1: ( rule__Object2__Group_5_2__2__Impl )
            // InternalBug304681TestLanguage.g:2585:2: rule__Object2__Group_5_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__2"


    // $ANTLR start "rule__Object2__Group_5_2__2__Impl"
    // InternalBug304681TestLanguage.g:2591:1: rule__Object2__Group_5_2__2__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2595:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2596:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2596:1: ( ';' )
            // InternalBug304681TestLanguage.g:2597:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_2__2__Impl"


    // $ANTLR start "rule__Object2__Group_5_3__0"
    // InternalBug304681TestLanguage.g:2607:1: rule__Object2__Group_5_3__0 : rule__Object2__Group_5_3__0__Impl rule__Object2__Group_5_3__1 ;
    public final void rule__Object2__Group_5_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2611:1: ( rule__Object2__Group_5_3__0__Impl rule__Object2__Group_5_3__1 )
            // InternalBug304681TestLanguage.g:2612:2: rule__Object2__Group_5_3__0__Impl rule__Object2__Group_5_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Object2__Group_5_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_3__0"


    // $ANTLR start "rule__Object2__Group_5_3__0__Impl"
    // InternalBug304681TestLanguage.g:2619:1: rule__Object2__Group_5_3__0__Impl : ( ( rule__Object2__CloneableAssignment_5_3_0 ) ) ;
    public final void rule__Object2__Group_5_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2623:1: ( ( ( rule__Object2__CloneableAssignment_5_3_0 ) ) )
            // InternalBug304681TestLanguage.g:2624:1: ( ( rule__Object2__CloneableAssignment_5_3_0 ) )
            {
            // InternalBug304681TestLanguage.g:2624:1: ( ( rule__Object2__CloneableAssignment_5_3_0 ) )
            // InternalBug304681TestLanguage.g:2625:2: ( rule__Object2__CloneableAssignment_5_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getCloneableAssignment_5_3_0()); 
            }
            // InternalBug304681TestLanguage.g:2626:2: ( rule__Object2__CloneableAssignment_5_3_0 )
            // InternalBug304681TestLanguage.g:2626:3: rule__Object2__CloneableAssignment_5_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__CloneableAssignment_5_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getCloneableAssignment_5_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_3__0__Impl"


    // $ANTLR start "rule__Object2__Group_5_3__1"
    // InternalBug304681TestLanguage.g:2634:1: rule__Object2__Group_5_3__1 : rule__Object2__Group_5_3__1__Impl ;
    public final void rule__Object2__Group_5_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2638:1: ( rule__Object2__Group_5_3__1__Impl )
            // InternalBug304681TestLanguage.g:2639:2: rule__Object2__Group_5_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__Group_5_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_3__1"


    // $ANTLR start "rule__Object2__Group_5_3__1__Impl"
    // InternalBug304681TestLanguage.g:2645:1: rule__Object2__Group_5_3__1__Impl : ( ';' ) ;
    public final void rule__Object2__Group_5_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2649:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2650:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2650:1: ( ';' )
            // InternalBug304681TestLanguage.g:2651:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__Group_5_3__1__Impl"


    // $ANTLR start "rule__Attribute2__Group__0"
    // InternalBug304681TestLanguage.g:2661:1: rule__Attribute2__Group__0 : rule__Attribute2__Group__0__Impl rule__Attribute2__Group__1 ;
    public final void rule__Attribute2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2665:1: ( rule__Attribute2__Group__0__Impl rule__Attribute2__Group__1 )
            // InternalBug304681TestLanguage.g:2666:2: rule__Attribute2__Group__0__Impl rule__Attribute2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__0"


    // $ANTLR start "rule__Attribute2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:2673:1: rule__Attribute2__Group__0__Impl : ( 'Attribute' ) ;
    public final void rule__Attribute2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2677:1: ( ( 'Attribute' ) )
            // InternalBug304681TestLanguage.g:2678:1: ( 'Attribute' )
            {
            // InternalBug304681TestLanguage.g:2678:1: ( 'Attribute' )
            // InternalBug304681TestLanguage.g:2679:2: 'Attribute'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getAttributeKeyword_0()); 
            }
            match(input,26,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getAttributeKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__0__Impl"


    // $ANTLR start "rule__Attribute2__Group__1"
    // InternalBug304681TestLanguage.g:2688:1: rule__Attribute2__Group__1 : rule__Attribute2__Group__1__Impl rule__Attribute2__Group__2 ;
    public final void rule__Attribute2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2692:1: ( rule__Attribute2__Group__1__Impl rule__Attribute2__Group__2 )
            // InternalBug304681TestLanguage.g:2693:2: rule__Attribute2__Group__1__Impl rule__Attribute2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Attribute2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__1"


    // $ANTLR start "rule__Attribute2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:2700:1: rule__Attribute2__Group__1__Impl : ( ( rule__Attribute2__TypeAssignment_1 ) ) ;
    public final void rule__Attribute2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2704:1: ( ( ( rule__Attribute2__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:2705:1: ( ( rule__Attribute2__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:2705:1: ( ( rule__Attribute2__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:2706:2: ( rule__Attribute2__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:2707:2: ( rule__Attribute2__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:2707:3: rule__Attribute2__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__1__Impl"


    // $ANTLR start "rule__Attribute2__Group__2"
    // InternalBug304681TestLanguage.g:2715:1: rule__Attribute2__Group__2 : rule__Attribute2__Group__2__Impl rule__Attribute2__Group__3 ;
    public final void rule__Attribute2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2719:1: ( rule__Attribute2__Group__2__Impl rule__Attribute2__Group__3 )
            // InternalBug304681TestLanguage.g:2720:2: rule__Attribute2__Group__2__Impl rule__Attribute2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Attribute2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__2"


    // $ANTLR start "rule__Attribute2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:2727:1: rule__Attribute2__Group__2__Impl : ( ( rule__Attribute2__NameAssignment_2 ) ) ;
    public final void rule__Attribute2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2731:1: ( ( ( rule__Attribute2__NameAssignment_2 ) ) )
            // InternalBug304681TestLanguage.g:2732:1: ( ( rule__Attribute2__NameAssignment_2 ) )
            {
            // InternalBug304681TestLanguage.g:2732:1: ( ( rule__Attribute2__NameAssignment_2 ) )
            // InternalBug304681TestLanguage.g:2733:2: ( rule__Attribute2__NameAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getNameAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:2734:2: ( rule__Attribute2__NameAssignment_2 )
            // InternalBug304681TestLanguage.g:2734:3: rule__Attribute2__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__NameAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getNameAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__2__Impl"


    // $ANTLR start "rule__Attribute2__Group__3"
    // InternalBug304681TestLanguage.g:2742:1: rule__Attribute2__Group__3 : rule__Attribute2__Group__3__Impl ;
    public final void rule__Attribute2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2746:1: ( rule__Attribute2__Group__3__Impl )
            // InternalBug304681TestLanguage.g:2747:2: rule__Attribute2__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__3"


    // $ANTLR start "rule__Attribute2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:2753:1: rule__Attribute2__Group__3__Impl : ( ( rule__Attribute2__Alternatives_3 ) ) ;
    public final void rule__Attribute2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2757:1: ( ( ( rule__Attribute2__Alternatives_3 ) ) )
            // InternalBug304681TestLanguage.g:2758:1: ( ( rule__Attribute2__Alternatives_3 ) )
            {
            // InternalBug304681TestLanguage.g:2758:1: ( ( rule__Attribute2__Alternatives_3 ) )
            // InternalBug304681TestLanguage.g:2759:2: ( rule__Attribute2__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getAlternatives_3()); 
            }
            // InternalBug304681TestLanguage.g:2760:2: ( rule__Attribute2__Alternatives_3 )
            // InternalBug304681TestLanguage.g:2760:3: rule__Attribute2__Alternatives_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getAlternatives_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group__3__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0__0"
    // InternalBug304681TestLanguage.g:2769:1: rule__Attribute2__Group_3_0__0 : rule__Attribute2__Group_3_0__0__Impl rule__Attribute2__Group_3_0__1 ;
    public final void rule__Attribute2__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2773:1: ( rule__Attribute2__Group_3_0__0__Impl rule__Attribute2__Group_3_0__1 )
            // InternalBug304681TestLanguage.g:2774:2: rule__Attribute2__Group_3_0__0__Impl rule__Attribute2__Group_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__Attribute2__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__0"


    // $ANTLR start "rule__Attribute2__Group_3_0__0__Impl"
    // InternalBug304681TestLanguage.g:2781:1: rule__Attribute2__Group_3_0__0__Impl : ( '{' ) ;
    public final void rule__Attribute2__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2785:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:2786:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:2786:1: ( '{' )
            // InternalBug304681TestLanguage.g:2787:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0__1"
    // InternalBug304681TestLanguage.g:2796:1: rule__Attribute2__Group_3_0__1 : rule__Attribute2__Group_3_0__1__Impl rule__Attribute2__Group_3_0__2 ;
    public final void rule__Attribute2__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2800:1: ( rule__Attribute2__Group_3_0__1__Impl rule__Attribute2__Group_3_0__2 )
            // InternalBug304681TestLanguage.g:2801:2: rule__Attribute2__Group_3_0__1__Impl rule__Attribute2__Group_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Attribute2__Group_3_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__1"


    // $ANTLR start "rule__Attribute2__Group_3_0__1__Impl"
    // InternalBug304681TestLanguage.g:2808:1: rule__Attribute2__Group_3_0__1__Impl : ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) ) ;
    public final void rule__Attribute2__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2812:1: ( ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) ) )
            // InternalBug304681TestLanguage.g:2813:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:2813:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1 ) )
            // InternalBug304681TestLanguage.g:2814:2: ( rule__Attribute2__UnorderedGroup_3_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()); 
            }
            // InternalBug304681TestLanguage.g:2815:2: ( rule__Attribute2__UnorderedGroup_3_0_1 )
            // InternalBug304681TestLanguage.g:2815:3: rule__Attribute2__UnorderedGroup_3_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__UnorderedGroup_3_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0__2"
    // InternalBug304681TestLanguage.g:2823:1: rule__Attribute2__Group_3_0__2 : rule__Attribute2__Group_3_0__2__Impl ;
    public final void rule__Attribute2__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2827:1: ( rule__Attribute2__Group_3_0__2__Impl )
            // InternalBug304681TestLanguage.g:2828:2: rule__Attribute2__Group_3_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__2"


    // $ANTLR start "rule__Attribute2__Group_3_0__2__Impl"
    // InternalBug304681TestLanguage.g:2834:1: rule__Attribute2__Group_3_0__2__Impl : ( '}' ) ;
    public final void rule__Attribute2__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2838:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:2839:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:2839:1: ( '}' )
            // InternalBug304681TestLanguage.g:2840:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0__2__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__0"
    // InternalBug304681TestLanguage.g:2850:1: rule__Attribute2__Group_3_0_1_0__0 : rule__Attribute2__Group_3_0_1_0__0__Impl rule__Attribute2__Group_3_0_1_0__1 ;
    public final void rule__Attribute2__Group_3_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2854:1: ( rule__Attribute2__Group_3_0_1_0__0__Impl rule__Attribute2__Group_3_0_1_0__1 )
            // InternalBug304681TestLanguage.g:2855:2: rule__Attribute2__Group_3_0_1_0__0__Impl rule__Attribute2__Group_3_0_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Attribute2__Group_3_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__0__Impl"
    // InternalBug304681TestLanguage.g:2862:1: rule__Attribute2__Group_3_0_1_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Attribute2__Group_3_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2866:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:2867:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:2867:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:2868:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__1"
    // InternalBug304681TestLanguage.g:2877:1: rule__Attribute2__Group_3_0_1_0__1 : rule__Attribute2__Group_3_0_1_0__1__Impl rule__Attribute2__Group_3_0_1_0__2 ;
    public final void rule__Attribute2__Group_3_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2881:1: ( rule__Attribute2__Group_3_0_1_0__1__Impl rule__Attribute2__Group_3_0_1_0__2 )
            // InternalBug304681TestLanguage.g:2882:2: rule__Attribute2__Group_3_0_1_0__1__Impl rule__Attribute2__Group_3_0_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__1__Impl"
    // InternalBug304681TestLanguage.g:2889:1: rule__Attribute2__Group_3_0_1_0__1__Impl : ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2893:1: ( ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) ) )
            // InternalBug304681TestLanguage.g:2894:1: ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:2894:1: ( ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 ) )
            // InternalBug304681TestLanguage.g:2895:2: ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getShortDescriptionAssignment_3_0_1_0_1()); 
            }
            // InternalBug304681TestLanguage.g:2896:2: ( rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 )
            // InternalBug304681TestLanguage.g:2896:3: rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getShortDescriptionAssignment_3_0_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__2"
    // InternalBug304681TestLanguage.g:2904:1: rule__Attribute2__Group_3_0_1_0__2 : rule__Attribute2__Group_3_0_1_0__2__Impl ;
    public final void rule__Attribute2__Group_3_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2908:1: ( rule__Attribute2__Group_3_0_1_0__2__Impl )
            // InternalBug304681TestLanguage.g:2909:2: rule__Attribute2__Group_3_0_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__2"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_0__2__Impl"
    // InternalBug304681TestLanguage.g:2915:1: rule__Attribute2__Group_3_0_1_0__2__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2919:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:2920:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:2920:1: ( ';' )
            // InternalBug304681TestLanguage.g:2921:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_0__2__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__0"
    // InternalBug304681TestLanguage.g:2931:1: rule__Attribute2__Group_3_0_1_1__0 : rule__Attribute2__Group_3_0_1_1__0__Impl rule__Attribute2__Group_3_0_1_1__1 ;
    public final void rule__Attribute2__Group_3_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2935:1: ( rule__Attribute2__Group_3_0_1_1__0__Impl rule__Attribute2__Group_3_0_1_1__1 )
            // InternalBug304681TestLanguage.g:2936:2: rule__Attribute2__Group_3_0_1_1__0__Impl rule__Attribute2__Group_3_0_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Attribute2__Group_3_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__0__Impl"
    // InternalBug304681TestLanguage.g:2943:1: rule__Attribute2__Group_3_0_1_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Attribute2__Group_3_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2947:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:2948:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:2948:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:2949:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__1"
    // InternalBug304681TestLanguage.g:2958:1: rule__Attribute2__Group_3_0_1_1__1 : rule__Attribute2__Group_3_0_1_1__1__Impl rule__Attribute2__Group_3_0_1_1__2 ;
    public final void rule__Attribute2__Group_3_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2962:1: ( rule__Attribute2__Group_3_0_1_1__1__Impl rule__Attribute2__Group_3_0_1_1__2 )
            // InternalBug304681TestLanguage.g:2963:2: rule__Attribute2__Group_3_0_1_1__1__Impl rule__Attribute2__Group_3_0_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__1__Impl"
    // InternalBug304681TestLanguage.g:2970:1: rule__Attribute2__Group_3_0_1_1__1__Impl : ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2974:1: ( ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) ) )
            // InternalBug304681TestLanguage.g:2975:1: ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:2975:1: ( ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 ) )
            // InternalBug304681TestLanguage.g:2976:2: ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLongDescriptionAssignment_3_0_1_1_1()); 
            }
            // InternalBug304681TestLanguage.g:2977:2: ( rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 )
            // InternalBug304681TestLanguage.g:2977:3: rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLongDescriptionAssignment_3_0_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__2"
    // InternalBug304681TestLanguage.g:2985:1: rule__Attribute2__Group_3_0_1_1__2 : rule__Attribute2__Group_3_0_1_1__2__Impl ;
    public final void rule__Attribute2__Group_3_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:2989:1: ( rule__Attribute2__Group_3_0_1_1__2__Impl )
            // InternalBug304681TestLanguage.g:2990:2: rule__Attribute2__Group_3_0_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__2"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_1__2__Impl"
    // InternalBug304681TestLanguage.g:2996:1: rule__Attribute2__Group_3_0_1_1__2__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3000:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3001:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3001:1: ( ';' )
            // InternalBug304681TestLanguage.g:3002:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_1__2__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__0"
    // InternalBug304681TestLanguage.g:3012:1: rule__Attribute2__Group_3_0_1_3__0 : rule__Attribute2__Group_3_0_1_3__0__Impl rule__Attribute2__Group_3_0_1_3__1 ;
    public final void rule__Attribute2__Group_3_0_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3016:1: ( rule__Attribute2__Group_3_0_1_3__0__Impl rule__Attribute2__Group_3_0_1_3__1 )
            // InternalBug304681TestLanguage.g:3017:2: rule__Attribute2__Group_3_0_1_3__0__Impl rule__Attribute2__Group_3_0_1_3__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__0__Impl"
    // InternalBug304681TestLanguage.g:3024:1: rule__Attribute2__Group_3_0_1_3__0__Impl : ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3028:1: ( ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) ) )
            // InternalBug304681TestLanguage.g:3029:1: ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) )
            {
            // InternalBug304681TestLanguage.g:3029:1: ( ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 ) )
            // InternalBug304681TestLanguage.g:3030:2: ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRequiredAssignment_3_0_1_3_0()); 
            }
            // InternalBug304681TestLanguage.g:3031:2: ( rule__Attribute2__RequiredAssignment_3_0_1_3_0 )
            // InternalBug304681TestLanguage.g:3031:3: rule__Attribute2__RequiredAssignment_3_0_1_3_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__RequiredAssignment_3_0_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRequiredAssignment_3_0_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__1"
    // InternalBug304681TestLanguage.g:3039:1: rule__Attribute2__Group_3_0_1_3__1 : rule__Attribute2__Group_3_0_1_3__1__Impl ;
    public final void rule__Attribute2__Group_3_0_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3043:1: ( rule__Attribute2__Group_3_0_1_3__1__Impl )
            // InternalBug304681TestLanguage.g:3044:2: rule__Attribute2__Group_3_0_1_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_3__1__Impl"
    // InternalBug304681TestLanguage.g:3050:1: rule__Attribute2__Group_3_0_1_3__1__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3054:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3055:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3055:1: ( ';' )
            // InternalBug304681TestLanguage.g:3056:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_3__1__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__0"
    // InternalBug304681TestLanguage.g:3066:1: rule__Attribute2__Group_3_0_1_4__0 : rule__Attribute2__Group_3_0_1_4__0__Impl rule__Attribute2__Group_3_0_1_4__1 ;
    public final void rule__Attribute2__Group_3_0_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3070:1: ( rule__Attribute2__Group_3_0_1_4__0__Impl rule__Attribute2__Group_3_0_1_4__1 )
            // InternalBug304681TestLanguage.g:3071:2: rule__Attribute2__Group_3_0_1_4__0__Impl rule__Attribute2__Group_3_0_1_4__1
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Attribute2__Group_3_0_1_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__0"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__0__Impl"
    // InternalBug304681TestLanguage.g:3078:1: rule__Attribute2__Group_3_0_1_4__0__Impl : ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) ) ;
    public final void rule__Attribute2__Group_3_0_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3082:1: ( ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) ) )
            // InternalBug304681TestLanguage.g:3083:1: ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) )
            {
            // InternalBug304681TestLanguage.g:3083:1: ( ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 ) )
            // InternalBug304681TestLanguage.g:3084:2: ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTechnicalAssignment_3_0_1_4_0()); 
            }
            // InternalBug304681TestLanguage.g:3085:2: ( rule__Attribute2__TechnicalAssignment_3_0_1_4_0 )
            // InternalBug304681TestLanguage.g:3085:3: rule__Attribute2__TechnicalAssignment_3_0_1_4_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__TechnicalAssignment_3_0_1_4_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTechnicalAssignment_3_0_1_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__0__Impl"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__1"
    // InternalBug304681TestLanguage.g:3093:1: rule__Attribute2__Group_3_0_1_4__1 : rule__Attribute2__Group_3_0_1_4__1__Impl ;
    public final void rule__Attribute2__Group_3_0_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3097:1: ( rule__Attribute2__Group_3_0_1_4__1__Impl )
            // InternalBug304681TestLanguage.g:3098:2: rule__Attribute2__Group_3_0_1_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__Group_3_0_1_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__1"


    // $ANTLR start "rule__Attribute2__Group_3_0_1_4__1__Impl"
    // InternalBug304681TestLanguage.g:3104:1: rule__Attribute2__Group_3_0_1_4__1__Impl : ( ';' ) ;
    public final void rule__Attribute2__Group_3_0_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3108:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3109:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3109:1: ( ';' )
            // InternalBug304681TestLanguage.g:3110:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__Group_3_0_1_4__1__Impl"


    // $ANTLR start "rule__Reference2__Group__0"
    // InternalBug304681TestLanguage.g:3120:1: rule__Reference2__Group__0 : rule__Reference2__Group__0__Impl rule__Reference2__Group__1 ;
    public final void rule__Reference2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3124:1: ( rule__Reference2__Group__0__Impl rule__Reference2__Group__1 )
            // InternalBug304681TestLanguage.g:3125:2: rule__Reference2__Group__0__Impl rule__Reference2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Reference2__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__0"


    // $ANTLR start "rule__Reference2__Group__0__Impl"
    // InternalBug304681TestLanguage.g:3132:1: rule__Reference2__Group__0__Impl : ( 'Reference' ) ;
    public final void rule__Reference2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3136:1: ( ( 'Reference' ) )
            // InternalBug304681TestLanguage.g:3137:1: ( 'Reference' )
            {
            // InternalBug304681TestLanguage.g:3137:1: ( 'Reference' )
            // InternalBug304681TestLanguage.g:3138:2: 'Reference'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getReferenceKeyword_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getReferenceKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__0__Impl"


    // $ANTLR start "rule__Reference2__Group__1"
    // InternalBug304681TestLanguage.g:3147:1: rule__Reference2__Group__1 : rule__Reference2__Group__1__Impl rule__Reference2__Group__2 ;
    public final void rule__Reference2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3151:1: ( rule__Reference2__Group__1__Impl rule__Reference2__Group__2 )
            // InternalBug304681TestLanguage.g:3152:2: rule__Reference2__Group__1__Impl rule__Reference2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference2__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__1"


    // $ANTLR start "rule__Reference2__Group__1__Impl"
    // InternalBug304681TestLanguage.g:3159:1: rule__Reference2__Group__1__Impl : ( ( rule__Reference2__TypeAssignment_1 ) ) ;
    public final void rule__Reference2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3163:1: ( ( ( rule__Reference2__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:3164:1: ( ( rule__Reference2__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:3164:1: ( ( rule__Reference2__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:3165:2: ( rule__Reference2__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:3166:2: ( rule__Reference2__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:3166:3: rule__Reference2__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__1__Impl"


    // $ANTLR start "rule__Reference2__Group__2"
    // InternalBug304681TestLanguage.g:3174:1: rule__Reference2__Group__2 : rule__Reference2__Group__2__Impl rule__Reference2__Group__3 ;
    public final void rule__Reference2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3178:1: ( rule__Reference2__Group__2__Impl rule__Reference2__Group__3 )
            // InternalBug304681TestLanguage.g:3179:2: rule__Reference2__Group__2__Impl rule__Reference2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Reference2__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__2"


    // $ANTLR start "rule__Reference2__Group__2__Impl"
    // InternalBug304681TestLanguage.g:3186:1: rule__Reference2__Group__2__Impl : ( ( rule__Reference2__ManyAssignment_2 )? ) ;
    public final void rule__Reference2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3190:1: ( ( ( rule__Reference2__ManyAssignment_2 )? ) )
            // InternalBug304681TestLanguage.g:3191:1: ( ( rule__Reference2__ManyAssignment_2 )? )
            {
            // InternalBug304681TestLanguage.g:3191:1: ( ( rule__Reference2__ManyAssignment_2 )? )
            // InternalBug304681TestLanguage.g:3192:2: ( rule__Reference2__ManyAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getManyAssignment_2()); 
            }
            // InternalBug304681TestLanguage.g:3193:2: ( rule__Reference2__ManyAssignment_2 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalBug304681TestLanguage.g:3193:3: rule__Reference2__ManyAssignment_2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__ManyAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getManyAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__2__Impl"


    // $ANTLR start "rule__Reference2__Group__3"
    // InternalBug304681TestLanguage.g:3201:1: rule__Reference2__Group__3 : rule__Reference2__Group__3__Impl rule__Reference2__Group__4 ;
    public final void rule__Reference2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3205:1: ( rule__Reference2__Group__3__Impl rule__Reference2__Group__4 )
            // InternalBug304681TestLanguage.g:3206:2: rule__Reference2__Group__3__Impl rule__Reference2__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__Reference2__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__3"


    // $ANTLR start "rule__Reference2__Group__3__Impl"
    // InternalBug304681TestLanguage.g:3213:1: rule__Reference2__Group__3__Impl : ( ( rule__Reference2__NameAssignment_3 ) ) ;
    public final void rule__Reference2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3217:1: ( ( ( rule__Reference2__NameAssignment_3 ) ) )
            // InternalBug304681TestLanguage.g:3218:1: ( ( rule__Reference2__NameAssignment_3 ) )
            {
            // InternalBug304681TestLanguage.g:3218:1: ( ( rule__Reference2__NameAssignment_3 ) )
            // InternalBug304681TestLanguage.g:3219:2: ( rule__Reference2__NameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getNameAssignment_3()); 
            }
            // InternalBug304681TestLanguage.g:3220:2: ( rule__Reference2__NameAssignment_3 )
            // InternalBug304681TestLanguage.g:3220:3: rule__Reference2__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__NameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getNameAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__3__Impl"


    // $ANTLR start "rule__Reference2__Group__4"
    // InternalBug304681TestLanguage.g:3228:1: rule__Reference2__Group__4 : rule__Reference2__Group__4__Impl ;
    public final void rule__Reference2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3232:1: ( rule__Reference2__Group__4__Impl )
            // InternalBug304681TestLanguage.g:3233:2: rule__Reference2__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__4"


    // $ANTLR start "rule__Reference2__Group__4__Impl"
    // InternalBug304681TestLanguage.g:3239:1: rule__Reference2__Group__4__Impl : ( ( rule__Reference2__Alternatives_4 ) ) ;
    public final void rule__Reference2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3243:1: ( ( ( rule__Reference2__Alternatives_4 ) ) )
            // InternalBug304681TestLanguage.g:3244:1: ( ( rule__Reference2__Alternatives_4 ) )
            {
            // InternalBug304681TestLanguage.g:3244:1: ( ( rule__Reference2__Alternatives_4 ) )
            // InternalBug304681TestLanguage.g:3245:2: ( rule__Reference2__Alternatives_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getAlternatives_4()); 
            }
            // InternalBug304681TestLanguage.g:3246:2: ( rule__Reference2__Alternatives_4 )
            // InternalBug304681TestLanguage.g:3246:3: rule__Reference2__Alternatives_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Alternatives_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getAlternatives_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group__4__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0__0"
    // InternalBug304681TestLanguage.g:3255:1: rule__Reference2__Group_4_0__0 : rule__Reference2__Group_4_0__0__Impl rule__Reference2__Group_4_0__1 ;
    public final void rule__Reference2__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3259:1: ( rule__Reference2__Group_4_0__0__Impl rule__Reference2__Group_4_0__1 )
            // InternalBug304681TestLanguage.g:3260:2: rule__Reference2__Group_4_0__0__Impl rule__Reference2__Group_4_0__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__Reference2__Group_4_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__0"


    // $ANTLR start "rule__Reference2__Group_4_0__0__Impl"
    // InternalBug304681TestLanguage.g:3267:1: rule__Reference2__Group_4_0__0__Impl : ( '{' ) ;
    public final void rule__Reference2__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3271:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:3272:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:3272:1: ( '{' )
            // InternalBug304681TestLanguage.g:3273:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__0__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0__1"
    // InternalBug304681TestLanguage.g:3282:1: rule__Reference2__Group_4_0__1 : rule__Reference2__Group_4_0__1__Impl rule__Reference2__Group_4_0__2 ;
    public final void rule__Reference2__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3286:1: ( rule__Reference2__Group_4_0__1__Impl rule__Reference2__Group_4_0__2 )
            // InternalBug304681TestLanguage.g:3287:2: rule__Reference2__Group_4_0__1__Impl rule__Reference2__Group_4_0__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__Reference2__Group_4_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__1"


    // $ANTLR start "rule__Reference2__Group_4_0__1__Impl"
    // InternalBug304681TestLanguage.g:3294:1: rule__Reference2__Group_4_0__1__Impl : ( ( rule__Reference2__UnorderedGroup_4_0_1 ) ) ;
    public final void rule__Reference2__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3298:1: ( ( ( rule__Reference2__UnorderedGroup_4_0_1 ) ) )
            // InternalBug304681TestLanguage.g:3299:1: ( ( rule__Reference2__UnorderedGroup_4_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:3299:1: ( ( rule__Reference2__UnorderedGroup_4_0_1 ) )
            // InternalBug304681TestLanguage.g:3300:2: ( rule__Reference2__UnorderedGroup_4_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()); 
            }
            // InternalBug304681TestLanguage.g:3301:2: ( rule__Reference2__UnorderedGroup_4_0_1 )
            // InternalBug304681TestLanguage.g:3301:3: rule__Reference2__UnorderedGroup_4_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__UnorderedGroup_4_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__1__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0__2"
    // InternalBug304681TestLanguage.g:3309:1: rule__Reference2__Group_4_0__2 : rule__Reference2__Group_4_0__2__Impl ;
    public final void rule__Reference2__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3313:1: ( rule__Reference2__Group_4_0__2__Impl )
            // InternalBug304681TestLanguage.g:3314:2: rule__Reference2__Group_4_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__2"


    // $ANTLR start "rule__Reference2__Group_4_0__2__Impl"
    // InternalBug304681TestLanguage.g:3320:1: rule__Reference2__Group_4_0__2__Impl : ( '}' ) ;
    public final void rule__Reference2__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3324:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:3325:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:3325:1: ( '}' )
            // InternalBug304681TestLanguage.g:3326:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0__2__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__0"
    // InternalBug304681TestLanguage.g:3336:1: rule__Reference2__Group_4_0_1_0__0 : rule__Reference2__Group_4_0_1_0__0__Impl rule__Reference2__Group_4_0_1_0__1 ;
    public final void rule__Reference2__Group_4_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3340:1: ( rule__Reference2__Group_4_0_1_0__0__Impl rule__Reference2__Group_4_0_1_0__1 )
            // InternalBug304681TestLanguage.g:3341:2: rule__Reference2__Group_4_0_1_0__0__Impl rule__Reference2__Group_4_0_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference2__Group_4_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__0"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__0__Impl"
    // InternalBug304681TestLanguage.g:3348:1: rule__Reference2__Group_4_0_1_0__0__Impl : ( 'shortDescription' ) ;
    public final void rule__Reference2__Group_4_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3352:1: ( ( 'shortDescription' ) )
            // InternalBug304681TestLanguage.g:3353:1: ( 'shortDescription' )
            {
            // InternalBug304681TestLanguage.g:3353:1: ( 'shortDescription' )
            // InternalBug304681TestLanguage.g:3354:2: 'shortDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__0__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__1"
    // InternalBug304681TestLanguage.g:3363:1: rule__Reference2__Group_4_0_1_0__1 : rule__Reference2__Group_4_0_1_0__1__Impl rule__Reference2__Group_4_0_1_0__2 ;
    public final void rule__Reference2__Group_4_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3367:1: ( rule__Reference2__Group_4_0_1_0__1__Impl rule__Reference2__Group_4_0_1_0__2 )
            // InternalBug304681TestLanguage.g:3368:2: rule__Reference2__Group_4_0_1_0__1__Impl rule__Reference2__Group_4_0_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference2__Group_4_0_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__1"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__1__Impl"
    // InternalBug304681TestLanguage.g:3375:1: rule__Reference2__Group_4_0_1_0__1__Impl : ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) ) ;
    public final void rule__Reference2__Group_4_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3379:1: ( ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) ) )
            // InternalBug304681TestLanguage.g:3380:1: ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) )
            {
            // InternalBug304681TestLanguage.g:3380:1: ( ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 ) )
            // InternalBug304681TestLanguage.g:3381:2: ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getShortDescriptionAssignment_4_0_1_0_1()); 
            }
            // InternalBug304681TestLanguage.g:3382:2: ( rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 )
            // InternalBug304681TestLanguage.g:3382:3: rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getShortDescriptionAssignment_4_0_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__1__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__2"
    // InternalBug304681TestLanguage.g:3390:1: rule__Reference2__Group_4_0_1_0__2 : rule__Reference2__Group_4_0_1_0__2__Impl ;
    public final void rule__Reference2__Group_4_0_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3394:1: ( rule__Reference2__Group_4_0_1_0__2__Impl )
            // InternalBug304681TestLanguage.g:3395:2: rule__Reference2__Group_4_0_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__2"


    // $ANTLR start "rule__Reference2__Group_4_0_1_0__2__Impl"
    // InternalBug304681TestLanguage.g:3401:1: rule__Reference2__Group_4_0_1_0__2__Impl : ( ';' ) ;
    public final void rule__Reference2__Group_4_0_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3405:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3406:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3406:1: ( ';' )
            // InternalBug304681TestLanguage.g:3407:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_0__2__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__0"
    // InternalBug304681TestLanguage.g:3417:1: rule__Reference2__Group_4_0_1_1__0 : rule__Reference2__Group_4_0_1_1__0__Impl rule__Reference2__Group_4_0_1_1__1 ;
    public final void rule__Reference2__Group_4_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3421:1: ( rule__Reference2__Group_4_0_1_1__0__Impl rule__Reference2__Group_4_0_1_1__1 )
            // InternalBug304681TestLanguage.g:3422:2: rule__Reference2__Group_4_0_1_1__0__Impl rule__Reference2__Group_4_0_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Reference2__Group_4_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__0"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__0__Impl"
    // InternalBug304681TestLanguage.g:3429:1: rule__Reference2__Group_4_0_1_1__0__Impl : ( 'longDescription' ) ;
    public final void rule__Reference2__Group_4_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3433:1: ( ( 'longDescription' ) )
            // InternalBug304681TestLanguage.g:3434:1: ( 'longDescription' )
            {
            // InternalBug304681TestLanguage.g:3434:1: ( 'longDescription' )
            // InternalBug304681TestLanguage.g:3435:2: 'longDescription'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__0__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__1"
    // InternalBug304681TestLanguage.g:3444:1: rule__Reference2__Group_4_0_1_1__1 : rule__Reference2__Group_4_0_1_1__1__Impl rule__Reference2__Group_4_0_1_1__2 ;
    public final void rule__Reference2__Group_4_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3448:1: ( rule__Reference2__Group_4_0_1_1__1__Impl rule__Reference2__Group_4_0_1_1__2 )
            // InternalBug304681TestLanguage.g:3449:2: rule__Reference2__Group_4_0_1_1__1__Impl rule__Reference2__Group_4_0_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Reference2__Group_4_0_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__1"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__1__Impl"
    // InternalBug304681TestLanguage.g:3456:1: rule__Reference2__Group_4_0_1_1__1__Impl : ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) ) ;
    public final void rule__Reference2__Group_4_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3460:1: ( ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) ) )
            // InternalBug304681TestLanguage.g:3461:1: ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:3461:1: ( ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 ) )
            // InternalBug304681TestLanguage.g:3462:2: ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLongDescriptionAssignment_4_0_1_1_1()); 
            }
            // InternalBug304681TestLanguage.g:3463:2: ( rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 )
            // InternalBug304681TestLanguage.g:3463:3: rule__Reference2__LongDescriptionAssignment_4_0_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__LongDescriptionAssignment_4_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLongDescriptionAssignment_4_0_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__1__Impl"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__2"
    // InternalBug304681TestLanguage.g:3471:1: rule__Reference2__Group_4_0_1_1__2 : rule__Reference2__Group_4_0_1_1__2__Impl ;
    public final void rule__Reference2__Group_4_0_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3475:1: ( rule__Reference2__Group_4_0_1_1__2__Impl )
            // InternalBug304681TestLanguage.g:3476:2: rule__Reference2__Group_4_0_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__Group_4_0_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__2"


    // $ANTLR start "rule__Reference2__Group_4_0_1_1__2__Impl"
    // InternalBug304681TestLanguage.g:3482:1: rule__Reference2__Group_4_0_1_1__2__Impl : ( ';' ) ;
    public final void rule__Reference2__Group_4_0_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3486:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3487:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3487:1: ( ';' )
            // InternalBug304681TestLanguage.g:3488:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__Group_4_0_1_1__2__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__0"
    // InternalBug304681TestLanguage.g:3498:1: rule__ConstraintDefinition__Group__0 : rule__ConstraintDefinition__Group__0__Impl rule__ConstraintDefinition__Group__1 ;
    public final void rule__ConstraintDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3502:1: ( rule__ConstraintDefinition__Group__0__Impl rule__ConstraintDefinition__Group__1 )
            // InternalBug304681TestLanguage.g:3503:2: rule__ConstraintDefinition__Group__0__Impl rule__ConstraintDefinition__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__ConstraintDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__0"


    // $ANTLR start "rule__ConstraintDefinition__Group__0__Impl"
    // InternalBug304681TestLanguage.g:3510:1: rule__ConstraintDefinition__Group__0__Impl : ( 'constraint' ) ;
    public final void rule__ConstraintDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3514:1: ( ( 'constraint' ) )
            // InternalBug304681TestLanguage.g:3515:1: ( 'constraint' )
            {
            // InternalBug304681TestLanguage.g:3515:1: ( 'constraint' )
            // InternalBug304681TestLanguage.g:3516:2: 'constraint'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__0__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__1"
    // InternalBug304681TestLanguage.g:3525:1: rule__ConstraintDefinition__Group__1 : rule__ConstraintDefinition__Group__1__Impl rule__ConstraintDefinition__Group__2 ;
    public final void rule__ConstraintDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3529:1: ( rule__ConstraintDefinition__Group__1__Impl rule__ConstraintDefinition__Group__2 )
            // InternalBug304681TestLanguage.g:3530:2: rule__ConstraintDefinition__Group__1__Impl rule__ConstraintDefinition__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__ConstraintDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__1"


    // $ANTLR start "rule__ConstraintDefinition__Group__1__Impl"
    // InternalBug304681TestLanguage.g:3537:1: rule__ConstraintDefinition__Group__1__Impl : ( ( rule__ConstraintDefinition__TypeAssignment_1 ) ) ;
    public final void rule__ConstraintDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3541:1: ( ( ( rule__ConstraintDefinition__TypeAssignment_1 ) ) )
            // InternalBug304681TestLanguage.g:3542:1: ( ( rule__ConstraintDefinition__TypeAssignment_1 ) )
            {
            // InternalBug304681TestLanguage.g:3542:1: ( ( rule__ConstraintDefinition__TypeAssignment_1 ) )
            // InternalBug304681TestLanguage.g:3543:2: ( rule__ConstraintDefinition__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getTypeAssignment_1()); 
            }
            // InternalBug304681TestLanguage.g:3544:2: ( rule__ConstraintDefinition__TypeAssignment_1 )
            // InternalBug304681TestLanguage.g:3544:3: rule__ConstraintDefinition__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getTypeAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__1__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__2"
    // InternalBug304681TestLanguage.g:3552:1: rule__ConstraintDefinition__Group__2 : rule__ConstraintDefinition__Group__2__Impl rule__ConstraintDefinition__Group__3 ;
    public final void rule__ConstraintDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3556:1: ( rule__ConstraintDefinition__Group__2__Impl rule__ConstraintDefinition__Group__3 )
            // InternalBug304681TestLanguage.g:3557:2: rule__ConstraintDefinition__Group__2__Impl rule__ConstraintDefinition__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__ConstraintDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__2"


    // $ANTLR start "rule__ConstraintDefinition__Group__2__Impl"
    // InternalBug304681TestLanguage.g:3564:1: rule__ConstraintDefinition__Group__2__Impl : ( '{' ) ;
    public final void rule__ConstraintDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3568:1: ( ( '{' ) )
            // InternalBug304681TestLanguage.g:3569:1: ( '{' )
            {
            // InternalBug304681TestLanguage.g:3569:1: ( '{' )
            // InternalBug304681TestLanguage.g:3570:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,16,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__2__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__3"
    // InternalBug304681TestLanguage.g:3579:1: rule__ConstraintDefinition__Group__3 : rule__ConstraintDefinition__Group__3__Impl rule__ConstraintDefinition__Group__4 ;
    public final void rule__ConstraintDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3583:1: ( rule__ConstraintDefinition__Group__3__Impl rule__ConstraintDefinition__Group__4 )
            // InternalBug304681TestLanguage.g:3584:2: rule__ConstraintDefinition__Group__3__Impl rule__ConstraintDefinition__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__ConstraintDefinition__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__3"


    // $ANTLR start "rule__ConstraintDefinition__Group__3__Impl"
    // InternalBug304681TestLanguage.g:3591:1: rule__ConstraintDefinition__Group__3__Impl : ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) ) ;
    public final void rule__ConstraintDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3595:1: ( ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) ) )
            // InternalBug304681TestLanguage.g:3596:1: ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) )
            {
            // InternalBug304681TestLanguage.g:3596:1: ( ( rule__ConstraintDefinition__UnorderedGroup_3 ) )
            // InternalBug304681TestLanguage.g:3597:2: ( rule__ConstraintDefinition__UnorderedGroup_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()); 
            }
            // InternalBug304681TestLanguage.g:3598:2: ( rule__ConstraintDefinition__UnorderedGroup_3 )
            // InternalBug304681TestLanguage.g:3598:3: rule__ConstraintDefinition__UnorderedGroup_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__UnorderedGroup_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__3__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group__4"
    // InternalBug304681TestLanguage.g:3606:1: rule__ConstraintDefinition__Group__4 : rule__ConstraintDefinition__Group__4__Impl ;
    public final void rule__ConstraintDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3610:1: ( rule__ConstraintDefinition__Group__4__Impl )
            // InternalBug304681TestLanguage.g:3611:2: rule__ConstraintDefinition__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__4"


    // $ANTLR start "rule__ConstraintDefinition__Group__4__Impl"
    // InternalBug304681TestLanguage.g:3617:1: rule__ConstraintDefinition__Group__4__Impl : ( '}' ) ;
    public final void rule__ConstraintDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3621:1: ( ( '}' ) )
            // InternalBug304681TestLanguage.g:3622:1: ( '}' )
            {
            // InternalBug304681TestLanguage.g:3622:1: ( '}' )
            // InternalBug304681TestLanguage.g:3623:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,17,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group__4__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__0"
    // InternalBug304681TestLanguage.g:3633:1: rule__ConstraintDefinition__Group_3_0__0 : rule__ConstraintDefinition__Group_3_0__0__Impl rule__ConstraintDefinition__Group_3_0__1 ;
    public final void rule__ConstraintDefinition__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3637:1: ( rule__ConstraintDefinition__Group_3_0__0__Impl rule__ConstraintDefinition__Group_3_0__1 )
            // InternalBug304681TestLanguage.g:3638:2: rule__ConstraintDefinition__Group_3_0__0__Impl rule__ConstraintDefinition__Group_3_0__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__ConstraintDefinition__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__0"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__0__Impl"
    // InternalBug304681TestLanguage.g:3645:1: rule__ConstraintDefinition__Group_3_0__0__Impl : ( 'parameters' ) ;
    public final void rule__ConstraintDefinition__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3649:1: ( ( 'parameters' ) )
            // InternalBug304681TestLanguage.g:3650:1: ( 'parameters' )
            {
            // InternalBug304681TestLanguage.g:3650:1: ( 'parameters' )
            // InternalBug304681TestLanguage.g:3651:2: 'parameters'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__0__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__1"
    // InternalBug304681TestLanguage.g:3660:1: rule__ConstraintDefinition__Group_3_0__1 : rule__ConstraintDefinition__Group_3_0__1__Impl rule__ConstraintDefinition__Group_3_0__2 ;
    public final void rule__ConstraintDefinition__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3664:1: ( rule__ConstraintDefinition__Group_3_0__1__Impl rule__ConstraintDefinition__Group_3_0__2 )
            // InternalBug304681TestLanguage.g:3665:2: rule__ConstraintDefinition__Group_3_0__1__Impl rule__ConstraintDefinition__Group_3_0__2
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__ConstraintDefinition__Group_3_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__1"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__1__Impl"
    // InternalBug304681TestLanguage.g:3672:1: rule__ConstraintDefinition__Group_3_0__1__Impl : ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* ) ;
    public final void rule__ConstraintDefinition__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3676:1: ( ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* ) )
            // InternalBug304681TestLanguage.g:3677:1: ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* )
            {
            // InternalBug304681TestLanguage.g:3677:1: ( ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )* )
            // InternalBug304681TestLanguage.g:3678:2: ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getParametersAssignment_3_0_1()); 
            }
            // InternalBug304681TestLanguage.g:3679:2: ( rule__ConstraintDefinition__ParametersAssignment_3_0_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_STRING) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBug304681TestLanguage.g:3679:3: rule__ConstraintDefinition__ParametersAssignment_3_0_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_24);
            	    rule__ConstraintDefinition__ParametersAssignment_3_0_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getParametersAssignment_3_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__1__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__2"
    // InternalBug304681TestLanguage.g:3687:1: rule__ConstraintDefinition__Group_3_0__2 : rule__ConstraintDefinition__Group_3_0__2__Impl ;
    public final void rule__ConstraintDefinition__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3691:1: ( rule__ConstraintDefinition__Group_3_0__2__Impl )
            // InternalBug304681TestLanguage.g:3692:2: rule__ConstraintDefinition__Group_3_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__2"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_0__2__Impl"
    // InternalBug304681TestLanguage.g:3698:1: rule__ConstraintDefinition__Group_3_0__2__Impl : ( ';' ) ;
    public final void rule__ConstraintDefinition__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3702:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3703:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3703:1: ( ';' )
            // InternalBug304681TestLanguage.g:3704:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_0__2__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__0"
    // InternalBug304681TestLanguage.g:3714:1: rule__ConstraintDefinition__Group_3_1__0 : rule__ConstraintDefinition__Group_3_1__0__Impl rule__ConstraintDefinition__Group_3_1__1 ;
    public final void rule__ConstraintDefinition__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3718:1: ( rule__ConstraintDefinition__Group_3_1__0__Impl rule__ConstraintDefinition__Group_3_1__1 )
            // InternalBug304681TestLanguage.g:3719:2: rule__ConstraintDefinition__Group_3_1__0__Impl rule__ConstraintDefinition__Group_3_1__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__ConstraintDefinition__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__0"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__0__Impl"
    // InternalBug304681TestLanguage.g:3726:1: rule__ConstraintDefinition__Group_3_1__0__Impl : ( 'message' ) ;
    public final void rule__ConstraintDefinition__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3730:1: ( ( 'message' ) )
            // InternalBug304681TestLanguage.g:3731:1: ( 'message' )
            {
            // InternalBug304681TestLanguage.g:3731:1: ( 'message' )
            // InternalBug304681TestLanguage.g:3732:2: 'message'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__0__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__1"
    // InternalBug304681TestLanguage.g:3741:1: rule__ConstraintDefinition__Group_3_1__1 : rule__ConstraintDefinition__Group_3_1__1__Impl rule__ConstraintDefinition__Group_3_1__2 ;
    public final void rule__ConstraintDefinition__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3745:1: ( rule__ConstraintDefinition__Group_3_1__1__Impl rule__ConstraintDefinition__Group_3_1__2 )
            // InternalBug304681TestLanguage.g:3746:2: rule__ConstraintDefinition__Group_3_1__1__Impl rule__ConstraintDefinition__Group_3_1__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__ConstraintDefinition__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__1"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__1__Impl"
    // InternalBug304681TestLanguage.g:3753:1: rule__ConstraintDefinition__Group_3_1__1__Impl : ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) ) ;
    public final void rule__ConstraintDefinition__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3757:1: ( ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) ) )
            // InternalBug304681TestLanguage.g:3758:1: ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) )
            {
            // InternalBug304681TestLanguage.g:3758:1: ( ( rule__ConstraintDefinition__MessageAssignment_3_1_1 ) )
            // InternalBug304681TestLanguage.g:3759:2: ( rule__ConstraintDefinition__MessageAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getMessageAssignment_3_1_1()); 
            }
            // InternalBug304681TestLanguage.g:3760:2: ( rule__ConstraintDefinition__MessageAssignment_3_1_1 )
            // InternalBug304681TestLanguage.g:3760:3: rule__ConstraintDefinition__MessageAssignment_3_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__MessageAssignment_3_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getMessageAssignment_3_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__1__Impl"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__2"
    // InternalBug304681TestLanguage.g:3768:1: rule__ConstraintDefinition__Group_3_1__2 : rule__ConstraintDefinition__Group_3_1__2__Impl ;
    public final void rule__ConstraintDefinition__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3772:1: ( rule__ConstraintDefinition__Group_3_1__2__Impl )
            // InternalBug304681TestLanguage.g:3773:2: rule__ConstraintDefinition__Group_3_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__Group_3_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__2"


    // $ANTLR start "rule__ConstraintDefinition__Group_3_1__2__Impl"
    // InternalBug304681TestLanguage.g:3779:1: rule__ConstraintDefinition__Group_3_1__2__Impl : ( ';' ) ;
    public final void rule__ConstraintDefinition__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3783:1: ( ( ';' ) )
            // InternalBug304681TestLanguage.g:3784:1: ( ';' )
            {
            // InternalBug304681TestLanguage.g:3784:1: ( ';' )
            // InternalBug304681TestLanguage.g:3785:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2()); 
            }
            match(input,11,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__Group_3_1__2__Impl"


    // $ANTLR start "rule__Object__UnorderedGroup_5"
    // InternalBug304681TestLanguage.g:3795:1: rule__Object__UnorderedGroup_5 : ( rule__Object__UnorderedGroup_5__0 )? ;
    public final void rule__Object__UnorderedGroup_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
        	
        try {
            // InternalBug304681TestLanguage.g:3800:1: ( ( rule__Object__UnorderedGroup_5__0 )? )
            // InternalBug304681TestLanguage.g:3801:2: ( rule__Object__UnorderedGroup_5__0 )?
            {
            // InternalBug304681TestLanguage.g:3801:2: ( rule__Object__UnorderedGroup_5__0 )?
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__0();

                    state._fsp--;
                    if (state.failed) return ;

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

            	getUnorderedGroupHelper().leave(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5"


    // $ANTLR start "rule__Object__UnorderedGroup_5__Impl"
    // InternalBug304681TestLanguage.g:3809:1: rule__Object__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) ;
    public final void rule__Object__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:3814:1: ( ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:3815:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:3815:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )
            int alt23=8;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalBug304681TestLanguage.g:3816:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3816:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3817:4: {...}? => ( ( ( rule__Object__Group_5_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:3817:102: ( ( ( rule__Object__Group_5_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:3818:5: ( ( rule__Object__Group_5_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3824:5: ( ( rule__Object__Group_5_0__0 ) )
                    // InternalBug304681TestLanguage.g:3825:6: ( rule__Object__Group_5_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_0()); 
                    }
                    // InternalBug304681TestLanguage.g:3826:6: ( rule__Object__Group_5_0__0 )
                    // InternalBug304681TestLanguage.g:3826:7: rule__Object__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:3831:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3831:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3832:4: {...}? => ( ( ( rule__Object__Group_5_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:3832:102: ( ( ( rule__Object__Group_5_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:3833:5: ( ( rule__Object__Group_5_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3839:5: ( ( rule__Object__Group_5_1__0 ) )
                    // InternalBug304681TestLanguage.g:3840:6: ( rule__Object__Group_5_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_1()); 
                    }
                    // InternalBug304681TestLanguage.g:3841:6: ( rule__Object__Group_5_1__0 )
                    // InternalBug304681TestLanguage.g:3841:7: rule__Object__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug304681TestLanguage.g:3846:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3846:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3847:4: {...}? => ( ( ( rule__Object__Group_5_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
                    }
                    // InternalBug304681TestLanguage.g:3847:102: ( ( ( rule__Object__Group_5_2__0 ) ) )
                    // InternalBug304681TestLanguage.g:3848:5: ( ( rule__Object__Group_5_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3854:5: ( ( rule__Object__Group_5_2__0 ) )
                    // InternalBug304681TestLanguage.g:3855:6: ( rule__Object__Group_5_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_2()); 
                    }
                    // InternalBug304681TestLanguage.g:3856:6: ( rule__Object__Group_5_2__0 )
                    // InternalBug304681TestLanguage.g:3856:7: rule__Object__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug304681TestLanguage.g:3861:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3861:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3862:4: {...}? => ( ( ( rule__Object__Group_5_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
                    }
                    // InternalBug304681TestLanguage.g:3862:102: ( ( ( rule__Object__Group_5_3__0 ) ) )
                    // InternalBug304681TestLanguage.g:3863:5: ( ( rule__Object__Group_5_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3869:5: ( ( rule__Object__Group_5_3__0 ) )
                    // InternalBug304681TestLanguage.g:3870:6: ( rule__Object__Group_5_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_3()); 
                    }
                    // InternalBug304681TestLanguage.g:3871:6: ( rule__Object__Group_5_3__0 )
                    // InternalBug304681TestLanguage.g:3871:7: rule__Object__Group_5_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug304681TestLanguage.g:3876:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3876:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
                    // InternalBug304681TestLanguage.g:3877:4: {...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
                    }
                    // InternalBug304681TestLanguage.g:3877:102: ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
                    // InternalBug304681TestLanguage.g:3878:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3884:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
                    // InternalBug304681TestLanguage.g:3885:6: ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
                    {
                    // InternalBug304681TestLanguage.g:3885:6: ( ( rule__Object__FeaturesAssignment_5_4 ) )
                    // InternalBug304681TestLanguage.g:3886:7: ( rule__Object__FeaturesAssignment_5_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:3887:7: ( rule__Object__FeaturesAssignment_5_4 )
                    // InternalBug304681TestLanguage.g:3887:8: rule__Object__FeaturesAssignment_5_4
                    {
                    pushFollow(FollowSets000.FOLLOW_14);
                    rule__Object__FeaturesAssignment_5_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }

                    }

                    // InternalBug304681TestLanguage.g:3890:6: ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
                    // InternalBug304681TestLanguage.g:3891:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:3892:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
                    loop22:
                    do {
                        int alt22=2;
                        alt22 = dfa22.predict(input);
                        switch (alt22) {
                    	case 1 :
                    	    // InternalBug304681TestLanguage.g:3892:8: ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_14);
                    	    rule__Object__FeaturesAssignment_5_4();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalBug304681TestLanguage.g:3898:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3898:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3899:4: {...}? => ( ( ( rule__Object__Group_5_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
                    }
                    // InternalBug304681TestLanguage.g:3899:102: ( ( ( rule__Object__Group_5_5__0 ) ) )
                    // InternalBug304681TestLanguage.g:3900:5: ( ( rule__Object__Group_5_5__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3906:5: ( ( rule__Object__Group_5_5__0 ) )
                    // InternalBug304681TestLanguage.g:3907:6: ( rule__Object__Group_5_5__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_5()); 
                    }
                    // InternalBug304681TestLanguage.g:3908:6: ( rule__Object__Group_5_5__0 )
                    // InternalBug304681TestLanguage.g:3908:7: rule__Object__Group_5_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_5__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_5()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalBug304681TestLanguage.g:3913:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3913:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3914:4: {...}? => ( ( ( rule__Object__Group_5_6__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
                    }
                    // InternalBug304681TestLanguage.g:3914:102: ( ( ( rule__Object__Group_5_6__0 ) ) )
                    // InternalBug304681TestLanguage.g:3915:5: ( ( rule__Object__Group_5_6__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3921:5: ( ( rule__Object__Group_5_6__0 ) )
                    // InternalBug304681TestLanguage.g:3922:6: ( rule__Object__Group_5_6__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_6()); 
                    }
                    // InternalBug304681TestLanguage.g:3923:6: ( rule__Object__Group_5_6__0 )
                    // InternalBug304681TestLanguage.g:3923:7: rule__Object__Group_5_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_6()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalBug304681TestLanguage.g:3928:3: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:3928:3: ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:3929:4: {...}? => ( ( ( rule__Object__Group_5_7__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
                    }
                    // InternalBug304681TestLanguage.g:3929:102: ( ( ( rule__Object__Group_5_7__0 ) ) )
                    // InternalBug304681TestLanguage.g:3930:5: ( ( rule__Object__Group_5_7__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
                    selected = true;
                    // InternalBug304681TestLanguage.g:3936:5: ( ( rule__Object__Group_5_7__0 ) )
                    // InternalBug304681TestLanguage.g:3937:6: ( rule__Object__Group_5_7__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectAccess().getGroup_5_7()); 
                    }
                    // InternalBug304681TestLanguage.g:3938:6: ( rule__Object__Group_5_7__0 )
                    // InternalBug304681TestLanguage.g:3938:7: rule__Object__Group_5_7__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__Group_5_7__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectAccess().getGroup_5_7()); 
                    }

                    }


                    }


                    }


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

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__Impl"


    // $ANTLR start "rule__Object__UnorderedGroup_5__0"
    // InternalBug304681TestLanguage.g:3951:1: rule__Object__UnorderedGroup_5__0 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? ;
    public final void rule__Object__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3955:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )? )
            // InternalBug304681TestLanguage.g:3956:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3957:2: ( rule__Object__UnorderedGroup_5__1 )?
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__1();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__0"


    // $ANTLR start "rule__Object__UnorderedGroup_5__1"
    // InternalBug304681TestLanguage.g:3963:1: rule__Object__UnorderedGroup_5__1 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? ;
    public final void rule__Object__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3967:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )? )
            // InternalBug304681TestLanguage.g:3968:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3969:2: ( rule__Object__UnorderedGroup_5__2 )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__2();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__1"


    // $ANTLR start "rule__Object__UnorderedGroup_5__2"
    // InternalBug304681TestLanguage.g:3975:1: rule__Object__UnorderedGroup_5__2 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? ;
    public final void rule__Object__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3979:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )? )
            // InternalBug304681TestLanguage.g:3980:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3981:2: ( rule__Object__UnorderedGroup_5__3 )?
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__3();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__2"


    // $ANTLR start "rule__Object__UnorderedGroup_5__3"
    // InternalBug304681TestLanguage.g:3987:1: rule__Object__UnorderedGroup_5__3 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? ;
    public final void rule__Object__UnorderedGroup_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:3991:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )? )
            // InternalBug304681TestLanguage.g:3992:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:3993:2: ( rule__Object__UnorderedGroup_5__4 )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__4();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__3"


    // $ANTLR start "rule__Object__UnorderedGroup_5__4"
    // InternalBug304681TestLanguage.g:3999:1: rule__Object__UnorderedGroup_5__4 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? ;
    public final void rule__Object__UnorderedGroup_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4003:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )? )
            // InternalBug304681TestLanguage.g:4004:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__5 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4005:2: ( rule__Object__UnorderedGroup_5__5 )?
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__5
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__5();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__4"


    // $ANTLR start "rule__Object__UnorderedGroup_5__5"
    // InternalBug304681TestLanguage.g:4011:1: rule__Object__UnorderedGroup_5__5 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? ;
    public final void rule__Object__UnorderedGroup_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4015:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )? )
            // InternalBug304681TestLanguage.g:4016:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__6 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4017:2: ( rule__Object__UnorderedGroup_5__6 )?
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__6
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__6();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__5"


    // $ANTLR start "rule__Object__UnorderedGroup_5__6"
    // InternalBug304681TestLanguage.g:4023:1: rule__Object__UnorderedGroup_5__6 : rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? ;
    public final void rule__Object__UnorderedGroup_5__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4027:1: ( rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )? )
            // InternalBug304681TestLanguage.g:4028:2: rule__Object__UnorderedGroup_5__Impl ( rule__Object__UnorderedGroup_5__7 )?
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4029:2: ( rule__Object__UnorderedGroup_5__7 )?
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object__UnorderedGroup_5__7
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object__UnorderedGroup_5__7();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__6"


    // $ANTLR start "rule__Object__UnorderedGroup_5__7"
    // InternalBug304681TestLanguage.g:4035:1: rule__Object__UnorderedGroup_5__7 : rule__Object__UnorderedGroup_5__Impl ;
    public final void rule__Object__UnorderedGroup_5__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4039:1: ( rule__Object__UnorderedGroup_5__Impl )
            // InternalBug304681TestLanguage.g:4040:2: rule__Object__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__UnorderedGroup_5__7"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1"
    // InternalBug304681TestLanguage.g:4047:1: rule__Reference__UnorderedGroup_4_0_1 : ( rule__Reference__UnorderedGroup_4_0_1__0 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
        	
        try {
            // InternalBug304681TestLanguage.g:4052:1: ( ( rule__Reference__UnorderedGroup_4_0_1__0 )? )
            // InternalBug304681TestLanguage.g:4053:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            {
            // InternalBug304681TestLanguage.g:4053:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( LA31_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                alt31=1;
            }
            else if ( LA31_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference__UnorderedGroup_4_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__UnorderedGroup_4_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

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

            	getUnorderedGroupHelper().leave(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1__Impl"
    // InternalBug304681TestLanguage.g:4061:1: rule__Reference__UnorderedGroup_4_0_1__Impl : ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) ;
    public final void rule__Reference__UnorderedGroup_4_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4066:1: ( ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4067:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4067:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( LA32_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                alt32=1;
            }
            else if ( LA32_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4068:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4068:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4069:4: {...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4069:109: ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4070:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4076:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
                    // InternalBug304681TestLanguage.g:4077:6: ( rule__Reference__Group_4_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4078:6: ( rule__Reference__Group_4_0_1_0__0 )
                    // InternalBug304681TestLanguage.g:4078:7: rule__Reference__Group_4_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__Group_4_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4083:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4083:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4084:4: {...}? => ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4084:109: ( ( ( rule__Reference__Group_4_0_1_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4085:5: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4091:5: ( ( rule__Reference__Group_4_0_1_1__0 ) )
                    // InternalBug304681TestLanguage.g:4092:6: ( rule__Reference__Group_4_0_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4093:6: ( rule__Reference__Group_4_0_1_1__0 )
                    // InternalBug304681TestLanguage.g:4093:7: rule__Reference__Group_4_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__Group_4_0_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReferenceAccess().getGroup_4_0_1_1()); 
                    }

                    }


                    }


                    }


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

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1__Impl"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1__0"
    // InternalBug304681TestLanguage.g:4106:1: rule__Reference__UnorderedGroup_4_0_1__0 : rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? ;
    public final void rule__Reference__UnorderedGroup_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4110:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )? )
            // InternalBug304681TestLanguage.g:4111:2: rule__Reference__UnorderedGroup_4_0_1__Impl ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__Reference__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4112:2: ( rule__Reference__UnorderedGroup_4_0_1__1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( LA33_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                alt33=1;
            }
            else if ( LA33_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference__UnorderedGroup_4_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference__UnorderedGroup_4_0_1__1();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1__0"


    // $ANTLR start "rule__Reference__UnorderedGroup_4_0_1__1"
    // InternalBug304681TestLanguage.g:4118:1: rule__Reference__UnorderedGroup_4_0_1__1 : rule__Reference__UnorderedGroup_4_0_1__Impl ;
    public final void rule__Reference__UnorderedGroup_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4122:1: ( rule__Reference__UnorderedGroup_4_0_1__Impl )
            // InternalBug304681TestLanguage.g:4123:2: rule__Reference__UnorderedGroup_4_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__UnorderedGroup_4_0_1__1"


    // $ANTLR start "rule__Object2__UnorderedGroup_5"
    // InternalBug304681TestLanguage.g:4130:1: rule__Object2__UnorderedGroup_5 : ( rule__Object2__UnorderedGroup_5__0 )? ;
    public final void rule__Object2__UnorderedGroup_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getObject2Access().getUnorderedGroup_5());
        	
        try {
            // InternalBug304681TestLanguage.g:4135:1: ( ( rule__Object2__UnorderedGroup_5__0 )? )
            // InternalBug304681TestLanguage.g:4136:2: ( rule__Object2__UnorderedGroup_5__0 )?
            {
            // InternalBug304681TestLanguage.g:4136:2: ( rule__Object2__UnorderedGroup_5__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( LA34_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt34=1;
            }
            else if ( LA34_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt34=1;
            }
            else if ( LA34_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt34=1;
            }
            else if ( LA34_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt34=1;
            }
            else if ( LA34_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt34=1;
            }
            else if ( LA34_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__0();

                    state._fsp--;
                    if (state.failed) return ;

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

            	getUnorderedGroupHelper().leave(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__Impl"
    // InternalBug304681TestLanguage.g:4144:1: rule__Object2__UnorderedGroup_5__Impl : ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) ) ;
    public final void rule__Object2__UnorderedGroup_5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4149:1: ( ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4150:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4150:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) ) )
            int alt36=5;
            int LA36_0 = input.LA(1);

            if ( LA36_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt36=1;
            }
            else if ( LA36_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt36=2;
            }
            else if ( LA36_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt36=3;
            }
            else if ( LA36_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt36=4;
            }
            else if ( LA36_0 >= 26 && LA36_0 <= 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt36=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4151:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4151:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4152:4: {...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4152:103: ( ( ( rule__Object2__Group_5_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4153:5: ( ( rule__Object2__Group_5_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4159:5: ( ( rule__Object2__Group_5_0__0 ) )
                    // InternalBug304681TestLanguage.g:4160:6: ( rule__Object2__Group_5_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4161:6: ( rule__Object2__Group_5_0__0 )
                    // InternalBug304681TestLanguage.g:4161:7: rule__Object2__Group_5_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4166:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4166:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4167:4: {...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4167:103: ( ( ( rule__Object2__Group_5_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4168:5: ( ( rule__Object2__Group_5_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4174:5: ( ( rule__Object2__Group_5_1__0 ) )
                    // InternalBug304681TestLanguage.g:4175:6: ( rule__Object2__Group_5_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4176:6: ( rule__Object2__Group_5_1__0 )
                    // InternalBug304681TestLanguage.g:4176:7: rule__Object2__Group_5_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug304681TestLanguage.g:4181:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4181:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4182:4: {...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
                    }
                    // InternalBug304681TestLanguage.g:4182:103: ( ( ( rule__Object2__Group_5_2__0 ) ) )
                    // InternalBug304681TestLanguage.g:4183:5: ( ( rule__Object2__Group_5_2__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4189:5: ( ( rule__Object2__Group_5_2__0 ) )
                    // InternalBug304681TestLanguage.g:4190:6: ( rule__Object2__Group_5_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_2()); 
                    }
                    // InternalBug304681TestLanguage.g:4191:6: ( rule__Object2__Group_5_2__0 )
                    // InternalBug304681TestLanguage.g:4191:7: rule__Object2__Group_5_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_2()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug304681TestLanguage.g:4196:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4196:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4197:4: {...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
                    }
                    // InternalBug304681TestLanguage.g:4197:103: ( ( ( rule__Object2__Group_5_3__0 ) ) )
                    // InternalBug304681TestLanguage.g:4198:5: ( ( rule__Object2__Group_5_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4204:5: ( ( rule__Object2__Group_5_3__0 ) )
                    // InternalBug304681TestLanguage.g:4205:6: ( rule__Object2__Group_5_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getGroup_5_3()); 
                    }
                    // InternalBug304681TestLanguage.g:4206:6: ( rule__Object2__Group_5_3__0 )
                    // InternalBug304681TestLanguage.g:4206:7: rule__Object2__Group_5_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__Group_5_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getGroup_5_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug304681TestLanguage.g:4211:3: ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4211:3: ({...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) ) )
                    // InternalBug304681TestLanguage.g:4212:4: {...}? => ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Object2__UnorderedGroup_5__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
                    }
                    // InternalBug304681TestLanguage.g:4212:103: ( ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) ) )
                    // InternalBug304681TestLanguage.g:4213:5: ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4219:5: ( ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* ) )
                    // InternalBug304681TestLanguage.g:4220:6: ( ( rule__Object2__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* )
                    {
                    // InternalBug304681TestLanguage.g:4220:6: ( ( rule__Object2__FeaturesAssignment_5_4 ) )
                    // InternalBug304681TestLanguage.g:4221:7: ( rule__Object2__FeaturesAssignment_5_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:4222:7: ( rule__Object2__FeaturesAssignment_5_4 )
                    // InternalBug304681TestLanguage.g:4222:8: rule__Object2__FeaturesAssignment_5_4
                    {
                    pushFollow(FollowSets000.FOLLOW_27);
                    rule__Object2__FeaturesAssignment_5_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }

                    }

                    // InternalBug304681TestLanguage.g:4225:6: ( ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )* )
                    // InternalBug304681TestLanguage.g:4226:7: ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }
                    // InternalBug304681TestLanguage.g:4227:7: ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )*
                    loop35:
                    do {
                        int alt35=2;
                        alt35 = dfa35.predict(input);
                        switch (alt35) {
                    	case 1 :
                    	    // InternalBug304681TestLanguage.g:4227:8: ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_27);
                    	    rule__Object2__FeaturesAssignment_5_4();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObject2Access().getFeaturesAssignment_5_4()); 
                    }

                    }


                    }


                    }


                    }


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

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__Impl"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__0"
    // InternalBug304681TestLanguage.g:4241:1: rule__Object2__UnorderedGroup_5__0 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )? ;
    public final void rule__Object2__UnorderedGroup_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4245:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )? )
            // InternalBug304681TestLanguage.g:4246:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4247:2: ( rule__Object2__UnorderedGroup_5__1 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( LA37_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt37=1;
            }
            else if ( LA37_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt37=1;
            }
            else if ( LA37_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt37=1;
            }
            else if ( LA37_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt37=1;
            }
            else if ( LA37_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt37=1;
            }
            else if ( LA37_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__1();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__0"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__1"
    // InternalBug304681TestLanguage.g:4253:1: rule__Object2__UnorderedGroup_5__1 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )? ;
    public final void rule__Object2__UnorderedGroup_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4257:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )? )
            // InternalBug304681TestLanguage.g:4258:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4259:2: ( rule__Object2__UnorderedGroup_5__2 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( LA38_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt38=1;
            }
            else if ( LA38_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt38=1;
            }
            else if ( LA38_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt38=1;
            }
            else if ( LA38_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt38=1;
            }
            else if ( LA38_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt38=1;
            }
            else if ( LA38_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__2();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__1"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__2"
    // InternalBug304681TestLanguage.g:4265:1: rule__Object2__UnorderedGroup_5__2 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )? ;
    public final void rule__Object2__UnorderedGroup_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4269:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )? )
            // InternalBug304681TestLanguage.g:4270:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4271:2: ( rule__Object2__UnorderedGroup_5__3 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( LA39_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt39=1;
            }
            else if ( LA39_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt39=1;
            }
            else if ( LA39_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt39=1;
            }
            else if ( LA39_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt39=1;
            }
            else if ( LA39_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt39=1;
            }
            else if ( LA39_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__3();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__2"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__3"
    // InternalBug304681TestLanguage.g:4277:1: rule__Object2__UnorderedGroup_5__3 : rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )? ;
    public final void rule__Object2__UnorderedGroup_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4281:1: ( rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )? )
            // InternalBug304681TestLanguage.g:4282:2: rule__Object2__UnorderedGroup_5__Impl ( rule__Object2__UnorderedGroup_5__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4283:2: ( rule__Object2__UnorderedGroup_5__4 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( LA40_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                alt40=1;
            }
            else if ( LA40_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                alt40=1;
            }
            else if ( LA40_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                alt40=1;
            }
            else if ( LA40_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                alt40=1;
            }
            else if ( LA40_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt40=1;
            }
            else if ( LA40_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Object2__UnorderedGroup_5__4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Object2__UnorderedGroup_5__4();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__3"


    // $ANTLR start "rule__Object2__UnorderedGroup_5__4"
    // InternalBug304681TestLanguage.g:4289:1: rule__Object2__UnorderedGroup_5__4 : rule__Object2__UnorderedGroup_5__Impl ;
    public final void rule__Object2__UnorderedGroup_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4293:1: ( rule__Object2__UnorderedGroup_5__Impl )
            // InternalBug304681TestLanguage.g:4294:2: rule__Object2__UnorderedGroup_5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Object2__UnorderedGroup_5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__UnorderedGroup_5__4"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1"
    // InternalBug304681TestLanguage.g:4301:1: rule__Attribute2__UnorderedGroup_3_0_1 : ( rule__Attribute2__UnorderedGroup_3_0_1__0 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
        	
        try {
            // InternalBug304681TestLanguage.g:4306:1: ( ( rule__Attribute2__UnorderedGroup_3_0_1__0 )? )
            // InternalBug304681TestLanguage.g:4307:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )?
            {
            // InternalBug304681TestLanguage.g:4307:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( LA41_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt41=1;
            }
            else if ( LA41_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt41=1;
            }
            else if ( LA41_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt41=1;
            }
            else if ( LA41_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt41=1;
            }
            else if ( LA41_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

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

            	getUnorderedGroupHelper().leave(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__Impl"
    // InternalBug304681TestLanguage.g:4315:1: rule__Attribute2__UnorderedGroup_3_0_1__Impl : ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) ) ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4320:1: ( ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4321:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4321:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) ) )
            int alt43=5;
            int LA43_0 = input.LA(1);

            if ( LA43_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt43=1;
            }
            else if ( LA43_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt43=2;
            }
            else if ( LA43_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt43=3;
            }
            else if ( LA43_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt43=4;
            }
            else if ( LA43_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt43=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4322:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4322:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4323:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4323:110: ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4324:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4330:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
                    // InternalBug304681TestLanguage.g:4331:6: ( rule__Attribute2__Group_3_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4332:6: ( rule__Attribute2__Group_3_0_1_0__0 )
                    // InternalBug304681TestLanguage.g:4332:7: rule__Attribute2__Group_3_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4337:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4337:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4338:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4338:110: ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4339:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4345:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
                    // InternalBug304681TestLanguage.g:4346:6: ( rule__Attribute2__Group_3_0_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4347:6: ( rule__Attribute2__Group_3_0_1_1__0 )
                    // InternalBug304681TestLanguage.g:4347:7: rule__Attribute2__Group_3_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalBug304681TestLanguage.g:4352:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4352:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
                    // InternalBug304681TestLanguage.g:4353:4: {...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
                    }
                    // InternalBug304681TestLanguage.g:4353:110: ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
                    // InternalBug304681TestLanguage.g:4354:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4360:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
                    // InternalBug304681TestLanguage.g:4361:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
                    {
                    // InternalBug304681TestLanguage.g:4361:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) )
                    // InternalBug304681TestLanguage.g:4362:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }
                    // InternalBug304681TestLanguage.g:4363:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
                    // InternalBug304681TestLanguage.g:4363:8: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
                    {
                    pushFollow(FollowSets000.FOLLOW_28);
                    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }

                    }

                    // InternalBug304681TestLanguage.g:4366:6: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
                    // InternalBug304681TestLanguage.g:4367:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }
                    // InternalBug304681TestLanguage.g:4368:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
                    loop42:
                    do {
                        int alt42=2;
                        alt42 = dfa42.predict(input);
                        switch (alt42) {
                    	case 1 :
                    	    // InternalBug304681TestLanguage.g:4368:8: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
                    	    {
                    	    pushFollow(FollowSets000.FOLLOW_28);
                    	    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalBug304681TestLanguage.g:4374:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4374:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4375:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
                    }
                    // InternalBug304681TestLanguage.g:4375:110: ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
                    // InternalBug304681TestLanguage.g:4376:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4382:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
                    // InternalBug304681TestLanguage.g:4383:6: ( rule__Attribute2__Group_3_0_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 
                    }
                    // InternalBug304681TestLanguage.g:4384:6: ( rule__Attribute2__Group_3_0_1_3__0 )
                    // InternalBug304681TestLanguage.g:4384:7: rule__Attribute2__Group_3_0_1_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalBug304681TestLanguage.g:4389:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4389:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4390:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Attribute2__UnorderedGroup_3_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
                    }
                    // InternalBug304681TestLanguage.g:4390:110: ( ( ( rule__Attribute2__Group_3_0_1_4__0 ) ) )
                    // InternalBug304681TestLanguage.g:4391:5: ( ( rule__Attribute2__Group_3_0_1_4__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4397:5: ( ( rule__Attribute2__Group_3_0_1_4__0 ) )
                    // InternalBug304681TestLanguage.g:4398:6: ( rule__Attribute2__Group_3_0_1_4__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAttribute2Access().getGroup_3_0_1_4()); 
                    }
                    // InternalBug304681TestLanguage.g:4399:6: ( rule__Attribute2__Group_3_0_1_4__0 )
                    // InternalBug304681TestLanguage.g:4399:7: rule__Attribute2__Group_3_0_1_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__Group_3_0_1_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAttribute2Access().getGroup_3_0_1_4()); 
                    }

                    }


                    }


                    }


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

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__Impl"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__0"
    // InternalBug304681TestLanguage.g:4412:1: rule__Attribute2__UnorderedGroup_3_0_1__0 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4416:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )? )
            // InternalBug304681TestLanguage.g:4417:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4418:2: ( rule__Attribute2__UnorderedGroup_3_0_1__1 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( LA44_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt44=1;
            }
            else if ( LA44_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt44=1;
            }
            else if ( LA44_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt44=1;
            }
            else if ( LA44_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt44=1;
            }
            else if ( LA44_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__1();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__0"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__1"
    // InternalBug304681TestLanguage.g:4424:1: rule__Attribute2__UnorderedGroup_3_0_1__1 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4428:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )? )
            // InternalBug304681TestLanguage.g:4429:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__2 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4430:2: ( rule__Attribute2__UnorderedGroup_3_0_1__2 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( LA45_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt45=1;
            }
            else if ( LA45_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt45=1;
            }
            else if ( LA45_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt45=1;
            }
            else if ( LA45_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt45=1;
            }
            else if ( LA45_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__2
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__2();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__1"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__2"
    // InternalBug304681TestLanguage.g:4436:1: rule__Attribute2__UnorderedGroup_3_0_1__2 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4440:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )? )
            // InternalBug304681TestLanguage.g:4441:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__3 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4442:2: ( rule__Attribute2__UnorderedGroup_3_0_1__3 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( LA46_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt46=1;
            }
            else if ( LA46_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt46=1;
            }
            else if ( LA46_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt46=1;
            }
            else if ( LA46_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt46=1;
            }
            else if ( LA46_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__3
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__3();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__2"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__3"
    // InternalBug304681TestLanguage.g:4448:1: rule__Attribute2__UnorderedGroup_3_0_1__3 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )? ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4452:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )? )
            // InternalBug304681TestLanguage.g:4453:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl ( rule__Attribute2__UnorderedGroup_3_0_1__4 )?
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4454:2: ( rule__Attribute2__UnorderedGroup_3_0_1__4 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( LA47_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                alt47=1;
            }
            else if ( LA47_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                alt47=1;
            }
            else if ( LA47_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                alt47=1;
            }
            else if ( LA47_0 == 35 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                alt47=1;
            }
            else if ( LA47_0 == 36 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Attribute2__UnorderedGroup_3_0_1__4
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Attribute2__UnorderedGroup_3_0_1__4();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__3"


    // $ANTLR start "rule__Attribute2__UnorderedGroup_3_0_1__4"
    // InternalBug304681TestLanguage.g:4460:1: rule__Attribute2__UnorderedGroup_3_0_1__4 : rule__Attribute2__UnorderedGroup_3_0_1__Impl ;
    public final void rule__Attribute2__UnorderedGroup_3_0_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4464:1: ( rule__Attribute2__UnorderedGroup_3_0_1__Impl )
            // InternalBug304681TestLanguage.g:4465:2: rule__Attribute2__UnorderedGroup_3_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Attribute2__UnorderedGroup_3_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__UnorderedGroup_3_0_1__4"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1"
    // InternalBug304681TestLanguage.g:4472:1: rule__Reference2__UnorderedGroup_4_0_1 : ( rule__Reference2__UnorderedGroup_4_0_1__0 )? ;
    public final void rule__Reference2__UnorderedGroup_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
        	
        try {
            // InternalBug304681TestLanguage.g:4477:1: ( ( rule__Reference2__UnorderedGroup_4_0_1__0 )? )
            // InternalBug304681TestLanguage.g:4478:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )?
            {
            // InternalBug304681TestLanguage.g:4478:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( LA48_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                alt48=1;
            }
            else if ( LA48_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference2__UnorderedGroup_4_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__UnorderedGroup_4_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

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

            	getUnorderedGroupHelper().leave(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1__Impl"
    // InternalBug304681TestLanguage.g:4486:1: rule__Reference2__UnorderedGroup_4_0_1__Impl : ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) ) ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4491:1: ( ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4492:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4492:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( LA49_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                alt49=1;
            }
            else if ( LA49_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4493:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4493:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4494:4: {...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference2__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4494:110: ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4495:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4501:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
                    // InternalBug304681TestLanguage.g:4502:6: ( rule__Reference2__Group_4_0_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4503:6: ( rule__Reference2__Group_4_0_1_0__0 )
                    // InternalBug304681TestLanguage.g:4503:7: rule__Reference2__Group_4_0_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__Group_4_0_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4508:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4508:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4509:4: {...}? => ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__Reference2__UnorderedGroup_4_0_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4509:110: ( ( ( rule__Reference2__Group_4_0_1_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4510:5: ( ( rule__Reference2__Group_4_0_1_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4516:5: ( ( rule__Reference2__Group_4_0_1_1__0 ) )
                    // InternalBug304681TestLanguage.g:4517:6: ( rule__Reference2__Group_4_0_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getReference2Access().getGroup_4_0_1_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4518:6: ( rule__Reference2__Group_4_0_1_1__0 )
                    // InternalBug304681TestLanguage.g:4518:7: rule__Reference2__Group_4_0_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__Group_4_0_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getReference2Access().getGroup_4_0_1_1()); 
                    }

                    }


                    }


                    }


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

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1__Impl"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1__0"
    // InternalBug304681TestLanguage.g:4531:1: rule__Reference2__UnorderedGroup_4_0_1__0 : rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )? ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4535:1: ( rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )? )
            // InternalBug304681TestLanguage.g:4536:2: rule__Reference2__UnorderedGroup_4_0_1__Impl ( rule__Reference2__UnorderedGroup_4_0_1__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__Reference2__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4537:2: ( rule__Reference2__UnorderedGroup_4_0_1__1 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( LA50_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                alt50=1;
            }
            else if ( LA50_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__Reference2__UnorderedGroup_4_0_1__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Reference2__UnorderedGroup_4_0_1__1();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1__0"


    // $ANTLR start "rule__Reference2__UnorderedGroup_4_0_1__1"
    // InternalBug304681TestLanguage.g:4543:1: rule__Reference2__UnorderedGroup_4_0_1__1 : rule__Reference2__UnorderedGroup_4_0_1__Impl ;
    public final void rule__Reference2__UnorderedGroup_4_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4547:1: ( rule__Reference2__UnorderedGroup_4_0_1__Impl )
            // InternalBug304681TestLanguage.g:4548:2: rule__Reference2__UnorderedGroup_4_0_1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Reference2__UnorderedGroup_4_0_1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__UnorderedGroup_4_0_1__1"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3"
    // InternalBug304681TestLanguage.g:4555:1: rule__ConstraintDefinition__UnorderedGroup_3 : rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?;
    public final void rule__ConstraintDefinition__UnorderedGroup_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
        	
        try {
            // InternalBug304681TestLanguage.g:4560:1: ( rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?)
            // InternalBug304681TestLanguage.g:4561:2: rule__ConstraintDefinition__UnorderedGroup_3__0 {...}?
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__UnorderedGroup_3__0();

            state._fsp--;
            if (state.failed) return ;
            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3", "getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3__Impl"
    // InternalBug304681TestLanguage.g:4569:1: rule__ConstraintDefinition__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) ) ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalBug304681TestLanguage.g:4574:1: ( ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) ) )
            // InternalBug304681TestLanguage.g:4575:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) )
            {
            // InternalBug304681TestLanguage.g:4575:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( LA51_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                alt51=1;
            }
            else if ( LA51_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalBug304681TestLanguage.g:4576:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4576:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4577:4: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
                    }
                    // InternalBug304681TestLanguage.g:4577:116: ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
                    // InternalBug304681TestLanguage.g:4578:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4584:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
                    // InternalBug304681TestLanguage.g:4585:6: ( rule__ConstraintDefinition__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 
                    }
                    // InternalBug304681TestLanguage.g:4586:6: ( rule__ConstraintDefinition__Group_3_0__0 )
                    // InternalBug304681TestLanguage.g:4586:7: rule__ConstraintDefinition__Group_3_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConstraintDefinition__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBug304681TestLanguage.g:4591:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) )
                    {
                    // InternalBug304681TestLanguage.g:4591:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) ) )
                    // InternalBug304681TestLanguage.g:4592:4: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "rule__ConstraintDefinition__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
                    }
                    // InternalBug304681TestLanguage.g:4592:116: ( ( ( rule__ConstraintDefinition__Group_3_1__0 ) ) )
                    // InternalBug304681TestLanguage.g:4593:5: ( ( rule__ConstraintDefinition__Group_3_1__0 ) )
                    {
                    getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
                    selected = true;
                    // InternalBug304681TestLanguage.g:4599:5: ( ( rule__ConstraintDefinition__Group_3_1__0 ) )
                    // InternalBug304681TestLanguage.g:4600:6: ( rule__ConstraintDefinition__Group_3_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_1()); 
                    }
                    // InternalBug304681TestLanguage.g:4601:6: ( rule__ConstraintDefinition__Group_3_1__0 )
                    // InternalBug304681TestLanguage.g:4601:7: rule__ConstraintDefinition__Group_3_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConstraintDefinition__Group_3_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getConstraintDefinitionAccess().getGroup_3_1()); 
                    }

                    }


                    }


                    }


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

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3__Impl"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3__0"
    // InternalBug304681TestLanguage.g:4614:1: rule__ConstraintDefinition__UnorderedGroup_3__0 : rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )? ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4618:1: ( rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )? )
            // InternalBug304681TestLanguage.g:4619:2: rule__ConstraintDefinition__UnorderedGroup_3__Impl ( rule__ConstraintDefinition__UnorderedGroup_3__1 )?
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__ConstraintDefinition__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;
            // InternalBug304681TestLanguage.g:4620:2: ( rule__ConstraintDefinition__UnorderedGroup_3__1 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( LA52_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                alt52=1;
            }
            else if ( LA52_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBug304681TestLanguage.g:0:0: rule__ConstraintDefinition__UnorderedGroup_3__1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConstraintDefinition__UnorderedGroup_3__1();

                    state._fsp--;
                    if (state.failed) return ;

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

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3__0"


    // $ANTLR start "rule__ConstraintDefinition__UnorderedGroup_3__1"
    // InternalBug304681TestLanguage.g:4626:1: rule__ConstraintDefinition__UnorderedGroup_3__1 : rule__ConstraintDefinition__UnorderedGroup_3__Impl ;
    public final void rule__ConstraintDefinition__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4630:1: ( rule__ConstraintDefinition__UnorderedGroup_3__Impl )
            // InternalBug304681TestLanguage.g:4631:2: rule__ConstraintDefinition__UnorderedGroup_3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConstraintDefinition__UnorderedGroup_3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__UnorderedGroup_3__1"


    // $ANTLR start "rule__Model__DefinitionAssignment_0_1"
    // InternalBug304681TestLanguage.g:4638:1: rule__Model__DefinitionAssignment_0_1 : ( rulePackageDefinition ) ;
    public final void rule__Model__DefinitionAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4642:1: ( ( rulePackageDefinition ) )
            // InternalBug304681TestLanguage.g:4643:2: ( rulePackageDefinition )
            {
            // InternalBug304681TestLanguage.g:4643:2: ( rulePackageDefinition )
            // InternalBug304681TestLanguage.g:4644:3: rulePackageDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            rulePackageDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DefinitionAssignment_0_1"


    // $ANTLR start "rule__Model__DefinitionAssignment_1_1"
    // InternalBug304681TestLanguage.g:4653:1: rule__Model__DefinitionAssignment_1_1 : ( rulePackageDefinition2 ) ;
    public final void rule__Model__DefinitionAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4657:1: ( ( rulePackageDefinition2 ) )
            // InternalBug304681TestLanguage.g:4658:2: ( rulePackageDefinition2 )
            {
            // InternalBug304681TestLanguage.g:4658:2: ( rulePackageDefinition2 )
            // InternalBug304681TestLanguage.g:4659:3: rulePackageDefinition2
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            rulePackageDefinition2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DefinitionAssignment_1_1"


    // $ANTLR start "rule__PackageDefinition__NamespaceAssignment_2"
    // InternalBug304681TestLanguage.g:4668:1: rule__PackageDefinition__NamespaceAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageDefinition__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4672:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4673:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4673:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4674:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__NamespaceAssignment_2"


    // $ANTLR start "rule__PackageDefinition__ContentsAssignment_4"
    // InternalBug304681TestLanguage.g:4683:1: rule__PackageDefinition__ContentsAssignment_4 : ( ruleObject ) ;
    public final void rule__PackageDefinition__ContentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4687:1: ( ( ruleObject ) )
            // InternalBug304681TestLanguage.g:4688:2: ( ruleObject )
            {
            // InternalBug304681TestLanguage.g:4688:2: ( ruleObject )
            // InternalBug304681TestLanguage.g:4689:3: ruleObject
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleObject();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__ContentsAssignment_4"


    // $ANTLR start "rule__Object__EnabledAssignment_0_0"
    // InternalBug304681TestLanguage.g:4698:1: rule__Object__EnabledAssignment_0_0 : ( ( 'enabled' ) ) ;
    public final void rule__Object__EnabledAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4702:1: ( ( ( 'enabled' ) ) )
            // InternalBug304681TestLanguage.g:4703:2: ( ( 'enabled' ) )
            {
            // InternalBug304681TestLanguage.g:4703:2: ( ( 'enabled' ) )
            // InternalBug304681TestLanguage.g:4704:3: ( 'enabled' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            }
            // InternalBug304681TestLanguage.g:4705:3: ( 'enabled' )
            // InternalBug304681TestLanguage.g:4706:4: 'enabled'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__EnabledAssignment_0_0"


    // $ANTLR start "rule__Object__AbstractAssignment_0_1"
    // InternalBug304681TestLanguage.g:4717:1: rule__Object__AbstractAssignment_0_1 : ( ( 'abstract' ) ) ;
    public final void rule__Object__AbstractAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4721:1: ( ( ( 'abstract' ) ) )
            // InternalBug304681TestLanguage.g:4722:2: ( ( 'abstract' ) )
            {
            // InternalBug304681TestLanguage.g:4722:2: ( ( 'abstract' ) )
            // InternalBug304681TestLanguage.g:4723:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            }
            // InternalBug304681TestLanguage.g:4724:3: ( 'abstract' )
            // InternalBug304681TestLanguage.g:4725:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__AbstractAssignment_0_1"


    // $ANTLR start "rule__Object__NameAssignment_2"
    // InternalBug304681TestLanguage.g:4736:1: rule__Object__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Object__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4740:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4741:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4741:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4742:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__NameAssignment_2"


    // $ANTLR start "rule__Object__ParentAssignment_3_1"
    // InternalBug304681TestLanguage.g:4751:1: rule__Object__ParentAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Object__ParentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4755:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:4756:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:4756:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4757:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 
            }
            // InternalBug304681TestLanguage.g:4758:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4759:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__ParentAssignment_3_1"


    // $ANTLR start "rule__Object__ShortDescriptionAssignment_5_0_1"
    // InternalBug304681TestLanguage.g:4770:1: rule__Object__ShortDescriptionAssignment_5_0_1 : ( RULE_STRING ) ;
    public final void rule__Object__ShortDescriptionAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4774:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:4775:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:4775:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:4776:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__ShortDescriptionAssignment_5_0_1"


    // $ANTLR start "rule__Object__LongDescriptionAssignment_5_1_1"
    // InternalBug304681TestLanguage.g:4785:1: rule__Object__LongDescriptionAssignment_5_1_1 : ( RULE_STRING ) ;
    public final void rule__Object__LongDescriptionAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4789:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:4790:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:4790:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:4791:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__LongDescriptionAssignment_5_1_1"


    // $ANTLR start "rule__Object__SerialVersionUIDAssignment_5_2_1"
    // InternalBug304681TestLanguage.g:4800:1: rule__Object__SerialVersionUIDAssignment_5_2_1 : ( RULE_INT ) ;
    public final void rule__Object__SerialVersionUIDAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4804:1: ( ( RULE_INT ) )
            // InternalBug304681TestLanguage.g:4805:2: ( RULE_INT )
            {
            // InternalBug304681TestLanguage.g:4805:2: ( RULE_INT )
            // InternalBug304681TestLanguage.g:4806:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__SerialVersionUIDAssignment_5_2_1"


    // $ANTLR start "rule__Object__CloneableAssignment_5_3_0"
    // InternalBug304681TestLanguage.g:4815:1: rule__Object__CloneableAssignment_5_3_0 : ( ( 'cloneable' ) ) ;
    public final void rule__Object__CloneableAssignment_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4819:1: ( ( ( 'cloneable' ) ) )
            // InternalBug304681TestLanguage.g:4820:2: ( ( 'cloneable' ) )
            {
            // InternalBug304681TestLanguage.g:4820:2: ( ( 'cloneable' ) )
            // InternalBug304681TestLanguage.g:4821:3: ( 'cloneable' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            // InternalBug304681TestLanguage.g:4822:3: ( 'cloneable' )
            // InternalBug304681TestLanguage.g:4823:4: 'cloneable'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__CloneableAssignment_5_3_0"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_4"
    // InternalBug304681TestLanguage.g:4834:1: rule__Object__FeaturesAssignment_5_4 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4838:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4839:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4839:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4840:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__FeaturesAssignment_5_4"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_5_1"
    // InternalBug304681TestLanguage.g:4849:1: rule__Object__FeaturesAssignment_5_5_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4853:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4854:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4854:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4855:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__FeaturesAssignment_5_5_1"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_6_1"
    // InternalBug304681TestLanguage.g:4864:1: rule__Object__FeaturesAssignment_5_6_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4868:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4869:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4869:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4870:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__FeaturesAssignment_5_6_1"


    // $ANTLR start "rule__Object__FeaturesAssignment_5_7_1"
    // InternalBug304681TestLanguage.g:4879:1: rule__Object__FeaturesAssignment_5_7_1 : ( ruleFeature ) ;
    public final void rule__Object__FeaturesAssignment_5_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4883:1: ( ( ruleFeature ) )
            // InternalBug304681TestLanguage.g:4884:2: ( ruleFeature )
            {
            // InternalBug304681TestLanguage.g:4884:2: ( ruleFeature )
            // InternalBug304681TestLanguage.g:4885:3: ruleFeature
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object__FeaturesAssignment_5_7_1"


    // $ANTLR start "rule__Attribute__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:4894:1: rule__Attribute__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4898:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4899:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4899:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4900:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__TypeAssignment_1"


    // $ANTLR start "rule__Attribute__NameAssignment_2"
    // InternalBug304681TestLanguage.g:4909:1: rule__Attribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4913:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4914:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4914:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4915:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_2"


    // $ANTLR start "rule__Reference__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:4924:1: rule__Reference__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4928:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:4929:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:4929:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4930:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 
            }
            // InternalBug304681TestLanguage.g:4931:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4932:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__TypeAssignment_1"


    // $ANTLR start "rule__Reference__ManyAssignment_2"
    // InternalBug304681TestLanguage.g:4943:1: rule__Reference__ManyAssignment_2 : ( ( '*' ) ) ;
    public final void rule__Reference__ManyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4947:1: ( ( ( '*' ) ) )
            // InternalBug304681TestLanguage.g:4948:2: ( ( '*' ) )
            {
            // InternalBug304681TestLanguage.g:4948:2: ( ( '*' ) )
            // InternalBug304681TestLanguage.g:4949:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            }
            // InternalBug304681TestLanguage.g:4950:3: ( '*' )
            // InternalBug304681TestLanguage.g:4951:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__ManyAssignment_2"


    // $ANTLR start "rule__Reference__NameAssignment_3"
    // InternalBug304681TestLanguage.g:4962:1: rule__Reference__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4966:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:4967:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:4967:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:4968:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__NameAssignment_3"


    // $ANTLR start "rule__Reference__ShortDescriptionAssignment_4_0_1_0_1"
    // InternalBug304681TestLanguage.g:4977:1: rule__Reference__ShortDescriptionAssignment_4_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Reference__ShortDescriptionAssignment_4_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4981:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:4982:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:4982:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:4983:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__ShortDescriptionAssignment_4_0_1_0_1"


    // $ANTLR start "rule__Reference__LongDescriptionAssignment_4_0_1_1_1"
    // InternalBug304681TestLanguage.g:4992:1: rule__Reference__LongDescriptionAssignment_4_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Reference__LongDescriptionAssignment_4_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:4996:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:4997:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:4997:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:4998:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__LongDescriptionAssignment_4_0_1_1_1"


    // $ANTLR start "rule__PackageDefinition2__NamespaceAssignment_2"
    // InternalBug304681TestLanguage.g:5007:1: rule__PackageDefinition2__NamespaceAssignment_2 : ( RULE_ID ) ;
    public final void rule__PackageDefinition2__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5011:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5012:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5012:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5013:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__NamespaceAssignment_2"


    // $ANTLR start "rule__PackageDefinition2__ContentsAssignment_4"
    // InternalBug304681TestLanguage.g:5022:1: rule__PackageDefinition2__ContentsAssignment_4 : ( ruleObject2 ) ;
    public final void rule__PackageDefinition2__ContentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5026:1: ( ( ruleObject2 ) )
            // InternalBug304681TestLanguage.g:5027:2: ( ruleObject2 )
            {
            // InternalBug304681TestLanguage.g:5027:2: ( ruleObject2 )
            // InternalBug304681TestLanguage.g:5028:3: ruleObject2
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleObject2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition2__ContentsAssignment_4"


    // $ANTLR start "rule__Object2__EnabledAssignment_0_0"
    // InternalBug304681TestLanguage.g:5037:1: rule__Object2__EnabledAssignment_0_0 : ( ( 'enabled' ) ) ;
    public final void rule__Object2__EnabledAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5041:1: ( ( ( 'enabled' ) ) )
            // InternalBug304681TestLanguage.g:5042:2: ( ( 'enabled' ) )
            {
            // InternalBug304681TestLanguage.g:5042:2: ( ( 'enabled' ) )
            // InternalBug304681TestLanguage.g:5043:3: ( 'enabled' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5044:3: ( 'enabled' )
            // InternalBug304681TestLanguage.g:5045:4: 'enabled'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            }
            match(input,31,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__EnabledAssignment_0_0"


    // $ANTLR start "rule__Object2__AbstractAssignment_0_1"
    // InternalBug304681TestLanguage.g:5056:1: rule__Object2__AbstractAssignment_0_1 : ( ( 'abstract' ) ) ;
    public final void rule__Object2__AbstractAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5060:1: ( ( ( 'abstract' ) ) )
            // InternalBug304681TestLanguage.g:5061:2: ( ( 'abstract' ) )
            {
            // InternalBug304681TestLanguage.g:5061:2: ( ( 'abstract' ) )
            // InternalBug304681TestLanguage.g:5062:3: ( 'abstract' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            }
            // InternalBug304681TestLanguage.g:5063:3: ( 'abstract' )
            // InternalBug304681TestLanguage.g:5064:4: 'abstract'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            }
            match(input,32,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__AbstractAssignment_0_1"


    // $ANTLR start "rule__Object2__NameAssignment_2"
    // InternalBug304681TestLanguage.g:5075:1: rule__Object2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Object2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5079:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5080:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5080:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5081:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__NameAssignment_2"


    // $ANTLR start "rule__Object2__ParentAssignment_3_1"
    // InternalBug304681TestLanguage.g:5090:1: rule__Object2__ParentAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Object2__ParentAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5094:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:5095:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:5095:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5096:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0()); 
            }
            // InternalBug304681TestLanguage.g:5097:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5098:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getParentObjectIDTerminalRuleCall_3_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__ParentAssignment_3_1"


    // $ANTLR start "rule__Object2__ShortDescriptionAssignment_5_0_1"
    // InternalBug304681TestLanguage.g:5109:1: rule__Object2__ShortDescriptionAssignment_5_0_1 : ( RULE_STRING ) ;
    public final void rule__Object2__ShortDescriptionAssignment_5_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5113:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5114:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5114:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5115:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__ShortDescriptionAssignment_5_0_1"


    // $ANTLR start "rule__Object2__LongDescriptionAssignment_5_1_1"
    // InternalBug304681TestLanguage.g:5124:1: rule__Object2__LongDescriptionAssignment_5_1_1 : ( RULE_STRING ) ;
    public final void rule__Object2__LongDescriptionAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5128:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5129:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5129:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5130:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__LongDescriptionAssignment_5_1_1"


    // $ANTLR start "rule__Object2__SerialVersionUIDAssignment_5_2_1"
    // InternalBug304681TestLanguage.g:5139:1: rule__Object2__SerialVersionUIDAssignment_5_2_1 : ( RULE_INT ) ;
    public final void rule__Object2__SerialVersionUIDAssignment_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5143:1: ( ( RULE_INT ) )
            // InternalBug304681TestLanguage.g:5144:2: ( RULE_INT )
            {
            // InternalBug304681TestLanguage.g:5144:2: ( RULE_INT )
            // InternalBug304681TestLanguage.g:5145:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__SerialVersionUIDAssignment_5_2_1"


    // $ANTLR start "rule__Object2__CloneableAssignment_5_3_0"
    // InternalBug304681TestLanguage.g:5154:1: rule__Object2__CloneableAssignment_5_3_0 : ( ( 'cloneable' ) ) ;
    public final void rule__Object2__CloneableAssignment_5_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5158:1: ( ( ( 'cloneable' ) ) )
            // InternalBug304681TestLanguage.g:5159:2: ( ( 'cloneable' ) )
            {
            // InternalBug304681TestLanguage.g:5159:2: ( ( 'cloneable' ) )
            // InternalBug304681TestLanguage.g:5160:3: ( 'cloneable' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5161:3: ( 'cloneable' )
            // InternalBug304681TestLanguage.g:5162:4: 'cloneable'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            }
            match(input,33,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__CloneableAssignment_5_3_0"


    // $ANTLR start "rule__Object2__FeaturesAssignment_5_4"
    // InternalBug304681TestLanguage.g:5173:1: rule__Object2__FeaturesAssignment_5_4 : ( ruleFeature2 ) ;
    public final void rule__Object2__FeaturesAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5177:1: ( ( ruleFeature2 ) )
            // InternalBug304681TestLanguage.g:5178:2: ( ruleFeature2 )
            {
            // InternalBug304681TestLanguage.g:5178:2: ( ruleFeature2 )
            // InternalBug304681TestLanguage.g:5179:3: ruleFeature2
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFeature2();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Object2__FeaturesAssignment_5_4"


    // $ANTLR start "rule__Attribute2__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:5188:1: rule__Attribute2__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__Attribute2__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5192:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5193:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5193:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5194:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__TypeAssignment_1"


    // $ANTLR start "rule__Attribute2__NameAssignment_2"
    // InternalBug304681TestLanguage.g:5203:1: rule__Attribute2__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Attribute2__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5207:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5208:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5208:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5209:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__NameAssignment_2"


    // $ANTLR start "rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1"
    // InternalBug304681TestLanguage.g:5218:1: rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5222:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5223:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5223:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5224:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__ShortDescriptionAssignment_3_0_1_0_1"


    // $ANTLR start "rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1"
    // InternalBug304681TestLanguage.g:5233:1: rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5237:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5238:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5238:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5239:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__LongDescriptionAssignment_3_0_1_1_1"


    // $ANTLR start "rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2"
    // InternalBug304681TestLanguage.g:5248:1: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 : ( ruleConstraintDefinition ) ;
    public final void rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5252:1: ( ( ruleConstraintDefinition ) )
            // InternalBug304681TestLanguage.g:5253:2: ( ruleConstraintDefinition )
            {
            // InternalBug304681TestLanguage.g:5253:2: ( ruleConstraintDefinition )
            // InternalBug304681TestLanguage.g:5254:3: ruleConstraintDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConstraintDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2"


    // $ANTLR start "rule__Attribute2__RequiredAssignment_3_0_1_3_0"
    // InternalBug304681TestLanguage.g:5263:1: rule__Attribute2__RequiredAssignment_3_0_1_3_0 : ( ( 'required' ) ) ;
    public final void rule__Attribute2__RequiredAssignment_3_0_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5267:1: ( ( ( 'required' ) ) )
            // InternalBug304681TestLanguage.g:5268:2: ( ( 'required' ) )
            {
            // InternalBug304681TestLanguage.g:5268:2: ( ( 'required' ) )
            // InternalBug304681TestLanguage.g:5269:3: ( 'required' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5270:3: ( 'required' )
            // InternalBug304681TestLanguage.g:5271:4: 'required'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            }
            match(input,35,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__RequiredAssignment_3_0_1_3_0"


    // $ANTLR start "rule__Attribute2__TechnicalAssignment_3_0_1_4_0"
    // InternalBug304681TestLanguage.g:5282:1: rule__Attribute2__TechnicalAssignment_3_0_1_4_0 : ( ( 'technical' ) ) ;
    public final void rule__Attribute2__TechnicalAssignment_3_0_1_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5286:1: ( ( ( 'technical' ) ) )
            // InternalBug304681TestLanguage.g:5287:2: ( ( 'technical' ) )
            {
            // InternalBug304681TestLanguage.g:5287:2: ( ( 'technical' ) )
            // InternalBug304681TestLanguage.g:5288:3: ( 'technical' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            }
            // InternalBug304681TestLanguage.g:5289:3: ( 'technical' )
            // InternalBug304681TestLanguage.g:5290:4: 'technical'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            }
            match(input,36,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute2__TechnicalAssignment_3_0_1_4_0"


    // $ANTLR start "rule__Reference2__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:5301:1: rule__Reference2__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference2__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5305:1: ( ( ( RULE_ID ) ) )
            // InternalBug304681TestLanguage.g:5306:2: ( ( RULE_ID ) )
            {
            // InternalBug304681TestLanguage.g:5306:2: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5307:3: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0()); 
            }
            // InternalBug304681TestLanguage.g:5308:3: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5309:4: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getTypeObjectIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__TypeAssignment_1"


    // $ANTLR start "rule__Reference2__ManyAssignment_2"
    // InternalBug304681TestLanguage.g:5320:1: rule__Reference2__ManyAssignment_2 : ( ( '*' ) ) ;
    public final void rule__Reference2__ManyAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5324:1: ( ( ( '*' ) ) )
            // InternalBug304681TestLanguage.g:5325:2: ( ( '*' ) )
            {
            // InternalBug304681TestLanguage.g:5325:2: ( ( '*' ) )
            // InternalBug304681TestLanguage.g:5326:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            }
            // InternalBug304681TestLanguage.g:5327:3: ( '*' )
            // InternalBug304681TestLanguage.g:5328:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__ManyAssignment_2"


    // $ANTLR start "rule__Reference2__NameAssignment_3"
    // InternalBug304681TestLanguage.g:5339:1: rule__Reference2__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Reference2__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5343:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5344:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5344:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5345:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__NameAssignment_3"


    // $ANTLR start "rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1"
    // InternalBug304681TestLanguage.g:5354:1: rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5358:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5359:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5359:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5360:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__ShortDescriptionAssignment_4_0_1_0_1"


    // $ANTLR start "rule__Reference2__LongDescriptionAssignment_4_0_1_1_1"
    // InternalBug304681TestLanguage.g:5369:1: rule__Reference2__LongDescriptionAssignment_4_0_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Reference2__LongDescriptionAssignment_4_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5373:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5374:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5374:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5375:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference2__LongDescriptionAssignment_4_0_1_1_1"


    // $ANTLR start "rule__ConstraintDefinition__TypeAssignment_1"
    // InternalBug304681TestLanguage.g:5384:1: rule__ConstraintDefinition__TypeAssignment_1 : ( RULE_ID ) ;
    public final void rule__ConstraintDefinition__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5388:1: ( ( RULE_ID ) )
            // InternalBug304681TestLanguage.g:5389:2: ( RULE_ID )
            {
            // InternalBug304681TestLanguage.g:5389:2: ( RULE_ID )
            // InternalBug304681TestLanguage.g:5390:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__TypeAssignment_1"


    // $ANTLR start "rule__ConstraintDefinition__ParametersAssignment_3_0_1"
    // InternalBug304681TestLanguage.g:5399:1: rule__ConstraintDefinition__ParametersAssignment_3_0_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintDefinition__ParametersAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5403:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5404:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5404:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5405:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__ParametersAssignment_3_0_1"


    // $ANTLR start "rule__ConstraintDefinition__MessageAssignment_3_1_1"
    // InternalBug304681TestLanguage.g:5414:1: rule__ConstraintDefinition__MessageAssignment_3_1_1 : ( RULE_STRING ) ;
    public final void rule__ConstraintDefinition__MessageAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBug304681TestLanguage.g:5418:1: ( ( RULE_STRING ) )
            // InternalBug304681TestLanguage.g:5419:2: ( RULE_STRING )
            {
            // InternalBug304681TestLanguage.g:5419:2: ( RULE_STRING )
            // InternalBug304681TestLanguage.g:5420:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0()); 
            }
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintDefinition__MessageAssignment_3_1_1"

    // $ANTLR start synpred13_InternalBug304681TestLanguage
    public final void synpred13_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:1430:3: ( rule__Object__FeaturesAssignment_5_6_1 )
        // InternalBug304681TestLanguage.g:1430:3: rule__Object__FeaturesAssignment_5_6_1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__FeaturesAssignment_5_6_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalBug304681TestLanguage

    // $ANTLR start synpred14_InternalBug304681TestLanguage
    public final void synpred14_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:1490:4: ( rule__Object__FeaturesAssignment_5_7_1 )
        // InternalBug304681TestLanguage.g:1490:4: rule__Object__FeaturesAssignment_5_7_1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__FeaturesAssignment_5_7_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalBug304681TestLanguage

    // $ANTLR start synpred21_InternalBug304681TestLanguage
    public final void synpred21_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3801:2: ( rule__Object__UnorderedGroup_5__0 )
        // InternalBug304681TestLanguage.g:3801:2: rule__Object__UnorderedGroup_5__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalBug304681TestLanguage

    // $ANTLR start synpred22_InternalBug304681TestLanguage
    public final void synpred22_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3816:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3816:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3816:3: ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3817:4: {...}? => ( ( ( rule__Object__Group_5_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
        }
        // InternalBug304681TestLanguage.g:3817:102: ( ( ( rule__Object__Group_5_0__0 ) ) )
        // InternalBug304681TestLanguage.g:3818:5: ( ( rule__Object__Group_5_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
        // InternalBug304681TestLanguage.g:3824:5: ( ( rule__Object__Group_5_0__0 ) )
        // InternalBug304681TestLanguage.g:3825:6: ( rule__Object__Group_5_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_0()); 
        }
        // InternalBug304681TestLanguage.g:3826:6: ( rule__Object__Group_5_0__0 )
        // InternalBug304681TestLanguage.g:3826:7: rule__Object__Group_5_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred22_InternalBug304681TestLanguage

    // $ANTLR start synpred23_InternalBug304681TestLanguage
    public final void synpred23_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3831:3: ( ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3831:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3831:3: ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3832:4: {...}? => ( ( ( rule__Object__Group_5_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred23_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
        }
        // InternalBug304681TestLanguage.g:3832:102: ( ( ( rule__Object__Group_5_1__0 ) ) )
        // InternalBug304681TestLanguage.g:3833:5: ( ( rule__Object__Group_5_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
        // InternalBug304681TestLanguage.g:3839:5: ( ( rule__Object__Group_5_1__0 ) )
        // InternalBug304681TestLanguage.g:3840:6: ( rule__Object__Group_5_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_1()); 
        }
        // InternalBug304681TestLanguage.g:3841:6: ( rule__Object__Group_5_1__0 )
        // InternalBug304681TestLanguage.g:3841:7: rule__Object__Group_5_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred23_InternalBug304681TestLanguage

    // $ANTLR start synpred24_InternalBug304681TestLanguage
    public final void synpred24_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3846:3: ( ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3846:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3846:3: ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3847:4: {...}? => ( ( ( rule__Object__Group_5_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred24_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
        }
        // InternalBug304681TestLanguage.g:3847:102: ( ( ( rule__Object__Group_5_2__0 ) ) )
        // InternalBug304681TestLanguage.g:3848:5: ( ( rule__Object__Group_5_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
        // InternalBug304681TestLanguage.g:3854:5: ( ( rule__Object__Group_5_2__0 ) )
        // InternalBug304681TestLanguage.g:3855:6: ( rule__Object__Group_5_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_2()); 
        }
        // InternalBug304681TestLanguage.g:3856:6: ( rule__Object__Group_5_2__0 )
        // InternalBug304681TestLanguage.g:3856:7: rule__Object__Group_5_2__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred24_InternalBug304681TestLanguage

    // $ANTLR start synpred25_InternalBug304681TestLanguage
    public final void synpred25_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3861:3: ( ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3861:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3861:3: ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3862:4: {...}? => ( ( ( rule__Object__Group_5_3__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred25_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
        }
        // InternalBug304681TestLanguage.g:3862:102: ( ( ( rule__Object__Group_5_3__0 ) ) )
        // InternalBug304681TestLanguage.g:3863:5: ( ( rule__Object__Group_5_3__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
        // InternalBug304681TestLanguage.g:3869:5: ( ( rule__Object__Group_5_3__0 ) )
        // InternalBug304681TestLanguage.g:3870:6: ( rule__Object__Group_5_3__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_3()); 
        }
        // InternalBug304681TestLanguage.g:3871:6: ( rule__Object__Group_5_3__0 )
        // InternalBug304681TestLanguage.g:3871:7: rule__Object__Group_5_3__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_3__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalBug304681TestLanguage

    // $ANTLR start synpred26_InternalBug304681TestLanguage
    public final void synpred26_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3892:8: ( rule__Object__FeaturesAssignment_5_4 )
        // InternalBug304681TestLanguage.g:3892:9: rule__Object__FeaturesAssignment_5_4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__FeaturesAssignment_5_4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalBug304681TestLanguage

    // $ANTLR start synpred27_InternalBug304681TestLanguage
    public final void synpred27_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3876:3: ( ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) )
        // InternalBug304681TestLanguage.g:3876:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3876:3: ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) )
        // InternalBug304681TestLanguage.g:3877:4: {...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
        }
        // InternalBug304681TestLanguage.g:3877:102: ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) )
        // InternalBug304681TestLanguage.g:3878:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
        // InternalBug304681TestLanguage.g:3884:5: ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) )
        // InternalBug304681TestLanguage.g:3885:6: ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
        {
        // InternalBug304681TestLanguage.g:3885:6: ( ( rule__Object__FeaturesAssignment_5_4 ) )
        // InternalBug304681TestLanguage.g:3886:7: ( rule__Object__FeaturesAssignment_5_4 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
        }
        // InternalBug304681TestLanguage.g:3887:7: ( rule__Object__FeaturesAssignment_5_4 )
        // InternalBug304681TestLanguage.g:3887:8: rule__Object__FeaturesAssignment_5_4
        {
        pushFollow(FollowSets000.FOLLOW_14);
        rule__Object__FeaturesAssignment_5_4();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBug304681TestLanguage.g:3890:6: ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* )
        // InternalBug304681TestLanguage.g:3891:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getFeaturesAssignment_5_4()); 
        }
        // InternalBug304681TestLanguage.g:3892:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*
        loop53:
        do {
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==26) && (synpred26_InternalBug304681TestLanguage())) {
                alt53=1;
            }
            else if ( (LA53_0==27) && (synpred26_InternalBug304681TestLanguage())) {
                alt53=1;
            }


            switch (alt53) {
        	case 1 :
        	    // InternalBug304681TestLanguage.g:3892:8: ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4
        	    {
        	    pushFollow(FollowSets000.FOLLOW_14);
        	    rule__Object__FeaturesAssignment_5_4();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop53;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred27_InternalBug304681TestLanguage

    // $ANTLR start synpred28_InternalBug304681TestLanguage
    public final void synpred28_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3898:3: ( ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3898:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3898:3: ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3899:4: {...}? => ( ( ( rule__Object__Group_5_5__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
        }
        // InternalBug304681TestLanguage.g:3899:102: ( ( ( rule__Object__Group_5_5__0 ) ) )
        // InternalBug304681TestLanguage.g:3900:5: ( ( rule__Object__Group_5_5__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
        // InternalBug304681TestLanguage.g:3906:5: ( ( rule__Object__Group_5_5__0 ) )
        // InternalBug304681TestLanguage.g:3907:6: ( rule__Object__Group_5_5__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_5()); 
        }
        // InternalBug304681TestLanguage.g:3908:6: ( rule__Object__Group_5_5__0 )
        // InternalBug304681TestLanguage.g:3908:7: rule__Object__Group_5_5__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_5__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred28_InternalBug304681TestLanguage

    // $ANTLR start synpred29_InternalBug304681TestLanguage
    public final void synpred29_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3913:3: ( ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:3913:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:3913:3: ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) )
        // InternalBug304681TestLanguage.g:3914:4: {...}? => ( ( ( rule__Object__Group_5_6__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
        }
        // InternalBug304681TestLanguage.g:3914:102: ( ( ( rule__Object__Group_5_6__0 ) ) )
        // InternalBug304681TestLanguage.g:3915:5: ( ( rule__Object__Group_5_6__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
        // InternalBug304681TestLanguage.g:3921:5: ( ( rule__Object__Group_5_6__0 ) )
        // InternalBug304681TestLanguage.g:3922:6: ( rule__Object__Group_5_6__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectAccess().getGroup_5_6()); 
        }
        // InternalBug304681TestLanguage.g:3923:6: ( rule__Object__Group_5_6__0 )
        // InternalBug304681TestLanguage.g:3923:7: rule__Object__Group_5_6__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__Group_5_6__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred29_InternalBug304681TestLanguage

    // $ANTLR start synpred30_InternalBug304681TestLanguage
    public final void synpred30_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3957:2: ( rule__Object__UnorderedGroup_5__1 )
        // InternalBug304681TestLanguage.g:3957:2: rule__Object__UnorderedGroup_5__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalBug304681TestLanguage

    // $ANTLR start synpred31_InternalBug304681TestLanguage
    public final void synpred31_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3969:2: ( rule__Object__UnorderedGroup_5__2 )
        // InternalBug304681TestLanguage.g:3969:2: rule__Object__UnorderedGroup_5__2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalBug304681TestLanguage

    // $ANTLR start synpred32_InternalBug304681TestLanguage
    public final void synpred32_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3981:2: ( rule__Object__UnorderedGroup_5__3 )
        // InternalBug304681TestLanguage.g:3981:2: rule__Object__UnorderedGroup_5__3
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalBug304681TestLanguage

    // $ANTLR start synpred33_InternalBug304681TestLanguage
    public final void synpred33_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:3993:2: ( rule__Object__UnorderedGroup_5__4 )
        // InternalBug304681TestLanguage.g:3993:2: rule__Object__UnorderedGroup_5__4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalBug304681TestLanguage

    // $ANTLR start synpred34_InternalBug304681TestLanguage
    public final void synpred34_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4005:2: ( rule__Object__UnorderedGroup_5__5 )
        // InternalBug304681TestLanguage.g:4005:2: rule__Object__UnorderedGroup_5__5
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__5();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalBug304681TestLanguage

    // $ANTLR start synpred35_InternalBug304681TestLanguage
    public final void synpred35_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4017:2: ( rule__Object__UnorderedGroup_5__6 )
        // InternalBug304681TestLanguage.g:4017:2: rule__Object__UnorderedGroup_5__6
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__6();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalBug304681TestLanguage

    // $ANTLR start synpred36_InternalBug304681TestLanguage
    public final void synpred36_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4029:2: ( rule__Object__UnorderedGroup_5__7 )
        // InternalBug304681TestLanguage.g:4029:2: rule__Object__UnorderedGroup_5__7
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object__UnorderedGroup_5__7();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalBug304681TestLanguage

    // $ANTLR start synpred37_InternalBug304681TestLanguage
    public final void synpred37_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4053:2: ( rule__Reference__UnorderedGroup_4_0_1__0 )
        // InternalBug304681TestLanguage.g:4053:2: rule__Reference__UnorderedGroup_4_0_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference__UnorderedGroup_4_0_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalBug304681TestLanguage

    // $ANTLR start synpred38_InternalBug304681TestLanguage
    public final void synpred38_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4068:3: ( ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4068:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4068:3: ({...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4069:4: {...}? => ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred38_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
        }
        // InternalBug304681TestLanguage.g:4069:109: ( ( ( rule__Reference__Group_4_0_1_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4070:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
        // InternalBug304681TestLanguage.g:4076:5: ( ( rule__Reference__Group_4_0_1_0__0 ) )
        // InternalBug304681TestLanguage.g:4077:6: ( rule__Reference__Group_4_0_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getReferenceAccess().getGroup_4_0_1_0()); 
        }
        // InternalBug304681TestLanguage.g:4078:6: ( rule__Reference__Group_4_0_1_0__0 )
        // InternalBug304681TestLanguage.g:4078:7: rule__Reference__Group_4_0_1_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference__Group_4_0_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred38_InternalBug304681TestLanguage

    // $ANTLR start synpred39_InternalBug304681TestLanguage
    public final void synpred39_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4112:2: ( rule__Reference__UnorderedGroup_4_0_1__1 )
        // InternalBug304681TestLanguage.g:4112:2: rule__Reference__UnorderedGroup_4_0_1__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference__UnorderedGroup_4_0_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalBug304681TestLanguage

    // $ANTLR start synpred40_InternalBug304681TestLanguage
    public final void synpred40_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4136:2: ( rule__Object2__UnorderedGroup_5__0 )
        // InternalBug304681TestLanguage.g:4136:2: rule__Object2__UnorderedGroup_5__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalBug304681TestLanguage

    // $ANTLR start synpred41_InternalBug304681TestLanguage
    public final void synpred41_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4151:3: ( ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4151:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4151:3: ({...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4152:4: {...}? => ( ( ( rule__Object2__Group_5_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred41_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
        }
        // InternalBug304681TestLanguage.g:4152:103: ( ( ( rule__Object2__Group_5_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4153:5: ( ( rule__Object2__Group_5_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
        // InternalBug304681TestLanguage.g:4159:5: ( ( rule__Object2__Group_5_0__0 ) )
        // InternalBug304681TestLanguage.g:4160:6: ( rule__Object2__Group_5_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_0()); 
        }
        // InternalBug304681TestLanguage.g:4161:6: ( rule__Object2__Group_5_0__0 )
        // InternalBug304681TestLanguage.g:4161:7: rule__Object2__Group_5_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred41_InternalBug304681TestLanguage

    // $ANTLR start synpred42_InternalBug304681TestLanguage
    public final void synpred42_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4166:3: ( ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4166:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4166:3: ({...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4167:4: {...}? => ( ( ( rule__Object2__Group_5_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred42_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
        }
        // InternalBug304681TestLanguage.g:4167:103: ( ( ( rule__Object2__Group_5_1__0 ) ) )
        // InternalBug304681TestLanguage.g:4168:5: ( ( rule__Object2__Group_5_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
        // InternalBug304681TestLanguage.g:4174:5: ( ( rule__Object2__Group_5_1__0 ) )
        // InternalBug304681TestLanguage.g:4175:6: ( rule__Object2__Group_5_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_1()); 
        }
        // InternalBug304681TestLanguage.g:4176:6: ( rule__Object2__Group_5_1__0 )
        // InternalBug304681TestLanguage.g:4176:7: rule__Object2__Group_5_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred42_InternalBug304681TestLanguage

    // $ANTLR start synpred43_InternalBug304681TestLanguage
    public final void synpred43_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4181:3: ( ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4181:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4181:3: ({...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4182:4: {...}? => ( ( ( rule__Object2__Group_5_2__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred43_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
        }
        // InternalBug304681TestLanguage.g:4182:103: ( ( ( rule__Object2__Group_5_2__0 ) ) )
        // InternalBug304681TestLanguage.g:4183:5: ( ( rule__Object2__Group_5_2__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
        // InternalBug304681TestLanguage.g:4189:5: ( ( rule__Object2__Group_5_2__0 ) )
        // InternalBug304681TestLanguage.g:4190:6: ( rule__Object2__Group_5_2__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_2()); 
        }
        // InternalBug304681TestLanguage.g:4191:6: ( rule__Object2__Group_5_2__0 )
        // InternalBug304681TestLanguage.g:4191:7: rule__Object2__Group_5_2__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_2__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred43_InternalBug304681TestLanguage

    // $ANTLR start synpred44_InternalBug304681TestLanguage
    public final void synpred44_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4196:3: ( ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4196:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4196:3: ({...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4197:4: {...}? => ( ( ( rule__Object2__Group_5_3__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred44_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
        }
        // InternalBug304681TestLanguage.g:4197:103: ( ( ( rule__Object2__Group_5_3__0 ) ) )
        // InternalBug304681TestLanguage.g:4198:5: ( ( rule__Object2__Group_5_3__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
        // InternalBug304681TestLanguage.g:4204:5: ( ( rule__Object2__Group_5_3__0 ) )
        // InternalBug304681TestLanguage.g:4205:6: ( rule__Object2__Group_5_3__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObject2Access().getGroup_5_3()); 
        }
        // InternalBug304681TestLanguage.g:4206:6: ( rule__Object2__Group_5_3__0 )
        // InternalBug304681TestLanguage.g:4206:7: rule__Object2__Group_5_3__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__Group_5_3__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred44_InternalBug304681TestLanguage

    // $ANTLR start synpred45_InternalBug304681TestLanguage
    public final void synpred45_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4227:8: ( rule__Object2__FeaturesAssignment_5_4 )
        // InternalBug304681TestLanguage.g:4227:9: rule__Object2__FeaturesAssignment_5_4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__FeaturesAssignment_5_4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalBug304681TestLanguage

    // $ANTLR start synpred46_InternalBug304681TestLanguage
    public final void synpred46_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4247:2: ( rule__Object2__UnorderedGroup_5__1 )
        // InternalBug304681TestLanguage.g:4247:2: rule__Object2__UnorderedGroup_5__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalBug304681TestLanguage

    // $ANTLR start synpred47_InternalBug304681TestLanguage
    public final void synpred47_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4259:2: ( rule__Object2__UnorderedGroup_5__2 )
        // InternalBug304681TestLanguage.g:4259:2: rule__Object2__UnorderedGroup_5__2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_InternalBug304681TestLanguage

    // $ANTLR start synpred48_InternalBug304681TestLanguage
    public final void synpred48_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4271:2: ( rule__Object2__UnorderedGroup_5__3 )
        // InternalBug304681TestLanguage.g:4271:2: rule__Object2__UnorderedGroup_5__3
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_InternalBug304681TestLanguage

    // $ANTLR start synpred49_InternalBug304681TestLanguage
    public final void synpred49_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4283:2: ( rule__Object2__UnorderedGroup_5__4 )
        // InternalBug304681TestLanguage.g:4283:2: rule__Object2__UnorderedGroup_5__4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Object2__UnorderedGroup_5__4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_InternalBug304681TestLanguage

    // $ANTLR start synpred50_InternalBug304681TestLanguage
    public final void synpred50_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4307:2: ( rule__Attribute2__UnorderedGroup_3_0_1__0 )
        // InternalBug304681TestLanguage.g:4307:2: rule__Attribute2__UnorderedGroup_3_0_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalBug304681TestLanguage

    // $ANTLR start synpred51_InternalBug304681TestLanguage
    public final void synpred51_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4322:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4322:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4322:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4323:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred51_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
        }
        // InternalBug304681TestLanguage.g:4323:110: ( ( ( rule__Attribute2__Group_3_0_1_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4324:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
        // InternalBug304681TestLanguage.g:4330:5: ( ( rule__Attribute2__Group_3_0_1_0__0 ) )
        // InternalBug304681TestLanguage.g:4331:6: ( rule__Attribute2__Group_3_0_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getGroup_3_0_1_0()); 
        }
        // InternalBug304681TestLanguage.g:4332:6: ( rule__Attribute2__Group_3_0_1_0__0 )
        // InternalBug304681TestLanguage.g:4332:7: rule__Attribute2__Group_3_0_1_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__Group_3_0_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred51_InternalBug304681TestLanguage

    // $ANTLR start synpred52_InternalBug304681TestLanguage
    public final void synpred52_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4337:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4337:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4337:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4338:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred52_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
        }
        // InternalBug304681TestLanguage.g:4338:110: ( ( ( rule__Attribute2__Group_3_0_1_1__0 ) ) )
        // InternalBug304681TestLanguage.g:4339:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
        // InternalBug304681TestLanguage.g:4345:5: ( ( rule__Attribute2__Group_3_0_1_1__0 ) )
        // InternalBug304681TestLanguage.g:4346:6: ( rule__Attribute2__Group_3_0_1_1__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getGroup_3_0_1_1()); 
        }
        // InternalBug304681TestLanguage.g:4347:6: ( rule__Attribute2__Group_3_0_1_1__0 )
        // InternalBug304681TestLanguage.g:4347:7: rule__Attribute2__Group_3_0_1_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__Group_3_0_1_1__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred52_InternalBug304681TestLanguage

    // $ANTLR start synpred53_InternalBug304681TestLanguage
    public final void synpred53_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4368:8: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
        // InternalBug304681TestLanguage.g:4368:9: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_InternalBug304681TestLanguage

    // $ANTLR start synpred54_InternalBug304681TestLanguage
    public final void synpred54_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4352:3: ( ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) ) )
        // InternalBug304681TestLanguage.g:4352:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4352:3: ({...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) ) )
        // InternalBug304681TestLanguage.g:4353:4: {...}? => ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred54_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
        }
        // InternalBug304681TestLanguage.g:4353:110: ( ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) ) )
        // InternalBug304681TestLanguage.g:4354:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
        // InternalBug304681TestLanguage.g:4360:5: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* ) )
        // InternalBug304681TestLanguage.g:4361:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) ) ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
        {
        // InternalBug304681TestLanguage.g:4361:6: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 ) )
        // InternalBug304681TestLanguage.g:4362:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
        }
        // InternalBug304681TestLanguage.g:4363:7: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )
        // InternalBug304681TestLanguage.g:4363:8: rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
        {
        pushFollow(FollowSets000.FOLLOW_28);
        rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalBug304681TestLanguage.g:4366:6: ( ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )* )
        // InternalBug304681TestLanguage.g:4367:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getConstraintDefinitionsAssignment_3_0_1_2()); 
        }
        // InternalBug304681TestLanguage.g:4368:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*
        loop54:
        do {
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==28) && (synpred53_InternalBug304681TestLanguage())) {
                alt54=1;
            }


            switch (alt54) {
        	case 1 :
        	    // InternalBug304681TestLanguage.g:4368:8: ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2
        	    {
        	    pushFollow(FollowSets000.FOLLOW_28);
        	    rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop54;
            }
        } while (true);


        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred54_InternalBug304681TestLanguage

    // $ANTLR start synpred55_InternalBug304681TestLanguage
    public final void synpred55_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4374:3: ( ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4374:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4374:3: ({...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4375:4: {...}? => ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred55_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
        }
        // InternalBug304681TestLanguage.g:4375:110: ( ( ( rule__Attribute2__Group_3_0_1_3__0 ) ) )
        // InternalBug304681TestLanguage.g:4376:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
        // InternalBug304681TestLanguage.g:4382:5: ( ( rule__Attribute2__Group_3_0_1_3__0 ) )
        // InternalBug304681TestLanguage.g:4383:6: ( rule__Attribute2__Group_3_0_1_3__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getAttribute2Access().getGroup_3_0_1_3()); 
        }
        // InternalBug304681TestLanguage.g:4384:6: ( rule__Attribute2__Group_3_0_1_3__0 )
        // InternalBug304681TestLanguage.g:4384:7: rule__Attribute2__Group_3_0_1_3__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__Group_3_0_1_3__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred55_InternalBug304681TestLanguage

    // $ANTLR start synpred56_InternalBug304681TestLanguage
    public final void synpred56_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4418:2: ( rule__Attribute2__UnorderedGroup_3_0_1__1 )
        // InternalBug304681TestLanguage.g:4418:2: rule__Attribute2__UnorderedGroup_3_0_1__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalBug304681TestLanguage

    // $ANTLR start synpred57_InternalBug304681TestLanguage
    public final void synpred57_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4430:2: ( rule__Attribute2__UnorderedGroup_3_0_1__2 )
        // InternalBug304681TestLanguage.g:4430:2: rule__Attribute2__UnorderedGroup_3_0_1__2
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__2();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalBug304681TestLanguage

    // $ANTLR start synpred58_InternalBug304681TestLanguage
    public final void synpred58_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4442:2: ( rule__Attribute2__UnorderedGroup_3_0_1__3 )
        // InternalBug304681TestLanguage.g:4442:2: rule__Attribute2__UnorderedGroup_3_0_1__3
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__3();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalBug304681TestLanguage

    // $ANTLR start synpred59_InternalBug304681TestLanguage
    public final void synpred59_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4454:2: ( rule__Attribute2__UnorderedGroup_3_0_1__4 )
        // InternalBug304681TestLanguage.g:4454:2: rule__Attribute2__UnorderedGroup_3_0_1__4
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Attribute2__UnorderedGroup_3_0_1__4();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalBug304681TestLanguage

    // $ANTLR start synpred60_InternalBug304681TestLanguage
    public final void synpred60_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4478:2: ( rule__Reference2__UnorderedGroup_4_0_1__0 )
        // InternalBug304681TestLanguage.g:4478:2: rule__Reference2__UnorderedGroup_4_0_1__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference2__UnorderedGroup_4_0_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_InternalBug304681TestLanguage

    // $ANTLR start synpred61_InternalBug304681TestLanguage
    public final void synpred61_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4493:3: ( ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4493:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4493:3: ({...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4494:4: {...}? => ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred61_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
        }
        // InternalBug304681TestLanguage.g:4494:110: ( ( ( rule__Reference2__Group_4_0_1_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4495:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
        // InternalBug304681TestLanguage.g:4501:5: ( ( rule__Reference2__Group_4_0_1_0__0 ) )
        // InternalBug304681TestLanguage.g:4502:6: ( rule__Reference2__Group_4_0_1_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getReference2Access().getGroup_4_0_1_0()); 
        }
        // InternalBug304681TestLanguage.g:4503:6: ( rule__Reference2__Group_4_0_1_0__0 )
        // InternalBug304681TestLanguage.g:4503:7: rule__Reference2__Group_4_0_1_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference2__Group_4_0_1_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred61_InternalBug304681TestLanguage

    // $ANTLR start synpred62_InternalBug304681TestLanguage
    public final void synpred62_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4537:2: ( rule__Reference2__UnorderedGroup_4_0_1__1 )
        // InternalBug304681TestLanguage.g:4537:2: rule__Reference2__UnorderedGroup_4_0_1__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__Reference2__UnorderedGroup_4_0_1__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_InternalBug304681TestLanguage

    // $ANTLR start synpred63_InternalBug304681TestLanguage
    public final void synpred63_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4576:3: ( ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) ) )
        // InternalBug304681TestLanguage.g:4576:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
        {
        // InternalBug304681TestLanguage.g:4576:3: ({...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) ) )
        // InternalBug304681TestLanguage.g:4577:4: {...}? => ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred63_InternalBug304681TestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
        }
        // InternalBug304681TestLanguage.g:4577:116: ( ( ( rule__ConstraintDefinition__Group_3_0__0 ) ) )
        // InternalBug304681TestLanguage.g:4578:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
        // InternalBug304681TestLanguage.g:4584:5: ( ( rule__ConstraintDefinition__Group_3_0__0 ) )
        // InternalBug304681TestLanguage.g:4585:6: ( rule__ConstraintDefinition__Group_3_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getConstraintDefinitionAccess().getGroup_3_0()); 
        }
        // InternalBug304681TestLanguage.g:4586:6: ( rule__ConstraintDefinition__Group_3_0__0 )
        // InternalBug304681TestLanguage.g:4586:7: rule__ConstraintDefinition__Group_3_0__0
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__ConstraintDefinition__Group_3_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred63_InternalBug304681TestLanguage

    // $ANTLR start synpred64_InternalBug304681TestLanguage
    public final void synpred64_InternalBug304681TestLanguage_fragment() throws RecognitionException {   
        // InternalBug304681TestLanguage.g:4620:2: ( rule__ConstraintDefinition__UnorderedGroup_3__1 )
        // InternalBug304681TestLanguage.g:4620:2: rule__ConstraintDefinition__UnorderedGroup_3__1
        {
        pushFollow(FollowSets000.FOLLOW_2);
        rule__ConstraintDefinition__UnorderedGroup_3__1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalBug304681TestLanguage

    // Delegated rules

    public final boolean synpred36_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalBug304681TestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalBug304681TestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String dfa_1s = "\32\uffff";
    static final String dfa_2s = "\1\1\31\uffff";
    static final String dfa_3s = "\1\21\1\uffff\4\4\1\13\1\4\1\13\1\0\1\21\1\0\1\uffff\2\5\1\0\2\13\2\21\2\5\2\13\2\21";
    static final String dfa_4s = "\1\41\1\uffff\3\4\1\42\1\13\1\4\1\20\1\0\1\24\1\0\1\uffff\2\5\1\0\2\13\2\24\2\5\2\13\2\21";
    static final String dfa_5s = "\1\uffff\1\2\12\uffff\1\1\15\uffff";
    static final String dfa_6s = "\11\uffff\1\1\1\uffff\1\2\3\uffff\1\0\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\uffff\4\1\1\uffff\2\1\1\2\1\3\5\uffff\1\1",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\10\35\uffff\1\7",
            "\1\11",
            "\1\10",
            "\1\13\4\uffff\1\12",
            "\1\uffff",
            "\1\17\1\uffff\1\15\1\16",
            "\1\uffff",
            "",
            "\1\20",
            "\1\21",
            "\1\uffff",
            "\1\22",
            "\1\23",
            "\1\17\1\uffff\1\24\1\25",
            "\1\17\1\uffff\1\24\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\17",
            "\1\17"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 1430:2: ( rule__Object__FeaturesAssignment_5_6_1 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_15 = input.LA(1);

                         
                        int index13_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_9 = input.LA(1);

                         
                        int index13_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_11 = input.LA(1);

                         
                        int index13_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index13_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\11\uffff\1\1\1\uffff\1\0\3\uffff\1\2\12\uffff}>";
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_8;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 1490:3: ( rule__Object__FeaturesAssignment_5_7_1 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_11 = input.LA(1);

                         
                        int index14_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_9 = input.LA(1);

                         
                        int index14_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_15 = input.LA(1);

                         
                        int index14_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index14_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_9s = "\13\uffff";
    static final String dfa_10s = "\1\21\12\uffff";
    static final String dfa_11s = "\1\41\12\uffff";
    static final String dfa_12s = "\1\uffff\11\1\1\2";
    static final String dfa_13s = "\1\0\12\uffff}>";
    static final String[] dfa_14s = {
            "\1\12\1\uffff\1\1\1\2\1\3\1\7\1\uffff\1\10\1\11\1\5\1\6\5\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_9;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3801:2: ( rule__Object__UnorderedGroup_5__0 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                         
                        int index21_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA21_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA21_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA21_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA21_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA21_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA21_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA21_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA21_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA21_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA21_0==17) ) {s = 10;}

                         
                        input.seek(index21_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\12\uffff";
    static final String dfa_16s = "\1\23\11\uffff";
    static final String dfa_17s = "\1\41\11\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\2\1\3\1\4\2\5\1\6\1\7\1\10";
    static final String dfa_19s = "\1\0\11\uffff}>";
    static final String[] dfa_20s = {
            "\1\1\1\2\1\3\1\7\1\uffff\1\10\1\11\1\5\1\6\5\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_15;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "3815:3: ( ({...}? => ( ( ( rule__Object__Group_5_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_3__0 ) ) ) ) | ({...}? => ( ( ( ( rule__Object__FeaturesAssignment_5_4 ) ) ( ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )* ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_5__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_6__0 ) ) ) ) | ({...}? => ( ( ( rule__Object__Group_5_7__0 ) ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA23_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA23_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA23_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA23_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA23_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA23_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA23_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA23_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA23_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 3892:7: ( ( rule__Object__FeaturesAssignment_5_4 )=> rule__Object__FeaturesAssignment_5_4 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_15 = input.LA(1);

                         
                        int index22_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index22_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_9 = input.LA(1);

                         
                        int index22_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index22_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA22_11 = input.LA(1);

                         
                        int index22_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred26_InternalBug304681TestLanguage()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index22_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_21s = "\1\12\12\uffff";
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3957:2: ( rule__Object__UnorderedGroup_5__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_0 = input.LA(1);

                         
                        int index24_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA24_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA24_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA24_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA24_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA24_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA24_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA24_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA24_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA24_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA24_0==EOF||LA24_0==17) ) {s = 10;}

                         
                        input.seek(index24_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3969:2: ( rule__Object__UnorderedGroup_5__2 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_0 = input.LA(1);

                         
                        int index25_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA25_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA25_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA25_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA25_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA25_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA25_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA25_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA25_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA25_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA25_0==EOF||LA25_0==17) ) {s = 10;}

                         
                        input.seek(index25_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3981:2: ( rule__Object__UnorderedGroup_5__3 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                         
                        int index26_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA26_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA26_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA26_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA26_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA26_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA26_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA26_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA26_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA26_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA26_0==EOF||LA26_0==17) ) {s = 10;}

                         
                        input.seek(index26_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "3993:2: ( rule__Object__UnorderedGroup_5__4 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_0 = input.LA(1);

                         
                        int index27_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA27_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA27_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA27_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA27_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA27_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA27_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA27_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA27_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA27_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA27_0==EOF||LA27_0==17) ) {s = 10;}

                         
                        input.seek(index27_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4005:2: ( rule__Object__UnorderedGroup_5__5 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                         
                        int index28_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA28_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA28_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA28_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA28_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA28_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA28_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA28_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA28_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA28_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA28_0==EOF||LA28_0==17) ) {s = 10;}

                         
                        input.seek(index28_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4017:2: ( rule__Object__UnorderedGroup_5__6 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_0 = input.LA(1);

                         
                        int index29_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA29_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA29_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA29_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA29_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA29_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA29_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA29_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA29_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA29_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA29_0==EOF||LA29_0==17) ) {s = 10;}

                         
                        input.seek(index29_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_9;
            this.eof = dfa_21;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4029:2: ( rule__Object__UnorderedGroup_5__7 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_0 = input.LA(1);

                         
                        int index30_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA30_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 1;}

                        else if ( LA30_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 2;}

                        else if ( LA30_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 3;}

                        else if ( LA30_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 4;}

                        else if ( LA30_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 5;}

                        else if ( LA30_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA30_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA30_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA30_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( (LA30_0==EOF||LA30_0==17) ) {s = 10;}

                         
                        input.seek(index30_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_22s = "\u01fa\uffff";
    static final String dfa_23s = "\1\1\u01f9\uffff";
    static final String dfa_24s = "\1\21\1\uffff\4\4\1\13\1\4\1\13\1\21\1\0\1\21\1\0\2\5\1\4\2\13\1\0\1\uffff\2\5\1\0\2\13\1\20\2\21\2\13\2\21\1\35\2\5\1\4\2\13\2\21\2\5\2\13\1\20\2\21\3\5\1\21\1\13\2\21\1\35\2\5\1\4\4\13\2\5\2\21\2\5\2\13\1\20\4\21\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2\13\1\21\1\20\2\5\2\21\2\5\2\13\1\20\2\21\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2\13\2\5\1\21\1\20\2\5\2\21\2\5\2\13\1\20\2\21\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\21\1\35\2\5\2\21\2\5\1\21\1\20\2\5\2\21\3\5\1\21\1\13\1\4\2\5\2\13\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\21\1\20\2\13\2\21\2\5\2\21\2\5\1\21\1\20\2\5\2\21\1\35\2\21\2\5\1\4\2\13\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\2\5\2\13\1\20\3\21\1\20\2\5\2\21\2\5\1\21\1\20\1\5\1\21\1\13\2\21\1\35\2\5\1\4\2\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\35\2\5\2\21\2\5\2\13\1\20\2\21\2\5\1\21\1\20\2\5\2\21\3\5\1\21\1\13\1\4\2\5\2\13\1\5\1\21\1\13\2\21\1\35\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\21\1\20\2\13\2\21\2\5\2\21\4\5\2\21\2\5\1\21\1\20\2\5\2\21\1\35\2\21\2\5\1\4\2\13\1\5\1\21\1\13\1\5\1\21\1\13\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\35\1\5\1\21\1\13\2\5\2\13\1\20\3\21\2\5\3\21\1\20\2\5\2\21\2\5\1\21\1\5\1\21\1\13\2\21\1\35\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\5\2\21\2\5\1\21\2\5\1\21\1\20\2\5\2\21\1\5\1\21\1\13\2\5\1\4\2\13\1\5\1\21\1\13\1\5\1\21\1\13\1\35\1\5\1\21\1\13\1\21\2\13\1\20\2\21\2\5\2\21\2\5\2\21\2\5\3\21\1\35\1\5\1\21\1\13\1\5\1\21\1\13\1\4\1\5\1\21\1\13\2\5\2\21\1\20\2\5\2\21\1\5\1\21\1\13\1\35\1\5\1\21\1\13\2\5\2\21\2\5\1\21\1\5\1\21\1\13\1\4\1\5\1\21\1\13\1\21\1\20\2\5\2\21\1\35\1\5\1\21\1\13\2\5\1\21\1\5\1\21\1\13\2\5\2\21\1\5\1\21\1\13\1\21";
    static final String dfa_25s = "\1\41\1\uffff\3\4\1\42\1\20\1\4\1\20\1\44\1\0\1\24\1\0\2\5\1\4\2\13\1\0\1\uffff\2\5\1\0\2\13\1\20\2\44\2\13\2\44\1\36\2\5\1\4\2\13\2\24\1\13\1\5\2\13\1\20\2\44\2\5\1\13\1\36\1\13\2\44\1\36\2\5\1\4\5\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\44\2\21\1\13\1\21\1\13\1\4\1\13\1\36\1\13\2\44\1\36\2\5\1\4\2\13\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\44\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\2\44\1\36\2\5\1\4\3\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\21\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\2\21\1\36\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\13\1\21\1\13\1\4\2\5\3\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\21\1\20\2\13\2\44\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\5\1\34\2\36\2\44\2\5\1\4\3\13\1\21\1\13\1\4\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\5\2\13\1\20\2\44\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\36\1\13\2\44\1\36\2\5\1\4\2\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\36\1\13\1\5\1\44\1\36\1\13\1\5\2\13\1\20\2\44\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\13\1\21\1\13\1\4\2\5\3\13\1\36\1\13\2\44\1\36\1\13\1\36\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\21\1\20\2\13\2\44\1\13\1\5\1\44\1\36\1\13\1\5\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\20\1\13\1\5\1\34\2\36\2\44\2\5\1\4\3\13\1\21\2\13\1\36\2\13\1\21\1\13\1\4\1\13\1\36\1\13\1\36\1\13\1\21\2\13\1\5\2\13\1\20\2\44\1\21\1\13\1\5\1\44\1\36\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\36\1\13\2\44\1\36\1\13\1\21\1\13\1\36\1\13\1\21\1\13\1\4\1\13\1\36\2\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\5\1\21\1\20\1\13\1\5\1\44\1\36\1\13\1\21\1\13\2\5\1\4\3\13\1\36\2\13\1\36\1\13\1\36\1\13\1\21\1\13\1\21\2\13\1\20\2\44\1\13\1\5\1\44\1\36\1\13\1\5\1\44\1\36\1\13\1\5\1\21\2\44\1\36\1\13\1\21\2\13\1\21\1\13\1\4\1\13\1\36\2\13\1\5\2\21\1\20\1\13\1\5\1\44\1\36\1\13\1\36\1\13\1\36\1\13\1\21\2\13\1\5\1\44\1\36\1\13\1\5\1\21\1\13\1\21\1\13\1\4\1\13\1\36\1\13\1\21\1\20\1\13\1\5\1\44\2\36\1\13\1\21\2\13\1\5\1\21\1\13\1\36\2\13\1\5\1\44\1\36\1\13\1\21\1\13\1\21";
    static final String dfa_26s = "\1\uffff\1\2\21\uffff\1\1\u01e6\uffff";
    static final String dfa_27s = "\12\uffff\1\3\1\uffff\1\1\5\uffff\1\2\3\uffff\1\0\u01e3\uffff}>";
    static final String[] dfa_28s = {
            "\1\1\1\uffff\3\1\4\uffff\1\2\1\3\5\uffff\1\1",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\10\35\uffff\1\7",
            "\1\12\4\uffff\1\11",
            "\1\10",
            "\1\14\4\uffff\1\13",
            "\1\22\1\uffff\1\15\1\16\7\uffff\1\17\6\uffff\1\20\1\21",
            "\1\uffff",
            "\1\26\1\uffff\1\24\1\25",
            "\1\uffff",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\uffff",
            "",
            "\1\34",
            "\1\35",
            "\1\uffff",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\46",
            "\1\47",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\43\6\uffff\1\44\1\45",
            "\1\50\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\26\1\uffff\1\57\1\60",
            "\1\26\1\uffff\1\57\1\60",
            "\1\61\5\uffff\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\74",
            "\1\75",
            "\1\61\5\uffff\1\62",
            "\1\100\13\uffff\1\76\1\77",
            "\1\101",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\71\6\uffff\1\72\1\73",
            "\1\102\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113\5\uffff\1\114",
            "\1\115",
            "\1\22\1\uffff\1\41\1\42\7\uffff\1\116\6\uffff\1\44\1\45",
            "\1\100\13\uffff\1\76\1\77",
            "\1\117\5\uffff\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\26",
            "\1\26",
            "\1\113\5\uffff\1\114",
            "\1\100",
            "\1\132",
            "\1\133",
            "\1\117\5\uffff\1\120",
            "\1\136\13\uffff\1\134\1\135",
            "\1\137",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\127\6\uffff\1\130\1\131",
            "\1\140\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\100",
            "\1\147",
            "\1\150\5\uffff\1\151",
            "\1\152",
            "\1\22\1\uffff\1\67\1\70\7\uffff\1\153\6\uffff\1\72\1\73",
            "\1\136\13\uffff\1\134\1\135",
            "\1\154\5\uffff\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\167\1\170",
            "\1\150\5\uffff\1\151",
            "\1\136",
            "\1\171",
            "\1\172",
            "\1\154\5\uffff\1\155",
            "\1\175\13\uffff\1\173\1\174",
            "\1\176",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\177\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086\5\uffff\1\u0087",
            "\1\u0088",
            "\1\136",
            "\1\u0089",
            "\1\u008a\5\uffff\1\u008b",
            "\1\u008c",
            "\1\22\1\uffff\1\125\1\126\7\uffff\1\u008d\6\uffff\1\130\1\131",
            "\1\175\13\uffff\1\173\1\174",
            "\1\u008e\5\uffff\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\22",
            "\1\22",
            "\1\u0086\5\uffff\1\u0087",
            "\1\u0096\13\uffff\1\u0094\1\u0095",
            "\1\u0097",
            "\1\u0098\1\u0099",
            "\1\u008a\5\uffff\1\u008b",
            "\1\175",
            "\1\u009a",
            "\1\u009b",
            "\1\u008e\5\uffff\1\u008f",
            "\1\u009e\13\uffff\1\u009c\1\u009d",
            "\1\u009f",
            "\1\22",
            "\1\22",
            "\1\u00a0\1\u00a1",
            "\1\u00a2\5\uffff\1\u00a3",
            "\1\u00a4",
            "\1\22\1\uffff\1\u00a6\1\u00a7\7\uffff\1\u00a5\6\uffff\1\u00a8\1\u00a9",
            "\1\u0096\13\uffff\1\u0094\1\u0095",
            "\1\u00aa\5\uffff\1\u00ab",
            "\1\u00ac",
            "\1\175",
            "\1\u00ad",
            "\1\u00ae\5\uffff\1\u00af",
            "\1\u00b0",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u00b1\6\uffff\1\165\1\166",
            "\1\u009e\13\uffff\1\u009c\1\u009d",
            "\1\u00b2\5\uffff\1\u00b3",
            "\1\u00b4",
            "\1\u00a2\5\uffff\1\u00a3",
            "\1\u0096",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00aa\5\uffff\1\u00ab",
            "\1\u00bd\13\uffff\1\u00bb\1\u00bc",
            "\1\u00be",
            "\1\u00bf\1\u00c0",
            "\1\u00ae\5\uffff\1\u00af",
            "\1\u009e",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00b2\5\uffff\1\u00b3",
            "\1\u00c5\13\uffff\1\u00c3\1\u00c4",
            "\1\u00c6",
            "\1\u0096",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\u00cf\5\uffff\1\u00d0",
            "\1\u00d1",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00d2\6\uffff\1\u00cd\1\u00ce",
            "\1\u00bd\13\uffff\1\u00bb\1\u00bc",
            "\1\u00d3\5\uffff\1\u00d4",
            "\1\u00d5",
            "\1\u009e",
            "\1\u00d6",
            "\1\u00d7\5\uffff\1\u00d8",
            "\1\u00d9",
            "\1\22\12\uffff\1\u00da",
            "\1\u00c5\13\uffff\1\u00c3\1\u00c4",
            "\1\u00db\1\u00dc",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\22\1\uffff\1\u00ca\1\u00cb\7\uffff\1\u00cc\6\uffff\1\u00cd\1\u00ce",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00cf\5\uffff\1\u00d0",
            "\1\u00bd",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00d3\5\uffff\1\u00d4",
            "\1\u00e6\13\uffff\1\u00e4\1\u00e5",
            "\1\u00e7",
            "\1\u00e8\1\u00e9",
            "\1\u00d7\5\uffff\1\u00d8",
            "\1\u00c5",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec\5\uffff\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u00bd",
            "\1\u00f7",
            "\1\u00f8\5\uffff\1\u00f9",
            "\1\u00fa",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00fb\6\uffff\1\u00f5\1\u00f6",
            "\1\u00e6\13\uffff\1\u00e4\1\u00e5",
            "\1\u00fc\5\uffff\1\u00fd",
            "\1\u00fe",
            "\1\u00c5",
            "\1\u00ff",
            "\1\u00ec\5\uffff\1\u00ed",
            "\1\u0102\13\uffff\1\u0100\1\u0101",
            "\1\u0103",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u0104\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b\1\u010c",
            "\1\u00f8\5\uffff\1\u00f9",
            "\1\u00e6",
            "\1\u010d",
            "\1\u010e",
            "\1\u00fc\5\uffff\1\u00fd",
            "\1\u0111\13\uffff\1\u010f\1\u0110",
            "\1\u0112",
            "\1\u0113\1\u0114",
            "\1\u0115\5\uffff\1\u0116",
            "\1\u0117",
            "\1\22\1\uffff\1\u0119\1\u011a\7\uffff\1\u0118\6\uffff\1\u011b\1\u011c",
            "\1\u0102\13\uffff\1\u0100\1\u0101",
            "\1\u011d\5\uffff\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\u0123\5\uffff\1\u0124",
            "\1\u0125",
            "\1\u00e6",
            "\1\u0126",
            "\1\u0127\5\uffff\1\u0128",
            "\1\u0129",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u012a\6\uffff\1\165\1\166",
            "\1\u0111\13\uffff\1\u010f\1\u0110",
            "\1\u012b\5\uffff\1\u012c",
            "\1\u012d",
            "\1\u0115\5\uffff\1\u0116",
            "\1\u0102",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u011d\5\uffff\1\u011e",
            "\1\u0136\13\uffff\1\u0134\1\u0135",
            "\1\u0137",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\164\6\uffff\1\165\1\166",
            "\1\u0138\1\u0139",
            "\1\u0123\5\uffff\1\u0124",
            "\1\u013c\13\uffff\1\u013a\1\u013b",
            "\1\u013d",
            "\1\u013e\1\u013f",
            "\1\u0127\5\uffff\1\u0128",
            "\1\u0111",
            "\1\u0140",
            "\1\u0141",
            "\1\u012b\5\uffff\1\u012c",
            "\1\u0144\13\uffff\1\u0142\1\u0143",
            "\1\u0145",
            "\1\u0102",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u014e\5\uffff\1\u014f",
            "\1\u0150",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00fb\6\uffff\1\u00f5\1\u00f6",
            "\1\u0136\13\uffff\1\u0134\1\u0135",
            "\1\u0151\5\uffff\1\u0152",
            "\1\u0153",
            "\1\u0154\5\uffff\1\u0155",
            "\1\u0156",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u0157\6\uffff\1\u014c\1\u014d",
            "\1\u013c\13\uffff\1\u013a\1\u013b",
            "\1\u0158\5\uffff\1\u0159",
            "\1\u015a",
            "\1\u0111",
            "\1\u015b",
            "\1\u015c\5\uffff\1\u015d",
            "\1\u015e",
            "\1\22\12\uffff\1\u00da",
            "\1\u0144\13\uffff\1\u0142\1\u0143",
            "\1\u015f\1\u0160",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u014e\5\uffff\1\u014f",
            "\1\u0136",
            "\1\u0166",
            "\1\u0151\5\uffff\1\u0152",
            "\1\u0169\13\uffff\1\u0167\1\u0168",
            "\1\u016a",
            "\1\u0154\5\uffff\1\u0155",
            "\1\u013c",
            "\1\u016b",
            "\1\u016c",
            "\1\u0158\5\uffff\1\u0159",
            "\1\u016f\13\uffff\1\u016d\1\u016e",
            "\1\u0170",
            "\1\u0171\1\u0172",
            "\1\u015c\5\uffff\1\u015d",
            "\1\u0144",
            "\1\u0173",
            "\1\u0174\5\uffff\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u0136",
            "\1\u017a\5\uffff\1\u017b",
            "\1\u017c",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u012a\6\uffff\1\165\1\166",
            "\1\u0169\13\uffff\1\u0167\1\u0168",
            "\1\u013c",
            "\1\u017d",
            "\1\u017e\5\uffff\1\u017f",
            "\1\u0180",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u0181\6\uffff\1\u00f5\1\u00f6",
            "\1\u016f\13\uffff\1\u016d\1\u016e",
            "\1\u0182\5\uffff\1\u0183",
            "\1\u0184",
            "\1\u0144",
            "\1\u0174\5\uffff\1\u0175",
            "\1\u0187\13\uffff\1\u0185\1\u0186",
            "\1\u0188",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u00f4\6\uffff\1\u00f5\1\u00f6",
            "\1\u0189\1\u018a",
            "\1\u017a\5\uffff\1\u017b",
            "\1\u0169",
            "\1\u018b",
            "\1\u018c\1\u018d",
            "\1\u017e\5\uffff\1\u017f",
            "\1\u016f",
            "\1\u018e",
            "\1\u018f",
            "\1\u0182\5\uffff\1\u0183",
            "\1\u0192\13\uffff\1\u0190\1\u0191",
            "\1\u0193",
            "\1\u0194\5\uffff\1\u0195",
            "\1\u0196",
            "\1\22\1\uffff\1\u0197\1\u0198\7\uffff\1\u0199\6\uffff\1\u019a\1\u019b",
            "\1\u0187\13\uffff\1\u0185\1\u0186",
            "\1\u019c\5\uffff\1\u019d",
            "\1\u019e",
            "\1\u0169",
            "\1\u019f\5\uffff\1\u01a0",
            "\1\u01a1",
            "\1\u016f",
            "\1\u01a2",
            "\1\u01a3\5\uffff\1\u01a4",
            "\1\u01a5",
            "\1\22\1\uffff\1\162\1\163\7\uffff\1\u012a\6\uffff\1\165\1\166",
            "\1\u0192\13\uffff\1\u0190\1\u0191",
            "\1\u0194\5\uffff\1\u0195",
            "\1\u0187",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u019c\5\uffff\1\u019d",
            "\1\u01ae\13\uffff\1\u01ac\1\u01ad",
            "\1\u01af",
            "\1\u019f\5\uffff\1\u01a0",
            "\1\u01b2\13\uffff\1\u01b0\1\u01b1",
            "\1\u01b3",
            "\1\u01b4\1\u01b5",
            "\1\u01a3\5\uffff\1\u01a4",
            "\1\u0192",
            "\1\u01b6",
            "\1\u0187",
            "\1\u01b7",
            "\1\u01b8",
            "\1\u01b9",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u01ba\5\uffff\1\u01bb",
            "\1\u01bc",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u0181\6\uffff\1\u00f5\1\u00f6",
            "\1\u01ae\13\uffff\1\u01ac\1\u01ad",
            "\1\u01bd\5\uffff\1\u01be",
            "\1\u01bf",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u01c0\6\uffff\1\u014c\1\u014d",
            "\1\u01b2\13\uffff\1\u01b0\1\u01b1",
            "\1\u01c1\5\uffff\1\u01c2",
            "\1\u01c3",
            "\1\u0192",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u014b\6\uffff\1\u014c\1\u014d",
            "\1\u01c4\1\u01c5",
            "\1\u01ba\5\uffff\1\u01bb",
            "\1\u01ae",
            "\1\u01c6",
            "\1\u01bd\5\uffff\1\u01be",
            "\1\u01b2",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c1\5\uffff\1\u01c2",
            "\1\u01cb\13\uffff\1\u01c9\1\u01ca",
            "\1\u01cc",
            "\1\u01cd\5\uffff\1\u01ce",
            "\1\u01cf",
            "\1\u01ae",
            "\1\u01b2",
            "\1\u01d0",
            "\1\u01d1\5\uffff\1\u01d2",
            "\1\u01d3",
            "\1\22\1\uffff\1\u00f2\1\u00f3\7\uffff\1\u0181\6\uffff\1\u00f5\1\u00f6",
            "\1\u01cb\13\uffff\1\u01c9\1\u01ca",
            "\1\u01cd\5\uffff\1\u01ce",
            "\1\u01d6\13\uffff\1\u01d4\1\u01d5",
            "\1\u01d7",
            "\1\u01d8\1\u01d9",
            "\1\u01d1\5\uffff\1\u01d2",
            "\1\u01cb",
            "\1\u01da",
            "\1\u01db\5\uffff\1\u01dc",
            "\1\u01dd",
            "\1\22\1\uffff\1\u0197\1\u0198\7\uffff\1\u01de\6\uffff\1\u019a\1\u019b",
            "\1\u01d6\13\uffff\1\u01d4\1\u01d5",
            "\1\u01df\5\uffff\1\u01e0",
            "\1\u01e1",
            "\1\u01cb",
            "\1\u01db\5\uffff\1\u01dc",
            "\1\u01d6",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01df\5\uffff\1\u01e0",
            "\1\u01e6\13\uffff\1\u01e4\1\u01e5",
            "\1\u01e7",
            "\1\u01d6",
            "\1\u01e8",
            "\1\u01e9\5\uffff\1\u01ea",
            "\1\u01eb",
            "\1\22\1\uffff\1\u0149\1\u014a\7\uffff\1\u01c0\6\uffff\1\u014c\1\u014d",
            "\1\u01e6\13\uffff\1\u01e4\1\u01e5",
            "\1\u01ec\1\u01ed",
            "\1\u01e9\5\uffff\1\u01ea",
            "\1\u01e6",
            "\1\u01ee",
            "\1\u01ef\5\uffff\1\u01f0",
            "\1\u01f1",
            "\1\u01e6",
            "\1\u01ef\5\uffff\1\u01f0",
            "\1\u01f4\13\uffff\1\u01f2\1\u01f3",
            "\1\u01f5",
            "\1\u01f6\5\uffff\1\u01f7",
            "\1\u01f8",
            "\1\22\1\uffff\1\u0197\1\u0198\7\uffff\1\u01de\6\uffff\1\u019a\1\u019b",
            "\1\u01f4\13\uffff\1\u01f2\1\u01f3",
            "\1\u01f6\5\uffff\1\u01f7",
            "\1\u01f4",
            "\1\u01f9",
            "\1\u01f4"
    };

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_22;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "()* loopback of 4227:7: ( ( rule__Object2__FeaturesAssignment_5_4 )=> rule__Object2__FeaturesAssignment_5_4 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_22 = input.LA(1);

                         
                        int index35_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_22);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_12 = input.LA(1);

                         
                        int index35_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_18 = input.LA(1);

                         
                        int index35_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_18);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_10 = input.LA(1);

                         
                        int index35_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalBug304681TestLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index35_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_29s = "\23\uffff";
    static final String dfa_30s = "\1\1\22\uffff";
    static final String dfa_31s = "\1\21\1\uffff\1\4\1\20\1\35\3\5\1\21\1\13\2\5\1\0\1\21\1\5\1\21\1\13\1\uffff\1\21";
    static final String dfa_32s = "\1\44\1\uffff\1\4\1\20\1\36\1\13\1\5\1\13\1\36\2\13\1\5\1\0\1\36\1\13\1\21\1\13\1\uffff\1\21";
    static final String dfa_33s = "\1\uffff\1\2\17\uffff\1\1\1\uffff";
    static final String dfa_34s = "\14\uffff\1\0\6\uffff}>";
    static final String[] dfa_35s = {
            "\1\1\1\uffff\2\1\7\uffff\1\2\6\uffff\2\1",
            "",
            "\1\3",
            "\1\4",
            "\1\5\1\6",
            "\1\7\5\uffff\1\10",
            "\1\11",
            "\1\7\5\uffff\1\10",
            "\1\14\13\uffff\1\12\1\13",
            "\1\15",
            "\1\16\5\uffff\1\17",
            "\1\20",
            "\1\uffff",
            "\1\14\13\uffff\1\12\1\13",
            "\1\16\5\uffff\1\17",
            "\1\14",
            "\1\22",
            "",
            "\1\14"
    };

    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_29;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "()* loopback of 4368:7: ( ( rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )=> rule__Attribute2__ConstraintDefinitionsAssignment_3_0_1_2 )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred53_InternalBug304681TestLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000180008000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000180008002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000050000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000020F780000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000C800000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400000010L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010800L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000020C380000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000001810180000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000020F780002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000180002L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000020C380002L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001810180002L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000060000002L});
    }


}