package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288734TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug288734TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'constant'", "'string'", "'integer'", "'boolean'", "'@desc'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug288734TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug288734TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug288734TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug288734TestLanguage.g"; }


     
     	private Bug288734TestLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(Bug288734TestLanguageGrammarAccess grammarAccess) {
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
    // InternalBug288734TestLanguage.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:61:1: ( ruleModel EOF )
            // InternalBug288734TestLanguage.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug288734TestLanguage.g:69:1: ruleModel : ( ( rule__Model__ConstantsAssignment ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:73:2: ( ( ( rule__Model__ConstantsAssignment ) ) )
            // InternalBug288734TestLanguage.g:74:1: ( ( rule__Model__ConstantsAssignment ) )
            {
            // InternalBug288734TestLanguage.g:74:1: ( ( rule__Model__ConstantsAssignment ) )
            // InternalBug288734TestLanguage.g:75:1: ( rule__Model__ConstantsAssignment )
            {
             before(grammarAccess.getModelAccess().getConstantsAssignment()); 
            // InternalBug288734TestLanguage.g:76:1: ( rule__Model__ConstantsAssignment )
            // InternalBug288734TestLanguage.g:76:2: rule__Model__ConstantsAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Model__ConstantsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getConstantsAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleTConstant"
    // InternalBug288734TestLanguage.g:88:1: entryRuleTConstant : ruleTConstant EOF ;
    public final void entryRuleTConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:89:1: ( ruleTConstant EOF )
            // InternalBug288734TestLanguage.g:90:1: ruleTConstant EOF
            {
             before(grammarAccess.getTConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTConstant();

            state._fsp--;

             after(grammarAccess.getTConstantRule()); 
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
    // $ANTLR end "entryRuleTConstant"


    // $ANTLR start "ruleTConstant"
    // InternalBug288734TestLanguage.g:97:1: ruleTConstant : ( ( rule__TConstant__Alternatives ) ) ;
    public final void ruleTConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:101:2: ( ( ( rule__TConstant__Alternatives ) ) )
            // InternalBug288734TestLanguage.g:102:1: ( ( rule__TConstant__Alternatives ) )
            {
            // InternalBug288734TestLanguage.g:102:1: ( ( rule__TConstant__Alternatives ) )
            // InternalBug288734TestLanguage.g:103:1: ( rule__TConstant__Alternatives )
            {
             before(grammarAccess.getTConstantAccess().getAlternatives()); 
            // InternalBug288734TestLanguage.g:104:1: ( rule__TConstant__Alternatives )
            // InternalBug288734TestLanguage.g:104:2: rule__TConstant__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TConstant__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTConstantAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTConstant"


    // $ANTLR start "entryRuleTStringConstant"
    // InternalBug288734TestLanguage.g:116:1: entryRuleTStringConstant : ruleTStringConstant EOF ;
    public final void entryRuleTStringConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:117:1: ( ruleTStringConstant EOF )
            // InternalBug288734TestLanguage.g:118:1: ruleTStringConstant EOF
            {
             before(grammarAccess.getTStringConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTStringConstant();

            state._fsp--;

             after(grammarAccess.getTStringConstantRule()); 
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
    // $ANTLR end "entryRuleTStringConstant"


    // $ANTLR start "ruleTStringConstant"
    // InternalBug288734TestLanguage.g:125:1: ruleTStringConstant : ( ( rule__TStringConstant__Group__0 ) ) ;
    public final void ruleTStringConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:129:2: ( ( ( rule__TStringConstant__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:130:1: ( ( rule__TStringConstant__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:130:1: ( ( rule__TStringConstant__Group__0 ) )
            // InternalBug288734TestLanguage.g:131:1: ( rule__TStringConstant__Group__0 )
            {
             before(grammarAccess.getTStringConstantAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:132:1: ( rule__TStringConstant__Group__0 )
            // InternalBug288734TestLanguage.g:132:2: rule__TStringConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTStringConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTStringConstant"


    // $ANTLR start "entryRuleTIntegerConstant"
    // InternalBug288734TestLanguage.g:144:1: entryRuleTIntegerConstant : ruleTIntegerConstant EOF ;
    public final void entryRuleTIntegerConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:145:1: ( ruleTIntegerConstant EOF )
            // InternalBug288734TestLanguage.g:146:1: ruleTIntegerConstant EOF
            {
             before(grammarAccess.getTIntegerConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTIntegerConstant();

            state._fsp--;

             after(grammarAccess.getTIntegerConstantRule()); 
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
    // $ANTLR end "entryRuleTIntegerConstant"


    // $ANTLR start "ruleTIntegerConstant"
    // InternalBug288734TestLanguage.g:153:1: ruleTIntegerConstant : ( ( rule__TIntegerConstant__Group__0 ) ) ;
    public final void ruleTIntegerConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:157:2: ( ( ( rule__TIntegerConstant__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:158:1: ( ( rule__TIntegerConstant__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:158:1: ( ( rule__TIntegerConstant__Group__0 ) )
            // InternalBug288734TestLanguage.g:159:1: ( rule__TIntegerConstant__Group__0 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:160:1: ( rule__TIntegerConstant__Group__0 )
            // InternalBug288734TestLanguage.g:160:2: rule__TIntegerConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTIntegerConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTIntegerConstant"


    // $ANTLR start "entryRuleTBooleanConstant"
    // InternalBug288734TestLanguage.g:172:1: entryRuleTBooleanConstant : ruleTBooleanConstant EOF ;
    public final void entryRuleTBooleanConstant() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:173:1: ( ruleTBooleanConstant EOF )
            // InternalBug288734TestLanguage.g:174:1: ruleTBooleanConstant EOF
            {
             before(grammarAccess.getTBooleanConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTBooleanConstant();

            state._fsp--;

             after(grammarAccess.getTBooleanConstantRule()); 
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
    // $ANTLR end "entryRuleTBooleanConstant"


    // $ANTLR start "ruleTBooleanConstant"
    // InternalBug288734TestLanguage.g:181:1: ruleTBooleanConstant : ( ( rule__TBooleanConstant__Group__0 ) ) ;
    public final void ruleTBooleanConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:185:2: ( ( ( rule__TBooleanConstant__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:186:1: ( ( rule__TBooleanConstant__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:186:1: ( ( rule__TBooleanConstant__Group__0 ) )
            // InternalBug288734TestLanguage.g:187:1: ( rule__TBooleanConstant__Group__0 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:188:1: ( rule__TBooleanConstant__Group__0 )
            // InternalBug288734TestLanguage.g:188:2: rule__TBooleanConstant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTBooleanConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTBooleanConstant"


    // $ANTLR start "entryRuleTAnnotation"
    // InternalBug288734TestLanguage.g:200:1: entryRuleTAnnotation : ruleTAnnotation EOF ;
    public final void entryRuleTAnnotation() throws RecognitionException {
        try {
            // InternalBug288734TestLanguage.g:201:1: ( ruleTAnnotation EOF )
            // InternalBug288734TestLanguage.g:202:1: ruleTAnnotation EOF
            {
             before(grammarAccess.getTAnnotationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTAnnotationRule()); 
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
    // $ANTLR end "entryRuleTAnnotation"


    // $ANTLR start "ruleTAnnotation"
    // InternalBug288734TestLanguage.g:209:1: ruleTAnnotation : ( ( rule__TAnnotation__Group__0 ) ) ;
    public final void ruleTAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:213:2: ( ( ( rule__TAnnotation__Group__0 ) ) )
            // InternalBug288734TestLanguage.g:214:1: ( ( rule__TAnnotation__Group__0 ) )
            {
            // InternalBug288734TestLanguage.g:214:1: ( ( rule__TAnnotation__Group__0 ) )
            // InternalBug288734TestLanguage.g:215:1: ( rule__TAnnotation__Group__0 )
            {
             before(grammarAccess.getTAnnotationAccess().getGroup()); 
            // InternalBug288734TestLanguage.g:216:1: ( rule__TAnnotation__Group__0 )
            // InternalBug288734TestLanguage.g:216:2: rule__TAnnotation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTAnnotation"


    // $ANTLR start "rule__TConstant__Alternatives"
    // InternalBug288734TestLanguage.g:228:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );
    public final void rule__TConstant__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:232:1: ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalBug288734TestLanguage.g:233:1: ( ruleTStringConstant )
                    {
                    // InternalBug288734TestLanguage.g:233:1: ( ruleTStringConstant )
                    // InternalBug288734TestLanguage.g:234:1: ruleTStringConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTStringConstant();

                    state._fsp--;

                     after(grammarAccess.getTConstantAccess().getTStringConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug288734TestLanguage.g:239:6: ( ruleTIntegerConstant )
                    {
                    // InternalBug288734TestLanguage.g:239:6: ( ruleTIntegerConstant )
                    // InternalBug288734TestLanguage.g:240:1: ruleTIntegerConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTIntegerConstant();

                    state._fsp--;

                     after(grammarAccess.getTConstantAccess().getTIntegerConstantParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBug288734TestLanguage.g:245:6: ( ruleTBooleanConstant )
                    {
                    // InternalBug288734TestLanguage.g:245:6: ( ruleTBooleanConstant )
                    // InternalBug288734TestLanguage.g:246:1: ruleTBooleanConstant
                    {
                     before(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleTBooleanConstant();

                    state._fsp--;

                     after(grammarAccess.getTConstantAccess().getTBooleanConstantParserRuleCall_2()); 

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
    // $ANTLR end "rule__TConstant__Alternatives"


    // $ANTLR start "rule__TStringConstant__Group__0"
    // InternalBug288734TestLanguage.g:258:1: rule__TStringConstant__Group__0 : rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1 ;
    public final void rule__TStringConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:262:1: ( rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1 )
            // InternalBug288734TestLanguage.g:263:2: rule__TStringConstant__Group__0__Impl rule__TStringConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TStringConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__0"


    // $ANTLR start "rule__TStringConstant__Group__0__Impl"
    // InternalBug288734TestLanguage.g:270:1: rule__TStringConstant__Group__0__Impl : ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TStringConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:274:1: ( ( ( rule__TStringConstant__AnnotationsAssignment_0 )* ) )
            // InternalBug288734TestLanguage.g:275:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* )
            {
            // InternalBug288734TestLanguage.g:275:1: ( ( rule__TStringConstant__AnnotationsAssignment_0 )* )
            // InternalBug288734TestLanguage.g:276:1: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0()); 
            // InternalBug288734TestLanguage.g:277:1: ( rule__TStringConstant__AnnotationsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:277:2: rule__TStringConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__TStringConstant__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTStringConstantAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__0__Impl"


    // $ANTLR start "rule__TStringConstant__Group__1"
    // InternalBug288734TestLanguage.g:287:1: rule__TStringConstant__Group__1 : rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2 ;
    public final void rule__TStringConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:291:1: ( rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2 )
            // InternalBug288734TestLanguage.g:292:2: rule__TStringConstant__Group__1__Impl rule__TStringConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__TStringConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__1"


    // $ANTLR start "rule__TStringConstant__Group__1__Impl"
    // InternalBug288734TestLanguage.g:299:1: rule__TStringConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TStringConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:303:1: ( ( 'constant' ) )
            // InternalBug288734TestLanguage.g:304:1: ( 'constant' )
            {
            // InternalBug288734TestLanguage.g:304:1: ( 'constant' )
            // InternalBug288734TestLanguage.g:305:1: 'constant'
            {
             before(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTStringConstantAccess().getConstantKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__1__Impl"


    // $ANTLR start "rule__TStringConstant__Group__2"
    // InternalBug288734TestLanguage.g:318:1: rule__TStringConstant__Group__2 : rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3 ;
    public final void rule__TStringConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:322:1: ( rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3 )
            // InternalBug288734TestLanguage.g:323:2: rule__TStringConstant__Group__2__Impl rule__TStringConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TStringConstant__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__2"


    // $ANTLR start "rule__TStringConstant__Group__2__Impl"
    // InternalBug288734TestLanguage.g:330:1: rule__TStringConstant__Group__2__Impl : ( 'string' ) ;
    public final void rule__TStringConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:334:1: ( ( 'string' ) )
            // InternalBug288734TestLanguage.g:335:1: ( 'string' )
            {
            // InternalBug288734TestLanguage.g:335:1: ( 'string' )
            // InternalBug288734TestLanguage.g:336:1: 'string'
            {
             before(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 
            match(input,12,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTStringConstantAccess().getStringKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__2__Impl"


    // $ANTLR start "rule__TStringConstant__Group__3"
    // InternalBug288734TestLanguage.g:349:1: rule__TStringConstant__Group__3 : rule__TStringConstant__Group__3__Impl ;
    public final void rule__TStringConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:353:1: ( rule__TStringConstant__Group__3__Impl )
            // InternalBug288734TestLanguage.g:354:2: rule__TStringConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__3"


    // $ANTLR start "rule__TStringConstant__Group__3__Impl"
    // InternalBug288734TestLanguage.g:360:1: rule__TStringConstant__Group__3__Impl : ( ( rule__TStringConstant__NameAssignment_3 ) ) ;
    public final void rule__TStringConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:364:1: ( ( ( rule__TStringConstant__NameAssignment_3 ) ) )
            // InternalBug288734TestLanguage.g:365:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            {
            // InternalBug288734TestLanguage.g:365:1: ( ( rule__TStringConstant__NameAssignment_3 ) )
            // InternalBug288734TestLanguage.g:366:1: ( rule__TStringConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTStringConstantAccess().getNameAssignment_3()); 
            // InternalBug288734TestLanguage.g:367:1: ( rule__TStringConstant__NameAssignment_3 )
            // InternalBug288734TestLanguage.g:367:2: rule__TStringConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TStringConstant__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTStringConstantAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__Group__3__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__0"
    // InternalBug288734TestLanguage.g:385:1: rule__TIntegerConstant__Group__0 : rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1 ;
    public final void rule__TIntegerConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:389:1: ( rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1 )
            // InternalBug288734TestLanguage.g:390:2: rule__TIntegerConstant__Group__0__Impl rule__TIntegerConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TIntegerConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__0"


    // $ANTLR start "rule__TIntegerConstant__Group__0__Impl"
    // InternalBug288734TestLanguage.g:397:1: rule__TIntegerConstant__Group__0__Impl : ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TIntegerConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:401:1: ( ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* ) )
            // InternalBug288734TestLanguage.g:402:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* )
            {
            // InternalBug288734TestLanguage.g:402:1: ( ( rule__TIntegerConstant__AnnotationsAssignment_0 )* )
            // InternalBug288734TestLanguage.g:403:1: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0()); 
            // InternalBug288734TestLanguage.g:404:1: ( rule__TIntegerConstant__AnnotationsAssignment_0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:404:2: rule__TIntegerConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__TIntegerConstant__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTIntegerConstantAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__0__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__1"
    // InternalBug288734TestLanguage.g:414:1: rule__TIntegerConstant__Group__1 : rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2 ;
    public final void rule__TIntegerConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:418:1: ( rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2 )
            // InternalBug288734TestLanguage.g:419:2: rule__TIntegerConstant__Group__1__Impl rule__TIntegerConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_7);
            rule__TIntegerConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__1"


    // $ANTLR start "rule__TIntegerConstant__Group__1__Impl"
    // InternalBug288734TestLanguage.g:426:1: rule__TIntegerConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TIntegerConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:430:1: ( ( 'constant' ) )
            // InternalBug288734TestLanguage.g:431:1: ( 'constant' )
            {
            // InternalBug288734TestLanguage.g:431:1: ( 'constant' )
            // InternalBug288734TestLanguage.g:432:1: 'constant'
            {
             before(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTIntegerConstantAccess().getConstantKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__1__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__2"
    // InternalBug288734TestLanguage.g:445:1: rule__TIntegerConstant__Group__2 : rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3 ;
    public final void rule__TIntegerConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:449:1: ( rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3 )
            // InternalBug288734TestLanguage.g:450:2: rule__TIntegerConstant__Group__2__Impl rule__TIntegerConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TIntegerConstant__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__2"


    // $ANTLR start "rule__TIntegerConstant__Group__2__Impl"
    // InternalBug288734TestLanguage.g:457:1: rule__TIntegerConstant__Group__2__Impl : ( 'integer' ) ;
    public final void rule__TIntegerConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:461:1: ( ( 'integer' ) )
            // InternalBug288734TestLanguage.g:462:1: ( 'integer' )
            {
            // InternalBug288734TestLanguage.g:462:1: ( 'integer' )
            // InternalBug288734TestLanguage.g:463:1: 'integer'
            {
             before(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTIntegerConstantAccess().getIntegerKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__2__Impl"


    // $ANTLR start "rule__TIntegerConstant__Group__3"
    // InternalBug288734TestLanguage.g:476:1: rule__TIntegerConstant__Group__3 : rule__TIntegerConstant__Group__3__Impl ;
    public final void rule__TIntegerConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:480:1: ( rule__TIntegerConstant__Group__3__Impl )
            // InternalBug288734TestLanguage.g:481:2: rule__TIntegerConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__3"


    // $ANTLR start "rule__TIntegerConstant__Group__3__Impl"
    // InternalBug288734TestLanguage.g:487:1: rule__TIntegerConstant__Group__3__Impl : ( ( rule__TIntegerConstant__NameAssignment_3 ) ) ;
    public final void rule__TIntegerConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:491:1: ( ( ( rule__TIntegerConstant__NameAssignment_3 ) ) )
            // InternalBug288734TestLanguage.g:492:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            {
            // InternalBug288734TestLanguage.g:492:1: ( ( rule__TIntegerConstant__NameAssignment_3 ) )
            // InternalBug288734TestLanguage.g:493:1: ( rule__TIntegerConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3()); 
            // InternalBug288734TestLanguage.g:494:1: ( rule__TIntegerConstant__NameAssignment_3 )
            // InternalBug288734TestLanguage.g:494:2: rule__TIntegerConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TIntegerConstant__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTIntegerConstantAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__Group__3__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__0"
    // InternalBug288734TestLanguage.g:512:1: rule__TBooleanConstant__Group__0 : rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1 ;
    public final void rule__TBooleanConstant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:516:1: ( rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1 )
            // InternalBug288734TestLanguage.g:517:2: rule__TBooleanConstant__Group__0__Impl rule__TBooleanConstant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__TBooleanConstant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__0"


    // $ANTLR start "rule__TBooleanConstant__Group__0__Impl"
    // InternalBug288734TestLanguage.g:524:1: rule__TBooleanConstant__Group__0__Impl : ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) ;
    public final void rule__TBooleanConstant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:528:1: ( ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* ) )
            // InternalBug288734TestLanguage.g:529:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* )
            {
            // InternalBug288734TestLanguage.g:529:1: ( ( rule__TBooleanConstant__AnnotationsAssignment_0 )* )
            // InternalBug288734TestLanguage.g:530:1: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0()); 
            // InternalBug288734TestLanguage.g:531:1: ( rule__TBooleanConstant__AnnotationsAssignment_0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug288734TestLanguage.g:531:2: rule__TBooleanConstant__AnnotationsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    rule__TBooleanConstant__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getTBooleanConstantAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__0__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__1"
    // InternalBug288734TestLanguage.g:541:1: rule__TBooleanConstant__Group__1 : rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2 ;
    public final void rule__TBooleanConstant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:545:1: ( rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2 )
            // InternalBug288734TestLanguage.g:546:2: rule__TBooleanConstant__Group__1__Impl rule__TBooleanConstant__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_8);
            rule__TBooleanConstant__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__1"


    // $ANTLR start "rule__TBooleanConstant__Group__1__Impl"
    // InternalBug288734TestLanguage.g:553:1: rule__TBooleanConstant__Group__1__Impl : ( 'constant' ) ;
    public final void rule__TBooleanConstant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:557:1: ( ( 'constant' ) )
            // InternalBug288734TestLanguage.g:558:1: ( 'constant' )
            {
            // InternalBug288734TestLanguage.g:558:1: ( 'constant' )
            // InternalBug288734TestLanguage.g:559:1: 'constant'
            {
             before(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTBooleanConstantAccess().getConstantKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__1__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__2"
    // InternalBug288734TestLanguage.g:572:1: rule__TBooleanConstant__Group__2 : rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3 ;
    public final void rule__TBooleanConstant__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:576:1: ( rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3 )
            // InternalBug288734TestLanguage.g:577:2: rule__TBooleanConstant__Group__2__Impl rule__TBooleanConstant__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__TBooleanConstant__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__2"


    // $ANTLR start "rule__TBooleanConstant__Group__2__Impl"
    // InternalBug288734TestLanguage.g:584:1: rule__TBooleanConstant__Group__2__Impl : ( 'boolean' ) ;
    public final void rule__TBooleanConstant__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:588:1: ( ( 'boolean' ) )
            // InternalBug288734TestLanguage.g:589:1: ( 'boolean' )
            {
            // InternalBug288734TestLanguage.g:589:1: ( 'boolean' )
            // InternalBug288734TestLanguage.g:590:1: 'boolean'
            {
             before(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTBooleanConstantAccess().getBooleanKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__2__Impl"


    // $ANTLR start "rule__TBooleanConstant__Group__3"
    // InternalBug288734TestLanguage.g:603:1: rule__TBooleanConstant__Group__3 : rule__TBooleanConstant__Group__3__Impl ;
    public final void rule__TBooleanConstant__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:607:1: ( rule__TBooleanConstant__Group__3__Impl )
            // InternalBug288734TestLanguage.g:608:2: rule__TBooleanConstant__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__3"


    // $ANTLR start "rule__TBooleanConstant__Group__3__Impl"
    // InternalBug288734TestLanguage.g:614:1: rule__TBooleanConstant__Group__3__Impl : ( ( rule__TBooleanConstant__NameAssignment_3 ) ) ;
    public final void rule__TBooleanConstant__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:618:1: ( ( ( rule__TBooleanConstant__NameAssignment_3 ) ) )
            // InternalBug288734TestLanguage.g:619:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            {
            // InternalBug288734TestLanguage.g:619:1: ( ( rule__TBooleanConstant__NameAssignment_3 ) )
            // InternalBug288734TestLanguage.g:620:1: ( rule__TBooleanConstant__NameAssignment_3 )
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3()); 
            // InternalBug288734TestLanguage.g:621:1: ( rule__TBooleanConstant__NameAssignment_3 )
            // InternalBug288734TestLanguage.g:621:2: rule__TBooleanConstant__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TBooleanConstant__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTBooleanConstantAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__Group__3__Impl"


    // $ANTLR start "rule__TAnnotation__Group__0"
    // InternalBug288734TestLanguage.g:639:1: rule__TAnnotation__Group__0 : rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1 ;
    public final void rule__TAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:643:1: ( rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1 )
            // InternalBug288734TestLanguage.g:644:2: rule__TAnnotation__Group__0__Impl rule__TAnnotation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_9);
            rule__TAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TAnnotation__Group__0"


    // $ANTLR start "rule__TAnnotation__Group__0__Impl"
    // InternalBug288734TestLanguage.g:651:1: rule__TAnnotation__Group__0__Impl : ( '@desc' ) ;
    public final void rule__TAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:655:1: ( ( '@desc' ) )
            // InternalBug288734TestLanguage.g:656:1: ( '@desc' )
            {
            // InternalBug288734TestLanguage.g:656:1: ( '@desc' )
            // InternalBug288734TestLanguage.g:657:1: '@desc'
            {
             before(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 
            match(input,15,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTAnnotationAccess().getDescKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TAnnotation__Group__0__Impl"


    // $ANTLR start "rule__TAnnotation__Group__1"
    // InternalBug288734TestLanguage.g:670:1: rule__TAnnotation__Group__1 : rule__TAnnotation__Group__1__Impl ;
    public final void rule__TAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:674:1: ( rule__TAnnotation__Group__1__Impl )
            // InternalBug288734TestLanguage.g:675:2: rule__TAnnotation__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TAnnotation__Group__1"


    // $ANTLR start "rule__TAnnotation__Group__1__Impl"
    // InternalBug288734TestLanguage.g:681:1: rule__TAnnotation__Group__1__Impl : ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) ;
    public final void rule__TAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:685:1: ( ( ( rule__TAnnotation__DescriptionAssignment_1 ) ) )
            // InternalBug288734TestLanguage.g:686:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            {
            // InternalBug288734TestLanguage.g:686:1: ( ( rule__TAnnotation__DescriptionAssignment_1 ) )
            // InternalBug288734TestLanguage.g:687:1: ( rule__TAnnotation__DescriptionAssignment_1 )
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1()); 
            // InternalBug288734TestLanguage.g:688:1: ( rule__TAnnotation__DescriptionAssignment_1 )
            // InternalBug288734TestLanguage.g:688:2: rule__TAnnotation__DescriptionAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__TAnnotation__DescriptionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTAnnotationAccess().getDescriptionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TAnnotation__Group__1__Impl"


    // $ANTLR start "rule__Model__ConstantsAssignment"
    // InternalBug288734TestLanguage.g:703:1: rule__Model__ConstantsAssignment : ( ruleTConstant ) ;
    public final void rule__Model__ConstantsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:707:1: ( ( ruleTConstant ) )
            // InternalBug288734TestLanguage.g:708:1: ( ruleTConstant )
            {
            // InternalBug288734TestLanguage.g:708:1: ( ruleTConstant )
            // InternalBug288734TestLanguage.g:709:1: ruleTConstant
            {
             before(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTConstant();

            state._fsp--;

             after(grammarAccess.getModelAccess().getConstantsTConstantParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ConstantsAssignment"


    // $ANTLR start "rule__TStringConstant__AnnotationsAssignment_0"
    // InternalBug288734TestLanguage.g:718:1: rule__TStringConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TStringConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:722:1: ( ( ruleTAnnotation ) )
            // InternalBug288734TestLanguage.g:723:1: ( ruleTAnnotation )
            {
            // InternalBug288734TestLanguage.g:723:1: ( ruleTAnnotation )
            // InternalBug288734TestLanguage.g:724:1: ruleTAnnotation
            {
             before(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTStringConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__AnnotationsAssignment_0"


    // $ANTLR start "rule__TStringConstant__NameAssignment_3"
    // InternalBug288734TestLanguage.g:733:1: rule__TStringConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TStringConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:737:1: ( ( RULE_ID ) )
            // InternalBug288734TestLanguage.g:738:1: ( RULE_ID )
            {
            // InternalBug288734TestLanguage.g:738:1: ( RULE_ID )
            // InternalBug288734TestLanguage.g:739:1: RULE_ID
            {
             before(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTStringConstantAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TStringConstant__NameAssignment_3"


    // $ANTLR start "rule__TIntegerConstant__AnnotationsAssignment_0"
    // InternalBug288734TestLanguage.g:748:1: rule__TIntegerConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TIntegerConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:752:1: ( ( ruleTAnnotation ) )
            // InternalBug288734TestLanguage.g:753:1: ( ruleTAnnotation )
            {
            // InternalBug288734TestLanguage.g:753:1: ( ruleTAnnotation )
            // InternalBug288734TestLanguage.g:754:1: ruleTAnnotation
            {
             before(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTIntegerConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__AnnotationsAssignment_0"


    // $ANTLR start "rule__TIntegerConstant__NameAssignment_3"
    // InternalBug288734TestLanguage.g:763:1: rule__TIntegerConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TIntegerConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:767:1: ( ( RULE_ID ) )
            // InternalBug288734TestLanguage.g:768:1: ( RULE_ID )
            {
            // InternalBug288734TestLanguage.g:768:1: ( RULE_ID )
            // InternalBug288734TestLanguage.g:769:1: RULE_ID
            {
             before(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTIntegerConstantAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TIntegerConstant__NameAssignment_3"


    // $ANTLR start "rule__TBooleanConstant__AnnotationsAssignment_0"
    // InternalBug288734TestLanguage.g:778:1: rule__TBooleanConstant__AnnotationsAssignment_0 : ( ruleTAnnotation ) ;
    public final void rule__TBooleanConstant__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:782:1: ( ( ruleTAnnotation ) )
            // InternalBug288734TestLanguage.g:783:1: ( ruleTAnnotation )
            {
            // InternalBug288734TestLanguage.g:783:1: ( ruleTAnnotation )
            // InternalBug288734TestLanguage.g:784:1: ruleTAnnotation
            {
             before(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTAnnotation();

            state._fsp--;

             after(grammarAccess.getTBooleanConstantAccess().getAnnotationsTAnnotationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__AnnotationsAssignment_0"


    // $ANTLR start "rule__TBooleanConstant__NameAssignment_3"
    // InternalBug288734TestLanguage.g:793:1: rule__TBooleanConstant__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__TBooleanConstant__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:797:1: ( ( RULE_ID ) )
            // InternalBug288734TestLanguage.g:798:1: ( RULE_ID )
            {
            // InternalBug288734TestLanguage.g:798:1: ( RULE_ID )
            // InternalBug288734TestLanguage.g:799:1: RULE_ID
            {
             before(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTBooleanConstantAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TBooleanConstant__NameAssignment_3"


    // $ANTLR start "rule__TAnnotation__DescriptionAssignment_1"
    // InternalBug288734TestLanguage.g:808:1: rule__TAnnotation__DescriptionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__TAnnotation__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug288734TestLanguage.g:812:1: ( ( RULE_STRING ) )
            // InternalBug288734TestLanguage.g:813:1: ( RULE_STRING )
            {
            // InternalBug288734TestLanguage.g:813:1: ( RULE_STRING )
            // InternalBug288734TestLanguage.g:814:1: RULE_STRING
            {
             before(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getTAnnotationAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TAnnotation__DescriptionAssignment_1"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\7\uffff";
    static final String DFA1_eofS =
        "\7\uffff";
    static final String DFA1_minS =
        "\1\13\1\5\1\14\1\13\3\uffff";
    static final String DFA1_maxS =
        "\1\17\1\5\1\16\1\17\3\uffff";
    static final String DFA1_acceptS =
        "\4\uffff\1\2\1\1\1\3";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\2\3\uffff\1\1",
            "\1\3",
            "\1\5\1\4\1\6",
            "\1\2\3\uffff\1\1",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "228:1: rule__TConstant__Alternatives : ( ( ruleTStringConstant ) | ( ruleTIntegerConstant ) | ( ruleTBooleanConstant ) );";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    }


}