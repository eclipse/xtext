package org.eclipse.xtext.testlanguages.backtracking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper.UnorderedGroupState;
import org.eclipse.xtext.testlanguages.backtracking.services.BeeLangTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class PsiInternalBeeLangTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOCUMENTATION", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_HEX", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'unit'", "'version'", "'implements'", "','", "'{'", "'source'", "':'", "';'", "'output'", "'provides'", "'requires'", "'env'", "'}'", "'when'", "'name'", "'as'", "'greedy'", "'requires-min'", "'requires-max'", "'/'", "'final'", "'function'", "'('", "'...'", "')'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'~='", "'=='", "'==='", "'!='", "'!=='", "'>='", "'<='", "'>'", "'<'", "'var'", "'val'", "'=>'", "'cached'", "'||'", "'&&'", "'+'", "'-'", "'*'", "'%'", "'..'", "'!'", "'++'", "'--'", "'.'", "'['", "']'", "'with'", "'context'", "'input'", "'properties'", "'builder'", "'this'", "'new'", "'|'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int RULE_HEX=8;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__15=15;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int RULE_DOCUMENTATION=4;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=11;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__77=77;

    // delegates
    // delegators


        public PsiInternalBeeLangTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBeeLangTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[257+1];
             
             
        }
        

    public String[] getTokenNames() { return PsiInternalBeeLangTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBeeLangTestLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

    	protected BeeLangTestLanguageGrammarAccess grammarAccess;

    	protected BeeLangTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalBeeLangTestLanguageParser(PsiBuilder builder, TokenStream input, BeeLangTestLanguageElementTypeProvider elementTypeProvider, BeeLangTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalBeeLangTestLanguage.g:60:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;
        int entryRuleModel_StartIndex = input.index();
        Boolean iv_ruleModel = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:60:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBeeLangTestLanguage.g:61:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getModelElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, entryRuleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalBeeLangTestLanguage.g:67:1: ruleModel returns [Boolean current=false] : ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;
        int ruleModel_StartIndex = input.index();
        Boolean lv_units_0_0 = null;

        Boolean lv_functions_1_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:68:1: ( ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:69:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:69:2: ( ( (lv_units_0_0= ruleUnit ) )* | ( (lv_functions_1_0= ruleFunction ) )* )
            int alt3=2;
            switch ( input.LA(1) ) {
            case RULE_DOCUMENTATION:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==13) ) {
                    alt3=1;
                }
                else if ( (LA3_1==RULE_ID||(LA3_1>=33 && LA3_1<=34)) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                alt3=1;
                }
                break;
            case EOF:
                {
                int LA3_3 = input.LA(2);

                if ( (synpred2_PsiInternalBeeLangTestLanguage()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 33:
            case 34:
                {
                alt3=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:70:3: ( (lv_units_0_0= ruleUnit ) )*
                    {
                    // PsiInternalBeeLangTestLanguage.g:70:3: ( (lv_units_0_0= ruleUnit ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_DOCUMENTATION||LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:71:4: (lv_units_0_0= ruleUnit )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:71:4: (lv_units_0_0= ruleUnit )
                    	    // PsiInternalBeeLangTestLanguage.g:72:5: lv_units_0_0= ruleUnit
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getModel_UnitsUnitParserRuleCall_0_0ElementType());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_3);
                    	    lv_units_0_0=ruleUnit();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      					if(!current) {
                    	      						associateWithSemanticElement();
                    	      						current = true;
                    	      					}
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:86:3: ( (lv_functions_1_0= ruleFunction ) )*
                    {
                    // PsiInternalBeeLangTestLanguage.g:86:3: ( (lv_functions_1_0= ruleFunction ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=RULE_DOCUMENTATION && LA2_0<=RULE_ID)||(LA2_0>=33 && LA2_0<=34)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:87:4: (lv_functions_1_0= ruleFunction )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:87:4: (lv_functions_1_0= ruleFunction )
                    	    // PsiInternalBeeLangTestLanguage.g:88:5: lv_functions_1_0= ruleFunction
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getModel_FunctionsFunctionParserRuleCall_1_0ElementType());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_4);
                    	    lv_functions_1_0=ruleFunction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      					if(!current) {
                    	      						associateWithSemanticElement();
                    	      						current = true;
                    	      					}
                    	      				
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


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
            if ( state.backtracking>0 ) { memoize(input, 2, ruleModel_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleUnit"
    // PsiInternalBeeLangTestLanguage.g:105:1: entryRuleUnit returns [Boolean current=false] : iv_ruleUnit= ruleUnit EOF ;
    public final Boolean entryRuleUnit() throws RecognitionException {
        Boolean current = false;
        int entryRuleUnit_StartIndex = input.index();
        Boolean iv_ruleUnit = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:109:2: (iv_ruleUnit= ruleUnit EOF )
            // PsiInternalBeeLangTestLanguage.g:110:2: iv_ruleUnit= ruleUnit EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnitElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnit=ruleUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, entryRuleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleUnit"


    // $ANTLR start "ruleUnit"
    // PsiInternalBeeLangTestLanguage.g:119:1: ruleUnit returns [Boolean current=false] : ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) ;
    public final Boolean ruleUnit() throws RecognitionException {
        Boolean current = false;
        int ruleUnit_StartIndex = input.index();
        Token lv_documentation_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_version_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Boolean lv_implements_7_0 = null;

        Boolean lv_implements_9_0 = null;

        Boolean lv_sourceLocation_14_0 = null;

        Boolean lv_outputLocation_18_0 = null;

        Boolean lv_providedCapabilities_22_0 = null;

        Boolean lv_requiredCapabilities_26_0 = null;

        Boolean lv_metaRequiredCapabilities_31_0 = null;

        Boolean lv_functions_33_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getUnitAccess().getUnorderedGroup_7()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:124:2: ( ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:125:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:125:2: ( () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}' )
            // PsiInternalBeeLangTestLanguage.g:126:3: () ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )? otherlv_2= 'unit' ( (lv_name_3_0= RULE_ID ) )? (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )? (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )? otherlv_10= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) ) otherlv_34= '}'
            {
            // PsiInternalBeeLangTestLanguage.g:126:3: ()
            // PsiInternalBeeLangTestLanguage.g:127:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnit_UnitAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:136:3: ( (lv_documentation_1_0= RULE_DOCUMENTATION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOCUMENTATION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:137:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalBeeLangTestLanguage.g:137:4: (lv_documentation_1_0= RULE_DOCUMENTATION )
                    // PsiInternalBeeLangTestLanguage.g:138:5: lv_documentation_1_0= RULE_DOCUMENTATION
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getUnit_DocumentationDOCUMENTATIONTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_documentation_1_0=(Token)match(input,RULE_DOCUMENTATION,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_documentation_1_0);
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnit_UnitKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:160:3: ( (lv_name_3_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:161:4: (lv_name_3_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:161:4: (lv_name_3_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:162:5: lv_name_3_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getUnit_NameIDTerminalRuleCall_3_0ElementType());
                      				
                    }
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_name_3_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:177:3: (otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:178:4: otherlv_4= 'version' ( (lv_version_5_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_VersionKeyword_4_0ElementType());
                      			
                    }
                    otherlv_4=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_4);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:185:4: ( (lv_version_5_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:186:5: (lv_version_5_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:186:5: (lv_version_5_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:187:6: lv_version_5_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnit_VersionIDTerminalRuleCall_4_1_0ElementType());
                      					
                    }
                    lv_version_5_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_version_5_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:203:3: (otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:204:4: otherlv_6= 'implements' ( (lv_implements_7_0= ruleSimpleTypeRef ) ) (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getUnit_ImplementsKeyword_5_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,15,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:211:4: ( (lv_implements_7_0= ruleSimpleTypeRef ) )
                    // PsiInternalBeeLangTestLanguage.g:212:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:212:5: (lv_implements_7_0= ruleSimpleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:213:6: lv_implements_7_0= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getUnit_ImplementsSimpleTypeRefParserRuleCall_5_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_implements_7_0=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:226:4: (otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==16) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:227:5: otherlv_8= ',' ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getUnit_CommaKeyword_5_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_8=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_8);
                    	      				
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:234:5: ( (lv_implements_9_0= ruleSimpleTypeRef ) )
                    	    // PsiInternalBeeLangTestLanguage.g:235:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:235:6: (lv_implements_9_0= ruleSimpleTypeRef )
                    	    // PsiInternalBeeLangTestLanguage.g:236:7: lv_implements_9_0= ruleSimpleTypeRef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markComposite(elementTypeProvider.getUnit_ImplementsSimpleTypeRefParserRuleCall_5_2_1_0ElementType());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_implements_9_0=ruleSimpleTypeRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneComposite();
                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnit_LeftCurlyBracketKeyword_6ElementType());
              		
            }
            otherlv_10=(Token)match(input,17,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:258:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) ) )
            // PsiInternalBeeLangTestLanguage.g:259:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            {
            // PsiInternalBeeLangTestLanguage.g:259:4: ( ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:260:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getUnitAccess().getUnorderedGroup_7());
            // PsiInternalBeeLangTestLanguage.g:263:5: ( ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:264:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:264:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*
            loop13:
            do {
                int alt13=7;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:265:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:265:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:266:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:266:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:267:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
            	    // PsiInternalBeeLangTestLanguage.g:270:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:270:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:270:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:270:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SourceKeyword_7_0_0ElementType());
            	      								
            	    }
            	    otherlv_12=(Token)match(input,18,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_12);
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_0_1ElementType());
            	      								
            	    }
            	    otherlv_13=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_13);
            	      								
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:284:9: ( (lv_sourceLocation_14_0= rulePath ) )
            	    // PsiInternalBeeLangTestLanguage.g:285:10: (lv_sourceLocation_14_0= rulePath )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:285:10: (lv_sourceLocation_14_0= rulePath )
            	    // PsiInternalBeeLangTestLanguage.g:286:11: lv_sourceLocation_14_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											markComposite(elementTypeProvider.getUnit_SourceLocationPathParserRuleCall_7_0_2_0ElementType());
            	      										
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_sourceLocation_14_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											doneComposite();
            	      											if(!current) {
            	      												associateWithSemanticElement();
            	      												current = true;
            	      											}
            	      										
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_0_3ElementType());
            	      								
            	    }
            	    otherlv_15=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_15);
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:313:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:313:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:314:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
            	    // PsiInternalBeeLangTestLanguage.g:317:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:317:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:317:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:317:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_OutputKeyword_7_1_0ElementType());
            	      								
            	    }
            	    otherlv_16=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_16);
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_1_1ElementType());
            	      								
            	    }
            	    otherlv_17=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_17);
            	      								
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:331:9: ( (lv_outputLocation_18_0= rulePath ) )
            	    // PsiInternalBeeLangTestLanguage.g:332:10: (lv_outputLocation_18_0= rulePath )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:332:10: (lv_outputLocation_18_0= rulePath )
            	    // PsiInternalBeeLangTestLanguage.g:333:11: lv_outputLocation_18_0= rulePath
            	    {
            	    if ( state.backtracking==0 ) {

            	      											markComposite(elementTypeProvider.getUnit_OutputLocationPathParserRuleCall_7_1_2_0ElementType());
            	      										
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_outputLocation_18_0=rulePath();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      											doneComposite();
            	      											if(!current) {
            	      												associateWithSemanticElement();
            	      												current = true;
            	      											}
            	      										
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_1_3ElementType());
            	      								
            	    }
            	    otherlv_19=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									doneLeaf(otherlv_19);
            	      								
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:359:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:359:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:360:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:360:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:361:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
            	    // PsiInternalBeeLangTestLanguage.g:364:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==22) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((synpred11_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:364:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:364:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
            	    	    // PsiInternalBeeLangTestLanguage.g:364:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_20=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_20);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_2_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_21=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_21);
            	    	      								
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:378:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:379:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:379:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
            	    	    // PsiInternalBeeLangTestLanguage.g:380:11: lv_providedCapabilities_22_0= ruleProvidedCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_providedCapabilities_22_0=ruleProvidedCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      											if(!current) {
            	    	      												associateWithSemanticElement();
            	    	      												current = true;
            	    	      											}
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_2_3ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_23=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_23);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalBeeLangTestLanguage.g:406:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:406:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:407:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:407:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:408:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
            	    // PsiInternalBeeLangTestLanguage.g:411:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==23) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((synpred13_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:411:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:411:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
            	    	    // PsiInternalBeeLangTestLanguage.g:411:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_24=(Token)match(input,23,FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_24);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_3_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_25=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_25);
            	    	      								
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:425:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:426:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:426:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
            	    	    // PsiInternalBeeLangTestLanguage.g:427:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      											if(!current) {
            	    	      												associateWithSemanticElement();
            	    	      												current = true;
            	    	      											}
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_3_3ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_27=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_27);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalBeeLangTestLanguage.g:453:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:453:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:454:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:454:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:455:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
            	    // PsiInternalBeeLangTestLanguage.g:458:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==23) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((synpred15_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:458:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:458:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
            	    	    // PsiInternalBeeLangTestLanguage.g:458:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_28=(Token)match(input,23,FOLLOW_16); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_28);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_EnvKeyword_7_4_1ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_29=(Token)match(input,24,FOLLOW_12); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_29);
            	    	      								
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_ColonKeyword_7_4_2ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_30=(Token)match(input,19,FOLLOW_15); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_30);
            	    	      								
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:479:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:480:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:480:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
            	    	    // PsiInternalBeeLangTestLanguage.g:481:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
            	    	      										
            	    	    }
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      											doneComposite();
            	    	      											if(!current) {
            	    	      												associateWithSemanticElement();
            	    	      												current = true;
            	    	      											}
            	    	      										
            	    	    }

            	    	    }


            	    	    }

            	    	    if ( state.backtracking==0 ) {

            	    	      									markLeaf(elementTypeProvider.getUnit_SemicolonKeyword_7_4_4ElementType());
            	    	      								
            	    	    }
            	    	    otherlv_32=(Token)match(input,20,FOLLOW_11); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      									doneLeaf(otherlv_32);
            	    	      								
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // PsiInternalBeeLangTestLanguage.g:507:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:507:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
            	    // PsiInternalBeeLangTestLanguage.g:508:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:508:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
            	    // PsiInternalBeeLangTestLanguage.g:509:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
            	    // PsiInternalBeeLangTestLanguage.g:512:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        switch ( input.LA(1) ) {
            	        case RULE_DOCUMENTATION:
            	            {
            	            int LA12_2 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA12_3 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 33:
            	            {
            	            int LA12_4 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;
            	        case 34:
            	            {
            	            int LA12_5 = input.LA(2);

            	            if ( ((synpred17_PsiInternalBeeLangTestLanguage()&&(true))) ) {
            	                alt12=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt12) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:512:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        if (state.backtracking>0) {state.failed=true; return current;}
            	    	        throw new FailedPredicateException(input, "ruleUnit", "true");
            	    	    }
            	    	    // PsiInternalBeeLangTestLanguage.g:512:19: ( (lv_functions_33_0= ruleFunction ) )
            	    	    // PsiInternalBeeLangTestLanguage.g:512:20: (lv_functions_33_0= ruleFunction )
            	    	    {
            	    	    // PsiInternalBeeLangTestLanguage.g:512:20: (lv_functions_33_0= ruleFunction )
            	    	    // PsiInternalBeeLangTestLanguage.g:513:10: lv_functions_33_0= ruleFunction
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
            	    	      									
            	    	    }
            	    	    pushFollow(FOLLOW_11);
            	    	    lv_functions_33_0=ruleFunction();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      										doneComposite();
            	    	      										if(!current) {
            	    	      											associateWithSemanticElement();
            	    	      											current = true;
            	    	      										}
            	    	      									
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getUnitAccess().getUnorderedGroup_7());

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getUnit_RightCurlyBracketKeyword_8ElementType());
              		
            }
            otherlv_34=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_34);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, ruleUnit_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleUnit"


    // $ANTLR start "entryRuleProvidedCapability"
    // PsiInternalBeeLangTestLanguage.g:552:1: entryRuleProvidedCapability returns [Boolean current=false] : iv_ruleProvidedCapability= ruleProvidedCapability EOF ;
    public final Boolean entryRuleProvidedCapability() throws RecognitionException {
        Boolean current = false;
        int entryRuleProvidedCapability_StartIndex = input.index();
        Boolean iv_ruleProvidedCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:556:2: (iv_ruleProvidedCapability= ruleProvidedCapability EOF )
            // PsiInternalBeeLangTestLanguage.g:557:2: iv_ruleProvidedCapability= ruleProvidedCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getProvidedCapabilityElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProvidedCapability=ruleProvidedCapability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProvidedCapability; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, entryRuleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleProvidedCapability"


    // $ANTLR start "ruleProvidedCapability"
    // PsiInternalBeeLangTestLanguage.g:566:1: ruleProvidedCapability returns [Boolean current=false] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) ;
    public final Boolean ruleProvidedCapability() throws RecognitionException {
        Boolean current = false;
        int ruleProvidedCapability_StartIndex = input.index();
        Token lv_nameSpace_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Boolean lv_condExpr_7_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:571:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? ) )
            // PsiInternalBeeLangTestLanguage.g:572:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            {
            // PsiInternalBeeLangTestLanguage.g:572:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )? )
            // PsiInternalBeeLangTestLanguage.g:573:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            {
            // PsiInternalBeeLangTestLanguage.g:573:3: ()
            // PsiInternalBeeLangTestLanguage.g:574:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getProvidedCapability_ProvidedCapabilityAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:583:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            else if ( (LA14_0==13) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:584:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:584:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:585:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:585:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:586:6: lv_nameSpace_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getProvidedCapability_NameSpaceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_1_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:602:4: otherlv_2= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_UnitKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,13,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:610:3: (otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==17) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:611:4: otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) ) otherlv_17= '}'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_LeftCurlyBracketKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,17,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:618:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) ) )
                    // PsiInternalBeeLangTestLanguage.g:619:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:619:5: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?) )
                    // PsiInternalBeeLangTestLanguage.g:620:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    {
                    getUnorderedGroupHelper().enter(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());
                    // PsiInternalBeeLangTestLanguage.g:623:6: ( ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?)
                    // PsiInternalBeeLangTestLanguage.g:624:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+ {...}?
                    {
                    // PsiInternalBeeLangTestLanguage.g:624:7: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=4;
                        int LA15_0 = input.LA(1);

                        if ( LA15_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                            alt15=1;
                        }
                        else if ( LA15_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                            alt15=2;
                        }
                        else if ( LA15_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                            alt15=3;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:625:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:625:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:626:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:626:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:627:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
                    	    // PsiInternalBeeLangTestLanguage.g:630:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
                    	    // PsiInternalBeeLangTestLanguage.g:630:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:630:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
                    	    // PsiInternalBeeLangTestLanguage.g:630:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_WhenKeyword_2_1_0_0ElementType());
                    	      									
                    	    }
                    	    otherlv_5=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_5);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_0_1ElementType());
                    	      									
                    	    }
                    	    otherlv_6=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_6);
                    	      									
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:644:10: ( (lv_condExpr_7_0= ruleExpression ) )
                    	    // PsiInternalBeeLangTestLanguage.g:645:11: (lv_condExpr_7_0= ruleExpression )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:645:11: (lv_condExpr_7_0= ruleExpression )
                    	    // PsiInternalBeeLangTestLanguage.g:646:12: lv_condExpr_7_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markComposite(elementTypeProvider.getProvidedCapability_CondExprExpressionParserRuleCall_2_1_0_2_0ElementType());
                    	      											
                    	    }
                    	    pushFollow(FOLLOW_14);
                    	    lv_condExpr_7_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												doneComposite();
                    	      												if(!current) {
                    	      													associateWithSemanticElement();
                    	      													current = true;
                    	      												}
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_0_3ElementType());
                    	      									
                    	    }
                    	    otherlv_8=(Token)match(input,20,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_8);
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalBeeLangTestLanguage.g:672:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:672:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:673:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:673:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:674:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
                    	    // PsiInternalBeeLangTestLanguage.g:677:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
                    	    // PsiInternalBeeLangTestLanguage.g:677:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:677:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
                    	    // PsiInternalBeeLangTestLanguage.g:677:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_NameKeyword_2_1_1_0ElementType());
                    	      									
                    	    }
                    	    otherlv_9=(Token)match(input,27,FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_9);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_1_1ElementType());
                    	      									
                    	    }
                    	    otherlv_10=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_10);
                    	      									
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:691:10: ( (lv_name_11_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:692:11: (lv_name_11_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:692:11: (lv_name_11_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:693:12: lv_name_11_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markLeaf(elementTypeProvider.getProvidedCapability_NameIDTerminalRuleCall_2_1_1_2_0ElementType());
                    	      											
                    	    }
                    	    lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												if(!current) {
                    	      													associateWithSemanticElement();
                    	      													current = true;
                    	      												}
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												doneLeaf(lv_name_11_0);
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_1_3ElementType());
                    	      									
                    	    }
                    	    otherlv_12=(Token)match(input,20,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_12);
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // PsiInternalBeeLangTestLanguage.g:721:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:721:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:722:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:722:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
                    	    // PsiInternalBeeLangTestLanguage.g:723:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    {
                    	    getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
                    	    // PsiInternalBeeLangTestLanguage.g:726:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
                    	    // PsiInternalBeeLangTestLanguage.g:726:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    {
                    	    if ( !((true)) ) {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        throw new FailedPredicateException(input, "ruleProvidedCapability", "true");
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:726:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
                    	    // PsiInternalBeeLangTestLanguage.g:726:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_VersionKeyword_2_1_2_0ElementType());
                    	      									
                    	    }
                    	    otherlv_13=(Token)match(input,14,FOLLOW_12); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_13);
                    	      									
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_ColonKeyword_2_1_2_1ElementType());
                    	      									
                    	    }
                    	    otherlv_14=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_14);
                    	      									
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:740:10: ( (lv_version_15_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:741:11: (lv_version_15_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:741:11: (lv_version_15_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:742:12: lv_version_15_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      												markLeaf(elementTypeProvider.getProvidedCapability_VersionIDTerminalRuleCall_2_1_2_2_0ElementType());
                    	      											
                    	    }
                    	    lv_version_15_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      												if(!current) {
                    	      													associateWithSemanticElement();
                    	      													current = true;
                    	      												}
                    	      											
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      												doneLeaf(lv_version_15_0);
                    	      											
                    	    }

                    	    }


                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      										markLeaf(elementTypeProvider.getProvidedCapability_SemicolonKeyword_2_1_2_3ElementType());
                    	      									
                    	    }
                    	    otherlv_16=(Token)match(input,20,FOLLOW_20); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      										doneLeaf(otherlv_16);
                    	      									
                    	    }

                    	    }


                    	    }

                    	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1()) ) {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        throw new FailedPredicateException(input, "ruleProvidedCapability", "getUnorderedGroupHelper().canLeave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1())");
                    }

                    }


                    }

                    getUnorderedGroupHelper().leave(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1());

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getProvidedCapability_RightCurlyBracketKeyword_2_2ElementType());
                      			
                    }
                    otherlv_17=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_17);
                      			
                    }

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, ruleProvidedCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleProvidedCapability"


    // $ANTLR start "entryRuleAliasedRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:793:1: entryRuleAliasedRequiredCapability returns [Boolean current=false] : iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF ;
    public final Boolean entryRuleAliasedRequiredCapability() throws RecognitionException {
        Boolean current = false;
        int entryRuleAliasedRequiredCapability_StartIndex = input.index();
        Boolean iv_ruleAliasedRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:797:2: (iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF )
            // PsiInternalBeeLangTestLanguage.g:798:2: iv_ruleAliasedRequiredCapability= ruleAliasedRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAliasedRequiredCapabilityElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAliasedRequiredCapability=ruleAliasedRequiredCapability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAliasedRequiredCapability; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, entryRuleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleAliasedRequiredCapability"


    // $ANTLR start "ruleAliasedRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:807:1: ruleAliasedRequiredCapability returns [Boolean current=false] : ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) ;
    public final Boolean ruleAliasedRequiredCapability() throws RecognitionException {
        Boolean current = false;
        int ruleAliasedRequiredCapability_StartIndex = input.index();
        Token lv_nameSpace_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Boolean lv_condExpr_9_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:812:2: ( ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) ) )
            // PsiInternalBeeLangTestLanguage.g:813:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:813:2: ( ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:814:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:814:3: ( ( (lv_nameSpace_0_0= RULE_ID ) ) | otherlv_1= 'unit' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==13) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:815:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:815:4: ( (lv_nameSpace_0_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:816:5: (lv_nameSpace_0_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:816:5: (lv_nameSpace_0_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:817:6: lv_nameSpace_0_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getAliasedRequiredCapability_NameSpaceIDTerminalRuleCall_0_0_0ElementType());
                      					
                    }
                    lv_nameSpace_0_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_0_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:833:4: otherlv_1= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAliasedRequiredCapability_UnitKeyword_0_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:841:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:842:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:842:4: (lv_name_2_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:843:5: lv_name_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getAliasedRequiredCapability_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_2_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:858:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:859:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getAliasedRequiredCapability_AsKeyword_2_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:866:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:867:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:867:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:868:6: lv_alias_4_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getAliasedRequiredCapability_AliasIDTerminalRuleCall_2_1_0ElementType());
                      					
                    }
                    lv_alias_4_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_4_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:884:3: (otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}' )
            // PsiInternalBeeLangTestLanguage.g:885:4: otherlv_5= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) ) otherlv_25= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getAliasedRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_5=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_5);
              			
            }
            // PsiInternalBeeLangTestLanguage.g:892:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) ) )
            // PsiInternalBeeLangTestLanguage.g:893:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            {
            // PsiInternalBeeLangTestLanguage.g:893:5: ( ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:894:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalBeeLangTestLanguage.g:897:6: ( ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:898:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:898:7: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )*
            loop19:
            do {
                int alt19=6;
                int LA19_0 = input.LA(1);

                if ( LA19_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
                    alt19=1;
                }
                else if ( LA19_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
                    alt19=2;
                }
                else if ( LA19_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
                    alt19=3;
                }
                else if ( LA19_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
                    alt19=4;
                }
                else if ( LA19_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
                    alt19=5;
                }


                switch (alt19) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:899:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:899:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:900:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:900:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:901:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalBeeLangTestLanguage.g:904:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:904:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:904:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:904:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_WhenKeyword_3_1_0_0ElementType());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_7);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_0_1ElementType());
            	      									
            	    }
            	    otherlv_8=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_8);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:918:10: ( (lv_condExpr_9_0= ruleExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:919:11: (lv_condExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:919:11: (lv_condExpr_9_0= ruleExpression )
            	    // PsiInternalBeeLangTestLanguage.g:920:12: lv_condExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markComposite(elementTypeProvider.getAliasedRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
            	      											
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_condExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneComposite();
            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_0_3ElementType());
            	      									
            	    }
            	    otherlv_10=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_10);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:946:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:946:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:947:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:947:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:948:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalBeeLangTestLanguage.g:951:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:951:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:951:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:951:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:951:21: ( (lv_greedy_11_0= 'greedy' ) )
            	    // PsiInternalBeeLangTestLanguage.g:952:11: (lv_greedy_11_0= 'greedy' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:952:11: (lv_greedy_11_0= 'greedy' )
            	    // PsiInternalBeeLangTestLanguage.g:953:12: lv_greedy_11_0= 'greedy'
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
            	      											
            	    }
            	    lv_greedy_11_0=(Token)match(input,29,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_greedy_11_0);
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_1_1ElementType());
            	      									
            	    }
            	    otherlv_12=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_12);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:981:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:981:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:982:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:982:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:983:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalBeeLangTestLanguage.g:986:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:986:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:986:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:986:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,30,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_13);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_2_1ElementType());
            	      									
            	    }
            	    otherlv_14=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_14);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1000:10: ( (lv_min_15_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:1001:11: (lv_min_15_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1001:11: (lv_min_15_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:1002:12: lv_min_15_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
            	      											
            	    }
            	    lv_min_15_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_min_15_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_2_3ElementType());
            	      									
            	    }
            	    otherlv_16=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_16);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalBeeLangTestLanguage.g:1030:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1030:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1031:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1031:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1032:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalBeeLangTestLanguage.g:1035:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1035:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1035:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1035:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,31,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_17);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_3_1ElementType());
            	      									
            	    }
            	    otherlv_18=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_18);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1049:10: ( (lv_max_19_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:1050:11: (lv_max_19_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1050:11: (lv_max_19_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:1051:12: lv_max_19_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
            	      											
            	    }
            	    lv_max_19_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_max_19_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_3_3ElementType());
            	      									
            	    }
            	    otherlv_20=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_20);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalBeeLangTestLanguage.g:1079:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1079:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1080:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1080:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1081:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalBeeLangTestLanguage.g:1084:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1084:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleAliasedRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1084:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1084:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionKeyword_3_1_4_0ElementType());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,14,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_21);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_ColonKeyword_3_1_4_1ElementType());
            	      									
            	    }
            	    otherlv_22=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_22);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1098:10: ( (lv_versionRange_23_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:1099:11: (lv_versionRange_23_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1099:11: (lv_versionRange_23_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:1100:12: lv_versionRange_23_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
            	      											
            	    }
            	    lv_versionRange_23_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_versionRange_23_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getAliasedRequiredCapability_SemicolonKeyword_3_1_4_3ElementType());
            	      									
            	    }
            	    otherlv_24=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_24);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1());

            }

            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getAliasedRequiredCapability_RightCurlyBracketKeyword_3_2ElementType());
              			
            }
            otherlv_25=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_25);
              			
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
            if ( state.backtracking>0 ) { memoize(input, 8, ruleAliasedRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleAliasedRequiredCapability"


    // $ANTLR start "entryRuleRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:1150:1: entryRuleRequiredCapability returns [Boolean current=false] : iv_ruleRequiredCapability= ruleRequiredCapability EOF ;
    public final Boolean entryRuleRequiredCapability() throws RecognitionException {
        Boolean current = false;
        int entryRuleRequiredCapability_StartIndex = input.index();
        Boolean iv_ruleRequiredCapability = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1154:2: (iv_ruleRequiredCapability= ruleRequiredCapability EOF )
            // PsiInternalBeeLangTestLanguage.g:1155:2: iv_ruleRequiredCapability= ruleRequiredCapability EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRequiredCapabilityElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRequiredCapability=ruleRequiredCapability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequiredCapability; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, entryRuleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredCapability"


    // $ANTLR start "ruleRequiredCapability"
    // PsiInternalBeeLangTestLanguage.g:1164:1: ruleRequiredCapability returns [Boolean current=false] : ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) ;
    public final Boolean ruleRequiredCapability() throws RecognitionException {
        Boolean current = false;
        int ruleRequiredCapability_StartIndex = input.index();
        Token lv_nameSpace_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Boolean lv_condExpr_8_0 = null;



        	UnorderedGroupState myUnorderedGroupState = getUnorderedGroupHelper().snapShot(
        	grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1()
        	);

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1169:2: ( ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) ) )
            // PsiInternalBeeLangTestLanguage.g:1170:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1170:2: ( () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:1171:3: () ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' ) ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:1171:3: ()
            // PsiInternalBeeLangTestLanguage.g:1172:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getRequiredCapability_RequiredCapabilityAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:1181:3: ( ( (lv_nameSpace_1_0= RULE_ID ) ) | otherlv_2= 'unit' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==13) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1182:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1182:4: ( (lv_nameSpace_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:1183:5: (lv_nameSpace_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1183:5: (lv_nameSpace_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:1184:6: lv_nameSpace_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getRequiredCapability_NameSpaceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_nameSpace_1_0=(Token)match(input,RULE_ID,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_nameSpace_1_0);
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1200:4: otherlv_2= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getRequiredCapability_UnitKeyword_1_1ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1208:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:1209:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:1209:4: (lv_name_3_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:1210:5: lv_name_3_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getRequiredCapability_NameIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_3_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:1225:3: (otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}' )
            // PsiInternalBeeLangTestLanguage.g:1226:4: otherlv_4= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) ) otherlv_24= '}'
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getRequiredCapability_LeftCurlyBracketKeyword_3_0ElementType());
              			
            }
            otherlv_4=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_4);
              			
            }
            // PsiInternalBeeLangTestLanguage.g:1233:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) ) )
            // PsiInternalBeeLangTestLanguage.g:1234:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1234:5: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:1235:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());
            // PsiInternalBeeLangTestLanguage.g:1238:6: ( ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:1239:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:1239:7: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )*
            loop21:
            do {
                int alt21=6;
                int LA21_0 = input.LA(1);

                if ( LA21_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
                    alt21=1;
                }
                else if ( LA21_0 == 29 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
                    alt21=2;
                }
                else if ( LA21_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
                    alt21=3;
                }
                else if ( LA21_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
                    alt21=4;
                }
                else if ( LA21_0 == 14 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
                    alt21=5;
                }


                switch (alt21) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:1240:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1240:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1241:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1241:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1242:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
            	    // PsiInternalBeeLangTestLanguage.g:1245:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1245:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1245:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1245:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_WhenKeyword_3_1_0_0ElementType());
            	      									
            	    }
            	    otherlv_6=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_6);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_0_1ElementType());
            	      									
            	    }
            	    otherlv_7=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_7);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1259:10: ( (lv_condExpr_8_0= ruleExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:1260:11: (lv_condExpr_8_0= ruleExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1260:11: (lv_condExpr_8_0= ruleExpression )
            	    // PsiInternalBeeLangTestLanguage.g:1261:12: lv_condExpr_8_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markComposite(elementTypeProvider.getRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
            	      											
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_condExpr_8_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneComposite();
            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_0_3ElementType());
            	      									
            	    }
            	    otherlv_9=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_9);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:1287:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1287:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1288:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1288:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1289:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
            	    // PsiInternalBeeLangTestLanguage.g:1292:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1292:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1292:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1292:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1292:21: ( (lv_greedy_10_0= 'greedy' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1293:11: (lv_greedy_10_0= 'greedy' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1293:11: (lv_greedy_10_0= 'greedy' )
            	    // PsiInternalBeeLangTestLanguage.g:1294:12: lv_greedy_10_0= 'greedy'
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
            	      											
            	    }
            	    lv_greedy_10_0=(Token)match(input,29,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_greedy_10_0);
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												if (!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_1_1ElementType());
            	      									
            	    }
            	    otherlv_11=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_11);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:1322:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1322:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1323:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1323:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1324:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
            	    // PsiInternalBeeLangTestLanguage.g:1327:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1327:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1327:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1327:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
            	      									
            	    }
            	    otherlv_12=(Token)match(input,30,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_12);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_2_1ElementType());
            	      									
            	    }
            	    otherlv_13=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_13);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1341:10: ( (lv_min_14_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:1342:11: (lv_min_14_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1342:11: (lv_min_14_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:1343:12: lv_min_14_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
            	      											
            	    }
            	    lv_min_14_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_min_14_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_2_3ElementType());
            	      									
            	    }
            	    otherlv_15=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_15);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalBeeLangTestLanguage.g:1371:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1371:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1372:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1372:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1373:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
            	    // PsiInternalBeeLangTestLanguage.g:1376:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1376:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1376:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1376:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
            	      									
            	    }
            	    otherlv_16=(Token)match(input,31,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_16);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_3_1ElementType());
            	      									
            	    }
            	    otherlv_17=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_17);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1390:10: ( (lv_max_18_0= RULE_INT ) )
            	    // PsiInternalBeeLangTestLanguage.g:1391:11: (lv_max_18_0= RULE_INT )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1391:11: (lv_max_18_0= RULE_INT )
            	    // PsiInternalBeeLangTestLanguage.g:1392:12: lv_max_18_0= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
            	      											
            	    }
            	    lv_max_18_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_max_18_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_3_3ElementType());
            	      									
            	    }
            	    otherlv_19=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_19);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalBeeLangTestLanguage.g:1420:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1420:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1421:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1421:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:1422:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
            	    // PsiInternalBeeLangTestLanguage.g:1425:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
            	    // PsiInternalBeeLangTestLanguage.g:1425:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleRequiredCapability", "true");
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1425:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
            	    // PsiInternalBeeLangTestLanguage.g:1425:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
            	    {
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_VersionKeyword_3_1_4_0ElementType());
            	      									
            	    }
            	    otherlv_20=(Token)match(input,14,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_20);
            	      									
            	    }
            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_ColonKeyword_3_1_4_1ElementType());
            	      									
            	    }
            	    otherlv_21=(Token)match(input,19,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_21);
            	      									
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1439:10: ( (lv_versionRange_22_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:1440:11: (lv_versionRange_22_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1440:11: (lv_versionRange_22_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:1441:12: lv_versionRange_22_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      												markLeaf(elementTypeProvider.getRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
            	      											
            	    }
            	    lv_versionRange_22_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      												if(!current) {
            	      													associateWithSemanticElement();
            	      													current = true;
            	      												}
            	      											
            	    }
            	    if ( state.backtracking==0 ) {

            	      												doneLeaf(lv_versionRange_22_0);
            	      											
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      										markLeaf(elementTypeProvider.getRequiredCapability_SemicolonKeyword_3_1_4_3ElementType());
            	      									
            	    }
            	    otherlv_23=(Token)match(input,20,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      										doneLeaf(otherlv_23);
            	      									
            	    }

            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1());

            }

            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getRequiredCapability_RightCurlyBracketKeyword_3_2ElementType());
              			
            }
            otherlv_24=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneLeaf(otherlv_24);
              			
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
            if ( state.backtracking>0 ) { memoize(input, 10, ruleRequiredCapability_StartIndex); }

            	myUnorderedGroupState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleRequiredCapability"


    // $ANTLR start "entryRulePath"
    // PsiInternalBeeLangTestLanguage.g:1491:1: entryRulePath returns [Boolean current=false] : iv_rulePath= rulePath EOF ;
    public final Boolean entryRulePath() throws RecognitionException {
        Boolean current = false;
        int entryRulePath_StartIndex = input.index();
        Boolean iv_rulePath = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1493:2: (iv_rulePath= rulePath EOF )
            // PsiInternalBeeLangTestLanguage.g:1494:2: iv_rulePath= rulePath EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPathElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, entryRulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // PsiInternalBeeLangTestLanguage.g:1503:1: rulePath returns [Boolean current=false] : (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) ;
    public final Boolean rulePath() throws RecognitionException {
        Boolean current = false;
        int rulePath_StartIndex = input.index();
        Token this_STRING_0=null;
        Token kw=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1506:2: ( (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) ) )
            // PsiInternalBeeLangTestLanguage.g:1507:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1507:2: (this_STRING_0= RULE_STRING | ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_STRING) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID||LA25_0==32) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1508:3: this_STRING_0= RULE_STRING
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getPath_STRINGTerminalRuleCall_0ElementType());
                      		
                    }
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(this_STRING_0);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1516:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1516:3: ( (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )? )
                    // PsiInternalBeeLangTestLanguage.g:1517:4: (kw= '/' )? ruleQID (kw= '/' ruleQID )* (kw= '/' )?
                    {
                    // PsiInternalBeeLangTestLanguage.g:1517:4: (kw= '/' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==32) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:1518:5: kw= '/'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_0ElementType());
                              				
                            }
                            kw=(Token)match(input,32,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markComposite(elementTypeProvider.getPath_QIDParserRuleCall_1_1ElementType());
                      			
                    }
                    pushFollow(FOLLOW_25);
                    ruleQID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneComposite();
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:1533:4: (kw= '/' ruleQID )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==32) ) {
                            int LA23_1 = input.LA(2);

                            if ( (LA23_1==RULE_ID) ) {
                                alt23=1;
                            }


                        }


                        switch (alt23) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:1534:5: kw= '/' ruleQID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    kw=(Token)match(input,32,FOLLOW_13); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(kw);
                    	      				
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      					markComposite(elementTypeProvider.getPath_QIDParserRuleCall_1_2_1ElementType());
                    	      				
                    	    }
                    	    pushFollow(FOLLOW_25);
                    	    ruleQID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneComposite();
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // PsiInternalBeeLangTestLanguage.g:1549:4: (kw= '/' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==32) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:1550:5: kw= '/'
                            {
                            if ( state.backtracking==0 ) {

                              					markLeaf(elementTypeProvider.getPath_SolidusKeyword_1_3ElementType());
                              				
                            }
                            kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					doneLeaf(kw);
                              				
                            }

                            }
                            break;

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
            if ( state.backtracking>0 ) { memoize(input, 12, rulePath_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleParameterList"
    // PsiInternalBeeLangTestLanguage.g:1566:1: entryRuleParameterList returns [Boolean current=false] : iv_ruleParameterList= ruleParameterList EOF ;
    public final Boolean entryRuleParameterList() throws RecognitionException {
        Boolean current = false;
        int entryRuleParameterList_StartIndex = input.index();
        Boolean iv_ruleParameterList = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1566:55: (iv_ruleParameterList= ruleParameterList EOF )
            // PsiInternalBeeLangTestLanguage.g:1567:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterListElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, entryRuleParameterList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // PsiInternalBeeLangTestLanguage.g:1573:1: ruleParameterList returns [Boolean current=false] : ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) ;
    public final Boolean ruleParameterList() throws RecognitionException {
        Boolean current = false;
        int ruleParameterList_StartIndex = input.index();
        Token otherlv_1=null;
        Boolean lv_parameters_0_0 = null;

        Boolean lv_parameters_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1574:1: ( ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:1575:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:1575:2: ( ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:1576:3: ( (lv_parameters_0_0= ruleFirstParameter ) ) (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            {
            // PsiInternalBeeLangTestLanguage.g:1576:3: ( (lv_parameters_0_0= ruleFirstParameter ) )
            // PsiInternalBeeLangTestLanguage.g:1577:4: (lv_parameters_0_0= ruleFirstParameter )
            {
            // PsiInternalBeeLangTestLanguage.g:1577:4: (lv_parameters_0_0= ruleFirstParameter )
            // PsiInternalBeeLangTestLanguage.g:1578:5: lv_parameters_0_0= ruleFirstParameter
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getParameterList_ParametersFirstParameterParserRuleCall_0_0ElementType());
              				
            }
            pushFollow(FOLLOW_26);
            lv_parameters_0_0=ruleFirstParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:1591:3: (otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==16) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:1592:4: otherlv_1= ',' ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getParameterList_CommaKeyword_1_0ElementType());
            	      			
            	    }
            	    otherlv_1=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_1);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:1599:4: ( (lv_parameters_2_0= ruleFirstParameter ) )
            	    // PsiInternalBeeLangTestLanguage.g:1600:5: (lv_parameters_2_0= ruleFirstParameter )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:1600:5: (lv_parameters_2_0= ruleFirstParameter )
            	    // PsiInternalBeeLangTestLanguage.g:1601:6: lv_parameters_2_0= ruleFirstParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getParameterList_ParametersFirstParameterParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_parameters_2_0=ruleFirstParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, ruleParameterList_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleFirstParameter"
    // PsiInternalBeeLangTestLanguage.g:1619:1: entryRuleFirstParameter returns [Boolean current=false] : iv_ruleFirstParameter= ruleFirstParameter EOF ;
    public final Boolean entryRuleFirstParameter() throws RecognitionException {
        Boolean current = false;
        int entryRuleFirstParameter_StartIndex = input.index();
        Boolean iv_ruleFirstParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1619:56: (iv_ruleFirstParameter= ruleFirstParameter EOF )
            // PsiInternalBeeLangTestLanguage.g:1620:2: iv_ruleFirstParameter= ruleFirstParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFirstParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFirstParameter=ruleFirstParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, entryRuleFirstParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFirstParameter"


    // $ANTLR start "ruleFirstParameter"
    // PsiInternalBeeLangTestLanguage.g:1626:1: ruleFirstParameter returns [Boolean current=false] : (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) ;
    public final Boolean ruleFirstParameter() throws RecognitionException {
        Boolean current = false;
        int ruleFirstParameter_StartIndex = input.index();
        Boolean this_ClosureParameter_0 = null;

        Boolean this_Parameter_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1627:1: ( (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter ) )
            // PsiInternalBeeLangTestLanguage.g:1628:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            {
            // PsiInternalBeeLangTestLanguage.g:1628:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1629:3: this_ClosureParameter_0= ruleClosureParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFirstParameter_ClosureParameterParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ClosureParameter_0=ruleClosureParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureParameter_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:1641:3: this_Parameter_1= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getFirstParameter_ParameterParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Parameter_1=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Parameter_1;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 16, ruleFirstParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFirstParameter"


    // $ANTLR start "entryRuleParameter"
    // PsiInternalBeeLangTestLanguage.g:1656:1: entryRuleParameter returns [Boolean current=false] : iv_ruleParameter= ruleParameter EOF ;
    public final Boolean entryRuleParameter() throws RecognitionException {
        Boolean current = false;
        int entryRuleParameter_StartIndex = input.index();
        Boolean iv_ruleParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1656:51: (iv_ruleParameter= ruleParameter EOF )
            // PsiInternalBeeLangTestLanguage.g:1657:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, entryRuleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // PsiInternalBeeLangTestLanguage.g:1663:1: ruleParameter returns [Boolean current=false] : ( (lv_expr_0_0= ruleExpression ) ) ;
    public final Boolean ruleParameter() throws RecognitionException {
        Boolean current = false;
        int ruleParameter_StartIndex = input.index();
        Boolean lv_expr_0_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1664:1: ( ( (lv_expr_0_0= ruleExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:1665:2: ( (lv_expr_0_0= ruleExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1665:2: ( (lv_expr_0_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:1666:3: (lv_expr_0_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:1666:3: (lv_expr_0_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:1667:4: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getParameter_ExprExpressionParserRuleCall_0ElementType());
              			
            }
            pushFollow(FOLLOW_2);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneComposite();
              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
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
            if ( state.backtracking>0 ) { memoize(input, 18, ruleParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleClosureParameter"
    // PsiInternalBeeLangTestLanguage.g:1683:1: entryRuleClosureParameter returns [Boolean current=false] : iv_ruleClosureParameter= ruleClosureParameter EOF ;
    public final Boolean entryRuleClosureParameter() throws RecognitionException {
        Boolean current = false;
        int entryRuleClosureParameter_StartIndex = input.index();
        Boolean iv_ruleClosureParameter = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1683:58: (iv_ruleClosureParameter= ruleClosureParameter EOF )
            // PsiInternalBeeLangTestLanguage.g:1684:2: iv_ruleClosureParameter= ruleClosureParameter EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureParameterElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClosureParameter=ruleClosureParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosureParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, entryRuleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureParameter"


    // $ANTLR start "ruleClosureParameter"
    // PsiInternalBeeLangTestLanguage.g:1690:1: ruleClosureParameter returns [Boolean current=false] : ( (lv_expr_0_0= ruleClosureExpression ) ) ;
    public final Boolean ruleClosureParameter() throws RecognitionException {
        Boolean current = false;
        int ruleClosureParameter_StartIndex = input.index();
        Boolean lv_expr_0_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1691:1: ( ( (lv_expr_0_0= ruleClosureExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:1692:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1692:2: ( (lv_expr_0_0= ruleClosureExpression ) )
            // PsiInternalBeeLangTestLanguage.g:1693:3: (lv_expr_0_0= ruleClosureExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:1693:3: (lv_expr_0_0= ruleClosureExpression )
            // PsiInternalBeeLangTestLanguage.g:1694:4: lv_expr_0_0= ruleClosureExpression
            {
            if ( state.backtracking==0 ) {

              				markComposite(elementTypeProvider.getClosureParameter_ExprClosureExpressionParserRuleCall_0ElementType());
              			
            }
            pushFollow(FOLLOW_2);
            lv_expr_0_0=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				doneComposite();
              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
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
            if ( state.backtracking>0 ) { memoize(input, 20, ruleClosureParameter_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureParameter"


    // $ANTLR start "entryRuleParameterDeclaration"
    // PsiInternalBeeLangTestLanguage.g:1710:1: entryRuleParameterDeclaration returns [Boolean current=false] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final Boolean entryRuleParameterDeclaration() throws RecognitionException {
        Boolean current = false;
        int entryRuleParameterDeclaration_StartIndex = input.index();
        Boolean iv_ruleParameterDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1710:62: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // PsiInternalBeeLangTestLanguage.g:1711:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParameterDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, entryRuleParameterDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // PsiInternalBeeLangTestLanguage.g:1717:1: ruleParameterDeclaration returns [Boolean current=false] : ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleParameterDeclaration() throws RecognitionException {
        Boolean current = false;
        int ruleParameterDeclaration_StartIndex = input.index();
        Token lv_name_1_0=null;
        Boolean lv_type_0_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1718:1: ( ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:1719:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1719:2: ( ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:1720:3: ( (lv_type_0_0= ruleTypeRef ) )? ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1720:3: ( (lv_type_0_0= ruleTypeRef ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==35) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_ID) ) {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==RULE_ID||LA28_2==52) ) {
                    alt28=1;
                }
            }
            switch (alt28) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1721:4: (lv_type_0_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1721:4: (lv_type_0_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:1722:5: lv_type_0_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getParameterDeclaration_TypeTypeRefParserRuleCall_0_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_type_0_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1735:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:1736:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:1736:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:1737:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getParameterDeclaration_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 22, ruleParameterDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleFunction"
    // PsiInternalBeeLangTestLanguage.g:1756:1: entryRuleFunction returns [Boolean current=false] : iv_ruleFunction= ruleFunction EOF ;
    public final Boolean entryRuleFunction() throws RecognitionException {
        Boolean current = false;
        int entryRuleFunction_StartIndex = input.index();
        Boolean iv_ruleFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1756:50: (iv_ruleFunction= ruleFunction EOF )
            // PsiInternalBeeLangTestLanguage.g:1757:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFunctionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, entryRuleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // PsiInternalBeeLangTestLanguage.g:1763:1: ruleFunction returns [Boolean current=false] : ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) ;
    public final Boolean ruleFunction() throws RecognitionException {
        Boolean current = false;
        int ruleFunction_StartIndex = input.index();
        Token lv_documentation_0_0=null;
        Token lv_visibility_1_0=null;
        Token lv_final_2_0=null;
        Token otherlv_3=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_varArgs_11_0=null;
        Token lv_varArgs_13_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Boolean lv_returnType_4_0 = null;

        Boolean lv_parameters_7_0 = null;

        Boolean lv_parameters_9_0 = null;

        Boolean lv_parameters_12_0 = null;

        Boolean lv_parameters_14_0 = null;

        Boolean lv_guard_17_0 = null;

        Boolean lv_funcExpr_19_0 = null;

        Boolean lv_funcExpr_21_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:1764:1: ( ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:1765:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1765:2: ( ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:1766:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )? ( (lv_visibility_1_0= RULE_ID ) )? ( (lv_final_2_0= 'final' ) )? otherlv_3= 'function' ( (lv_returnType_4_0= ruleTypeRef ) )? ( (lv_name_5_0= RULE_ID ) ) (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )? (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )? ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:1766:3: ( (lv_documentation_0_0= RULE_DOCUMENTATION ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_DOCUMENTATION) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1767:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1767:4: (lv_documentation_0_0= RULE_DOCUMENTATION )
                    // PsiInternalBeeLangTestLanguage.g:1768:5: lv_documentation_0_0= RULE_DOCUMENTATION
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_DocumentationDOCUMENTATIONTerminalRuleCall_0_0ElementType());
                      				
                    }
                    lv_documentation_0_0=(Token)match(input,RULE_DOCUMENTATION,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_documentation_0_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1783:3: ( (lv_visibility_1_0= RULE_ID ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1784:4: (lv_visibility_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1784:4: (lv_visibility_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:1785:5: lv_visibility_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_VisibilityIDTerminalRuleCall_1_0ElementType());
                      				
                    }
                    lv_visibility_1_0=(Token)match(input,RULE_ID,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_visibility_1_0);
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1800:3: ( (lv_final_2_0= 'final' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1801:4: (lv_final_2_0= 'final' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1801:4: (lv_final_2_0= 'final' )
                    // PsiInternalBeeLangTestLanguage.g:1802:5: lv_final_2_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_FinalFinalKeyword_2_0ElementType());
                      				
                    }
                    lv_final_2_0=(Token)match(input,33,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_2_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getFunction_FunctionKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,34,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:1824:3: ( (lv_returnType_4_0= ruleTypeRef ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==35) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_ID) ) {
                int LA32_2 = input.LA(2);

                if ( (LA32_2==RULE_ID||LA32_2==52) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1825:4: (lv_returnType_4_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:1825:4: (lv_returnType_4_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:1826:5: lv_returnType_4_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getFunction_ReturnTypeTypeRefParserRuleCall_4_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_returnType_4_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1839:3: ( (lv_name_5_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:1840:4: (lv_name_5_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:1840:4: (lv_name_5_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:1841:5: lv_name_5_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFunction_NameIDTerminalRuleCall_5_0ElementType());
              				
            }
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_5_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:1856:3: (otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==35) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1857:4: otherlv_6= '(' ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )? otherlv_15= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_LeftParenthesisKeyword_6_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,35,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:1864:4: ( ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? ) | ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) ) )?
                    int alt35=3;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_ID||LA35_0==35) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==36) ) {
                        alt35=2;
                    }
                    switch (alt35) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:1865:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1865:5: ( ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )? )
                            // PsiInternalBeeLangTestLanguage.g:1866:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) ) (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )* (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            {
                            // PsiInternalBeeLangTestLanguage.g:1866:6: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                            // PsiInternalBeeLangTestLanguage.g:1867:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1867:7: (lv_parameters_7_0= ruleParameterDeclaration )
                            // PsiInternalBeeLangTestLanguage.g:1868:8: lv_parameters_7_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_0_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_34);
                            lv_parameters_7_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:1881:6: (otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==16) ) {
                                    int LA33_1 = input.LA(2);

                                    if ( (LA33_1==RULE_ID||LA33_1==35) ) {
                                        alt33=1;
                                    }


                                }


                                switch (alt33) {
                            	case 1 :
                            	    // PsiInternalBeeLangTestLanguage.g:1882:7: otherlv_8= ',' ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_1_0ElementType());
                            	      						
                            	    }
                            	    otherlv_8=(Token)match(input,16,FOLLOW_35); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							doneLeaf(otherlv_8);
                            	      						
                            	    }
                            	    // PsiInternalBeeLangTestLanguage.g:1889:7: ( (lv_parameters_9_0= ruleParameterDeclaration ) )
                            	    // PsiInternalBeeLangTestLanguage.g:1890:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    {
                            	    // PsiInternalBeeLangTestLanguage.g:1890:8: (lv_parameters_9_0= ruleParameterDeclaration )
                            	    // PsiInternalBeeLangTestLanguage.g:1891:9: lv_parameters_9_0= ruleParameterDeclaration
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_1_1_0ElementType());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_34);
                            	    lv_parameters_9_0=ruleParameterDeclaration();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									doneComposite();
                            	      									if(!current) {
                            	      										associateWithSemanticElement();
                            	      										current = true;
                            	      									}
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);

                            // PsiInternalBeeLangTestLanguage.g:1905:6: (otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==16) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // PsiInternalBeeLangTestLanguage.g:1906:7: otherlv_10= ',' ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    {
                                    if ( state.backtracking==0 ) {

                                      							markLeaf(elementTypeProvider.getFunction_CommaKeyword_6_1_0_2_0ElementType());
                                      						
                                    }
                                    otherlv_10=(Token)match(input,16,FOLLOW_36); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							doneLeaf(otherlv_10);
                                      						
                                    }
                                    // PsiInternalBeeLangTestLanguage.g:1913:7: ( (lv_varArgs_11_0= '...' ) )
                                    // PsiInternalBeeLangTestLanguage.g:1914:8: (lv_varArgs_11_0= '...' )
                                    {
                                    // PsiInternalBeeLangTestLanguage.g:1914:8: (lv_varArgs_11_0= '...' )
                                    // PsiInternalBeeLangTestLanguage.g:1915:9: lv_varArgs_11_0= '...'
                                    {
                                    if ( state.backtracking==0 ) {

                                      									markLeaf(elementTypeProvider.getFunction_VarArgsFullStopFullStopFullStopKeyword_6_1_0_2_1_0ElementType());
                                      								
                                    }
                                    lv_varArgs_11_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									doneLeaf(lv_varArgs_11_0);
                                      								
                                    }
                                    if ( state.backtracking==0 ) {

                                      									if (!current) {
                                      										associateWithSemanticElement();
                                      										current = true;
                                      									}
                                      								
                                    }

                                    }


                                    }

                                    // PsiInternalBeeLangTestLanguage.g:1930:7: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                                    // PsiInternalBeeLangTestLanguage.g:1931:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    {
                                    // PsiInternalBeeLangTestLanguage.g:1931:8: (lv_parameters_12_0= ruleParameterDeclaration )
                                    // PsiInternalBeeLangTestLanguage.g:1932:9: lv_parameters_12_0= ruleParameterDeclaration
                                    {
                                    if ( state.backtracking==0 ) {

                                      									markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_0_2_2_0ElementType());
                                      								
                                    }
                                    pushFollow(FOLLOW_37);
                                    lv_parameters_12_0=ruleParameterDeclaration();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      									doneComposite();
                                      									if(!current) {
                                      										associateWithSemanticElement();
                                      										current = true;
                                      									}
                                      								
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalBeeLangTestLanguage.g:1948:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1948:5: ( ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) ) )
                            // PsiInternalBeeLangTestLanguage.g:1949:6: ( (lv_varArgs_13_0= '...' ) ) ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1949:6: ( (lv_varArgs_13_0= '...' ) )
                            // PsiInternalBeeLangTestLanguage.g:1950:7: (lv_varArgs_13_0= '...' )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1950:7: (lv_varArgs_13_0= '...' )
                            // PsiInternalBeeLangTestLanguage.g:1951:8: lv_varArgs_13_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getFunction_VarArgsFullStopFullStopFullStopKeyword_6_1_1_0_0ElementType());
                              							
                            }
                            lv_varArgs_13_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_varArgs_13_0);
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:1966:6: ( (lv_parameters_14_0= ruleParameterDeclaration ) )
                            // PsiInternalBeeLangTestLanguage.g:1967:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            {
                            // PsiInternalBeeLangTestLanguage.g:1967:7: (lv_parameters_14_0= ruleParameterDeclaration )
                            // PsiInternalBeeLangTestLanguage.g:1968:8: lv_parameters_14_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              								markComposite(elementTypeProvider.getFunction_ParametersParameterDeclarationParserRuleCall_6_1_1_1_0ElementType());
                              							
                            }
                            pushFollow(FOLLOW_37);
                            lv_parameters_14_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneComposite();
                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }


                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_RightParenthesisKeyword_6_2ElementType());
                      			
                    }
                    otherlv_15=(Token)match(input,37,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_15);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:1991:3: (otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:1992:4: otherlv_16= 'when' ( (lv_guard_17_0= ruleGuardExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getFunction_WhenKeyword_7_0ElementType());
                      			
                    }
                    otherlv_16=(Token)match(input,26,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_16);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:1999:4: ( (lv_guard_17_0= ruleGuardExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2000:5: (lv_guard_17_0= ruleGuardExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2000:5: (lv_guard_17_0= ruleGuardExpression )
                    // PsiInternalBeeLangTestLanguage.g:2001:6: lv_guard_17_0= ruleGuardExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getFunction_GuardGuardExpressionParserRuleCall_7_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_39);
                    lv_guard_17_0=ruleGuardExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2015:3: ( (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' ) | ( (lv_funcExpr_21_0= ruleBlockExpression ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==19) ) {
                alt38=1;
            }
            else if ( (LA38_0==17) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2016:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2016:4: (otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';' )
                    // PsiInternalBeeLangTestLanguage.g:2017:5: otherlv_18= ':' ( (lv_funcExpr_19_0= ruleExpression ) ) otherlv_20= ';'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_ColonKeyword_8_0_0ElementType());
                      				
                    }
                    otherlv_18=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_18);
                      				
                    }
                    // PsiInternalBeeLangTestLanguage.g:2024:5: ( (lv_funcExpr_19_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2025:6: (lv_funcExpr_19_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2025:6: (lv_funcExpr_19_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:2026:7: lv_funcExpr_19_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getFunction_FuncExprExpressionParserRuleCall_8_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_14);
                    lv_funcExpr_19_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getFunction_SemicolonKeyword_8_0_2ElementType());
                      				
                    }
                    otherlv_20=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_20);
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2048:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2048:4: ( (lv_funcExpr_21_0= ruleBlockExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2049:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2049:5: (lv_funcExpr_21_0= ruleBlockExpression )
                    // PsiInternalBeeLangTestLanguage.g:2050:6: lv_funcExpr_21_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getFunction_FuncExprBlockExpressionParserRuleCall_8_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_funcExpr_21_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, ruleFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleGuardExpression"
    // PsiInternalBeeLangTestLanguage.g:2068:1: entryRuleGuardExpression returns [Boolean current=false] : iv_ruleGuardExpression= ruleGuardExpression EOF ;
    public final Boolean entryRuleGuardExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleGuardExpression_StartIndex = input.index();
        Boolean iv_ruleGuardExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2068:57: (iv_ruleGuardExpression= ruleGuardExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2069:2: iv_ruleGuardExpression= ruleGuardExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getGuardExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGuardExpression=ruleGuardExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGuardExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, entryRuleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleGuardExpression"


    // $ANTLR start "ruleGuardExpression"
    // PsiInternalBeeLangTestLanguage.g:2075:1: ruleGuardExpression returns [Boolean current=false] : ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) ;
    public final Boolean ruleGuardExpression() throws RecognitionException {
        Boolean current = false;
        int ruleGuardExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_guardExpr_1_0 = null;

        Boolean lv_guardExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2076:1: ( ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:2077:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2077:2: ( (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' ) | ( (lv_guardExpr_3_0= ruleBlockExpression ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) ) {
                alt39=1;
            }
            else if ( (LA39_0==17) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2078:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2078:3: (otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';' )
                    // PsiInternalBeeLangTestLanguage.g:2079:4: otherlv_0= ':' ( (lv_guardExpr_1_0= ruleExpression ) ) otherlv_2= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getGuardExpression_ColonKeyword_0_0ElementType());
                      			
                    }
                    otherlv_0=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_0);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:2086:4: ( (lv_guardExpr_1_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2087:5: (lv_guardExpr_1_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2087:5: (lv_guardExpr_1_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:2088:6: lv_guardExpr_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getGuardExpression_GuardExprExpressionParserRuleCall_0_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_guardExpr_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getGuardExpression_SemicolonKeyword_0_2ElementType());
                      			
                    }
                    otherlv_2=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_2);
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2110:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2110:3: ( (lv_guardExpr_3_0= ruleBlockExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2111:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2111:4: (lv_guardExpr_3_0= ruleBlockExpression )
                    // PsiInternalBeeLangTestLanguage.g:2112:5: lv_guardExpr_3_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getGuardExpression_GuardExprBlockExpressionParserRuleCall_1_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_guardExpr_3_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
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
            if ( state.backtracking>0 ) { memoize(input, 26, ruleGuardExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleGuardExpression"


    // $ANTLR start "entryRuleAssignmentOperator"
    // PsiInternalBeeLangTestLanguage.g:2129:1: entryRuleAssignmentOperator returns [Boolean current=false] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final Boolean entryRuleAssignmentOperator() throws RecognitionException {
        Boolean current = false;
        int entryRuleAssignmentOperator_StartIndex = input.index();
        Boolean iv_ruleAssignmentOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2129:60: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // PsiInternalBeeLangTestLanguage.g:2130:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAssignmentOperatorElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, entryRuleAssignmentOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // PsiInternalBeeLangTestLanguage.g:2136:1: ruleAssignmentOperator returns [Boolean current=false] : (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) ;
    public final Boolean ruleAssignmentOperator() throws RecognitionException {
        Boolean current = false;
        int ruleAssignmentOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2137:1: ( (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' ) )
            // PsiInternalBeeLangTestLanguage.g:2138:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            {
            // PsiInternalBeeLangTestLanguage.g:2138:2: (kw= '=' | kw= '+=' | kw= '-=' | kw= '*=' | kw= '/=' | kw= '%=' )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt40=1;
                }
                break;
            case 39:
                {
                alt40=2;
                }
                break;
            case 40:
                {
                alt40=3;
                }
                break;
            case 41:
                {
                alt40=4;
                }
                break;
            case 42:
                {
                alt40=5;
                }
                break;
            case 43:
                {
                alt40=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2139:3: kw= '='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_EqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2147:3: kw= '+='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_PlusSignEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:2155:3: kw= '-='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_HyphenMinusEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:2163:3: kw= '*='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_AsteriskEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:2171:3: kw= '/='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_SolidusEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:2179:3: kw= '%='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getAssignmentOperator_PercentSignEqualsSignKeyword_5ElementType());
                      		
                    }
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 28, ruleAssignmentOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleRelationalOperator"
    // PsiInternalBeeLangTestLanguage.g:2190:1: entryRuleRelationalOperator returns [Boolean current=false] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final Boolean entryRuleRelationalOperator() throws RecognitionException {
        Boolean current = false;
        int entryRuleRelationalOperator_StartIndex = input.index();
        Boolean iv_ruleRelationalOperator = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2190:60: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // PsiInternalBeeLangTestLanguage.g:2191:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRelationalOperatorElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, entryRuleRelationalOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // PsiInternalBeeLangTestLanguage.g:2197:1: ruleRelationalOperator returns [Boolean current=false] : (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) ;
    public final Boolean ruleRelationalOperator() throws RecognitionException {
        Boolean current = false;
        int ruleRelationalOperator_StartIndex = input.index();
        Token kw=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2198:1: ( (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' ) )
            // PsiInternalBeeLangTestLanguage.g:2199:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            {
            // PsiInternalBeeLangTestLanguage.g:2199:2: (kw= '~=' | kw= '==' | kw= '===' | kw= '!=' | kw= '!==' | kw= '>=' | kw= '<=' | kw= '>' | kw= '<' )
            int alt41=9;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt41=1;
                }
                break;
            case 45:
                {
                alt41=2;
                }
                break;
            case 46:
                {
                alt41=3;
                }
                break;
            case 47:
                {
                alt41=4;
                }
                break;
            case 48:
                {
                alt41=5;
                }
                break;
            case 49:
                {
                alt41=6;
                }
                break;
            case 50:
                {
                alt41=7;
                }
                break;
            case 51:
                {
                alt41=8;
                }
                break;
            case 52:
                {
                alt41=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2200:3: kw= '~='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_TildeEqualsSignKeyword_0ElementType());
                      		
                    }
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2208:3: kw= '=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_EqualsSignEqualsSignKeyword_1ElementType());
                      		
                    }
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:2216:3: kw= '==='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_EqualsSignEqualsSignEqualsSignKeyword_2ElementType());
                      		
                    }
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:2224:3: kw= '!='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_ExclamationMarkEqualsSignKeyword_3ElementType());
                      		
                    }
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:2232:3: kw= '!=='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_ExclamationMarkEqualsSignEqualsSignKeyword_4ElementType());
                      		
                    }
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:2240:3: kw= '>='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_GreaterThanSignEqualsSignKeyword_5ElementType());
                      		
                    }
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalBeeLangTestLanguage.g:2248:3: kw= '<='
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_LessThanSignEqualsSignKeyword_6ElementType());
                      		
                    }
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalBeeLangTestLanguage.g:2256:3: kw= '>'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_GreaterThanSignKeyword_7ElementType());
                      		
                    }
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalBeeLangTestLanguage.g:2264:3: kw= '<'
                    {
                    if ( state.backtracking==0 ) {

                      			markLeaf(elementTypeProvider.getRelationalOperator_LessThanSignKeyword_8ElementType());
                      		
                    }
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			doneLeaf(kw);
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 30, ruleRelationalOperator_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleTopLevelExpression"
    // PsiInternalBeeLangTestLanguage.g:2275:1: entryRuleTopLevelExpression returns [Boolean current=false] : iv_ruleTopLevelExpression= ruleTopLevelExpression EOF ;
    public final Boolean entryRuleTopLevelExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleTopLevelExpression_StartIndex = input.index();
        Boolean iv_ruleTopLevelExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2275:60: (iv_ruleTopLevelExpression= ruleTopLevelExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2276:2: iv_ruleTopLevelExpression= ruleTopLevelExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getTopLevelExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTopLevelExpression=ruleTopLevelExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopLevelExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, entryRuleTopLevelExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelExpression"


    // $ANTLR start "ruleTopLevelExpression"
    // PsiInternalBeeLangTestLanguage.g:2282:1: ruleTopLevelExpression returns [Boolean current=false] : (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) ;
    public final Boolean ruleTopLevelExpression() throws RecognitionException {
        Boolean current = false;
        int ruleTopLevelExpression_StartIndex = input.index();
        Boolean this_VarDeclaration_0 = null;

        Boolean this_ValDeclaration_1 = null;

        Boolean this_AssignmentExpression_2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2283:1: ( (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression ) )
            // PsiInternalBeeLangTestLanguage.g:2284:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:2284:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )
            int alt42=3;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2285:3: this_VarDeclaration_0= ruleVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_VarDeclarationParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VarDeclaration_0=ruleVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VarDeclaration_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2297:3: this_ValDeclaration_1= ruleValDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_ValDeclarationParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValDeclaration_1=ruleValDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValDeclaration_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:2309:3: this_AssignmentExpression_2= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTopLevelExpression_AssignmentExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AssignmentExpression_2=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignmentExpression_2;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 32, ruleTopLevelExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTopLevelExpression"


    // $ANTLR start "entryRuleExpression"
    // PsiInternalBeeLangTestLanguage.g:2324:1: entryRuleExpression returns [Boolean current=false] : iv_ruleExpression= ruleExpression EOF ;
    public final Boolean entryRuleExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleExpression_StartIndex = input.index();
        Boolean iv_ruleExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2324:52: (iv_ruleExpression= ruleExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2325:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, entryRuleExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // PsiInternalBeeLangTestLanguage.g:2331:1: ruleExpression returns [Boolean current=false] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final Boolean ruleExpression() throws RecognitionException {
        Boolean current = false;
        int ruleExpression_StartIndex = input.index();
        Boolean this_AssignmentExpression_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2332:1: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // PsiInternalBeeLangTestLanguage.g:2333:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getExpression_AssignmentExpressionParserRuleCallElementType());
              	
            }
            pushFollow(FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		doneComposite();
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, ruleExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // PsiInternalBeeLangTestLanguage.g:2347:1: entryRuleAssignmentExpression returns [Boolean current=false] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final Boolean entryRuleAssignmentExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleAssignmentExpression_StartIndex = input.index();
        Boolean iv_ruleAssignmentExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2347:62: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2348:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAssignmentExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, entryRuleAssignmentExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // PsiInternalBeeLangTestLanguage.g:2354:1: ruleAssignmentExpression returns [Boolean current=false] : (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) ;
    public final Boolean ruleAssignmentExpression() throws RecognitionException {
        Boolean current = false;
        int ruleAssignmentExpression_StartIndex = input.index();
        Boolean this_CachedExpression_0 = null;

        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2355:1: ( (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:2356:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:2356:2: (this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )? )
            // PsiInternalBeeLangTestLanguage.g:2357:3: this_CachedExpression_0= ruleCachedExpression ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAssignmentExpression_CachedExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_40);
            this_CachedExpression_0=ruleCachedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CachedExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2368:3: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )?
            int alt43=2;
            switch ( input.LA(1) ) {
                case 38:
                    {
                    int LA43_1 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 39:
                    {
                    int LA43_2 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA43_3 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 41:
                    {
                    int LA43_4 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA43_5 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA43_6 = input.LA(2);

                    if ( (synpred71_PsiInternalBeeLangTestLanguage()) ) {
                        alt43=1;
                    }
                    }
                    break;
            }

            switch (alt43) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2369:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2369:4: ()
                    // PsiInternalBeeLangTestLanguage.g:2370:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getAssignmentExpression_AssignmentExpressionLeftExprAction_1_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalBeeLangTestLanguage.g:2379:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
                    // PsiInternalBeeLangTestLanguage.g:2380:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2380:5: (lv_functionName_2_0= ruleAssignmentOperator )
                    // PsiInternalBeeLangTestLanguage.g:2381:6: lv_functionName_2_0= ruleAssignmentOperator
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getAssignmentExpression_FunctionNameAssignmentOperatorParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_functionName_2_0=ruleAssignmentOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2394:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2395:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2395:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
                    // PsiInternalBeeLangTestLanguage.g:2396:6: lv_rightExpr_3_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getAssignmentExpression_RightExprAssignmentExpressionParserRuleCall_1_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rightExpr_3_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, ruleAssignmentExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleVarDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2414:1: entryRuleVarDeclaration returns [Boolean current=false] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final Boolean entryRuleVarDeclaration() throws RecognitionException {
        Boolean current = false;
        int entryRuleVarDeclaration_StartIndex = input.index();
        Boolean iv_ruleVarDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2414:56: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // PsiInternalBeeLangTestLanguage.g:2415:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getVarDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVarDeclaration=ruleVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, entryRuleVarDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2421:1: ruleVarDeclaration returns [Boolean current=false] : ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) ;
    public final Boolean ruleVarDeclaration() throws RecognitionException {
        Boolean current = false;
        int ruleVarDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_valueExpr_6_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2422:1: ( ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:2423:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:2423:2: ( () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )? )
            // PsiInternalBeeLangTestLanguage.g:2424:3: () ( (lv_final_1_0= 'final' ) )? ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) ) (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            {
            // PsiInternalBeeLangTestLanguage.g:2424:3: ()
            // PsiInternalBeeLangTestLanguage.g:2425:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getVarDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:2434:3: ( (lv_final_1_0= 'final' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==33) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2435:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2435:4: (lv_final_1_0= 'final' )
                    // PsiInternalBeeLangTestLanguage.g:2436:5: lv_final_1_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getVarDeclaration_FinalFinalKeyword_1_0ElementType());
                      				
                    }
                    lv_final_1_0=(Token)match(input,33,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_1_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2451:3: ( (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:2452:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) ) ( (lv_name_4_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2452:4: (otherlv_2= 'var' | ( (lv_type_3_0= ruleTypeRef ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==53) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_ID||LA45_0==35) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2453:5: otherlv_2= 'var'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getVarDeclaration_VarKeyword_2_0_0ElementType());
                      				
                    }
                    otherlv_2=(Token)match(input,53,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_2);
                      				
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2461:5: ( (lv_type_3_0= ruleTypeRef ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2461:5: ( (lv_type_3_0= ruleTypeRef ) )
                    // PsiInternalBeeLangTestLanguage.g:2462:6: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2462:6: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:2463:7: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getVarDeclaration_TypeTypeRefParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2477:4: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2478:5: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2478:5: (lv_name_4_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2479:6: lv_name_4_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						markLeaf(elementTypeProvider.getVarDeclaration_NameIDTerminalRuleCall_2_1_0ElementType());
              					
            }
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if(!current) {
              							associateWithSemanticElement();
              							current = true;
              						}
              					
            }
            if ( state.backtracking==0 ) {

              						doneLeaf(lv_name_4_0);
              					
            }

            }


            }


            }

            // PsiInternalBeeLangTestLanguage.g:2495:3: (otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==38) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2496:4: otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getVarDeclaration_EqualsSignKeyword_3_0ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:2503:4: ( (lv_valueExpr_6_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2504:5: (lv_valueExpr_6_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2504:5: (lv_valueExpr_6_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:2505:6: lv_valueExpr_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getVarDeclaration_ValueExprExpressionParserRuleCall_3_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_valueExpr_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, ruleVarDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleValDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2523:1: entryRuleValDeclaration returns [Boolean current=false] : iv_ruleValDeclaration= ruleValDeclaration EOF ;
    public final Boolean entryRuleValDeclaration() throws RecognitionException {
        Boolean current = false;
        int entryRuleValDeclaration_StartIndex = input.index();
        Boolean iv_ruleValDeclaration = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2523:56: (iv_ruleValDeclaration= ruleValDeclaration EOF )
            // PsiInternalBeeLangTestLanguage.g:2524:2: iv_ruleValDeclaration= ruleValDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValDeclarationElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValDeclaration=ruleValDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, entryRuleValDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValDeclaration"


    // $ANTLR start "ruleValDeclaration"
    // PsiInternalBeeLangTestLanguage.g:2530:1: ruleValDeclaration returns [Boolean current=false] : ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) ;
    public final Boolean ruleValDeclaration() throws RecognitionException {
        Boolean current = false;
        int ruleValDeclaration_StartIndex = input.index();
        Token lv_final_1_0=null;
        Token lv_immutable_2_0=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Boolean lv_type_3_0 = null;

        Boolean lv_valueExpr_6_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2531:1: ( ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:2532:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2532:2: ( () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:2533:3: () ( (lv_final_1_0= 'final' ) )? ( (lv_immutable_2_0= 'val' ) ) ( (lv_type_3_0= ruleTypeRef ) )? ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_valueExpr_6_0= ruleExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2533:3: ()
            // PsiInternalBeeLangTestLanguage.g:2534:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValDeclaration_DefValueAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:2543:3: ( (lv_final_1_0= 'final' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==33) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2544:4: (lv_final_1_0= 'final' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2544:4: (lv_final_1_0= 'final' )
                    // PsiInternalBeeLangTestLanguage.g:2545:5: lv_final_1_0= 'final'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getValDeclaration_FinalFinalKeyword_1_0ElementType());
                      				
                    }
                    lv_final_1_0=(Token)match(input,33,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(lv_final_1_0);
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2560:3: ( (lv_immutable_2_0= 'val' ) )
            // PsiInternalBeeLangTestLanguage.g:2561:4: (lv_immutable_2_0= 'val' )
            {
            // PsiInternalBeeLangTestLanguage.g:2561:4: (lv_immutable_2_0= 'val' )
            // PsiInternalBeeLangTestLanguage.g:2562:5: lv_immutable_2_0= 'val'
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValDeclaration_ImmutableValKeyword_2_0ElementType());
              				
            }
            lv_immutable_2_0=(Token)match(input,54,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_immutable_2_0);
              				
            }
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:2577:3: ( (lv_type_3_0= ruleTypeRef ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==35) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_ID) ) {
                int LA48_2 = input.LA(2);

                if ( (LA48_2==RULE_ID||LA48_2==52) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2578:4: (lv_type_3_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2578:4: (lv_type_3_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:2579:5: lv_type_3_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getValDeclaration_TypeTypeRefParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_type_3_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:2592:3: ( (lv_name_4_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2593:4: (lv_name_4_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2593:4: (lv_name_4_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2594:5: lv_name_4_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValDeclaration_NameIDTerminalRuleCall_4_0ElementType());
              				
            }
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_4_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getValDeclaration_EqualsSignKeyword_5ElementType());
              		
            }
            otherlv_5=(Token)match(input,38,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_5);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2616:3: ( (lv_valueExpr_6_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:2617:4: (lv_valueExpr_6_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:2617:4: (lv_valueExpr_6_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:2618:5: lv_valueExpr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getValDeclaration_ValueExprExpressionParserRuleCall_6_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_valueExpr_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 40, ruleValDeclaration_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValDeclaration"


    // $ANTLR start "entryRuleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2635:1: entryRuleTypeRef returns [Boolean current=false] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final Boolean entryRuleTypeRef() throws RecognitionException {
        Boolean current = false;
        int entryRuleTypeRef_StartIndex = input.index();
        Boolean iv_ruleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2635:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // PsiInternalBeeLangTestLanguage.g:2636:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getTypeRefElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, entryRuleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2642:1: ruleTypeRef returns [Boolean current=false] : (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) ;
    public final Boolean ruleTypeRef() throws RecognitionException {
        Boolean current = false;
        int ruleTypeRef_StartIndex = input.index();
        Boolean this_ClosureTypeRef_0 = null;

        Boolean this_SimpleTypeRef_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2643:1: ( (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef ) )
            // PsiInternalBeeLangTestLanguage.g:2644:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            {
            // PsiInternalBeeLangTestLanguage.g:2644:2: (this_ClosureTypeRef_0= ruleClosureTypeRef | this_SimpleTypeRef_1= ruleSimpleTypeRef )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==35) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_ID) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2645:3: this_ClosureTypeRef_0= ruleClosureTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTypeRef_ClosureTypeRefParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ClosureTypeRef_0=ruleClosureTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ClosureTypeRef_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2657:3: this_SimpleTypeRef_1= ruleSimpleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getTypeRef_SimpleTypeRefParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SimpleTypeRef_1=ruleSimpleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SimpleTypeRef_1;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 42, ruleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleSimpleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2672:1: entryRuleSimpleTypeRef returns [Boolean current=false] : iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF ;
    public final Boolean entryRuleSimpleTypeRef() throws RecognitionException {
        Boolean current = false;
        int entryRuleSimpleTypeRef_StartIndex = input.index();
        Boolean iv_ruleSimpleTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2672:55: (iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF )
            // PsiInternalBeeLangTestLanguage.g:2673:2: iv_ruleSimpleTypeRef= ruleSimpleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSimpleTypeRefElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSimpleTypeRef=ruleSimpleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 43, entryRuleSimpleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleTypeRef"


    // $ANTLR start "ruleSimpleTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2679:1: ruleSimpleTypeRef returns [Boolean current=false] : ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) ;
    public final Boolean ruleSimpleTypeRef() throws RecognitionException {
        Boolean current = false;
        int ruleSimpleTypeRef_StartIndex = input.index();
        Token lv_rawType_0_0=null;
        Token otherlv_1=null;
        Token lv_actualArgumentsList_2_0=null;
        Token otherlv_3=null;
        Token lv_actualArgumentsList_4_0=null;
        Token otherlv_5=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2680:1: ( ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? ) )
            // PsiInternalBeeLangTestLanguage.g:2681:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            {
            // PsiInternalBeeLangTestLanguage.g:2681:2: ( ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )? )
            // PsiInternalBeeLangTestLanguage.g:2682:3: ( (lv_rawType_0_0= RULE_ID ) ) (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            {
            // PsiInternalBeeLangTestLanguage.g:2682:3: ( (lv_rawType_0_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2683:4: (lv_rawType_0_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2683:4: (lv_rawType_0_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2684:5: lv_rawType_0_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getSimpleTypeRef_RawTypeIDTerminalRuleCall_0_0ElementType());
              				
            }
            lv_rawType_0_0=(Token)match(input,RULE_ID,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_rawType_0_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:2699:3: (otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==52) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2700:4: otherlv_1= '<' ( (lv_actualArgumentsList_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )* otherlv_5= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSimpleTypeRef_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:2707:4: ( (lv_actualArgumentsList_2_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:2708:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2708:5: (lv_actualArgumentsList_2_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:2709:6: lv_actualArgumentsList_2_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getSimpleTypeRef_ActualArgumentsListIDTerminalRuleCall_1_1_0ElementType());
                      					
                    }
                    lv_actualArgumentsList_2_0=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_actualArgumentsList_2_0);
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2724:4: (otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==16) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:2725:5: otherlv_3= ',' ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getSimpleTypeRef_CommaKeyword_1_2_0ElementType());
                    	      				
                    	    }
                    	    otherlv_3=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_3);
                    	      				
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:2732:5: ( (lv_actualArgumentsList_4_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:2733:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:2733:6: (lv_actualArgumentsList_4_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:2734:7: lv_actualArgumentsList_4_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getSimpleTypeRef_ActualArgumentsListIDTerminalRuleCall_1_2_1_0ElementType());
                    	      						
                    	    }
                    	    lv_actualArgumentsList_4_0=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(lv_actualArgumentsList_4_0);
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getSimpleTypeRef_GreaterThanSignKeyword_1_3ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 44, ruleSimpleTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleSimpleTypeRef"


    // $ANTLR start "entryRuleClosureTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2762:1: entryRuleClosureTypeRef returns [Boolean current=false] : iv_ruleClosureTypeRef= ruleClosureTypeRef EOF ;
    public final Boolean entryRuleClosureTypeRef() throws RecognitionException {
        Boolean current = false;
        int entryRuleClosureTypeRef_StartIndex = input.index();
        Boolean iv_ruleClosureTypeRef = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2762:56: (iv_ruleClosureTypeRef= ruleClosureTypeRef EOF )
            // PsiInternalBeeLangTestLanguage.g:2763:2: iv_ruleClosureTypeRef= ruleClosureTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureTypeRefElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClosureTypeRef=ruleClosureTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosureTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 45, entryRuleClosureTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureTypeRef"


    // $ANTLR start "ruleClosureTypeRef"
    // PsiInternalBeeLangTestLanguage.g:2769:1: ruleClosureTypeRef returns [Boolean current=false] : (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) ;
    public final Boolean ruleClosureTypeRef() throws RecognitionException {
        Boolean current = false;
        int ruleClosureTypeRef_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_parameterTypes_1_0=null;
        Token otherlv_2=null;
        Token lv_parameterTypes_3_0=null;
        Token otherlv_4=null;
        Token lv_varArgs_5_0=null;
        Token lv_parameterTypes_6_0=null;
        Token lv_varArgs_7_0=null;
        Token lv_parameterTypes_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_returnType_11_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2770:1: ( (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:2771:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:2771:2: (otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:2772:3: otherlv_0= '(' ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )? otherlv_9= ')' otherlv_10= '=>' ( (lv_returnType_11_0= RULE_ID ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,35,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2779:3: ( ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? ) | ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) ) )?
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==36) ) {
                alt54=2;
            }
            switch (alt54) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2780:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2780:4: ( ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )? )
                    // PsiInternalBeeLangTestLanguage.g:2781:5: ( (lv_parameterTypes_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )* (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    {
                    // PsiInternalBeeLangTestLanguage.g:2781:5: ( (lv_parameterTypes_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:2782:6: (lv_parameterTypes_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2782:6: (lv_parameterTypes_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:2783:7: lv_parameterTypes_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_0_0ElementType());
                      						
                    }
                    lv_parameterTypes_1_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_parameterTypes_1_0);
                      						
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2798:5: (otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==16) ) {
                            int LA52_1 = input.LA(2);

                            if ( (LA52_1==RULE_ID) ) {
                                alt52=1;
                            }


                        }


                        switch (alt52) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:2799:6: otherlv_2= ',' ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_1_0ElementType());
                    	      					
                    	    }
                    	    otherlv_2=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						doneLeaf(otherlv_2);
                    	      					
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:2806:6: ( (lv_parameterTypes_3_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:2807:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:2807:7: (lv_parameterTypes_3_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:2808:8: lv_parameterTypes_3_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_1_1_0ElementType());
                    	      							
                    	    }
                    	    lv_parameterTypes_3_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if(!current) {
                    	      									associateWithSemanticElement();
                    	      									current = true;
                    	      								}
                    	      							
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      								doneLeaf(lv_parameterTypes_3_0);
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    // PsiInternalBeeLangTestLanguage.g:2824:5: (otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==16) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:2825:6: otherlv_4= ',' ( (lv_varArgs_5_0= '...' ) ) ( (lv_parameterTypes_6_0= RULE_ID ) )
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getClosureTypeRef_CommaKeyword_1_0_2_0ElementType());
                              					
                            }
                            otherlv_4=(Token)match(input,16,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(otherlv_4);
                              					
                            }
                            // PsiInternalBeeLangTestLanguage.g:2832:6: ( (lv_varArgs_5_0= '...' ) )
                            // PsiInternalBeeLangTestLanguage.g:2833:7: (lv_varArgs_5_0= '...' )
                            {
                            // PsiInternalBeeLangTestLanguage.g:2833:7: (lv_varArgs_5_0= '...' )
                            // PsiInternalBeeLangTestLanguage.g:2834:8: lv_varArgs_5_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getClosureTypeRef_VarArgsFullStopFullStopFullStopKeyword_1_0_2_1_0ElementType());
                              							
                            }
                            lv_varArgs_5_0=(Token)match(input,36,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_varArgs_5_0);
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:2849:6: ( (lv_parameterTypes_6_0= RULE_ID ) )
                            // PsiInternalBeeLangTestLanguage.g:2850:7: (lv_parameterTypes_6_0= RULE_ID )
                            {
                            // PsiInternalBeeLangTestLanguage.g:2850:7: (lv_parameterTypes_6_0= RULE_ID )
                            // PsiInternalBeeLangTestLanguage.g:2851:8: lv_parameterTypes_6_0= RULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              								markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_0_2_2_0ElementType());
                              							
                            }
                            lv_parameterTypes_6_0=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if(!current) {
                              									associateWithSemanticElement();
                              									current = true;
                              								}
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								doneLeaf(lv_parameterTypes_6_0);
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2869:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2869:4: ( ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) ) )
                    // PsiInternalBeeLangTestLanguage.g:2870:5: ( (lv_varArgs_7_0= '...' ) ) ( (lv_parameterTypes_8_0= RULE_ID ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2870:5: ( (lv_varArgs_7_0= '...' ) )
                    // PsiInternalBeeLangTestLanguage.g:2871:6: (lv_varArgs_7_0= '...' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2871:6: (lv_varArgs_7_0= '...' )
                    // PsiInternalBeeLangTestLanguage.g:2872:7: lv_varArgs_7_0= '...'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_VarArgsFullStopFullStopFullStopKeyword_1_1_0_0ElementType());
                      						
                    }
                    lv_varArgs_7_0=(Token)match(input,36,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_varArgs_7_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:2887:5: ( (lv_parameterTypes_8_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:2888:6: (lv_parameterTypes_8_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2888:6: (lv_parameterTypes_8_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:2889:7: lv_parameterTypes_8_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureTypeRef_ParameterTypesIDTerminalRuleCall_1_1_1_0ElementType());
                      						
                    }
                    lv_parameterTypes_8_0=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_parameterTypes_8_0);
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_9=(Token)match(input,37,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_9);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureTypeRef_EqualsSignGreaterThanSignKeyword_3ElementType());
              		
            }
            otherlv_10=(Token)match(input,55,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_10);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:2920:3: ( (lv_returnType_11_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:2921:4: (lv_returnType_11_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:2921:4: (lv_returnType_11_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:2922:5: lv_returnType_11_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getClosureTypeRef_ReturnTypeIDTerminalRuleCall_4_0ElementType());
              				
            }
            lv_returnType_11_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_returnType_11_0);
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 46, ruleClosureTypeRef_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureTypeRef"


    // $ANTLR start "entryRuleCachedExpression"
    // PsiInternalBeeLangTestLanguage.g:2941:1: entryRuleCachedExpression returns [Boolean current=false] : iv_ruleCachedExpression= ruleCachedExpression EOF ;
    public final Boolean entryRuleCachedExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleCachedExpression_StartIndex = input.index();
        Boolean iv_ruleCachedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2941:58: (iv_ruleCachedExpression= ruleCachedExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:2942:2: iv_ruleCachedExpression= ruleCachedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getCachedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCachedExpression=ruleCachedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCachedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 47, entryRuleCachedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCachedExpression"


    // $ANTLR start "ruleCachedExpression"
    // PsiInternalBeeLangTestLanguage.g:2948:1: ruleCachedExpression returns [Boolean current=false] : ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) ;
    public final Boolean ruleCachedExpression() throws RecognitionException {
        Boolean current = false;
        int ruleCachedExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Boolean lv_expr_2_0 = null;

        Boolean this_OrExpression_3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:2949:1: ( ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression ) )
            // PsiInternalBeeLangTestLanguage.g:2950:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:2950:2: ( ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) ) | this_OrExpression_3= ruleOrExpression )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_ID||LA55_0==RULE_STRING||LA55_0==13||(LA55_0>=17 && LA55_0<=18)||LA55_0==21||LA55_0==35||LA55_0==60||(LA55_0>=64 && LA55_0<=66)||LA55_0==70||(LA55_0>=72 && LA55_0<=76)) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:2951:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2951:3: ( () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) ) )
                    // PsiInternalBeeLangTestLanguage.g:2952:4: () otherlv_1= 'cached' ( (lv_expr_2_0= ruleOrExpression ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2952:4: ()
                    // PsiInternalBeeLangTestLanguage.g:2953:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getCachedExpression_CachedExpressionAction_0_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getCachedExpression_CachedKeyword_0_1ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,56,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:2969:4: ( (lv_expr_2_0= ruleOrExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:2970:5: (lv_expr_2_0= ruleOrExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:2970:5: (lv_expr_2_0= ruleOrExpression )
                    // PsiInternalBeeLangTestLanguage.g:2971:6: lv_expr_2_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getCachedExpression_ExprOrExpressionParserRuleCall_0_2_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_2_0=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:2986:3: this_OrExpression_3= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getCachedExpression_OrExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OrExpression_3=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OrExpression_3;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 48, ruleCachedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleCachedExpression"


    // $ANTLR start "entryRuleOrExpression"
    // PsiInternalBeeLangTestLanguage.g:3001:1: entryRuleOrExpression returns [Boolean current=false] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final Boolean entryRuleOrExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleOrExpression_StartIndex = input.index();
        Boolean iv_ruleOrExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3001:54: (iv_ruleOrExpression= ruleOrExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3002:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOrExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 49, entryRuleOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // PsiInternalBeeLangTestLanguage.g:3008:1: ruleOrExpression returns [Boolean current=false] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) ;
    public final Boolean ruleOrExpression() throws RecognitionException {
        Boolean current = false;
        int ruleOrExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Boolean this_AndExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3009:1: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3010:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3010:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3011:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getOrExpression_AndExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_49);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3022:3: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==57) ) {
                    int LA56_2 = input.LA(2);

                    if ( (synpred85_PsiInternalBeeLangTestLanguage()) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3023:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3023:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3024:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getOrExpression_OrExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getOrExpression_VerticalLineVerticalLineKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,57,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3040:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3041:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3041:5: (lv_rightExpr_3_0= ruleAndExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3042:6: lv_rightExpr_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getOrExpression_RightExprAndExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_49);
            	    lv_rightExpr_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 50, ruleOrExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // PsiInternalBeeLangTestLanguage.g:3060:1: entryRuleAndExpression returns [Boolean current=false] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final Boolean entryRuleAndExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleAndExpression_StartIndex = input.index();
        Boolean iv_ruleAndExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3060:55: (iv_ruleAndExpression= ruleAndExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3061:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAndExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 51, entryRuleAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // PsiInternalBeeLangTestLanguage.g:3067:1: ruleAndExpression returns [Boolean current=false] : (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) ;
    public final Boolean ruleAndExpression() throws RecognitionException {
        Boolean current = false;
        int ruleAndExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Boolean this_RelationalExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3068:1: ( (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3069:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3069:2: (this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3070:3: this_RelationalExpression_0= ruleRelationalExpression ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAndExpression_RelationalExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_50);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3081:3: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==58) ) {
                    int LA57_2 = input.LA(2);

                    if ( (synpred86_PsiInternalBeeLangTestLanguage()) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3082:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3082:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3083:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAndExpression_AndExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getAndExpression_AmpersandAmpersandKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,58,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3099:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3100:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3100:5: (lv_rightExpr_3_0= ruleRelationalExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3101:6: lv_rightExpr_3_0= ruleRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAndExpression_RightExprRelationalExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_50);
            	    lv_rightExpr_3_0=ruleRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 52, ruleAndExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // PsiInternalBeeLangTestLanguage.g:3119:1: entryRuleRelationalExpression returns [Boolean current=false] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final Boolean entryRuleRelationalExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleRelationalExpression_StartIndex = input.index();
        Boolean iv_ruleRelationalExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3119:62: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3120:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getRelationalExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 53, entryRuleRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // PsiInternalBeeLangTestLanguage.g:3126:1: ruleRelationalExpression returns [Boolean current=false] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final Boolean ruleRelationalExpression() throws RecognitionException {
        Boolean current = false;
        int ruleRelationalExpression_StartIndex = input.index();
        Boolean this_AdditiveExpression_0 = null;

        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3127:1: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3128:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3128:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3129:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getRelationalExpression_AdditiveExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_51);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3140:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3141:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3141:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3142:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getRelationalExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3151:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
            	    // PsiInternalBeeLangTestLanguage.g:3152:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3152:5: (lv_functionName_2_0= ruleRelationalOperator )
            	    // PsiInternalBeeLangTestLanguage.g:3153:6: lv_functionName_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getRelationalExpression_FunctionNameRelationalOperatorParserRuleCall_1_1_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_functionName_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3166:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3167:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3167:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3168:6: lv_rightExpr_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getRelationalExpression_RightExprAdditiveExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_51);
            	    lv_rightExpr_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 54, ruleRelationalExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // PsiInternalBeeLangTestLanguage.g:3186:1: entryRuleAdditiveExpression returns [Boolean current=false] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final Boolean entryRuleAdditiveExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleAdditiveExpression_StartIndex = input.index();
        Boolean iv_ruleAdditiveExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3186:60: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3187:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getAdditiveExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 55, entryRuleAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // PsiInternalBeeLangTestLanguage.g:3193:1: ruleAdditiveExpression returns [Boolean current=false] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final Boolean ruleAdditiveExpression() throws RecognitionException {
        Boolean current = false;
        int ruleAdditiveExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Boolean this_MultiplicativeExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3194:1: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3195:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3195:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3196:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getAdditiveExpression_MultiplicativeExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_52);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3207:3: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==59) ) {
                    int LA60_2 = input.LA(2);

                    if ( (synpred89_PsiInternalBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }
                else if ( (LA60_0==60) ) {
                    int LA60_3 = input.LA(2);

                    if ( (synpred89_PsiInternalBeeLangTestLanguage()) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3208:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3208:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3209:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getAdditiveExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3218:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:3219:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3219:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
            	    // PsiInternalBeeLangTestLanguage.g:3220:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3220:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==59) ) {
            	        alt59=1;
            	    }
            	    else if ( (LA59_0==60) ) {
            	        alt59=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 59, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:3221:7: lv_functionName_2_1= '+'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNamePlusSignKeyword_1_1_0_0ElementType());
            	              						
            	            }
            	            lv_functionName_2_1=(Token)match(input,59,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_1);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalBeeLangTestLanguage.g:3235:7: lv_functionName_2_2= '-'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNameHyphenMinusKeyword_1_1_0_1ElementType());
            	              						
            	            }
            	            lv_functionName_2_2=(Token)match(input,60,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_2);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3251:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3252:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3252:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3253:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getAdditiveExpression_RightExprMultiplicativeExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_52);
            	    lv_rightExpr_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 56, ruleAdditiveExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // PsiInternalBeeLangTestLanguage.g:3271:1: entryRuleMultiplicativeExpression returns [Boolean current=false] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final Boolean entryRuleMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleMultiplicativeExpression_StartIndex = input.index();
        Boolean iv_ruleMultiplicativeExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3271:66: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3272:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getMultiplicativeExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 57, entryRuleMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // PsiInternalBeeLangTestLanguage.g:3278:1: ruleMultiplicativeExpression returns [Boolean current=false] : (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) ;
    public final Boolean ruleMultiplicativeExpression() throws RecognitionException {
        Boolean current = false;
        int ruleMultiplicativeExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        Boolean this_SetExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3279:1: ( (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3280:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3280:2: (this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3281:3: this_SetExpression_0= ruleSetExpression ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getMultiplicativeExpression_SetExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_53);
            this_SetExpression_0=ruleSetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SetExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3292:3: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA62_2 = input.LA(2);

                    if ( (synpred92_PsiInternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 32:
                    {
                    int LA62_3 = input.LA(2);

                    if ( (synpred92_PsiInternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;
                case 62:
                    {
                    int LA62_4 = input.LA(2);

                    if ( (synpred92_PsiInternalBeeLangTestLanguage()) ) {
                        alt62=1;
                    }


                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3293:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3293:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3294:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getMultiplicativeExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3303:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:3304:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3304:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
            	    // PsiInternalBeeLangTestLanguage.g:3305:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3305:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
            	    int alt61=3;
            	    switch ( input.LA(1) ) {
            	    case 61:
            	        {
            	        alt61=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt61=2;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt61=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt61) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:3306:7: lv_functionName_2_1= '*'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNameAsteriskKeyword_1_1_0_0ElementType());
            	              						
            	            }
            	            lv_functionName_2_1=(Token)match(input,61,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_1);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // PsiInternalBeeLangTestLanguage.g:3320:7: lv_functionName_2_2= '/'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNameSolidusKeyword_1_1_0_1ElementType());
            	              						
            	            }
            	            lv_functionName_2_2=(Token)match(input,32,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_2);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // PsiInternalBeeLangTestLanguage.g:3334:7: lv_functionName_2_3= '%'
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNamePercentSignKeyword_1_1_0_2ElementType());
            	              						
            	            }
            	            lv_functionName_2_3=(Token)match(input,62,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneLeaf(lv_functionName_2_3);
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3350:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3351:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3351:5: (lv_rightExpr_3_0= ruleSetExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3352:6: lv_rightExpr_3_0= ruleSetExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getMultiplicativeExpression_RightExprSetExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
            	    lv_rightExpr_3_0=ruleSetExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 58, ruleMultiplicativeExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleSetExpression"
    // PsiInternalBeeLangTestLanguage.g:3370:1: entryRuleSetExpression returns [Boolean current=false] : iv_ruleSetExpression= ruleSetExpression EOF ;
    public final Boolean entryRuleSetExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleSetExpression_StartIndex = input.index();
        Boolean iv_ruleSetExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3370:55: (iv_ruleSetExpression= ruleSetExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3371:2: iv_ruleSetExpression= ruleSetExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getSetExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetExpression=ruleSetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 59, entryRuleSetExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleSetExpression"


    // $ANTLR start "ruleSetExpression"
    // PsiInternalBeeLangTestLanguage.g:3377:1: ruleSetExpression returns [Boolean current=false] : (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) ;
    public final Boolean ruleSetExpression() throws RecognitionException {
        Boolean current = false;
        int ruleSetExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        Boolean this_UnaryOrInfixExpression_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3378:1: ( (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3379:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3379:2: (this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3380:3: this_UnaryOrInfixExpression_0= ruleUnaryOrInfixExpression ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getSetExpression_UnaryOrInfixExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_54);
            this_UnaryOrInfixExpression_0=ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_UnaryOrInfixExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3391:3: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==63) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred93_PsiInternalBeeLangTestLanguage()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3392:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3392:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3393:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getSetExpression_BinaryOpExpressionLeftExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3402:4: ( (lv_functionName_2_0= '..' ) )
            	    // PsiInternalBeeLangTestLanguage.g:3403:5: (lv_functionName_2_0= '..' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3403:5: (lv_functionName_2_0= '..' )
            	    // PsiInternalBeeLangTestLanguage.g:3404:6: lv_functionName_2_0= '..'
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markLeaf(elementTypeProvider.getSetExpression_FunctionNameFullStopFullStopKeyword_1_1_0ElementType());
            	      					
            	    }
            	    lv_functionName_2_0=(Token)match(input,63,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneLeaf(lv_functionName_2_0);
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    // PsiInternalBeeLangTestLanguage.g:3419:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3420:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3420:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3421:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getSetExpression_RightExprUnaryOrInfixExpressionParserRuleCall_1_2_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
            	    lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 60, ruleSetExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleSetExpression"


    // $ANTLR start "entryRuleUnaryOrInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:3439:1: entryRuleUnaryOrInfixExpression returns [Boolean current=false] : iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF ;
    public final Boolean entryRuleUnaryOrInfixExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleUnaryOrInfixExpression_StartIndex = input.index();
        Boolean iv_ruleUnaryOrInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3439:64: (iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3440:2: iv_ruleUnaryOrInfixExpression= ruleUnaryOrInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnaryOrInfixExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOrInfixExpression=ruleUnaryOrInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOrInfixExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 61, entryRuleUnaryOrInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOrInfixExpression"


    // $ANTLR start "ruleUnaryOrInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:3446:1: ruleUnaryOrInfixExpression returns [Boolean current=false] : (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) ;
    public final Boolean ruleUnaryOrInfixExpression() throws RecognitionException {
        Boolean current = false;
        int ruleUnaryOrInfixExpression_StartIndex = input.index();
        Boolean this_PostopExpression_0 = null;

        Boolean this_UnaryExpression_1 = null;

        Boolean this_PreopExpression_2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3447:1: ( (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3448:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3448:2: (this_PostopExpression_0= rulePostopExpression | this_UnaryExpression_1= ruleUnaryExpression | this_PreopExpression_2= rulePreopExpression )
            int alt64=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_STRING:
            case 13:
            case 17:
            case 18:
            case 21:
            case 35:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
                {
                alt64=1;
                }
                break;
            case 60:
            case 64:
                {
                alt64=2;
                }
                break;
            case 65:
            case 66:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3449:3: this_PostopExpression_0= rulePostopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_PostopExpressionParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostopExpression_0=rulePostopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostopExpression_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3461:3: this_UnaryExpression_1= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_UnaryExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_1=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:3473:3: this_PreopExpression_2= rulePreopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getUnaryOrInfixExpression_PreopExpressionParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PreopExpression_2=rulePreopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PreopExpression_2;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 62, ruleUnaryOrInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOrInfixExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // PsiInternalBeeLangTestLanguage.g:3488:1: entryRuleUnaryExpression returns [Boolean current=false] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final Boolean entryRuleUnaryExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleUnaryExpression_StartIndex = input.index();
        Boolean iv_ruleUnaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3488:57: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3489:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getUnaryExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 63, entryRuleUnaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // PsiInternalBeeLangTestLanguage.g:3495:1: ruleUnaryExpression returns [Boolean current=false] : ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final Boolean ruleUnaryExpression() throws RecognitionException {
        Boolean current = false;
        int ruleUnaryExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        Boolean lv_expr_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3496:1: ( ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3497:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3497:2: ( () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:3498:3: () ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3498:3: ()
            // PsiInternalBeeLangTestLanguage.g:3499:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getUnaryExpression_UnaryOpExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:3508:3: ( ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) ) )
            // PsiInternalBeeLangTestLanguage.g:3509:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3509:4: ( (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' ) )
            // PsiInternalBeeLangTestLanguage.g:3510:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            {
            // PsiInternalBeeLangTestLanguage.g:3510:5: (lv_functionName_1_1= '!' | lv_functionName_1_2= '-' )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==64) ) {
                alt65=1;
            }
            else if ( (LA65_0==60) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3511:6: lv_functionName_1_1= '!'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnaryExpression_FunctionNameExclamationMarkKeyword_1_0_0ElementType());
                      					
                    }
                    lv_functionName_1_1=(Token)match(input,64,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_1);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3525:6: lv_functionName_1_2= '-'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getUnaryExpression_FunctionNameHyphenMinusKeyword_1_0_1ElementType());
                      					
                    }
                    lv_functionName_1_2=(Token)match(input,60,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_2);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalBeeLangTestLanguage.g:3541:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3542:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3542:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalBeeLangTestLanguage.g:3543:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getUnaryExpression_ExprInfixExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 64, ruleUnaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePreopExpression"
    // PsiInternalBeeLangTestLanguage.g:3560:1: entryRulePreopExpression returns [Boolean current=false] : iv_rulePreopExpression= rulePreopExpression EOF ;
    public final Boolean entryRulePreopExpression() throws RecognitionException {
        Boolean current = false;
        int entryRulePreopExpression_StartIndex = input.index();
        Boolean iv_rulePreopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3560:57: (iv_rulePreopExpression= rulePreopExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3561:2: iv_rulePreopExpression= rulePreopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPreopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePreopExpression=rulePreopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePreopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 65, entryRulePreopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePreopExpression"


    // $ANTLR start "rulePreopExpression"
    // PsiInternalBeeLangTestLanguage.g:3567:1: rulePreopExpression returns [Boolean current=false] : ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) ;
    public final Boolean rulePreopExpression() throws RecognitionException {
        Boolean current = false;
        int rulePreopExpression_StartIndex = input.index();
        Token lv_functionName_1_1=null;
        Token lv_functionName_1_2=null;
        Boolean lv_expr_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3568:1: ( ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:3569:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3569:2: ( () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:3570:3: () ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) ) ( (lv_expr_2_0= ruleInfixExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3570:3: ()
            // PsiInternalBeeLangTestLanguage.g:3571:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getPreopExpression_UnaryPreOpExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:3580:3: ( ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) ) )
            // PsiInternalBeeLangTestLanguage.g:3581:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:3581:4: ( (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' ) )
            // PsiInternalBeeLangTestLanguage.g:3582:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            {
            // PsiInternalBeeLangTestLanguage.g:3582:5: (lv_functionName_1_1= '++' | lv_functionName_1_2= '--' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==65) ) {
                alt66=1;
            }
            else if ( (LA66_0==66) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3583:6: lv_functionName_1_1= '++'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPreopExpression_FunctionNamePlusSignPlusSignKeyword_1_0_0ElementType());
                      					
                    }
                    lv_functionName_1_1=(Token)match(input,65,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_1);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3597:6: lv_functionName_1_2= '--'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getPreopExpression_FunctionNameHyphenMinusHyphenMinusKeyword_1_0_1ElementType());
                      					
                    }
                    lv_functionName_1_2=(Token)match(input,66,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_functionName_1_2);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;

            }


            }


            }

            // PsiInternalBeeLangTestLanguage.g:3613:3: ( (lv_expr_2_0= ruleInfixExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3614:4: (lv_expr_2_0= ruleInfixExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3614:4: (lv_expr_2_0= ruleInfixExpression )
            // PsiInternalBeeLangTestLanguage.g:3615:5: lv_expr_2_0= ruleInfixExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getPreopExpression_ExprInfixExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 66, rulePreopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePreopExpression"


    // $ANTLR start "entryRulePostopExpression"
    // PsiInternalBeeLangTestLanguage.g:3632:1: entryRulePostopExpression returns [Boolean current=false] : iv_rulePostopExpression= rulePostopExpression EOF ;
    public final Boolean entryRulePostopExpression() throws RecognitionException {
        Boolean current = false;
        int entryRulePostopExpression_StartIndex = input.index();
        Boolean iv_rulePostopExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3632:58: (iv_rulePostopExpression= rulePostopExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3633:2: iv_rulePostopExpression= rulePostopExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPostopExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostopExpression=rulePostopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 67, entryRulePostopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePostopExpression"


    // $ANTLR start "rulePostopExpression"
    // PsiInternalBeeLangTestLanguage.g:3639:1: rulePostopExpression returns [Boolean current=false] : (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) ;
    public final Boolean rulePostopExpression() throws RecognitionException {
        Boolean current = false;
        int rulePostopExpression_StartIndex = input.index();
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Boolean this_InfixExpression_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3640:1: ( (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:3641:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:3641:2: (this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )? )
            // PsiInternalBeeLangTestLanguage.g:3642:3: this_InfixExpression_0= ruleInfixExpression ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getPostopExpression_InfixExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_56);
            this_InfixExpression_0=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_InfixExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3653:3: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==66) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred99_PsiInternalBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            else if ( (LA68_0==65) ) {
                int LA68_2 = input.LA(2);

                if ( (synpred99_PsiInternalBeeLangTestLanguage()) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3654:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3654:4: ()
                    // PsiInternalBeeLangTestLanguage.g:3655:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					precedeComposite(elementTypeProvider.getPostopExpression_UnaryPostOpExpressionExprAction_1_0ElementType());
                      					doneComposite();
                      					associateWithSemanticElement();
                      				
                    }

                    }

                    // PsiInternalBeeLangTestLanguage.g:3664:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
                    // PsiInternalBeeLangTestLanguage.g:3665:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3665:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
                    // PsiInternalBeeLangTestLanguage.g:3666:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:3666:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==66) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==65) ) {
                        alt67=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:3667:7: lv_functionName_2_1= '--'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getPostopExpression_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_0ElementType());
                              						
                            }
                            lv_functionName_2_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_functionName_2_1);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }
                            break;
                        case 2 :
                            // PsiInternalBeeLangTestLanguage.g:3681:7: lv_functionName_2_2= '++'
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getPostopExpression_FunctionNamePlusSignPlusSignKeyword_1_1_0_1ElementType());
                              						
                            }
                            lv_functionName_2_2=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(lv_functionName_2_2);
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (!current) {
                              								associateWithSemanticElement();
                              								current = true;
                              							}
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 68, rulePostopExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePostopExpression"


    // $ANTLR start "entryRuleInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:3702:1: entryRuleInfixExpression returns [Boolean current=false] : iv_ruleInfixExpression= ruleInfixExpression EOF ;
    public final Boolean entryRuleInfixExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleInfixExpression_StartIndex = input.index();
        Boolean iv_ruleInfixExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3702:57: (iv_ruleInfixExpression= ruleInfixExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3703:2: iv_ruleInfixExpression= ruleInfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInfixExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInfixExpression=ruleInfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 69, entryRuleInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixExpression"


    // $ANTLR start "ruleInfixExpression"
    // PsiInternalBeeLangTestLanguage.g:3709:1: ruleInfixExpression returns [Boolean current=false] : (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) ;
    public final Boolean ruleInfixExpression() throws RecognitionException {
        Boolean current = false;
        int ruleInfixExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;
        Boolean this_CallExpression_0 = null;

        Boolean lv_parameterList_5_0 = null;

        Boolean lv_indexExpr_9_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3710:1: ( (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* ) )
            // PsiInternalBeeLangTestLanguage.g:3711:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3711:2: (this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )* )
            // PsiInternalBeeLangTestLanguage.g:3712:3: this_CallExpression_0= ruleCallExpression ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getInfixExpression_CallExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_57);
            this_CallExpression_0=ruleCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CallExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3723:3: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) | ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) | ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )*
            loop70:
            do {
                int alt70=4;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==67) ) {
                    int LA70_2 = input.LA(2);

                    if ( (synpred101_PsiInternalBeeLangTestLanguage()) ) {
                        alt70=1;
                    }
                    else if ( (synpred103_PsiInternalBeeLangTestLanguage()) ) {
                        alt70=3;
                    }


                }
                else if ( (LA70_0==68) ) {
                    int LA70_3 = input.LA(2);

                    if ( (synpred102_PsiInternalBeeLangTestLanguage()) ) {
                        alt70=2;
                    }


                }


                switch (alt70) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3724:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3724:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
            	    // PsiInternalBeeLangTestLanguage.g:3725:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3725:5: ()
            	    // PsiInternalBeeLangTestLanguage.g:3726:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_CallFeatureFuncExprAction_1_0_0ElementType());
            	      						doneComposite();
            	      						associateWithSemanticElement();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_FullStopKeyword_1_0_1ElementType());
            	      				
            	    }
            	    otherlv_2=(Token)match(input,67,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_2);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3742:5: ( (lv_name_3_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:3743:6: (lv_name_3_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3743:6: (lv_name_3_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:3744:7: lv_name_3_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType());
            	      						
            	    }
            	    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_58); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(lv_name_3_0);
            	      						
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_LeftParenthesisKeyword_1_0_3ElementType());
            	      				
            	    }
            	    otherlv_4=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_4);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3766:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
            	    int alt69=2;
            	    int LA69_0 = input.LA(1);

            	    if ( (LA69_0==RULE_ID||LA69_0==RULE_STRING||LA69_0==13||(LA69_0>=17 && LA69_0<=18)||LA69_0==21||(LA69_0>=35 && LA69_0<=36)||LA69_0==52||LA69_0==56||LA69_0==60||(LA69_0>=64 && LA69_0<=66)||LA69_0==70||(LA69_0>=72 && LA69_0<=77)) ) {
            	        alt69=1;
            	    }
            	    switch (alt69) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:3767:6: (lv_parameterList_5_0= ruleParameterList )
            	            {
            	            // PsiInternalBeeLangTestLanguage.g:3767:6: (lv_parameterList_5_0= ruleParameterList )
            	            // PsiInternalBeeLangTestLanguage.g:3768:7: lv_parameterList_5_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              							markComposite(elementTypeProvider.getInfixExpression_ParameterListParameterListParserRuleCall_1_0_4_0ElementType());
            	              						
            	            }
            	            pushFollow(FOLLOW_37);
            	            lv_parameterList_5_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							doneComposite();
            	              							if(!current) {
            	              								associateWithSemanticElement();
            	              								current = true;
            	              							}
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_RightParenthesisKeyword_1_0_5ElementType());
            	      				
            	    }
            	    otherlv_6=(Token)match(input,37,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_6);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:3790:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3790:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
            	    // PsiInternalBeeLangTestLanguage.g:3791:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3791:5: ()
            	    // PsiInternalBeeLangTestLanguage.g:3792:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_AtExpressionObjExprAction_1_1_0ElementType());
            	      						doneComposite();
            	      						associateWithSemanticElement();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_LeftSquareBracketKeyword_1_1_1ElementType());
            	      				
            	    }
            	    otherlv_8=(Token)match(input,68,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_8);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3808:5: ( (lv_indexExpr_9_0= ruleExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:3809:6: (lv_indexExpr_9_0= ruleExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3809:6: (lv_indexExpr_9_0= ruleExpression )
            	    // PsiInternalBeeLangTestLanguage.g:3810:7: lv_indexExpr_9_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markComposite(elementTypeProvider.getInfixExpression_IndexExprExpressionParserRuleCall_1_1_2_0ElementType());
            	      						
            	    }
            	    pushFollow(FOLLOW_60);
            	    lv_indexExpr_9_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							doneComposite();
            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_RightSquareBracketKeyword_1_1_3ElementType());
            	      				
            	    }
            	    otherlv_10=(Token)match(input,69,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_10);
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:3832:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3832:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
            	    // PsiInternalBeeLangTestLanguage.g:3833:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3833:5: ()
            	    // PsiInternalBeeLangTestLanguage.g:3834:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						/* */
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						precedeComposite(elementTypeProvider.getInfixExpression_FeatureExpressionObjExprAction_1_2_0ElementType());
            	      						doneComposite();
            	      						associateWithSemanticElement();
            	      					
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      					markLeaf(elementTypeProvider.getInfixExpression_FullStopKeyword_1_2_1ElementType());
            	      				
            	    }
            	    otherlv_12=(Token)match(input,67,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					doneLeaf(otherlv_12);
            	      				
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3850:5: ( (lv_featureName_13_0= RULE_ID ) )
            	    // PsiInternalBeeLangTestLanguage.g:3851:6: (lv_featureName_13_0= RULE_ID )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3851:6: (lv_featureName_13_0= RULE_ID )
            	    // PsiInternalBeeLangTestLanguage.g:3852:7: lv_featureName_13_0= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							markLeaf(elementTypeProvider.getInfixExpression_FeatureNameIDTerminalRuleCall_1_2_2_0ElementType());
            	      						
            	    }
            	    lv_featureName_13_0=(Token)match(input,RULE_ID,FOLLOW_57); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if(!current) {
            	      								associateWithSemanticElement();
            	      								current = true;
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							doneLeaf(lv_featureName_13_0);
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 70, ruleInfixExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInfixExpression"


    // $ANTLR start "entryRuleCallExpression"
    // PsiInternalBeeLangTestLanguage.g:3873:1: entryRuleCallExpression returns [Boolean current=false] : iv_ruleCallExpression= ruleCallExpression EOF ;
    public final Boolean entryRuleCallExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleCallExpression_StartIndex = input.index();
        Boolean iv_ruleCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3873:56: (iv_ruleCallExpression= ruleCallExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3874:2: iv_ruleCallExpression= ruleCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getCallExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCallExpression=ruleCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCallExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 71, entryRuleCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleCallExpression"


    // $ANTLR start "ruleCallExpression"
    // PsiInternalBeeLangTestLanguage.g:3880:1: ruleCallExpression returns [Boolean current=false] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) ;
    public final Boolean ruleCallExpression() throws RecognitionException {
        Boolean current = false;
        int ruleCallExpression_StartIndex = input.index();
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean this_PrimaryExpression_0 = null;

        Boolean lv_parameterList_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3881:1: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* ) )
            // PsiInternalBeeLangTestLanguage.g:3882:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            {
            // PsiInternalBeeLangTestLanguage.g:3882:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )* )
            // PsiInternalBeeLangTestLanguage.g:3883:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            {
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getCallExpression_PrimaryExpressionParserRuleCall_0ElementType());
              		
            }
            pushFollow(FOLLOW_61);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			doneComposite();
              		
            }
            // PsiInternalBeeLangTestLanguage.g:3894:3: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==35) ) {
                    int LA72_2 = input.LA(2);

                    if ( (synpred105_PsiInternalBeeLangTestLanguage()) ) {
                        alt72=1;
                    }


                }


                switch (alt72) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:3895:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:3895:4: ()
            	    // PsiInternalBeeLangTestLanguage.g:3896:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					/* */
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					precedeComposite(elementTypeProvider.getCallExpression_CallFunctionFuncExprAction_1_0ElementType());
            	      					doneComposite();
            	      					associateWithSemanticElement();
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getCallExpression_LeftParenthesisKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:3912:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
            	    int alt71=2;
            	    int LA71_0 = input.LA(1);

            	    if ( (LA71_0==RULE_ID||LA71_0==RULE_STRING||LA71_0==13||(LA71_0>=17 && LA71_0<=18)||LA71_0==21||(LA71_0>=35 && LA71_0<=36)||LA71_0==52||LA71_0==56||LA71_0==60||(LA71_0>=64 && LA71_0<=66)||LA71_0==70||(LA71_0>=72 && LA71_0<=77)) ) {
            	        alt71=1;
            	    }
            	    switch (alt71) {
            	        case 1 :
            	            // PsiInternalBeeLangTestLanguage.g:3913:5: (lv_parameterList_3_0= ruleParameterList )
            	            {
            	            // PsiInternalBeeLangTestLanguage.g:3913:5: (lv_parameterList_3_0= ruleParameterList )
            	            // PsiInternalBeeLangTestLanguage.g:3914:6: lv_parameterList_3_0= ruleParameterList
            	            {
            	            if ( state.backtracking==0 ) {

            	              						markComposite(elementTypeProvider.getCallExpression_ParameterListParameterListParserRuleCall_1_2_0ElementType());
            	              					
            	            }
            	            pushFollow(FOLLOW_37);
            	            lv_parameterList_3_0=ruleParameterList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						doneComposite();
            	              						if(!current) {
            	              							associateWithSemanticElement();
            	              							current = true;
            	              						}
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getCallExpression_RightParenthesisKeyword_1_3ElementType());
            	      			
            	    }
            	    otherlv_4=(Token)match(input,37,FOLLOW_61); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_4);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 72, ruleCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleCallExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // PsiInternalBeeLangTestLanguage.g:3939:1: entryRulePrimaryExpression returns [Boolean current=false] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final Boolean entryRulePrimaryExpression() throws RecognitionException {
        Boolean current = false;
        int entryRulePrimaryExpression_StartIndex = input.index();
        Boolean iv_rulePrimaryExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3939:59: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:3940:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getPrimaryExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 73, entryRulePrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // PsiInternalBeeLangTestLanguage.g:3946:1: rulePrimaryExpression returns [Boolean current=false] : (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) ;
    public final Boolean rulePrimaryExpression() throws RecognitionException {
        Boolean current = false;
        int rulePrimaryExpression_StartIndex = input.index();
        Boolean this_FeatureCall_0 = null;

        Boolean this_ConstructorCallExpression_1 = null;

        Boolean this_Value_2 = null;

        Boolean this_Literal_3 = null;

        Boolean this_KeywordVariables_4 = null;

        Boolean this_ParanthesizedExpression_5 = null;

        Boolean this_BlockExpression_6 = null;

        Boolean this_WithExpression_7 = null;

        Boolean this_WithContextExpression_8 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:3947:1: ( (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression ) )
            // PsiInternalBeeLangTestLanguage.g:3948:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:3948:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )
            int alt73=9;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:3949:3: this_FeatureCall_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_FeatureCallParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCall_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCall_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:3961:3: this_ConstructorCallExpression_1= ruleConstructorCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ConstructorCallExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConstructorCallExpression_1=ruleConstructorCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConstructorCallExpression_1;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:3973:3: this_Value_2= ruleValue
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ValueParserRuleCall_2ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Value_2=ruleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Value_2;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:3985:3: this_Literal_3= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_LiteralParserRuleCall_3ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_3=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_3;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:3997:3: this_KeywordVariables_4= ruleKeywordVariables
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_KeywordVariablesParserRuleCall_4ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_KeywordVariables_4=ruleKeywordVariables();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_KeywordVariables_4;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:4009:3: this_ParanthesizedExpression_5= ruleParanthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_ParanthesizedExpressionParserRuleCall_5ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParanthesizedExpression_5=ruleParanthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParanthesizedExpression_5;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalBeeLangTestLanguage.g:4021:3: this_BlockExpression_6= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_BlockExpressionParserRuleCall_6ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BlockExpression_6=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpression_6;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 8 :
                    // PsiInternalBeeLangTestLanguage.g:4033:3: this_WithExpression_7= ruleWithExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_WithExpressionParserRuleCall_7ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_WithExpression_7=ruleWithExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithExpression_7;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 9 :
                    // PsiInternalBeeLangTestLanguage.g:4045:3: this_WithContextExpression_8= ruleWithContextExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getPrimaryExpression_WithContextExpressionParserRuleCall_8ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_WithContextExpression_8=ruleWithContextExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_WithContextExpression_8;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 74, rulePrimaryExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleWithExpression"
    // PsiInternalBeeLangTestLanguage.g:4060:1: entryRuleWithExpression returns [Boolean current=false] : iv_ruleWithExpression= ruleWithExpression EOF ;
    public final Boolean entryRuleWithExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleWithExpression_StartIndex = input.index();
        Boolean iv_ruleWithExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4060:56: (iv_ruleWithExpression= ruleWithExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4061:2: iv_ruleWithExpression= ruleWithExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getWithExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWithExpression=ruleWithExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWithExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 75, entryRuleWithExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithExpression"


    // $ANTLR start "ruleWithExpression"
    // PsiInternalBeeLangTestLanguage.g:4067:1: ruleWithExpression returns [Boolean current=false] : (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) ;
    public final Boolean ruleWithExpression() throws RecognitionException {
        Boolean current = false;
        int ruleWithExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token lv_referencedAdvice_1_0=null;
        Token otherlv_2=null;
        Token lv_referencedAdvice_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Boolean lv_funcExpr_5_0 = null;

        Boolean lv_funcExpr_7_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4068:1: ( (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4069:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4069:2: (otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) ) )
            // PsiInternalBeeLangTestLanguage.g:4070:3: otherlv_0= 'with' ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )? ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithExpression_WithKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,70,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4077:3: ( ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4078:4: ( (lv_referencedAdvice_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    {
                    // PsiInternalBeeLangTestLanguage.g:4078:4: ( (lv_referencedAdvice_1_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:4079:5: (lv_referencedAdvice_1_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4079:5: (lv_referencedAdvice_1_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:4080:6: lv_referencedAdvice_1_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getWithExpression_ReferencedAdviceIDTerminalRuleCall_1_0_0ElementType());
                      					
                    }
                    lv_referencedAdvice_1_0=(Token)match(input,RULE_ID,FOLLOW_63); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_referencedAdvice_1_0);
                      					
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:4095:4: (otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==16) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:4096:5: otherlv_2= ',' ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      					markLeaf(elementTypeProvider.getWithExpression_CommaKeyword_1_1_0ElementType());
                    	      				
                    	    }
                    	    otherlv_2=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					doneLeaf(otherlv_2);
                    	      				
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:4103:5: ( (lv_referencedAdvice_3_0= RULE_ID ) )
                    	    // PsiInternalBeeLangTestLanguage.g:4104:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:4104:6: (lv_referencedAdvice_3_0= RULE_ID )
                    	    // PsiInternalBeeLangTestLanguage.g:4105:7: lv_referencedAdvice_3_0= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getWithExpression_ReferencedAdviceIDTerminalRuleCall_1_1_1_0ElementType());
                    	      						
                    	    }
                    	    lv_referencedAdvice_3_0=(Token)match(input,RULE_ID,FOLLOW_63); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if(!current) {
                    	      								associateWithSemanticElement();
                    	      								current = true;
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(lv_referencedAdvice_3_0);
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop74;
                        }
                    } while (true);


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:4122:3: ( (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) ) | (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==19) ) {
                alt76=1;
            }
            else if ( (LA76_0==17) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4123:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4123:4: (otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) ) )
                    // PsiInternalBeeLangTestLanguage.g:4124:5: otherlv_4= ':' ( (lv_funcExpr_5_0= ruleExpression ) )
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_ColonKeyword_2_0_0ElementType());
                      				
                    }
                    otherlv_4=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_4);
                      				
                    }
                    // PsiInternalBeeLangTestLanguage.g:4131:5: ( (lv_funcExpr_5_0= ruleExpression ) )
                    // PsiInternalBeeLangTestLanguage.g:4132:6: (lv_funcExpr_5_0= ruleExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4132:6: (lv_funcExpr_5_0= ruleExpression )
                    // PsiInternalBeeLangTestLanguage.g:4133:7: lv_funcExpr_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getWithExpression_FuncExprExpressionParserRuleCall_2_0_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_funcExpr_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:4148:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4148:4: (otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}' )
                    // PsiInternalBeeLangTestLanguage.g:4149:5: otherlv_6= '{' ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) ) otherlv_8= '}'
                    {
                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_LeftCurlyBracketKeyword_2_1_0ElementType());
                      				
                    }
                    otherlv_6=(Token)match(input,17,FOLLOW_64); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_6);
                      				
                    }
                    // PsiInternalBeeLangTestLanguage.g:4156:5: ( (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets ) )
                    // PsiInternalBeeLangTestLanguage.g:4157:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4157:6: (lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets )
                    // PsiInternalBeeLangTestLanguage.g:4158:7: lv_funcExpr_7_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getWithExpression_FuncExprBlockExpressionWithoutBracketsParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_65);
                    lv_funcExpr_7_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      					markLeaf(elementTypeProvider.getWithExpression_RightCurlyBracketKeyword_2_1_2ElementType());
                      				
                    }
                    otherlv_8=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneLeaf(otherlv_8);
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 76, ruleWithExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleWithExpression"


    // $ANTLR start "entryRuleWithContextExpression"
    // PsiInternalBeeLangTestLanguage.g:4184:1: entryRuleWithContextExpression returns [Boolean current=false] : iv_ruleWithContextExpression= ruleWithContextExpression EOF ;
    public final Boolean entryRuleWithContextExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleWithContextExpression_StartIndex = input.index();
        Boolean iv_ruleWithContextExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4184:63: (iv_ruleWithContextExpression= ruleWithContextExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4185:2: iv_ruleWithContextExpression= ruleWithContextExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getWithContextExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWithContextExpression=ruleWithContextExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWithContextExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 77, entryRuleWithContextExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleWithContextExpression"


    // $ANTLR start "ruleWithContextExpression"
    // PsiInternalBeeLangTestLanguage.g:4191:1: ruleWithContextExpression returns [Boolean current=false] : (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) ;
    public final Boolean ruleWithContextExpression() throws RecognitionException {
        Boolean current = false;
        int ruleWithContextExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;
        Boolean lv_expr_2_0 = null;

        Boolean lv_contextBlock_5_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4192:1: ( (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4193:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4193:2: (otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:4194:3: otherlv_0= 'with' otherlv_1= 'context' ( (lv_expr_2_0= ruleExpression ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )? ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithContextExpression_WithKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,70,FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getWithContextExpression_ContextKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,71,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4208:3: ( (lv_expr_2_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:4209:4: (lv_expr_2_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:4209:4: (lv_expr_2_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:4210:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getWithContextExpression_ExprExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_21);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:4223:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==28) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4224:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getWithContextExpression_AsKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:4231:4: ( (lv_alias_4_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:4232:5: (lv_alias_4_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4232:5: (lv_alias_4_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:4233:6: lv_alias_4_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getWithContextExpression_AliasIDTerminalRuleCall_3_1_0ElementType());
                      					
                    }
                    lv_alias_4_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_4_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:4249:3: ( (lv_contextBlock_5_0= ruleBlockExpression ) )
            // PsiInternalBeeLangTestLanguage.g:4250:4: (lv_contextBlock_5_0= ruleBlockExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:4250:4: (lv_contextBlock_5_0= ruleBlockExpression )
            // PsiInternalBeeLangTestLanguage.g:4251:5: lv_contextBlock_5_0= ruleBlockExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getWithContextExpression_ContextBlockBlockExpressionParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_contextBlock_5_0=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 78, ruleWithContextExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleWithContextExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:4268:1: entryRuleBlockExpression returns [Boolean current=false] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final Boolean entryRuleBlockExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleBlockExpression_StartIndex = input.index();
        Boolean iv_ruleBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4268:57: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4269:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBlockExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockExpression=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 79, entryRuleBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:4275:1: ruleBlockExpression returns [Boolean current=false] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final Boolean ruleBlockExpression() throws RecognitionException {
        Boolean current = false;
        int ruleBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_expressions_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4276:1: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:4277:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:4277:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // PsiInternalBeeLangTestLanguage.g:4278:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            // PsiInternalBeeLangTestLanguage.g:4278:3: ()
            // PsiInternalBeeLangTestLanguage.g:4279:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBlockExpression_ChainedExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,17,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4295:3: ( ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';' )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID||LA78_0==RULE_STRING||LA78_0==13||(LA78_0>=17 && LA78_0<=18)||LA78_0==21||LA78_0==33||LA78_0==35||(LA78_0>=53 && LA78_0<=54)||LA78_0==56||LA78_0==60||(LA78_0>=64 && LA78_0<=66)||LA78_0==70||(LA78_0>=72 && LA78_0<=76)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:4296:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) ) otherlv_3= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:4296:4: ( (lv_expressions_2_0= ruleTopLevelExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:4297:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:4297:5: (lv_expressions_2_0= ruleTopLevelExpression )
            	    // PsiInternalBeeLangTestLanguage.g:4298:6: lv_expressions_2_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getBlockExpression_ExpressionsTopLevelExpressionParserRuleCall_2_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_expressions_2_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getBlockExpression_SemicolonKeyword_2_1ElementType());
            	      			
            	    }
            	    otherlv_3=(Token)match(input,20,FOLLOW_67); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_3);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getBlockExpression_RightCurlyBracketKeyword_3ElementType());
              		
            }
            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 80, ruleBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleValue"
    // PsiInternalBeeLangTestLanguage.g:4330:1: entryRuleValue returns [Boolean current=false] : iv_ruleValue= ruleValue EOF ;
    public final Boolean entryRuleValue() throws RecognitionException {
        Boolean current = false;
        int entryRuleValue_StartIndex = input.index();
        Boolean iv_ruleValue = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4330:47: (iv_ruleValue= ruleValue EOF )
            // PsiInternalBeeLangTestLanguage.g:4331:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValueElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 81, entryRuleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // PsiInternalBeeLangTestLanguage.g:4337:1: ruleValue returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleValue() throws RecognitionException {
        Boolean current = false;
        int ruleValue_StartIndex = input.index();
        Token lv_name_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4338:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4339:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4339:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:4340:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4340:3: ()
            // PsiInternalBeeLangTestLanguage.g:4341:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getValue_VariableExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4350:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:4351:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:4351:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:4352:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getValue_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 82, ruleValue_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleKeywordVariables"
    // PsiInternalBeeLangTestLanguage.g:4371:1: entryRuleKeywordVariables returns [Boolean current=false] : iv_ruleKeywordVariables= ruleKeywordVariables EOF ;
    public final Boolean entryRuleKeywordVariables() throws RecognitionException {
        Boolean current = false;
        int entryRuleKeywordVariables_StartIndex = input.index();
        Boolean iv_ruleKeywordVariables = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4371:58: (iv_ruleKeywordVariables= ruleKeywordVariables EOF )
            // PsiInternalBeeLangTestLanguage.g:4372:2: iv_ruleKeywordVariables= ruleKeywordVariables EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getKeywordVariablesElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKeywordVariables=ruleKeywordVariables();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeywordVariables; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 83, entryRuleKeywordVariables_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleKeywordVariables"


    // $ANTLR start "ruleKeywordVariables"
    // PsiInternalBeeLangTestLanguage.g:4378:1: ruleKeywordVariables returns [Boolean current=false] : ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) ;
    public final Boolean ruleKeywordVariables() throws RecognitionException {
        Boolean current = false;
        int ruleKeywordVariables_StartIndex = input.index();
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4379:1: ( ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4380:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4380:2: ( () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4381:3: () ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4381:3: ()
            // PsiInternalBeeLangTestLanguage.g:4382:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getKeywordVariables_VariableExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4391:3: ( ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) ) )
            // PsiInternalBeeLangTestLanguage.g:4392:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4392:4: ( (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' ) )
            // PsiInternalBeeLangTestLanguage.g:4393:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            {
            // PsiInternalBeeLangTestLanguage.g:4393:5: (lv_name_1_1= 'input' | lv_name_1_2= 'output' | lv_name_1_3= 'source' | lv_name_1_4= 'properties' | lv_name_1_5= 'builder' | lv_name_1_6= 'unit' | lv_name_1_7= 'this' )
            int alt79=7;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt79=1;
                }
                break;
            case 21:
                {
                alt79=2;
                }
                break;
            case 18:
                {
                alt79=3;
                }
                break;
            case 73:
                {
                alt79=4;
                }
                break;
            case 74:
                {
                alt79=5;
                }
                break;
            case 13:
                {
                alt79=6;
                }
                break;
            case 75:
                {
                alt79=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4394:6: lv_name_1_1= 'input'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameInputKeyword_1_0_0ElementType());
                      					
                    }
                    lv_name_1_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_1);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:4408:6: lv_name_1_2= 'output'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameOutputKeyword_1_0_1ElementType());
                      					
                    }
                    lv_name_1_2=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_2);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 3 :
                    // PsiInternalBeeLangTestLanguage.g:4422:6: lv_name_1_3= 'source'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameSourceKeyword_1_0_2ElementType());
                      					
                    }
                    lv_name_1_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_3);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 4 :
                    // PsiInternalBeeLangTestLanguage.g:4436:6: lv_name_1_4= 'properties'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NamePropertiesKeyword_1_0_3ElementType());
                      					
                    }
                    lv_name_1_4=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_4);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 5 :
                    // PsiInternalBeeLangTestLanguage.g:4450:6: lv_name_1_5= 'builder'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameBuilderKeyword_1_0_4ElementType());
                      					
                    }
                    lv_name_1_5=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_5);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 6 :
                    // PsiInternalBeeLangTestLanguage.g:4464:6: lv_name_1_6= 'unit'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameUnitKeyword_1_0_5ElementType());
                      					
                    }
                    lv_name_1_6=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_6);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;
                case 7 :
                    // PsiInternalBeeLangTestLanguage.g:4478:6: lv_name_1_7= 'this'
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getKeywordVariables_NameThisKeyword_1_0_6ElementType());
                      					
                    }
                    lv_name_1_7=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_name_1_7);
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }
                    break;

            }


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
            if ( state.backtracking>0 ) { memoize(input, 84, ruleKeywordVariables_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleKeywordVariables"


    // $ANTLR start "entryRuleFeatureCall"
    // PsiInternalBeeLangTestLanguage.g:4498:1: entryRuleFeatureCall returns [Boolean current=false] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final Boolean entryRuleFeatureCall() throws RecognitionException {
        Boolean current = false;
        int entryRuleFeatureCall_StartIndex = input.index();
        Boolean iv_ruleFeatureCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4498:53: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // PsiInternalBeeLangTestLanguage.g:4499:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 85, entryRuleFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // PsiInternalBeeLangTestLanguage.g:4505:1: ruleFeatureCall returns [Boolean current=false] : this_OperationCall_0= ruleOperationCall ;
    public final Boolean ruleFeatureCall() throws RecognitionException {
        Boolean current = false;
        int ruleFeatureCall_StartIndex = input.index();
        Boolean this_OperationCall_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4506:1: (this_OperationCall_0= ruleOperationCall )
            // PsiInternalBeeLangTestLanguage.g:4507:2: this_OperationCall_0= ruleOperationCall
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		markComposite(elementTypeProvider.getFeatureCall_OperationCallParserRuleCallElementType());
              	
            }
            pushFollow(FOLLOW_2);
            this_OperationCall_0=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OperationCall_0;
              		doneComposite();
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 86, ruleFeatureCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleOperationCall"
    // PsiInternalBeeLangTestLanguage.g:4521:1: entryRuleOperationCall returns [Boolean current=false] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final Boolean entryRuleOperationCall() throws RecognitionException {
        Boolean current = false;
        int entryRuleOperationCall_StartIndex = input.index();
        Boolean iv_ruleOperationCall = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4521:55: (iv_ruleOperationCall= ruleOperationCall EOF )
            // PsiInternalBeeLangTestLanguage.g:4522:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOperationCallElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperationCall=ruleOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 87, entryRuleOperationCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // PsiInternalBeeLangTestLanguage.g:4528:1: ruleOperationCall returns [Boolean current=false] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) ;
    public final Boolean ruleOperationCall() throws RecognitionException {
        Boolean current = false;
        int ruleOperationCall_StartIndex = input.index();
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_parameterList_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4529:1: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' ) )
            // PsiInternalBeeLangTestLanguage.g:4530:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            {
            // PsiInternalBeeLangTestLanguage.g:4530:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
            // PsiInternalBeeLangTestLanguage.g:4531:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
            {
            // PsiInternalBeeLangTestLanguage.g:4531:3: ()
            // PsiInternalBeeLangTestLanguage.g:4532:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getOperationCall_CallNamedFunctionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4541:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:4542:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:4542:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:4543:5: lv_name_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getOperationCall_NameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_name_1_0);
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperationCall_LeftParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4565:3: ( (lv_parameterList_3_0= ruleParameterList ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||LA80_0==RULE_STRING||LA80_0==13||(LA80_0>=17 && LA80_0<=18)||LA80_0==21||(LA80_0>=35 && LA80_0<=36)||LA80_0==52||LA80_0==56||LA80_0==60||(LA80_0>=64 && LA80_0<=66)||LA80_0==70||(LA80_0>=72 && LA80_0<=77)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4566:4: (lv_parameterList_3_0= ruleParameterList )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4566:4: (lv_parameterList_3_0= ruleParameterList )
                    // PsiInternalBeeLangTestLanguage.g:4567:5: lv_parameterList_3_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getOperationCall_ParameterListParameterListParserRuleCall_3_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_37);
                    lv_parameterList_3_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getOperationCall_RightParenthesisKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 88, ruleOperationCall_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleConstructorCallExpression"
    // PsiInternalBeeLangTestLanguage.g:4591:1: entryRuleConstructorCallExpression returns [Boolean current=false] : iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF ;
    public final Boolean entryRuleConstructorCallExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleConstructorCallExpression_StartIndex = input.index();
        Boolean iv_ruleConstructorCallExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4591:67: (iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4592:2: iv_ruleConstructorCallExpression= ruleConstructorCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getConstructorCallExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstructorCallExpression=ruleConstructorCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorCallExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 89, entryRuleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleConstructorCallExpression"


    // $ANTLR start "ruleConstructorCallExpression"
    // PsiInternalBeeLangTestLanguage.g:4598:1: ruleConstructorCallExpression returns [Boolean current=false] : ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) ;
    public final Boolean ruleConstructorCallExpression() throws RecognitionException {
        Boolean current = false;
        int ruleConstructorCallExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token lv_typeExpr_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_alias_7_0=null;
        Boolean lv_parameterList_4_0 = null;

        Boolean lv_contextBlock_8_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4599:1: ( ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? ) )
            // PsiInternalBeeLangTestLanguage.g:4600:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            {
            // PsiInternalBeeLangTestLanguage.g:4600:2: ( () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )? )
            // PsiInternalBeeLangTestLanguage.g:4601:3: () otherlv_1= 'new' ( (lv_typeExpr_2_0= RULE_ID ) ) (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )? (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )? ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            {
            // PsiInternalBeeLangTestLanguage.g:4601:3: ()
            // PsiInternalBeeLangTestLanguage.g:4602:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getConstructorCallExpression_CreateExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getConstructorCallExpression_NewKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,76,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4618:3: ( (lv_typeExpr_2_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:4619:4: (lv_typeExpr_2_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:4619:4: (lv_typeExpr_2_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:4620:5: lv_typeExpr_2_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getConstructorCallExpression_TypeExprIDTerminalRuleCall_2_0ElementType());
              				
            }
            lv_typeExpr_2_0=(Token)match(input,RULE_ID,FOLLOW_68); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_typeExpr_2_0);
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:4635:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4636:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,35,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:4643:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID||LA81_0==RULE_STRING||LA81_0==13||(LA81_0>=17 && LA81_0<=18)||LA81_0==21||(LA81_0>=35 && LA81_0<=36)||LA81_0==52||LA81_0==56||LA81_0==60||(LA81_0>=64 && LA81_0<=66)||LA81_0==70||(LA81_0>=72 && LA81_0<=77)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:4644:5: (lv_parameterList_4_0= ruleParameterList )
                            {
                            // PsiInternalBeeLangTestLanguage.g:4644:5: (lv_parameterList_4_0= ruleParameterList )
                            // PsiInternalBeeLangTestLanguage.g:4645:6: lv_parameterList_4_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {

                              						markComposite(elementTypeProvider.getConstructorCallExpression_ParameterListParameterListParserRuleCall_3_1_0ElementType());
                              					
                            }
                            pushFollow(FOLLOW_37);
                            lv_parameterList_4_0=ruleParameterList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						doneComposite();
                              						if(!current) {
                              							associateWithSemanticElement();
                              							current = true;
                              						}
                              					
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_RightParenthesisKeyword_3_2ElementType());
                      			
                    }
                    otherlv_5=(Token)match(input,37,FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_5);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:4666:3: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==28) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_ID) ) {
                    int LA83_3 = input.LA(3);

                    if ( (synpred128_PsiInternalBeeLangTestLanguage()) ) {
                        alt83=1;
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4667:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
                      			
                    }
                    otherlv_6=(Token)match(input,28,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_6);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:4674:4: ( (lv_alias_7_0= RULE_ID ) )
                    // PsiInternalBeeLangTestLanguage.g:4675:5: (lv_alias_7_0= RULE_ID )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4675:5: (lv_alias_7_0= RULE_ID )
                    // PsiInternalBeeLangTestLanguage.g:4676:6: lv_alias_7_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						markLeaf(elementTypeProvider.getConstructorCallExpression_AliasIDTerminalRuleCall_4_1_0ElementType());
                      					
                    }
                    lv_alias_7_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						doneLeaf(lv_alias_7_0);
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:4692:3: ( (lv_contextBlock_8_0= ruleInitializationBlockExpression ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==17) ) {
                int LA84_1 = input.LA(2);

                if ( (LA84_1==RULE_ID) ) {
                    int LA84_3 = input.LA(3);

                    if ( (LA84_3==19) ) {
                        alt84=1;
                    }
                }
            }
            switch (alt84) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4693:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4693:4: (lv_contextBlock_8_0= ruleInitializationBlockExpression )
                    // PsiInternalBeeLangTestLanguage.g:4694:5: lv_contextBlock_8_0= ruleInitializationBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      					markComposite(elementTypeProvider.getConstructorCallExpression_ContextBlockInitializationBlockExpressionParserRuleCall_5_0ElementType());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_contextBlock_8_0=ruleInitializationBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					doneComposite();
                      					if(!current) {
                      						associateWithSemanticElement();
                      						current = true;
                      					}
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 90, ruleConstructorCallExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleConstructorCallExpression"


    // $ANTLR start "entryRuleInitializationBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:4711:1: entryRuleInitializationBlockExpression returns [Boolean current=false] : iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF ;
    public final Boolean entryRuleInitializationBlockExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleInitializationBlockExpression_StartIndex = input.index();
        Boolean iv_ruleInitializationBlockExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4711:71: (iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4712:2: iv_ruleInitializationBlockExpression= ruleInitializationBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInitializationBlockExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInitializationBlockExpression=ruleInitializationBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitializationBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 91, entryRuleInitializationBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationBlockExpression"


    // $ANTLR start "ruleInitializationBlockExpression"
    // PsiInternalBeeLangTestLanguage.g:4718:1: ruleInitializationBlockExpression returns [Boolean current=false] : ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) ;
    public final Boolean ruleInitializationBlockExpression() throws RecognitionException {
        Boolean current = false;
        int ruleInitializationBlockExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Boolean lv_expressions_2_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4719:1: ( ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:4720:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:4720:2: ( () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}' )
            // PsiInternalBeeLangTestLanguage.g:4721:3: () otherlv_1= '{' ( (lv_expressions_2_0= ruleInitializationExpression ) ) otherlv_3= ';' otherlv_4= '}'
            {
            // PsiInternalBeeLangTestLanguage.g:4721:3: ()
            // PsiInternalBeeLangTestLanguage.g:4722:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getInitializationBlockExpression_ChainedExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_LeftCurlyBracketKeyword_1ElementType());
              		
            }
            otherlv_1=(Token)match(input,17,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_1);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:4738:3: ( (lv_expressions_2_0= ruleInitializationExpression ) )
            // PsiInternalBeeLangTestLanguage.g:4739:4: (lv_expressions_2_0= ruleInitializationExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:4739:4: (lv_expressions_2_0= ruleInitializationExpression )
            // PsiInternalBeeLangTestLanguage.g:4740:5: lv_expressions_2_0= ruleInitializationExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationBlockExpression_ExpressionsInitializationExpressionParserRuleCall_2_0ElementType());
              				
            }
            pushFollow(FOLLOW_14);
            lv_expressions_2_0=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_SemicolonKeyword_3ElementType());
              		
            }
            otherlv_3=(Token)match(input,20,FOLLOW_65); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_3);
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getInitializationBlockExpression_RightCurlyBracketKeyword_4ElementType());
              		
            }
            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_4);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 92, ruleInitializationBlockExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInitializationBlockExpression"


    // $ANTLR start "entryRuleInitializationExpression"
    // PsiInternalBeeLangTestLanguage.g:4771:1: entryRuleInitializationExpression returns [Boolean current=false] : iv_ruleInitializationExpression= ruleInitializationExpression EOF ;
    public final Boolean entryRuleInitializationExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleInitializationExpression_StartIndex = input.index();
        Boolean iv_ruleInitializationExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4771:66: (iv_ruleInitializationExpression= ruleInitializationExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4772:2: iv_ruleInitializationExpression= ruleInitializationExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getInitializationExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInitializationExpression=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitializationExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 93, entryRuleInitializationExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationExpression"


    // $ANTLR start "ruleInitializationExpression"
    // PsiInternalBeeLangTestLanguage.g:4778:1: ruleInitializationExpression returns [Boolean current=false] : ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) ;
    public final Boolean ruleInitializationExpression() throws RecognitionException {
        Boolean current = false;
        int ruleInitializationExpression_StartIndex = input.index();
        Token lv_functionName_2_0=null;
        Boolean lv_leftExpr_1_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4779:1: ( ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4780:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4780:2: ( () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) ) )
            // PsiInternalBeeLangTestLanguage.g:4781:3: () ( (lv_leftExpr_1_0= ruleFeatureOfThis ) ) ( (lv_functionName_2_0= ':' ) ) ( (lv_rightExpr_3_0= ruleExpression ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4781:3: ()
            // PsiInternalBeeLangTestLanguage.g:4782:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getInitializationExpression_AssignmentExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4791:3: ( (lv_leftExpr_1_0= ruleFeatureOfThis ) )
            // PsiInternalBeeLangTestLanguage.g:4792:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            {
            // PsiInternalBeeLangTestLanguage.g:4792:4: (lv_leftExpr_1_0= ruleFeatureOfThis )
            // PsiInternalBeeLangTestLanguage.g:4793:5: lv_leftExpr_1_0= ruleFeatureOfThis
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationExpression_LeftExprFeatureOfThisParserRuleCall_1_0ElementType());
              				
            }
            pushFollow(FOLLOW_12);
            lv_leftExpr_1_0=ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:4806:3: ( (lv_functionName_2_0= ':' ) )
            // PsiInternalBeeLangTestLanguage.g:4807:4: (lv_functionName_2_0= ':' )
            {
            // PsiInternalBeeLangTestLanguage.g:4807:4: (lv_functionName_2_0= ':' )
            // PsiInternalBeeLangTestLanguage.g:4808:5: lv_functionName_2_0= ':'
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getInitializationExpression_FunctionNameColonKeyword_2_0ElementType());
              				
            }
            lv_functionName_2_0=(Token)match(input,19,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_functionName_2_0);
              				
            }
            if ( state.backtracking==0 ) {

              					if (!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

            }


            }

            // PsiInternalBeeLangTestLanguage.g:4823:3: ( (lv_rightExpr_3_0= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:4824:4: (lv_rightExpr_3_0= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:4824:4: (lv_rightExpr_3_0= ruleExpression )
            // PsiInternalBeeLangTestLanguage.g:4825:5: lv_rightExpr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getInitializationExpression_RightExprExpressionParserRuleCall_3_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_rightExpr_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 94, ruleInitializationExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleInitializationExpression"


    // $ANTLR start "entryRuleFeatureOfThis"
    // PsiInternalBeeLangTestLanguage.g:4842:1: entryRuleFeatureOfThis returns [Boolean current=false] : iv_ruleFeatureOfThis= ruleFeatureOfThis EOF ;
    public final Boolean entryRuleFeatureOfThis() throws RecognitionException {
        Boolean current = false;
        int entryRuleFeatureOfThis_StartIndex = input.index();
        Boolean iv_ruleFeatureOfThis = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4842:55: (iv_ruleFeatureOfThis= ruleFeatureOfThis EOF )
            // PsiInternalBeeLangTestLanguage.g:4843:2: iv_ruleFeatureOfThis= ruleFeatureOfThis EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getFeatureOfThisElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureOfThis=ruleFeatureOfThis();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureOfThis; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 95, entryRuleFeatureOfThis_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureOfThis"


    // $ANTLR start "ruleFeatureOfThis"
    // PsiInternalBeeLangTestLanguage.g:4849:1: ruleFeatureOfThis returns [Boolean current=false] : ( () ( (lv_featureName_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleFeatureOfThis() throws RecognitionException {
        Boolean current = false;
        int ruleFeatureOfThis_StartIndex = input.index();
        Token lv_featureName_1_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4850:1: ( ( () ( (lv_featureName_1_0= RULE_ID ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4851:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4851:2: ( () ( (lv_featureName_1_0= RULE_ID ) ) )
            // PsiInternalBeeLangTestLanguage.g:4852:3: () ( (lv_featureName_1_0= RULE_ID ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4852:3: ()
            // PsiInternalBeeLangTestLanguage.g:4853:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getFeatureOfThis_FeatureExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4862:3: ( (lv_featureName_1_0= RULE_ID ) )
            // PsiInternalBeeLangTestLanguage.g:4863:4: (lv_featureName_1_0= RULE_ID )
            {
            // PsiInternalBeeLangTestLanguage.g:4863:4: (lv_featureName_1_0= RULE_ID )
            // PsiInternalBeeLangTestLanguage.g:4864:5: lv_featureName_1_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					markLeaf(elementTypeProvider.getFeatureOfThis_FeatureNameIDTerminalRuleCall_1_0ElementType());
              				
            }
            lv_featureName_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					doneLeaf(lv_featureName_1_0);
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 96, ruleFeatureOfThis_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleFeatureOfThis"


    // $ANTLR start "entryRuleLiteral"
    // PsiInternalBeeLangTestLanguage.g:4883:1: entryRuleLiteral returns [Boolean current=false] : iv_ruleLiteral= ruleLiteral EOF ;
    public final Boolean entryRuleLiteral() throws RecognitionException {
        Boolean current = false;
        int entryRuleLiteral_StartIndex = input.index();
        Boolean iv_ruleLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4883:49: (iv_ruleLiteral= ruleLiteral EOF )
            // PsiInternalBeeLangTestLanguage.g:4884:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 97, entryRuleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // PsiInternalBeeLangTestLanguage.g:4890:1: ruleLiteral returns [Boolean current=false] : (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) ;
    public final Boolean ruleLiteral() throws RecognitionException {
        Boolean current = false;
        int ruleLiteral_StartIndex = input.index();
        Boolean this_ValueLiteral_0 = null;

        Boolean this_LiteralFunction_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4891:1: ( (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction ) )
            // PsiInternalBeeLangTestLanguage.g:4892:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            {
            // PsiInternalBeeLangTestLanguage.g:4892:2: (this_ValueLiteral_0= ruleValueLiteral | this_LiteralFunction_1= ruleLiteralFunction )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_STRING) ) {
                alt85=1;
            }
            else if ( (LA85_0==17) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4893:3: this_ValueLiteral_0= ruleValueLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_ValueLiteralParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValueLiteral_0=ruleValueLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ValueLiteral_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:4905:3: this_LiteralFunction_1= ruleLiteralFunction
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getLiteral_LiteralFunctionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralFunction_1=ruleLiteralFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralFunction_1;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 98, ruleLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleLiteralFunction"
    // PsiInternalBeeLangTestLanguage.g:4920:1: entryRuleLiteralFunction returns [Boolean current=false] : iv_ruleLiteralFunction= ruleLiteralFunction EOF ;
    public final Boolean entryRuleLiteralFunction() throws RecognitionException {
        Boolean current = false;
        int entryRuleLiteralFunction_StartIndex = input.index();
        Boolean iv_ruleLiteralFunction = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4920:57: (iv_ruleLiteralFunction= ruleLiteralFunction EOF )
            // PsiInternalBeeLangTestLanguage.g:4921:2: iv_ruleLiteralFunction= ruleLiteralFunction EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getLiteralFunctionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralFunction=ruleLiteralFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 99, entryRuleLiteralFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFunction"


    // $ANTLR start "ruleLiteralFunction"
    // PsiInternalBeeLangTestLanguage.g:4927:1: ruleLiteralFunction returns [Boolean current=false] : (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) ;
    public final Boolean ruleLiteralFunction() throws RecognitionException {
        Boolean current = false;
        int ruleLiteralFunction_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_ClosureExpression_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4928:1: ( (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' ) )
            // PsiInternalBeeLangTestLanguage.g:4929:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            {
            // PsiInternalBeeLangTestLanguage.g:4929:2: (otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}' )
            // PsiInternalBeeLangTestLanguage.g:4930:3: otherlv_0= '{' this_ClosureExpression_1= ruleClosureExpression otherlv_2= '}'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLiteralFunction_LeftCurlyBracketKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,17,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getLiteralFunction_ClosureExpressionParserRuleCall_1ElementType());
              		
            }
            pushFollow(FOLLOW_65);
            this_ClosureExpression_1=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ClosureExpression_1;
              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getLiteralFunction_RightCurlyBracketKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 100, ruleLiteralFunction_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleLiteralFunction"


    // $ANTLR start "entryRuleClosureExpression"
    // PsiInternalBeeLangTestLanguage.g:4959:1: entryRuleClosureExpression returns [Boolean current=false] : iv_ruleClosureExpression= ruleClosureExpression EOF ;
    public final Boolean entryRuleClosureExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleClosureExpression_StartIndex = input.index();
        Boolean iv_ruleClosureExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4959:59: (iv_ruleClosureExpression= ruleClosureExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:4960:2: iv_ruleClosureExpression= ruleClosureExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getClosureExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClosureExpression=ruleClosureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClosureExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 101, entryRuleClosureExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleClosureExpression"


    // $ANTLR start "ruleClosureExpression"
    // PsiInternalBeeLangTestLanguage.g:4966:1: ruleClosureExpression returns [Boolean current=false] : ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) ;
    public final Boolean ruleClosureExpression() throws RecognitionException {
        Boolean current = false;
        int ruleClosureExpression_StartIndex = input.index();
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        Token lv_varArgs_11_0=null;
        Token otherlv_13=null;
        Boolean lv_returnType_2_0 = null;

        Boolean lv_parameters_5_0 = null;

        Boolean lv_parameters_7_0 = null;

        Boolean lv_parameters_10_0 = null;

        Boolean lv_parameters_12_0 = null;

        Boolean lv_funcExpr_14_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:4967:1: ( ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) ) )
            // PsiInternalBeeLangTestLanguage.g:4968:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4968:2: ( () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) ) )
            // PsiInternalBeeLangTestLanguage.g:4969:3: () (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )? ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )? otherlv_13= '|' ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            {
            // PsiInternalBeeLangTestLanguage.g:4969:3: ()
            // PsiInternalBeeLangTestLanguage.g:4970:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getClosureExpression_FunctionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:4979:3: (otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==52) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:4980:4: otherlv_1= '<' ( (lv_returnType_2_0= ruleTypeRef ) ) otherlv_3= '>'
                    {
                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getClosureExpression_LessThanSignKeyword_1_0ElementType());
                      			
                    }
                    otherlv_1=(Token)match(input,52,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_1);
                      			
                    }
                    // PsiInternalBeeLangTestLanguage.g:4987:4: ( (lv_returnType_2_0= ruleTypeRef ) )
                    // PsiInternalBeeLangTestLanguage.g:4988:5: (lv_returnType_2_0= ruleTypeRef )
                    {
                    // PsiInternalBeeLangTestLanguage.g:4988:5: (lv_returnType_2_0= ruleTypeRef )
                    // PsiInternalBeeLangTestLanguage.g:4989:6: lv_returnType_2_0= ruleTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      						markComposite(elementTypeProvider.getClosureExpression_ReturnTypeTypeRefParserRuleCall_1_1_0ElementType());
                      					
                    }
                    pushFollow(FOLLOW_71);
                    lv_returnType_2_0=ruleTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						doneComposite();
                      						if(!current) {
                      							associateWithSemanticElement();
                      							current = true;
                      						}
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				markLeaf(elementTypeProvider.getClosureExpression_GreaterThanSignKeyword_1_2ElementType());
                      			
                    }
                    otherlv_3=(Token)match(input,51,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				doneLeaf(otherlv_3);
                      			
                    }

                    }
                    break;

            }

            // PsiInternalBeeLangTestLanguage.g:5010:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?
            int alt90=3;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:5011:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:5011:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
                    // PsiInternalBeeLangTestLanguage.g:5012:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    {
                    // PsiInternalBeeLangTestLanguage.g:5012:5: (otherlv_4= '|' )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==77) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:5013:6: otherlv_4= '|'
                            {
                            if ( state.backtracking==0 ) {

                              						markLeaf(elementTypeProvider.getClosureExpression_VerticalLineKeyword_2_0_0ElementType());
                              					
                            }
                            otherlv_4=(Token)match(input,77,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						doneLeaf(otherlv_4);
                              					
                            }

                            }
                            break;

                    }

                    // PsiInternalBeeLangTestLanguage.g:5021:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
                    // PsiInternalBeeLangTestLanguage.g:5022:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    {
                    // PsiInternalBeeLangTestLanguage.g:5022:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
                    // PsiInternalBeeLangTestLanguage.g:5023:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    {
                    // PsiInternalBeeLangTestLanguage.g:5023:7: (lv_parameters_5_0= ruleParameterDeclaration )
                    // PsiInternalBeeLangTestLanguage.g:5024:8: lv_parameters_5_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      								markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_0_0ElementType());
                      							
                    }
                    pushFollow(FOLLOW_73);
                    lv_parameters_5_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								doneComposite();
                      								if(!current) {
                      									associateWithSemanticElement();
                      									current = true;
                      								}
                      							
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:5037:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==16) ) {
                            int LA88_1 = input.LA(2);

                            if ( (LA88_1==RULE_ID||LA88_1==35) ) {
                                alt88=1;
                            }


                        }


                        switch (alt88) {
                    	case 1 :
                    	    // PsiInternalBeeLangTestLanguage.g:5038:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_1_0ElementType());
                    	      						
                    	    }
                    	    otherlv_6=(Token)match(input,16,FOLLOW_35); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							doneLeaf(otherlv_6);
                    	      						
                    	    }
                    	    // PsiInternalBeeLangTestLanguage.g:5045:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
                    	    // PsiInternalBeeLangTestLanguage.g:5046:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    {
                    	    // PsiInternalBeeLangTestLanguage.g:5046:8: (lv_parameters_7_0= ruleParameterDeclaration )
                    	    // PsiInternalBeeLangTestLanguage.g:5047:9: lv_parameters_7_0= ruleParameterDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0ElementType());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_73);
                    	    lv_parameters_7_0=ruleParameterDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									doneComposite();
                    	      									if(!current) {
                    	      										associateWithSemanticElement();
                    	      										current = true;
                    	      									}
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop88;
                        }
                    } while (true);

                    // PsiInternalBeeLangTestLanguage.g:5061:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==16) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // PsiInternalBeeLangTestLanguage.g:5062:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            {
                            if ( state.backtracking==0 ) {

                              							markLeaf(elementTypeProvider.getClosureExpression_CommaKeyword_2_0_1_2_0ElementType());
                              						
                            }
                            otherlv_8=(Token)match(input,16,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							doneLeaf(otherlv_8);
                              						
                            }
                            // PsiInternalBeeLangTestLanguage.g:5069:7: ( (lv_varArgs_9_0= '...' ) )
                            // PsiInternalBeeLangTestLanguage.g:5070:8: (lv_varArgs_9_0= '...' )
                            {
                            // PsiInternalBeeLangTestLanguage.g:5070:8: (lv_varArgs_9_0= '...' )
                            // PsiInternalBeeLangTestLanguage.g:5071:9: lv_varArgs_9_0= '...'
                            {
                            if ( state.backtracking==0 ) {

                              									markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0ElementType());
                              								
                            }
                            lv_varArgs_9_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneLeaf(lv_varArgs_9_0);
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									if (!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }

                            // PsiInternalBeeLangTestLanguage.g:5086:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                            // PsiInternalBeeLangTestLanguage.g:5087:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            {
                            // PsiInternalBeeLangTestLanguage.g:5087:8: (lv_parameters_10_0= ruleParameterDeclaration )
                            // PsiInternalBeeLangTestLanguage.g:5088:9: lv_parameters_10_0= ruleParameterDeclaration
                            {
                            if ( state.backtracking==0 ) {

                              									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0ElementType());
                              								
                            }
                            pushFollow(FOLLOW_74);
                            lv_parameters_10_0=ruleParameterDeclaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									doneComposite();
                              									if(!current) {
                              										associateWithSemanticElement();
                              										current = true;
                              									}
                              								
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:5105:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:5105:4: ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) )
                    // PsiInternalBeeLangTestLanguage.g:5106:5: ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    {
                    // PsiInternalBeeLangTestLanguage.g:5106:5: ( (lv_varArgs_11_0= '...' ) )
                    // PsiInternalBeeLangTestLanguage.g:5107:6: (lv_varArgs_11_0= '...' )
                    {
                    // PsiInternalBeeLangTestLanguage.g:5107:6: (lv_varArgs_11_0= '...' )
                    // PsiInternalBeeLangTestLanguage.g:5108:7: lv_varArgs_11_0= '...'
                    {
                    if ( state.backtracking==0 ) {

                      							markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_1_0_0ElementType());
                      						
                    }
                    lv_varArgs_11_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneLeaf(lv_varArgs_11_0);
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }

                    // PsiInternalBeeLangTestLanguage.g:5123:5: ( (lv_parameters_12_0= ruleParameterDeclaration ) )
                    // PsiInternalBeeLangTestLanguage.g:5124:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    {
                    // PsiInternalBeeLangTestLanguage.g:5124:6: (lv_parameters_12_0= ruleParameterDeclaration )
                    // PsiInternalBeeLangTestLanguage.g:5125:7: lv_parameters_12_0= ruleParameterDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      							markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_1_1_0ElementType());
                      						
                    }
                    pushFollow(FOLLOW_74);
                    lv_parameters_12_0=ruleParameterDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							doneComposite();
                      							if(!current) {
                      								associateWithSemanticElement();
                      								current = true;
                      							}
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getClosureExpression_VerticalLineKeyword_3ElementType());
              		
            }
            otherlv_13=(Token)match(input,77,FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_13);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:5147:3: ( (lv_funcExpr_14_0= ruleOneOrManyExpressions ) )
            // PsiInternalBeeLangTestLanguage.g:5148:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            {
            // PsiInternalBeeLangTestLanguage.g:5148:4: (lv_funcExpr_14_0= ruleOneOrManyExpressions )
            // PsiInternalBeeLangTestLanguage.g:5149:5: lv_funcExpr_14_0= ruleOneOrManyExpressions
            {
            if ( state.backtracking==0 ) {

              					markComposite(elementTypeProvider.getClosureExpression_FuncExprOneOrManyExpressionsParserRuleCall_4_0ElementType());
              				
            }
            pushFollow(FOLLOW_2);
            lv_funcExpr_14_0=ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					doneComposite();
              					if(!current) {
              						associateWithSemanticElement();
              						current = true;
              					}
              				
            }

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
            if ( state.backtracking>0 ) { memoize(input, 102, ruleClosureExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleClosureExpression"


    // $ANTLR start "entryRuleOneOrManyExpressions"
    // PsiInternalBeeLangTestLanguage.g:5166:1: entryRuleOneOrManyExpressions returns [Boolean current=false] : iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF ;
    public final Boolean entryRuleOneOrManyExpressions() throws RecognitionException {
        Boolean current = false;
        int entryRuleOneOrManyExpressions_StartIndex = input.index();
        Boolean iv_ruleOneOrManyExpressions = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5166:62: (iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF )
            // PsiInternalBeeLangTestLanguage.g:5167:2: iv_ruleOneOrManyExpressions= ruleOneOrManyExpressions EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getOneOrManyExpressionsElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOneOrManyExpressions=ruleOneOrManyExpressions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOneOrManyExpressions; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 103, entryRuleOneOrManyExpressions_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleOneOrManyExpressions"


    // $ANTLR start "ruleOneOrManyExpressions"
    // PsiInternalBeeLangTestLanguage.g:5173:1: ruleOneOrManyExpressions returns [Boolean current=false] : (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) ;
    public final Boolean ruleOneOrManyExpressions() throws RecognitionException {
        Boolean current = false;
        int ruleOneOrManyExpressions_StartIndex = input.index();
        Boolean this_BlockExpressionWithoutBrackets_0 = null;

        Boolean this_Expression_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5174:1: ( (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression ) )
            // PsiInternalBeeLangTestLanguage.g:5175:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            {
            // PsiInternalBeeLangTestLanguage.g:5175:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )
            int alt91=2;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // PsiInternalBeeLangTestLanguage.g:5176:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getOneOrManyExpressions_BlockExpressionWithoutBracketsParserRuleCall_0ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BlockExpressionWithoutBrackets_0=ruleBlockExpressionWithoutBrackets();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BlockExpressionWithoutBrackets_0;
                      			doneComposite();
                      		
                    }

                    }
                    break;
                case 2 :
                    // PsiInternalBeeLangTestLanguage.g:5188:3: this_Expression_1= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			markComposite(elementTypeProvider.getOneOrManyExpressions_ExpressionParserRuleCall_1ElementType());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Expression_1;
                      			doneComposite();
                      		
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
            if ( state.backtracking>0 ) { memoize(input, 104, ruleOneOrManyExpressions_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleOneOrManyExpressions"


    // $ANTLR start "entryRuleBlockExpressionWithoutBrackets"
    // PsiInternalBeeLangTestLanguage.g:5203:1: entryRuleBlockExpressionWithoutBrackets returns [Boolean current=false] : iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF ;
    public final Boolean entryRuleBlockExpressionWithoutBrackets() throws RecognitionException {
        Boolean current = false;
        int entryRuleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Boolean iv_ruleBlockExpressionWithoutBrackets = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5203:72: (iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF )
            // PsiInternalBeeLangTestLanguage.g:5204:2: iv_ruleBlockExpressionWithoutBrackets= ruleBlockExpressionWithoutBrackets EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getBlockExpressionWithoutBracketsElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockExpressionWithoutBrackets=ruleBlockExpressionWithoutBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpressionWithoutBrackets; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 105, entryRuleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpressionWithoutBrackets"


    // $ANTLR start "ruleBlockExpressionWithoutBrackets"
    // PsiInternalBeeLangTestLanguage.g:5210:1: ruleBlockExpressionWithoutBrackets returns [Boolean current=false] : ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) ;
    public final Boolean ruleBlockExpressionWithoutBrackets() throws RecognitionException {
        Boolean current = false;
        int ruleBlockExpressionWithoutBrackets_StartIndex = input.index();
        Token otherlv_2=null;
        Boolean lv_expressions_1_0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5211:1: ( ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ ) )
            // PsiInternalBeeLangTestLanguage.g:5212:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            {
            // PsiInternalBeeLangTestLanguage.g:5212:2: ( () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+ )
            // PsiInternalBeeLangTestLanguage.g:5213:3: () ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            {
            // PsiInternalBeeLangTestLanguage.g:5213:3: ()
            // PsiInternalBeeLangTestLanguage.g:5214:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				precedeComposite(elementTypeProvider.getBlockExpressionWithoutBrackets_ChainedExpressionAction_0ElementType());
              				doneComposite();
              				associateWithSemanticElement();
              			
            }

            }

            // PsiInternalBeeLangTestLanguage.g:5223:3: ( ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';' )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==RULE_ID||LA92_0==RULE_STRING||LA92_0==13||(LA92_0>=17 && LA92_0<=18)||LA92_0==21||LA92_0==33||LA92_0==35||(LA92_0>=53 && LA92_0<=54)||LA92_0==56||LA92_0==60||(LA92_0>=64 && LA92_0<=66)||LA92_0==70||(LA92_0>=72 && LA92_0<=76)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:5224:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) ) otherlv_2= ';'
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:5224:4: ( (lv_expressions_1_0= ruleTopLevelExpression ) )
            	    // PsiInternalBeeLangTestLanguage.g:5225:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    {
            	    // PsiInternalBeeLangTestLanguage.g:5225:5: (lv_expressions_1_0= ruleTopLevelExpression )
            	    // PsiInternalBeeLangTestLanguage.g:5226:6: lv_expressions_1_0= ruleTopLevelExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						markComposite(elementTypeProvider.getBlockExpressionWithoutBrackets_ExpressionsTopLevelExpressionParserRuleCall_1_0_0ElementType());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_expressions_1_0=ruleTopLevelExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						doneComposite();
            	      						if(!current) {
            	      							associateWithSemanticElement();
            	      							current = true;
            	      						}
            	      					
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getBlockExpressionWithoutBrackets_SemicolonKeyword_1_1ElementType());
            	      			
            	    }
            	    otherlv_2=(Token)match(input,20,FOLLOW_75); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(otherlv_2);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt92 >= 1 ) break loop92;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(92, input);
                        throw eee;
                }
                cnt92++;
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 106, ruleBlockExpressionWithoutBrackets_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpressionWithoutBrackets"


    // $ANTLR start "entryRuleValueLiteral"
    // PsiInternalBeeLangTestLanguage.g:5251:1: entryRuleValueLiteral returns [Boolean current=false] : iv_ruleValueLiteral= ruleValueLiteral EOF ;
    public final Boolean entryRuleValueLiteral() throws RecognitionException {
        Boolean current = false;
        int entryRuleValueLiteral_StartIndex = input.index();
        Boolean iv_ruleValueLiteral = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5251:54: (iv_ruleValueLiteral= ruleValueLiteral EOF )
            // PsiInternalBeeLangTestLanguage.g:5252:2: iv_ruleValueLiteral= ruleValueLiteral EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getValueLiteralElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValueLiteral=ruleValueLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 107, entryRuleValueLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleValueLiteral"


    // $ANTLR start "ruleValueLiteral"
    // PsiInternalBeeLangTestLanguage.g:5258:1: ruleValueLiteral returns [Boolean current=false] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final Boolean ruleValueLiteral() throws RecognitionException {
        Boolean current = false;
        int ruleValueLiteral_StartIndex = input.index();
        Token lv_value_0_0=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5259:1: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // PsiInternalBeeLangTestLanguage.g:5260:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // PsiInternalBeeLangTestLanguage.g:5260:2: ( (lv_value_0_0= RULE_STRING ) )
            // PsiInternalBeeLangTestLanguage.g:5261:3: (lv_value_0_0= RULE_STRING )
            {
            // PsiInternalBeeLangTestLanguage.g:5261:3: (lv_value_0_0= RULE_STRING )
            // PsiInternalBeeLangTestLanguage.g:5262:4: lv_value_0_0= RULE_STRING
            {
            if ( state.backtracking==0 ) {

              				markLeaf(elementTypeProvider.getValueLiteral_ValueSTRINGTerminalRuleCall_0ElementType());
              			
            }
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if(!current) {
              					associateWithSemanticElement();
              					current = true;
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				doneLeaf(lv_value_0_0);
              			
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
            if ( state.backtracking>0 ) { memoize(input, 108, ruleValueLiteral_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleValueLiteral"


    // $ANTLR start "entryRuleParanthesizedExpression"
    // PsiInternalBeeLangTestLanguage.g:5280:1: entryRuleParanthesizedExpression returns [Boolean current=false] : iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF ;
    public final Boolean entryRuleParanthesizedExpression() throws RecognitionException {
        Boolean current = false;
        int entryRuleParanthesizedExpression_StartIndex = input.index();
        Boolean iv_ruleParanthesizedExpression = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5280:65: (iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF )
            // PsiInternalBeeLangTestLanguage.g:5281:2: iv_ruleParanthesizedExpression= ruleParanthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getParanthesizedExpressionElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParanthesizedExpression=ruleParanthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParanthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 109, entryRuleParanthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "entryRuleParanthesizedExpression"


    // $ANTLR start "ruleParanthesizedExpression"
    // PsiInternalBeeLangTestLanguage.g:5287:1: ruleParanthesizedExpression returns [Boolean current=false] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final Boolean ruleParanthesizedExpression() throws RecognitionException {
        Boolean current = false;
        int ruleParanthesizedExpression_StartIndex = input.index();
        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean this_Expression_1 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5288:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // PsiInternalBeeLangTestLanguage.g:5289:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // PsiInternalBeeLangTestLanguage.g:5289:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // PsiInternalBeeLangTestLanguage.g:5290:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getParanthesizedExpression_LeftParenthesisKeyword_0ElementType());
              		
            }
            otherlv_0=(Token)match(input,35,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_0);
              		
            }
            if ( state.backtracking==0 ) {

              			/* */
              		
            }
            if ( state.backtracking==0 ) {

              			markComposite(elementTypeProvider.getParanthesizedExpression_ExpressionParserRuleCall_1ElementType());
              		
            }
            pushFollow(FOLLOW_37);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expression_1;
              			doneComposite();
              		
            }
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getParanthesizedExpression_RightParenthesisKeyword_2ElementType());
              		
            }
            otherlv_2=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(otherlv_2);
              		
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 110, ruleParanthesizedExpression_StartIndex); }
        }
        return current;
    }
    // $ANTLR end "ruleParanthesizedExpression"


    // $ANTLR start "entryRuleQID"
    // PsiInternalBeeLangTestLanguage.g:5319:1: entryRuleQID returns [Boolean current=false] : iv_ruleQID= ruleQID EOF ;
    public final Boolean entryRuleQID() throws RecognitionException {
        Boolean current = false;
        int entryRuleQID_StartIndex = input.index();
        Boolean iv_ruleQID = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 111) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5321:2: (iv_ruleQID= ruleQID EOF )
            // PsiInternalBeeLangTestLanguage.g:5322:2: iv_ruleQID= ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               markComposite(elementTypeProvider.getQIDElementType()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQID=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQID; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 111, entryRuleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // PsiInternalBeeLangTestLanguage.g:5331:1: ruleQID returns [Boolean current=false] : (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) ;
    public final Boolean ruleQID() throws RecognitionException {
        Boolean current = false;
        int ruleQID_StartIndex = input.index();
        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_HEX_2=null;
        Token this_ID_3=null;
        Token kw=null;
        Token this_ID_5=null;
        Token this_INT_6=null;
        Token this_HEX_7=null;
        Token this_ID_8=null;


        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 112) ) { return current; }
            // PsiInternalBeeLangTestLanguage.g:5334:2: ( (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* ) )
            // PsiInternalBeeLangTestLanguage.g:5335:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            {
            // PsiInternalBeeLangTestLanguage.g:5335:2: (this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )* )
            // PsiInternalBeeLangTestLanguage.g:5336:3: this_ID_0= RULE_ID (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )* (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            {
            if ( state.backtracking==0 ) {

              			markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_0ElementType());
              		
            }
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			doneLeaf(this_ID_0);
              		
            }
            // PsiInternalBeeLangTestLanguage.g:5343:3: (this_INT_1= RULE_INT | this_HEX_2= RULE_HEX | this_ID_3= RULE_ID )*
            loop93:
            do {
                int alt93=4;
                switch ( input.LA(1) ) {
                case RULE_INT:
                    {
                    alt93=1;
                    }
                    break;
                case RULE_HEX:
                    {
                    alt93=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt93=3;
                    }
                    break;

                }

                switch (alt93) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:5344:4: this_INT_1= RULE_INT
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_INTTerminalRuleCall_1_0ElementType());
            	      			
            	    }
            	    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_INT_1);
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBeeLangTestLanguage.g:5352:4: this_HEX_2= RULE_HEX
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_HEXTerminalRuleCall_1_1ElementType());
            	      			
            	    }
            	    this_HEX_2=(Token)match(input,RULE_HEX,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_HEX_2);
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBeeLangTestLanguage.g:5360:4: this_ID_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_1_2ElementType());
            	      			
            	    }
            	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_ID_3);
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            // PsiInternalBeeLangTestLanguage.g:5368:3: (kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )* )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==67) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // PsiInternalBeeLangTestLanguage.g:5369:4: kw= '.' this_ID_5= RULE_ID (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    {
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_FullStopKeyword_2_0ElementType());
            	      			
            	    }
            	    kw=(Token)match(input,67,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(kw);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_2_1ElementType());
            	      			
            	    }
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				doneLeaf(this_ID_5);
            	      			
            	    }
            	    // PsiInternalBeeLangTestLanguage.g:5383:4: (this_INT_6= RULE_INT | this_HEX_7= RULE_HEX | this_ID_8= RULE_ID )*
            	    loop94:
            	    do {
            	        int alt94=4;
            	        switch ( input.LA(1) ) {
            	        case RULE_INT:
            	            {
            	            alt94=1;
            	            }
            	            break;
            	        case RULE_HEX:
            	            {
            	            alt94=2;
            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            alt94=3;
            	            }
            	            break;

            	        }

            	        switch (alt94) {
            	    	case 1 :
            	    	    // PsiInternalBeeLangTestLanguage.g:5384:5: this_INT_6= RULE_INT
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_INTTerminalRuleCall_2_2_0ElementType());
            	    	      				
            	    	    }
            	    	    this_INT_6=(Token)match(input,RULE_INT,FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_INT_6);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // PsiInternalBeeLangTestLanguage.g:5392:5: this_HEX_7= RULE_HEX
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_HEXTerminalRuleCall_2_2_1ElementType());
            	    	      				
            	    	    }
            	    	    this_HEX_7=(Token)match(input,RULE_HEX,FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_HEX_7);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // PsiInternalBeeLangTestLanguage.g:5400:5: this_ID_8= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      					markLeaf(elementTypeProvider.getQID_IDTerminalRuleCall_2_2_2ElementType());
            	    	      				
            	    	    }
            	    	    this_ID_8=(Token)match(input,RULE_ID,FOLLOW_76); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					doneLeaf(this_ID_8);
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop94;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 112, ruleQID_StartIndex); }

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleQID"

    // $ANTLR start synpred2_PsiInternalBeeLangTestLanguage
    public final void synpred2_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_units_0_0 = null;


        // PsiInternalBeeLangTestLanguage.g:70:3: ( ( (lv_units_0_0= ruleUnit ) )* )
        // PsiInternalBeeLangTestLanguage.g:70:3: ( (lv_units_0_0= ruleUnit ) )*
        {
        // PsiInternalBeeLangTestLanguage.g:70:3: ( (lv_units_0_0= ruleUnit ) )*
        loop96:
        do {
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_DOCUMENTATION||LA96_0==13) ) {
                alt96=1;
            }


            switch (alt96) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:71:4: (lv_units_0_0= ruleUnit )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:71:4: (lv_units_0_0= ruleUnit )
        	    // PsiInternalBeeLangTestLanguage.g:72:5: lv_units_0_0= ruleUnit
        	    {
        	    if ( state.backtracking==0 ) {

        	      					markComposite(elementTypeProvider.getModel_UnitsUnitParserRuleCall_0_0ElementType());
        	      				
        	    }
        	    pushFollow(FOLLOW_3);
        	    lv_units_0_0=ruleUnit();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    break loop96;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred2_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred9_PsiInternalBeeLangTestLanguage
    public final void synpred9_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Boolean lv_sourceLocation_14_0 = null;


        // PsiInternalBeeLangTestLanguage.g:265:4: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:265:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:265:4: ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:266:5: {...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:266:101: ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:267:6: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0);
        // PsiInternalBeeLangTestLanguage.g:270:9: ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:270:10: {...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred9_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:270:19: (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' )
        // PsiInternalBeeLangTestLanguage.g:270:20: otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_SourceKeyword_7_0_0ElementType());
          								
        }
        otherlv_12=(Token)match(input,18,FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FOLLOW_13); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:284:9: ( (lv_sourceLocation_14_0= rulePath ) )
        // PsiInternalBeeLangTestLanguage.g:285:10: (lv_sourceLocation_14_0= rulePath )
        {
        // PsiInternalBeeLangTestLanguage.g:285:10: (lv_sourceLocation_14_0= rulePath )
        // PsiInternalBeeLangTestLanguage.g:286:11: lv_sourceLocation_14_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_SourceLocationPathParserRuleCall_7_0_2_0ElementType());
          										
        }
        pushFollow(FOLLOW_14);
        lv_sourceLocation_14_0=rulePath();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_15=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred9_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred10_PsiInternalBeeLangTestLanguage
    public final void synpred10_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Boolean lv_outputLocation_18_0 = null;


        // PsiInternalBeeLangTestLanguage.g:312:4: ( ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:312:4: ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:313:5: {...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:313:101: ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:314:6: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1);
        // PsiInternalBeeLangTestLanguage.g:317:9: ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:317:10: {...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred10_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:317:19: (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' )
        // PsiInternalBeeLangTestLanguage.g:317:20: otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_OutputKeyword_7_1_0ElementType());
          								
        }
        otherlv_16=(Token)match(input,21,FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FOLLOW_13); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:331:9: ( (lv_outputLocation_18_0= rulePath ) )
        // PsiInternalBeeLangTestLanguage.g:332:10: (lv_outputLocation_18_0= rulePath )
        {
        // PsiInternalBeeLangTestLanguage.g:332:10: (lv_outputLocation_18_0= rulePath )
        // PsiInternalBeeLangTestLanguage.g:333:11: lv_outputLocation_18_0= rulePath
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_OutputLocationPathParserRuleCall_7_1_2_0ElementType());
          										
        }
        pushFollow(FOLLOW_14);
        lv_outputLocation_18_0=rulePath();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_19=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred10_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred11_PsiInternalBeeLangTestLanguage
    public final void synpred11_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Boolean lv_providedCapabilities_22_0 = null;


        // PsiInternalBeeLangTestLanguage.g:364:10: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:364:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred11_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:364:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        // PsiInternalBeeLangTestLanguage.g:364:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
          								
        }
        otherlv_20=(Token)match(input,22,FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:378:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        // PsiInternalBeeLangTestLanguage.g:379:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        {
        // PsiInternalBeeLangTestLanguage.g:379:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        // PsiInternalBeeLangTestLanguage.g:380:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
          										
        }
        pushFollow(FOLLOW_14);
        lv_providedCapabilities_22_0=ruleProvidedCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_23=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred12_PsiInternalBeeLangTestLanguage
    public final void synpred12_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Boolean lv_providedCapabilities_22_0 = null;


        // PsiInternalBeeLangTestLanguage.g:359:4: ( ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:359:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:359:4: ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:360:5: {...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred12_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:360:101: ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ )
        // PsiInternalBeeLangTestLanguage.g:361:6: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2);
        // PsiInternalBeeLangTestLanguage.g:364:9: ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+
        int cnt98=0;
        loop98:
        do {
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==22) && ((true))) {
                alt98=1;
            }


            switch (alt98) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:364:10: {...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred12_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:364:19: (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' )
        	    // PsiInternalBeeLangTestLanguage.g:364:20: otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_ProvidesKeyword_7_2_0ElementType());
        	      								
        	    }
        	    otherlv_20=(Token)match(input,22,FOLLOW_12); if (state.failed) return ;
        	    otherlv_21=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:378:9: ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) )
        	    // PsiInternalBeeLangTestLanguage.g:379:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:379:10: (lv_providedCapabilities_22_0= ruleProvidedCapability )
        	    // PsiInternalBeeLangTestLanguage.g:380:11: lv_providedCapabilities_22_0= ruleProvidedCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_ProvidedCapabilitiesProvidedCapabilityParserRuleCall_7_2_2_0ElementType());
        	      										
        	    }
        	    pushFollow(FOLLOW_14);
        	    lv_providedCapabilities_22_0=ruleProvidedCapability();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    otherlv_23=(Token)match(input,20,FOLLOW_77); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt98 >= 1 ) break loop98;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(98, input);
                    throw eee;
            }
            cnt98++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred12_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred13_PsiInternalBeeLangTestLanguage
    public final void synpred13_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Boolean lv_requiredCapabilities_26_0 = null;


        // PsiInternalBeeLangTestLanguage.g:411:10: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:411:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred13_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:411:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        // PsiInternalBeeLangTestLanguage.g:411:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
          								
        }
        otherlv_24=(Token)match(input,23,FOLLOW_12); if (state.failed) return ;
        otherlv_25=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:425:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        // PsiInternalBeeLangTestLanguage.g:426:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        {
        // PsiInternalBeeLangTestLanguage.g:426:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        // PsiInternalBeeLangTestLanguage.g:427:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
          										
        }
        pushFollow(FOLLOW_14);
        lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_27=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred14_PsiInternalBeeLangTestLanguage
    public final void synpred14_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Boolean lv_requiredCapabilities_26_0 = null;


        // PsiInternalBeeLangTestLanguage.g:406:4: ( ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:406:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:406:4: ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:407:5: {...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred14_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3)");
        }
        // PsiInternalBeeLangTestLanguage.g:407:101: ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ )
        // PsiInternalBeeLangTestLanguage.g:408:6: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3);
        // PsiInternalBeeLangTestLanguage.g:411:9: ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+
        int cnt99=0;
        loop99:
        do {
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==23) && ((true))) {
                alt99=1;
            }


            switch (alt99) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:411:10: {...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred14_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:411:19: (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' )
        	    // PsiInternalBeeLangTestLanguage.g:411:20: otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_3_0ElementType());
        	      								
        	    }
        	    otherlv_24=(Token)match(input,23,FOLLOW_12); if (state.failed) return ;
        	    otherlv_25=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:425:9: ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) )
        	    // PsiInternalBeeLangTestLanguage.g:426:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:426:10: (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability )
        	    // PsiInternalBeeLangTestLanguage.g:427:11: lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_RequiredCapabilitiesAliasedRequiredCapabilityParserRuleCall_7_3_2_0ElementType());
        	      										
        	    }
        	    pushFollow(FOLLOW_14);
        	    lv_requiredCapabilities_26_0=ruleAliasedRequiredCapability();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    otherlv_27=(Token)match(input,20,FOLLOW_78); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt99 >= 1 ) break loop99;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(99, input);
                    throw eee;
            }
            cnt99++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred14_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred15_PsiInternalBeeLangTestLanguage
    public final void synpred15_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Boolean lv_metaRequiredCapabilities_31_0 = null;


        // PsiInternalBeeLangTestLanguage.g:458:10: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:458:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred15_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:458:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        // PsiInternalBeeLangTestLanguage.g:458:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        {
        if ( state.backtracking==0 ) {

          									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
          								
        }
        otherlv_28=(Token)match(input,23,FOLLOW_16); if (state.failed) return ;
        otherlv_29=(Token)match(input,24,FOLLOW_12); if (state.failed) return ;
        otherlv_30=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:479:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        // PsiInternalBeeLangTestLanguage.g:480:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        {
        // PsiInternalBeeLangTestLanguage.g:480:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        // PsiInternalBeeLangTestLanguage.g:481:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        {
        if ( state.backtracking==0 ) {

          											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
          										
        }
        pushFollow(FOLLOW_14);
        lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_32=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred15_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred16_PsiInternalBeeLangTestLanguage
    public final void synpred16_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Boolean lv_metaRequiredCapabilities_31_0 = null;


        // PsiInternalBeeLangTestLanguage.g:453:4: ( ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:453:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:453:4: ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:454:5: {...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred16_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4)");
        }
        // PsiInternalBeeLangTestLanguage.g:454:101: ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ )
        // PsiInternalBeeLangTestLanguage.g:455:6: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4);
        // PsiInternalBeeLangTestLanguage.g:458:9: ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+
        int cnt100=0;
        loop100:
        do {
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==23) && ((true))) {
                alt100=1;
            }


            switch (alt100) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:458:10: {...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred16_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:458:19: (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' )
        	    // PsiInternalBeeLangTestLanguage.g:458:20: otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';'
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markLeaf(elementTypeProvider.getUnit_RequiresKeyword_7_4_0ElementType());
        	      								
        	    }
        	    otherlv_28=(Token)match(input,23,FOLLOW_16); if (state.failed) return ;
        	    otherlv_29=(Token)match(input,24,FOLLOW_12); if (state.failed) return ;
        	    otherlv_30=(Token)match(input,19,FOLLOW_15); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:479:9: ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) )
        	    // PsiInternalBeeLangTestLanguage.g:480:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:480:10: (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability )
        	    // PsiInternalBeeLangTestLanguage.g:481:11: lv_metaRequiredCapabilities_31_0= ruleRequiredCapability
        	    {
        	    if ( state.backtracking==0 ) {

        	      											markComposite(elementTypeProvider.getUnit_MetaRequiredCapabilitiesRequiredCapabilityParserRuleCall_7_4_3_0ElementType());
        	      										
        	    }
        	    pushFollow(FOLLOW_14);
        	    lv_metaRequiredCapabilities_31_0=ruleRequiredCapability();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }

        	    otherlv_32=(Token)match(input,20,FOLLOW_78); if (state.failed) return ;

        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt100 >= 1 ) break loop100;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(100, input);
                    throw eee;
            }
            cnt100++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred16_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred17_PsiInternalBeeLangTestLanguage
    public final void synpred17_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functions_33_0 = null;


        // PsiInternalBeeLangTestLanguage.g:512:10: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )
        // PsiInternalBeeLangTestLanguage.g:512:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred17_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:512:19: ( (lv_functions_33_0= ruleFunction ) )
        // PsiInternalBeeLangTestLanguage.g:512:20: (lv_functions_33_0= ruleFunction )
        {
        // PsiInternalBeeLangTestLanguage.g:512:20: (lv_functions_33_0= ruleFunction )
        // PsiInternalBeeLangTestLanguage.g:513:10: lv_functions_33_0= ruleFunction
        {
        if ( state.backtracking==0 ) {

          										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
          									
        }
        pushFollow(FOLLOW_2);
        lv_functions_33_0=ruleFunction();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred18_PsiInternalBeeLangTestLanguage
    public final void synpred18_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functions_33_0 = null;


        // PsiInternalBeeLangTestLanguage.g:507:4: ( ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )
        // PsiInternalBeeLangTestLanguage.g:507:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        {
        // PsiInternalBeeLangTestLanguage.g:507:4: ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) )
        // PsiInternalBeeLangTestLanguage.g:508:5: {...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred18_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5)");
        }
        // PsiInternalBeeLangTestLanguage.g:508:101: ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ )
        // PsiInternalBeeLangTestLanguage.g:509:6: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        {
        getUnorderedGroupHelper().select(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5);
        // PsiInternalBeeLangTestLanguage.g:512:9: ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+
        int cnt101=0;
        loop101:
        do {
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==RULE_DOCUMENTATION) && ((true))) {
                alt101=1;
            }
            else if ( (LA101_0==RULE_ID) && ((true))) {
                alt101=1;
            }
            else if ( (LA101_0==33) && ((true))) {
                alt101=1;
            }
            else if ( (LA101_0==34) && ((true))) {
                alt101=1;
            }


            switch (alt101) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:512:10: {...}? => ( (lv_functions_33_0= ruleFunction ) )
        	    {
        	    if ( !((true)) ) {
        	        if (state.backtracking>0) {state.failed=true; return ;}
        	        throw new FailedPredicateException(input, "synpred18_PsiInternalBeeLangTestLanguage", "true");
        	    }
        	    // PsiInternalBeeLangTestLanguage.g:512:19: ( (lv_functions_33_0= ruleFunction ) )
        	    // PsiInternalBeeLangTestLanguage.g:512:20: (lv_functions_33_0= ruleFunction )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:512:20: (lv_functions_33_0= ruleFunction )
        	    // PsiInternalBeeLangTestLanguage.g:513:10: lv_functions_33_0= ruleFunction
        	    {
        	    if ( state.backtracking==0 ) {

        	      										markComposite(elementTypeProvider.getUnit_FunctionsFunctionParserRuleCall_7_5_0ElementType());
        	      									
        	    }
        	    pushFollow(FOLLOW_4);
        	    lv_functions_33_0=ruleFunction();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    if ( cnt101 >= 1 ) break loop101;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(101, input);
                    throw eee;
            }
            cnt101++;
        } while (true);


        }


        }


        }
    }
    // $ANTLR end synpred18_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred20_PsiInternalBeeLangTestLanguage
    public final void synpred20_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Boolean lv_condExpr_7_0 = null;


        // PsiInternalBeeLangTestLanguage.g:625:5: ( ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:625:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:625:5: ({...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:626:6: {...}? => ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:626:118: ( ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:627:7: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 0);
        // PsiInternalBeeLangTestLanguage.g:630:10: ({...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:630:11: {...}? => (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred20_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:630:20: (otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';' )
        // PsiInternalBeeLangTestLanguage.g:630:21: otherlv_5= 'when' otherlv_6= ':' ( (lv_condExpr_7_0= ruleExpression ) ) otherlv_8= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_WhenKeyword_2_1_0_0ElementType());
          									
        }
        otherlv_5=(Token)match(input,26,FOLLOW_12); if (state.failed) return ;
        otherlv_6=(Token)match(input,19,FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:644:10: ( (lv_condExpr_7_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:645:11: (lv_condExpr_7_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:645:11: (lv_condExpr_7_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:646:12: lv_condExpr_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getProvidedCapability_CondExprExpressionParserRuleCall_2_1_0_2_0ElementType());
          											
        }
        pushFollow(FOLLOW_14);
        lv_condExpr_7_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred20_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred21_PsiInternalBeeLangTestLanguage
    public final void synpred21_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;

        // PsiInternalBeeLangTestLanguage.g:672:5: ( ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:672:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:672:5: ({...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:673:6: {...}? => ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:673:118: ( ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:674:7: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 1);
        // PsiInternalBeeLangTestLanguage.g:677:10: ({...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:677:11: {...}? => (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred21_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:677:20: (otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';' )
        // PsiInternalBeeLangTestLanguage.g:677:21: otherlv_9= 'name' otherlv_10= ':' ( (lv_name_11_0= RULE_ID ) ) otherlv_12= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_NameKeyword_2_1_1_0ElementType());
          									
        }
        otherlv_9=(Token)match(input,27,FOLLOW_12); if (state.failed) return ;
        otherlv_10=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:691:10: ( (lv_name_11_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:692:11: (lv_name_11_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:692:11: (lv_name_11_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:693:12: lv_name_11_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getProvidedCapability_NameIDTerminalRuleCall_2_1_1_2_0ElementType());
          											
        }
        lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_12=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred21_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred22_PsiInternalBeeLangTestLanguage
    public final void synpred22_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_version_15_0=null;
        Token otherlv_16=null;

        // PsiInternalBeeLangTestLanguage.g:721:5: ( ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:721:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:721:5: ({...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:722:6: {...}? => ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:722:118: ( ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:723:7: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getProvidedCapabilityAccess().getUnorderedGroup_2_1(), 2);
        // PsiInternalBeeLangTestLanguage.g:726:10: ({...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:726:11: {...}? => (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred22_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:726:20: (otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';' )
        // PsiInternalBeeLangTestLanguage.g:726:21: otherlv_13= 'version' otherlv_14= ':' ( (lv_version_15_0= RULE_ID ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getProvidedCapability_VersionKeyword_2_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,14,FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:740:10: ( (lv_version_15_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:741:11: (lv_version_15_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:741:11: (lv_version_15_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:742:12: lv_version_15_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getProvidedCapability_VersionIDTerminalRuleCall_2_1_2_2_0ElementType());
          											
        }
        lv_version_15_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred22_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred26_PsiInternalBeeLangTestLanguage
    public final void synpred26_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Boolean lv_condExpr_9_0 = null;


        // PsiInternalBeeLangTestLanguage.g:899:5: ( ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:899:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:899:5: ({...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:900:6: {...}? => ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:900:125: ( ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:901:7: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalBeeLangTestLanguage.g:904:10: ({...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:904:11: {...}? => (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred26_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:904:20: (otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';' )
        // PsiInternalBeeLangTestLanguage.g:904:21: otherlv_7= 'when' otherlv_8= ':' ( (lv_condExpr_9_0= ruleExpression ) ) otherlv_10= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_7=(Token)match(input,26,FOLLOW_12); if (state.failed) return ;
        otherlv_8=(Token)match(input,19,FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:918:10: ( (lv_condExpr_9_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:919:11: (lv_condExpr_9_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:919:11: (lv_condExpr_9_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:920:12: lv_condExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getAliasedRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
          											
        }
        pushFollow(FOLLOW_14);
        lv_condExpr_9_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred26_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred27_PsiInternalBeeLangTestLanguage
    public final void synpred27_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_11_0=null;
        Token otherlv_12=null;

        // PsiInternalBeeLangTestLanguage.g:946:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:946:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:946:5: ({...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:947:6: {...}? => ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:947:125: ( ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:948:7: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalBeeLangTestLanguage.g:951:10: ({...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:951:11: {...}? => ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred27_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:951:20: ( ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';' )
        // PsiInternalBeeLangTestLanguage.g:951:21: ( (lv_greedy_11_0= 'greedy' ) ) otherlv_12= ';'
        {
        // PsiInternalBeeLangTestLanguage.g:951:21: ( (lv_greedy_11_0= 'greedy' ) )
        // PsiInternalBeeLangTestLanguage.g:952:11: (lv_greedy_11_0= 'greedy' )
        {
        // PsiInternalBeeLangTestLanguage.g:952:11: (lv_greedy_11_0= 'greedy' )
        // PsiInternalBeeLangTestLanguage.g:953:12: lv_greedy_11_0= 'greedy'
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
          											
        }
        lv_greedy_11_0=(Token)match(input,29,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_12=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred27_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred28_PsiInternalBeeLangTestLanguage
    public final void synpred28_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_min_15_0=null;
        Token otherlv_16=null;

        // PsiInternalBeeLangTestLanguage.g:981:5: ( ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:981:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:981:5: ({...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:982:6: {...}? => ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:982:125: ( ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:983:7: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalBeeLangTestLanguage.g:986:10: ({...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:986:11: {...}? => (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred28_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:986:20: (otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';' )
        // PsiInternalBeeLangTestLanguage.g:986:21: otherlv_13= 'requires-min' otherlv_14= ':' ( (lv_min_15_0= RULE_INT ) ) otherlv_16= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_13=(Token)match(input,30,FOLLOW_12); if (state.failed) return ;
        otherlv_14=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1000:10: ( (lv_min_15_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:1001:11: (lv_min_15_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:1001:11: (lv_min_15_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:1002:12: lv_min_15_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
          											
        }
        lv_min_15_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_16=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred28_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred29_PsiInternalBeeLangTestLanguage
    public final void synpred29_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token lv_max_19_0=null;
        Token otherlv_20=null;

        // PsiInternalBeeLangTestLanguage.g:1030:5: ( ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1030:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1030:5: ({...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1031:6: {...}? => ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalBeeLangTestLanguage.g:1031:125: ( ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1032:7: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalBeeLangTestLanguage.g:1035:10: ({...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1035:11: {...}? => (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred29_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1035:20: (otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';' )
        // PsiInternalBeeLangTestLanguage.g:1035:21: otherlv_17= 'requires-max' otherlv_18= ':' ( (lv_max_19_0= RULE_INT ) ) otherlv_20= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_17=(Token)match(input,31,FOLLOW_12); if (state.failed) return ;
        otherlv_18=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1049:10: ( (lv_max_19_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:1050:11: (lv_max_19_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:1050:11: (lv_max_19_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:1051:12: lv_max_19_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
          											
        }
        lv_max_19_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_20=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred29_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred30_PsiInternalBeeLangTestLanguage
    public final void synpred30_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token lv_versionRange_23_0=null;
        Token otherlv_24=null;

        // PsiInternalBeeLangTestLanguage.g:1079:5: ( ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1079:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1079:5: ({...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1080:6: {...}? => ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalBeeLangTestLanguage.g:1080:125: ( ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1081:7: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getAliasedRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalBeeLangTestLanguage.g:1084:10: ({...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1084:11: {...}? => (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred30_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1084:20: (otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';' )
        // PsiInternalBeeLangTestLanguage.g:1084:21: otherlv_21= 'version' otherlv_22= ':' ( (lv_versionRange_23_0= RULE_ID ) ) otherlv_24= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_21=(Token)match(input,14,FOLLOW_12); if (state.failed) return ;
        otherlv_22=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1098:10: ( (lv_versionRange_23_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:1099:11: (lv_versionRange_23_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:1099:11: (lv_versionRange_23_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:1100:12: lv_versionRange_23_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getAliasedRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
          											
        }
        lv_versionRange_23_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_24=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred30_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred32_PsiInternalBeeLangTestLanguage
    public final void synpred32_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Boolean lv_condExpr_8_0 = null;


        // PsiInternalBeeLangTestLanguage.g:1240:5: ( ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1240:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1240:5: ({...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1241:6: {...}? => ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0)");
        }
        // PsiInternalBeeLangTestLanguage.g:1241:118: ( ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1242:7: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 0);
        // PsiInternalBeeLangTestLanguage.g:1245:10: ({...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1245:11: {...}? => (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred32_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1245:20: (otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';' )
        // PsiInternalBeeLangTestLanguage.g:1245:21: otherlv_6= 'when' otherlv_7= ':' ( (lv_condExpr_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_WhenKeyword_3_1_0_0ElementType());
          									
        }
        otherlv_6=(Token)match(input,26,FOLLOW_12); if (state.failed) return ;
        otherlv_7=(Token)match(input,19,FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1259:10: ( (lv_condExpr_8_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:1260:11: (lv_condExpr_8_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:1260:11: (lv_condExpr_8_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:1261:12: lv_condExpr_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          												markComposite(elementTypeProvider.getRequiredCapability_CondExprExpressionParserRuleCall_3_1_0_2_0ElementType());
          											
        }
        pushFollow(FOLLOW_14);
        lv_condExpr_8_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred32_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred33_PsiInternalBeeLangTestLanguage
    public final void synpred33_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_greedy_10_0=null;
        Token otherlv_11=null;

        // PsiInternalBeeLangTestLanguage.g:1287:5: ( ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1287:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1287:5: ({...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1288:6: {...}? => ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1)");
        }
        // PsiInternalBeeLangTestLanguage.g:1288:118: ( ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1289:7: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 1);
        // PsiInternalBeeLangTestLanguage.g:1292:10: ({...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1292:11: {...}? => ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1292:20: ( ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';' )
        // PsiInternalBeeLangTestLanguage.g:1292:21: ( (lv_greedy_10_0= 'greedy' ) ) otherlv_11= ';'
        {
        // PsiInternalBeeLangTestLanguage.g:1292:21: ( (lv_greedy_10_0= 'greedy' ) )
        // PsiInternalBeeLangTestLanguage.g:1293:11: (lv_greedy_10_0= 'greedy' )
        {
        // PsiInternalBeeLangTestLanguage.g:1293:11: (lv_greedy_10_0= 'greedy' )
        // PsiInternalBeeLangTestLanguage.g:1294:12: lv_greedy_10_0= 'greedy'
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_GreedyGreedyKeyword_3_1_1_0_0ElementType());
          											
        }
        lv_greedy_10_0=(Token)match(input,29,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_11=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred33_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred34_PsiInternalBeeLangTestLanguage
    public final void synpred34_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_min_14_0=null;
        Token otherlv_15=null;

        // PsiInternalBeeLangTestLanguage.g:1322:5: ( ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1322:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1322:5: ({...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1323:6: {...}? => ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2)");
        }
        // PsiInternalBeeLangTestLanguage.g:1323:118: ( ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1324:7: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 2);
        // PsiInternalBeeLangTestLanguage.g:1327:10: ({...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1327:11: {...}? => (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1327:20: (otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';' )
        // PsiInternalBeeLangTestLanguage.g:1327:21: otherlv_12= 'requires-min' otherlv_13= ':' ( (lv_min_14_0= RULE_INT ) ) otherlv_15= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMinKeyword_3_1_2_0ElementType());
          									
        }
        otherlv_12=(Token)match(input,30,FOLLOW_12); if (state.failed) return ;
        otherlv_13=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1341:10: ( (lv_min_14_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:1342:11: (lv_min_14_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:1342:11: (lv_min_14_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:1343:12: lv_min_14_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_MinINTTerminalRuleCall_3_1_2_2_0ElementType());
          											
        }
        lv_min_14_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_15=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred34_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred35_PsiInternalBeeLangTestLanguage
    public final void synpred35_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_max_18_0=null;
        Token otherlv_19=null;

        // PsiInternalBeeLangTestLanguage.g:1371:5: ( ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1371:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1371:5: ({...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1372:6: {...}? => ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3)");
        }
        // PsiInternalBeeLangTestLanguage.g:1372:118: ( ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1373:7: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 3);
        // PsiInternalBeeLangTestLanguage.g:1376:10: ({...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1376:11: {...}? => (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred35_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1376:20: (otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';' )
        // PsiInternalBeeLangTestLanguage.g:1376:21: otherlv_16= 'requires-max' otherlv_17= ':' ( (lv_max_18_0= RULE_INT ) ) otherlv_19= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_RequiresMaxKeyword_3_1_3_0ElementType());
          									
        }
        otherlv_16=(Token)match(input,31,FOLLOW_12); if (state.failed) return ;
        otherlv_17=(Token)match(input,19,FOLLOW_24); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1390:10: ( (lv_max_18_0= RULE_INT ) )
        // PsiInternalBeeLangTestLanguage.g:1391:11: (lv_max_18_0= RULE_INT )
        {
        // PsiInternalBeeLangTestLanguage.g:1391:11: (lv_max_18_0= RULE_INT )
        // PsiInternalBeeLangTestLanguage.g:1392:12: lv_max_18_0= RULE_INT
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_MaxINTTerminalRuleCall_3_1_3_2_0ElementType());
          											
        }
        lv_max_18_0=(Token)match(input,RULE_INT,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_19=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred35_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred36_PsiInternalBeeLangTestLanguage
    public final void synpred36_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token lv_versionRange_22_0=null;
        Token otherlv_23=null;

        // PsiInternalBeeLangTestLanguage.g:1420:5: ( ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1420:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:1420:5: ({...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:1421:6: {...}? => ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        {
        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalBeeLangTestLanguage", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4)");
        }
        // PsiInternalBeeLangTestLanguage.g:1421:118: ( ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) ) )
        // PsiInternalBeeLangTestLanguage.g:1422:7: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        {
        getUnorderedGroupHelper().select(grammarAccess.getRequiredCapabilityAccess().getUnorderedGroup_3_1(), 4);
        // PsiInternalBeeLangTestLanguage.g:1425:10: ({...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' ) )
        // PsiInternalBeeLangTestLanguage.g:1425:11: {...}? => (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        {
        if ( !((true)) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred36_PsiInternalBeeLangTestLanguage", "true");
        }
        // PsiInternalBeeLangTestLanguage.g:1425:20: (otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';' )
        // PsiInternalBeeLangTestLanguage.g:1425:21: otherlv_20= 'version' otherlv_21= ':' ( (lv_versionRange_22_0= RULE_ID ) ) otherlv_23= ';'
        {
        if ( state.backtracking==0 ) {

          										markLeaf(elementTypeProvider.getRequiredCapability_VersionKeyword_3_1_4_0ElementType());
          									
        }
        otherlv_20=(Token)match(input,14,FOLLOW_12); if (state.failed) return ;
        otherlv_21=(Token)match(input,19,FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:1439:10: ( (lv_versionRange_22_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:1440:11: (lv_versionRange_22_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:1440:11: (lv_versionRange_22_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:1441:12: lv_versionRange_22_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          												markLeaf(elementTypeProvider.getRequiredCapability_VersionRangeIDTerminalRuleCall_3_1_4_2_0ElementType());
          											
        }
        lv_versionRange_22_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return ;

        }


        }

        otherlv_23=(Token)match(input,20,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred36_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred42_PsiInternalBeeLangTestLanguage
    public final void synpred42_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_ClosureParameter_0 = null;


        // PsiInternalBeeLangTestLanguage.g:1629:3: (this_ClosureParameter_0= ruleClosureParameter )
        // PsiInternalBeeLangTestLanguage.g:1629:3: this_ClosureParameter_0= ruleClosureParameter
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_ClosureParameter_0=ruleClosureParameter();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred69_PsiInternalBeeLangTestLanguage
    public final void synpred69_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_VarDeclaration_0 = null;


        // PsiInternalBeeLangTestLanguage.g:2285:3: (this_VarDeclaration_0= ruleVarDeclaration )
        // PsiInternalBeeLangTestLanguage.g:2285:3: this_VarDeclaration_0= ruleVarDeclaration
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_VarDeclaration_0=ruleVarDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred69_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred71_PsiInternalBeeLangTestLanguage
    public final void synpred71_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:2369:4: ( () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:2369:4: () ( (lv_functionName_2_0= ruleAssignmentOperator ) ) ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:2369:4: ()
        // PsiInternalBeeLangTestLanguage.g:2370:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:2379:4: ( (lv_functionName_2_0= ruleAssignmentOperator ) )
        // PsiInternalBeeLangTestLanguage.g:2380:5: (lv_functionName_2_0= ruleAssignmentOperator )
        {
        // PsiInternalBeeLangTestLanguage.g:2380:5: (lv_functionName_2_0= ruleAssignmentOperator )
        // PsiInternalBeeLangTestLanguage.g:2381:6: lv_functionName_2_0= ruleAssignmentOperator
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAssignmentExpression_FunctionNameAssignmentOperatorParserRuleCall_1_1_0ElementType());
          					
        }
        pushFollow(FOLLOW_19);
        lv_functionName_2_0=ruleAssignmentOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:2394:4: ( (lv_rightExpr_3_0= ruleAssignmentExpression ) )
        // PsiInternalBeeLangTestLanguage.g:2395:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:2395:5: (lv_rightExpr_3_0= ruleAssignmentExpression )
        // PsiInternalBeeLangTestLanguage.g:2396:6: lv_rightExpr_3_0= ruleAssignmentExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAssignmentExpression_RightExprAssignmentExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleAssignmentExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred71_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred85_PsiInternalBeeLangTestLanguage
    public final void synpred85_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3023:4: ( () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:3023:4: () otherlv_2= '||' ( (lv_rightExpr_3_0= ruleAndExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3023:4: ()
        // PsiInternalBeeLangTestLanguage.g:3024:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,57,FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3040:4: ( (lv_rightExpr_3_0= ruleAndExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3041:5: (lv_rightExpr_3_0= ruleAndExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3041:5: (lv_rightExpr_3_0= ruleAndExpression )
        // PsiInternalBeeLangTestLanguage.g:3042:6: lv_rightExpr_3_0= ruleAndExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getOrExpression_RightExprAndExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred85_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred86_PsiInternalBeeLangTestLanguage
    public final void synpred86_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3082:4: ( () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:3082:4: () otherlv_2= '&&' ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3082:4: ()
        // PsiInternalBeeLangTestLanguage.g:3083:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,58,FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3099:4: ( (lv_rightExpr_3_0= ruleRelationalExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3100:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3100:5: (lv_rightExpr_3_0= ruleRelationalExpression )
        // PsiInternalBeeLangTestLanguage.g:3101:6: lv_rightExpr_3_0= ruleRelationalExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAndExpression_RightExprRelationalExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleRelationalExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred86_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred87_PsiInternalBeeLangTestLanguage
    public final void synpred87_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean lv_functionName_2_0 = null;

        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3141:4: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:3141:4: () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3141:4: ()
        // PsiInternalBeeLangTestLanguage.g:3142:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:3151:4: ( (lv_functionName_2_0= ruleRelationalOperator ) )
        // PsiInternalBeeLangTestLanguage.g:3152:5: (lv_functionName_2_0= ruleRelationalOperator )
        {
        // PsiInternalBeeLangTestLanguage.g:3152:5: (lv_functionName_2_0= ruleRelationalOperator )
        // PsiInternalBeeLangTestLanguage.g:3153:6: lv_functionName_2_0= ruleRelationalOperator
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getRelationalExpression_FunctionNameRelationalOperatorParserRuleCall_1_1_0ElementType());
          					
        }
        pushFollow(FOLLOW_19);
        lv_functionName_2_0=ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:3166:4: ( (lv_rightExpr_3_0= ruleAdditiveExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3167:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3167:5: (lv_rightExpr_3_0= ruleAdditiveExpression )
        // PsiInternalBeeLangTestLanguage.g:3168:6: lv_rightExpr_3_0= ruleAdditiveExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getRelationalExpression_RightExprAdditiveExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleAdditiveExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred87_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred89_PsiInternalBeeLangTestLanguage
    public final void synpred89_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3208:4: ( () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:3208:4: () ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) ) ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3208:4: ()
        // PsiInternalBeeLangTestLanguage.g:3209:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:3218:4: ( ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) ) )
        // PsiInternalBeeLangTestLanguage.g:3219:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3219:5: ( (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' ) )
        // PsiInternalBeeLangTestLanguage.g:3220:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        {
        // PsiInternalBeeLangTestLanguage.g:3220:6: (lv_functionName_2_1= '+' | lv_functionName_2_2= '-' )
        int alt111=2;
        int LA111_0 = input.LA(1);

        if ( (LA111_0==59) ) {
            alt111=1;
        }
        else if ( (LA111_0==60) ) {
            alt111=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 111, 0, input);

            throw nvae;
        }
        switch (alt111) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3221:7: lv_functionName_2_1= '+'
                {
                lv_functionName_2_1=(Token)match(input,59,FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalBeeLangTestLanguage.g:3235:7: lv_functionName_2_2= '-'
                {
                if ( state.backtracking==0 ) {

                  							markLeaf(elementTypeProvider.getAdditiveExpression_FunctionNameHyphenMinusKeyword_1_1_0_1ElementType());
                  						
                }
                lv_functionName_2_2=(Token)match(input,60,FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // PsiInternalBeeLangTestLanguage.g:3251:4: ( (lv_rightExpr_3_0= ruleMultiplicativeExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3252:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3252:5: (lv_rightExpr_3_0= ruleMultiplicativeExpression )
        // PsiInternalBeeLangTestLanguage.g:3253:6: lv_rightExpr_3_0= ruleMultiplicativeExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getAdditiveExpression_RightExprMultiplicativeExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleMultiplicativeExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred89_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred92_PsiInternalBeeLangTestLanguage
    public final void synpred92_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;
        Token lv_functionName_2_3=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3293:4: ( () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:3293:4: () ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) ) ( (lv_rightExpr_3_0= ruleSetExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3293:4: ()
        // PsiInternalBeeLangTestLanguage.g:3294:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:3303:4: ( ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) ) )
        // PsiInternalBeeLangTestLanguage.g:3304:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3304:5: ( (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' ) )
        // PsiInternalBeeLangTestLanguage.g:3305:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        {
        // PsiInternalBeeLangTestLanguage.g:3305:6: (lv_functionName_2_1= '*' | lv_functionName_2_2= '/' | lv_functionName_2_3= '%' )
        int alt112=3;
        switch ( input.LA(1) ) {
        case 61:
            {
            alt112=1;
            }
            break;
        case 32:
            {
            alt112=2;
            }
            break;
        case 62:
            {
            alt112=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 112, 0, input);

            throw nvae;
        }

        switch (alt112) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3306:7: lv_functionName_2_1= '*'
                {
                lv_functionName_2_1=(Token)match(input,61,FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalBeeLangTestLanguage.g:3320:7: lv_functionName_2_2= '/'
                {
                lv_functionName_2_2=(Token)match(input,32,FOLLOW_19); if (state.failed) return ;

                }
                break;
            case 3 :
                // PsiInternalBeeLangTestLanguage.g:3334:7: lv_functionName_2_3= '%'
                {
                if ( state.backtracking==0 ) {

                  							markLeaf(elementTypeProvider.getMultiplicativeExpression_FunctionNamePercentSignKeyword_1_1_0_2ElementType());
                  						
                }
                lv_functionName_2_3=(Token)match(input,62,FOLLOW_19); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // PsiInternalBeeLangTestLanguage.g:3350:4: ( (lv_rightExpr_3_0= ruleSetExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3351:5: (lv_rightExpr_3_0= ruleSetExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3351:5: (lv_rightExpr_3_0= ruleSetExpression )
        // PsiInternalBeeLangTestLanguage.g:3352:6: lv_rightExpr_3_0= ruleSetExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getMultiplicativeExpression_RightExprSetExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleSetExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred92_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred93_PsiInternalBeeLangTestLanguage
    public final void synpred93_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_0=null;
        Boolean lv_rightExpr_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3392:4: ( () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) ) )
        // PsiInternalBeeLangTestLanguage.g:3392:4: () ( (lv_functionName_2_0= '..' ) ) ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3392:4: ()
        // PsiInternalBeeLangTestLanguage.g:3393:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:3402:4: ( (lv_functionName_2_0= '..' ) )
        // PsiInternalBeeLangTestLanguage.g:3403:5: (lv_functionName_2_0= '..' )
        {
        // PsiInternalBeeLangTestLanguage.g:3403:5: (lv_functionName_2_0= '..' )
        // PsiInternalBeeLangTestLanguage.g:3404:6: lv_functionName_2_0= '..'
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getSetExpression_FunctionNameFullStopFullStopKeyword_1_1_0ElementType());
          					
        }
        lv_functionName_2_0=(Token)match(input,63,FOLLOW_19); if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:3419:4: ( (lv_rightExpr_3_0= ruleUnaryOrInfixExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3420:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3420:5: (lv_rightExpr_3_0= ruleUnaryOrInfixExpression )
        // PsiInternalBeeLangTestLanguage.g:3421:6: lv_rightExpr_3_0= ruleUnaryOrInfixExpression
        {
        if ( state.backtracking==0 ) {

          						markComposite(elementTypeProvider.getSetExpression_RightExprUnaryOrInfixExpressionParserRuleCall_1_2_0ElementType());
          					
        }
        pushFollow(FOLLOW_2);
        lv_rightExpr_3_0=ruleUnaryOrInfixExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred93_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred99_PsiInternalBeeLangTestLanguage
    public final void synpred99_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token lv_functionName_2_1=null;
        Token lv_functionName_2_2=null;

        // PsiInternalBeeLangTestLanguage.g:3654:4: ( () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:3654:4: () ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3654:4: ()
        // PsiInternalBeeLangTestLanguage.g:3655:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // PsiInternalBeeLangTestLanguage.g:3664:4: ( ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) ) )
        // PsiInternalBeeLangTestLanguage.g:3665:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3665:5: ( (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' ) )
        // PsiInternalBeeLangTestLanguage.g:3666:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        {
        // PsiInternalBeeLangTestLanguage.g:3666:6: (lv_functionName_2_1= '--' | lv_functionName_2_2= '++' )
        int alt113=2;
        int LA113_0 = input.LA(1);

        if ( (LA113_0==66) ) {
            alt113=1;
        }
        else if ( (LA113_0==65) ) {
            alt113=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 113, 0, input);

            throw nvae;
        }
        switch (alt113) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3667:7: lv_functionName_2_1= '--'
                {
                lv_functionName_2_1=(Token)match(input,66,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // PsiInternalBeeLangTestLanguage.g:3681:7: lv_functionName_2_2= '++'
                {
                if ( state.backtracking==0 ) {

                  							markLeaf(elementTypeProvider.getPostopExpression_FunctionNamePlusSignPlusSignKeyword_1_1_0_1ElementType());
                  						
                }
                lv_functionName_2_2=(Token)match(input,65,FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred99_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred101_PsiInternalBeeLangTestLanguage
    public final void synpred101_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_parameterList_5_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3724:4: ( ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' ) )
        // PsiInternalBeeLangTestLanguage.g:3724:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        {
        // PsiInternalBeeLangTestLanguage.g:3724:4: ( () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')' )
        // PsiInternalBeeLangTestLanguage.g:3725:5: () otherlv_2= '.' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '(' ( (lv_parameterList_5_0= ruleParameterList ) )? otherlv_6= ')'
        {
        // PsiInternalBeeLangTestLanguage.g:3725:5: ()
        // PsiInternalBeeLangTestLanguage.g:3726:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_2=(Token)match(input,67,FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3742:5: ( (lv_name_3_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:3743:6: (lv_name_3_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:3743:6: (lv_name_3_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:3744:7: lv_name_3_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          							markLeaf(elementTypeProvider.getInfixExpression_NameIDTerminalRuleCall_1_0_2_0ElementType());
          						
        }
        lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_58); if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,35,FOLLOW_59); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3766:5: ( (lv_parameterList_5_0= ruleParameterList ) )?
        int alt114=2;
        int LA114_0 = input.LA(1);

        if ( (LA114_0==RULE_ID||LA114_0==RULE_STRING||LA114_0==13||(LA114_0>=17 && LA114_0<=18)||LA114_0==21||(LA114_0>=35 && LA114_0<=36)||LA114_0==52||LA114_0==56||LA114_0==60||(LA114_0>=64 && LA114_0<=66)||LA114_0==70||(LA114_0>=72 && LA114_0<=77)) ) {
            alt114=1;
        }
        switch (alt114) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3767:6: (lv_parameterList_5_0= ruleParameterList )
                {
                // PsiInternalBeeLangTestLanguage.g:3767:6: (lv_parameterList_5_0= ruleParameterList )
                // PsiInternalBeeLangTestLanguage.g:3768:7: lv_parameterList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  							markComposite(elementTypeProvider.getInfixExpression_ParameterListParameterListParserRuleCall_1_0_4_0ElementType());
                  						
                }
                pushFollow(FOLLOW_37);
                lv_parameterList_5_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_6=(Token)match(input,37,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred101_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred102_PsiInternalBeeLangTestLanguage
    public final void synpred102_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token otherlv_10=null;
        Boolean lv_indexExpr_9_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3790:4: ( ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' ) )
        // PsiInternalBeeLangTestLanguage.g:3790:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        {
        // PsiInternalBeeLangTestLanguage.g:3790:4: ( () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']' )
        // PsiInternalBeeLangTestLanguage.g:3791:5: () otherlv_8= '[' ( (lv_indexExpr_9_0= ruleExpression ) ) otherlv_10= ']'
        {
        // PsiInternalBeeLangTestLanguage.g:3791:5: ()
        // PsiInternalBeeLangTestLanguage.g:3792:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_8=(Token)match(input,68,FOLLOW_19); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3808:5: ( (lv_indexExpr_9_0= ruleExpression ) )
        // PsiInternalBeeLangTestLanguage.g:3809:6: (lv_indexExpr_9_0= ruleExpression )
        {
        // PsiInternalBeeLangTestLanguage.g:3809:6: (lv_indexExpr_9_0= ruleExpression )
        // PsiInternalBeeLangTestLanguage.g:3810:7: lv_indexExpr_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          							markComposite(elementTypeProvider.getInfixExpression_IndexExprExpressionParserRuleCall_1_1_2_0ElementType());
          						
        }
        pushFollow(FOLLOW_60);
        lv_indexExpr_9_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_10=(Token)match(input,69,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred102_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred103_PsiInternalBeeLangTestLanguage
    public final void synpred103_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_12=null;
        Token lv_featureName_13_0=null;

        // PsiInternalBeeLangTestLanguage.g:3832:4: ( ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) ) )
        // PsiInternalBeeLangTestLanguage.g:3832:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3832:4: ( () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) ) )
        // PsiInternalBeeLangTestLanguage.g:3833:5: () otherlv_12= '.' ( (lv_featureName_13_0= RULE_ID ) )
        {
        // PsiInternalBeeLangTestLanguage.g:3833:5: ()
        // PsiInternalBeeLangTestLanguage.g:3834:6: 
        {
        if ( state.backtracking==0 ) {

          						/* */
          					
        }

        }

        otherlv_12=(Token)match(input,67,FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3850:5: ( (lv_featureName_13_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:3851:6: (lv_featureName_13_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:3851:6: (lv_featureName_13_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:3852:7: lv_featureName_13_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          							markLeaf(elementTypeProvider.getInfixExpression_FeatureNameIDTerminalRuleCall_1_2_2_0ElementType());
          						
        }
        lv_featureName_13_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred103_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred105_PsiInternalBeeLangTestLanguage
    public final void synpred105_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_parameterList_3_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3895:4: ( () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')' )
        // PsiInternalBeeLangTestLanguage.g:3895:4: () otherlv_2= '(' ( (lv_parameterList_3_0= ruleParameterList ) )? otherlv_4= ')'
        {
        // PsiInternalBeeLangTestLanguage.g:3895:4: ()
        // PsiInternalBeeLangTestLanguage.g:3896:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        otherlv_2=(Token)match(input,35,FOLLOW_59); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:3912:4: ( (lv_parameterList_3_0= ruleParameterList ) )?
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==RULE_ID||LA115_0==RULE_STRING||LA115_0==13||(LA115_0>=17 && LA115_0<=18)||LA115_0==21||(LA115_0>=35 && LA115_0<=36)||LA115_0==52||LA115_0==56||LA115_0==60||(LA115_0>=64 && LA115_0<=66)||LA115_0==70||(LA115_0>=72 && LA115_0<=77)) ) {
            alt115=1;
        }
        switch (alt115) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:3913:5: (lv_parameterList_3_0= ruleParameterList )
                {
                // PsiInternalBeeLangTestLanguage.g:3913:5: (lv_parameterList_3_0= ruleParameterList )
                // PsiInternalBeeLangTestLanguage.g:3914:6: lv_parameterList_3_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						markComposite(elementTypeProvider.getCallExpression_ParameterListParameterListParserRuleCall_1_2_0ElementType());
                  					
                }
                pushFollow(FOLLOW_37);
                lv_parameterList_3_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_4=(Token)match(input,37,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred106_PsiInternalBeeLangTestLanguage
    public final void synpred106_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_FeatureCall_0 = null;


        // PsiInternalBeeLangTestLanguage.g:3949:3: (this_FeatureCall_0= ruleFeatureCall )
        // PsiInternalBeeLangTestLanguage.g:3949:3: this_FeatureCall_0= ruleFeatureCall
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_FeatureCall_0=ruleFeatureCall();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred108_PsiInternalBeeLangTestLanguage
    public final void synpred108_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_Value_2 = null;


        // PsiInternalBeeLangTestLanguage.g:3973:3: (this_Value_2= ruleValue )
        // PsiInternalBeeLangTestLanguage.g:3973:3: this_Value_2= ruleValue
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_Value_2=ruleValue();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred108_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred109_PsiInternalBeeLangTestLanguage
    public final void synpred109_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_Literal_3 = null;


        // PsiInternalBeeLangTestLanguage.g:3985:3: (this_Literal_3= ruleLiteral )
        // PsiInternalBeeLangTestLanguage.g:3985:3: this_Literal_3= ruleLiteral
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_Literal_3=ruleLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred109_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred112_PsiInternalBeeLangTestLanguage
    public final void synpred112_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_BlockExpression_6 = null;


        // PsiInternalBeeLangTestLanguage.g:4021:3: (this_BlockExpression_6= ruleBlockExpression )
        // PsiInternalBeeLangTestLanguage.g:4021:3: this_BlockExpression_6= ruleBlockExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_BlockExpression_6=ruleBlockExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred113_PsiInternalBeeLangTestLanguage
    public final void synpred113_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_WithExpression_7 = null;


        // PsiInternalBeeLangTestLanguage.g:4033:3: (this_WithExpression_7= ruleWithExpression )
        // PsiInternalBeeLangTestLanguage.g:4033:3: this_WithExpression_7= ruleWithExpression
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_WithExpression_7=ruleWithExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred127_PsiInternalBeeLangTestLanguage
    public final void synpred127_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token otherlv_5=null;
        Boolean lv_parameterList_4_0 = null;


        // PsiInternalBeeLangTestLanguage.g:4636:4: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )
        // PsiInternalBeeLangTestLanguage.g:4636:4: otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')'
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_LeftParenthesisKeyword_3_0ElementType());
          			
        }
        otherlv_3=(Token)match(input,35,FOLLOW_59); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:4643:4: ( (lv_parameterList_4_0= ruleParameterList ) )?
        int alt117=2;
        int LA117_0 = input.LA(1);

        if ( (LA117_0==RULE_ID||LA117_0==RULE_STRING||LA117_0==13||(LA117_0>=17 && LA117_0<=18)||LA117_0==21||(LA117_0>=35 && LA117_0<=36)||LA117_0==52||LA117_0==56||LA117_0==60||(LA117_0>=64 && LA117_0<=66)||LA117_0==70||(LA117_0>=72 && LA117_0<=77)) ) {
            alt117=1;
        }
        switch (alt117) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:4644:5: (lv_parameterList_4_0= ruleParameterList )
                {
                // PsiInternalBeeLangTestLanguage.g:4644:5: (lv_parameterList_4_0= ruleParameterList )
                // PsiInternalBeeLangTestLanguage.g:4645:6: lv_parameterList_4_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						markComposite(elementTypeProvider.getConstructorCallExpression_ParameterListParameterListParserRuleCall_3_1_0ElementType());
                  					
                }
                pushFollow(FOLLOW_37);
                lv_parameterList_4_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_5=(Token)match(input,37,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred127_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred128_PsiInternalBeeLangTestLanguage
    public final void synpred128_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token lv_alias_7_0=null;

        // PsiInternalBeeLangTestLanguage.g:4667:4: (otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) ) )
        // PsiInternalBeeLangTestLanguage.g:4667:4: otherlv_6= 'as' ( (lv_alias_7_0= RULE_ID ) )
        {
        if ( state.backtracking==0 ) {

          				markLeaf(elementTypeProvider.getConstructorCallExpression_AsKeyword_4_0ElementType());
          			
        }
        otherlv_6=(Token)match(input,28,FOLLOW_8); if (state.failed) return ;
        // PsiInternalBeeLangTestLanguage.g:4674:4: ( (lv_alias_7_0= RULE_ID ) )
        // PsiInternalBeeLangTestLanguage.g:4675:5: (lv_alias_7_0= RULE_ID )
        {
        // PsiInternalBeeLangTestLanguage.g:4675:5: (lv_alias_7_0= RULE_ID )
        // PsiInternalBeeLangTestLanguage.g:4676:6: lv_alias_7_0= RULE_ID
        {
        if ( state.backtracking==0 ) {

          						markLeaf(elementTypeProvider.getConstructorCallExpression_AliasIDTerminalRuleCall_4_1_0ElementType());
          					
        }
        lv_alias_7_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred128_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred135_PsiInternalBeeLangTestLanguage
    public final void synpred135_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_varArgs_9_0=null;
        Boolean lv_parameters_5_0 = null;

        Boolean lv_parameters_7_0 = null;

        Boolean lv_parameters_10_0 = null;


        // PsiInternalBeeLangTestLanguage.g:5011:4: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) )
        // PsiInternalBeeLangTestLanguage.g:5011:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        {
        // PsiInternalBeeLangTestLanguage.g:5011:4: ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) )
        // PsiInternalBeeLangTestLanguage.g:5012:5: (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        {
        // PsiInternalBeeLangTestLanguage.g:5012:5: (otherlv_4= '|' )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==77) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:5013:6: otherlv_4= '|'
                {
                otherlv_4=(Token)match(input,77,FOLLOW_35); if (state.failed) return ;

                }
                break;

        }

        // PsiInternalBeeLangTestLanguage.g:5021:5: ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? )
        // PsiInternalBeeLangTestLanguage.g:5022:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        {
        // PsiInternalBeeLangTestLanguage.g:5022:6: ( (lv_parameters_5_0= ruleParameterDeclaration ) )
        // PsiInternalBeeLangTestLanguage.g:5023:7: (lv_parameters_5_0= ruleParameterDeclaration )
        {
        // PsiInternalBeeLangTestLanguage.g:5023:7: (lv_parameters_5_0= ruleParameterDeclaration )
        // PsiInternalBeeLangTestLanguage.g:5024:8: lv_parameters_5_0= ruleParameterDeclaration
        {
        if ( state.backtracking==0 ) {

          								markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_0_0ElementType());
          							
        }
        pushFollow(FOLLOW_26);
        lv_parameters_5_0=ruleParameterDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // PsiInternalBeeLangTestLanguage.g:5037:6: (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )*
        loop119:
        do {
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==16) ) {
                int LA119_1 = input.LA(2);

                if ( (LA119_1==RULE_ID||LA119_1==35) ) {
                    alt119=1;
                }


            }


            switch (alt119) {
        	case 1 :
        	    // PsiInternalBeeLangTestLanguage.g:5038:7: otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    {
        	    otherlv_6=(Token)match(input,16,FOLLOW_35); if (state.failed) return ;
        	    // PsiInternalBeeLangTestLanguage.g:5045:7: ( (lv_parameters_7_0= ruleParameterDeclaration ) )
        	    // PsiInternalBeeLangTestLanguage.g:5046:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    {
        	    // PsiInternalBeeLangTestLanguage.g:5046:8: (lv_parameters_7_0= ruleParameterDeclaration )
        	    // PsiInternalBeeLangTestLanguage.g:5047:9: lv_parameters_7_0= ruleParameterDeclaration
        	    {
        	    if ( state.backtracking==0 ) {

        	      									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_1_1_0ElementType());
        	      								
        	    }
        	    pushFollow(FOLLOW_26);
        	    lv_parameters_7_0=ruleParameterDeclaration();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop119;
            }
        } while (true);

        // PsiInternalBeeLangTestLanguage.g:5061:6: (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==16) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // PsiInternalBeeLangTestLanguage.g:5062:7: otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                {
                otherlv_8=(Token)match(input,16,FOLLOW_36); if (state.failed) return ;
                // PsiInternalBeeLangTestLanguage.g:5069:7: ( (lv_varArgs_9_0= '...' ) )
                // PsiInternalBeeLangTestLanguage.g:5070:8: (lv_varArgs_9_0= '...' )
                {
                // PsiInternalBeeLangTestLanguage.g:5070:8: (lv_varArgs_9_0= '...' )
                // PsiInternalBeeLangTestLanguage.g:5071:9: lv_varArgs_9_0= '...'
                {
                if ( state.backtracking==0 ) {

                  									markLeaf(elementTypeProvider.getClosureExpression_VarArgsFullStopFullStopFullStopKeyword_2_0_1_2_1_0ElementType());
                  								
                }
                lv_varArgs_9_0=(Token)match(input,36,FOLLOW_35); if (state.failed) return ;

                }


                }

                // PsiInternalBeeLangTestLanguage.g:5086:7: ( (lv_parameters_10_0= ruleParameterDeclaration ) )
                // PsiInternalBeeLangTestLanguage.g:5087:8: (lv_parameters_10_0= ruleParameterDeclaration )
                {
                // PsiInternalBeeLangTestLanguage.g:5087:8: (lv_parameters_10_0= ruleParameterDeclaration )
                // PsiInternalBeeLangTestLanguage.g:5088:9: lv_parameters_10_0= ruleParameterDeclaration
                {
                if ( state.backtracking==0 ) {

                  									markComposite(elementTypeProvider.getClosureExpression_ParametersParameterDeclarationParserRuleCall_2_0_1_2_2_0ElementType());
                  								
                }
                pushFollow(FOLLOW_2);
                lv_parameters_10_0=ruleParameterDeclaration();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }


        }
    }
    // $ANTLR end synpred135_PsiInternalBeeLangTestLanguage

    // $ANTLR start synpred137_PsiInternalBeeLangTestLanguage
    public final void synpred137_PsiInternalBeeLangTestLanguage_fragment() throws RecognitionException {   
        Boolean this_BlockExpressionWithoutBrackets_0 = null;


        // PsiInternalBeeLangTestLanguage.g:5176:3: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets )
        // PsiInternalBeeLangTestLanguage.g:5176:3: this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets
        {
        if ( state.backtracking==0 ) {

          			/* */
          		
        }
        pushFollow(FOLLOW_2);
        this_BlockExpressionWithoutBrackets_0=ruleBlockExpressionWithoutBrackets();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred137_PsiInternalBeeLangTestLanguage

    // Delegated rules

    public final boolean synpred102_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_PsiInternalBeeLangTestLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_PsiInternalBeeLangTestLanguage_fragment(); // can never throw exception
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
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA91 dfa91 = new DFA91(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\4\uffff\1\23\6\uffff";
    static final String dfa_3s = "\1\42\4\uffff\1\30\6\uffff";
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\1\3\1\uffff\4\6\1\4\1\5";
    static final String dfa_5s = "\1\0\4\uffff\1\1\6\uffff}>";
    static final String[] dfa_6s = {
            "\1\6\1\7\14\uffff\1\2\2\uffff\1\3\1\4\1\5\1\uffff\1\1\7\uffff\1\10\1\11",
            "",
            "",
            "",
            "",
            "\1\12\4\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 264:6: ( ({...}? => ( ({...}? => (otherlv_12= 'source' otherlv_13= ':' ( (lv_sourceLocation_14_0= rulePath ) ) otherlv_15= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'output' otherlv_17= ':' ( (lv_outputLocation_18_0= rulePath ) ) otherlv_19= ';' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'provides' otherlv_21= ':' ( (lv_providedCapabilities_22_0= ruleProvidedCapability ) ) otherlv_23= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_24= 'requires' otherlv_25= ':' ( (lv_requiredCapabilities_26_0= ruleAliasedRequiredCapability ) ) otherlv_27= ';' ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= 'requires' otherlv_29= 'env' otherlv_30= ':' ( (lv_metaRequiredCapabilities_31_0= ruleRequiredCapability ) ) otherlv_32= ';' ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_functions_33_0= ruleFunction ) ) )+ ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_0 = input.LA(1);

                         
                        int index13_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA13_0==25) ) {s = 1;}

                        else if ( LA13_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 0) ) {s = 2;}

                        else if ( LA13_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 1) ) {s = 3;}

                        else if ( LA13_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 2) ) {s = 4;}

                        else if ( (LA13_0==23) ) {s = 5;}

                        else if ( LA13_0 == RULE_DOCUMENTATION && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 6;}

                        else if ( LA13_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 7;}

                        else if ( LA13_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 8;}

                        else if ( LA13_0 == 34 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 5) ) {s = 9;}

                         
                        input.seek(index13_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_5 = input.LA(1);

                         
                        int index13_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA13_5 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 3) ) {s = 10;}

                        else if ( LA13_5 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getUnitAccess().getUnorderedGroup_7(), 4) ) {s = 11;}

                         
                        input.seek(index13_5);
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
    static final String dfa_7s = "\56\uffff";
    static final String dfa_8s = "\3\uffff\1\4\4\uffff\2\4\12\uffff\2\4\1\uffff\1\4\15\uffff\2\4\7\uffff";
    static final String dfa_9s = "\1\5\1\uffff\2\5\1\uffff\1\20\2\5\2\20\1\5\1\0\3\5\1\20\1\5\1\67\1\5\1\0\1\5\1\20\1\5\1\20\1\45\1\5\1\20\1\5\1\67\2\5\1\20\3\5\1\45\1\5\1\20\1\5\1\45\1\0\1\5\1\20\1\5\1\45\1\0";
    static final String dfa_10s = "\1\115\1\uffff\1\114\1\115\1\uffff\1\104\1\114\1\115\2\104\1\114\1\0\1\43\1\115\1\114\1\104\1\5\1\67\1\45\1\0\2\115\1\44\1\104\1\45\1\5\1\45\1\5\1\67\1\114\1\115\1\45\2\5\1\44\1\45\1\5\2\115\1\45\1\0\1\5\1\45\1\5\1\45\1\0";
    static final String dfa_11s = "\1\uffff\1\1\2\uffff\1\2\51\uffff";
    static final String dfa_12s = "\13\uffff\1\2\7\uffff\1\0\24\uffff\1\1\4\uffff\1\3}>";
    static final String[] dfa_13s = {
            "\1\3\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\2\1\1\17\uffff\1\1\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4\1\1",
            "",
            "\1\5\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\2\1\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\1\12\uffff\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\17\4\1\6\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "",
            "\1\1\17\uffff\1\4\2\uffff\1\4\1\uffff\1\10\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\11\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\13\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\12\1\14\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\1\1\uffff\7\4\1\uffff\4\4",
            "\1\15\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\16\1\4\4\uffff\7\4\1\uffff\4\4",
            "\1\17\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\1\20\1\21\22\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\uffff",
            "\1\23\35\uffff\1\22",
            "\1\24\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\25\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\26\17\uffff\1\4\2\uffff\1\4\1\uffff\1\27\17\4\4\uffff\7\4\1\uffff\4\4",
            "\1\30",
            "\1\31",
            "\1\32\36\uffff\1\33\1\34",
            "\1\uffff",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\37\36\uffff\1\40",
            "\1\4\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\2\uffff\1\31\1\uffff\7\4\1\uffff\4\4",
            "\1\21",
            "\1\41",
            "\1\42\24\uffff\1\34",
            "\1\43",
            "\1\44",
            "\1\45\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\1\4\30\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\5\4",
            "\1\46\1\uffff\1\4\5\uffff\1\4\3\uffff\2\4\2\uffff\1\4\15\uffff\2\4\17\uffff\1\4\3\uffff\1\4\3\uffff\1\4\3\uffff\3\4\3\uffff\1\4\1\uffff\6\4",
            "\1\26\24\uffff\1\21",
            "\1\47",
            "\1\50",
            "\1\52\36\uffff\1\51",
            "\1\34",
            "\1\53",
            "\1\7\17\uffff\1\4\2\uffff\1\4\1\uffff\20\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\1",
            "\1\4\12\uffff\1\36\17\uffff\1\4\2\uffff\1\4\1\uffff\16\4\1\35\1\4\4\uffff\7\4\1\uffff\4\4\10\uffff\1\4",
            "\1\21",
            "\1\uffff",
            "\1\54",
            "\1\42\24\uffff\1\34",
            "\1\55",
            "\1\34",
            "\1\uffff"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1628:2: (this_ClosureParameter_0= ruleClosureParameter | this_Parameter_1= ruleParameter )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_19 = input.LA(1);

                         
                        int index27_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_40 = input.LA(1);

                         
                        int index27_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_40);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_45 = input.LA(1);

                         
                        int index27_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index27_45);
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
    static final String dfa_14s = "\15\uffff";
    static final String dfa_15s = "\4\uffff\1\6\4\uffff\2\6\2\uffff";
    static final String dfa_16s = "\2\5\1\uffff\2\5\2\uffff\1\20\1\5\1\24\1\20\1\5\1\0";
    static final String dfa_17s = "\1\114\1\66\1\uffff\1\114\1\104\2\uffff\1\104\1\114\2\104\1\114\1\0";
    static final String dfa_18s = "\2\uffff\1\1\2\uffff\1\2\1\3\6\uffff";
    static final String dfa_19s = "\14\uffff\1\0}>";
    static final String[] dfa_20s = {
            "\1\4\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\13\uffff\1\1\1\uffff\1\3\21\uffff\1\2\1\5\1\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\2\35\uffff\1\2\21\uffff\1\2\1\5",
            "",
            "\1\7\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\2\2\22\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\2\16\uffff\1\6\13\uffff\1\6\2\uffff\1\6\2\uffff\16\6\1\10\4\uffff\7\6\1\uffff\4\6",
            "",
            "",
            "\1\2\17\uffff\1\6\2\uffff\1\6\1\uffff\1\11\17\6\4\uffff\7\6\1\uffff\4\6",
            "\1\12\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\6\13\uffff\1\6\2\uffff\1\6\2\uffff\17\6\2\uffff\1\2\1\uffff\7\6\1\uffff\4\6",
            "\1\2\3\uffff\1\6\13\uffff\1\6\2\uffff\1\6\2\uffff\15\6\1\13\1\6\4\uffff\7\6\1\uffff\4\6",
            "\1\14\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\uffff"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "2284:2: (this_VarDeclaration_0= ruleVarDeclaration | this_ValDeclaration_1= ruleValDeclaration | this_AssignmentExpression_2= ruleAssignmentExpression )";
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
                        if ( (synpred69_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
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
    static final String dfa_21s = "\1\1\13\uffff";
    static final String dfa_22s = "\1\20\1\uffff\11\0\1\uffff";
    static final String dfa_23s = "\1\105\1\uffff\11\0\1\uffff";
    static final String dfa_24s = "\1\uffff\1\2\11\uffff\1\1";
    static final String dfa_25s = "\2\uffff\1\1\1\4\1\3\1\10\1\6\1\5\1\7\1\2\1\0\1\uffff}>";
    static final String[] dfa_26s = {
            "\2\1\2\uffff\1\1\4\uffff\1\1\2\uffff\1\1\3\uffff\1\1\2\uffff\1\1\1\uffff\7\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\4\uffff\7\1\1\uffff\5\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_1;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "()* loopback of 3140:3: ( () ( (lv_functionName_2_0= ruleRelationalOperator ) ) ( (lv_rightExpr_3_0= ruleAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA58_10 = input.LA(1);

                         
                        int index58_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA58_2 = input.LA(1);

                         
                        int index58_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA58_9 = input.LA(1);

                         
                        int index58_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA58_4 = input.LA(1);

                         
                        int index58_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA58_3 = input.LA(1);

                         
                        int index58_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_3);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA58_7 = input.LA(1);

                         
                        int index58_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA58_6 = input.LA(1);

                         
                        int index58_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA58_8 = input.LA(1);

                         
                        int index58_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA58_5 = input.LA(1);

                         
                        int index58_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_PsiInternalBeeLangTestLanguage()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index58_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 58, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_27s = "\23\uffff";
    static final String dfa_28s = "\1\5\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String dfa_29s = "\1\114\1\0\2\uffff\1\0\10\uffff\1\0\5\uffff";
    static final String dfa_30s = "\2\uffff\1\2\1\4\1\uffff\1\5\6\uffff\1\6\1\uffff\1\1\1\3\1\7\1\10\1\11";
    static final String dfa_31s = "\1\uffff\1\0\2\uffff\1\1\10\uffff\1\2\5\uffff}>";
    static final String[] dfa_32s = {
            "\1\1\1\uffff\1\3\5\uffff\1\5\3\uffff\1\4\1\5\2\uffff\1\5\15\uffff\1\14\42\uffff\1\15\1\uffff\4\5\1\2",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "3948:2: (this_FeatureCall_0= ruleFeatureCall | this_ConstructorCallExpression_1= ruleConstructorCallExpression | this_Value_2= ruleValue | this_Literal_3= ruleLiteral | this_KeywordVariables_4= ruleKeywordVariables | this_ParanthesizedExpression_5= ruleParanthesizedExpression | this_BlockExpression_6= ruleBlockExpression | this_WithExpression_7= ruleWithExpression | this_WithContextExpression_8= ruleWithContextExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA73_1 = input.LA(1);

                         
                        int index73_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_PsiInternalBeeLangTestLanguage()) ) {s = 14;}

                        else if ( (synpred108_PsiInternalBeeLangTestLanguage()) ) {s = 15;}

                         
                        input.seek(index73_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA73_4 = input.LA(1);

                         
                        int index73_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred109_PsiInternalBeeLangTestLanguage()) ) {s = 3;}

                        else if ( (synpred112_PsiInternalBeeLangTestLanguage()) ) {s = 16;}

                         
                        input.seek(index73_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA73_13 = input.LA(1);

                         
                        int index73_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_PsiInternalBeeLangTestLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index73_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 73, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_33s = "\46\uffff";
    static final String dfa_34s = "\1\2\45\uffff";
    static final String dfa_35s = "\1\20\1\0\44\uffff";
    static final String dfa_36s = "\1\105\1\0\44\uffff";
    static final String dfa_37s = "\2\uffff\1\2\42\uffff\1\1";
    static final String dfa_38s = "\1\uffff\1\0\44\uffff}>";
    static final String[] dfa_39s = {
            "\2\2\2\uffff\1\2\4\uffff\1\2\2\uffff\1\2\3\uffff\1\2\2\uffff\1\1\1\uffff\20\2\4\uffff\7\2\1\uffff\5\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[][] dfa_39 = unpackEncodedStringArray(dfa_39s);

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_33;
            this.eof = dfa_34;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_38;
            this.transition = dfa_39;
        }
        public String getDescription() {
            return "4635:3: (otherlv_3= '(' ( (lv_parameterList_4_0= ruleParameterList ) )? otherlv_5= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_PsiInternalBeeLangTestLanguage()) ) {s = 37;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_40s = "\72\uffff";
    static final String dfa_41s = "\5\uffff\1\6\7\uffff\1\6\6\uffff\1\6\17\uffff\1\6\2\uffff\2\6\15\uffff\2\6\2\uffff";
    static final String dfa_42s = "\2\5\2\uffff\2\5\1\uffff\1\20\1\5\1\67\2\5\2\20\1\5\1\45\3\5\1\0\1\20\1\5\1\20\2\5\1\0\1\20\1\5\1\67\2\5\1\45\1\20\1\5\1\67\1\5\1\20\1\45\1\5\1\20\2\5\1\45\1\5\1\20\4\5\1\20\2\5\1\45\1\0\1\20\1\5\1\45\1\0";
    static final String dfa_43s = "\1\115\1\114\2\uffff\1\114\1\115\1\uffff\1\104\1\5\1\67\1\115\1\114\1\115\1\104\1\44\1\45\1\5\1\43\1\114\1\0\1\104\1\5\1\45\1\5\1\45\1\0\1\104\1\5\1\67\1\114\1\115\2\45\1\5\1\67\1\44\1\104\1\45\1\5\2\115\1\44\1\45\1\5\1\45\2\5\1\114\1\115\1\45\2\5\1\45\1\0\2\115\1\45\1\0";
    static final String dfa_44s = "\2\uffff\1\1\1\2\2\uffff\1\3\63\uffff";
    static final String dfa_45s = "\23\uffff\1\0\5\uffff\1\3\33\uffff\1\2\3\uffff\1\1}>";
    static final String[] dfa_46s = {
            "\1\2\35\uffff\1\2\1\3\50\uffff\1\1",
            "\1\5\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\13\uffff\1\6\1\uffff\1\4\21\uffff\2\6\1\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "",
            "",
            "\1\7\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\1\10\1\11\22\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\14\12\uffff\1\12\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\17\6\1\13\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "",
            "\1\16\17\uffff\1\6\2\uffff\1\6\1\uffff\1\15\17\6\4\uffff\7\6\1\uffff\4\6",
            "\1\17",
            "\1\20",
            "\1\23\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\22\1\21\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\24\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\2\3\uffff\1\6\21\uffff\1\6\46\uffff\1\2",
            "\1\6\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\20\6\2\uffff\1\20\1\uffff\7\6\1\uffff\4\6",
            "\1\26\36\uffff\1\25",
            "\1\11",
            "\1\27",
            "\1\31\35\uffff\1\30",
            "\1\32\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\1\33\1\34\22\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\uffff",
            "\1\36\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\35\1\6\4\uffff\7\6\1\uffff\4\6",
            "\1\37",
            "\1\16\24\uffff\1\11",
            "\1\14",
            "\1\40\36\uffff\1\41\1\42",
            "\1\uffff",
            "\1\43\17\uffff\1\6\2\uffff\1\6\1\uffff\1\44\17\6\4\uffff\7\6\1\uffff\4\6",
            "\1\45",
            "\1\46",
            "\1\47\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\50\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\2\6\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\11",
            "\1\51\24\uffff\1\42",
            "\1\52",
            "\1\53",
            "\1\54\36\uffff\1\55",
            "\1\6\17\uffff\1\6\2\uffff\1\6\1\uffff\20\6\2\uffff\1\46\1\uffff\7\6\1\uffff\4\6",
            "\1\34",
            "\1\56",
            "\1\12\3\uffff\1\6\4\uffff\1\6\6\uffff\1\6\2\uffff\1\6\1\uffff\20\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "\1\6\12\uffff\1\60\17\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\57\1\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\6",
            "\1\61\36\uffff\1\62",
            "\1\42",
            "\1\63",
            "\1\43\24\uffff\1\34",
            "\1\64",
            "\1\65",
            "\1\66\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\1\6\30\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\5\6",
            "\1\67\1\uffff\1\6\5\uffff\1\6\3\uffff\2\6\2\uffff\1\6\15\uffff\2\6\17\uffff\1\6\3\uffff\1\6\3\uffff\1\6\3\uffff\3\6\3\uffff\1\6\1\uffff\6\6",
            "\1\51\24\uffff\1\42",
            "\1\70",
            "\1\71",
            "\1\34",
            "\1\uffff",
            "\1\12\3\uffff\1\6\13\uffff\1\6\2\uffff\1\6\1\uffff\20\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\2",
            "\1\6\12\uffff\1\60\17\uffff\1\6\2\uffff\1\6\1\uffff\16\6\1\57\1\6\4\uffff\7\6\1\uffff\4\6\10\uffff\1\6",
            "\1\42",
            "\1\uffff"
    };

    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = dfa_40;
            this.eof = dfa_41;
            this.min = dfa_42;
            this.max = dfa_43;
            this.accept = dfa_44;
            this.special = dfa_45;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "5010:3: ( ( (otherlv_4= '|' )? ( ( (lv_parameters_5_0= ruleParameterDeclaration ) ) (otherlv_6= ',' ( (lv_parameters_7_0= ruleParameterDeclaration ) ) )* (otherlv_8= ',' ( (lv_varArgs_9_0= '...' ) ) ( (lv_parameters_10_0= ruleParameterDeclaration ) ) )? ) ) | ( ( (lv_varArgs_11_0= '...' ) ) ( (lv_parameters_12_0= ruleParameterDeclaration ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_19 = input.LA(1);

                         
                        int index90_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_57 = input.LA(1);

                         
                        int index90_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_57);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_53 = input.LA(1);

                         
                        int index90_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_53);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_25 = input.LA(1);

                         
                        int index90_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_PsiInternalBeeLangTestLanguage()) ) {s = 2;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index90_25);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 90, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_47s = "\27\uffff";
    static final String dfa_48s = "\1\5\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String dfa_49s = "\1\114\2\uffff\2\0\1\uffff\20\0\1\uffff";
    static final String dfa_50s = "\1\uffff\1\1\24\uffff\1\2";
    static final String dfa_51s = "\3\uffff\1\0\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\uffff}>";
    static final String[] dfa_52s = {
            "\1\4\1\uffff\1\10\5\uffff\1\17\3\uffff\1\11\1\14\2\uffff\1\13\13\uffff\1\1\1\uffff\1\3\21\uffff\2\1\1\uffff\1\6\3\uffff\1\23\3\uffff\1\22\1\24\1\25\3\uffff\1\21\1\uffff\1\12\1\15\1\16\1\20\1\7",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final short[][] dfa_52 = unpackEncodedStringArray(dfa_52s);

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_47;
            this.eof = dfa_47;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_50;
            this.special = dfa_51;
            this.transition = dfa_52;
        }
        public String getDescription() {
            return "5175:2: (this_BlockExpressionWithoutBrackets_0= ruleBlockExpressionWithoutBrackets | this_Expression_1= ruleExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA91_3 = input.LA(1);

                         
                        int index91_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA91_4 = input.LA(1);

                         
                        int index91_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA91_6 = input.LA(1);

                         
                        int index91_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA91_7 = input.LA(1);

                         
                        int index91_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA91_8 = input.LA(1);

                         
                        int index91_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA91_9 = input.LA(1);

                         
                        int index91_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA91_10 = input.LA(1);

                         
                        int index91_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA91_11 = input.LA(1);

                         
                        int index91_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA91_12 = input.LA(1);

                         
                        int index91_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA91_13 = input.LA(1);

                         
                        int index91_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA91_14 = input.LA(1);

                         
                        int index91_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA91_15 = input.LA(1);

                         
                        int index91_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_15);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA91_16 = input.LA(1);

                         
                        int index91_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_16);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA91_17 = input.LA(1);

                         
                        int index91_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_17);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA91_18 = input.LA(1);

                         
                        int index91_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_18);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA91_19 = input.LA(1);

                         
                        int index91_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_19);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA91_20 = input.LA(1);

                         
                        int index91_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_20);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA91_21 = input.LA(1);

                         
                        int index91_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred137_PsiInternalBeeLangTestLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index91_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 91, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000600000032L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000002C020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000602E40030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000001000000A0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000C004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x11000008002620A0L,0x0000000000001F47L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000E004000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000000E6004000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x11100018002620A0L,0x0000000000003F47L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000600000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00000008040A0000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000003800000020L,0x0000000000002000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000002000010000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000020L,0x0000000000002000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000040A0000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00000FC000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000800000020L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0008000000010000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000003000000020L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x001FF00000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x6000000100000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00000008002620A0L,0x0000000000001F40L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000006L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x11100038002620A0L,0x0000000000003F47L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x00000000000A0020L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x00000000000B0000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x1160000A002620A0L,0x0000000000001F47L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x1160000A022620A0L,0x0000000000001F47L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000810020002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000010020002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0010001800000020L,0x0000000000002000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000001800000020L,0x0000000000002000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000010000L,0x0000000000002000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x1160000A002620A2L,0x0000000000001F47L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000162L,0x0000000000000008L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000800002L});

}
