package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug307519TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug307519TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Foo", "T1", "T2", "DollarSign", "PercentSign", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=9;
    public static final int RULE_STRING=11;
    public static final int DollarSign=7;
    public static final int T1=5;
    public static final int RULE_ANY_OTHER=15;
    public static final int T2=6;
    public static final int RULE_INT=10;
    public static final int Foo=4;
    public static final int RULE_WS=14;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
    public static final int PercentSign=8;
    public static final int RULE_ML_COMMENT=12;

    // delegates
    // delegators


        public InternalBug307519TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug307519TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug307519TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug307519TestLanguageParser.g"; }


     
     	private Bug307519TestLanguageGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("DollarSign", "'\u0024'");
    		tokenNameToValue.put("PercentSign", "'%'");
    		tokenNameToValue.put("T1", "'T1'");
    		tokenNameToValue.put("T2", "'T2'");
    		tokenNameToValue.put("Foo", "'foo'");
     	}
     	
        public void setGrammarAccess(Bug307519TestLanguageGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRuleModel"
    // InternalBug307519TestLanguageParser.g:68:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalBug307519TestLanguageParser.g:69:1: ( ruleModel EOF )
            // InternalBug307519TestLanguageParser.g:70:1: ruleModel EOF
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
    // InternalBug307519TestLanguageParser.g:77:1: ruleModel : ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:81:5: ( ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) )
            // InternalBug307519TestLanguageParser.g:82:1: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            {
            // InternalBug307519TestLanguageParser.g:82:1: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            // InternalBug307519TestLanguageParser.g:83:1: ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* )
            {
            // InternalBug307519TestLanguageParser.g:83:1: ( ( rule__Model__Alternatives ) )
            // InternalBug307519TestLanguageParser.g:84:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug307519TestLanguageParser.g:85:1: ( rule__Model__Alternatives )
            // InternalBug307519TestLanguageParser.g:85:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_3);
            rule__Model__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }

            // InternalBug307519TestLanguageParser.g:88:1: ( ( rule__Model__Alternatives )* )
            // InternalBug307519TestLanguageParser.g:89:1: ( rule__Model__Alternatives )*
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // InternalBug307519TestLanguageParser.g:90:1: ( rule__Model__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=T1 && LA1_0<=T2)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug307519TestLanguageParser.g:90:2: rule__Model__Alternatives
            	    {
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    rule__Model__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

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


    // $ANTLR start "entryRuleElem1"
    // InternalBug307519TestLanguageParser.g:103:1: entryRuleElem1 : ruleElem1 EOF ;
    public final void entryRuleElem1() throws RecognitionException {
        try {
            // InternalBug307519TestLanguageParser.g:104:1: ( ruleElem1 EOF )
            // InternalBug307519TestLanguageParser.g:105:1: ruleElem1 EOF
            {
             before(grammarAccess.getElem1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElem1();

            state._fsp--;

             after(grammarAccess.getElem1Rule()); 
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
    // $ANTLR end "entryRuleElem1"


    // $ANTLR start "ruleElem1"
    // InternalBug307519TestLanguageParser.g:112:1: ruleElem1 : ( ( rule__Elem1__ValueAssignment ) ) ;
    public final void ruleElem1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:116:5: ( ( ( rule__Elem1__ValueAssignment ) ) )
            // InternalBug307519TestLanguageParser.g:117:1: ( ( rule__Elem1__ValueAssignment ) )
            {
            // InternalBug307519TestLanguageParser.g:117:1: ( ( rule__Elem1__ValueAssignment ) )
            // InternalBug307519TestLanguageParser.g:118:1: ( rule__Elem1__ValueAssignment )
            {
             before(grammarAccess.getElem1Access().getValueAssignment()); 
            // InternalBug307519TestLanguageParser.g:119:1: ( rule__Elem1__ValueAssignment )
            // InternalBug307519TestLanguageParser.g:119:2: rule__Elem1__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem1__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getElem1Access().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElem1"


    // $ANTLR start "entryRuleElem2"
    // InternalBug307519TestLanguageParser.g:131:1: entryRuleElem2 : ruleElem2 EOF ;
    public final void entryRuleElem2() throws RecognitionException {
        try {
            // InternalBug307519TestLanguageParser.g:132:1: ( ruleElem2 EOF )
            // InternalBug307519TestLanguageParser.g:133:1: ruleElem2 EOF
            {
             before(grammarAccess.getElem2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElem2();

            state._fsp--;

             after(grammarAccess.getElem2Rule()); 
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
    // $ANTLR end "entryRuleElem2"


    // $ANTLR start "ruleElem2"
    // InternalBug307519TestLanguageParser.g:140:1: ruleElem2 : ( ( rule__Elem2__Group__0 ) ) ;
    public final void ruleElem2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:144:5: ( ( ( rule__Elem2__Group__0 ) ) )
            // InternalBug307519TestLanguageParser.g:145:1: ( ( rule__Elem2__Group__0 ) )
            {
            // InternalBug307519TestLanguageParser.g:145:1: ( ( rule__Elem2__Group__0 ) )
            // InternalBug307519TestLanguageParser.g:146:1: ( rule__Elem2__Group__0 )
            {
             before(grammarAccess.getElem2Access().getGroup()); 
            // InternalBug307519TestLanguageParser.g:147:1: ( rule__Elem2__Group__0 )
            // InternalBug307519TestLanguageParser.g:147:2: rule__Elem2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElem2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElem2"


    // $ANTLR start "ruleEnumT"
    // InternalBug307519TestLanguageParser.g:160:1: ruleEnumT : ( ( rule__EnumT__Alternatives ) ) ;
    public final void ruleEnumT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:164:1: ( ( ( rule__EnumT__Alternatives ) ) )
            // InternalBug307519TestLanguageParser.g:165:1: ( ( rule__EnumT__Alternatives ) )
            {
            // InternalBug307519TestLanguageParser.g:165:1: ( ( rule__EnumT__Alternatives ) )
            // InternalBug307519TestLanguageParser.g:166:1: ( rule__EnumT__Alternatives )
            {
             before(grammarAccess.getEnumTAccess().getAlternatives()); 
            // InternalBug307519TestLanguageParser.g:167:1: ( rule__EnumT__Alternatives )
            // InternalBug307519TestLanguageParser.g:167:2: rule__EnumT__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__EnumT__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEnumTAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumT"


    // $ANTLR start "rule__Model__Alternatives"
    // InternalBug307519TestLanguageParser.g:178:1: rule__Model__Alternatives : ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:182:1: ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==T1) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==Foo) ) {
                    alt2=2;
                }
                else if ( (LA2_1==EOF||(LA2_1>=T1 && LA2_1<=T2)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==T2) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==Foo) ) {
                    alt2=2;
                }
                else if ( (LA2_2==EOF||(LA2_2>=T1 && LA2_2<=T2)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug307519TestLanguageParser.g:183:1: ( ( rule__Model__E1Assignment_0 ) )
                    {
                    // InternalBug307519TestLanguageParser.g:183:1: ( ( rule__Model__E1Assignment_0 ) )
                    // InternalBug307519TestLanguageParser.g:184:1: ( rule__Model__E1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getE1Assignment_0()); 
                    // InternalBug307519TestLanguageParser.g:185:1: ( rule__Model__E1Assignment_0 )
                    // InternalBug307519TestLanguageParser.g:185:2: rule__Model__E1Assignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__E1Assignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getE1Assignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug307519TestLanguageParser.g:189:6: ( ( rule__Model__E2Assignment_1 ) )
                    {
                    // InternalBug307519TestLanguageParser.g:189:6: ( ( rule__Model__E2Assignment_1 ) )
                    // InternalBug307519TestLanguageParser.g:190:1: ( rule__Model__E2Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getE2Assignment_1()); 
                    // InternalBug307519TestLanguageParser.g:191:1: ( rule__Model__E2Assignment_1 )
                    // InternalBug307519TestLanguageParser.g:191:2: rule__Model__E2Assignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_2);
                    rule__Model__E2Assignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getE2Assignment_1()); 

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


    // $ANTLR start "rule__EnumT__Alternatives"
    // InternalBug307519TestLanguageParser.g:200:1: rule__EnumT__Alternatives : ( ( ( T1 ) ) | ( ( T2 ) ) );
    public final void rule__EnumT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:204:1: ( ( ( T1 ) ) | ( ( T2 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==T1) ) {
                alt3=1;
            }
            else if ( (LA3_0==T2) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug307519TestLanguageParser.g:205:1: ( ( T1 ) )
                    {
                    // InternalBug307519TestLanguageParser.g:205:1: ( ( T1 ) )
                    // InternalBug307519TestLanguageParser.g:206:1: ( T1 )
                    {
                     before(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 
                    // InternalBug307519TestLanguageParser.g:207:1: ( T1 )
                    // InternalBug307519TestLanguageParser.g:207:3: T1
                    {
                    match(input,T1,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBug307519TestLanguageParser.g:212:6: ( ( T2 ) )
                    {
                    // InternalBug307519TestLanguageParser.g:212:6: ( ( T2 ) )
                    // InternalBug307519TestLanguageParser.g:213:1: ( T2 )
                    {
                     before(grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1()); 
                    // InternalBug307519TestLanguageParser.g:214:1: ( T2 )
                    // InternalBug307519TestLanguageParser.g:214:3: T2
                    {
                    match(input,T2,FollowSets000.FOLLOW_2); 

                    }

                     after(grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__EnumT__Alternatives"


    // $ANTLR start "rule__Elem2__Group__0"
    // InternalBug307519TestLanguageParser.g:226:1: rule__Elem2__Group__0 : rule__Elem2__Group__0__Impl rule__Elem2__Group__1 ;
    public final void rule__Elem2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:230:1: ( rule__Elem2__Group__0__Impl rule__Elem2__Group__1 )
            // InternalBug307519TestLanguageParser.g:231:2: rule__Elem2__Group__0__Impl rule__Elem2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_4);
            rule__Elem2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__0"


    // $ANTLR start "rule__Elem2__Group__0__Impl"
    // InternalBug307519TestLanguageParser.g:238:1: rule__Elem2__Group__0__Impl : ( ( rule__Elem2__ValueAssignment_0 ) ) ;
    public final void rule__Elem2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:242:1: ( ( ( rule__Elem2__ValueAssignment_0 ) ) )
            // InternalBug307519TestLanguageParser.g:243:1: ( ( rule__Elem2__ValueAssignment_0 ) )
            {
            // InternalBug307519TestLanguageParser.g:243:1: ( ( rule__Elem2__ValueAssignment_0 ) )
            // InternalBug307519TestLanguageParser.g:244:1: ( rule__Elem2__ValueAssignment_0 )
            {
             before(grammarAccess.getElem2Access().getValueAssignment_0()); 
            // InternalBug307519TestLanguageParser.g:245:1: ( rule__Elem2__ValueAssignment_0 )
            // InternalBug307519TestLanguageParser.g:245:2: rule__Elem2__ValueAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__ValueAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getElem2Access().getValueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__0__Impl"


    // $ANTLR start "rule__Elem2__Group__1"
    // InternalBug307519TestLanguageParser.g:255:1: rule__Elem2__Group__1 : rule__Elem2__Group__1__Impl rule__Elem2__Group__2 ;
    public final void rule__Elem2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:259:1: ( rule__Elem2__Group__1__Impl rule__Elem2__Group__2 )
            // InternalBug307519TestLanguageParser.g:260:2: rule__Elem2__Group__1__Impl rule__Elem2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_5);
            rule__Elem2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__1"


    // $ANTLR start "rule__Elem2__Group__1__Impl"
    // InternalBug307519TestLanguageParser.g:267:1: rule__Elem2__Group__1__Impl : ( Foo ) ;
    public final void rule__Elem2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:271:1: ( ( Foo ) )
            // InternalBug307519TestLanguageParser.g:272:1: ( Foo )
            {
            // InternalBug307519TestLanguageParser.g:272:1: ( Foo )
            // InternalBug307519TestLanguageParser.g:273:1: Foo
            {
             before(grammarAccess.getElem2Access().getFooKeyword_1()); 
            match(input,Foo,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElem2Access().getFooKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__1__Impl"


    // $ANTLR start "rule__Elem2__Group__2"
    // InternalBug307519TestLanguageParser.g:286:1: rule__Elem2__Group__2 : rule__Elem2__Group__2__Impl rule__Elem2__Group__3 ;
    public final void rule__Elem2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:290:1: ( rule__Elem2__Group__2__Impl rule__Elem2__Group__3 )
            // InternalBug307519TestLanguageParser.g:291:2: rule__Elem2__Group__2__Impl rule__Elem2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_6);
            rule__Elem2__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__2"


    // $ANTLR start "rule__Elem2__Group__2__Impl"
    // InternalBug307519TestLanguageParser.g:298:1: rule__Elem2__Group__2__Impl : ( PercentSign ) ;
    public final void rule__Elem2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:302:1: ( ( PercentSign ) )
            // InternalBug307519TestLanguageParser.g:303:1: ( PercentSign )
            {
            // InternalBug307519TestLanguageParser.g:303:1: ( PercentSign )
            // InternalBug307519TestLanguageParser.g:304:1: PercentSign
            {
             before(grammarAccess.getElem2Access().getPercentSignKeyword_2()); 
            match(input,PercentSign,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElem2Access().getPercentSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__2__Impl"


    // $ANTLR start "rule__Elem2__Group__3"
    // InternalBug307519TestLanguageParser.g:317:1: rule__Elem2__Group__3 : rule__Elem2__Group__3__Impl ;
    public final void rule__Elem2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:321:1: ( rule__Elem2__Group__3__Impl )
            // InternalBug307519TestLanguageParser.g:322:2: rule__Elem2__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_2);
            rule__Elem2__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__3"


    // $ANTLR start "rule__Elem2__Group__3__Impl"
    // InternalBug307519TestLanguageParser.g:328:1: rule__Elem2__Group__3__Impl : ( DollarSign ) ;
    public final void rule__Elem2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:332:1: ( ( DollarSign ) )
            // InternalBug307519TestLanguageParser.g:333:1: ( DollarSign )
            {
            // InternalBug307519TestLanguageParser.g:333:1: ( DollarSign )
            // InternalBug307519TestLanguageParser.g:334:1: DollarSign
            {
             before(grammarAccess.getElem2Access().getDollarSignKeyword_3()); 
            match(input,DollarSign,FollowSets000.FOLLOW_2); 
             after(grammarAccess.getElem2Access().getDollarSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__Group__3__Impl"


    // $ANTLR start "rule__Model__E1Assignment_0"
    // InternalBug307519TestLanguageParser.g:356:1: rule__Model__E1Assignment_0 : ( ruleElem1 ) ;
    public final void rule__Model__E1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:360:1: ( ( ruleElem1 ) )
            // InternalBug307519TestLanguageParser.g:361:1: ( ruleElem1 )
            {
            // InternalBug307519TestLanguageParser.g:361:1: ( ruleElem1 )
            // InternalBug307519TestLanguageParser.g:362:1: ruleElem1
            {
             before(grammarAccess.getModelAccess().getE1Elem1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElem1();

            state._fsp--;

             after(grammarAccess.getModelAccess().getE1Elem1ParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__E1Assignment_0"


    // $ANTLR start "rule__Model__E2Assignment_1"
    // InternalBug307519TestLanguageParser.g:371:1: rule__Model__E2Assignment_1 : ( ruleElem2 ) ;
    public final void rule__Model__E2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:375:1: ( ( ruleElem2 ) )
            // InternalBug307519TestLanguageParser.g:376:1: ( ruleElem2 )
            {
            // InternalBug307519TestLanguageParser.g:376:1: ( ruleElem2 )
            // InternalBug307519TestLanguageParser.g:377:1: ruleElem2
            {
             before(grammarAccess.getModelAccess().getE2Elem2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleElem2();

            state._fsp--;

             after(grammarAccess.getModelAccess().getE2Elem2ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__E2Assignment_1"


    // $ANTLR start "rule__Elem1__ValueAssignment"
    // InternalBug307519TestLanguageParser.g:386:1: rule__Elem1__ValueAssignment : ( ruleEnumT ) ;
    public final void rule__Elem1__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:390:1: ( ( ruleEnumT ) )
            // InternalBug307519TestLanguageParser.g:391:1: ( ruleEnumT )
            {
            // InternalBug307519TestLanguageParser.g:391:1: ( ruleEnumT )
            // InternalBug307519TestLanguageParser.g:392:1: ruleEnumT
            {
             before(grammarAccess.getElem1Access().getValueEnumTEnumRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumT();

            state._fsp--;

             after(grammarAccess.getElem1Access().getValueEnumTEnumRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem1__ValueAssignment"


    // $ANTLR start "rule__Elem2__ValueAssignment_0"
    // InternalBug307519TestLanguageParser.g:401:1: rule__Elem2__ValueAssignment_0 : ( ruleEnumT ) ;
    public final void rule__Elem2__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalBug307519TestLanguageParser.g:405:1: ( ( ruleEnumT ) )
            // InternalBug307519TestLanguageParser.g:406:1: ( ruleEnumT )
            {
            // InternalBug307519TestLanguageParser.g:406:1: ( ruleEnumT )
            // InternalBug307519TestLanguageParser.g:407:1: ruleEnumT
            {
             before(grammarAccess.getElem2Access().getValueEnumTEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_2);
            ruleEnumT();

            state._fsp--;

             after(grammarAccess.getElem2Access().getValueEnumTEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Elem2__ValueAssignment_0"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000080L});
    }


}