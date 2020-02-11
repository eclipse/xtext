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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "';'", "'#1'", "'#2'", "'#3'", "'#4'", "'#5'", "'#10'", "'#11'", "'#12'", "'#13'", "'#20'", "'#21'", "'#22'", "'#23'", "'#24'", "'#30'", "'kw1'", "'kw2'", "'{'", "'children1'", "'}'", "'direct'", "':'", "'child'", "'subs'", "'import'", "'refs'", "'ref'", "'.'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
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
    // InternalPartialSerializationTestLanguage.g:58:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:59:1: ( ruleModel EOF )
            // InternalPartialSerializationTestLanguage.g:60:1: ruleModel EOF
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
    // InternalPartialSerializationTestLanguage.g:67:1: ruleModel : ( ( rule__Model__Alternatives ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:71:2: ( ( ( rule__Model__Alternatives ) ) )
            // InternalPartialSerializationTestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            {
            // InternalPartialSerializationTestLanguage.g:72:2: ( ( rule__Model__Alternatives ) )
            // InternalPartialSerializationTestLanguage.g:73:3: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalPartialSerializationTestLanguage.g:74:3: ( rule__Model__Alternatives )
            // InternalPartialSerializationTestLanguage.g:74:4: rule__Model__Alternatives
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
    // InternalPartialSerializationTestLanguage.g:83:1: entryRuleMandatoryValue : ruleMandatoryValue EOF ;
    public final void entryRuleMandatoryValue() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:84:1: ( ruleMandatoryValue EOF )
            // InternalPartialSerializationTestLanguage.g:85:1: ruleMandatoryValue EOF
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
    // InternalPartialSerializationTestLanguage.g:92:1: ruleMandatoryValue : ( ( rule__MandatoryValue__NameAssignment ) ) ;
    public final void ruleMandatoryValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:96:2: ( ( ( rule__MandatoryValue__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:97:2: ( ( rule__MandatoryValue__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:97:2: ( ( rule__MandatoryValue__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:98:3: ( rule__MandatoryValue__NameAssignment )
            {
             before(grammarAccess.getMandatoryValueAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:99:3: ( rule__MandatoryValue__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:99:4: rule__MandatoryValue__NameAssignment
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
    // InternalPartialSerializationTestLanguage.g:108:1: entryRuleOptionalValue : ruleOptionalValue EOF ;
    public final void entryRuleOptionalValue() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:109:1: ( ruleOptionalValue EOF )
            // InternalPartialSerializationTestLanguage.g:110:1: ruleOptionalValue EOF
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
    // InternalPartialSerializationTestLanguage.g:117:1: ruleOptionalValue : ( ( rule__OptionalValue__Group__0 ) ) ;
    public final void ruleOptionalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:121:2: ( ( ( rule__OptionalValue__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:122:2: ( ( rule__OptionalValue__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:122:2: ( ( rule__OptionalValue__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:123:3: ( rule__OptionalValue__Group__0 )
            {
             before(grammarAccess.getOptionalValueAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:124:3: ( rule__OptionalValue__Group__0 )
            // InternalPartialSerializationTestLanguage.g:124:4: rule__OptionalValue__Group__0
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
    // InternalPartialSerializationTestLanguage.g:133:1: entryRuleManyOptionalValues : ruleManyOptionalValues EOF ;
    public final void entryRuleManyOptionalValues() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:134:1: ( ruleManyOptionalValues EOF )
            // InternalPartialSerializationTestLanguage.g:135:1: ruleManyOptionalValues EOF
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
    // InternalPartialSerializationTestLanguage.g:142:1: ruleManyOptionalValues : ( ( rule__ManyOptionalValues__Group__0 ) ) ;
    public final void ruleManyOptionalValues() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:146:2: ( ( ( rule__ManyOptionalValues__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:147:2: ( ( rule__ManyOptionalValues__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:147:2: ( ( rule__ManyOptionalValues__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:148:3: ( rule__ManyOptionalValues__Group__0 )
            {
             before(grammarAccess.getManyOptionalValuesAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:149:3: ( rule__ManyOptionalValues__Group__0 )
            // InternalPartialSerializationTestLanguage.g:149:4: rule__ManyOptionalValues__Group__0
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
    // InternalPartialSerializationTestLanguage.g:158:1: entryRuleManyMandatoryValues : ruleManyMandatoryValues EOF ;
    public final void entryRuleManyMandatoryValues() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:159:1: ( ruleManyMandatoryValues EOF )
            // InternalPartialSerializationTestLanguage.g:160:1: ruleManyMandatoryValues EOF
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
    // InternalPartialSerializationTestLanguage.g:167:1: ruleManyMandatoryValues : ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) ) ;
    public final void ruleManyMandatoryValues() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:171:2: ( ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) ) )
            // InternalPartialSerializationTestLanguage.g:172:2: ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:172:2: ( ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* ) )
            // InternalPartialSerializationTestLanguage.g:173:3: ( ( rule__ManyMandatoryValues__NameAssignment ) ) ( ( rule__ManyMandatoryValues__NameAssignment )* )
            {
            // InternalPartialSerializationTestLanguage.g:173:3: ( ( rule__ManyMandatoryValues__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:174:4: ( rule__ManyMandatoryValues__NameAssignment )
            {
             before(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:175:4: ( rule__ManyMandatoryValues__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:175:5: rule__ManyMandatoryValues__NameAssignment
            {
            pushFollow(FOLLOW_3);
            rule__ManyMandatoryValues__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment()); 

            }

            // InternalPartialSerializationTestLanguage.g:178:3: ( ( rule__ManyMandatoryValues__NameAssignment )* )
            // InternalPartialSerializationTestLanguage.g:179:4: ( rule__ManyMandatoryValues__NameAssignment )*
            {
             before(grammarAccess.getManyMandatoryValuesAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:180:4: ( rule__ManyMandatoryValues__NameAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:180:5: rule__ManyMandatoryValues__NameAssignment
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
    // InternalPartialSerializationTestLanguage.g:190:1: entryRuleMandatoryChild : ruleMandatoryChild EOF ;
    public final void entryRuleMandatoryChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:191:1: ( ruleMandatoryChild EOF )
            // InternalPartialSerializationTestLanguage.g:192:1: ruleMandatoryChild EOF
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
    // InternalPartialSerializationTestLanguage.g:199:1: ruleMandatoryChild : ( ( rule__MandatoryChild__ChildAssignment ) ) ;
    public final void ruleMandatoryChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:203:2: ( ( ( rule__MandatoryChild__ChildAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:204:2: ( ( rule__MandatoryChild__ChildAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:204:2: ( ( rule__MandatoryChild__ChildAssignment ) )
            // InternalPartialSerializationTestLanguage.g:205:3: ( rule__MandatoryChild__ChildAssignment )
            {
             before(grammarAccess.getMandatoryChildAccess().getChildAssignment()); 
            // InternalPartialSerializationTestLanguage.g:206:3: ( rule__MandatoryChild__ChildAssignment )
            // InternalPartialSerializationTestLanguage.g:206:4: rule__MandatoryChild__ChildAssignment
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
    // InternalPartialSerializationTestLanguage.g:215:1: entryRuleOptionalChild : ruleOptionalChild EOF ;
    public final void entryRuleOptionalChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:216:1: ( ruleOptionalChild EOF )
            // InternalPartialSerializationTestLanguage.g:217:1: ruleOptionalChild EOF
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
    // InternalPartialSerializationTestLanguage.g:224:1: ruleOptionalChild : ( ( rule__OptionalChild__Group__0 ) ) ;
    public final void ruleOptionalChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:228:2: ( ( ( rule__OptionalChild__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:229:2: ( ( rule__OptionalChild__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:229:2: ( ( rule__OptionalChild__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:230:3: ( rule__OptionalChild__Group__0 )
            {
             before(grammarAccess.getOptionalChildAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:231:3: ( rule__OptionalChild__Group__0 )
            // InternalPartialSerializationTestLanguage.g:231:4: rule__OptionalChild__Group__0
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
    // InternalPartialSerializationTestLanguage.g:240:1: entryRuleTwoChildLists : ruleTwoChildLists EOF ;
    public final void entryRuleTwoChildLists() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:241:1: ( ruleTwoChildLists EOF )
            // InternalPartialSerializationTestLanguage.g:242:1: ruleTwoChildLists EOF
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
    // InternalPartialSerializationTestLanguage.g:249:1: ruleTwoChildLists : ( ( rule__TwoChildLists__Group__0 ) ) ;
    public final void ruleTwoChildLists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:253:2: ( ( ( rule__TwoChildLists__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:254:2: ( ( rule__TwoChildLists__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:254:2: ( ( rule__TwoChildLists__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:255:3: ( rule__TwoChildLists__Group__0 )
            {
             before(grammarAccess.getTwoChildListsAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:256:3: ( rule__TwoChildLists__Group__0 )
            // InternalPartialSerializationTestLanguage.g:256:4: rule__TwoChildLists__Group__0
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
    // InternalPartialSerializationTestLanguage.g:265:1: entryRuleTwoChilds : ruleTwoChilds EOF ;
    public final void entryRuleTwoChilds() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:266:1: ( ruleTwoChilds EOF )
            // InternalPartialSerializationTestLanguage.g:267:1: ruleTwoChilds EOF
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
    // InternalPartialSerializationTestLanguage.g:274:1: ruleTwoChilds : ( ( rule__TwoChilds__Group__0 ) ) ;
    public final void ruleTwoChilds() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:278:2: ( ( ( rule__TwoChilds__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:279:2: ( ( rule__TwoChilds__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:279:2: ( ( rule__TwoChilds__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:280:3: ( rule__TwoChilds__Group__0 )
            {
             before(grammarAccess.getTwoChildsAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:281:3: ( rule__TwoChilds__Group__0 )
            // InternalPartialSerializationTestLanguage.g:281:4: rule__TwoChilds__Group__0
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
    // InternalPartialSerializationTestLanguage.g:290:1: entryRuleChildWithSubChilds : ruleChildWithSubChilds EOF ;
    public final void entryRuleChildWithSubChilds() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:291:1: ( ruleChildWithSubChilds EOF )
            // InternalPartialSerializationTestLanguage.g:292:1: ruleChildWithSubChilds EOF
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
    // InternalPartialSerializationTestLanguage.g:299:1: ruleChildWithSubChilds : ( ( rule__ChildWithSubChilds__Group__0 ) ) ;
    public final void ruleChildWithSubChilds() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:303:2: ( ( ( rule__ChildWithSubChilds__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:304:2: ( ( rule__ChildWithSubChilds__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:304:2: ( ( rule__ChildWithSubChilds__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:305:3: ( rule__ChildWithSubChilds__Group__0 )
            {
             before(grammarAccess.getChildWithSubChildsAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:306:3: ( rule__ChildWithSubChilds__Group__0 )
            // InternalPartialSerializationTestLanguage.g:306:4: rule__ChildWithSubChilds__Group__0
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
    // InternalPartialSerializationTestLanguage.g:315:1: entryRuleChildWithSubChild : ruleChildWithSubChild EOF ;
    public final void entryRuleChildWithSubChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:316:1: ( ruleChildWithSubChild EOF )
            // InternalPartialSerializationTestLanguage.g:317:1: ruleChildWithSubChild EOF
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
    // InternalPartialSerializationTestLanguage.g:324:1: ruleChildWithSubChild : ( ( rule__ChildWithSubChild__Group__0 ) ) ;
    public final void ruleChildWithSubChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:328:2: ( ( ( rule__ChildWithSubChild__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:329:2: ( ( rule__ChildWithSubChild__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:329:2: ( ( rule__ChildWithSubChild__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:330:3: ( rule__ChildWithSubChild__Group__0 )
            {
             before(grammarAccess.getChildWithSubChildAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:331:3: ( rule__ChildWithSubChild__Group__0 )
            // InternalPartialSerializationTestLanguage.g:331:4: rule__ChildWithSubChild__Group__0
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
    // InternalPartialSerializationTestLanguage.g:340:1: entryRuleSubChild : ruleSubChild EOF ;
    public final void entryRuleSubChild() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:341:1: ( ruleSubChild EOF )
            // InternalPartialSerializationTestLanguage.g:342:1: ruleSubChild EOF
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
    // InternalPartialSerializationTestLanguage.g:349:1: ruleSubChild : ( ( rule__SubChild__NameAssignment ) ) ;
    public final void ruleSubChild() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:353:2: ( ( ( rule__SubChild__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:354:2: ( ( rule__SubChild__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:354:2: ( ( rule__SubChild__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:355:3: ( rule__SubChild__NameAssignment )
            {
             before(grammarAccess.getSubChildAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:356:3: ( rule__SubChild__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:356:4: rule__SubChild__NameAssignment
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
    // InternalPartialSerializationTestLanguage.g:365:1: entryRuleMandatoryChildList : ruleMandatoryChildList EOF ;
    public final void entryRuleMandatoryChildList() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:366:1: ( ruleMandatoryChildList EOF )
            // InternalPartialSerializationTestLanguage.g:367:1: ruleMandatoryChildList EOF
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
    // InternalPartialSerializationTestLanguage.g:374:1: ruleMandatoryChildList : ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) ) ;
    public final void ruleMandatoryChildList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:378:2: ( ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) ) )
            // InternalPartialSerializationTestLanguage.g:379:2: ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:379:2: ( ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* ) )
            // InternalPartialSerializationTestLanguage.g:380:3: ( ( rule__MandatoryChildList__ChildrenAssignment ) ) ( ( rule__MandatoryChildList__ChildrenAssignment )* )
            {
            // InternalPartialSerializationTestLanguage.g:380:3: ( ( rule__MandatoryChildList__ChildrenAssignment ) )
            // InternalPartialSerializationTestLanguage.g:381:4: ( rule__MandatoryChildList__ChildrenAssignment )
            {
             before(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 
            // InternalPartialSerializationTestLanguage.g:382:4: ( rule__MandatoryChildList__ChildrenAssignment )
            // InternalPartialSerializationTestLanguage.g:382:5: rule__MandatoryChildList__ChildrenAssignment
            {
            pushFollow(FOLLOW_3);
            rule__MandatoryChildList__ChildrenAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 

            }

            // InternalPartialSerializationTestLanguage.g:385:3: ( ( rule__MandatoryChildList__ChildrenAssignment )* )
            // InternalPartialSerializationTestLanguage.g:386:4: ( rule__MandatoryChildList__ChildrenAssignment )*
            {
             before(grammarAccess.getMandatoryChildListAccess().getChildrenAssignment()); 
            // InternalPartialSerializationTestLanguage.g:387:4: ( rule__MandatoryChildList__ChildrenAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:387:5: rule__MandatoryChildList__ChildrenAssignment
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
    // InternalPartialSerializationTestLanguage.g:397:1: entryRuleOptionalChildList : ruleOptionalChildList EOF ;
    public final void entryRuleOptionalChildList() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:398:1: ( ruleOptionalChildList EOF )
            // InternalPartialSerializationTestLanguage.g:399:1: ruleOptionalChildList EOF
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
    // InternalPartialSerializationTestLanguage.g:406:1: ruleOptionalChildList : ( ( rule__OptionalChildList__Group__0 ) ) ;
    public final void ruleOptionalChildList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:410:2: ( ( ( rule__OptionalChildList__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:411:2: ( ( rule__OptionalChildList__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:411:2: ( ( rule__OptionalChildList__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:412:3: ( rule__OptionalChildList__Group__0 )
            {
             before(grammarAccess.getOptionalChildListAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:413:3: ( rule__OptionalChildList__Group__0 )
            // InternalPartialSerializationTestLanguage.g:413:4: rule__OptionalChildList__Group__0
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
    // InternalPartialSerializationTestLanguage.g:422:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:423:1: ( ruleImport EOF )
            // InternalPartialSerializationTestLanguage.g:424:1: ruleImport EOF
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
    // InternalPartialSerializationTestLanguage.g:431:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:435:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:436:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:436:2: ( ( rule__Import__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:437:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:438:3: ( rule__Import__Group__0 )
            // InternalPartialSerializationTestLanguage.g:438:4: rule__Import__Group__0
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
    // InternalPartialSerializationTestLanguage.g:447:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:448:1: ( ruleNode EOF )
            // InternalPartialSerializationTestLanguage.g:449:1: ruleNode EOF
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
    // InternalPartialSerializationTestLanguage.g:456:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:460:2: ( ( ( rule__Node__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:461:2: ( ( rule__Node__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:461:2: ( ( rule__Node__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:462:3: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:463:3: ( rule__Node__Group__0 )
            // InternalPartialSerializationTestLanguage.g:463:4: rule__Node__Group__0
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
    // InternalPartialSerializationTestLanguage.g:472:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:473:1: ( ruleQualifiedName EOF )
            // InternalPartialSerializationTestLanguage.g:474:1: ruleQualifiedName EOF
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
    // InternalPartialSerializationTestLanguage.g:481:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:485:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalPartialSerializationTestLanguage.g:486:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalPartialSerializationTestLanguage.g:486:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalPartialSerializationTestLanguage.g:487:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalPartialSerializationTestLanguage.g:488:3: ( rule__QualifiedName__Group__0 )
            // InternalPartialSerializationTestLanguage.g:488:4: rule__QualifiedName__Group__0
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
    // InternalPartialSerializationTestLanguage.g:497:1: entryRuleEClassDecl : ruleEClassDecl EOF ;
    public final void entryRuleEClassDecl() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:498:1: ( ruleEClassDecl EOF )
            // InternalPartialSerializationTestLanguage.g:499:1: ruleEClassDecl EOF
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
    // InternalPartialSerializationTestLanguage.g:506:1: ruleEClassDecl : ( ( rule__EClassDecl__NameAssignment ) ) ;
    public final void ruleEClassDecl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:510:2: ( ( ( rule__EClassDecl__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:511:2: ( ( rule__EClassDecl__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:511:2: ( ( rule__EClassDecl__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:512:3: ( rule__EClassDecl__NameAssignment )
            {
             before(grammarAccess.getEClassDeclAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:513:3: ( rule__EClassDecl__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:513:4: rule__EClassDecl__NameAssignment
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
    // InternalPartialSerializationTestLanguage.g:522:1: entryRuleEClassRef : ruleEClassRef EOF ;
    public final void entryRuleEClassRef() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:523:1: ( ruleEClassRef EOF )
            // InternalPartialSerializationTestLanguage.g:524:1: ruleEClassRef EOF
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
    // InternalPartialSerializationTestLanguage.g:531:1: ruleEClassRef : ( ( rule__EClassRef__RefAssignment ) ) ;
    public final void ruleEClassRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:535:2: ( ( ( rule__EClassRef__RefAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:536:2: ( ( rule__EClassRef__RefAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:536:2: ( ( rule__EClassRef__RefAssignment ) )
            // InternalPartialSerializationTestLanguage.g:537:3: ( rule__EClassRef__RefAssignment )
            {
             before(grammarAccess.getEClassRefAccess().getRefAssignment()); 
            // InternalPartialSerializationTestLanguage.g:538:3: ( rule__EClassRef__RefAssignment )
            // InternalPartialSerializationTestLanguage.g:538:4: rule__EClassRef__RefAssignment
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


    // $ANTLR start "entryRuleWithTransientContainer"
    // InternalPartialSerializationTestLanguage.g:547:1: entryRuleWithTransientContainer : ruleWithTransientContainer EOF ;
    public final void entryRuleWithTransientContainer() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:548:1: ( ruleWithTransientContainer EOF )
            // InternalPartialSerializationTestLanguage.g:549:1: ruleWithTransientContainer EOF
            {
             before(grammarAccess.getWithTransientContainerRule()); 
            pushFollow(FOLLOW_1);
            ruleWithTransientContainer();

            state._fsp--;

             after(grammarAccess.getWithTransientContainerRule()); 
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
    // $ANTLR end "entryRuleWithTransientContainer"


    // $ANTLR start "ruleWithTransientContainer"
    // InternalPartialSerializationTestLanguage.g:556:1: ruleWithTransientContainer : ( ( rule__WithTransientContainer__ChildAssignment ) ) ;
    public final void ruleWithTransientContainer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:560:2: ( ( ( rule__WithTransientContainer__ChildAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:561:2: ( ( rule__WithTransientContainer__ChildAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:561:2: ( ( rule__WithTransientContainer__ChildAssignment ) )
            // InternalPartialSerializationTestLanguage.g:562:3: ( rule__WithTransientContainer__ChildAssignment )
            {
             before(grammarAccess.getWithTransientContainerAccess().getChildAssignment()); 
            // InternalPartialSerializationTestLanguage.g:563:3: ( rule__WithTransientContainer__ChildAssignment )
            // InternalPartialSerializationTestLanguage.g:563:4: rule__WithTransientContainer__ChildAssignment
            {
            pushFollow(FOLLOW_2);
            rule__WithTransientContainer__ChildAssignment();

            state._fsp--;


            }

             after(grammarAccess.getWithTransientContainerAccess().getChildAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWithTransientContainer"


    // $ANTLR start "entryRuleWithTransient"
    // InternalPartialSerializationTestLanguage.g:572:1: entryRuleWithTransient : ruleWithTransient EOF ;
    public final void entryRuleWithTransient() throws RecognitionException {
        try {
            // InternalPartialSerializationTestLanguage.g:573:1: ( ruleWithTransient EOF )
            // InternalPartialSerializationTestLanguage.g:574:1: ruleWithTransient EOF
            {
             before(grammarAccess.getWithTransientRule()); 
            pushFollow(FOLLOW_1);
            ruleWithTransient();

            state._fsp--;

             after(grammarAccess.getWithTransientRule()); 
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
    // $ANTLR end "entryRuleWithTransient"


    // $ANTLR start "ruleWithTransient"
    // InternalPartialSerializationTestLanguage.g:581:1: ruleWithTransient : ( ( rule__WithTransient__NameAssignment ) ) ;
    public final void ruleWithTransient() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:585:2: ( ( ( rule__WithTransient__NameAssignment ) ) )
            // InternalPartialSerializationTestLanguage.g:586:2: ( ( rule__WithTransient__NameAssignment ) )
            {
            // InternalPartialSerializationTestLanguage.g:586:2: ( ( rule__WithTransient__NameAssignment ) )
            // InternalPartialSerializationTestLanguage.g:587:3: ( rule__WithTransient__NameAssignment )
            {
             before(grammarAccess.getWithTransientAccess().getNameAssignment()); 
            // InternalPartialSerializationTestLanguage.g:588:3: ( rule__WithTransient__NameAssignment )
            // InternalPartialSerializationTestLanguage.g:588:4: rule__WithTransient__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__WithTransient__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getWithTransientAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWithTransient"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalPartialSerializationTestLanguage.g:596:1: rule__Model__Alternatives : ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) | ( ( rule__Model__Group_6__0 ) ) | ( ( rule__Model__Group_7__0 ) ) | ( ( rule__Model__Group_8__0 ) ) | ( ( rule__Model__Group_9__0 ) ) | ( ( rule__Model__Group_10__0 ) ) | ( ( rule__Model__Group_11__0 ) ) | ( ( rule__Model__Group_12__0 ) ) | ( ( rule__Model__Group_13__0 ) ) | ( ( rule__Model__Group_14__0 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:600:1: ( ( ( rule__Model__Group_0__0 ) ) | ( ( rule__Model__Group_1__0 ) ) | ( ( rule__Model__Group_2__0 ) ) | ( ( rule__Model__Group_3__0 ) ) | ( ( rule__Model__Group_4__0 ) ) | ( ( rule__Model__Group_5__0 ) ) | ( ( rule__Model__Group_6__0 ) ) | ( ( rule__Model__Group_7__0 ) ) | ( ( rule__Model__Group_8__0 ) ) | ( ( rule__Model__Group_9__0 ) ) | ( ( rule__Model__Group_10__0 ) ) | ( ( rule__Model__Group_11__0 ) ) | ( ( rule__Model__Group_12__0 ) ) | ( ( rule__Model__Group_13__0 ) ) | ( ( rule__Model__Group_14__0 ) ) )
            int alt3=15;
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
            case 26:
                {
                alt3=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:601:2: ( ( rule__Model__Group_0__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:601:2: ( ( rule__Model__Group_0__0 ) )
                    // InternalPartialSerializationTestLanguage.g:602:3: ( rule__Model__Group_0__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_0()); 
                    // InternalPartialSerializationTestLanguage.g:603:3: ( rule__Model__Group_0__0 )
                    // InternalPartialSerializationTestLanguage.g:603:4: rule__Model__Group_0__0
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
                    // InternalPartialSerializationTestLanguage.g:607:2: ( ( rule__Model__Group_1__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:607:2: ( ( rule__Model__Group_1__0 ) )
                    // InternalPartialSerializationTestLanguage.g:608:3: ( rule__Model__Group_1__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_1()); 
                    // InternalPartialSerializationTestLanguage.g:609:3: ( rule__Model__Group_1__0 )
                    // InternalPartialSerializationTestLanguage.g:609:4: rule__Model__Group_1__0
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
                    // InternalPartialSerializationTestLanguage.g:613:2: ( ( rule__Model__Group_2__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:613:2: ( ( rule__Model__Group_2__0 ) )
                    // InternalPartialSerializationTestLanguage.g:614:3: ( rule__Model__Group_2__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_2()); 
                    // InternalPartialSerializationTestLanguage.g:615:3: ( rule__Model__Group_2__0 )
                    // InternalPartialSerializationTestLanguage.g:615:4: rule__Model__Group_2__0
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
                    // InternalPartialSerializationTestLanguage.g:619:2: ( ( rule__Model__Group_3__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:619:2: ( ( rule__Model__Group_3__0 ) )
                    // InternalPartialSerializationTestLanguage.g:620:3: ( rule__Model__Group_3__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_3()); 
                    // InternalPartialSerializationTestLanguage.g:621:3: ( rule__Model__Group_3__0 )
                    // InternalPartialSerializationTestLanguage.g:621:4: rule__Model__Group_3__0
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
                    // InternalPartialSerializationTestLanguage.g:625:2: ( ( rule__Model__Group_4__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:625:2: ( ( rule__Model__Group_4__0 ) )
                    // InternalPartialSerializationTestLanguage.g:626:3: ( rule__Model__Group_4__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_4()); 
                    // InternalPartialSerializationTestLanguage.g:627:3: ( rule__Model__Group_4__0 )
                    // InternalPartialSerializationTestLanguage.g:627:4: rule__Model__Group_4__0
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
                    // InternalPartialSerializationTestLanguage.g:631:2: ( ( rule__Model__Group_5__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:631:2: ( ( rule__Model__Group_5__0 ) )
                    // InternalPartialSerializationTestLanguage.g:632:3: ( rule__Model__Group_5__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_5()); 
                    // InternalPartialSerializationTestLanguage.g:633:3: ( rule__Model__Group_5__0 )
                    // InternalPartialSerializationTestLanguage.g:633:4: rule__Model__Group_5__0
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
                    // InternalPartialSerializationTestLanguage.g:637:2: ( ( rule__Model__Group_6__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:637:2: ( ( rule__Model__Group_6__0 ) )
                    // InternalPartialSerializationTestLanguage.g:638:3: ( rule__Model__Group_6__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_6()); 
                    // InternalPartialSerializationTestLanguage.g:639:3: ( rule__Model__Group_6__0 )
                    // InternalPartialSerializationTestLanguage.g:639:4: rule__Model__Group_6__0
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
                    // InternalPartialSerializationTestLanguage.g:643:2: ( ( rule__Model__Group_7__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:643:2: ( ( rule__Model__Group_7__0 ) )
                    // InternalPartialSerializationTestLanguage.g:644:3: ( rule__Model__Group_7__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_7()); 
                    // InternalPartialSerializationTestLanguage.g:645:3: ( rule__Model__Group_7__0 )
                    // InternalPartialSerializationTestLanguage.g:645:4: rule__Model__Group_7__0
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
                    // InternalPartialSerializationTestLanguage.g:649:2: ( ( rule__Model__Group_8__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:649:2: ( ( rule__Model__Group_8__0 ) )
                    // InternalPartialSerializationTestLanguage.g:650:3: ( rule__Model__Group_8__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_8()); 
                    // InternalPartialSerializationTestLanguage.g:651:3: ( rule__Model__Group_8__0 )
                    // InternalPartialSerializationTestLanguage.g:651:4: rule__Model__Group_8__0
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
                    // InternalPartialSerializationTestLanguage.g:655:2: ( ( rule__Model__Group_9__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:655:2: ( ( rule__Model__Group_9__0 ) )
                    // InternalPartialSerializationTestLanguage.g:656:3: ( rule__Model__Group_9__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_9()); 
                    // InternalPartialSerializationTestLanguage.g:657:3: ( rule__Model__Group_9__0 )
                    // InternalPartialSerializationTestLanguage.g:657:4: rule__Model__Group_9__0
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
                    // InternalPartialSerializationTestLanguage.g:661:2: ( ( rule__Model__Group_10__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:661:2: ( ( rule__Model__Group_10__0 ) )
                    // InternalPartialSerializationTestLanguage.g:662:3: ( rule__Model__Group_10__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_10()); 
                    // InternalPartialSerializationTestLanguage.g:663:3: ( rule__Model__Group_10__0 )
                    // InternalPartialSerializationTestLanguage.g:663:4: rule__Model__Group_10__0
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
                    // InternalPartialSerializationTestLanguage.g:667:2: ( ( rule__Model__Group_11__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:667:2: ( ( rule__Model__Group_11__0 ) )
                    // InternalPartialSerializationTestLanguage.g:668:3: ( rule__Model__Group_11__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_11()); 
                    // InternalPartialSerializationTestLanguage.g:669:3: ( rule__Model__Group_11__0 )
                    // InternalPartialSerializationTestLanguage.g:669:4: rule__Model__Group_11__0
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
                    // InternalPartialSerializationTestLanguage.g:673:2: ( ( rule__Model__Group_12__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:673:2: ( ( rule__Model__Group_12__0 ) )
                    // InternalPartialSerializationTestLanguage.g:674:3: ( rule__Model__Group_12__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_12()); 
                    // InternalPartialSerializationTestLanguage.g:675:3: ( rule__Model__Group_12__0 )
                    // InternalPartialSerializationTestLanguage.g:675:4: rule__Model__Group_12__0
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
                    // InternalPartialSerializationTestLanguage.g:679:2: ( ( rule__Model__Group_13__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:679:2: ( ( rule__Model__Group_13__0 ) )
                    // InternalPartialSerializationTestLanguage.g:680:3: ( rule__Model__Group_13__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_13()); 
                    // InternalPartialSerializationTestLanguage.g:681:3: ( rule__Model__Group_13__0 )
                    // InternalPartialSerializationTestLanguage.g:681:4: rule__Model__Group_13__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_13__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalPartialSerializationTestLanguage.g:685:2: ( ( rule__Model__Group_14__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:685:2: ( ( rule__Model__Group_14__0 ) )
                    // InternalPartialSerializationTestLanguage.g:686:3: ( rule__Model__Group_14__0 )
                    {
                     before(grammarAccess.getModelAccess().getGroup_14()); 
                    // InternalPartialSerializationTestLanguage.g:687:3: ( rule__Model__Group_14__0 )
                    // InternalPartialSerializationTestLanguage.g:687:4: rule__Model__Group_14__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Model__Group_14__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getGroup_14()); 

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
    // InternalPartialSerializationTestLanguage.g:695:1: rule__Node__Alternatives_4 : ( ( ( rule__Node__Group_4_0__0 ) ) | ( ';' ) );
    public final void rule__Node__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:699:1: ( ( ( rule__Node__Group_4_0__0 ) ) | ( ';' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
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
                    // InternalPartialSerializationTestLanguage.g:700:2: ( ( rule__Node__Group_4_0__0 ) )
                    {
                    // InternalPartialSerializationTestLanguage.g:700:2: ( ( rule__Node__Group_4_0__0 ) )
                    // InternalPartialSerializationTestLanguage.g:701:3: ( rule__Node__Group_4_0__0 )
                    {
                     before(grammarAccess.getNodeAccess().getGroup_4_0()); 
                    // InternalPartialSerializationTestLanguage.g:702:3: ( rule__Node__Group_4_0__0 )
                    // InternalPartialSerializationTestLanguage.g:702:4: rule__Node__Group_4_0__0
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
                    // InternalPartialSerializationTestLanguage.g:706:2: ( ';' )
                    {
                    // InternalPartialSerializationTestLanguage.g:706:2: ( ';' )
                    // InternalPartialSerializationTestLanguage.g:707:3: ';'
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
    // InternalPartialSerializationTestLanguage.g:716:1: rule__Model__Group_0__0 : rule__Model__Group_0__0__Impl rule__Model__Group_0__1 ;
    public final void rule__Model__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:720:1: ( rule__Model__Group_0__0__Impl rule__Model__Group_0__1 )
            // InternalPartialSerializationTestLanguage.g:721:2: rule__Model__Group_0__0__Impl rule__Model__Group_0__1
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
    // InternalPartialSerializationTestLanguage.g:728:1: rule__Model__Group_0__0__Impl : ( '#1' ) ;
    public final void rule__Model__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:732:1: ( ( '#1' ) )
            // InternalPartialSerializationTestLanguage.g:733:1: ( '#1' )
            {
            // InternalPartialSerializationTestLanguage.g:733:1: ( '#1' )
            // InternalPartialSerializationTestLanguage.g:734:2: '#1'
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
    // InternalPartialSerializationTestLanguage.g:743:1: rule__Model__Group_0__1 : rule__Model__Group_0__1__Impl ;
    public final void rule__Model__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:747:1: ( rule__Model__Group_0__1__Impl )
            // InternalPartialSerializationTestLanguage.g:748:2: rule__Model__Group_0__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:754:1: rule__Model__Group_0__1__Impl : ( ruleNode ) ;
    public final void rule__Model__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:758:1: ( ( ruleNode ) )
            // InternalPartialSerializationTestLanguage.g:759:1: ( ruleNode )
            {
            // InternalPartialSerializationTestLanguage.g:759:1: ( ruleNode )
            // InternalPartialSerializationTestLanguage.g:760:2: ruleNode
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
    // InternalPartialSerializationTestLanguage.g:770:1: rule__Model__Group_1__0 : rule__Model__Group_1__0__Impl rule__Model__Group_1__1 ;
    public final void rule__Model__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:774:1: ( rule__Model__Group_1__0__Impl rule__Model__Group_1__1 )
            // InternalPartialSerializationTestLanguage.g:775:2: rule__Model__Group_1__0__Impl rule__Model__Group_1__1
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
    // InternalPartialSerializationTestLanguage.g:782:1: rule__Model__Group_1__0__Impl : ( '#2' ) ;
    public final void rule__Model__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:786:1: ( ( '#2' ) )
            // InternalPartialSerializationTestLanguage.g:787:1: ( '#2' )
            {
            // InternalPartialSerializationTestLanguage.g:787:1: ( '#2' )
            // InternalPartialSerializationTestLanguage.g:788:2: '#2'
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
    // InternalPartialSerializationTestLanguage.g:797:1: rule__Model__Group_1__1 : rule__Model__Group_1__1__Impl ;
    public final void rule__Model__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:801:1: ( rule__Model__Group_1__1__Impl )
            // InternalPartialSerializationTestLanguage.g:802:2: rule__Model__Group_1__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:808:1: rule__Model__Group_1__1__Impl : ( ruleMandatoryValue ) ;
    public final void rule__Model__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:812:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:813:1: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:813:1: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:814:2: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:824:1: rule__Model__Group_2__0 : rule__Model__Group_2__0__Impl rule__Model__Group_2__1 ;
    public final void rule__Model__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:828:1: ( rule__Model__Group_2__0__Impl rule__Model__Group_2__1 )
            // InternalPartialSerializationTestLanguage.g:829:2: rule__Model__Group_2__0__Impl rule__Model__Group_2__1
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
    // InternalPartialSerializationTestLanguage.g:836:1: rule__Model__Group_2__0__Impl : ( '#3' ) ;
    public final void rule__Model__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:840:1: ( ( '#3' ) )
            // InternalPartialSerializationTestLanguage.g:841:1: ( '#3' )
            {
            // InternalPartialSerializationTestLanguage.g:841:1: ( '#3' )
            // InternalPartialSerializationTestLanguage.g:842:2: '#3'
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
    // InternalPartialSerializationTestLanguage.g:851:1: rule__Model__Group_2__1 : rule__Model__Group_2__1__Impl ;
    public final void rule__Model__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:855:1: ( rule__Model__Group_2__1__Impl )
            // InternalPartialSerializationTestLanguage.g:856:2: rule__Model__Group_2__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:862:1: rule__Model__Group_2__1__Impl : ( ruleOptionalValue ) ;
    public final void rule__Model__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:866:1: ( ( ruleOptionalValue ) )
            // InternalPartialSerializationTestLanguage.g:867:1: ( ruleOptionalValue )
            {
            // InternalPartialSerializationTestLanguage.g:867:1: ( ruleOptionalValue )
            // InternalPartialSerializationTestLanguage.g:868:2: ruleOptionalValue
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
    // InternalPartialSerializationTestLanguage.g:878:1: rule__Model__Group_3__0 : rule__Model__Group_3__0__Impl rule__Model__Group_3__1 ;
    public final void rule__Model__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:882:1: ( rule__Model__Group_3__0__Impl rule__Model__Group_3__1 )
            // InternalPartialSerializationTestLanguage.g:883:2: rule__Model__Group_3__0__Impl rule__Model__Group_3__1
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
    // InternalPartialSerializationTestLanguage.g:890:1: rule__Model__Group_3__0__Impl : ( '#4' ) ;
    public final void rule__Model__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:894:1: ( ( '#4' ) )
            // InternalPartialSerializationTestLanguage.g:895:1: ( '#4' )
            {
            // InternalPartialSerializationTestLanguage.g:895:1: ( '#4' )
            // InternalPartialSerializationTestLanguage.g:896:2: '#4'
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
    // InternalPartialSerializationTestLanguage.g:905:1: rule__Model__Group_3__1 : rule__Model__Group_3__1__Impl ;
    public final void rule__Model__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:909:1: ( rule__Model__Group_3__1__Impl )
            // InternalPartialSerializationTestLanguage.g:910:2: rule__Model__Group_3__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:916:1: rule__Model__Group_3__1__Impl : ( ruleMandatoryChild ) ;
    public final void rule__Model__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:920:1: ( ( ruleMandatoryChild ) )
            // InternalPartialSerializationTestLanguage.g:921:1: ( ruleMandatoryChild )
            {
            // InternalPartialSerializationTestLanguage.g:921:1: ( ruleMandatoryChild )
            // InternalPartialSerializationTestLanguage.g:922:2: ruleMandatoryChild
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
    // InternalPartialSerializationTestLanguage.g:932:1: rule__Model__Group_4__0 : rule__Model__Group_4__0__Impl rule__Model__Group_4__1 ;
    public final void rule__Model__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:936:1: ( rule__Model__Group_4__0__Impl rule__Model__Group_4__1 )
            // InternalPartialSerializationTestLanguage.g:937:2: rule__Model__Group_4__0__Impl rule__Model__Group_4__1
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
    // InternalPartialSerializationTestLanguage.g:944:1: rule__Model__Group_4__0__Impl : ( '#5' ) ;
    public final void rule__Model__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:948:1: ( ( '#5' ) )
            // InternalPartialSerializationTestLanguage.g:949:1: ( '#5' )
            {
            // InternalPartialSerializationTestLanguage.g:949:1: ( '#5' )
            // InternalPartialSerializationTestLanguage.g:950:2: '#5'
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
    // InternalPartialSerializationTestLanguage.g:959:1: rule__Model__Group_4__1 : rule__Model__Group_4__1__Impl ;
    public final void rule__Model__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:963:1: ( rule__Model__Group_4__1__Impl )
            // InternalPartialSerializationTestLanguage.g:964:2: rule__Model__Group_4__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:970:1: rule__Model__Group_4__1__Impl : ( ruleOptionalChild ) ;
    public final void rule__Model__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:974:1: ( ( ruleOptionalChild ) )
            // InternalPartialSerializationTestLanguage.g:975:1: ( ruleOptionalChild )
            {
            // InternalPartialSerializationTestLanguage.g:975:1: ( ruleOptionalChild )
            // InternalPartialSerializationTestLanguage.g:976:2: ruleOptionalChild
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
    // InternalPartialSerializationTestLanguage.g:986:1: rule__Model__Group_5__0 : rule__Model__Group_5__0__Impl rule__Model__Group_5__1 ;
    public final void rule__Model__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:990:1: ( rule__Model__Group_5__0__Impl rule__Model__Group_5__1 )
            // InternalPartialSerializationTestLanguage.g:991:2: rule__Model__Group_5__0__Impl rule__Model__Group_5__1
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
    // InternalPartialSerializationTestLanguage.g:998:1: rule__Model__Group_5__0__Impl : ( '#10' ) ;
    public final void rule__Model__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1002:1: ( ( '#10' ) )
            // InternalPartialSerializationTestLanguage.g:1003:1: ( '#10' )
            {
            // InternalPartialSerializationTestLanguage.g:1003:1: ( '#10' )
            // InternalPartialSerializationTestLanguage.g:1004:2: '#10'
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
    // InternalPartialSerializationTestLanguage.g:1013:1: rule__Model__Group_5__1 : rule__Model__Group_5__1__Impl ;
    public final void rule__Model__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1017:1: ( rule__Model__Group_5__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1018:2: rule__Model__Group_5__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1024:1: rule__Model__Group_5__1__Impl : ( ruleManyOptionalValues ) ;
    public final void rule__Model__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1028:1: ( ( ruleManyOptionalValues ) )
            // InternalPartialSerializationTestLanguage.g:1029:1: ( ruleManyOptionalValues )
            {
            // InternalPartialSerializationTestLanguage.g:1029:1: ( ruleManyOptionalValues )
            // InternalPartialSerializationTestLanguage.g:1030:2: ruleManyOptionalValues
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
    // InternalPartialSerializationTestLanguage.g:1040:1: rule__Model__Group_6__0 : rule__Model__Group_6__0__Impl rule__Model__Group_6__1 ;
    public final void rule__Model__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1044:1: ( rule__Model__Group_6__0__Impl rule__Model__Group_6__1 )
            // InternalPartialSerializationTestLanguage.g:1045:2: rule__Model__Group_6__0__Impl rule__Model__Group_6__1
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
    // InternalPartialSerializationTestLanguage.g:1052:1: rule__Model__Group_6__0__Impl : ( '#11' ) ;
    public final void rule__Model__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1056:1: ( ( '#11' ) )
            // InternalPartialSerializationTestLanguage.g:1057:1: ( '#11' )
            {
            // InternalPartialSerializationTestLanguage.g:1057:1: ( '#11' )
            // InternalPartialSerializationTestLanguage.g:1058:2: '#11'
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
    // InternalPartialSerializationTestLanguage.g:1067:1: rule__Model__Group_6__1 : rule__Model__Group_6__1__Impl ;
    public final void rule__Model__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1071:1: ( rule__Model__Group_6__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1072:2: rule__Model__Group_6__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1078:1: rule__Model__Group_6__1__Impl : ( ruleManyMandatoryValues ) ;
    public final void rule__Model__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1082:1: ( ( ruleManyMandatoryValues ) )
            // InternalPartialSerializationTestLanguage.g:1083:1: ( ruleManyMandatoryValues )
            {
            // InternalPartialSerializationTestLanguage.g:1083:1: ( ruleManyMandatoryValues )
            // InternalPartialSerializationTestLanguage.g:1084:2: ruleManyMandatoryValues
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
    // InternalPartialSerializationTestLanguage.g:1094:1: rule__Model__Group_7__0 : rule__Model__Group_7__0__Impl rule__Model__Group_7__1 ;
    public final void rule__Model__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1098:1: ( rule__Model__Group_7__0__Impl rule__Model__Group_7__1 )
            // InternalPartialSerializationTestLanguage.g:1099:2: rule__Model__Group_7__0__Impl rule__Model__Group_7__1
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
    // InternalPartialSerializationTestLanguage.g:1106:1: rule__Model__Group_7__0__Impl : ( '#12' ) ;
    public final void rule__Model__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1110:1: ( ( '#12' ) )
            // InternalPartialSerializationTestLanguage.g:1111:1: ( '#12' )
            {
            // InternalPartialSerializationTestLanguage.g:1111:1: ( '#12' )
            // InternalPartialSerializationTestLanguage.g:1112:2: '#12'
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
    // InternalPartialSerializationTestLanguage.g:1121:1: rule__Model__Group_7__1 : rule__Model__Group_7__1__Impl ;
    public final void rule__Model__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1125:1: ( rule__Model__Group_7__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1126:2: rule__Model__Group_7__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1132:1: rule__Model__Group_7__1__Impl : ( ruleMandatoryChildList ) ;
    public final void rule__Model__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1136:1: ( ( ruleMandatoryChildList ) )
            // InternalPartialSerializationTestLanguage.g:1137:1: ( ruleMandatoryChildList )
            {
            // InternalPartialSerializationTestLanguage.g:1137:1: ( ruleMandatoryChildList )
            // InternalPartialSerializationTestLanguage.g:1138:2: ruleMandatoryChildList
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
    // InternalPartialSerializationTestLanguage.g:1148:1: rule__Model__Group_8__0 : rule__Model__Group_8__0__Impl rule__Model__Group_8__1 ;
    public final void rule__Model__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1152:1: ( rule__Model__Group_8__0__Impl rule__Model__Group_8__1 )
            // InternalPartialSerializationTestLanguage.g:1153:2: rule__Model__Group_8__0__Impl rule__Model__Group_8__1
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
    // InternalPartialSerializationTestLanguage.g:1160:1: rule__Model__Group_8__0__Impl : ( '#13' ) ;
    public final void rule__Model__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1164:1: ( ( '#13' ) )
            // InternalPartialSerializationTestLanguage.g:1165:1: ( '#13' )
            {
            // InternalPartialSerializationTestLanguage.g:1165:1: ( '#13' )
            // InternalPartialSerializationTestLanguage.g:1166:2: '#13'
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
    // InternalPartialSerializationTestLanguage.g:1175:1: rule__Model__Group_8__1 : rule__Model__Group_8__1__Impl ;
    public final void rule__Model__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1179:1: ( rule__Model__Group_8__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1180:2: rule__Model__Group_8__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1186:1: rule__Model__Group_8__1__Impl : ( ruleOptionalChildList ) ;
    public final void rule__Model__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1190:1: ( ( ruleOptionalChildList ) )
            // InternalPartialSerializationTestLanguage.g:1191:1: ( ruleOptionalChildList )
            {
            // InternalPartialSerializationTestLanguage.g:1191:1: ( ruleOptionalChildList )
            // InternalPartialSerializationTestLanguage.g:1192:2: ruleOptionalChildList
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
    // InternalPartialSerializationTestLanguage.g:1202:1: rule__Model__Group_9__0 : rule__Model__Group_9__0__Impl rule__Model__Group_9__1 ;
    public final void rule__Model__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1206:1: ( rule__Model__Group_9__0__Impl rule__Model__Group_9__1 )
            // InternalPartialSerializationTestLanguage.g:1207:2: rule__Model__Group_9__0__Impl rule__Model__Group_9__1
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
    // InternalPartialSerializationTestLanguage.g:1214:1: rule__Model__Group_9__0__Impl : ( '#20' ) ;
    public final void rule__Model__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1218:1: ( ( '#20' ) )
            // InternalPartialSerializationTestLanguage.g:1219:1: ( '#20' )
            {
            // InternalPartialSerializationTestLanguage.g:1219:1: ( '#20' )
            // InternalPartialSerializationTestLanguage.g:1220:2: '#20'
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
    // InternalPartialSerializationTestLanguage.g:1229:1: rule__Model__Group_9__1 : rule__Model__Group_9__1__Impl ;
    public final void rule__Model__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1233:1: ( rule__Model__Group_9__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1234:2: rule__Model__Group_9__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1240:1: rule__Model__Group_9__1__Impl : ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) ) ;
    public final void rule__Model__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1244:1: ( ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) ) )
            // InternalPartialSerializationTestLanguage.g:1245:1: ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:1245:1: ( ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1246:2: ( ( rule__Model__ClazzAssignment_9_1 ) ) ( ( rule__Model__ClazzAssignment_9_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1246:2: ( ( rule__Model__ClazzAssignment_9_1 ) )
            // InternalPartialSerializationTestLanguage.g:1247:3: ( rule__Model__ClazzAssignment_9_1 )
            {
             before(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 
            // InternalPartialSerializationTestLanguage.g:1248:3: ( rule__Model__ClazzAssignment_9_1 )
            // InternalPartialSerializationTestLanguage.g:1248:4: rule__Model__ClazzAssignment_9_1
            {
            pushFollow(FOLLOW_3);
            rule__Model__ClazzAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 

            }

            // InternalPartialSerializationTestLanguage.g:1251:2: ( ( rule__Model__ClazzAssignment_9_1 )* )
            // InternalPartialSerializationTestLanguage.g:1252:3: ( rule__Model__ClazzAssignment_9_1 )*
            {
             before(grammarAccess.getModelAccess().getClazzAssignment_9_1()); 
            // InternalPartialSerializationTestLanguage.g:1253:3: ( rule__Model__ClazzAssignment_9_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1253:4: rule__Model__ClazzAssignment_9_1
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
    // InternalPartialSerializationTestLanguage.g:1263:1: rule__Model__Group_10__0 : rule__Model__Group_10__0__Impl rule__Model__Group_10__1 ;
    public final void rule__Model__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1267:1: ( rule__Model__Group_10__0__Impl rule__Model__Group_10__1 )
            // InternalPartialSerializationTestLanguage.g:1268:2: rule__Model__Group_10__0__Impl rule__Model__Group_10__1
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
    // InternalPartialSerializationTestLanguage.g:1275:1: rule__Model__Group_10__0__Impl : ( '#21' ) ;
    public final void rule__Model__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1279:1: ( ( '#21' ) )
            // InternalPartialSerializationTestLanguage.g:1280:1: ( '#21' )
            {
            // InternalPartialSerializationTestLanguage.g:1280:1: ( '#21' )
            // InternalPartialSerializationTestLanguage.g:1281:2: '#21'
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
    // InternalPartialSerializationTestLanguage.g:1290:1: rule__Model__Group_10__1 : rule__Model__Group_10__1__Impl ;
    public final void rule__Model__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1294:1: ( rule__Model__Group_10__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1295:2: rule__Model__Group_10__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1301:1: rule__Model__Group_10__1__Impl : ( ruleEClassRef ) ;
    public final void rule__Model__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1305:1: ( ( ruleEClassRef ) )
            // InternalPartialSerializationTestLanguage.g:1306:1: ( ruleEClassRef )
            {
            // InternalPartialSerializationTestLanguage.g:1306:1: ( ruleEClassRef )
            // InternalPartialSerializationTestLanguage.g:1307:2: ruleEClassRef
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
    // InternalPartialSerializationTestLanguage.g:1317:1: rule__Model__Group_11__0 : rule__Model__Group_11__0__Impl rule__Model__Group_11__1 ;
    public final void rule__Model__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1321:1: ( rule__Model__Group_11__0__Impl rule__Model__Group_11__1 )
            // InternalPartialSerializationTestLanguage.g:1322:2: rule__Model__Group_11__0__Impl rule__Model__Group_11__1
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
    // InternalPartialSerializationTestLanguage.g:1329:1: rule__Model__Group_11__0__Impl : ( '#22' ) ;
    public final void rule__Model__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1333:1: ( ( '#22' ) )
            // InternalPartialSerializationTestLanguage.g:1334:1: ( '#22' )
            {
            // InternalPartialSerializationTestLanguage.g:1334:1: ( '#22' )
            // InternalPartialSerializationTestLanguage.g:1335:2: '#22'
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
    // InternalPartialSerializationTestLanguage.g:1344:1: rule__Model__Group_11__1 : rule__Model__Group_11__1__Impl ;
    public final void rule__Model__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1348:1: ( rule__Model__Group_11__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1349:2: rule__Model__Group_11__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1355:1: rule__Model__Group_11__1__Impl : ( ruleTwoChildLists ) ;
    public final void rule__Model__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1359:1: ( ( ruleTwoChildLists ) )
            // InternalPartialSerializationTestLanguage.g:1360:1: ( ruleTwoChildLists )
            {
            // InternalPartialSerializationTestLanguage.g:1360:1: ( ruleTwoChildLists )
            // InternalPartialSerializationTestLanguage.g:1361:2: ruleTwoChildLists
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
    // InternalPartialSerializationTestLanguage.g:1371:1: rule__Model__Group_12__0 : rule__Model__Group_12__0__Impl rule__Model__Group_12__1 ;
    public final void rule__Model__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1375:1: ( rule__Model__Group_12__0__Impl rule__Model__Group_12__1 )
            // InternalPartialSerializationTestLanguage.g:1376:2: rule__Model__Group_12__0__Impl rule__Model__Group_12__1
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
    // InternalPartialSerializationTestLanguage.g:1383:1: rule__Model__Group_12__0__Impl : ( '#23' ) ;
    public final void rule__Model__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1387:1: ( ( '#23' ) )
            // InternalPartialSerializationTestLanguage.g:1388:1: ( '#23' )
            {
            // InternalPartialSerializationTestLanguage.g:1388:1: ( '#23' )
            // InternalPartialSerializationTestLanguage.g:1389:2: '#23'
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
    // InternalPartialSerializationTestLanguage.g:1398:1: rule__Model__Group_12__1 : rule__Model__Group_12__1__Impl ;
    public final void rule__Model__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1402:1: ( rule__Model__Group_12__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1403:2: rule__Model__Group_12__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1409:1: rule__Model__Group_12__1__Impl : ( ruleChildWithSubChilds ) ;
    public final void rule__Model__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1413:1: ( ( ruleChildWithSubChilds ) )
            // InternalPartialSerializationTestLanguage.g:1414:1: ( ruleChildWithSubChilds )
            {
            // InternalPartialSerializationTestLanguage.g:1414:1: ( ruleChildWithSubChilds )
            // InternalPartialSerializationTestLanguage.g:1415:2: ruleChildWithSubChilds
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
    // InternalPartialSerializationTestLanguage.g:1425:1: rule__Model__Group_13__0 : rule__Model__Group_13__0__Impl rule__Model__Group_13__1 ;
    public final void rule__Model__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1429:1: ( rule__Model__Group_13__0__Impl rule__Model__Group_13__1 )
            // InternalPartialSerializationTestLanguage.g:1430:2: rule__Model__Group_13__0__Impl rule__Model__Group_13__1
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
    // InternalPartialSerializationTestLanguage.g:1437:1: rule__Model__Group_13__0__Impl : ( '#24' ) ;
    public final void rule__Model__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1441:1: ( ( '#24' ) )
            // InternalPartialSerializationTestLanguage.g:1442:1: ( '#24' )
            {
            // InternalPartialSerializationTestLanguage.g:1442:1: ( '#24' )
            // InternalPartialSerializationTestLanguage.g:1443:2: '#24'
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
    // InternalPartialSerializationTestLanguage.g:1452:1: rule__Model__Group_13__1 : rule__Model__Group_13__1__Impl ;
    public final void rule__Model__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1456:1: ( rule__Model__Group_13__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1457:2: rule__Model__Group_13__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1463:1: rule__Model__Group_13__1__Impl : ( ruleTwoChilds ) ;
    public final void rule__Model__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1467:1: ( ( ruleTwoChilds ) )
            // InternalPartialSerializationTestLanguage.g:1468:1: ( ruleTwoChilds )
            {
            // InternalPartialSerializationTestLanguage.g:1468:1: ( ruleTwoChilds )
            // InternalPartialSerializationTestLanguage.g:1469:2: ruleTwoChilds
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


    // $ANTLR start "rule__Model__Group_14__0"
    // InternalPartialSerializationTestLanguage.g:1479:1: rule__Model__Group_14__0 : rule__Model__Group_14__0__Impl rule__Model__Group_14__1 ;
    public final void rule__Model__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1483:1: ( rule__Model__Group_14__0__Impl rule__Model__Group_14__1 )
            // InternalPartialSerializationTestLanguage.g:1484:2: rule__Model__Group_14__0__Impl rule__Model__Group_14__1
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_14__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__0"


    // $ANTLR start "rule__Model__Group_14__0__Impl"
    // InternalPartialSerializationTestLanguage.g:1491:1: rule__Model__Group_14__0__Impl : ( '#30' ) ;
    public final void rule__Model__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1495:1: ( ( '#30' ) )
            // InternalPartialSerializationTestLanguage.g:1496:1: ( '#30' )
            {
            // InternalPartialSerializationTestLanguage.g:1496:1: ( '#30' )
            // InternalPartialSerializationTestLanguage.g:1497:2: '#30'
            {
             before(grammarAccess.getModelAccess().getNumberSignDigitThreeDigitZeroKeyword_14_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getNumberSignDigitThreeDigitZeroKeyword_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__0__Impl"


    // $ANTLR start "rule__Model__Group_14__1"
    // InternalPartialSerializationTestLanguage.g:1506:1: rule__Model__Group_14__1 : rule__Model__Group_14__1__Impl ;
    public final void rule__Model__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1510:1: ( rule__Model__Group_14__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1511:2: rule__Model__Group_14__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_14__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__1"


    // $ANTLR start "rule__Model__Group_14__1__Impl"
    // InternalPartialSerializationTestLanguage.g:1517:1: rule__Model__Group_14__1__Impl : ( ruleWithTransientContainer ) ;
    public final void rule__Model__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1521:1: ( ( ruleWithTransientContainer ) )
            // InternalPartialSerializationTestLanguage.g:1522:1: ( ruleWithTransientContainer )
            {
            // InternalPartialSerializationTestLanguage.g:1522:1: ( ruleWithTransientContainer )
            // InternalPartialSerializationTestLanguage.g:1523:2: ruleWithTransientContainer
            {
             before(grammarAccess.getModelAccess().getWithTransientContainerParserRuleCall_14_1()); 
            pushFollow(FOLLOW_2);
            ruleWithTransientContainer();

            state._fsp--;

             after(grammarAccess.getModelAccess().getWithTransientContainerParserRuleCall_14_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_14__1__Impl"


    // $ANTLR start "rule__OptionalValue__Group__0"
    // InternalPartialSerializationTestLanguage.g:1533:1: rule__OptionalValue__Group__0 : rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1 ;
    public final void rule__OptionalValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1537:1: ( rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1538:2: rule__OptionalValue__Group__0__Impl rule__OptionalValue__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1545:1: rule__OptionalValue__Group__0__Impl : ( () ) ;
    public final void rule__OptionalValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1549:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1550:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1550:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1551:2: ()
            {
             before(grammarAccess.getOptionalValueAccess().getOptionalValueAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1552:2: ()
            // InternalPartialSerializationTestLanguage.g:1552:3: 
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
    // InternalPartialSerializationTestLanguage.g:1560:1: rule__OptionalValue__Group__1 : rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2 ;
    public final void rule__OptionalValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1564:1: ( rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1565:2: rule__OptionalValue__Group__1__Impl rule__OptionalValue__Group__2
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
    // InternalPartialSerializationTestLanguage.g:1572:1: rule__OptionalValue__Group__1__Impl : ( ( 'kw1' )? ) ;
    public final void rule__OptionalValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1576:1: ( ( ( 'kw1' )? ) )
            // InternalPartialSerializationTestLanguage.g:1577:1: ( ( 'kw1' )? )
            {
            // InternalPartialSerializationTestLanguage.g:1577:1: ( ( 'kw1' )? )
            // InternalPartialSerializationTestLanguage.g:1578:2: ( 'kw1' )?
            {
             before(grammarAccess.getOptionalValueAccess().getKw1Keyword_1()); 
            // InternalPartialSerializationTestLanguage.g:1579:2: ( 'kw1' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1579:3: 'kw1'
                    {
                    match(input,27,FOLLOW_2); 

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
    // InternalPartialSerializationTestLanguage.g:1587:1: rule__OptionalValue__Group__2 : rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3 ;
    public final void rule__OptionalValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1591:1: ( rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3 )
            // InternalPartialSerializationTestLanguage.g:1592:2: rule__OptionalValue__Group__2__Impl rule__OptionalValue__Group__3
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
    // InternalPartialSerializationTestLanguage.g:1599:1: rule__OptionalValue__Group__2__Impl : ( ( rule__OptionalValue__NameAssignment_2 )? ) ;
    public final void rule__OptionalValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1603:1: ( ( ( rule__OptionalValue__NameAssignment_2 )? ) )
            // InternalPartialSerializationTestLanguage.g:1604:1: ( ( rule__OptionalValue__NameAssignment_2 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1604:1: ( ( rule__OptionalValue__NameAssignment_2 )? )
            // InternalPartialSerializationTestLanguage.g:1605:2: ( rule__OptionalValue__NameAssignment_2 )?
            {
             before(grammarAccess.getOptionalValueAccess().getNameAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:1606:2: ( rule__OptionalValue__NameAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1606:3: rule__OptionalValue__NameAssignment_2
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
    // InternalPartialSerializationTestLanguage.g:1614:1: rule__OptionalValue__Group__3 : rule__OptionalValue__Group__3__Impl ;
    public final void rule__OptionalValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1618:1: ( rule__OptionalValue__Group__3__Impl )
            // InternalPartialSerializationTestLanguage.g:1619:2: rule__OptionalValue__Group__3__Impl
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
    // InternalPartialSerializationTestLanguage.g:1625:1: rule__OptionalValue__Group__3__Impl : ( ( 'kw2' )? ) ;
    public final void rule__OptionalValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1629:1: ( ( ( 'kw2' )? ) )
            // InternalPartialSerializationTestLanguage.g:1630:1: ( ( 'kw2' )? )
            {
            // InternalPartialSerializationTestLanguage.g:1630:1: ( ( 'kw2' )? )
            // InternalPartialSerializationTestLanguage.g:1631:2: ( 'kw2' )?
            {
             before(grammarAccess.getOptionalValueAccess().getKw2Keyword_3()); 
            // InternalPartialSerializationTestLanguage.g:1632:2: ( 'kw2' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==28) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1632:3: 'kw2'
                    {
                    match(input,28,FOLLOW_2); 

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
    // InternalPartialSerializationTestLanguage.g:1641:1: rule__ManyOptionalValues__Group__0 : rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1 ;
    public final void rule__ManyOptionalValues__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1645:1: ( rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1646:2: rule__ManyOptionalValues__Group__0__Impl rule__ManyOptionalValues__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1653:1: rule__ManyOptionalValues__Group__0__Impl : ( () ) ;
    public final void rule__ManyOptionalValues__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1657:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1658:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1658:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1659:2: ()
            {
             before(grammarAccess.getManyOptionalValuesAccess().getManyValuesAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1660:2: ()
            // InternalPartialSerializationTestLanguage.g:1660:3: 
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
    // InternalPartialSerializationTestLanguage.g:1668:1: rule__ManyOptionalValues__Group__1 : rule__ManyOptionalValues__Group__1__Impl ;
    public final void rule__ManyOptionalValues__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1672:1: ( rule__ManyOptionalValues__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1673:2: rule__ManyOptionalValues__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1679:1: rule__ManyOptionalValues__Group__1__Impl : ( ( rule__ManyOptionalValues__NameAssignment_1 )* ) ;
    public final void rule__ManyOptionalValues__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1683:1: ( ( ( rule__ManyOptionalValues__NameAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1684:1: ( ( rule__ManyOptionalValues__NameAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1684:1: ( ( rule__ManyOptionalValues__NameAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:1685:2: ( rule__ManyOptionalValues__NameAssignment_1 )*
            {
             before(grammarAccess.getManyOptionalValuesAccess().getNameAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1686:2: ( rule__ManyOptionalValues__NameAssignment_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1686:3: rule__ManyOptionalValues__NameAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:1695:1: rule__OptionalChild__Group__0 : rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1 ;
    public final void rule__OptionalChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1699:1: ( rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1700:2: rule__OptionalChild__Group__0__Impl rule__OptionalChild__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1707:1: rule__OptionalChild__Group__0__Impl : ( () ) ;
    public final void rule__OptionalChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1711:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1712:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1712:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1713:2: ()
            {
             before(grammarAccess.getOptionalChildAccess().getOptionalChildAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1714:2: ()
            // InternalPartialSerializationTestLanguage.g:1714:3: 
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
    // InternalPartialSerializationTestLanguage.g:1722:1: rule__OptionalChild__Group__1 : rule__OptionalChild__Group__1__Impl ;
    public final void rule__OptionalChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1726:1: ( rule__OptionalChild__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:1727:2: rule__OptionalChild__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:1733:1: rule__OptionalChild__Group__1__Impl : ( ( rule__OptionalChild__ChildAssignment_1 )? ) ;
    public final void rule__OptionalChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1737:1: ( ( ( rule__OptionalChild__ChildAssignment_1 )? ) )
            // InternalPartialSerializationTestLanguage.g:1738:1: ( ( rule__OptionalChild__ChildAssignment_1 )? )
            {
            // InternalPartialSerializationTestLanguage.g:1738:1: ( ( rule__OptionalChild__ChildAssignment_1 )? )
            // InternalPartialSerializationTestLanguage.g:1739:2: ( rule__OptionalChild__ChildAssignment_1 )?
            {
             before(grammarAccess.getOptionalChildAccess().getChildAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1740:2: ( rule__OptionalChild__ChildAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:1740:3: rule__OptionalChild__ChildAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:1749:1: rule__TwoChildLists__Group__0 : rule__TwoChildLists__Group__0__Impl rule__TwoChildLists__Group__1 ;
    public final void rule__TwoChildLists__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1753:1: ( rule__TwoChildLists__Group__0__Impl rule__TwoChildLists__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1754:2: rule__TwoChildLists__Group__0__Impl rule__TwoChildLists__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1761:1: rule__TwoChildLists__Group__0__Impl : ( '{' ) ;
    public final void rule__TwoChildLists__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1765:1: ( ( '{' ) )
            // InternalPartialSerializationTestLanguage.g:1766:1: ( '{' )
            {
            // InternalPartialSerializationTestLanguage.g:1766:1: ( '{' )
            // InternalPartialSerializationTestLanguage.g:1767:2: '{'
            {
             before(grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:1776:1: rule__TwoChildLists__Group__1 : rule__TwoChildLists__Group__1__Impl rule__TwoChildLists__Group__2 ;
    public final void rule__TwoChildLists__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1780:1: ( rule__TwoChildLists__Group__1__Impl rule__TwoChildLists__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1781:2: rule__TwoChildLists__Group__1__Impl rule__TwoChildLists__Group__2
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
    // InternalPartialSerializationTestLanguage.g:1788:1: rule__TwoChildLists__Group__1__Impl : ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) ) ;
    public final void rule__TwoChildLists__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1792:1: ( ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) ) )
            // InternalPartialSerializationTestLanguage.g:1793:1: ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) )
            {
            // InternalPartialSerializationTestLanguage.g:1793:1: ( ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:1794:2: ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) ) ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:1794:2: ( ( rule__TwoChildLists__DirectChildrenAssignment_1 ) )
            // InternalPartialSerializationTestLanguage.g:1795:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )
            {
             before(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1796:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )
            // InternalPartialSerializationTestLanguage.g:1796:4: rule__TwoChildLists__DirectChildrenAssignment_1
            {
            pushFollow(FOLLOW_3);
            rule__TwoChildLists__DirectChildrenAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1()); 

            }

            // InternalPartialSerializationTestLanguage.g:1799:2: ( ( rule__TwoChildLists__DirectChildrenAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:1800:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )*
            {
             before(grammarAccess.getTwoChildListsAccess().getDirectChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:1801:3: ( rule__TwoChildLists__DirectChildrenAssignment_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:1801:4: rule__TwoChildLists__DirectChildrenAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:1810:1: rule__TwoChildLists__Group__2 : rule__TwoChildLists__Group__2__Impl rule__TwoChildLists__Group__3 ;
    public final void rule__TwoChildLists__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1814:1: ( rule__TwoChildLists__Group__2__Impl rule__TwoChildLists__Group__3 )
            // InternalPartialSerializationTestLanguage.g:1815:2: rule__TwoChildLists__Group__2__Impl rule__TwoChildLists__Group__3
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
    // InternalPartialSerializationTestLanguage.g:1822:1: rule__TwoChildLists__Group__2__Impl : ( 'children1' ) ;
    public final void rule__TwoChildLists__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1826:1: ( ( 'children1' ) )
            // InternalPartialSerializationTestLanguage.g:1827:1: ( 'children1' )
            {
            // InternalPartialSerializationTestLanguage.g:1827:1: ( 'children1' )
            // InternalPartialSerializationTestLanguage.g:1828:2: 'children1'
            {
             before(grammarAccess.getTwoChildListsAccess().getChildren1Keyword_2()); 
            match(input,30,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:1837:1: rule__TwoChildLists__Group__3 : rule__TwoChildLists__Group__3__Impl rule__TwoChildLists__Group__4 ;
    public final void rule__TwoChildLists__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1841:1: ( rule__TwoChildLists__Group__3__Impl rule__TwoChildLists__Group__4 )
            // InternalPartialSerializationTestLanguage.g:1842:2: rule__TwoChildLists__Group__3__Impl rule__TwoChildLists__Group__4
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
    // InternalPartialSerializationTestLanguage.g:1849:1: rule__TwoChildLists__Group__3__Impl : ( '{' ) ;
    public final void rule__TwoChildLists__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1853:1: ( ( '{' ) )
            // InternalPartialSerializationTestLanguage.g:1854:1: ( '{' )
            {
            // InternalPartialSerializationTestLanguage.g:1854:1: ( '{' )
            // InternalPartialSerializationTestLanguage.g:1855:2: '{'
            {
             before(grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,29,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:1864:1: rule__TwoChildLists__Group__4 : rule__TwoChildLists__Group__4__Impl rule__TwoChildLists__Group__5 ;
    public final void rule__TwoChildLists__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1868:1: ( rule__TwoChildLists__Group__4__Impl rule__TwoChildLists__Group__5 )
            // InternalPartialSerializationTestLanguage.g:1869:2: rule__TwoChildLists__Group__4__Impl rule__TwoChildLists__Group__5
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
    // InternalPartialSerializationTestLanguage.g:1876:1: rule__TwoChildLists__Group__4__Impl : ( ( rule__TwoChildLists__ChildsListAssignment_4 ) ) ;
    public final void rule__TwoChildLists__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1880:1: ( ( ( rule__TwoChildLists__ChildsListAssignment_4 ) ) )
            // InternalPartialSerializationTestLanguage.g:1881:1: ( ( rule__TwoChildLists__ChildsListAssignment_4 ) )
            {
            // InternalPartialSerializationTestLanguage.g:1881:1: ( ( rule__TwoChildLists__ChildsListAssignment_4 ) )
            // InternalPartialSerializationTestLanguage.g:1882:2: ( rule__TwoChildLists__ChildsListAssignment_4 )
            {
             before(grammarAccess.getTwoChildListsAccess().getChildsListAssignment_4()); 
            // InternalPartialSerializationTestLanguage.g:1883:2: ( rule__TwoChildLists__ChildsListAssignment_4 )
            // InternalPartialSerializationTestLanguage.g:1883:3: rule__TwoChildLists__ChildsListAssignment_4
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
    // InternalPartialSerializationTestLanguage.g:1891:1: rule__TwoChildLists__Group__5 : rule__TwoChildLists__Group__5__Impl rule__TwoChildLists__Group__6 ;
    public final void rule__TwoChildLists__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1895:1: ( rule__TwoChildLists__Group__5__Impl rule__TwoChildLists__Group__6 )
            // InternalPartialSerializationTestLanguage.g:1896:2: rule__TwoChildLists__Group__5__Impl rule__TwoChildLists__Group__6
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
    // InternalPartialSerializationTestLanguage.g:1903:1: rule__TwoChildLists__Group__5__Impl : ( '}' ) ;
    public final void rule__TwoChildLists__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1907:1: ( ( '}' ) )
            // InternalPartialSerializationTestLanguage.g:1908:1: ( '}' )
            {
            // InternalPartialSerializationTestLanguage.g:1908:1: ( '}' )
            // InternalPartialSerializationTestLanguage.g:1909:2: '}'
            {
             before(grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,31,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:1918:1: rule__TwoChildLists__Group__6 : rule__TwoChildLists__Group__6__Impl ;
    public final void rule__TwoChildLists__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1922:1: ( rule__TwoChildLists__Group__6__Impl )
            // InternalPartialSerializationTestLanguage.g:1923:2: rule__TwoChildLists__Group__6__Impl
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
    // InternalPartialSerializationTestLanguage.g:1929:1: rule__TwoChildLists__Group__6__Impl : ( '}' ) ;
    public final void rule__TwoChildLists__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1933:1: ( ( '}' ) )
            // InternalPartialSerializationTestLanguage.g:1934:1: ( '}' )
            {
            // InternalPartialSerializationTestLanguage.g:1934:1: ( '}' )
            // InternalPartialSerializationTestLanguage.g:1935:2: '}'
            {
             before(grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:1945:1: rule__TwoChilds__Group__0 : rule__TwoChilds__Group__0__Impl rule__TwoChilds__Group__1 ;
    public final void rule__TwoChilds__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1949:1: ( rule__TwoChilds__Group__0__Impl rule__TwoChilds__Group__1 )
            // InternalPartialSerializationTestLanguage.g:1950:2: rule__TwoChilds__Group__0__Impl rule__TwoChilds__Group__1
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
    // InternalPartialSerializationTestLanguage.g:1957:1: rule__TwoChilds__Group__0__Impl : ( () ) ;
    public final void rule__TwoChilds__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1961:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:1962:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:1962:1: ( () )
            // InternalPartialSerializationTestLanguage.g:1963:2: ()
            {
             before(grammarAccess.getTwoChildsAccess().getTwoChildsAction_0()); 
            // InternalPartialSerializationTestLanguage.g:1964:2: ()
            // InternalPartialSerializationTestLanguage.g:1964:3: 
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
    // InternalPartialSerializationTestLanguage.g:1972:1: rule__TwoChilds__Group__1 : rule__TwoChilds__Group__1__Impl rule__TwoChilds__Group__2 ;
    public final void rule__TwoChilds__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1976:1: ( rule__TwoChilds__Group__1__Impl rule__TwoChilds__Group__2 )
            // InternalPartialSerializationTestLanguage.g:1977:2: rule__TwoChilds__Group__1__Impl rule__TwoChilds__Group__2
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
    // InternalPartialSerializationTestLanguage.g:1984:1: rule__TwoChilds__Group__1__Impl : ( 'direct' ) ;
    public final void rule__TwoChilds__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:1988:1: ( ( 'direct' ) )
            // InternalPartialSerializationTestLanguage.g:1989:1: ( 'direct' )
            {
            // InternalPartialSerializationTestLanguage.g:1989:1: ( 'direct' )
            // InternalPartialSerializationTestLanguage.g:1990:2: 'direct'
            {
             before(grammarAccess.getTwoChildsAccess().getDirectKeyword_1()); 
            match(input,32,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:1999:1: rule__TwoChilds__Group__2 : rule__TwoChilds__Group__2__Impl rule__TwoChilds__Group__3 ;
    public final void rule__TwoChilds__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2003:1: ( rule__TwoChilds__Group__2__Impl rule__TwoChilds__Group__3 )
            // InternalPartialSerializationTestLanguage.g:2004:2: rule__TwoChilds__Group__2__Impl rule__TwoChilds__Group__3
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
    // InternalPartialSerializationTestLanguage.g:2011:1: rule__TwoChilds__Group__2__Impl : ( ':' ) ;
    public final void rule__TwoChilds__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2015:1: ( ( ':' ) )
            // InternalPartialSerializationTestLanguage.g:2016:1: ( ':' )
            {
            // InternalPartialSerializationTestLanguage.g:2016:1: ( ':' )
            // InternalPartialSerializationTestLanguage.g:2017:2: ':'
            {
             before(grammarAccess.getTwoChildsAccess().getColonKeyword_2()); 
            match(input,33,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2026:1: rule__TwoChilds__Group__3 : rule__TwoChilds__Group__3__Impl rule__TwoChilds__Group__4 ;
    public final void rule__TwoChilds__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2030:1: ( rule__TwoChilds__Group__3__Impl rule__TwoChilds__Group__4 )
            // InternalPartialSerializationTestLanguage.g:2031:2: rule__TwoChilds__Group__3__Impl rule__TwoChilds__Group__4
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
    // InternalPartialSerializationTestLanguage.g:2038:1: rule__TwoChilds__Group__3__Impl : ( ( rule__TwoChilds__DirectChildAssignment_3 )? ) ;
    public final void rule__TwoChilds__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2042:1: ( ( ( rule__TwoChilds__DirectChildAssignment_3 )? ) )
            // InternalPartialSerializationTestLanguage.g:2043:1: ( ( rule__TwoChilds__DirectChildAssignment_3 )? )
            {
            // InternalPartialSerializationTestLanguage.g:2043:1: ( ( rule__TwoChilds__DirectChildAssignment_3 )? )
            // InternalPartialSerializationTestLanguage.g:2044:2: ( rule__TwoChilds__DirectChildAssignment_3 )?
            {
             before(grammarAccess.getTwoChildsAccess().getDirectChildAssignment_3()); 
            // InternalPartialSerializationTestLanguage.g:2045:2: ( rule__TwoChilds__DirectChildAssignment_3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:2045:3: rule__TwoChilds__DirectChildAssignment_3
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
    // InternalPartialSerializationTestLanguage.g:2053:1: rule__TwoChilds__Group__4 : rule__TwoChilds__Group__4__Impl rule__TwoChilds__Group__5 ;
    public final void rule__TwoChilds__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2057:1: ( rule__TwoChilds__Group__4__Impl rule__TwoChilds__Group__5 )
            // InternalPartialSerializationTestLanguage.g:2058:2: rule__TwoChilds__Group__4__Impl rule__TwoChilds__Group__5
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
    // InternalPartialSerializationTestLanguage.g:2065:1: rule__TwoChilds__Group__4__Impl : ( 'child' ) ;
    public final void rule__TwoChilds__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2069:1: ( ( 'child' ) )
            // InternalPartialSerializationTestLanguage.g:2070:1: ( 'child' )
            {
            // InternalPartialSerializationTestLanguage.g:2070:1: ( 'child' )
            // InternalPartialSerializationTestLanguage.g:2071:2: 'child'
            {
             before(grammarAccess.getTwoChildsAccess().getChildKeyword_4()); 
            match(input,34,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2080:1: rule__TwoChilds__Group__5 : rule__TwoChilds__Group__5__Impl rule__TwoChilds__Group__6 ;
    public final void rule__TwoChilds__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2084:1: ( rule__TwoChilds__Group__5__Impl rule__TwoChilds__Group__6 )
            // InternalPartialSerializationTestLanguage.g:2085:2: rule__TwoChilds__Group__5__Impl rule__TwoChilds__Group__6
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
    // InternalPartialSerializationTestLanguage.g:2092:1: rule__TwoChilds__Group__5__Impl : ( ':' ) ;
    public final void rule__TwoChilds__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2096:1: ( ( ':' ) )
            // InternalPartialSerializationTestLanguage.g:2097:1: ( ':' )
            {
            // InternalPartialSerializationTestLanguage.g:2097:1: ( ':' )
            // InternalPartialSerializationTestLanguage.g:2098:2: ':'
            {
             before(grammarAccess.getTwoChildsAccess().getColonKeyword_5()); 
            match(input,33,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2107:1: rule__TwoChilds__Group__6 : rule__TwoChilds__Group__6__Impl ;
    public final void rule__TwoChilds__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2111:1: ( rule__TwoChilds__Group__6__Impl )
            // InternalPartialSerializationTestLanguage.g:2112:2: rule__TwoChilds__Group__6__Impl
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
    // InternalPartialSerializationTestLanguage.g:2118:1: rule__TwoChilds__Group__6__Impl : ( ( rule__TwoChilds__OptChildAssignment_6 ) ) ;
    public final void rule__TwoChilds__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2122:1: ( ( ( rule__TwoChilds__OptChildAssignment_6 ) ) )
            // InternalPartialSerializationTestLanguage.g:2123:1: ( ( rule__TwoChilds__OptChildAssignment_6 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2123:1: ( ( rule__TwoChilds__OptChildAssignment_6 ) )
            // InternalPartialSerializationTestLanguage.g:2124:2: ( rule__TwoChilds__OptChildAssignment_6 )
            {
             before(grammarAccess.getTwoChildsAccess().getOptChildAssignment_6()); 
            // InternalPartialSerializationTestLanguage.g:2125:2: ( rule__TwoChilds__OptChildAssignment_6 )
            // InternalPartialSerializationTestLanguage.g:2125:3: rule__TwoChilds__OptChildAssignment_6
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
    // InternalPartialSerializationTestLanguage.g:2134:1: rule__ChildWithSubChilds__Group__0 : rule__ChildWithSubChilds__Group__0__Impl rule__ChildWithSubChilds__Group__1 ;
    public final void rule__ChildWithSubChilds__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2138:1: ( rule__ChildWithSubChilds__Group__0__Impl rule__ChildWithSubChilds__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2139:2: rule__ChildWithSubChilds__Group__0__Impl rule__ChildWithSubChilds__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2146:1: rule__ChildWithSubChilds__Group__0__Impl : ( () ) ;
    public final void rule__ChildWithSubChilds__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2150:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2151:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2151:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2152:2: ()
            {
             before(grammarAccess.getChildWithSubChildsAccess().getChildWithSubChildsAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2153:2: ()
            // InternalPartialSerializationTestLanguage.g:2153:3: 
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
    // InternalPartialSerializationTestLanguage.g:2161:1: rule__ChildWithSubChilds__Group__1 : rule__ChildWithSubChilds__Group__1__Impl ;
    public final void rule__ChildWithSubChilds__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2165:1: ( rule__ChildWithSubChilds__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2166:2: rule__ChildWithSubChilds__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2172:1: rule__ChildWithSubChilds__Group__1__Impl : ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* ) ;
    public final void rule__ChildWithSubChilds__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2176:1: ( ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2177:1: ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2177:1: ( ( rule__ChildWithSubChilds__ChildrenAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:2178:2: ( rule__ChildWithSubChilds__ChildrenAssignment_1 )*
            {
             before(grammarAccess.getChildWithSubChildsAccess().getChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2179:2: ( rule__ChildWithSubChilds__ChildrenAssignment_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2179:3: rule__ChildWithSubChilds__ChildrenAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:2188:1: rule__ChildWithSubChild__Group__0 : rule__ChildWithSubChild__Group__0__Impl rule__ChildWithSubChild__Group__1 ;
    public final void rule__ChildWithSubChild__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2192:1: ( rule__ChildWithSubChild__Group__0__Impl rule__ChildWithSubChild__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2193:2: rule__ChildWithSubChild__Group__0__Impl rule__ChildWithSubChild__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2200:1: rule__ChildWithSubChild__Group__0__Impl : ( () ) ;
    public final void rule__ChildWithSubChild__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2204:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2205:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2205:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2206:2: ()
            {
             before(grammarAccess.getChildWithSubChildAccess().getChildWithSubChildAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2207:2: ()
            // InternalPartialSerializationTestLanguage.g:2207:3: 
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
    // InternalPartialSerializationTestLanguage.g:2215:1: rule__ChildWithSubChild__Group__1 : rule__ChildWithSubChild__Group__1__Impl rule__ChildWithSubChild__Group__2 ;
    public final void rule__ChildWithSubChild__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2219:1: ( rule__ChildWithSubChild__Group__1__Impl rule__ChildWithSubChild__Group__2 )
            // InternalPartialSerializationTestLanguage.g:2220:2: rule__ChildWithSubChild__Group__1__Impl rule__ChildWithSubChild__Group__2
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
    // InternalPartialSerializationTestLanguage.g:2227:1: rule__ChildWithSubChild__Group__1__Impl : ( 'subs' ) ;
    public final void rule__ChildWithSubChild__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2231:1: ( ( 'subs' ) )
            // InternalPartialSerializationTestLanguage.g:2232:1: ( 'subs' )
            {
            // InternalPartialSerializationTestLanguage.g:2232:1: ( 'subs' )
            // InternalPartialSerializationTestLanguage.g:2233:2: 'subs'
            {
             before(grammarAccess.getChildWithSubChildAccess().getSubsKeyword_1()); 
            match(input,35,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2242:1: rule__ChildWithSubChild__Group__2 : rule__ChildWithSubChild__Group__2__Impl ;
    public final void rule__ChildWithSubChild__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2246:1: ( rule__ChildWithSubChild__Group__2__Impl )
            // InternalPartialSerializationTestLanguage.g:2247:2: rule__ChildWithSubChild__Group__2__Impl
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
    // InternalPartialSerializationTestLanguage.g:2253:1: rule__ChildWithSubChild__Group__2__Impl : ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* ) ;
    public final void rule__ChildWithSubChild__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2257:1: ( ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* ) )
            // InternalPartialSerializationTestLanguage.g:2258:1: ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2258:1: ( ( rule__ChildWithSubChild__SubChildsAssignment_2 )* )
            // InternalPartialSerializationTestLanguage.g:2259:2: ( rule__ChildWithSubChild__SubChildsAssignment_2 )*
            {
             before(grammarAccess.getChildWithSubChildAccess().getSubChildsAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:2260:2: ( rule__ChildWithSubChild__SubChildsAssignment_2 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2260:3: rule__ChildWithSubChild__SubChildsAssignment_2
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
    // InternalPartialSerializationTestLanguage.g:2269:1: rule__OptionalChildList__Group__0 : rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1 ;
    public final void rule__OptionalChildList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2273:1: ( rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2274:2: rule__OptionalChildList__Group__0__Impl rule__OptionalChildList__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2281:1: rule__OptionalChildList__Group__0__Impl : ( () ) ;
    public final void rule__OptionalChildList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2285:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2286:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2286:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2287:2: ()
            {
             before(grammarAccess.getOptionalChildListAccess().getOptionalChildListAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2288:2: ()
            // InternalPartialSerializationTestLanguage.g:2288:3: 
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
    // InternalPartialSerializationTestLanguage.g:2296:1: rule__OptionalChildList__Group__1 : rule__OptionalChildList__Group__1__Impl ;
    public final void rule__OptionalChildList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2300:1: ( rule__OptionalChildList__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2301:2: rule__OptionalChildList__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2307:1: rule__OptionalChildList__Group__1__Impl : ( ( rule__OptionalChildList__ChildrenAssignment_1 )* ) ;
    public final void rule__OptionalChildList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2311:1: ( ( ( rule__OptionalChildList__ChildrenAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2312:1: ( ( rule__OptionalChildList__ChildrenAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2312:1: ( ( rule__OptionalChildList__ChildrenAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:2313:2: ( rule__OptionalChildList__ChildrenAssignment_1 )*
            {
             before(grammarAccess.getOptionalChildListAccess().getChildrenAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2314:2: ( rule__OptionalChildList__ChildrenAssignment_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2314:3: rule__OptionalChildList__ChildrenAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:2323:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2327:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2328:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2335:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2339:1: ( ( 'import' ) )
            // InternalPartialSerializationTestLanguage.g:2340:1: ( 'import' )
            {
            // InternalPartialSerializationTestLanguage.g:2340:1: ( 'import' )
            // InternalPartialSerializationTestLanguage.g:2341:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2350:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2354:1: ( rule__Import__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2355:2: rule__Import__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2361:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2365:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalPartialSerializationTestLanguage.g:2366:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2366:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalPartialSerializationTestLanguage.g:2367:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2368:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalPartialSerializationTestLanguage.g:2368:3: rule__Import__ImportedNamespaceAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:2377:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2381:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2382:2: rule__Node__Group__0__Impl rule__Node__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2389:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2393:1: ( ( () ) )
            // InternalPartialSerializationTestLanguage.g:2394:1: ( () )
            {
            // InternalPartialSerializationTestLanguage.g:2394:1: ( () )
            // InternalPartialSerializationTestLanguage.g:2395:2: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // InternalPartialSerializationTestLanguage.g:2396:2: ()
            // InternalPartialSerializationTestLanguage.g:2396:3: 
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
    // InternalPartialSerializationTestLanguage.g:2404:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2408:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalPartialSerializationTestLanguage.g:2409:2: rule__Node__Group__1__Impl rule__Node__Group__2
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
    // InternalPartialSerializationTestLanguage.g:2416:1: rule__Node__Group__1__Impl : ( ( rule__Node__ImportsAssignment_1 )* ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2420:1: ( ( ( rule__Node__ImportsAssignment_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2421:1: ( ( rule__Node__ImportsAssignment_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2421:1: ( ( rule__Node__ImportsAssignment_1 )* )
            // InternalPartialSerializationTestLanguage.g:2422:2: ( rule__Node__ImportsAssignment_1 )*
            {
             before(grammarAccess.getNodeAccess().getImportsAssignment_1()); 
            // InternalPartialSerializationTestLanguage.g:2423:2: ( rule__Node__ImportsAssignment_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==36) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2423:3: rule__Node__ImportsAssignment_1
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
    // InternalPartialSerializationTestLanguage.g:2431:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2435:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalPartialSerializationTestLanguage.g:2436:2: rule__Node__Group__2__Impl rule__Node__Group__3
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
    // InternalPartialSerializationTestLanguage.g:2443:1: rule__Node__Group__2__Impl : ( ( rule__Node__NameAssignment_2 )? ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2447:1: ( ( ( rule__Node__NameAssignment_2 )? ) )
            // InternalPartialSerializationTestLanguage.g:2448:1: ( ( rule__Node__NameAssignment_2 )? )
            {
            // InternalPartialSerializationTestLanguage.g:2448:1: ( ( rule__Node__NameAssignment_2 )? )
            // InternalPartialSerializationTestLanguage.g:2449:2: ( rule__Node__NameAssignment_2 )?
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_2()); 
            // InternalPartialSerializationTestLanguage.g:2450:2: ( rule__Node__NameAssignment_2 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:2450:3: rule__Node__NameAssignment_2
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
    // InternalPartialSerializationTestLanguage.g:2458:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2462:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalPartialSerializationTestLanguage.g:2463:2: rule__Node__Group__3__Impl rule__Node__Group__4
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
    // InternalPartialSerializationTestLanguage.g:2470:1: rule__Node__Group__3__Impl : ( ( rule__Node__Group_3__0 )? ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2474:1: ( ( ( rule__Node__Group_3__0 )? ) )
            // InternalPartialSerializationTestLanguage.g:2475:1: ( ( rule__Node__Group_3__0 )? )
            {
            // InternalPartialSerializationTestLanguage.g:2475:1: ( ( rule__Node__Group_3__0 )? )
            // InternalPartialSerializationTestLanguage.g:2476:2: ( rule__Node__Group_3__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_3()); 
            // InternalPartialSerializationTestLanguage.g:2477:2: ( rule__Node__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==37) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:2477:3: rule__Node__Group_3__0
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
    // InternalPartialSerializationTestLanguage.g:2485:1: rule__Node__Group__4 : rule__Node__Group__4__Impl ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2489:1: ( rule__Node__Group__4__Impl )
            // InternalPartialSerializationTestLanguage.g:2490:2: rule__Node__Group__4__Impl
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
    // InternalPartialSerializationTestLanguage.g:2496:1: rule__Node__Group__4__Impl : ( ( rule__Node__Alternatives_4 ) ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2500:1: ( ( ( rule__Node__Alternatives_4 ) ) )
            // InternalPartialSerializationTestLanguage.g:2501:1: ( ( rule__Node__Alternatives_4 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2501:1: ( ( rule__Node__Alternatives_4 ) )
            // InternalPartialSerializationTestLanguage.g:2502:2: ( rule__Node__Alternatives_4 )
            {
             before(grammarAccess.getNodeAccess().getAlternatives_4()); 
            // InternalPartialSerializationTestLanguage.g:2503:2: ( rule__Node__Alternatives_4 )
            // InternalPartialSerializationTestLanguage.g:2503:3: rule__Node__Alternatives_4
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
    // InternalPartialSerializationTestLanguage.g:2512:1: rule__Node__Group_3__0 : rule__Node__Group_3__0__Impl rule__Node__Group_3__1 ;
    public final void rule__Node__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2516:1: ( rule__Node__Group_3__0__Impl rule__Node__Group_3__1 )
            // InternalPartialSerializationTestLanguage.g:2517:2: rule__Node__Group_3__0__Impl rule__Node__Group_3__1
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
    // InternalPartialSerializationTestLanguage.g:2524:1: rule__Node__Group_3__0__Impl : ( 'refs' ) ;
    public final void rule__Node__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2528:1: ( ( 'refs' ) )
            // InternalPartialSerializationTestLanguage.g:2529:1: ( 'refs' )
            {
            // InternalPartialSerializationTestLanguage.g:2529:1: ( 'refs' )
            // InternalPartialSerializationTestLanguage.g:2530:2: 'refs'
            {
             before(grammarAccess.getNodeAccess().getRefsKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2539:1: rule__Node__Group_3__1 : rule__Node__Group_3__1__Impl ;
    public final void rule__Node__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2543:1: ( rule__Node__Group_3__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2544:2: rule__Node__Group_3__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2550:1: rule__Node__Group_3__1__Impl : ( ( rule__Node__RefsAssignment_3_1 )* ) ;
    public final void rule__Node__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2554:1: ( ( ( rule__Node__RefsAssignment_3_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2555:1: ( ( rule__Node__RefsAssignment_3_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2555:1: ( ( rule__Node__RefsAssignment_3_1 )* )
            // InternalPartialSerializationTestLanguage.g:2556:2: ( rule__Node__RefsAssignment_3_1 )*
            {
             before(grammarAccess.getNodeAccess().getRefsAssignment_3_1()); 
            // InternalPartialSerializationTestLanguage.g:2557:2: ( rule__Node__RefsAssignment_3_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2557:3: rule__Node__RefsAssignment_3_1
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
    // InternalPartialSerializationTestLanguage.g:2566:1: rule__Node__Group_4_0__0 : rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1 ;
    public final void rule__Node__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2570:1: ( rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1 )
            // InternalPartialSerializationTestLanguage.g:2571:2: rule__Node__Group_4_0__0__Impl rule__Node__Group_4_0__1
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
    // InternalPartialSerializationTestLanguage.g:2578:1: rule__Node__Group_4_0__0__Impl : ( '{' ) ;
    public final void rule__Node__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2582:1: ( ( '{' ) )
            // InternalPartialSerializationTestLanguage.g:2583:1: ( '{' )
            {
            // InternalPartialSerializationTestLanguage.g:2583:1: ( '{' )
            // InternalPartialSerializationTestLanguage.g:2584:2: '{'
            {
             before(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4_0_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2593:1: rule__Node__Group_4_0__1 : rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2 ;
    public final void rule__Node__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2597:1: ( rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2 )
            // InternalPartialSerializationTestLanguage.g:2598:2: rule__Node__Group_4_0__1__Impl rule__Node__Group_4_0__2
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
    // InternalPartialSerializationTestLanguage.g:2605:1: rule__Node__Group_4_0__1__Impl : ( ( rule__Node__ChildrenAssignment_4_0_1 )* ) ;
    public final void rule__Node__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2609:1: ( ( ( rule__Node__ChildrenAssignment_4_0_1 )* ) )
            // InternalPartialSerializationTestLanguage.g:2610:1: ( ( rule__Node__ChildrenAssignment_4_0_1 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2610:1: ( ( rule__Node__ChildrenAssignment_4_0_1 )* )
            // InternalPartialSerializationTestLanguage.g:2611:2: ( rule__Node__ChildrenAssignment_4_0_1 )*
            {
             before(grammarAccess.getNodeAccess().getChildrenAssignment_4_0_1()); 
            // InternalPartialSerializationTestLanguage.g:2612:2: ( rule__Node__ChildrenAssignment_4_0_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID||LA20_0==11||LA20_0==29||(LA20_0>=36 && LA20_0<=37)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2612:3: rule__Node__ChildrenAssignment_4_0_1
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
    // InternalPartialSerializationTestLanguage.g:2620:1: rule__Node__Group_4_0__2 : rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3 ;
    public final void rule__Node__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2624:1: ( rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3 )
            // InternalPartialSerializationTestLanguage.g:2625:2: rule__Node__Group_4_0__2__Impl rule__Node__Group_4_0__3
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
    // InternalPartialSerializationTestLanguage.g:2632:1: rule__Node__Group_4_0__2__Impl : ( ( rule__Node__Group_4_0_2__0 )? ) ;
    public final void rule__Node__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2636:1: ( ( ( rule__Node__Group_4_0_2__0 )? ) )
            // InternalPartialSerializationTestLanguage.g:2637:1: ( ( rule__Node__Group_4_0_2__0 )? )
            {
            // InternalPartialSerializationTestLanguage.g:2637:1: ( ( rule__Node__Group_4_0_2__0 )? )
            // InternalPartialSerializationTestLanguage.g:2638:2: ( rule__Node__Group_4_0_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_4_0_2()); 
            // InternalPartialSerializationTestLanguage.g:2639:2: ( rule__Node__Group_4_0_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalPartialSerializationTestLanguage.g:2639:3: rule__Node__Group_4_0_2__0
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
    // InternalPartialSerializationTestLanguage.g:2647:1: rule__Node__Group_4_0__3 : rule__Node__Group_4_0__3__Impl ;
    public final void rule__Node__Group_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2651:1: ( rule__Node__Group_4_0__3__Impl )
            // InternalPartialSerializationTestLanguage.g:2652:2: rule__Node__Group_4_0__3__Impl
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
    // InternalPartialSerializationTestLanguage.g:2658:1: rule__Node__Group_4_0__3__Impl : ( '}' ) ;
    public final void rule__Node__Group_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2662:1: ( ( '}' ) )
            // InternalPartialSerializationTestLanguage.g:2663:1: ( '}' )
            {
            // InternalPartialSerializationTestLanguage.g:2663:1: ( '}' )
            // InternalPartialSerializationTestLanguage.g:2664:2: '}'
            {
             before(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_4_0_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2674:1: rule__Node__Group_4_0_2__0 : rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1 ;
    public final void rule__Node__Group_4_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2678:1: ( rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1 )
            // InternalPartialSerializationTestLanguage.g:2679:2: rule__Node__Group_4_0_2__0__Impl rule__Node__Group_4_0_2__1
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
    // InternalPartialSerializationTestLanguage.g:2686:1: rule__Node__Group_4_0_2__0__Impl : ( 'ref' ) ;
    public final void rule__Node__Group_4_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2690:1: ( ( 'ref' ) )
            // InternalPartialSerializationTestLanguage.g:2691:1: ( 'ref' )
            {
            // InternalPartialSerializationTestLanguage.g:2691:1: ( 'ref' )
            // InternalPartialSerializationTestLanguage.g:2692:2: 'ref'
            {
             before(grammarAccess.getNodeAccess().getRefKeyword_4_0_2_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2701:1: rule__Node__Group_4_0_2__1 : rule__Node__Group_4_0_2__1__Impl ;
    public final void rule__Node__Group_4_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2705:1: ( rule__Node__Group_4_0_2__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2706:2: rule__Node__Group_4_0_2__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2712:1: rule__Node__Group_4_0_2__1__Impl : ( ( rule__Node__RefAssignment_4_0_2_1 ) ) ;
    public final void rule__Node__Group_4_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2716:1: ( ( ( rule__Node__RefAssignment_4_0_2_1 ) ) )
            // InternalPartialSerializationTestLanguage.g:2717:1: ( ( rule__Node__RefAssignment_4_0_2_1 ) )
            {
            // InternalPartialSerializationTestLanguage.g:2717:1: ( ( rule__Node__RefAssignment_4_0_2_1 ) )
            // InternalPartialSerializationTestLanguage.g:2718:2: ( rule__Node__RefAssignment_4_0_2_1 )
            {
             before(grammarAccess.getNodeAccess().getRefAssignment_4_0_2_1()); 
            // InternalPartialSerializationTestLanguage.g:2719:2: ( rule__Node__RefAssignment_4_0_2_1 )
            // InternalPartialSerializationTestLanguage.g:2719:3: rule__Node__RefAssignment_4_0_2_1
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
    // InternalPartialSerializationTestLanguage.g:2728:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2732:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalPartialSerializationTestLanguage.g:2733:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalPartialSerializationTestLanguage.g:2740:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2744:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2745:1: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2745:1: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2746:2: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2755:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2759:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2760:2: rule__QualifiedName__Group__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2766:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2770:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalPartialSerializationTestLanguage.g:2771:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalPartialSerializationTestLanguage.g:2771:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalPartialSerializationTestLanguage.g:2772:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalPartialSerializationTestLanguage.g:2773:2: ( rule__QualifiedName__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==39) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalPartialSerializationTestLanguage.g:2773:3: rule__QualifiedName__Group_1__0
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
    // InternalPartialSerializationTestLanguage.g:2782:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2786:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalPartialSerializationTestLanguage.g:2787:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalPartialSerializationTestLanguage.g:2794:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2798:1: ( ( '.' ) )
            // InternalPartialSerializationTestLanguage.g:2799:1: ( '.' )
            {
            // InternalPartialSerializationTestLanguage.g:2799:1: ( '.' )
            // InternalPartialSerializationTestLanguage.g:2800:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalPartialSerializationTestLanguage.g:2809:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2813:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalPartialSerializationTestLanguage.g:2814:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalPartialSerializationTestLanguage.g:2820:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2824:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2825:1: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2825:1: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2826:2: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2836:1: rule__Model__ClazzAssignment_9_1 : ( ruleEClassDecl ) ;
    public final void rule__Model__ClazzAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2840:1: ( ( ruleEClassDecl ) )
            // InternalPartialSerializationTestLanguage.g:2841:2: ( ruleEClassDecl )
            {
            // InternalPartialSerializationTestLanguage.g:2841:2: ( ruleEClassDecl )
            // InternalPartialSerializationTestLanguage.g:2842:3: ruleEClassDecl
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
    // InternalPartialSerializationTestLanguage.g:2851:1: rule__MandatoryValue__NameAssignment : ( RULE_ID ) ;
    public final void rule__MandatoryValue__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2855:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2856:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2856:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2857:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2866:1: rule__OptionalValue__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OptionalValue__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2870:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2871:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2871:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2872:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2881:1: rule__ManyOptionalValues__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ManyOptionalValues__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2885:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2886:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2886:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2887:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2896:1: rule__ManyMandatoryValues__NameAssignment : ( RULE_ID ) ;
    public final void rule__ManyMandatoryValues__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2900:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:2901:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:2901:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:2902:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:2911:1: rule__MandatoryChild__ChildAssignment : ( ruleMandatoryValue ) ;
    public final void rule__MandatoryChild__ChildAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2915:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2916:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2916:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2917:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:2926:1: rule__OptionalChild__ChildAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__OptionalChild__ChildAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2930:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2931:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2931:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2932:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:2941:1: rule__TwoChildLists__DirectChildrenAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__TwoChildLists__DirectChildrenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2945:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2946:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2946:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2947:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:2956:1: rule__TwoChildLists__ChildsListAssignment_4 : ( ruleMandatoryChildList ) ;
    public final void rule__TwoChildLists__ChildsListAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2960:1: ( ( ruleMandatoryChildList ) )
            // InternalPartialSerializationTestLanguage.g:2961:2: ( ruleMandatoryChildList )
            {
            // InternalPartialSerializationTestLanguage.g:2961:2: ( ruleMandatoryChildList )
            // InternalPartialSerializationTestLanguage.g:2962:3: ruleMandatoryChildList
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
    // InternalPartialSerializationTestLanguage.g:2971:1: rule__TwoChilds__DirectChildAssignment_3 : ( ruleMandatoryValue ) ;
    public final void rule__TwoChilds__DirectChildAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2975:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:2976:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:2976:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:2977:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:2986:1: rule__TwoChilds__OptChildAssignment_6 : ( ruleOptionalChild ) ;
    public final void rule__TwoChilds__OptChildAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:2990:1: ( ( ruleOptionalChild ) )
            // InternalPartialSerializationTestLanguage.g:2991:2: ( ruleOptionalChild )
            {
            // InternalPartialSerializationTestLanguage.g:2991:2: ( ruleOptionalChild )
            // InternalPartialSerializationTestLanguage.g:2992:3: ruleOptionalChild
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
    // InternalPartialSerializationTestLanguage.g:3001:1: rule__ChildWithSubChilds__ChildrenAssignment_1 : ( ruleChildWithSubChild ) ;
    public final void rule__ChildWithSubChilds__ChildrenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3005:1: ( ( ruleChildWithSubChild ) )
            // InternalPartialSerializationTestLanguage.g:3006:2: ( ruleChildWithSubChild )
            {
            // InternalPartialSerializationTestLanguage.g:3006:2: ( ruleChildWithSubChild )
            // InternalPartialSerializationTestLanguage.g:3007:3: ruleChildWithSubChild
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
    // InternalPartialSerializationTestLanguage.g:3016:1: rule__ChildWithSubChild__SubChildsAssignment_2 : ( ruleSubChild ) ;
    public final void rule__ChildWithSubChild__SubChildsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3020:1: ( ( ruleSubChild ) )
            // InternalPartialSerializationTestLanguage.g:3021:2: ( ruleSubChild )
            {
            // InternalPartialSerializationTestLanguage.g:3021:2: ( ruleSubChild )
            // InternalPartialSerializationTestLanguage.g:3022:3: ruleSubChild
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
    // InternalPartialSerializationTestLanguage.g:3031:1: rule__SubChild__NameAssignment : ( RULE_ID ) ;
    public final void rule__SubChild__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3035:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:3036:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:3036:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:3037:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:3046:1: rule__MandatoryChildList__ChildrenAssignment : ( ruleMandatoryValue ) ;
    public final void rule__MandatoryChildList__ChildrenAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3050:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:3051:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:3051:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:3052:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:3061:1: rule__OptionalChildList__ChildrenAssignment_1 : ( ruleMandatoryValue ) ;
    public final void rule__OptionalChildList__ChildrenAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3065:1: ( ( ruleMandatoryValue ) )
            // InternalPartialSerializationTestLanguage.g:3066:2: ( ruleMandatoryValue )
            {
            // InternalPartialSerializationTestLanguage.g:3066:2: ( ruleMandatoryValue )
            // InternalPartialSerializationTestLanguage.g:3067:3: ruleMandatoryValue
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
    // InternalPartialSerializationTestLanguage.g:3076:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3080:1: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:3081:2: ( ruleQualifiedName )
            {
            // InternalPartialSerializationTestLanguage.g:3081:2: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:3082:3: ruleQualifiedName
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
    // InternalPartialSerializationTestLanguage.g:3091:1: rule__Node__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Node__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3095:1: ( ( ruleImport ) )
            // InternalPartialSerializationTestLanguage.g:3096:2: ( ruleImport )
            {
            // InternalPartialSerializationTestLanguage.g:3096:2: ( ruleImport )
            // InternalPartialSerializationTestLanguage.g:3097:3: ruleImport
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
    // InternalPartialSerializationTestLanguage.g:3106:1: rule__Node__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Node__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3110:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:3111:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:3111:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:3112:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:3121:1: rule__Node__RefsAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Node__RefsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3125:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:3126:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:3126:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:3127:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getNodeAccess().getRefsNodeCrossReference_3_1_0()); 
            // InternalPartialSerializationTestLanguage.g:3128:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:3129:4: ruleQualifiedName
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
    // InternalPartialSerializationTestLanguage.g:3140:1: rule__Node__ChildrenAssignment_4_0_1 : ( ruleNode ) ;
    public final void rule__Node__ChildrenAssignment_4_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3144:1: ( ( ruleNode ) )
            // InternalPartialSerializationTestLanguage.g:3145:2: ( ruleNode )
            {
            // InternalPartialSerializationTestLanguage.g:3145:2: ( ruleNode )
            // InternalPartialSerializationTestLanguage.g:3146:3: ruleNode
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
    // InternalPartialSerializationTestLanguage.g:3155:1: rule__Node__RefAssignment_4_0_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Node__RefAssignment_4_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3159:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:3160:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:3160:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:3161:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getNodeAccess().getRefNodeCrossReference_4_0_2_1_0()); 
            // InternalPartialSerializationTestLanguage.g:3162:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:3163:4: ruleQualifiedName
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
    // InternalPartialSerializationTestLanguage.g:3174:1: rule__EClassDecl__NameAssignment : ( RULE_ID ) ;
    public final void rule__EClassDecl__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3178:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:3179:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:3179:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:3180:3: RULE_ID
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
    // InternalPartialSerializationTestLanguage.g:3189:1: rule__EClassRef__RefAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__EClassRef__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3193:1: ( ( ( ruleQualifiedName ) ) )
            // InternalPartialSerializationTestLanguage.g:3194:2: ( ( ruleQualifiedName ) )
            {
            // InternalPartialSerializationTestLanguage.g:3194:2: ( ( ruleQualifiedName ) )
            // InternalPartialSerializationTestLanguage.g:3195:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getEClassRefAccess().getRefEClassCrossReference_0()); 
            // InternalPartialSerializationTestLanguage.g:3196:3: ( ruleQualifiedName )
            // InternalPartialSerializationTestLanguage.g:3197:4: ruleQualifiedName
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


    // $ANTLR start "rule__WithTransientContainer__ChildAssignment"
    // InternalPartialSerializationTestLanguage.g:3208:1: rule__WithTransientContainer__ChildAssignment : ( ruleWithTransient ) ;
    public final void rule__WithTransientContainer__ChildAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3212:1: ( ( ruleWithTransient ) )
            // InternalPartialSerializationTestLanguage.g:3213:2: ( ruleWithTransient )
            {
            // InternalPartialSerializationTestLanguage.g:3213:2: ( ruleWithTransient )
            // InternalPartialSerializationTestLanguage.g:3214:3: ruleWithTransient
            {
             before(grammarAccess.getWithTransientContainerAccess().getChildWithTransientParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleWithTransient();

            state._fsp--;

             after(grammarAccess.getWithTransientContainerAccess().getChildWithTransientParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithTransientContainer__ChildAssignment"


    // $ANTLR start "rule__WithTransient__NameAssignment"
    // InternalPartialSerializationTestLanguage.g:3223:1: rule__WithTransient__NameAssignment : ( RULE_ID ) ;
    public final void rule__WithTransient__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalPartialSerializationTestLanguage.g:3227:1: ( ( RULE_ID ) )
            // InternalPartialSerializationTestLanguage.g:3228:2: ( RULE_ID )
            {
            // InternalPartialSerializationTestLanguage.g:3228:2: ( RULE_ID )
            // InternalPartialSerializationTestLanguage.g:3229:3: RULE_ID
            {
             before(grammarAccess.getWithTransientAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWithTransientAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WithTransient__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000003020000810L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000018000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000400000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000070A0000810L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000003020000812L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000008000000002L});

}