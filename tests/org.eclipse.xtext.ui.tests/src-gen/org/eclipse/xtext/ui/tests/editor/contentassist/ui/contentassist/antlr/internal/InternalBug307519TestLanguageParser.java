package org.eclipse.xtext.ui.tests.editor.contentassist.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
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

public class InternalBug307519TestLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_5", "KEYWORD_3", "KEYWORD_4", "KEYWORD_1", "KEYWORD_2", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "Tokens"
    };
    public static final int RULE_ML_COMMENT=12;
    public static final int RULE_ID=9;
    public static final int KEYWORD_4=6;
    public static final int RULE_WS=14;
    public static final int KEYWORD_1=7;
    public static final int RULE_INT=10;
    public static final int EOF=-1;
    public static final int RULE_STRING=11;
    public static final int KEYWORD_5=4;
    public static final int Tokens=16;
    public static final int RULE_ANY_OTHER=15;
    public static final int KEYWORD_2=8;
    public static final int RULE_SL_COMMENT=13;
    public static final int KEYWORD_3=5;

        public InternalBug307519TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g"; }


     
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



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:69:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:70:1: ( ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:71:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();
            _fsp--;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:78:1: ruleModel : ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:82:5: ( ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:83:1: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:83:1: ( ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:84:1: ( ( rule__Model__Alternatives ) ) ( ( rule__Model__Alternatives )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:84:1: ( ( rule__Model__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:85:1: ( rule__Model__Alternatives )
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:86:1: ( rule__Model__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:86:2: rule__Model__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel93);
            rule__Model__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getAlternatives()); 

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:89:1: ( ( rule__Model__Alternatives )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:90:1: ( rule__Model__Alternatives )*
            {
             before(grammarAccess.getModelAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:91:1: ( rule__Model__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=KEYWORD_3 && LA1_0<=KEYWORD_4)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:91:2: rule__Model__Alternatives
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Model__Alternatives_in_ruleModel105);
            	    rule__Model__Alternatives();
            	    _fsp--;


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleElem1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:104:1: entryRuleElem1 : ruleElem1 EOF ;
    public final void entryRuleElem1() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:105:1: ( ruleElem1 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:106:1: ruleElem1 EOF
            {
             before(grammarAccess.getElem1Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem1_in_entryRuleElem1135);
            ruleElem1();
            _fsp--;

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
    // $ANTLR end entryRuleElem1


    // $ANTLR start ruleElem1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:113:1: ruleElem1 : ( ( rule__Elem1__ValueAssignment ) ) ;
    public final void ruleElem1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:117:5: ( ( ( rule__Elem1__ValueAssignment ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:118:1: ( ( rule__Elem1__ValueAssignment ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:118:1: ( ( rule__Elem1__ValueAssignment ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:119:1: ( rule__Elem1__ValueAssignment )
            {
             before(grammarAccess.getElem1Access().getValueAssignment()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:120:1: ( rule__Elem1__ValueAssignment )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:120:2: rule__Elem1__ValueAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem1__ValueAssignment_in_ruleElem1172);
            rule__Elem1__ValueAssignment();
            _fsp--;


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
    // $ANTLR end ruleElem1


    // $ANTLR start entryRuleElem2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:132:1: entryRuleElem2 : ruleElem2 EOF ;
    public final void entryRuleElem2() throws RecognitionException {
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:133:1: ( ruleElem2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:134:1: ruleElem2 EOF
            {
             before(grammarAccess.getElem2Rule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem2_in_entryRuleElem2199);
            ruleElem2();
            _fsp--;

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
    // $ANTLR end entryRuleElem2


    // $ANTLR start ruleElem2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:141:1: ruleElem2 : ( ( rule__Elem2__Group__0 ) ) ;
    public final void ruleElem2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:145:5: ( ( ( rule__Elem2__Group__0 ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:146:1: ( ( rule__Elem2__Group__0 ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:146:1: ( ( rule__Elem2__Group__0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:147:1: ( rule__Elem2__Group__0 )
            {
             before(grammarAccess.getElem2Access().getGroup()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:148:1: ( rule__Elem2__Group__0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:148:2: rule__Elem2__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__0_in_ruleElem2236);
            rule__Elem2__Group__0();
            _fsp--;


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
    // $ANTLR end ruleElem2


    // $ANTLR start ruleEnumT
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:161:1: ruleEnumT : ( ( rule__EnumT__Alternatives ) ) ;
    public final void ruleEnumT() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:165:1: ( ( ( rule__EnumT__Alternatives ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:166:1: ( ( rule__EnumT__Alternatives ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:166:1: ( ( rule__EnumT__Alternatives ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:167:1: ( rule__EnumT__Alternatives )
            {
             before(grammarAccess.getEnumTAccess().getAlternatives()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:168:1: ( rule__EnumT__Alternatives )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:168:2: rule__EnumT__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EnumT__Alternatives_in_ruleEnumT273);
            rule__EnumT__Alternatives();
            _fsp--;


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
    // $ANTLR end ruleEnumT


    // $ANTLR start rule__Model__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:179:1: rule__Model__Alternatives : ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) );
    public final void rule__Model__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:183:1: ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_3) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==EOF||(LA2_1>=KEYWORD_3 && LA2_1<=KEYWORD_4)) ) {
                    alt2=1;
                }
                else if ( (LA2_1==KEYWORD_5) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("179:1: rule__Model__Alternatives : ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) );", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==KEYWORD_4) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==EOF||(LA2_2>=KEYWORD_3 && LA2_2<=KEYWORD_4)) ) {
                    alt2=1;
                }
                else if ( (LA2_2==KEYWORD_5) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("179:1: rule__Model__Alternatives : ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) );", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("179:1: rule__Model__Alternatives : ( ( ( rule__Model__E1Assignment_0 ) ) | ( ( rule__Model__E2Assignment_1 ) ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:184:1: ( ( rule__Model__E1Assignment_0 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:184:1: ( ( rule__Model__E1Assignment_0 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:185:1: ( rule__Model__E1Assignment_0 )
                    {
                     before(grammarAccess.getModelAccess().getE1Assignment_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:186:1: ( rule__Model__E1Assignment_0 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:186:2: rule__Model__E1Assignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__E1Assignment_0_in_rule__Model__Alternatives308);
                    rule__Model__E1Assignment_0();
                    _fsp--;


                    }

                     after(grammarAccess.getModelAccess().getE1Assignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:190:6: ( ( rule__Model__E2Assignment_1 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:190:6: ( ( rule__Model__E2Assignment_1 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:191:1: ( rule__Model__E2Assignment_1 )
                    {
                     before(grammarAccess.getModelAccess().getE2Assignment_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:192:1: ( rule__Model__E2Assignment_1 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:192:2: rule__Model__E2Assignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Model__E2Assignment_1_in_rule__Model__Alternatives326);
                    rule__Model__E2Assignment_1();
                    _fsp--;


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
    // $ANTLR end rule__Model__Alternatives


    // $ANTLR start rule__EnumT__Alternatives
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:201:1: rule__EnumT__Alternatives : ( ( ( KEYWORD_3 ) ) | ( ( KEYWORD_4 ) ) );
    public final void rule__EnumT__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:205:1: ( ( ( KEYWORD_3 ) ) | ( ( KEYWORD_4 ) ) )
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
                    new NoViableAltException("201:1: rule__EnumT__Alternatives : ( ( ( KEYWORD_3 ) ) | ( ( KEYWORD_4 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:206:1: ( ( KEYWORD_3 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:206:1: ( ( KEYWORD_3 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:207:1: ( KEYWORD_3 )
                    {
                     before(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:208:1: ( KEYWORD_3 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:208:3: KEYWORD_3
                    {
                    match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_rule__EnumT__Alternatives360); 

                    }

                     after(grammarAccess.getEnumTAccess().getT1EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:213:6: ( ( KEYWORD_4 ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:213:6: ( ( KEYWORD_4 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:214:1: ( KEYWORD_4 )
                    {
                     before(grammarAccess.getEnumTAccess().getT2EnumLiteralDeclaration_1()); 
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:215:1: ( KEYWORD_4 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:215:3: KEYWORD_4
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
    // $ANTLR end rule__EnumT__Alternatives


    // $ANTLR start rule__Elem2__Group__0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:227:1: rule__Elem2__Group__0 : ( ( rule__Elem2__ValueAssignment_0 ) ) rule__Elem2__Group__1 ;
    public final void rule__Elem2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:231:1: ( ( ( rule__Elem2__ValueAssignment_0 ) ) rule__Elem2__Group__1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:232:1: ( ( rule__Elem2__ValueAssignment_0 ) ) rule__Elem2__Group__1
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:232:1: ( ( rule__Elem2__ValueAssignment_0 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:233:1: ( rule__Elem2__ValueAssignment_0 )
            {
             before(grammarAccess.getElem2Access().getValueAssignment_0()); 
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:234:1: ( rule__Elem2__ValueAssignment_0 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:234:2: rule__Elem2__ValueAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Elem2__ValueAssignment_0_in_rule__Elem2__Group__0416);
            rule__Elem2__ValueAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getElem2Access().getValueAssignment_0()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__1_in_rule__Elem2__Group__0425);
            rule__Elem2__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Elem2__Group__0


    // $ANTLR start rule__Elem2__Group__1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:245:1: rule__Elem2__Group__1 : ( KEYWORD_5 ) rule__Elem2__Group__2 ;
    public final void rule__Elem2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:249:1: ( ( KEYWORD_5 ) rule__Elem2__Group__2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:250:1: ( KEYWORD_5 ) rule__Elem2__Group__2
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:250:1: ( KEYWORD_5 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:251:1: KEYWORD_5
            {
             before(grammarAccess.getElem2Access().getFooKeyword_1()); 
            match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_rule__Elem2__Group__1454); 
             after(grammarAccess.getElem2Access().getFooKeyword_1()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__2_in_rule__Elem2__Group__1464);
            rule__Elem2__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Elem2__Group__1


    // $ANTLR start rule__Elem2__Group__2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:265:1: rule__Elem2__Group__2 : ( KEYWORD_2 ) rule__Elem2__Group__3 ;
    public final void rule__Elem2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:269:1: ( ( KEYWORD_2 ) rule__Elem2__Group__3 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:270:1: ( KEYWORD_2 ) rule__Elem2__Group__3
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:270:1: ( KEYWORD_2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:271:1: KEYWORD_2
            {
             before(grammarAccess.getElem2Access().getPercentSignKeyword_2()); 
            match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_rule__Elem2__Group__2493); 
             after(grammarAccess.getElem2Access().getPercentSignKeyword_2()); 

            }

            pushFollow(FollowSets000.FOLLOW_rule__Elem2__Group__3_in_rule__Elem2__Group__2503);
            rule__Elem2__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Elem2__Group__2


    // $ANTLR start rule__Elem2__Group__3
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:285:1: rule__Elem2__Group__3 : ( KEYWORD_1 ) ;
    public final void rule__Elem2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:289:1: ( ( KEYWORD_1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:290:1: ( KEYWORD_1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:290:1: ( KEYWORD_1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:291:1: KEYWORD_1
            {
             before(grammarAccess.getElem2Access().getDollarSignKeyword_3()); 
            match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_rule__Elem2__Group__3532); 
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
    // $ANTLR end rule__Elem2__Group__3


    // $ANTLR start rule__Model__E1Assignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:313:1: rule__Model__E1Assignment_0 : ( ruleElem1 ) ;
    public final void rule__Model__E1Assignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:317:1: ( ( ruleElem1 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:318:1: ( ruleElem1 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:318:1: ( ruleElem1 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:319:1: ruleElem1
            {
             before(grammarAccess.getModelAccess().getE1Elem1ParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem1_in_rule__Model__E1Assignment_0576);
            ruleElem1();
            _fsp--;

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
    // $ANTLR end rule__Model__E1Assignment_0


    // $ANTLR start rule__Model__E2Assignment_1
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:328:1: rule__Model__E2Assignment_1 : ( ruleElem2 ) ;
    public final void rule__Model__E2Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:332:1: ( ( ruleElem2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:333:1: ( ruleElem2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:333:1: ( ruleElem2 )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:334:1: ruleElem2
            {
             before(grammarAccess.getModelAccess().getE2Elem2ParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElem2_in_rule__Model__E2Assignment_1607);
            ruleElem2();
            _fsp--;

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
    // $ANTLR end rule__Model__E2Assignment_1


    // $ANTLR start rule__Elem1__ValueAssignment
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:343:1: rule__Elem1__ValueAssignment : ( ruleEnumT ) ;
    public final void rule__Elem1__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:347:1: ( ( ruleEnumT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:348:1: ( ruleEnumT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:348:1: ( ruleEnumT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:349:1: ruleEnumT
            {
             before(grammarAccess.getElem1Access().getValueEnumTEnumRuleCall_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumT_in_rule__Elem1__ValueAssignment638);
            ruleEnumT();
            _fsp--;

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
    // $ANTLR end rule__Elem1__ValueAssignment


    // $ANTLR start rule__Elem2__ValueAssignment_0
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:358:1: rule__Elem2__ValueAssignment_0 : ( ruleEnumT ) ;
    public final void rule__Elem2__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:362:1: ( ( ruleEnumT ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:363:1: ( ruleEnumT )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:363:1: ( ruleEnumT )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/ui/contentassist/antlr/internal/InternalBug307519TestLanguage.g:364:1: ruleEnumT
            {
             before(grammarAccess.getElem2Access().getValueEnumTEnumRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumT_in_rule__Elem2__ValueAssignment_0669);
            ruleEnumT();
            _fsp--;

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
    // $ANTLR end rule__Elem2__ValueAssignment_0


 

    
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
        public static final BitSet FOLLOW_rule__Elem2__ValueAssignment_0_in_rule__Elem2__Group__0416 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Elem2__Group__1_in_rule__Elem2__Group__0425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_5_in_rule__Elem2__Group__1454 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_rule__Elem2__Group__2_in_rule__Elem2__Group__1464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_2_in_rule__Elem2__Group__2493 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__Elem2__Group__3_in_rule__Elem2__Group__2503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_rule__Elem2__Group__3532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElem1_in_rule__Model__E1Assignment_0576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElem2_in_rule__Model__E2Assignment_1607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumT_in_rule__Elem1__ValueAssignment638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumT_in_rule__Elem2__ValueAssignment_0669 = new BitSet(new long[]{0x0000000000000002L});
    }


}