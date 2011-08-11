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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_5", "KEYWORD_3", "KEYWORD_4", "KEYWORD_1", "KEYWORD_2", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=9;
    public static final int RULE_STRING=11;
    public static final int RULE_ANY_OTHER=15;
    public static final int KEYWORD_1=7;
    public static final int RULE_INT=10;
    public static final int KEYWORD_5=4;
    public static final int KEYWORD_4=6;
    public static final int KEYWORD_3=5;
    public static final int KEYWORD_2=8;
    public static final int RULE_WS=14;
    public static final int RULE_SL_COMMENT=13;
    public static final int EOF=-1;
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g"; }


     
     	private Bug307519TestLanguageGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("KEYWORD_1", "'\u0024'");
    		tokenNameToValue.put("KEYWORD_2", "'%'");
    		tokenNameToValue.put("KEYWORD_3", "'T1'");
    		tokenNameToValue.put("KEYWORD_4", "'T2'");
    		tokenNameToValue.put("KEYWORD_5", "'foo'");
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:68:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:69:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:70:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel61); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:77:1: ruleModel : ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:81:5: ( ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:82:1: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:82:1: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:83:1: ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:83:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:84:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:85:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:85:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel93);
            rule__Model__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:88:1: ( ( rule__Model__Alternatives )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:89:1: ( rule__Model__Alternatives )*
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:90:1: ( rule__Model__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=KEYWORD_3 && LA1_0<=KEYWORD_4)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:90:2: rule__Model__Alternatives
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel105);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:103:1: entryRuleElem1 : ruleElem1 EOF ;
    public final void entryRuleElem1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:104:1: ( ruleElem1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:105:1: ruleElem1 EOF
            {
             before(grammarAccess.getElem1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem1_in_entryRuleElem1135);
            ruleElem1();

            state._fsp--;

             after(grammarAccess.getElem1Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElem1142); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:112:1: ruleElem1 : ( ( rule__Elem1__ValueAssignment ) ) ;
    public final void ruleElem1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:116:5: ( ( ( rule__Elem1__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:117:1: ( ( rule__Elem1__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:117:1: ( ( rule__Elem1__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:118:1: ( rule__Elem1__ValueAssignment )
            {
             before(grammarAccess.getElem1Access().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:119:1: ( rule__Elem1__ValueAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:119:2: rule__Elem1__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem1__ValueAssignment_in_ruleElem1172);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:131:1: entryRuleElem2 : ruleElem2 EOF ;
    public final void entryRuleElem2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:132:1: ( ruleElem2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:133:1: ruleElem2 EOF
            {
             before(grammarAccess.getElem2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem2_in_entryRuleElem2199);
            ruleElem2();

            state._fsp--;

             after(grammarAccess.getElem2Rule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElem2206); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:140:1: ruleElem2 : ( ( rule__Elem2__Group__0 ) ) ;
    public final void ruleElem2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:144:5: ( ( ( rule__Elem2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:145:1: ( ( rule__Elem2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:145:1: ( ( rule__Elem2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:146:1: ( rule__Elem2__Group__0 )
            {
             before(grammarAccess.getElem2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:147:1: ( rule__Elem2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:147:2: rule__Elem2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__0_in_ruleElem2236);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:160:1: ruleEnumT : ( ( rule__EnumT__Alternatives ) ) ;
    public final void ruleEnumT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:164:1: ( ( ( rule__EnumT__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:165:1: ( ( rule__EnumT__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:165:1: ( ( rule__EnumT__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:166:1: ( rule__EnumT__Alternatives )
            {
             before(grammarAccess.getEnumTAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:167:1: ( rule__EnumT__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:167:2: rule__EnumT__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumT__Alternatives_in_ruleEnumT273);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:178:1: rule__Model__Alternatives : ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:182:1: ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_3) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==KEYWORD_5) ) {
                    alt2=2;
                }
                else if ( (LA2_1==EOF||(LA2_1>=KEYWORD_3 && LA2_1<=KEYWORD_4)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==KEYWORD_4) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==KEYWORD_5) ) {
                    alt2=2;
                }
                else if ( (LA2_2==EOF||(LA2_2>=KEYWORD_3 && LA2_2<=KEYWORD_4)) ) {
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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:183:1: ( ( rule__Model__E1Assignment_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:183:1: ( ( rule__Model__E1Assignment_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:184:1: ( rule__Model__E1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getE1Assignment_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:185:1: ( rule__Model__E1Assignment_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:185:2: rule__Model__E1Assignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__E1Assignment_0_in_rule__Model__Alternatives308);
                    rule__Model__E1Assignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModelAccess().getE1Assignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:189:6: ( ( rule__Model__E2Assignment_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:189:6: ( ( rule__Model__E2Assignment_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:190:1: ( rule__Model__E2Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getE2Assignment_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:191:1: ( rule__Model__E2Assignment_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:191:2: rule__Model__E2Assignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__E2Assignment_1_in_rule__Model__Alternatives326);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:200:1: rule__EnumT__Alternatives : ( ( ( KEYWORD_3 ) ) | ( ( KEYWORD_4 ) ) );
    public final void rule__EnumT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:204:1: ( ( ( KEYWORD_3 ) ) | ( ( KEYWORD_4 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==KEYWORD_3) ) {
                alt3=1;
            }
            else if ( (LA3_0==KEYWORD_4) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:205:1: ( ( KEYWORD_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:205:1: ( ( KEYWORD_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:206:1: ( KEYWORD_3 )
                    {
                     before(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:207:1: ( KEYWORD_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:207:3: KEYWORD_3
                    {
                    match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_rule__EnumT__Alternatives360); 

                    }

                     after(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:212:6: ( ( KEYWORD_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:212:6: ( ( KEYWORD_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:213:1: ( KEYWORD_4 )
                    {
                     before(grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:214:1: ( KEYWORD_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:214:3: KEYWORD_4
                    {
                    match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_rule__EnumT__Alternatives380); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:226:1: rule__Elem2__Group__0 : rule__Elem2__Group__0__Impl rule__Elem2__Group__1 ;
    public final void rule__Elem2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:230:1: ( rule__Elem2__Group__0__Impl rule__Elem2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:231:2: rule__Elem2__Group__0__Impl rule__Elem2__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__0__Impl_in_rule__Elem2__Group__0412);
            rule__Elem2__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__1_in_rule__Elem2__Group__0415);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:238:1: rule__Elem2__Group__0__Impl : ( ( rule__Elem2__ValueAssignment_0 ) ) ;
    public final void rule__Elem2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:242:1: ( ( ( rule__Elem2__ValueAssignment_0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:243:1: ( ( rule__Elem2__ValueAssignment_0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:243:1: ( ( rule__Elem2__ValueAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:244:1: ( rule__Elem2__ValueAssignment_0 )
            {
             before(grammarAccess.getElem2Access().getValueAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:245:1: ( rule__Elem2__ValueAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:245:2: rule__Elem2__ValueAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__ValueAssignment_0_in_rule__Elem2__Group__0__Impl442);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:255:1: rule__Elem2__Group__1 : rule__Elem2__Group__1__Impl rule__Elem2__Group__2 ;
    public final void rule__Elem2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:259:1: ( rule__Elem2__Group__1__Impl rule__Elem2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:260:2: rule__Elem2__Group__1__Impl rule__Elem2__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__1__Impl_in_rule__Elem2__Group__1472);
            rule__Elem2__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__2_in_rule__Elem2__Group__1475);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:267:1: rule__Elem2__Group__1__Impl : ( KEYWORD_5 ) ;
    public final void rule__Elem2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:271:1: ( ( KEYWORD_5 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:272:1: ( KEYWORD_5 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:272:1: ( KEYWORD_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:273:1: KEYWORD_5
            {
             before(grammarAccess.getElem2Access().getFooKeyword_1()); 
            match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_rule__Elem2__Group__1__Impl503); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:286:1: rule__Elem2__Group__2 : rule__Elem2__Group__2__Impl rule__Elem2__Group__3 ;
    public final void rule__Elem2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:290:1: ( rule__Elem2__Group__2__Impl rule__Elem2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:291:2: rule__Elem2__Group__2__Impl rule__Elem2__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__2__Impl_in_rule__Elem2__Group__2534);
            rule__Elem2__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__3_in_rule__Elem2__Group__2537);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:298:1: rule__Elem2__Group__2__Impl : ( KEYWORD_2 ) ;
    public final void rule__Elem2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:302:1: ( ( KEYWORD_2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:303:1: ( KEYWORD_2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:303:1: ( KEYWORD_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:304:1: KEYWORD_2
            {
             before(grammarAccess.getElem2Access().getPercentSignKeyword_2()); 
            match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_rule__Elem2__Group__2__Impl565); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:317:1: rule__Elem2__Group__3 : rule__Elem2__Group__3__Impl ;
    public final void rule__Elem2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:321:1: ( rule__Elem2__Group__3__Impl )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:322:2: rule__Elem2__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__3__Impl_in_rule__Elem2__Group__3596);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:328:1: rule__Elem2__Group__3__Impl : ( KEYWORD_1 ) ;
    public final void rule__Elem2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:332:1: ( ( KEYWORD_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:333:1: ( KEYWORD_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:333:1: ( KEYWORD_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:334:1: KEYWORD_1
            {
             before(grammarAccess.getElem2Access().getDollarSignKeyword_3()); 
            match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_rule__Elem2__Group__3__Impl624); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:356:1: rule__Model__E1Assignment_0 : ( ruleElem1 ) ;
    public final void rule__Model__E1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:360:1: ( ( ruleElem1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:361:1: ( ruleElem1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:361:1: ( ruleElem1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:362:1: ruleElem1
            {
             before(grammarAccess.getModelAccess().getE1Elem1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem1_in_rule__Model__E1Assignment_0668);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:371:1: rule__Model__E2Assignment_1 : ( ruleElem2 ) ;
    public final void rule__Model__E2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:375:1: ( ( ruleElem2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:376:1: ( ruleElem2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:376:1: ( ruleElem2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:377:1: ruleElem2
            {
             before(grammarAccess.getModelAccess().getE2Elem2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem2_in_rule__Model__E2Assignment_1699);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:386:1: rule__Elem1__ValueAssignment : ( ruleEnumT ) ;
    public final void rule__Elem1__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:390:1: ( ( ruleEnumT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:391:1: ( ruleEnumT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:391:1: ( ruleEnumT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:392:1: ruleEnumT
            {
             before(grammarAccess.getElem1Access().getValueEnumTEnumRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumT_in_rule__Elem1__ValueAssignment730);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:401:1: rule__Elem2__ValueAssignment_0 : ( ruleEnumT ) ;
    public final void rule__Elem2__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:405:1: ( ( ruleEnumT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:406:1: ( ruleEnumT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:406:1: ( ruleEnumT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguageParser.g:407:1: ruleEnumT
            {
             before(grammarAccess.getElem2Access().getValueEnumTEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumT_in_rule__Elem2__ValueAssignment_0761);
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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel93 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_rule__Model__Alternatives_in_ruleModel105 = new BitSet(new long[]{0x0000000000000062L});
        public static final BitSet FOLLOW_ruleElem1_in_entryRuleElem1135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElem1142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Elem1__ValueAssignment_in_ruleElem1172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElem2_in_entryRuleElem2199 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElem2206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Elem2__Group__0_in_ruleElem2236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EnumT__Alternatives_in_ruleEnumT273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__E1Assignment_0_in_rule__Model__Alternatives308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Model__E2Assignment_1_in_rule__Model__Alternatives326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_3_in_rule__EnumT__Alternatives360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_rule__EnumT__Alternatives380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Elem2__Group__0__Impl_in_rule__Elem2__Group__0412 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Elem2__Group__1_in_rule__Elem2__Group__0415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Elem2__ValueAssignment_0_in_rule__Elem2__Group__0__Impl442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Elem2__Group__1__Impl_in_rule__Elem2__Group__1472 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_rule__Elem2__Group__2_in_rule__Elem2__Group__1475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_5_in_rule__Elem2__Group__1__Impl503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Elem2__Group__2__Impl_in_rule__Elem2__Group__2534 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__Elem2__Group__3_in_rule__Elem2__Group__2537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_2_in_rule__Elem2__Group__2__Impl565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Elem2__Group__3__Impl_in_rule__Elem2__Group__3596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_rule__Elem2__Group__3__Impl624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElem1_in_rule__Model__E1Assignment_0668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElem2_in_rule__Model__E2Assignment_1699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumT_in_rule__Elem1__ValueAssignment730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumT_in_rule__Elem2__ValueAssignment_0761 = new BitSet(new long[]{0x0000000000000002L});
    }


}