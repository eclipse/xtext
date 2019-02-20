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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#10'", "'#11'", "'#12'", "'#13'", "'#20'", "'#21'", "'#22'", "'#23'", "'#24'", "'kw1'", "'kw2'", "'{'", "'children1'", "'}'", "'direct'", "':'", "'child'", "'subs'", "'import'", "'refs'", "'ref'", "'.'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
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


    // $ANTLR start "entryRuleTwoChildLists"
    // InternalPartialSerializationTestLanguage.g:239:1: entryRuleTwoChildLists : ruleTwoChildLists EOF ;
    public final void entryRuleTwoChildLists() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:240:1: ( ruleTwoChildLists EOF )
            // InternalPartialSerializationTestLanguage.g:241:1: ruleTwoChildLists EOF
            {
             before(grammarAccess.getTwoChildListsRule()); 
            pushFollow(FOLLOW_1);
            ruleTwoChildLists();

            state._fsp--;

             after(grammarAccess.getTwoChildListsRule()); 
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
    // $ANTLR end "entryRuleTwoChildLists"


    // $ANTLR start "ruleTwoChildLists"
    // InternalPartialSerializationTestLanguage.g:248:1: ruleTwoChildLists : ( ( rule__TwoChildLists__Group__0 ) ) ;
    public final void ruleTwoChildLists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:252:2: ( ( ( rule__TwoChildLists__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:253:2: ( ( rule__TwoChildLists__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:253:2: ( ( rule__TwoChildLists__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:254:3: ( rule__TwoChildLists__Group__0 )
            {
             before(grammarAccess.getTwoChildListsAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:255:3: ( rule__TwoChildLists__Group__0 )
            // InternalPartialSerializationTestLanguage.g:255:4: rule__TwoChildLists__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTwoChildListsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTwoChildLists"


    // $ANTLR start "entryRuleTwoChilds"
    // InternalPartialSerializationTestLanguage.g:264:1: entryRuleTwoChilds : ruleTwoChilds EOF ;
    public final void entryRuleTwoChilds() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:265:1: ( ruleTwoChilds EOF )
            // InternalPartialSerializationTestLanguage.g:266:1: ruleTwoChilds EOF
            {
             before(grammarAccess.getTwoChildsRule()); 
            pushFollow(FOLLOW_1);
            ruleTwoChilds();

            state._fsp--;

             after(grammarAccess.getTwoChildsRule()); 
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
    // $ANTLR end "entryRuleTwoChilds"


    // $ANTLR start "ruleTwoChilds"
    // InternalPartialSerializationTestLanguage.g:273:1: ruleTwoChilds : ( ( rule__TwoChilds__Group__0 ) ) ;
    public final void ruleTwoChilds() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:277:2: ( ( ( rule__TwoChilds__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:278:2: ( ( rule__TwoChilds__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:278:2: ( ( rule__TwoChilds__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:279:3: ( rule__TwoChilds__Group__0 )
            {
             before(grammarAccess.getTwoChildsAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:280:3: ( rule__TwoChilds__Group__0 )
            // InternalPartialSerializationTestLanguage.g:280:4: rule__TwoChilds__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTwoChildsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTwoChilds"


    // $ANTLR start "entryRuleChildWithSubChilds"
    // InternalPartialSerializationTestLanguage.g:289:1: entryRuleChildWithSubChilds : ruleChildWithSubChilds EOF ;
    public final void entryRuleChildWithSubChilds() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:290:1: ( ruleChildWithSubChilds EOF )
            // InternalPartialSerializationTestLanguage.g:291:1: ruleChildWithSubChilds EOF
            {
             before(grammarAccess.getChildWithSubChildsRule()); 
            pushFollow(FOLLOW_1);
            ruleChildWithSubChilds();

            state._fsp--;

             after(grammarAccess.getChildWithSubChildsRule()); 
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
    // $ANTLR end "entryRuleChildWithSubChilds"


    // $ANTLR start "ruleChildWithSubChilds"
    // InternalPartialSerializationTestLanguage.g:298:1: ruleChildWithSubChilds : ( ( rule__ChildWithSubChilds__Group__0 ) ) ;
    public final void ruleChildWithSubChilds() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:302:2: ( ( ( rule__ChildWithSubChilds__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:303:2: ( ( rule__ChildWithSubChilds__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:303:2: ( ( rule__ChildWithSubChilds__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:304:3: ( rule__ChildWithSubChilds__Group__0 )
            {
             before(grammarAccess.getChildWithSubChildsAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:305:3: ( rule__ChildWithSubChilds__Group__0 )
            // InternalPartialSerializationTestLanguage.g:305:4: rule__ChildWithSubChilds__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ChildWithSubChilds__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChildWithSubChildsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChildWithSubChilds"


    // $ANTLR start "entryRuleChildWithSubChild"
    // InternalPartialSerializationTestLanguage.g:314:1: entryRuleChildWithSubChild : ruleChildWithSubChild EOF ;
    public final void entryRuleChildWithSubChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:315:1: ( ruleChildWithSubChild EOF )
            // InternalPartialSerializationTestLanguage.g:316:1: ruleChildWithSubChild EOF
            {
             before(grammarAccess.getChildWithSubChildRule()); 
            pushFollow(FOLLOW_1);
            ruleChildWithSubChild();

            state._fsp--;

             after(grammarAccess.getChildWithSubChildRule()); 
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
    // $ANTLR end "entryRuleChildWithSubChild"


    // $ANTLR start "ruleChildWithSubChild"
    // InternalPartialSerializationTestLanguage.g:323:1: ruleChildWithSubChild : ( ( rule__ChildWithSubChild__Group__0 ) ) ;
    public final void ruleChildWithSubChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:327:2: ( ( ( rule__ChildWithSubChild__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:328:2: ( ( rule__ChildWithSubChild__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:328:2: ( ( rule__ChildWithSubChild__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:329:3: ( rule__ChildWithSubChild__Group__0 )
            {
             before(grammarAccess.getChildWithSubChildAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:330:3: ( rule__ChildWithSubChild__Group__0 )
            // InternalPartialSerializationTestLanguage.g:330:4: rule__ChildWithSubChild__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ChildWithSubChild__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getChildWithSubChildAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleChildWithSubChild"


    // $ANTLR start "entryRuleSubChild"
    // InternalPartialSerializationTestLanguage.g:339:1: entryRuleSubChild : ruleSubChild EOF ;
    public final void entryRuleSubChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:340:1: ( ruleSubChild EOF )
            // InternalPartialSerializationTestLanguage.g:341:1: ruleSubChild EOF
            {
             before(grammarAccess.getSubChildRule()); 
            pushFollow(FOLLOW_1);
            ruleSubChild();

            state._fsp--;

             after(grammarAccess.getSubChildRule()); 
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
    // $ANTLR end "entryRuleSubChild"


    // $ANTLR start "ruleSubChild"
    // InternalPartialSerializationTestLanguage.g:348:1: ruleSubChild : ( ( rule__SubChild__NameAssignment ) ) ;
    public final void ruleSubChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:352:2: ( ( ( rule__SubChild__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:353:2: ( ( rule__SubChild__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:353:2: ( ( rule__SubChild__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:354:3: ( rule__SubChild__NameAssignment )
            {
             before(grammarAccess.getSubChildAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:355:3: ( rule__SubChild__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:355:4: rule__SubChild__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__SubChild__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getSubChildAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSubChild"


    // $ANTLR start "entryRuleMandatoryChildList"
    // InternalPartialSerializationTestLanguage.g:364:1: entryRuleMandatoryChildList : ruleMandatoryChildList EOF ;
    public final void entryRuleMandatoryChildList() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:365:1: ( ruleMandatoryChildList EOF )
            // InternalPartialSerializationTestLanguage.g:366:1: ruleMandatoryChildList EOF
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
    // InternalPartialSerializationTestLanguage.g:373:1: ruleMandatoryChildList : ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) ) ;
    public final void ruleMandatoryChildList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:377:2: ( ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) ) )
            // InternalPartialSerializationTestLanguage.g:378:2: ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:378:2: ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) )
            // InternalPartialSerializationTestLanguage.g:379:3: ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* )
            {
            // InternalPartialSerializationTestLanguage.g:379:3: ( ( rule__MandatoryChildList__ChildrenAssignment ) )
            // InternalPartialSerializationTestLanguage.g:380:4: ( rule__MandatoryChildList__ChildrenAssignment )
            {
             before(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 
            // InternalPartialSerializationTestLanguage.g:381:4: ( rule__MandatoryChildList__ChildrenAssignment )
            // InternalPartialSerializationTestLanguage.g:381:5: rule__MandatoryChildList__ChildrenAssignment
            {
            pushFollow(FOLLOW_3);
            rule__MandatoryChildList__ChildrenAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 

            }

            // InternalPartialSerializationTestLanguage.g:384:3: ( ( rule__MandatoryChildList__ChildrenAssignment )* )
            // InternalPartialSerializationTestLanguage.g:385:4: ( rule__MandatoryChildList__ChildrenAssignment )*
            {
             before(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 
            // InternalPartialSerializationTestLanguage.g:386:4: ( rule__MandatoryChildList__ChildrenAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:386:5: rule__MandatoryChildList__ChildrenAssignment
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
    // InternalPartialSerializationTestLanguage.g:396:1: entryRuleOptionalChildList : ruleOptionalChildList EOF ;
    public final void entryRuleOptionalChildList() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:397:1: ( ruleOptionalChildList EOF )
            // InternalPartialSerializationTestLanguage.g:398:1: ruleOptionalChildList EOF
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
    // InternalPartialSerializationTestLanguage.g:405:1: ruleOptionalChildList : ( ( rule__OptionalChildList__Group__0 ) ) ;
    public final void ruleOptionalChildList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:409:2: ( ( ( rule__OptionalChildList__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:410:2: ( ( rule__OptionalChildList__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:410:2: ( ( rule__OptionalChildList__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:411:3: ( rule__OptionalChildList__Group__0 )
            {
             before(grammarAccess.getOptionalChildListAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:412:3: ( rule__OptionalChildList__Group__0 )
            // InternalPartialSerializationTestLanguage.g:412:4: rule__OptionalChildList__Group__0
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
    // InternalPartialSerializationTestLanguage.g:421:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:422:1: ( ruleImport EOF )
            // InternalPartialSerializationTestLanguage.g:423:1: ruleImport EOF
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
    // InternalPartialSerializationTestLanguage.g:430:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:434:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:435:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:435:2: ( ( rule__Import__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:436:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:437:3: ( rule__Import__Group__0 )
            // InternalPartialSerializationTestLanguage.g:437:4: rule__Import__Group__0
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
    // InternalPartialSerializationTestLanguage.g:446:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:447:1: ( ruleNode EOF )
            // InternalPartialSerializationTestLanguage.g:448:1: ruleNode EOF
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
    // InternalPartialSerializationTestLanguage.g:455:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:459:2: ( ( ( rule__Node__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:460:2: ( ( rule__Node__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:460:2: ( ( rule__Node__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:461:3: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:462:3: ( rule__Node__Group__0 )
            // InternalPartialSerializationTestLanguage.g:462:4: rule__Node__Group__0
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
    // InternalPartialSerializationTestLanguage.g:471:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:472:1: ( ruleQualifiedName EOF )
            // InternalPartialSerializationTestLanguage.g:473:1: ruleQualifiedName EOF
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
    // InternalPartialSerializationTestLanguage.g:480:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:484:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:485:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:485:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:486:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:487:3: ( rule__QualifiedName__Group__0 )
            // InternalPartialSerializationTestLanguage.g:487:4: rule__QualifiedName__Group__0
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
    // InternalPartialSerializationTestLanguage.g:496:1: entryRuleEClassDecl : ruleEClassDecl EOF ;
    public final void entryRuleEClassDecl() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:497:1: ( ruleEClassDecl EOF )
            // InternalPartialSerializationTestLanguage.g:498:1: ruleEClassDecl EOF
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
    // InternalPartialSerializationTestLanguage.g:505:1: ruleEClassDecl : ( ( rule__EClassDecl__NameAssignment ) ) ;
    public final void ruleEClassDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:509:2: ( ( ( rule__EClassDecl__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:510:2: ( ( rule__EClassDecl__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:510:2: ( ( rule__EClassDecl__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:511:3: ( rule__EClassDecl__NameAssignment )
            {
             before(grammarAccess.getEClassDeclAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:512:3: ( rule__EClassDecl__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:512:4: rule__EClassDecl__NameAssignment
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
    // InternalPartialSerializationTestLanguage.g:521:1: entryRuleEClassRef : ruleEClassRef EOF ;
    public final void entryRuleEClassRef() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:522:1: ( ruleEClassRef EOF )
            // InternalPartialSerializationTestLanguage.g:523:1: ruleEClassRef EOF
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
    // InternalPartialSerializationTestLanguage.g:530:1: ruleEClassRef : ( ( rule__EClassRef__RefAssignment ) ) ;
    public final void ruleEClassRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:534:2: ( ( ( rule__EClassRef__RefAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:535:2: ( ( rule__EClassRef__RefAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:535:2: ( ( rule__EClassRef__RefAssignment ) )
            // InternalPartialSerializationTestLanguage.g:536:3: ( rule__EClassRef__RefAssignment )
            {
             before(grammarAccess.getEClassRefAccess().getRefAssignment()); 
            // InternalPartialSerializationTestLanguage.g:537:3: ( rule__EClassRef__RefAssignment )
            // InternalPartialSerializationTestLanguage.g:537:4: rule__EClassRef__RefAssignment
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
    // InternalPartialSerializationTestLanguage.g:545:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) | ( ( rule__Model__Group_6__0 ) ) | ( ( rule__Model__Group_7__0 ) ) | ( ( rule__Model__Group_8__0 ) ) | ( ( rule__Model__Group_9__0 ) ) | ( ( rule__Model__Group_10__0 ) ) | ( ( rule__Model__Group_11__0 ) ) | ( ( rule__Model__Group_12__0 ) ) | ( ( rule__Model__Group_13__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:549:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) | ( ( rule__Model__Group_6__0 ) ) | ( ( rule__Model__Group_7__0 ) ) | ( ( rule__Model__Group_8__0 ) ) | ( ( rule__Model__Group_9__0 ) ) | ( ( rule__Model__Group_10__0 ) ) | ( ( rule__Model__Group_11__0 ) ) | ( ( rule__Model__Group_12__0 ) ) | ( ( rule__Model__Group_13__0 ) ) )
            int alt3=14;
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
            case 23:
                {
                alt3=12;
                }
                break;
            case 24:
                {
                alt3=13;
                }
                break;
            case 25:
                {
                alt3=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:550:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:550:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalPartialSerializationTestLanguage.g:551:3: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // InternalPartialSerializationTestLanguage.g:552:3: ( rule__Model__Group_0__0 )
                    // InternalPartialSerializationTestLanguage.g:552:4: rule__Model__Group_0__0
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
                    // InternalPartialSerializationTestLanguage.g:556:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:556:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalPartialSerializationTestLanguage.g:557:3: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // InternalPartialSerializationTestLanguage.g:558:3: ( rule__Model__Group_1__0 )
                    // InternalPartialSerializationTestLanguage.g:558:4: rule__Model__Group_1__0
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
                    // InternalPartialSerializationTestLanguage.g:562:2: ( ( rule__Model__Group_2__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:562:2: ( ( rule__Model__Group_2__0 ) )
                    // InternalPartialSerializationTestLanguage.g:563:3: ( rule__Model__Group_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // InternalPartialSerializationTestLanguage.g:564:3: ( rule__Model__Group_2__0 )
                    // InternalPartialSerializationTestLanguage.g:564:4: rule__Model__Group_2__0
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
                    // InternalPartialSerializationTestLanguage.g:568:2: ( ( rule__Model__Group_3__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:568:2: ( ( rule__Model__Group_3__0 ) )
                    // InternalPartialSerializationTestLanguage.g:569:3: ( rule__Model__Group_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_3()); 
                    // InternalPartialSerializationTestLanguage.g:570:3: ( rule__Model__Group_3__0 )
                    // InternalPartialSerializationTestLanguage.g:570:4: rule__Model__Group_3__0
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
                    // InternalPartialSerializationTestLanguage.g:574:2: ( ( rule__Model__Group_4__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:574:2: ( ( rule__Model__Group_4__0 ) )
                    // InternalPartialSerializationTestLanguage.g:575:3: ( rule__Model__Group_4__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_4()); 
                    // InternalPartialSerializationTestLanguage.g:576:3: ( rule__Model__Group_4__0 )
                    // InternalPartialSerializationTestLanguage.g:576:4: rule__Model__Group_4__0
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
                    // InternalPartialSerializationTestLanguage.g:580:2: ( ( rule__Model__Group_5__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:580:2: ( ( rule__Model__Group_5__0 ) )
                    // InternalPartialSerializationTestLanguage.g:581:3: ( rule__Model__Group_5__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_5()); 
                    // InternalPartialSerializationTestLanguage.g:582:3: ( rule__Model__Group_5__0 )
                    // InternalPartialSerializationTestLanguage.g:582:4: rule__Model__Group_5__0
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
                    // InternalPartialSerializationTestLanguage.g:586:2: ( ( rule__Model__Group_6__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:586:2: ( ( rule__Model__Group_6__0 ) )
                    // InternalPartialSerializationTestLanguage.g:587:3: ( rule__Model__Group_6__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_6()); 
                    // InternalPartialSerializationTestLanguage.g:588:3: ( rule__Model__Group_6__0 )
                    // InternalPartialSerializationTestLanguage.g:588:4: rule__Model__Group_6__0
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
                    // InternalPartialSerializationTestLanguage.g:592:2: ( ( rule__Model__Group_7__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:592:2: ( ( rule__Model__Group_7__0 ) )
                    // InternalPartialSerializationTestLanguage.g:593:3: ( rule__Model__Group_7__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_7()); 
                    // InternalPartialSerializationTestLanguage.g:594:3: ( rule__Model__Group_7__0 )
                    // InternalPartialSerializationTestLanguage.g:594:4: rule__Model__Group_7__0
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
                    // InternalPartialSerializationTestLanguage.g:598:2: ( ( rule__Model__Group_8__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:598:2: ( ( rule__Model__Group_8__0 ) )
                    // InternalPartialSerializationTestLanguage.g:599:3: ( rule__Model__Group_8__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_8()); 
                    // InternalPartialSerializationTestLanguage.g:600:3: ( rule__Model__Group_8__0 )
                    // InternalPartialSerializationTestLanguage.g:600:4: rule__Model__Group_8__0
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
                    // InternalPartialSerializationTestLanguage.g:604:2: ( ( rule__Model__Group_9__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:604:2: ( ( rule__Model__Group_9__0 ) )
                    // InternalPartialSerializationTestLanguage.g:605:3: ( rule__Model__Group_9__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_9()); 
                    // InternalPartialSerializationTestLanguage.g:606:3: ( rule__Model__Group_9__0 )
                    // InternalPartialSerializationTestLanguage.g:606:4: rule__Model__Group_9__0
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
                    // InternalPartialSerializationTestLanguage.g:610:2: ( ( rule__Model__Group_10__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:610:2: ( ( rule__Model__Group_10__0 ) )
                    // InternalPartialSerializationTestLanguage.g:611:3: ( rule__Model__Group_10__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_10()); 
                    // InternalPartialSerializationTestLanguage.g:612:3: ( rule__Model__Group_10__0 )
                    // InternalPartialSerializationTestLanguage.g:612:4: rule__Model__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_10__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalPartialSerializationTestLanguage.g:616:2: ( ( rule__Model__Group_11__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:616:2: ( ( rule__Model__Group_11__0 ) )
                    // InternalPartialSerializationTestLanguage.g:617:3: ( rule__Model__Group_11__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_11()); 
                    // InternalPartialSerializationTestLanguage.g:618:3: ( rule__Model__Group_11__0 )
                    // InternalPartialSerializationTestLanguage.g:618:4: rule__Model__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_11__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalPartialSerializationTestLanguage.g:622:2: ( ( rule__Model__Group_12__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:622:2: ( ( rule__Model__Group_12__0 ) )
                    // InternalPartialSerializationTestLanguage.g:623:3: ( rule__Model__Group_12__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_12()); 
                    // InternalPartialSerializationTestLanguage.g:624:3: ( rule__Model__Group_12__0 )
                    // InternalPartialSerializationTestLanguage.g:624:4: rule__Model__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_12__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalPartialSerializationTestLanguage.g:628:2: ( ( rule__Model__Group_13__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:628:2: ( ( rule__Model__Group_13__0 ) )
                    // InternalPartialSerializationTestLanguage.g:629:3: ( rule__Model__Group_13__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_13()); 
                    // InternalPartialSerializationTestLanguage.g:630:3: ( rule__Model__Group_13__0 )
                    // InternalPartialSerializationTestLanguage.g:630:4: rule__Model__Group_13__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_13()); 

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
    // InternalPartialSerializationTestLanguage.g:638:1: rule__Node__Alternatives_4 : ( ( ( rule__Node__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Node__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:642:1: ( ( ( rule__Node__Group_4_0__0 ) ) | ( ';' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==28) ) {
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
                    // InternalPartialSerializationTestLanguage.g:643:2: ( ( rule__Node__Group_4_0__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:643:2: ( ( rule__Node__Group_4_0__0 ) )
                    // InternalPartialSerializationTestLanguage.g:644:3: ( rule__Node__Group_4_0__0 )
                    {
                     before(grammarAccess.getNodeAccess().getGroup_4_0()); 
                    // InternalPartialSerializationTestLanguage.g:645:3: ( rule__Node__Group_4_0__0 )
                    // InternalPartialSerializationTestLanguage.g:645:4: rule__Node__Group_4_0__0
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
                    // InternalPartialSerializationTestLanguage.g:649:2: ( ';' )
                    {
                    // InternalPartialSerializationTestLanguage.g:649:2: ( ';' )
                    // InternalPartialSerializationTestLanguage.g:650:3: ';'
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
    // InternalPartialSerializationTestLanguage.g:659:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:663:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalPartialSerializationTestLanguage.g:664:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
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
    // InternalPartialSerializationTestLanguage.g:671:1: rule__Model__Group_0__0__Impl : ( '#1' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:675:1: ( ( '#1' ) )
            // InternalPartialSerializationTestLanguage.g:676:1: ( '#1' )
            {
            // InternalPartialSerializationTestLanguage.g:676:1: ( '#1' )
            // InternalPartialSerializationTestLanguage.g:677:2: '#1'
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
    // InternalPartialSerializationTestLanguage.g:686:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:690:1: ( rule__Model__Group_0__1__Impl )
            // InternalPartialSerializationTestLanguage.g:691:2: rule__Model__Group_0__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:697:1: rule__Model__Group_0__1__Impl : ( ruleNode ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:701:1: ( ( ruleNode ) )
            // InternalPartialSerializationTestLanguage.g:702:1: ( ruleNode )
            {
            // InternalPartialSerializationTestLanguage.g:702:1: ( ruleNode )
            // InternalPartialSerializationTestLanguage.g:703:2: ruleNode
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
    // InternalPartialSerializationTestLanguage.g:713:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:717:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalPartialSerializationTestLanguage.g:718:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
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
    // InternalPartialSerializationTestLanguage.g:725:1: rule__Model__Group_1__0__Impl : ( '#2' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:729:1: ( ( '#2' ) )
            // InternalPartialSerializationTestLanguage.g:730:1: ( '#2' )
            {
            // InternalPartialSerializationTestLanguage.g:730:1: ( '#2' )
            // InternalPartialSerializationTestLanguage.g:731:2: '#2'
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
    // InternalPartialSerializationTestLanguage.g:740:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:744:1: ( rule__Model__Group_1__1__Impl )
            // InternalPartialSerializationTestLanguage.g:745:2: rule__Model__Group_1__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:751:1: rule__Model__Group_1__1__Impl : ( ruleMandatoryValue ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:755:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:756:1: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:756:1: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:757:2: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:767:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:771:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalPartialSerializationTestLanguage.g:772:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalPartialSerializationTestLanguage.g:779:1: rule__Model__Group_2__0__Impl : ( '#3' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:783:1: ( ( '#3' ) )
            // InternalPartialSerializationTestLanguage.g:784:1: ( '#3' )
            {
            // InternalPartialSerializationTestLanguage.g:784:1: ( '#3' )
            // InternalPartialSerializationTestLanguage.g:785:2: '#3'
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
    // InternalPartialSerializationTestLanguage.g:794:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:798:1: ( rule__Model__Group_2__1__Impl )
            // InternalPartialSerializationTestLanguage.g:799:2: rule__Model__Group_2__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:805:1: rule__Model__Group_2__1__Impl : ( ruleOptionalValue ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:809:1: ( ( ruleOptionalValue ) )
            // InternalPartialSerializationTestLanguage.g:810:1: ( ruleOptionalValue )
            {
            // InternalPartialSerializationTestLanguage.g:810:1: ( ruleOptionalValue )
            // InternalPartialSerializationTestLanguage.g:811:2: ruleOptionalValue
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
    // InternalPartialSerializationTestLanguage.g:821:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:825:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalPartialSerializationTestLanguage.g:826:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
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
    // InternalPartialSerializationTestLanguage.g:833:1: rule__Model__Group_3__0__Impl : ( '#4' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:837:1: ( ( '#4' ) )
            // InternalPartialSerializationTestLanguage.g:838:1: ( '#4' )
            {
            // InternalPartialSerializationTestLanguage.g:838:1: ( '#4' )
            // InternalPartialSerializationTestLanguage.g:839:2: '#4'
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
    // InternalPartialSerializationTestLanguage.g:848:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:852:1: ( rule__Model__Group_3__1__Impl )
            // InternalPartialSerializationTestLanguage.g:853:2: rule__Model__Group_3__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:859:1: rule__Model__Group_3__1__Impl : ( ruleMandatoryChild ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:863:1: ( ( ruleMandatoryChild ) )
            // InternalPartialSerializationTestLanguage.g:864:1: ( ruleMandatoryChild )
            {
            // InternalPartialSerializationTestLanguage.g:864:1: ( ruleMandatoryChild )
            // InternalPartialSerializationTestLanguage.g:865:2: ruleMandatoryChild
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
    // InternalPartialSerializationTestLanguage.g:875:1: rule__Model__Group_4__0 : rule__Model__Group_4__0__Impl rule__Model__Group_4__1 ;
    public final void rule__Model__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:879:1: ( rule__Model__Group_4__0__Impl rule__Model__Group_4__1 )
            // InternalPartialSerializationTestLanguage.g:880:2: rule__Model__Group_4__0__Impl rule__Model__Group_4__1
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
    // InternalPartialSerializationTestLanguage.g:887:1: rule__Model__Group_4__0__Impl : ( '#5' ) ;
    public final void rule__Model__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:891:1: ( ( '#5' ) )
            // InternalPartialSerializationTestLanguage.g:892:1: ( '#5' )
            {
            // InternalPartialSerializationTestLanguage.g:892:1: ( '#5' )
            // InternalPartialSerializationTestLanguage.g:893:2: '#5'
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
    // InternalPartialSerializationTestLanguage.g:902:1: rule__Model__Group_4__1 : rule__Model__Group_4__1__Impl ;
    public final void rule__Model__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:906:1: ( rule__Model__Group_4__1__Impl )
            // InternalPartialSerializationTestLanguage.g:907:2: rule__Model__Group_4__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:913:1: rule__Model__Group_4__1__Impl : ( ruleOptionalChild ) ;
    public final void rule__Model__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:917:1: ( ( ruleOptionalChild ) )
            // InternalPartialSerializationTestLanguage.g:918:1: ( ruleOptionalChild )
            {
            // InternalPartialSerializationTestLanguage.g:918:1: ( ruleOptionalChild )
            // InternalPartialSerializationTestLanguage.g:919:2: ruleOptionalChild
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
    // InternalPartialSerializationTestLanguage.g:929:1: rule__Model__Group_5__0 : rule__Model__Group_5__0__Impl rule__Model__Group_5__1 ;
    public final void rule__Model__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:933:1: ( rule__Model__Group_5__0__Impl rule__Model__Group_5__1 )
            // InternalPartialSerializationTestLanguage.g:934:2: rule__Model__Group_5__0__Impl rule__Model__Group_5__1
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
    // InternalPartialSerializationTestLanguage.g:941:1: rule__Model__Group_5__0__Impl : ( '#10' ) ;
    public final void rule__Model__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:945:1: ( ( '#10' ) )
            // InternalPartialSerializationTestLanguage.g:946:1: ( '#10' )
            {
            // InternalPartialSerializationTestLanguage.g:946:1: ( '#10' )
            // InternalPartialSerializationTestLanguage.g:947:2: '#10'
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
    // InternalPartialSerializationTestLanguage.g:956:1: rule__Model__Group_5__1 : rule__Model__Group_5__1__Impl ;
    public final void rule__Model__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:960:1: ( rule__Model__Group_5__1__Impl )
            // InternalPartialSerializationTestLanguage.g:961:2: rule__Model__Group_5__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:967:1: rule__Model__Group_5__1__Impl : ( ruleManyOptionalValues ) ;
    public final void rule__Model__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:971:1: ( ( ruleManyOptionalValues ) )
            // InternalPartialSerializationTestLanguage.g:972:1: ( ruleManyOptionalValues )
            {
            // InternalPartialSerializationTestLanguage.g:972:1: ( ruleManyOptionalValues )
            // InternalPartialSerializationTestLanguage.g:973:2: ruleManyOptionalValues
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
    // InternalPartialSerializationTestLanguage.g:983:1: rule__Model__Group_6__0 : rule__Model__Group_6__0__Impl rule__Model__Group_6__1 ;
    public final void rule__Model__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:987:1: ( rule__Model__Group_6__0__Impl rule__Model__Group_6__1 )
            // InternalPartialSerializationTestLanguage.g:988:2: rule__Model__Group_6__0__Impl rule__Model__Group_6__1
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
    // InternalPartialSerializationTestLanguage.g:995:1: rule__Model__Group_6__0__Impl : ( '#11' ) ;
    public final void rule__Model__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:999:1: ( ( '#11' ) )
            // InternalPartialSerializationTestLanguage.g:1000:1: ( '#11' )
            {
            // InternalPartialSerializationTestLanguage.g:1000:1: ( '#11' )
            // InternalPartialSerializationTestLanguage.g:1001:2: '#11'
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
    // InternalPartialSerializationTestLanguage.g:1010:1: rule__Model__Group_6__1 : rule__Model__Group_6__1__Impl ;
    public final void rule__Model__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1014:1: ( rule__Model__Group_6__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1015:2: rule__Model__Group_6__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1021:1: rule__Model__Group_6__1__Impl : ( ruleManyMandatoryValues ) ;
    public final void rule__Model__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1025:1: ( ( ruleManyMandatoryValues ) )
            // InternalPartialSerializationTestLanguage.g:1026:1: ( ruleManyMandatoryValues )
            {
            // InternalPartialSerializationTestLanguage.g:1026:1: ( ruleManyMandatoryValues )
            // InternalPartialSerializationTestLanguage.g:1027:2: ruleManyMandatoryValues
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
    // InternalPartialSerializationTestLanguage.g:1037:1: rule__Model__Group_7__0 : rule__Model__Group_7__0__Impl rule__Model__Group_7__1 ;
    public final void rule__Model__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1041:1: ( rule__Model__Group_7__0__Impl rule__Model__Group_7__1 )
            // InternalPartialSerializationTestLanguage.g:1042:2: rule__Model__Group_7__0__Impl rule__Model__Group_7__1
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
    // InternalPartialSerializationTestLanguage.g:1049:1: rule__Model__Group_7__0__Impl : ( '#12' ) ;
    public final void rule__Model__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1053:1: ( ( '#12' ) )
            // InternalPartialSerializationTestLanguage.g:1054:1: ( '#12' )
            {
            // InternalPartialSerializationTestLanguage.g:1054:1: ( '#12' )
            // InternalPartialSerializationTestLanguage.g:1055:2: '#12'
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
    // InternalPartialSerializationTestLanguage.g:1064:1: rule__Model__Group_7__1 : rule__Model__Group_7__1__Impl ;
    public final void rule__Model__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1068:1: ( rule__Model__Group_7__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1069:2: rule__Model__Group_7__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1075:1: rule__Model__Group_7__1__Impl : ( ruleMandatoryChildList ) ;
    public final void rule__Model__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1079:1: ( ( ruleMandatoryChildList ) )
            // InternalPartialSerializationTestLanguage.g:1080:1: ( ruleMandatoryChildList )
            {
            // InternalPartialSerializationTestLanguage.g:1080:1: ( ruleMandatoryChildList )
            // InternalPartialSerializationTestLanguage.g:1081:2: ruleMandatoryChildList
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
    // InternalPartialSerializationTestLanguage.g:1091:1: rule__Model__Group_8__0 : rule__Model__Group_8__0__Impl rule__Model__Group_8__1 ;
    public final void rule__Model__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1095:1: ( rule__Model__Group_8__0__Impl rule__Model__Group_8__1 )
            // InternalPartialSerializationTestLanguage.g:1096:2: rule__Model__Group_8__0__Impl rule__Model__Group_8__1
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
    // InternalPartialSerializationTestLanguage.g:1103:1: rule__Model__Group_8__0__Impl : ( '#13' ) ;
    public final void rule__Model__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1107:1: ( ( '#13' ) )
            // InternalPartialSerializationTestLanguage.g:1108:1: ( '#13' )
            {
            // InternalPartialSerializationTestLanguage.g:1108:1: ( '#13' )
            // InternalPartialSerializationTestLanguage.g:1109:2: '#13'
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
    // InternalPartialSerializationTestLanguage.g:1118:1: rule__Model__Group_8__1 : rule__Model__Group_8__1__Impl ;
    public final void rule__Model__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1122:1: ( rule__Model__Group_8__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1123:2: rule__Model__Group_8__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1129:1: rule__Model__Group_8__1__Impl : ( ruleOptionalChildList ) ;
    public final void rule__Model__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1133:1: ( ( ruleOptionalChildList ) )
            // InternalPartialSerializationTestLanguage.g:1134:1: ( ruleOptionalChildList )
            {
            // InternalPartialSerializationTestLanguage.g:1134:1: ( ruleOptionalChildList )
            // InternalPartialSerializationTestLanguage.g:1135:2: ruleOptionalChildList
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
    // InternalPartialSerializationTestLanguage.g:1145:1: rule__Model__Group_9__0 : rule__Model__Group_9__0__Impl rule__Model__Group_9__1 ;
    public final void rule__Model__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1149:1: ( rule__Model__Group_9__0__Impl rule__Model__Group_9__1 )
            // InternalPartialSerializationTestLanguage.g:1150:2: rule__Model__Group_9__0__Impl rule__Model__Group_9__1
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
    // InternalPartialSerializationTestLanguage.g:1157:1: rule__Model__Group_9__0__Impl : ( '#20' ) ;
    public final void rule__Model__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1161:1: ( ( '#20' ) )
            // InternalPartialSerializationTestLanguage.g:1162:1: ( '#20' )
            {
            // InternalPartialSerializationTestLanguage.g:1162:1: ( '#20' )
            // InternalPartialSerializationTestLanguage.g:1163:2: '#20'
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
    // InternalPartialSerializationTestLanguage.g:1172:1: rule__Model__Group_9__1 : rule__Model__Group_9__1__Impl ;
    public final void rule__Model__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1176:1: ( rule__Model__Group_9__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1177:2: rule__Model__Group_9__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1183:1: rule__Model__Group_9__1__Impl : ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) ) ;
    public final void rule__Model__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1187:1: ( ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) ) )
            // InternalPartialSerializationTestLanguage.g:1188:1: ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:1188:1: ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1189:2: ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1189:2: ( ( rule__Model__ClazzAssignment_9_1 ) )
            // InternalPartialSerializationTestLanguage.g:1190:3: ( rule__Model__ClazzAssignment_9_1 )
            {
             before(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 
            // InternalPartialSerializationTestLanguage.g:1191:3: ( rule__Model__ClazzAssignment_9_1 )
            // InternalPartialSerializationTestLanguage.g:1191:4: rule__Model__ClazzAssignment_9_1
            {
            pushFollow(FOLLOW_3);
            rule__Model__ClazzAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 

            }

            // InternalPartialSerializationTestLanguage.g:1194:2: ( ( rule__Model__ClazzAssignment_9_1 )* )
            // InternalPartialSerializationTestLanguage.g:1195:3: ( rule__Model__ClazzAssignment_9_1 )*
            {
             before(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 
            // InternalPartialSerializationTestLanguage.g:1196:3: ( rule__Model__ClazzAssignment_9_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1196:4: rule__Model__ClazzAssignment_9_1
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
    // InternalPartialSerializationTestLanguage.g:1206:1: rule__Model__Group_10__0 : rule__Model__Group_10__0__Impl rule__Model__Group_10__1 ;
    public final void rule__Model__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1210:1: ( rule__Model__Group_10__0__Impl rule__Model__Group_10__1 )
            // InternalPartialSerializationTestLanguage.g:1211:2: rule__Model__Group_10__0__Impl rule__Model__Group_10__1
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
    // InternalPartialSerializationTestLanguage.g:1218:1: rule__Model__Group_10__0__Impl : ( '#21' ) ;
    public final void rule__Model__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1222:1: ( ( '#21' ) )
            // InternalPartialSerializationTestLanguage.g:1223:1: ( '#21' )
            {
            // InternalPartialSerializationTestLanguage.g:1223:1: ( '#21' )
            // InternalPartialSerializationTestLanguage.g:1224:2: '#21'
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
    // InternalPartialSerializationTestLanguage.g:1233:1: rule__Model__Group_10__1 : rule__Model__Group_10__1__Impl ;
    public final void rule__Model__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1237:1: ( rule__Model__Group_10__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1238:2: rule__Model__Group_10__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1244:1: rule__Model__Group_10__1__Impl : ( ruleEClassRef ) ;
    public final void rule__Model__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1248:1: ( ( ruleEClassRef ) )
            // InternalPartialSerializationTestLanguage.g:1249:1: ( ruleEClassRef )
            {
            // InternalPartialSerializationTestLanguage.g:1249:1: ( ruleEClassRef )
            // InternalPartialSerializationTestLanguage.g:1250:2: ruleEClassRef
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


    // $ANTLR start "rule__Model__Group_11__0"
    // InternalPartialSerializationTestLanguage.g:1260:1: rule__Model__Group_11__0 : rule__Model__Group_11__0__Impl rule__Model__Group_11__1 ;
    public final void rule__Model__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1264:1: ( rule__Model__Group_11__0__Impl rule__Model__Group_11__1 )
            // InternalPartialSerializationTestLanguage.g:1265:2: rule__Model__Group_11__0__Impl rule__Model__Group_11__1
            {
            pushFollow(FOLLOW_7);
            rule__Model__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__0"


    // $ANTLR start "rule__Model__Group_11__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1272:1: rule__Model__Group_11__0__Impl : ( '#22' ) ;
    public final void rule__Model__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1276:1: ( ( '#22' ) )
            // InternalPartialSerializationTestLanguage.g:1277:1: ( '#22' )
            {
            // InternalPartialSerializationTestLanguage.g:1277:1: ( '#22' )
            // InternalPartialSerializationTestLanguage.g:1278:2: '#22'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitTwoKeyword_11_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitTwoKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__0__Impl"


    // $ANTLR start "rule__Model__Group_11__1"
    // InternalPartialSerializationTestLanguage.g:1287:1: rule__Model__Group_11__1 : rule__Model__Group_11__1__Impl ;
    public final void rule__Model__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1291:1: ( rule__Model__Group_11__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1292:2: rule__Model__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__1"


    // $ANTLR start "rule__Model__Group_11__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1298:1: rule__Model__Group_11__1__Impl : ( ruleTwoChildLists ) ;
    public final void rule__Model__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1302:1: ( ( ruleTwoChildLists ) )
            // InternalPartialSerializationTestLanguage.g:1303:1: ( ruleTwoChildLists )
            {
            // InternalPartialSerializationTestLanguage.g:1303:1: ( ruleTwoChildLists )
            // InternalPartialSerializationTestLanguage.g:1304:2: ruleTwoChildLists
            {
             before(grammarAccess.getModelAccess().getTwoChildListsParserRuleCall_11_1()); 
            pushFollow(FOLLOW_2);
            ruleTwoChildLists();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTwoChildListsParserRuleCall_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_11__1__Impl"


    // $ANTLR start "rule__Model__Group_12__0"
    // InternalPartialSerializationTestLanguage.g:1314:1: rule__Model__Group_12__0 : rule__Model__Group_12__0__Impl rule__Model__Group_12__1 ;
    public final void rule__Model__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1318:1: ( rule__Model__Group_12__0__Impl rule__Model__Group_12__1 )
            // InternalPartialSerializationTestLanguage.g:1319:2: rule__Model__Group_12__0__Impl rule__Model__Group_12__1
            {
            pushFollow(FOLLOW_8);
            rule__Model__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__0"


    // $ANTLR start "rule__Model__Group_12__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1326:1: rule__Model__Group_12__0__Impl : ( '#23' ) ;
    public final void rule__Model__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1330:1: ( ( '#23' ) )
            // InternalPartialSerializationTestLanguage.g:1331:1: ( '#23' )
            {
            // InternalPartialSerializationTestLanguage.g:1331:1: ( '#23' )
            // InternalPartialSerializationTestLanguage.g:1332:2: '#23'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitThreeKeyword_12_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitThreeKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__0__Impl"


    // $ANTLR start "rule__Model__Group_12__1"
    // InternalPartialSerializationTestLanguage.g:1341:1: rule__Model__Group_12__1 : rule__Model__Group_12__1__Impl ;
    public final void rule__Model__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1345:1: ( rule__Model__Group_12__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1346:2: rule__Model__Group_12__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_12__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__1"


    // $ANTLR start "rule__Model__Group_12__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1352:1: rule__Model__Group_12__1__Impl : ( ruleChildWithSubChilds ) ;
    public final void rule__Model__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1356:1: ( ( ruleChildWithSubChilds ) )
            // InternalPartialSerializationTestLanguage.g:1357:1: ( ruleChildWithSubChilds )
            {
            // InternalPartialSerializationTestLanguage.g:1357:1: ( ruleChildWithSubChilds )
            // InternalPartialSerializationTestLanguage.g:1358:2: ruleChildWithSubChilds
            {
             before(grammarAccess.getModelAccess().getChildWithSubChildsParserRuleCall_12_1()); 
            pushFollow(FOLLOW_2);
            ruleChildWithSubChilds();

            state._fsp--;

             after(grammarAccess.getModelAccess().getChildWithSubChildsParserRuleCall_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_12__1__Impl"


    // $ANTLR start "rule__Model__Group_13__0"
    // InternalPartialSerializationTestLanguage.g:1368:1: rule__Model__Group_13__0 : rule__Model__Group_13__0__Impl rule__Model__Group_13__1 ;
    public final void rule__Model__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1372:1: ( rule__Model__Group_13__0__Impl rule__Model__Group_13__1 )
            // InternalPartialSerializationTestLanguage.g:1373:2: rule__Model__Group_13__0__Impl rule__Model__Group_13__1
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__0"


    // $ANTLR start "rule__Model__Group_13__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1380:1: rule__Model__Group_13__0__Impl : ( '#24' ) ;
    public final void rule__Model__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1384:1: ( ( '#24' ) )
            // InternalPartialSerializationTestLanguage.g:1385:1: ( '#24' )
            {
            // InternalPartialSerializationTestLanguage.g:1385:1: ( '#24' )
            // InternalPartialSerializationTestLanguage.g:1386:2: '#24'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitFourKeyword_13_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitTwoDigitFourKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__0__Impl"


    // $ANTLR start "rule__Model__Group_13__1"
    // InternalPartialSerializationTestLanguage.g:1395:1: rule__Model__Group_13__1 : rule__Model__Group_13__1__Impl ;
    public final void rule__Model__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1399:1: ( rule__Model__Group_13__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1400:2: rule__Model__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_13__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__1"


    // $ANTLR start "rule__Model__Group_13__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1406:1: rule__Model__Group_13__1__Impl : ( ruleTwoChilds ) ;
    public final void rule__Model__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1410:1: ( ( ruleTwoChilds ) )
            // InternalPartialSerializationTestLanguage.g:1411:1: ( ruleTwoChilds )
            {
            // InternalPartialSerializationTestLanguage.g:1411:1: ( ruleTwoChilds )
            // InternalPartialSerializationTestLanguage.g:1412:2: ruleTwoChilds
            {
             before(grammarAccess.getModelAccess().getTwoChildsParserRuleCall_13_1()); 
            pushFollow(FOLLOW_2);
            ruleTwoChilds();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTwoChildsParserRuleCall_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__1__Impl"


    // $ANTLR start "rule__OptionalValue__Group__0"
    // InternalPartialSerializationTestLanguage.g:1422:1: rule__OptionalValue__Group__0 : rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1 ;
    public final void rule__OptionalValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1426:1: ( rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1427:2: rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1434:1: rule__OptionalValue__Group__0__Impl : ( () ) ;
    public final void rule__OptionalValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1438:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1439:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1439:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1440:2: ()
            {
             before(grammarAccess.getOptionalValueAccess().getOptionalValueAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1441:2: ()
            // InternalPartialSerializationTestLanguage.g:1441:3: 
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
    // InternalPartialSerializationTestLanguage.g:1449:1: rule__OptionalValue__Group__1 : rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2 ;
    public final void rule__OptionalValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1453:1: ( rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1454:2: rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2
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
    // InternalPartialSerializationTestLanguage.g:1461:1: rule__OptionalValue__Group__1__Impl : ( ( 'kw1' )? ) ;
    public final void rule__OptionalValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1465:1: ( ( ( 'kw1' )? ) )
            // InternalPartialSerializationTestLanguage.g:1466:1: ( ( 'kw1' )? )
            {
            // InternalPartialSerializationTestLanguage.g:1466:1: ( ( 'kw1' )? )
            // InternalPartialSerializationTestLanguage.g:1467:2: ( 'kw1' )?
            {
             before(grammarAccess.getOptionalValueAccess().getKw1Keyword_1()); 
            // InternalPartialSerializationTestLanguage.g:1468:2: ( 'kw1' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1468:3: 'kw1'
                    {
                    match(input,26,FOLLOW_2); 

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
    // InternalPartialSerializationTestLanguage.g:1476:1: rule__OptionalValue__Group__2 : rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3 ;
    public final void rule__OptionalValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1480:1: ( rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3 )
            // InternalPartialSerializationTestLanguage.g:1481:2: rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3
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
    // InternalPartialSerializationTestLanguage.g:1488:1: rule__OptionalValue__Group__2__Impl : ( ( rule__OptionalValue__NameAssignment_2 )? ) ;
    public final void rule__OptionalValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1492:1: ( ( ( rule__OptionalValue__NameAssignment_2 )? ) )
            // InternalPartialSerializationTestLanguage.g:1493:1: ( ( rule__OptionalValue__NameAssignment_2 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1493:1: ( ( rule__OptionalValue__NameAssignment_2 )? )
            // InternalPartialSerializationTestLanguage.g:1494:2: ( rule__OptionalValue__NameAssignment_2 )?
            {
             before(grammarAccess.getOptionalValueAccess().getNameAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:1495:2: ( rule__OptionalValue__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1495:3: rule__OptionalValue__NameAssignment_2
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
    // InternalPartialSerializationTestLanguage.g:1503:1: rule__OptionalValue__Group__3 : rule__OptionalValue__Group__3__Impl ;
    public final void rule__OptionalValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1507:1: ( rule__OptionalValue__Group__3__Impl )
            // InternalPartialSerializationTestLanguage.g:1508:2: rule__OptionalValue__Group__3__Impl
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
    // InternalPartialSerializationTestLanguage.g:1514:1: rule__OptionalValue__Group__3__Impl : ( ( 'kw2' )? ) ;
    public final void rule__OptionalValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1518:1: ( ( ( 'kw2' )? ) )
            // InternalPartialSerializationTestLanguage.g:1519:1: ( ( 'kw2' )? )
            {
            // InternalPartialSerializationTestLanguage.g:1519:1: ( ( 'kw2' )? )
            // InternalPartialSerializationTestLanguage.g:1520:2: ( 'kw2' )?
            {
             before(grammarAccess.getOptionalValueAccess().getKw2Keyword_3()); 
            // InternalPartialSerializationTestLanguage.g:1521:2: ( 'kw2' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1521:3: 'kw2'
                    {
                    match(input,27,FOLLOW_2); 

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
    // InternalPartialSerializationTestLanguage.g:1530:1: rule__ManyOptionalValues__Group__0 : rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1 ;
    public final void rule__ManyOptionalValues__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1534:1: ( rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1535:2: rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1542:1: rule__ManyOptionalValues__Group__0__Impl : ( () ) ;
    public final void rule__ManyOptionalValues__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1546:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1547:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1547:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1548:2: ()
            {
             before(grammarAccess.getManyOptionalValuesAccess().getManyValuesAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1549:2: ()
            // InternalPartialSerializationTestLanguage.g:1549:3: 
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
    // InternalPartialSerializationTestLanguage.g:1557:1: rule__ManyOptionalValues__Group__1 : rule__ManyOptionalValues__Group__1__Impl ;
    public final void rule__ManyOptionalValues__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1561:1: ( rule__ManyOptionalValues__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1562:2: rule__ManyOptionalValues__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1568:1: rule__ManyOptionalValues__Group__1__Impl : ( ( rule__ManyOptionalValues__NameAssignment_1 )* ) ;
    public final void rule__ManyOptionalValues__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1572:1: ( ( ( rule__ManyOptionalValues__NameAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1573:1: ( ( rule__ManyOptionalValues__NameAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1573:1: ( ( rule__ManyOptionalValues__NameAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:1574:2: ( rule__ManyOptionalValues__NameAssignment_1 )*
            {
             before(grammarAccess.getManyOptionalValuesAccess().getNameAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1575:2: ( rule__ManyOptionalValues__NameAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1575:3: rule__ManyOptionalValues__NameAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:1584:1: rule__OptionalChild__Group__0 : rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1 ;
    public final void rule__OptionalChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1588:1: ( rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1589:2: rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1596:1: rule__OptionalChild__Group__0__Impl : ( () ) ;
    public final void rule__OptionalChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1600:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1601:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1601:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1602:2: ()
            {
             before(grammarAccess.getOptionalChildAccess().getOptionalChildAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1603:2: ()
            // InternalPartialSerializationTestLanguage.g:1603:3: 
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
    // InternalPartialSerializationTestLanguage.g:1611:1: rule__OptionalChild__Group__1 : rule__OptionalChild__Group__1__Impl ;
    public final void rule__OptionalChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1615:1: ( rule__OptionalChild__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1616:2: rule__OptionalChild__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1622:1: rule__OptionalChild__Group__1__Impl : ( ( rule__OptionalChild__ChildAssignment_1 )? ) ;
    public final void rule__OptionalChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1626:1: ( ( ( rule__OptionalChild__ChildAssignment_1 )? ) )
            // InternalPartialSerializationTestLanguage.g:1627:1: ( ( rule__OptionalChild__ChildAssignment_1 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1627:1: ( ( rule__OptionalChild__ChildAssignment_1 )? )
            // InternalPartialSerializationTestLanguage.g:1628:2: ( rule__OptionalChild__ChildAssignment_1 )?
            {
             before(grammarAccess.getOptionalChildAccess().getChildAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1629:2: ( rule__OptionalChild__ChildAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1629:3: rule__OptionalChild__ChildAssignment_1
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


    // $ANTLR start "rule__TwoChildLists__Group__0"
    // InternalPartialSerializationTestLanguage.g:1638:1: rule__TwoChildLists__Group__0 : rule__TwoChildLists__Group__0__Impl rule__TwoChildLists__Group__1 ;
    public final void rule__TwoChildLists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1642:1: ( rule__TwoChildLists__Group__0__Impl rule__TwoChildLists__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1643:2: rule__TwoChildLists__Group__0__Impl rule__TwoChildLists__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__TwoChildLists__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__0"


    // $ANTLR start "rule__TwoChildLists__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1650:1: rule__TwoChildLists__Group__0__Impl : ( '{' ) ;
    public final void rule__TwoChildLists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1654:1: ( ( '{' ) )
            // InternalPartialSerializationTestLanguage.g:1655:1: ( '{' )
            {
            // InternalPartialSerializationTestLanguage.g:1655:1: ( '{' )
            // InternalPartialSerializationTestLanguage.g:1656:2: '{'
            {
             before(grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__0__Impl"


    // $ANTLR start "rule__TwoChildLists__Group__1"
    // InternalPartialSerializationTestLanguage.g:1665:1: rule__TwoChildLists__Group__1 : rule__TwoChildLists__Group__1__Impl rule__TwoChildLists__Group__2 ;
    public final void rule__TwoChildLists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1669:1: ( rule__TwoChildLists__Group__1__Impl rule__TwoChildLists__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1670:2: rule__TwoChildLists__Group__1__Impl rule__TwoChildLists__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__TwoChildLists__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__1"


    // $ANTLR start "rule__TwoChildLists__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1677:1: rule__TwoChildLists__Group__1__Impl : ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) ) ;
    public final void rule__TwoChildLists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1681:1: ( ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) ) )
            // InternalPartialSerializationTestLanguage.g:1682:1: ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:1682:1: ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1683:2: ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1683:2: ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) )
            // InternalPartialSerializationTestLanguage.g:1684:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )
            {
             before(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1685:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )
            // InternalPartialSerializationTestLanguage.g:1685:4: rule__TwoChildLists__DirectChildrenAssignment_1
            {
            pushFollow(FOLLOW_3);
            rule__TwoChildLists__DirectChildrenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1()); 

            }

            // InternalPartialSerializationTestLanguage.g:1688:2: ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:1689:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )*
            {
             before(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1690:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1690:4: rule__TwoChildLists__DirectChildrenAssignment_1
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__TwoChildLists__DirectChildrenAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1()); 

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
    // $ANTLR end "rule__TwoChildLists__Group__1__Impl"


    // $ANTLR start "rule__TwoChildLists__Group__2"
    // InternalPartialSerializationTestLanguage.g:1699:1: rule__TwoChildLists__Group__2 : rule__TwoChildLists__Group__2__Impl rule__TwoChildLists__Group__3 ;
    public final void rule__TwoChildLists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1703:1: ( rule__TwoChildLists__Group__2__Impl rule__TwoChildLists__Group__3 )
            // InternalPartialSerializationTestLanguage.g:1704:2: rule__TwoChildLists__Group__2__Impl rule__TwoChildLists__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__TwoChildLists__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__2"


    // $ANTLR start "rule__TwoChildLists__Group__2__Impl"
    // InternalPartialSerializationTestLanguage.g:1711:1: rule__TwoChildLists__Group__2__Impl : ( 'children1' ) ;
    public final void rule__TwoChildLists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1715:1: ( ( 'children1' ) )
            // InternalPartialSerializationTestLanguage.g:1716:1: ( 'children1' )
            {
            // InternalPartialSerializationTestLanguage.g:1716:1: ( 'children1' )
            // InternalPartialSerializationTestLanguage.g:1717:2: 'children1'
            {
             before(grammarAccess.getTwoChildListsAccess().getChildren1Keyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getTwoChildListsAccess().getChildren1Keyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__2__Impl"


    // $ANTLR start "rule__TwoChildLists__Group__3"
    // InternalPartialSerializationTestLanguage.g:1726:1: rule__TwoChildLists__Group__3 : rule__TwoChildLists__Group__3__Impl rule__TwoChildLists__Group__4 ;
    public final void rule__TwoChildLists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1730:1: ( rule__TwoChildLists__Group__3__Impl rule__TwoChildLists__Group__4 )
            // InternalPartialSerializationTestLanguage.g:1731:2: rule__TwoChildLists__Group__3__Impl rule__TwoChildLists__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__TwoChildLists__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__3"


    // $ANTLR start "rule__TwoChildLists__Group__3__Impl"
    // InternalPartialSerializationTestLanguage.g:1738:1: rule__TwoChildLists__Group__3__Impl : ( '{' ) ;
    public final void rule__TwoChildLists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1742:1: ( ( '{' ) )
            // InternalPartialSerializationTestLanguage.g:1743:1: ( '{' )
            {
            // InternalPartialSerializationTestLanguage.g:1743:1: ( '{' )
            // InternalPartialSerializationTestLanguage.g:1744:2: '{'
            {
             before(grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__3__Impl"


    // $ANTLR start "rule__TwoChildLists__Group__4"
    // InternalPartialSerializationTestLanguage.g:1753:1: rule__TwoChildLists__Group__4 : rule__TwoChildLists__Group__4__Impl rule__TwoChildLists__Group__5 ;
    public final void rule__TwoChildLists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1757:1: ( rule__TwoChildLists__Group__4__Impl rule__TwoChildLists__Group__5 )
            // InternalPartialSerializationTestLanguage.g:1758:2: rule__TwoChildLists__Group__4__Impl rule__TwoChildLists__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__TwoChildLists__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__4"


    // $ANTLR start "rule__TwoChildLists__Group__4__Impl"
    // InternalPartialSerializationTestLanguage.g:1765:1: rule__TwoChildLists__Group__4__Impl : ( ( rule__TwoChildLists__ChildsListAssignment_4 ) ) ;
    public final void rule__TwoChildLists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1769:1: ( ( ( rule__TwoChildLists__ChildsListAssignment_4 ) ) )
            // InternalPartialSerializationTestLanguage.g:1770:1: ( ( rule__TwoChildLists__ChildsListAssignment_4 ) )
            {
            // InternalPartialSerializationTestLanguage.g:1770:1: ( ( rule__TwoChildLists__ChildsListAssignment_4 ) )
            // InternalPartialSerializationTestLanguage.g:1771:2: ( rule__TwoChildLists__ChildsListAssignment_4 )
            {
             before(grammarAccess.getTwoChildListsAccess().getChildsListAssignment_4()); 
            // InternalPartialSerializationTestLanguage.g:1772:2: ( rule__TwoChildLists__ChildsListAssignment_4 )
            // InternalPartialSerializationTestLanguage.g:1772:3: rule__TwoChildLists__ChildsListAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TwoChildLists__ChildsListAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTwoChildListsAccess().getChildsListAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__4__Impl"


    // $ANTLR start "rule__TwoChildLists__Group__5"
    // InternalPartialSerializationTestLanguage.g:1780:1: rule__TwoChildLists__Group__5 : rule__TwoChildLists__Group__5__Impl rule__TwoChildLists__Group__6 ;
    public final void rule__TwoChildLists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1784:1: ( rule__TwoChildLists__Group__5__Impl rule__TwoChildLists__Group__6 )
            // InternalPartialSerializationTestLanguage.g:1785:2: rule__TwoChildLists__Group__5__Impl rule__TwoChildLists__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__TwoChildLists__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__5"


    // $ANTLR start "rule__TwoChildLists__Group__5__Impl"
    // InternalPartialSerializationTestLanguage.g:1792:1: rule__TwoChildLists__Group__5__Impl : ( '}' ) ;
    public final void rule__TwoChildLists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1796:1: ( ( '}' ) )
            // InternalPartialSerializationTestLanguage.g:1797:1: ( '}' )
            {
            // InternalPartialSerializationTestLanguage.g:1797:1: ( '}' )
            // InternalPartialSerializationTestLanguage.g:1798:2: '}'
            {
             before(grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__5__Impl"


    // $ANTLR start "rule__TwoChildLists__Group__6"
    // InternalPartialSerializationTestLanguage.g:1807:1: rule__TwoChildLists__Group__6 : rule__TwoChildLists__Group__6__Impl ;
    public final void rule__TwoChildLists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1811:1: ( rule__TwoChildLists__Group__6__Impl )
            // InternalPartialSerializationTestLanguage.g:1812:2: rule__TwoChildLists__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TwoChildLists__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__6"


    // $ANTLR start "rule__TwoChildLists__Group__6__Impl"
    // InternalPartialSerializationTestLanguage.g:1818:1: rule__TwoChildLists__Group__6__Impl : ( '}' ) ;
    public final void rule__TwoChildLists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1822:1: ( ( '}' ) )
            // InternalPartialSerializationTestLanguage.g:1823:1: ( '}' )
            {
            // InternalPartialSerializationTestLanguage.g:1823:1: ( '}' )
            // InternalPartialSerializationTestLanguage.g:1824:2: '}'
            {
             before(grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_6()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__Group__6__Impl"


    // $ANTLR start "rule__TwoChilds__Group__0"
    // InternalPartialSerializationTestLanguage.g:1834:1: rule__TwoChilds__Group__0 : rule__TwoChilds__Group__0__Impl rule__TwoChilds__Group__1 ;
    public final void rule__TwoChilds__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1838:1: ( rule__TwoChilds__Group__0__Impl rule__TwoChilds__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1839:2: rule__TwoChilds__Group__0__Impl rule__TwoChilds__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__TwoChilds__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__0"


    // $ANTLR start "rule__TwoChilds__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1846:1: rule__TwoChilds__Group__0__Impl : ( () ) ;
    public final void rule__TwoChilds__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1850:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1851:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1851:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1852:2: ()
            {
             before(grammarAccess.getTwoChildsAccess().getTwoChildsAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1853:2: ()
            // InternalPartialSerializationTestLanguage.g:1853:3: 
            {
            }

             after(grammarAccess.getTwoChildsAccess().getTwoChildsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__0__Impl"


    // $ANTLR start "rule__TwoChilds__Group__1"
    // InternalPartialSerializationTestLanguage.g:1861:1: rule__TwoChilds__Group__1 : rule__TwoChilds__Group__1__Impl rule__TwoChilds__Group__2 ;
    public final void rule__TwoChilds__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1865:1: ( rule__TwoChilds__Group__1__Impl rule__TwoChilds__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1866:2: rule__TwoChilds__Group__1__Impl rule__TwoChilds__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__TwoChilds__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__1"


    // $ANTLR start "rule__TwoChilds__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1873:1: rule__TwoChilds__Group__1__Impl : ( 'direct' ) ;
    public final void rule__TwoChilds__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1877:1: ( ( 'direct' ) )
            // InternalPartialSerializationTestLanguage.g:1878:1: ( 'direct' )
            {
            // InternalPartialSerializationTestLanguage.g:1878:1: ( 'direct' )
            // InternalPartialSerializationTestLanguage.g:1879:2: 'direct'
            {
             before(grammarAccess.getTwoChildsAccess().getDirectKeyword_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getTwoChildsAccess().getDirectKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__1__Impl"


    // $ANTLR start "rule__TwoChilds__Group__2"
    // InternalPartialSerializationTestLanguage.g:1888:1: rule__TwoChilds__Group__2 : rule__TwoChilds__Group__2__Impl rule__TwoChilds__Group__3 ;
    public final void rule__TwoChilds__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1892:1: ( rule__TwoChilds__Group__2__Impl rule__TwoChilds__Group__3 )
            // InternalPartialSerializationTestLanguage.g:1893:2: rule__TwoChilds__Group__2__Impl rule__TwoChilds__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__TwoChilds__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__2"


    // $ANTLR start "rule__TwoChilds__Group__2__Impl"
    // InternalPartialSerializationTestLanguage.g:1900:1: rule__TwoChilds__Group__2__Impl : ( ':' ) ;
    public final void rule__TwoChilds__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1904:1: ( ( ':' ) )
            // InternalPartialSerializationTestLanguage.g:1905:1: ( ':' )
            {
            // InternalPartialSerializationTestLanguage.g:1905:1: ( ':' )
            // InternalPartialSerializationTestLanguage.g:1906:2: ':'
            {
             before(grammarAccess.getTwoChildsAccess().getColonKeyword_2()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTwoChildsAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__2__Impl"


    // $ANTLR start "rule__TwoChilds__Group__3"
    // InternalPartialSerializationTestLanguage.g:1915:1: rule__TwoChilds__Group__3 : rule__TwoChilds__Group__3__Impl rule__TwoChilds__Group__4 ;
    public final void rule__TwoChilds__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1919:1: ( rule__TwoChilds__Group__3__Impl rule__TwoChilds__Group__4 )
            // InternalPartialSerializationTestLanguage.g:1920:2: rule__TwoChilds__Group__3__Impl rule__TwoChilds__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__TwoChilds__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__3"


    // $ANTLR start "rule__TwoChilds__Group__3__Impl"
    // InternalPartialSerializationTestLanguage.g:1927:1: rule__TwoChilds__Group__3__Impl : ( ( rule__TwoChilds__DirectChildAssignment_3 )? ) ;
    public final void rule__TwoChilds__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1931:1: ( ( ( rule__TwoChilds__DirectChildAssignment_3 )? ) )
            // InternalPartialSerializationTestLanguage.g:1932:1: ( ( rule__TwoChilds__DirectChildAssignment_3 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1932:1: ( ( rule__TwoChilds__DirectChildAssignment_3 )? )
            // InternalPartialSerializationTestLanguage.g:1933:2: ( rule__TwoChilds__DirectChildAssignment_3 )?
            {
             before(grammarAccess.getTwoChildsAccess().getDirectChildAssignment_3()); 
            // InternalPartialSerializationTestLanguage.g:1934:2: ( rule__TwoChilds__DirectChildAssignment_3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1934:3: rule__TwoChilds__DirectChildAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__TwoChilds__DirectChildAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTwoChildsAccess().getDirectChildAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__3__Impl"


    // $ANTLR start "rule__TwoChilds__Group__4"
    // InternalPartialSerializationTestLanguage.g:1942:1: rule__TwoChilds__Group__4 : rule__TwoChilds__Group__4__Impl rule__TwoChilds__Group__5 ;
    public final void rule__TwoChilds__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1946:1: ( rule__TwoChilds__Group__4__Impl rule__TwoChilds__Group__5 )
            // InternalPartialSerializationTestLanguage.g:1947:2: rule__TwoChilds__Group__4__Impl rule__TwoChilds__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__TwoChilds__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__4"


    // $ANTLR start "rule__TwoChilds__Group__4__Impl"
    // InternalPartialSerializationTestLanguage.g:1954:1: rule__TwoChilds__Group__4__Impl : ( 'child' ) ;
    public final void rule__TwoChilds__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1958:1: ( ( 'child' ) )
            // InternalPartialSerializationTestLanguage.g:1959:1: ( 'child' )
            {
            // InternalPartialSerializationTestLanguage.g:1959:1: ( 'child' )
            // InternalPartialSerializationTestLanguage.g:1960:2: 'child'
            {
             before(grammarAccess.getTwoChildsAccess().getChildKeyword_4()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getTwoChildsAccess().getChildKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__4__Impl"


    // $ANTLR start "rule__TwoChilds__Group__5"
    // InternalPartialSerializationTestLanguage.g:1969:1: rule__TwoChilds__Group__5 : rule__TwoChilds__Group__5__Impl rule__TwoChilds__Group__6 ;
    public final void rule__TwoChilds__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1973:1: ( rule__TwoChilds__Group__5__Impl rule__TwoChilds__Group__6 )
            // InternalPartialSerializationTestLanguage.g:1974:2: rule__TwoChilds__Group__5__Impl rule__TwoChilds__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__TwoChilds__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__5"


    // $ANTLR start "rule__TwoChilds__Group__5__Impl"
    // InternalPartialSerializationTestLanguage.g:1981:1: rule__TwoChilds__Group__5__Impl : ( ':' ) ;
    public final void rule__TwoChilds__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1985:1: ( ( ':' ) )
            // InternalPartialSerializationTestLanguage.g:1986:1: ( ':' )
            {
            // InternalPartialSerializationTestLanguage.g:1986:1: ( ':' )
            // InternalPartialSerializationTestLanguage.g:1987:2: ':'
            {
             before(grammarAccess.getTwoChildsAccess().getColonKeyword_5()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTwoChildsAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__5__Impl"


    // $ANTLR start "rule__TwoChilds__Group__6"
    // InternalPartialSerializationTestLanguage.g:1996:1: rule__TwoChilds__Group__6 : rule__TwoChilds__Group__6__Impl ;
    public final void rule__TwoChilds__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2000:1: ( rule__TwoChilds__Group__6__Impl )
            // InternalPartialSerializationTestLanguage.g:2001:2: rule__TwoChilds__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TwoChilds__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__6"


    // $ANTLR start "rule__TwoChilds__Group__6__Impl"
    // InternalPartialSerializationTestLanguage.g:2007:1: rule__TwoChilds__Group__6__Impl : ( ( rule__TwoChilds__OptChildAssignment_6 ) ) ;
    public final void rule__TwoChilds__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2011:1: ( ( ( rule__TwoChilds__OptChildAssignment_6 ) ) )
            // InternalPartialSerializationTestLanguage.g:2012:1: ( ( rule__TwoChilds__OptChildAssignment_6 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2012:1: ( ( rule__TwoChilds__OptChildAssignment_6 ) )
            // InternalPartialSerializationTestLanguage.g:2013:2: ( rule__TwoChilds__OptChildAssignment_6 )
            {
             before(grammarAccess.getTwoChildsAccess().getOptChildAssignment_6()); 
            // InternalPartialSerializationTestLanguage.g:2014:2: ( rule__TwoChilds__OptChildAssignment_6 )
            // InternalPartialSerializationTestLanguage.g:2014:3: rule__TwoChilds__OptChildAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__TwoChilds__OptChildAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTwoChildsAccess().getOptChildAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__Group__6__Impl"


    // $ANTLR start "rule__ChildWithSubChilds__Group__0"
    // InternalPartialSerializationTestLanguage.g:2023:1: rule__ChildWithSubChilds__Group__0 : rule__ChildWithSubChilds__Group__0__Impl rule__ChildWithSubChilds__Group__1 ;
    public final void rule__ChildWithSubChilds__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2027:1: ( rule__ChildWithSubChilds__Group__0__Impl rule__ChildWithSubChilds__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2028:2: rule__ChildWithSubChilds__Group__0__Impl rule__ChildWithSubChilds__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ChildWithSubChilds__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChildWithSubChilds__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChilds__Group__0"


    // $ANTLR start "rule__ChildWithSubChilds__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:2035:1: rule__ChildWithSubChilds__Group__0__Impl : ( () ) ;
    public final void rule__ChildWithSubChilds__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2039:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2040:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2040:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2041:2: ()
            {
             before(grammarAccess.getChildWithSubChildsAccess().getChildWithSubChildsAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2042:2: ()
            // InternalPartialSerializationTestLanguage.g:2042:3: 
            {
            }

             after(grammarAccess.getChildWithSubChildsAccess().getChildWithSubChildsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChilds__Group__0__Impl"


    // $ANTLR start "rule__ChildWithSubChilds__Group__1"
    // InternalPartialSerializationTestLanguage.g:2050:1: rule__ChildWithSubChilds__Group__1 : rule__ChildWithSubChilds__Group__1__Impl ;
    public final void rule__ChildWithSubChilds__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2054:1: ( rule__ChildWithSubChilds__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2055:2: rule__ChildWithSubChilds__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChildWithSubChilds__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChilds__Group__1"


    // $ANTLR start "rule__ChildWithSubChilds__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:2061:1: rule__ChildWithSubChilds__Group__1__Impl : ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* ) ;
    public final void rule__ChildWithSubChilds__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2065:1: ( ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2066:1: ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2066:1: ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:2067:2: ( rule__ChildWithSubChilds__ChildrenAssignment_1 )*
            {
             before(grammarAccess.getChildWithSubChildsAccess().getChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2068:2: ( rule__ChildWithSubChilds__ChildrenAssignment_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==34) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2068:3: rule__ChildWithSubChilds__ChildrenAssignment_1
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__ChildWithSubChilds__ChildrenAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getChildWithSubChildsAccess().getChildrenAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChilds__Group__1__Impl"


    // $ANTLR start "rule__ChildWithSubChild__Group__0"
    // InternalPartialSerializationTestLanguage.g:2077:1: rule__ChildWithSubChild__Group__0 : rule__ChildWithSubChild__Group__0__Impl rule__ChildWithSubChild__Group__1 ;
    public final void rule__ChildWithSubChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2081:1: ( rule__ChildWithSubChild__Group__0__Impl rule__ChildWithSubChild__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2082:2: rule__ChildWithSubChild__Group__0__Impl rule__ChildWithSubChild__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ChildWithSubChild__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChildWithSubChild__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChild__Group__0"


    // $ANTLR start "rule__ChildWithSubChild__Group__0__Impl"
    // InternalPartialSerializationTestLanguage.g:2089:1: rule__ChildWithSubChild__Group__0__Impl : ( () ) ;
    public final void rule__ChildWithSubChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2093:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2094:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2094:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2095:2: ()
            {
             before(grammarAccess.getChildWithSubChildAccess().getChildWithSubChildAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2096:2: ()
            // InternalPartialSerializationTestLanguage.g:2096:3: 
            {
            }

             after(grammarAccess.getChildWithSubChildAccess().getChildWithSubChildAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChild__Group__0__Impl"


    // $ANTLR start "rule__ChildWithSubChild__Group__1"
    // InternalPartialSerializationTestLanguage.g:2104:1: rule__ChildWithSubChild__Group__1 : rule__ChildWithSubChild__Group__1__Impl rule__ChildWithSubChild__Group__2 ;
    public final void rule__ChildWithSubChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2108:1: ( rule__ChildWithSubChild__Group__1__Impl rule__ChildWithSubChild__Group__2 )
            // InternalPartialSerializationTestLanguage.g:2109:2: rule__ChildWithSubChild__Group__1__Impl rule__ChildWithSubChild__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__ChildWithSubChild__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ChildWithSubChild__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChild__Group__1"


    // $ANTLR start "rule__ChildWithSubChild__Group__1__Impl"
    // InternalPartialSerializationTestLanguage.g:2116:1: rule__ChildWithSubChild__Group__1__Impl : ( 'subs' ) ;
    public final void rule__ChildWithSubChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2120:1: ( ( 'subs' ) )
            // InternalPartialSerializationTestLanguage.g:2121:1: ( 'subs' )
            {
            // InternalPartialSerializationTestLanguage.g:2121:1: ( 'subs' )
            // InternalPartialSerializationTestLanguage.g:2122:2: 'subs'
            {
             before(grammarAccess.getChildWithSubChildAccess().getSubsKeyword_1()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getChildWithSubChildAccess().getSubsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChild__Group__1__Impl"


    // $ANTLR start "rule__ChildWithSubChild__Group__2"
    // InternalPartialSerializationTestLanguage.g:2131:1: rule__ChildWithSubChild__Group__2 : rule__ChildWithSubChild__Group__2__Impl ;
    public final void rule__ChildWithSubChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2135:1: ( rule__ChildWithSubChild__Group__2__Impl )
            // InternalPartialSerializationTestLanguage.g:2136:2: rule__ChildWithSubChild__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ChildWithSubChild__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChild__Group__2"


    // $ANTLR start "rule__ChildWithSubChild__Group__2__Impl"
    // InternalPartialSerializationTestLanguage.g:2142:1: rule__ChildWithSubChild__Group__2__Impl : ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* ) ;
    public final void rule__ChildWithSubChild__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2146:1: ( ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* ) )
            // InternalPartialSerializationTestLanguage.g:2147:1: ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2147:1: ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* )
            // InternalPartialSerializationTestLanguage.g:2148:2: ( rule__ChildWithSubChild__SubChildsAssignment_2 )*
            {
             before(grammarAccess.getChildWithSubChildAccess().getSubChildsAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:2149:2: ( rule__ChildWithSubChild__SubChildsAssignment_2 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2149:3: rule__ChildWithSubChild__SubChildsAssignment_2
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__ChildWithSubChild__SubChildsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getChildWithSubChildAccess().getSubChildsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChild__Group__2__Impl"


    // $ANTLR start "rule__OptionalChildList__Group__0"
    // InternalPartialSerializationTestLanguage.g:2158:1: rule__OptionalChildList__Group__0 : rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1 ;
    public final void rule__OptionalChildList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2162:1: ( rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2163:2: rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2170:1: rule__OptionalChildList__Group__0__Impl : ( () ) ;
    public final void rule__OptionalChildList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2174:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2175:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2175:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2176:2: ()
            {
             before(grammarAccess.getOptionalChildListAccess().getOptionalChildListAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2177:2: ()
            // InternalPartialSerializationTestLanguage.g:2177:3: 
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
    // InternalPartialSerializationTestLanguage.g:2185:1: rule__OptionalChildList__Group__1 : rule__OptionalChildList__Group__1__Impl ;
    public final void rule__OptionalChildList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2189:1: ( rule__OptionalChildList__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2190:2: rule__OptionalChildList__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2196:1: rule__OptionalChildList__Group__1__Impl : ( ( rule__OptionalChildList__ChildrenAssignment_1 )* ) ;
    public final void rule__OptionalChildList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2200:1: ( ( ( rule__OptionalChildList__ChildrenAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2201:1: ( ( rule__OptionalChildList__ChildrenAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2201:1: ( ( rule__OptionalChildList__ChildrenAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:2202:2: ( rule__OptionalChildList__ChildrenAssignment_1 )*
            {
             before(grammarAccess.getOptionalChildListAccess().getChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2203:2: ( rule__OptionalChildList__ChildrenAssignment_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2203:3: rule__OptionalChildList__ChildrenAssignment_1
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__OptionalChildList__ChildrenAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalPartialSerializationTestLanguage.g:2212:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2216:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2217:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2224:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2228:1: ( ( 'import' ) )
            // InternalPartialSerializationTestLanguage.g:2229:1: ( 'import' )
            {
            // InternalPartialSerializationTestLanguage.g:2229:1: ( 'import' )
            // InternalPartialSerializationTestLanguage.g:2230:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,35,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2239:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2243:1: ( rule__Import__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2244:2: rule__Import__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2250:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2254:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalPartialSerializationTestLanguage.g:2255:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2255:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalPartialSerializationTestLanguage.g:2256:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2257:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalPartialSerializationTestLanguage.g:2257:3: rule__Import__ImportedNamespaceAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:2266:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2270:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2271:2: rule__Node__Group__0__Impl rule__Node__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2278:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2282:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2283:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2283:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2284:2: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2285:2: ()
            // InternalPartialSerializationTestLanguage.g:2285:3: 
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
    // InternalPartialSerializationTestLanguage.g:2293:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2297:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalPartialSerializationTestLanguage.g:2298:2: rule__Node__Group__1__Impl rule__Node__Group__2
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
    // InternalPartialSerializationTestLanguage.g:2305:1: rule__Node__Group__1__Impl : ( ( rule__Node__ImportsAssignment_1 )* ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2309:1: ( ( ( rule__Node__ImportsAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2310:1: ( ( rule__Node__ImportsAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2310:1: ( ( rule__Node__ImportsAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:2311:2: ( rule__Node__ImportsAssignment_1 )*
            {
             before(grammarAccess.getNodeAccess().getImportsAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2312:2: ( rule__Node__ImportsAssignment_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==35) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2312:3: rule__Node__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Node__ImportsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalPartialSerializationTestLanguage.g:2320:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2324:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalPartialSerializationTestLanguage.g:2325:2: rule__Node__Group__2__Impl rule__Node__Group__3
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
    // InternalPartialSerializationTestLanguage.g:2332:1: rule__Node__Group__2__Impl : ( ( rule__Node__NameAssignment_2 )? ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2336:1: ( ( ( rule__Node__NameAssignment_2 )? ) )
            // InternalPartialSerializationTestLanguage.g:2337:1: ( ( rule__Node__NameAssignment_2 )? )
            {
            // InternalPartialSerializationTestLanguage.g:2337:1: ( ( rule__Node__NameAssignment_2 )? )
            // InternalPartialSerializationTestLanguage.g:2338:2: ( rule__Node__NameAssignment_2 )?
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:2339:2: ( rule__Node__NameAssignment_2 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:2339:3: rule__Node__NameAssignment_2
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
    // InternalPartialSerializationTestLanguage.g:2347:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2351:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalPartialSerializationTestLanguage.g:2352:2: rule__Node__Group__3__Impl rule__Node__Group__4
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
    // InternalPartialSerializationTestLanguage.g:2359:1: rule__Node__Group__3__Impl : ( ( rule__Node__Group_3__0 )? ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2363:1: ( ( ( rule__Node__Group_3__0 )? ) )
            // InternalPartialSerializationTestLanguage.g:2364:1: ( ( rule__Node__Group_3__0 )? )
            {
            // InternalPartialSerializationTestLanguage.g:2364:1: ( ( rule__Node__Group_3__0 )? )
            // InternalPartialSerializationTestLanguage.g:2365:2: ( rule__Node__Group_3__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_3()); 
            // InternalPartialSerializationTestLanguage.g:2366:2: ( rule__Node__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:2366:3: rule__Node__Group_3__0
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
    // InternalPartialSerializationTestLanguage.g:2374:1: rule__Node__Group__4 : rule__Node__Group__4__Impl ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2378:1: ( rule__Node__Group__4__Impl )
            // InternalPartialSerializationTestLanguage.g:2379:2: rule__Node__Group__4__Impl
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
    // InternalPartialSerializationTestLanguage.g:2385:1: rule__Node__Group__4__Impl : ( ( rule__Node__Alternatives_4 ) ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2389:1: ( ( ( rule__Node__Alternatives_4 ) ) )
            // InternalPartialSerializationTestLanguage.g:2390:1: ( ( rule__Node__Alternatives_4 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2390:1: ( ( rule__Node__Alternatives_4 ) )
            // InternalPartialSerializationTestLanguage.g:2391:2: ( rule__Node__Alternatives_4 )
            {
             before(grammarAccess.getNodeAccess().getAlternatives_4()); 
            // InternalPartialSerializationTestLanguage.g:2392:2: ( rule__Node__Alternatives_4 )
            // InternalPartialSerializationTestLanguage.g:2392:3: rule__Node__Alternatives_4
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
    // InternalPartialSerializationTestLanguage.g:2401:1: rule__Node__Group_3__0 : rule__Node__Group_3__0__Impl rule__Node__Group_3__1 ;
    public final void rule__Node__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2405:1: ( rule__Node__Group_3__0__Impl rule__Node__Group_3__1 )
            // InternalPartialSerializationTestLanguage.g:2406:2: rule__Node__Group_3__0__Impl rule__Node__Group_3__1
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
    // InternalPartialSerializationTestLanguage.g:2413:1: rule__Node__Group_3__0__Impl : ( 'refs' ) ;
    public final void rule__Node__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2417:1: ( ( 'refs' ) )
            // InternalPartialSerializationTestLanguage.g:2418:1: ( 'refs' )
            {
            // InternalPartialSerializationTestLanguage.g:2418:1: ( 'refs' )
            // InternalPartialSerializationTestLanguage.g:2419:2: 'refs'
            {
             before(grammarAccess.getNodeAccess().getRefsKeyword_3_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2428:1: rule__Node__Group_3__1 : rule__Node__Group_3__1__Impl ;
    public final void rule__Node__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2432:1: ( rule__Node__Group_3__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2433:2: rule__Node__Group_3__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2439:1: rule__Node__Group_3__1__Impl : ( ( rule__Node__RefsAssignment_3_1 )* ) ;
    public final void rule__Node__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2443:1: ( ( ( rule__Node__RefsAssignment_3_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2444:1: ( ( rule__Node__RefsAssignment_3_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2444:1: ( ( rule__Node__RefsAssignment_3_1 )* )
            // InternalPartialSerializationTestLanguage.g:2445:2: ( rule__Node__RefsAssignment_3_1 )*
            {
             before(grammarAccess.getNodeAccess().getRefsAssignment_3_1()); 
            // InternalPartialSerializationTestLanguage.g:2446:2: ( rule__Node__RefsAssignment_3_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2446:3: rule__Node__RefsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Node__RefsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalPartialSerializationTestLanguage.g:2455:1: rule__Node__Group_4_0__0 : rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1 ;
    public final void rule__Node__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2459:1: ( rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1 )
            // InternalPartialSerializationTestLanguage.g:2460:2: rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalPartialSerializationTestLanguage.g:2467:1: rule__Node__Group_4_0__0__Impl : ( '{' ) ;
    public final void rule__Node__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2471:1: ( ( '{' ) )
            // InternalPartialSerializationTestLanguage.g:2472:1: ( '{' )
            {
            // InternalPartialSerializationTestLanguage.g:2472:1: ( '{' )
            // InternalPartialSerializationTestLanguage.g:2473:2: '{'
            {
             before(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2482:1: rule__Node__Group_4_0__1 : rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2 ;
    public final void rule__Node__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2486:1: ( rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2 )
            // InternalPartialSerializationTestLanguage.g:2487:2: rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2
            {
            pushFollow(FOLLOW_16);
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
    // InternalPartialSerializationTestLanguage.g:2494:1: rule__Node__Group_4_0__1__Impl : ( ( rule__Node__ChildrenAssignment_4_0_1 )* ) ;
    public final void rule__Node__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2498:1: ( ( ( rule__Node__ChildrenAssignment_4_0_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2499:1: ( ( rule__Node__ChildrenAssignment_4_0_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2499:1: ( ( rule__Node__ChildrenAssignment_4_0_1 )* )
            // InternalPartialSerializationTestLanguage.g:2500:2: ( rule__Node__ChildrenAssignment_4_0_1 )*
            {
             before(grammarAccess.getNodeAccess().getChildrenAssignment_4_0_1()); 
            // InternalPartialSerializationTestLanguage.g:2501:2: ( rule__Node__ChildrenAssignment_4_0_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID||LA20_0==11||LA20_0==28||(LA20_0>=35 && LA20_0<=36)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2501:3: rule__Node__ChildrenAssignment_4_0_1
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Node__ChildrenAssignment_4_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalPartialSerializationTestLanguage.g:2509:1: rule__Node__Group_4_0__2 : rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3 ;
    public final void rule__Node__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2513:1: ( rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3 )
            // InternalPartialSerializationTestLanguage.g:2514:2: rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3
            {
            pushFollow(FOLLOW_16);
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
    // InternalPartialSerializationTestLanguage.g:2521:1: rule__Node__Group_4_0__2__Impl : ( ( rule__Node__Group_4_0_2__0 )? ) ;
    public final void rule__Node__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2525:1: ( ( ( rule__Node__Group_4_0_2__0 )? ) )
            // InternalPartialSerializationTestLanguage.g:2526:1: ( ( rule__Node__Group_4_0_2__0 )? )
            {
            // InternalPartialSerializationTestLanguage.g:2526:1: ( ( rule__Node__Group_4_0_2__0 )? )
            // InternalPartialSerializationTestLanguage.g:2527:2: ( rule__Node__Group_4_0_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_4_0_2()); 
            // InternalPartialSerializationTestLanguage.g:2528:2: ( rule__Node__Group_4_0_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==37) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:2528:3: rule__Node__Group_4_0_2__0
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
    // InternalPartialSerializationTestLanguage.g:2536:1: rule__Node__Group_4_0__3 : rule__Node__Group_4_0__3__Impl ;
    public final void rule__Node__Group_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2540:1: ( rule__Node__Group_4_0__3__Impl )
            // InternalPartialSerializationTestLanguage.g:2541:2: rule__Node__Group_4_0__3__Impl
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
    // InternalPartialSerializationTestLanguage.g:2547:1: rule__Node__Group_4_0__3__Impl : ( '}' ) ;
    public final void rule__Node__Group_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2551:1: ( ( '}' ) )
            // InternalPartialSerializationTestLanguage.g:2552:1: ( '}' )
            {
            // InternalPartialSerializationTestLanguage.g:2552:1: ( '}' )
            // InternalPartialSerializationTestLanguage.g:2553:2: '}'
            {
             before(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_4_0_3()); 
            match(input,30,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2563:1: rule__Node__Group_4_0_2__0 : rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1 ;
    public final void rule__Node__Group_4_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2567:1: ( rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1 )
            // InternalPartialSerializationTestLanguage.g:2568:2: rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1
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
    // InternalPartialSerializationTestLanguage.g:2575:1: rule__Node__Group_4_0_2__0__Impl : ( 'ref' ) ;
    public final void rule__Node__Group_4_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2579:1: ( ( 'ref' ) )
            // InternalPartialSerializationTestLanguage.g:2580:1: ( 'ref' )
            {
            // InternalPartialSerializationTestLanguage.g:2580:1: ( 'ref' )
            // InternalPartialSerializationTestLanguage.g:2581:2: 'ref'
            {
             before(grammarAccess.getNodeAccess().getRefKeyword_4_0_2_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2590:1: rule__Node__Group_4_0_2__1 : rule__Node__Group_4_0_2__1__Impl ;
    public final void rule__Node__Group_4_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2594:1: ( rule__Node__Group_4_0_2__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2595:2: rule__Node__Group_4_0_2__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2601:1: rule__Node__Group_4_0_2__1__Impl : ( ( rule__Node__RefAssignment_4_0_2_1 ) ) ;
    public final void rule__Node__Group_4_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2605:1: ( ( ( rule__Node__RefAssignment_4_0_2_1 ) ) )
            // InternalPartialSerializationTestLanguage.g:2606:1: ( ( rule__Node__RefAssignment_4_0_2_1 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2606:1: ( ( rule__Node__RefAssignment_4_0_2_1 ) )
            // InternalPartialSerializationTestLanguage.g:2607:2: ( rule__Node__RefAssignment_4_0_2_1 )
            {
             before(grammarAccess.getNodeAccess().getRefAssignment_4_0_2_1()); 
            // InternalPartialSerializationTestLanguage.g:2608:2: ( rule__Node__RefAssignment_4_0_2_1 )
            // InternalPartialSerializationTestLanguage.g:2608:3: rule__Node__RefAssignment_4_0_2_1
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
    // InternalPartialSerializationTestLanguage.g:2617:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2621:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2622:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalPartialSerializationTestLanguage.g:2629:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2633:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2634:1: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2634:1: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2635:2: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2644:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2648:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2649:2: rule__QualifiedName__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2655:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2659:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalPartialSerializationTestLanguage.g:2660:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2660:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalPartialSerializationTestLanguage.g:2661:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalPartialSerializationTestLanguage.g:2662:2: ( rule__QualifiedName__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==38) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2662:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalPartialSerializationTestLanguage.g:2671:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2675:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalPartialSerializationTestLanguage.g:2676:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalPartialSerializationTestLanguage.g:2683:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2687:1: ( ( '.' ) )
            // InternalPartialSerializationTestLanguage.g:2688:1: ( '.' )
            {
            // InternalPartialSerializationTestLanguage.g:2688:1: ( '.' )
            // InternalPartialSerializationTestLanguage.g:2689:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2698:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2702:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2703:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2709:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2713:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2714:1: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2714:1: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2715:2: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2725:1: rule__Model__ClazzAssignment_9_1 : ( ruleEClassDecl ) ;
    public final void rule__Model__ClazzAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2729:1: ( ( ruleEClassDecl ) )
            // InternalPartialSerializationTestLanguage.g:2730:2: ( ruleEClassDecl )
            {
            // InternalPartialSerializationTestLanguage.g:2730:2: ( ruleEClassDecl )
            // InternalPartialSerializationTestLanguage.g:2731:3: ruleEClassDecl
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
    // InternalPartialSerializationTestLanguage.g:2740:1: rule__MandatoryValue__NameAssignment : ( RULE_ID ) ;
    public final void rule__MandatoryValue__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2744:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2745:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2745:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2746:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2755:1: rule__OptionalValue__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OptionalValue__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2759:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2760:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2760:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2761:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2770:1: rule__ManyOptionalValues__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ManyOptionalValues__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2774:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2775:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2775:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2776:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2785:1: rule__ManyMandatoryValues__NameAssignment : ( RULE_ID ) ;
    public final void rule__ManyMandatoryValues__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2789:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2790:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2790:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2791:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2800:1: rule__MandatoryChild__ChildAssignment : ( ruleMandatoryValue ) ;
    public final void rule__MandatoryChild__ChildAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2804:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2805:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2805:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2806:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:2815:1: rule__OptionalChild__ChildAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__OptionalChild__ChildAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2819:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2820:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2820:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2821:3: ruleMandatoryValue
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


    // $ANTLR start "rule__TwoChildLists__DirectChildrenAssignment_1"
    // InternalPartialSerializationTestLanguage.g:2830:1: rule__TwoChildLists__DirectChildrenAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__TwoChildLists__DirectChildrenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2834:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2835:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2835:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2836:3: ruleMandatoryValue
            {
             before(grammarAccess.getTwoChildListsAccess().getDirectChildrenMandatoryValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getTwoChildListsAccess().getDirectChildrenMandatoryValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__DirectChildrenAssignment_1"


    // $ANTLR start "rule__TwoChildLists__ChildsListAssignment_4"
    // InternalPartialSerializationTestLanguage.g:2845:1: rule__TwoChildLists__ChildsListAssignment_4 : ( ruleMandatoryChildList ) ;
    public final void rule__TwoChildLists__ChildsListAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2849:1: ( ( ruleMandatoryChildList ) )
            // InternalPartialSerializationTestLanguage.g:2850:2: ( ruleMandatoryChildList )
            {
            // InternalPartialSerializationTestLanguage.g:2850:2: ( ruleMandatoryChildList )
            // InternalPartialSerializationTestLanguage.g:2851:3: ruleMandatoryChildList
            {
             before(grammarAccess.getTwoChildListsAccess().getChildsListMandatoryChildListParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryChildList();

            state._fsp--;

             after(grammarAccess.getTwoChildListsAccess().getChildsListMandatoryChildListParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChildLists__ChildsListAssignment_4"


    // $ANTLR start "rule__TwoChilds__DirectChildAssignment_3"
    // InternalPartialSerializationTestLanguage.g:2860:1: rule__TwoChilds__DirectChildAssignment_3 : ( ruleMandatoryValue ) ;
    public final void rule__TwoChilds__DirectChildAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2864:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2865:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2865:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2866:3: ruleMandatoryValue
            {
             before(grammarAccess.getTwoChildsAccess().getDirectChildMandatoryValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMandatoryValue();

            state._fsp--;

             after(grammarAccess.getTwoChildsAccess().getDirectChildMandatoryValueParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__DirectChildAssignment_3"


    // $ANTLR start "rule__TwoChilds__OptChildAssignment_6"
    // InternalPartialSerializationTestLanguage.g:2875:1: rule__TwoChilds__OptChildAssignment_6 : ( ruleOptionalChild ) ;
    public final void rule__TwoChilds__OptChildAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2879:1: ( ( ruleOptionalChild ) )
            // InternalPartialSerializationTestLanguage.g:2880:2: ( ruleOptionalChild )
            {
            // InternalPartialSerializationTestLanguage.g:2880:2: ( ruleOptionalChild )
            // InternalPartialSerializationTestLanguage.g:2881:3: ruleOptionalChild
            {
             before(grammarAccess.getTwoChildsAccess().getOptChildOptionalChildParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleOptionalChild();

            state._fsp--;

             after(grammarAccess.getTwoChildsAccess().getOptChildOptionalChildParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TwoChilds__OptChildAssignment_6"


    // $ANTLR start "rule__ChildWithSubChilds__ChildrenAssignment_1"
    // InternalPartialSerializationTestLanguage.g:2890:1: rule__ChildWithSubChilds__ChildrenAssignment_1 : ( ruleChildWithSubChild ) ;
    public final void rule__ChildWithSubChilds__ChildrenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2894:1: ( ( ruleChildWithSubChild ) )
            // InternalPartialSerializationTestLanguage.g:2895:2: ( ruleChildWithSubChild )
            {
            // InternalPartialSerializationTestLanguage.g:2895:2: ( ruleChildWithSubChild )
            // InternalPartialSerializationTestLanguage.g:2896:3: ruleChildWithSubChild
            {
             before(grammarAccess.getChildWithSubChildsAccess().getChildrenChildWithSubChildParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleChildWithSubChild();

            state._fsp--;

             after(grammarAccess.getChildWithSubChildsAccess().getChildrenChildWithSubChildParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChilds__ChildrenAssignment_1"


    // $ANTLR start "rule__ChildWithSubChild__SubChildsAssignment_2"
    // InternalPartialSerializationTestLanguage.g:2905:1: rule__ChildWithSubChild__SubChildsAssignment_2 : ( ruleSubChild ) ;
    public final void rule__ChildWithSubChild__SubChildsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2909:1: ( ( ruleSubChild ) )
            // InternalPartialSerializationTestLanguage.g:2910:2: ( ruleSubChild )
            {
            // InternalPartialSerializationTestLanguage.g:2910:2: ( ruleSubChild )
            // InternalPartialSerializationTestLanguage.g:2911:3: ruleSubChild
            {
             before(grammarAccess.getChildWithSubChildAccess().getSubChildsSubChildParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSubChild();

            state._fsp--;

             after(grammarAccess.getChildWithSubChildAccess().getSubChildsSubChildParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ChildWithSubChild__SubChildsAssignment_2"


    // $ANTLR start "rule__SubChild__NameAssignment"
    // InternalPartialSerializationTestLanguage.g:2920:1: rule__SubChild__NameAssignment : ( RULE_ID ) ;
    public final void rule__SubChild__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2924:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2925:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2925:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2926:3: RULE_ID
            {
             before(grammarAccess.getSubChildAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSubChildAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SubChild__NameAssignment"


    // $ANTLR start "rule__MandatoryChildList__ChildrenAssignment"
    // InternalPartialSerializationTestLanguage.g:2935:1: rule__MandatoryChildList__ChildrenAssignment : ( ruleMandatoryValue ) ;
    public final void rule__MandatoryChildList__ChildrenAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2939:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2940:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2940:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2941:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:2950:1: rule__OptionalChildList__ChildrenAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__OptionalChildList__ChildrenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2954:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2955:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2955:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2956:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:2965:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2969:1: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:2970:2: ( ruleQualifiedName )
            {
            // InternalPartialSerializationTestLanguage.g:2970:2: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:2971:3: ruleQualifiedName
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
    // InternalPartialSerializationTestLanguage.g:2980:1: rule__Node__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Node__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2984:1: ( ( ruleImport ) )
            // InternalPartialSerializationTestLanguage.g:2985:2: ( ruleImport )
            {
            // InternalPartialSerializationTestLanguage.g:2985:2: ( ruleImport )
            // InternalPartialSerializationTestLanguage.g:2986:3: ruleImport
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
    // InternalPartialSerializationTestLanguage.g:2995:1: rule__Node__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Node__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2999:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:3000:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:3000:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:3001:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:3010:1: rule__Node__RefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Node__RefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3014:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:3015:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:3015:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:3016:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getNodeAccess().getRefsNodeCrossReference_3_1_0()); 
            // InternalPartialSerializationTestLanguage.g:3017:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:3018:4: ruleQualifiedName
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
    // InternalPartialSerializationTestLanguage.g:3029:1: rule__Node__ChildrenAssignment_4_0_1 : ( ruleNode ) ;
    public final void rule__Node__ChildrenAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3033:1: ( ( ruleNode ) )
            // InternalPartialSerializationTestLanguage.g:3034:2: ( ruleNode )
            {
            // InternalPartialSerializationTestLanguage.g:3034:2: ( ruleNode )
            // InternalPartialSerializationTestLanguage.g:3035:3: ruleNode
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
    // InternalPartialSerializationTestLanguage.g:3044:1: rule__Node__RefAssignment_4_0_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Node__RefAssignment_4_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3048:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:3049:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:3049:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:3050:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getNodeAccess().getRefNodeCrossReference_4_0_2_1_0()); 
            // InternalPartialSerializationTestLanguage.g:3051:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:3052:4: ruleQualifiedName
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
    // InternalPartialSerializationTestLanguage.g:3063:1: rule__EClassDecl__NameAssignment : ( RULE_ID ) ;
    public final void rule__EClassDecl__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3067:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:3068:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:3068:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:3069:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:3078:1: rule__EClassRef__RefAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__EClassRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3082:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:3083:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:3083:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:3084:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getEClassRefAccess().getRefEClassCrossReference_0()); 
            // InternalPartialSerializationTestLanguage.g:3085:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:3086:4: ruleQualifiedName
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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000001810000810L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000C000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000003850000810L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000001810000812L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000004000000002L});

}