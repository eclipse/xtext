package org.eclipse.xtext.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtextGrammarTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'?'", "'*'", "'+'", "'='", "'+='", "'!'", "'?='", "'grammar'", "'with'", "','", "'('", "')'", "'.'", "'generate'", "'as'", "'import'", "':'", "';'", "'['", "']'", "'returns'", "'::'", "'|'", "'&'", "'{'", "'}'", "'current'", "'terminal'", "'->'", "'EOF'", "'..'", "'enum'", "'hidden'", "'fragment'", "'=>'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalXtextGrammarTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtextGrammarTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtextGrammarTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXtextGrammarTestLanguage.g"; }


    	private XtextGrammarTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(XtextGrammarTestLanguageGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleGrammar"
    // InternalXtextGrammarTestLanguage.g:53:1: entryRuleGrammar : ruleGrammar EOF ;
    public final void entryRuleGrammar() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:54:1: ( ruleGrammar EOF )
            // InternalXtextGrammarTestLanguage.g:55:1: ruleGrammar EOF
            {
             before(grammarAccess.getGrammarRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammar();

            state._fsp--;

             after(grammarAccess.getGrammarRule()); 
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
    // $ANTLR end "entryRuleGrammar"


    // $ANTLR start "ruleGrammar"
    // InternalXtextGrammarTestLanguage.g:62:1: ruleGrammar : ( ( rule__Grammar__Group__0 ) ) ;
    public final void ruleGrammar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:66:2: ( ( ( rule__Grammar__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:67:2: ( ( rule__Grammar__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:67:2: ( ( rule__Grammar__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:68:3: ( rule__Grammar__Group__0 )
            {
             before(grammarAccess.getGrammarAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:69:3: ( rule__Grammar__Group__0 )
            // InternalXtextGrammarTestLanguage.g:69:4: rule__Grammar__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGrammar"


    // $ANTLR start "ruleHiddenClause"
    // InternalXtextGrammarTestLanguage.g:79:1: ruleHiddenClause : ( ( rule__HiddenClause__Group__0 ) ) ;
    public final void ruleHiddenClause() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:83:2: ( ( ( rule__HiddenClause__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:84:2: ( ( rule__HiddenClause__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:84:2: ( ( rule__HiddenClause__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:85:3: ( rule__HiddenClause__Group__0 )
            {
             before(grammarAccess.getHiddenClauseAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:86:3: ( rule__HiddenClause__Group__0 )
            // InternalXtextGrammarTestLanguage.g:86:4: rule__HiddenClause__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHiddenClauseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHiddenClause"


    // $ANTLR start "entryRuleGrammarID"
    // InternalXtextGrammarTestLanguage.g:95:1: entryRuleGrammarID : ruleGrammarID EOF ;
    public final void entryRuleGrammarID() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:96:1: ( ruleGrammarID EOF )
            // InternalXtextGrammarTestLanguage.g:97:1: ruleGrammarID EOF
            {
             before(grammarAccess.getGrammarIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarIDRule()); 
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
    // $ANTLR end "entryRuleGrammarID"


    // $ANTLR start "ruleGrammarID"
    // InternalXtextGrammarTestLanguage.g:104:1: ruleGrammarID : ( ( rule__GrammarID__Group__0 ) ) ;
    public final void ruleGrammarID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:108:2: ( ( ( rule__GrammarID__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:109:2: ( ( rule__GrammarID__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:109:2: ( ( rule__GrammarID__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:110:3: ( rule__GrammarID__Group__0 )
            {
             before(grammarAccess.getGrammarIDAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:111:3: ( rule__GrammarID__Group__0 )
            // InternalXtextGrammarTestLanguage.g:111:4: rule__GrammarID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGrammarIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGrammarID"


    // $ANTLR start "entryRuleAbstractRule"
    // InternalXtextGrammarTestLanguage.g:120:1: entryRuleAbstractRule : ruleAbstractRule EOF ;
    public final void entryRuleAbstractRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:121:1: ( ruleAbstractRule EOF )
            // InternalXtextGrammarTestLanguage.g:122:1: ruleAbstractRule EOF
            {
             before(grammarAccess.getAbstractRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getAbstractRuleRule()); 
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
    // $ANTLR end "entryRuleAbstractRule"


    // $ANTLR start "ruleAbstractRule"
    // InternalXtextGrammarTestLanguage.g:129:1: ruleAbstractRule : ( ( rule__AbstractRule__Alternatives ) ) ;
    public final void ruleAbstractRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:133:2: ( ( ( rule__AbstractRule__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:134:2: ( ( rule__AbstractRule__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:134:2: ( ( rule__AbstractRule__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:135:3: ( rule__AbstractRule__Alternatives )
            {
             before(grammarAccess.getAbstractRuleAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:136:3: ( rule__AbstractRule__Alternatives )
            // InternalXtextGrammarTestLanguage.g:136:4: rule__AbstractRule__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractRule"


    // $ANTLR start "entryRuleAbstractMetamodelDeclaration"
    // InternalXtextGrammarTestLanguage.g:145:1: entryRuleAbstractMetamodelDeclaration : ruleAbstractMetamodelDeclaration EOF ;
    public final void entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:146:1: ( ruleAbstractMetamodelDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:147:1: ruleAbstractMetamodelDeclaration EOF
            {
             before(grammarAccess.getAbstractMetamodelDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

             after(grammarAccess.getAbstractMetamodelDeclarationRule()); 
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
    // $ANTLR end "entryRuleAbstractMetamodelDeclaration"


    // $ANTLR start "ruleAbstractMetamodelDeclaration"
    // InternalXtextGrammarTestLanguage.g:154:1: ruleAbstractMetamodelDeclaration : ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) ;
    public final void ruleAbstractMetamodelDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:158:2: ( ( ( rule__AbstractMetamodelDeclaration__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:159:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:159:2: ( ( rule__AbstractMetamodelDeclaration__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:160:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            {
             before(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:161:3: ( rule__AbstractMetamodelDeclaration__Alternatives )
            // InternalXtextGrammarTestLanguage.g:161:4: rule__AbstractMetamodelDeclaration__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractMetamodelDeclaration__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractMetamodelDeclarationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractMetamodelDeclaration"


    // $ANTLR start "entryRuleGeneratedMetamodel"
    // InternalXtextGrammarTestLanguage.g:170:1: entryRuleGeneratedMetamodel : ruleGeneratedMetamodel EOF ;
    public final void entryRuleGeneratedMetamodel() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:171:1: ( ruleGeneratedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:172:1: ruleGeneratedMetamodel EOF
            {
             before(grammarAccess.getGeneratedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGeneratedMetamodel();

            state._fsp--;

             after(grammarAccess.getGeneratedMetamodelRule()); 
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
    // $ANTLR end "entryRuleGeneratedMetamodel"


    // $ANTLR start "ruleGeneratedMetamodel"
    // InternalXtextGrammarTestLanguage.g:179:1: ruleGeneratedMetamodel : ( ( rule__GeneratedMetamodel__Group__0 ) ) ;
    public final void ruleGeneratedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:183:2: ( ( ( rule__GeneratedMetamodel__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:184:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:184:2: ( ( rule__GeneratedMetamodel__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:185:3: ( rule__GeneratedMetamodel__Group__0 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:186:3: ( rule__GeneratedMetamodel__Group__0 )
            // InternalXtextGrammarTestLanguage.g:186:4: rule__GeneratedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGeneratedMetamodel"


    // $ANTLR start "entryRuleReferencedMetamodel"
    // InternalXtextGrammarTestLanguage.g:195:1: entryRuleReferencedMetamodel : ruleReferencedMetamodel EOF ;
    public final void entryRuleReferencedMetamodel() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:196:1: ( ruleReferencedMetamodel EOF )
            // InternalXtextGrammarTestLanguage.g:197:1: ruleReferencedMetamodel EOF
            {
             before(grammarAccess.getReferencedMetamodelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleReferencedMetamodel();

            state._fsp--;

             after(grammarAccess.getReferencedMetamodelRule()); 
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
    // $ANTLR end "entryRuleReferencedMetamodel"


    // $ANTLR start "ruleReferencedMetamodel"
    // InternalXtextGrammarTestLanguage.g:204:1: ruleReferencedMetamodel : ( ( rule__ReferencedMetamodel__Group__0 ) ) ;
    public final void ruleReferencedMetamodel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:208:2: ( ( ( rule__ReferencedMetamodel__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:209:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:209:2: ( ( rule__ReferencedMetamodel__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:210:3: ( rule__ReferencedMetamodel__Group__0 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:211:3: ( rule__ReferencedMetamodel__Group__0 )
            // InternalXtextGrammarTestLanguage.g:211:4: rule__ReferencedMetamodel__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferencedMetamodel"


    // $ANTLR start "entryRuleParserRule"
    // InternalXtextGrammarTestLanguage.g:220:1: entryRuleParserRule : ruleParserRule EOF ;
    public final void entryRuleParserRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:221:1: ( ruleParserRule EOF )
            // InternalXtextGrammarTestLanguage.g:222:1: ruleParserRule EOF
            {
             before(grammarAccess.getParserRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParserRule();

            state._fsp--;

             after(grammarAccess.getParserRuleRule()); 
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
    // $ANTLR end "entryRuleParserRule"


    // $ANTLR start "ruleParserRule"
    // InternalXtextGrammarTestLanguage.g:229:1: ruleParserRule : ( ( rule__ParserRule__Group__0 ) ) ;
    public final void ruleParserRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:233:2: ( ( ( rule__ParserRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:234:2: ( ( rule__ParserRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:234:2: ( ( rule__ParserRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:235:3: ( rule__ParserRule__Group__0 )
            {
             before(grammarAccess.getParserRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:236:3: ( rule__ParserRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:236:4: rule__ParserRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParserRule"


    // $ANTLR start "ruleRuleNameAndParams"
    // InternalXtextGrammarTestLanguage.g:246:1: ruleRuleNameAndParams : ( ( rule__RuleNameAndParams__Group__0 ) ) ;
    public final void ruleRuleNameAndParams() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:250:2: ( ( ( rule__RuleNameAndParams__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:251:2: ( ( rule__RuleNameAndParams__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:251:2: ( ( rule__RuleNameAndParams__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:252:3: ( rule__RuleNameAndParams__Group__0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:253:3: ( rule__RuleNameAndParams__Group__0 )
            // InternalXtextGrammarTestLanguage.g:253:4: rule__RuleNameAndParams__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleNameAndParams"


    // $ANTLR start "ruleReturnsClause"
    // InternalXtextGrammarTestLanguage.g:263:1: ruleReturnsClause : ( ( rule__ReturnsClause__Group__0 ) ) ;
    public final void ruleReturnsClause() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:267:2: ( ( ( rule__ReturnsClause__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:268:2: ( ( rule__ReturnsClause__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:268:2: ( ( rule__ReturnsClause__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:269:3: ( rule__ReturnsClause__Group__0 )
            {
             before(grammarAccess.getReturnsClauseAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:270:3: ( rule__ReturnsClause__Group__0 )
            // InternalXtextGrammarTestLanguage.g:270:4: rule__ReturnsClause__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReturnsClause__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReturnsClauseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReturnsClause"


    // $ANTLR start "entryRuleParameter"
    // InternalXtextGrammarTestLanguage.g:279:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:280:1: ( ruleParameter EOF )
            // InternalXtextGrammarTestLanguage.g:281:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalXtextGrammarTestLanguage.g:288:1: ruleParameter : ( ( rule__Parameter__NameAssignment ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:292:2: ( ( ( rule__Parameter__NameAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:293:2: ( ( rule__Parameter__NameAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:293:2: ( ( rule__Parameter__NameAssignment ) )
            // InternalXtextGrammarTestLanguage.g:294:3: ( rule__Parameter__NameAssignment )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment()); 
            // InternalXtextGrammarTestLanguage.g:295:3: ( rule__Parameter__NameAssignment )
            // InternalXtextGrammarTestLanguage.g:295:4: rule__Parameter__NameAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Parameter__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleTypeRef"
    // InternalXtextGrammarTestLanguage.g:304:1: entryRuleTypeRef : ruleTypeRef EOF ;
    public final void entryRuleTypeRef() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:305:1: ( ruleTypeRef EOF )
            // InternalXtextGrammarTestLanguage.g:306:1: ruleTypeRef EOF
            {
             before(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getTypeRefRule()); 
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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalXtextGrammarTestLanguage.g:313:1: ruleTypeRef : ( ( rule__TypeRef__Group__0 ) ) ;
    public final void ruleTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:317:2: ( ( ( rule__TypeRef__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:318:2: ( ( rule__TypeRef__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:318:2: ( ( rule__TypeRef__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:319:3: ( rule__TypeRef__Group__0 )
            {
             before(grammarAccess.getTypeRefAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:320:3: ( rule__TypeRef__Group__0 )
            // InternalXtextGrammarTestLanguage.g:320:4: rule__TypeRef__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleAlternatives"
    // InternalXtextGrammarTestLanguage.g:329:1: entryRuleAlternatives : ruleAlternatives EOF ;
    public final void entryRuleAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:330:1: ( ruleAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:331:1: ruleAlternatives EOF
            {
             before(grammarAccess.getAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getAlternativesRule()); 
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
    // $ANTLR end "entryRuleAlternatives"


    // $ANTLR start "ruleAlternatives"
    // InternalXtextGrammarTestLanguage.g:338:1: ruleAlternatives : ( ( rule__Alternatives__Group__0 ) ) ;
    public final void ruleAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:342:2: ( ( ( rule__Alternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:343:2: ( ( rule__Alternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:343:2: ( ( rule__Alternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:344:3: ( rule__Alternatives__Group__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:345:3: ( rule__Alternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:345:4: rule__Alternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternatives"


    // $ANTLR start "entryRuleConditionalBranch"
    // InternalXtextGrammarTestLanguage.g:354:1: entryRuleConditionalBranch : ruleConditionalBranch EOF ;
    public final void entryRuleConditionalBranch() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:355:1: ( ruleConditionalBranch EOF )
            // InternalXtextGrammarTestLanguage.g:356:1: ruleConditionalBranch EOF
            {
             before(grammarAccess.getConditionalBranchRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getConditionalBranchRule()); 
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
    // $ANTLR end "entryRuleConditionalBranch"


    // $ANTLR start "ruleConditionalBranch"
    // InternalXtextGrammarTestLanguage.g:363:1: ruleConditionalBranch : ( ( rule__ConditionalBranch__Alternatives ) ) ;
    public final void ruleConditionalBranch() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:367:2: ( ( ( rule__ConditionalBranch__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:368:2: ( ( rule__ConditionalBranch__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:368:2: ( ( rule__ConditionalBranch__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:369:3: ( rule__ConditionalBranch__Alternatives )
            {
             before(grammarAccess.getConditionalBranchAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:370:3: ( rule__ConditionalBranch__Alternatives )
            // InternalXtextGrammarTestLanguage.g:370:4: rule__ConditionalBranch__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditionalBranch"


    // $ANTLR start "entryRuleUnorderedGroup"
    // InternalXtextGrammarTestLanguage.g:379:1: entryRuleUnorderedGroup : ruleUnorderedGroup EOF ;
    public final void entryRuleUnorderedGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:380:1: ( ruleUnorderedGroup EOF )
            // InternalXtextGrammarTestLanguage.g:381:1: ruleUnorderedGroup EOF
            {
             before(grammarAccess.getUnorderedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUnorderedGroup();

            state._fsp--;

             after(grammarAccess.getUnorderedGroupRule()); 
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
    // $ANTLR end "entryRuleUnorderedGroup"


    // $ANTLR start "ruleUnorderedGroup"
    // InternalXtextGrammarTestLanguage.g:388:1: ruleUnorderedGroup : ( ( rule__UnorderedGroup__Group__0 ) ) ;
    public final void ruleUnorderedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:392:2: ( ( ( rule__UnorderedGroup__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:393:2: ( ( rule__UnorderedGroup__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:393:2: ( ( rule__UnorderedGroup__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:394:3: ( rule__UnorderedGroup__Group__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:395:3: ( rule__UnorderedGroup__Group__0 )
            // InternalXtextGrammarTestLanguage.g:395:4: rule__UnorderedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnorderedGroup"


    // $ANTLR start "entryRuleGroup"
    // InternalXtextGrammarTestLanguage.g:404:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:405:1: ( ruleGroup EOF )
            // InternalXtextGrammarTestLanguage.g:406:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getGroupRule()); 
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
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalXtextGrammarTestLanguage.g:413:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:417:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:418:2: ( ( rule__Group__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:418:2: ( ( rule__Group__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:419:3: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:420:3: ( rule__Group__Group__0 )
            // InternalXtextGrammarTestLanguage.g:420:4: rule__Group__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleAbstractToken"
    // InternalXtextGrammarTestLanguage.g:429:1: entryRuleAbstractToken : ruleAbstractToken EOF ;
    public final void entryRuleAbstractToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:430:1: ( ruleAbstractToken EOF )
            // InternalXtextGrammarTestLanguage.g:431:1: ruleAbstractToken EOF
            {
             before(grammarAccess.getAbstractTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getAbstractTokenRule()); 
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
    // $ANTLR end "entryRuleAbstractToken"


    // $ANTLR start "ruleAbstractToken"
    // InternalXtextGrammarTestLanguage.g:438:1: ruleAbstractToken : ( ( rule__AbstractToken__Alternatives ) ) ;
    public final void ruleAbstractToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:442:2: ( ( ( rule__AbstractToken__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:443:2: ( ( rule__AbstractToken__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:443:2: ( ( rule__AbstractToken__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:444:3: ( rule__AbstractToken__Alternatives )
            {
             before(grammarAccess.getAbstractTokenAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:445:3: ( rule__AbstractToken__Alternatives )
            // InternalXtextGrammarTestLanguage.g:445:4: rule__AbstractToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractToken__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTokenAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractToken"


    // $ANTLR start "entryRuleAbstractTokenWithCardinality"
    // InternalXtextGrammarTestLanguage.g:454:1: entryRuleAbstractTokenWithCardinality : ruleAbstractTokenWithCardinality EOF ;
    public final void entryRuleAbstractTokenWithCardinality() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:455:1: ( ruleAbstractTokenWithCardinality EOF )
            // InternalXtextGrammarTestLanguage.g:456:1: ruleAbstractTokenWithCardinality EOF
            {
             before(grammarAccess.getAbstractTokenWithCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTokenWithCardinality();

            state._fsp--;

             after(grammarAccess.getAbstractTokenWithCardinalityRule()); 
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
    // $ANTLR end "entryRuleAbstractTokenWithCardinality"


    // $ANTLR start "ruleAbstractTokenWithCardinality"
    // InternalXtextGrammarTestLanguage.g:463:1: ruleAbstractTokenWithCardinality : ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) ;
    public final void ruleAbstractTokenWithCardinality() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:467:2: ( ( ( rule__AbstractTokenWithCardinality__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:468:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:468:2: ( ( rule__AbstractTokenWithCardinality__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:469:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:470:3: ( rule__AbstractTokenWithCardinality__Group__0 )
            // InternalXtextGrammarTestLanguage.g:470:4: rule__AbstractTokenWithCardinality__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractTokenWithCardinality"


    // $ANTLR start "ruleCardinalities"
    // InternalXtextGrammarTestLanguage.g:480:1: ruleCardinalities : ( ( rule__Cardinalities__CardinalityAssignment ) ) ;
    public final void ruleCardinalities() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:484:2: ( ( ( rule__Cardinalities__CardinalityAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:485:2: ( ( rule__Cardinalities__CardinalityAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:485:2: ( ( rule__Cardinalities__CardinalityAssignment ) )
            // InternalXtextGrammarTestLanguage.g:486:3: ( rule__Cardinalities__CardinalityAssignment )
            {
             before(grammarAccess.getCardinalitiesAccess().getCardinalityAssignment()); 
            // InternalXtextGrammarTestLanguage.g:487:3: ( rule__Cardinalities__CardinalityAssignment )
            // InternalXtextGrammarTestLanguage.g:487:4: rule__Cardinalities__CardinalityAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Cardinalities__CardinalityAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCardinalitiesAccess().getCardinalityAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCardinalities"


    // $ANTLR start "entryRuleAction"
    // InternalXtextGrammarTestLanguage.g:496:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:497:1: ( ruleAction EOF )
            // InternalXtextGrammarTestLanguage.g:498:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalXtextGrammarTestLanguage.g:505:1: ruleAction : ( ( rule__Action__Group__0 ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:509:2: ( ( ( rule__Action__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:510:2: ( ( rule__Action__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:510:2: ( ( rule__Action__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:511:3: ( rule__Action__Group__0 )
            {
             before(grammarAccess.getActionAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:512:3: ( rule__Action__Group__0 )
            // InternalXtextGrammarTestLanguage.g:512:4: rule__Action__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleAbstractTerminal"
    // InternalXtextGrammarTestLanguage.g:521:1: entryRuleAbstractTerminal : ruleAbstractTerminal EOF ;
    public final void entryRuleAbstractTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:522:1: ( ruleAbstractTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:523:1: ruleAbstractTerminal EOF
            {
             before(grammarAccess.getAbstractTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractTerminal();

            state._fsp--;

             after(grammarAccess.getAbstractTerminalRule()); 
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
    // $ANTLR end "entryRuleAbstractTerminal"


    // $ANTLR start "ruleAbstractTerminal"
    // InternalXtextGrammarTestLanguage.g:530:1: ruleAbstractTerminal : ( ( rule__AbstractTerminal__Alternatives ) ) ;
    public final void ruleAbstractTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:534:2: ( ( ( rule__AbstractTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:535:2: ( ( rule__AbstractTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:535:2: ( ( rule__AbstractTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:536:3: ( rule__AbstractTerminal__Alternatives )
            {
             before(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:537:3: ( rule__AbstractTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:537:4: rule__AbstractTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTerminal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTerminalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractTerminal"


    // $ANTLR start "entryRuleKeyword"
    // InternalXtextGrammarTestLanguage.g:546:1: entryRuleKeyword : ruleKeyword EOF ;
    public final void entryRuleKeyword() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:547:1: ( ruleKeyword EOF )
            // InternalXtextGrammarTestLanguage.g:548:1: ruleKeyword EOF
            {
             before(grammarAccess.getKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getKeywordRule()); 
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
    // $ANTLR end "entryRuleKeyword"


    // $ANTLR start "ruleKeyword"
    // InternalXtextGrammarTestLanguage.g:555:1: ruleKeyword : ( ( rule__Keyword__ValueAssignment ) ) ;
    public final void ruleKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:559:2: ( ( ( rule__Keyword__ValueAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:560:2: ( ( rule__Keyword__ValueAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:560:2: ( ( rule__Keyword__ValueAssignment ) )
            // InternalXtextGrammarTestLanguage.g:561:3: ( rule__Keyword__ValueAssignment )
            {
             before(grammarAccess.getKeywordAccess().getValueAssignment()); 
            // InternalXtextGrammarTestLanguage.g:562:3: ( rule__Keyword__ValueAssignment )
            // InternalXtextGrammarTestLanguage.g:562:4: rule__Keyword__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Keyword__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getKeywordAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyword"


    // $ANTLR start "entryRuleRuleCall"
    // InternalXtextGrammarTestLanguage.g:571:1: entryRuleRuleCall : ruleRuleCall EOF ;
    public final void entryRuleRuleCall() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:572:1: ( ruleRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:573:1: ruleRuleCall EOF
            {
             before(grammarAccess.getRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleCall();

            state._fsp--;

             after(grammarAccess.getRuleCallRule()); 
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
    // $ANTLR end "entryRuleRuleCall"


    // $ANTLR start "ruleRuleCall"
    // InternalXtextGrammarTestLanguage.g:580:1: ruleRuleCall : ( ( rule__RuleCall__Group__0 ) ) ;
    public final void ruleRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:584:2: ( ( ( rule__RuleCall__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:585:2: ( ( rule__RuleCall__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:585:2: ( ( rule__RuleCall__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:586:3: ( rule__RuleCall__Group__0 )
            {
             before(grammarAccess.getRuleCallAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:587:3: ( rule__RuleCall__Group__0 )
            // InternalXtextGrammarTestLanguage.g:587:4: rule__RuleCall__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleCall"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalXtextGrammarTestLanguage.g:596:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:597:1: ( ruleLiteralValue EOF )
            // InternalXtextGrammarTestLanguage.g:598:1: ruleLiteralValue EOF
            {
             before(grammarAccess.getLiteralValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getLiteralValueRule()); 
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
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // InternalXtextGrammarTestLanguage.g:605:1: ruleLiteralValue : ( ( rule__LiteralValue__Alternatives ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:609:2: ( ( ( rule__LiteralValue__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:610:2: ( ( rule__LiteralValue__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:610:2: ( ( rule__LiteralValue__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:611:3: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:612:3: ( rule__LiteralValue__Alternatives )
            // InternalXtextGrammarTestLanguage.g:612:4: rule__LiteralValue__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleInverseLiteralValue"
    // InternalXtextGrammarTestLanguage.g:621:1: entryRuleInverseLiteralValue : ruleInverseLiteralValue EOF ;
    public final void entryRuleInverseLiteralValue() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:622:1: ( ruleInverseLiteralValue EOF )
            // InternalXtextGrammarTestLanguage.g:623:1: ruleInverseLiteralValue EOF
            {
             before(grammarAccess.getInverseLiteralValueRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleInverseLiteralValue();

            state._fsp--;

             after(grammarAccess.getInverseLiteralValueRule()); 
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
    // $ANTLR end "entryRuleInverseLiteralValue"


    // $ANTLR start "ruleInverseLiteralValue"
    // InternalXtextGrammarTestLanguage.g:630:1: ruleInverseLiteralValue : ( ruleLiteralValue ) ;
    public final void ruleInverseLiteralValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:634:2: ( ( ruleLiteralValue ) )
            // InternalXtextGrammarTestLanguage.g:635:2: ( ruleLiteralValue )
            {
            // InternalXtextGrammarTestLanguage.g:635:2: ( ruleLiteralValue )
            // InternalXtextGrammarTestLanguage.g:636:3: ruleLiteralValue
            {
             before(grammarAccess.getInverseLiteralValueAccess().getLiteralValueParserRuleCall()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getInverseLiteralValueAccess().getLiteralValueParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInverseLiteralValue"


    // $ANTLR start "entryRuleNamedArgument"
    // InternalXtextGrammarTestLanguage.g:646:1: entryRuleNamedArgument : ruleNamedArgument EOF ;
    public final void entryRuleNamedArgument() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:647:1: ( ruleNamedArgument EOF )
            // InternalXtextGrammarTestLanguage.g:648:1: ruleNamedArgument EOF
            {
             before(grammarAccess.getNamedArgumentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getNamedArgumentRule()); 
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
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // InternalXtextGrammarTestLanguage.g:655:1: ruleNamedArgument : ( ( rule__NamedArgument__Group__0 ) ) ;
    public final void ruleNamedArgument() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:659:2: ( ( ( rule__NamedArgument__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:660:2: ( ( rule__NamedArgument__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:660:2: ( ( rule__NamedArgument__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:661:3: ( rule__NamedArgument__Group__0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:662:3: ( rule__NamedArgument__Group__0 )
            // InternalXtextGrammarTestLanguage.g:662:4: rule__NamedArgument__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleTerminalRuleCall"
    // InternalXtextGrammarTestLanguage.g:671:1: entryRuleTerminalRuleCall : ruleTerminalRuleCall EOF ;
    public final void entryRuleTerminalRuleCall() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:672:1: ( ruleTerminalRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:673:1: ruleTerminalRuleCall EOF
            {
             before(grammarAccess.getTerminalRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRuleCall();

            state._fsp--;

             after(grammarAccess.getTerminalRuleCallRule()); 
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
    // $ANTLR end "entryRuleTerminalRuleCall"


    // $ANTLR start "ruleTerminalRuleCall"
    // InternalXtextGrammarTestLanguage.g:680:1: ruleTerminalRuleCall : ( ( rule__TerminalRuleCall__RuleAssignment ) ) ;
    public final void ruleTerminalRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:684:2: ( ( ( rule__TerminalRuleCall__RuleAssignment ) ) )
            // InternalXtextGrammarTestLanguage.g:685:2: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            {
            // InternalXtextGrammarTestLanguage.g:685:2: ( ( rule__TerminalRuleCall__RuleAssignment ) )
            // InternalXtextGrammarTestLanguage.g:686:3: ( rule__TerminalRuleCall__RuleAssignment )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); 
            // InternalXtextGrammarTestLanguage.g:687:3: ( rule__TerminalRuleCall__RuleAssignment )
            // InternalXtextGrammarTestLanguage.g:687:4: rule__TerminalRuleCall__RuleAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRuleCall__RuleAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalRuleCall"


    // $ANTLR start "entryRuleRuleID"
    // InternalXtextGrammarTestLanguage.g:696:1: entryRuleRuleID : ruleRuleID EOF ;
    public final void entryRuleRuleID() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:697:1: ( ruleRuleID EOF )
            // InternalXtextGrammarTestLanguage.g:698:1: ruleRuleID EOF
            {
             before(grammarAccess.getRuleIDRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getRuleIDRule()); 
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
    // $ANTLR end "entryRuleRuleID"


    // $ANTLR start "ruleRuleID"
    // InternalXtextGrammarTestLanguage.g:705:1: ruleRuleID : ( ( rule__RuleID__Group__0 ) ) ;
    public final void ruleRuleID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:709:2: ( ( ( rule__RuleID__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:710:2: ( ( rule__RuleID__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:710:2: ( ( rule__RuleID__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:711:3: ( rule__RuleID__Group__0 )
            {
             before(grammarAccess.getRuleIDAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:712:3: ( rule__RuleID__Group__0 )
            // InternalXtextGrammarTestLanguage.g:712:4: rule__RuleID__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleID"


    // $ANTLR start "entryRulePredicatedKeyword"
    // InternalXtextGrammarTestLanguage.g:721:1: entryRulePredicatedKeyword : rulePredicatedKeyword EOF ;
    public final void entryRulePredicatedKeyword() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:722:1: ( rulePredicatedKeyword EOF )
            // InternalXtextGrammarTestLanguage.g:723:1: rulePredicatedKeyword EOF
            {
             before(grammarAccess.getPredicatedKeywordRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedKeyword();

            state._fsp--;

             after(grammarAccess.getPredicatedKeywordRule()); 
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
    // $ANTLR end "entryRulePredicatedKeyword"


    // $ANTLR start "rulePredicatedKeyword"
    // InternalXtextGrammarTestLanguage.g:730:1: rulePredicatedKeyword : ( ( rule__PredicatedKeyword__Group__0 ) ) ;
    public final void rulePredicatedKeyword() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:734:2: ( ( ( rule__PredicatedKeyword__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:735:2: ( ( rule__PredicatedKeyword__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:735:2: ( ( rule__PredicatedKeyword__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:736:3: ( rule__PredicatedKeyword__Group__0 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:737:3: ( rule__PredicatedKeyword__Group__0 )
            // InternalXtextGrammarTestLanguage.g:737:4: rule__PredicatedKeyword__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedKeyword"


    // $ANTLR start "entryRulePredicatedRuleCall"
    // InternalXtextGrammarTestLanguage.g:746:1: entryRulePredicatedRuleCall : rulePredicatedRuleCall EOF ;
    public final void entryRulePredicatedRuleCall() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:747:1: ( rulePredicatedRuleCall EOF )
            // InternalXtextGrammarTestLanguage.g:748:1: rulePredicatedRuleCall EOF
            {
             before(grammarAccess.getPredicatedRuleCallRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedRuleCall();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallRule()); 
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
    // $ANTLR end "entryRulePredicatedRuleCall"


    // $ANTLR start "rulePredicatedRuleCall"
    // InternalXtextGrammarTestLanguage.g:755:1: rulePredicatedRuleCall : ( ( rule__PredicatedRuleCall__Group__0 ) ) ;
    public final void rulePredicatedRuleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:759:2: ( ( ( rule__PredicatedRuleCall__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:760:2: ( ( rule__PredicatedRuleCall__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:760:2: ( ( rule__PredicatedRuleCall__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:761:3: ( rule__PredicatedRuleCall__Group__0 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:762:3: ( rule__PredicatedRuleCall__Group__0 )
            // InternalXtextGrammarTestLanguage.g:762:4: rule__PredicatedRuleCall__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedRuleCall"


    // $ANTLR start "entryRuleAssignment"
    // InternalXtextGrammarTestLanguage.g:771:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:772:1: ( ruleAssignment EOF )
            // InternalXtextGrammarTestLanguage.g:773:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalXtextGrammarTestLanguage.g:780:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:784:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:785:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:785:2: ( ( rule__Assignment__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:786:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:787:3: ( rule__Assignment__Group__0 )
            // InternalXtextGrammarTestLanguage.g:787:4: rule__Assignment__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "rulePredicate"
    // InternalXtextGrammarTestLanguage.g:797:1: rulePredicate : ( ( rule__Predicate__Alternatives ) ) ;
    public final void rulePredicate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:801:2: ( ( ( rule__Predicate__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:802:2: ( ( rule__Predicate__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:802:2: ( ( rule__Predicate__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:803:3: ( rule__Predicate__Alternatives )
            {
             before(grammarAccess.getPredicateAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:804:3: ( rule__Predicate__Alternatives )
            // InternalXtextGrammarTestLanguage.g:804:4: rule__Predicate__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Predicate__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPredicateAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleAssignableTerminal"
    // InternalXtextGrammarTestLanguage.g:813:1: entryRuleAssignableTerminal : ruleAssignableTerminal EOF ;
    public final void entryRuleAssignableTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:814:1: ( ruleAssignableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:815:1: ruleAssignableTerminal EOF
            {
             before(grammarAccess.getAssignableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableTerminalRule()); 
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
    // $ANTLR end "entryRuleAssignableTerminal"


    // $ANTLR start "ruleAssignableTerminal"
    // InternalXtextGrammarTestLanguage.g:822:1: ruleAssignableTerminal : ( ( rule__AssignableTerminal__Alternatives ) ) ;
    public final void ruleAssignableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:826:2: ( ( ( rule__AssignableTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:827:2: ( ( rule__AssignableTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:827:2: ( ( rule__AssignableTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:828:3: ( rule__AssignableTerminal__Alternatives )
            {
             before(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:829:3: ( rule__AssignableTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:829:4: rule__AssignableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableTerminal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAssignableTerminalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignableTerminal"


    // $ANTLR start "entryRuleParenthesizedAssignableElement"
    // InternalXtextGrammarTestLanguage.g:838:1: entryRuleParenthesizedAssignableElement : ruleParenthesizedAssignableElement EOF ;
    public final void entryRuleParenthesizedAssignableElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:839:1: ( ruleParenthesizedAssignableElement EOF )
            // InternalXtextGrammarTestLanguage.g:840:1: ruleParenthesizedAssignableElement EOF
            {
             before(grammarAccess.getParenthesizedAssignableElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedAssignableElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedAssignableElementRule()); 
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
    // $ANTLR end "entryRuleParenthesizedAssignableElement"


    // $ANTLR start "ruleParenthesizedAssignableElement"
    // InternalXtextGrammarTestLanguage.g:847:1: ruleParenthesizedAssignableElement : ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) ;
    public final void ruleParenthesizedAssignableElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:851:2: ( ( ( rule__ParenthesizedAssignableElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:852:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:852:2: ( ( rule__ParenthesizedAssignableElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:853:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:854:3: ( rule__ParenthesizedAssignableElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:854:4: rule__ParenthesizedAssignableElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedAssignableElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedAssignableElement"


    // $ANTLR start "entryRuleAssignableAlternatives"
    // InternalXtextGrammarTestLanguage.g:863:1: entryRuleAssignableAlternatives : ruleAssignableAlternatives EOF ;
    public final void entryRuleAssignableAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:864:1: ( ruleAssignableAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:865:1: ruleAssignableAlternatives EOF
            {
             before(grammarAccess.getAssignableAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignableAlternatives();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesRule()); 
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
    // $ANTLR end "entryRuleAssignableAlternatives"


    // $ANTLR start "ruleAssignableAlternatives"
    // InternalXtextGrammarTestLanguage.g:872:1: ruleAssignableAlternatives : ( ( rule__AssignableAlternatives__Group__0 ) ) ;
    public final void ruleAssignableAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:876:2: ( ( ( rule__AssignableAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:877:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:877:2: ( ( rule__AssignableAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:878:3: ( rule__AssignableAlternatives__Group__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:879:3: ( rule__AssignableAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:879:4: rule__AssignableAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignableAlternatives"


    // $ANTLR start "entryRuleCrossReference"
    // InternalXtextGrammarTestLanguage.g:888:1: entryRuleCrossReference : ruleCrossReference EOF ;
    public final void entryRuleCrossReference() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:889:1: ( ruleCrossReference EOF )
            // InternalXtextGrammarTestLanguage.g:890:1: ruleCrossReference EOF
            {
             before(grammarAccess.getCrossReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReference();

            state._fsp--;

             after(grammarAccess.getCrossReferenceRule()); 
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
    // $ANTLR end "entryRuleCrossReference"


    // $ANTLR start "ruleCrossReference"
    // InternalXtextGrammarTestLanguage.g:897:1: ruleCrossReference : ( ( rule__CrossReference__Group__0 ) ) ;
    public final void ruleCrossReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:901:2: ( ( ( rule__CrossReference__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:902:2: ( ( rule__CrossReference__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:902:2: ( ( rule__CrossReference__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:903:3: ( rule__CrossReference__Group__0 )
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:904:3: ( rule__CrossReference__Group__0 )
            // InternalXtextGrammarTestLanguage.g:904:4: rule__CrossReference__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCrossReference"


    // $ANTLR start "entryRuleCrossReferenceableTerminal"
    // InternalXtextGrammarTestLanguage.g:913:1: entryRuleCrossReferenceableTerminal : ruleCrossReferenceableTerminal EOF ;
    public final void entryRuleCrossReferenceableTerminal() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:914:1: ( ruleCrossReferenceableTerminal EOF )
            // InternalXtextGrammarTestLanguage.g:915:1: ruleCrossReferenceableTerminal EOF
            {
             before(grammarAccess.getCrossReferenceableTerminalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCrossReferenceableTerminal();

            state._fsp--;

             after(grammarAccess.getCrossReferenceableTerminalRule()); 
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
    // $ANTLR end "entryRuleCrossReferenceableTerminal"


    // $ANTLR start "ruleCrossReferenceableTerminal"
    // InternalXtextGrammarTestLanguage.g:922:1: ruleCrossReferenceableTerminal : ( ( rule__CrossReferenceableTerminal__Alternatives ) ) ;
    public final void ruleCrossReferenceableTerminal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:926:2: ( ( ( rule__CrossReferenceableTerminal__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:927:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:927:2: ( ( rule__CrossReferenceableTerminal__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:928:3: ( rule__CrossReferenceableTerminal__Alternatives )
            {
             before(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:929:3: ( rule__CrossReferenceableTerminal__Alternatives )
            // InternalXtextGrammarTestLanguage.g:929:4: rule__CrossReferenceableTerminal__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReferenceableTerminal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceableTerminalAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCrossReferenceableTerminal"


    // $ANTLR start "entryRuleParenthesizedElement"
    // InternalXtextGrammarTestLanguage.g:938:1: entryRuleParenthesizedElement : ruleParenthesizedElement EOF ;
    public final void entryRuleParenthesizedElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:939:1: ( ruleParenthesizedElement EOF )
            // InternalXtextGrammarTestLanguage.g:940:1: ruleParenthesizedElement EOF
            {
             before(grammarAccess.getParenthesizedElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedElementRule()); 
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
    // $ANTLR end "entryRuleParenthesizedElement"


    // $ANTLR start "ruleParenthesizedElement"
    // InternalXtextGrammarTestLanguage.g:947:1: ruleParenthesizedElement : ( ( rule__ParenthesizedElement__Group__0 ) ) ;
    public final void ruleParenthesizedElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:951:2: ( ( ( rule__ParenthesizedElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:952:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:952:2: ( ( rule__ParenthesizedElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:953:3: ( rule__ParenthesizedElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:954:3: ( rule__ParenthesizedElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:954:4: rule__ParenthesizedElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedElement"


    // $ANTLR start "entryRulePredicatedGroup"
    // InternalXtextGrammarTestLanguage.g:963:1: entryRulePredicatedGroup : rulePredicatedGroup EOF ;
    public final void entryRulePredicatedGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:964:1: ( rulePredicatedGroup EOF )
            // InternalXtextGrammarTestLanguage.g:965:1: rulePredicatedGroup EOF
            {
             before(grammarAccess.getPredicatedGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            rulePredicatedGroup();

            state._fsp--;

             after(grammarAccess.getPredicatedGroupRule()); 
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
    // $ANTLR end "entryRulePredicatedGroup"


    // $ANTLR start "rulePredicatedGroup"
    // InternalXtextGrammarTestLanguage.g:972:1: rulePredicatedGroup : ( ( rule__PredicatedGroup__Group__0 ) ) ;
    public final void rulePredicatedGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:976:2: ( ( ( rule__PredicatedGroup__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:977:2: ( ( rule__PredicatedGroup__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:977:2: ( ( rule__PredicatedGroup__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:978:3: ( rule__PredicatedGroup__Group__0 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:979:3: ( rule__PredicatedGroup__Group__0 )
            // InternalXtextGrammarTestLanguage.g:979:4: rule__PredicatedGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePredicatedGroup"


    // $ANTLR start "entryRuleTerminalRule"
    // InternalXtextGrammarTestLanguage.g:988:1: entryRuleTerminalRule : ruleTerminalRule EOF ;
    public final void entryRuleTerminalRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:989:1: ( ruleTerminalRule EOF )
            // InternalXtextGrammarTestLanguage.g:990:1: ruleTerminalRule EOF
            {
             before(grammarAccess.getTerminalRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalRule();

            state._fsp--;

             after(grammarAccess.getTerminalRuleRule()); 
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
    // $ANTLR end "entryRuleTerminalRule"


    // $ANTLR start "ruleTerminalRule"
    // InternalXtextGrammarTestLanguage.g:997:1: ruleTerminalRule : ( ( rule__TerminalRule__Group__0 ) ) ;
    public final void ruleTerminalRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1001:2: ( ( ( rule__TerminalRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1002:2: ( ( rule__TerminalRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1002:2: ( ( rule__TerminalRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1003:3: ( rule__TerminalRule__Group__0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1004:3: ( rule__TerminalRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1004:4: rule__TerminalRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalRule"


    // $ANTLR start "entryRuleTerminalAlternatives"
    // InternalXtextGrammarTestLanguage.g:1013:1: entryRuleTerminalAlternatives : ruleTerminalAlternatives EOF ;
    public final void entryRuleTerminalAlternatives() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1014:1: ( ruleTerminalAlternatives EOF )
            // InternalXtextGrammarTestLanguage.g:1015:1: ruleTerminalAlternatives EOF
            {
             before(grammarAccess.getTerminalAlternativesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesRule()); 
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
    // $ANTLR end "entryRuleTerminalAlternatives"


    // $ANTLR start "ruleTerminalAlternatives"
    // InternalXtextGrammarTestLanguage.g:1022:1: ruleTerminalAlternatives : ( ( rule__TerminalAlternatives__Group__0 ) ) ;
    public final void ruleTerminalAlternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1026:2: ( ( ( rule__TerminalAlternatives__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1027:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1027:2: ( ( rule__TerminalAlternatives__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1028:3: ( rule__TerminalAlternatives__Group__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1029:3: ( rule__TerminalAlternatives__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1029:4: rule__TerminalAlternatives__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalAlternatives"


    // $ANTLR start "entryRuleTerminalGroup"
    // InternalXtextGrammarTestLanguage.g:1038:1: entryRuleTerminalGroup : ruleTerminalGroup EOF ;
    public final void entryRuleTerminalGroup() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1039:1: ( ruleTerminalGroup EOF )
            // InternalXtextGrammarTestLanguage.g:1040:1: ruleTerminalGroup EOF
            {
             before(grammarAccess.getTerminalGroupRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalGroupRule()); 
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
    // $ANTLR end "entryRuleTerminalGroup"


    // $ANTLR start "ruleTerminalGroup"
    // InternalXtextGrammarTestLanguage.g:1047:1: ruleTerminalGroup : ( ( rule__TerminalGroup__Group__0 ) ) ;
    public final void ruleTerminalGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1051:2: ( ( ( rule__TerminalGroup__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1052:2: ( ( rule__TerminalGroup__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1052:2: ( ( rule__TerminalGroup__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1053:3: ( rule__TerminalGroup__Group__0 )
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1054:3: ( rule__TerminalGroup__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1054:4: rule__TerminalGroup__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalGroup"


    // $ANTLR start "entryRuleTerminalToken"
    // InternalXtextGrammarTestLanguage.g:1063:1: entryRuleTerminalToken : ruleTerminalToken EOF ;
    public final void entryRuleTerminalToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1064:1: ( ruleTerminalToken EOF )
            // InternalXtextGrammarTestLanguage.g:1065:1: ruleTerminalToken EOF
            {
             before(grammarAccess.getTerminalTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalTokenRule()); 
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
    // $ANTLR end "entryRuleTerminalToken"


    // $ANTLR start "ruleTerminalToken"
    // InternalXtextGrammarTestLanguage.g:1072:1: ruleTerminalToken : ( ( rule__TerminalToken__Group__0 ) ) ;
    public final void ruleTerminalToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1076:2: ( ( ( rule__TerminalToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1077:2: ( ( rule__TerminalToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1077:2: ( ( rule__TerminalToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1078:3: ( rule__TerminalToken__Group__0 )
            {
             before(grammarAccess.getTerminalTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1079:3: ( rule__TerminalToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1079:4: rule__TerminalToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalToken"


    // $ANTLR start "entryRuleTerminalTokenElement"
    // InternalXtextGrammarTestLanguage.g:1088:1: entryRuleTerminalTokenElement : ruleTerminalTokenElement EOF ;
    public final void entryRuleTerminalTokenElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1089:1: ( ruleTerminalTokenElement EOF )
            // InternalXtextGrammarTestLanguage.g:1090:1: ruleTerminalTokenElement EOF
            {
             before(grammarAccess.getTerminalTokenElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getTerminalTokenElementRule()); 
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
    // $ANTLR end "entryRuleTerminalTokenElement"


    // $ANTLR start "ruleTerminalTokenElement"
    // InternalXtextGrammarTestLanguage.g:1097:1: ruleTerminalTokenElement : ( ( rule__TerminalTokenElement__Alternatives ) ) ;
    public final void ruleTerminalTokenElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1101:2: ( ( ( rule__TerminalTokenElement__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:1102:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:1102:2: ( ( rule__TerminalTokenElement__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:1103:3: ( rule__TerminalTokenElement__Alternatives )
            {
             before(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:1104:3: ( rule__TerminalTokenElement__Alternatives )
            // InternalXtextGrammarTestLanguage.g:1104:4: rule__TerminalTokenElement__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalTokenElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTerminalTokenElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTerminalTokenElement"


    // $ANTLR start "entryRuleParenthesizedTerminalElement"
    // InternalXtextGrammarTestLanguage.g:1113:1: entryRuleParenthesizedTerminalElement : ruleParenthesizedTerminalElement EOF ;
    public final void entryRuleParenthesizedTerminalElement() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1114:1: ( ruleParenthesizedTerminalElement EOF )
            // InternalXtextGrammarTestLanguage.g:1115:1: ruleParenthesizedTerminalElement EOF
            {
             before(grammarAccess.getParenthesizedTerminalElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleParenthesizedTerminalElement();

            state._fsp--;

             after(grammarAccess.getParenthesizedTerminalElementRule()); 
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
    // $ANTLR end "entryRuleParenthesizedTerminalElement"


    // $ANTLR start "ruleParenthesizedTerminalElement"
    // InternalXtextGrammarTestLanguage.g:1122:1: ruleParenthesizedTerminalElement : ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) ;
    public final void ruleParenthesizedTerminalElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1126:2: ( ( ( rule__ParenthesizedTerminalElement__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1127:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1127:2: ( ( rule__ParenthesizedTerminalElement__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1128:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1129:3: ( rule__ParenthesizedTerminalElement__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1129:4: rule__ParenthesizedTerminalElement__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedTerminalElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedTerminalElement"


    // $ANTLR start "entryRuleAbstractNegatedToken"
    // InternalXtextGrammarTestLanguage.g:1138:1: entryRuleAbstractNegatedToken : ruleAbstractNegatedToken EOF ;
    public final void entryRuleAbstractNegatedToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1139:1: ( ruleAbstractNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:1140:1: ruleAbstractNegatedToken EOF
            {
             before(grammarAccess.getAbstractNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAbstractNegatedToken();

            state._fsp--;

             after(grammarAccess.getAbstractNegatedTokenRule()); 
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
    // $ANTLR end "entryRuleAbstractNegatedToken"


    // $ANTLR start "ruleAbstractNegatedToken"
    // InternalXtextGrammarTestLanguage.g:1147:1: ruleAbstractNegatedToken : ( ( rule__AbstractNegatedToken__Alternatives ) ) ;
    public final void ruleAbstractNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1151:2: ( ( ( rule__AbstractNegatedToken__Alternatives ) ) )
            // InternalXtextGrammarTestLanguage.g:1152:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            {
            // InternalXtextGrammarTestLanguage.g:1152:2: ( ( rule__AbstractNegatedToken__Alternatives ) )
            // InternalXtextGrammarTestLanguage.g:1153:3: ( rule__AbstractNegatedToken__Alternatives )
            {
             before(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 
            // InternalXtextGrammarTestLanguage.g:1154:3: ( rule__AbstractNegatedToken__Alternatives )
            // InternalXtextGrammarTestLanguage.g:1154:4: rule__AbstractNegatedToken__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractNegatedToken__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractNegatedTokenAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractNegatedToken"


    // $ANTLR start "entryRuleNegatedToken"
    // InternalXtextGrammarTestLanguage.g:1163:1: entryRuleNegatedToken : ruleNegatedToken EOF ;
    public final void entryRuleNegatedToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1164:1: ( ruleNegatedToken EOF )
            // InternalXtextGrammarTestLanguage.g:1165:1: ruleNegatedToken EOF
            {
             before(grammarAccess.getNegatedTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNegatedToken();

            state._fsp--;

             after(grammarAccess.getNegatedTokenRule()); 
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
    // $ANTLR end "entryRuleNegatedToken"


    // $ANTLR start "ruleNegatedToken"
    // InternalXtextGrammarTestLanguage.g:1172:1: ruleNegatedToken : ( ( rule__NegatedToken__Group__0 ) ) ;
    public final void ruleNegatedToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1176:2: ( ( ( rule__NegatedToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1177:2: ( ( rule__NegatedToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1177:2: ( ( rule__NegatedToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1178:3: ( rule__NegatedToken__Group__0 )
            {
             before(grammarAccess.getNegatedTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1179:3: ( rule__NegatedToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1179:4: rule__NegatedToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNegatedTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegatedToken"


    // $ANTLR start "entryRuleUntilToken"
    // InternalXtextGrammarTestLanguage.g:1188:1: entryRuleUntilToken : ruleUntilToken EOF ;
    public final void entryRuleUntilToken() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1189:1: ( ruleUntilToken EOF )
            // InternalXtextGrammarTestLanguage.g:1190:1: ruleUntilToken EOF
            {
             before(grammarAccess.getUntilTokenRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleUntilToken();

            state._fsp--;

             after(grammarAccess.getUntilTokenRule()); 
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
    // $ANTLR end "entryRuleUntilToken"


    // $ANTLR start "ruleUntilToken"
    // InternalXtextGrammarTestLanguage.g:1197:1: ruleUntilToken : ( ( rule__UntilToken__Group__0 ) ) ;
    public final void ruleUntilToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1201:2: ( ( ( rule__UntilToken__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1202:2: ( ( rule__UntilToken__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1202:2: ( ( rule__UntilToken__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1203:3: ( rule__UntilToken__Group__0 )
            {
             before(grammarAccess.getUntilTokenAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1204:3: ( rule__UntilToken__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1204:4: rule__UntilToken__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUntilTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUntilToken"


    // $ANTLR start "entryRuleWildcard"
    // InternalXtextGrammarTestLanguage.g:1213:1: entryRuleWildcard : ruleWildcard EOF ;
    public final void entryRuleWildcard() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1214:1: ( ruleWildcard EOF )
            // InternalXtextGrammarTestLanguage.g:1215:1: ruleWildcard EOF
            {
             before(grammarAccess.getWildcardRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleWildcard();

            state._fsp--;

             after(grammarAccess.getWildcardRule()); 
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
    // $ANTLR end "entryRuleWildcard"


    // $ANTLR start "ruleWildcard"
    // InternalXtextGrammarTestLanguage.g:1222:1: ruleWildcard : ( ( rule__Wildcard__Group__0 ) ) ;
    public final void ruleWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1226:2: ( ( ( rule__Wildcard__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1227:2: ( ( rule__Wildcard__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1227:2: ( ( rule__Wildcard__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1228:3: ( rule__Wildcard__Group__0 )
            {
             before(grammarAccess.getWildcardAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1229:3: ( rule__Wildcard__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1229:4: rule__Wildcard__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Wildcard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWildcardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWildcard"


    // $ANTLR start "entryRuleEOF"
    // InternalXtextGrammarTestLanguage.g:1238:1: entryRuleEOF : ruleEOF EOF ;
    public final void entryRuleEOF() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1239:1: ( ruleEOF EOF )
            // InternalXtextGrammarTestLanguage.g:1240:1: ruleEOF EOF
            {
             before(grammarAccess.getEOFRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEOF();

            state._fsp--;

             after(grammarAccess.getEOFRule()); 
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
    // $ANTLR end "entryRuleEOF"


    // $ANTLR start "ruleEOF"
    // InternalXtextGrammarTestLanguage.g:1247:1: ruleEOF : ( ( rule__EOF__Group__0 ) ) ;
    public final void ruleEOF() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1251:2: ( ( ( rule__EOF__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1252:2: ( ( rule__EOF__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1252:2: ( ( rule__EOF__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1253:3: ( rule__EOF__Group__0 )
            {
             before(grammarAccess.getEOFAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1254:3: ( rule__EOF__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1254:4: rule__EOF__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEOFAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEOF"


    // $ANTLR start "entryRuleCharacterRange"
    // InternalXtextGrammarTestLanguage.g:1263:1: entryRuleCharacterRange : ruleCharacterRange EOF ;
    public final void entryRuleCharacterRange() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1264:1: ( ruleCharacterRange EOF )
            // InternalXtextGrammarTestLanguage.g:1265:1: ruleCharacterRange EOF
            {
             before(grammarAccess.getCharacterRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCharacterRange();

            state._fsp--;

             after(grammarAccess.getCharacterRangeRule()); 
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
    // $ANTLR end "entryRuleCharacterRange"


    // $ANTLR start "ruleCharacterRange"
    // InternalXtextGrammarTestLanguage.g:1272:1: ruleCharacterRange : ( ( rule__CharacterRange__Group__0 ) ) ;
    public final void ruleCharacterRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1276:2: ( ( ( rule__CharacterRange__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1277:2: ( ( rule__CharacterRange__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1277:2: ( ( rule__CharacterRange__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1278:3: ( rule__CharacterRange__Group__0 )
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1279:3: ( rule__CharacterRange__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1279:4: rule__CharacterRange__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCharacterRangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCharacterRange"


    // $ANTLR start "entryRuleEnumRule"
    // InternalXtextGrammarTestLanguage.g:1288:1: entryRuleEnumRule : ruleEnumRule EOF ;
    public final void entryRuleEnumRule() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1289:1: ( ruleEnumRule EOF )
            // InternalXtextGrammarTestLanguage.g:1290:1: ruleEnumRule EOF
            {
             before(grammarAccess.getEnumRuleRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumRule();

            state._fsp--;

             after(grammarAccess.getEnumRuleRule()); 
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
    // $ANTLR end "entryRuleEnumRule"


    // $ANTLR start "ruleEnumRule"
    // InternalXtextGrammarTestLanguage.g:1297:1: ruleEnumRule : ( ( rule__EnumRule__Group__0 ) ) ;
    public final void ruleEnumRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1301:2: ( ( ( rule__EnumRule__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1302:2: ( ( rule__EnumRule__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1302:2: ( ( rule__EnumRule__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1303:3: ( rule__EnumRule__Group__0 )
            {
             before(grammarAccess.getEnumRuleAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1304:3: ( rule__EnumRule__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1304:4: rule__EnumRule__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumRule"


    // $ANTLR start "entryRuleEnumLiterals"
    // InternalXtextGrammarTestLanguage.g:1313:1: entryRuleEnumLiterals : ruleEnumLiterals EOF ;
    public final void entryRuleEnumLiterals() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1314:1: ( ruleEnumLiterals EOF )
            // InternalXtextGrammarTestLanguage.g:1315:1: ruleEnumLiterals EOF
            {
             before(grammarAccess.getEnumLiteralsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiterals();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsRule()); 
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
    // $ANTLR end "entryRuleEnumLiterals"


    // $ANTLR start "ruleEnumLiterals"
    // InternalXtextGrammarTestLanguage.g:1322:1: ruleEnumLiterals : ( ( rule__EnumLiterals__Group__0 ) ) ;
    public final void ruleEnumLiterals() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1326:2: ( ( ( rule__EnumLiterals__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1327:2: ( ( rule__EnumLiterals__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1327:2: ( ( rule__EnumLiterals__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1328:3: ( rule__EnumLiterals__Group__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1329:3: ( rule__EnumLiterals__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1329:4: rule__EnumLiterals__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumLiterals"


    // $ANTLR start "entryRuleEnumLiteralDeclaration"
    // InternalXtextGrammarTestLanguage.g:1338:1: entryRuleEnumLiteralDeclaration : ruleEnumLiteralDeclaration EOF ;
    public final void entryRuleEnumLiteralDeclaration() throws RecognitionException {
        try {
            // InternalXtextGrammarTestLanguage.g:1339:1: ( ruleEnumLiteralDeclaration EOF )
            // InternalXtextGrammarTestLanguage.g:1340:1: ruleEnumLiteralDeclaration EOF
            {
             before(grammarAccess.getEnumLiteralDeclarationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralDeclarationRule()); 
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
    // $ANTLR end "entryRuleEnumLiteralDeclaration"


    // $ANTLR start "ruleEnumLiteralDeclaration"
    // InternalXtextGrammarTestLanguage.g:1347:1: ruleEnumLiteralDeclaration : ( ( rule__EnumLiteralDeclaration__Group__0 ) ) ;
    public final void ruleEnumLiteralDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1351:2: ( ( ( rule__EnumLiteralDeclaration__Group__0 ) ) )
            // InternalXtextGrammarTestLanguage.g:1352:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1352:2: ( ( rule__EnumLiteralDeclaration__Group__0 ) )
            // InternalXtextGrammarTestLanguage.g:1353:3: ( rule__EnumLiteralDeclaration__Group__0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 
            // InternalXtextGrammarTestLanguage.g:1354:3: ( rule__EnumLiteralDeclaration__Group__0 )
            // InternalXtextGrammarTestLanguage.g:1354:4: rule__EnumLiteralDeclaration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumLiteralDeclaration"


    // $ANTLR start "rule__AbstractRule__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1362:1: rule__AbstractRule__Alternatives : ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) );
    public final void rule__AbstractRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1366:1: ( ( ruleParserRule ) | ( ruleTerminalRule ) | ( ruleEnumRule ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 44:
                {
                alt1=1;
                }
                break;
            case 38:
                {
                alt1=2;
                }
                break;
            case 42:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1367:2: ( ruleParserRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1367:2: ( ruleParserRule )
                    // InternalXtextGrammarTestLanguage.g:1368:3: ruleParserRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParserRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getParserRuleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1373:2: ( ruleTerminalRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1373:2: ( ruleTerminalRule )
                    // InternalXtextGrammarTestLanguage.g:1374:3: ruleTerminalRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getTerminalRuleParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1379:2: ( ruleEnumRule )
                    {
                    // InternalXtextGrammarTestLanguage.g:1379:2: ( ruleEnumRule )
                    // InternalXtextGrammarTestLanguage.g:1380:3: ruleEnumRule
                    {
                     before(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEnumRule();

                    state._fsp--;

                     after(grammarAccess.getAbstractRuleAccess().getEnumRuleParserRuleCall_2()); 

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
    // $ANTLR end "rule__AbstractRule__Alternatives"


    // $ANTLR start "rule__AbstractMetamodelDeclaration__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1389:1: rule__AbstractMetamodelDeclaration__Alternatives : ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) );
    public final void rule__AbstractMetamodelDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1393:1: ( ( ruleGeneratedMetamodel ) | ( ruleReferencedMetamodel ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( (LA2_0==26) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1394:2: ( ruleGeneratedMetamodel )
                    {
                    // InternalXtextGrammarTestLanguage.g:1394:2: ( ruleGeneratedMetamodel )
                    // InternalXtextGrammarTestLanguage.g:1395:3: ruleGeneratedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleGeneratedMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getGeneratedMetamodelParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1400:2: ( ruleReferencedMetamodel )
                    {
                    // InternalXtextGrammarTestLanguage.g:1400:2: ( ruleReferencedMetamodel )
                    // InternalXtextGrammarTestLanguage.g:1401:3: ruleReferencedMetamodel
                    {
                     before(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReferencedMetamodel();

                    state._fsp--;

                     after(grammarAccess.getAbstractMetamodelDeclarationAccess().getReferencedMetamodelParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractMetamodelDeclaration__Alternatives"


    // $ANTLR start "rule__ParserRule__Alternatives_0"
    // InternalXtextGrammarTestLanguage.g:1410:1: rule__ParserRule__Alternatives_0 : ( ( ( rule__ParserRule__Group_0_0__0 ) ) | ( ( rule__ParserRule__Group_0_1__0 ) ) );
    public final void rule__ParserRule__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1414:1: ( ( ( rule__ParserRule__Group_0_0__0 ) ) | ( ( rule__ParserRule__Group_0_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==44) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1415:2: ( ( rule__ParserRule__Group_0_0__0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1415:2: ( ( rule__ParserRule__Group_0_0__0 ) )
                    // InternalXtextGrammarTestLanguage.g:1416:3: ( rule__ParserRule__Group_0_0__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_0_0()); 
                    // InternalXtextGrammarTestLanguage.g:1417:3: ( rule__ParserRule__Group_0_0__0 )
                    // InternalXtextGrammarTestLanguage.g:1417:4: rule__ParserRule__Group_0_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1421:2: ( ( rule__ParserRule__Group_0_1__0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1421:2: ( ( rule__ParserRule__Group_0_1__0 ) )
                    // InternalXtextGrammarTestLanguage.g:1422:3: ( rule__ParserRule__Group_0_1__0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getGroup_0_1()); 
                    // InternalXtextGrammarTestLanguage.g:1423:3: ( rule__ParserRule__Group_0_1__0 )
                    // InternalXtextGrammarTestLanguage.g:1423:4: rule__ParserRule__Group_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getGroup_0_1()); 

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
    // $ANTLR end "rule__ParserRule__Alternatives_0"


    // $ANTLR start "rule__ParserRule__Alternatives_0_0_2"
    // InternalXtextGrammarTestLanguage.g:1431:1: rule__ParserRule__Alternatives_0_0_2 : ( ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) ) | ( ( ruleReturnsClause )? ) );
    public final void rule__ParserRule__Alternatives_0_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1435:1: ( ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) ) | ( ( ruleReturnsClause )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==27||LA5_0==31||LA5_0==43) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1436:2: ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1436:2: ( ( rule__ParserRule__WildcardAssignment_0_0_2_0 ) )
                    // InternalXtextGrammarTestLanguage.g:1437:3: ( rule__ParserRule__WildcardAssignment_0_0_2_0 )
                    {
                     before(grammarAccess.getParserRuleAccess().getWildcardAssignment_0_0_2_0()); 
                    // InternalXtextGrammarTestLanguage.g:1438:3: ( rule__ParserRule__WildcardAssignment_0_0_2_0 )
                    // InternalXtextGrammarTestLanguage.g:1438:4: rule__ParserRule__WildcardAssignment_0_0_2_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ParserRule__WildcardAssignment_0_0_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParserRuleAccess().getWildcardAssignment_0_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1442:2: ( ( ruleReturnsClause )? )
                    {
                    // InternalXtextGrammarTestLanguage.g:1442:2: ( ( ruleReturnsClause )? )
                    // InternalXtextGrammarTestLanguage.g:1443:3: ( ruleReturnsClause )?
                    {
                     before(grammarAccess.getParserRuleAccess().getReturnsClauseParserRuleCall_0_0_2_1()); 
                    // InternalXtextGrammarTestLanguage.g:1444:3: ( ruleReturnsClause )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==31) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalXtextGrammarTestLanguage.g:1444:4: ruleReturnsClause
                            {
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleReturnsClause();

                            state._fsp--;


                            }
                            break;

                    }

                     after(grammarAccess.getParserRuleAccess().getReturnsClauseParserRuleCall_0_0_2_1()); 

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
    // $ANTLR end "rule__ParserRule__Alternatives_0_0_2"


    // $ANTLR start "rule__ConditionalBranch__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1452:1: rule__ConditionalBranch__Alternatives : ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) );
    public final void rule__ConditionalBranch__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1456:1: ( ( ruleUnorderedGroup ) | ( ( rule__ConditionalBranch__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)||LA6_0==21||LA6_0==35||LA6_0==39||LA6_0==45) ) {
                alt6=1;
            }
            else if ( (LA6_0==29) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1457:2: ( ruleUnorderedGroup )
                    {
                    // InternalXtextGrammarTestLanguage.g:1457:2: ( ruleUnorderedGroup )
                    // InternalXtextGrammarTestLanguage.g:1458:3: ruleUnorderedGroup
                    {
                     before(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUnorderedGroup();

                    state._fsp--;

                     after(grammarAccess.getConditionalBranchAccess().getUnorderedGroupParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1463:2: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1463:2: ( ( rule__ConditionalBranch__Group_1__0 ) )
                    // InternalXtextGrammarTestLanguage.g:1464:3: ( rule__ConditionalBranch__Group_1__0 )
                    {
                     before(grammarAccess.getConditionalBranchAccess().getGroup_1()); 
                    // InternalXtextGrammarTestLanguage.g:1465:3: ( rule__ConditionalBranch__Group_1__0 )
                    // InternalXtextGrammarTestLanguage.g:1465:4: rule__ConditionalBranch__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ConditionalBranch__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getConditionalBranchAccess().getGroup_1()); 

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
    // $ANTLR end "rule__ConditionalBranch__Alternatives"


    // $ANTLR start "rule__AbstractToken__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1473:1: rule__AbstractToken__Alternatives : ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) );
    public final void rule__AbstractToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1477:1: ( ( ruleAbstractTokenWithCardinality ) | ( ruleAction ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)||LA7_0==21||LA7_0==39||LA7_0==45) ) {
                alt7=1;
            }
            else if ( (LA7_0==35) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1478:2: ( ruleAbstractTokenWithCardinality )
                    {
                    // InternalXtextGrammarTestLanguage.g:1478:2: ( ruleAbstractTokenWithCardinality )
                    // InternalXtextGrammarTestLanguage.g:1479:3: ruleAbstractTokenWithCardinality
                    {
                     before(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractTokenWithCardinality();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getAbstractTokenWithCardinalityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1484:2: ( ruleAction )
                    {
                    // InternalXtextGrammarTestLanguage.g:1484:2: ( ruleAction )
                    // InternalXtextGrammarTestLanguage.g:1485:3: ruleAction
                    {
                     before(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAction();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenAccess().getActionParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractToken__Alternatives"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Alternatives_0"
    // InternalXtextGrammarTestLanguage.g:1494:1: rule__AbstractTokenWithCardinality__Alternatives_0 : ( ( ruleAssignment ) | ( ruleAbstractTerminal ) );
    public final void rule__AbstractTokenWithCardinality__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1498:1: ( ( ruleAssignment ) | ( ruleAbstractTerminal ) )
            int alt8=2;
            switch ( input.LA(1) ) {
            case 45:
                {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==RULE_ID) ) {
                    int LA8_5 = input.LA(3);

                    if ( ((LA8_5>=14 && LA8_5<=15)||LA8_5==17) ) {
                        alt8=1;
                    }
                    else if ( (LA8_5==EOF||(LA8_5>=RULE_ID && LA8_5<=RULE_STRING)||(LA8_5>=11 && LA8_5<=13)||(LA8_5>=21 && LA8_5<=22)||LA8_5==28||(LA8_5>=33 && LA8_5<=35)||LA8_5==39||LA8_5==45) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 5, input);

                        throw nvae;
                    }
                }
                else if ( (LA8_1==RULE_STRING||LA8_1==21) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
                }
                break;
            case 39:
                {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==RULE_STRING||LA8_2==21) ) {
                    alt8=2;
                }
                else if ( (LA8_2==RULE_ID) ) {
                    int LA8_5 = input.LA(3);

                    if ( ((LA8_5>=14 && LA8_5<=15)||LA8_5==17) ) {
                        alt8=1;
                    }
                    else if ( (LA8_5==EOF||(LA8_5>=RULE_ID && LA8_5<=RULE_STRING)||(LA8_5>=11 && LA8_5<=13)||(LA8_5>=21 && LA8_5<=22)||LA8_5==28||(LA8_5>=33 && LA8_5<=35)||LA8_5==39||LA8_5==45) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 5, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                int LA8_3 = input.LA(2);

                if ( (LA8_3==EOF||(LA8_3>=RULE_ID && LA8_3<=RULE_STRING)||(LA8_3>=11 && LA8_3<=13)||(LA8_3>=21 && LA8_3<=22)||(LA8_3>=28 && LA8_3<=29)||(LA8_3>=32 && LA8_3<=35)||LA8_3==39||LA8_3==45) ) {
                    alt8=2;
                }
                else if ( ((LA8_3>=14 && LA8_3<=15)||LA8_3==17) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case 21:
                {
                alt8=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1499:2: ( ruleAssignment )
                    {
                    // InternalXtextGrammarTestLanguage.g:1499:2: ( ruleAssignment )
                    // InternalXtextGrammarTestLanguage.g:1500:3: ruleAssignment
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAssignmentParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1505:2: ( ruleAbstractTerminal )
                    {
                    // InternalXtextGrammarTestLanguage.g:1505:2: ( ruleAbstractTerminal )
                    // InternalXtextGrammarTestLanguage.g:1506:3: ruleAbstractTerminal
                    {
                     before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractTerminal();

                    state._fsp--;

                     after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAbstractTerminalParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__AbstractTokenWithCardinality__Alternatives_0"


    // $ANTLR start "rule__Cardinalities__CardinalityAlternatives_0"
    // InternalXtextGrammarTestLanguage.g:1515:1: rule__Cardinalities__CardinalityAlternatives_0 : ( ( '?' ) | ( '*' ) | ( '+' ) );
    public final void rule__Cardinalities__CardinalityAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1519:1: ( ( '?' ) | ( '*' ) | ( '+' ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt9=1;
                }
                break;
            case 12:
                {
                alt9=2;
                }
                break;
            case 13:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1520:2: ( '?' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1520:2: ( '?' )
                    // InternalXtextGrammarTestLanguage.g:1521:3: '?'
                    {
                     before(grammarAccess.getCardinalitiesAccess().getCardinalityQuestionMarkKeyword_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getCardinalitiesAccess().getCardinalityQuestionMarkKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1526:2: ( '*' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1526:2: ( '*' )
                    // InternalXtextGrammarTestLanguage.g:1527:3: '*'
                    {
                     before(grammarAccess.getCardinalitiesAccess().getCardinalityAsteriskKeyword_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getCardinalitiesAccess().getCardinalityAsteriskKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1532:2: ( '+' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1532:2: ( '+' )
                    // InternalXtextGrammarTestLanguage.g:1533:3: '+'
                    {
                     before(grammarAccess.getCardinalitiesAccess().getCardinalityPlusSignKeyword_0_2()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getCardinalitiesAccess().getCardinalityPlusSignKeyword_0_2()); 

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
    // $ANTLR end "rule__Cardinalities__CardinalityAlternatives_0"


    // $ANTLR start "rule__Action__OperatorAlternatives_2_2_0"
    // InternalXtextGrammarTestLanguage.g:1542:1: rule__Action__OperatorAlternatives_2_2_0 : ( ( '=' ) | ( '+=' ) );
    public final void rule__Action__OperatorAlternatives_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1546:1: ( ( '=' ) | ( '+=' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            else if ( (LA10_0==15) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1547:2: ( '=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1547:2: ( '=' )
                    // InternalXtextGrammarTestLanguage.g:1548:3: '='
                    {
                     before(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorEqualsSignKeyword_2_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1553:2: ( '+=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1553:2: ( '+=' )
                    // InternalXtextGrammarTestLanguage.g:1554:3: '+='
                    {
                     before(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getActionAccess().getOperatorPlusSignEqualsSignKeyword_2_2_0_1()); 

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
    // $ANTLR end "rule__Action__OperatorAlternatives_2_2_0"


    // $ANTLR start "rule__AbstractTerminal__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1563:1: rule__AbstractTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) );
    public final void rule__AbstractTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1567:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedElement ) | ( rulePredicatedKeyword ) | ( rulePredicatedRuleCall ) | ( rulePredicatedGroup ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt11=1;
                }
                break;
            case RULE_ID:
                {
                alt11=2;
                }
                break;
            case 21:
                {
                alt11=3;
                }
                break;
            case 45:
                {
                switch ( input.LA(2) ) {
                case 21:
                    {
                    alt11=6;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt11=4;
                    }
                    break;
                case RULE_ID:
                    {
                    alt11=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;
                }

                }
                break;
            case 39:
                {
                switch ( input.LA(2) ) {
                case RULE_STRING:
                    {
                    alt11=4;
                    }
                    break;
                case 21:
                    {
                    alt11=6;
                    }
                    break;
                case RULE_ID:
                    {
                    alt11=5;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 5, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1568:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1568:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1569:3: ruleKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1574:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1574:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1575:3: ruleRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1580:2: ( ruleParenthesizedElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1580:2: ( ruleParenthesizedElement )
                    // InternalXtextGrammarTestLanguage.g:1581:3: ruleParenthesizedElement
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedElement();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getParenthesizedElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:1586:2: ( rulePredicatedKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1586:2: ( rulePredicatedKeyword )
                    // InternalXtextGrammarTestLanguage.g:1587:3: rulePredicatedKeyword
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedKeyword();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedKeywordParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtextGrammarTestLanguage.g:1592:2: ( rulePredicatedRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1592:2: ( rulePredicatedRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1593:3: rulePredicatedRuleCall
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedRuleCallParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXtextGrammarTestLanguage.g:1598:2: ( rulePredicatedGroup )
                    {
                    // InternalXtextGrammarTestLanguage.g:1598:2: ( rulePredicatedGroup )
                    // InternalXtextGrammarTestLanguage.g:1599:3: rulePredicatedGroup
                    {
                     before(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicatedGroup();

                    state._fsp--;

                     after(grammarAccess.getAbstractTerminalAccess().getPredicatedGroupParserRuleCall_5()); 

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
    // $ANTLR end "rule__AbstractTerminal__Alternatives"


    // $ANTLR start "rule__LiteralValue__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1608:1: rule__LiteralValue__Alternatives : ( ( '!' ) | ( '+' ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1612:1: ( ( '!' ) | ( '+' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==16) ) {
                alt12=1;
            }
            else if ( (LA12_0==13) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1613:2: ( '!' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1613:2: ( '!' )
                    // InternalXtextGrammarTestLanguage.g:1614:3: '!'
                    {
                     before(grammarAccess.getLiteralValueAccess().getExclamationMarkKeyword_0()); 
                    match(input,16,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getExclamationMarkKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1619:2: ( '+' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1619:2: ( '+' )
                    // InternalXtextGrammarTestLanguage.g:1620:3: '+'
                    {
                     before(grammarAccess.getLiteralValueAccess().getPlusSignKeyword_1()); 
                    match(input,13,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getPlusSignKeyword_1()); 

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
    // $ANTLR end "rule__LiteralValue__Alternatives"


    // $ANTLR start "rule__NamedArgument__Alternatives_1"
    // InternalXtextGrammarTestLanguage.g:1629:1: rule__NamedArgument__Alternatives_1 : ( ( ( rule__NamedArgument__Group_1_0__0 ) ) | ( ( rule__NamedArgument__Group_1_1__0 ) ) );
    public final void rule__NamedArgument__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1633:1: ( ( ( rule__NamedArgument__Group_1_0__0 ) ) | ( ( rule__NamedArgument__Group_1_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==13||LA13_0==16) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==EOF||LA13_2==20||LA13_2==30) ) {
                    alt13=1;
                }
                else if ( (LA13_2==14) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1634:2: ( ( rule__NamedArgument__Group_1_0__0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1634:2: ( ( rule__NamedArgument__Group_1_0__0 ) )
                    // InternalXtextGrammarTestLanguage.g:1635:3: ( rule__NamedArgument__Group_1_0__0 )
                    {
                     before(grammarAccess.getNamedArgumentAccess().getGroup_1_0()); 
                    // InternalXtextGrammarTestLanguage.g:1636:3: ( rule__NamedArgument__Group_1_0__0 )
                    // InternalXtextGrammarTestLanguage.g:1636:4: rule__NamedArgument__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__NamedArgument__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNamedArgumentAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1640:2: ( ( rule__NamedArgument__Group_1_1__0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1640:2: ( ( rule__NamedArgument__Group_1_1__0 ) )
                    // InternalXtextGrammarTestLanguage.g:1641:3: ( rule__NamedArgument__Group_1_1__0 )
                    {
                     before(grammarAccess.getNamedArgumentAccess().getGroup_1_1()); 
                    // InternalXtextGrammarTestLanguage.g:1642:3: ( rule__NamedArgument__Group_1_1__0 )
                    // InternalXtextGrammarTestLanguage.g:1642:4: rule__NamedArgument__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__NamedArgument__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNamedArgumentAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__NamedArgument__Alternatives_1"


    // $ANTLR start "rule__Assignment__OperatorAlternatives_2_0"
    // InternalXtextGrammarTestLanguage.g:1650:1: rule__Assignment__OperatorAlternatives_2_0 : ( ( '+=' ) | ( '=' ) | ( '?=' ) );
    public final void rule__Assignment__OperatorAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1654:1: ( ( '+=' ) | ( '=' ) | ( '?=' ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt14=1;
                }
                break;
            case 14:
                {
                alt14=2;
                }
                break;
            case 17:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1655:2: ( '+=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1655:2: ( '+=' )
                    // InternalXtextGrammarTestLanguage.g:1656:3: '+='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 
                    match(input,15,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorPlusSignEqualsSignKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1661:2: ( '=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1661:2: ( '=' )
                    // InternalXtextGrammarTestLanguage.g:1662:3: '='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorEqualsSignKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1667:2: ( '?=' )
                    {
                    // InternalXtextGrammarTestLanguage.g:1667:2: ( '?=' )
                    // InternalXtextGrammarTestLanguage.g:1668:3: '?='
                    {
                     before(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); 
                    match(input,17,FollowSets000.FOLLOW_2); 
                     after(grammarAccess.getAssignmentAccess().getOperatorQuestionMarkEqualsSignKeyword_2_0_2()); 

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
    // $ANTLR end "rule__Assignment__OperatorAlternatives_2_0"


    // $ANTLR start "rule__Predicate__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1677:1: rule__Predicate__Alternatives : ( ( ( rule__Predicate__PredicatedAssignment_0 ) ) | ( ( rule__Predicate__FirstSetPredicatedAssignment_1 ) ) );
    public final void rule__Predicate__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1681:1: ( ( ( rule__Predicate__PredicatedAssignment_0 ) ) | ( ( rule__Predicate__FirstSetPredicatedAssignment_1 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==45) ) {
                alt15=1;
            }
            else if ( (LA15_0==39) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1682:2: ( ( rule__Predicate__PredicatedAssignment_0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1682:2: ( ( rule__Predicate__PredicatedAssignment_0 ) )
                    // InternalXtextGrammarTestLanguage.g:1683:3: ( rule__Predicate__PredicatedAssignment_0 )
                    {
                     before(grammarAccess.getPredicateAccess().getPredicatedAssignment_0()); 
                    // InternalXtextGrammarTestLanguage.g:1684:3: ( rule__Predicate__PredicatedAssignment_0 )
                    // InternalXtextGrammarTestLanguage.g:1684:4: rule__Predicate__PredicatedAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Predicate__PredicatedAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicateAccess().getPredicatedAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1688:2: ( ( rule__Predicate__FirstSetPredicatedAssignment_1 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1688:2: ( ( rule__Predicate__FirstSetPredicatedAssignment_1 ) )
                    // InternalXtextGrammarTestLanguage.g:1689:3: ( rule__Predicate__FirstSetPredicatedAssignment_1 )
                    {
                     before(grammarAccess.getPredicateAccess().getFirstSetPredicatedAssignment_1()); 
                    // InternalXtextGrammarTestLanguage.g:1690:3: ( rule__Predicate__FirstSetPredicatedAssignment_1 )
                    // InternalXtextGrammarTestLanguage.g:1690:4: rule__Predicate__FirstSetPredicatedAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Predicate__FirstSetPredicatedAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getPredicateAccess().getFirstSetPredicatedAssignment_1()); 

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
    // $ANTLR end "rule__Predicate__Alternatives"


    // $ANTLR start "rule__AssignableTerminal__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1698:1: rule__AssignableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) );
    public final void rule__AssignableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1702:1: ( ( ruleKeyword ) | ( ruleRuleCall ) | ( ruleParenthesizedAssignableElement ) | ( ruleCrossReference ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
                {
                alt16=2;
                }
                break;
            case 21:
                {
                alt16=3;
                }
                break;
            case 29:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1703:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1703:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1704:3: ruleKeyword
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1709:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1709:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1710:3: ruleRuleCall
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1715:2: ( ruleParenthesizedAssignableElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1715:2: ( ruleParenthesizedAssignableElement )
                    // InternalXtextGrammarTestLanguage.g:1716:3: ruleParenthesizedAssignableElement
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedAssignableElement();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getParenthesizedAssignableElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:1721:2: ( ruleCrossReference )
                    {
                    // InternalXtextGrammarTestLanguage.g:1721:2: ( ruleCrossReference )
                    // InternalXtextGrammarTestLanguage.g:1722:3: ruleCrossReference
                    {
                     before(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCrossReference();

                    state._fsp--;

                     after(grammarAccess.getAssignableTerminalAccess().getCrossReferenceParserRuleCall_3()); 

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
    // $ANTLR end "rule__AssignableTerminal__Alternatives"


    // $ANTLR start "rule__CrossReferenceableTerminal__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1731:1: rule__CrossReferenceableTerminal__Alternatives : ( ( ruleKeyword ) | ( ruleRuleCall ) );
    public final void rule__CrossReferenceableTerminal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1735:1: ( ( ruleKeyword ) | ( ruleRuleCall ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1736:2: ( ruleKeyword )
                    {
                    // InternalXtextGrammarTestLanguage.g:1736:2: ( ruleKeyword )
                    // InternalXtextGrammarTestLanguage.g:1737:3: ruleKeyword
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleKeyword();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getKeywordParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1742:2: ( ruleRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1742:2: ( ruleRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1743:3: ruleRuleCall
                    {
                     before(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleRuleCall();

                    state._fsp--;

                     after(grammarAccess.getCrossReferenceableTerminalAccess().getRuleCallParserRuleCall_1()); 

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
    // $ANTLR end "rule__CrossReferenceableTerminal__Alternatives"


    // $ANTLR start "rule__TerminalRule__Alternatives_1"
    // InternalXtextGrammarTestLanguage.g:1752:1: rule__TerminalRule__Alternatives_1 : ( ( ( rule__TerminalRule__Group_1_0__0 ) ) | ( ( rule__TerminalRule__Group_1_1__0 ) ) );
    public final void rule__TerminalRule__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1756:1: ( ( ( rule__TerminalRule__Group_1_0__0 ) ) | ( ( rule__TerminalRule__Group_1_1__0 ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==44) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1757:2: ( ( rule__TerminalRule__Group_1_0__0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1757:2: ( ( rule__TerminalRule__Group_1_0__0 ) )
                    // InternalXtextGrammarTestLanguage.g:1758:3: ( rule__TerminalRule__Group_1_0__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_1_0()); 
                    // InternalXtextGrammarTestLanguage.g:1759:3: ( rule__TerminalRule__Group_1_0__0 )
                    // InternalXtextGrammarTestLanguage.g:1759:4: rule__TerminalRule__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1763:2: ( ( rule__TerminalRule__Group_1_1__0 ) )
                    {
                    // InternalXtextGrammarTestLanguage.g:1763:2: ( ( rule__TerminalRule__Group_1_1__0 ) )
                    // InternalXtextGrammarTestLanguage.g:1764:3: ( rule__TerminalRule__Group_1_1__0 )
                    {
                     before(grammarAccess.getTerminalRuleAccess().getGroup_1_1()); 
                    // InternalXtextGrammarTestLanguage.g:1765:3: ( rule__TerminalRule__Group_1_1__0 )
                    // InternalXtextGrammarTestLanguage.g:1765:4: rule__TerminalRule__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalRule__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTerminalRuleAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__TerminalRule__Alternatives_1"


    // $ANTLR start "rule__TerminalTokenElement__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1773:1: rule__TerminalTokenElement__Alternatives : ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) );
    public final void rule__TerminalTokenElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1777:1: ( ( ruleCharacterRange ) | ( ruleTerminalRuleCall ) | ( ruleParenthesizedTerminalElement ) | ( ruleAbstractNegatedToken ) | ( ruleWildcard ) | ( ruleEOF ) )
            int alt19=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt19=1;
                }
                break;
            case RULE_ID:
                {
                alt19=2;
                }
                break;
            case 21:
                {
                alt19=3;
                }
                break;
            case 16:
            case 39:
                {
                alt19=4;
                }
                break;
            case 23:
                {
                alt19=5;
                }
                break;
            case 40:
                {
                alt19=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1778:2: ( ruleCharacterRange )
                    {
                    // InternalXtextGrammarTestLanguage.g:1778:2: ( ruleCharacterRange )
                    // InternalXtextGrammarTestLanguage.g:1779:3: ruleCharacterRange
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCharacterRange();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getCharacterRangeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1784:2: ( ruleTerminalRuleCall )
                    {
                    // InternalXtextGrammarTestLanguage.g:1784:2: ( ruleTerminalRuleCall )
                    // InternalXtextGrammarTestLanguage.g:1785:3: ruleTerminalRuleCall
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTerminalRuleCall();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getTerminalRuleCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXtextGrammarTestLanguage.g:1790:2: ( ruleParenthesizedTerminalElement )
                    {
                    // InternalXtextGrammarTestLanguage.g:1790:2: ( ruleParenthesizedTerminalElement )
                    // InternalXtextGrammarTestLanguage.g:1791:3: ruleParenthesizedTerminalElement
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleParenthesizedTerminalElement();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getParenthesizedTerminalElementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXtextGrammarTestLanguage.g:1796:2: ( ruleAbstractNegatedToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1796:2: ( ruleAbstractNegatedToken )
                    // InternalXtextGrammarTestLanguage.g:1797:3: ruleAbstractNegatedToken
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleAbstractNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getAbstractNegatedTokenParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXtextGrammarTestLanguage.g:1802:2: ( ruleWildcard )
                    {
                    // InternalXtextGrammarTestLanguage.g:1802:2: ( ruleWildcard )
                    // InternalXtextGrammarTestLanguage.g:1803:3: ruleWildcard
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleWildcard();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getWildcardParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalXtextGrammarTestLanguage.g:1808:2: ( ruleEOF )
                    {
                    // InternalXtextGrammarTestLanguage.g:1808:2: ( ruleEOF )
                    // InternalXtextGrammarTestLanguage.g:1809:3: ruleEOF
                    {
                     before(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEOF();

                    state._fsp--;

                     after(grammarAccess.getTerminalTokenElementAccess().getEOFParserRuleCall_5()); 

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
    // $ANTLR end "rule__TerminalTokenElement__Alternatives"


    // $ANTLR start "rule__AbstractNegatedToken__Alternatives"
    // InternalXtextGrammarTestLanguage.g:1818:1: rule__AbstractNegatedToken__Alternatives : ( ( ruleNegatedToken ) | ( ruleUntilToken ) );
    public final void rule__AbstractNegatedToken__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1822:1: ( ( ruleNegatedToken ) | ( ruleUntilToken ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            else if ( (LA20_0==39) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1823:2: ( ruleNegatedToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1823:2: ( ruleNegatedToken )
                    // InternalXtextGrammarTestLanguage.g:1824:3: ruleNegatedToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleNegatedToken();

                    state._fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getNegatedTokenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXtextGrammarTestLanguage.g:1829:2: ( ruleUntilToken )
                    {
                    // InternalXtextGrammarTestLanguage.g:1829:2: ( ruleUntilToken )
                    // InternalXtextGrammarTestLanguage.g:1830:3: ruleUntilToken
                    {
                     before(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleUntilToken();

                    state._fsp--;

                     after(grammarAccess.getAbstractNegatedTokenAccess().getUntilTokenParserRuleCall_1()); 

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
    // $ANTLR end "rule__AbstractNegatedToken__Alternatives"


    // $ANTLR start "rule__Grammar__Group__0"
    // InternalXtextGrammarTestLanguage.g:1839:1: rule__Grammar__Group__0 : rule__Grammar__Group__0__Impl rule__Grammar__Group__1 ;
    public final void rule__Grammar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1843:1: ( rule__Grammar__Group__0__Impl rule__Grammar__Group__1 )
            // InternalXtextGrammarTestLanguage.g:1844:2: rule__Grammar__Group__0__Impl rule__Grammar__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__1();

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
    // $ANTLR end "rule__Grammar__Group__0"


    // $ANTLR start "rule__Grammar__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:1851:1: rule__Grammar__Group__0__Impl : ( 'grammar' ) ;
    public final void rule__Grammar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1855:1: ( ( 'grammar' ) )
            // InternalXtextGrammarTestLanguage.g:1856:1: ( 'grammar' )
            {
            // InternalXtextGrammarTestLanguage.g:1856:1: ( 'grammar' )
            // InternalXtextGrammarTestLanguage.g:1857:2: 'grammar'
            {
             before(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getGrammarKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__0__Impl"


    // $ANTLR start "rule__Grammar__Group__1"
    // InternalXtextGrammarTestLanguage.g:1866:1: rule__Grammar__Group__1 : rule__Grammar__Group__1__Impl rule__Grammar__Group__2 ;
    public final void rule__Grammar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1870:1: ( rule__Grammar__Group__1__Impl rule__Grammar__Group__2 )
            // InternalXtextGrammarTestLanguage.g:1871:2: rule__Grammar__Group__1__Impl rule__Grammar__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__2();

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
    // $ANTLR end "rule__Grammar__Group__1"


    // $ANTLR start "rule__Grammar__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:1878:1: rule__Grammar__Group__1__Impl : ( ( rule__Grammar__NameAssignment_1 ) ) ;
    public final void rule__Grammar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1882:1: ( ( ( rule__Grammar__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:1883:1: ( ( rule__Grammar__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:1883:1: ( ( rule__Grammar__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:1884:2: ( rule__Grammar__NameAssignment_1 )
            {
             before(grammarAccess.getGrammarAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:1885:2: ( rule__Grammar__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:1885:3: rule__Grammar__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__1__Impl"


    // $ANTLR start "rule__Grammar__Group__2"
    // InternalXtextGrammarTestLanguage.g:1893:1: rule__Grammar__Group__2 : rule__Grammar__Group__2__Impl rule__Grammar__Group__3 ;
    public final void rule__Grammar__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1897:1: ( rule__Grammar__Group__2__Impl rule__Grammar__Group__3 )
            // InternalXtextGrammarTestLanguage.g:1898:2: rule__Grammar__Group__2__Impl rule__Grammar__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__3();

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
    // $ANTLR end "rule__Grammar__Group__2"


    // $ANTLR start "rule__Grammar__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:1905:1: rule__Grammar__Group__2__Impl : ( ( rule__Grammar__Group_2__0 )? ) ;
    public final void rule__Grammar__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1909:1: ( ( ( rule__Grammar__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:1910:1: ( ( rule__Grammar__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:1910:1: ( ( rule__Grammar__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:1911:2: ( rule__Grammar__Group_2__0 )?
            {
             before(grammarAccess.getGrammarAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:1912:2: ( rule__Grammar__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1912:3: rule__Grammar__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Grammar__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__2__Impl"


    // $ANTLR start "rule__Grammar__Group__3"
    // InternalXtextGrammarTestLanguage.g:1920:1: rule__Grammar__Group__3 : rule__Grammar__Group__3__Impl rule__Grammar__Group__4 ;
    public final void rule__Grammar__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1924:1: ( rule__Grammar__Group__3__Impl rule__Grammar__Group__4 )
            // InternalXtextGrammarTestLanguage.g:1925:2: rule__Grammar__Group__3__Impl rule__Grammar__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__4();

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
    // $ANTLR end "rule__Grammar__Group__3"


    // $ANTLR start "rule__Grammar__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:1932:1: rule__Grammar__Group__3__Impl : ( ( ruleHiddenClause )? ) ;
    public final void rule__Grammar__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1936:1: ( ( ( ruleHiddenClause )? ) )
            // InternalXtextGrammarTestLanguage.g:1937:1: ( ( ruleHiddenClause )? )
            {
            // InternalXtextGrammarTestLanguage.g:1937:1: ( ( ruleHiddenClause )? )
            // InternalXtextGrammarTestLanguage.g:1938:2: ( ruleHiddenClause )?
            {
             before(grammarAccess.getGrammarAccess().getHiddenClauseParserRuleCall_3()); 
            // InternalXtextGrammarTestLanguage.g:1939:2: ( ruleHiddenClause )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==43) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:1939:3: ruleHiddenClause
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleHiddenClause();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGrammarAccess().getHiddenClauseParserRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__3__Impl"


    // $ANTLR start "rule__Grammar__Group__4"
    // InternalXtextGrammarTestLanguage.g:1947:1: rule__Grammar__Group__4 : rule__Grammar__Group__4__Impl rule__Grammar__Group__5 ;
    public final void rule__Grammar__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1951:1: ( rule__Grammar__Group__4__Impl rule__Grammar__Group__5 )
            // InternalXtextGrammarTestLanguage.g:1952:2: rule__Grammar__Group__4__Impl rule__Grammar__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Grammar__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__5();

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
    // $ANTLR end "rule__Grammar__Group__4"


    // $ANTLR start "rule__Grammar__Group__4__Impl"
    // InternalXtextGrammarTestLanguage.g:1959:1: rule__Grammar__Group__4__Impl : ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) ;
    public final void rule__Grammar__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1963:1: ( ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* ) )
            // InternalXtextGrammarTestLanguage.g:1964:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1964:1: ( ( rule__Grammar__MetamodelDeclarationsAssignment_4 )* )
            // InternalXtextGrammarTestLanguage.g:1965:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:1966:2: ( rule__Grammar__MetamodelDeclarationsAssignment_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24||LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1966:3: rule__Grammar__MetamodelDeclarationsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    rule__Grammar__MetamodelDeclarationsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group__4__Impl"


    // $ANTLR start "rule__Grammar__Group__5"
    // InternalXtextGrammarTestLanguage.g:1974:1: rule__Grammar__Group__5 : rule__Grammar__Group__5__Impl ;
    public final void rule__Grammar__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1978:1: ( rule__Grammar__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:1979:2: rule__Grammar__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group__5__Impl();

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
    // $ANTLR end "rule__Grammar__Group__5"


    // $ANTLR start "rule__Grammar__Group__5__Impl"
    // InternalXtextGrammarTestLanguage.g:1985:1: rule__Grammar__Group__5__Impl : ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) ;
    public final void rule__Grammar__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:1989:1: ( ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:1990:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:1990:1: ( ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* ) )
            // InternalXtextGrammarTestLanguage.g:1991:2: ( ( rule__Grammar__RulesAssignment_5 ) ) ( ( rule__Grammar__RulesAssignment_5 )* )
            {
            // InternalXtextGrammarTestLanguage.g:1991:2: ( ( rule__Grammar__RulesAssignment_5 ) )
            // InternalXtextGrammarTestLanguage.g:1992:3: ( rule__Grammar__RulesAssignment_5 )
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtextGrammarTestLanguage.g:1993:3: ( rule__Grammar__RulesAssignment_5 )
            // InternalXtextGrammarTestLanguage.g:1993:4: rule__Grammar__RulesAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Grammar__RulesAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

            }

            // InternalXtextGrammarTestLanguage.g:1996:2: ( ( rule__Grammar__RulesAssignment_5 )* )
            // InternalXtextGrammarTestLanguage.g:1997:3: ( rule__Grammar__RulesAssignment_5 )*
            {
             before(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 
            // InternalXtextGrammarTestLanguage.g:1998:3: ( rule__Grammar__RulesAssignment_5 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||LA24_0==38||LA24_0==42||LA24_0==44) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:1998:4: rule__Grammar__RulesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    rule__Grammar__RulesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getRulesAssignment_5()); 

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
    // $ANTLR end "rule__Grammar__Group__5__Impl"


    // $ANTLR start "rule__Grammar__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:2008:1: rule__Grammar__Group_2__0 : rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 ;
    public final void rule__Grammar__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2012:1: ( rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:2013:2: rule__Grammar__Group_2__0__Impl rule__Grammar__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2__1();

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
    // $ANTLR end "rule__Grammar__Group_2__0"


    // $ANTLR start "rule__Grammar__Group_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2020:1: rule__Grammar__Group_2__0__Impl : ( 'with' ) ;
    public final void rule__Grammar__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2024:1: ( ( 'with' ) )
            // InternalXtextGrammarTestLanguage.g:2025:1: ( 'with' )
            {
            // InternalXtextGrammarTestLanguage.g:2025:1: ( 'with' )
            // InternalXtextGrammarTestLanguage.g:2026:2: 'with'
            {
             before(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 
            match(input,19,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getWithKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_2__1"
    // InternalXtextGrammarTestLanguage.g:2035:1: rule__Grammar__Group_2__1 : rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 ;
    public final void rule__Grammar__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2039:1: ( rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:2040:2: rule__Grammar__Group_2__1__Impl rule__Grammar__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__Grammar__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2__2();

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
    // $ANTLR end "rule__Grammar__Group_2__1"


    // $ANTLR start "rule__Grammar__Group_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2047:1: rule__Grammar__Group_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) ;
    public final void rule__Grammar__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2051:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2052:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2052:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:2053:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2054:2: ( rule__Grammar__UsedGrammarsAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:2054:3: rule__Grammar__UsedGrammarsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__UsedGrammarsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__1__Impl"


    // $ANTLR start "rule__Grammar__Group_2__2"
    // InternalXtextGrammarTestLanguage.g:2062:1: rule__Grammar__Group_2__2 : rule__Grammar__Group_2__2__Impl ;
    public final void rule__Grammar__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2066:1: ( rule__Grammar__Group_2__2__Impl )
            // InternalXtextGrammarTestLanguage.g:2067:2: rule__Grammar__Group_2__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2__2__Impl();

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
    // $ANTLR end "rule__Grammar__Group_2__2"


    // $ANTLR start "rule__Grammar__Group_2__2__Impl"
    // InternalXtextGrammarTestLanguage.g:2073:1: rule__Grammar__Group_2__2__Impl : ( ( rule__Grammar__Group_2_2__0 )* ) ;
    public final void rule__Grammar__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2077:1: ( ( ( rule__Grammar__Group_2_2__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:2078:1: ( ( rule__Grammar__Group_2_2__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:2078:1: ( ( rule__Grammar__Group_2_2__0 )* )
            // InternalXtextGrammarTestLanguage.g:2079:2: ( rule__Grammar__Group_2_2__0 )*
            {
             before(grammarAccess.getGrammarAccess().getGroup_2_2()); 
            // InternalXtextGrammarTestLanguage.g:2080:2: ( rule__Grammar__Group_2_2__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==20) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:2080:3: rule__Grammar__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__Grammar__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getGrammarAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2__2__Impl"


    // $ANTLR start "rule__Grammar__Group_2_2__0"
    // InternalXtextGrammarTestLanguage.g:2089:1: rule__Grammar__Group_2_2__0 : rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 ;
    public final void rule__Grammar__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2093:1: ( rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1 )
            // InternalXtextGrammarTestLanguage.g:2094:2: rule__Grammar__Group_2_2__0__Impl rule__Grammar__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Grammar__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2_2__1();

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
    // $ANTLR end "rule__Grammar__Group_2_2__0"


    // $ANTLR start "rule__Grammar__Group_2_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2101:1: rule__Grammar__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Grammar__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2105:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:2106:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:2106:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:2107:2: ','
            {
             before(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__0__Impl"


    // $ANTLR start "rule__Grammar__Group_2_2__1"
    // InternalXtextGrammarTestLanguage.g:2116:1: rule__Grammar__Group_2_2__1 : rule__Grammar__Group_2_2__1__Impl ;
    public final void rule__Grammar__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2120:1: ( rule__Grammar__Group_2_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2121:2: rule__Grammar__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__Grammar__Group_2_2__1"


    // $ANTLR start "rule__Grammar__Group_2_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2127:1: rule__Grammar__Group_2_2__1__Impl : ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) ;
    public final void rule__Grammar__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2131:1: ( ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2132:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2132:1: ( ( rule__Grammar__UsedGrammarsAssignment_2_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:2133:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2134:2: ( rule__Grammar__UsedGrammarsAssignment_2_2_1 )
            // InternalXtextGrammarTestLanguage.g:2134:3: rule__Grammar__UsedGrammarsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Grammar__UsedGrammarsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__Group_2_2__1__Impl"


    // $ANTLR start "rule__HiddenClause__Group__0"
    // InternalXtextGrammarTestLanguage.g:2143:1: rule__HiddenClause__Group__0 : rule__HiddenClause__Group__0__Impl rule__HiddenClause__Group__1 ;
    public final void rule__HiddenClause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2147:1: ( rule__HiddenClause__Group__0__Impl rule__HiddenClause__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2148:2: rule__HiddenClause__Group__0__Impl rule__HiddenClause__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__HiddenClause__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group__1();

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
    // $ANTLR end "rule__HiddenClause__Group__0"


    // $ANTLR start "rule__HiddenClause__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2155:1: rule__HiddenClause__Group__0__Impl : ( ( rule__HiddenClause__DefinesHiddenTokensAssignment_0 ) ) ;
    public final void rule__HiddenClause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2159:1: ( ( ( rule__HiddenClause__DefinesHiddenTokensAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2160:1: ( ( rule__HiddenClause__DefinesHiddenTokensAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2160:1: ( ( rule__HiddenClause__DefinesHiddenTokensAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:2161:2: ( rule__HiddenClause__DefinesHiddenTokensAssignment_0 )
            {
             before(grammarAccess.getHiddenClauseAccess().getDefinesHiddenTokensAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:2162:2: ( rule__HiddenClause__DefinesHiddenTokensAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:2162:3: rule__HiddenClause__DefinesHiddenTokensAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__DefinesHiddenTokensAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getHiddenClauseAccess().getDefinesHiddenTokensAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group__0__Impl"


    // $ANTLR start "rule__HiddenClause__Group__1"
    // InternalXtextGrammarTestLanguage.g:2170:1: rule__HiddenClause__Group__1 : rule__HiddenClause__Group__1__Impl rule__HiddenClause__Group__2 ;
    public final void rule__HiddenClause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2174:1: ( rule__HiddenClause__Group__1__Impl rule__HiddenClause__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2175:2: rule__HiddenClause__Group__1__Impl rule__HiddenClause__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__HiddenClause__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group__2();

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
    // $ANTLR end "rule__HiddenClause__Group__1"


    // $ANTLR start "rule__HiddenClause__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2182:1: rule__HiddenClause__Group__1__Impl : ( '(' ) ;
    public final void rule__HiddenClause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2186:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:2187:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:2187:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:2188:2: '('
            {
             before(grammarAccess.getHiddenClauseAccess().getLeftParenthesisKeyword_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getHiddenClauseAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group__1__Impl"


    // $ANTLR start "rule__HiddenClause__Group__2"
    // InternalXtextGrammarTestLanguage.g:2197:1: rule__HiddenClause__Group__2 : rule__HiddenClause__Group__2__Impl rule__HiddenClause__Group__3 ;
    public final void rule__HiddenClause__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2201:1: ( rule__HiddenClause__Group__2__Impl rule__HiddenClause__Group__3 )
            // InternalXtextGrammarTestLanguage.g:2202:2: rule__HiddenClause__Group__2__Impl rule__HiddenClause__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_10);
            rule__HiddenClause__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group__3();

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
    // $ANTLR end "rule__HiddenClause__Group__2"


    // $ANTLR start "rule__HiddenClause__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:2209:1: rule__HiddenClause__Group__2__Impl : ( ( rule__HiddenClause__Group_2__0 )? ) ;
    public final void rule__HiddenClause__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2213:1: ( ( ( rule__HiddenClause__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2214:1: ( ( rule__HiddenClause__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2214:1: ( ( rule__HiddenClause__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2215:2: ( rule__HiddenClause__Group_2__0 )?
            {
             before(grammarAccess.getHiddenClauseAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:2216:2: ( rule__HiddenClause__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2216:3: rule__HiddenClause__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__HiddenClause__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHiddenClauseAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group__2__Impl"


    // $ANTLR start "rule__HiddenClause__Group__3"
    // InternalXtextGrammarTestLanguage.g:2224:1: rule__HiddenClause__Group__3 : rule__HiddenClause__Group__3__Impl ;
    public final void rule__HiddenClause__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2228:1: ( rule__HiddenClause__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:2229:2: rule__HiddenClause__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group__3__Impl();

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
    // $ANTLR end "rule__HiddenClause__Group__3"


    // $ANTLR start "rule__HiddenClause__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:2235:1: rule__HiddenClause__Group__3__Impl : ( ')' ) ;
    public final void rule__HiddenClause__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2239:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:2240:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:2240:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:2241:2: ')'
            {
             before(grammarAccess.getHiddenClauseAccess().getRightParenthesisKeyword_3()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getHiddenClauseAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group__3__Impl"


    // $ANTLR start "rule__HiddenClause__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:2251:1: rule__HiddenClause__Group_2__0 : rule__HiddenClause__Group_2__0__Impl rule__HiddenClause__Group_2__1 ;
    public final void rule__HiddenClause__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2255:1: ( rule__HiddenClause__Group_2__0__Impl rule__HiddenClause__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:2256:2: rule__HiddenClause__Group_2__0__Impl rule__HiddenClause__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__HiddenClause__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group_2__1();

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
    // $ANTLR end "rule__HiddenClause__Group_2__0"


    // $ANTLR start "rule__HiddenClause__Group_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2263:1: rule__HiddenClause__Group_2__0__Impl : ( ( rule__HiddenClause__HiddenTokensAssignment_2_0 ) ) ;
    public final void rule__HiddenClause__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2267:1: ( ( ( rule__HiddenClause__HiddenTokensAssignment_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2268:1: ( ( rule__HiddenClause__HiddenTokensAssignment_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2268:1: ( ( rule__HiddenClause__HiddenTokensAssignment_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:2269:2: ( rule__HiddenClause__HiddenTokensAssignment_2_0 )
            {
             before(grammarAccess.getHiddenClauseAccess().getHiddenTokensAssignment_2_0()); 
            // InternalXtextGrammarTestLanguage.g:2270:2: ( rule__HiddenClause__HiddenTokensAssignment_2_0 )
            // InternalXtextGrammarTestLanguage.g:2270:3: rule__HiddenClause__HiddenTokensAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__HiddenTokensAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getHiddenClauseAccess().getHiddenTokensAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group_2__0__Impl"


    // $ANTLR start "rule__HiddenClause__Group_2__1"
    // InternalXtextGrammarTestLanguage.g:2278:1: rule__HiddenClause__Group_2__1 : rule__HiddenClause__Group_2__1__Impl ;
    public final void rule__HiddenClause__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2282:1: ( rule__HiddenClause__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2283:2: rule__HiddenClause__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group_2__1__Impl();

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
    // $ANTLR end "rule__HiddenClause__Group_2__1"


    // $ANTLR start "rule__HiddenClause__Group_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2289:1: rule__HiddenClause__Group_2__1__Impl : ( ( rule__HiddenClause__Group_2_1__0 )* ) ;
    public final void rule__HiddenClause__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2293:1: ( ( ( rule__HiddenClause__Group_2_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:2294:1: ( ( rule__HiddenClause__Group_2_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:2294:1: ( ( rule__HiddenClause__Group_2_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:2295:2: ( rule__HiddenClause__Group_2_1__0 )*
            {
             before(grammarAccess.getHiddenClauseAccess().getGroup_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2296:2: ( rule__HiddenClause__Group_2_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==20) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:2296:3: rule__HiddenClause__Group_2_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__HiddenClause__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getHiddenClauseAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group_2__1__Impl"


    // $ANTLR start "rule__HiddenClause__Group_2_1__0"
    // InternalXtextGrammarTestLanguage.g:2305:1: rule__HiddenClause__Group_2_1__0 : rule__HiddenClause__Group_2_1__0__Impl rule__HiddenClause__Group_2_1__1 ;
    public final void rule__HiddenClause__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2309:1: ( rule__HiddenClause__Group_2_1__0__Impl rule__HiddenClause__Group_2_1__1 )
            // InternalXtextGrammarTestLanguage.g:2310:2: rule__HiddenClause__Group_2_1__0__Impl rule__HiddenClause__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__HiddenClause__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group_2_1__1();

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
    // $ANTLR end "rule__HiddenClause__Group_2_1__0"


    // $ANTLR start "rule__HiddenClause__Group_2_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2317:1: rule__HiddenClause__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__HiddenClause__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2321:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:2322:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:2322:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:2323:2: ','
            {
             before(grammarAccess.getHiddenClauseAccess().getCommaKeyword_2_1_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getHiddenClauseAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group_2_1__0__Impl"


    // $ANTLR start "rule__HiddenClause__Group_2_1__1"
    // InternalXtextGrammarTestLanguage.g:2332:1: rule__HiddenClause__Group_2_1__1 : rule__HiddenClause__Group_2_1__1__Impl ;
    public final void rule__HiddenClause__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2336:1: ( rule__HiddenClause__Group_2_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2337:2: rule__HiddenClause__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__Group_2_1__1__Impl();

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
    // $ANTLR end "rule__HiddenClause__Group_2_1__1"


    // $ANTLR start "rule__HiddenClause__Group_2_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2343:1: rule__HiddenClause__Group_2_1__1__Impl : ( ( rule__HiddenClause__HiddenTokensAssignment_2_1_1 ) ) ;
    public final void rule__HiddenClause__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2347:1: ( ( ( rule__HiddenClause__HiddenTokensAssignment_2_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2348:1: ( ( rule__HiddenClause__HiddenTokensAssignment_2_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2348:1: ( ( rule__HiddenClause__HiddenTokensAssignment_2_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:2349:2: ( rule__HiddenClause__HiddenTokensAssignment_2_1_1 )
            {
             before(grammarAccess.getHiddenClauseAccess().getHiddenTokensAssignment_2_1_1()); 
            // InternalXtextGrammarTestLanguage.g:2350:2: ( rule__HiddenClause__HiddenTokensAssignment_2_1_1 )
            // InternalXtextGrammarTestLanguage.g:2350:3: rule__HiddenClause__HiddenTokensAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__HiddenClause__HiddenTokensAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getHiddenClauseAccess().getHiddenTokensAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__Group_2_1__1__Impl"


    // $ANTLR start "rule__GrammarID__Group__0"
    // InternalXtextGrammarTestLanguage.g:2359:1: rule__GrammarID__Group__0 : rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 ;
    public final void rule__GrammarID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2363:1: ( rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2364:2: rule__GrammarID__Group__0__Impl rule__GrammarID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__GrammarID__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group__1();

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
    // $ANTLR end "rule__GrammarID__Group__0"


    // $ANTLR start "rule__GrammarID__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2371:1: rule__GrammarID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2375:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:2376:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:2376:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:2377:2: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__0__Impl"


    // $ANTLR start "rule__GrammarID__Group__1"
    // InternalXtextGrammarTestLanguage.g:2386:1: rule__GrammarID__Group__1 : rule__GrammarID__Group__1__Impl ;
    public final void rule__GrammarID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2390:1: ( rule__GrammarID__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2391:2: rule__GrammarID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group__1__Impl();

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
    // $ANTLR end "rule__GrammarID__Group__1"


    // $ANTLR start "rule__GrammarID__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2397:1: rule__GrammarID__Group__1__Impl : ( ( rule__GrammarID__Group_1__0 )* ) ;
    public final void rule__GrammarID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2401:1: ( ( ( rule__GrammarID__Group_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:2402:1: ( ( rule__GrammarID__Group_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:2402:1: ( ( rule__GrammarID__Group_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:2403:2: ( rule__GrammarID__Group_1__0 )*
            {
             before(grammarAccess.getGrammarIDAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:2404:2: ( rule__GrammarID__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==23) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:2404:3: rule__GrammarID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    rule__GrammarID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getGrammarIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group__1__Impl"


    // $ANTLR start "rule__GrammarID__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:2413:1: rule__GrammarID__Group_1__0 : rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 ;
    public final void rule__GrammarID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2417:1: ( rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:2418:2: rule__GrammarID__Group_1__0__Impl rule__GrammarID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GrammarID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group_1__1();

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
    // $ANTLR end "rule__GrammarID__Group_1__0"


    // $ANTLR start "rule__GrammarID__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2425:1: rule__GrammarID__Group_1__0__Impl : ( '.' ) ;
    public final void rule__GrammarID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2429:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:2430:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:2430:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:2431:2: '.'
            {
             before(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarIDAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__0__Impl"


    // $ANTLR start "rule__GrammarID__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:2440:1: rule__GrammarID__Group_1__1 : rule__GrammarID__Group_1__1__Impl ;
    public final void rule__GrammarID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2444:1: ( rule__GrammarID__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2445:2: rule__GrammarID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GrammarID__Group_1__1__Impl();

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
    // $ANTLR end "rule__GrammarID__Group_1__1"


    // $ANTLR start "rule__GrammarID__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2451:1: rule__GrammarID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__GrammarID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2455:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:2456:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:2456:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:2457:2: RULE_ID
            {
             before(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGrammarIDAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GrammarID__Group_1__1__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__0"
    // InternalXtextGrammarTestLanguage.g:2467:1: rule__GeneratedMetamodel__Group__0 : rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 ;
    public final void rule__GeneratedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2471:1: ( rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2472:2: rule__GeneratedMetamodel__Group__0__Impl rule__GeneratedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GeneratedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__1();

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
    // $ANTLR end "rule__GeneratedMetamodel__Group__0"


    // $ANTLR start "rule__GeneratedMetamodel__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2479:1: rule__GeneratedMetamodel__Group__0__Impl : ( 'generate' ) ;
    public final void rule__GeneratedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2483:1: ( ( 'generate' ) )
            // InternalXtextGrammarTestLanguage.g:2484:1: ( 'generate' )
            {
            // InternalXtextGrammarTestLanguage.g:2484:1: ( 'generate' )
            // InternalXtextGrammarTestLanguage.g:2485:2: 'generate'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 
            match(input,24,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getGenerateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__0__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__1"
    // InternalXtextGrammarTestLanguage.g:2494:1: rule__GeneratedMetamodel__Group__1 : rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 ;
    public final void rule__GeneratedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2498:1: ( rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2499:2: rule__GeneratedMetamodel__Group__1__Impl rule__GeneratedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__GeneratedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__2();

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
    // $ANTLR end "rule__GeneratedMetamodel__Group__1"


    // $ANTLR start "rule__GeneratedMetamodel__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2506:1: rule__GeneratedMetamodel__Group__1__Impl : ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2510:1: ( ( ( rule__GeneratedMetamodel__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2511:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2511:1: ( ( rule__GeneratedMetamodel__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2512:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2513:2: ( rule__GeneratedMetamodel__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2513:3: rule__GeneratedMetamodel__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__1__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__2"
    // InternalXtextGrammarTestLanguage.g:2521:1: rule__GeneratedMetamodel__Group__2 : rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 ;
    public final void rule__GeneratedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2525:1: ( rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3 )
            // InternalXtextGrammarTestLanguage.g:2526:2: rule__GeneratedMetamodel__Group__2__Impl rule__GeneratedMetamodel__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__GeneratedMetamodel__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__3();

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
    // $ANTLR end "rule__GeneratedMetamodel__Group__2"


    // $ANTLR start "rule__GeneratedMetamodel__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:2533:1: rule__GeneratedMetamodel__Group__2__Impl : ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) ;
    public final void rule__GeneratedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2537:1: ( ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:2538:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2538:1: ( ( rule__GeneratedMetamodel__EPackageAssignment_2 ) )
            // InternalXtextGrammarTestLanguage.g:2539:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 
            // InternalXtextGrammarTestLanguage.g:2540:2: ( rule__GeneratedMetamodel__EPackageAssignment_2 )
            // InternalXtextGrammarTestLanguage.g:2540:3: rule__GeneratedMetamodel__EPackageAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__EPackageAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__2__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group__3"
    // InternalXtextGrammarTestLanguage.g:2548:1: rule__GeneratedMetamodel__Group__3 : rule__GeneratedMetamodel__Group__3__Impl ;
    public final void rule__GeneratedMetamodel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2552:1: ( rule__GeneratedMetamodel__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:2553:2: rule__GeneratedMetamodel__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group__3__Impl();

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
    // $ANTLR end "rule__GeneratedMetamodel__Group__3"


    // $ANTLR start "rule__GeneratedMetamodel__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:2559:1: rule__GeneratedMetamodel__Group__3__Impl : ( ( rule__GeneratedMetamodel__Group_3__0 )? ) ;
    public final void rule__GeneratedMetamodel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2563:1: ( ( ( rule__GeneratedMetamodel__Group_3__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2564:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2564:1: ( ( rule__GeneratedMetamodel__Group_3__0 )? )
            // InternalXtextGrammarTestLanguage.g:2565:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 
            // InternalXtextGrammarTestLanguage.g:2566:2: ( rule__GeneratedMetamodel__Group_3__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==25) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2566:3: rule__GeneratedMetamodel__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__GeneratedMetamodel__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGeneratedMetamodelAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group__3__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__0"
    // InternalXtextGrammarTestLanguage.g:2575:1: rule__GeneratedMetamodel__Group_3__0 : rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 ;
    public final void rule__GeneratedMetamodel__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2579:1: ( rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1 )
            // InternalXtextGrammarTestLanguage.g:2580:2: rule__GeneratedMetamodel__Group_3__0__Impl rule__GeneratedMetamodel__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__GeneratedMetamodel__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group_3__1();

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
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__0"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2587:1: rule__GeneratedMetamodel__Group_3__0__Impl : ( 'as' ) ;
    public final void rule__GeneratedMetamodel__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2591:1: ( ( 'as' ) )
            // InternalXtextGrammarTestLanguage.g:2592:1: ( 'as' )
            {
            // InternalXtextGrammarTestLanguage.g:2592:1: ( 'as' )
            // InternalXtextGrammarTestLanguage.g:2593:2: 'as'
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__0__Impl"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__1"
    // InternalXtextGrammarTestLanguage.g:2602:1: rule__GeneratedMetamodel__Group_3__1 : rule__GeneratedMetamodel__Group_3__1__Impl ;
    public final void rule__GeneratedMetamodel__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2606:1: ( rule__GeneratedMetamodel__Group_3__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2607:2: rule__GeneratedMetamodel__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__Group_3__1__Impl();

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
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__1"


    // $ANTLR start "rule__GeneratedMetamodel__Group_3__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2613:1: rule__GeneratedMetamodel__Group_3__1__Impl : ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) ;
    public final void rule__GeneratedMetamodel__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2617:1: ( ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2618:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2618:1: ( ( rule__GeneratedMetamodel__AliasAssignment_3_1 ) )
            // InternalXtextGrammarTestLanguage.g:2619:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 
            // InternalXtextGrammarTestLanguage.g:2620:2: ( rule__GeneratedMetamodel__AliasAssignment_3_1 )
            // InternalXtextGrammarTestLanguage.g:2620:3: rule__GeneratedMetamodel__AliasAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__GeneratedMetamodel__AliasAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getGeneratedMetamodelAccess().getAliasAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__Group_3__1__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__0"
    // InternalXtextGrammarTestLanguage.g:2629:1: rule__ReferencedMetamodel__Group__0 : rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 ;
    public final void rule__ReferencedMetamodel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2633:1: ( rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2634:2: rule__ReferencedMetamodel__Group__0__Impl rule__ReferencedMetamodel__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__ReferencedMetamodel__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__1();

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
    // $ANTLR end "rule__ReferencedMetamodel__Group__0"


    // $ANTLR start "rule__ReferencedMetamodel__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2641:1: rule__ReferencedMetamodel__Group__0__Impl : ( 'import' ) ;
    public final void rule__ReferencedMetamodel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2645:1: ( ( 'import' ) )
            // InternalXtextGrammarTestLanguage.g:2646:1: ( 'import' )
            {
            // InternalXtextGrammarTestLanguage.g:2646:1: ( 'import' )
            // InternalXtextGrammarTestLanguage.g:2647:2: 'import'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferencedMetamodelAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__0__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__1"
    // InternalXtextGrammarTestLanguage.g:2656:1: rule__ReferencedMetamodel__Group__1 : rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 ;
    public final void rule__ReferencedMetamodel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2660:1: ( rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2661:2: rule__ReferencedMetamodel__Group__1__Impl rule__ReferencedMetamodel__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_14);
            rule__ReferencedMetamodel__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__2();

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
    // $ANTLR end "rule__ReferencedMetamodel__Group__1"


    // $ANTLR start "rule__ReferencedMetamodel__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2668:1: rule__ReferencedMetamodel__Group__1__Impl : ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2672:1: ( ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2673:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2673:1: ( ( rule__ReferencedMetamodel__EPackageAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:2674:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:2675:2: ( rule__ReferencedMetamodel__EPackageAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:2675:3: rule__ReferencedMetamodel__EPackageAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__EPackageAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__1__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group__2"
    // InternalXtextGrammarTestLanguage.g:2683:1: rule__ReferencedMetamodel__Group__2 : rule__ReferencedMetamodel__Group__2__Impl ;
    public final void rule__ReferencedMetamodel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2687:1: ( rule__ReferencedMetamodel__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:2688:2: rule__ReferencedMetamodel__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group__2__Impl();

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
    // $ANTLR end "rule__ReferencedMetamodel__Group__2"


    // $ANTLR start "rule__ReferencedMetamodel__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:2694:1: rule__ReferencedMetamodel__Group__2__Impl : ( ( rule__ReferencedMetamodel__Group_2__0 )? ) ;
    public final void rule__ReferencedMetamodel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2698:1: ( ( ( rule__ReferencedMetamodel__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:2699:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:2699:1: ( ( rule__ReferencedMetamodel__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:2700:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            {
             before(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:2701:2: ( rule__ReferencedMetamodel__Group_2__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==25) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2701:3: rule__ReferencedMetamodel__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__ReferencedMetamodel__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferencedMetamodelAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group__2__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:2710:1: rule__ReferencedMetamodel__Group_2__0 : rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 ;
    public final void rule__ReferencedMetamodel__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2714:1: ( rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:2715:2: rule__ReferencedMetamodel__Group_2__0__Impl rule__ReferencedMetamodel__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ReferencedMetamodel__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group_2__1();

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
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__0"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2722:1: rule__ReferencedMetamodel__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__ReferencedMetamodel__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2726:1: ( ( 'as' ) )
            // InternalXtextGrammarTestLanguage.g:2727:1: ( 'as' )
            {
            // InternalXtextGrammarTestLanguage.g:2727:1: ( 'as' )
            // InternalXtextGrammarTestLanguage.g:2728:2: 'as'
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 
            match(input,25,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferencedMetamodelAccess().getAsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__0__Impl"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__1"
    // InternalXtextGrammarTestLanguage.g:2737:1: rule__ReferencedMetamodel__Group_2__1 : rule__ReferencedMetamodel__Group_2__1__Impl ;
    public final void rule__ReferencedMetamodel__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2741:1: ( rule__ReferencedMetamodel__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:2742:2: rule__ReferencedMetamodel__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__Group_2__1__Impl();

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
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__1"


    // $ANTLR start "rule__ReferencedMetamodel__Group_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2748:1: rule__ReferencedMetamodel__Group_2__1__Impl : ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) ;
    public final void rule__ReferencedMetamodel__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2752:1: ( ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:2753:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2753:1: ( ( rule__ReferencedMetamodel__AliasAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:2754:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:2755:2: ( rule__ReferencedMetamodel__AliasAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:2755:3: rule__ReferencedMetamodel__AliasAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReferencedMetamodel__AliasAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getReferencedMetamodelAccess().getAliasAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__Group_2__1__Impl"


    // $ANTLR start "rule__ParserRule__Group__0"
    // InternalXtextGrammarTestLanguage.g:2764:1: rule__ParserRule__Group__0 : rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 ;
    public final void rule__ParserRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2768:1: ( rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:2769:2: rule__ParserRule__Group__0__Impl rule__ParserRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__ParserRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__1();

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
    // $ANTLR end "rule__ParserRule__Group__0"


    // $ANTLR start "rule__ParserRule__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2776:1: rule__ParserRule__Group__0__Impl : ( ( rule__ParserRule__Alternatives_0 ) ) ;
    public final void rule__ParserRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2780:1: ( ( ( rule__ParserRule__Alternatives_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2781:1: ( ( rule__ParserRule__Alternatives_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2781:1: ( ( rule__ParserRule__Alternatives_0 ) )
            // InternalXtextGrammarTestLanguage.g:2782:2: ( rule__ParserRule__Alternatives_0 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_0()); 
            // InternalXtextGrammarTestLanguage.g:2783:2: ( rule__ParserRule__Alternatives_0 )
            // InternalXtextGrammarTestLanguage.g:2783:3: rule__ParserRule__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__0__Impl"


    // $ANTLR start "rule__ParserRule__Group__1"
    // InternalXtextGrammarTestLanguage.g:2791:1: rule__ParserRule__Group__1 : rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 ;
    public final void rule__ParserRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2795:1: ( rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:2796:2: rule__ParserRule__Group__1__Impl rule__ParserRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_15);
            rule__ParserRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__2();

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
    // $ANTLR end "rule__ParserRule__Group__1"


    // $ANTLR start "rule__ParserRule__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2803:1: rule__ParserRule__Group__1__Impl : ( ( ruleHiddenClause )? ) ;
    public final void rule__ParserRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2807:1: ( ( ( ruleHiddenClause )? ) )
            // InternalXtextGrammarTestLanguage.g:2808:1: ( ( ruleHiddenClause )? )
            {
            // InternalXtextGrammarTestLanguage.g:2808:1: ( ( ruleHiddenClause )? )
            // InternalXtextGrammarTestLanguage.g:2809:2: ( ruleHiddenClause )?
            {
             before(grammarAccess.getParserRuleAccess().getHiddenClauseParserRuleCall_1()); 
            // InternalXtextGrammarTestLanguage.g:2810:2: ( ruleHiddenClause )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:2810:3: ruleHiddenClause
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleHiddenClause();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getHiddenClauseParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__1__Impl"


    // $ANTLR start "rule__ParserRule__Group__2"
    // InternalXtextGrammarTestLanguage.g:2818:1: rule__ParserRule__Group__2 : rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 ;
    public final void rule__ParserRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2822:1: ( rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:2823:2: rule__ParserRule__Group__2__Impl rule__ParserRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ParserRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__3();

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
    // $ANTLR end "rule__ParserRule__Group__2"


    // $ANTLR start "rule__ParserRule__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:2830:1: rule__ParserRule__Group__2__Impl : ( ':' ) ;
    public final void rule__ParserRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2834:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:2835:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:2835:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:2836:2: ':'
            {
             before(grammarAccess.getParserRuleAccess().getColonKeyword_2()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__2__Impl"


    // $ANTLR start "rule__ParserRule__Group__3"
    // InternalXtextGrammarTestLanguage.g:2845:1: rule__ParserRule__Group__3 : rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 ;
    public final void rule__ParserRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2849:1: ( rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:2850:2: rule__ParserRule__Group__3__Impl rule__ParserRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__ParserRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__4();

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
    // $ANTLR end "rule__ParserRule__Group__3"


    // $ANTLR start "rule__ParserRule__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:2857:1: rule__ParserRule__Group__3__Impl : ( ( rule__ParserRule__AlternativesAssignment_3 ) ) ;
    public final void rule__ParserRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2861:1: ( ( ( rule__ParserRule__AlternativesAssignment_3 ) ) )
            // InternalXtextGrammarTestLanguage.g:2862:1: ( ( rule__ParserRule__AlternativesAssignment_3 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2862:1: ( ( rule__ParserRule__AlternativesAssignment_3 ) )
            // InternalXtextGrammarTestLanguage.g:2863:2: ( rule__ParserRule__AlternativesAssignment_3 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAssignment_3()); 
            // InternalXtextGrammarTestLanguage.g:2864:2: ( rule__ParserRule__AlternativesAssignment_3 )
            // InternalXtextGrammarTestLanguage.g:2864:3: rule__ParserRule__AlternativesAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__AlternativesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternativesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__3__Impl"


    // $ANTLR start "rule__ParserRule__Group__4"
    // InternalXtextGrammarTestLanguage.g:2872:1: rule__ParserRule__Group__4 : rule__ParserRule__Group__4__Impl ;
    public final void rule__ParserRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2876:1: ( rule__ParserRule__Group__4__Impl )
            // InternalXtextGrammarTestLanguage.g:2877:2: rule__ParserRule__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group__4__Impl();

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
    // $ANTLR end "rule__ParserRule__Group__4"


    // $ANTLR start "rule__ParserRule__Group__4__Impl"
    // InternalXtextGrammarTestLanguage.g:2883:1: rule__ParserRule__Group__4__Impl : ( ';' ) ;
    public final void rule__ParserRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2887:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:2888:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:2888:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:2889:2: ';'
            {
             before(grammarAccess.getParserRuleAccess().getSemicolonKeyword_4()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group__4__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_0__0"
    // InternalXtextGrammarTestLanguage.g:2899:1: rule__ParserRule__Group_0_0__0 : rule__ParserRule__Group_0_0__0__Impl rule__ParserRule__Group_0_0__1 ;
    public final void rule__ParserRule__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2903:1: ( rule__ParserRule__Group_0_0__0__Impl rule__ParserRule__Group_0_0__1 )
            // InternalXtextGrammarTestLanguage.g:2904:2: rule__ParserRule__Group_0_0__0__Impl rule__ParserRule__Group_0_0__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__ParserRule__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0__1();

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
    // $ANTLR end "rule__ParserRule__Group_0_0__0"


    // $ANTLR start "rule__ParserRule__Group_0_0__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2911:1: rule__ParserRule__Group_0_0__0__Impl : ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) ) ;
    public final void rule__ParserRule__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2915:1: ( ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:2916:1: ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2916:1: ( ( rule__ParserRule__FragmentAssignment_0_0_0 ) )
            // InternalXtextGrammarTestLanguage.g:2917:2: ( rule__ParserRule__FragmentAssignment_0_0_0 )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentAssignment_0_0_0()); 
            // InternalXtextGrammarTestLanguage.g:2918:2: ( rule__ParserRule__FragmentAssignment_0_0_0 )
            // InternalXtextGrammarTestLanguage.g:2918:3: rule__ParserRule__FragmentAssignment_0_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__FragmentAssignment_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getFragmentAssignment_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_0__1"
    // InternalXtextGrammarTestLanguage.g:2926:1: rule__ParserRule__Group_0_0__1 : rule__ParserRule__Group_0_0__1__Impl rule__ParserRule__Group_0_0__2 ;
    public final void rule__ParserRule__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2930:1: ( rule__ParserRule__Group_0_0__1__Impl rule__ParserRule__Group_0_0__2 )
            // InternalXtextGrammarTestLanguage.g:2931:2: rule__ParserRule__Group_0_0__1__Impl rule__ParserRule__Group_0_0__2
            {
            pushFollow(FollowSets000.FOLLOW_19);
            rule__ParserRule__Group_0_0__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0__2();

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
    // $ANTLR end "rule__ParserRule__Group_0_0__1"


    // $ANTLR start "rule__ParserRule__Group_0_0__1__Impl"
    // InternalXtextGrammarTestLanguage.g:2938:1: rule__ParserRule__Group_0_0__1__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2942:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtextGrammarTestLanguage.g:2943:1: ( ruleRuleNameAndParams )
            {
            // InternalXtextGrammarTestLanguage.g:2943:1: ( ruleRuleNameAndParams )
            // InternalXtextGrammarTestLanguage.g:2944:2: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0__1__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_0__2"
    // InternalXtextGrammarTestLanguage.g:2953:1: rule__ParserRule__Group_0_0__2 : rule__ParserRule__Group_0_0__2__Impl ;
    public final void rule__ParserRule__Group_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2957:1: ( rule__ParserRule__Group_0_0__2__Impl )
            // InternalXtextGrammarTestLanguage.g:2958:2: rule__ParserRule__Group_0_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_0__2__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_0_0__2"


    // $ANTLR start "rule__ParserRule__Group_0_0__2__Impl"
    // InternalXtextGrammarTestLanguage.g:2964:1: rule__ParserRule__Group_0_0__2__Impl : ( ( rule__ParserRule__Alternatives_0_0_2 ) ) ;
    public final void rule__ParserRule__Group_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2968:1: ( ( ( rule__ParserRule__Alternatives_0_0_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:2969:1: ( ( rule__ParserRule__Alternatives_0_0_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:2969:1: ( ( rule__ParserRule__Alternatives_0_0_2 ) )
            // InternalXtextGrammarTestLanguage.g:2970:2: ( rule__ParserRule__Alternatives_0_0_2 )
            {
             before(grammarAccess.getParserRuleAccess().getAlternatives_0_0_2()); 
            // InternalXtextGrammarTestLanguage.g:2971:2: ( rule__ParserRule__Alternatives_0_0_2 )
            // InternalXtextGrammarTestLanguage.g:2971:3: rule__ParserRule__Alternatives_0_0_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Alternatives_0_0_2();

            state._fsp--;


            }

             after(grammarAccess.getParserRuleAccess().getAlternatives_0_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_0__2__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_1__0"
    // InternalXtextGrammarTestLanguage.g:2980:1: rule__ParserRule__Group_0_1__0 : rule__ParserRule__Group_0_1__0__Impl rule__ParserRule__Group_0_1__1 ;
    public final void rule__ParserRule__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2984:1: ( rule__ParserRule__Group_0_1__0__Impl rule__ParserRule__Group_0_1__1 )
            // InternalXtextGrammarTestLanguage.g:2985:2: rule__ParserRule__Group_0_1__0__Impl rule__ParserRule__Group_0_1__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__ParserRule__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_1__1();

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
    // $ANTLR end "rule__ParserRule__Group_0_1__0"


    // $ANTLR start "rule__ParserRule__Group_0_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:2992:1: rule__ParserRule__Group_0_1__0__Impl : ( ruleRuleNameAndParams ) ;
    public final void rule__ParserRule__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:2996:1: ( ( ruleRuleNameAndParams ) )
            // InternalXtextGrammarTestLanguage.g:2997:1: ( ruleRuleNameAndParams )
            {
            // InternalXtextGrammarTestLanguage.g:2997:1: ( ruleRuleNameAndParams )
            // InternalXtextGrammarTestLanguage.g:2998:2: ruleRuleNameAndParams
            {
             before(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleNameAndParams();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getRuleNameAndParamsParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_1__0__Impl"


    // $ANTLR start "rule__ParserRule__Group_0_1__1"
    // InternalXtextGrammarTestLanguage.g:3007:1: rule__ParserRule__Group_0_1__1 : rule__ParserRule__Group_0_1__1__Impl ;
    public final void rule__ParserRule__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3011:1: ( rule__ParserRule__Group_0_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3012:2: rule__ParserRule__Group_0_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParserRule__Group_0_1__1__Impl();

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
    // $ANTLR end "rule__ParserRule__Group_0_1__1"


    // $ANTLR start "rule__ParserRule__Group_0_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3018:1: rule__ParserRule__Group_0_1__1__Impl : ( ( ruleReturnsClause )? ) ;
    public final void rule__ParserRule__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3022:1: ( ( ( ruleReturnsClause )? ) )
            // InternalXtextGrammarTestLanguage.g:3023:1: ( ( ruleReturnsClause )? )
            {
            // InternalXtextGrammarTestLanguage.g:3023:1: ( ( ruleReturnsClause )? )
            // InternalXtextGrammarTestLanguage.g:3024:2: ( ruleReturnsClause )?
            {
             before(grammarAccess.getParserRuleAccess().getReturnsClauseParserRuleCall_0_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3025:2: ( ruleReturnsClause )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==31) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3025:3: ruleReturnsClause
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReturnsClause();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParserRuleAccess().getReturnsClauseParserRuleCall_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__Group_0_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group__0"
    // InternalXtextGrammarTestLanguage.g:3034:1: rule__RuleNameAndParams__Group__0 : rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 ;
    public final void rule__RuleNameAndParams__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3038:1: ( rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3039:2: rule__RuleNameAndParams__Group__0__Impl rule__RuleNameAndParams__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__RuleNameAndParams__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group__0"


    // $ANTLR start "rule__RuleNameAndParams__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3046:1: rule__RuleNameAndParams__Group__0__Impl : ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) ;
    public final void rule__RuleNameAndParams__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3050:1: ( ( ( rule__RuleNameAndParams__NameAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:3051:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3051:1: ( ( rule__RuleNameAndParams__NameAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:3052:2: ( rule__RuleNameAndParams__NameAssignment_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:3053:2: ( rule__RuleNameAndParams__NameAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:3053:3: rule__RuleNameAndParams__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group__1"
    // InternalXtextGrammarTestLanguage.g:3061:1: rule__RuleNameAndParams__Group__1 : rule__RuleNameAndParams__Group__1__Impl ;
    public final void rule__RuleNameAndParams__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3065:1: ( rule__RuleNameAndParams__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3066:2: rule__RuleNameAndParams__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group__1__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group__1"


    // $ANTLR start "rule__RuleNameAndParams__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3072:1: rule__RuleNameAndParams__Group__1__Impl : ( ( rule__RuleNameAndParams__Group_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3076:1: ( ( ( rule__RuleNameAndParams__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3077:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3077:1: ( ( rule__RuleNameAndParams__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3078:2: ( rule__RuleNameAndParams__Group_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3079:2: ( rule__RuleNameAndParams__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==29) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3079:3: rule__RuleNameAndParams__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleNameAndParams__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:3088:1: rule__RuleNameAndParams__Group_1__0 : rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 ;
    public final void rule__RuleNameAndParams__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3092:1: ( rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3093:2: rule__RuleNameAndParams__Group_1__0__Impl rule__RuleNameAndParams__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__RuleNameAndParams__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3100:1: rule__RuleNameAndParams__Group_1__0__Impl : ( '[' ) ;
    public final void rule__RuleNameAndParams__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3104:1: ( ( '[' ) )
            // InternalXtextGrammarTestLanguage.g:3105:1: ( '[' )
            {
            // InternalXtextGrammarTestLanguage.g:3105:1: ( '[' )
            // InternalXtextGrammarTestLanguage.g:3106:2: '['
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:3115:1: rule__RuleNameAndParams__Group_1__1 : rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 ;
    public final void rule__RuleNameAndParams__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3119:1: ( rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2 )
            // InternalXtextGrammarTestLanguage.g:3120:2: rule__RuleNameAndParams__Group_1__1__Impl rule__RuleNameAndParams__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_22);
            rule__RuleNameAndParams__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__2();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3127:1: rule__RuleNameAndParams__Group_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) ;
    public final void rule__RuleNameAndParams__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3131:1: ( ( ( rule__RuleNameAndParams__Group_1_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3132:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3132:1: ( ( rule__RuleNameAndParams__Group_1_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3133:2: ( rule__RuleNameAndParams__Group_1_1__0 )?
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3134:2: ( rule__RuleNameAndParams__Group_1_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3134:3: rule__RuleNameAndParams__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleNameAndParams__Group_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__2"
    // InternalXtextGrammarTestLanguage.g:3142:1: rule__RuleNameAndParams__Group_1__2 : rule__RuleNameAndParams__Group_1__2__Impl ;
    public final void rule__RuleNameAndParams__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3146:1: ( rule__RuleNameAndParams__Group_1__2__Impl )
            // InternalXtextGrammarTestLanguage.g:3147:2: rule__RuleNameAndParams__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1__2__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1__2"


    // $ANTLR start "rule__RuleNameAndParams__Group_1__2__Impl"
    // InternalXtextGrammarTestLanguage.g:3153:1: rule__RuleNameAndParams__Group_1__2__Impl : ( ']' ) ;
    public final void rule__RuleNameAndParams__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3157:1: ( ( ']' ) )
            // InternalXtextGrammarTestLanguage.g:3158:1: ( ']' )
            {
            // InternalXtextGrammarTestLanguage.g:3158:1: ( ']' )
            // InternalXtextGrammarTestLanguage.g:3159:2: ']'
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getRightSquareBracketKeyword_1_2()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getRightSquareBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1__2__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:3169:1: rule__RuleNameAndParams__Group_1_1__0 : rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3173:1: ( rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:3174:2: rule__RuleNameAndParams__Group_1_1__0__Impl rule__RuleNameAndParams__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__RuleNameAndParams__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3181:1: rule__RuleNameAndParams__Group_1_1__0__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3185:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:3186:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3186:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:3187:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3188:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_0 )
            // InternalXtextGrammarTestLanguage.g:3188:3: rule__RuleNameAndParams__ParametersAssignment_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__ParametersAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:3196:1: rule__RuleNameAndParams__Group_1_1__1 : rule__RuleNameAndParams__Group_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3200:1: ( rule__RuleNameAndParams__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3201:2: rule__RuleNameAndParams__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3207:1: rule__RuleNameAndParams__Group_1_1__1__Impl : ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) ;
    public final void rule__RuleNameAndParams__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3211:1: ( ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:3212:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:3212:1: ( ( rule__RuleNameAndParams__Group_1_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:3213:2: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3214:2: ( rule__RuleNameAndParams__Group_1_1_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==20) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:3214:3: rule__RuleNameAndParams__Group_1_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__RuleNameAndParams__Group_1_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getRuleNameAndParamsAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1__1__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__0"
    // InternalXtextGrammarTestLanguage.g:3223:1: rule__RuleNameAndParams__Group_1_1_1__0 : rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3227:1: ( rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:3228:2: rule__RuleNameAndParams__Group_1_1_1__0__Impl rule__RuleNameAndParams__Group_1_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__RuleNameAndParams__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1_1__1();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__0"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3235:1: rule__RuleNameAndParams__Group_1_1_1__0__Impl : ( ',' ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3239:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:3240:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:3240:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:3241:2: ','
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getCommaKeyword_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__1"
    // InternalXtextGrammarTestLanguage.g:3250:1: rule__RuleNameAndParams__Group_1_1_1__1 : rule__RuleNameAndParams__Group_1_1_1__1__Impl ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3254:1: ( rule__RuleNameAndParams__Group_1_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3255:2: rule__RuleNameAndParams__Group_1_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__Group_1_1_1__1__Impl();

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
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__1"


    // $ANTLR start "rule__RuleNameAndParams__Group_1_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3261:1: rule__RuleNameAndParams__Group_1_1_1__1__Impl : ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) ;
    public final void rule__RuleNameAndParams__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3265:1: ( ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3266:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3266:1: ( ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:3267:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3268:2: ( rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:3268:3: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleNameAndParams__ParametersAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersAssignment_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__ReturnsClause__Group__0"
    // InternalXtextGrammarTestLanguage.g:3277:1: rule__ReturnsClause__Group__0 : rule__ReturnsClause__Group__0__Impl rule__ReturnsClause__Group__1 ;
    public final void rule__ReturnsClause__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3281:1: ( rule__ReturnsClause__Group__0__Impl rule__ReturnsClause__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3282:2: rule__ReturnsClause__Group__0__Impl rule__ReturnsClause__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ReturnsClause__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReturnsClause__Group__1();

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
    // $ANTLR end "rule__ReturnsClause__Group__0"


    // $ANTLR start "rule__ReturnsClause__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3289:1: rule__ReturnsClause__Group__0__Impl : ( 'returns' ) ;
    public final void rule__ReturnsClause__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3293:1: ( ( 'returns' ) )
            // InternalXtextGrammarTestLanguage.g:3294:1: ( 'returns' )
            {
            // InternalXtextGrammarTestLanguage.g:3294:1: ( 'returns' )
            // InternalXtextGrammarTestLanguage.g:3295:2: 'returns'
            {
             before(grammarAccess.getReturnsClauseAccess().getReturnsKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReturnsClauseAccess().getReturnsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReturnsClause__Group__0__Impl"


    // $ANTLR start "rule__ReturnsClause__Group__1"
    // InternalXtextGrammarTestLanguage.g:3304:1: rule__ReturnsClause__Group__1 : rule__ReturnsClause__Group__1__Impl ;
    public final void rule__ReturnsClause__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3308:1: ( rule__ReturnsClause__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3309:2: rule__ReturnsClause__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReturnsClause__Group__1__Impl();

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
    // $ANTLR end "rule__ReturnsClause__Group__1"


    // $ANTLR start "rule__ReturnsClause__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3315:1: rule__ReturnsClause__Group__1__Impl : ( ( rule__ReturnsClause__TypeAssignment_1 ) ) ;
    public final void rule__ReturnsClause__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3319:1: ( ( ( rule__ReturnsClause__TypeAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3320:1: ( ( rule__ReturnsClause__TypeAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3320:1: ( ( rule__ReturnsClause__TypeAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3321:2: ( rule__ReturnsClause__TypeAssignment_1 )
            {
             before(grammarAccess.getReturnsClauseAccess().getTypeAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3322:2: ( rule__ReturnsClause__TypeAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3322:3: rule__ReturnsClause__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ReturnsClause__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReturnsClauseAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReturnsClause__Group__1__Impl"


    // $ANTLR start "rule__TypeRef__Group__0"
    // InternalXtextGrammarTestLanguage.g:3331:1: rule__TypeRef__Group__0 : rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 ;
    public final void rule__TypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3335:1: ( rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3336:2: rule__TypeRef__Group__0__Impl rule__TypeRef__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TypeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group__1();

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
    // $ANTLR end "rule__TypeRef__Group__0"


    // $ANTLR start "rule__TypeRef__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3343:1: rule__TypeRef__Group__0__Impl : ( ( rule__TypeRef__Group_0__0 )? ) ;
    public final void rule__TypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3347:1: ( ( ( rule__TypeRef__Group_0__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3348:1: ( ( rule__TypeRef__Group_0__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3348:1: ( ( rule__TypeRef__Group_0__0 )? )
            // InternalXtextGrammarTestLanguage.g:3349:2: ( rule__TypeRef__Group_0__0 )?
            {
             before(grammarAccess.getTypeRefAccess().getGroup_0()); 
            // InternalXtextGrammarTestLanguage.g:3350:2: ( rule__TypeRef__Group_0__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==32) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3350:3: rule__TypeRef__Group_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TypeRef__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTypeRefAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__0__Impl"


    // $ANTLR start "rule__TypeRef__Group__1"
    // InternalXtextGrammarTestLanguage.g:3358:1: rule__TypeRef__Group__1 : rule__TypeRef__Group__1__Impl ;
    public final void rule__TypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3362:1: ( rule__TypeRef__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3363:2: rule__TypeRef__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group__1__Impl();

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
    // $ANTLR end "rule__TypeRef__Group__1"


    // $ANTLR start "rule__TypeRef__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3369:1: rule__TypeRef__Group__1__Impl : ( ( rule__TypeRef__ClassifierAssignment_1 ) ) ;
    public final void rule__TypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3373:1: ( ( ( rule__TypeRef__ClassifierAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3374:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3374:1: ( ( rule__TypeRef__ClassifierAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:3375:2: ( rule__TypeRef__ClassifierAssignment_1 )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:3376:2: ( rule__TypeRef__ClassifierAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:3376:3: rule__TypeRef__ClassifierAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__ClassifierAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getClassifierAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group__1__Impl"


    // $ANTLR start "rule__TypeRef__Group_0__0"
    // InternalXtextGrammarTestLanguage.g:3385:1: rule__TypeRef__Group_0__0 : rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 ;
    public final void rule__TypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3389:1: ( rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1 )
            // InternalXtextGrammarTestLanguage.g:3390:2: rule__TypeRef__Group_0__0__Impl rule__TypeRef__Group_0__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__TypeRef__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group_0__1();

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
    // $ANTLR end "rule__TypeRef__Group_0__0"


    // $ANTLR start "rule__TypeRef__Group_0__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3397:1: rule__TypeRef__Group_0__0__Impl : ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) ;
    public final void rule__TypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3401:1: ( ( ( rule__TypeRef__MetamodelAssignment_0_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:3402:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3402:1: ( ( rule__TypeRef__MetamodelAssignment_0_0 ) )
            // InternalXtextGrammarTestLanguage.g:3403:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 
            // InternalXtextGrammarTestLanguage.g:3404:2: ( rule__TypeRef__MetamodelAssignment_0_0 )
            // InternalXtextGrammarTestLanguage.g:3404:3: rule__TypeRef__MetamodelAssignment_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__MetamodelAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__0__Impl"


    // $ANTLR start "rule__TypeRef__Group_0__1"
    // InternalXtextGrammarTestLanguage.g:3412:1: rule__TypeRef__Group_0__1 : rule__TypeRef__Group_0__1__Impl ;
    public final void rule__TypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3416:1: ( rule__TypeRef__Group_0__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3417:2: rule__TypeRef__Group_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TypeRef__Group_0__1__Impl();

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
    // $ANTLR end "rule__TypeRef__Group_0__1"


    // $ANTLR start "rule__TypeRef__Group_0__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3423:1: rule__TypeRef__Group_0__1__Impl : ( '::' ) ;
    public final void rule__TypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3427:1: ( ( '::' ) )
            // InternalXtextGrammarTestLanguage.g:3428:1: ( '::' )
            {
            // InternalXtextGrammarTestLanguage.g:3428:1: ( '::' )
            // InternalXtextGrammarTestLanguage.g:3429:2: '::'
            {
             before(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeRefAccess().getColonColonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__Group_0__1__Impl"


    // $ANTLR start "rule__Alternatives__Group__0"
    // InternalXtextGrammarTestLanguage.g:3439:1: rule__Alternatives__Group__0 : rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 ;
    public final void rule__Alternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3443:1: ( rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3444:2: rule__Alternatives__Group__0__Impl rule__Alternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__Alternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group__1();

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
    // $ANTLR end "rule__Alternatives__Group__0"


    // $ANTLR start "rule__Alternatives__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3451:1: rule__Alternatives__Group__0__Impl : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3455:1: ( ( ruleConditionalBranch ) )
            // InternalXtextGrammarTestLanguage.g:3456:1: ( ruleConditionalBranch )
            {
            // InternalXtextGrammarTestLanguage.g:3456:1: ( ruleConditionalBranch )
            // InternalXtextGrammarTestLanguage.g:3457:2: ruleConditionalBranch
            {
             before(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getAlternativesAccess().getConditionalBranchParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__0__Impl"


    // $ANTLR start "rule__Alternatives__Group__1"
    // InternalXtextGrammarTestLanguage.g:3466:1: rule__Alternatives__Group__1 : rule__Alternatives__Group__1__Impl ;
    public final void rule__Alternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3470:1: ( rule__Alternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3471:2: rule__Alternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group__1__Impl();

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
    // $ANTLR end "rule__Alternatives__Group__1"


    // $ANTLR start "rule__Alternatives__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3477:1: rule__Alternatives__Group__1__Impl : ( ( rule__Alternatives__Group_1__0 )? ) ;
    public final void rule__Alternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3481:1: ( ( ( rule__Alternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3482:1: ( ( rule__Alternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3482:1: ( ( rule__Alternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3483:2: ( rule__Alternatives__Group_1__0 )?
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3484:2: ( rule__Alternatives__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==33) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3484:3: rule__Alternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Alternatives__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativesAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group__1__Impl"


    // $ANTLR start "rule__Alternatives__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:3493:1: rule__Alternatives__Group_1__0 : rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 ;
    public final void rule__Alternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3497:1: ( rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3498:2: rule__Alternatives__Group_1__0__Impl rule__Alternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__Alternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1__1();

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
    // $ANTLR end "rule__Alternatives__Group_1__0"


    // $ANTLR start "rule__Alternatives__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3505:1: rule__Alternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__Alternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3509:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:3510:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:3510:1: ( () )
            // InternalXtextGrammarTestLanguage.g:3511:2: ()
            {
             before(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3512:2: ()
            // InternalXtextGrammarTestLanguage.g:3512:3: 
            {
            }

             after(grammarAccess.getAlternativesAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1__0__Impl"


    // $ANTLR start "rule__Alternatives__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:3520:1: rule__Alternatives__Group_1__1 : rule__Alternatives__Group_1__1__Impl ;
    public final void rule__Alternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3524:1: ( rule__Alternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3525:2: rule__Alternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1__1__Impl();

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
    // $ANTLR end "rule__Alternatives__Group_1__1"


    // $ANTLR start "rule__Alternatives__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3531:1: rule__Alternatives__Group_1__1__Impl : ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) ;
    public final void rule__Alternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3535:1: ( ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:3536:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:3536:1: ( ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:3537:2: ( ( rule__Alternatives__Group_1_1__0 ) ) ( ( rule__Alternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:3537:2: ( ( rule__Alternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:3538:3: ( rule__Alternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3539:3: ( rule__Alternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:3539:4: rule__Alternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__Alternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:3542:2: ( ( rule__Alternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:3543:3: ( rule__Alternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3544:3: ( rule__Alternatives__Group_1_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==33) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:3544:4: rule__Alternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_25);
            	    rule__Alternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getAlternativesAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__Alternatives__Group_1__1__Impl"


    // $ANTLR start "rule__Alternatives__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:3554:1: rule__Alternatives__Group_1_1__0 : rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 ;
    public final void rule__Alternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3558:1: ( rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:3559:2: rule__Alternatives__Group_1_1__0__Impl rule__Alternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__Alternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1_1__1();

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
    // $ANTLR end "rule__Alternatives__Group_1_1__0"


    // $ANTLR start "rule__Alternatives__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3566:1: rule__Alternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__Alternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3570:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:3571:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:3571:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:3572:2: '|'
            {
             before(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__Alternatives__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:3581:1: rule__Alternatives__Group_1_1__1 : rule__Alternatives__Group_1_1__1__Impl ;
    public final void rule__Alternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3585:1: ( rule__Alternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3586:2: rule__Alternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__Alternatives__Group_1_1__1"


    // $ANTLR start "rule__Alternatives__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3592:1: rule__Alternatives__Group_1_1__1__Impl : ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__Alternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3596:1: ( ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3597:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3597:1: ( ( rule__Alternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:3598:2: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3599:2: ( rule__Alternatives__ElementsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:3599:3: rule__Alternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Alternatives__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:3608:1: rule__ConditionalBranch__Group_1__0 : rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 ;
    public final void rule__ConditionalBranch__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3612:1: ( rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3613:2: rule__ConditionalBranch__Group_1__0__Impl rule__ConditionalBranch__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ConditionalBranch__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__1();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__0"


    // $ANTLR start "rule__ConditionalBranch__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3620:1: rule__ConditionalBranch__Group_1__0__Impl : ( () ) ;
    public final void rule__ConditionalBranch__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3624:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:3625:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:3625:1: ( () )
            // InternalXtextGrammarTestLanguage.g:3626:2: ()
            {
             before(grammarAccess.getConditionalBranchAccess().getConditionalBranchAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3627:2: ()
            // InternalXtextGrammarTestLanguage.g:3627:3: 
            {
            }

             after(grammarAccess.getConditionalBranchAccess().getConditionalBranchAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__0__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:3635:1: rule__ConditionalBranch__Group_1__1 : rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 ;
    public final void rule__ConditionalBranch__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3639:1: ( rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2 )
            // InternalXtextGrammarTestLanguage.g:3640:2: rule__ConditionalBranch__Group_1__1__Impl rule__ConditionalBranch__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_26);
            rule__ConditionalBranch__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__2();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__1"


    // $ANTLR start "rule__ConditionalBranch__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3647:1: rule__ConditionalBranch__Group_1__1__Impl : ( '[' ) ;
    public final void rule__ConditionalBranch__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3651:1: ( ( '[' ) )
            // InternalXtextGrammarTestLanguage.g:3652:1: ( '[' )
            {
            // InternalXtextGrammarTestLanguage.g:3652:1: ( '[' )
            // InternalXtextGrammarTestLanguage.g:3653:2: '['
            {
             before(grammarAccess.getConditionalBranchAccess().getLeftSquareBracketKeyword_1_1()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConditionalBranchAccess().getLeftSquareBracketKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__1__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__2"
    // InternalXtextGrammarTestLanguage.g:3662:1: rule__ConditionalBranch__Group_1__2 : rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 ;
    public final void rule__ConditionalBranch__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3666:1: ( rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3 )
            // InternalXtextGrammarTestLanguage.g:3667:2: rule__ConditionalBranch__Group_1__2__Impl rule__ConditionalBranch__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__ConditionalBranch__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__3();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__2"


    // $ANTLR start "rule__ConditionalBranch__Group_1__2__Impl"
    // InternalXtextGrammarTestLanguage.g:3674:1: rule__ConditionalBranch__Group_1__2__Impl : ( ( rule__ConditionalBranch__FilteredAssignment_1_2 ) ) ;
    public final void rule__ConditionalBranch__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3678:1: ( ( ( rule__ConditionalBranch__FilteredAssignment_1_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:3679:1: ( ( rule__ConditionalBranch__FilteredAssignment_1_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3679:1: ( ( rule__ConditionalBranch__FilteredAssignment_1_2 ) )
            // InternalXtextGrammarTestLanguage.g:3680:2: ( rule__ConditionalBranch__FilteredAssignment_1_2 )
            {
             before(grammarAccess.getConditionalBranchAccess().getFilteredAssignment_1_2()); 
            // InternalXtextGrammarTestLanguage.g:3681:2: ( rule__ConditionalBranch__FilteredAssignment_1_2 )
            // InternalXtextGrammarTestLanguage.g:3681:3: rule__ConditionalBranch__FilteredAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__FilteredAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getFilteredAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__2__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__3"
    // InternalXtextGrammarTestLanguage.g:3689:1: rule__ConditionalBranch__Group_1__3 : rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 ;
    public final void rule__ConditionalBranch__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3693:1: ( rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4 )
            // InternalXtextGrammarTestLanguage.g:3694:2: rule__ConditionalBranch__Group_1__3__Impl rule__ConditionalBranch__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_27);
            rule__ConditionalBranch__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__4();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__3"


    // $ANTLR start "rule__ConditionalBranch__Group_1__3__Impl"
    // InternalXtextGrammarTestLanguage.g:3701:1: rule__ConditionalBranch__Group_1__3__Impl : ( ( rule__ConditionalBranch__ParameterAssignment_1_3 ) ) ;
    public final void rule__ConditionalBranch__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3705:1: ( ( ( rule__ConditionalBranch__ParameterAssignment_1_3 ) ) )
            // InternalXtextGrammarTestLanguage.g:3706:1: ( ( rule__ConditionalBranch__ParameterAssignment_1_3 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3706:1: ( ( rule__ConditionalBranch__ParameterAssignment_1_3 ) )
            // InternalXtextGrammarTestLanguage.g:3707:2: ( rule__ConditionalBranch__ParameterAssignment_1_3 )
            {
             before(grammarAccess.getConditionalBranchAccess().getParameterAssignment_1_3()); 
            // InternalXtextGrammarTestLanguage.g:3708:2: ( rule__ConditionalBranch__ParameterAssignment_1_3 )
            // InternalXtextGrammarTestLanguage.g:3708:3: rule__ConditionalBranch__ParameterAssignment_1_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__ParameterAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getParameterAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__3__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__4"
    // InternalXtextGrammarTestLanguage.g:3716:1: rule__ConditionalBranch__Group_1__4 : rule__ConditionalBranch__Group_1__4__Impl rule__ConditionalBranch__Group_1__5 ;
    public final void rule__ConditionalBranch__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3720:1: ( rule__ConditionalBranch__Group_1__4__Impl rule__ConditionalBranch__Group_1__5 )
            // InternalXtextGrammarTestLanguage.g:3721:2: rule__ConditionalBranch__Group_1__4__Impl rule__ConditionalBranch__Group_1__5
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__ConditionalBranch__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__5();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__4"


    // $ANTLR start "rule__ConditionalBranch__Group_1__4__Impl"
    // InternalXtextGrammarTestLanguage.g:3728:1: rule__ConditionalBranch__Group_1__4__Impl : ( ']' ) ;
    public final void rule__ConditionalBranch__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3732:1: ( ( ']' ) )
            // InternalXtextGrammarTestLanguage.g:3733:1: ( ']' )
            {
            // InternalXtextGrammarTestLanguage.g:3733:1: ( ']' )
            // InternalXtextGrammarTestLanguage.g:3734:2: ']'
            {
             before(grammarAccess.getConditionalBranchAccess().getRightSquareBracketKeyword_1_4()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConditionalBranchAccess().getRightSquareBracketKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__4__Impl"


    // $ANTLR start "rule__ConditionalBranch__Group_1__5"
    // InternalXtextGrammarTestLanguage.g:3743:1: rule__ConditionalBranch__Group_1__5 : rule__ConditionalBranch__Group_1__5__Impl ;
    public final void rule__ConditionalBranch__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3747:1: ( rule__ConditionalBranch__Group_1__5__Impl )
            // InternalXtextGrammarTestLanguage.g:3748:2: rule__ConditionalBranch__Group_1__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__Group_1__5__Impl();

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
    // $ANTLR end "rule__ConditionalBranch__Group_1__5"


    // $ANTLR start "rule__ConditionalBranch__Group_1__5__Impl"
    // InternalXtextGrammarTestLanguage.g:3754:1: rule__ConditionalBranch__Group_1__5__Impl : ( ( rule__ConditionalBranch__GuardedElementAssignment_1_5 ) ) ;
    public final void rule__ConditionalBranch__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3758:1: ( ( ( rule__ConditionalBranch__GuardedElementAssignment_1_5 ) ) )
            // InternalXtextGrammarTestLanguage.g:3759:1: ( ( rule__ConditionalBranch__GuardedElementAssignment_1_5 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3759:1: ( ( rule__ConditionalBranch__GuardedElementAssignment_1_5 ) )
            // InternalXtextGrammarTestLanguage.g:3760:2: ( rule__ConditionalBranch__GuardedElementAssignment_1_5 )
            {
             before(grammarAccess.getConditionalBranchAccess().getGuardedElementAssignment_1_5()); 
            // InternalXtextGrammarTestLanguage.g:3761:2: ( rule__ConditionalBranch__GuardedElementAssignment_1_5 )
            // InternalXtextGrammarTestLanguage.g:3761:3: rule__ConditionalBranch__GuardedElementAssignment_1_5
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ConditionalBranch__GuardedElementAssignment_1_5();

            state._fsp--;


            }

             after(grammarAccess.getConditionalBranchAccess().getGuardedElementAssignment_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__Group_1__5__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group__0"
    // InternalXtextGrammarTestLanguage.g:3770:1: rule__UnorderedGroup__Group__0 : rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 ;
    public final void rule__UnorderedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3774:1: ( rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3775:2: rule__UnorderedGroup__Group__0__Impl rule__UnorderedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__UnorderedGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group__1();

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
    // $ANTLR end "rule__UnorderedGroup__Group__0"


    // $ANTLR start "rule__UnorderedGroup__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3782:1: rule__UnorderedGroup__Group__0__Impl : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3786:1: ( ( ruleGroup ) )
            // InternalXtextGrammarTestLanguage.g:3787:1: ( ruleGroup )
            {
            // InternalXtextGrammarTestLanguage.g:3787:1: ( ruleGroup )
            // InternalXtextGrammarTestLanguage.g:3788:2: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getUnorderedGroupAccess().getGroupParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group__1"
    // InternalXtextGrammarTestLanguage.g:3797:1: rule__UnorderedGroup__Group__1 : rule__UnorderedGroup__Group__1__Impl ;
    public final void rule__UnorderedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3801:1: ( rule__UnorderedGroup__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3802:2: rule__UnorderedGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group__1__Impl();

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
    // $ANTLR end "rule__UnorderedGroup__Group__1"


    // $ANTLR start "rule__UnorderedGroup__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3808:1: rule__UnorderedGroup__Group__1__Impl : ( ( rule__UnorderedGroup__Group_1__0 )? ) ;
    public final void rule__UnorderedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3812:1: ( ( ( rule__UnorderedGroup__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3813:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3813:1: ( ( rule__UnorderedGroup__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3814:2: ( rule__UnorderedGroup__Group_1__0 )?
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3815:2: ( rule__UnorderedGroup__Group_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3815:3: rule__UnorderedGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__UnorderedGroup__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group__1__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:3824:1: rule__UnorderedGroup__Group_1__0 : rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 ;
    public final void rule__UnorderedGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3828:1: ( rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3829:2: rule__UnorderedGroup__Group_1__0__Impl rule__UnorderedGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_29);
            rule__UnorderedGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1__1();

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
    // $ANTLR end "rule__UnorderedGroup__Group_1__0"


    // $ANTLR start "rule__UnorderedGroup__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3836:1: rule__UnorderedGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__UnorderedGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3840:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:3841:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:3841:1: ( () )
            // InternalXtextGrammarTestLanguage.g:3842:2: ()
            {
             before(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:3843:2: ()
            // InternalXtextGrammarTestLanguage.g:3843:3: 
            {
            }

             after(grammarAccess.getUnorderedGroupAccess().getUnorderedGroupElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:3851:1: rule__UnorderedGroup__Group_1__1 : rule__UnorderedGroup__Group_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3855:1: ( rule__UnorderedGroup__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3856:2: rule__UnorderedGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1__1__Impl();

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
    // $ANTLR end "rule__UnorderedGroup__Group_1__1"


    // $ANTLR start "rule__UnorderedGroup__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3862:1: rule__UnorderedGroup__Group_1__1__Impl : ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) ;
    public final void rule__UnorderedGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3866:1: ( ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:3867:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:3867:1: ( ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:3868:2: ( ( rule__UnorderedGroup__Group_1_1__0 ) ) ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:3868:2: ( ( rule__UnorderedGroup__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:3869:3: ( rule__UnorderedGroup__Group_1_1__0 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3870:3: ( rule__UnorderedGroup__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:3870:4: rule__UnorderedGroup__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_30);
            rule__UnorderedGroup__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:3873:2: ( ( rule__UnorderedGroup__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:3874:3: ( rule__UnorderedGroup__Group_1_1__0 )*
            {
             before(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3875:3: ( rule__UnorderedGroup__Group_1_1__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==34) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:3875:4: rule__UnorderedGroup__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_30);
            	    rule__UnorderedGroup__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getUnorderedGroupAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__UnorderedGroup__Group_1__1__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:3885:1: rule__UnorderedGroup__Group_1_1__0 : rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 ;
    public final void rule__UnorderedGroup__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3889:1: ( rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:3890:2: rule__UnorderedGroup__Group_1_1__0__Impl rule__UnorderedGroup__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__UnorderedGroup__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1_1__1();

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
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__0"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3897:1: rule__UnorderedGroup__Group_1_1__0__Impl : ( '&' ) ;
    public final void rule__UnorderedGroup__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3901:1: ( ( '&' ) )
            // InternalXtextGrammarTestLanguage.g:3902:1: ( '&' )
            {
            // InternalXtextGrammarTestLanguage.g:3902:1: ( '&' )
            // InternalXtextGrammarTestLanguage.g:3903:2: '&'
            {
             before(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 
            match(input,34,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUnorderedGroupAccess().getAmpersandKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__0__Impl"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:3912:1: rule__UnorderedGroup__Group_1_1__1 : rule__UnorderedGroup__Group_1_1__1__Impl ;
    public final void rule__UnorderedGroup__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3916:1: ( rule__UnorderedGroup__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3917:2: rule__UnorderedGroup__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__1"


    // $ANTLR start "rule__UnorderedGroup__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3923:1: rule__UnorderedGroup__Group_1_1__1__Impl : ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__UnorderedGroup__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3927:1: ( ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:3928:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:3928:1: ( ( rule__UnorderedGroup__ElementsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:3929:2: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:3930:2: ( rule__UnorderedGroup__ElementsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:3930:3: rule__UnorderedGroup__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UnorderedGroup__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getUnorderedGroupAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__Group_1_1__1__Impl"


    // $ANTLR start "rule__Group__Group__0"
    // InternalXtextGrammarTestLanguage.g:3939:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3943:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalXtextGrammarTestLanguage.g:3944:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__Group__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group__1();

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
    // $ANTLR end "rule__Group__Group__0"


    // $ANTLR start "rule__Group__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:3951:1: rule__Group__Group__0__Impl : ( ruleAbstractToken ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3955:1: ( ( ruleAbstractToken ) )
            // InternalXtextGrammarTestLanguage.g:3956:1: ( ruleAbstractToken )
            {
            // InternalXtextGrammarTestLanguage.g:3956:1: ( ruleAbstractToken )
            // InternalXtextGrammarTestLanguage.g:3957:2: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getAbstractTokenParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0__Impl"


    // $ANTLR start "rule__Group__Group__1"
    // InternalXtextGrammarTestLanguage.g:3966:1: rule__Group__Group__1 : rule__Group__Group__1__Impl ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3970:1: ( rule__Group__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:3971:2: rule__Group__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group__1__Impl();

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
    // $ANTLR end "rule__Group__Group__1"


    // $ANTLR start "rule__Group__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:3977:1: rule__Group__Group__1__Impl : ( ( rule__Group__Group_1__0 )? ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3981:1: ( ( ( rule__Group__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:3982:1: ( ( rule__Group__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:3982:1: ( ( rule__Group__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:3983:2: ( rule__Group__Group_1__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:3984:2: ( rule__Group__Group_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==21||LA41_0==35||LA41_0==39||LA41_0==45) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:3984:3: rule__Group__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Group__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGroupAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1__Impl"


    // $ANTLR start "rule__Group__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:3993:1: rule__Group__Group_1__0 : rule__Group__Group_1__0__Impl rule__Group__Group_1__1 ;
    public final void rule__Group__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:3997:1: ( rule__Group__Group_1__0__Impl rule__Group__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:3998:2: rule__Group__Group_1__0__Impl rule__Group__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_28);
            rule__Group__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group_1__1();

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
    // $ANTLR end "rule__Group__Group_1__0"


    // $ANTLR start "rule__Group__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4005:1: rule__Group__Group_1__0__Impl : ( () ) ;
    public final void rule__Group__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4009:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4010:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4010:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4011:2: ()
            {
             before(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4012:2: ()
            // InternalXtextGrammarTestLanguage.g:4012:3: 
            {
            }

             after(grammarAccess.getGroupAccess().getGroupElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_1__0__Impl"


    // $ANTLR start "rule__Group__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:4020:1: rule__Group__Group_1__1 : rule__Group__Group_1__1__Impl ;
    public final void rule__Group__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4024:1: ( rule__Group__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4025:2: rule__Group__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Group__Group_1__1__Impl();

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
    // $ANTLR end "rule__Group__Group_1__1"


    // $ANTLR start "rule__Group__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4031:1: rule__Group__Group_1__1__Impl : ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__Group__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4035:1: ( ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:4036:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:4036:1: ( ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* ) )
            // InternalXtextGrammarTestLanguage.g:4037:2: ( ( rule__Group__ElementsAssignment_1_1 ) ) ( ( rule__Group__ElementsAssignment_1_1 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4037:2: ( ( rule__Group__ElementsAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:4038:3: ( rule__Group__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4039:3: ( rule__Group__ElementsAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:4039:4: rule__Group__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_31);
            rule__Group__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:4042:2: ( ( rule__Group__ElementsAssignment_1_1 )* )
            // InternalXtextGrammarTestLanguage.g:4043:3: ( rule__Group__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:4044:3: ( rule__Group__ElementsAssignment_1_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||LA42_0==21||LA42_0==35||LA42_0==39||LA42_0==45) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4044:4: rule__Group__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    rule__Group__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getGroupAccess().getElementsAssignment_1_1()); 

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
    // $ANTLR end "rule__Group__Group_1__1__Impl"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__0"
    // InternalXtextGrammarTestLanguage.g:4054:1: rule__AbstractTokenWithCardinality__Group__0 : rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 ;
    public final void rule__AbstractTokenWithCardinality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4058:1: ( rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4059:2: rule__AbstractTokenWithCardinality__Group__0__Impl rule__AbstractTokenWithCardinality__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_32);
            rule__AbstractTokenWithCardinality__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Group__1();

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
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__0"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4066:1: rule__AbstractTokenWithCardinality__Group__0__Impl : ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) ;
    public final void rule__AbstractTokenWithCardinality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4070:1: ( ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:4071:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4071:1: ( ( rule__AbstractTokenWithCardinality__Alternatives_0 ) )
            // InternalXtextGrammarTestLanguage.g:4072:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 
            // InternalXtextGrammarTestLanguage.g:4073:2: ( rule__AbstractTokenWithCardinality__Alternatives_0 )
            // InternalXtextGrammarTestLanguage.g:4073:3: rule__AbstractTokenWithCardinality__Alternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__0__Impl"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__1"
    // InternalXtextGrammarTestLanguage.g:4081:1: rule__AbstractTokenWithCardinality__Group__1 : rule__AbstractTokenWithCardinality__Group__1__Impl ;
    public final void rule__AbstractTokenWithCardinality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4085:1: ( rule__AbstractTokenWithCardinality__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4086:2: rule__AbstractTokenWithCardinality__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AbstractTokenWithCardinality__Group__1__Impl();

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
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__1"


    // $ANTLR start "rule__AbstractTokenWithCardinality__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4092:1: rule__AbstractTokenWithCardinality__Group__1__Impl : ( ( ruleCardinalities )? ) ;
    public final void rule__AbstractTokenWithCardinality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4096:1: ( ( ( ruleCardinalities )? ) )
            // InternalXtextGrammarTestLanguage.g:4097:1: ( ( ruleCardinalities )? )
            {
            // InternalXtextGrammarTestLanguage.g:4097:1: ( ( ruleCardinalities )? )
            // InternalXtextGrammarTestLanguage.g:4098:2: ( ruleCardinalities )?
            {
             before(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalitiesParserRuleCall_1()); 
            // InternalXtextGrammarTestLanguage.g:4099:2: ( ruleCardinalities )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=11 && LA43_0<=13)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4099:3: ruleCardinalities
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCardinalities();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractTokenWithCardinalityAccess().getCardinalitiesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractTokenWithCardinality__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__0"
    // InternalXtextGrammarTestLanguage.g:4108:1: rule__Action__Group__0 : rule__Action__Group__0__Impl rule__Action__Group__1 ;
    public final void rule__Action__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4112:1: ( rule__Action__Group__0__Impl rule__Action__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4113:2: rule__Action__Group__0__Impl rule__Action__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Action__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__1();

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
    // $ANTLR end "rule__Action__Group__0"


    // $ANTLR start "rule__Action__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4120:1: rule__Action__Group__0__Impl : ( '{' ) ;
    public final void rule__Action__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4124:1: ( ( '{' ) )
            // InternalXtextGrammarTestLanguage.g:4125:1: ( '{' )
            {
            // InternalXtextGrammarTestLanguage.g:4125:1: ( '{' )
            // InternalXtextGrammarTestLanguage.g:4126:2: '{'
            {
             before(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,35,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__0__Impl"


    // $ANTLR start "rule__Action__Group__1"
    // InternalXtextGrammarTestLanguage.g:4135:1: rule__Action__Group__1 : rule__Action__Group__1__Impl rule__Action__Group__2 ;
    public final void rule__Action__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4139:1: ( rule__Action__Group__1__Impl rule__Action__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4140:2: rule__Action__Group__1__Impl rule__Action__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__Action__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__2();

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
    // $ANTLR end "rule__Action__Group__1"


    // $ANTLR start "rule__Action__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4147:1: rule__Action__Group__1__Impl : ( ( rule__Action__TypeAssignment_1 ) ) ;
    public final void rule__Action__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4151:1: ( ( ( rule__Action__TypeAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4152:1: ( ( rule__Action__TypeAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4152:1: ( ( rule__Action__TypeAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4153:2: ( rule__Action__TypeAssignment_1 )
            {
             before(grammarAccess.getActionAccess().getTypeAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4154:2: ( rule__Action__TypeAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4154:3: rule__Action__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__1__Impl"


    // $ANTLR start "rule__Action__Group__2"
    // InternalXtextGrammarTestLanguage.g:4162:1: rule__Action__Group__2 : rule__Action__Group__2__Impl rule__Action__Group__3 ;
    public final void rule__Action__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4166:1: ( rule__Action__Group__2__Impl rule__Action__Group__3 )
            // InternalXtextGrammarTestLanguage.g:4167:2: rule__Action__Group__2__Impl rule__Action__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_33);
            rule__Action__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__3();

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
    // $ANTLR end "rule__Action__Group__2"


    // $ANTLR start "rule__Action__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:4174:1: rule__Action__Group__2__Impl : ( ( rule__Action__Group_2__0 )? ) ;
    public final void rule__Action__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4178:1: ( ( ( rule__Action__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4179:1: ( ( rule__Action__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4179:1: ( ( rule__Action__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:4180:2: ( rule__Action__Group_2__0 )?
            {
             before(grammarAccess.getActionAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:4181:2: ( rule__Action__Group_2__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==23) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4181:3: rule__Action__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Action__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getActionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__2__Impl"


    // $ANTLR start "rule__Action__Group__3"
    // InternalXtextGrammarTestLanguage.g:4189:1: rule__Action__Group__3 : rule__Action__Group__3__Impl ;
    public final void rule__Action__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4193:1: ( rule__Action__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:4194:2: rule__Action__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group__3__Impl();

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
    // $ANTLR end "rule__Action__Group__3"


    // $ANTLR start "rule__Action__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:4200:1: rule__Action__Group__3__Impl : ( '}' ) ;
    public final void rule__Action__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4204:1: ( ( '}' ) )
            // InternalXtextGrammarTestLanguage.g:4205:1: ( '}' )
            {
            // InternalXtextGrammarTestLanguage.g:4205:1: ( '}' )
            // InternalXtextGrammarTestLanguage.g:4206:2: '}'
            {
             before(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 
            match(input,36,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group__3__Impl"


    // $ANTLR start "rule__Action__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:4216:1: rule__Action__Group_2__0 : rule__Action__Group_2__0__Impl rule__Action__Group_2__1 ;
    public final void rule__Action__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4220:1: ( rule__Action__Group_2__0__Impl rule__Action__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:4221:2: rule__Action__Group_2__0__Impl rule__Action__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Action__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__1();

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
    // $ANTLR end "rule__Action__Group_2__0"


    // $ANTLR start "rule__Action__Group_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4228:1: rule__Action__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Action__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4232:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:4233:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:4233:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:4234:2: '.'
            {
             before(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__0__Impl"


    // $ANTLR start "rule__Action__Group_2__1"
    // InternalXtextGrammarTestLanguage.g:4243:1: rule__Action__Group_2__1 : rule__Action__Group_2__1__Impl rule__Action__Group_2__2 ;
    public final void rule__Action__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4247:1: ( rule__Action__Group_2__1__Impl rule__Action__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:4248:2: rule__Action__Group_2__1__Impl rule__Action__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_34);
            rule__Action__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__2();

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
    // $ANTLR end "rule__Action__Group_2__1"


    // $ANTLR start "rule__Action__Group_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4255:1: rule__Action__Group_2__1__Impl : ( ( rule__Action__FeatureAssignment_2_1 ) ) ;
    public final void rule__Action__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4259:1: ( ( ( rule__Action__FeatureAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4260:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4260:1: ( ( rule__Action__FeatureAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:4261:2: ( rule__Action__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:4262:2: ( rule__Action__FeatureAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:4262:3: rule__Action__FeatureAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__FeatureAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getFeatureAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__1__Impl"


    // $ANTLR start "rule__Action__Group_2__2"
    // InternalXtextGrammarTestLanguage.g:4270:1: rule__Action__Group_2__2 : rule__Action__Group_2__2__Impl rule__Action__Group_2__3 ;
    public final void rule__Action__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4274:1: ( rule__Action__Group_2__2__Impl rule__Action__Group_2__3 )
            // InternalXtextGrammarTestLanguage.g:4275:2: rule__Action__Group_2__2__Impl rule__Action__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_35);
            rule__Action__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__3();

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
    // $ANTLR end "rule__Action__Group_2__2"


    // $ANTLR start "rule__Action__Group_2__2__Impl"
    // InternalXtextGrammarTestLanguage.g:4282:1: rule__Action__Group_2__2__Impl : ( ( rule__Action__OperatorAssignment_2_2 ) ) ;
    public final void rule__Action__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4286:1: ( ( ( rule__Action__OperatorAssignment_2_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:4287:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4287:1: ( ( rule__Action__OperatorAssignment_2_2 ) )
            // InternalXtextGrammarTestLanguage.g:4288:2: ( rule__Action__OperatorAssignment_2_2 )
            {
             before(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 
            // InternalXtextGrammarTestLanguage.g:4289:2: ( rule__Action__OperatorAssignment_2_2 )
            // InternalXtextGrammarTestLanguage.g:4289:3: rule__Action__OperatorAssignment_2_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__OperatorAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__2__Impl"


    // $ANTLR start "rule__Action__Group_2__3"
    // InternalXtextGrammarTestLanguage.g:4297:1: rule__Action__Group_2__3 : rule__Action__Group_2__3__Impl ;
    public final void rule__Action__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4301:1: ( rule__Action__Group_2__3__Impl )
            // InternalXtextGrammarTestLanguage.g:4302:2: rule__Action__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__Group_2__3__Impl();

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
    // $ANTLR end "rule__Action__Group_2__3"


    // $ANTLR start "rule__Action__Group_2__3__Impl"
    // InternalXtextGrammarTestLanguage.g:4308:1: rule__Action__Group_2__3__Impl : ( 'current' ) ;
    public final void rule__Action__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4312:1: ( ( 'current' ) )
            // InternalXtextGrammarTestLanguage.g:4313:1: ( 'current' )
            {
            // InternalXtextGrammarTestLanguage.g:4313:1: ( 'current' )
            // InternalXtextGrammarTestLanguage.g:4314:2: 'current'
            {
             before(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 
            match(input,37,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getCurrentKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Group_2__3__Impl"


    // $ANTLR start "rule__RuleCall__Group__0"
    // InternalXtextGrammarTestLanguage.g:4324:1: rule__RuleCall__Group__0 : rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 ;
    public final void rule__RuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4328:1: ( rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4329:2: rule__RuleCall__Group__0__Impl rule__RuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__RuleCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__1();

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
    // $ANTLR end "rule__RuleCall__Group__0"


    // $ANTLR start "rule__RuleCall__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4336:1: rule__RuleCall__Group__0__Impl : ( () ) ;
    public final void rule__RuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4340:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4341:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4341:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4342:2: ()
            {
             before(grammarAccess.getRuleCallAccess().getRuleCallAction_0()); 
            // InternalXtextGrammarTestLanguage.g:4343:2: ()
            // InternalXtextGrammarTestLanguage.g:4343:3: 
            {
            }

             after(grammarAccess.getRuleCallAccess().getRuleCallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__0__Impl"


    // $ANTLR start "rule__RuleCall__Group__1"
    // InternalXtextGrammarTestLanguage.g:4351:1: rule__RuleCall__Group__1 : rule__RuleCall__Group__1__Impl rule__RuleCall__Group__2 ;
    public final void rule__RuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4355:1: ( rule__RuleCall__Group__1__Impl rule__RuleCall__Group__2 )
            // InternalXtextGrammarTestLanguage.g:4356:2: rule__RuleCall__Group__1__Impl rule__RuleCall__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_21);
            rule__RuleCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__2();

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
    // $ANTLR end "rule__RuleCall__Group__1"


    // $ANTLR start "rule__RuleCall__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4363:1: rule__RuleCall__Group__1__Impl : ( ( rule__RuleCall__RuleAssignment_1 ) ) ;
    public final void rule__RuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4367:1: ( ( ( rule__RuleCall__RuleAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4368:1: ( ( rule__RuleCall__RuleAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4368:1: ( ( rule__RuleCall__RuleAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4369:2: ( rule__RuleCall__RuleAssignment_1 )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4370:2: ( rule__RuleCall__RuleAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4370:3: rule__RuleCall__RuleAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__RuleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getRuleAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__1__Impl"


    // $ANTLR start "rule__RuleCall__Group__2"
    // InternalXtextGrammarTestLanguage.g:4378:1: rule__RuleCall__Group__2 : rule__RuleCall__Group__2__Impl ;
    public final void rule__RuleCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4382:1: ( rule__RuleCall__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:4383:2: rule__RuleCall__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group__2__Impl();

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
    // $ANTLR end "rule__RuleCall__Group__2"


    // $ANTLR start "rule__RuleCall__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:4389:1: rule__RuleCall__Group__2__Impl : ( ( rule__RuleCall__Group_2__0 )? ) ;
    public final void rule__RuleCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4393:1: ( ( ( rule__RuleCall__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4394:1: ( ( rule__RuleCall__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4394:1: ( ( rule__RuleCall__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:4395:2: ( rule__RuleCall__Group_2__0 )?
            {
             before(grammarAccess.getRuleCallAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:4396:2: ( rule__RuleCall__Group_2__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==29) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4396:3: rule__RuleCall__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__RuleCall__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleCallAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group__2__Impl"


    // $ANTLR start "rule__RuleCall__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:4405:1: rule__RuleCall__Group_2__0 : rule__RuleCall__Group_2__0__Impl rule__RuleCall__Group_2__1 ;
    public final void rule__RuleCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4409:1: ( rule__RuleCall__Group_2__0__Impl rule__RuleCall__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:4410:2: rule__RuleCall__Group_2__0__Impl rule__RuleCall__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_36);
            rule__RuleCall__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_2__1();

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
    // $ANTLR end "rule__RuleCall__Group_2__0"


    // $ANTLR start "rule__RuleCall__Group_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4417:1: rule__RuleCall__Group_2__0__Impl : ( '[' ) ;
    public final void rule__RuleCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4421:1: ( ( '[' ) )
            // InternalXtextGrammarTestLanguage.g:4422:1: ( '[' )
            {
            // InternalXtextGrammarTestLanguage.g:4422:1: ( '[' )
            // InternalXtextGrammarTestLanguage.g:4423:2: '['
            {
             before(grammarAccess.getRuleCallAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_2__0__Impl"


    // $ANTLR start "rule__RuleCall__Group_2__1"
    // InternalXtextGrammarTestLanguage.g:4432:1: rule__RuleCall__Group_2__1 : rule__RuleCall__Group_2__1__Impl rule__RuleCall__Group_2__2 ;
    public final void rule__RuleCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4436:1: ( rule__RuleCall__Group_2__1__Impl rule__RuleCall__Group_2__2 )
            // InternalXtextGrammarTestLanguage.g:4437:2: rule__RuleCall__Group_2__1__Impl rule__RuleCall__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_37);
            rule__RuleCall__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_2__2();

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
    // $ANTLR end "rule__RuleCall__Group_2__1"


    // $ANTLR start "rule__RuleCall__Group_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4444:1: rule__RuleCall__Group_2__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_2_1 ) ) ;
    public final void rule__RuleCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4448:1: ( ( ( rule__RuleCall__ArgumentsAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4449:1: ( ( rule__RuleCall__ArgumentsAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4449:1: ( ( rule__RuleCall__ArgumentsAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:4450:2: ( rule__RuleCall__ArgumentsAssignment_2_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:4451:2: ( rule__RuleCall__ArgumentsAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:4451:3: rule__RuleCall__ArgumentsAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__ArgumentsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_2__1__Impl"


    // $ANTLR start "rule__RuleCall__Group_2__2"
    // InternalXtextGrammarTestLanguage.g:4459:1: rule__RuleCall__Group_2__2 : rule__RuleCall__Group_2__2__Impl rule__RuleCall__Group_2__3 ;
    public final void rule__RuleCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4463:1: ( rule__RuleCall__Group_2__2__Impl rule__RuleCall__Group_2__3 )
            // InternalXtextGrammarTestLanguage.g:4464:2: rule__RuleCall__Group_2__2__Impl rule__RuleCall__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_37);
            rule__RuleCall__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_2__3();

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
    // $ANTLR end "rule__RuleCall__Group_2__2"


    // $ANTLR start "rule__RuleCall__Group_2__2__Impl"
    // InternalXtextGrammarTestLanguage.g:4471:1: rule__RuleCall__Group_2__2__Impl : ( ( rule__RuleCall__Group_2_2__0 )* ) ;
    public final void rule__RuleCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4475:1: ( ( ( rule__RuleCall__Group_2_2__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:4476:1: ( ( rule__RuleCall__Group_2_2__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4476:1: ( ( rule__RuleCall__Group_2_2__0 )* )
            // InternalXtextGrammarTestLanguage.g:4477:2: ( rule__RuleCall__Group_2_2__0 )*
            {
             before(grammarAccess.getRuleCallAccess().getGroup_2_2()); 
            // InternalXtextGrammarTestLanguage.g:4478:2: ( rule__RuleCall__Group_2_2__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==20) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4478:3: rule__RuleCall__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    rule__RuleCall__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getRuleCallAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_2__2__Impl"


    // $ANTLR start "rule__RuleCall__Group_2__3"
    // InternalXtextGrammarTestLanguage.g:4486:1: rule__RuleCall__Group_2__3 : rule__RuleCall__Group_2__3__Impl ;
    public final void rule__RuleCall__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4490:1: ( rule__RuleCall__Group_2__3__Impl )
            // InternalXtextGrammarTestLanguage.g:4491:2: rule__RuleCall__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_2__3__Impl();

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
    // $ANTLR end "rule__RuleCall__Group_2__3"


    // $ANTLR start "rule__RuleCall__Group_2__3__Impl"
    // InternalXtextGrammarTestLanguage.g:4497:1: rule__RuleCall__Group_2__3__Impl : ( ']' ) ;
    public final void rule__RuleCall__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4501:1: ( ( ']' ) )
            // InternalXtextGrammarTestLanguage.g:4502:1: ( ']' )
            {
            // InternalXtextGrammarTestLanguage.g:4502:1: ( ']' )
            // InternalXtextGrammarTestLanguage.g:4503:2: ']'
            {
             before(grammarAccess.getRuleCallAccess().getRightSquareBracketKeyword_2_3()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getRightSquareBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_2__3__Impl"


    // $ANTLR start "rule__RuleCall__Group_2_2__0"
    // InternalXtextGrammarTestLanguage.g:4513:1: rule__RuleCall__Group_2_2__0 : rule__RuleCall__Group_2_2__0__Impl rule__RuleCall__Group_2_2__1 ;
    public final void rule__RuleCall__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4517:1: ( rule__RuleCall__Group_2_2__0__Impl rule__RuleCall__Group_2_2__1 )
            // InternalXtextGrammarTestLanguage.g:4518:2: rule__RuleCall__Group_2_2__0__Impl rule__RuleCall__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_36);
            rule__RuleCall__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_2_2__1();

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
    // $ANTLR end "rule__RuleCall__Group_2_2__0"


    // $ANTLR start "rule__RuleCall__Group_2_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4525:1: rule__RuleCall__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__RuleCall__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4529:1: ( ( ',' ) )
            // InternalXtextGrammarTestLanguage.g:4530:1: ( ',' )
            {
            // InternalXtextGrammarTestLanguage.g:4530:1: ( ',' )
            // InternalXtextGrammarTestLanguage.g:4531:2: ','
            {
             before(grammarAccess.getRuleCallAccess().getCommaKeyword_2_2_0()); 
            match(input,20,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleCallAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_2_2__0__Impl"


    // $ANTLR start "rule__RuleCall__Group_2_2__1"
    // InternalXtextGrammarTestLanguage.g:4540:1: rule__RuleCall__Group_2_2__1 : rule__RuleCall__Group_2_2__1__Impl ;
    public final void rule__RuleCall__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4544:1: ( rule__RuleCall__Group_2_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4545:2: rule__RuleCall__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__RuleCall__Group_2_2__1"


    // $ANTLR start "rule__RuleCall__Group_2_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4551:1: rule__RuleCall__Group_2_2__1__Impl : ( ( rule__RuleCall__ArgumentsAssignment_2_2_1 ) ) ;
    public final void rule__RuleCall__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4555:1: ( ( ( rule__RuleCall__ArgumentsAssignment_2_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4556:1: ( ( rule__RuleCall__ArgumentsAssignment_2_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4556:1: ( ( rule__RuleCall__ArgumentsAssignment_2_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:4557:2: ( rule__RuleCall__ArgumentsAssignment_2_2_1 )
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsAssignment_2_2_1()); 
            // InternalXtextGrammarTestLanguage.g:4558:2: ( rule__RuleCall__ArgumentsAssignment_2_2_1 )
            // InternalXtextGrammarTestLanguage.g:4558:3: rule__RuleCall__ArgumentsAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleCall__ArgumentsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleCallAccess().getArgumentsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__Group_2_2__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group__0"
    // InternalXtextGrammarTestLanguage.g:4567:1: rule__NamedArgument__Group__0 : rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 ;
    public final void rule__NamedArgument__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4571:1: ( rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4572:2: rule__NamedArgument__Group__0__Impl rule__NamedArgument__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_36);
            rule__NamedArgument__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__1();

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
    // $ANTLR end "rule__NamedArgument__Group__0"


    // $ANTLR start "rule__NamedArgument__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4579:1: rule__NamedArgument__Group__0__Impl : ( () ) ;
    public final void rule__NamedArgument__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4583:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:4584:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:4584:1: ( () )
            // InternalXtextGrammarTestLanguage.g:4585:2: ()
            {
             before(grammarAccess.getNamedArgumentAccess().getNamedArgumentAction_0()); 
            // InternalXtextGrammarTestLanguage.g:4586:2: ()
            // InternalXtextGrammarTestLanguage.g:4586:3: 
            {
            }

             after(grammarAccess.getNamedArgumentAccess().getNamedArgumentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group__1"
    // InternalXtextGrammarTestLanguage.g:4594:1: rule__NamedArgument__Group__1 : rule__NamedArgument__Group__1__Impl ;
    public final void rule__NamedArgument__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4598:1: ( rule__NamedArgument__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4599:2: rule__NamedArgument__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group__1__Impl();

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
    // $ANTLR end "rule__NamedArgument__Group__1"


    // $ANTLR start "rule__NamedArgument__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4605:1: rule__NamedArgument__Group__1__Impl : ( ( rule__NamedArgument__Alternatives_1 ) ) ;
    public final void rule__NamedArgument__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4609:1: ( ( ( rule__NamedArgument__Alternatives_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4610:1: ( ( rule__NamedArgument__Alternatives_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4610:1: ( ( rule__NamedArgument__Alternatives_1 ) )
            // InternalXtextGrammarTestLanguage.g:4611:2: ( rule__NamedArgument__Alternatives_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getAlternatives_1()); 
            // InternalXtextGrammarTestLanguage.g:4612:2: ( rule__NamedArgument__Alternatives_1 )
            // InternalXtextGrammarTestLanguage.g:4612:3: rule__NamedArgument__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group_1_0__0"
    // InternalXtextGrammarTestLanguage.g:4621:1: rule__NamedArgument__Group_1_0__0 : rule__NamedArgument__Group_1_0__0__Impl rule__NamedArgument__Group_1_0__1 ;
    public final void rule__NamedArgument__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4625:1: ( rule__NamedArgument__Group_1_0__0__Impl rule__NamedArgument__Group_1_0__1 )
            // InternalXtextGrammarTestLanguage.g:4626:2: rule__NamedArgument__Group_1_0__0__Impl rule__NamedArgument__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_36);
            rule__NamedArgument__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_1_0__1();

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
    // $ANTLR end "rule__NamedArgument__Group_1_0__0"


    // $ANTLR start "rule__NamedArgument__Group_1_0__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4633:1: rule__NamedArgument__Group_1_0__0__Impl : ( ( rule__NamedArgument__LiteralValueAssignment_1_0_0 )? ) ;
    public final void rule__NamedArgument__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4637:1: ( ( ( rule__NamedArgument__LiteralValueAssignment_1_0_0 )? ) )
            // InternalXtextGrammarTestLanguage.g:4638:1: ( ( rule__NamedArgument__LiteralValueAssignment_1_0_0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:4638:1: ( ( rule__NamedArgument__LiteralValueAssignment_1_0_0 )? )
            // InternalXtextGrammarTestLanguage.g:4639:2: ( rule__NamedArgument__LiteralValueAssignment_1_0_0 )?
            {
             before(grammarAccess.getNamedArgumentAccess().getLiteralValueAssignment_1_0_0()); 
            // InternalXtextGrammarTestLanguage.g:4640:2: ( rule__NamedArgument__LiteralValueAssignment_1_0_0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==13||LA47_0==16) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4640:3: rule__NamedArgument__LiteralValueAssignment_1_0_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__NamedArgument__LiteralValueAssignment_1_0_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNamedArgumentAccess().getLiteralValueAssignment_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_1_0__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group_1_0__1"
    // InternalXtextGrammarTestLanguage.g:4648:1: rule__NamedArgument__Group_1_0__1 : rule__NamedArgument__Group_1_0__1__Impl ;
    public final void rule__NamedArgument__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4652:1: ( rule__NamedArgument__Group_1_0__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4653:2: rule__NamedArgument__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_1_0__1__Impl();

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
    // $ANTLR end "rule__NamedArgument__Group_1_0__1"


    // $ANTLR start "rule__NamedArgument__Group_1_0__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4659:1: rule__NamedArgument__Group_1_0__1__Impl : ( ( rule__NamedArgument__ParameterAssignment_1_0_1 ) ) ;
    public final void rule__NamedArgument__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4663:1: ( ( ( rule__NamedArgument__ParameterAssignment_1_0_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4664:1: ( ( rule__NamedArgument__ParameterAssignment_1_0_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4664:1: ( ( rule__NamedArgument__ParameterAssignment_1_0_1 ) )
            // InternalXtextGrammarTestLanguage.g:4665:2: ( rule__NamedArgument__ParameterAssignment_1_0_1 )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterAssignment_1_0_1()); 
            // InternalXtextGrammarTestLanguage.g:4666:2: ( rule__NamedArgument__ParameterAssignment_1_0_1 )
            // InternalXtextGrammarTestLanguage.g:4666:3: rule__NamedArgument__ParameterAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__ParameterAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getParameterAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_1_0__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:4675:1: rule__NamedArgument__Group_1_1__0 : rule__NamedArgument__Group_1_1__0__Impl rule__NamedArgument__Group_1_1__1 ;
    public final void rule__NamedArgument__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4679:1: ( rule__NamedArgument__Group_1_1__0__Impl rule__NamedArgument__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:4680:2: rule__NamedArgument__Group_1_1__0__Impl rule__NamedArgument__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_38);
            rule__NamedArgument__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_1_1__1();

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
    // $ANTLR end "rule__NamedArgument__Group_1_1__0"


    // $ANTLR start "rule__NamedArgument__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4687:1: rule__NamedArgument__Group_1_1__0__Impl : ( ( rule__NamedArgument__ParameterAssignment_1_1_0 ) ) ;
    public final void rule__NamedArgument__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4691:1: ( ( ( rule__NamedArgument__ParameterAssignment_1_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:4692:1: ( ( rule__NamedArgument__ParameterAssignment_1_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4692:1: ( ( rule__NamedArgument__ParameterAssignment_1_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:4693:2: ( rule__NamedArgument__ParameterAssignment_1_1_0 )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterAssignment_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:4694:2: ( rule__NamedArgument__ParameterAssignment_1_1_0 )
            // InternalXtextGrammarTestLanguage.g:4694:3: rule__NamedArgument__ParameterAssignment_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__ParameterAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getParameterAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_1_1__0__Impl"


    // $ANTLR start "rule__NamedArgument__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:4702:1: rule__NamedArgument__Group_1_1__1 : rule__NamedArgument__Group_1_1__1__Impl rule__NamedArgument__Group_1_1__2 ;
    public final void rule__NamedArgument__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4706:1: ( rule__NamedArgument__Group_1_1__1__Impl rule__NamedArgument__Group_1_1__2 )
            // InternalXtextGrammarTestLanguage.g:4707:2: rule__NamedArgument__Group_1_1__1__Impl rule__NamedArgument__Group_1_1__2
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__NamedArgument__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_1_1__2();

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
    // $ANTLR end "rule__NamedArgument__Group_1_1__1"


    // $ANTLR start "rule__NamedArgument__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4714:1: rule__NamedArgument__Group_1_1__1__Impl : ( '=' ) ;
    public final void rule__NamedArgument__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4718:1: ( ( '=' ) )
            // InternalXtextGrammarTestLanguage.g:4719:1: ( '=' )
            {
            // InternalXtextGrammarTestLanguage.g:4719:1: ( '=' )
            // InternalXtextGrammarTestLanguage.g:4720:2: '='
            {
             before(grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_1_1_1()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_1_1__1__Impl"


    // $ANTLR start "rule__NamedArgument__Group_1_1__2"
    // InternalXtextGrammarTestLanguage.g:4729:1: rule__NamedArgument__Group_1_1__2 : rule__NamedArgument__Group_1_1__2__Impl ;
    public final void rule__NamedArgument__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4733:1: ( rule__NamedArgument__Group_1_1__2__Impl )
            // InternalXtextGrammarTestLanguage.g:4734:2: rule__NamedArgument__Group_1_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__Group_1_1__2__Impl();

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
    // $ANTLR end "rule__NamedArgument__Group_1_1__2"


    // $ANTLR start "rule__NamedArgument__Group_1_1__2__Impl"
    // InternalXtextGrammarTestLanguage.g:4740:1: rule__NamedArgument__Group_1_1__2__Impl : ( ( rule__NamedArgument__ValueAssignment_1_1_2 ) ) ;
    public final void rule__NamedArgument__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4744:1: ( ( ( rule__NamedArgument__ValueAssignment_1_1_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:4745:1: ( ( rule__NamedArgument__ValueAssignment_1_1_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4745:1: ( ( rule__NamedArgument__ValueAssignment_1_1_2 ) )
            // InternalXtextGrammarTestLanguage.g:4746:2: ( rule__NamedArgument__ValueAssignment_1_1_2 )
            {
             before(grammarAccess.getNamedArgumentAccess().getValueAssignment_1_1_2()); 
            // InternalXtextGrammarTestLanguage.g:4747:2: ( rule__NamedArgument__ValueAssignment_1_1_2 )
            // InternalXtextGrammarTestLanguage.g:4747:3: rule__NamedArgument__ValueAssignment_1_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NamedArgument__ValueAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNamedArgumentAccess().getValueAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__Group_1_1__2__Impl"


    // $ANTLR start "rule__RuleID__Group__0"
    // InternalXtextGrammarTestLanguage.g:4756:1: rule__RuleID__Group__0 : rule__RuleID__Group__0__Impl rule__RuleID__Group__1 ;
    public final void rule__RuleID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4760:1: ( rule__RuleID__Group__0__Impl rule__RuleID__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4761:2: rule__RuleID__Group__0__Impl rule__RuleID__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_23);
            rule__RuleID__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__1();

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
    // $ANTLR end "rule__RuleID__Group__0"


    // $ANTLR start "rule__RuleID__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4768:1: rule__RuleID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__RuleID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4772:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:4773:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:4773:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:4774:2: RULE_ID
            {
             before(grammarAccess.getRuleIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleIDAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__0__Impl"


    // $ANTLR start "rule__RuleID__Group__1"
    // InternalXtextGrammarTestLanguage.g:4783:1: rule__RuleID__Group__1 : rule__RuleID__Group__1__Impl ;
    public final void rule__RuleID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4787:1: ( rule__RuleID__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4788:2: rule__RuleID__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group__1__Impl();

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
    // $ANTLR end "rule__RuleID__Group__1"


    // $ANTLR start "rule__RuleID__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4794:1: rule__RuleID__Group__1__Impl : ( ( rule__RuleID__Group_1__0 )* ) ;
    public final void rule__RuleID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4798:1: ( ( ( rule__RuleID__Group_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:4799:1: ( ( rule__RuleID__Group_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:4799:1: ( ( rule__RuleID__Group_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:4800:2: ( rule__RuleID__Group_1__0 )*
            {
             before(grammarAccess.getRuleIDAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:4801:2: ( rule__RuleID__Group_1__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==32) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:4801:3: rule__RuleID__Group_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_39);
            	    rule__RuleID__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getRuleIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group__1__Impl"


    // $ANTLR start "rule__RuleID__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:4810:1: rule__RuleID__Group_1__0 : rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 ;
    public final void rule__RuleID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4814:1: ( rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:4815:2: rule__RuleID__Group_1__0__Impl rule__RuleID__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__RuleID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group_1__1();

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
    // $ANTLR end "rule__RuleID__Group_1__0"


    // $ANTLR start "rule__RuleID__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4822:1: rule__RuleID__Group_1__0__Impl : ( '::' ) ;
    public final void rule__RuleID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4826:1: ( ( '::' ) )
            // InternalXtextGrammarTestLanguage.g:4827:1: ( '::' )
            {
            // InternalXtextGrammarTestLanguage.g:4827:1: ( '::' )
            // InternalXtextGrammarTestLanguage.g:4828:2: '::'
            {
             before(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); 
            match(input,32,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleIDAccess().getColonColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__0__Impl"


    // $ANTLR start "rule__RuleID__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:4837:1: rule__RuleID__Group_1__1 : rule__RuleID__Group_1__1__Impl ;
    public final void rule__RuleID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4841:1: ( rule__RuleID__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4842:2: rule__RuleID__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__RuleID__Group_1__1__Impl();

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
    // $ANTLR end "rule__RuleID__Group_1__1"


    // $ANTLR start "rule__RuleID__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4848:1: rule__RuleID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__RuleID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4852:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:4853:1: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:4853:1: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:4854:2: RULE_ID
            {
             before(grammarAccess.getRuleIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleIDAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleID__Group_1__1__Impl"


    // $ANTLR start "rule__PredicatedKeyword__Group__0"
    // InternalXtextGrammarTestLanguage.g:4864:1: rule__PredicatedKeyword__Group__0 : rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 ;
    public final void rule__PredicatedKeyword__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4868:1: ( rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4869:2: rule__PredicatedKeyword__Group__0__Impl rule__PredicatedKeyword__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__PredicatedKeyword__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__1();

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
    // $ANTLR end "rule__PredicatedKeyword__Group__0"


    // $ANTLR start "rule__PredicatedKeyword__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4876:1: rule__PredicatedKeyword__Group__0__Impl : ( rulePredicate ) ;
    public final void rule__PredicatedKeyword__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4880:1: ( ( rulePredicate ) )
            // InternalXtextGrammarTestLanguage.g:4881:1: ( rulePredicate )
            {
            // InternalXtextGrammarTestLanguage.g:4881:1: ( rulePredicate )
            // InternalXtextGrammarTestLanguage.g:4882:2: rulePredicate
            {
             before(grammarAccess.getPredicatedKeywordAccess().getPredicateParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            rulePredicate();

            state._fsp--;

             after(grammarAccess.getPredicatedKeywordAccess().getPredicateParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__0__Impl"


    // $ANTLR start "rule__PredicatedKeyword__Group__1"
    // InternalXtextGrammarTestLanguage.g:4891:1: rule__PredicatedKeyword__Group__1 : rule__PredicatedKeyword__Group__1__Impl ;
    public final void rule__PredicatedKeyword__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4895:1: ( rule__PredicatedKeyword__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4896:2: rule__PredicatedKeyword__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__Group__1__Impl();

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
    // $ANTLR end "rule__PredicatedKeyword__Group__1"


    // $ANTLR start "rule__PredicatedKeyword__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4902:1: rule__PredicatedKeyword__Group__1__Impl : ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) ;
    public final void rule__PredicatedKeyword__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4906:1: ( ( ( rule__PredicatedKeyword__ValueAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4907:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4907:1: ( ( rule__PredicatedKeyword__ValueAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4908:2: ( rule__PredicatedKeyword__ValueAssignment_1 )
            {
             before(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4909:2: ( rule__PredicatedKeyword__ValueAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4909:3: rule__PredicatedKeyword__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedKeyword__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedKeywordAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__Group__1__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__0"
    // InternalXtextGrammarTestLanguage.g:4918:1: rule__PredicatedRuleCall__Group__0 : rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 ;
    public final void rule__PredicatedRuleCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4922:1: ( rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4923:2: rule__PredicatedRuleCall__Group__0__Impl rule__PredicatedRuleCall__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__PredicatedRuleCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__1();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group__0"


    // $ANTLR start "rule__PredicatedRuleCall__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4930:1: rule__PredicatedRuleCall__Group__0__Impl : ( rulePredicate ) ;
    public final void rule__PredicatedRuleCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4934:1: ( ( rulePredicate ) )
            // InternalXtextGrammarTestLanguage.g:4935:1: ( rulePredicate )
            {
            // InternalXtextGrammarTestLanguage.g:4935:1: ( rulePredicate )
            // InternalXtextGrammarTestLanguage.g:4936:2: rulePredicate
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getPredicateParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            rulePredicate();

            state._fsp--;

             after(grammarAccess.getPredicatedRuleCallAccess().getPredicateParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__0__Impl"


    // $ANTLR start "rule__PredicatedRuleCall__Group__1"
    // InternalXtextGrammarTestLanguage.g:4945:1: rule__PredicatedRuleCall__Group__1 : rule__PredicatedRuleCall__Group__1__Impl ;
    public final void rule__PredicatedRuleCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4949:1: ( rule__PredicatedRuleCall__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:4950:2: rule__PredicatedRuleCall__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__Group__1__Impl();

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
    // $ANTLR end "rule__PredicatedRuleCall__Group__1"


    // $ANTLR start "rule__PredicatedRuleCall__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:4956:1: rule__PredicatedRuleCall__Group__1__Impl : ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) ;
    public final void rule__PredicatedRuleCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4960:1: ( ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:4961:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:4961:1: ( ( rule__PredicatedRuleCall__RuleAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:4962:2: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:4963:2: ( rule__PredicatedRuleCall__RuleAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:4963:3: rule__PredicatedRuleCall__RuleAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedRuleCall__RuleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalXtextGrammarTestLanguage.g:4972:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4976:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalXtextGrammarTestLanguage.g:4977:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_40);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__1();

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
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:4984:1: rule__Assignment__Group__0__Impl : ( ( rulePredicate )? ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:4988:1: ( ( ( rulePredicate )? ) )
            // InternalXtextGrammarTestLanguage.g:4989:1: ( ( rulePredicate )? )
            {
            // InternalXtextGrammarTestLanguage.g:4989:1: ( ( rulePredicate )? )
            // InternalXtextGrammarTestLanguage.g:4990:2: ( rulePredicate )?
            {
             before(grammarAccess.getAssignmentAccess().getPredicateParserRuleCall_0()); 
            // InternalXtextGrammarTestLanguage.g:4991:2: ( rulePredicate )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==39||LA49_0==45) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:4991:3: rulePredicate
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rulePredicate();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssignmentAccess().getPredicateParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // InternalXtextGrammarTestLanguage.g:4999:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5003:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5004:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_41);
            rule__Assignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__2();

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
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5011:1: rule__Assignment__Group__1__Impl : ( ( rule__Assignment__FeatureAssignment_1 ) ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5015:1: ( ( ( rule__Assignment__FeatureAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5016:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5016:1: ( ( rule__Assignment__FeatureAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:5017:2: ( rule__Assignment__FeatureAssignment_1 )
            {
             before(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:5018:2: ( rule__Assignment__FeatureAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:5018:3: rule__Assignment__FeatureAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__FeatureAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getFeatureAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__2"
    // InternalXtextGrammarTestLanguage.g:5026:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl rule__Assignment__Group__3 ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5030:1: ( rule__Assignment__Group__2__Impl rule__Assignment__Group__3 )
            // InternalXtextGrammarTestLanguage.g:5031:2: rule__Assignment__Group__2__Impl rule__Assignment__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_42);
            rule__Assignment__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__3();

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
    // $ANTLR end "rule__Assignment__Group__2"


    // $ANTLR start "rule__Assignment__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:5038:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__OperatorAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5042:1: ( ( ( rule__Assignment__OperatorAssignment_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:5043:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5043:1: ( ( rule__Assignment__OperatorAssignment_2 ) )
            // InternalXtextGrammarTestLanguage.g:5044:2: ( rule__Assignment__OperatorAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); 
            // InternalXtextGrammarTestLanguage.g:5045:2: ( rule__Assignment__OperatorAssignment_2 )
            // InternalXtextGrammarTestLanguage.g:5045:3: rule__Assignment__OperatorAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__OperatorAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2__Impl"


    // $ANTLR start "rule__Assignment__Group__3"
    // InternalXtextGrammarTestLanguage.g:5053:1: rule__Assignment__Group__3 : rule__Assignment__Group__3__Impl ;
    public final void rule__Assignment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5057:1: ( rule__Assignment__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:5058:2: rule__Assignment__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__Group__3__Impl();

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
    // $ANTLR end "rule__Assignment__Group__3"


    // $ANTLR start "rule__Assignment__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:5064:1: rule__Assignment__Group__3__Impl : ( ( rule__Assignment__TerminalAssignment_3 ) ) ;
    public final void rule__Assignment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5068:1: ( ( ( rule__Assignment__TerminalAssignment_3 ) ) )
            // InternalXtextGrammarTestLanguage.g:5069:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5069:1: ( ( rule__Assignment__TerminalAssignment_3 ) )
            // InternalXtextGrammarTestLanguage.g:5070:2: ( rule__Assignment__TerminalAssignment_3 )
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); 
            // InternalXtextGrammarTestLanguage.g:5071:2: ( rule__Assignment__TerminalAssignment_3 )
            // InternalXtextGrammarTestLanguage.g:5071:3: rule__Assignment__TerminalAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__TerminalAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getTerminalAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__3__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__0"
    // InternalXtextGrammarTestLanguage.g:5080:1: rule__ParenthesizedAssignableElement__Group__0 : rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 ;
    public final void rule__ParenthesizedAssignableElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5084:1: ( rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5085:2: rule__ParenthesizedAssignableElement__Group__0__Impl rule__ParenthesizedAssignableElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_42);
            rule__ParenthesizedAssignableElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__1();

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
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__0"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5092:1: rule__ParenthesizedAssignableElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5096:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:5097:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:5097:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:5098:2: '('
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__1"
    // InternalXtextGrammarTestLanguage.g:5107:1: rule__ParenthesizedAssignableElement__Group__1 : rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 ;
    public final void rule__ParenthesizedAssignableElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5111:1: ( rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5112:2: rule__ParenthesizedAssignableElement__Group__1__Impl rule__ParenthesizedAssignableElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__ParenthesizedAssignableElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__2();

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
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__1"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5119:1: rule__ParenthesizedAssignableElement__Group__1__Impl : ( ruleAssignableAlternatives ) ;
    public final void rule__ParenthesizedAssignableElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5123:1: ( ( ruleAssignableAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:5124:1: ( ruleAssignableAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:5124:1: ( ruleAssignableAlternatives )
            // InternalXtextGrammarTestLanguage.g:5125:2: ruleAssignableAlternatives
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableAlternatives();

            state._fsp--;

             after(grammarAccess.getParenthesizedAssignableElementAccess().getAssignableAlternativesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__2"
    // InternalXtextGrammarTestLanguage.g:5134:1: rule__ParenthesizedAssignableElement__Group__2 : rule__ParenthesizedAssignableElement__Group__2__Impl ;
    public final void rule__ParenthesizedAssignableElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5138:1: ( rule__ParenthesizedAssignableElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:5139:2: rule__ParenthesizedAssignableElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedAssignableElement__Group__2__Impl();

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
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__2"


    // $ANTLR start "rule__ParenthesizedAssignableElement__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:5145:1: rule__ParenthesizedAssignableElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedAssignableElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5149:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:5150:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:5150:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:5151:2: ')'
            {
             before(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedAssignableElementAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedAssignableElement__Group__2__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group__0"
    // InternalXtextGrammarTestLanguage.g:5161:1: rule__AssignableAlternatives__Group__0 : rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 ;
    public final void rule__AssignableAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5165:1: ( rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5166:2: rule__AssignableAlternatives__Group__0__Impl rule__AssignableAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__AssignableAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group__1();

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
    // $ANTLR end "rule__AssignableAlternatives__Group__0"


    // $ANTLR start "rule__AssignableAlternatives__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5173:1: rule__AssignableAlternatives__Group__0__Impl : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5177:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:5178:1: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:5178:1: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:5179:2: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getAssignableTerminalParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group__1"
    // InternalXtextGrammarTestLanguage.g:5188:1: rule__AssignableAlternatives__Group__1 : rule__AssignableAlternatives__Group__1__Impl ;
    public final void rule__AssignableAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5192:1: ( rule__AssignableAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5193:2: rule__AssignableAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group__1__Impl();

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
    // $ANTLR end "rule__AssignableAlternatives__Group__1"


    // $ANTLR start "rule__AssignableAlternatives__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5199:1: rule__AssignableAlternatives__Group__1__Impl : ( ( rule__AssignableAlternatives__Group_1__0 )? ) ;
    public final void rule__AssignableAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5203:1: ( ( ( rule__AssignableAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5204:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5204:1: ( ( rule__AssignableAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5205:2: ( rule__AssignableAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5206:2: ( rule__AssignableAlternatives__Group_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==33) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5206:3: rule__AssignableAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__AssignableAlternatives__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group__1__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:5215:1: rule__AssignableAlternatives__Group_1__0 : rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 ;
    public final void rule__AssignableAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5219:1: ( rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5220:2: rule__AssignableAlternatives__Group_1__0__Impl rule__AssignableAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__AssignableAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1__1();

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
    // $ANTLR end "rule__AssignableAlternatives__Group_1__0"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5227:1: rule__AssignableAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__AssignableAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5231:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:5232:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:5232:1: ( () )
            // InternalXtextGrammarTestLanguage.g:5233:2: ()
            {
             before(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5234:2: ()
            // InternalXtextGrammarTestLanguage.g:5234:3: 
            {
            }

             after(grammarAccess.getAssignableAlternativesAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:5242:1: rule__AssignableAlternatives__Group_1__1 : rule__AssignableAlternatives__Group_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5246:1: ( rule__AssignableAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5247:2: rule__AssignableAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1__1__Impl();

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
    // $ANTLR end "rule__AssignableAlternatives__Group_1__1"


    // $ANTLR start "rule__AssignableAlternatives__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5253:1: rule__AssignableAlternatives__Group_1__1__Impl : ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__AssignableAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5257:1: ( ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:5258:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:5258:1: ( ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:5259:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) ) ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:5259:2: ( ( rule__AssignableAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:5260:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5261:3: ( rule__AssignableAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:5261:4: rule__AssignableAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__AssignableAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:5264:2: ( ( rule__AssignableAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:5265:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5266:3: ( rule__AssignableAlternatives__Group_1_1__0 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==33) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:5266:4: rule__AssignableAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_25);
            	    rule__AssignableAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getAssignableAlternativesAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__AssignableAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:5276:1: rule__AssignableAlternatives__Group_1_1__0 : rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 ;
    public final void rule__AssignableAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5280:1: ( rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:5281:2: rule__AssignableAlternatives__Group_1_1__0__Impl rule__AssignableAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_42);
            rule__AssignableAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1_1__1();

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
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__0"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5288:1: rule__AssignableAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__AssignableAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5292:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:5293:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:5293:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:5294:2: '|'
            {
             before(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAssignableAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:5303:1: rule__AssignableAlternatives__Group_1_1__1 : rule__AssignableAlternatives__Group_1_1__1__Impl ;
    public final void rule__AssignableAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5307:1: ( rule__AssignableAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5308:2: rule__AssignableAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__1"


    // $ANTLR start "rule__AssignableAlternatives__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5314:1: rule__AssignableAlternatives__Group_1_1__1__Impl : ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__AssignableAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5318:1: ( ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5319:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5319:1: ( ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:5320:2: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5321:2: ( rule__AssignableAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:5321:3: rule__AssignableAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__AssignableAlternatives__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__CrossReference__Group__0"
    // InternalXtextGrammarTestLanguage.g:5330:1: rule__CrossReference__Group__0 : rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 ;
    public final void rule__CrossReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5334:1: ( rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5335:2: rule__CrossReference__Group__0__Impl rule__CrossReference__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__CrossReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__1();

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
    // $ANTLR end "rule__CrossReference__Group__0"


    // $ANTLR start "rule__CrossReference__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5342:1: rule__CrossReference__Group__0__Impl : ( '[' ) ;
    public final void rule__CrossReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5346:1: ( ( '[' ) )
            // InternalXtextGrammarTestLanguage.g:5347:1: ( '[' )
            {
            // InternalXtextGrammarTestLanguage.g:5347:1: ( '[' )
            // InternalXtextGrammarTestLanguage.g:5348:2: '['
            {
             before(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 
            match(input,29,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCrossReferenceAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__0__Impl"


    // $ANTLR start "rule__CrossReference__Group__1"
    // InternalXtextGrammarTestLanguage.g:5357:1: rule__CrossReference__Group__1 : rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 ;
    public final void rule__CrossReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5361:1: ( rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5362:2: rule__CrossReference__Group__1__Impl rule__CrossReference__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_44);
            rule__CrossReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__2();

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
    // $ANTLR end "rule__CrossReference__Group__1"


    // $ANTLR start "rule__CrossReference__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5369:1: rule__CrossReference__Group__1__Impl : ( ( rule__CrossReference__TypeAssignment_1 ) ) ;
    public final void rule__CrossReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5373:1: ( ( ( rule__CrossReference__TypeAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5374:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5374:1: ( ( rule__CrossReference__TypeAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:5375:2: ( rule__CrossReference__TypeAssignment_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:5376:2: ( rule__CrossReference__TypeAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:5376:3: rule__CrossReference__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__1__Impl"


    // $ANTLR start "rule__CrossReference__Group__2"
    // InternalXtextGrammarTestLanguage.g:5384:1: rule__CrossReference__Group__2 : rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 ;
    public final void rule__CrossReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5388:1: ( rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3 )
            // InternalXtextGrammarTestLanguage.g:5389:2: rule__CrossReference__Group__2__Impl rule__CrossReference__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_44);
            rule__CrossReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__3();

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
    // $ANTLR end "rule__CrossReference__Group__2"


    // $ANTLR start "rule__CrossReference__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:5396:1: rule__CrossReference__Group__2__Impl : ( ( rule__CrossReference__Group_2__0 )? ) ;
    public final void rule__CrossReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5400:1: ( ( ( rule__CrossReference__Group_2__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5401:1: ( ( rule__CrossReference__Group_2__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5401:1: ( ( rule__CrossReference__Group_2__0 )? )
            // InternalXtextGrammarTestLanguage.g:5402:2: ( rule__CrossReference__Group_2__0 )?
            {
             before(grammarAccess.getCrossReferenceAccess().getGroup_2()); 
            // InternalXtextGrammarTestLanguage.g:5403:2: ( rule__CrossReference__Group_2__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==33) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5403:3: rule__CrossReference__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__CrossReference__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCrossReferenceAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__2__Impl"


    // $ANTLR start "rule__CrossReference__Group__3"
    // InternalXtextGrammarTestLanguage.g:5411:1: rule__CrossReference__Group__3 : rule__CrossReference__Group__3__Impl ;
    public final void rule__CrossReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5415:1: ( rule__CrossReference__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:5416:2: rule__CrossReference__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group__3__Impl();

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
    // $ANTLR end "rule__CrossReference__Group__3"


    // $ANTLR start "rule__CrossReference__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:5422:1: rule__CrossReference__Group__3__Impl : ( ']' ) ;
    public final void rule__CrossReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5426:1: ( ( ']' ) )
            // InternalXtextGrammarTestLanguage.g:5427:1: ( ']' )
            {
            // InternalXtextGrammarTestLanguage.g:5427:1: ( ']' )
            // InternalXtextGrammarTestLanguage.g:5428:2: ']'
            {
             before(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 
            match(input,30,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCrossReferenceAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group__3__Impl"


    // $ANTLR start "rule__CrossReference__Group_2__0"
    // InternalXtextGrammarTestLanguage.g:5438:1: rule__CrossReference__Group_2__0 : rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 ;
    public final void rule__CrossReference__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5442:1: ( rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1 )
            // InternalXtextGrammarTestLanguage.g:5443:2: rule__CrossReference__Group_2__0__Impl rule__CrossReference__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_45);
            rule__CrossReference__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group_2__1();

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
    // $ANTLR end "rule__CrossReference__Group_2__0"


    // $ANTLR start "rule__CrossReference__Group_2__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5450:1: rule__CrossReference__Group_2__0__Impl : ( '|' ) ;
    public final void rule__CrossReference__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5454:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:5455:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:5455:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:5456:2: '|'
            {
             before(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCrossReferenceAccess().getVerticalLineKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__0__Impl"


    // $ANTLR start "rule__CrossReference__Group_2__1"
    // InternalXtextGrammarTestLanguage.g:5465:1: rule__CrossReference__Group_2__1 : rule__CrossReference__Group_2__1__Impl ;
    public final void rule__CrossReference__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5469:1: ( rule__CrossReference__Group_2__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5470:2: rule__CrossReference__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__Group_2__1__Impl();

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
    // $ANTLR end "rule__CrossReference__Group_2__1"


    // $ANTLR start "rule__CrossReference__Group_2__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5476:1: rule__CrossReference__Group_2__1__Impl : ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) ;
    public final void rule__CrossReference__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5480:1: ( ( ( rule__CrossReference__TerminalAssignment_2_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5481:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5481:1: ( ( rule__CrossReference__TerminalAssignment_2_1 ) )
            // InternalXtextGrammarTestLanguage.g:5482:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 
            // InternalXtextGrammarTestLanguage.g:5483:2: ( rule__CrossReference__TerminalAssignment_2_1 )
            // InternalXtextGrammarTestLanguage.g:5483:3: rule__CrossReference__TerminalAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CrossReference__TerminalAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getCrossReferenceAccess().getTerminalAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__Group_2__1__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__0"
    // InternalXtextGrammarTestLanguage.g:5492:1: rule__ParenthesizedElement__Group__0 : rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 ;
    public final void rule__ParenthesizedElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5496:1: ( rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5497:2: rule__ParenthesizedElement__Group__0__Impl rule__ParenthesizedElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__ParenthesizedElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__1();

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
    // $ANTLR end "rule__ParenthesizedElement__Group__0"


    // $ANTLR start "rule__ParenthesizedElement__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5504:1: rule__ParenthesizedElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5508:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:5509:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:5509:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:5510:2: '('
            {
             before(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedElementAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__1"
    // InternalXtextGrammarTestLanguage.g:5519:1: rule__ParenthesizedElement__Group__1 : rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 ;
    public final void rule__ParenthesizedElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5523:1: ( rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5524:2: rule__ParenthesizedElement__Group__1__Impl rule__ParenthesizedElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__ParenthesizedElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__2();

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
    // $ANTLR end "rule__ParenthesizedElement__Group__1"


    // $ANTLR start "rule__ParenthesizedElement__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5531:1: rule__ParenthesizedElement__Group__1__Impl : ( ruleAlternatives ) ;
    public final void rule__ParenthesizedElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5535:1: ( ( ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:5536:1: ( ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:5536:1: ( ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:5537:2: ruleAlternatives
            {
             before(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getParenthesizedElementAccess().getAlternativesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedElement__Group__2"
    // InternalXtextGrammarTestLanguage.g:5546:1: rule__ParenthesizedElement__Group__2 : rule__ParenthesizedElement__Group__2__Impl ;
    public final void rule__ParenthesizedElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5550:1: ( rule__ParenthesizedElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:5551:2: rule__ParenthesizedElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedElement__Group__2__Impl();

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
    // $ANTLR end "rule__ParenthesizedElement__Group__2"


    // $ANTLR start "rule__ParenthesizedElement__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:5557:1: rule__ParenthesizedElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5561:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:5562:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:5562:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:5563:2: ')'
            {
             before(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedElementAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedElement__Group__2__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__0"
    // InternalXtextGrammarTestLanguage.g:5573:1: rule__PredicatedGroup__Group__0 : rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 ;
    public final void rule__PredicatedGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5577:1: ( rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5578:2: rule__PredicatedGroup__Group__0__Impl rule__PredicatedGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__PredicatedGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__1();

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
    // $ANTLR end "rule__PredicatedGroup__Group__0"


    // $ANTLR start "rule__PredicatedGroup__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5585:1: rule__PredicatedGroup__Group__0__Impl : ( rulePredicate ) ;
    public final void rule__PredicatedGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5589:1: ( ( rulePredicate ) )
            // InternalXtextGrammarTestLanguage.g:5590:1: ( rulePredicate )
            {
            // InternalXtextGrammarTestLanguage.g:5590:1: ( rulePredicate )
            // InternalXtextGrammarTestLanguage.g:5591:2: rulePredicate
            {
             before(grammarAccess.getPredicatedGroupAccess().getPredicateParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            rulePredicate();

            state._fsp--;

             after(grammarAccess.getPredicatedGroupAccess().getPredicateParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__0__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__1"
    // InternalXtextGrammarTestLanguage.g:5600:1: rule__PredicatedGroup__Group__1 : rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 ;
    public final void rule__PredicatedGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5604:1: ( rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5605:2: rule__PredicatedGroup__Group__1__Impl rule__PredicatedGroup__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_16);
            rule__PredicatedGroup__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__2();

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
    // $ANTLR end "rule__PredicatedGroup__Group__1"


    // $ANTLR start "rule__PredicatedGroup__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5612:1: rule__PredicatedGroup__Group__1__Impl : ( '(' ) ;
    public final void rule__PredicatedGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5616:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:5617:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:5617:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:5618:2: '('
            {
             before(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__1__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__2"
    // InternalXtextGrammarTestLanguage.g:5627:1: rule__PredicatedGroup__Group__2 : rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 ;
    public final void rule__PredicatedGroup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5631:1: ( rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3 )
            // InternalXtextGrammarTestLanguage.g:5632:2: rule__PredicatedGroup__Group__2__Impl rule__PredicatedGroup__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__PredicatedGroup__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__3();

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
    // $ANTLR end "rule__PredicatedGroup__Group__2"


    // $ANTLR start "rule__PredicatedGroup__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:5639:1: rule__PredicatedGroup__Group__2__Impl : ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) ;
    public final void rule__PredicatedGroup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5643:1: ( ( ( rule__PredicatedGroup__ElementsAssignment_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:5644:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5644:1: ( ( rule__PredicatedGroup__ElementsAssignment_2 ) )
            // InternalXtextGrammarTestLanguage.g:5645:2: ( rule__PredicatedGroup__ElementsAssignment_2 )
            {
             before(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); 
            // InternalXtextGrammarTestLanguage.g:5646:2: ( rule__PredicatedGroup__ElementsAssignment_2 )
            // InternalXtextGrammarTestLanguage.g:5646:3: rule__PredicatedGroup__ElementsAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPredicatedGroupAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__2__Impl"


    // $ANTLR start "rule__PredicatedGroup__Group__3"
    // InternalXtextGrammarTestLanguage.g:5654:1: rule__PredicatedGroup__Group__3 : rule__PredicatedGroup__Group__3__Impl ;
    public final void rule__PredicatedGroup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5658:1: ( rule__PredicatedGroup__Group__3__Impl )
            // InternalXtextGrammarTestLanguage.g:5659:2: rule__PredicatedGroup__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__PredicatedGroup__Group__3__Impl();

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
    // $ANTLR end "rule__PredicatedGroup__Group__3"


    // $ANTLR start "rule__PredicatedGroup__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:5665:1: rule__PredicatedGroup__Group__3__Impl : ( ')' ) ;
    public final void rule__PredicatedGroup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5669:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:5670:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:5670:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:5671:2: ')'
            {
             before(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedGroupAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__Group__3__Impl"


    // $ANTLR start "rule__TerminalRule__Group__0"
    // InternalXtextGrammarTestLanguage.g:5681:1: rule__TerminalRule__Group__0 : rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 ;
    public final void rule__TerminalRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5685:1: ( rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5686:2: rule__TerminalRule__Group__0__Impl rule__TerminalRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_18);
            rule__TerminalRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__1();

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
    // $ANTLR end "rule__TerminalRule__Group__0"


    // $ANTLR start "rule__TerminalRule__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5693:1: rule__TerminalRule__Group__0__Impl : ( 'terminal' ) ;
    public final void rule__TerminalRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5697:1: ( ( 'terminal' ) )
            // InternalXtextGrammarTestLanguage.g:5698:1: ( 'terminal' )
            {
            // InternalXtextGrammarTestLanguage.g:5698:1: ( 'terminal' )
            // InternalXtextGrammarTestLanguage.g:5699:2: 'terminal'
            {
             before(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 
            match(input,38,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getTerminalKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group__1"
    // InternalXtextGrammarTestLanguage.g:5708:1: rule__TerminalRule__Group__1 : rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 ;
    public final void rule__TerminalRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5712:1: ( rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:5713:2: rule__TerminalRule__Group__1__Impl rule__TerminalRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_46);
            rule__TerminalRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__2();

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
    // $ANTLR end "rule__TerminalRule__Group__1"


    // $ANTLR start "rule__TerminalRule__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5720:1: rule__TerminalRule__Group__1__Impl : ( ( rule__TerminalRule__Alternatives_1 ) ) ;
    public final void rule__TerminalRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5724:1: ( ( ( rule__TerminalRule__Alternatives_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5725:1: ( ( rule__TerminalRule__Alternatives_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5725:1: ( ( rule__TerminalRule__Alternatives_1 ) )
            // InternalXtextGrammarTestLanguage.g:5726:2: ( rule__TerminalRule__Alternatives_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternatives_1()); 
            // InternalXtextGrammarTestLanguage.g:5727:2: ( rule__TerminalRule__Alternatives_1 )
            // InternalXtextGrammarTestLanguage.g:5727:3: rule__TerminalRule__Alternatives_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group__2"
    // InternalXtextGrammarTestLanguage.g:5735:1: rule__TerminalRule__Group__2 : rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 ;
    public final void rule__TerminalRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5739:1: ( rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:5740:2: rule__TerminalRule__Group__2__Impl rule__TerminalRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__TerminalRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__3();

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
    // $ANTLR end "rule__TerminalRule__Group__2"


    // $ANTLR start "rule__TerminalRule__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:5747:1: rule__TerminalRule__Group__2__Impl : ( ':' ) ;
    public final void rule__TerminalRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5751:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:5752:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:5752:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:5753:2: ':'
            {
             before(grammarAccess.getTerminalRuleAccess().getColonKeyword_2()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__2__Impl"


    // $ANTLR start "rule__TerminalRule__Group__3"
    // InternalXtextGrammarTestLanguage.g:5762:1: rule__TerminalRule__Group__3 : rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 ;
    public final void rule__TerminalRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5766:1: ( rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:5767:2: rule__TerminalRule__Group__3__Impl rule__TerminalRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__TerminalRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__4();

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
    // $ANTLR end "rule__TerminalRule__Group__3"


    // $ANTLR start "rule__TerminalRule__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:5774:1: rule__TerminalRule__Group__3__Impl : ( ( rule__TerminalRule__AlternativesAssignment_3 ) ) ;
    public final void rule__TerminalRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5778:1: ( ( ( rule__TerminalRule__AlternativesAssignment_3 ) ) )
            // InternalXtextGrammarTestLanguage.g:5779:1: ( ( rule__TerminalRule__AlternativesAssignment_3 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5779:1: ( ( rule__TerminalRule__AlternativesAssignment_3 ) )
            // InternalXtextGrammarTestLanguage.g:5780:2: ( rule__TerminalRule__AlternativesAssignment_3 )
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_3()); 
            // InternalXtextGrammarTestLanguage.g:5781:2: ( rule__TerminalRule__AlternativesAssignment_3 )
            // InternalXtextGrammarTestLanguage.g:5781:3: rule__TerminalRule__AlternativesAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__AlternativesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getAlternativesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__3__Impl"


    // $ANTLR start "rule__TerminalRule__Group__4"
    // InternalXtextGrammarTestLanguage.g:5789:1: rule__TerminalRule__Group__4 : rule__TerminalRule__Group__4__Impl ;
    public final void rule__TerminalRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5793:1: ( rule__TerminalRule__Group__4__Impl )
            // InternalXtextGrammarTestLanguage.g:5794:2: rule__TerminalRule__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group__4__Impl();

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
    // $ANTLR end "rule__TerminalRule__Group__4"


    // $ANTLR start "rule__TerminalRule__Group__4__Impl"
    // InternalXtextGrammarTestLanguage.g:5800:1: rule__TerminalRule__Group__4__Impl : ( ';' ) ;
    public final void rule__TerminalRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5804:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:5805:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:5805:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:5806:2: ';'
            {
             before(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_4()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group__4__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_0__0"
    // InternalXtextGrammarTestLanguage.g:5816:1: rule__TerminalRule__Group_1_0__0 : rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1 ;
    public final void rule__TerminalRule__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5820:1: ( rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1 )
            // InternalXtextGrammarTestLanguage.g:5821:2: rule__TerminalRule__Group_1_0__0__Impl rule__TerminalRule__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TerminalRule__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_1_0__1();

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
    // $ANTLR end "rule__TerminalRule__Group_1_0__0"


    // $ANTLR start "rule__TerminalRule__Group_1_0__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5828:1: rule__TerminalRule__Group_1_0__0__Impl : ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) ) ;
    public final void rule__TerminalRule__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5832:1: ( ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:5833:1: ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5833:1: ( ( rule__TerminalRule__FragmentAssignment_1_0_0 ) )
            // InternalXtextGrammarTestLanguage.g:5834:2: ( rule__TerminalRule__FragmentAssignment_1_0_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_1_0_0()); 
            // InternalXtextGrammarTestLanguage.g:5835:2: ( rule__TerminalRule__FragmentAssignment_1_0_0 )
            // InternalXtextGrammarTestLanguage.g:5835:3: rule__TerminalRule__FragmentAssignment_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__FragmentAssignment_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentAssignment_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_0__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_0__1"
    // InternalXtextGrammarTestLanguage.g:5843:1: rule__TerminalRule__Group_1_0__1 : rule__TerminalRule__Group_1_0__1__Impl ;
    public final void rule__TerminalRule__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5847:1: ( rule__TerminalRule__Group_1_0__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5848:2: rule__TerminalRule__Group_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_1_0__1__Impl();

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
    // $ANTLR end "rule__TerminalRule__Group_1_0__1"


    // $ANTLR start "rule__TerminalRule__Group_1_0__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5854:1: rule__TerminalRule__Group_1_0__1__Impl : ( ( rule__TerminalRule__NameAssignment_1_0_1 ) ) ;
    public final void rule__TerminalRule__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5858:1: ( ( ( rule__TerminalRule__NameAssignment_1_0_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:5859:1: ( ( rule__TerminalRule__NameAssignment_1_0_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5859:1: ( ( rule__TerminalRule__NameAssignment_1_0_1 ) )
            // InternalXtextGrammarTestLanguage.g:5860:2: ( rule__TerminalRule__NameAssignment_1_0_1 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_0_1()); 
            // InternalXtextGrammarTestLanguage.g:5861:2: ( rule__TerminalRule__NameAssignment_1_0_1 )
            // InternalXtextGrammarTestLanguage.g:5861:3: rule__TerminalRule__NameAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__NameAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_0__1__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:5870:1: rule__TerminalRule__Group_1_1__0 : rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1 ;
    public final void rule__TerminalRule__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5874:1: ( rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:5875:2: rule__TerminalRule__Group_1_1__0__Impl rule__TerminalRule__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_20);
            rule__TerminalRule__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_1_1__1();

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
    // $ANTLR end "rule__TerminalRule__Group_1_1__0"


    // $ANTLR start "rule__TerminalRule__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5882:1: rule__TerminalRule__Group_1_1__0__Impl : ( ( rule__TerminalRule__NameAssignment_1_1_0 ) ) ;
    public final void rule__TerminalRule__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5886:1: ( ( ( rule__TerminalRule__NameAssignment_1_1_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:5887:1: ( ( rule__TerminalRule__NameAssignment_1_1_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:5887:1: ( ( rule__TerminalRule__NameAssignment_1_1_0 ) )
            // InternalXtextGrammarTestLanguage.g:5888:2: ( rule__TerminalRule__NameAssignment_1_1_0 )
            {
             before(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5889:2: ( rule__TerminalRule__NameAssignment_1_1_0 )
            // InternalXtextGrammarTestLanguage.g:5889:3: rule__TerminalRule__NameAssignment_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__NameAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalRuleAccess().getNameAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1__0__Impl"


    // $ANTLR start "rule__TerminalRule__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:5897:1: rule__TerminalRule__Group_1_1__1 : rule__TerminalRule__Group_1_1__1__Impl ;
    public final void rule__TerminalRule__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5901:1: ( rule__TerminalRule__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5902:2: rule__TerminalRule__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalRule__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__TerminalRule__Group_1_1__1"


    // $ANTLR start "rule__TerminalRule__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5908:1: rule__TerminalRule__Group_1_1__1__Impl : ( ( ruleReturnsClause )? ) ;
    public final void rule__TerminalRule__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5912:1: ( ( ( ruleReturnsClause )? ) )
            // InternalXtextGrammarTestLanguage.g:5913:1: ( ( ruleReturnsClause )? )
            {
            // InternalXtextGrammarTestLanguage.g:5913:1: ( ( ruleReturnsClause )? )
            // InternalXtextGrammarTestLanguage.g:5914:2: ( ruleReturnsClause )?
            {
             before(grammarAccess.getTerminalRuleAccess().getReturnsClauseParserRuleCall_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:5915:2: ( ruleReturnsClause )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==31) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5915:3: ruleReturnsClause
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReturnsClause();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalRuleAccess().getReturnsClauseParserRuleCall_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__Group_1_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__0"
    // InternalXtextGrammarTestLanguage.g:5924:1: rule__TerminalAlternatives__Group__0 : rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 ;
    public final void rule__TerminalAlternatives__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5928:1: ( rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1 )
            // InternalXtextGrammarTestLanguage.g:5929:2: rule__TerminalAlternatives__Group__0__Impl rule__TerminalAlternatives__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__TerminalAlternatives__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group__1();

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
    // $ANTLR end "rule__TerminalAlternatives__Group__0"


    // $ANTLR start "rule__TerminalAlternatives__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5936:1: rule__TerminalAlternatives__Group__0__Impl : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5940:1: ( ( ruleTerminalGroup ) )
            // InternalXtextGrammarTestLanguage.g:5941:1: ( ruleTerminalGroup )
            {
            // InternalXtextGrammarTestLanguage.g:5941:1: ( ruleTerminalGroup )
            // InternalXtextGrammarTestLanguage.g:5942:2: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getTerminalGroupParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group__1"
    // InternalXtextGrammarTestLanguage.g:5951:1: rule__TerminalAlternatives__Group__1 : rule__TerminalAlternatives__Group__1__Impl ;
    public final void rule__TerminalAlternatives__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5955:1: ( rule__TerminalAlternatives__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:5956:2: rule__TerminalAlternatives__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group__1__Impl();

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
    // $ANTLR end "rule__TerminalAlternatives__Group__1"


    // $ANTLR start "rule__TerminalAlternatives__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:5962:1: rule__TerminalAlternatives__Group__1__Impl : ( ( rule__TerminalAlternatives__Group_1__0 )? ) ;
    public final void rule__TerminalAlternatives__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5966:1: ( ( ( rule__TerminalAlternatives__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:5967:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:5967:1: ( ( rule__TerminalAlternatives__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:5968:2: ( rule__TerminalAlternatives__Group_1__0 )?
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:5969:2: ( rule__TerminalAlternatives__Group_1__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==33) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:5969:3: rule__TerminalAlternatives__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalAlternatives__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:5978:1: rule__TerminalAlternatives__Group_1__0 : rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 ;
    public final void rule__TerminalAlternatives__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5982:1: ( rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:5983:2: rule__TerminalAlternatives__Group_1__0__Impl rule__TerminalAlternatives__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__TerminalAlternatives__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1__1();

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
    // $ANTLR end "rule__TerminalAlternatives__Group_1__0"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:5990:1: rule__TerminalAlternatives__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalAlternatives__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:5994:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:5995:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:5995:1: ( () )
            // InternalXtextGrammarTestLanguage.g:5996:2: ()
            {
             before(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:5997:2: ()
            // InternalXtextGrammarTestLanguage.g:5997:3: 
            {
            }

             after(grammarAccess.getTerminalAlternativesAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:6005:1: rule__TerminalAlternatives__Group_1__1 : rule__TerminalAlternatives__Group_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6009:1: ( rule__TerminalAlternatives__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6010:2: rule__TerminalAlternatives__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1__1__Impl();

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
    // $ANTLR end "rule__TerminalAlternatives__Group_1__1"


    // $ANTLR start "rule__TerminalAlternatives__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6016:1: rule__TerminalAlternatives__Group_1__1__Impl : ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) ;
    public final void rule__TerminalAlternatives__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6020:1: ( ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:6021:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:6021:1: ( ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:6022:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) ) ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:6022:2: ( ( rule__TerminalAlternatives__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:6023:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:6024:3: ( rule__TerminalAlternatives__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:6024:4: rule__TerminalAlternatives__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__TerminalAlternatives__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:6027:2: ( ( rule__TerminalAlternatives__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:6028:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            {
             before(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:6029:3: ( rule__TerminalAlternatives__Group_1_1__0 )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==33) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:6029:4: rule__TerminalAlternatives__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_25);
            	    rule__TerminalAlternatives__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

             after(grammarAccess.getTerminalAlternativesAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__TerminalAlternatives__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:6039:1: rule__TerminalAlternatives__Group_1_1__0 : rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 ;
    public final void rule__TerminalAlternatives__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6043:1: ( rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:6044:2: rule__TerminalAlternatives__Group_1_1__0__Impl rule__TerminalAlternatives__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__TerminalAlternatives__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1_1__1();

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
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__0"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6051:1: rule__TerminalAlternatives__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__TerminalAlternatives__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6055:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:6056:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:6056:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:6057:2: '|'
            {
             before(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalAlternativesAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__0__Impl"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:6066:1: rule__TerminalAlternatives__Group_1_1__1 : rule__TerminalAlternatives__Group_1_1__1__Impl ;
    public final void rule__TerminalAlternatives__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6070:1: ( rule__TerminalAlternatives__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6071:2: rule__TerminalAlternatives__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__1"


    // $ANTLR start "rule__TerminalAlternatives__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6077:1: rule__TerminalAlternatives__Group_1_1__1__Impl : ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__TerminalAlternatives__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6081:1: ( ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:6082:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6082:1: ( ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:6083:2: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:6084:2: ( rule__TerminalAlternatives__ElementsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:6084:3: rule__TerminalAlternatives__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalAlternatives__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalAlternativesAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__Group_1_1__1__Impl"


    // $ANTLR start "rule__TerminalGroup__Group__0"
    // InternalXtextGrammarTestLanguage.g:6093:1: rule__TerminalGroup__Group__0 : rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 ;
    public final void rule__TerminalGroup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6097:1: ( rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6098:2: rule__TerminalGroup__Group__0__Impl rule__TerminalGroup__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__TerminalGroup__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group__1();

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
    // $ANTLR end "rule__TerminalGroup__Group__0"


    // $ANTLR start "rule__TerminalGroup__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6105:1: rule__TerminalGroup__Group__0__Impl : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6109:1: ( ( ruleTerminalToken ) )
            // InternalXtextGrammarTestLanguage.g:6110:1: ( ruleTerminalToken )
            {
            // InternalXtextGrammarTestLanguage.g:6110:1: ( ruleTerminalToken )
            // InternalXtextGrammarTestLanguage.g:6111:2: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalGroupAccess().getTerminalTokenParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__0__Impl"


    // $ANTLR start "rule__TerminalGroup__Group__1"
    // InternalXtextGrammarTestLanguage.g:6120:1: rule__TerminalGroup__Group__1 : rule__TerminalGroup__Group__1__Impl ;
    public final void rule__TerminalGroup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6124:1: ( rule__TerminalGroup__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6125:2: rule__TerminalGroup__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group__1__Impl();

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
    // $ANTLR end "rule__TerminalGroup__Group__1"


    // $ANTLR start "rule__TerminalGroup__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6131:1: rule__TerminalGroup__Group__1__Impl : ( ( rule__TerminalGroup__Group_1__0 )? ) ;
    public final void rule__TerminalGroup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6135:1: ( ( ( rule__TerminalGroup__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:6136:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:6136:1: ( ( rule__TerminalGroup__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:6137:2: ( rule__TerminalGroup__Group_1__0 )?
            {
             before(grammarAccess.getTerminalGroupAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:6138:2: ( rule__TerminalGroup__Group_1__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=RULE_ID && LA56_0<=RULE_STRING)||LA56_0==16||LA56_0==21||LA56_0==23||(LA56_0>=39 && LA56_0<=40)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:6138:3: rule__TerminalGroup__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__TerminalGroup__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalGroupAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group__1__Impl"


    // $ANTLR start "rule__TerminalGroup__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:6147:1: rule__TerminalGroup__Group_1__0 : rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 ;
    public final void rule__TerminalGroup__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6151:1: ( rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:6152:2: rule__TerminalGroup__Group_1__0__Impl rule__TerminalGroup__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__TerminalGroup__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group_1__1();

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
    // $ANTLR end "rule__TerminalGroup__Group_1__0"


    // $ANTLR start "rule__TerminalGroup__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6159:1: rule__TerminalGroup__Group_1__0__Impl : ( () ) ;
    public final void rule__TerminalGroup__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6163:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:6164:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:6164:1: ( () )
            // InternalXtextGrammarTestLanguage.g:6165:2: ()
            {
             before(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6166:2: ()
            // InternalXtextGrammarTestLanguage.g:6166:3: 
            {
            }

             after(grammarAccess.getTerminalGroupAccess().getGroupElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__Group_1__0__Impl"


    // $ANTLR start "rule__TerminalGroup__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:6174:1: rule__TerminalGroup__Group_1__1 : rule__TerminalGroup__Group_1__1__Impl ;
    public final void rule__TerminalGroup__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6178:1: ( rule__TerminalGroup__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6179:2: rule__TerminalGroup__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalGroup__Group_1__1__Impl();

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
    // $ANTLR end "rule__TerminalGroup__Group_1__1"


    // $ANTLR start "rule__TerminalGroup__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6185:1: rule__TerminalGroup__Group_1__1__Impl : ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) ;
    public final void rule__TerminalGroup__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6189:1: ( ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:6190:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:6190:1: ( ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* ) )
            // InternalXtextGrammarTestLanguage.g:6191:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) ) ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            {
            // InternalXtextGrammarTestLanguage.g:6191:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:6192:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:6193:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:6193:4: rule__TerminalGroup__ElementsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_48);
            rule__TerminalGroup__ElementsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:6196:2: ( ( rule__TerminalGroup__ElementsAssignment_1_1 )* )
            // InternalXtextGrammarTestLanguage.g:6197:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:6198:3: ( rule__TerminalGroup__ElementsAssignment_1_1 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_ID && LA57_0<=RULE_STRING)||LA57_0==16||LA57_0==21||LA57_0==23||(LA57_0>=39 && LA57_0<=40)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:6198:4: rule__TerminalGroup__ElementsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_48);
            	    rule__TerminalGroup__ElementsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getTerminalGroupAccess().getElementsAssignment_1_1()); 

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
    // $ANTLR end "rule__TerminalGroup__Group_1__1__Impl"


    // $ANTLR start "rule__TerminalToken__Group__0"
    // InternalXtextGrammarTestLanguage.g:6208:1: rule__TerminalToken__Group__0 : rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 ;
    public final void rule__TerminalToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6212:1: ( rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6213:2: rule__TerminalToken__Group__0__Impl rule__TerminalToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_32);
            rule__TerminalToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalToken__Group__1();

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
    // $ANTLR end "rule__TerminalToken__Group__0"


    // $ANTLR start "rule__TerminalToken__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6220:1: rule__TerminalToken__Group__0__Impl : ( ruleTerminalTokenElement ) ;
    public final void rule__TerminalToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6224:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:6225:1: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:6225:1: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:6226:2: ruleTerminalTokenElement
            {
             before(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getTerminalTokenAccess().getTerminalTokenElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__0__Impl"


    // $ANTLR start "rule__TerminalToken__Group__1"
    // InternalXtextGrammarTestLanguage.g:6235:1: rule__TerminalToken__Group__1 : rule__TerminalToken__Group__1__Impl ;
    public final void rule__TerminalToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6239:1: ( rule__TerminalToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6240:2: rule__TerminalToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TerminalToken__Group__1__Impl();

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
    // $ANTLR end "rule__TerminalToken__Group__1"


    // $ANTLR start "rule__TerminalToken__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6246:1: rule__TerminalToken__Group__1__Impl : ( ( ruleCardinalities )? ) ;
    public final void rule__TerminalToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6250:1: ( ( ( ruleCardinalities )? ) )
            // InternalXtextGrammarTestLanguage.g:6251:1: ( ( ruleCardinalities )? )
            {
            // InternalXtextGrammarTestLanguage.g:6251:1: ( ( ruleCardinalities )? )
            // InternalXtextGrammarTestLanguage.g:6252:2: ( ruleCardinalities )?
            {
             before(grammarAccess.getTerminalTokenAccess().getCardinalitiesParserRuleCall_1()); 
            // InternalXtextGrammarTestLanguage.g:6253:2: ( ruleCardinalities )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=11 && LA58_0<=13)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:6253:3: ruleCardinalities
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCardinalities();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTerminalTokenAccess().getCardinalitiesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalToken__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__0"
    // InternalXtextGrammarTestLanguage.g:6262:1: rule__ParenthesizedTerminalElement__Group__0 : rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 ;
    public final void rule__ParenthesizedTerminalElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6266:1: ( rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6267:2: rule__ParenthesizedTerminalElement__Group__0__Impl rule__ParenthesizedTerminalElement__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__ParenthesizedTerminalElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__1();

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
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__0"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6274:1: rule__ParenthesizedTerminalElement__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6278:1: ( ( '(' ) )
            // InternalXtextGrammarTestLanguage.g:6279:1: ( '(' )
            {
            // InternalXtextGrammarTestLanguage.g:6279:1: ( '(' )
            // InternalXtextGrammarTestLanguage.g:6280:2: '('
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__1"
    // InternalXtextGrammarTestLanguage.g:6289:1: rule__ParenthesizedTerminalElement__Group__1 : rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 ;
    public final void rule__ParenthesizedTerminalElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6293:1: ( rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2 )
            // InternalXtextGrammarTestLanguage.g:6294:2: rule__ParenthesizedTerminalElement__Group__1__Impl rule__ParenthesizedTerminalElement__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_43);
            rule__ParenthesizedTerminalElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__2();

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
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__1"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6301:1: rule__ParenthesizedTerminalElement__Group__1__Impl : ( ruleTerminalAlternatives ) ;
    public final void rule__ParenthesizedTerminalElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6305:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:6306:1: ( ruleTerminalAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:6306:1: ( ruleTerminalAlternatives )
            // InternalXtextGrammarTestLanguage.g:6307:2: ruleTerminalAlternatives
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getParenthesizedTerminalElementAccess().getTerminalAlternativesParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__2"
    // InternalXtextGrammarTestLanguage.g:6316:1: rule__ParenthesizedTerminalElement__Group__2 : rule__ParenthesizedTerminalElement__Group__2__Impl ;
    public final void rule__ParenthesizedTerminalElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6320:1: ( rule__ParenthesizedTerminalElement__Group__2__Impl )
            // InternalXtextGrammarTestLanguage.g:6321:2: rule__ParenthesizedTerminalElement__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__ParenthesizedTerminalElement__Group__2__Impl();

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
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__2"


    // $ANTLR start "rule__ParenthesizedTerminalElement__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:6327:1: rule__ParenthesizedTerminalElement__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedTerminalElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6331:1: ( ( ')' ) )
            // InternalXtextGrammarTestLanguage.g:6332:1: ( ')' )
            {
            // InternalXtextGrammarTestLanguage.g:6332:1: ( ')' )
            // InternalXtextGrammarTestLanguage.g:6333:2: ')'
            {
             before(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParenthesizedTerminalElementAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedTerminalElement__Group__2__Impl"


    // $ANTLR start "rule__NegatedToken__Group__0"
    // InternalXtextGrammarTestLanguage.g:6343:1: rule__NegatedToken__Group__0 : rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 ;
    public final void rule__NegatedToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6347:1: ( rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6348:2: rule__NegatedToken__Group__0__Impl rule__NegatedToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__NegatedToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__Group__1();

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
    // $ANTLR end "rule__NegatedToken__Group__0"


    // $ANTLR start "rule__NegatedToken__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6355:1: rule__NegatedToken__Group__0__Impl : ( '!' ) ;
    public final void rule__NegatedToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6359:1: ( ( '!' ) )
            // InternalXtextGrammarTestLanguage.g:6360:1: ( '!' )
            {
            // InternalXtextGrammarTestLanguage.g:6360:1: ( '!' )
            // InternalXtextGrammarTestLanguage.g:6361:2: '!'
            {
             before(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 
            match(input,16,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNegatedTokenAccess().getExclamationMarkKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__0__Impl"


    // $ANTLR start "rule__NegatedToken__Group__1"
    // InternalXtextGrammarTestLanguage.g:6370:1: rule__NegatedToken__Group__1 : rule__NegatedToken__Group__1__Impl ;
    public final void rule__NegatedToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6374:1: ( rule__NegatedToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6375:2: rule__NegatedToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__Group__1__Impl();

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
    // $ANTLR end "rule__NegatedToken__Group__1"


    // $ANTLR start "rule__NegatedToken__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6381:1: rule__NegatedToken__Group__1__Impl : ( ( rule__NegatedToken__TerminalAssignment_1 ) ) ;
    public final void rule__NegatedToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6385:1: ( ( ( rule__NegatedToken__TerminalAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:6386:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6386:1: ( ( rule__NegatedToken__TerminalAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:6387:2: ( rule__NegatedToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:6388:2: ( rule__NegatedToken__TerminalAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:6388:3: rule__NegatedToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__NegatedToken__TerminalAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNegatedTokenAccess().getTerminalAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__Group__1__Impl"


    // $ANTLR start "rule__UntilToken__Group__0"
    // InternalXtextGrammarTestLanguage.g:6397:1: rule__UntilToken__Group__0 : rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 ;
    public final void rule__UntilToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6401:1: ( rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6402:2: rule__UntilToken__Group__0__Impl rule__UntilToken__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__UntilToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__Group__1();

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
    // $ANTLR end "rule__UntilToken__Group__0"


    // $ANTLR start "rule__UntilToken__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6409:1: rule__UntilToken__Group__0__Impl : ( '->' ) ;
    public final void rule__UntilToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6413:1: ( ( '->' ) )
            // InternalXtextGrammarTestLanguage.g:6414:1: ( '->' )
            {
            // InternalXtextGrammarTestLanguage.g:6414:1: ( '->' )
            // InternalXtextGrammarTestLanguage.g:6415:2: '->'
            {
             before(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 
            match(input,39,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getUntilTokenAccess().getHyphenMinusGreaterThanSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__0__Impl"


    // $ANTLR start "rule__UntilToken__Group__1"
    // InternalXtextGrammarTestLanguage.g:6424:1: rule__UntilToken__Group__1 : rule__UntilToken__Group__1__Impl ;
    public final void rule__UntilToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6428:1: ( rule__UntilToken__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6429:2: rule__UntilToken__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__Group__1__Impl();

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
    // $ANTLR end "rule__UntilToken__Group__1"


    // $ANTLR start "rule__UntilToken__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6435:1: rule__UntilToken__Group__1__Impl : ( ( rule__UntilToken__TerminalAssignment_1 ) ) ;
    public final void rule__UntilToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6439:1: ( ( ( rule__UntilToken__TerminalAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:6440:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6440:1: ( ( rule__UntilToken__TerminalAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:6441:2: ( rule__UntilToken__TerminalAssignment_1 )
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:6442:2: ( rule__UntilToken__TerminalAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:6442:3: rule__UntilToken__TerminalAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__UntilToken__TerminalAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUntilTokenAccess().getTerminalAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__Group__1__Impl"


    // $ANTLR start "rule__Wildcard__Group__0"
    // InternalXtextGrammarTestLanguage.g:6451:1: rule__Wildcard__Group__0 : rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 ;
    public final void rule__Wildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6455:1: ( rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6456:2: rule__Wildcard__Group__0__Impl rule__Wildcard__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_11);
            rule__Wildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Wildcard__Group__1();

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
    // $ANTLR end "rule__Wildcard__Group__0"


    // $ANTLR start "rule__Wildcard__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6463:1: rule__Wildcard__Group__0__Impl : ( () ) ;
    public final void rule__Wildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6467:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:6468:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:6468:1: ( () )
            // InternalXtextGrammarTestLanguage.g:6469:2: ()
            {
             before(grammarAccess.getWildcardAccess().getWildcardAction_0()); 
            // InternalXtextGrammarTestLanguage.g:6470:2: ()
            // InternalXtextGrammarTestLanguage.g:6470:3: 
            {
            }

             after(grammarAccess.getWildcardAccess().getWildcardAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__0__Impl"


    // $ANTLR start "rule__Wildcard__Group__1"
    // InternalXtextGrammarTestLanguage.g:6478:1: rule__Wildcard__Group__1 : rule__Wildcard__Group__1__Impl ;
    public final void rule__Wildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6482:1: ( rule__Wildcard__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6483:2: rule__Wildcard__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Wildcard__Group__1__Impl();

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
    // $ANTLR end "rule__Wildcard__Group__1"


    // $ANTLR start "rule__Wildcard__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6489:1: rule__Wildcard__Group__1__Impl : ( '.' ) ;
    public final void rule__Wildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6493:1: ( ( '.' ) )
            // InternalXtextGrammarTestLanguage.g:6494:1: ( '.' )
            {
            // InternalXtextGrammarTestLanguage.g:6494:1: ( '.' )
            // InternalXtextGrammarTestLanguage.g:6495:2: '.'
            {
             before(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getWildcardAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Wildcard__Group__1__Impl"


    // $ANTLR start "rule__EOF__Group__0"
    // InternalXtextGrammarTestLanguage.g:6505:1: rule__EOF__Group__0 : rule__EOF__Group__0__Impl rule__EOF__Group__1 ;
    public final void rule__EOF__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6509:1: ( rule__EOF__Group__0__Impl rule__EOF__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6510:2: rule__EOF__Group__0__Impl rule__EOF__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_47);
            rule__EOF__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__1();

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
    // $ANTLR end "rule__EOF__Group__0"


    // $ANTLR start "rule__EOF__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6517:1: rule__EOF__Group__0__Impl : ( () ) ;
    public final void rule__EOF__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6521:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:6522:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:6522:1: ( () )
            // InternalXtextGrammarTestLanguage.g:6523:2: ()
            {
             before(grammarAccess.getEOFAccess().getEOFAction_0()); 
            // InternalXtextGrammarTestLanguage.g:6524:2: ()
            // InternalXtextGrammarTestLanguage.g:6524:3: 
            {
            }

             after(grammarAccess.getEOFAccess().getEOFAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__0__Impl"


    // $ANTLR start "rule__EOF__Group__1"
    // InternalXtextGrammarTestLanguage.g:6532:1: rule__EOF__Group__1 : rule__EOF__Group__1__Impl ;
    public final void rule__EOF__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6536:1: ( rule__EOF__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6537:2: rule__EOF__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EOF__Group__1__Impl();

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
    // $ANTLR end "rule__EOF__Group__1"


    // $ANTLR start "rule__EOF__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6543:1: rule__EOF__Group__1__Impl : ( 'EOF' ) ;
    public final void rule__EOF__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6547:1: ( ( 'EOF' ) )
            // InternalXtextGrammarTestLanguage.g:6548:1: ( 'EOF' )
            {
            // InternalXtextGrammarTestLanguage.g:6548:1: ( 'EOF' )
            // InternalXtextGrammarTestLanguage.g:6549:2: 'EOF'
            {
             before(grammarAccess.getEOFAccess().getEOFKeyword_1()); 
            match(input,40,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEOFAccess().getEOFKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EOF__Group__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group__0"
    // InternalXtextGrammarTestLanguage.g:6559:1: rule__CharacterRange__Group__0 : rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 ;
    public final void rule__CharacterRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6563:1: ( rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6564:2: rule__CharacterRange__Group__0__Impl rule__CharacterRange__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_49);
            rule__CharacterRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group__1();

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
    // $ANTLR end "rule__CharacterRange__Group__0"


    // $ANTLR start "rule__CharacterRange__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6571:1: rule__CharacterRange__Group__0__Impl : ( ruleKeyword ) ;
    public final void rule__CharacterRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6575:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:6576:1: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:6576:1: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:6577:2: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getCharacterRangeAccess().getKeywordParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__0__Impl"


    // $ANTLR start "rule__CharacterRange__Group__1"
    // InternalXtextGrammarTestLanguage.g:6586:1: rule__CharacterRange__Group__1 : rule__CharacterRange__Group__1__Impl ;
    public final void rule__CharacterRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6590:1: ( rule__CharacterRange__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6591:2: rule__CharacterRange__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group__1__Impl();

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
    // $ANTLR end "rule__CharacterRange__Group__1"


    // $ANTLR start "rule__CharacterRange__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6597:1: rule__CharacterRange__Group__1__Impl : ( ( rule__CharacterRange__Group_1__0 )? ) ;
    public final void rule__CharacterRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6601:1: ( ( ( rule__CharacterRange__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:6602:1: ( ( rule__CharacterRange__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:6602:1: ( ( rule__CharacterRange__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:6603:2: ( rule__CharacterRange__Group_1__0 )?
            {
             before(grammarAccess.getCharacterRangeAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:6604:2: ( rule__CharacterRange__Group_1__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==41) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:6604:3: rule__CharacterRange__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__CharacterRange__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCharacterRangeAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:6613:1: rule__CharacterRange__Group_1__0 : rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 ;
    public final void rule__CharacterRange__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6617:1: ( rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:6618:2: rule__CharacterRange__Group_1__0__Impl rule__CharacterRange__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_49);
            rule__CharacterRange__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group_1__1();

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
    // $ANTLR end "rule__CharacterRange__Group_1__0"


    // $ANTLR start "rule__CharacterRange__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6625:1: rule__CharacterRange__Group_1__0__Impl : ( () ) ;
    public final void rule__CharacterRange__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6629:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:6630:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:6630:1: ( () )
            // InternalXtextGrammarTestLanguage.g:6631:2: ()
            {
             before(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6632:2: ()
            // InternalXtextGrammarTestLanguage.g:6632:3: 
            {
            }

             after(grammarAccess.getCharacterRangeAccess().getCharacterRangeLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__0__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:6640:1: rule__CharacterRange__Group_1__1 : rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 ;
    public final void rule__CharacterRange__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6644:1: ( rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2 )
            // InternalXtextGrammarTestLanguage.g:6645:2: rule__CharacterRange__Group_1__1__Impl rule__CharacterRange__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__CharacterRange__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group_1__2();

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
    // $ANTLR end "rule__CharacterRange__Group_1__1"


    // $ANTLR start "rule__CharacterRange__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6652:1: rule__CharacterRange__Group_1__1__Impl : ( '..' ) ;
    public final void rule__CharacterRange__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6656:1: ( ( '..' ) )
            // InternalXtextGrammarTestLanguage.g:6657:1: ( '..' )
            {
            // InternalXtextGrammarTestLanguage.g:6657:1: ( '..' )
            // InternalXtextGrammarTestLanguage.g:6658:2: '..'
            {
             before(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 
            match(input,41,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getCharacterRangeAccess().getFullStopFullStopKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__1__Impl"


    // $ANTLR start "rule__CharacterRange__Group_1__2"
    // InternalXtextGrammarTestLanguage.g:6667:1: rule__CharacterRange__Group_1__2 : rule__CharacterRange__Group_1__2__Impl ;
    public final void rule__CharacterRange__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6671:1: ( rule__CharacterRange__Group_1__2__Impl )
            // InternalXtextGrammarTestLanguage.g:6672:2: rule__CharacterRange__Group_1__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__Group_1__2__Impl();

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
    // $ANTLR end "rule__CharacterRange__Group_1__2"


    // $ANTLR start "rule__CharacterRange__Group_1__2__Impl"
    // InternalXtextGrammarTestLanguage.g:6678:1: rule__CharacterRange__Group_1__2__Impl : ( ( rule__CharacterRange__RightAssignment_1_2 ) ) ;
    public final void rule__CharacterRange__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6682:1: ( ( ( rule__CharacterRange__RightAssignment_1_2 ) ) )
            // InternalXtextGrammarTestLanguage.g:6683:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6683:1: ( ( rule__CharacterRange__RightAssignment_1_2 ) )
            // InternalXtextGrammarTestLanguage.g:6684:2: ( rule__CharacterRange__RightAssignment_1_2 )
            {
             before(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 
            // InternalXtextGrammarTestLanguage.g:6685:2: ( rule__CharacterRange__RightAssignment_1_2 )
            // InternalXtextGrammarTestLanguage.g:6685:3: rule__CharacterRange__RightAssignment_1_2
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__CharacterRange__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getCharacterRangeAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__Group_1__2__Impl"


    // $ANTLR start "rule__EnumRule__Group__0"
    // InternalXtextGrammarTestLanguage.g:6694:1: rule__EnumRule__Group__0 : rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 ;
    public final void rule__EnumRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6698:1: ( rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6699:2: rule__EnumRule__Group__0__Impl rule__EnumRule__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__EnumRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__1();

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
    // $ANTLR end "rule__EnumRule__Group__0"


    // $ANTLR start "rule__EnumRule__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6706:1: rule__EnumRule__Group__0__Impl : ( 'enum' ) ;
    public final void rule__EnumRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6710:1: ( ( 'enum' ) )
            // InternalXtextGrammarTestLanguage.g:6711:1: ( 'enum' )
            {
            // InternalXtextGrammarTestLanguage.g:6711:1: ( 'enum' )
            // InternalXtextGrammarTestLanguage.g:6712:2: 'enum'
            {
             before(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 
            match(input,42,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__0__Impl"


    // $ANTLR start "rule__EnumRule__Group__1"
    // InternalXtextGrammarTestLanguage.g:6721:1: rule__EnumRule__Group__1 : rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 ;
    public final void rule__EnumRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6725:1: ( rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2 )
            // InternalXtextGrammarTestLanguage.g:6726:2: rule__EnumRule__Group__1__Impl rule__EnumRule__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_50);
            rule__EnumRule__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__2();

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
    // $ANTLR end "rule__EnumRule__Group__1"


    // $ANTLR start "rule__EnumRule__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6733:1: rule__EnumRule__Group__1__Impl : ( ( rule__EnumRule__NameAssignment_1 ) ) ;
    public final void rule__EnumRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6737:1: ( ( ( rule__EnumRule__NameAssignment_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:6738:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6738:1: ( ( rule__EnumRule__NameAssignment_1 ) )
            // InternalXtextGrammarTestLanguage.g:6739:2: ( rule__EnumRule__NameAssignment_1 )
            {
             before(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 
            // InternalXtextGrammarTestLanguage.g:6740:2: ( rule__EnumRule__NameAssignment_1 )
            // InternalXtextGrammarTestLanguage.g:6740:3: rule__EnumRule__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__1__Impl"


    // $ANTLR start "rule__EnumRule__Group__2"
    // InternalXtextGrammarTestLanguage.g:6748:1: rule__EnumRule__Group__2 : rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 ;
    public final void rule__EnumRule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6752:1: ( rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3 )
            // InternalXtextGrammarTestLanguage.g:6753:2: rule__EnumRule__Group__2__Impl rule__EnumRule__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_50);
            rule__EnumRule__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__3();

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
    // $ANTLR end "rule__EnumRule__Group__2"


    // $ANTLR start "rule__EnumRule__Group__2__Impl"
    // InternalXtextGrammarTestLanguage.g:6760:1: rule__EnumRule__Group__2__Impl : ( ( ruleReturnsClause )? ) ;
    public final void rule__EnumRule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6764:1: ( ( ( ruleReturnsClause )? ) )
            // InternalXtextGrammarTestLanguage.g:6765:1: ( ( ruleReturnsClause )? )
            {
            // InternalXtextGrammarTestLanguage.g:6765:1: ( ( ruleReturnsClause )? )
            // InternalXtextGrammarTestLanguage.g:6766:2: ( ruleReturnsClause )?
            {
             before(grammarAccess.getEnumRuleAccess().getReturnsClauseParserRuleCall_2()); 
            // InternalXtextGrammarTestLanguage.g:6767:2: ( ruleReturnsClause )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==31) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:6767:3: ruleReturnsClause
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleReturnsClause();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumRuleAccess().getReturnsClauseParserRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__2__Impl"


    // $ANTLR start "rule__EnumRule__Group__3"
    // InternalXtextGrammarTestLanguage.g:6775:1: rule__EnumRule__Group__3 : rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 ;
    public final void rule__EnumRule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6779:1: ( rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4 )
            // InternalXtextGrammarTestLanguage.g:6780:2: rule__EnumRule__Group__3__Impl rule__EnumRule__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__EnumRule__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__4();

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
    // $ANTLR end "rule__EnumRule__Group__3"


    // $ANTLR start "rule__EnumRule__Group__3__Impl"
    // InternalXtextGrammarTestLanguage.g:6787:1: rule__EnumRule__Group__3__Impl : ( ':' ) ;
    public final void rule__EnumRule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6791:1: ( ( ':' ) )
            // InternalXtextGrammarTestLanguage.g:6792:1: ( ':' )
            {
            // InternalXtextGrammarTestLanguage.g:6792:1: ( ':' )
            // InternalXtextGrammarTestLanguage.g:6793:2: ':'
            {
             before(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 
            match(input,27,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__3__Impl"


    // $ANTLR start "rule__EnumRule__Group__4"
    // InternalXtextGrammarTestLanguage.g:6802:1: rule__EnumRule__Group__4 : rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 ;
    public final void rule__EnumRule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6806:1: ( rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5 )
            // InternalXtextGrammarTestLanguage.g:6807:2: rule__EnumRule__Group__4__Impl rule__EnumRule__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_17);
            rule__EnumRule__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__5();

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
    // $ANTLR end "rule__EnumRule__Group__4"


    // $ANTLR start "rule__EnumRule__Group__4__Impl"
    // InternalXtextGrammarTestLanguage.g:6814:1: rule__EnumRule__Group__4__Impl : ( ( rule__EnumRule__AlternativesAssignment_4 ) ) ;
    public final void rule__EnumRule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6818:1: ( ( ( rule__EnumRule__AlternativesAssignment_4 ) ) )
            // InternalXtextGrammarTestLanguage.g:6819:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            {
            // InternalXtextGrammarTestLanguage.g:6819:1: ( ( rule__EnumRule__AlternativesAssignment_4 ) )
            // InternalXtextGrammarTestLanguage.g:6820:2: ( rule__EnumRule__AlternativesAssignment_4 )
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 
            // InternalXtextGrammarTestLanguage.g:6821:2: ( rule__EnumRule__AlternativesAssignment_4 )
            // InternalXtextGrammarTestLanguage.g:6821:3: rule__EnumRule__AlternativesAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__AlternativesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEnumRuleAccess().getAlternativesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__4__Impl"


    // $ANTLR start "rule__EnumRule__Group__5"
    // InternalXtextGrammarTestLanguage.g:6829:1: rule__EnumRule__Group__5 : rule__EnumRule__Group__5__Impl ;
    public final void rule__EnumRule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6833:1: ( rule__EnumRule__Group__5__Impl )
            // InternalXtextGrammarTestLanguage.g:6834:2: rule__EnumRule__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumRule__Group__5__Impl();

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
    // $ANTLR end "rule__EnumRule__Group__5"


    // $ANTLR start "rule__EnumRule__Group__5__Impl"
    // InternalXtextGrammarTestLanguage.g:6840:1: rule__EnumRule__Group__5__Impl : ( ';' ) ;
    public final void rule__EnumRule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6844:1: ( ( ';' ) )
            // InternalXtextGrammarTestLanguage.g:6845:1: ( ';' )
            {
            // InternalXtextGrammarTestLanguage.g:6845:1: ( ';' )
            // InternalXtextGrammarTestLanguage.g:6846:2: ';'
            {
             before(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 
            match(input,28,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__Group__5__Impl"


    // $ANTLR start "rule__EnumLiterals__Group__0"
    // InternalXtextGrammarTestLanguage.g:6856:1: rule__EnumLiterals__Group__0 : rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 ;
    public final void rule__EnumLiterals__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6860:1: ( rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1 )
            // InternalXtextGrammarTestLanguage.g:6861:2: rule__EnumLiterals__Group__0__Impl rule__EnumLiterals__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__EnumLiterals__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group__1();

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
    // $ANTLR end "rule__EnumLiterals__Group__0"


    // $ANTLR start "rule__EnumLiterals__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6868:1: rule__EnumLiterals__Group__0__Impl : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6872:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:6873:1: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:6873:1: ( ruleEnumLiteralDeclaration )
            // InternalXtextGrammarTestLanguage.g:6874:2: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getEnumLiteralDeclarationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group__1"
    // InternalXtextGrammarTestLanguage.g:6883:1: rule__EnumLiterals__Group__1 : rule__EnumLiterals__Group__1__Impl ;
    public final void rule__EnumLiterals__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6887:1: ( rule__EnumLiterals__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6888:2: rule__EnumLiterals__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group__1__Impl();

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
    // $ANTLR end "rule__EnumLiterals__Group__1"


    // $ANTLR start "rule__EnumLiterals__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6894:1: rule__EnumLiterals__Group__1__Impl : ( ( rule__EnumLiterals__Group_1__0 )? ) ;
    public final void rule__EnumLiterals__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6898:1: ( ( ( rule__EnumLiterals__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:6899:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:6899:1: ( ( rule__EnumLiterals__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:6900:2: ( rule__EnumLiterals__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:6901:2: ( rule__EnumLiterals__Group_1__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==33) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:6901:3: rule__EnumLiterals__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__EnumLiterals__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:6910:1: rule__EnumLiterals__Group_1__0 : rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 ;
    public final void rule__EnumLiterals__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6914:1: ( rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:6915:2: rule__EnumLiterals__Group_1__0__Impl rule__EnumLiterals__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_24);
            rule__EnumLiterals__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1__1();

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
    // $ANTLR end "rule__EnumLiterals__Group_1__0"


    // $ANTLR start "rule__EnumLiterals__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6922:1: rule__EnumLiterals__Group_1__0__Impl : ( () ) ;
    public final void rule__EnumLiterals__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6926:1: ( ( () ) )
            // InternalXtextGrammarTestLanguage.g:6927:1: ( () )
            {
            // InternalXtextGrammarTestLanguage.g:6927:1: ( () )
            // InternalXtextGrammarTestLanguage.g:6928:2: ()
            {
             before(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 
            // InternalXtextGrammarTestLanguage.g:6929:2: ()
            // InternalXtextGrammarTestLanguage.g:6929:3: 
            {
            }

             after(grammarAccess.getEnumLiteralsAccess().getAlternativesElementsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:6937:1: rule__EnumLiterals__Group_1__1 : rule__EnumLiterals__Group_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6941:1: ( rule__EnumLiterals__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:6942:2: rule__EnumLiterals__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1__1__Impl();

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
    // $ANTLR end "rule__EnumLiterals__Group_1__1"


    // $ANTLR start "rule__EnumLiterals__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:6948:1: rule__EnumLiterals__Group_1__1__Impl : ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) ;
    public final void rule__EnumLiterals__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6952:1: ( ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) ) )
            // InternalXtextGrammarTestLanguage.g:6953:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            {
            // InternalXtextGrammarTestLanguage.g:6953:1: ( ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* ) )
            // InternalXtextGrammarTestLanguage.g:6954:2: ( ( rule__EnumLiterals__Group_1_1__0 ) ) ( ( rule__EnumLiterals__Group_1_1__0 )* )
            {
            // InternalXtextGrammarTestLanguage.g:6954:2: ( ( rule__EnumLiterals__Group_1_1__0 ) )
            // InternalXtextGrammarTestLanguage.g:6955:3: ( rule__EnumLiterals__Group_1_1__0 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:6956:3: ( rule__EnumLiterals__Group_1_1__0 )
            // InternalXtextGrammarTestLanguage.g:6956:4: rule__EnumLiterals__Group_1_1__0
            {
            pushFollow(FollowSets000.FOLLOW_25);
            rule__EnumLiterals__Group_1_1__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

            }

            // InternalXtextGrammarTestLanguage.g:6959:2: ( ( rule__EnumLiterals__Group_1_1__0 )* )
            // InternalXtextGrammarTestLanguage.g:6960:3: ( rule__EnumLiterals__Group_1_1__0 )*
            {
             before(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 
            // InternalXtextGrammarTestLanguage.g:6961:3: ( rule__EnumLiterals__Group_1_1__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==33) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalXtextGrammarTestLanguage.g:6961:4: rule__EnumLiterals__Group_1_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_25);
            	    rule__EnumLiterals__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

             after(grammarAccess.getEnumLiteralsAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__EnumLiterals__Group_1__1__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__0"
    // InternalXtextGrammarTestLanguage.g:6971:1: rule__EnumLiterals__Group_1_1__0 : rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 ;
    public final void rule__EnumLiterals__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6975:1: ( rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1 )
            // InternalXtextGrammarTestLanguage.g:6976:2: rule__EnumLiterals__Group_1_1__0__Impl rule__EnumLiterals__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__EnumLiterals__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1_1__1();

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
    // $ANTLR end "rule__EnumLiterals__Group_1_1__0"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:6983:1: rule__EnumLiterals__Group_1_1__0__Impl : ( '|' ) ;
    public final void rule__EnumLiterals__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:6987:1: ( ( '|' ) )
            // InternalXtextGrammarTestLanguage.g:6988:1: ( '|' )
            {
            // InternalXtextGrammarTestLanguage.g:6988:1: ( '|' )
            // InternalXtextGrammarTestLanguage.g:6989:2: '|'
            {
             before(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 
            match(input,33,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumLiteralsAccess().getVerticalLineKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__0__Impl"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__1"
    // InternalXtextGrammarTestLanguage.g:6998:1: rule__EnumLiterals__Group_1_1__1 : rule__EnumLiterals__Group_1_1__1__Impl ;
    public final void rule__EnumLiterals__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7002:1: ( rule__EnumLiterals__Group_1_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:7003:2: rule__EnumLiterals__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__EnumLiterals__Group_1_1__1"


    // $ANTLR start "rule__EnumLiterals__Group_1_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:7009:1: rule__EnumLiterals__Group_1_1__1__Impl : ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) ;
    public final void rule__EnumLiterals__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7013:1: ( ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:7014:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:7014:1: ( ( rule__EnumLiterals__ElementsAssignment_1_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:7015:2: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 
            // InternalXtextGrammarTestLanguage.g:7016:2: ( rule__EnumLiterals__ElementsAssignment_1_1_1 )
            // InternalXtextGrammarTestLanguage.g:7016:3: rule__EnumLiterals__ElementsAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiterals__ElementsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralsAccess().getElementsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__Group_1_1__1__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__0"
    // InternalXtextGrammarTestLanguage.g:7025:1: rule__EnumLiteralDeclaration__Group__0 : rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 ;
    public final void rule__EnumLiteralDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7029:1: ( rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1 )
            // InternalXtextGrammarTestLanguage.g:7030:2: rule__EnumLiteralDeclaration__Group__0__Impl rule__EnumLiteralDeclaration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_38);
            rule__EnumLiteralDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group__1();

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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__0"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__0__Impl"
    // InternalXtextGrammarTestLanguage.g:7037:1: rule__EnumLiteralDeclaration__Group__0__Impl : ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7041:1: ( ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:7042:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:7042:1: ( ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 ) )
            // InternalXtextGrammarTestLanguage.g:7043:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 
            // InternalXtextGrammarTestLanguage.g:7044:2: ( rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 )
            // InternalXtextGrammarTestLanguage.g:7044:3: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__EnumLiteralAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__0__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__1"
    // InternalXtextGrammarTestLanguage.g:7052:1: rule__EnumLiteralDeclaration__Group__1 : rule__EnumLiteralDeclaration__Group__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7056:1: ( rule__EnumLiteralDeclaration__Group__1__Impl )
            // InternalXtextGrammarTestLanguage.g:7057:2: rule__EnumLiteralDeclaration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group__1__Impl();

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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__1"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group__1__Impl"
    // InternalXtextGrammarTestLanguage.g:7063:1: rule__EnumLiteralDeclaration__Group__1__Impl : ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) ;
    public final void rule__EnumLiteralDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7067:1: ( ( ( rule__EnumLiteralDeclaration__Group_1__0 )? ) )
            // InternalXtextGrammarTestLanguage.g:7068:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            {
            // InternalXtextGrammarTestLanguage.g:7068:1: ( ( rule__EnumLiteralDeclaration__Group_1__0 )? )
            // InternalXtextGrammarTestLanguage.g:7069:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 
            // InternalXtextGrammarTestLanguage.g:7070:2: ( rule__EnumLiteralDeclaration__Group_1__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==14) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalXtextGrammarTestLanguage.g:7070:3: rule__EnumLiteralDeclaration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__EnumLiteralDeclaration__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group__1__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__0"
    // InternalXtextGrammarTestLanguage.g:7079:1: rule__EnumLiteralDeclaration__Group_1__0 : rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 ;
    public final void rule__EnumLiteralDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7083:1: ( rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1 )
            // InternalXtextGrammarTestLanguage.g:7084:2: rule__EnumLiteralDeclaration__Group_1__0__Impl rule__EnumLiteralDeclaration__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_13);
            rule__EnumLiteralDeclaration__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group_1__1();

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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__0"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__0__Impl"
    // InternalXtextGrammarTestLanguage.g:7091:1: rule__EnumLiteralDeclaration__Group_1__0__Impl : ( '=' ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7095:1: ( ( '=' ) )
            // InternalXtextGrammarTestLanguage.g:7096:1: ( '=' )
            {
            // InternalXtextGrammarTestLanguage.g:7096:1: ( '=' )
            // InternalXtextGrammarTestLanguage.g:7097:2: '='
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEqualsSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__0__Impl"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__1"
    // InternalXtextGrammarTestLanguage.g:7106:1: rule__EnumLiteralDeclaration__Group_1__1 : rule__EnumLiteralDeclaration__Group_1__1__Impl ;
    public final void rule__EnumLiteralDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7110:1: ( rule__EnumLiteralDeclaration__Group_1__1__Impl )
            // InternalXtextGrammarTestLanguage.g:7111:2: rule__EnumLiteralDeclaration__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__Group_1__1__Impl();

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
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__1"


    // $ANTLR start "rule__EnumLiteralDeclaration__Group_1__1__Impl"
    // InternalXtextGrammarTestLanguage.g:7117:1: rule__EnumLiteralDeclaration__Group_1__1__Impl : ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) ;
    public final void rule__EnumLiteralDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7121:1: ( ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) ) )
            // InternalXtextGrammarTestLanguage.g:7122:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            {
            // InternalXtextGrammarTestLanguage.g:7122:1: ( ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 ) )
            // InternalXtextGrammarTestLanguage.g:7123:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 
            // InternalXtextGrammarTestLanguage.g:7124:2: ( rule__EnumLiteralDeclaration__LiteralAssignment_1_1 )
            // InternalXtextGrammarTestLanguage.g:7124:3: rule__EnumLiteralDeclaration__LiteralAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumLiteralDeclaration__LiteralAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__Group_1__1__Impl"


    // $ANTLR start "rule__Grammar__NameAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7133:1: rule__Grammar__NameAssignment_1 : ( ruleGrammarID ) ;
    public final void rule__Grammar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7137:1: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:7138:2: ( ruleGrammarID )
            {
            // InternalXtextGrammarTestLanguage.g:7138:2: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:7139:3: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getNameGrammarIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__NameAssignment_1"


    // $ANTLR start "rule__Grammar__UsedGrammarsAssignment_2_1"
    // InternalXtextGrammarTestLanguage.g:7148:1: rule__Grammar__UsedGrammarsAssignment_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7152:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtextGrammarTestLanguage.g:7153:2: ( ( ruleGrammarID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7153:2: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:7154:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7155:3: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:7156:4: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UsedGrammarsAssignment_2_1"


    // $ANTLR start "rule__Grammar__UsedGrammarsAssignment_2_2_1"
    // InternalXtextGrammarTestLanguage.g:7167:1: rule__Grammar__UsedGrammarsAssignment_2_2_1 : ( ( ruleGrammarID ) ) ;
    public final void rule__Grammar__UsedGrammarsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7171:1: ( ( ( ruleGrammarID ) ) )
            // InternalXtextGrammarTestLanguage.g:7172:2: ( ( ruleGrammarID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7172:2: ( ( ruleGrammarID ) )
            // InternalXtextGrammarTestLanguage.g:7173:3: ( ruleGrammarID )
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7174:3: ( ruleGrammarID )
            // InternalXtextGrammarTestLanguage.g:7175:4: ruleGrammarID
            {
             before(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGrammarID();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarGrammarIDParserRuleCall_2_2_1_0_1()); 

            }

             after(grammarAccess.getGrammarAccess().getUsedGrammarsGrammarCrossReference_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__UsedGrammarsAssignment_2_2_1"


    // $ANTLR start "rule__Grammar__MetamodelDeclarationsAssignment_4"
    // InternalXtextGrammarTestLanguage.g:7186:1: rule__Grammar__MetamodelDeclarationsAssignment_4 : ( ruleAbstractMetamodelDeclaration ) ;
    public final void rule__Grammar__MetamodelDeclarationsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7190:1: ( ( ruleAbstractMetamodelDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:7191:2: ( ruleAbstractMetamodelDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:7191:2: ( ruleAbstractMetamodelDeclaration )
            // InternalXtextGrammarTestLanguage.g:7192:3: ruleAbstractMetamodelDeclaration
            {
             before(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractMetamodelDeclaration();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getMetamodelDeclarationsAbstractMetamodelDeclarationParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__MetamodelDeclarationsAssignment_4"


    // $ANTLR start "rule__Grammar__RulesAssignment_5"
    // InternalXtextGrammarTestLanguage.g:7201:1: rule__Grammar__RulesAssignment_5 : ( ruleAbstractRule ) ;
    public final void rule__Grammar__RulesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7205:1: ( ( ruleAbstractRule ) )
            // InternalXtextGrammarTestLanguage.g:7206:2: ( ruleAbstractRule )
            {
            // InternalXtextGrammarTestLanguage.g:7206:2: ( ruleAbstractRule )
            // InternalXtextGrammarTestLanguage.g:7207:3: ruleAbstractRule
            {
             before(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractRule();

            state._fsp--;

             after(grammarAccess.getGrammarAccess().getRulesAbstractRuleParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Grammar__RulesAssignment_5"


    // $ANTLR start "rule__HiddenClause__DefinesHiddenTokensAssignment_0"
    // InternalXtextGrammarTestLanguage.g:7216:1: rule__HiddenClause__DefinesHiddenTokensAssignment_0 : ( ( 'hidden' ) ) ;
    public final void rule__HiddenClause__DefinesHiddenTokensAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7220:1: ( ( ( 'hidden' ) ) )
            // InternalXtextGrammarTestLanguage.g:7221:2: ( ( 'hidden' ) )
            {
            // InternalXtextGrammarTestLanguage.g:7221:2: ( ( 'hidden' ) )
            // InternalXtextGrammarTestLanguage.g:7222:3: ( 'hidden' )
            {
             before(grammarAccess.getHiddenClauseAccess().getDefinesHiddenTokensHiddenKeyword_0_0()); 
            // InternalXtextGrammarTestLanguage.g:7223:3: ( 'hidden' )
            // InternalXtextGrammarTestLanguage.g:7224:4: 'hidden'
            {
             before(grammarAccess.getHiddenClauseAccess().getDefinesHiddenTokensHiddenKeyword_0_0()); 
            match(input,43,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getHiddenClauseAccess().getDefinesHiddenTokensHiddenKeyword_0_0()); 

            }

             after(grammarAccess.getHiddenClauseAccess().getDefinesHiddenTokensHiddenKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__DefinesHiddenTokensAssignment_0"


    // $ANTLR start "rule__HiddenClause__HiddenTokensAssignment_2_0"
    // InternalXtextGrammarTestLanguage.g:7235:1: rule__HiddenClause__HiddenTokensAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__HiddenClause__HiddenTokensAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7239:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7240:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7240:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7241:3: ( RULE_ID )
            {
             before(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:7242:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7243:4: RULE_ID
            {
             before(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_0_0_1()); 

            }

             after(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__HiddenTokensAssignment_2_0"


    // $ANTLR start "rule__HiddenClause__HiddenTokensAssignment_2_1_1"
    // InternalXtextGrammarTestLanguage.g:7254:1: rule__HiddenClause__HiddenTokensAssignment_2_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__HiddenClause__HiddenTokensAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7258:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7259:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7259:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7260:3: ( RULE_ID )
            {
             before(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_1_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7261:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7262:4: RULE_ID
            {
             before(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleIDTerminalRuleCall_2_1_1_0_1()); 

            }

             after(grammarAccess.getHiddenClauseAccess().getHiddenTokensAbstractRuleCrossReference_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HiddenClause__HiddenTokensAssignment_2_1_1"


    // $ANTLR start "rule__GeneratedMetamodel__NameAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7273:1: rule__GeneratedMetamodel__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7277:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7278:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:7278:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7279:3: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__NameAssignment_1"


    // $ANTLR start "rule__GeneratedMetamodel__EPackageAssignment_2"
    // InternalXtextGrammarTestLanguage.g:7288:1: rule__GeneratedMetamodel__EPackageAssignment_2 : ( ( RULE_STRING ) ) ;
    public final void rule__GeneratedMetamodel__EPackageAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7292:1: ( ( ( RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:7293:2: ( ( RULE_STRING ) )
            {
            // InternalXtextGrammarTestLanguage.g:7293:2: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:7294:3: ( RULE_STRING )
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 
            // InternalXtextGrammarTestLanguage.g:7295:3: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:7296:4: RULE_STRING
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getGeneratedMetamodelAccess().getEPackageEPackageCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__EPackageAssignment_2"


    // $ANTLR start "rule__GeneratedMetamodel__AliasAssignment_3_1"
    // InternalXtextGrammarTestLanguage.g:7307:1: rule__GeneratedMetamodel__AliasAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__GeneratedMetamodel__AliasAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7311:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7312:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:7312:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7313:3: RULE_ID
            {
             before(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getGeneratedMetamodelAccess().getAliasIDTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GeneratedMetamodel__AliasAssignment_3_1"


    // $ANTLR start "rule__ReferencedMetamodel__EPackageAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7322:1: rule__ReferencedMetamodel__EPackageAssignment_1 : ( ( RULE_STRING ) ) ;
    public final void rule__ReferencedMetamodel__EPackageAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7326:1: ( ( ( RULE_STRING ) ) )
            // InternalXtextGrammarTestLanguage.g:7327:2: ( ( RULE_STRING ) )
            {
            // InternalXtextGrammarTestLanguage.g:7327:2: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:7328:3: ( RULE_STRING )
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7329:3: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:7330:4: RULE_STRING
            {
             before(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageSTRINGTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getReferencedMetamodelAccess().getEPackageEPackageCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__EPackageAssignment_1"


    // $ANTLR start "rule__ReferencedMetamodel__AliasAssignment_2_1"
    // InternalXtextGrammarTestLanguage.g:7341:1: rule__ReferencedMetamodel__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__ReferencedMetamodel__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7345:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7346:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:7346:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7347:3: RULE_ID
            {
             before(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getReferencedMetamodelAccess().getAliasIDTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferencedMetamodel__AliasAssignment_2_1"


    // $ANTLR start "rule__ParserRule__FragmentAssignment_0_0_0"
    // InternalXtextGrammarTestLanguage.g:7356:1: rule__ParserRule__FragmentAssignment_0_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__ParserRule__FragmentAssignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7360:1: ( ( ( 'fragment' ) ) )
            // InternalXtextGrammarTestLanguage.g:7361:2: ( ( 'fragment' ) )
            {
            // InternalXtextGrammarTestLanguage.g:7361:2: ( ( 'fragment' ) )
            // InternalXtextGrammarTestLanguage.g:7362:3: ( 'fragment' )
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 
            // InternalXtextGrammarTestLanguage.g:7363:3: ( 'fragment' )
            // InternalXtextGrammarTestLanguage.g:7364:4: 'fragment'
            {
             before(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getFragmentFragmentKeyword_0_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__FragmentAssignment_0_0_0"


    // $ANTLR start "rule__ParserRule__WildcardAssignment_0_0_2_0"
    // InternalXtextGrammarTestLanguage.g:7375:1: rule__ParserRule__WildcardAssignment_0_0_2_0 : ( ( '*' ) ) ;
    public final void rule__ParserRule__WildcardAssignment_0_0_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7379:1: ( ( ( '*' ) ) )
            // InternalXtextGrammarTestLanguage.g:7380:2: ( ( '*' ) )
            {
            // InternalXtextGrammarTestLanguage.g:7380:2: ( ( '*' ) )
            // InternalXtextGrammarTestLanguage.g:7381:3: ( '*' )
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 
            // InternalXtextGrammarTestLanguage.g:7382:3: ( '*' )
            // InternalXtextGrammarTestLanguage.g:7383:4: '*'
            {
             before(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 

            }

             after(grammarAccess.getParserRuleAccess().getWildcardAsteriskKeyword_0_0_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__WildcardAssignment_0_0_2_0"


    // $ANTLR start "rule__ParserRule__AlternativesAssignment_3"
    // InternalXtextGrammarTestLanguage.g:7394:1: rule__ParserRule__AlternativesAssignment_3 : ( ruleAlternatives ) ;
    public final void rule__ParserRule__AlternativesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7398:1: ( ( ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:7399:2: ( ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:7399:2: ( ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:7400:3: ruleAlternatives
            {
             before(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getParserRuleAccess().getAlternativesAlternativesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParserRule__AlternativesAssignment_3"


    // $ANTLR start "rule__RuleNameAndParams__NameAssignment_0"
    // InternalXtextGrammarTestLanguage.g:7409:1: rule__RuleNameAndParams__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__RuleNameAndParams__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7413:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7414:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:7414:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7415:3: RULE_ID
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getRuleNameAndParamsAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__NameAssignment_0"


    // $ANTLR start "rule__RuleNameAndParams__ParametersAssignment_1_1_0"
    // InternalXtextGrammarTestLanguage.g:7424:1: rule__RuleNameAndParams__ParametersAssignment_1_1_0 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7428:1: ( ( ruleParameter ) )
            // InternalXtextGrammarTestLanguage.g:7429:2: ( ruleParameter )
            {
            // InternalXtextGrammarTestLanguage.g:7429:2: ( ruleParameter )
            // InternalXtextGrammarTestLanguage.g:7430:3: ruleParameter
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__ParametersAssignment_1_1_0"


    // $ANTLR start "rule__RuleNameAndParams__ParametersAssignment_1_1_1_1"
    // InternalXtextGrammarTestLanguage.g:7439:1: rule__RuleNameAndParams__ParametersAssignment_1_1_1_1 : ( ruleParameter ) ;
    public final void rule__RuleNameAndParams__ParametersAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7443:1: ( ( ruleParameter ) )
            // InternalXtextGrammarTestLanguage.g:7444:2: ( ruleParameter )
            {
            // InternalXtextGrammarTestLanguage.g:7444:2: ( ruleParameter )
            // InternalXtextGrammarTestLanguage.g:7445:3: ruleParameter
            {
             before(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getRuleNameAndParamsAccess().getParametersParameterParserRuleCall_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleNameAndParams__ParametersAssignment_1_1_1_1"


    // $ANTLR start "rule__ReturnsClause__TypeAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7454:1: rule__ReturnsClause__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__ReturnsClause__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7458:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:7459:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:7459:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:7460:3: ruleTypeRef
            {
             before(grammarAccess.getReturnsClauseAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getReturnsClauseAccess().getTypeTypeRefParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReturnsClause__TypeAssignment_1"


    // $ANTLR start "rule__Parameter__NameAssignment"
    // InternalXtextGrammarTestLanguage.g:7469:1: rule__Parameter__NameAssignment : ( RULE_ID ) ;
    public final void rule__Parameter__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7473:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7474:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:7474:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7475:3: RULE_ID
            {
             before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment"


    // $ANTLR start "rule__TypeRef__MetamodelAssignment_0_0"
    // InternalXtextGrammarTestLanguage.g:7484:1: rule__TypeRef__MetamodelAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__MetamodelAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7488:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7489:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7489:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7490:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 
            // InternalXtextGrammarTestLanguage.g:7491:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7492:4: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getMetamodelAbstractMetamodelDeclarationCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__MetamodelAssignment_0_0"


    // $ANTLR start "rule__TypeRef__ClassifierAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7503:1: rule__TypeRef__ClassifierAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__TypeRef__ClassifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7507:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7508:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7508:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7509:3: ( RULE_ID )
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7510:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7511:4: RULE_ID
            {
             before(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTypeRefAccess().getClassifierEClassifierCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeRef__ClassifierAssignment_1"


    // $ANTLR start "rule__Alternatives__ElementsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:7522:1: rule__Alternatives__ElementsAssignment_1_1_1 : ( ruleConditionalBranch ) ;
    public final void rule__Alternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7526:1: ( ( ruleConditionalBranch ) )
            // InternalXtextGrammarTestLanguage.g:7527:2: ( ruleConditionalBranch )
            {
            // InternalXtextGrammarTestLanguage.g:7527:2: ( ruleConditionalBranch )
            // InternalXtextGrammarTestLanguage.g:7528:3: ruleConditionalBranch
            {
             before(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleConditionalBranch();

            state._fsp--;

             after(grammarAccess.getAlternativesAccess().getElementsConditionalBranchParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Alternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__ConditionalBranch__FilteredAssignment_1_2"
    // InternalXtextGrammarTestLanguage.g:7537:1: rule__ConditionalBranch__FilteredAssignment_1_2 : ( ruleInverseLiteralValue ) ;
    public final void rule__ConditionalBranch__FilteredAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7541:1: ( ( ruleInverseLiteralValue ) )
            // InternalXtextGrammarTestLanguage.g:7542:2: ( ruleInverseLiteralValue )
            {
            // InternalXtextGrammarTestLanguage.g:7542:2: ( ruleInverseLiteralValue )
            // InternalXtextGrammarTestLanguage.g:7543:3: ruleInverseLiteralValue
            {
             before(grammarAccess.getConditionalBranchAccess().getFilteredInverseLiteralValueParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleInverseLiteralValue();

            state._fsp--;

             after(grammarAccess.getConditionalBranchAccess().getFilteredInverseLiteralValueParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__FilteredAssignment_1_2"


    // $ANTLR start "rule__ConditionalBranch__ParameterAssignment_1_3"
    // InternalXtextGrammarTestLanguage.g:7552:1: rule__ConditionalBranch__ParameterAssignment_1_3 : ( ( RULE_ID ) ) ;
    public final void rule__ConditionalBranch__ParameterAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7556:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7557:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7557:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7558:3: ( RULE_ID )
            {
             before(grammarAccess.getConditionalBranchAccess().getParameterParameterCrossReference_1_3_0()); 
            // InternalXtextGrammarTestLanguage.g:7559:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7560:4: RULE_ID
            {
             before(grammarAccess.getConditionalBranchAccess().getParameterParameterIDTerminalRuleCall_1_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getConditionalBranchAccess().getParameterParameterIDTerminalRuleCall_1_3_0_1()); 

            }

             after(grammarAccess.getConditionalBranchAccess().getParameterParameterCrossReference_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__ParameterAssignment_1_3"


    // $ANTLR start "rule__ConditionalBranch__GuardedElementAssignment_1_5"
    // InternalXtextGrammarTestLanguage.g:7571:1: rule__ConditionalBranch__GuardedElementAssignment_1_5 : ( ruleUnorderedGroup ) ;
    public final void rule__ConditionalBranch__GuardedElementAssignment_1_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7575:1: ( ( ruleUnorderedGroup ) )
            // InternalXtextGrammarTestLanguage.g:7576:2: ( ruleUnorderedGroup )
            {
            // InternalXtextGrammarTestLanguage.g:7576:2: ( ruleUnorderedGroup )
            // InternalXtextGrammarTestLanguage.g:7577:3: ruleUnorderedGroup
            {
             before(grammarAccess.getConditionalBranchAccess().getGuardedElementUnorderedGroupParserRuleCall_1_5_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleUnorderedGroup();

            state._fsp--;

             after(grammarAccess.getConditionalBranchAccess().getGuardedElementUnorderedGroupParserRuleCall_1_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalBranch__GuardedElementAssignment_1_5"


    // $ANTLR start "rule__UnorderedGroup__ElementsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:7586:1: rule__UnorderedGroup__ElementsAssignment_1_1_1 : ( ruleGroup ) ;
    public final void rule__UnorderedGroup__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7590:1: ( ( ruleGroup ) )
            // InternalXtextGrammarTestLanguage.g:7591:2: ( ruleGroup )
            {
            // InternalXtextGrammarTestLanguage.g:7591:2: ( ruleGroup )
            // InternalXtextGrammarTestLanguage.g:7592:3: ruleGroup
            {
             before(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getUnorderedGroupAccess().getElementsGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnorderedGroup__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__Group__ElementsAssignment_1_1"
    // InternalXtextGrammarTestLanguage.g:7601:1: rule__Group__ElementsAssignment_1_1 : ( ruleAbstractToken ) ;
    public final void rule__Group__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7605:1: ( ( ruleAbstractToken ) )
            // InternalXtextGrammarTestLanguage.g:7606:2: ( ruleAbstractToken )
            {
            // InternalXtextGrammarTestLanguage.g:7606:2: ( ruleAbstractToken )
            // InternalXtextGrammarTestLanguage.g:7607:3: ruleAbstractToken
            {
             before(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAbstractToken();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getElementsAbstractTokenParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__ElementsAssignment_1_1"


    // $ANTLR start "rule__Cardinalities__CardinalityAssignment"
    // InternalXtextGrammarTestLanguage.g:7616:1: rule__Cardinalities__CardinalityAssignment : ( ( rule__Cardinalities__CardinalityAlternatives_0 ) ) ;
    public final void rule__Cardinalities__CardinalityAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7620:1: ( ( ( rule__Cardinalities__CardinalityAlternatives_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:7621:2: ( ( rule__Cardinalities__CardinalityAlternatives_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:7621:2: ( ( rule__Cardinalities__CardinalityAlternatives_0 ) )
            // InternalXtextGrammarTestLanguage.g:7622:3: ( rule__Cardinalities__CardinalityAlternatives_0 )
            {
             before(grammarAccess.getCardinalitiesAccess().getCardinalityAlternatives_0()); 
            // InternalXtextGrammarTestLanguage.g:7623:3: ( rule__Cardinalities__CardinalityAlternatives_0 )
            // InternalXtextGrammarTestLanguage.g:7623:4: rule__Cardinalities__CardinalityAlternatives_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Cardinalities__CardinalityAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getCardinalitiesAccess().getCardinalityAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cardinalities__CardinalityAssignment"


    // $ANTLR start "rule__Action__TypeAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7631:1: rule__Action__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__Action__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7635:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:7636:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:7636:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:7637:3: ruleTypeRef
            {
             before(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getActionAccess().getTypeTypeRefParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__TypeAssignment_1"


    // $ANTLR start "rule__Action__FeatureAssignment_2_1"
    // InternalXtextGrammarTestLanguage.g:7646:1: rule__Action__FeatureAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Action__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7650:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7651:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:7651:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7652:3: RULE_ID
            {
             before(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getActionAccess().getFeatureIDTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__FeatureAssignment_2_1"


    // $ANTLR start "rule__Action__OperatorAssignment_2_2"
    // InternalXtextGrammarTestLanguage.g:7661:1: rule__Action__OperatorAssignment_2_2 : ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) ;
    public final void rule__Action__OperatorAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7665:1: ( ( ( rule__Action__OperatorAlternatives_2_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:7666:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:7666:2: ( ( rule__Action__OperatorAlternatives_2_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:7667:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            {
             before(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 
            // InternalXtextGrammarTestLanguage.g:7668:3: ( rule__Action__OperatorAlternatives_2_2_0 )
            // InternalXtextGrammarTestLanguage.g:7668:4: rule__Action__OperatorAlternatives_2_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Action__OperatorAlternatives_2_2_0();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getOperatorAlternatives_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__OperatorAssignment_2_2"


    // $ANTLR start "rule__Keyword__ValueAssignment"
    // InternalXtextGrammarTestLanguage.g:7676:1: rule__Keyword__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__Keyword__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7680:1: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:7681:2: ( RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:7681:2: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:7682:3: RULE_STRING
            {
             before(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getKeywordAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Keyword__ValueAssignment"


    // $ANTLR start "rule__RuleCall__RuleAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7691:1: rule__RuleCall__RuleAssignment_1 : ( ( ruleRuleID ) ) ;
    public final void rule__RuleCall__RuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7695:1: ( ( ( ruleRuleID ) ) )
            // InternalXtextGrammarTestLanguage.g:7696:2: ( ( ruleRuleID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7696:2: ( ( ruleRuleID ) )
            // InternalXtextGrammarTestLanguage.g:7697:3: ( ruleRuleID )
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7698:3: ( ruleRuleID )
            // InternalXtextGrammarTestLanguage.g:7699:4: ruleRuleID
            {
             before(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__RuleAssignment_1"


    // $ANTLR start "rule__RuleCall__ArgumentsAssignment_2_1"
    // InternalXtextGrammarTestLanguage.g:7710:1: rule__RuleCall__ArgumentsAssignment_2_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7714:1: ( ( ruleNamedArgument ) )
            // InternalXtextGrammarTestLanguage.g:7715:2: ( ruleNamedArgument )
            {
            // InternalXtextGrammarTestLanguage.g:7715:2: ( ruleNamedArgument )
            // InternalXtextGrammarTestLanguage.g:7716:3: ruleNamedArgument
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__ArgumentsAssignment_2_1"


    // $ANTLR start "rule__RuleCall__ArgumentsAssignment_2_2_1"
    // InternalXtextGrammarTestLanguage.g:7725:1: rule__RuleCall__ArgumentsAssignment_2_2_1 : ( ruleNamedArgument ) ;
    public final void rule__RuleCall__ArgumentsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7729:1: ( ( ruleNamedArgument ) )
            // InternalXtextGrammarTestLanguage.g:7730:2: ( ruleNamedArgument )
            {
            // InternalXtextGrammarTestLanguage.g:7730:2: ( ruleNamedArgument )
            // InternalXtextGrammarTestLanguage.g:7731:3: ruleNamedArgument
            {
             before(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNamedArgument();

            state._fsp--;

             after(grammarAccess.getRuleCallAccess().getArgumentsNamedArgumentParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleCall__ArgumentsAssignment_2_2_1"


    // $ANTLR start "rule__NamedArgument__LiteralValueAssignment_1_0_0"
    // InternalXtextGrammarTestLanguage.g:7740:1: rule__NamedArgument__LiteralValueAssignment_1_0_0 : ( ruleLiteralValue ) ;
    public final void rule__NamedArgument__LiteralValueAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7744:1: ( ( ruleLiteralValue ) )
            // InternalXtextGrammarTestLanguage.g:7745:2: ( ruleLiteralValue )
            {
            // InternalXtextGrammarTestLanguage.g:7745:2: ( ruleLiteralValue )
            // InternalXtextGrammarTestLanguage.g:7746:3: ruleLiteralValue
            {
             before(grammarAccess.getNamedArgumentAccess().getLiteralValueLiteralValueParserRuleCall_1_0_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getNamedArgumentAccess().getLiteralValueLiteralValueParserRuleCall_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__LiteralValueAssignment_1_0_0"


    // $ANTLR start "rule__NamedArgument__ParameterAssignment_1_0_1"
    // InternalXtextGrammarTestLanguage.g:7755:1: rule__NamedArgument__ParameterAssignment_1_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__NamedArgument__ParameterAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7759:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7760:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7760:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7761:3: ( RULE_ID )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_1_0_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7762:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7763:4: RULE_ID
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_1_0_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_1_0_1_0_1()); 

            }

             after(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ParameterAssignment_1_0_1"


    // $ANTLR start "rule__NamedArgument__ParameterAssignment_1_1_0"
    // InternalXtextGrammarTestLanguage.g:7774:1: rule__NamedArgument__ParameterAssignment_1_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__NamedArgument__ParameterAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7778:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7779:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7779:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7780:3: ( RULE_ID )
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_1_1_0_0()); 
            // InternalXtextGrammarTestLanguage.g:7781:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7782:4: RULE_ID
            {
             before(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_1_1_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getParameterParameterIDTerminalRuleCall_1_1_0_0_1()); 

            }

             after(grammarAccess.getNamedArgumentAccess().getParameterParameterCrossReference_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ParameterAssignment_1_1_0"


    // $ANTLR start "rule__NamedArgument__ValueAssignment_1_1_2"
    // InternalXtextGrammarTestLanguage.g:7793:1: rule__NamedArgument__ValueAssignment_1_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__NamedArgument__ValueAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7797:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7798:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7798:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7799:3: ( RULE_ID )
            {
             before(grammarAccess.getNamedArgumentAccess().getValueParameterCrossReference_1_1_2_0()); 
            // InternalXtextGrammarTestLanguage.g:7800:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7801:4: RULE_ID
            {
             before(grammarAccess.getNamedArgumentAccess().getValueParameterIDTerminalRuleCall_1_1_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getNamedArgumentAccess().getValueParameterIDTerminalRuleCall_1_1_2_0_1()); 

            }

             after(grammarAccess.getNamedArgumentAccess().getValueParameterCrossReference_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedArgument__ValueAssignment_1_1_2"


    // $ANTLR start "rule__TerminalRuleCall__RuleAssignment"
    // InternalXtextGrammarTestLanguage.g:7812:1: rule__TerminalRuleCall__RuleAssignment : ( ( ruleRuleID ) ) ;
    public final void rule__TerminalRuleCall__RuleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7816:1: ( ( ( ruleRuleID ) ) )
            // InternalXtextGrammarTestLanguage.g:7817:2: ( ( ruleRuleID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7817:2: ( ( ruleRuleID ) )
            // InternalXtextGrammarTestLanguage.g:7818:3: ( ruleRuleID )
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 
            // InternalXtextGrammarTestLanguage.g:7819:3: ( ruleRuleID )
            // InternalXtextGrammarTestLanguage.g:7820:4: ruleRuleID
            {
             before(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleRuleID();

            state._fsp--;

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleRuleIDParserRuleCall_0_1()); 

            }

             after(grammarAccess.getTerminalRuleCallAccess().getRuleAbstractRuleCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRuleCall__RuleAssignment"


    // $ANTLR start "rule__PredicatedKeyword__ValueAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7831:1: rule__PredicatedKeyword__ValueAssignment_1 : ( RULE_STRING ) ;
    public final void rule__PredicatedKeyword__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7835:1: ( ( RULE_STRING ) )
            // InternalXtextGrammarTestLanguage.g:7836:2: ( RULE_STRING )
            {
            // InternalXtextGrammarTestLanguage.g:7836:2: ( RULE_STRING )
            // InternalXtextGrammarTestLanguage.g:7837:3: RULE_STRING
            {
             before(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedKeywordAccess().getValueSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedKeyword__ValueAssignment_1"


    // $ANTLR start "rule__PredicatedRuleCall__RuleAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7846:1: rule__PredicatedRuleCall__RuleAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PredicatedRuleCall__RuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7850:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:7851:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:7851:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7852:3: ( RULE_ID )
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7853:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7854:4: RULE_ID
            {
             before(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPredicatedRuleCallAccess().getRuleAbstractRuleCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedRuleCall__RuleAssignment_1"


    // $ANTLR start "rule__Assignment__FeatureAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7865:1: rule__Assignment__FeatureAssignment_1 : ( RULE_ID ) ;
    public final void rule__Assignment__FeatureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7869:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:7870:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:7870:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:7871:3: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getFeatureIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__FeatureAssignment_1"


    // $ANTLR start "rule__Assignment__OperatorAssignment_2"
    // InternalXtextGrammarTestLanguage.g:7880:1: rule__Assignment__OperatorAssignment_2 : ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) ;
    public final void rule__Assignment__OperatorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7884:1: ( ( ( rule__Assignment__OperatorAlternatives_2_0 ) ) )
            // InternalXtextGrammarTestLanguage.g:7885:2: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            {
            // InternalXtextGrammarTestLanguage.g:7885:2: ( ( rule__Assignment__OperatorAlternatives_2_0 ) )
            // InternalXtextGrammarTestLanguage.g:7886:3: ( rule__Assignment__OperatorAlternatives_2_0 )
            {
             before(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); 
            // InternalXtextGrammarTestLanguage.g:7887:3: ( rule__Assignment__OperatorAlternatives_2_0 )
            // InternalXtextGrammarTestLanguage.g:7887:4: rule__Assignment__OperatorAlternatives_2_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Assignment__OperatorAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getOperatorAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__OperatorAssignment_2"


    // $ANTLR start "rule__Assignment__TerminalAssignment_3"
    // InternalXtextGrammarTestLanguage.g:7895:1: rule__Assignment__TerminalAssignment_3 : ( ruleAssignableTerminal ) ;
    public final void rule__Assignment__TerminalAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7899:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:7900:2: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:7900:2: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:7901:3: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getTerminalAssignableTerminalParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__TerminalAssignment_3"


    // $ANTLR start "rule__Predicate__PredicatedAssignment_0"
    // InternalXtextGrammarTestLanguage.g:7910:1: rule__Predicate__PredicatedAssignment_0 : ( ( '=>' ) ) ;
    public final void rule__Predicate__PredicatedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7914:1: ( ( ( '=>' ) ) )
            // InternalXtextGrammarTestLanguage.g:7915:2: ( ( '=>' ) )
            {
            // InternalXtextGrammarTestLanguage.g:7915:2: ( ( '=>' ) )
            // InternalXtextGrammarTestLanguage.g:7916:3: ( '=>' )
            {
             before(grammarAccess.getPredicateAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0()); 
            // InternalXtextGrammarTestLanguage.g:7917:3: ( '=>' )
            // InternalXtextGrammarTestLanguage.g:7918:4: '=>'
            {
             before(grammarAccess.getPredicateAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0()); 
            match(input,45,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicateAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0()); 

            }

             after(grammarAccess.getPredicateAccess().getPredicatedEqualsSignGreaterThanSignKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__PredicatedAssignment_0"


    // $ANTLR start "rule__Predicate__FirstSetPredicatedAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7929:1: rule__Predicate__FirstSetPredicatedAssignment_1 : ( ( '->' ) ) ;
    public final void rule__Predicate__FirstSetPredicatedAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7933:1: ( ( ( '->' ) ) )
            // InternalXtextGrammarTestLanguage.g:7934:2: ( ( '->' ) )
            {
            // InternalXtextGrammarTestLanguage.g:7934:2: ( ( '->' ) )
            // InternalXtextGrammarTestLanguage.g:7935:3: ( '->' )
            {
             before(grammarAccess.getPredicateAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0()); 
            // InternalXtextGrammarTestLanguage.g:7936:3: ( '->' )
            // InternalXtextGrammarTestLanguage.g:7937:4: '->'
            {
             before(grammarAccess.getPredicateAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0()); 
            match(input,39,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getPredicateAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0()); 

            }

             after(grammarAccess.getPredicateAccess().getFirstSetPredicatedHyphenMinusGreaterThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Predicate__FirstSetPredicatedAssignment_1"


    // $ANTLR start "rule__AssignableAlternatives__ElementsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:7948:1: rule__AssignableAlternatives__ElementsAssignment_1_1_1 : ( ruleAssignableTerminal ) ;
    public final void rule__AssignableAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7952:1: ( ( ruleAssignableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:7953:2: ( ruleAssignableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:7953:2: ( ruleAssignableTerminal )
            // InternalXtextGrammarTestLanguage.g:7954:3: ruleAssignableTerminal
            {
             before(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAssignableTerminal();

            state._fsp--;

             after(grammarAccess.getAssignableAlternativesAccess().getElementsAssignableTerminalParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignableAlternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__CrossReference__TypeAssignment_1"
    // InternalXtextGrammarTestLanguage.g:7963:1: rule__CrossReference__TypeAssignment_1 : ( ruleTypeRef ) ;
    public final void rule__CrossReference__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7967:1: ( ( ruleTypeRef ) )
            // InternalXtextGrammarTestLanguage.g:7968:2: ( ruleTypeRef )
            {
            // InternalXtextGrammarTestLanguage.g:7968:2: ( ruleTypeRef )
            // InternalXtextGrammarTestLanguage.g:7969:3: ruleTypeRef
            {
             before(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeRef();

            state._fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTypeTypeRefParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__TypeAssignment_1"


    // $ANTLR start "rule__CrossReference__TerminalAssignment_2_1"
    // InternalXtextGrammarTestLanguage.g:7978:1: rule__CrossReference__TerminalAssignment_2_1 : ( ruleCrossReferenceableTerminal ) ;
    public final void rule__CrossReference__TerminalAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7982:1: ( ( ruleCrossReferenceableTerminal ) )
            // InternalXtextGrammarTestLanguage.g:7983:2: ( ruleCrossReferenceableTerminal )
            {
            // InternalXtextGrammarTestLanguage.g:7983:2: ( ruleCrossReferenceableTerminal )
            // InternalXtextGrammarTestLanguage.g:7984:3: ruleCrossReferenceableTerminal
            {
             before(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleCrossReferenceableTerminal();

            state._fsp--;

             after(grammarAccess.getCrossReferenceAccess().getTerminalCrossReferenceableTerminalParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossReference__TerminalAssignment_2_1"


    // $ANTLR start "rule__PredicatedGroup__ElementsAssignment_2"
    // InternalXtextGrammarTestLanguage.g:7993:1: rule__PredicatedGroup__ElementsAssignment_2 : ( ruleAlternatives ) ;
    public final void rule__PredicatedGroup__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:7997:1: ( ( ruleAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:7998:2: ( ruleAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:7998:2: ( ruleAlternatives )
            // InternalXtextGrammarTestLanguage.g:7999:3: ruleAlternatives
            {
             before(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleAlternatives();

            state._fsp--;

             after(grammarAccess.getPredicatedGroupAccess().getElementsAlternativesParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PredicatedGroup__ElementsAssignment_2"


    // $ANTLR start "rule__TerminalRule__FragmentAssignment_1_0_0"
    // InternalXtextGrammarTestLanguage.g:8008:1: rule__TerminalRule__FragmentAssignment_1_0_0 : ( ( 'fragment' ) ) ;
    public final void rule__TerminalRule__FragmentAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8012:1: ( ( ( 'fragment' ) ) )
            // InternalXtextGrammarTestLanguage.g:8013:2: ( ( 'fragment' ) )
            {
            // InternalXtextGrammarTestLanguage.g:8013:2: ( ( 'fragment' ) )
            // InternalXtextGrammarTestLanguage.g:8014:3: ( 'fragment' )
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            // InternalXtextGrammarTestLanguage.g:8015:3: ( 'fragment' )
            // InternalXtextGrammarTestLanguage.g:8016:4: 'fragment'
            {
             before(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 
            match(input,44,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }

             after(grammarAccess.getTerminalRuleAccess().getFragmentFragmentKeyword_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__FragmentAssignment_1_0_0"


    // $ANTLR start "rule__TerminalRule__NameAssignment_1_0_1"
    // InternalXtextGrammarTestLanguage.g:8027:1: rule__TerminalRule__NameAssignment_1_0_1 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8031:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:8032:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:8032:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:8033:3: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_1_0_1"


    // $ANTLR start "rule__TerminalRule__NameAssignment_1_1_0"
    // InternalXtextGrammarTestLanguage.g:8042:1: rule__TerminalRule__NameAssignment_1_1_0 : ( RULE_ID ) ;
    public final void rule__TerminalRule__NameAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8046:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:8047:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:8047:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:8048:3: RULE_ID
            {
             before(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_1_0_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTerminalRuleAccess().getNameIDTerminalRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__NameAssignment_1_1_0"


    // $ANTLR start "rule__TerminalRule__AlternativesAssignment_3"
    // InternalXtextGrammarTestLanguage.g:8057:1: rule__TerminalRule__AlternativesAssignment_3 : ( ruleTerminalAlternatives ) ;
    public final void rule__TerminalRule__AlternativesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8061:1: ( ( ruleTerminalAlternatives ) )
            // InternalXtextGrammarTestLanguage.g:8062:2: ( ruleTerminalAlternatives )
            {
            // InternalXtextGrammarTestLanguage.g:8062:2: ( ruleTerminalAlternatives )
            // InternalXtextGrammarTestLanguage.g:8063:3: ruleTerminalAlternatives
            {
             before(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalAlternatives();

            state._fsp--;

             after(grammarAccess.getTerminalRuleAccess().getAlternativesTerminalAlternativesParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalRule__AlternativesAssignment_3"


    // $ANTLR start "rule__TerminalAlternatives__ElementsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:8072:1: rule__TerminalAlternatives__ElementsAssignment_1_1_1 : ( ruleTerminalGroup ) ;
    public final void rule__TerminalAlternatives__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8076:1: ( ( ruleTerminalGroup ) )
            // InternalXtextGrammarTestLanguage.g:8077:2: ( ruleTerminalGroup )
            {
            // InternalXtextGrammarTestLanguage.g:8077:2: ( ruleTerminalGroup )
            // InternalXtextGrammarTestLanguage.g:8078:3: ruleTerminalGroup
            {
             before(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalGroup();

            state._fsp--;

             after(grammarAccess.getTerminalAlternativesAccess().getElementsTerminalGroupParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalAlternatives__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__TerminalGroup__ElementsAssignment_1_1"
    // InternalXtextGrammarTestLanguage.g:8087:1: rule__TerminalGroup__ElementsAssignment_1_1 : ( ruleTerminalToken ) ;
    public final void rule__TerminalGroup__ElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8091:1: ( ( ruleTerminalToken ) )
            // InternalXtextGrammarTestLanguage.g:8092:2: ( ruleTerminalToken )
            {
            // InternalXtextGrammarTestLanguage.g:8092:2: ( ruleTerminalToken )
            // InternalXtextGrammarTestLanguage.g:8093:3: ruleTerminalToken
            {
             before(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalToken();

            state._fsp--;

             after(grammarAccess.getTerminalGroupAccess().getElementsTerminalTokenParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TerminalGroup__ElementsAssignment_1_1"


    // $ANTLR start "rule__NegatedToken__TerminalAssignment_1"
    // InternalXtextGrammarTestLanguage.g:8102:1: rule__NegatedToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__NegatedToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8106:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:8107:2: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:8107:2: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:8108:3: ruleTerminalTokenElement
            {
             before(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getNegatedTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NegatedToken__TerminalAssignment_1"


    // $ANTLR start "rule__UntilToken__TerminalAssignment_1"
    // InternalXtextGrammarTestLanguage.g:8117:1: rule__UntilToken__TerminalAssignment_1 : ( ruleTerminalTokenElement ) ;
    public final void rule__UntilToken__TerminalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8121:1: ( ( ruleTerminalTokenElement ) )
            // InternalXtextGrammarTestLanguage.g:8122:2: ( ruleTerminalTokenElement )
            {
            // InternalXtextGrammarTestLanguage.g:8122:2: ( ruleTerminalTokenElement )
            // InternalXtextGrammarTestLanguage.g:8123:3: ruleTerminalTokenElement
            {
             before(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTerminalTokenElement();

            state._fsp--;

             after(grammarAccess.getUntilTokenAccess().getTerminalTerminalTokenElementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilToken__TerminalAssignment_1"


    // $ANTLR start "rule__CharacterRange__RightAssignment_1_2"
    // InternalXtextGrammarTestLanguage.g:8132:1: rule__CharacterRange__RightAssignment_1_2 : ( ruleKeyword ) ;
    public final void rule__CharacterRange__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8136:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:8137:2: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:8137:2: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:8138:3: ruleKeyword
            {
             before(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getCharacterRangeAccess().getRightKeywordParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharacterRange__RightAssignment_1_2"


    // $ANTLR start "rule__EnumRule__NameAssignment_1"
    // InternalXtextGrammarTestLanguage.g:8147:1: rule__EnumRule__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EnumRule__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8151:1: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:8152:2: ( RULE_ID )
            {
            // InternalXtextGrammarTestLanguage.g:8152:2: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:8153:3: RULE_ID
            {
             before(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumRuleAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__NameAssignment_1"


    // $ANTLR start "rule__EnumRule__AlternativesAssignment_4"
    // InternalXtextGrammarTestLanguage.g:8162:1: rule__EnumRule__AlternativesAssignment_4 : ( ruleEnumLiterals ) ;
    public final void rule__EnumRule__AlternativesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8166:1: ( ( ruleEnumLiterals ) )
            // InternalXtextGrammarTestLanguage.g:8167:2: ( ruleEnumLiterals )
            {
            // InternalXtextGrammarTestLanguage.g:8167:2: ( ruleEnumLiterals )
            // InternalXtextGrammarTestLanguage.g:8168:3: ruleEnumLiterals
            {
             before(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumLiterals();

            state._fsp--;

             after(grammarAccess.getEnumRuleAccess().getAlternativesEnumLiteralsParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumRule__AlternativesAssignment_4"


    // $ANTLR start "rule__EnumLiterals__ElementsAssignment_1_1_1"
    // InternalXtextGrammarTestLanguage.g:8177:1: rule__EnumLiterals__ElementsAssignment_1_1_1 : ( ruleEnumLiteralDeclaration ) ;
    public final void rule__EnumLiterals__ElementsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8181:1: ( ( ruleEnumLiteralDeclaration ) )
            // InternalXtextGrammarTestLanguage.g:8182:2: ( ruleEnumLiteralDeclaration )
            {
            // InternalXtextGrammarTestLanguage.g:8182:2: ( ruleEnumLiteralDeclaration )
            // InternalXtextGrammarTestLanguage.g:8183:3: ruleEnumLiteralDeclaration
            {
             before(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumLiteralDeclaration();

            state._fsp--;

             after(grammarAccess.getEnumLiteralsAccess().getElementsEnumLiteralDeclarationParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiterals__ElementsAssignment_1_1_1"


    // $ANTLR start "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0"
    // InternalXtextGrammarTestLanguage.g:8192:1: rule__EnumLiteralDeclaration__EnumLiteralAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EnumLiteralDeclaration__EnumLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8196:1: ( ( ( RULE_ID ) ) )
            // InternalXtextGrammarTestLanguage.g:8197:2: ( ( RULE_ID ) )
            {
            // InternalXtextGrammarTestLanguage.g:8197:2: ( ( RULE_ID ) )
            // InternalXtextGrammarTestLanguage.g:8198:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 
            // InternalXtextGrammarTestLanguage.g:8199:3: ( RULE_ID )
            // InternalXtextGrammarTestLanguage.g:8200:4: RULE_ID
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEnumLiteralDeclarationAccess().getEnumLiteralEEnumLiteralCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__EnumLiteralAssignment_0"


    // $ANTLR start "rule__EnumLiteralDeclaration__LiteralAssignment_1_1"
    // InternalXtextGrammarTestLanguage.g:8211:1: rule__EnumLiteralDeclaration__LiteralAssignment_1_1 : ( ruleKeyword ) ;
    public final void rule__EnumLiteralDeclaration__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXtextGrammarTestLanguage.g:8215:1: ( ( ruleKeyword ) )
            // InternalXtextGrammarTestLanguage.g:8216:2: ( ruleKeyword )
            {
            // InternalXtextGrammarTestLanguage.g:8216:2: ( ruleKeyword )
            // InternalXtextGrammarTestLanguage.g:8217:3: ruleKeyword
            {
             before(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleKeyword();

            state._fsp--;

             after(grammarAccess.getEnumLiteralDeclarationAccess().getLiteralKeywordParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumLiteralDeclaration__LiteralAssignment_1_1"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00001C4005080010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000005000002L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00001C4005080012L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000080008000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000208820200030L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000100000000010L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080001000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000010L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000208800200030L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000208800200032L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000003800L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000001000800000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000012010L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000208000000010L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000020200030L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000240000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000018000A10030L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000018000A10032L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000088000000L});
    }


}