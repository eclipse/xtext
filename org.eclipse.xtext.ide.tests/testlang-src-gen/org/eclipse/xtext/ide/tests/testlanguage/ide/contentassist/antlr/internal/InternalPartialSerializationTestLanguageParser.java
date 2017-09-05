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
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialSerializationTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPartialSerializationTestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#10'", "'#11'", "'#12'", "'#13'", "'#20'", "'#21'", "'kw1'", "'kw2'", "'import'", "'refs'", "'{'", "'}'", "'ref'", "'.'"
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
    public static final int T__30=30;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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


        public InternalPartialSerializationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPartialSerializationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPartialSerializationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalPartialSerializationTestLanguage.g"; }


    	private PartialSerializationTestLanguageGrammarAccess grammarAccess;

    	public void setGrammarAccess(PartialSerializationTestLanguageGrammarAccess grammarAccess) {
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
    // InternalPartialSerializationTestLanguage.g:57:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:58:1: ( ruleModel EOF )
            // InternalPartialSerializationTestLanguage.g:59:1: ruleModel EOF
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
    // InternalPartialSerializationTestLanguage.g:66:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:70:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalPartialSerializationTestLanguage.g:71:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalPartialSerializationTestLanguage.g:71:2: ( ( rule__Model__Alternatives ) )
            // InternalPartialSerializationTestLanguage.g:72:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalPartialSerializationTestLanguage.g:73:3: ( rule__Model__Alternatives )
            // InternalPartialSerializationTestLanguage.g:73:4: rule__Model__Alternatives
            {
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleMandatoryValue"
    // InternalPartialSerializationTestLanguage.g:82:1: entryRuleMandatoryValue : ruleMandatoryValue EOF ;
    public final void entryRuleMandatoryValue() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:83:1: ( ruleMandatoryValue EOF )
            // InternalPartialSerializationTestLanguage.g:84:1: ruleMandatoryValue EOF
            {
             before(grammarAccess.getMandatoryValueRule()); 
            pushFollow(FOLLOW_1);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getMandatoryValueRule()); 
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
    // $ANTLR end "entryRuleMandatoryValue"


    // $ANTLR start "ruleMandatoryValue"
    // InternalPartialSerializationTestLanguage.g:91:1: ruleMandatoryValue : ( ( rule__MandatoryValue__NameAssignment ) ) ;
    public final void ruleMandatoryValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:95:2: ( ( ( rule__MandatoryValue__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:96:2: ( ( rule__MandatoryValue__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:96:2: ( ( rule__MandatoryValue__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:97:3: ( rule__MandatoryValue__NameAssignment )
            {
             before(grammarAccess.getMandatoryValueAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:98:3: ( rule__MandatoryValue__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:98:4: rule__MandatoryValue__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MandatoryValue__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryValueAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMandatoryValue"


    // $ANTLR start "entryRuleOptionalValue"
    // InternalPartialSerializationTestLanguage.g:107:1: entryRuleOptionalValue : ruleOptionalValue EOF ;
    public final void entryRuleOptionalValue() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:108:1: ( ruleOptionalValue EOF )
            // InternalPartialSerializationTestLanguage.g:109:1: ruleOptionalValue EOF
            {
             before(grammarAccess.getOptionalValueRule()); 
            pushFollow(FOLLOW_1);
            ruleOptionalValue();

            state._fsp--;

             after(grammarAccess.getOptionalValueRule()); 
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
    // $ANTLR end "entryRuleOptionalValue"


    // $ANTLR start "ruleOptionalValue"
    // InternalPartialSerializationTestLanguage.g:116:1: ruleOptionalValue : ( ( rule__OptionalValue__Group__0 ) ) ;
    public final void ruleOptionalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:120:2: ( ( ( rule__OptionalValue__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:121:2: ( ( rule__OptionalValue__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:121:2: ( ( rule__OptionalValue__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:122:3: ( rule__OptionalValue__Group__0 )
            {
             before(grammarAccess.getOptionalValueAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:123:3: ( rule__OptionalValue__Group__0 )
            // InternalPartialSerializationTestLanguage.g:123:4: rule__OptionalValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OptionalValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionalValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptionalValue"


    // $ANTLR start "entryRuleManyOptionalValues"
    // InternalPartialSerializationTestLanguage.g:132:1: entryRuleManyOptionalValues : ruleManyOptionalValues EOF ;
    public final void entryRuleManyOptionalValues() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:133:1: ( ruleManyOptionalValues EOF )
            // InternalPartialSerializationTestLanguage.g:134:1: ruleManyOptionalValues EOF
            {
             before(grammarAccess.getManyOptionalValuesRule()); 
            pushFollow(FOLLOW_1);
            ruleManyOptionalValues();

            state._fsp--;

             after(grammarAccess.getManyOptionalValuesRule()); 
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
    // $ANTLR end "entryRuleManyOptionalValues"


    // $ANTLR start "ruleManyOptionalValues"
    // InternalPartialSerializationTestLanguage.g:141:1: ruleManyOptionalValues : ( ( rule__ManyOptionalValues__Group__0 ) ) ;
    public final void ruleManyOptionalValues() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:145:2: ( ( ( rule__ManyOptionalValues__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:146:2: ( ( rule__ManyOptionalValues__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:146:2: ( ( rule__ManyOptionalValues__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:147:3: ( rule__ManyOptionalValues__Group__0 )
            {
             before(grammarAccess.getManyOptionalValuesAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:148:3: ( rule__ManyOptionalValues__Group__0 )
            // InternalPartialSerializationTestLanguage.g:148:4: rule__ManyOptionalValues__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ManyOptionalValues__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getManyOptionalValuesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleManyOptionalValues"


    // $ANTLR start "entryRuleManyMandatoryValues"
    // InternalPartialSerializationTestLanguage.g:157:1: entryRuleManyMandatoryValues : ruleManyMandatoryValues EOF ;
    public final void entryRuleManyMandatoryValues() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:158:1: ( ruleManyMandatoryValues EOF )
            // InternalPartialSerializationTestLanguage.g:159:1: ruleManyMandatoryValues EOF
            {
             before(grammarAccess.getManyMandatoryValuesRule()); 
            pushFollow(FOLLOW_1);
            ruleManyMandatoryValues();

            state._fsp--;

             after(grammarAccess.getManyMandatoryValuesRule()); 
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
    // $ANTLR end "entryRuleManyMandatoryValues"


    // $ANTLR start "ruleManyMandatoryValues"
    // InternalPartialSerializationTestLanguage.g:166:1: ruleManyMandatoryValues : ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) ) ;
    public final void ruleManyMandatoryValues() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:170:2: ( ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) ) )
            // InternalPartialSerializationTestLanguage.g:171:2: ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:171:2: ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) )
            // InternalPartialSerializationTestLanguage.g:172:3: ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* )
            {
            // InternalPartialSerializationTestLanguage.g:172:3: ( ( rule__ManyMandatoryValues__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:173:4: ( rule__ManyMandatoryValues__NameAssignment )
            {
             before(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:174:4: ( rule__ManyMandatoryValues__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:174:5: rule__ManyMandatoryValues__NameAssignment
            {
            pushFollow(FOLLOW_3);
            rule__ManyMandatoryValues__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment()); 

            }

            // InternalPartialSerializationTestLanguage.g:177:3: ( ( rule__ManyMandatoryValues__NameAssignment )* )
            // InternalPartialSerializationTestLanguage.g:178:4: ( rule__ManyMandatoryValues__NameAssignment )*
            {
             before(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:179:4: ( rule__ManyMandatoryValues__NameAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:179:5: rule__ManyMandatoryValues__NameAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__ManyMandatoryValues__NameAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment()); 

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
    // $ANTLR end "ruleManyMandatoryValues"


    // $ANTLR start "entryRuleMandatoryChild"
    // InternalPartialSerializationTestLanguage.g:189:1: entryRuleMandatoryChild : ruleMandatoryChild EOF ;
    public final void entryRuleMandatoryChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:190:1: ( ruleMandatoryChild EOF )
            // InternalPartialSerializationTestLanguage.g:191:1: ruleMandatoryChild EOF
            {
             before(grammarAccess.getMandatoryChildRule()); 
            pushFollow(FOLLOW_1);
            ruleMandatoryChild();

            state._fsp--;

             after(grammarAccess.getMandatoryChildRule()); 
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
    // $ANTLR end "entryRuleMandatoryChild"


    // $ANTLR start "ruleMandatoryChild"
    // InternalPartialSerializationTestLanguage.g:198:1: ruleMandatoryChild : ( ( rule__MandatoryChild__ChildAssignment ) ) ;
    public final void ruleMandatoryChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:202:2: ( ( ( rule__MandatoryChild__ChildAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:203:2: ( ( rule__MandatoryChild__ChildAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:203:2: ( ( rule__MandatoryChild__ChildAssignment ) )
            // InternalPartialSerializationTestLanguage.g:204:3: ( rule__MandatoryChild__ChildAssignment )
            {
             before(grammarAccess.getMandatoryChildAccess().getChildAssignment()); 
            // InternalPartialSerializationTestLanguage.g:205:3: ( rule__MandatoryChild__ChildAssignment )
            // InternalPartialSerializationTestLanguage.g:205:4: rule__MandatoryChild__ChildAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MandatoryChild__ChildAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryChildAccess().getChildAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMandatoryChild"


    // $ANTLR start "entryRuleOptionalChild"
    // InternalPartialSerializationTestLanguage.g:214:1: entryRuleOptionalChild : ruleOptionalChild EOF ;
    public final void entryRuleOptionalChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:215:1: ( ruleOptionalChild EOF )
            // InternalPartialSerializationTestLanguage.g:216:1: ruleOptionalChild EOF
            {
             before(grammarAccess.getOptionalChildRule()); 
            pushFollow(FOLLOW_1);
            ruleOptionalChild();

            state._fsp--;

             after(grammarAccess.getOptionalChildRule()); 
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
    // $ANTLR end "entryRuleOptionalChild"


    // $ANTLR start "ruleOptionalChild"
    // InternalPartialSerializationTestLanguage.g:223:1: ruleOptionalChild : ( ( rule__OptionalChild__Group__0 ) ) ;
    public final void ruleOptionalChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:227:2: ( ( ( rule__OptionalChild__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:228:2: ( ( rule__OptionalChild__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:228:2: ( ( rule__OptionalChild__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:229:3: ( rule__OptionalChild__Group__0 )
            {
             before(grammarAccess.getOptionalChildAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:230:3: ( rule__OptionalChild__Group__0 )
            // InternalPartialSerializationTestLanguage.g:230:4: rule__OptionalChild__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OptionalChild__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionalChildAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptionalChild"


    // $ANTLR start "entryRuleMandatoryChildList"
    // InternalPartialSerializationTestLanguage.g:239:1: entryRuleMandatoryChildList : ruleMandatoryChildList EOF ;
    public final void entryRuleMandatoryChildList() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:240:1: ( ruleMandatoryChildList EOF )
            // InternalPartialSerializationTestLanguage.g:241:1: ruleMandatoryChildList EOF
            {
             before(grammarAccess.getMandatoryChildListRule()); 
            pushFollow(FOLLOW_1);
            ruleMandatoryChildList();

            state._fsp--;

             after(grammarAccess.getMandatoryChildListRule()); 
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
    // $ANTLR end "entryRuleMandatoryChildList"


    // $ANTLR start "ruleMandatoryChildList"
    // InternalPartialSerializationTestLanguage.g:248:1: ruleMandatoryChildList : ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) ) ;
    public final void ruleMandatoryChildList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:252:2: ( ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) ) )
            // InternalPartialSerializationTestLanguage.g:253:2: ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:253:2: ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) )
            // InternalPartialSerializationTestLanguage.g:254:3: ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* )
            {
            // InternalPartialSerializationTestLanguage.g:254:3: ( ( rule__MandatoryChildList__ChildrenAssignment ) )
            // InternalPartialSerializationTestLanguage.g:255:4: ( rule__MandatoryChildList__ChildrenAssignment )
            {
             before(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 
            // InternalPartialSerializationTestLanguage.g:256:4: ( rule__MandatoryChildList__ChildrenAssignment )
            // InternalPartialSerializationTestLanguage.g:256:5: rule__MandatoryChildList__ChildrenAssignment
            {
            pushFollow(FOLLOW_3);
            rule__MandatoryChildList__ChildrenAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 

            }

            // InternalPartialSerializationTestLanguage.g:259:3: ( ( rule__MandatoryChildList__ChildrenAssignment )* )
            // InternalPartialSerializationTestLanguage.g:260:4: ( rule__MandatoryChildList__ChildrenAssignment )*
            {
             before(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 
            // InternalPartialSerializationTestLanguage.g:261:4: ( rule__MandatoryChildList__ChildrenAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:261:5: rule__MandatoryChildList__ChildrenAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__MandatoryChildList__ChildrenAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 

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
    // $ANTLR end "ruleMandatoryChildList"


    // $ANTLR start "entryRuleOptionalChildList"
    // InternalPartialSerializationTestLanguage.g:271:1: entryRuleOptionalChildList : ruleOptionalChildList EOF ;
    public final void entryRuleOptionalChildList() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:272:1: ( ruleOptionalChildList EOF )
            // InternalPartialSerializationTestLanguage.g:273:1: ruleOptionalChildList EOF
            {
             before(grammarAccess.getOptionalChildListRule()); 
            pushFollow(FOLLOW_1);
            ruleOptionalChildList();

            state._fsp--;

             after(grammarAccess.getOptionalChildListRule()); 
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
    // $ANTLR end "entryRuleOptionalChildList"


    // $ANTLR start "ruleOptionalChildList"
    // InternalPartialSerializationTestLanguage.g:280:1: ruleOptionalChildList : ( ( rule__OptionalChildList__Group__0 ) ) ;
    public final void ruleOptionalChildList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:284:2: ( ( ( rule__OptionalChildList__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:285:2: ( ( rule__OptionalChildList__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:285:2: ( ( rule__OptionalChildList__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:286:3: ( rule__OptionalChildList__Group__0 )
            {
             before(grammarAccess.getOptionalChildListAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:287:3: ( rule__OptionalChildList__Group__0 )
            // InternalPartialSerializationTestLanguage.g:287:4: rule__OptionalChildList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OptionalChildList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionalChildListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptionalChildList"


    // $ANTLR start "entryRuleImport"
    // InternalPartialSerializationTestLanguage.g:296:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:297:1: ( ruleImport EOF )
            // InternalPartialSerializationTestLanguage.g:298:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalPartialSerializationTestLanguage.g:305:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:309:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:310:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:310:2: ( ( rule__Import__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:311:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:312:3: ( rule__Import__Group__0 )
            // InternalPartialSerializationTestLanguage.g:312:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleNode"
    // InternalPartialSerializationTestLanguage.g:321:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:322:1: ( ruleNode EOF )
            // InternalPartialSerializationTestLanguage.g:323:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalPartialSerializationTestLanguage.g:330:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:334:2: ( ( ( rule__Node__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:335:2: ( ( rule__Node__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:335:2: ( ( rule__Node__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:336:3: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:337:3: ( rule__Node__Group__0 )
            // InternalPartialSerializationTestLanguage.g:337:4: rule__Node__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalPartialSerializationTestLanguage.g:346:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:347:1: ( ruleQualifiedName EOF )
            // InternalPartialSerializationTestLanguage.g:348:1: ruleQualifiedName EOF
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
    // InternalPartialSerializationTestLanguage.g:355:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:359:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:360:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:360:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:361:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:362:3: ( rule__QualifiedName__Group__0 )
            // InternalPartialSerializationTestLanguage.g:362:4: rule__QualifiedName__Group__0
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


    // $ANTLR start "entryRuleEClassDecl"
    // InternalPartialSerializationTestLanguage.g:371:1: entryRuleEClassDecl : ruleEClassDecl EOF ;
    public final void entryRuleEClassDecl() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:372:1: ( ruleEClassDecl EOF )
            // InternalPartialSerializationTestLanguage.g:373:1: ruleEClassDecl EOF
            {
             before(grammarAccess.getEClassDeclRule()); 
            pushFollow(FOLLOW_1);
            ruleEClassDecl();

            state._fsp--;

             after(grammarAccess.getEClassDeclRule()); 
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
    // $ANTLR end "entryRuleEClassDecl"


    // $ANTLR start "ruleEClassDecl"
    // InternalPartialSerializationTestLanguage.g:380:1: ruleEClassDecl : ( ( rule__EClassDecl__NameAssignment ) ) ;
    public final void ruleEClassDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:384:2: ( ( ( rule__EClassDecl__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:385:2: ( ( rule__EClassDecl__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:385:2: ( ( rule__EClassDecl__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:386:3: ( rule__EClassDecl__NameAssignment )
            {
             before(grammarAccess.getEClassDeclAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:387:3: ( rule__EClassDecl__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:387:4: rule__EClassDecl__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__EClassDecl__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEClassDeclAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEClassDecl"


    // $ANTLR start "entryRuleEClassRef"
    // InternalPartialSerializationTestLanguage.g:396:1: entryRuleEClassRef : ruleEClassRef EOF ;
    public final void entryRuleEClassRef() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:397:1: ( ruleEClassRef EOF )
            // InternalPartialSerializationTestLanguage.g:398:1: ruleEClassRef EOF
            {
             before(grammarAccess.getEClassRefRule()); 
            pushFollow(FOLLOW_1);
            ruleEClassRef();

            state._fsp--;

             after(grammarAccess.getEClassRefRule()); 
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
    // $ANTLR end "entryRuleEClassRef"


    // $ANTLR start "ruleEClassRef"
    // InternalPartialSerializationTestLanguage.g:405:1: ruleEClassRef : ( ( rule__EClassRef__RefAssignment ) ) ;
    public final void ruleEClassRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:409:2: ( ( ( rule__EClassRef__RefAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:410:2: ( ( rule__EClassRef__RefAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:410:2: ( ( rule__EClassRef__RefAssignment ) )
            // InternalPartialSerializationTestLanguage.g:411:3: ( rule__EClassRef__RefAssignment )
            {
             before(grammarAccess.getEClassRefAccess().getRefAssignment()); 
            // InternalPartialSerializationTestLanguage.g:412:3: ( rule__EClassRef__RefAssignment )
            // InternalPartialSerializationTestLanguage.g:412:4: rule__EClassRef__RefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__EClassRef__RefAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEClassRefAccess().getRefAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEClassRef"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalPartialSerializationTestLanguage.g:420:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) | ( ( rule__Model__Group_6__0 ) ) | ( ( rule__Model__Group_7__0 ) ) | ( ( rule__Model__Group_8__0 ) ) | ( ( rule__Model__Group_9__0 ) ) | ( ( rule__Model__Group_10__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:424:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) | ( ( rule__Model__Group_6__0 ) ) | ( ( rule__Model__Group_7__0 ) ) | ( ( rule__Model__Group_8__0 ) ) | ( ( rule__Model__Group_9__0 ) ) | ( ( rule__Model__Group_10__0 ) ) )
            int alt3=11;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 13:
                {
                alt3=2;
                }
                break;
            case 14:
                {
                alt3=3;
                }
                break;
            case 15:
                {
                alt3=4;
                }
                break;
            case 16:
                {
                alt3=5;
                }
                break;
            case 17:
                {
                alt3=6;
                }
                break;
            case 18:
                {
                alt3=7;
                }
                break;
            case 19:
                {
                alt3=8;
                }
                break;
            case 20:
                {
                alt3=9;
                }
                break;
            case 21:
                {
                alt3=10;
                }
                break;
            case 22:
                {
                alt3=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:425:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:425:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalPartialSerializationTestLanguage.g:426:3: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // InternalPartialSerializationTestLanguage.g:427:3: ( rule__Model__Group_0__0 )
                    // InternalPartialSerializationTestLanguage.g:427:4: rule__Model__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPartialSerializationTestLanguage.g:431:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:431:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalPartialSerializationTestLanguage.g:432:3: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // InternalPartialSerializationTestLanguage.g:433:3: ( rule__Model__Group_1__0 )
                    // InternalPartialSerializationTestLanguage.g:433:4: rule__Model__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalPartialSerializationTestLanguage.g:437:2: ( ( rule__Model__Group_2__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:437:2: ( ( rule__Model__Group_2__0 ) )
                    // InternalPartialSerializationTestLanguage.g:438:3: ( rule__Model__Group_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // InternalPartialSerializationTestLanguage.g:439:3: ( rule__Model__Group_2__0 )
                    // InternalPartialSerializationTestLanguage.g:439:4: rule__Model__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalPartialSerializationTestLanguage.g:443:2: ( ( rule__Model__Group_3__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:443:2: ( ( rule__Model__Group_3__0 ) )
                    // InternalPartialSerializationTestLanguage.g:444:3: ( rule__Model__Group_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_3()); 
                    // InternalPartialSerializationTestLanguage.g:445:3: ( rule__Model__Group_3__0 )
                    // InternalPartialSerializationTestLanguage.g:445:4: rule__Model__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalPartialSerializationTestLanguage.g:449:2: ( ( rule__Model__Group_4__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:449:2: ( ( rule__Model__Group_4__0 ) )
                    // InternalPartialSerializationTestLanguage.g:450:3: ( rule__Model__Group_4__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_4()); 
                    // InternalPartialSerializationTestLanguage.g:451:3: ( rule__Model__Group_4__0 )
                    // InternalPartialSerializationTestLanguage.g:451:4: rule__Model__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalPartialSerializationTestLanguage.g:455:2: ( ( rule__Model__Group_5__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:455:2: ( ( rule__Model__Group_5__0 ) )
                    // InternalPartialSerializationTestLanguage.g:456:3: ( rule__Model__Group_5__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_5()); 
                    // InternalPartialSerializationTestLanguage.g:457:3: ( rule__Model__Group_5__0 )
                    // InternalPartialSerializationTestLanguage.g:457:4: rule__Model__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalPartialSerializationTestLanguage.g:461:2: ( ( rule__Model__Group_6__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:461:2: ( ( rule__Model__Group_6__0 ) )
                    // InternalPartialSerializationTestLanguage.g:462:3: ( rule__Model__Group_6__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_6()); 
                    // InternalPartialSerializationTestLanguage.g:463:3: ( rule__Model__Group_6__0 )
                    // InternalPartialSerializationTestLanguage.g:463:4: rule__Model__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_6__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalPartialSerializationTestLanguage.g:467:2: ( ( rule__Model__Group_7__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:467:2: ( ( rule__Model__Group_7__0 ) )
                    // InternalPartialSerializationTestLanguage.g:468:3: ( rule__Model__Group_7__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_7()); 
                    // InternalPartialSerializationTestLanguage.g:469:3: ( rule__Model__Group_7__0 )
                    // InternalPartialSerializationTestLanguage.g:469:4: rule__Model__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_7__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalPartialSerializationTestLanguage.g:473:2: ( ( rule__Model__Group_8__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:473:2: ( ( rule__Model__Group_8__0 ) )
                    // InternalPartialSerializationTestLanguage.g:474:3: ( rule__Model__Group_8__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_8()); 
                    // InternalPartialSerializationTestLanguage.g:475:3: ( rule__Model__Group_8__0 )
                    // InternalPartialSerializationTestLanguage.g:475:4: rule__Model__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_8__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalPartialSerializationTestLanguage.g:479:2: ( ( rule__Model__Group_9__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:479:2: ( ( rule__Model__Group_9__0 ) )
                    // InternalPartialSerializationTestLanguage.g:480:3: ( rule__Model__Group_9__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_9()); 
                    // InternalPartialSerializationTestLanguage.g:481:3: ( rule__Model__Group_9__0 )
                    // InternalPartialSerializationTestLanguage.g:481:4: rule__Model__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_9__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalPartialSerializationTestLanguage.g:485:2: ( ( rule__Model__Group_10__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:485:2: ( ( rule__Model__Group_10__0 ) )
                    // InternalPartialSerializationTestLanguage.g:486:3: ( rule__Model__Group_10__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_10()); 
                    // InternalPartialSerializationTestLanguage.g:487:3: ( rule__Model__Group_10__0 )
                    // InternalPartialSerializationTestLanguage.g:487:4: rule__Model__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_10()); 

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


    // $ANTLR start "rule__Node__Alternatives_4"
    // InternalPartialSerializationTestLanguage.g:495:1: rule__Node__Alternatives_4 : ( ( ( rule__Node__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Node__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:499:1: ( ( ( rule__Node__Group_4_0__0 ) ) | ( ';' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:500:2: ( ( rule__Node__Group_4_0__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:500:2: ( ( rule__Node__Group_4_0__0 ) )
                    // InternalPartialSerializationTestLanguage.g:501:3: ( rule__Node__Group_4_0__0 )
                    {
                     before(grammarAccess.getNodeAccess().getGroup_4_0()); 
                    // InternalPartialSerializationTestLanguage.g:502:3: ( rule__Node__Group_4_0__0 )
                    // InternalPartialSerializationTestLanguage.g:502:4: rule__Node__Group_4_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNodeAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalPartialSerializationTestLanguage.g:506:2: ( ';' )
                    {
                    // InternalPartialSerializationTestLanguage.g:506:2: ( ';' )
                    // InternalPartialSerializationTestLanguage.g:507:3: ';'
                    {
                     before(grammarAccess.getNodeAccess().getSemicolonKeyword_4_1()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getNodeAccess().getSemicolonKeyword_4_1()); 

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
    // $ANTLR end "rule__Node__Alternatives_4"


    // $ANTLR start "rule__Model__Group_0__0"
    // InternalPartialSerializationTestLanguage.g:516:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:520:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalPartialSerializationTestLanguage.g:521:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalPartialSerializationTestLanguage.g:528:1: rule__Model__Group_0__0__Impl : ( '#1' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:532:1: ( ( '#1' ) )
            // InternalPartialSerializationTestLanguage.g:533:1: ( '#1' )
            {
            // InternalPartialSerializationTestLanguage.g:533:1: ( '#1' )
            // InternalPartialSerializationTestLanguage.g:534:2: '#1'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_0_0()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_0_0()); 

            }


            }

        }
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
    // InternalPartialSerializationTestLanguage.g:543:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:547:1: ( rule__Model__Group_0__1__Impl )
            // InternalPartialSerializationTestLanguage.g:548:2: rule__Model__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_0__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalPartialSerializationTestLanguage.g:554:1: rule__Model__Group_0__1__Impl : ( ruleNode ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:558:1: ( ( ruleNode ) )
            // InternalPartialSerializationTestLanguage.g:559:1: ( ruleNode )
            {
            // InternalPartialSerializationTestLanguage.g:559:1: ( ruleNode )
            // InternalPartialSerializationTestLanguage.g:560:2: ruleNode
            {
             before(grammarAccess.getModelAccess().getNodeParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getModelAccess().getNodeParserRuleCall_0_1()); 

            }


            }

        }
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
    // InternalPartialSerializationTestLanguage.g:570:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:574:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalPartialSerializationTestLanguage.g:575:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
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
    // InternalPartialSerializationTestLanguage.g:582:1: rule__Model__Group_1__0__Impl : ( '#2' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:586:1: ( ( '#2' ) )
            // InternalPartialSerializationTestLanguage.g:587:1: ( '#2' )
            {
            // InternalPartialSerializationTestLanguage.g:587:1: ( '#2' )
            // InternalPartialSerializationTestLanguage.g:588:2: '#2'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_1_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_1_0()); 

            }


            }

        }
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
    // InternalPartialSerializationTestLanguage.g:597:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:601:1: ( rule__Model__Group_1__1__Impl )
            // InternalPartialSerializationTestLanguage.g:602:2: rule__Model__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
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
    // InternalPartialSerializationTestLanguage.g:608:1: rule__Model__Group_1__1__Impl : ( ruleMandatoryValue ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:612:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:613:1: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:613:1: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:614:2: ruleMandatoryValue
            {
             before(grammarAccess.getModelAccess().getMandatoryValueParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getModelAccess().getMandatoryValueParserRuleCall_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Model__Group_2__0"
    // InternalPartialSerializationTestLanguage.g:624:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:628:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalPartialSerializationTestLanguage.g:629:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
            {
            pushFollow(FOLLOW_6);
            rule__Model__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0"


    // $ANTLR start "rule__Model__Group_2__0__Impl"
    // InternalPartialSerializationTestLanguage.g:636:1: rule__Model__Group_2__0__Impl : ( '#3' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:640:1: ( ( '#3' ) )
            // InternalPartialSerializationTestLanguage.g:641:1: ( '#3' )
            {
            // InternalPartialSerializationTestLanguage.g:641:1: ( '#3' )
            // InternalPartialSerializationTestLanguage.g:642:2: '#3'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_2_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__0__Impl"


    // $ANTLR start "rule__Model__Group_2__1"
    // InternalPartialSerializationTestLanguage.g:651:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:655:1: ( rule__Model__Group_2__1__Impl )
            // InternalPartialSerializationTestLanguage.g:656:2: rule__Model__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1"


    // $ANTLR start "rule__Model__Group_2__1__Impl"
    // InternalPartialSerializationTestLanguage.g:662:1: rule__Model__Group_2__1__Impl : ( ruleOptionalValue ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:666:1: ( ( ruleOptionalValue ) )
            // InternalPartialSerializationTestLanguage.g:667:1: ( ruleOptionalValue )
            {
            // InternalPartialSerializationTestLanguage.g:667:1: ( ruleOptionalValue )
            // InternalPartialSerializationTestLanguage.g:668:2: ruleOptionalValue
            {
             before(grammarAccess.getModelAccess().getOptionalValueParserRuleCall_2_1()); 
            pushFollow(FOLLOW_2);
            ruleOptionalValue();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOptionalValueParserRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_2__1__Impl"


    // $ANTLR start "rule__Model__Group_3__0"
    // InternalPartialSerializationTestLanguage.g:678:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:682:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalPartialSerializationTestLanguage.g:683:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__0"


    // $ANTLR start "rule__Model__Group_3__0__Impl"
    // InternalPartialSerializationTestLanguage.g:690:1: rule__Model__Group_3__0__Impl : ( '#4' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:694:1: ( ( '#4' ) )
            // InternalPartialSerializationTestLanguage.g:695:1: ( '#4' )
            {
            // InternalPartialSerializationTestLanguage.g:695:1: ( '#4' )
            // InternalPartialSerializationTestLanguage.g:696:2: '#4'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_3_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__0__Impl"


    // $ANTLR start "rule__Model__Group_3__1"
    // InternalPartialSerializationTestLanguage.g:705:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:709:1: ( rule__Model__Group_3__1__Impl )
            // InternalPartialSerializationTestLanguage.g:710:2: rule__Model__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__1"


    // $ANTLR start "rule__Model__Group_3__1__Impl"
    // InternalPartialSerializationTestLanguage.g:716:1: rule__Model__Group_3__1__Impl : ( ruleMandatoryChild ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:720:1: ( ( ruleMandatoryChild ) )
            // InternalPartialSerializationTestLanguage.g:721:1: ( ruleMandatoryChild )
            {
            // InternalPartialSerializationTestLanguage.g:721:1: ( ruleMandatoryChild )
            // InternalPartialSerializationTestLanguage.g:722:2: ruleMandatoryChild
            {
             before(grammarAccess.getModelAccess().getMandatoryChildParserRuleCall_3_1()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryChild();

            state._fsp--;

             after(grammarAccess.getModelAccess().getMandatoryChildParserRuleCall_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_3__1__Impl"


    // $ANTLR start "rule__Model__Group_4__0"
    // InternalPartialSerializationTestLanguage.g:732:1: rule__Model__Group_4__0 : rule__Model__Group_4__0__Impl rule__Model__Group_4__1 ;
    public final void rule__Model__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:736:1: ( rule__Model__Group_4__0__Impl rule__Model__Group_4__1 )
            // InternalPartialSerializationTestLanguage.g:737:2: rule__Model__Group_4__0__Impl rule__Model__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__0"


    // $ANTLR start "rule__Model__Group_4__0__Impl"
    // InternalPartialSerializationTestLanguage.g:744:1: rule__Model__Group_4__0__Impl : ( '#5' ) ;
    public final void rule__Model__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:748:1: ( ( '#5' ) )
            // InternalPartialSerializationTestLanguage.g:749:1: ( '#5' )
            {
            // InternalPartialSerializationTestLanguage.g:749:1: ( '#5' )
            // InternalPartialSerializationTestLanguage.g:750:2: '#5'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitFiveKeyword_4_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitFiveKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__0__Impl"


    // $ANTLR start "rule__Model__Group_4__1"
    // InternalPartialSerializationTestLanguage.g:759:1: rule__Model__Group_4__1 : rule__Model__Group_4__1__Impl ;
    public final void rule__Model__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:763:1: ( rule__Model__Group_4__1__Impl )
            // InternalPartialSerializationTestLanguage.g:764:2: rule__Model__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__1"


    // $ANTLR start "rule__Model__Group_4__1__Impl"
    // InternalPartialSerializationTestLanguage.g:770:1: rule__Model__Group_4__1__Impl : ( ruleOptionalChild ) ;
    public final void rule__Model__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:774:1: ( ( ruleOptionalChild ) )
            // InternalPartialSerializationTestLanguage.g:775:1: ( ruleOptionalChild )
            {
            // InternalPartialSerializationTestLanguage.g:775:1: ( ruleOptionalChild )
            // InternalPartialSerializationTestLanguage.g:776:2: ruleOptionalChild
            {
             before(grammarAccess.getModelAccess().getOptionalChildParserRuleCall_4_1()); 
            pushFollow(FOLLOW_2);
            ruleOptionalChild();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOptionalChildParserRuleCall_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_4__1__Impl"


    // $ANTLR start "rule__Model__Group_5__0"
    // InternalPartialSerializationTestLanguage.g:786:1: rule__Model__Group_5__0 : rule__Model__Group_5__0__Impl rule__Model__Group_5__1 ;
    public final void rule__Model__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:790:1: ( rule__Model__Group_5__0__Impl rule__Model__Group_5__1 )
            // InternalPartialSerializationTestLanguage.g:791:2: rule__Model__Group_5__0__Impl rule__Model__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_5__0"


    // $ANTLR start "rule__Model__Group_5__0__Impl"
    // InternalPartialSerializationTestLanguage.g:798:1: rule__Model__Group_5__0__Impl : ( '#10' ) ;
    public final void rule__Model__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:802:1: ( ( '#10' ) )
            // InternalPartialSerializationTestLanguage.g:803:1: ( '#10' )
            {
            // InternalPartialSerializationTestLanguage.g:803:1: ( '#10' )
            // InternalPartialSerializationTestLanguage.g:804:2: '#10'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitOneDigitZeroKeyword_5_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitOneDigitZeroKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_5__0__Impl"


    // $ANTLR start "rule__Model__Group_5__1"
    // InternalPartialSerializationTestLanguage.g:813:1: rule__Model__Group_5__1 : rule__Model__Group_5__1__Impl ;
    public final void rule__Model__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:817:1: ( rule__Model__Group_5__1__Impl )
            // InternalPartialSerializationTestLanguage.g:818:2: rule__Model__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_5__1"


    // $ANTLR start "rule__Model__Group_5__1__Impl"
    // InternalPartialSerializationTestLanguage.g:824:1: rule__Model__Group_5__1__Impl : ( ruleManyOptionalValues ) ;
    public final void rule__Model__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:828:1: ( ( ruleManyOptionalValues ) )
            // InternalPartialSerializationTestLanguage.g:829:1: ( ruleManyOptionalValues )
            {
            // InternalPartialSerializationTestLanguage.g:829:1: ( ruleManyOptionalValues )
            // InternalPartialSerializationTestLanguage.g:830:2: ruleManyOptionalValues
            {
             before(grammarAccess.getModelAccess().getManyOptionalValuesParserRuleCall_5_1()); 
            pushFollow(FOLLOW_2);
            ruleManyOptionalValues();

            state._fsp--;

             after(grammarAccess.getModelAccess().getManyOptionalValuesParserRuleCall_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_5__1__Impl"


    // $ANTLR start "rule__Model__Group_6__0"
    // InternalPartialSerializationTestLanguage.g:840:1: rule__Model__Group_6__0 : rule__Model__Group_6__0__Impl rule__Model__Group_6__1 ;
    public final void rule__Model__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:844:1: ( rule__Model__Group_6__0__Impl rule__Model__Group_6__1 )
            // InternalPartialSerializationTestLanguage.g:845:2: rule__Model__Group_6__0__Impl rule__Model__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__0"


    // $ANTLR start "rule__Model__Group_6__0__Impl"
    // InternalPartialSerializationTestLanguage.g:852:1: rule__Model__Group_6__0__Impl : ( '#11' ) ;
    public final void rule__Model__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:856:1: ( ( '#11' ) )
            // InternalPartialSerializationTestLanguage.g:857:1: ( '#11' )
            {
            // InternalPartialSerializationTestLanguage.g:857:1: ( '#11' )
            // InternalPartialSerializationTestLanguage.g:858:2: '#11'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitOneDigitOneKeyword_6_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitOneDigitOneKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__0__Impl"


    // $ANTLR start "rule__Model__Group_6__1"
    // InternalPartialSerializationTestLanguage.g:867:1: rule__Model__Group_6__1 : rule__Model__Group_6__1__Impl ;
    public final void rule__Model__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:871:1: ( rule__Model__Group_6__1__Impl )
            // InternalPartialSerializationTestLanguage.g:872:2: rule__Model__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__1"


    // $ANTLR start "rule__Model__Group_6__1__Impl"
    // InternalPartialSerializationTestLanguage.g:878:1: rule__Model__Group_6__1__Impl : ( ruleManyMandatoryValues ) ;
    public final void rule__Model__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:882:1: ( ( ruleManyMandatoryValues ) )
            // InternalPartialSerializationTestLanguage.g:883:1: ( ruleManyMandatoryValues )
            {
            // InternalPartialSerializationTestLanguage.g:883:1: ( ruleManyMandatoryValues )
            // InternalPartialSerializationTestLanguage.g:884:2: ruleManyMandatoryValues
            {
             before(grammarAccess.getModelAccess().getManyMandatoryValuesParserRuleCall_6_1()); 
            pushFollow(FOLLOW_2);
            ruleManyMandatoryValues();

            state._fsp--;

             after(grammarAccess.getModelAccess().getManyMandatoryValuesParserRuleCall_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_6__1__Impl"


    // $ANTLR start "rule__Model__Group_7__0"
    // InternalPartialSerializationTestLanguage.g:894:1: rule__Model__Group_7__0 : rule__Model__Group_7__0__Impl rule__Model__Group_7__1 ;
    public final void rule__Model__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:898:1: ( rule__Model__Group_7__0__Impl rule__Model__Group_7__1 )
            // InternalPartialSerializationTestLanguage.g:899:2: rule__Model__Group_7__0__Impl rule__Model__Group_7__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__0"


    // $ANTLR start "rule__Model__Group_7__0__Impl"
    // InternalPartialSerializationTestLanguage.g:906:1: rule__Model__Group_7__0__Impl : ( '#12' ) ;
    public final void rule__Model__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:910:1: ( ( '#12' ) )
            // InternalPartialSerializationTestLanguage.g:911:1: ( '#12' )
            {
            // InternalPartialSerializationTestLanguage.g:911:1: ( '#12' )
            // InternalPartialSerializationTestLanguage.g:912:2: '#12'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitOneDigitTwoKeyword_7_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitOneDigitTwoKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__0__Impl"


    // $ANTLR start "rule__Model__Group_7__1"
    // InternalPartialSerializationTestLanguage.g:921:1: rule__Model__Group_7__1 : rule__Model__Group_7__1__Impl ;
    public final void rule__Model__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:925:1: ( rule__Model__Group_7__1__Impl )
            // InternalPartialSerializationTestLanguage.g:926:2: rule__Model__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__1"


    // $ANTLR start "rule__Model__Group_7__1__Impl"
    // InternalPartialSerializationTestLanguage.g:932:1: rule__Model__Group_7__1__Impl : ( ruleMandatoryChildList ) ;
    public final void rule__Model__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:936:1: ( ( ruleMandatoryChildList ) )
            // InternalPartialSerializationTestLanguage.g:937:1: ( ruleMandatoryChildList )
            {
            // InternalPartialSerializationTestLanguage.g:937:1: ( ruleMandatoryChildList )
            // InternalPartialSerializationTestLanguage.g:938:2: ruleMandatoryChildList
            {
             before(grammarAccess.getModelAccess().getMandatoryChildListParserRuleCall_7_1()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryChildList();

            state._fsp--;

             after(grammarAccess.getModelAccess().getMandatoryChildListParserRuleCall_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_7__1__Impl"


    // $ANTLR start "rule__Model__Group_8__0"
    // InternalPartialSerializationTestLanguage.g:948:1: rule__Model__Group_8__0 : rule__Model__Group_8__0__Impl rule__Model__Group_8__1 ;
    public final void rule__Model__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:952:1: ( rule__Model__Group_8__0__Impl rule__Model__Group_8__1 )
            // InternalPartialSerializationTestLanguage.g:953:2: rule__Model__Group_8__0__Impl rule__Model__Group_8__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__0"


    // $ANTLR start "rule__Model__Group_8__0__Impl"
    // InternalPartialSerializationTestLanguage.g:960:1: rule__Model__Group_8__0__Impl : ( '#13' ) ;
    public final void rule__Model__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:964:1: ( ( '#13' ) )
            // InternalPartialSerializationTestLanguage.g:965:1: ( '#13' )
            {
            // InternalPartialSerializationTestLanguage.g:965:1: ( '#13' )
            // InternalPartialSerializationTestLanguage.g:966:2: '#13'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitOneDigitThreeKeyword_8_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitOneDigitThreeKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__0__Impl"


    // $ANTLR start "rule__Model__Group_8__1"
    // InternalPartialSerializationTestLanguage.g:975:1: rule__Model__Group_8__1 : rule__Model__Group_8__1__Impl ;
    public final void rule__Model__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:979:1: ( rule__Model__Group_8__1__Impl )
            // InternalPartialSerializationTestLanguage.g:980:2: rule__Model__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__1"


    // $ANTLR start "rule__Model__Group_8__1__Impl"
    // InternalPartialSerializationTestLanguage.g:986:1: rule__Model__Group_8__1__Impl : ( ruleOptionalChildList ) ;
    public final void rule__Model__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:990:1: ( ( ruleOptionalChildList ) )
            // InternalPartialSerializationTestLanguage.g:991:1: ( ruleOptionalChildList )
            {
            // InternalPartialSerializationTestLanguage.g:991:1: ( ruleOptionalChildList )
            // InternalPartialSerializationTestLanguage.g:992:2: ruleOptionalChildList
            {
             before(grammarAccess.getModelAccess().getOptionalChildListParserRuleCall_8_1()); 
            pushFollow(FOLLOW_2);
            ruleOptionalChildList();

            state._fsp--;

             after(grammarAccess.getModelAccess().getOptionalChildListParserRuleCall_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__1__Impl"


    // $ANTLR start "rule__Model__Group_9__0"
    // InternalPartialSerializationTestLanguage.g:1002:1: rule__Model__Group_9__0 : rule__Model__Group_9__0__Impl rule__Model__Group_9__1 ;
    public final void rule__Model__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1006:1: ( rule__Model__Group_9__0__Impl rule__Model__Group_9__1 )
            // InternalPartialSerializationTestLanguage.g:1007:2: rule__Model__Group_9__0__Impl rule__Model__Group_9__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_9__0"


    // $ANTLR start "rule__Model__Group_9__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1014:1: rule__Model__Group_9__0__Impl : ( '#20' ) ;
    public final void rule__Model__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1018:1: ( ( '#20' ) )
            // InternalPartialSerializationTestLanguage.g:1019:1: ( '#20' )
            {
            // InternalPartialSerializationTestLanguage.g:1019:1: ( '#20' )
            // InternalPartialSerializationTestLanguage.g:1020:2: '#20'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitZeroKeyword_9_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitZeroKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_9__0__Impl"


    // $ANTLR start "rule__Model__Group_9__1"
    // InternalPartialSerializationTestLanguage.g:1029:1: rule__Model__Group_9__1 : rule__Model__Group_9__1__Impl ;
    public final void rule__Model__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1033:1: ( rule__Model__Group_9__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1034:2: rule__Model__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_9__1"


    // $ANTLR start "rule__Model__Group_9__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1040:1: rule__Model__Group_9__1__Impl : ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) ) ;
    public final void rule__Model__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1044:1: ( ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) ) )
            // InternalPartialSerializationTestLanguage.g:1045:1: ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:1045:1: ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1046:2: ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1046:2: ( ( rule__Model__ClazzAssignment_9_1 ) )
            // InternalPartialSerializationTestLanguage.g:1047:3: ( rule__Model__ClazzAssignment_9_1 )
            {
             before(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 
            // InternalPartialSerializationTestLanguage.g:1048:3: ( rule__Model__ClazzAssignment_9_1 )
            // InternalPartialSerializationTestLanguage.g:1048:4: rule__Model__ClazzAssignment_9_1
            {
            pushFollow(FOLLOW_3);
            rule__Model__ClazzAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 

            }

            // InternalPartialSerializationTestLanguage.g:1051:2: ( ( rule__Model__ClazzAssignment_9_1 )* )
            // InternalPartialSerializationTestLanguage.g:1052:3: ( rule__Model__ClazzAssignment_9_1 )*
            {
             before(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 
            // InternalPartialSerializationTestLanguage.g:1053:3: ( rule__Model__ClazzAssignment_9_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1053:4: rule__Model__ClazzAssignment_9_1
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ClazzAssignment_9_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 

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
    // $ANTLR end "rule__Model__Group_9__1__Impl"


    // $ANTLR start "rule__Model__Group_10__0"
    // InternalPartialSerializationTestLanguage.g:1063:1: rule__Model__Group_10__0 : rule__Model__Group_10__0__Impl rule__Model__Group_10__1 ;
    public final void rule__Model__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1067:1: ( rule__Model__Group_10__0__Impl rule__Model__Group_10__1 )
            // InternalPartialSerializationTestLanguage.g:1068:2: rule__Model__Group_10__0__Impl rule__Model__Group_10__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__0"


    // $ANTLR start "rule__Model__Group_10__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1075:1: rule__Model__Group_10__0__Impl : ( '#21' ) ;
    public final void rule__Model__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1079:1: ( ( '#21' ) )
            // InternalPartialSerializationTestLanguage.g:1080:1: ( '#21' )
            {
            // InternalPartialSerializationTestLanguage.g:1080:1: ( '#21' )
            // InternalPartialSerializationTestLanguage.g:1081:2: '#21'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitOneKeyword_10_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitOneKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__0__Impl"


    // $ANTLR start "rule__Model__Group_10__1"
    // InternalPartialSerializationTestLanguage.g:1090:1: rule__Model__Group_10__1 : rule__Model__Group_10__1__Impl ;
    public final void rule__Model__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1094:1: ( rule__Model__Group_10__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1095:2: rule__Model__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__1"


    // $ANTLR start "rule__Model__Group_10__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1101:1: rule__Model__Group_10__1__Impl : ( ruleEClassRef ) ;
    public final void rule__Model__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1105:1: ( ( ruleEClassRef ) )
            // InternalPartialSerializationTestLanguage.g:1106:1: ( ruleEClassRef )
            {
            // InternalPartialSerializationTestLanguage.g:1106:1: ( ruleEClassRef )
            // InternalPartialSerializationTestLanguage.g:1107:2: ruleEClassRef
            {
             before(grammarAccess.getModelAccess().getEClassRefParserRuleCall_10_1()); 
            pushFollow(FOLLOW_2);
            ruleEClassRef();

            state._fsp--;

             after(grammarAccess.getModelAccess().getEClassRefParserRuleCall_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_10__1__Impl"


    // $ANTLR start "rule__OptionalValue__Group__0"
    // InternalPartialSerializationTestLanguage.g:1117:1: rule__OptionalValue__Group__0 : rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1 ;
    public final void rule__OptionalValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1121:1: ( rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1122:2: rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__OptionalValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptionalValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__0"


    // $ANTLR start "rule__OptionalValue__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1129:1: rule__OptionalValue__Group__0__Impl : ( () ) ;
    public final void rule__OptionalValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1133:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1134:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1134:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1135:2: ()
            {
             before(grammarAccess.getOptionalValueAccess().getOptionalValueAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1136:2: ()
            // InternalPartialSerializationTestLanguage.g:1136:3: 
            {
            }

             after(grammarAccess.getOptionalValueAccess().getOptionalValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__0__Impl"


    // $ANTLR start "rule__OptionalValue__Group__1"
    // InternalPartialSerializationTestLanguage.g:1144:1: rule__OptionalValue__Group__1 : rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2 ;
    public final void rule__OptionalValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1148:1: ( rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1149:2: rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__OptionalValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptionalValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__1"


    // $ANTLR start "rule__OptionalValue__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1156:1: rule__OptionalValue__Group__1__Impl : ( ( 'kw1' )? ) ;
    public final void rule__OptionalValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1160:1: ( ( ( 'kw1' )? ) )
            // InternalPartialSerializationTestLanguage.g:1161:1: ( ( 'kw1' )? )
            {
            // InternalPartialSerializationTestLanguage.g:1161:1: ( ( 'kw1' )? )
            // InternalPartialSerializationTestLanguage.g:1162:2: ( 'kw1' )?
            {
             before(grammarAccess.getOptionalValueAccess().getKw1Keyword_1()); 
            // InternalPartialSerializationTestLanguage.g:1163:2: ( 'kw1' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1163:3: 'kw1'
                    {
                    match(input,23,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getOptionalValueAccess().getKw1Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__1__Impl"


    // $ANTLR start "rule__OptionalValue__Group__2"
    // InternalPartialSerializationTestLanguage.g:1171:1: rule__OptionalValue__Group__2 : rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3 ;
    public final void rule__OptionalValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1175:1: ( rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3 )
            // InternalPartialSerializationTestLanguage.g:1176:2: rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__OptionalValue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptionalValue__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__2"


    // $ANTLR start "rule__OptionalValue__Group__2__Impl"
    // InternalPartialSerializationTestLanguage.g:1183:1: rule__OptionalValue__Group__2__Impl : ( ( rule__OptionalValue__NameAssignment_2 )? ) ;
    public final void rule__OptionalValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1187:1: ( ( ( rule__OptionalValue__NameAssignment_2 )? ) )
            // InternalPartialSerializationTestLanguage.g:1188:1: ( ( rule__OptionalValue__NameAssignment_2 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1188:1: ( ( rule__OptionalValue__NameAssignment_2 )? )
            // InternalPartialSerializationTestLanguage.g:1189:2: ( rule__OptionalValue__NameAssignment_2 )?
            {
             before(grammarAccess.getOptionalValueAccess().getNameAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:1190:2: ( rule__OptionalValue__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1190:3: rule__OptionalValue__NameAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__OptionalValue__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOptionalValueAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__2__Impl"


    // $ANTLR start "rule__OptionalValue__Group__3"
    // InternalPartialSerializationTestLanguage.g:1198:1: rule__OptionalValue__Group__3 : rule__OptionalValue__Group__3__Impl ;
    public final void rule__OptionalValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1202:1: ( rule__OptionalValue__Group__3__Impl )
            // InternalPartialSerializationTestLanguage.g:1203:2: rule__OptionalValue__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OptionalValue__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__3"


    // $ANTLR start "rule__OptionalValue__Group__3__Impl"
    // InternalPartialSerializationTestLanguage.g:1209:1: rule__OptionalValue__Group__3__Impl : ( ( 'kw2' )? ) ;
    public final void rule__OptionalValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1213:1: ( ( ( 'kw2' )? ) )
            // InternalPartialSerializationTestLanguage.g:1214:1: ( ( 'kw2' )? )
            {
            // InternalPartialSerializationTestLanguage.g:1214:1: ( ( 'kw2' )? )
            // InternalPartialSerializationTestLanguage.g:1215:2: ( 'kw2' )?
            {
             before(grammarAccess.getOptionalValueAccess().getKw2Keyword_3()); 
            // InternalPartialSerializationTestLanguage.g:1216:2: ( 'kw2' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1216:3: 'kw2'
                    {
                    match(input,24,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getOptionalValueAccess().getKw2Keyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__Group__3__Impl"


    // $ANTLR start "rule__ManyOptionalValues__Group__0"
    // InternalPartialSerializationTestLanguage.g:1225:1: rule__ManyOptionalValues__Group__0 : rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1 ;
    public final void rule__ManyOptionalValues__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1229:1: ( rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1230:2: rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ManyOptionalValues__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ManyOptionalValues__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ManyOptionalValues__Group__0"


    // $ANTLR start "rule__ManyOptionalValues__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1237:1: rule__ManyOptionalValues__Group__0__Impl : ( () ) ;
    public final void rule__ManyOptionalValues__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1241:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1242:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1242:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1243:2: ()
            {
             before(grammarAccess.getManyOptionalValuesAccess().getManyValuesAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1244:2: ()
            // InternalPartialSerializationTestLanguage.g:1244:3: 
            {
            }

             after(grammarAccess.getManyOptionalValuesAccess().getManyValuesAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ManyOptionalValues__Group__0__Impl"


    // $ANTLR start "rule__ManyOptionalValues__Group__1"
    // InternalPartialSerializationTestLanguage.g:1252:1: rule__ManyOptionalValues__Group__1 : rule__ManyOptionalValues__Group__1__Impl ;
    public final void rule__ManyOptionalValues__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1256:1: ( rule__ManyOptionalValues__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1257:2: rule__ManyOptionalValues__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ManyOptionalValues__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ManyOptionalValues__Group__1"


    // $ANTLR start "rule__ManyOptionalValues__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1263:1: rule__ManyOptionalValues__Group__1__Impl : ( ( rule__ManyOptionalValues__NameAssignment_1 )* ) ;
    public final void rule__ManyOptionalValues__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1267:1: ( ( ( rule__ManyOptionalValues__NameAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1268:1: ( ( rule__ManyOptionalValues__NameAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1268:1: ( ( rule__ManyOptionalValues__NameAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:1269:2: ( rule__ManyOptionalValues__NameAssignment_1 )*
            {
             before(grammarAccess.getManyOptionalValuesAccess().getNameAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1270:2: ( rule__ManyOptionalValues__NameAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1270:3: rule__ManyOptionalValues__NameAssignment_1
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__ManyOptionalValues__NameAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getManyOptionalValuesAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ManyOptionalValues__Group__1__Impl"


    // $ANTLR start "rule__OptionalChild__Group__0"
    // InternalPartialSerializationTestLanguage.g:1279:1: rule__OptionalChild__Group__0 : rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1 ;
    public final void rule__OptionalChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1283:1: ( rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1284:2: rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__OptionalChild__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptionalChild__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChild__Group__0"


    // $ANTLR start "rule__OptionalChild__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1291:1: rule__OptionalChild__Group__0__Impl : ( () ) ;
    public final void rule__OptionalChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1295:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1296:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1296:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1297:2: ()
            {
             before(grammarAccess.getOptionalChildAccess().getOptionalChildAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1298:2: ()
            // InternalPartialSerializationTestLanguage.g:1298:3: 
            {
            }

             after(grammarAccess.getOptionalChildAccess().getOptionalChildAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChild__Group__0__Impl"


    // $ANTLR start "rule__OptionalChild__Group__1"
    // InternalPartialSerializationTestLanguage.g:1306:1: rule__OptionalChild__Group__1 : rule__OptionalChild__Group__1__Impl ;
    public final void rule__OptionalChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1310:1: ( rule__OptionalChild__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1311:2: rule__OptionalChild__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OptionalChild__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChild__Group__1"


    // $ANTLR start "rule__OptionalChild__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1317:1: rule__OptionalChild__Group__1__Impl : ( ( rule__OptionalChild__ChildAssignment_1 )? ) ;
    public final void rule__OptionalChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1321:1: ( ( ( rule__OptionalChild__ChildAssignment_1 )? ) )
            // InternalPartialSerializationTestLanguage.g:1322:1: ( ( rule__OptionalChild__ChildAssignment_1 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1322:1: ( ( rule__OptionalChild__ChildAssignment_1 )? )
            // InternalPartialSerializationTestLanguage.g:1323:2: ( rule__OptionalChild__ChildAssignment_1 )?
            {
             before(grammarAccess.getOptionalChildAccess().getChildAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1324:2: ( rule__OptionalChild__ChildAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1324:3: rule__OptionalChild__ChildAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__OptionalChild__ChildAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOptionalChildAccess().getChildAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChild__Group__1__Impl"


    // $ANTLR start "rule__OptionalChildList__Group__0"
    // InternalPartialSerializationTestLanguage.g:1333:1: rule__OptionalChildList__Group__0 : rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1 ;
    public final void rule__OptionalChildList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1337:1: ( rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1338:2: rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__OptionalChildList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OptionalChildList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChildList__Group__0"


    // $ANTLR start "rule__OptionalChildList__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1345:1: rule__OptionalChildList__Group__0__Impl : ( () ) ;
    public final void rule__OptionalChildList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1349:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1350:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1350:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1351:2: ()
            {
             before(grammarAccess.getOptionalChildListAccess().getOptionalChildListAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1352:2: ()
            // InternalPartialSerializationTestLanguage.g:1352:3: 
            {
            }

             after(grammarAccess.getOptionalChildListAccess().getOptionalChildListAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChildList__Group__0__Impl"


    // $ANTLR start "rule__OptionalChildList__Group__1"
    // InternalPartialSerializationTestLanguage.g:1360:1: rule__OptionalChildList__Group__1 : rule__OptionalChildList__Group__1__Impl ;
    public final void rule__OptionalChildList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1364:1: ( rule__OptionalChildList__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1365:2: rule__OptionalChildList__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OptionalChildList__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChildList__Group__1"


    // $ANTLR start "rule__OptionalChildList__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1371:1: rule__OptionalChildList__Group__1__Impl : ( ( rule__OptionalChildList__ChildrenAssignment_1 )* ) ;
    public final void rule__OptionalChildList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1375:1: ( ( ( rule__OptionalChildList__ChildrenAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1376:1: ( ( rule__OptionalChildList__ChildrenAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1376:1: ( ( rule__OptionalChildList__ChildrenAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:1377:2: ( rule__OptionalChildList__ChildrenAssignment_1 )*
            {
             before(grammarAccess.getOptionalChildListAccess().getChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1378:2: ( rule__OptionalChildList__ChildrenAssignment_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1378:3: rule__OptionalChildList__ChildrenAssignment_1
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__OptionalChildList__ChildrenAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getOptionalChildListAccess().getChildrenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChildList__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalPartialSerializationTestLanguage.g:1387:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1391:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1392:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1399:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1403:1: ( ( 'import' ) )
            // InternalPartialSerializationTestLanguage.g:1404:1: ( 'import' )
            {
            // InternalPartialSerializationTestLanguage.g:1404:1: ( 'import' )
            // InternalPartialSerializationTestLanguage.g:1405:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalPartialSerializationTestLanguage.g:1414:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1418:1: ( rule__Import__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1419:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1425:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1429:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalPartialSerializationTestLanguage.g:1430:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalPartialSerializationTestLanguage.g:1430:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalPartialSerializationTestLanguage.g:1431:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1432:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalPartialSerializationTestLanguage.g:1432:3: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Node__Group__0"
    // InternalPartialSerializationTestLanguage.g:1441:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1445:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1446:2: rule__Node__Group__0__Impl rule__Node__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Node__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0"


    // $ANTLR start "rule__Node__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1453:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1457:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1458:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1458:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1459:2: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1460:2: ()
            // InternalPartialSerializationTestLanguage.g:1460:3: 
            {
            }

             after(grammarAccess.getNodeAccess().getNodeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0__Impl"


    // $ANTLR start "rule__Node__Group__1"
    // InternalPartialSerializationTestLanguage.g:1468:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1472:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1473:2: rule__Node__Group__1__Impl rule__Node__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Node__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1"


    // $ANTLR start "rule__Node__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1480:1: rule__Node__Group__1__Impl : ( ( rule__Node__ImportsAssignment_1 )* ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1484:1: ( ( ( rule__Node__ImportsAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1485:1: ( ( rule__Node__ImportsAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1485:1: ( ( rule__Node__ImportsAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:1486:2: ( rule__Node__ImportsAssignment_1 )*
            {
             before(grammarAccess.getNodeAccess().getImportsAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1487:2: ( rule__Node__ImportsAssignment_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1487:3: rule__Node__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__Node__ImportsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getImportsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1__Impl"


    // $ANTLR start "rule__Node__Group__2"
    // InternalPartialSerializationTestLanguage.g:1495:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1499:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalPartialSerializationTestLanguage.g:1500:2: rule__Node__Group__2__Impl rule__Node__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Node__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2"


    // $ANTLR start "rule__Node__Group__2__Impl"
    // InternalPartialSerializationTestLanguage.g:1507:1: rule__Node__Group__2__Impl : ( ( rule__Node__NameAssignment_2 )? ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1511:1: ( ( ( rule__Node__NameAssignment_2 )? ) )
            // InternalPartialSerializationTestLanguage.g:1512:1: ( ( rule__Node__NameAssignment_2 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1512:1: ( ( rule__Node__NameAssignment_2 )? )
            // InternalPartialSerializationTestLanguage.g:1513:2: ( rule__Node__NameAssignment_2 )?
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:1514:2: ( rule__Node__NameAssignment_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1514:3: rule__Node__NameAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__NameAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2__Impl"


    // $ANTLR start "rule__Node__Group__3"
    // InternalPartialSerializationTestLanguage.g:1522:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1526:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalPartialSerializationTestLanguage.g:1527:2: rule__Node__Group__3__Impl rule__Node__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Node__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__3"


    // $ANTLR start "rule__Node__Group__3__Impl"
    // InternalPartialSerializationTestLanguage.g:1534:1: rule__Node__Group__3__Impl : ( ( rule__Node__Group_3__0 )? ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1538:1: ( ( ( rule__Node__Group_3__0 )? ) )
            // InternalPartialSerializationTestLanguage.g:1539:1: ( ( rule__Node__Group_3__0 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1539:1: ( ( rule__Node__Group_3__0 )? )
            // InternalPartialSerializationTestLanguage.g:1540:2: ( rule__Node__Group_3__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_3()); 
            // InternalPartialSerializationTestLanguage.g:1541:2: ( rule__Node__Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1541:3: rule__Node__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__3__Impl"


    // $ANTLR start "rule__Node__Group__4"
    // InternalPartialSerializationTestLanguage.g:1549:1: rule__Node__Group__4 : rule__Node__Group__4__Impl ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1553:1: ( rule__Node__Group__4__Impl )
            // InternalPartialSerializationTestLanguage.g:1554:2: rule__Node__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__4"


    // $ANTLR start "rule__Node__Group__4__Impl"
    // InternalPartialSerializationTestLanguage.g:1560:1: rule__Node__Group__4__Impl : ( ( rule__Node__Alternatives_4 ) ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1564:1: ( ( ( rule__Node__Alternatives_4 ) ) )
            // InternalPartialSerializationTestLanguage.g:1565:1: ( ( rule__Node__Alternatives_4 ) )
            {
            // InternalPartialSerializationTestLanguage.g:1565:1: ( ( rule__Node__Alternatives_4 ) )
            // InternalPartialSerializationTestLanguage.g:1566:2: ( rule__Node__Alternatives_4 )
            {
             before(grammarAccess.getNodeAccess().getAlternatives_4()); 
            // InternalPartialSerializationTestLanguage.g:1567:2: ( rule__Node__Alternatives_4 )
            // InternalPartialSerializationTestLanguage.g:1567:3: rule__Node__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__Node__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__4__Impl"


    // $ANTLR start "rule__Node__Group_3__0"
    // InternalPartialSerializationTestLanguage.g:1576:1: rule__Node__Group_3__0 : rule__Node__Group_3__0__Impl rule__Node__Group_3__1 ;
    public final void rule__Node__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1580:1: ( rule__Node__Group_3__0__Impl rule__Node__Group_3__1 )
            // InternalPartialSerializationTestLanguage.g:1581:2: rule__Node__Group_3__0__Impl rule__Node__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__0"


    // $ANTLR start "rule__Node__Group_3__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1588:1: rule__Node__Group_3__0__Impl : ( 'refs' ) ;
    public final void rule__Node__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1592:1: ( ( 'refs' ) )
            // InternalPartialSerializationTestLanguage.g:1593:1: ( 'refs' )
            {
            // InternalPartialSerializationTestLanguage.g:1593:1: ( 'refs' )
            // InternalPartialSerializationTestLanguage.g:1594:2: 'refs'
            {
             before(grammarAccess.getNodeAccess().getRefsKeyword_3_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRefsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__0__Impl"


    // $ANTLR start "rule__Node__Group_3__1"
    // InternalPartialSerializationTestLanguage.g:1603:1: rule__Node__Group_3__1 : rule__Node__Group_3__1__Impl ;
    public final void rule__Node__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1607:1: ( rule__Node__Group_3__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1608:2: rule__Node__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__1"


    // $ANTLR start "rule__Node__Group_3__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1614:1: rule__Node__Group_3__1__Impl : ( ( rule__Node__RefsAssignment_3_1 )* ) ;
    public final void rule__Node__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1618:1: ( ( ( rule__Node__RefsAssignment_3_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1619:1: ( ( rule__Node__RefsAssignment_3_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1619:1: ( ( rule__Node__RefsAssignment_3_1 )* )
            // InternalPartialSerializationTestLanguage.g:1620:2: ( rule__Node__RefsAssignment_3_1 )*
            {
             before(grammarAccess.getNodeAccess().getRefsAssignment_3_1()); 
            // InternalPartialSerializationTestLanguage.g:1621:2: ( rule__Node__RefsAssignment_3_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1621:3: rule__Node__RefsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Node__RefsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getRefsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__1__Impl"


    // $ANTLR start "rule__Node__Group_4_0__0"
    // InternalPartialSerializationTestLanguage.g:1630:1: rule__Node__Group_4_0__0 : rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1 ;
    public final void rule__Node__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1634:1: ( rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1 )
            // InternalPartialSerializationTestLanguage.g:1635:2: rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1
            {
            pushFollow(FOLLOW_8);
            rule__Node__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__0"


    // $ANTLR start "rule__Node__Group_4_0__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1642:1: rule__Node__Group_4_0__0__Impl : ( '{' ) ;
    public final void rule__Node__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1646:1: ( ( '{' ) )
            // InternalPartialSerializationTestLanguage.g:1647:1: ( '{' )
            {
            // InternalPartialSerializationTestLanguage.g:1647:1: ( '{' )
            // InternalPartialSerializationTestLanguage.g:1648:2: '{'
            {
             before(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__0__Impl"


    // $ANTLR start "rule__Node__Group_4_0__1"
    // InternalPartialSerializationTestLanguage.g:1657:1: rule__Node__Group_4_0__1 : rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2 ;
    public final void rule__Node__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1661:1: ( rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2 )
            // InternalPartialSerializationTestLanguage.g:1662:2: rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2
            {
            pushFollow(FOLLOW_8);
            rule__Node__Group_4_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_4_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__1"


    // $ANTLR start "rule__Node__Group_4_0__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1669:1: rule__Node__Group_4_0__1__Impl : ( ( rule__Node__ChildrenAssignment_4_0_1 )* ) ;
    public final void rule__Node__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1673:1: ( ( ( rule__Node__ChildrenAssignment_4_0_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1674:1: ( ( rule__Node__ChildrenAssignment_4_0_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1674:1: ( ( rule__Node__ChildrenAssignment_4_0_1 )* )
            // InternalPartialSerializationTestLanguage.g:1675:2: ( rule__Node__ChildrenAssignment_4_0_1 )*
            {
             before(grammarAccess.getNodeAccess().getChildrenAssignment_4_0_1()); 
            // InternalPartialSerializationTestLanguage.g:1676:2: ( rule__Node__ChildrenAssignment_4_0_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==11||(LA16_0>=25 && LA16_0<=27)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1676:3: rule__Node__ChildrenAssignment_4_0_1
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Node__ChildrenAssignment_4_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getChildrenAssignment_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__1__Impl"


    // $ANTLR start "rule__Node__Group_4_0__2"
    // InternalPartialSerializationTestLanguage.g:1684:1: rule__Node__Group_4_0__2 : rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3 ;
    public final void rule__Node__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1688:1: ( rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3 )
            // InternalPartialSerializationTestLanguage.g:1689:2: rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3
            {
            pushFollow(FOLLOW_8);
            rule__Node__Group_4_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_4_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__2"


    // $ANTLR start "rule__Node__Group_4_0__2__Impl"
    // InternalPartialSerializationTestLanguage.g:1696:1: rule__Node__Group_4_0__2__Impl : ( ( rule__Node__Group_4_0_2__0 )? ) ;
    public final void rule__Node__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1700:1: ( ( ( rule__Node__Group_4_0_2__0 )? ) )
            // InternalPartialSerializationTestLanguage.g:1701:1: ( ( rule__Node__Group_4_0_2__0 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1701:1: ( ( rule__Node__Group_4_0_2__0 )? )
            // InternalPartialSerializationTestLanguage.g:1702:2: ( rule__Node__Group_4_0_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_4_0_2()); 
            // InternalPartialSerializationTestLanguage.g:1703:2: ( rule__Node__Group_4_0_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1703:3: rule__Node__Group_4_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_4_0_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__2__Impl"


    // $ANTLR start "rule__Node__Group_4_0__3"
    // InternalPartialSerializationTestLanguage.g:1711:1: rule__Node__Group_4_0__3 : rule__Node__Group_4_0__3__Impl ;
    public final void rule__Node__Group_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1715:1: ( rule__Node__Group_4_0__3__Impl )
            // InternalPartialSerializationTestLanguage.g:1716:2: rule__Node__Group_4_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_4_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__3"


    // $ANTLR start "rule__Node__Group_4_0__3__Impl"
    // InternalPartialSerializationTestLanguage.g:1722:1: rule__Node__Group_4_0__3__Impl : ( '}' ) ;
    public final void rule__Node__Group_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1726:1: ( ( '}' ) )
            // InternalPartialSerializationTestLanguage.g:1727:1: ( '}' )
            {
            // InternalPartialSerializationTestLanguage.g:1727:1: ( '}' )
            // InternalPartialSerializationTestLanguage.g:1728:2: '}'
            {
             before(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_4_0_3()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_4_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0__3__Impl"


    // $ANTLR start "rule__Node__Group_4_0_2__0"
    // InternalPartialSerializationTestLanguage.g:1738:1: rule__Node__Group_4_0_2__0 : rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1 ;
    public final void rule__Node__Group_4_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1742:1: ( rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1 )
            // InternalPartialSerializationTestLanguage.g:1743:2: rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group_4_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_4_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0_2__0"


    // $ANTLR start "rule__Node__Group_4_0_2__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1750:1: rule__Node__Group_4_0_2__0__Impl : ( 'ref' ) ;
    public final void rule__Node__Group_4_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1754:1: ( ( 'ref' ) )
            // InternalPartialSerializationTestLanguage.g:1755:1: ( 'ref' )
            {
            // InternalPartialSerializationTestLanguage.g:1755:1: ( 'ref' )
            // InternalPartialSerializationTestLanguage.g:1756:2: 'ref'
            {
             before(grammarAccess.getNodeAccess().getRefKeyword_4_0_2_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRefKeyword_4_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0_2__0__Impl"


    // $ANTLR start "rule__Node__Group_4_0_2__1"
    // InternalPartialSerializationTestLanguage.g:1765:1: rule__Node__Group_4_0_2__1 : rule__Node__Group_4_0_2__1__Impl ;
    public final void rule__Node__Group_4_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1769:1: ( rule__Node__Group_4_0_2__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1770:2: rule__Node__Group_4_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_4_0_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0_2__1"


    // $ANTLR start "rule__Node__Group_4_0_2__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1776:1: rule__Node__Group_4_0_2__1__Impl : ( ( rule__Node__RefAssignment_4_0_2_1 ) ) ;
    public final void rule__Node__Group_4_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1780:1: ( ( ( rule__Node__RefAssignment_4_0_2_1 ) ) )
            // InternalPartialSerializationTestLanguage.g:1781:1: ( ( rule__Node__RefAssignment_4_0_2_1 ) )
            {
            // InternalPartialSerializationTestLanguage.g:1781:1: ( ( rule__Node__RefAssignment_4_0_2_1 ) )
            // InternalPartialSerializationTestLanguage.g:1782:2: ( rule__Node__RefAssignment_4_0_2_1 )
            {
             before(grammarAccess.getNodeAccess().getRefAssignment_4_0_2_1()); 
            // InternalPartialSerializationTestLanguage.g:1783:2: ( rule__Node__RefAssignment_4_0_2_1 )
            // InternalPartialSerializationTestLanguage.g:1783:3: rule__Node__RefAssignment_4_0_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__RefAssignment_4_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getRefAssignment_4_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_4_0_2__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalPartialSerializationTestLanguage.g:1792:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1796:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1797:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalPartialSerializationTestLanguage.g:1804:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1808:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1809:1: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1809:1: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1810:2: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:1819:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1823:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1824:2: rule__QualifiedName__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1830:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1834:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalPartialSerializationTestLanguage.g:1835:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1835:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalPartialSerializationTestLanguage.g:1836:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalPartialSerializationTestLanguage.g:1837:2: ( rule__QualifiedName__Group_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==30) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1837:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalPartialSerializationTestLanguage.g:1846:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1850:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalPartialSerializationTestLanguage.g:1851:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalPartialSerializationTestLanguage.g:1858:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1862:1: ( ( '.' ) )
            // InternalPartialSerializationTestLanguage.g:1863:1: ( '.' )
            {
            // InternalPartialSerializationTestLanguage.g:1863:1: ( '.' )
            // InternalPartialSerializationTestLanguage.g:1864:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:1873:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1877:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1878:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1884:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1888:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1889:1: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1889:1: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1890:2: RULE_ID
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


    // $ANTLR start "rule__Model__ClazzAssignment_9_1"
    // InternalPartialSerializationTestLanguage.g:1900:1: rule__Model__ClazzAssignment_9_1 : ( ruleEClassDecl ) ;
    public final void rule__Model__ClazzAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1904:1: ( ( ruleEClassDecl ) )
            // InternalPartialSerializationTestLanguage.g:1905:2: ( ruleEClassDecl )
            {
            // InternalPartialSerializationTestLanguage.g:1905:2: ( ruleEClassDecl )
            // InternalPartialSerializationTestLanguage.g:1906:3: ruleEClassDecl
            {
             before(grammarAccess.getModelAccess().getClazzEClassDeclParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEClassDecl();

            state._fsp--;

             after(grammarAccess.getModelAccess().getClazzEClassDeclParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ClazzAssignment_9_1"


    // $ANTLR start "rule__MandatoryValue__NameAssignment"
    // InternalPartialSerializationTestLanguage.g:1915:1: rule__MandatoryValue__NameAssignment : ( RULE_ID ) ;
    public final void rule__MandatoryValue__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1919:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1920:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1920:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1921:3: RULE_ID
            {
             before(grammarAccess.getMandatoryValueAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMandatoryValueAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryValue__NameAssignment"


    // $ANTLR start "rule__OptionalValue__NameAssignment_2"
    // InternalPartialSerializationTestLanguage.g:1930:1: rule__OptionalValue__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OptionalValue__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1934:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1935:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1935:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1936:3: RULE_ID
            {
             before(grammarAccess.getOptionalValueAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOptionalValueAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalValue__NameAssignment_2"


    // $ANTLR start "rule__ManyOptionalValues__NameAssignment_1"
    // InternalPartialSerializationTestLanguage.g:1945:1: rule__ManyOptionalValues__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ManyOptionalValues__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1949:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1950:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1950:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1951:3: RULE_ID
            {
             before(grammarAccess.getManyOptionalValuesAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getManyOptionalValuesAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ManyOptionalValues__NameAssignment_1"


    // $ANTLR start "rule__ManyMandatoryValues__NameAssignment"
    // InternalPartialSerializationTestLanguage.g:1960:1: rule__ManyMandatoryValues__NameAssignment : ( RULE_ID ) ;
    public final void rule__ManyMandatoryValues__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1964:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:1965:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:1965:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:1966:3: RULE_ID
            {
             before(grammarAccess.getManyMandatoryValuesAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getManyMandatoryValuesAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ManyMandatoryValues__NameAssignment"


    // $ANTLR start "rule__MandatoryChild__ChildAssignment"
    // InternalPartialSerializationTestLanguage.g:1975:1: rule__MandatoryChild__ChildAssignment : ( ruleMandatoryValue ) ;
    public final void rule__MandatoryChild__ChildAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1979:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:1980:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:1980:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:1981:3: ruleMandatoryValue
            {
             before(grammarAccess.getMandatoryChildAccess().getChildMandatoryValueParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getMandatoryChildAccess().getChildMandatoryValueParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryChild__ChildAssignment"


    // $ANTLR start "rule__OptionalChild__ChildAssignment_1"
    // InternalPartialSerializationTestLanguage.g:1990:1: rule__OptionalChild__ChildAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__OptionalChild__ChildAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1994:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:1995:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:1995:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:1996:3: ruleMandatoryValue
            {
             before(grammarAccess.getOptionalChildAccess().getChildMandatoryValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getOptionalChildAccess().getChildMandatoryValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChild__ChildAssignment_1"


    // $ANTLR start "rule__MandatoryChildList__ChildrenAssignment"
    // InternalPartialSerializationTestLanguage.g:2005:1: rule__MandatoryChildList__ChildrenAssignment : ( ruleMandatoryValue ) ;
    public final void rule__MandatoryChildList__ChildrenAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2009:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2010:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2010:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2011:3: ruleMandatoryValue
            {
             before(grammarAccess.getMandatoryChildListAccess().getChildrenMandatoryValueParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getMandatoryChildListAccess().getChildrenMandatoryValueParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryChildList__ChildrenAssignment"


    // $ANTLR start "rule__OptionalChildList__ChildrenAssignment_1"
    // InternalPartialSerializationTestLanguage.g:2020:1: rule__OptionalChildList__ChildrenAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__OptionalChildList__ChildrenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2024:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2025:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2025:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2026:3: ruleMandatoryValue
            {
             before(grammarAccess.getOptionalChildListAccess().getChildrenMandatoryValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getOptionalChildListAccess().getChildrenMandatoryValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalChildList__ChildrenAssignment_1"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalPartialSerializationTestLanguage.g:2035:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2039:1: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:2040:2: ( ruleQualifiedName )
            {
            // InternalPartialSerializationTestLanguage.g:2040:2: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:2041:3: ruleQualifiedName
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Node__ImportsAssignment_1"
    // InternalPartialSerializationTestLanguage.g:2050:1: rule__Node__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Node__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2054:1: ( ( ruleImport ) )
            // InternalPartialSerializationTestLanguage.g:2055:2: ( ruleImport )
            {
            // InternalPartialSerializationTestLanguage.g:2055:2: ( ruleImport )
            // InternalPartialSerializationTestLanguage.g:2056:3: ruleImport
            {
             before(grammarAccess.getNodeAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getImportsImportParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ImportsAssignment_1"


    // $ANTLR start "rule__Node__NameAssignment_2"
    // InternalPartialSerializationTestLanguage.g:2065:1: rule__Node__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Node__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2069:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2070:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2070:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2071:3: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__NameAssignment_2"


    // $ANTLR start "rule__Node__RefsAssignment_3_1"
    // InternalPartialSerializationTestLanguage.g:2080:1: rule__Node__RefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Node__RefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2084:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:2085:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:2085:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:2086:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getNodeAccess().getRefsNodeCrossReference_3_1_0()); 
            // InternalPartialSerializationTestLanguage.g:2087:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:2088:4: ruleQualifiedName
            {
             before(grammarAccess.getNodeAccess().getRefsNodeQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getRefsNodeQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getRefsNodeCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__RefsAssignment_3_1"


    // $ANTLR start "rule__Node__ChildrenAssignment_4_0_1"
    // InternalPartialSerializationTestLanguage.g:2099:1: rule__Node__ChildrenAssignment_4_0_1 : ( ruleNode ) ;
    public final void rule__Node__ChildrenAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2103:1: ( ( ruleNode ) )
            // InternalPartialSerializationTestLanguage.g:2104:2: ( ruleNode )
            {
            // InternalPartialSerializationTestLanguage.g:2104:2: ( ruleNode )
            // InternalPartialSerializationTestLanguage.g:2105:3: ruleNode
            {
             before(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_4_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_4_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ChildrenAssignment_4_0_1"


    // $ANTLR start "rule__Node__RefAssignment_4_0_2_1"
    // InternalPartialSerializationTestLanguage.g:2114:1: rule__Node__RefAssignment_4_0_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Node__RefAssignment_4_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2118:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:2119:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:2119:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:2120:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getNodeAccess().getRefNodeCrossReference_4_0_2_1_0()); 
            // InternalPartialSerializationTestLanguage.g:2121:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:2122:4: ruleQualifiedName
            {
             before(grammarAccess.getNodeAccess().getRefNodeQualifiedNameParserRuleCall_4_0_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getRefNodeQualifiedNameParserRuleCall_4_0_2_1_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getRefNodeCrossReference_4_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__RefAssignment_4_0_2_1"


    // $ANTLR start "rule__EClassDecl__NameAssignment"
    // InternalPartialSerializationTestLanguage.g:2133:1: rule__EClassDecl__NameAssignment : ( RULE_ID ) ;
    public final void rule__EClassDecl__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2137:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2138:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2138:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2139:3: RULE_ID
            {
             before(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EClassDecl__NameAssignment"


    // $ANTLR start "rule__EClassRef__RefAssignment"
    // InternalPartialSerializationTestLanguage.g:2148:1: rule__EClassRef__RefAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__EClassRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2152:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:2153:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:2153:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:2154:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getEClassRefAccess().getRefEClassCrossReference_0()); 
            // InternalPartialSerializationTestLanguage.g:2155:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:2156:4: ruleQualifiedName
            {
             before(grammarAccess.getEClassRefAccess().getRefEClassQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getEClassRefAccess().getRefEClassQualifiedNameParserRuleCall_0_1()); 

            }

             after(grammarAccess.getEClassRefAccess().getRefEClassCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EClassRef__RefAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000000E000810L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001800010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000003E000810L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000E000812L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000040000002L});

}